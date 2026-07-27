/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamGameServerAPI;
import com.codedisaster.steamworks.SteamGameServerStatsCallback;
import com.codedisaster.steamworks.SteamGameServerStatsCallbackAdapter;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamInterface;

public class SteamGameServerStats
extends SteamInterface {
    public SteamGameServerStats(SteamGameServerStatsCallback steamGameServerStatsCallback) {
        super(SteamGameServerAPI.getSteamGameServerStatsPointer(), SteamGameServerStats.createCallback(new SteamGameServerStatsCallbackAdapter(steamGameServerStatsCallback)));
    }

    public SteamAPICall requestUserStats(SteamID steamID) {
        return new SteamAPICall(SteamGameServerStats.requestUserStats(this.pointer, steamID.handle));
    }

    public int getUserStatI(SteamID steamID, String string2, int n2) {
        int[] nArray = new int[1];
        if (SteamGameServerStats.getUserStat(this.pointer, steamID.handle, string2, nArray)) {
            return nArray[0];
        }
        return n2;
    }

    public float getUserStatF(SteamID steamID, String string2, float f2) {
        float[] fArray = new float[1];
        if (SteamGameServerStats.getUserStat(this.pointer, steamID.handle, string2, fArray)) {
            return fArray[0];
        }
        return f2;
    }

    public boolean getUserAchievement(SteamID steamID, String string2, boolean bl2) {
        boolean[] blArray = new boolean[1];
        if (SteamGameServerStats.getUserAchievement(this.pointer, steamID.handle, string2, blArray)) {
            return blArray[0];
        }
        return bl2;
    }

    public boolean setUserStatI(SteamID steamID, String string2, int n2) {
        return SteamGameServerStats.setUserStat(this.pointer, steamID.handle, string2, n2);
    }

    public boolean setUserStatF(SteamID steamID, String string2, float f2) {
        return SteamGameServerStats.setUserStat(this.pointer, steamID.handle, string2, f2);
    }

    public boolean updateUserAvgRateStat(SteamID steamID, String string2, float f2, double d2) {
        return SteamGameServerStats.updateUserAvgRateStat(this.pointer, steamID.handle, string2, f2, d2);
    }

    public boolean setUserAchievement(SteamID steamID, String string2) {
        return SteamGameServerStats.setUserAchievement(this.pointer, steamID.handle, string2);
    }

    public boolean clearUserAchievement(SteamID steamID, String string2) {
        return SteamGameServerStats.clearUserAchievement(this.pointer, steamID.handle, string2);
    }

    public SteamAPICall storeUserStats(SteamID steamID) {
        return new SteamAPICall(SteamGameServerStats.storeUserStats(this.pointer, steamID.handle));
    }

    private static native long createCallback(SteamGameServerStatsCallbackAdapter var0);

    private static native long requestUserStats(long var0, long var2);

    private static native boolean getUserStat(long var0, long var2, String var4, int[] var5);

    private static native boolean getUserStat(long var0, long var2, String var4, float[] var5);

    private static native boolean getUserAchievement(long var0, long var2, String var4, boolean[] var5);

    private static native boolean setUserStat(long var0, long var2, String var4, int var5);

    private static native boolean setUserStat(long var0, long var2, String var4, float var5);

    private static native boolean updateUserAvgRateStat(long var0, long var2, String var4, float var5, double var6);

    private static native boolean setUserAchievement(long var0, long var2, String var4);

    private static native boolean clearUserAchievement(long var0, long var2, String var4);

    private static native long storeUserStats(long var0, long var2);
}

