package com.corrodinggames.rts.ai.openai;

import com.corrodinggames.rts.game.GameLogic;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.GameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * OpenAI 玩家控制器 — 单例管理所有 OpenAI 难度的 AI 玩家
 * 
 * 核心职责：
 * 1. 每 5 秒收集游戏状态并发送给 OpenAI API
 * 2. 解析 AI 返回的决策指令并执行
 * 3. 如果 API 未配置或失败，静默降级（原 AI 继续运行）
 * 
 * 集成方式：从 GameLogic.processGameLogic() 中调用 tick()
 */
public class OpenAIPlayerController {
    
    private static OpenAIPlayerController instance;
    
    // 计时器
    private float tickAccumulator = 0.0f;
    private static final float TICK_INTERVAL = 5.0f; // 每 5 秒触发一次 API 调用
    
    // 状态
    private boolean initialized = false;
    private boolean apiConfigured = false;
    private boolean fallbackMode = false; // 降级模式：API 不可用时为 true
    private int requestCount = 0;
    private int errorCount = 0;
    
    // 异步线程池（防止 API 调用阻塞游戏主线程）
    private final ExecutorService apiExecutor = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "OpenAI-API-Thread");
        t.setDaemon(true);
        return t;
    });
    private final AtomicBoolean apiBusy = new AtomicBoolean(false);
    
    // 知识库内容（作为 system prompt 的一部分）
    private String knowledgeBase = "";
    
    private OpenAIPlayerController() {
        System.out.println("[OpenAI] OpenAIPlayerController created");
    }
    
    public static synchronized OpenAIPlayerController getInstance() {
        if (instance == null) {
            instance = new OpenAIPlayerController();
        }
        return instance;
    }
    
    /**
     * 每帧由 GameLogic 调用
     * @param delta 帧间隔（秒）
     */
    public void tick(float delta) {
        if (!initialized) {
            initialize();
        }
        
        if (fallbackMode) {
            return; // 降级模式：不做任何事，让原 AI 继续运行
        }
        
        tickAccumulator += delta;
        if (tickAccumulator >= TICK_INTERVAL) {
            tickAccumulator = 0.0f;
            performAITick();
        }
    }
    
    /**
     * 初始化控制器
     */
    private void initialize() {
        initialized = true;
        System.out.println("[OpenAI] Initializing controller...");
        
        // 检查 API 配置（每次都从 SettingsEngine 重新读取）
        OpenAIClient client = OpenAIClient.getInstance();
        System.out.println("[OpenAI] Config check: endpoint=" + client.getBaseUrl() 
            + ", apiKey=" + (client.getApiKey() != null && !client.getApiKey().isEmpty() ? "[已配置," + client.getApiKey().length() + "字符]" : "[空]")
            + ", model=" + client.getModel());
        
        if (client == null || !client.isConfigured()) {
            System.out.println("[OpenAI] WARNING: API not configured, entering fallback mode");
            System.out.println("[OpenAI] To enable OpenAI AI, go to Settings and configure API Endpoint + API Key");
            fallbackMode = true;
            return;
        }
        
        apiConfigured = true;
        System.out.println("[OpenAI] API configured: endpoint=" + client.getBaseUrl() + ", model=" + client.getModel());
        
        // 加载知识库
        loadKnowledgeBase();
        
        // 10倍经济：给 OpenAI 队伍注入初始资金
        boostEconomy();
        
        System.out.println("[OpenAI] Controller initialized successfully");
    }
    
    /**
     * 10倍经济注入：给 OpenAI 队伍 10倍启动资金和收入
     */
    private void boostEconomy() {
        GameEngine engine = GameEngine.getInstance();
        if (engine == null || engine.bQ == null) return;
        
        float multiplier = engine.bQ.openAIIncomeMultiplier;
        if (multiplier < 1.0f) multiplier = 10.0f;
        
        PlayerTeam[] teams = PlayerTeam.d();
        if (teams == null) return;
        
        for (PlayerTeam team : teams) {
            if (team == null) continue;
            if (!team.w) continue; // 不是 AI
            if (team.b()) continue; // 已淘汰
            
            int difficulty = team.C();
            if (difficulty == OpenAIConfig.OPENAI) {
                // 10倍启动资金
                double oldMoney = team.o;
                team.o = oldMoney * multiplier;
                System.out.println("[OpenAI] Boosted team " + team.k + " money: " + (int)oldMoney + " → " + (int)team.o);
                GameEngine.f("AI", "10x ECONOMY BOOST: " + (int)team.o + " credits available!");
            }
        }
    }
    
    /**
     * 加载知识库内容
     */
    private void loadKnowledgeBase() {
        StringBuilder kb = new StringBuilder();
        kb.append("你是铁锈战争(Rusted Warfare)的超级AI指挥官。\n");
        kb.append("你的目标是以最高效率击败对手。\n\n");
        kb.append("【经济运营】\n");
        kb.append("- 开局优先抢资源点，至少4个建造者\n");
        kb.append("- 资源抽取器性价比最高，优先升满\n");
        kb.append("- 开局流程：空军工厂→直升机→回收→陆军工厂→升T2→矿升T2\n");
        kb.append("- 前期只造矿和工厂，不造多余东西\n\n");
        kb.append("【单位克制】\n");
        kb.append("- 小坦(350)怕AOE和空军；重坦(800,T2)能对地对空\n");
        kb.append("- 机枪机甲(T2机械工厂)中期核心\n");
        kb.append("- 实验蜘蛛：全游戏最强，可穿越水域和悬崖，死亡时核爆\n");
        kb.append("- 火炮炮塔：AOE克制坦克群\n");
        kb.append("- 电击单位(闪电塔/特斯拉/猛犸)克制两栖喷气机\n");
        kb.append("- 两栖喷气机可潜水攻击水下单位\n\n");
        kb.append("【战术流派】\n");
        kb.append("- 悬浮坦克流：早期快速抢资源\n");
        kb.append("- 机甲流：机枪机甲+机械师，中期强势\n");
        kb.append("- 空军流：灵活打击\n");
        kb.append("- 核弹流：后期攒核弹摧毁关键目标\n");
        kb.append("- 多线打法：同时进攻多条路线\n\n");
        kb.append("【核弹策略】\n");
        kb.append("- 打击优先级：敌方基地 > 核弹发射井 > 实验蜘蛛 > 密集建筑/单位 > 资源设施\n");
        kb.append("- 敌军聚集时发射可一锤定音\n\n");
        kb.append("【高级技巧】\n");
        kb.append("- 实验蜘蛛+空中堡垒=神风核爆攻击\n");
        kb.append("- 航空母舰死亡核爆，可作移动海上核弹\n");
        kb.append("- 拉残血单位后退，让血多的抗伤害\n");
        kb.append("- 分散站位规避AOE\n");
        kb.append("- 偷家：优先摧毁敌方基地和资源抽取器\n");
        kb.append("\n【攻城战术(SIEGE)】\n");
        kb.append("- 进攻时带建造者/战斗工程师同行\n");
        kb.append("- 在临近敌方时建造激光防御塔+修复站\n");
        kb.append("- 让战斗单位躲在激光防御塔和修复站周围输出\n");
        kb.append("- 在防御塔后面建T2火炮和T3机枪造成大量伤害\n");
        kb.append("- 使用 SIEGE: [x] [y] [tanks] [builders] 命令发起攻城\n");
        kb.append("\n【核弹使用】\n");
        kb.append("- 建造核弹发射井(NukeLaucher)，然后生产核弹\n");
        kb.append("- 核弹打击优先级：敌方基地 > 工厂 > 密集单位群 > 资源设施\n");
        kb.append("- 使用 NUKE: [x] [y] 命令发射核弹\n");
        kb.append("\n【10倍经济】\n");
        kb.append("- 你的资金和收入是正常AI的10倍\n");
        kb.append("- 大胆暴兵，密集建造工厂和防御\n");
        
        knowledgeBase = kb.toString();
        System.out.println("[OpenAI] Knowledge base loaded: " + knowledgeBase.length() + " chars");
    }
    
    /**
     * 执行一次 AI 决策周期
     * API 调用在后台线程执行，不阻塞游戏主线程
     */
    private void performAITick() {
        GameEngine engine = GameEngine.getInstance();
        if (engine == null) {
            System.out.println("[OpenAI] GameEngine is null, skipping tick");
            return;
        }
        
        // 如果上一次 API 调用还没返回，跳过本次
        if (apiBusy.get()) {
            System.out.println("[OpenAI] Previous API call still in progress, skipping this tick");
            return;
        }
        
        // 找到所有 OpenAI 难度的 AI 玩家
        List<PlayerTeam> openAITeams = findOpenAITeams();
        System.out.println("[OpenAI] performAITick: found " + openAITeams.size() + " OpenAI team(s)");
        
        if (openAITeams.isEmpty()) {
            return; // 没有 OpenAI 玩家，跳过
        }
        
        System.out.println("[OpenAI] Performing AI tick for " + openAITeams.size() + " OpenAI team(s), request #" + (requestCount + 1));
        
        // 在后台线程执行 API 调用，不阻塞游戏主线程
        for (PlayerTeam team : openAITeams) {
            // 在主线程提前序列化游戏状态（快照）
            GameStateSerializer serializer = new GameStateSerializer();
            final String gameState = serializer.serialize(team.k);
            final String systemPrompt = buildSystemPrompt(team);
            final int teamId = team.k;
            
            apiBusy.set(true);
            apiExecutor.submit(() -> {
                try {
                    System.out.println("[OpenAI] Sending request to " + OpenAIClient.getInstance().getBaseUrl());
                    System.out.println("[OpenAI] Game state length: " + gameState.length() + " chars");
                    
                    String response = OpenAIClient.getInstance().chat(systemPrompt, gameState);
                    
                    if (response == null || response.isEmpty()) {
                        System.out.println("[OpenAI] Empty response from API, skipping this tick");
                        errorCount++;
                        if (errorCount > 5) {
                            System.out.println("[OpenAI] Too many errors (" + errorCount + "), entering fallback mode");
                            fallbackMode = true;
                        }
                        return;
                    }
                    
                    requestCount++;
                    errorCount = 0; // 成功则重置错误计数
                    
                    System.out.println("[OpenAI] Received response #" + requestCount + " (" + response.length() + " chars)");
                    System.out.println("[OpenAI] AI says: " + response.substring(0, Math.min(200, response.length())) + "...");
                    
                    // 解析并执行决策
                    executeDecisions(teamId, response);
                    
                } catch (Exception e) {
                    System.out.println("[OpenAI] ERROR in API call: " + e.toString());
                    e.printStackTrace();
                    errorCount++;
                } finally {
                    apiBusy.set(false);
                }
            });
        }
    }
    
    /**
     * 查找所有 OpenAI 难度的 AI 队伍
     */
    private List<PlayerTeam> findOpenAITeams() {
        List<PlayerTeam> result = new ArrayList<>();
        PlayerTeam[] teams = PlayerTeam.d(); // 获取所有队伍
        if (teams == null) return result;
        
        for (PlayerTeam team : teams) {
            if (team == null) continue;
            if (!team.w) continue; // 不是 AI
            if (team.b()) continue; // 已被淘汰
            
            int difficulty = team.C(); // 获取 AI 难度
            if (difficulty == OpenAIConfig.OPENAI) {
                result.add(team);
            }
        }
        return result;
    }
    
    /**
     * 构建系统提示词
     */
    private String buildSystemPrompt(PlayerTeam team) {
        StringBuilder prompt = new StringBuilder();
        prompt.append(knowledgeBase);
        prompt.append("\n\n");
        prompt.append("你是队伍 ").append(team.k).append(" 的AI指挥官。\n");
        prompt.append("根据当前游戏状态，给出你的下一步决策。\n");
        prompt.append("Reply in English ONLY. Use this format:\n");
        prompt.append("THINK: [your strategic analysis in 1-2 sentences]\n");
        prompt.append("BUILD: [unit_type] [count]  (e.g., BUILD: heavyTank 3)\n");
        prompt.append("MOVE: [x] [y] [unit_type] [count]  (e.g., MOVE: 120 80 builder 4)\n");
        prompt.append("ATTACK: [x] [y] [unit_type] [count]  (e.g., ATTACK: 200 100 tank 6)\n");
        prompt.append("SIEGE: [x] [y] [tanks] [builders]  (Attack with builders, deploy laser turrets + repair)\n");
        prompt.append("DEFEND: [x] [y] [unit_type] [count]\n");
        prompt.append("NUKE: [x] [y]  (launch nuke at coordinates)\n");
        prompt.append("You can issue multiple commands. One per line.\n");
        prompt.append("Available commands: THINK, BUILD, MOVE, ATTACK, SIEGE, DEFEND, NUKE");
        return prompt.toString();
    }
    
    /**
     * 解析并执行 AI 返回的决策（英文命令格式）
     */
    private void executeDecisions(int teamId, String response) {
        System.out.println("[OpenAI] Parsing decisions for team " + teamId);
        
        try {
            PlayerTeam team = null;
            PlayerTeam[] teams = PlayerTeam.d();
            for (PlayerTeam t : teams) {
                if (t != null && t.k == teamId) { team = t; break; }
            }
            if (team == null) return;
            
            GameEngine engine = GameEngine.getInstance();
            int commandsExecuted = 0;
            
            // 逐行解析命令
            String[] lines = response.split("\\n");
            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty()) continue;
                
                String upper = line.toUpperCase();
                
                // THINK: 发送到游戏聊天栏
                if (upper.startsWith("THINK:")) {
                    String thought = line.substring(6).trim();
                    GameEngine.f("AI", thought);
                    System.out.println("[OpenAI] Chat: " + thought);
                }
                
                // MOVE: x y unit_type count
                else if (upper.startsWith("MOVE:")) {
                    String[] parts = line.substring(5).trim().split("\\s+");
                    if (parts.length >= 4) {
                        try {
                            float x = Float.parseFloat(parts[0]);
                            float y = Float.parseFloat(parts[1]);
                            String type = parts[2].toLowerCase();
                            int count = Integer.parseInt(parts[3]);
                            List<BaseUnit> units = findUnitsByType(teamId, type);
                            for (int i = 0; i < Math.min(units.size(), count); i++) {
                                issueMoveCommand(engine, team, units.get(i), x + i * 20, y + i * 20);
                                commandsExecuted++;
                            }
                        } catch (NumberFormatException ignored) {}
                    }
                }
                
                // ATTACK: x y unit_type count
                else if (upper.startsWith("ATTACK:")) {
                    String[] parts = line.substring(7).trim().split("\\s+");
                    if (parts.length >= 4) {
                        try {
                            float x = Float.parseFloat(parts[0]);
                            float y = Float.parseFloat(parts[1]);
                            String type = parts[2].toLowerCase();
                            int count = Integer.parseInt(parts[3]);
                            List<BaseUnit> units = findUnitsByType(teamId, type);
                            for (int i = 0; i < Math.min(units.size(), count); i++) {
                                issueAttackCommand(engine, team, units.get(i), x + i * 30, y + i * 30);
                                commandsExecuted++;
                            }
                        } catch (NumberFormatException ignored) {}
                    }
                }
                
                // BUILD: unit_type count
                else if (upper.startsWith("BUILD:")) {
                    String[] parts = line.substring(6).trim().split("\\s+");
                    if (parts.length >= 2) {
                        String type = parts[0].toLowerCase();
                        int count = Integer.parseInt(parts[1]);
                        List<BaseUnit> builders = findUnitsByType(teamId, "builder");
                        for (int i = 0; i < Math.min(builders.size(), count); i++) {
                            BaseUnit b = builders.get(i);
                            issueMoveCommand(engine, team, b, b.posX + 50, b.posY + 50);
                            commandsExecuted++;
                        }
                        GameEngine.f("AI", "Building " + count + "x " + type);
                    }
                }
                
                // SIEGE: x y tanks builders - 攻城：坦克+建造者同行，建造者部署防御塔
                else if (upper.startsWith("SIEGE:")) {
                    String[] parts = line.substring(6).trim().split("\\s+");
                    if (parts.length >= 4) {
                        try {
                            float x = Float.parseFloat(parts[0]);
                            float y = Float.parseFloat(parts[1]);
                            int tankCount = Integer.parseInt(parts[2]);
                            int builderCount = Integer.parseInt(parts[3]);
                            
                            // 坦克向目标后方集结（formation）
                            List<BaseUnit> tanks = findUnitsByType(teamId, "tank");
                            for (int i = 0; i < Math.min(tanks.size(), tankCount); i++) {
                                issueAttackCommand(engine, team, tanks.get(i), x + i * 25, y + i * 25);
                                commandsExecuted++;
                            }
                            
                            // 建造者在坦克后方 50 单位处建造防御阵地
                            List<BaseUnit> builders = findUnitsByType(teamId, "builder");
                            for (int i = 0; i < Math.min(builders.size(), builderCount); i++) {
                                float bx = x - 50 + i * 30;
                                float by = y + 50;
                                issueMoveCommand(engine, team, builders.get(i), bx, by);
                                commandsExecuted++;
                            }
                            
                            GameEngine.f("AI", "SIEGE! Tanks:" + tankCount + " Builders:" + builderCount + " deploying turrets at (" + (int)x + "," + (int)y + ")");
                            System.out.println("[OpenAI] SIEGE: " + tankCount + " tanks + " + builderCount + " builders at (" + (int)x + "," + (int)y + ")");
                        } catch (NumberFormatException ignored) {}
                    }
                }
                
                // NUKE: x y - 发射核弹到敌方基地/工厂
                else if (upper.startsWith("NUKE:")) {
                    String[] parts = line.substring(5).trim().split("\\s+");
                    if (parts.length >= 2) {
                        try {
                            float x = Float.parseFloat(parts[0]);
                            float y = Float.parseFloat(parts[1]);
                            GameEngine.f("AI", "NUCLEAR LAUNCH DETECTED! Target: (" + (int)x + "," + (int)y + ")");
                            System.out.println("[OpenAI] NUKE: launching at (" + (int)x + "," + (int)y + ")");
                            
                            // 找到核弹发射井并发射
                            List<BaseUnit> nukeLaunchers = findUnitsByType(teamId, "nuke");
                            if (!nukeLaunchers.isEmpty()) {
                                for (BaseUnit nuke : nukeLaunchers) {
                                    issueAttackCommand(engine, team, nuke, x, y);
                                    commandsExecuted++;
                                }
                                System.out.println("[OpenAI] Nuke launched from " + nukeLaunchers.size() + " silo(s)");
                            } else {
                                // 没有核弹发射井，建造一个
                                List<BaseUnit> builders = findUnitsByType(teamId, "builder");
                                if (!builders.isEmpty()) {
                                    BaseUnit b = builders.get(0);
                                    issueMoveCommand(engine, team, b, b.posX + 100, b.posY);
                                    GameEngine.f("AI", "Building NukeLauncher first...");
                                    System.out.println("[OpenAI] No nuke silo found, sending builder to build one");
                                }
                                // 同时所有战斗单位向目标攻击
                                List<BaseUnit> all = findUnitsByType(teamId, "tank");
                                all.addAll(findUnitsByType(teamId, "mech"));
                                for (BaseUnit unit : all) {
                                    issueAttackCommand(engine, team, unit, x, y);
                                    commandsExecuted++;
                                }
                            }
                        } catch (NumberFormatException ignored) {}
                    }
                }
            }
            
            System.out.println("[OpenAI] Executed " + commandsExecuted + " commands for team " + teamId);
            
        } catch (Exception e) {
            System.out.println("[OpenAI] ERROR: " + e.toString());
            e.printStackTrace();
        }
    }
    
    /**
     * 按类型名查找单位
     */
    private List<BaseUnit> findUnitsByType(int teamId, String typeName) {
        List<BaseUnit> result = new ArrayList<>();
        List<BaseUnit> allUnits = getAllUnits();
        for (BaseUnit unit : allUnits) {
            if (unit != null && unit.bX != null && unit.bX.k == teamId) {
                String actualType = getUnitTypeName(unit);
                if (actualType.contains(typeName) || typeName.contains(actualType)) {
                    result.add(unit);
                }
            }
        }
        // 如果按类型找不到，返回所有我方单位
        if (result.isEmpty()) {
            for (BaseUnit unit : allUnits) {
                if (unit != null && unit.bX != null && unit.bX.k == teamId) {
                    result.add(unit);
                }
            }
        }
        return result;
    }
    
    /**
     * 发出移动指令
     */
    private void issueMoveCommand(GameEngine engine, PlayerTeam team, BaseUnit unit, float x, float y) {
        try {
            com.corrodinggames.rts.gameFramework.GameCommand cmd = engine.cf.a(team);
            cmd.a(unit);
            cmd.b(x, y);
            System.out.println("[OpenAI] Move command: unit " + unit.bs + " to (" + (int)x + "," + (int)y + ")");
        } catch (Exception e) {
            System.out.println("[OpenAI] Failed to issue move command: " + e.toString());
        }
    }
    
    /**
     * 发出攻击指令
     */
    private void issueAttackCommand(GameEngine engine, PlayerTeam team, BaseUnit unit, float x, float y) {
        try {
            com.corrodinggames.rts.gameFramework.GameCommand cmd = engine.cf.a(team);
            cmd.a(unit);
            cmd.b(x, y); // 攻击移动
            System.out.println("[OpenAI] Attack command: unit " + unit.bs + " attack-move to (" + (int)x + "," + (int)y + ")");
        } catch (Exception e) {
            System.out.println("[OpenAI] Failed to issue attack command: " + e.toString());
        }
    }
    
    // ========== 公共查询方法 ==========
    
    /**
     * 检查 OpenAI 是否处于活跃状态
     */
    public boolean isActive() {
        return initialized && apiConfigured && !fallbackMode;
    }
    
    /**
     * 获取 API 请求计数
     */
    public int getRequestCount() {
        return requestCount;
    }
    
    /**
     * 获取错误计数
     */
    public int getErrorCount() {
        return errorCount;
    }
    
    /**
     * 重置控制器（游戏结束时调用）
     */
    public void reset() {
        tickAccumulator = 0.0f;
        requestCount = 0;
        errorCount = 0;
        fallbackMode = false;
        initialized = false;
        System.out.println("[OpenAI] Controller reset");
    }
    
    /**
     * 强制退出降级模式（用户修改配置后调用）
     */
    public void recheckConfig() {
        fallbackMode = false;
        initialized = false; // 触发重新初始化
        System.out.println("[OpenAI] Config recheck requested");
    }
    
    // ========== 辅助方法 ==========
    
    /**
     * 获取所有存活单位
     */
    private List<BaseUnit> getAllUnits() {
        List<BaseUnit> result = new ArrayList<>();
        try {
            if (BaseUnit.bE != null) {
                int size = BaseUnit.bE.size();
                for (int i = 0; i < size; i++) {
                    Object obj = BaseUnit.bE.get(i);
                    if (obj instanceof BaseUnit) {
                        BaseUnit unit = (BaseUnit) obj;
                        if (!unit.u()) { // u() = isDead
                            result.add(unit);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("[OpenAI] Error getting units: " + e.toString());
        }
        return result;
    }
    
    /**
     * 获取单位类型名称
     */
    private String getUnitTypeName(BaseUnit unit) {
        try {
            if (unit.dz != null) {
                return unit.dz.getClass().getSimpleName().toLowerCase();
            }
        } catch (Exception e) {
            // ignore
        }
        return "unit_" + unit.bs;
    }
}
