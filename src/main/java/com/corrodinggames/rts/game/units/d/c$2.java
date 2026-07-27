/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.c;
import com.corrodinggames.rts.gameFramework.h.a;

final class c$2
extends PopupQueueAction {
    c$2(int n2) {
        super(n2);
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return a.a("gui.actions.buildAntiNuke.description", new Object[0]);
    }

    @Override
    public String b() {
        return a.a("gui.actions.buildAntiNuke", new Object[0]);
    }

    @Override
    public int c() {
        return 4000;
    }

    @Override
    public float K() {
        return 7.0E-4f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        c c2 = (c)am2;
        float f2 = c2.d + c2.a(this.N(), bl2);
        if (f2 >= 12.0f) {
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

