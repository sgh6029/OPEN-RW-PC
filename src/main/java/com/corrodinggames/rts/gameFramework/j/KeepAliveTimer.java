/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.PacketData;
import java.io.IOException;
import java.util.TimerTask;

class KeepAliveTimer
extends TimerTask {
    private final NetworkEngine c;
    public boolean a = true;
    public long b = 0L;

    KeepAliveTimer(NetworkEngine ad2) {
        this.c = ad2;
    }

    @Override
    public void run() {
        try {
            long l2 = System.currentTimeMillis();
            if (this.c.au != 0L && (l2 > this.c.au + 5L || l2 < this.c.au)) {
                this.c.au = 0L;
                this.c.Q();
            }
            if (l2 > this.b + 1000L || l2 < this.b) {
                this.b = l2;
                if (this.a) {
                    GameOutputStream as2 = new GameOutputStream();
                    as2.a(System.currentTimeMillis());
                    as2.c(0);
                    PacketData au2 = as2.b(108);
                    this.c.g(au2);
                } else {
                    this.c.P();
                }
                this.a = !this.a;
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

