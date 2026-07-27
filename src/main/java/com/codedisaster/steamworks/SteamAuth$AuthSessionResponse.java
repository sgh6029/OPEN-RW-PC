/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

public enum SteamAuth$AuthSessionResponse {
    OK,
    UserNotConnectedToSteam,
    NoLicenseOrExpired,
    VACBanned,
    LoggedInElseWhere,
    VACCheckTimedOut,
    AuthTicketCanceled,
    AuthTicketInvalidAlreadyUsed,
    AuthTicketInvalid,
    PublisherIssuedBan;

    private static final SteamAuth$AuthSessionResponse[] values;

    static SteamAuth$AuthSessionResponse byOrdinal(int n2) {
        return values[n2];
    }

    static {
        values = SteamAuth$AuthSessionResponse.values();
    }
}

