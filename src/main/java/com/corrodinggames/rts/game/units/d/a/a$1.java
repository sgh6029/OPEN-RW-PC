/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d.a;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.a.b;

final class a$1
extends PopupQueueAction {
    a$1(int n2) {
        super(n2);
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return "-Increases HP, attack damage, and range";
    }

    @Override
    public String b() {
        return "Upgrade";
    }

    @Override
    public int c() {
        return 1200;
    }

    @Override
    public float K() {
        return 0.001f;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        b b2 = (b)am2;
        if (b2.j || b2.a(this.N(), bl2) > 0) {
            return false;
        }
        return super.a(am2, bl2);
    }

    @Override
    public boolean b(BaseUnit am2) {
        b b2 = (b)am2;
        return !b2.j;
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

