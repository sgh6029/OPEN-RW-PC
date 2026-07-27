/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.b;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.b.c;
import com.corrodinggames.rts.game.units.y;

final class c$2
extends NoneAction {
    c$2(int n2) {
        super(n2);
    }

    @Override
    public String a() {
        return "-Dive unit underwater.";
    }

    @Override
    public String b() {
        return "Dive";
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        return ((c)am2).r && ((y)am2).cJ();
    }
}

