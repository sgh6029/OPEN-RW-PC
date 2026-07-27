/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.f;

import java.util.HashMap;

public class d {
    HashMap a = new HashMap();

    public void a(String string2, String string3) {
        this.a.put(string2, string3);
    }

    public String a(String string2) {
        return (String)this.a.get(string2);
    }

    public void a() {
        this.a.clear();
    }
}

