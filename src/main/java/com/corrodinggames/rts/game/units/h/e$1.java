/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.h;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.h.e;

final class e$1
extends NoneAction {
    e$1(int n2) {
        super(n2);
    }

    @Override
    public String a() {
        return "-Surface unit. Allows it to fire missiles";
    }

    @Override
    public String b() {
        return "Surface";
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        return !((e)am2).a;
    }
}

