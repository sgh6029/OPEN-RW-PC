package com.corrodinggames.rts.ai.openai;

/**
 * OpenAI AI 难度常量定义
 * 值与 rml 文件中 select option 的 value 对应
 */
public class OpenAIConfig {
    
    /**
     * AI 难度值定义
     * 对应 rml 文件中 aiDifficulty select 的 option value
     */
    public static final int VERY_EASY = -2;
    public static final int EASY = -1;
    public static final int MEDIUM = 0;
    public static final int HARD = 1;
    public static final int VERY_HARD = 2;
    public static final int IMPOSSIBLE = 3;
    public static final int OPENAI = 4;  // 新增：OpenAI 难度（追加在 Impossible=3 之后）
    
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
        if (difficulty == VERY_EASY) return "Very Easy";
        if (difficulty == EASY) return "Easy";
        if (difficulty == MEDIUM) return "Medium";
        if (difficulty == HARD) return "Hard";
        if (difficulty == VERY_HARD) return "Very Hard";
        if (difficulty == IMPOSSIBLE) return "Impossible";
        if (difficulty == OPENAI) return "OpenAI";
        return "Unknown(" + difficulty + ")";
    }
}
