/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.java.SlickGraphicsEngine;
import org.newdawn.slick.Font;

class FontKey {
    int a;
    boolean b;
    boolean c;
    Font d;
    int e;
    String[] f = new String[30];
    final /* synthetic */ SlickGraphicsEngine g;

    FontKey(SlickGraphicsEngine e2) {
        this.g = e2;
    }

    public FontKey a() {
        FontKey f2 = new FontKey(this.g);
        f2.a = this.a;
        f2.b = this.b;
        f2.c = this.c;
        return f2;
    }

    public String toString() {
        return "FontKey:(size:" + this.a + ",  bold:" + this.b + " fallback:" + this.c + ")";
    }

    boolean a(String string2) {
        if (string2 == null) {
            return true;
        }
        boolean bl2 = com.corrodinggames.rts.java.SlickGraphicsEngine.a(string2);
        if (!bl2) {
            return true;
        }
        for (int i2 = 0; i2 < this.f.length; ++i2) {
            String string3 = this.f[i2];
            if (string3 == null || !string3.equals(string2)) continue;
            return true;
        }
        return false;
    }

    void b(String string2) {
        this.f[this.e] = string2;
        ++this.e;
        if (this.e >= this.f.length) {
            this.e = 0;
        }
    }

    public /* synthetic */ Object clone() {
        return this.a();
    }
}

