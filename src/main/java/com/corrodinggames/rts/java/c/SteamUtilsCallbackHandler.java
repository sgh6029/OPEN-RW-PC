/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.c;

import com.codedisaster.steamworks.SteamUtilsCallback;
import com.corrodinggames.rts.java.c.JavaSteamEngine;

public class SteamUtilsCallbackHandler
implements SteamUtilsCallback {
    final /* synthetic */ JavaSteamEngine a;

    public SteamUtilsCallbackHandler(JavaSteamEngine b2) {
        this.a = b2;
    }

    @Override
    public void onSteamShutdown() {
    }
}

