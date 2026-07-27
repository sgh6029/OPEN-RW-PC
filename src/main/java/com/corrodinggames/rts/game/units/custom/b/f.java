package com.corrodinggames.rts.game.units.custom.b;

public enum f
{
    shadow("shadow", 0), 
    beforeBody("beforeBody", 1), 
    afterBody("afterBody", 2), 
    onTop("onTop", 3), 
    beforeUI("beforeUI", 4), 
    inactive("inactive", 5);
    
    private static final /* synthetic */ f[] g;
    
    private f(final String name, final int ordinal) {
    }
    
    static {
        g = new f[] { f.shadow, f.beforeBody, f.afterBody, f.onTop, f.beforeUI, f.inactive };
    }
}
