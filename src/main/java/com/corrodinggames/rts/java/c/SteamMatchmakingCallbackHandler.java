/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.c;

import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamMatchmaking$ChatEntryType;
import com.codedisaster.steamworks.SteamMatchmaking$ChatMemberStateChange;
import com.codedisaster.steamworks.SteamMatchmaking$ChatRoomEnterResponse;
import com.codedisaster.steamworks.SteamMatchmakingCallback;
import com.codedisaster.steamworks.SteamResult;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.java.c.SteamGameInviteHandler;
import com.corrodinggames.rts.java.c.JavaSteamEngine;

public class SteamMatchmakingCallbackHandler
implements SteamMatchmakingCallback {
    JavaSteamEngine a;

    public SteamMatchmakingCallbackHandler(JavaSteamEngine b2) {
        this.a = b2;
    }

    @Override
    public void onFavoritesListChanged(int n2, int n3, int n4, int n5, int n6, boolean bl2, int n7) {
        GameEngine.log("onFavoritesListChanged");
    }

    @Override
    public void onLobbyInvite(SteamID steamID, SteamID steamID2, long l2) {
        GameEngine.log("onLobbyInvite");
        SteamGameInviteHandler a2 = new SteamGameInviteHandler(this.a, steamID, steamID2, l2);
        a2.a();
    }

    @Override
    public void onLobbyEnter(SteamID steamID, int n2, boolean bl2, SteamMatchmaking$ChatRoomEnterResponse steamMatchmaking$ChatRoomEnterResponse) {
        GameEngine.log("onLobbyEnter");
        if (bl2) {
            GameEngine.log("onLobbyEnter blocked: " + (Object)((Object)steamMatchmaking$ChatRoomEnterResponse));
        }
        this.a.c(steamID);
    }

    @Override
    public void onLobbyDataUpdate(SteamID steamID, SteamID steamID2, boolean bl2) {
        GameEngine.log("onLobbyDataUpdate success: " + bl2);
    }

    @Override
    public void onLobbyChatUpdate(SteamID steamID, SteamID steamID2, SteamID steamID3, SteamMatchmaking$ChatMemberStateChange steamMatchmaking$ChatMemberStateChange) {
        GameEngine.log("onLobbyChatUpdate steamIDUserChanged: " + steamID2 + " stateChange:" + (Object)((Object)steamMatchmaking$ChatMemberStateChange));
    }

    @Override
    public void onLobbyChatMessage(SteamID steamID, SteamID steamID2, SteamMatchmaking$ChatEntryType steamMatchmaking$ChatEntryType, int n2) {
        GameEngine.log("onLobbyChatMessage");
    }

    @Override
    public void onLobbyGameCreated(SteamID steamID, SteamID steamID2, int n2, short s2) {
        GameEngine.log("onLobbyGameCreated");
        this.a.a(steamID);
    }

    @Override
    public void onLobbyMatchList(int n2) {
        GameEngine.log("onLobbyMatchList");
    }

    @Override
    public void onLobbyKicked(SteamID steamID, SteamID steamID2, boolean bl2) {
        GameEngine.log("onLobbyKicked");
    }

    @Override
    public void onLobbyCreated(SteamResult steamResult, SteamID steamID) {
        GameEngine.log("onLobbyCreated");
        this.a.a(steamID);
    }

    @Override
    public void onFavoritesListAccountsUpdated(SteamResult steamResult) {
        GameEngine.log("onFavoritesListAccountsUpdated");
    }
}

