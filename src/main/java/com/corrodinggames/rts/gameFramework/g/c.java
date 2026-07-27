package com.corrodinggames.rts.gameFramework.g;

public enum c
{
    player("player", 0), 
    allyGroup("allyGroup", 1), 
    combinedPlayerAndGroup("combinedPlayerAndGroup", 2);
    
    private static final /* synthetic */ c[] d;
    
    private c(final String name, final int ordinal) {
    }
    
    static {
        d = new c[] { c.player, c.allyGroup, c.combinedPlayerAndGroup };
    }
}
