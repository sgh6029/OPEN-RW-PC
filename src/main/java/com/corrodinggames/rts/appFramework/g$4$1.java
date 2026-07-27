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
import com.corrodinggames.rts.appFramework.g$4;

class g$4$1
implements DialogInterface.OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ g$4 b;

    g$4$1(g$4 var1_1, String string2) {
        this.b = var1_1;
        this.a = string2;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        g.b(this.b.c, this.a);
    }
}

