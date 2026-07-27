/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.p;
import com.corrodinggames.rts.gameFramework.h.a;

final class p$1
extends PopupQueueAction {
    p$1(int n2) {
        super(n2);
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return a.a("units.laserDefence.upgrade.description", new Object[0]);
    }

    @Override
    public String b() {
        return a.a("units.laserDefence.upgrade.name", new Object[0]);
    }

    @Override
    public int c() {
        return UnitTypeEnum.laserDefence.c(2);
    }

    @Override
    public float K() {
        return 3.0E-4f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        p p2 = (p)am2;
        if (p2.d || p2.a(this.N(), bl2) > 0) {
            return false;
        }
        return super.a(am2, bl2);
    }

    @Override
    public boolean b(BaseUnit am2) {
        p p2 = (p)am2;
        return !p2.d;
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

