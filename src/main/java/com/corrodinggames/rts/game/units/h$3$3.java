/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.h_f;
import com.corrodinggames.rts.game.units.h$3;
import com.corrodinggames.rts.gameFramework.GameEngine;

class h$3$3
implements Runnable {
    final /* synthetic */ h$3 a;

    h$3$3(h$3 h$3) {
        this.a = h$3;
    }

    @Override
    public void run() {
        GameEngine l2 = GameEngine.getInstance();
        boolean bl2 = l2.cb.j();
        if (!bl2) {
            GameEngine.log("stopPlaybackRunnable: Already stopped");
        } else {
            l2.cb.e();
            l2.bt = 1.0f;
            l2.bv = true;
            h_f h2 = h_f.L();
            if (h2 != null) {
                l2.bs = h2.bX;
            }
        }
    }
}

