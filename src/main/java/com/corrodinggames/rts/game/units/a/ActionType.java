package com.corrodinggames.rts.game.units.a;

public enum ActionType
{
    none("none", 0), 
    placeBuilding("placeBuilding", 1), 
    popupQueue("popupQueue", 2), 
    setRally("setRally", 3), 
    reclaimTarget("reclaimTarget", 4), 
    repairTarget("repairTarget", 5), 
    targetGround("targetGround", 6), 
    attackMove("attackMove", 7), 
    infoOnly("infoOnly", 8), 
    pingMap("pingMap", 9), 
    directToAction("directToAction", 10), 
    guardUnit("guardUnit", 11), 
    patrol("patrol", 12);
    
    // private static final /* synthetic */ ActionType[] n;
    
    
    private ActionType(final String name, final int ordinal) {
    }
    
    // static {
    //     n = new ActionType[] { ActionType.none, ActionType.placeBuilding, ActionType.popupQueue, ActionType.setRally, ActionType.reclaimTarget,
    //          ActionType.repairTarget, ActionType.targetGround, ActionType.attackMove, ActionType.infoOnly, 
    //          ActionType.pingMap, ActionType.directToAction, ActionType.guardUnit, ActionType.patrol };
    // }
}
