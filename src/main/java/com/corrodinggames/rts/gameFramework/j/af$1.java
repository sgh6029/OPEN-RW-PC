/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.j.UdpDiscoveryHandler;
import java.util.TimerTask;

class af$1
extends TimerTask {
    final /* synthetic */ UdpDiscoveryHandler a;

    af$1(UdpDiscoveryHandler af2) {
        this.a = af2;
    }

    @Override
    public void run() {
        if (!this.a.d.C) {
            this.a.a();
        }
    }
}

