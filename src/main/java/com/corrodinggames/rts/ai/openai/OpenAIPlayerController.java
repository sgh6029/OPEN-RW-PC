package com.corrodinggames.rts.ai.openai;

import com.corrodinggames.rts.game.GameLogic;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.GameEngine;

import java.util.ArrayList;
import java.util.List;

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
        
        // 检查 API 配置
        OpenAIClient client = OpenAIClient.getInstance();
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
        
        System.out.println("[OpenAI] Controller initialized successfully");
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
        
        knowledgeBase = kb.toString();
        System.out.println("[OpenAI] Knowledge base loaded: " + knowledgeBase.length() + " chars");
    }
    
    /**
     * 执行一次 AI 决策周期
     */
    private void performAITick() {
        GameEngine engine = GameEngine.getInstance();
        if (engine == null) {
            System.out.println("[OpenAI] GameEngine is null, skipping tick");
            return;
        }
        
        // 找到所有 OpenAI 难度的 AI 玩家
        List<PlayerTeam> openAITeams = findOpenAITeams();
        if (openAITeams.isEmpty()) {
            return; // 没有 OpenAI 玩家，跳过
        }
        
        System.out.println("[OpenAI] Performing AI tick for " + openAITeams.size() + " OpenAI team(s), request #" + (requestCount + 1));
        
        for (PlayerTeam team : openAITeams) {
            processTeamDecision(team);
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
     * 为指定队伍执行 AI 决策
     */
    private void processTeamDecision(PlayerTeam team) {
        try {
            // 1. 序列化游戏状态
            GameStateSerializer serializer = new GameStateSerializer();
            String gameState = serializer.serialize(team.k); // team.k = teamId
            
            // 2. 构建完整提示词
            String systemPrompt = buildSystemPrompt(team);
            
            // 3. 发送 API 请求
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
            
            // 4. 解析并执行决策
            executeDecisions(team, response);
            
        } catch (Exception e) {
            System.out.println("[OpenAI] ERROR in processTeamDecision: " + e.toString());
            e.printStackTrace();
            errorCount++;
        }
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
        prompt.append("请用简洁的中文回复你的战略思考和具体操作指令。\n");
        prompt.append("回复格式：\n");
        prompt.append("【战略】简短描述当前战略思路\n");
        prompt.append("【操作】具体要执行的操作列表\n");
        return prompt.toString();
    }
    
    /**
     * 解析并执行 AI 返回的决策
     * 当前版本：仅记录日志，不实际执行（执行逻辑在任务二实现）
     */
    private void executeDecisions(PlayerTeam team, String response) {
        // 任务二将实现完整的指令解析和执行
        // 当前仅记录 AI 的决策，原 AI 继续运行
        System.out.println("[OpenAI] Decision logged for team " + team.k + " (execution in Task 2)");
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
}
