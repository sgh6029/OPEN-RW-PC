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
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.h.a;

public class ReclaimTargetAction
extends AbstractUnitAction {
    boolean a;

    public ReclaimTargetAction(boolean bl2) {
        super("c_2");
        this.a = bl2;
    }

    @Override
    public String a() {
        if (!this.a) {
            return com.corrodinggames.rts.gameFramework.h.a.a("gui.actions.reclaimBuildingTarget.description", new Object[0]);
        }
        return com.corrodinggames.rts.gameFramework.h.a.a("gui.actions.reclaimTarget.description", new Object[0]);
    }

    @Override
    public String b() {
        if (!this.a) {
            return com.corrodinggames.rts.gameFramework.h.a.a("gui.actions.reclaimBuildingTarget", new Object[0]);
        }
        return com.corrodinggames.rts.gameFramework.h.a.a("gui.actions.reclaimTarget", new Object[0]);
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
        return ActionType.reclaimTarget;
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
    public boolean o(BaseUnit am2) {
        if (am2 == null) {
            return true;
        }
        if (!this.a) {
            return am2.bI();
        }
        return true;
    }

    @Override
    public float l() {
        if (!com.corrodinggames.rts.gameFramework.f.g.bP) {
            return 0.6f;
        }
        return 1.0f;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.K();
    }
}

