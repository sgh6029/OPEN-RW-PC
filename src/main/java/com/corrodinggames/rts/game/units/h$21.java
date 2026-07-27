/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;

final class h$21
extends AbstractUnitAction {
    h$21(String string2) {
        super(string2);
    }

    @Override
    public String a() {
        return "Create a nuke at a point";
    }

    @Override
    public String b() {
        return "Nuke at";
    }

    @Override
    public boolean h_() {
        return false;
    }

    @Override
    public int c() {
        return 0;
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return -1;
    }

    public UnitTypeEnum l_() {
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
        return this.l_();
    }
}

