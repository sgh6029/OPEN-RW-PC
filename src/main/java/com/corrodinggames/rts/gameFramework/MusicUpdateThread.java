/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.MusicManager;

class MusicUpdateThread
extends Thread {
    final /* synthetic */ MusicManager a;

    MusicUpdateThread(MusicManager am2) {
        this.a = am2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        while (true) {
            float f2 = 1.0f;
            Object object = this.a.c;
            synchronized (object) {
                this.a.g = true;
                if (!this.a.f) {
                    try {
                        this.a.c.wait(MusicManager.a.e());
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                    }
                }
                this.a.f = false;
                f2 = this.a.d;
            }
            object = this.a.b;
            synchronized (object) {
                if (!this.a.b(f2)) {
                    return;
                }
            }
        }
    }
}

