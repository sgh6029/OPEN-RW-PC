/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.h.a;

public class RepairTargetAction
extends AbstractUnitAction {
    public RepairTargetAction() {
        super("c_3");
    }

    @Override
    public String a() {
        return a.a("gui.actions.repairTarget", new Object[0]);
    }

    @Override
    public String b() {
        return a.a("gui.actions.repairTarget", new Object[0]);
    }

    @Override
    public int c() {
        return 0;
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return -1;
    }

    public UnitTypeEnum K() {
        return null;
    }

    @Override
    public ActionType e() {
        return ActionType.repairTarget;
    }

    @Override
    public boolean h_() {
        return true;
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
        return this.K();
    }
}

