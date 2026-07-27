/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.SocketConnector;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;

class ad$8
implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ NetworkEngine b;

    ad$8(NetworkEngine ad2, boolean bl2) {
        this.b = ad2;
        this.a = bl2;
    }

    @Override
    public void run() {
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.log("startJoinServerInternalThread callback");
        SocketConnector an2 = this.b.bF;
        this.b.bF = null;
        if (an2 == null) {
            GameEngine.log("startJoinServerInternalThread callback gameConnector==null");
            return;
        }
        if (an2.errorMessage != null) {
            GameEngine.log("startJoinServerInternalThread failed to connect: " + an2.errorMessage);
            if (this.a) {
                l2.networkEngine.b("Reconnect failed: " + an2.errorMessage);
                this.b.b("Reconnect failed", "reconnect failed");
                l2.d("Reconnect failed", "Reconnect failed: " + an2.errorMessage);
                l2.i("Reconnect failed: " + an2.errorMessage);
            }
            return;
        }
        try {
            l2.networkEngine.b("starting new");
            l2.networkEngine.a(an2.connectedSocket);
        }
        catch (IOException iOException) {
            String string2 = iOException.getMessage();
            l2.c(string2, "Connection failed");
            iOException.printStackTrace();
        }
    }
}

