/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.h_f;
import com.corrodinggames.rts.game.units.h$9;
import com.corrodinggames.rts.game.units.n;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.j.PasswordHandler;
import com.corrodinggames.rts.gameFramework.GameEngine;

class h$9$1
extends PasswordHandler {
    final /* synthetic */ h$9 a;

    h$9$1(h$9 var1_1) {
        this.a = var1_1;
    }

    @Override
    public void a(String string2) {
        GameEngine.log("Searching for: " + string2);
        GameEngine l2 = GameEngine.getInstance();
        if (l2.cb.i()) {
            l2.c("Reply active", "Changing search filter is currently not supported while recording a replay");
            return;
        }
        h_f h2 = h_f.L();
        if (h2 == null) {
            GameEngine.log("search: No editor");
            return;
        }
        if (string2 == null || string2.trim().equals("")) {
            GameEngine.log("search: No text entered");
            if (h2.G == n.search) {
                h2.G = n.all;
            }
            h2.H = null;
            h2.I = true;
            com.corrodinggames.rts.gameFramework.f.g.K();
            return;
        }
        h2.G = n.search;
        h2.H = string2;
        h2.I = true;
        com.corrodinggames.rts.gameFramework.f.g.K();
    }

    @Override
    public void a() {
    }
}

