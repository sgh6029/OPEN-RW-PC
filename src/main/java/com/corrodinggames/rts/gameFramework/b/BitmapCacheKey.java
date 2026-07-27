/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.b;

import com.corrodinggames.rts.gameFramework.b.DynamicTexture$1;

import android.graphics.Bitmap;

class BitmapCacheKey
implements Cloneable {
    public boolean a;
    public Bitmap.Config b;
    public int c;

    private BitmapCacheKey() {
    }

    public int hashCode() {
        int n2 = this.b.hashCode() ^ this.c;
        return this.a ? n2 : -n2;
    }

    public boolean equals(Object object) {
        if (!(object instanceof BitmapCacheKey)) {
            return false;
        }
        BitmapCacheKey ai2 = (BitmapCacheKey)object;
        return this.a == ai2.a && this.b == ai2.b && this.c == ai2.c;
    }

    public BitmapCacheKey a() {
        try {
            return (BitmapCacheKey)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    public /* synthetic */ Object clone() {
        return this.a();
    }

    /* synthetic */ BitmapCacheKey(DynamicTexture$1 ah$1) {
        this();
    }
}

