/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.h.a;

public class PatrolAction
extends AbstractUnitAction {
    public PatrolAction() {
        super("c_9");
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return -1;
    }

    @Override
    public int c() {
        return 0;
    }

    public UnitTypeEnum w() {
        return null;
    }

    @Override
    public ActionType e() {
        return ActionType.patrol;
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
        return a.a("gui.actions.patrol.description", new Object[0]);
    }

    @Override
    public String b() {
        return a.a("gui.actions.patrol", new Object[0]);
    }

    @Override
    public boolean s() {
        return true;
    }

    @Override
    public float l() {
        if (!com.corrodinggames.rts.gameFramework.f.g.bP) {
            return 0.6f;
        }
        return 0.5f;
    }

    @Override
    public boolean h() {
        return true;
    }

    @Override
    public boolean o_() {
        return true;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.w();
    }
}

