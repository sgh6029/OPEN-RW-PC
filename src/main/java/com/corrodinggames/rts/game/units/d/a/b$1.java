/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d.a;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.a.b;
import com.corrodinggames.rts.gameFramework.h.a;

final class b$1
extends PopupQueueAction {
    b$1(int n2) {
        super(n2);
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return "-Increases HP, attack damage, and range";
    }

    @Override
    public String b() {
        return a.a("gui.actions.upgradeToGunT2", new Object[0]);
    }

    @Override
    public int c() {
        return 1000;
    }

    @Override
    public float K() {
        return 0.001f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        b b2 = (b)am2;
        if (b2.M() != 1 || b2.a(AbstractUnitAction.NONE_ACTION_ID, bl2) > 0) {
            return false;
        }
        return super.a(am2, bl2);
    }

    @Override
    public boolean b(BaseUnit am2) {
        b b2 = (b)am2;
        return b2.M() == 1;
    }

    public UnitTypeEnum L() {
        return null;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.upgrade;
    }

    @Override
    public void f(BaseUnit am2) {
        b b2 = (b)am2;
        b2.b(b.u);
        b.a(b2);
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.L();
    }
}

