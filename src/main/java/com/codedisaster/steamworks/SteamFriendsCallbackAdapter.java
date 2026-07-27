/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamFriends$PersonaChange;
import com.codedisaster.steamworks.SteamFriendsCallback;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamResult;

class SteamFriendsCallbackAdapter
extends SteamCallbackAdapter {
    private static final SteamFriends$PersonaChange[] personaChangeValues = SteamFriends$PersonaChange.values();

    SteamFriendsCallbackAdapter(SteamFriendsCallback steamFriendsCallback) {
        super(steamFriendsCallback);
    }

    void onSetPersonaNameResponse(boolean bl2, boolean bl3, int n2) {
        ((SteamFriendsCallback)this.callback).onSetPersonaNameResponse(bl2, bl3, SteamResult.byValue(n2));
    }

    void onPersonaStateChange(long l2, int n2) {
        SteamID steamID = new SteamID(l2);
        for (SteamFriends$PersonaChange steamFriends$PersonaChange : personaChangeValues) {
            if (!SteamFriends$PersonaChange.isSet(steamFriends$PersonaChange, n2)) continue;
            ((SteamFriendsCallback)this.callback).onPersonaStateChange(steamID, steamFriends$PersonaChange);
        }
    }

    void onGameOverlayActivated(boolean bl2) {
        ((SteamFriendsCallback)this.callback).onGameOverlayActivated(bl2);
    }

    void onGameLobbyJoinRequested(long l2, long l3) {
        ((SteamFriendsCallback)this.callback).onGameLobbyJoinRequested(new SteamID(l2), new SteamID(l3));
    }

    void onAvatarImageLoaded(long l2, int n2, int n3, int n4) {
        ((SteamFriendsCallback)this.callback).onAvatarImageLoaded(new SteamID(l2), n2, n3, n4);
    }

    void onFriendRichPresenceUpdate(long l2, int n2) {
        ((SteamFriendsCallback)this.callback).onFriendRichPresenceUpdate(new SteamID(l2), n2);
    }

    void onGameRichPresenceJoinRequested(long l2, String string2) {
        ((SteamFriendsCallback)this.callback).onGameRichPresenceJoinRequested(new SteamID(l2), string2);
    }
}

