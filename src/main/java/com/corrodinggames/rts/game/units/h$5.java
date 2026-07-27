/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.h_f;

final class h$5
extends NoneAction {
    h$5(String string2) {
        super(string2);
    }

    @Override
    public String a() {
        return "Freeze full high level logic for all AI forever";
    }

    @Override
    public String b() {
        return "Freeze AI";
    }

    @Override
    public String d() {
        boolean bl2;
        String string2 = "Freeze AI";
        h_f h2 = com.corrodinggames.rts.game.units.h_f.L();
        if (h2 != null && (bl2 = h2.c)) {
            string2 = "Unfreeze AIs";
        }
        return string2;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        return true;
    }
}

