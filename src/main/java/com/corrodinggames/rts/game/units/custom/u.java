/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;

import java.util.List;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.PointF;

public class u {
    m a = new m();
    m b;
    String c;
    String d;

    public void a(l l2) {
    }

    public void b(l l2) throws bo {
        m m2 = new m();
        for (String string2 : ((List<String>) this.a)) {
            AbstractUnitAction s2 = l2.h(string2);
            if (s2 == null) {
                throw new bo("[" + this.d + "]" + this.c + " Could not find action:" + string2 + " on unit: " + l2.b());
            }
            if (s2 instanceof PopupQueueAction) {
                m2.add((PopupQueueAction) s2);
                continue;
            }
            throw new bo("[" + this.d + "]" + this.c + " Action:" + string2 + " on unit: " + l2.b()
                    + " doesn't have the right type");
        }
        this.b = m2;
    }

    public void a(j j2, PointF pointF, BaseUnit am2, int n2, int n3) {
        if (this.b == null) {
            NetworkEngine.g("Action on " + j2.dt().i() + " has not been linked");
            return;
        }
        for (AbstractUnitAction s2 : ((List<AbstractUnitAction>) this.b)) {
            j2.a(s2, pointF, am2, n2, n3);
        }
    }

    public m a() {
        if (this.b == null) {
            NetworkEngine.g("Action on [" + this.d + "]" + this.c + " has not been linked");
            return new m();
        }
        return this.b;
    }

    public void a(j j2, PointF pointF, BaseUnit am2) {
        if (this.b == null) {
            NetworkEngine.g("Action on " + j2.dt().i() + " has not been linked");
            return;
        }
        for (AbstractUnitAction s2 : ((List<AbstractUnitAction>) this.b)) {
            j2.dL.a((PopupQueueAction) s2, false, pointF, am2);
        }
    }
}
