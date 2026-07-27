/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;
import com.corrodinggames.rts.appFramework.g;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameMode;

class g$10
implements DialogInterface.OnClickListener {
    final /* synthetic */ g a;

    g$10(g g2) {
        this.a = g2;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.L();
        l2.startGame(true, GameMode.normal);
        l2.J();
    }
}

