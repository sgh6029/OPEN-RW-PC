/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.appFramework;

import com.corrodinggames.rts.appFramework.g;
import com.corrodinggames.rts.gameFramework.GameEngine;

class g$1
implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ g b;

    g$1(g g2, int n2) {
        this.b = g2;
        this.a = n2;
    }

    @Override
    public void run() {
        GameEngine.log("inner selectMenuOption: " + this.a);
        this.b.d(this.a);
    }
}

