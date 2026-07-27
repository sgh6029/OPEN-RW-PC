/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamGameServerStatsCallback;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamResult;

class SteamGameServerStatsCallbackAdapter
extends SteamCallbackAdapter {
    SteamGameServerStatsCallbackAdapter(SteamGameServerStatsCallback steamGameServerStatsCallback) {
        super(steamGameServerStatsCallback);
    }

    void onStatsReceived(int n2, long l2) {
        ((SteamGameServerStatsCallback)this.callback).onStatsReceived(SteamResult.byValue(n2), new SteamID(l2));
    }

    void onStatsStored(int n2, long l2) {
        ((SteamGameServerStatsCallback)this.callback).onStatsStored(SteamResult.byValue(n2), new SteamID(l2));
    }

    void onStatsUnloaded(long l2) {
        ((SteamGameServerStatsCallback)this.callback).onStatsUnloaded(new SteamID(l2));
    }
}

