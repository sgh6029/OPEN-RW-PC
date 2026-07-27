/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

public class SteamMatchMakingKeyValuePair {
    private String key;
    private String value;

    public SteamMatchMakingKeyValuePair() {
    }

    public SteamMatchMakingKeyValuePair(String string2, String string3) {
        this.key = string2;
        this.value = string3;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}

