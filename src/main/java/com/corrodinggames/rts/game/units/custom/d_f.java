/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

enum d_f {
    frame("frame", 0), //a
    scale("scale", 1), //b
    legX("legX", 2), //c
    legY("legY", 3), //d
    legDir("legDir", 4), //e
    legHeight("legHeight", 5),//f 
    turretX("turretX", 6), //g
    turretY("turretY", 7),//h 
    event("event", 8), //i
    legAlpha("legAlpha", 9);//j
    
    private static final /* synthetic */ d_f[] k;
    
    // public static d[] values() {
    //     return d.k.clone();
    // }
    
    // public static d valueOf(final String name) {
    //     return Enum.valueOf(d.class, name);
    // }
    
    private d_f(final String name, final int ordinal) {
    }
    
    static {
        k = new d_f[] { d_f.frame, d_f.scale, d_f.legX, d_f.legY, d_f.legDir, d_f.legHeight, d_f.turretX, d_f.turretY, d_f.event, d_f.legAlpha };
    }
}
