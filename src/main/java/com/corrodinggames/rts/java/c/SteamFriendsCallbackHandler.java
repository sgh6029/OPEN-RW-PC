/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.c;

import com.codedisaster.steamworks.SteamFriends$PersonaChange;
import com.codedisaster.steamworks.SteamFriendsCallback;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamResult;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.java.c.JavaSteamEngine;

public class SteamFriendsCallbackHandler
implements SteamFriendsCallback {
    JavaSteamEngine a;

    public SteamFriendsCallbackHandler(JavaSteamEngine b2) {
        this.a = b2;
    }

    @Override
    public void onSetPersonaNameResponse(boolean bl2, boolean bl3, SteamResult steamResult) {
    }

    @Override
    public void onPersonaStateChange(SteamID steamID, SteamFriends$PersonaChange steamFriends$PersonaChange) {
    }

    @Override
    public void onGameOverlayActivated(boolean bl2) {
        GameEngine.log("onGameOverlayActivated");
    }

    @Override
    public void onGameLobbyJoinRequested(SteamID steamID, SteamID steamID2) {
    }

    @Override
    public void onAvatarImageLoaded(SteamID steamID, int n2, int n3, int n4) {
    }

    @Override
    public void onFriendRichPresenceUpdate(SteamID steamID, int n2) {
    }

    @Override
    public void onGameRichPresenceJoinRequested(SteamID steamID, String string2) {
    }
}

