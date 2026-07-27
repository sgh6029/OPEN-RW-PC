/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.a.a;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;

import java.util.List;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.a.a_f2;
import com.corrodinggames.rts.game.units.custom.a.d;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.bp;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.PointF;

public class k
extends a_f2 {
    public bp a;
    public bp b;

    public static void a(l l2, IniFile ab2, String string2, String string3, d d2, String string4, boolean bl2) throws bo {
        Object object;
        bp bp2 = bp.a(l2, ab2, string2, string3 + "produceUnits");
        if (!bp2.b()) {
            object = new k();
            ((k)object).a = bp2;
            d2.ac.add(object);
        }
        if (!((bp)(object = bp.a(l2, ab2, string2, string3 + "spawnUnits"))).b()) {
            k k2 = new k();
            k2.b = (bp) object;
            d2.ac.add(k2);
        }
    }

    @Override
    public boolean a(j j2, AbstractUnitAction s2, PointF pointF, BaseUnit am2, int n2) {
        if (this.a != null) {
            m m2 = new m();
            this.a.a(m2, j2.bX, j2, false);
            for (BaseUnit am3 : ((List<BaseUnit>)m2)) {
                j2.E(am3);
                j2.F(am3);
            }
        }
        if (this.b != null) {
            this.b.a(j2.posX, j2.posY, j2.posZ, j2.cg, j2.bX, false, j2);
        }
        return true;
    }
}

