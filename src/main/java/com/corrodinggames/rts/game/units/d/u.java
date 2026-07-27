/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.t;
import com.corrodinggames.rts.gameFramework.h.a;

class u
extends PopupQueueAction {
    public u() {
        super(t.g.getId());
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
        return a.a("gui.actions.upgradeT2", new Object[0]);
    }

    @Override
    public int c() {
        return UnitTypeEnum.seaFactory.c(2);
    }

    @Override
    public float K() {
        return 4.0E-4f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        t t2 = (t)am2;
        if (t2.r != 1 || t2.a(this.N(), bl2) > 0) {
            return false;
        }
        return super.a(am2, bl2);
    }

    @Override
    public boolean b(BaseUnit am2) {
        t t2 = (t)am2;
        return t2.r == 1;
    }

    public UnitTypeEnum L() {
        return null;
    }

    @Override
    public com.corrodinggames.rts.game.units.a.ActionDisplayType f() {
        return com.corrodinggames.rts.game.units.a.ActionDisplayType.upgrade;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.L();
    }
}

