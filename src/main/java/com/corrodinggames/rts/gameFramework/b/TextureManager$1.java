/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.b;

import com.corrodinggames.rts.gameFramework.b.ITextureFilter;
import com.corrodinggames.rts.gameFramework.b.Texture;
import com.corrodinggames.rts.gameFramework.b.TextureManager;
import com.corrodinggames.rts.gameFramework.b.FilterCallback;

class TextureManager$1
implements FilterCallback {
    final /* synthetic */ TextureManager a;

    TextureManager$1(TextureManager f2) {
        this.a = f2;
    }

    @Override
    public void a(Texture b2, ITextureFilter af2, boolean bl2) {
        this.a.a.a(b2, 0, 0, b2.b(), b2.c(), af2, null);
    }
}

