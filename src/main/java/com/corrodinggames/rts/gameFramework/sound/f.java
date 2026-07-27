/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.sound;


import com.corrodinggames.rts.gameFramework.sound.g;
import com.corrodinggames.rts.gameFramework.sound.h;
import com.corrodinggames.rts.gameFramework.sound.i;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;

import android.content.Context;

public class f
extends h {
    @Override
    public void a(Context context) {
    }

    @Override
    public i a(int n2) {
        String string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(com.corrodinggames.rts.R.raw.class, n2);
        g g2 = new g(string2, this);
        return g2;
    }

    @Override
    public i a(String string2, AssetInputStream j2, boolean bl2) {
        g g2 = new g(string2, this);
        return g2;
    }

    public static i b() {
        g g2 = new g("Null (from out of memory)", null);
        return g2;
    }

    public static i a(String string2) {
        g g2 = new g("Null sound - " + string2, null);
        return g2;
    }
}

