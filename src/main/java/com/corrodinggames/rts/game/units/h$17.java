/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;

final class h$17
extends AbstractUnitAction {
    h$17(String string2) {
        super(string2);
    }

    @Override
    public String a() {
        return "Clones units at point x50";
    }

    @Override
    public String b() {
        return "Unit Clone";
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
        return ActionType.targetGround;
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
    public boolean a(BaseUnit am2, boolean bl2) {
        return true;
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

