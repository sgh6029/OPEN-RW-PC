package com.corrodinggames.rts.game.units;

public enum UnitBehaviorType
{
    normal("normal", 0), 
    strafing("strafing", 1), 
    moveaway("moveaway", 2), 
    bomber("bomber", 3);
    
    private static final /* synthetic */ UnitBehaviorType[] e;

    private UnitBehaviorType(final String name, final int ordinal) {
    }
    
    static {
        e = new UnitBehaviorType[] { UnitBehaviorType.normal, UnitBehaviorType.strafing, UnitBehaviorType.moveaway, UnitBehaviorType.bomber };
    }
}
