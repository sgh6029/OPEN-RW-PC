/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.a_f5;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.z;

class b_f
extends a_f5 {
    public z e;
    public float f;
    public float g;
    public boolean h;

    public b_f(float f2, float f3) {
        super(f2, f3);
    }

    public void a(l l2, String string2, String string3) throws bo {
        try {
            if (string2.equalsIgnoreCase("x")) {
                this.f = Float.parseFloat(string3);
                return;
            }
            if (string2.equalsIgnoreCase("y")) {
                this.g = Float.parseFloat(string3);
                return;
            }
        }
        catch (NumberFormatException numberFormatException) {
            throw new bo("Failed to parse float:" + string3);
        }
        if (string2.equalsIgnoreCase("name")) {
            this.e = l2.a(string3, (z)null);
            return;
        }
        throw new bo("Unknown event key:" + string2 + " on animation");
    }

    public void finalize() throws bo {
        this.h = true;
        if (this.e == null) {
            throw new bo("Animation effect missing key 'name'");
        }
    }

    public void a(j j2) {
        if (this.e != null) {
            float f2 = j2.posX;
            float f3 = j2.posY;
            this.e.a(f2 += this.f, f3 += this.g, j2.posZ, j2.cg, j2);
        }
    }
}

