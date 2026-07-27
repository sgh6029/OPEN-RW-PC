/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;

final class h$8
extends NoneAction {
    h$8(String string2) {
        super(string2);
    }

    @Override
    public String a() {
        return "Fast Forward 1-5x";
    }

    @Override
    public String b() {
        GameEngine l2 = GameEngine.getInstance();
        return "Fast Forward: " + l2.bt;
    }

    @Override
    public boolean c(BaseUnit am2, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.cb.j()) {
            // empty if block
        }
        l2.bt = l2.bt == 1.0f ? 2.0f : (l2.bt == 2.0f ? 3.0f : (l2.bt == 3.0f ? 4.0f : (l2.bt == 4.0f ? 5.0f : (l2.bt == 5.0f ? 10.0f : 1.0f))));
        return false;
    }
}

