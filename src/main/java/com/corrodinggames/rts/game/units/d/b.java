/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.a_f;

class b
extends PopupQueueAction {
    public b() {
        super(a_f.h.getId());
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return "-Allows factory to build Tech 2 units";
    }

    @Override
    public String b() {
        return com.corrodinggames.rts.gameFramework.h.a.a("gui.actions.upgradeT2", new Object[0]);
    }

    @Override
    public int c() {
        return UnitTypeEnum.airFactory.c(2);
    }

    @Override
    public float K() {
        return 4.0E-4f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        a_f a2 = (a_f)am2;
        if (a2.f != 1 || a2.a(this.N(), bl2) > 0) {
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

