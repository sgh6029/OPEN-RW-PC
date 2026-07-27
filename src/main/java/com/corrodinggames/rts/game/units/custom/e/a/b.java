/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.e.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bb;
import com.corrodinggames.rts.game.units.custom.e.a.a;

public class b
extends a {
    public b() {
        this.u = true;
        this.t = true;
        this.b = "ammo";
        this.c = bb.a("ammo");
    }

    @Override
    public double a(BaseUnit am2) {
        return am2.cE;
    }

    @Override
    public void a(BaseUnit am2, double d2) {
        am2.cE = (int)d2;
    }

    @Override
    public void b(BaseUnit am2, double d2) {
        am2.cE = (int)((double)am2.cE + d2);
    }
}

