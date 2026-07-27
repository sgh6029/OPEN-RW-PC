/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.a;

import com.corrodinggames.rts.game.units.a.UnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;

public class b
extends UnitAction {
    public UnitAction b;
    public com.corrodinggames.rts.game.units.custom.d.b c;
    public com.corrodinggames.rts.game.units.custom.d.b d;

    public b(UnitAction a2) {
        this.b = a2;
    }

    @Override
    public boolean b(BaseUnit am2) {
        return this.b.b(am2);
    }

    @Override
    public String c(BaseUnit am2) {
        return this.b.c(am2);
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        return this.b.a(am2, bl2);
    }

    @Override
    public boolean d(BaseUnit am2) {
        return this.b.d(am2);
    }

    @Override
    public com.corrodinggames.rts.game.units.custom.d.b a() {
        if (this.c != null) {
            return this.c;
        }
        return this.b.a();
    }

    @Override
    public com.corrodinggames.rts.game.units.custom.d.b b() {
        if (this.d != null) {
            return this.d;
        }
        return this.b.b();
    }

    @Override
    public void a(BaseUnit am2, BaseUnit am3) {
        this.b.a(am2, am3);
    }
}

