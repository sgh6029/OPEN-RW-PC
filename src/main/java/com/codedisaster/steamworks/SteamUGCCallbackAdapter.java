/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamResult;
import com.codedisaster.steamworks.SteamUGCCallback;
import com.codedisaster.steamworks.SteamUGCDetails;
import com.codedisaster.steamworks.SteamUGCQuery;

class SteamUGCCallbackAdapter
extends SteamCallbackAdapter {
    SteamUGCCallbackAdapter(SteamUGCCallback steamUGCCallback) {
        super(steamUGCCallback);
    }

    void onUGCQueryCompleted(long l2, int n2, int n3, boolean bl2, int n4) {
        ((SteamUGCCallback)this.callback).onUGCQueryCompleted(new SteamUGCQuery(l2), n2, n3, bl2, SteamResult.byValue(n4));
    }

    void onSubscribeItem(long l2, int n2) {
        ((SteamUGCCallback)this.callback).onSubscribeItem(new SteamPublishedFileID(l2), SteamResult.byValue(n2));
    }

    void onUnsubscribeItem(long l2, int n2) {
        ((SteamUGCCallback)this.callback).onUnsubscribeItem(new SteamPublishedFileID(l2), SteamResult.byValue(n2));
    }

    void onRequestUGCDetails(long l2, int n2, String string2, String string3, long l3, long l4, String string4, boolean bl2, int n3, int n4, long l5, int n5, int n6) {
        SteamUGCDetails steamUGCDetails = new SteamUGCDetails();
        steamUGCDetails.publishedFileID = l2;
        steamUGCDetails.result = n2;
        steamUGCDetails.title = string2;
        steamUGCDetails.description = string3;
        steamUGCDetails.fileHandle = l3;
        steamUGCDetails.previewFileHandle = l4;
        steamUGCDetails.fileName = string4;
        steamUGCDetails.votesUp = n3;
        steamUGCDetails.votesDown = n4;
        steamUGCDetails.ownerID = l5;
        steamUGCDetails.timeCreated = n5;
        steamUGCDetails.timeUpdated = n6;
        ((SteamUGCCallback)this.callback).onRequestUGCDetails(steamUGCDetails, SteamResult.byValue(n2));
    }

    void onCreateItem(long l2, boolean bl2, int n2) {
        ((SteamUGCCallback)this.callback).onCreateItem(new SteamPublishedFileID(l2), bl2, SteamResult.byValue(n2));
    }

    void onSubmitItemUpdate(boolean bl2, int n2) {
        ((SteamUGCCallback)this.callback).onSubmitItemUpdate(bl2, SteamResult.byValue(n2));
    }

    void onDownloadItemResult(int n2, long l2, int n3) {
        ((SteamUGCCallback)this.callback).onDownloadItemResult(n2, new SteamPublishedFileID(l2), SteamResult.byValue(n3));
    }

    void onUserFavoriteItemsListChanged(long l2, boolean bl2, int n2) {
        ((SteamUGCCallback)this.callback).onUserFavoriteItemsListChanged(new SteamPublishedFileID(l2), bl2, SteamResult.byValue(n2));
    }

    void onSetUserItemVote(long l2, boolean bl2, int n2) {
        ((SteamUGCCallback)this.callback).onSetUserItemVote(new SteamPublishedFileID(l2), bl2, SteamResult.byValue(n2));
    }

    void onGetUserItemVote(long l2, boolean bl2, boolean bl3, boolean bl4, int n2) {
        ((SteamUGCCallback)this.callback).onGetUserItemVote(new SteamPublishedFileID(l2), bl2, bl3, bl4, SteamResult.byValue(n2));
    }

    void onStartPlaytimeTracking(int n2) {
        ((SteamUGCCallback)this.callback).onStartPlaytimeTracking(SteamResult.byValue(n2));
    }

    void onStopPlaytimeTracking(int n2) {
        ((SteamUGCCallback)this.callback).onStopPlaytimeTracking(SteamResult.byValue(n2));
    }

    void onStopPlaytimeTrackingForAllItems(int n2) {
        ((SteamUGCCallback)this.callback).onStopPlaytimeTrackingForAllItems(SteamResult.byValue(n2));
    }
}

