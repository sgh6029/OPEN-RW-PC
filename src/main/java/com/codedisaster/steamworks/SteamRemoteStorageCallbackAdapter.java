/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamRemoteStorageCallback;
import com.codedisaster.steamworks.SteamResult;
import com.codedisaster.steamworks.SteamUGCHandle;

class SteamRemoteStorageCallbackAdapter
extends SteamCallbackAdapter {
    SteamRemoteStorageCallbackAdapter(SteamRemoteStorageCallback steamRemoteStorageCallback) {
        super(steamRemoteStorageCallback);
    }

    void onFileShareResult(long l2, String string2, int n2) {
        ((SteamRemoteStorageCallback)this.callback).onFileShareResult(new SteamUGCHandle(l2), string2, SteamResult.byValue(n2));
    }

    void onDownloadUGCResult(long l2, int n2) {
        ((SteamRemoteStorageCallback)this.callback).onDownloadUGCResult(new SteamUGCHandle(l2), SteamResult.byValue(n2));
    }

    void onPublishFileResult(long l2, boolean bl2, int n2) {
        ((SteamRemoteStorageCallback)this.callback).onPublishFileResult(new SteamPublishedFileID(l2), bl2, SteamResult.byValue(n2));
    }

    void onUpdatePublishedFileResult(long l2, boolean bl2, int n2) {
        ((SteamRemoteStorageCallback)this.callback).onUpdatePublishedFileResult(new SteamPublishedFileID(l2), bl2, SteamResult.byValue(n2));
    }

    void onPublishedFileSubscribed(long l2, int n2) {
        ((SteamRemoteStorageCallback)this.callback).onPublishedFileSubscribed(new SteamPublishedFileID(l2), n2);
    }

    void onPublishedFileUnsubscribed(long l2, int n2) {
        ((SteamRemoteStorageCallback)this.callback).onPublishedFileUnsubscribed(new SteamPublishedFileID(l2), n2);
    }

    void onPublishedFileDeleted(long l2, int n2) {
        ((SteamRemoteStorageCallback)this.callback).onPublishedFileDeleted(new SteamPublishedFileID(l2), n2);
    }

    void onFileWriteAsyncComplete(int n2) {
        ((SteamRemoteStorageCallback)this.callback).onFileWriteAsyncComplete(SteamResult.byValue(n2));
    }

    void onFileReadAsyncComplete(long l2, int n2, int n3, int n4) {
        ((SteamRemoteStorageCallback)this.callback).onFileReadAsyncComplete(new SteamAPICall(l2), SteamResult.byValue(n2), n3, n4);
    }
}

