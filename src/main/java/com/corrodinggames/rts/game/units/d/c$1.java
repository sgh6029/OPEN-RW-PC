/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.c;
import com.corrodinggames.rts.gameFramework.h.a;

final class c$1
extends AbstractUnitAction {
    c$1(int n2) {
        super(n2);
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return "";
    }

    @Override
    public String b() {
        return a.a("gui.actions.antiNukeCount", new Object[0]);
    }

    @Override
    public int c() {
        return 0;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        return this.b(am2, false) != 0;
    }

    public UnitTypeEnum K() {
        return null;
    }

    @Override
    public ActionType e() {
        return ActionType.none;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.none;
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        c c2 = (c)am2;
        return c2.d;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.K();
    }
}

