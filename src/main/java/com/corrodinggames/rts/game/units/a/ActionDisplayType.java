package com.corrodinggames.rts.game.units.a;

public enum ActionDisplayType
{
    none("none", 0), //a
    rally("rally", 1), //b
    upgrade("upgrade", 2),//c 
    queueUnit("queueUnit", 3),//d 
    building("building", 4), //e
    action("action", 5), //f
    infoOnly("infoOnly", 6),//g 
    infoOnlyNoBox("infoOnlyNoBox", 7),//h 
    infoOnlyStockpile("infoOnlyStockpile", 8);//i
    
    // private static final /* synthetic */ ActionDisplayType[] j;
    
    // public static t[] values() {
    //     return t.j.clone();
    // }
    
    // public static t valueOf(final String name) {
    //     return Enum.valueOf(t.class, name);
    // }
    
    private ActionDisplayType(final String name, final int ordinal) {
    }
    
    // static {
    //     j = new ActionDisplayType[] { ActionDisplayType.none, ActionDisplayType.rally, ActionDisplayType.upgrade, ActionDisplayType.queueUnit, ActionDisplayType.building, ActionDisplayType.action, ActionDisplayType.infoOnly, ActionDisplayType.infoOnlyNoBox, ActionDisplayType.infoOnlyStockpile };
    // }
}
