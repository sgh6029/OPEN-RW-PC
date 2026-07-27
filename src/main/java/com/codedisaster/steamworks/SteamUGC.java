/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamRemoteStorage$PublishedFileVisibility;
import com.codedisaster.steamworks.SteamRemoteStorage$WorkshopFileType;
import com.codedisaster.steamworks.SteamUGC$ItemAdditionalPreview;
import com.codedisaster.steamworks.SteamUGC$ItemDownloadInfo;
import com.codedisaster.steamworks.SteamUGC$ItemInstallInfo;
import com.codedisaster.steamworks.SteamUGC$ItemState;
import com.codedisaster.steamworks.SteamUGC$ItemStatistic;
import com.codedisaster.steamworks.SteamUGC$ItemUpdateInfo;
import com.codedisaster.steamworks.SteamUGC$ItemUpdateStatus;
import com.codedisaster.steamworks.SteamUGC$MatchingUGCType;
import com.codedisaster.steamworks.SteamUGC$UGCQueryType;
import com.codedisaster.steamworks.SteamUGC$UserUGCList;
import com.codedisaster.steamworks.SteamUGC$UserUGCListSortOrder;
import com.codedisaster.steamworks.SteamUGCCallback;
import com.codedisaster.steamworks.SteamUGCCallbackAdapter;
import com.codedisaster.steamworks.SteamUGCDetails;
import com.codedisaster.steamworks.SteamUGCQuery;
import com.codedisaster.steamworks.SteamUGCUpdateHandle;
import java.util.Collection;

public class SteamUGC
        extends SteamInterface {
    public SteamUGC(SteamUGCCallback steamUGCCallback) {
        super(SteamAPI.getSteamUGCPointer(), SteamUGC.createCallback(new SteamUGCCallbackAdapter(steamUGCCallback)));
    }

    public SteamUGCQuery createQueryUserUGCRequest(long l2, SteamUGC$UserUGCList steamUGC$UserUGCList,
            SteamUGC$MatchingUGCType steamUGC$MatchingUGCType,
            SteamUGC$UserUGCListSortOrder steamUGC$UserUGCListSortOrder, int n2, int n3, int n4) {
        return new SteamUGCQuery(SteamUGC.createQueryUserUGCRequest(this.pointer, l2, steamUGC$UserUGCList.ordinal(),
                SteamUGC$MatchingUGCType.access$000(steamUGC$MatchingUGCType), steamUGC$UserUGCListSortOrder.ordinal(),
                n2, n3, n4));
    }

    public SteamUGCQuery createQueryAllUGCRequest(SteamUGC$UGCQueryType steamUGC$UGCQueryType,
            SteamUGC$MatchingUGCType steamUGC$MatchingUGCType, int n2, int n3, int n4) {
        return new SteamUGCQuery(SteamUGC.createQueryAllUGCRequest(this.pointer, steamUGC$UGCQueryType.ordinal(),
                SteamUGC$MatchingUGCType.access$000(steamUGC$MatchingUGCType), n2, n3, n4));
    }

    public SteamUGCQuery createQueryUGCDetailsRequest(SteamPublishedFileID steamPublishedFileID) {
        long[] lArray = new long[] { steamPublishedFileID.handle };
        return new SteamUGCQuery(SteamUGC.createQueryUGCDetailsRequest(this.pointer, lArray, 1));
    }

    public SteamUGCQuery createQueryUGCDetailsRequest(Collection<SteamPublishedFileID> collection) {
        int n2 = collection.size();
        long[] lArray = new long[n2];
        int n3 = 0;
        for (SteamPublishedFileID steamPublishedFileID : collection) {
            lArray[n3++] = steamPublishedFileID.handle;
        }
        return new SteamUGCQuery(SteamUGC.createQueryUGCDetailsRequest(this.pointer, lArray, n2));
    }

    public SteamAPICall sendQueryUGCRequest(SteamUGCQuery steamUGCQuery) {
        return new SteamAPICall(SteamUGC.sendQueryUGCRequest(this.pointer, this.callback, steamUGCQuery.handle));
    }

    public boolean getQueryUGCResult(SteamUGCQuery steamUGCQuery, int n2, SteamUGCDetails steamUGCDetails) {
        return SteamUGC.getQueryUGCResult(this.pointer, steamUGCQuery.handle, n2, steamUGCDetails);
    }

    public String getQueryUGCPreviewURL(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.getQueryUGCPreviewURL(this.pointer, steamUGCQuery.handle, n2);
    }

    public String getQueryUGCMetadata(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.getQueryUGCMetadata(this.pointer, steamUGCQuery.handle, n2);
    }

    public long getQueryUGCStatistic(SteamUGCQuery steamUGCQuery, int n2,
            SteamUGC$ItemStatistic steamUGC$ItemStatistic) {
        return SteamUGC.getQueryUGCStatistic(this.pointer, steamUGCQuery.handle, n2, steamUGC$ItemStatistic.ordinal());
    }

    public int getQueryUGCNumAdditionalPreviews(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.getQueryUGCNumAdditionalPreviews(this.pointer, steamUGCQuery.handle, n2);
    }

    public boolean getQueryUGCAdditionalPreview(SteamUGCQuery steamUGCQuery, int n2, int n3,
            SteamUGC$ItemAdditionalPreview steamUGC$ItemAdditionalPreview) {
        return SteamUGC.getQueryUGCAdditionalPreview(this.pointer, steamUGCQuery.handle, n2, n3,
                steamUGC$ItemAdditionalPreview);
    }

    public int getQueryUGCNumKeyValueTags(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.getQueryUGCNumKeyValueTags(this.pointer, steamUGCQuery.handle, n2);
    }

    public boolean getQueryUGCKeyValueTag(SteamUGCQuery steamUGCQuery, int n2, int n3, String[] stringArray) {
        return SteamUGC.getQueryUGCKeyValueTag(this.pointer, steamUGCQuery.handle, n2, n3, stringArray);
    }

    public boolean releaseQueryUserUGCRequest(SteamUGCQuery steamUGCQuery) {
        return SteamUGC.releaseQueryUserUGCRequest(this.pointer, steamUGCQuery.handle);
    }

    public boolean addRequiredTag(SteamUGCQuery steamUGCQuery, String string2) {
        return SteamUGC.addRequiredTag(this.pointer, steamUGCQuery.handle, string2);
    }

    public boolean addExcludedTag(SteamUGCQuery steamUGCQuery, String string2) {
        return SteamUGC.addExcludedTag(this.pointer, steamUGCQuery.handle, string2);
    }

    public boolean setReturnOnlyIDs(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnOnlyIDs(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnKeyValueTags(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnKeyValueTags(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnLongDescription(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnLongDescription(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnMetadata(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnMetadata(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnChildren(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnChildren(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnAdditionalPreviews(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnAdditionalPreviews(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnTotalOnly(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnTotalOnly(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setLanguage(SteamUGCQuery steamUGCQuery, String string2) {
        return SteamUGC.setLanguage(this.pointer, steamUGCQuery.handle, string2);
    }

    public boolean setAllowCachedResponse(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.setAllowCachedResponse(this.pointer, steamUGCQuery.handle, n2);
    }

    public boolean setCloudFileNameFilter(SteamUGCQuery steamUGCQuery, String string2) {
        return SteamUGC.setCloudFileNameFilter(this.pointer, steamUGCQuery.handle, string2);
    }

    public boolean setMatchAnyTag(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setMatchAnyTag(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setSearchText(SteamUGCQuery steamUGCQuery, String string2) {
        return SteamUGC.setSearchText(this.pointer, steamUGCQuery.handle, string2);
    }

    public boolean setRankedByTrendDays(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.setRankedByTrendDays(this.pointer, steamUGCQuery.handle, n2);
    }

    public boolean addRequiredKeyValueTag(SteamUGCQuery steamUGCQuery, String string2, String string3) {
        return SteamUGC.addRequiredKeyValueTag(this.pointer, steamUGCQuery.handle, string2, string3);
    }

    @Deprecated
    public SteamAPICall requestUGCDetails(SteamPublishedFileID steamPublishedFileID, int n2) {
        return new SteamAPICall(
                SteamUGC.requestUGCDetails(this.pointer, this.callback, steamPublishedFileID.handle, n2));
    }

    public SteamAPICall createItem(int n2, SteamRemoteStorage$WorkshopFileType steamRemoteStorage$WorkshopFileType) {
        return new SteamAPICall(
                SteamUGC.createItem(this.pointer, this.callback, n2, steamRemoteStorage$WorkshopFileType.ordinal()));
    }

    public SteamUGCUpdateHandle startItemUpdate(int n2, SteamPublishedFileID steamPublishedFileID) {
        return new SteamUGCUpdateHandle(SteamUGC.startItemUpdate(this.pointer, n2, steamPublishedFileID.handle));
    }

    public boolean setItemTitle(SteamUGCUpdateHandle steamUGCUpdateHandle, String string2) {
        return SteamUGC.setItemTitle(this.pointer, steamUGCUpdateHandle.handle, string2);
    }

    public boolean setItemDescription(SteamUGCUpdateHandle steamUGCUpdateHandle, String string2) {
        return SteamUGC.setItemDescription(this.pointer, steamUGCUpdateHandle.handle, string2);
    }

    public boolean setItemUpdateLanguage(SteamUGCUpdateHandle steamUGCUpdateHandle, String string2) {
        return SteamUGC.setItemUpdateLanguage(this.pointer, steamUGCUpdateHandle.handle, string2);
    }

    public boolean setItemMetadata(SteamUGCUpdateHandle steamUGCUpdateHandle, String string2) {
        return SteamUGC.setItemMetadata(this.pointer, steamUGCUpdateHandle.handle, string2);
    }

    public boolean setItemVisibility(SteamUGCUpdateHandle steamUGCUpdateHandle,
            SteamRemoteStorage$PublishedFileVisibility steamRemoteStorage$PublishedFileVisibility) {
        return SteamUGC.setItemVisibility(this.pointer, steamUGCUpdateHandle.handle,
                steamRemoteStorage$PublishedFileVisibility.ordinal());
    }

    public boolean setItemTags(SteamUGCUpdateHandle steamUGCUpdateHandle, String[] stringArray) {
        return SteamUGC.setItemTags(this.pointer, steamUGCUpdateHandle.handle, stringArray, stringArray.length);
    }

    public boolean setItemContent(SteamUGCUpdateHandle steamUGCUpdateHandle, String string2) {
        return SteamUGC.setItemContent(this.pointer, steamUGCUpdateHandle.handle, string2);
    }

    public boolean setItemPreview(SteamUGCUpdateHandle steamUGCUpdateHandle, String string2) {
        return SteamUGC.setItemPreview(this.pointer, steamUGCUpdateHandle.handle, string2);
    }

    public boolean removeItemKeyValueTags(SteamUGCUpdateHandle steamUGCUpdateHandle, String string2) {
        return SteamUGC.removeItemKeyValueTags(this.pointer, steamUGCUpdateHandle.handle, string2);
    }

    public boolean addItemKeyValueTag(SteamUGCUpdateHandle steamUGCUpdateHandle, String string2, String string3) {
        return SteamUGC.addItemKeyValueTag(this.pointer, steamUGCUpdateHandle.handle, string2, string3);
    }

    public SteamAPICall submitItemUpdate(SteamUGCUpdateHandle steamUGCUpdateHandle, String string2) {
        return new SteamAPICall(
                SteamUGC.submitItemUpdate(this.pointer, this.callback, steamUGCUpdateHandle.handle, string2));
    }

    public SteamUGC$ItemUpdateStatus getItemUpdateProgress(SteamUGCUpdateHandle steamUGCUpdateHandle,
            SteamUGC$ItemUpdateInfo steamUGC$ItemUpdateInfo) {
        long[] lArray = new long[2];
        SteamUGC$ItemUpdateStatus steamUGC$ItemUpdateStatus = SteamUGC$ItemUpdateStatus
                .byOrdinal(SteamUGC.getItemUpdateProgress(this.pointer, steamUGCUpdateHandle.handle, lArray));
        steamUGC$ItemUpdateInfo.bytesProcessed = lArray[0];
        steamUGC$ItemUpdateInfo.bytesTotal = lArray[1];
        return steamUGC$ItemUpdateStatus;
    }

    public SteamAPICall setUserItemVote(SteamPublishedFileID steamPublishedFileID, boolean bl2) {
        return new SteamAPICall(
                SteamUGC.setUserItemVote(this.pointer, this.callback, steamPublishedFileID.handle, bl2));
    }

    public SteamAPICall getUserItemVote(SteamPublishedFileID steamPublishedFileID) {
        return new SteamAPICall(SteamUGC.getUserItemVote(this.pointer, this.callback, steamPublishedFileID.handle));
    }

    public SteamAPICall addItemToFavorites(int n2, SteamPublishedFileID steamPublishedFileID) {
        return new SteamAPICall(
                SteamUGC.addItemToFavorites(this.pointer, this.callback, n2, steamPublishedFileID.handle));
    }

    public SteamAPICall removeItemFromFavorites(int n2, SteamPublishedFileID steamPublishedFileID) {
        return new SteamAPICall(
                SteamUGC.removeItemFromFavorites(this.pointer, this.callback, n2, steamPublishedFileID.handle));
    }

    public SteamAPICall subscribeItem(SteamPublishedFileID steamPublishedFileID) {
        return new SteamAPICall(SteamUGC.subscribeItem(this.pointer, this.callback, steamPublishedFileID.handle));
    }

    public SteamAPICall unsubscribeItem(SteamPublishedFileID steamPublishedFileID) {
        return new SteamAPICall(SteamUGC.unsubscribeItem(this.pointer, this.callback, steamPublishedFileID.handle));
    }

    public int getNumSubscribedItems() {
        return SteamUGC.getNumSubscribedItems(this.pointer);
    }

    public int getSubscribedItems(SteamPublishedFileID[] steamPublishedFileIDArray) {
        long[] lArray = new long[steamPublishedFileIDArray.length];
        int n2 = SteamUGC.getSubscribedItems(this.pointer, lArray, steamPublishedFileIDArray.length);
        for (int i2 = 0; i2 < n2; ++i2) {
            steamPublishedFileIDArray[i2] = new SteamPublishedFileID(lArray[i2]);
        }
        return n2;
    }

    public Collection getItemState(SteamPublishedFileID steamPublishedFileID) {
        return SteamUGC$ItemState.fromBits(SteamUGC.getItemState(this.pointer, steamPublishedFileID.handle));
    }

    public boolean getItemInstallInfo(SteamPublishedFileID steamPublishedFileID,
            SteamUGC$ItemInstallInfo steamUGC$ItemInstallInfo) {
        return SteamUGC.getItemInstallInfo(this.pointer, steamPublishedFileID.handle, steamUGC$ItemInstallInfo);
    }

    public boolean getItemDownloadInfo(SteamPublishedFileID steamPublishedFileID,
            SteamUGC$ItemDownloadInfo steamUGC$ItemDownloadInfo) {
        long[] lArray = new long[2];
        if (SteamUGC.getItemDownloadInfo(this.pointer, steamPublishedFileID.handle, lArray)) {
            steamUGC$ItemDownloadInfo.bytesDownloaded = lArray[0];
            steamUGC$ItemDownloadInfo.bytesTotal = lArray[1];
            return true;
        }
        return false;
    }

    public boolean downloadItem(SteamPublishedFileID steamPublishedFileID, boolean bl2) {
        return SteamUGC.downloadItem(this.pointer, steamPublishedFileID.handle, bl2);
    }

    public boolean initWorkshopForGameServer(int n2, String string2) {
        return SteamUGC.initWorkshopForGameServer(this.pointer, n2, string2);
    }

    public void suspendDownloads(boolean bl2) {
        SteamUGC.suspendDownloads(this.pointer, bl2);
    }

    public SteamAPICall startPlaytimeTracking(SteamPublishedFileID[] steamPublishedFileIDArray) {
        long[] lArray = new long[steamPublishedFileIDArray.length];
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            lArray[i2] = steamPublishedFileIDArray[i2].handle;
        }
        return new SteamAPICall(SteamUGC.startPlaytimeTracking(this.pointer, this.callback, lArray, lArray.length));
    }

    public SteamAPICall stopPlaytimeTracking(SteamPublishedFileID[] steamPublishedFileIDArray) {
        long[] lArray = new long[steamPublishedFileIDArray.length];
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            lArray[i2] = steamPublishedFileIDArray[i2].handle;
        }
        return new SteamAPICall(SteamUGC.stopPlaytimeTracking(this.pointer, this.callback, lArray, lArray.length));
    }

    public SteamAPICall stopPlaytimeTrackingForAllItems() {
        return new SteamAPICall(SteamUGC.stopPlaytimeTrackingForAllItems(this.pointer, this.callback));
    }

    private static native long createCallback(SteamUGCCallbackAdapter var0);

    private static native long createQueryUserUGCRequest(long var0, long var2, int var4, int var5, int var6, int var7,
            int var8, int var9);

    private static native long createQueryAllUGCRequest(long var0, int var2, int var3, int var4, int var5, int var6);

    private static native long createQueryUGCDetailsRequest(long var0, long[] var2, int var3);

    private static native long sendQueryUGCRequest(long var0, long var2, long var4);

    private static native boolean getQueryUGCResult(long var0, long var2, int var4, SteamUGCDetails var5);

    private static native String getQueryUGCPreviewURL(long var0, long var2, int var4);

    private static native String getQueryUGCMetadata(long var0, long var2, int var4);

    private static native long getQueryUGCStatistic(long var0, long var2, int var4, int var5);

    private static native int getQueryUGCNumAdditionalPreviews(long var0, long var2, int var4);

    private static native boolean getQueryUGCAdditionalPreview(long var0, long var2, int var4, int var5,
            SteamUGC$ItemAdditionalPreview var6);

    private static native int getQueryUGCNumKeyValueTags(long var0, long var2, int var4);

    private static native boolean getQueryUGCKeyValueTag(long var0, long var2, int var4, int var5, String[] var6);

    private static native boolean releaseQueryUserUGCRequest(long var0, long var2);

    private static native boolean addRequiredTag(long var0, long var2, String var4);

    private static native boolean addExcludedTag(long var0, long var2, String var4);

    private static native boolean setReturnOnlyIDs(long var0, long var2, boolean var4);

    private static native boolean setReturnKeyValueTags(long var0, long var2, boolean var4);

    private static native boolean setReturnLongDescription(long var0, long var2, boolean var4);

    private static native boolean setReturnMetadata(long var0, long var2, boolean var4);

    private static native boolean setReturnChildren(long var0, long var2, boolean var4);

    private static native boolean setReturnAdditionalPreviews(long var0, long var2, boolean var4);

    private static native boolean setReturnTotalOnly(long var0, long var2, boolean var4);

    private static native boolean setLanguage(long var0, long var2, String var4);

    private static native boolean setAllowCachedResponse(long var0, long var2, int var4);

    private static native boolean setCloudFileNameFilter(long var0, long var2, String var4);

    private static native boolean setMatchAnyTag(long var0, long var2, boolean var4);

    private static native boolean setSearchText(long var0, long var2, String var4);

    private static native boolean setRankedByTrendDays(long var0, long var2, int var4);

    private static native boolean addRequiredKeyValueTag(long var0, long var2, String var4, String var5);

    private static native long requestUGCDetails(long var0, long var2, long var4, int var6);

    private static native long createItem(long var0, long var2, int var4, int var5);

    private static native long startItemUpdate(long var0, int var2, long var3);

    private static native boolean setItemTitle(long var0, long var2, String var4);

    private static native boolean setItemDescription(long var0, long var2, String var4);

    private static native boolean setItemUpdateLanguage(long var0, long var2, String var4);

    private static native boolean setItemMetadata(long var0, long var2, String var4);

    private static native boolean setItemVisibility(long var0, long var2, int var4);

    private static native boolean setItemTags(long var0, long var2, String[] var4, int var5);

    private static native boolean setItemContent(long var0, long var2, String var4);

    private static native boolean setItemPreview(long var0, long var2, String var4);

    private static native boolean removeItemKeyValueTags(long var0, long var2, String var4);

    private static native boolean addItemKeyValueTag(long var0, long var2, String var4, String var5);

    private static native long submitItemUpdate(long var0, long var2, long var4, String var6);

    private static native int getItemUpdateProgress(long var0, long var2, long[] var4);

    private static native long setUserItemVote(long var0, long var2, long var4, boolean var6);

    private static native long getUserItemVote(long var0, long var2, long var4);

    private static native long addItemToFavorites(long var0, long var2, int var4, long var5);

    private static native long removeItemFromFavorites(long var0, long var2, int var4, long var5);

    private static native long subscribeItem(long var0, long var2, long var4);

    private static native long unsubscribeItem(long var0, long var2, long var4);

    private static native int getNumSubscribedItems(long var0);

    private static native int getSubscribedItems(long var0, long[] var2, int var3);

    private static native int getItemState(long var0, long var2);

    private static native boolean getItemInstallInfo(long var0, long var2, SteamUGC$ItemInstallInfo var4);

    private static native boolean getItemDownloadInfo(long var0, long var2, long[] var4);

    private static native boolean downloadItem(long var0, long var2, boolean var4);

    private static native boolean initWorkshopForGameServer(long var0, int var2, String var3);

    private static native void suspendDownloads(long var0, boolean var2);

    private static native long startPlaytimeTracking(long var0, long var2, long[] var4, int var5);

    private static native long stopPlaytimeTracking(long var0, long var2, long[] var4, int var5);

    private static native long stopPlaytimeTrackingForAllItems(long var0, long var2);
}
