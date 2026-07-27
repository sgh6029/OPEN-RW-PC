/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.storage.a;

final class c$1
implements DialogInterface.OnClickListener {
    final /* synthetic */ GameEngine a;
    final /* synthetic */ Runnable b;

    c$1(GameEngine l2, Runnable runnable) {
        this.a = l2;
        this.b = runnable;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        this.a.bQ.storageType = 1;
        this.a.bQ.hasSelectedAStorageType = true;
        com.corrodinggames.rts.gameFramework.storage.a.b();
        this.a.bQ.save();
        if (this.b != null) {
            this.b.run();
        }
    }
}

