/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.gameFramework.GameEngine;

final class h$10
extends NoneAction {
    h$10(String string2) {
        super(string2);
    }

    @Override
    public String a() {
        return "Show hidden unit information in tooltips including flags, ammo, tags and resources";
    }

    @Override
    public String b() {
        GameEngine l2 = GameEngine.getInstance();
        if (!l2.bl) {
            return "Debug: Off";
        }
        return "Debug: On";
    }
}

