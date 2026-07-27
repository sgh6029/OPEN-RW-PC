/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.appFramework;

import java.util.ArrayList;

import android.app.Activity;

public class b
extends Activity {
    ArrayList b = new ArrayList();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(Runnable runnable) {
        ArrayList arrayList = this.b;
        synchronized (arrayList) {
            this.b.add(runnable);
        }
    }
}

