package com.corrodinggames.rts.ai.openai;

import com.corrodinggames.rts.gameFramework.GameEngine;

/**
 * 游戏状态序列化为文本
 * 将游戏状态转换为 LLM 可理解的文本格式
 * 
 * 注意：此类的实际数据获取逻辑将在任务二中实现。
 * 当前仅返回框架文本，不引用任何混淆字段名。
 */
public class GameStateSerializer {
    
    public GameStateSerializer() {
    }
    
    /**
     * 序列化当前游戏状态为文本
     * @param aiTeamId OpenAI 控制的队伍 ID
     * @return 游戏状态文本
     */
    public String serialize(int aiTeamId) {
        GameEngine.log("[OpenAI] GameStateSerializer.serialize called for team " + aiTeamId);
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== 游戏状态 ===\n");
        sb.append("游戏版本: ").append(GameEngine.dz).append("\n");
        sb.append("OpenAI 队伍 ID: ").append(aiTeamId).append("\n\n");
        sb.append("[待任务二实现：完整游戏状态序列化]\n");
        
        return sb.toString();
    }
}
