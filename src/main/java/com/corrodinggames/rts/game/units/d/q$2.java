/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.q;
import com.corrodinggames.rts.gameFramework.h.a;

final class q$2
extends PopupQueueAction {
    q$2(int n2) {
        super(n2);
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return a.a("gui.actions.buildNuke.description", new Object[0]);
    }

    @Override
    public String b() {
        return a.a("gui.actions.buildNuke", new Object[0]);
    }

    @Override
    public int c() {
        return 11000;
    }

    @Override
    public float K() {
        return 3.0E-4f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        q q2 = (q)am2;
        float f2 = q2.c + q2.a(this.N(), bl2);
        if (f2 >= 4.0f) {
            return false;
        }
        return super.a(am2, bl2);
    }

    public UnitTypeEnum L() {
        return null;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.queueUnit;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.L();
    }
}

