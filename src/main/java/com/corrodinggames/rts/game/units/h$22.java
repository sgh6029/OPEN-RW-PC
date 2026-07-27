/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.h_f;
import com.corrodinggames.rts.gameFramework.GameEngine;

final class h$22
extends NoneAction {
    h$22(String string2) {
        super(string2);
    }

    @Override
    public String a() {
        return "Freeze high level AI logic (120secs)";
    }

    @Override
    public String b() {
        return "Freeze AI";
    }

    @Override
    public String d() {
        String string2 = "Freeze AI";
        GameEngine l2 = GameEngine.getInstance();
        h_f h2 = com.corrodinggames.rts.game.units.h_f.L();
        if (h2 != null) {
            int n2 = -1;
            if (h2.bX instanceof AIController) {
                AIController a2 = (AIController)h2.bX;
                n2 = (int)a2.bG / 60;
            }
            if (n2 > 0) {
                string2 = string2 + "(" + n2 + ")";
            }
        }
        return string2;
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        return am2.bX instanceof AIController;
    }
}

