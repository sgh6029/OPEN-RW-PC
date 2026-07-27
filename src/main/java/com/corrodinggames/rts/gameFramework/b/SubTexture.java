/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.b;

import com.corrodinggames.rts.gameFramework.b.BackingTexture;
import com.corrodinggames.rts.gameFramework.b.Texture;

import android.graphics.RectF;

import com.corrodinggames.rts.gameFramework.b.IGraphicsEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class SubTexture
extends Texture {
    BackingTexture l;
    public float m;
    public float n;
    public int o;
    public int p;

    @Override
    protected boolean c(IGraphicsEngine k2) {
        return false;
    }

    @Override
    protected int g() {
        return 3553;
    }

    @Override
    public void b(int n2) {
        this.l.b(n2);
    }

    @Override
    public int h() {
        return this.l.h();
    }

    @Override
    public void a(RectF rectF) {
        float f2 = this.g;
        float f3 = this.h;
        rectF.left = rectF.left * f2 + this.m;
        rectF.c = rectF.c * f2 + this.m;
        rectF.b = rectF.b * f3 + this.n;
        rectF.d = rectF.d * f3 + this.n;
    }

    @Override
    public void a(RectF rectF, RectF rectF2) {
        SubTexture ae2 = this;
    }

    @Override
    public void b(IGraphicsEngine k2) {
        com.corrodinggames.rts.gameFramework.GameEngine.log("SubTexture prepare TODO");
    }
}

