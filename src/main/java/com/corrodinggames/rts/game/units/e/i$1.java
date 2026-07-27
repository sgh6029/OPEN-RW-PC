/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.e;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.TransportUnitInterface;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.h.a;

final class i$1
extends NoneAction {
    i$1(int n2) {
        super(n2);
    }

    @Override
    public String a() {
        return "-Will unload all units when stopped";
    }

    @Override
    public String b() {
        return a.a("gui.actions.unload", new Object[0]);
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return ((TransportUnitInterface)((Object)am2)).bB();
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        if (((TransportUnitInterface)((Object)am2)).bA()) {
            return false;
        }
        return ((TransportUnitInterface)((Object)am2)).f() && ((TransportUnitInterface)((Object)am2)).bB() > 0;
    }

    @Override
    public boolean b(BaseUnit am2) {
        return ((TransportUnitInterface)((Object)am2)).j();
    }
}

