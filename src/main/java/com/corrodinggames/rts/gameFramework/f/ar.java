/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.f.au;
import com.corrodinggames.rts.gameFramework.h.a;

class ar
extends au {
    UnitType a;
    int b;

    public ar(float f2, float f3, UnitType as2) {
        super(f2, f3);
        this.a = as2;
        this.b = 1;
    }

    @Override
    public boolean a(au au2) {
        if (super.a(au2) && au2 instanceof ar) {
            ar ar2 = (ar)au2;
            return ar2.a == this.a;
        }
        return false;
    }

    @Override
    public void b(au au2) {
        this.c = au2.c;
        ++this.b;
        this.g = null;
        this.h = false;
    }

    @Override
    public String a() {
        if (this.g == null) {
            String string2 = "gui.log.unitCreated";
            if (this.a.j()) {
                string2 = "gui.log.buildingConstructed";
            }
            this.g = String.format(com.corrodinggames.rts.gameFramework.h.a.a(string2, new Object[0]), this.a.e(), this.b);
        }
        return this.g;
    }
}

