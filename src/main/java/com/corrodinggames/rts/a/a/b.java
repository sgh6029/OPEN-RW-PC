/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.a.a;

import com.corrodinggames.rts.a.a.l;

public class b
extends l {
    public void a() {
        this.b();
    }

    public void b() {
        com.corrodinggames.rts.gameFramework.GameEngine.log("networkSocks");
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        for (int i2 = 0; i2 < 10000; ++i2) {
            l2.networkEngine.b(false);
            try {
                Thread.sleep(50L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            l2.networkEngine.b("test");
        }
        com.corrodinggames.rts.gameFramework.GameEngine.log("done");
        try {
            Thread.sleep(100000L);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

