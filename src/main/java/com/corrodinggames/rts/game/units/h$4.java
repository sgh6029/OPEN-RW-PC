/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;

final class h$4
extends NoneAction {
    h$4(String string2) {
        super(string2);
    }

    @Override
    public String a() {
        String string2 = "Hide interface till the screen is clicked/pressed";
        if (GameEngine.av()) {
            string2 = string2 + "\n-Enable mouse capture to also hide the mouse";
        }
        return string2;
    }

    @Override
    public String b() {
        return "Hide interface";
    }

    @Override
    public boolean c(BaseUnit am2, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.cU = true;
        return false;
    }
}

