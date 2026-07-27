/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamLeaderboardEntriesHandle;
import com.codedisaster.steamworks.SteamLeaderboardHandle;
import com.codedisaster.steamworks.SteamResult;
import com.codedisaster.steamworks.SteamUserStatsCallback;

class SteamUserStatsCallbackAdapter
extends SteamCallbackAdapter {
    SteamUserStatsCallbackAdapter(SteamUserStatsCallback steamUserStatsCallback) {
        super(steamUserStatsCallback);
    }

    void onUserStatsReceived(long l2, long l3, int n2) {
        ((SteamUserStatsCallback)this.callback).onUserStatsReceived(l2, new SteamID(l3), SteamResult.byValue(n2));
    }

    void onUserStatsStored(long l2, int n2) {
        ((SteamUserStatsCallback)this.callback).onUserStatsStored(l2, SteamResult.byValue(n2));
    }

    void onUserStatsUnloaded(long l2) {
        ((SteamUserStatsCallback)this.callback).onUserStatsUnloaded(new SteamID(l2));
    }

    void onUserAchievementStored(long l2, boolean bl2, String string2, int n2, int n3) {
        ((SteamUserStatsCallback)this.callback).onUserAchievementStored(l2, bl2, string2, n2, n3);
    }

    void onLeaderboardFindResult(long l2, boolean bl2) {
        ((SteamUserStatsCallback)this.callback).onLeaderboardFindResult(new SteamLeaderboardHandle(l2), bl2);
    }

    void onLeaderboardScoresDownloaded(long l2, long l3, int n2) {
        ((SteamUserStatsCallback)this.callback).onLeaderboardScoresDownloaded(new SteamLeaderboardHandle(l2), new SteamLeaderboardEntriesHandle(l3), n2);
    }

    void onLeaderboardScoreUploaded(boolean bl2, long l2, int n2, boolean bl3, int n3, int n4) {
        ((SteamUserStatsCallback)this.callback).onLeaderboardScoreUploaded(bl2, new SteamLeaderboardHandle(l2), n2, bl3, n3, n4);
    }

    void onGlobalStatsReceived(long l2, int n2) {
        ((SteamUserStatsCallback)this.callback).onGlobalStatsReceived(l2, SteamResult.byValue(n2));
    }
}

