package com.corrodinggames.rts.gameFramework.f;

public enum r
{
    base("base", 0), 
    unit("unit", 1), 
    nuke("nuke", 2), 
    message("message", 3);
    
    private static final /* synthetic */ r[] e;
    
    private r(final String name, final int ordinal) {
    }
    
    static {
        e = new r[] { r.base, r.unit, r.nuke, r.message };
    }
}
