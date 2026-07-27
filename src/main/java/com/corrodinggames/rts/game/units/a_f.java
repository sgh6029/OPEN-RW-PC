/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

public enum a_f
{
    outOfRange("outOfRange", 0), //a
    onlyInRange("onlyInRange", 1), //b
    returnFire("returnFire", 2), //c
    holdFire("holdFire", 3), //d
    guardArea("guardArea", 4), //e
    aggressive("aggressive", 5), //f
    mixed("mixed", 6);//g
    
    private static final /* synthetic */ a_f[] h;
    
    // public static a[] values() {
    //     return a.h.clone();
    // }
    
    // public static a valueOf(final String name) {
    //     return Enum.valueOf(a.class, name);
    // }
    
    private a_f(final String name, final int ordinal) {
    }
    
    static {
        h = new a_f[] { a_f.outOfRange, a_f.onlyInRange, a_f.returnFire, a_f.holdFire, a_f.guardArea, a_f.aggressive, a_f.mixed };
    }
}

