package com.corrodinggames.rts.game;

public enum o
{
    pureGreen("pureGreen", 0), //a
    hueAdd("hueAdd", 1), //b
    hueNew("hueNew", 2), //c
    hueShift("hueShift", 3), //d
    disabled("disabled", 4);//e
    
    private static final /* synthetic */ o[] f;

    private o(final String name, final int ordinal) {
    }
    
    static {
        f = new o[] { o.pureGreen, o.hueAdd, o.hueNew, o.hueShift, o.disabled };
    }
}
