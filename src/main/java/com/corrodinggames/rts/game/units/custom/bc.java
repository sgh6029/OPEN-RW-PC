/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

public class bc {
    public String a;
    public String b;

    public bc() {
    }

    public bc(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    public void a(String string2, String string3) {
        if (this.b != null) {
            this.b = this.b.replaceAll(string2, string3);
        }
    }
}

