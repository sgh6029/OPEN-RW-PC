/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;

final class h$13
extends NoneAction {
    h$13(String string2) {
        super(string2);
    }

    @Override
    public String a() {
        return "For debugging autoTriggers. When enabled will log a message when any auto triggers fire on any selected units";
    }

    @Override
    public String b() {
        GameEngine l2 = GameEngine.getInstance();
        if (!l2.bn) {
            return "Trigger Debug: Off";
        }
        return "Trigger Debug: On";
    }

    @Override
    public boolean b(BaseUnit am2) {
        GameEngine l2 = GameEngine.getInstance();
        return l2.bl;
    }
}

