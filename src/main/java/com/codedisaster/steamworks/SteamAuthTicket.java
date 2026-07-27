/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamNativeHandle;

public class SteamAuthTicket
extends SteamNativeHandle {
    static final long AuthTicketInvalid = 0L;

    SteamAuthTicket(long l2) {
        super(l2);
    }

    public boolean isValid() {
        return this.handle != 0L;
    }
}

