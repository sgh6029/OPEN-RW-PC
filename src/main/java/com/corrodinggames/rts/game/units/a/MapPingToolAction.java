/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.a.CustomUnitToolAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.KeyBinding;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class MapPingToolAction
extends CustomUnitToolAction {
    public MapPingToolAction() {
        super("c__cut_ping");
    }

    @Override
    public String b() {
        return "Map Ping";
    }

    @Override
    public String a() {
        return "Send a map ping to your allies";
    }

    @Override
    public boolean c(BaseUnit am2, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.bS.I();
        return true;
    }

    @Override
    public KeyBinding M() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.bT.v;
    }
}

