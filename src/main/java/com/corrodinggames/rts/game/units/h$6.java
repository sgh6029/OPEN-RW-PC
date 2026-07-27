/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;

final class h$6
extends NoneAction {
    h$6(String string2) {
        super(string2);
    }

    @Override
    public String a() {
        return "Pause Game";
    }

    @Override
    public String b() {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.bt != 0.0f) {
            return "Pause: Off";
        }
        return "Pause: On";
    }

    @Override
    public boolean c(BaseUnit am2, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.cb.j()) {
            // empty if block
        }
        l2.bt = l2.bt != 0.0f ? 0.0f : 1.0f;
        return false;
    }
}

