/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.c;

import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamNetworking$P2PSessionError;
import com.codedisaster.steamworks.SteamNetworkingCallback;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.java.c.JavaSteamEngine;
import com.corrodinggames.rts.java.c.SteamSocket;
import java.io.IOException;

public class SteamNetworkingCallbackHandler
implements SteamNetworkingCallback {
    JavaSteamEngine a;

    public SteamNetworkingCallbackHandler(JavaSteamEngine b2) {
        this.a = b2;
    }

    @Override
    public void onP2PSessionConnectFail(SteamID steamID, SteamNetworking$P2PSessionError steamNetworking$P2PSessionError) {
        GameEngine.log("onP2PSessionConnectFail:" + (Object)((Object)steamNetworking$P2PSessionError));
        SteamSocket k2 = (SteamSocket)this.a.l.get(steamID);
        if (k2 != null && !k2.isClosed()) {
            GameEngine.log("onP2PSessionConnectFail: closing active socket");
            // try {
                k2.close();
            // }
            // catch (IOException iOException) {
            //     iOException.printStackTrace();
            // }
        }
    }

    @Override
    public void onP2PSessionRequest(SteamID steamID) {
        GameEngine.log("onP2PSessionRequest:" + steamID);
        this.a.h.acceptP2PSessionWithUser(steamID);
    }
}

