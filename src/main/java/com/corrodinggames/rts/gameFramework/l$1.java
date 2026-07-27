/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.Toast
 */
package com.corrodinggames.rts.gameFramework;

import android.widget.Toast;
import android.content.Context;

import com.corrodinggames.rts.gameFramework.GameEngine;

class l$1
implements Runnable {
    final /* synthetic */ GameEngine a;

    l$1(GameEngine l2) {
        this.a = l2;
    }

    @Override
    public void run() {
        String string2 = this.a.gameMode;
        try {
            if (string2 == null) {
                GameEngine.b("Cannot show toast, no message");
                return;
            }
            int n2 = 1;
            Toast toast = Toast.makeText((Context)this.a.am, (CharSequence)string2, (int)n2);
            toast.show();
        }
        catch (Exception exception) {
            GameEngine.b("Error showing toast: " + string2);
            exception.printStackTrace();
        }
    }
}

