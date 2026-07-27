package com.corrodinggames.rts.gameFramework.f;

// 导入相关包
import com.corrodinggames.rts.gameFramework.StatisticType;

public enum ac {
    // 枚举常量定义
    overallStats("A", null),
    incomeChart("B", StatisticType.income),
    armyValueChart("C", StatisticType.armyValue),
    buildingValueChart("D", StatisticType.buildingValue),
    totalValueChart("E", StatisticType.totalValue);
    
    // 字段定义
    private final String f;
    private final StatisticType g;
    
    // 构造函数
    private ac(String str, StatisticType bjVar) {
        this.f = str;
        this.g = bjVar;
    }
    
    // 方法a：返回bj对象
    public StatisticType a() {
        return this.g;
    }
    
    // values()和valueOf()方法由编译器自动生成
}