/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game;

import com.corrodinggames.rts.game.GameLogic;

class i$a
extends Thread {
    final /* synthetic */ GameLogic a;

    i$a(GameLogic i2) {
        this.a = i2;
    }

    @Override
    public void run() {
        this.a.networkEngine.b("gotoNextLevel");
    }
}

