/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.h_f;
import com.corrodinggames.rts.game.units.h$2;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;

class h$2$1
implements Runnable {
    final /* synthetic */ h$2 a;

    h$2$1(h$2 var1_1) {
        this.a = var1_1;
    }

    @Override
    public void run() {
        GameEngine l2 = GameEngine.getInstance();
        boolean bl2 = l2.cb.k();
        if (!bl2) {
            h_f h2 = h_f.L();
            l2.bS.e = true;
            if (!l2.networkEngine.B) {
                long l3 = l2.networkEngine.w;
                l2.networkEngine.o = true;
                int n2 = l2.networkEngine.ay.d;
                l2.networkEngine.R();
                l2.networkEngine.ay.d = n2;
                l2.networkEngine.w = l3;
                l2.networkEngine.aW = true;
                l2.bx = 0;
                l2.networkEngine.X = l2.bx + 1;
                l2.networkEngine.w();
            }
            String string2 = "[sandbox]" + l2.al() + " [v" + l2.getVersionNumber() + "] (" + GameUtils.a("d MMM yyyy HH.mm.ss") + ").replay";
            l2.cb.d(string2);
            l2.bS.e = false;
            GameEngine.f(null, "Replay started as: " + string2);
            h_f h3 = h_f.L();
            if (h3 != null && h2 != null) {
                h3.a(h2);
                h3.r = string2;
            } else {
                GameEngine.b("Failed copySettingsFromAnotherEditor");
            }
        } else {
            l2.cb.e();
        }
    }
}

