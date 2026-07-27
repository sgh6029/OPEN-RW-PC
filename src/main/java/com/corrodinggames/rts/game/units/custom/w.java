/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.v;

public class w
extends v {
    @Override
    public void a() throws bo {
        if (!this.e) {
            this.d = l.n(this.c);
            if (this.d == null) {
                throw new bo("Could not find customUnit target:" + this.d() + " used on:" + this.a + " in section:" + this.b);
            }
        }
    }

    public l e() {
        return (l)this.d;
    }

    @Override
    public /* synthetic */ UnitType c() {
        return this.e();
    }
}

