/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamMatchmaking$ChatEntryType;
import com.codedisaster.steamworks.SteamMatchmaking$ChatMemberStateChange;
import com.codedisaster.steamworks.SteamMatchmaking$ChatRoomEnterResponse;
import com.codedisaster.steamworks.SteamMatchmakingCallback;
import com.codedisaster.steamworks.SteamResult;

class SteamMatchmakingCallbackAdapter
extends SteamCallbackAdapter {
    private static final SteamMatchmaking$ChatMemberStateChange[] stateChangeValues = SteamMatchmaking$ChatMemberStateChange.values();

    SteamMatchmakingCallbackAdapter(SteamMatchmakingCallback steamMatchmakingCallback) {
        super(steamMatchmakingCallback);
    }

    void onFavoritesListChanged(int n2, int n3, int n4, int n5, int n6, boolean bl2, int n7) {
        ((SteamMatchmakingCallback)this.callback).onFavoritesListChanged(n2, n3, n4, n5, n6, bl2, n7);
    }

    void onLobbyInvite(long l2, long l3, long l4) {
        ((SteamMatchmakingCallback)this.callback).onLobbyInvite(new SteamID(l2), new SteamID(l3), l4);
    }

    void onLobbyEnter(long l2, int n2, boolean bl2, int n3) {
        ((SteamMatchmakingCallback)this.callback).onLobbyEnter(new SteamID(l2), n2, bl2, SteamMatchmaking$ChatRoomEnterResponse.byCode(n3));
    }

    void onLobbyDataUpdate(long l2, long l3, boolean bl2) {
        ((SteamMatchmakingCallback)this.callback).onLobbyDataUpdate(new SteamID(l2), new SteamID(l3), bl2);
    }

    void onLobbyChatUpdate(long l2, long l3, long l4, int n2) {
        SteamID steamID = new SteamID(l2);
        SteamID steamID2 = new SteamID(l3);
        SteamID steamID3 = new SteamID(l4);
        for (SteamMatchmaking$ChatMemberStateChange steamMatchmaking$ChatMemberStateChange : stateChangeValues) {
            if (!SteamMatchmaking$ChatMemberStateChange.isSet(steamMatchmaking$ChatMemberStateChange, n2)) continue;
            ((SteamMatchmakingCallback)this.callback).onLobbyChatUpdate(steamID, steamID2, steamID3, steamMatchmaking$ChatMemberStateChange);
        }
    }

    void onLobbyChatMessage(long l2, long l3, int n2, int n3) {
        ((SteamMatchmakingCallback)this.callback).onLobbyChatMessage(new SteamID(l2), new SteamID(l3), SteamMatchmaking$ChatEntryType.byCode(n2), n3);
    }

    void onLobbyGameCreated(long l2, long l3, int n2, short s2) {
        ((SteamMatchmakingCallback)this.callback).onLobbyGameCreated(new SteamID(l2), new SteamID(l3), n2, s2);
    }

    void onLobbyMatchList(int n2) {
        ((SteamMatchmakingCallback)this.callback).onLobbyMatchList(n2);
    }

    void onLobbyKicked(long l2, long l3, boolean bl2) {
        ((SteamMatchmakingCallback)this.callback).onLobbyKicked(new SteamID(l2), new SteamID(l3), bl2);
    }

    void onLobbyCreated(int n2, long l2) {
        ((SteamMatchmakingCallback)this.callback).onLobbyCreated(SteamResult.byValue(n2), new SteamID(l2));
    }

    void onFavoritesListAccountsUpdated(int n2) {
        ((SteamMatchmakingCallback)this.callback).onFavoritesListAccountsUpdated(SteamResult.byValue(n2));
    }
}

