/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.v;
import com.corrodinggames.rts.gameFramework.h.a;

final class v$1
extends PopupQueueAction {
    v$1(int n2) {
        super(n2);
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return a.a("units.supplyDepot.upgrade.description", new Object[0]);
    }

    @Override
    public String b() {
        return a.a("units.supplyDepot.upgrade.name", new Object[0]);
    }

    @Override
    public int c() {
        return 1000;
    }

    @Override
    public float K() {
        return 4.0E-4f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        v v2 = (v)am2;
        if (v2.f != 1 || v2.a(this.N(), bl2) > 0) {
            return false;
        }
        return super.a(am2, bl2);
    }

    public UnitTypeEnum L() {
        return null;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.upgrade;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.L();
    }
}

