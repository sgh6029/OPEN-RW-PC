package com.corrodinggames.rts.ai.openai;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OpenAI 玩家控制器 — 线程安全版
 * 
 * 架构：
 *   API线程：发请求、收响应、解析文本 → 只把 PendingCommand 放进队列
 *   游戏主线程：tick() 里 drain 队列，在主循环锁内执行命令
 *   绝不允许异步线程直接操作游戏集合
 */
public class OpenAIPlayerController {
    
    private static OpenAIPlayerController instance;
    
    // ========== 状态机 ==========
    private enum State { IDLE, WAITING_RESPONSE, EXECUTED, COOLDOWN }
    private volatile State state = State.IDLE;
    private volatile long stateTimestamp = 0;
    private static final long COOLDOWN_MS = 5000;
    private static final long MAX_RESPONSE_WAIT_MS = 120000;
    private static final long INITIAL_DELAY_MS = 15000; // 等 15 秒让原版 AI 先造单位
    private long initTimestamp = 0;
    
    // ========== 线程安全命令队列 ==========
    /**
     * API 线程解析完文本后，只把待执行的命令放进这个队列。
     * 游戏主线程在 tick() 中 drain 并执行。
     */
    private final ConcurrentLinkedQueue<PendingCommand> commandQueue = new ConcurrentLinkedQueue<>();
    
    /**
     * 当前存活的单位 ID 快照（由主线程序列化时更新，API 线程只读）。
     * key = teamId, value = 该队伍存活的单位 bs 集合
     */
    private volatile Set<Integer> validUnitIds = Collections.synchronizedSet(new HashSet<>());
    
    // ========== 状态 ==========
    private boolean initialized = false;
    private boolean fallbackMode = false;
    private int requestCount = 0;
    private int errorCount = 0;
    
    // ========== 异步线程池 ==========
    private final ExecutorService apiExecutor = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "OpenAI-API-Thread");
        t.setDaemon(true);
        return t;
    });
    
    // ========== 知识库 ==========
    private String knowledgeBase = "";
    
    // ================================================================
    // PendingCommand — API 线程 → 主线程 的通信载体
    // ================================================================
    static class PendingCommand {
        enum Type { MOVE, ATTACK, SIEGE, NUKE, THINK, BUILD }
        
        final Type type;
        final int teamId;
        final float x, y;
        final String unitType;
        final int count;
        final String message; // THINK 用
        
        PendingCommand(Type type, int teamId, float x, float y, String unitType, int count, String message) {
            this.type = type;
            this.teamId = teamId;
            this.x = x;
            this.y = y;
            this.unitType = unitType;
            this.count = count;
            this.message = message;
        }
    }
    
    // ================================================================
    // 单例
    // ================================================================
    private OpenAIPlayerController() {
        System.out.println("[OpenAI] OpenAIPlayerController created (thread-safe)");
    }
    
    public static synchronized OpenAIPlayerController getInstance() {
        if (instance == null) {
            instance = new OpenAIPlayerController();
        }
        return instance;
    }
    
    // ================================================================
    // tick() — 由游戏主线程每帧调用
    // ================================================================
    public void tick(float delta) {
        if (!initialized) {
            initialize();
        }
        
        // ★ 核心：主线程 drain 命令队列并执行（线程安全）
        drainAndExecuteCommands();
        
        if (fallbackMode) {
            return;
        }
        
        long now = System.currentTimeMillis();
        
        switch (state) {
            case IDLE:
                // 初始延迟：等 15 秒让原版 AI 先造单位
                if (System.currentTimeMillis() - initTimestamp < INITIAL_DELAY_MS) {
                    break;
                }
                state = State.WAITING_RESPONSE;
                stateTimestamp = now;
                performAITick();
                break;
                
            case WAITING_RESPONSE:
                if (now - stateTimestamp > MAX_RESPONSE_WAIT_MS) {
                    System.out.println("[OpenAI] Response timeout after 120s");
                    state = State.COOLDOWN;
                    stateTimestamp = now;
                }
                break;
                
            case EXECUTED:
                state = State.COOLDOWN;
                stateTimestamp = now;
                break;
                
            case COOLDOWN:
                if (now - stateTimestamp >= COOLDOWN_MS) {
                    state = State.IDLE;
                }
                break;
        }
    }
    
    // ================================================================
    // drainAndExecuteCommands — 主线程执行，操作游戏集合
    // ================================================================
    private void drainAndExecuteCommands() {
        PendingCommand cmd;
        int executed = 0;
        while ((cmd = commandQueue.poll()) != null) {
            try {
                executeSingleCommand(cmd);
                executed++;
            } catch (Exception e) {
                System.out.println("[OpenAI] Error executing command: " + e.toString());
            }
        }
        if (executed > 0) {
            System.out.println("[OpenAI] Main thread executed " + executed + " commands from queue");
        }
    }
    
    /**
     * 在主线程中执行单个命令（安全操作游戏集合）
     */
    private void executeSingleCommand(PendingCommand cmd) {
        GameEngine engine = GameEngine.getInstance();
        if (engine == null || engine.cf == null) return;
        
        // 找到队伍
        PlayerTeam team = null;
        PlayerTeam[] teams = PlayerTeam.d();
        if (teams == null) return;
        for (PlayerTeam t : teams) {
            if (t != null && t.k == cmd.teamId) { team = t; break; }
        }
        if (team == null) return;
        
        switch (cmd.type) {
            case THINK:
                // THINK 已在 API 线程发到聊天栏，这里不重复
                break;
                
            case BUILD: {
                String typeName = cmd.unitType != null ? cmd.unitType : "";
                int count = cmd.count;
                com.corrodinggames.rts.game.units.UnitType buildType = resolveUnitType(typeName);
                if (buildType == null) {
                    System.out.println("[OpenAI] BUILD: unknown type '" + typeName + "', skipping");
                    break;
                }
                boolean isBuilding = buildType.j();
                if (isBuilding) {
                    List<BaseUnit> builders = findUnitsByTypeSafe(cmd.teamId, "builder");
                    builders.addAll(findUnitsByTypeSafe(cmd.teamId, "engineer"));
                    System.out.println("[OpenAI] BUILD building '" + typeName + "' x" + count + ", found " + builders.size() + " builders");
                    for (int i = 0; i < Math.min(builders.size(), count); i++) {
                        BaseUnit builder = builders.get(i);
                        if (!validateUnit(builder, cmd.teamId)) continue;
                        float bx = builder.posX + (i % 4) * 80 - 120;
                        float by = builder.posY + (i / 4) * 80;
                        com.corrodinggames.rts.gameFramework.GameCommand gc = engine.cf.a(team);
                        gc.a(builder);
                        gc.a(bx, by, buildType, 1);
                        System.out.println("[OpenAI] Builder " + builder.bs + " building " + typeName + " at (" + (int)bx + "," + (int)by + ")");
                    }
                    GameEngine.f("AI", "Building " + count + "x " + typeName);
                } else {
                    String factoryType = getFactoryForUnit(typeName);
                    List<BaseUnit> factories = findUnitsByTypeSafe(cmd.teamId, factoryType);
                    System.out.println("[OpenAI] BUILD unit '" + typeName + "' x" + count + ", found " + factories.size() + " " + factoryType + "s");
                    for (int i = 0; i < Math.min(factories.size(), count); i++) {
                        BaseUnit factory = factories.get(i);
                        if (!validateUnit(factory, cmd.teamId)) continue;
                        com.corrodinggames.rts.gameFramework.GameCommand gc = engine.cf.a(team);
                        gc.a(factory);
                        gc.a(factory.posX, factory.posY, buildType, 1);
                        System.out.println("[OpenAI] Factory " + factory.bs + " producing " + typeName);
                    }
                    GameEngine.f("AI", "Producing " + count + "x " + typeName);
                }
                break;
            }
                
            case MOVE: {
                List<BaseUnit> units = findUnitsByTypeSafe(cmd.teamId, cmd.unitType);
                for (int i = 0; i < Math.min(units.size(), cmd.count); i++) {
                    BaseUnit u = units.get(i);
                    if (!validateUnit(u, cmd.teamId)) continue;
                    com.corrodinggames.rts.gameFramework.GameCommand gc = engine.cf.a(team);
                    gc.a(u);
                    gc.b(cmd.x + i * 20, cmd.y + i * 20);
                    System.out.println("[OpenAI] MOVE unit " + u.bs + " → (" + (int)cmd.x + "," + (int)cmd.y + ")");
                }
                break;
            }
            
            case ATTACK: {
                List<BaseUnit> units = findUnitsByTypeSafe(cmd.teamId, cmd.unitType);
                for (int i = 0; i < Math.min(units.size(), cmd.count); i++) {
                    BaseUnit u = units.get(i);
                    if (!validateUnit(u, cmd.teamId)) continue;
                    com.corrodinggames.rts.gameFramework.GameCommand gc = engine.cf.a(team);
                    gc.a(u);
                    gc.b(cmd.x + i * 30, cmd.y + i * 30);
                    System.out.println("[OpenAI] ATTACK unit " + u.bs + " → (" + (int)cmd.x + "," + (int)cmd.y + ")");
                }
                break;
            }
            
            case SIEGE: {
                // 坦克向前
                List<BaseUnit> tanks = findUnitsByTypeSafe(cmd.teamId, "tank");
                for (int i = 0; i < Math.min(tanks.size(), cmd.count); i++) {
                    BaseUnit u = tanks.get(i);
                    if (!validateUnit(u, cmd.teamId)) continue;
                    com.corrodinggames.rts.gameFramework.GameCommand gc = engine.cf.a(team);
                    gc.a(u);
                    gc.b(cmd.x + i * 25, cmd.y + i * 25);
                }
                // 建造者在后方
                List<BaseUnit> builders = findUnitsByTypeSafe(cmd.teamId, "builder");
                int builderCount = Math.max(1, cmd.count / 3);
                for (int i = 0; i < Math.min(builders.size(), builderCount); i++) {
                    BaseUnit u = builders.get(i);
                    if (!validateUnit(u, cmd.teamId)) continue;
                    com.corrodinggames.rts.gameFramework.GameCommand gc = engine.cf.a(team);
                    gc.a(u);
                    gc.b(cmd.x - 50 + i * 30, cmd.y + 50);
                }
                GameEngine.f("AI", "SIEGE at (" + (int)cmd.x + "," + (int)cmd.y + ")");
                System.out.println("[OpenAI] SIEGE executed");
                break;
            }
            
            case NUKE: {
                // 查找核弹发射井
                List<BaseUnit> nukeSilos = findUnitsByTypeSafe(cmd.teamId, "NukeLaucher");
                nukeSilos.addAll(findUnitsByTypeSafe(cmd.teamId, "nuke_launcher"));
                nukeSilos.addAll(findUnitsByTypeSafe(cmd.teamId, "nuke"));
                
                if (!nukeSilos.isEmpty()) {
                    // 有核弹井，发射核弹
                    int launched = 0;
                    for (BaseUnit silo : nukeSilos) {
                        if (!validateUnit(silo, cmd.teamId)) continue;
                        com.corrodinggames.rts.gameFramework.GameCommand gc = engine.cf.a(team);
                        gc.a(silo);
                        gc.b(cmd.x, cmd.y);  // 发射到目标坐标
                        launched++;
                    }
                    GameEngine.f("AI", "NUCLEAR LAUNCH at (" + (int)cmd.x + "," + (int)cmd.y + ")!");
                    System.out.println("[OpenAI] NUKE launched from " + launched + " silo(s)");
                } else {
                    // 没有核弹井，先建造一个
                    System.out.println("[OpenAI] No nuke silo found, building one first");
                    List<BaseUnit> builders = findUnitsByTypeSafe(cmd.teamId, "builder");
                    builders.addAll(findUnitsByTypeSafe(cmd.teamId, "engineer"));
                    if (!builders.isEmpty()) {
                        BaseUnit builder = builders.get(0);
                        if (validateUnit(builder, cmd.teamId)) {
                            com.corrodinggames.rts.game.units.UnitType nukeType = resolveUnitType("NukeLaucher");
                            if (nukeType != null) {
                                float bx = builder.posX + 150;
                                float by = builder.posY + 100;
                                com.corrodinggames.rts.gameFramework.GameCommand gc = engine.cf.a(team);
                                gc.a(builder);
                                gc.a(bx, by, nukeType, 1);
                                System.out.println("[OpenAI] Builder " + builder.bs + " building NukeLaucher at (" + (int)bx + "," + (int)by + ")");
                                GameEngine.f("AI", "Building NukeLauncher...");
                            }
                        }
                    }
                    // 同时所有战斗单位攻击目标
                    List<BaseUnit> fighters = findUnitsByTypeSafe(cmd.teamId, "tank");
                    fighters.addAll(findUnitsByTypeSafe(cmd.teamId, "heavyTank"));
                    fighters.addAll(findUnitsByTypeSafe(cmd.teamId, "mech"));
                    int attackCount = 0;
                    for (BaseUnit u : fighters) {
                        if (!validateUnit(u, cmd.teamId)) continue;
                        com.corrodinggames.rts.gameFramework.GameCommand gc = engine.cf.a(team);
                        gc.a(u);
                        gc.b(cmd.x, cmd.y);
                        attackCount++;
                    }
                    if (attackCount > 0) {
                        GameEngine.f("AI", "Building nuke silo... meanwhile " + attackCount + " units attack (" + (int)cmd.x + "," + (int)cmd.y + ")");
                    }
                }
                break;
            }
        }
    }
    
    // ================================================================
    // validateUnit — 单位 ID 对账（止空气指挥）
    // ================================================================
    /**
     * 校验单位是否真实存在且属于指定队伍
     * @return true = 合法，可以下发命令
     */
    private boolean validateUnit(BaseUnit unit, int teamId) {
        if (unit == null) {
            System.out.println("[OpenAI] DISCARD: unit is null");
            return false;
        }
        if (unit.bs == -9999) {
            System.out.println("[OpenAI] DISCARD: unit.bs == -9999 (default/uninitialized)");
            return false;
        }
        if (unit.u()) { // isDead
            System.out.println("[OpenAI] DISCARD: unit " + unit.bs + " is dead");
            return false;
        }
        if (unit.bX == null || unit.bX.k != teamId) {
            System.out.println("[OpenAI] DISCARD: unit " + unit.bs + " doesn't belong to team " + teamId);
            return false;
        }
        // 最终校验：ID 必须在有效集合中
        if (!validUnitIds.contains(unit.bs)) {
            System.out.println("[OpenAI] DISCARD: unit " + unit.bs + " not in valid IDs snapshot");
            return false;
        }
        return true;
    }
    
    // ================================================================
    // initialize
    // ================================================================
    private void initialize() {
        initialized = true;
        initTimestamp = System.currentTimeMillis();
        System.out.println("[OpenAI] Initializing controller...");
        
        OpenAIClient client = OpenAIClient.getInstance();
        System.out.println("[OpenAI] Config: endpoint=" + client.getBaseUrl() 
            + ", apiKey=" + (client.getApiKey() != null && !client.getApiKey().isEmpty() ? "[" + client.getApiKey().length() + "chars]" : "[empty]")
            + ", model=" + client.getModel());
        
        if (!client.isConfigured()) {
            System.out.println("[OpenAI] API not configured, entering fallback mode");
            fallbackMode = true;
            return;
        }
        
        loadKnowledgeBase();
        boostEconomy();
        
        System.out.println("[OpenAI] Controller initialized successfully");
    }
    
    private void boostEconomy() {
        GameEngine engine = GameEngine.getInstance();
        if (engine == null || engine.bQ == null) return;
        
        float multiplier = engine.bQ.openAIIncomeMultiplier;
        if (multiplier < 1.0f) multiplier = 10.0f;
        
        PlayerTeam[] teams = PlayerTeam.d();
        if (teams == null) return;
        
        for (PlayerTeam team : teams) {
            if (team == null || !team.w || team.b()) continue;
            if (team.C() == OpenAIConfig.OPENAI) {
                double oldMoney = team.o;
                team.o = oldMoney * multiplier;
                System.out.println("[OpenAI] Boosted team " + team.k + " money: " + (int)oldMoney + " → " + (int)team.o);
                GameEngine.f("AI", "10x ECONOMY: " + (int)team.o + " credits!");
            }
        }
    }
    
    private void loadKnowledgeBase() {
        StringBuilder kb = new StringBuilder();
        kb.append("You are the supreme AI commander in Rusted Warfare.\n");
        kb.append("Your goal: defeat the enemy with maximum efficiency.\n\n");
        kb.append("【ECONOMY】\n");
        kb.append("- Priority: capture resource points with 4+ builders\n");
        kb.append("- Extractors have best ROI, max them first\n");
        kb.append("- Opening: Air Factory → Heli → Reclaim → Land Factory → T2 → Mine T2\n\n");
        kb.append("【COUNTERS】\n");
        kb.append("- Light tanks fear AOE/air; Heavy tanks (T2) anti-ground+air\n");
        kb.append("- Machine Gun Mech (T2 Mech Factory) mid-game core\n");
        kb.append("- Experimental Spider: strongest unit, crosses water/cliffs, nukes on death\n");
        kb.append("- Artillery turrets: AOE counters tank groups\n");
        kb.append("- Electric units (Lightning Tower/Tesla/Mammoth) counter amphibious jets\n\n");
        kb.append("【SIEGE TACTICS】\n");
        kb.append("- Attack with builders/combat engineers alongside tanks\n");
        kb.append("- Build laser defense turrets + repair stations near enemy\n");
        kb.append("- Combat units hide behind turrets while dealing damage\n");
        kb.append("- Build T2 artillery + T3 machine guns behind turrets for massive damage\n\n");
        kb.append("【NUKE STRATEGY】\n");
        kb.append("- Build NukeLaucher, then produce nukes\n");
        kb.append("- Priority: enemy base > factories > dense units > resources\n\n");
        kb.append("【10x ECONOMY】\n");
        kb.append("- Your money and income are 10x normal AI\n");
        kb.append("- Mass produce units and defenses aggressively\n");
        
        knowledgeBase = kb.toString();
        System.out.println("[OpenAI] Knowledge base loaded: " + knowledgeBase.length() + " chars");
    }
    
    // ================================================================
    // performAITick — 在 API 线程执行，只做网络 IO + 文本解析
    // 解析结果放入 commandQueue，不操作任何游戏集合
    // ================================================================
    private void performAITick() {
        GameEngine engine = GameEngine.getInstance();
        if (engine == null) {
            state = State.IDLE;
            return;
        }
        
        List<PlayerTeam> openAITeams = findOpenAITeams();
        if (openAITeams.isEmpty()) {
            state = State.IDLE;
            return;
        }
        
        System.out.println("[OpenAI] performAITick: " + openAITeams.size() + " team(s), request #" + (requestCount + 1));
        
        for (PlayerTeam team : openAITeams) {
            // ★ 主线程：序列化快照 + 更新 validUnitIds
            GameStateSerializer serializer = new GameStateSerializer();
            final String gameState = serializer.serialize(team.k);
            final String systemPrompt = buildSystemPrompt(team);
            final int teamId = team.k;
            
            // ★ 更新有效单位 ID 快照（主线程安全）
            updateValidUnitIds(teamId);
            
            apiExecutor.submit(() -> {
                try {
                    System.out.println("[OpenAI] Sending request, state=" + gameState.length() + " chars");
                    String response = OpenAIClient.getInstance().chat(systemPrompt, gameState);
                    
                    if (response == null || response.isEmpty()) {
                        System.out.println("[OpenAI] Empty response");
                        errorCount++;
                        if (errorCount > 5) {
                            System.out.println("[OpenAI] Too many errors, fallback");
                            fallbackMode = true;
                        }
                        state = State.EXECUTED;
                        return;
                    }
                    
                    requestCount++;
                    errorCount = 0;
                    
                    System.out.println("[OpenAI] Response #" + requestCount + " (" + response.length() + " chars)");
                    System.out.println("[OpenAI] AI: " + response.substring(0, Math.min(300, response.length())) + "...");
                    
                    // ★ API 线程：只解析文本，把 PendingCommand 放入队列
                    // ★ 绝不在此处操作游戏集合
                    parseResponseToQueue(teamId, response);
                    
                } catch (Exception e) {
                    System.out.println("[OpenAI] API error: " + e.toString());
                    e.printStackTrace();
                    errorCount++;
                } finally {
                    state = State.EXECUTED;
                }
            });
        }
    }
    
    // ================================================================
    // updateValidUnitIds — 主线程调用，更新有效单位 ID 快照
    // ================================================================
    private void updateValidUnitIds(int teamId) {
        Set<Integer> ids = new HashSet<>();
        int totalUnits = 0;
        java.util.Map<Integer, Integer> unitsPerTeam = new java.util.HashMap<>();
        
        try {
            if (BaseUnit.bE != null) {
                int size = BaseUnit.bE.size();
                totalUnits = size;
                
                for (int i = 0; i < size; i++) {
                    Object obj = BaseUnit.bE.get(i);
                    if (obj instanceof BaseUnit) {
                        BaseUnit u = (BaseUnit) obj;
                        if (!u.u() && u.bX != null && u.bs != -9999) {
                            // 统计每个队伍的单位数
                            int tId = u.bX.k;
                            unitsPerTeam.merge(tId, 1, Integer::sum);
                            
                            if (tId == teamId) {
                                ids.add(u.bs);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("[OpenAI] Error building validUnitIds: " + e.toString());
        }
        
        validUnitIds = Collections.synchronizedSet(ids);
        
        // 详细诊断日志
        System.out.println("[OpenAI] === Unit Diagnostic ===");
        System.out.println("[OpenAI] Total units in game: " + totalUnits);
        System.out.println("[OpenAI] Units per team: " + unitsPerTeam);
        System.out.println("[OpenAI] Team " + teamId + " has " + ids.size() + " units");
        
        // 检查原版 AIController 状态
        PlayerTeam[] teams = PlayerTeam.d();
        if (teams != null) {
            for (PlayerTeam t : teams) {
                if (t != null && t.k == teamId) {
                    System.out.println("[OpenAI] Team " + teamId + " isAI=" + t.w + " eliminated=" + t.b());
                    if (t instanceof com.corrodinggames.rts.game.a.AIController) {
                        com.corrodinggames.rts.game.a.AIController aic = (com.corrodinggames.rts.game.a.AIController) t;
                        System.out.println("[OpenAI] AIController aZ=" + aic.aZ + " aX=" + aic.aX);
                    }
                    break;
                }
            }
        }
        System.out.println("[OpenAI] ========================");
    }
    
    // ================================================================
    // parseResponseToQueue — API 线程调用，只做文本解析
    // 结果放入 commandQueue，不操作任何游戏集合
    // ================================================================
    private void parseResponseToQueue(int teamId, String response) {
        String[] lines = response.split("\\n");
        int parsed = 0;
        
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;
            
            String upper = line.toUpperCase();
            
            if (upper.startsWith("THINK:")) {
                String thought = line.substring(6).trim();
                commandQueue.add(new PendingCommand(PendingCommand.Type.THINK, teamId, 0, 0, null, 0, thought));
                System.out.println("[OpenAI] Parsed THINK: " + thought.substring(0, Math.min(100, thought.length())));
                parsed++;
            }
            else if (upper.startsWith("MOVE:")) {
                String[] p = line.substring(5).trim().split("\\s+");
                if (p.length >= 4) {
                    try {
                        float x, y;
                        String type;
                        int count;
                        // 检测格式：第一个是数字 = "x y type count"，否则 = "type count x y"
                        try {
                            Float.parseFloat(p[0]);
                            // Format A: x y type count
                            x = Float.parseFloat(p[0]);
                            y = Float.parseFloat(p[1]);
                            type = p[2].toLowerCase();
                            count = Integer.parseInt(p[3]);
                        } catch (NumberFormatException nfe) {
                            // Format B: type count x y
                            type = p[0].toLowerCase();
                            count = Integer.parseInt(p[1]);
                            x = Float.parseFloat(p[2]);
                            y = Float.parseFloat(p[3]);
                        }
                        commandQueue.add(new PendingCommand(PendingCommand.Type.MOVE, teamId, x, y, type, count, null));
                        parsed++;
                    } catch (Exception e) {
                        System.out.println("[OpenAI] Bad MOVE format: " + line);
                    }
                }
            }
            else if (upper.startsWith("ATTACK:")) {
                String[] p = line.substring(7).trim().split("\\s+");
                if (p.length >= 4) {
                    try {
                        float x, y;
                        String type;
                        int count;
                        try {
                            Float.parseFloat(p[0]);
                            x = Float.parseFloat(p[0]);
                            y = Float.parseFloat(p[1]);
                            type = p[2].toLowerCase();
                            count = Integer.parseInt(p[3]);
                        } catch (NumberFormatException nfe) {
                            type = p[0].toLowerCase();
                            count = Integer.parseInt(p[1]);
                            x = Float.parseFloat(p[2]);
                            y = Float.parseFloat(p[3]);
                        }
                        commandQueue.add(new PendingCommand(PendingCommand.Type.ATTACK, teamId, x, y, type, count, null));
                        parsed++;
                    } catch (Exception e) {
                        System.out.println("[OpenAI] Bad ATTACK format: " + line);
                    }
                }
            }
            else if (upper.startsWith("SIEGE:")) {
                String[] p = line.substring(6).trim().split("\\s+");
                if (p.length >= 4) {
                    try {
                        commandQueue.add(new PendingCommand(PendingCommand.Type.SIEGE, teamId,
                            Float.parseFloat(p[0]), Float.parseFloat(p[1]), null, Integer.parseInt(p[2]), null));
                        parsed++;
                    } catch (NumberFormatException e) {
                        System.out.println("[OpenAI] Bad SIEGE format: " + line);
                    }
                }
            }
            else if (upper.startsWith("NUKE:")) {
                String[] p = line.substring(5).trim().split("\\s+");
                if (p.length >= 2) {
                    try {
                        commandQueue.add(new PendingCommand(PendingCommand.Type.NUKE, teamId,
                            Float.parseFloat(p[0]), Float.parseFloat(p[1]), null, 0, null));
                        parsed++;
                    } catch (NumberFormatException e) {
                        System.out.println("[OpenAI] Bad NUKE format: " + line);
                    }
                }
            }
            else if (upper.startsWith("BUILD:")) {
                String[] p = line.substring(6).trim().split("\\s+");
                if (p.length >= 2) {
                    try {
                        // BUILD: type count — 创建 BUILD 命令
                        String buildTypeName = p[0].toLowerCase();
                        int count = Integer.parseInt(p[1]);
                        commandQueue.add(new PendingCommand(PendingCommand.Type.BUILD, teamId,
                            0, 0, buildTypeName, count, null));
                        parsed++;
                    } catch (NumberFormatException e) {
                        System.out.println("[OpenAI] Bad BUILD format: " + line);
                    }
                }
            }
            else if (upper.startsWith("DEFEND:")) {
                String[] p = line.substring(7).trim().split("\\s+");
                if (p.length >= 4) {
                    try {
                        commandQueue.add(new PendingCommand(PendingCommand.Type.MOVE, teamId,
                            Float.parseFloat(p[0]), Float.parseFloat(p[1]), p[2].toLowerCase(), Integer.parseInt(p[3]), null));
                        parsed++;
                    } catch (NumberFormatException e) {
                        System.out.println("[OpenAI] Bad DEFEND format: " + line);
                    }
                }
            }
        }
        
        System.out.println("[OpenAI] Parsed " + parsed + " commands into queue for team " + teamId);
    }
    
    // ================================================================
    // findOpenAITeams
    // ================================================================
    private List<PlayerTeam> findOpenAITeams() {
        List<PlayerTeam> result = new ArrayList<>();
        PlayerTeam[] teams = PlayerTeam.d();
        if (teams == null) return result;
        for (PlayerTeam team : teams) {
            if (team == null || !team.w || team.b()) continue;
            if (team.C() == OpenAIConfig.OPENAI) {
                result.add(team);
            }
        }
        return result;
    }
    
    // ================================================================
    // buildSystemPrompt
    // ================================================================
    private String buildSystemPrompt(PlayerTeam team) {
        StringBuilder prompt = new StringBuilder();
        prompt.append(knowledgeBase);
        prompt.append("\n\nYou are team ").append(team.k).append("'s AI commander.\n");
        prompt.append("Reply in English ONLY. One command per line:\n");
        prompt.append("THINK: [1-2 sentence strategic analysis]\n");
        prompt.append("BUILD: [unit_type] [count]\n");
        prompt.append("MOVE: [x] [y] [unit_type] [count]\n");
        prompt.append("ATTACK: [x] [y] [unit_type] [count]\n");
        prompt.append("SIEGE: [x] [y] [tank_count] [builder_count]\n");
        prompt.append("DEFEND: [x] [y] [unit_type] [count]\n");
        prompt.append("NUKE: [x] [y]\n");
        prompt.append("Commands: THINK, BUILD, MOVE, ATTACK, SIEGE, DEFEND, NUKE\n");
        prompt.append("You have 10x economy. Be aggressive.");
        return prompt.toString();
    }
    
    // ================================================================
    // findUnitsByTypeSafe — 主线程调用，按类型查找单位
    // ================================================================
    private List<BaseUnit> findUnitsByTypeSafe(int teamId, String typeName) {
        List<BaseUnit> result = new ArrayList<>();
        List<BaseUnit> allUnits = getAllUnitsSafe();
        for (BaseUnit unit : allUnits) {
            if (unit == null || unit.bX == null || unit.bX.k != teamId) continue;
            if (!validUnitIds.contains(unit.bs)) continue;
            String actualType = getUnitTypeName(unit);
            if (actualType.contains(typeName) || typeName.contains(actualType)) {
                result.add(unit);
            }
        }
        if (result.isEmpty()) {
            for (BaseUnit unit : allUnits) {
                if (unit == null || unit.bX == null || unit.bX.k != teamId) continue;
                if (!validUnitIds.contains(unit.bs)) continue;
                result.add(unit);
            }
        }
        return result;
    }
    
    // ================================================================
    // getAllUnitsSafe — 主线程调用
    // ================================================================
    private List<BaseUnit> getAllUnitsSafe() {
        List<BaseUnit> result = new ArrayList<>();
        try {
            if (BaseUnit.bE != null) {
                int size = BaseUnit.bE.size();
                for (int i = 0; i < size; i++) {
                    Object obj = BaseUnit.bE.get(i);
                    if (obj instanceof BaseUnit) {
                        BaseUnit u = (BaseUnit) obj;
                        if (!u.u() && u.bs != -9999) {
                            result.add(u);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("[OpenAI] getAllUnitsSafe error: " + e.toString());
        }
        return result;
    }
    
    private String getUnitTypeName(BaseUnit unit) {
        try {
            if (unit.dz != null) {
                return unit.dz.getClass().getSimpleName().toLowerCase();
            }
        } catch (Exception ignored) {}
        return "unit_" + unit.bs;
    }
    
    // ================================================================
    // BUILD 辅助方法
    // ================================================================
    
    /**
     * 将 AI 输出的字符串类型名解析为游戏 UnitType
     */
    private static final java.util.Map<String, String> UNIT_TYPE_ALIASES = new java.util.HashMap<>();
    static {
        // 建筑
        UNIT_TYPE_ALIASES.put("extractor", "extractor");
        UNIT_TYPE_ALIASES.put("land_factory", "landFactory");
        UNIT_TYPE_ALIASES.put("air_factory", "airFactory");
        UNIT_TYPE_ALIASES.put("sea_factory", "seaFactory");
        UNIT_TYPE_ALIASES.put("laser_defence", "laserDefence");
        UNIT_TYPE_ALIASES.put("laser_turret", "laserDefence");
        UNIT_TYPE_ALIASES.put("repair_bay", "repairbay");
        UNIT_TYPE_ALIASES.put("repair_station", "repairbay");
        UNIT_TYPE_ALIASES.put("nuke_launcher", "NukeLaucher");
        UNIT_TYPE_ALIASES.put("nuke_silo", "NukeLaucher");
        UNIT_TYPE_ALIASES.put("anti_nuke", "AntiNukeLaucher");
        UNIT_TYPE_ALIASES.put("turret", "turret");
        UNIT_TYPE_ALIASES.put("gun_turret", "turret");
        UNIT_TYPE_ALIASES.put("fabricator", "fabricator");
        // 单位
        UNIT_TYPE_ALIASES.put("heavy_tank", "heavyTank");
        UNIT_TYPE_ALIASES.put("tank", "heavyTank");
        UNIT_TYPE_ALIASES.put("hover_tank", "hoverTank");
        UNIT_TYPE_ALIASES.put("heavy_hover_tank", "heavyHoverTank");
        UNIT_TYPE_ALIASES.put("laser_tank", "laserTank");
        UNIT_TYPE_ALIASES.put("mega_tank", "megaTank");
        UNIT_TYPE_ALIASES.put("tank_destroyer", "tankDestroyer");
        UNIT_TYPE_ALIASES.put("artillery", "artillery");
        UNIT_TYPE_ALIASES.put("helicopter", "helicopter");
        UNIT_TYPE_ALIASES.put("heli", "helicopter");
        UNIT_TYPE_ALIASES.put("gunship", "gunShip");
        UNIT_TYPE_ALIASES.put("gun_ship", "gunShip");
        UNIT_TYPE_ALIASES.put("airship", "airShip");
        UNIT_TYPE_ALIASES.put("air_ship", "airShip");
        UNIT_TYPE_ALIASES.put("dropship", "dropship");
        UNIT_TYPE_ALIASES.put("missile_ship", "missileShip");
        UNIT_TYPE_ALIASES.put("battle_ship", "battleShip");
        UNIT_TYPE_ALIASES.put("gunboat", "gunBoat");
        UNIT_TYPE_ALIASES.put("hovercraft", "hovercraft");
        UNIT_TYPE_ALIASES.put("builder", "builder");
        UNIT_TYPE_ALIASES.put("engineer", "engineer");
        // NukeLaucher 直接匹配
        UNIT_TYPE_ALIASES.put("NukeLaucher", "NukeLaucher");
        UNIT_TYPE_ALIASES.put("AntiNukeLaucher", "AntiNukeLaucher");
    }
    
    private com.corrodinggames.rts.game.units.UnitType resolveUnitType(String name) {
        if (name == null || name.isEmpty()) return null;
        String lower = name.toLowerCase().replace(" ", "_");
        // 先查别名表
        String resolved = UNIT_TYPE_ALIASES.get(lower);
        if (resolved == null) {
            // 尝试直接匹配枚举名（大小写不敏感）
            resolved = name;
        }
        try {
            return com.corrodinggames.rts.game.units.UnitTypeEnum.a(resolved);
        } catch (Exception e) {
            System.out.println("[OpenAI] resolveUnitType: '" + name + "' → not found");
            return null;
        }
    }
    
    /**
     * 根据单位类型返回对应的工厂类型
     */
    private String getFactoryForUnit(String typeName) {
        if (typeName == null) return "landFactory";
        String lower = typeName.toLowerCase().replace(" ", "_");
        // 空军单位从空军工厂生产
        if (lower.contains("heli") || lower.contains("gunship") || lower.contains("airship") || lower.contains("dropship")) {
            return "airFactory";
        }
        // 海军单位从海军工厂生产
        if (lower.contains("ship") || lower.contains("boat")) {
            return "seaFactory";
        }
        // 其他单位从陆军工厂生产
        return "landFactory";
    }
    
    // ================================================================
    // 公共方法
    // ================================================================
    public boolean isActive() {
        return initialized && !fallbackMode;
    }
    
    public int getRequestCount() { return requestCount; }
    public int getErrorCount() { return errorCount; }
    
    public void reset() {
        requestCount = 0;
        errorCount = 0;
        fallbackMode = false;
        initialized = false;
        commandQueue.clear();
        state = State.IDLE;
        System.out.println("[OpenAI] Controller reset");
    }
    
    public void recheckConfig() {
        fallbackMode = false;
        initialized = false;
        System.out.println("[OpenAI] Config recheck requested");
    }
}
