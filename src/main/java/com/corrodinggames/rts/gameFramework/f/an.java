/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.e.f;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.f.ao;
import com.corrodinggames.rts.gameFramework.f.x;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.m;

public class an {
    static m a = new m();
    static final x b = new x();

    public static ao a(long l2) {
        Object[] objectArray = a.a();
        for (int i2 = an.a.a - 1; i2 >= 0; --i2) {
            ao ao2 = (ao)objectArray[i2];
            if (ao2.a != l2) continue;
            return ao2;
        }
        return null;
    }

    public static ao a(BaseUnit am2) {
        long l2 = am2.objectId;
        ao ao2 = an.a(l2);
        if (ao2 == null) {
            ao2 = new ao();
            ao2.a = am2.objectId;
            ao2.b = am2.cE;
            ao2.c = am2.cF;
            ao2.d = GameEngine.getInstance().networkEngine.X;
            a.add(ao2);
        }
        return ao2;
    }

    public static void a(BaseUnit am2, b b2) {
        if (!GameEngine.getInstance().networkEngine.B) {
            return;
        }
        ao ao2 = an.a(am2);
        ao2.b += b2.f;
        ao2.c = b2.c(ao2.c);
        if (!b2.k.c()) {
            ao2.e = f.b(ao2.e, b2.k);
        }
    }

    public static void b(BaseUnit am2, b b2) {
        if (!GameEngine.getInstance().networkEngine.B) {
            return;
        }
        ao ao2 = an.a(am2);
        ao2.b -= b2.f;
        ao2.c = b2.c(ao2.c);
        if (!b2.k.c()) {
            ao2.e = f.a(ao2.e, b2.k);
        }
        if (an.a.a > 0) {
            // empty if block
        }
    }

    public static boolean c(BaseUnit am2, b b2) {
        ao ao2 = an.a(am2.objectId);
        if (ao2 != null) {
            an.b.bX = am2.bX;
            an.b.cE = ao2.b;
            an.b.cF = ao2.c;
            f f2 = b.df();
            b.a(ao2.e);
            boolean bl2 = b2.b(b);
            b.a(f2);
            return bl2;
        }
        return b2.b(am2);
    }

    public static boolean a(LogicBoolean logicBoolean, y y2) {
        ao ao2 = an.a(y2.objectId);
        if (ao2 != null) {
            int n2 = y2.cE;
            int n3 = y2.cF;
            y2.cE = ao2.b;
            y2.cF = ao2.c;
            boolean bl2 = logicBoolean.read(y2);
            y2.cE = n2;
            y2.cF = n3;
            return bl2;
        }
        return logicBoolean.read(y2);
    }

    public static void a() {
        if (an.a.a > 0) {
            GameEngine.log("LagHiding: clearing: " + an.a.a);
        }
        a.clear();
    }

    public static void a(y y2, AbstractUnitAction s2) {
        if (a.size() == 0) {
            return;
        }
        int n2 = GameEngine.getInstance().networkEngine.X;
        for (int i2 = a.size() - 1; i2 >= 0; --i2) {
            ao ao2 = (ao)a.get(i2);
            if (ao2.a == y2.objectId) {
                a.remove(i2);
                break;
            }
            if (ao2.d >= n2 + 80) continue;
            a.remove(i2);
            break;
        }
    }
}

