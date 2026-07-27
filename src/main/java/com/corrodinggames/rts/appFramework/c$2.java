/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 */
package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.content.Context;

import com.corrodinggames.rts.appFramework.b;
import com.corrodinggames.rts.appFramework.c;
import com.corrodinggames.rts.appFramework.c$2$1;
import com.corrodinggames.rts.appFramework.s;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.storage.a;

final class c$2
implements DialogInterface.OnClickListener {
    final /* synthetic */ Activity a;
    final /* synthetic */ GameEngine b;
    final /* synthetic */ Runnable c;

    c$2(Activity activity, GameEngine l2, Runnable runnable) {
        this.a = activity;
        this.b = l2;
        this.c = runnable;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        com.corrodinggames.rts.gameFramework.storage.b b2 = com.corrodinggames.rts.gameFramework.storage.a.a(true);
        if (!b2.b) {
            GameEngine.log("Storage setup: Not using SAF, not showing setup folder popup");
            boolean bl2 = com.corrodinggames.rts.appFramework.c.b(this.a);
            if (bl2) {
                this.b.bQ.storageType = 2;
                this.b.bQ.hasSelectedAStorageType = true;
                com.corrodinggames.rts.gameFramework.storage.a.b();
                this.b.bQ.save();
            }
            return;
        }
        if (this.a instanceof s) {
            GameEngine.log("Storage setup: Already on settings page");
            s s2 = (s)this.a;
            s2.l();
            return;
        }
        Intent intent = new Intent((Context)this.a, s.class);
        intent.putExtra("mode", "setupExternalFolder");
        com.corrodinggames.rts.appFramework.c.a(intent);
        this.a.a(intent);
        if (this.a instanceof b) {
            if (this.c != null) {
                c$2$1 c$2$1 = new c$2$1(this);
                ((b)this.a).a(c$2$1);
            }
        } else {
            GameEngine.b("context not instance CommonActivity");
        }
    }
}

