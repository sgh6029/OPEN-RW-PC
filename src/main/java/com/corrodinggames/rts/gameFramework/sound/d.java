/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.sound;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.sound.a;
import com.corrodinggames.rts.gameFramework.sound.c;

public class d
extends Thread {
    final /* synthetic */ a a;

    public d(a a2) {
        this.a = a2;
    }

    @Override
    public void run() {
        GameEngine.aq();
        try {
            while (true) {
                c c2 = (c)this.a.a.take();
                c2.a();
                this.a.c.a(c2);
            }
        }
        catch (InterruptedException interruptedException) {
            return;
        }
    }
}

