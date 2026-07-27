/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;

import java.util.List;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.utility.m;

class c {
    BaseUnit a;
    AbstractUnitAction b;
    float c;
    boolean d;
    boolean e;
    static m f = new m();

    c() {
    }

    public static void a(BaseUnit am2, AbstractUnitAction s2, boolean bl2, boolean bl3) {
        c c2 = com.corrodinggames.rts.gameFramework.f.c.a(am2, s2, bl3);
        if (c2 == null) {
            c2 = new c();
            f.add(c2);
        }
        c2.a = am2;
        c2.b = s2;
        c2.c = 10.0f;
        c2.d = bl2;
        c2.e = bl3;
    }

    public static c a(BaseUnit am2, AbstractUnitAction s2, boolean bl2) {
        for (c c2 : ((List<c>) f)) {
            if (c2.a != am2 || c2.b != s2 || c2.e != bl2)
                continue;
            return c2;
        }
        return null;
    }

    public static float b(BaseUnit am2, AbstractUnitAction s2, boolean bl2) {
        c c2 = com.corrodinggames.rts.gameFramework.f.c.a(am2, s2, bl2);
        if (c2 != null) {
            float f2 = c2.c / 10.0f;
            if (c2.d) {
                f2 = -f2;
            }
            return f2;
        }
        return 0.0f;
    }

    public static void a(float f2) {
        for (int i2 = f.size() - 1; i2 >= 0; --i2) {
            c c2 = (c) f.get(i2);
            c2.c -= f2;
            if (!(c2.c <= 0.0f))
                continue;
            f.remove(i2);
        }
    }
}
