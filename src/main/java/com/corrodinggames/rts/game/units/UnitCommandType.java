package com.corrodinggames.rts.game.units;

public enum UnitCommandType
{
    move("move", 0), //a
    attack("attack", 1),//b 
    build("build", 2), //c
    repair("repair", 3), //d
    loadInto("loadInto", 4),//e 
    unloadAt("unloadAt", 5), //f
    reclaim("reclaim", 6), //g
    attackMove("attackMove", 7), //h
    loadUp("loadUp", 8), //i
    patrol("patrol", 9), //j
    guard("guard", 10), //k
    guardAt("guardAt", 11),//l 
    touchTarget("touchTarget", 12), //m
    follow("follow", 13), //n
    triggerAction("triggerAction", 14), //o
    triggerActionWhenInRange("triggerActionWhenInRange", 15), //p
    setPassiveTarget("setPassiveTarget", 16);//q
    
    private static final /* synthetic */ UnitCommandType[] r;
    
    private UnitCommandType(final String name, final int ordinal) {
    }
    
    static {
        r = new UnitCommandType[] { UnitCommandType.move, UnitCommandType.attack, UnitCommandType.build, UnitCommandType.repair, UnitCommandType.loadInto, UnitCommandType.unloadAt, UnitCommandType.reclaim, UnitCommandType.attackMove, UnitCommandType.loadUp, UnitCommandType.patrol, UnitCommandType.guard, UnitCommandType.guardAt, UnitCommandType.touchTarget, UnitCommandType.follow, UnitCommandType.triggerAction, UnitCommandType.triggerActionWhenInRange, UnitCommandType.setPassiveTarget };
    }
}
