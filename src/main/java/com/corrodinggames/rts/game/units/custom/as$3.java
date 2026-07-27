/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.as;
import com.corrodinggames.rts.game.units.custom.aw;
import com.corrodinggames.rts.game.units.custom.j;

final class as$3
extends aw {
    as$3(int n2, String string2) {
        super(n2, string2);
    }

    @Override
    public double a(as as2) {
        return as2.e;
    }

    @Override
    public void a(as as2, double d2) {
        as2.e = (float)d2;
    }

    @Override
    public void a(j j2, double d2) {
        super.a(j2, d2);
        j2.aW();
    }
}

