/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.effect;

public enum d
{
    custom("custom", 0), 
    smoke("smoke", 1), 
    teleport("teleport", 2), 
    hitGround("hitGround", 3), 
    playerLand("playerLand", 4), 
    playerJump("playerJump", 5), 
    gemCollect("gemCollect", 6), 
    keyDoorOpen("keyDoorOpen", 7), 
    blood("blood", 8);
    
    private static final /* synthetic */ d[] j;
    
    private d(final String name, final int ordinal) {
    }
    
    static {
        j = new d[] { d.custom, d.smoke, d.teleport, d.hitGround, d.playerLand, d.playerJump, d.gemCollect, d.keyDoorOpen, d.blood };
    }
}
