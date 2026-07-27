/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;

class q
extends AbstractUnitAction {
    r a;

    public q(r r2) {
        super("SetTerrainType" + r2.ordinal());
        this.a = r2;
    }

    @Override
    public boolean b(BaseUnit am2) {
        h_f h2 = com.corrodinggames.rts.game.units.h_f.L();
        if (h2 != null) {
            return h2.G == n.terrain;
        }
        return true;
    }

    @Override
    public String a() {
        return "Set terrain type to: " + this.a.name();
    }

    @Override
    public String b() {
        return "Set " + this.a.name();
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

    public UnitTypeEnum n() {
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
    public boolean o() {
        return true;
    }

    @Override
    public boolean a(float f2, float f3) {
        return true;
    }

    @Override
    public boolean p() {
        return true;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.n();
    }
}

