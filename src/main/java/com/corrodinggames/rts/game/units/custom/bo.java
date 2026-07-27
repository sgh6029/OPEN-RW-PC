/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

public class bo extends Exception {
    public String b;
    public String c;
    public String d;

    public bo(String string2, String string3) {
        super(string2);
        this.b = string3;
    }

    public bo(String string2) {
        super(string2);
    }

    public bo(String string2, String string3, String string4) {
        super(string2);
        this.c = string3;
        this.d = string4;
    }

    public bo(String string2, Exception exception) {
        super(string2, exception);
    }
}

