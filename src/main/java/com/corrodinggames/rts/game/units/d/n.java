/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.m;
import com.corrodinggames.rts.gameFramework.h.a;

class n
extends PopupQueueAction {
    public n() {
        super(m.h.getId());
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return a.a("units.landFactory.upgrade.description", new Object[0]);
    }

    @Override
    public String b() {
        return a.a("units.landFactory.upgrade.name", new Object[0]);
    }

    @Override
    public int c() {
        return UnitTypeEnum.landFactory.c(2);
    }

    @Override
    public float K() {
        return 4.0E-4f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        m m2 = (m)am2;
        if (m2.g || m2.a(this.N(), bl2) > 0) {
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

