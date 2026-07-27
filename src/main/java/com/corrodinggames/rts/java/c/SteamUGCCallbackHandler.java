/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.c;

import com.codedisaster.steamworks.SteamNativeHandle;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamResult;
import com.codedisaster.steamworks.SteamUGCCallback;
import com.codedisaster.steamworks.SteamUGCDetails;
import com.codedisaster.steamworks.SteamUGCQuery;
import com.corrodinggames.rts.gameFramework.i.b;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.java.c.SteamWorkshopManager;
import com.corrodinggames.rts.java.c.WorkshopItemInfo;
import com.corrodinggames.rts.java.c.WorkshopDownloadRequest;

public class SteamUGCCallbackHandler
implements SteamUGCCallback {
    final /* synthetic */ SteamWorkshopManager a;

    public SteamUGCCallbackHandler(SteamWorkshopManager g2) {
        this.a = g2;
    }

    @Override
    public void onUGCQueryCompleted(SteamUGCQuery steamUGCQuery, int n2, int n3, boolean bl2, SteamResult steamResult) {
        GameEngine.log("Got workshop callback: onUGCQueryCompleted (" + (Object)((Object)steamResult) + ") numResultsReturned:" + n2);
        if (steamResult != SteamResult.OK) {
            return;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            SteamUGCDetails steamUGCDetails = new SteamUGCDetails();
            boolean bl3 = this.a.d.getQueryUGCResult(steamUGCQuery, i2, steamUGCDetails);
            if (!bl3) {
                GameEngine.log("getQueryUGCResult failed for index: " + i2);
                continue;
            }
            SteamPublishedFileID steamPublishedFileID = steamUGCDetails.getPublishedFileID();
            GameEngine.log("getQueryUGCResult: " + steamPublishedFileID);
            WorkshopItemInfo h2 = this.a.a(steamPublishedFileID);
            h2.d = steamUGCDetails.getTitle();
            h2.c = true;
            this.a.a = true;
        }
    }

    @Override
    public void onSubscribeItem(SteamPublishedFileID steamPublishedFileID, SteamResult steamResult) {
        this.a("onSubscribeItem", steamResult);
        GameEngine l2 = GameEngine.getInstance();
    }

    @Override
    public void onUnsubscribeItem(SteamPublishedFileID steamPublishedFileID, SteamResult steamResult) {
        this.a("onUnsubscribeItem", steamResult);
        GameEngine l2 = GameEngine.getInstance();
    }

    @Override
    public void onRequestUGCDetails(SteamUGCDetails steamUGCDetails, SteamResult steamResult) {
        this.a("onRequestUGCDetails", steamResult);
    }

    @Override
    public void onCreateItem(SteamPublishedFileID steamPublishedFileID, boolean bl2, SteamResult steamResult) {
        this.a("onCreateItem", steamResult);
        if (this.a.e == null) {
            this.a.a(null, "Error no mod pending creation!", false);
            return;
        }
        if (this.a.e.k != 0L) {
            this.a.a(this.a.e, "This mod has already been published", true);
            return;
        }
        this.a.e.a(SteamNativeHandle.getNativeHandle(steamPublishedFileID));
        this.a.a(this.a.e, true, "Created.");
        this.a.e = null;
        GameEngine l2 = GameEngine.getInstance();
        l2.bZ.m();
    }

    @Override
    public void onSubmitItemUpdate(boolean bl2, SteamResult steamResult) {
        b b2 = this.a.g;
        this.a.g = null;
        this.a("onSubmitItemUpdate", steamResult);
        String string2 = "";
        if (steamResult == SteamResult.OK) {
            string2 = "Workshop item updated.";
        } else if (this.a.f) {
            string2 = "Error. Workshop returned: " + (Object)((Object)steamResult) + " while trying to upload workshop data.";
        } else {
            string2 = "Error. Workshop returned: " + (Object)((Object)steamResult) + " while trying to update existing workshop item.";
            if (steamResult == SteamResult.FileNotFound) {
                string2 = string2 + " (If you want to create a new workshop item instead of updating, delete steam.dat from this mod.)";
            }
        }
        if (bl2) {
            string2 = string2 + "WLA agreement needs to be accepted on the workshop site.";
        }
        GameEngine.getInstance().i(string2);
        GameEngine l2 = GameEngine.getInstance();
        l2.bZ.m();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onDownloadItemResult(int n2, SteamPublishedFileID steamPublishedFileID, SteamResult steamResult) {
        this.a("onDownloadItemResult", steamResult);
        Object object = this.a.h;
        synchronized (object) {
            WorkshopDownloadRequest i2 = this.a.c(steamPublishedFileID);
            if (i2 != null) {
                i2.a(steamResult);
                this.a.h.remove(i2);
            }
        }
        object = GameEngine.getInstance();
        ((GameEngine)object).bZ.m();
    }

    @Override
    public void onUserFavoriteItemsListChanged(SteamPublishedFileID steamPublishedFileID, boolean bl2, SteamResult steamResult) {
        this.a("onUserFavoriteItemsListChanged", steamResult);
    }

    @Override
    public void onSetUserItemVote(SteamPublishedFileID steamPublishedFileID, boolean bl2, SteamResult steamResult) {
        this.a("onSetUserItemVote", steamResult);
    }

    @Override
    public void onGetUserItemVote(SteamPublishedFileID steamPublishedFileID, boolean bl2, boolean bl3, boolean bl4, SteamResult steamResult) {
        this.a("onGetUserItemVote", steamResult);
    }

    @Override
    public void onStartPlaytimeTracking(SteamResult steamResult) {
        this.a("onStartPlaytimeTracking", steamResult);
    }

    @Override
    public void onStopPlaytimeTracking(SteamResult steamResult) {
        this.a("onStopPlaytimeTracking", steamResult);
    }

    @Override
    public void onStopPlaytimeTrackingForAllItems(SteamResult steamResult) {
        this.a("onStopPlaytimeTrackingForAllItems", steamResult);
    }

    public void a(String string2, SteamResult steamResult) {
        GameEngine.log("Got workshop callback: " + string2 + " (" + (Object)((Object)steamResult) + ")");
    }
}

