/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.gameFramework.GameEngine;

final class h$11
extends NoneAction {
    h$11(String string2) {
        super(string2);
    }

    @Override
    public String a() {
        return "AI debug view";
    }

    @Override
    public String b() {
        GameEngine l2 = GameEngine.getInstance();
        if (!AIController.as) {
            return "AI Debug: Off";
        }
        return "AI Debug: On";
    }
}

