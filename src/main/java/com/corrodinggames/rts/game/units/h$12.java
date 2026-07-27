/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;

final class h$12
extends AbstractUnitAction {
    h$12(String string2) {
        super(string2);
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        return !com.corrodinggames.rts.game.units.h_f.w();
    }

    @Override
    public String a() {
        return "Reload data only for active units on map (for modding). This is a faster than reload but will be incomplete.";
    }

    @Override
    public String b() {
        return "Quick reload";
    }

    @Override
    public int c() {
        return 0;
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return -1;
    }

    public UnitTypeEnum k() {
        return null;
    }

    @Override
    public ActionType e() {
        return ActionType.none;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.action;
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public boolean h() {
        return true;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.k();
    }
}

