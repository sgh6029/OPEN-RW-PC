/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.b;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.b.c;

final class c$1
extends NoneAction {
    c$1(int n2) {
        super(n2);
    }

    @Override
    public String a() {
        return "-Surface unit.";
    }

    @Override
    public String b() {
        return "Fly";
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        return !((c)am2).r;
    }
}

