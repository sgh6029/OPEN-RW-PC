/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

class k_f
extends Thread {
    boolean a = true;

    k_f() {
    }

    @Override
    public void run() {
        while (this.a) {
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            FileChangeEngine.b();
        }
    }
}

