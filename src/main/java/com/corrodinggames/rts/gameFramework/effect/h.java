package com.corrodinggames.rts.gameFramework.effect;

public enum h
{
    //a
    verylow("verylow", 0), 
    //b
    low("low", 1), 
    //c
    high("high", 2), 
    //d
    veryhigh("veryhigh", 3), 
    //e
    critical("critical", 4);
    
    private static final /* synthetic */ h[] f;
    
    // public static h[] values() {
    //     return h.f.clone();
    // }
    
    // public static h valueOf(final String name) {
    //     return Enum.valueOf(h.class, name);
    // }
    
    private h(final String name, final int ordinal) {
    }
    
    public boolean a(final h h) {
        return h == null || this.ordinal() < h.ordinal();
    }
    
    static {
        f = new h[] { h.verylow, h.low, h.high, h.veryhigh, h.critical };
    }
}
