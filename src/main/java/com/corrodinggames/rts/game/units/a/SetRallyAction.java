/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.h.a;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

public class SetRallyAction
extends AbstractUnitAction {
    public SetRallyAction() {
        super("c_1");
    }

    @Override
    public String a() {
        return a.a("gui.actions.setRally.description", new Object[0]);
    }

    @Override
    public String b() {
        return a.a("gui.actions.setRally", new Object[0]);
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
        return ActionType.setRally;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.rally;
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public Texture_M j() {
        return GameEngine.getInstance().bS.bj;
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

