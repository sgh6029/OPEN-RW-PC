/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.utility.AssetIndex;

class i$1
extends Thread {
    final /* synthetic */ AssetIndex a;

    i$1(AssetIndex i2) {
        this.a = i2;
    }

    @Override
    public void run() {
        this.a.b();
    }
}

