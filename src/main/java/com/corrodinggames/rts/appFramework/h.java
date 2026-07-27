/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.appFramework;

import com.corrodinggames.rts.appFramework.g;
import com.corrodinggames.rts.gameFramework.GameEngine;

class h
implements Runnable {
    public String a;
    final /* synthetic */ g b;

    h(g g2) {
        this.b = g2;
    }

    @Override
    public void run() {
        GameEngine l2 = GameEngine.getInstance();
        l2.L();
        l2.ca.b(this.a, false);
        l2.J();
        if (this.b.e != null && this.b.e.isShowing()) {
            this.b.b(0);
        }
    }
}

