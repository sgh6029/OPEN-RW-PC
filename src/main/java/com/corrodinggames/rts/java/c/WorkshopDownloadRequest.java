/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.c;

import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamResult;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class WorkshopDownloadRequest {
    SteamPublishedFileID a;
    Runnable b;

    public void a(SteamResult steamResult) {
        GameEngine.b("PendingDownload onFinish for: " + this.a);
        if (this.b != null) {
            this.b.run();
        }
    }
}

