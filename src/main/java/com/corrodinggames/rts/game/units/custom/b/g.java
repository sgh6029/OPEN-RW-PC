/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.b;

import com.corrodinggames.rts.game.units.custom.b.c;
import com.corrodinggames.rts.game.units.custom.b.d;
import com.corrodinggames.rts.game.units.custom.b.f;

import java.io.IOException;

import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.t;
import com.corrodinggames.rts.gameFramework.utility.m;

public class g
extends t {
    String a;
    m b = new m();

    public g(String string2) {
        this.a = string2;
    }

    @Override
    public void a(l l2) throws bo {
        if (this.a != null) {
            String[] stringArray;
            for (String string2 : stringArray = this.a.split(",")) {
                d d2 = c.b(l2, string2 = string2.trim());
                if (d2 == null) {
                    throw new bo("Failed to find decal: " + string2);
                }
                this.b.add(d2);
            }
            this.a = null;
        }
    }

    public void a(j j2, float f2, float f3) throws IOException {
        c.i.a(f2, f3);
        c.a(j2, 0.0f, f.inactive, this.b, c.i);
    }
}

