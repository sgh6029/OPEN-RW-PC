package com.corrodinggames.rts.gameFramework;

public enum StatisticType
{
    income("income", 0, com.corrodinggames.rts.gameFramework.g.f.income), 
    armyValue("armyValue", 1, com.corrodinggames.rts.gameFramework.g.f.armyValue), 
    buildingValue("buildingValue", 2, com.corrodinggames.rts.gameFramework.g.f.buildingValue), 
    totalValue("totalValue", 3, com.corrodinggames.rts.gameFramework.g.f.totalValue);
    
    final com.corrodinggames.rts.gameFramework.g.f e;
    private static final /* synthetic */ StatisticType[] f;
    
    
    private StatisticType(final String name, final int ordinal, final com.corrodinggames.rts.gameFramework.g.f e) {
        this.e = e;
    }
    
    public com.corrodinggames.rts.gameFramework.g.f a() {
        return this.e;
    }
    
    static {
        f = new StatisticType[] { StatisticType.income, StatisticType.armyValue, StatisticType.buildingValue, StatisticType.totalValue };
    }
}
