package com.corrodinggames.rts.ai.openai;

import com.corrodinggames.rts.gameFramework.GameEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * OpenAI 兼容 API 客户端
 * 支持 OpenAI、Azure OpenAI、本地 Ollama 等兼容接口
 */
public class OpenAIClient {
    
    private static OpenAIClient instance;
    
    private String baseUrl;
    private String apiKey;
    private String model;
    private float temperature;
    private int maxTokens;
    
    // 超时设置（毫秒）
    private static final int CONNECT_TIMEOUT = 30000;
    private static final int READ_TIMEOUT = 60000;
    
    private OpenAIClient() {
        // 从 SettingsEngine 加载配置
        loadConfig();
    }
    
    public static synchronized OpenAIClient getInstance() {
        if (instance == null) {
            instance = new OpenAIClient();
        }
        return instance;
    }
    
    /**
     * 从 SettingsEngine 加载配置
     */
    private void loadConfig() {
        GameEngine engine = GameEngine.getInstance();
        if (engine != null && engine.bQ != null) {
            this.baseUrl = engine.bQ.openAIEndpoint;
            this.apiKey = engine.bQ.openAIApiKey;
            this.model = engine.bQ.openAIModel;
            this.temperature = engine.bQ.openAITemperature;
            this.maxTokens = engine.bQ.openAIMaxTokens;
        } else {
            // 默认值
            this.baseUrl = "https://api.openai.com/v1";
            this.apiKey = "";
            this.model = "gpt-4o-mini";
            this.temperature = 0.3f;
            this.maxTokens = 2048;
        }
    }
    
    /**
     * 发送聊天请求
     * @param systemPrompt 系统提示词
     * @param userMessage 用户消息（游戏状态）
     * @return AI 回复内容，失败返回 null
     */
    public String chat(String systemPrompt, String userMessage) {
        if (apiKey == null || apiKey.isEmpty()) {
            GameEngine.log("[OpenAI] API Key 未配置");
            return null;
        }
        
        try {
            // 构建请求 URL
            String endpoint = baseUrl.endsWith("/") ? baseUrl + "chat/completions" : baseUrl + "/chat/completions";
            URL url = new URL(endpoint);
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setConnectTimeout(CONNECT_TIMEOUT);
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setDoOutput(true);
            
            // 构建请求体
            String requestBody = buildRequestBody(systemPrompt, userMessage);
            
            // 发送请求
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            
            // 读取响应
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                String errorMsg = readErrorResponse(conn);
                GameEngine.log("[OpenAI] API 错误 " + responseCode + ": " + errorMsg);
                return null;
            }
            
            String responseBody;
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                responseBody = response.toString();
            }
            
            // 解析响应
            return parseResponse(responseBody);
            
        } catch (IOException e) {
            GameEngine.log("[OpenAI] 网络错误: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * 构建请求体 JSON
     */
    private String buildRequestBody(String systemPrompt, String userMessage) {
        // 转义特殊字符
        systemPrompt = escapeJson(systemPrompt);
        userMessage = escapeJson(userMessage);
        
        return String.format(
            "{" +
            "\"model\":\"%s\"," +
            "\"messages\":[" +
                "{\"role\":\"system\",\"content\":\"%s\"}," +
                "{\"role\":\"user\",\"content\":\"%s\"}" +
            "]," +
            "\"temperature\":%.2f," +
            "\"max_tokens\":%d," +
            "\"stream\":false" +
            "}",
            model, systemPrompt, userMessage, temperature, maxTokens
        );
    }
    
    /**
     * 解析响应 JSON，提取 AI 回复内容
     */
    private String parseResponse(String responseBody) {
        try {
            // 简单 JSON 解析，提取 choices[0].message.content
            int choicesIdx = responseBody.indexOf("\"choices\"");
            if (choicesIdx == -1) {
                GameEngine.log("[OpenAI] 响应格式错误: 未找到 choices");
                return null;
            }
            
            int messageIdx = responseBody.indexOf("\"message\"", choicesIdx);
            if (messageIdx == -1) {
                GameEngine.log("[OpenAI] 响应格式错误: 未找到 message");
                return null;
            }
            
            int contentIdx = responseBody.indexOf("\"content\"", messageIdx);
            if (contentIdx == -1) {
                GameEngine.log("[OpenAI] 响应格式错误: 未找到 content");
                return null;
            }
            
            // 找到 content 的值
            int colonIdx = responseBody.indexOf(":", contentIdx);
            int quoteStart = responseBody.indexOf("\"", colonIdx + 1);
            int quoteEnd = findClosingQuote(responseBody, quoteStart + 1);
            
            if (quoteStart == -1 || quoteEnd == -1) {
                GameEngine.log("[OpenAI] 响应格式错误: content 值解析失败");
                return null;
            }
            
            String content = responseBody.substring(quoteStart + 1, quoteEnd);
            return unescapeJson(content);
            
        } catch (Exception e) {
            GameEngine.log("[OpenAI] 解析响应失败: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * 读取错误响应
     */
    private String readErrorResponse(HttpURLConnection conn) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } catch (IOException e) {
            return "无法读取错误信息";
        }
    }
    
    /**
     * 找到闭合引号（处理转义）
     */
    private int findClosingQuote(String str, int start) {
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '"') {
                // 检查是否被转义
                int backslashCount = 0;
                for (int j = i - 1; j >= start && str.charAt(j) == '\\'; j--) {
                    backslashCount++;
                }
                if (backslashCount % 2 == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    /**
     * JSON 字符串转义
     */
    private String escapeJson(String str) {
        if (str == null) return "";
        return str
            .replace("\\", "\\\\")
            .replace("\"", "\\\"")
            .replace("\n", "\\n")
            .replace("\r", "\\r")
            .replace("\t", "\\t");
    }
    
    /**
     * JSON 字符串反转义
     */
    private String unescapeJson(String str) {
        if (str == null) return "";
        return str
            .replace("\\\"", "\"")
            .replace("\\n", "\n")
            .replace("\\r", "\r")
            .replace("\\t", "\t")
            .replace("\\\\", "\\");
    }
    
    /**
     * 检查配置是否有效
     */
    public boolean isConfigured() {
        return apiKey != null && !apiKey.isEmpty() && baseUrl != null && !baseUrl.isEmpty();
    }
    
    // Getters and Setters
    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }
    
    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
    
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    
    public float getTemperature() { return temperature; }
    public void setTemperature(float temperature) { this.temperature = temperature; }
    
    public int getMaxTokens() { return maxTokens; }
    public void setMaxTokens(int maxTokens) { this.maxTokens = maxTokens; }
}
