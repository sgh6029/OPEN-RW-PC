/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamPublishedFileUpdateHandle;
import com.codedisaster.steamworks.SteamRemoteStorage$PublishedFileVisibility;
import com.codedisaster.steamworks.SteamRemoteStorage$RemoteStoragePlatform;
import com.codedisaster.steamworks.SteamRemoteStorage$UGCReadAction;
import com.codedisaster.steamworks.SteamRemoteStorage$WorkshopFileType;
import com.codedisaster.steamworks.SteamRemoteStorageCallback;
import com.codedisaster.steamworks.SteamRemoteStorageCallbackAdapter;
import com.codedisaster.steamworks.SteamUGCFileWriteStreamHandle;
import com.codedisaster.steamworks.SteamUGCHandle;
import java.nio.ByteBuffer;

public class SteamRemoteStorage
extends SteamInterface {
    public SteamRemoteStorage(SteamRemoteStorageCallback steamRemoteStorageCallback) {
        super(SteamAPI.getSteamRemoteStoragePointer(), SteamRemoteStorage.createCallback(new SteamRemoteStorageCallbackAdapter(steamRemoteStorageCallback)));
    }

    public boolean fileWrite(String string2, ByteBuffer byteBuffer, int n2) throws SteamException {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return SteamRemoteStorage.fileWrite(this.pointer, string2, byteBuffer, n2);
    }

    public boolean fileRead(String string2, ByteBuffer byteBuffer, int n2) throws SteamException {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return SteamRemoteStorage.fileRead(this.pointer, string2, byteBuffer, n2);
    }

    public SteamAPICall fileWriteAsync(String string2, ByteBuffer byteBuffer) throws SteamException {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return new SteamAPICall(SteamRemoteStorage.fileWriteAsync(this.pointer, this.callback, string2, byteBuffer, byteBuffer.remaining()));
    }

    public SteamAPICall fileReadAsync(String string2, int n2, int n3) {
        return new SteamAPICall(SteamRemoteStorage.fileReadAsync(this.pointer, this.callback, string2, n2, n3));
    }

    public boolean fileReadAsyncComplete(SteamAPICall steamAPICall, ByteBuffer byteBuffer, int n2) {
        return SteamRemoteStorage.fileReadAsyncComplete(this.pointer, steamAPICall.handle, byteBuffer, n2);
    }

    public boolean fileForget(String string2) {
        return SteamRemoteStorage.fileForget(this.pointer, string2);
    }

    public boolean fileDelete(String string2) {
        return SteamRemoteStorage.fileDelete(this.pointer, string2);
    }

    public SteamAPICall fileShare(String string2) {
        return new SteamAPICall(SteamRemoteStorage.fileShare(this.pointer, this.callback, string2));
    }

    public boolean setSyncPlatforms(String string2, SteamRemoteStorage$RemoteStoragePlatform steamRemoteStorage$RemoteStoragePlatform) {
        return SteamRemoteStorage.setSyncPlatforms(this.pointer, string2, SteamRemoteStorage$RemoteStoragePlatform.access$000(steamRemoteStorage$RemoteStoragePlatform));
    }

    public SteamUGCFileWriteStreamHandle fileWriteStreamOpen(String string2) {
        return new SteamUGCFileWriteStreamHandle(SteamRemoteStorage.fileWriteStreamOpen(this.pointer, string2));
    }

    public boolean fileWriteStreamWriteChunk(SteamUGCFileWriteStreamHandle steamUGCFileWriteStreamHandle, ByteBuffer byteBuffer, int n2) {
        return SteamRemoteStorage.fileWriteStreamWriteChunk(this.pointer, steamUGCFileWriteStreamHandle.handle, byteBuffer, n2);
    }

    public boolean fileWriteStreamClose(SteamUGCFileWriteStreamHandle steamUGCFileWriteStreamHandle) {
        return SteamRemoteStorage.fileWriteStreamClose(this.pointer, steamUGCFileWriteStreamHandle.handle);
    }

    public boolean fileWriteStreamCancel(SteamUGCFileWriteStreamHandle steamUGCFileWriteStreamHandle) {
        return SteamRemoteStorage.fileWriteStreamCancel(this.pointer, steamUGCFileWriteStreamHandle.handle);
    }

    public boolean fileExists(String string2) {
        return SteamRemoteStorage.fileExists(this.pointer, string2);
    }

    public boolean filePersisted(String string2) {
        return SteamRemoteStorage.filePersisted(this.pointer, string2);
    }

    public int getFileSize(String string2) {
        return SteamRemoteStorage.getFileSize(this.pointer, string2);
    }

    public long getFileTimestamp(String string2) {
        return SteamRemoteStorage.getFileTimestamp(this.pointer, string2);
    }

    public SteamRemoteStorage$RemoteStoragePlatform[] getSyncPlatforms(String string2) {
        int n2 = SteamRemoteStorage.getSyncPlatforms(this.pointer, string2);
        return SteamRemoteStorage$RemoteStoragePlatform.byMask(n2);
    }

    public int getFileCount() {
        return SteamRemoteStorage.getFileCount(this.pointer);
    }

    public String getFileNameAndSize(int n2, int[] nArray) {
        return SteamRemoteStorage.getFileNameAndSize(this.pointer, n2, nArray);
    }

    public boolean getQuota(long[] lArray, long[] lArray2) {
        return SteamRemoteStorage.getQuota(this.pointer, lArray, lArray2);
    }

    public boolean isCloudEnabledForAccount() {
        return SteamRemoteStorage.isCloudEnabledForAccount(this.pointer);
    }

    public boolean isCloudEnabledForApp() {
        return SteamRemoteStorage.isCloudEnabledForApp(this.pointer);
    }

    public void setCloudEnabledForApp(boolean bl2) {
        SteamRemoteStorage.setCloudEnabledForApp(this.pointer, bl2);
    }

    public SteamAPICall ugcDownload(SteamUGCHandle steamUGCHandle, int n2) {
        return new SteamAPICall(SteamRemoteStorage.ugcDownload(this.pointer, this.callback, steamUGCHandle.handle, n2));
    }

    public boolean getUGCDownloadProgress(SteamUGCHandle steamUGCHandle, int[] nArray, int[] nArray2) {
        return SteamRemoteStorage.getUGCDownloadProgress(this.pointer, steamUGCHandle.handle, nArray, nArray2);
    }

    public int ugcRead(SteamUGCHandle steamUGCHandle, ByteBuffer byteBuffer, int n2, int n3, SteamRemoteStorage$UGCReadAction steamRemoteStorage$UGCReadAction) {
        return SteamRemoteStorage.ugcRead(this.pointer, steamUGCHandle.handle, byteBuffer, n2, n3, steamRemoteStorage$UGCReadAction.ordinal());
    }

    public int getCachedUGCCount() {
        return SteamRemoteStorage.getCachedUGCCount(this.pointer);
    }

    public SteamUGCHandle getCachedUGCHandle(int n2) {
        return new SteamUGCHandle(SteamRemoteStorage.getCachedUGCHandle(this.pointer, n2));
    }

    public SteamAPICall publishWorkshopFile(String string2, String string3, int n2, String string4, String string5, SteamRemoteStorage$PublishedFileVisibility steamRemoteStorage$PublishedFileVisibility, String[] stringArray, SteamRemoteStorage$WorkshopFileType steamRemoteStorage$WorkshopFileType) {
        return new SteamAPICall(SteamRemoteStorage.publishWorkshopFile(this.pointer, this.callback, string2, string3, n2, string4, string5, steamRemoteStorage$PublishedFileVisibility.ordinal(), stringArray, stringArray != null ? stringArray.length : 0, steamRemoteStorage$WorkshopFileType.ordinal()));
    }

    public SteamPublishedFileUpdateHandle createPublishedFileUpdateRequest(SteamPublishedFileID steamPublishedFileID) {
        return new SteamPublishedFileUpdateHandle(SteamRemoteStorage.createPublishedFileUpdateRequest(this.pointer, steamPublishedFileID.handle));
    }

    public boolean updatePublishedFileFile(SteamPublishedFileUpdateHandle steamPublishedFileUpdateHandle, String string2) {
        return SteamRemoteStorage.updatePublishedFileFile(this.pointer, steamPublishedFileUpdateHandle.handle, string2);
    }

    public boolean updatePublishedFilePreviewFile(SteamPublishedFileUpdateHandle steamPublishedFileUpdateHandle, String string2) {
        return SteamRemoteStorage.updatePublishedFilePreviewFile(this.pointer, steamPublishedFileUpdateHandle.handle, string2);
    }

    public boolean updatePublishedFileTitle(SteamPublishedFileUpdateHandle steamPublishedFileUpdateHandle, String string2) {
        return SteamRemoteStorage.updatePublishedFileTitle(this.pointer, steamPublishedFileUpdateHandle.handle, string2);
    }

    public boolean updatePublishedFileDescription(SteamPublishedFileUpdateHandle steamPublishedFileUpdateHandle, String string2) {
        return SteamRemoteStorage.updatePublishedFileDescription(this.pointer, steamPublishedFileUpdateHandle.handle, string2);
    }

    public boolean updatePublishedFileVisibility(SteamPublishedFileUpdateHandle steamPublishedFileUpdateHandle, SteamRemoteStorage$PublishedFileVisibility steamRemoteStorage$PublishedFileVisibility) {
        return SteamRemoteStorage.updatePublishedFileVisibility(this.pointer, steamPublishedFileUpdateHandle.handle, steamRemoteStorage$PublishedFileVisibility.ordinal());
    }

    public boolean updatePublishedFileTags(SteamPublishedFileUpdateHandle steamPublishedFileUpdateHandle, String[] stringArray) {
        return SteamRemoteStorage.updatePublishedFileTags(this.pointer, steamPublishedFileUpdateHandle.handle, stringArray, stringArray != null ? stringArray.length : 0);
    }

    public SteamAPICall commitPublishedFileUpdate(SteamPublishedFileUpdateHandle steamPublishedFileUpdateHandle) {
        return new SteamAPICall(SteamRemoteStorage.commitPublishedFileUpdate(this.pointer, this.callback, steamPublishedFileUpdateHandle.handle));
    }

    private static native long createCallback(SteamRemoteStorageCallbackAdapter var0);

    private static native boolean fileWrite(long var0, String var2, ByteBuffer var3, int var4);

    private static native boolean fileRead(long var0, String var2, ByteBuffer var3, int var4);

    private static native long fileWriteAsync(long var0, long var2, String var4, ByteBuffer var5, int var6);

    private static native long fileReadAsync(long var0, long var2, String var4, int var5, int var6);

    private static native boolean fileReadAsyncComplete(long var0, long var2, ByteBuffer var4, int var5);

    private static native boolean fileForget(long var0, String var2);

    private static native boolean fileDelete(long var0, String var2);

    private static native long fileShare(long var0, long var2, String var4);

    private static native boolean setSyncPlatforms(long var0, String var2, int var3);

    private static native long fileWriteStreamOpen(long var0, String var2);

    private static native boolean fileWriteStreamWriteChunk(long var0, long var2, ByteBuffer var4, int var5);

    private static native boolean fileWriteStreamClose(long var0, long var2);

    private static native boolean fileWriteStreamCancel(long var0, long var2);

    private static native boolean fileExists(long var0, String var2);

    private static native boolean filePersisted(long var0, String var2);

    private static native int getFileSize(long var0, String var2);

    private static native long getFileTimestamp(long var0, String var2);

    private static native int getSyncPlatforms(long var0, String var2);

    private static native int getFileCount(long var0);

    private static native String getFileNameAndSize(long var0, int var2, int[] var3);

    private static native boolean getQuota(long var0, long[] var2, long[] var3);

    private static native boolean isCloudEnabledForAccount(long var0);

    private static native boolean isCloudEnabledForApp(long var0);

    private static native void setCloudEnabledForApp(long var0, boolean var2);

    private static native long ugcDownload(long var0, long var2, long var4, int var6);

    private static native boolean getUGCDownloadProgress(long var0, long var2, int[] var4, int[] var5);

    private static native int ugcRead(long var0, long var2, ByteBuffer var4, int var5, int var6, int var7);

    private static native int getCachedUGCCount(long var0);

    private static native long getCachedUGCHandle(long var0, int var2);

    private static native long publishWorkshopFile(long var0, long var2, String var4, String var5, int var6, String var7, String var8, int var9, String[] var10, int var11, int var12);

    private static native long createPublishedFileUpdateRequest(long var0, long var2);

    private static native boolean updatePublishedFileFile(long var0, long var2, String var4);

    private static native boolean updatePublishedFilePreviewFile(long var0, long var2, String var4);

    private static native boolean updatePublishedFileTitle(long var0, long var2, String var4);

    private static native boolean updatePublishedFileDescription(long var0, long var2, String var4);

    private static native boolean updatePublishedFileVisibility(long var0, long var2, int var4);

    private static native boolean updatePublishedFileTags(long var0, long var2, String[] var4, int var5);

    private static native long commitPublishedFileUpdate(long var0, long var2, long var4);
}

