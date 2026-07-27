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
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.PointF;

public class o
extends a_f2 {
    public bp a;
    public int b;
    public h c;
    public boolean d;
    public boolean e;
    public int f = -1;
    public LogicBoolean g;

    public static void a(l l2, IniFile ab2, String string2, String string3, d d2, String string4, boolean bl2) throws bo {
        bp bp2 = bp.a(l2, ab2, string2, string3 + "addUnitsIntoTransport");
        int n2 = ab2.b(string2, string3 + "deleteNumUnitsFromTransport", 0);
        h h2 = com.corrodinggames.rts.game.units.custom.g.a(ab2.b(string2, "deleteNumUnitsFromTransport_onlyWithTags", (String)null), null);
        boolean bl3 = ab2.a(string2, string3 + "startUnloadingTransport", (Boolean)false);
        boolean bl4 = ab2.a(string2, string3 + "forceUnloadTransportNow", (Boolean)false);
        int n3 = ab2.b(string2, string3 + "forceUnloadTransportNow_onlyOnSlot", -1);
        LogicBoolean logicBoolean = ab2.b(l2, string2, string3 + "transportTargetNow", null);
        if (n3 != -1 && !bl4) {
            throw new bo("forceUnloadTransportNow_onlyOnSlot expects forceUnloadTransportNow");
        }
        if (!bp2.b() || n2 > 0 || bl3 || bl4 || logicBoolean != null) {
            o o2 = new o();
            if (!bp2.b()) {
                o2.a = bp2;
            }
            if (n2 > 0) {
                o2.b = n2;
                o2.c = h2;
            }
            o2.d = bl3;
            o2.e = bl4;
            o2.f = n3;
            o2.g = logicBoolean;
            d2.ac.add(o2);
        }
    }

    @Override
    public boolean a(j j2, AbstractUnitAction s2, PointF pointF, BaseUnit am2, int n2) {
        BaseUnit am3;
        int n3;
        if (this.b != 0) {
            block0: for (n3 = 0; n3 < this.b; ++n3) {
                if (j2.B.size() <= 0) continue;
                for (int i2 = j2.B.size() - 1; i2 >= 0; --i2) {
                    BaseUnit am4 = (BaseUnit)j2.B.get(i2);
                    if (am4 == null) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("deleteNumUnitsFromTransport unit==null");
                        continue;
                    }
                    if (this.c != null && !com.corrodinggames.rts.game.units.custom.g.a(this.c, am4.de())) continue;
                    j2.B.remove(i2);
                    j2.D(am4);
                    if (am4 == null) continue block0;
                    am4.ci();
                    continue block0;
                }
            }
        }
        if (this.a != null) {
            m m2 = new m();
            this.a.a(m2, j2.bX, j2, false);
            for (BaseUnit am4 : ((List<BaseUnit>)m2)) {
                am4.posX = j2.posX;
                am4.posY = j2.posY;
                am4.posZ = j2.posZ;
                j2.C(am4);
            }
        }
        if (this.d) {
            j2.L();
        }
        if (this.e) {
            for (n3 = j2.B.size() - 1; n3 >= 0; --n3) {
                if (this.f != -1 && this.f != n3) continue;
                boolean bl2 = j2.B.size() % 2 == 0;
                j2.a((BaseUnit)j2.B.get(n3), true, bl2);
            }
        }
        if (this.g != null && (am3 = this.g.readUnit(j2)) != null && am3.bL && j2.d(am3, true)) {
            j2.C(j2);
        }
        return true;
    }
}

