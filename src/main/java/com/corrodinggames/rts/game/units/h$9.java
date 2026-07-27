/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.h_f;
import com.corrodinggames.rts.game.units.h$9$1;
import com.corrodinggames.rts.game.units.n;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import test.rudp.ReliableSocket;

final class h$9
extends NoneAction {
    h$9(String string2) {
        super(string2);
    }

    @Override
    public Texture_M j() {
        return com.corrodinggames.rts.game.units.h_f.g;
    }

    @Override
    public String a() {
        return "Search for units";
    }

    @Override
    public String b() {
        GameEngine l2 = GameEngine.getInstance();
        h_f h2 = com.corrodinggames.rts.game.units.h_f.L();
        if (h2 != null && h2.G == n.search) {
            return "Search: " + GameUtils.b(h2.H, 8);
        }
        return "Search units";
    }

    @Override
    public boolean c(BaseUnit am2, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.cb.i()) {
            l2.c("Reply active", "Changing search filter is currently not supported while recording a replay");
            return false;
        }
        h$9$1 h$9$1 = new h$9$1(this);
        h$9$1.b = "Search units by internal name or text title.";
        h$9$1.e = "Search units";
        h$9$1.f = "Search";
        h$9$1.g = "Cancel";
        NetworkEngine.a(h$9$1);
        return false;
    }
}

