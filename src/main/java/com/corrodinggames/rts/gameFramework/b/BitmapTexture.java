/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.b;

import com.corrodinggames.rts.gameFramework.b.DynamicTexture;

import android.graphics.Bitmap;

public class BitmapTexture
extends DynamicTexture {
    protected Bitmap l;

    public BitmapTexture(Bitmap bitmap) {
        this(bitmap, false);
    }

    public BitmapTexture(Bitmap bitmap, boolean bl2) {
        super(bl2);
        this.l = bitmap;
        this.m = this.k();
        int n2 = this.m.getWidth() + 0;
        int n3 = this.m.getHeight() + 0;
        this.a(n2, n3);
    }

    @Override
    protected void a(Bitmap bitmap) {
    }

    @Override
    protected Bitmap k() {
        return this.l;
    }
}

