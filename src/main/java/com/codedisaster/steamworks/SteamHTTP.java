/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamGameServerAPI;
import com.codedisaster.steamworks.SteamHTTP$API;
import com.codedisaster.steamworks.SteamHTTP$HTTPMethod;
import com.codedisaster.steamworks.SteamHTTPCallback;
import com.codedisaster.steamworks.SteamHTTPCallbackAdapter;
import com.codedisaster.steamworks.SteamHTTPRequestHandle;
import com.codedisaster.steamworks.SteamInterface;
import java.nio.ByteBuffer;

public class SteamHTTP
extends SteamInterface {
    public SteamHTTP(SteamHTTPCallback steamHTTPCallback, SteamHTTP$API steamHTTP$API) {
        super(steamHTTP$API == SteamHTTP$API.Client ? SteamAPI.getSteamHTTPPointer() : SteamGameServerAPI.getSteamGameServerHTTPPointer(), SteamHTTP.createCallback(new SteamHTTPCallbackAdapter(steamHTTPCallback), steamHTTP$API == SteamHTTP$API.Client));
    }

    public SteamHTTPRequestHandle createHTTPRequest(SteamHTTP$HTTPMethod steamHTTP$HTTPMethod, String string2) {
        return new SteamHTTPRequestHandle(SteamHTTP.createHTTPRequest(this.pointer, steamHTTP$HTTPMethod.ordinal(), string2));
    }

    public boolean setHTTPRequestContextValue(SteamHTTPRequestHandle steamHTTPRequestHandle, long l2) {
        return SteamHTTP.setHTTPRequestContextValue(this.pointer, steamHTTPRequestHandle.handle, l2);
    }

    public boolean setHTTPRequestNetworkActivityTimeout(SteamHTTPRequestHandle steamHTTPRequestHandle, int n2) {
        return SteamHTTP.setHTTPRequestNetworkActivityTimeout(this.pointer, steamHTTPRequestHandle.handle, n2);
    }

    public boolean setHTTPRequestHeaderValue(SteamHTTPRequestHandle steamHTTPRequestHandle, String string2, String string3) {
        return SteamHTTP.setHTTPRequestHeaderValue(this.pointer, steamHTTPRequestHandle.handle, string2, string3);
    }

    public boolean setHTTPRequestGetOrPostParameter(SteamHTTPRequestHandle steamHTTPRequestHandle, String string2, String string3) {
        return SteamHTTP.setHTTPRequestGetOrPostParameter(this.pointer, steamHTTPRequestHandle.handle, string2, string3);
    }

    public SteamAPICall sendHTTPRequest(SteamHTTPRequestHandle steamHTTPRequestHandle) {
        return new SteamAPICall(SteamHTTP.sendHTTPRequest(this.pointer, this.callback, steamHTTPRequestHandle.handle));
    }

    public SteamAPICall sendHTTPRequestAndStreamResponse(SteamHTTPRequestHandle steamHTTPRequestHandle) {
        return new SteamAPICall(SteamHTTP.sendHTTPRequestAndStreamResponse(this.pointer, steamHTTPRequestHandle.handle));
    }

    public int getHTTPResponseHeaderSize(SteamHTTPRequestHandle steamHTTPRequestHandle, String string2) {
        return SteamHTTP.getHTTPResponseHeaderSize(this.pointer, steamHTTPRequestHandle.handle, string2);
    }

    public boolean getHTTPResponseHeaderValue(SteamHTTPRequestHandle steamHTTPRequestHandle, String string2, ByteBuffer byteBuffer) throws SteamException {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        int n2 = byteBuffer.position();
        int n3 = byteBuffer.limit() - n2;
        return SteamHTTP.getHTTPResponseHeaderValue(this.pointer, steamHTTPRequestHandle.handle, string2, byteBuffer, n2, n3);
    }

    public int getHTTPResponseBodySize(SteamHTTPRequestHandle steamHTTPRequestHandle) {
        return SteamHTTP.getHTTPResponseBodySize(this.pointer, steamHTTPRequestHandle.handle);
    }

    public boolean getHTTPResponseBodyData(SteamHTTPRequestHandle steamHTTPRequestHandle, ByteBuffer byteBuffer) throws SteamException {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        int n2 = byteBuffer.position();
        int n3 = byteBuffer.limit() - n2;
        return SteamHTTP.getHTTPResponseBodyData(this.pointer, steamHTTPRequestHandle.handle, byteBuffer, n2, n3);
    }

    public boolean getHTTPStreamingResponseBodyData(SteamHTTPRequestHandle steamHTTPRequestHandle, int n2, ByteBuffer byteBuffer) throws SteamException {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        int n3 = byteBuffer.position();
        int n4 = byteBuffer.limit() - n3;
        return SteamHTTP.getHTTPStreamingResponseBodyData(this.pointer, steamHTTPRequestHandle.handle, n2, byteBuffer, n3, n4);
    }

    public boolean releaseHTTPRequest(SteamHTTPRequestHandle steamHTTPRequestHandle) {
        return SteamHTTP.releaseHTTPRequest(this.pointer, steamHTTPRequestHandle.handle);
    }

    private static native long createCallback(SteamHTTPCallbackAdapter var0, boolean var1);

    private static native long createHTTPRequest(long var0, int var2, String var3);

    private static native boolean setHTTPRequestContextValue(long var0, long var2, long var4);

    private static native boolean setHTTPRequestNetworkActivityTimeout(long var0, long var2, int var4);

    private static native boolean setHTTPRequestHeaderValue(long var0, long var2, String var4, String var5);

    private static native boolean setHTTPRequestGetOrPostParameter(long var0, long var2, String var4, String var5);

    private static native long sendHTTPRequest(long var0, long var2, long var4);

    private static native long sendHTTPRequestAndStreamResponse(long var0, long var2);

    private static native int getHTTPResponseHeaderSize(long var0, long var2, String var4);

    private static native boolean getHTTPResponseHeaderValue(long var0, long var2, String var4, ByteBuffer var5, int var6, int var7);

    private static native int getHTTPResponseBodySize(long var0, long var2);

    private static native boolean getHTTPResponseBodyData(long var0, long var2, ByteBuffer var4, int var5, int var6);

    private static native boolean getHTTPStreamingResponseBodyData(long var0, long var2, int var4, ByteBuffer var5, int var6, int var7);

    private static native boolean releaseHTTPRequest(long var0, long var2);
}

