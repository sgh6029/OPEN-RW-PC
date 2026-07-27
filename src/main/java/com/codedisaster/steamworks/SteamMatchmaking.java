/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamMatchMakingKeyValuePair;
import com.codedisaster.steamworks.SteamMatchmaking$ChatEntry;
import com.codedisaster.steamworks.SteamMatchmaking$LobbyComparison;
import com.codedisaster.steamworks.SteamMatchmaking$LobbyDistanceFilter;
import com.codedisaster.steamworks.SteamMatchmaking$LobbyType;
import com.codedisaster.steamworks.SteamMatchmakingCallback;
import com.codedisaster.steamworks.SteamMatchmakingCallbackAdapter;
import java.nio.ByteBuffer;

public class SteamMatchmaking
extends SteamInterface {
    public SteamMatchmaking(SteamMatchmakingCallback steamMatchmakingCallback) {
        super(SteamAPI.getSteamMatchmakingPointer(), SteamMatchmaking.createCallback(new SteamMatchmakingCallbackAdapter(steamMatchmakingCallback)));
    }

    public SteamAPICall requestLobbyList() {
        return new SteamAPICall(SteamMatchmaking.requestLobbyList(this.pointer, this.callback));
    }

    public void addRequestLobbyListStringFilter(String string2, String string3, SteamMatchmaking$LobbyComparison steamMatchmaking$LobbyComparison) {
        SteamMatchmaking.addRequestLobbyListStringFilter(this.pointer, string2, string3, SteamMatchmaking$LobbyComparison.access$000(steamMatchmaking$LobbyComparison));
    }

    public void addRequestLobbyListNumericalFilter(String string2, int n2, SteamMatchmaking$LobbyComparison steamMatchmaking$LobbyComparison) {
        SteamMatchmaking.addRequestLobbyListNumericalFilter(this.pointer, string2, n2, SteamMatchmaking$LobbyComparison.access$000(steamMatchmaking$LobbyComparison));
    }

    public void addRequestLobbyListNearValueFilter(String string2, int n2) {
        SteamMatchmaking.addRequestLobbyListNearValueFilter(this.pointer, string2, n2);
    }

    public void addRequestLobbyListFilterSlotsAvailable(int n2) {
        SteamMatchmaking.addRequestLobbyListFilterSlotsAvailable(this.pointer, n2);
    }

    public void addRequestLobbyListDistanceFilter(SteamMatchmaking$LobbyDistanceFilter steamMatchmaking$LobbyDistanceFilter) {
        SteamMatchmaking.addRequestLobbyListDistanceFilter(this.pointer, steamMatchmaking$LobbyDistanceFilter.ordinal());
    }

    public void addRequestLobbyListResultCountFilter(int n2) {
        SteamMatchmaking.addRequestLobbyListResultCountFilter(this.pointer, n2);
    }

    public void addRequestLobbyListCompatibleMembersFilter(SteamID steamID) {
        SteamMatchmaking.addRequestLobbyListCompatibleMembersFilter(this.pointer, steamID.handle);
    }

    public SteamID getLobbyByIndex(int n2) {
        return new SteamID(SteamMatchmaking.getLobbyByIndex(this.pointer, n2));
    }

    public SteamAPICall createLobby(SteamMatchmaking$LobbyType steamMatchmaking$LobbyType, int n2) {
        return new SteamAPICall(SteamMatchmaking.createLobby(this.pointer, this.callback, steamMatchmaking$LobbyType.ordinal(), n2));
    }

    public SteamAPICall joinLobby(SteamID steamID) {
        return new SteamAPICall(SteamMatchmaking.joinLobby(this.pointer, this.callback, steamID.handle));
    }

    public void leaveLobby(SteamID steamID) {
        SteamMatchmaking.leaveLobby(this.pointer, steamID.handle);
    }

    public boolean inviteUserToLobby(SteamID steamID, SteamID steamID2) {
        return SteamMatchmaking.inviteUserToLobby(this.pointer, steamID.handle, steamID2.handle);
    }

    public int getNumLobbyMembers(SteamID steamID) {
        return SteamMatchmaking.getNumLobbyMembers(this.pointer, steamID.handle);
    }

    public SteamID getLobbyMemberByIndex(SteamID steamID, int n2) {
        return new SteamID(SteamMatchmaking.getLobbyMemberByIndex(this.pointer, steamID.handle, n2));
    }

    public String getLobbyData(SteamID steamID, String string2) {
        return SteamMatchmaking.getLobbyData(this.pointer, steamID.handle, string2);
    }

    public boolean setLobbyData(SteamID steamID, String string2, String string3) {
        return SteamMatchmaking.setLobbyData(this.pointer, steamID.handle, string2, string3);
    }

    public boolean setLobbyData(SteamID steamID, SteamMatchMakingKeyValuePair steamMatchMakingKeyValuePair) {
        return SteamMatchmaking.setLobbyData(this.pointer, steamID.handle, steamMatchMakingKeyValuePair.getKey(), steamMatchMakingKeyValuePair.getValue());
    }

    public int getLobbyDataCount(SteamID steamID) {
        return SteamMatchmaking.getLobbyDataCount(this.pointer, steamID.handle);
    }

    public boolean getLobbyDataByIndex(SteamID steamID, int n2, SteamMatchMakingKeyValuePair steamMatchMakingKeyValuePair) {
        return SteamMatchmaking.getLobbyDataByIndex(this.pointer, steamID.handle, n2, steamMatchMakingKeyValuePair);
    }

    public boolean deleteLobbyData(SteamID steamID, String string2) {
        return SteamMatchmaking.deleteLobbyData(this.pointer, steamID.handle, string2);
    }

    public boolean sendLobbyChatMsg(SteamID steamID, ByteBuffer byteBuffer) throws SteamException {
        int n2 = byteBuffer.position();
        int n3 = byteBuffer.limit() - n2;
        return this.sendLobbyChatMsg(steamID, byteBuffer, n2, n3);
    }

    public boolean sendLobbyChatMsg(SteamID steamID, ByteBuffer byteBuffer, int n2, int n3) throws SteamException {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        if (byteBuffer.capacity() < n2 + n3) {
            throw new SteamException("Buffer capacity exceeded!");
        }
        return SteamMatchmaking.sendLobbyChatMsg(this.pointer, steamID.handle, byteBuffer, n2, n3);
    }

    public boolean sendLobbyChatMsg(SteamID steamID, String string2) {
        return SteamMatchmaking.sendLobbyChatMsg(this.pointer, steamID.handle, string2);
    }

    public int getLobbyChatEntry(SteamID steamID, int n2, SteamMatchmaking$ChatEntry steamMatchmaking$ChatEntry, ByteBuffer byteBuffer) throws SteamException {
        int n3 = byteBuffer.position();
        int n4 = byteBuffer.limit() - n3;
        return this.getLobbyChatEntry(steamID, n2, steamMatchmaking$ChatEntry, byteBuffer, n3, n4);
    }

    public int getLobbyChatEntry(SteamID steamID, int n2, SteamMatchmaking$ChatEntry steamMatchmaking$ChatEntry, ByteBuffer byteBuffer, int n3, int n4) throws SteamException {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        if (byteBuffer.capacity() < n3 + n4) {
            throw new SteamException("Buffer capacity exceeded!");
        }
        int n5 = SteamMatchmaking.getLobbyChatEntry(this.pointer, steamID.handle, n2, steamMatchmaking$ChatEntry, byteBuffer, n3, n4);
        if (n5 >= 0) {
            byteBuffer.position(n3);
            byteBuffer.limit(n3 + n5);
        }
        return n5;
    }

    public boolean requestLobbyData(SteamID steamID) {
        return SteamMatchmaking.requestLobbyData(this.pointer, steamID.handle);
    }

    public boolean setLobbyMemberLimit(SteamID steamID, int n2) {
        return SteamMatchmaking.setLobbyMemberLimit(this.pointer, steamID.handle, n2);
    }

    public boolean getLobbyMemberLimit(SteamID steamID) {
        return SteamMatchmaking.getLobbyMemberLimit(this.pointer, steamID.handle);
    }

    public boolean setLobbyType(SteamID steamID, SteamMatchmaking$LobbyType steamMatchmaking$LobbyType) {
        return SteamMatchmaking.setLobbyType(this.pointer, steamID.handle, steamMatchmaking$LobbyType.ordinal());
    }

    public boolean setLobbyJoinable(SteamID steamID, boolean bl2) {
        return SteamMatchmaking.setLobbyJoinable(this.pointer, steamID.handle, bl2);
    }

    public SteamID getLobbyOwner(SteamID steamID) {
        return new SteamID(SteamMatchmaking.getLobbyOwner(this.pointer, steamID.handle));
    }

    public boolean setLobbyOwner(SteamID steamID, SteamID steamID2) {
        return SteamMatchmaking.setLobbyOwner(this.pointer, steamID.handle, steamID2.handle);
    }

    public boolean setLinkedLobby(SteamID steamID, SteamID steamID2) {
        return SteamMatchmaking.setLinkedLobby(this.pointer, steamID.handle, steamID2.handle);
    }

    private static native long createCallback(SteamMatchmakingCallbackAdapter var0);

    private static native long requestLobbyList(long var0, long var2);

    private static native void addRequestLobbyListStringFilter(long var0, String var2, String var3, int var4);

    private static native void addRequestLobbyListNumericalFilter(long var0, String var2, int var3, int var4);

    private static native void addRequestLobbyListNearValueFilter(long var0, String var2, int var3);

    private static native void addRequestLobbyListFilterSlotsAvailable(long var0, int var2);

    private static native void addRequestLobbyListDistanceFilter(long var0, int var2);

    private static native void addRequestLobbyListResultCountFilter(long var0, int var2);

    private static native void addRequestLobbyListCompatibleMembersFilter(long var0, long var2);

    private static native long getLobbyByIndex(long var0, int var2);

    private static native long createLobby(long var0, long var2, int var4, int var5);

    private static native long joinLobby(long var0, long var2, long var4);

    private static native void leaveLobby(long var0, long var2);

    private static native boolean inviteUserToLobby(long var0, long var2, long var4);

    private static native int getNumLobbyMembers(long var0, long var2);

    private static native long getLobbyMemberByIndex(long var0, long var2, int var4);

    private static native String getLobbyData(long var0, long var2, String var4);

    private static native boolean setLobbyData(long var0, long var2, String var4, String var5);

    private static native int getLobbyDataCount(long var0, long var2);

    private static native boolean getLobbyDataByIndex(long var0, long var2, int var4, SteamMatchMakingKeyValuePair var5);

    private static native boolean deleteLobbyData(long var0, long var2, String var4);

    private static native boolean sendLobbyChatMsg(long var0, long var2, ByteBuffer var4, int var5, int var6);

    private static native boolean sendLobbyChatMsg(long var0, long var2, String var4);

    private static native int getLobbyChatEntry(long var0, long var2, int var4, SteamMatchmaking$ChatEntry var5, ByteBuffer var6, int var7, int var8);

    private static native boolean requestLobbyData(long var0, long var2);

    private static native boolean setLobbyMemberLimit(long var0, long var2, int var4);

    private static native boolean getLobbyMemberLimit(long var0, long var2);

    private static native boolean setLobbyType(long var0, long var2, int var4);

    private static native boolean setLobbyJoinable(long var0, long var2, boolean var4);

    private static native long getLobbyOwner(long var0, long var2);

    private static native boolean setLobbyOwner(long var0, long var2, long var4);

    private static native boolean setLinkedLobby(long var0, long var2, long var4);
}

