package com.corrodinggames.rts.ai.openai;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏状态序列化为文本
 * 将游戏状态转换为 LLM 可理解的文本格式
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
        GameEngine engine = GameEngine.getInstance();
        if (engine == null) {
            return "游戏引擎未初始化";
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 基本信息
        sb.append("=== 游戏状态 ===\n");
        sb.append("游戏版本: ").append(GameEngine.dz).append("\n");
        sb.append("帧号: ").append(engine.bx).append("\n");
        sb.append("我方队伍ID: ").append(aiTeamId).append("\n\n");
        
        // 遍历所有队伍
        PlayerTeam[] teams = PlayerTeam.d();
        if (teams == null) {
            sb.append("无队伍信息\n");
            return sb.toString();
        }
        
        // 获取所有单位
        List<BaseUnit> allUnits = getAllUnits();
        
        for (PlayerTeam team : teams) {
            if (team == null) continue;
            if (team.b()) continue; // 跳过已淘汰
            
            int teamId = team.k;
            boolean isMe = (teamId == aiTeamId);
            
            sb.append("--- ").append(isMe ? "我方" : "敌方").append(" 队伍 ").append(teamId).append(" ---\n");
            
            // 资源
            sb.append("资金: ").append((int) team.o).append("\n");
            
            // 统计该队伍的单位
            List<BaseUnit> teamUnits = getUnitsForTeam(teamId, allUnits);
            sb.append("单位数量: ").append(teamUnits.size()).append("\n");
            
            // 按类型分组
            int builders = 0, military = 0, buildings = 0, other = 0;
            for (BaseUnit unit : teamUnits) {
                if (unit == null) continue;
                String typeName = getUnitTypeName(unit);
                if (typeName.contains("builder") || typeName.contains("engineer") || typeName.contains("harvester")) {
                    builders++;
                } else if (typeName.contains("factory") || typeName.contains("turret") || typeName.contains("extractor") || typeName.contains("command")) {
                    buildings++;
                } else {
                    military++;
                }
            }
            
            sb.append("  建造者/采集: ").append(builders).append("\n");
            sb.append("  军事单位: ").append(military).append("\n");
            sb.append("  建筑: ").append(buildings).append("\n");
            
            // 详细列表（限制数量避免过长）
            if (teamUnits.size() <= 30) {
                for (BaseUnit unit : teamUnits) {
                    if (unit == null) continue;
                    sb.append(String.format("  - %s @ (%.0f, %.0f) HP:%.0f/%.0f\n",
                        getUnitTypeName(unit), unit.posX, unit.posY, unit.cu, unit.cv));
                }
            } else {
                // 只显示前 20 个
                for (int i = 0; i < 20; i++) {
                    BaseUnit unit = teamUnits.get(i);
                    if (unit == null) continue;
                    sb.append(String.format("  - %s @ (%.0f, %.0f) HP:%.0f/%.0f\n",
                        getUnitTypeName(unit), unit.posX, unit.posY, unit.cu, unit.cv));
                }
                sb.append("  ... 还有 ").append(teamUnits.size() - 20).append(" 个单位\n");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    /**
     * 获取所有存活单位
     */
    private List<BaseUnit> getAllUnits() {
        List<BaseUnit> result = new ArrayList<>();
        try {
            if (BaseUnit.bE != null) {
                BaseUnit[] arr = BaseUnit.bE.a();
                int size = BaseUnit.bE.size();
                for (int i = 0; i < size; i++) {
                    if (arr[i] != null && !arr[i].u()) { // u() = isDead
                        result.add(arr[i]);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("[OpenAI] Error getting units: " + e.toString());
        }
        return result;
    }
    
    /**
     * 获取指定队伍的单位
     */
    private List<BaseUnit> getUnitsForTeam(int teamId, List<BaseUnit> allUnits) {
        List<BaseUnit> result = new ArrayList<>();
        for (BaseUnit unit : allUnits) {
            if (unit == null) continue;
            if (unit.bX != null && unit.bX.k == teamId) {
                result.add(unit);
            }
        }
        return result;
    }
    
    /**
     * 获取单位类型名称
     */
    private String getUnitTypeName(BaseUnit unit) {
        try {
            if (unit.dz != null) {
                return unit.dz.getClass().getSimpleName();
            }
        } catch (Exception e) {
            // ignore
        }
        return "unit_" + unit.bs;
    }
}
