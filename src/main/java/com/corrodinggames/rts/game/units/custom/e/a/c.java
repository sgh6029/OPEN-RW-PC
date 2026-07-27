/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.e.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bb;
import com.corrodinggames.rts.game.units.custom.e.a.a;
import com.corrodinggames.rts.game.units.custom.e.b;

public class c
extends a {
    public c() {
        this.u = true;
        this.t = true;
        this.b = "credits";
        this.c = bb.a("$");
        this.o = true;
        this.q = com.corrodinggames.rts.game.units.custom.e.b.space;
    }

    @Override
    public double a(BaseUnit am2) {
        return am2.bX.o;
    }

    @Override
    public void a(BaseUnit am2, double d2) {
        am2.bX.o = d2;
    }

    @Override
    public void b(BaseUnit am2, double d2) {
        am2.bX.o += d2;
    }

    @Override
    public String a(boolean bl2) {
        return "$";
    }
}

