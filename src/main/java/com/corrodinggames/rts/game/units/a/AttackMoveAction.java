/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;

public class AttackMoveAction
extends AbstractUnitAction {
    public AttackMoveAction() {
        super("c_4");
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return -1;
    }

    @Override
    public int c() {
        return 0;
    }

    public UnitTypeEnum n() {
        return null;
    }

    @Override
    public ActionType e() {
        return ActionType.attackMove;
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
    public String a() {
        return "Attack Move";
    }

    @Override
    public String b() {
        return "Attack Move";
    }

    @Override
    public boolean h_() {
        return false;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.n();
    }
}

