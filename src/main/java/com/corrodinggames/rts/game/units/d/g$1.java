/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.g;
import com.corrodinggames.rts.gameFramework.h.a;

final class g$1
extends PopupQueueAction {
    g$1(int n2) {
        super(n2);
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return a.a("units.extractor.upgrade.description", new Object[0]);
    }

    @Override
    public String b() {
        return a.a("gui.actions.upgradeT2", new Object[0]);
    }

    @Override
    public int c() {
        return UnitTypeEnum.extractor.c(2);
    }

    @Override
    public float K() {
        return 6.0E-4f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        g g2 = (g)am2;
        if (g2.b != 1 || g2.a(this.N(), bl2) > 0) {
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

