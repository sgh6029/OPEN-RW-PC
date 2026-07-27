/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;

final class h$14
extends NoneAction {
    h$14(String string2) {
        super(string2);
    }

    @Override
    public String a() {
        return "Clear save history";
    }

    @Override
    public String b() {
        GameEngine l2 = GameEngine.getInstance();
        return "Clear history";
    }

    @Override
    public boolean b(BaseUnit am2) {
        GameEngine l2 = GameEngine.getInstance();
        return l2.bl;
    }
}

