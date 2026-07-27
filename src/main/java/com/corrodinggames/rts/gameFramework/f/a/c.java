/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f.a;

import com.corrodinggames.rts.gameFramework.f.a.d;

public class c {
    public int a;
    public int b;
    public d c;
    public int d = -1;

    public static c a(int n2, int n3) {
        c c2 = new c();
        c2.a = n2;
        c2.b = n3;
        c2.c = com.corrodinggames.rts.gameFramework.f.a.d.mouseClick;
        c2.d = 1;
        return c2;
    }

    public static c b(int n2, int n3) {
        c c2 = new c();
        c2.a = n2;
        c2.b = n3;
        c2.c = com.corrodinggames.rts.gameFramework.f.a.d.mouseMove;
        c2.d = 1;
        return c2;
    }

    public boolean a() {
        return this.c == com.corrodinggames.rts.gameFramework.f.a.d.mouseClick;
    }

    public boolean b() {
        return this.c == com.corrodinggames.rts.gameFramework.f.a.d.mouseMove;
    }
}

