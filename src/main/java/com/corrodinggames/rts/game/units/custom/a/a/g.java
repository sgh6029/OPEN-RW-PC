/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.a.a;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.a.a_f2;
import com.corrodinggames.rts.game.units.custom.a.d;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.utility.IniFile;

import android.graphics.PointF;

public class g
extends a_f2 {
    com.corrodinggames.rts.game.units.custom.e.a_f3 a;
    com.corrodinggames.rts.game.units.custom.e.a_f3 b;
    double c;
    double d;
    float e;

    public static void a(l l2, IniFile ab2, String string2, String string3, d d2, String string4, boolean bl2) throws bo {
        com.corrodinggames.rts.game.units.custom.e.a_f3 a2 = ab2.a(l2, string2, "convertResource_from", null, true);
        com.corrodinggames.rts.game.units.custom.e.a_f3 a3 = ab2.a(l2, string2, "convertResource_to", null, true);
        if (!(a2 == null && a3 == null || a2 != null && a3 != null)) {
            throw new bo("[" + string2 + "] Both convertResource_from and convertResource_to are required together");
        }
        if (a2 != null && a3 != null) {
            g g2 = new g();
            g2.a = a2;
            g2.b = a3;
            g2.c = ab2.a(string2, "convertResource_minAmount", 0.0);
            g2.d = ab2.j(string2, "convertResource_maxAmount");
            if (g2.c < 0.0) {
                throw new bo("[" + string2 + "] convertResource_minAmount cannot be < 0");
            }
            if (g2.d < 0.0) {
                throw new bo("[" + string2 + "] convertResource_maxAmount cannot be < 0");
            }
            if (g2.d < g2.c) {
                throw new bo("[" + string2 + "] convertResource_maxAmount cannot be < convertResource_minAmount");
            }
            g2.e = ab2.a(string2, "convertResource_multiplyAmountBy", Float.valueOf(1.0f)).floatValue();
            d2.ac.add(g2);
        }
    }

    @Override
    public boolean a(j j2, AbstractUnitAction s2, PointF pointF, BaseUnit am2, int n2) {
        double d2 = this.a.a(j2);
        if (d2 > this.c) {
            double d3 = GameUtils.a(d2, this.d);
            this.a.b(j2, -d3);
            this.b.b(j2, d3 *= (double)this.e);
        }
        return true;
    }
}

