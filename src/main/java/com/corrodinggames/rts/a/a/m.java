/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.a.a;

import com.corrodinggames.rts.a.a.l;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;

public class m
extends l {
    public void a() {
        com.corrodinggames.rts.gameFramework.GameEngine.log("Unit Reference tests");
        com.corrodinggames.rts.game.units.custom.l l2 = com.corrodinggames.rts.game.units.custom.l.b;
        j j2 = com.corrodinggames.rts.game.units.custom.l.a(false, l2);
        j2.b(PlayerTeam.i);
        j j3 = com.corrodinggames.rts.game.units.custom.l.a(false, l2);
        j3.b(PlayerTeam.i);
        j3.posX = 2.0f;
        j j4 = com.corrodinggames.rts.game.units.custom.l.a(false, l2);
        j4.b(PlayerTeam.i);
        j4.posX = 3.0f;
        j j5 = com.corrodinggames.rts.game.units.custom.l.a(false, l2);
        j5.b(PlayerTeam.i);
        j5.posX = 3.0f;
        j3.C(j4);
        j3.C(j5);
        j j6 = com.corrodinggames.rts.game.units.custom.l.a(false, l2);
        j6.b(PlayerTeam.i);
        j j7 = com.corrodinggames.rts.game.units.custom.l.a(false, l2);
        j7.b(PlayerTeam.i);
        j j8 = com.corrodinggames.rts.game.units.custom.l.a(false, l2);
        j8.b(PlayerTeam.i);
        j2.bu = j6;
        j6.bv = j7;
        j4.bv = j7;
        j3.bu = j8;
        int n2 = 2;
        com.corrodinggames.rts.gameFramework.GameEngine.log("=== unit reference tests == (runs:" + n2 + ")");
        Long l3 = PerformanceProfiler.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            j j9 = j2;
            this.a(j9, this.a("self"), j9);
            this.a(j9, this.a("self.parent"), null);
            this.a("self.unknown", true);
            this.a(j9, this.a("self.parent"), null);
            this.a(j9, this.a("nullUnit"), null);
            this.a(j9, this.a("self.customTarget1"), j6);
            this.a(j9, this.a("self.customTarget1.customTarget2"), j7);
            this.a(j9, this.a("self.customTarget2"), null);
            this.a(j9, this.a("self.nullUnit"), null);
            this.a(j9, this.a("nullUnit.nullUnit"), null);
            this.a(j4, this.a("self.parent.customTarget1"), j8);
            this.a(j3, this.a("self.transporting(slot=0)"), j4);
            this.a(j3, this.a("self.transporting(SLOT=0)"), j4);
            this.a("self.transporting(MISS=0)", true);
            this.a(j3, this.a("self.transporting(slot=3)"), null);
            this.a(j3, this.a("self.transporting"), j4);
            this.a(j3, this.a("self.transporting(slot=0).customTarget2"), j7);
            this.a(j3, this.a("self.self.transporting(slot=0).customTarget2"), j7);
            this.a(j3, this.a("self.SELF.TRANsporting(slot=0).customTarget2"), j7);
            this.a(j3, this.a("self.SELF.transporting(slot=0).customTarget2"), j7);
            this.a(j9, this.a("self.nearestUnit(withinRange=500, withTag='test', relation='any')"));
            this.a("", true);
        }
        Long l4 = PerformanceProfiler.a();
        double d2 = PerformanceProfiler.a(l3, (long)l4);
        com.corrodinggames.rts.gameFramework.GameEngine.log("Took: " + d2);
    }

    public void a(String string2, boolean bl2) {
        try {
            com.corrodinggames.rts.game.units.custom.l l2 = com.corrodinggames.rts.game.units.custom.l.b;
            UnitReference unitReference = UnitReference.parseSingleUnitReferenceBlock(l2, string2);
        }
        catch (RuntimeException runtimeException) {
            if (runtimeException.getClass() != RuntimeException.class && runtimeException.getClass() != BooleanParseException.class) {
                throw new RuntimeException(runtimeException);
            }
            if (bl2) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("(debug)assertCreateError: " + string2 + " expected-error:" + runtimeException.getMessage());
            }
            return;
        }
        throw new RuntimeException("assertCreateError got no error for: " + string2);
    }

    public UnitReference a(String string2) {
        try {
            com.corrodinggames.rts.game.units.custom.l l2 = com.corrodinggames.rts.game.units.custom.l.b;
            UnitReference unitReference = UnitReference.parseSingleUnitReferenceBlock(l2, string2);
            if (unitReference == null) {
                throw new RuntimeException("Null when parsing [" + string2 + "]");
            }
            return unitReference;
        }
        catch (RuntimeException runtimeException) {
            throw new RuntimeException("Error: " + runtimeException.getMessage() + " parsing [" + string2 + "]", runtimeException);
        }
    }

    public void a(y y2, UnitReference unitReference, BaseUnit am2) {
        BaseUnit am3 = unitReference.get(y2);
        if (am3 != am2) {
            throw new RuntimeException("assertSame type expected:" + BaseUnit.A(am2) + " got: " + BaseUnit.A(am3));
        }
    }

    public void a(y y2, UnitReference unitReference) {
        BaseUnit am2 = unitReference.get(y2);
    }
}

