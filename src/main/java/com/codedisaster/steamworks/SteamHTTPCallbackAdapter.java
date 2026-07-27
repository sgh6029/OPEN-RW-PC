/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamHTTP$HTTPStatusCode;
import com.codedisaster.steamworks.SteamHTTPCallback;
import com.codedisaster.steamworks.SteamHTTPRequestHandle;

class SteamHTTPCallbackAdapter
extends SteamCallbackAdapter {
    SteamHTTPCallbackAdapter(SteamHTTPCallback steamHTTPCallback) {
        super(steamHTTPCallback);
    }

    void onHTTPRequestCompleted(long l2, long l3, boolean bl2, int n2, int n3) {
        ((SteamHTTPCallback)this.callback).onHTTPRequestCompleted(new SteamHTTPRequestHandle(l2), l3, bl2, SteamHTTP$HTTPStatusCode.byValue(n2), n3);
    }

    void onHTTPRequestHeadersReceived(long l2, long l3) {
        ((SteamHTTPCallback)this.callback).onHTTPRequestHeadersReceived(new SteamHTTPRequestHandle(l2), l3);
    }

    void onHTTPRequestDataReceived(long l2, long l3, int n2, int n3) {
        ((SteamHTTPCallback)this.callback).onHTTPRequestDataReceived(new SteamHTTPRequestHandle(l2), l3, n2, n3);
    }
}

