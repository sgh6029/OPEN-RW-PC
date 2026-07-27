/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.b;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.b.d;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.h.a;

final class d$1
extends NoneAction {
    d$1(int n2) {
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
        return ((d)am2).o.size();
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        if (((d)am2).g) {
            return false;
        }
        return !((y)am2).cK() && ((d)am2).o.size() > 0;
    }
}

