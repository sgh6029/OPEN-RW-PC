/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.GameEngine;

class l$3
extends Thread {
    final /* synthetic */ GameEngine a;

    l$3(GameEngine l2) {
        this.a = l2;
    }

    @Override
    public void run() {
        try {
            l$3.sleep(3000L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        this.a.ab();
    }
}

