package com.corrodinggames.rts.ai.openai;

/**
 * OpenAI AI 难度常量定义
 */
public class OpenAIConfig {
    
    /**
     * AI 难度值定义
     * 对应 arrays.xml 中的 aidifficulty_array
     */
    public static final int VERY_EASY = 0;
    public static final int EASY = 1;
    public static final int MEDIUM = 2;
    public static final int HARD = 3;
    public static final int VERY_HARD = 4;
    public static final int IMPOSSIBLE = 5;
    public static final int OPENAI = 6;  // 新增：OpenAI 难度
    
    /**
     * 检查是否为 OpenAI 难度
     */
    public static boolean isOpenAIDifficulty(int difficulty) {
        return difficulty == OPENAI;
    }
    
    /**
     * 获取难度名称
     */
    public static String getDifficultyName(int difficulty) {
        switch (difficulty) {
            case VERY_EASY: return "Very Easy";
            case EASY: return "Easy";
            case MEDIUM: return "Medium";
            case HARD: return "Hard";
            case VERY_HARD: return "Very Hard";
            case IMPOSSIBLE: return "Impossible";
            case OPENAI: return "OpenAI";
            default: return "Unknown";
        }
    }
}
