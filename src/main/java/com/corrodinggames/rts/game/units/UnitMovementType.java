package com.corrodinggames.rts.game.units;

import java.util.Locale;

public enum UnitMovementType
{
    // a("NONE", 0), 
    // b("LAND", 1), 
    // c("BUILDING", 2), 
    // d("AIR", 3), 
    // e("WATER", 4), 
    // f("HOVER", 5), 
    // g("OVER_CLIFF", 6), 
    // h("OVER_CLIFF_WATER", 7),
    //上面是原来的 下面是我的
    NONE("NONE",0),
    LAND("LAND",1),
    BUILDING("BUILDING",2),
    AIR("AIR",3),
    WATER("WATER",4),
    HOVER("HOVER",5),
    OVER_CLIFF("OVER_CLIFF",6),
    OVER_CLIFF_WATER("OVER_CLIFF_WATER", 7);
    
    
    private static final /* synthetic */ UnitMovementType[] i;
    
    private UnitMovementType(final String name, final int ordinal) {
    }
    
    public static UnitMovementType myValueOf(final String name) {
        return Enum.valueOf(UnitMovementType.class, name);
    }
    public static UnitMovementType a(final String str, final String str2) {
        try {
            return myValueOf(str.toUpperCase(Locale.ROOT));
        }
        catch (final IllegalArgumentException ex) {
            String string = "";
            final UnitMovementType[] values = values();
            for (int length = values.length, i = 0; i < length; ++i) {
                string = string + ", " + values[i].toString();
            }
            throw new IllegalArgumentException("Unknown movement type:'" + str + "' possible type:" + string + " on key:" + str2);
        }
    }
    
    static {
        i = new UnitMovementType[] { UnitMovementType.NONE, UnitMovementType.LAND, UnitMovementType.BUILDING, UnitMovementType.AIR, UnitMovementType.WATER, UnitMovementType.HOVER, UnitMovementType.OVER_CLIFF, UnitMovementType.OVER_CLIFF_WATER };
    }
}
