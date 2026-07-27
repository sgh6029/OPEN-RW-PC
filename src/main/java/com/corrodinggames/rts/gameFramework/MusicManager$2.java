/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.MusicManager;

class MusicManager$2
extends Thread {
    final /* synthetic */ MusicManager a;

    MusicManager$2(MusicManager am2) {
        this.a = am2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Object object = this.a.b;
        synchronized (object) {
            if (this.a.l) {
                this.a.k.b();
                if (!this.a.C) {
                    this.a.k.a(this.a.a(), this.a.a());
                }
            }
            if (this.a.B) {
                this.a.A.b();
            }
        }
    }
}

