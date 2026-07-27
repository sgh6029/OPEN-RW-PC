/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.b;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.b.d;
import com.corrodinggames.rts.gameFramework.h.a;

final class d$2
extends NoneAction {
    d$2(int n2) {
        super(n2);
    }

    @Override
    public String a() {
        return "-Stop unloading";
    }

    @Override
    public String b() {
        return a.a("gui.actions.cancel", new Object[0]);
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        return ((d)am2).g;
    }

    @Override
    public boolean b(BaseUnit am2) {
        return this.a(am2, false);
    }
}

