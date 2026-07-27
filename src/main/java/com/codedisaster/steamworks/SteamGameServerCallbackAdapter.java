/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAuth$AuthSessionResponse;
import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamGameServer$DenyReason;
import com.codedisaster.steamworks.SteamGameServerCallback;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamResult;

class SteamGameServerCallbackAdapter
extends SteamCallbackAdapter {
    SteamGameServerCallbackAdapter(SteamGameServerCallback steamGameServerCallback) {
        super(steamGameServerCallback);
    }

    void onValidateAuthTicketResponse(long l2, int n2, long l3) {
        ((SteamGameServerCallback)this.callback).onValidateAuthTicketResponse(new SteamID(l2), SteamAuth$AuthSessionResponse.byOrdinal(n2), new SteamID(l3));
    }

    void onSteamServersConnected() {
        ((SteamGameServerCallback)this.callback).onSteamServersConnected();
    }

    void onSteamServerConnectFailure(int n2, boolean bl2) {
        ((SteamGameServerCallback)this.callback).onSteamServerConnectFailure(SteamResult.byValue(n2), bl2);
    }

    void onSteamServersDisconnected(int n2) {
        ((SteamGameServerCallback)this.callback).onSteamServersDisconnected(SteamResult.byValue(n2));
    }

    void onClientApprove(long l2, long l3) {
        ((SteamGameServerCallback)this.callback).onClientApprove(new SteamID(l2), new SteamID(l3));
    }

    void onClientDeny(long l2, int n2, String string2) {
        ((SteamGameServerCallback)this.callback).onClientDeny(new SteamID(l2), SteamGameServer$DenyReason.byOrdinal(n2), string2);
    }

    void onClientKick(long l2, int n2) {
        ((SteamGameServerCallback)this.callback).onClientKick(new SteamID(l2), SteamGameServer$DenyReason.byOrdinal(n2));
    }

    void onClientGroupStatus(long l2, long l3, boolean bl2, boolean bl3) {
        ((SteamGameServerCallback)this.callback).onClientGroupStatus(new SteamID(l2), new SteamID(l3), bl2, bl3);
    }

    void onAssociateWithClanResult(int n2) {
        ((SteamGameServerCallback)this.callback).onAssociateWithClanResult(SteamResult.byValue(n2));
    }

    void onComputeNewPlayerCompatibilityResult(int n2, int n3, int n4, int n5, long l2) {
        ((SteamGameServerCallback)this.callback).onComputeNewPlayerCompatibilityResult(SteamResult.byValue(n2), n3, n4, n5, new SteamID(l2));
    }
}

