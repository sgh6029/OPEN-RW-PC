/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.h_f;
import com.corrodinggames.rts.game.units.h$3;
import com.corrodinggames.rts.gameFramework.GameEngine;

import test.rudp.ReliableSocket;

class h$3$1
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ h$3 b;

    h$3$1(h$3 var1_1, String string2) {
        this.b = var1_1;
        this.a = string2;
    }

    @Override
    public void run() {
        GameEngine l2 = GameEngine.getInstance();
        boolean bl2 = l2.cb.j();
        if (!bl2) {
            boolean bl3 = l2.bL.E;
            h_f h2 = h_f.L();
            boolean bl4 = l2.dq;
            boolean bl5 = l2.dr;
            l2.cb.h = true;
            l2.cb.c(this.a);
            l2.cb.h = false;
            l2.dq = bl4;
            l2.dr = bl5;
            h_f h3 = h_f.L();
            if (h3 != null && h2 != null) {
                h3.a(h2);
            } else {
                GameEngine.b("Failed copySettingsFromAnotherEditor");
            }
            l2.bv = true;
            if (l2.bL != null) {
                l2.bL.E = bl3;
            }
            l2.cU = true;
            if (h3 != null) {
                h3.M();
            }
        } else {
            GameEngine.log("stopPlaybackRunnable: Already started");
        }
    }
}

