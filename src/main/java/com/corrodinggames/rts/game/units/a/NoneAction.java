/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;

public abstract class NoneAction
extends AbstractUnitAction {
    public NoneAction(int n2) {
        super(n2);
    }

    public NoneAction(String string2) {
        super(string2);
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return -1;
    }

    @Override
    public int c() {
        return 0;
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
    public boolean g() {
        return false;
    }

    @Override
    public boolean h() {
        return true;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.K();
    }
}

