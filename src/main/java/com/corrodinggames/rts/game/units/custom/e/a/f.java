/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.e.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bb;
import com.corrodinggames.rts.game.units.custom.e.a_f3;
import com.corrodinggames.rts.game.units.custom.e.a.a;

public class f
extends a_f3 {
    public f() {
        this.u = true;
        this.t = true;
        this.b = "shield";
        this.c = bb.a("shield");
    }

    @Override
    public double a(BaseUnit am2) {
        return am2.cx;
    }

    @Override
    public void a(BaseUnit am2, double d2) {
        am2.cx = (float)d2;
    }

    @Override
    public void b(BaseUnit am2, double d2) {
        am2.cx = (float)((double)am2.cx + d2);
    }
}

