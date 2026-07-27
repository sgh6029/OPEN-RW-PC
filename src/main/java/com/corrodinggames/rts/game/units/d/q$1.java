/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;
import com.corrodinggames.rts.gameFramework.h.a;

final class q$1
extends AbstractUnitAction {
    q$1(int n2) {
        super(n2);
    }

    @Override
    public String a() {
        return a.a("gui.actions.launchNuke", new Object[0]);
    }

    @Override
    public String b() {
        return a.a("gui.actions.launchNuke", new Object[0]);
    }

    @Override
    public int c() {
        return 0;
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        q q2 = (q)am2;
        return q2.c;
    }

    public UnitTypeEnum K() {
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
        q q2 = (q)am2;
        return q2.c > 0;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.K();
    }
}

