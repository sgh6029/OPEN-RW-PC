/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamGameServerAPI$ServerMode;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamSharedLibraryLoader;

public class SteamGameServerAPI {
    private static boolean isRunning = false;

    public static boolean init(int n2, short s2, short s3, short s4, SteamGameServerAPI$ServerMode steamGameServerAPI$ServerMode, String string2) {
        return SteamGameServerAPI.init(null, n2, s2, s3, s4, steamGameServerAPI$ServerMode, string2);
    }

    public static boolean init(String string2, int n2, short s2, short s3, short s4, SteamGameServerAPI$ServerMode steamGameServerAPI$ServerMode, String string3) {
        try {
            SteamSharedLibraryLoader.loadLibraries(string2);
        } catch (SteamException e) {
            e.printStackTrace();
        }
        isRunning = SteamGameServerAPI.nativeInit(n2, s2, s3, s4, steamGameServerAPI$ServerMode.ordinal(), string3);
        return isRunning;
    }

    public static void shutdown() {
        isRunning = false;
        SteamGameServerAPI.nativeShutdown();
    }

    public static SteamID getSteamID() {
        return new SteamID(SteamGameServerAPI.nativeGetSteamID());
    }

    private static native boolean nativeInit(int var0, short var1, short var2, short var3, int var4, String var5);

    private static native void nativeShutdown();

    public static native void runCallbacks();

    public static native boolean isSecure();

    private static native long nativeGetSteamID();

    static native long getSteamGameServerPointer();

    static native long getSteamGameServerNetworkingPointer();

    static native long getSteamGameServerStatsPointer();

    static native long getSteamGameServerHTTPPointer();
}

