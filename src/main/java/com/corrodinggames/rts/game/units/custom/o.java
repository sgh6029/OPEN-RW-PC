/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import java.util.List;

import com.corrodinggames.rts.game.units.custom.f_f6;
import com.corrodinggames.rts.game.units.custom.l;

public class o {
    String a;
    f_f6 b;
    final /* synthetic */ l c;

    public o(l l2) {
        this.c = l2;
    }

    public void a() {
        if (this.a != null && this.b() == null) {
            throw new RuntimeException("Failed to find animation:" + this.a);
        }
    }

    public f_f6 b() {
        if (this.a == null) {
            return null;
        }
        if (this.b != null) {
            return this.b;
        }
        for (f_f6 f2 : ((List<f_f6>) this.c.dr)) {
            if (!f2.a.equalsIgnoreCase(this.a))
                continue;
            this.b = f2;
            return f2;
        }
        return null;
    }
}
