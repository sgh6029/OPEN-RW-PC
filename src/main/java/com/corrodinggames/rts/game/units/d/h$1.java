/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.h;
import com.corrodinggames.rts.gameFramework.h.a;

final class h$1
extends PopupQueueAction {
    h$1(int n2) {
        super(n2);
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return a.a("units.fabricator.upgrade.description", new Object[0]);
    }

    @Override
    public String b() {
        return a.a("units.fabricator.upgrade.name", new Object[0]);
    }

    @Override
    public int c() {
        return UnitTypeEnum.fabricator.c(2);
    }

    @Override
    public float K() {
        return 3.0E-4f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        h h2 = (h)am2;
        if (h2.r != 1 || h2.a(this.N(), bl2) > 0) {
            return false;
        }
        return super.a(am2, bl2);
    }

    @Override
    public boolean b(BaseUnit am2) {
        h h2 = (h)am2;
        return h2.r == 1;
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

