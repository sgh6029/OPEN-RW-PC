/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.d;

import com.corrodinggames.rts.game.units.BaseUnit;

public abstract class a {
    public abstract void a(BaseUnit var1);

    public abstract boolean b(BaseUnit var1);

    public abstract void a(BaseUnit var1, double var2);

    public abstract boolean b(BaseUnit var1, double var2);

    public boolean c(BaseUnit am2) {
        if (this.b(am2)) {
            this.a(am2);
            return true;
        }
        return false;
    }

    public boolean c(BaseUnit am2, double d2) {
        if (this.b(am2, d2)) {
            this.a(am2, d2);
            return true;
        }
        return false;
    }
}

