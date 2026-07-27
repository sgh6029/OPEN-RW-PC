/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.sound;

import com.corrodinggames.rts.gameFramework.sound.i;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;

import android.content.Context;

import java.util.HashMap;

public abstract class h {
    HashMap h = new HashMap();

    public abstract i a(int var1);

    public abstract i a(String var1, AssetInputStream var2, boolean var3);

    public abstract void a(Context var1);

    public void a() {
    }
}

