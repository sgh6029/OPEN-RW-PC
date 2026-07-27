/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.f;
import com.corrodinggames.rts.gameFramework.h.a;

final class f$1
extends PopupQueueAction {
    f$1(int n2) {
        super(n2);
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return "-Allows factory to build Tech 2 units";
    }

    @Override
    public String b() {
        return a.a("gui.actions.upgradeT2", new Object[0]);
    }

    @Override
    public int c() {
        return 1500;
    }

    @Override
    public float K() {
        return 5.0E-4f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        f f2 = (f)am2;
        if (f2.f || f2.a(this.N(), bl2) > 0) {
            return false;
        }
        return super.a(am2, bl2);
    }

    public UnitTypeEnum L() {
        return null;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.upgrade;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.L();
    }
}

