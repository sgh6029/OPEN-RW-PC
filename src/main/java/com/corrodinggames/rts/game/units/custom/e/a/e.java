/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.e.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bb;
import com.corrodinggames.rts.game.units.custom.e.a.a;

public class e
extends a {
    public e() {
        this.u = true;
        this.t = true;
        this.b = "hp";
        this.c = bb.a("hp");
    }

    @Override
    public double a(BaseUnit am2) {
        return am2.cu;
    }

    @Override
    public void a(BaseUnit am2, double d2) {
        am2.o((float)d2);
    }

    @Override
    public void b(BaseUnit am2, double d2) {
        am2.o(am2.cu + (float)d2);
    }
}

