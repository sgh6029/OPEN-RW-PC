/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamNetworking$P2PSessionError;
import com.codedisaster.steamworks.SteamNetworkingCallback;

class SteamNetworkingCallbackAdapter
extends SteamCallbackAdapter {
    SteamNetworkingCallbackAdapter(SteamNetworkingCallback steamNetworkingCallback) {
        super(steamNetworkingCallback);
    }

    void onP2PSessionConnectFail(long l2, int n2) {
        SteamID steamID = new SteamID(l2);
        ((SteamNetworkingCallback)this.callback).onP2PSessionConnectFail(steamID, SteamNetworking$P2PSessionError.byOrdinal(n2));
    }

    void onP2PSessionRequest(long l2) {
        SteamID steamID = new SteamID(l2);
        ((SteamNetworkingCallback)this.callback).onP2PSessionRequest(steamID);
    }
}

