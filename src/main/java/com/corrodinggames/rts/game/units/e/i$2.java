/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.e;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.TransportUnitInterface;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.h.a;

final class i$2
extends NoneAction {
    i$2(int n2) {
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
        return ((TransportUnitInterface)((Object)am2)).bA();
    }

    @Override
    public boolean b(BaseUnit am2) {
        return this.a(am2, false);
    }
}

