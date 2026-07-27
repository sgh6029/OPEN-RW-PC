/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.b;

import java.util.Collection;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Paint$Style;

public class TextureManager {
    protected final IGraphicsEngine a = null;//TODO: 原先没有初始化
    private Map b;
    private ShaderProgram c;
    private CircleShader d;
    private ITextureFilter e;

    public void a(Texture b2) {
        this.a.c(b2);
    }

    public void a() {
        this.a.d();
    }

    public IGraphicsEngine b() {
        return this.a;
    }

    public Texture a(Bitmap bitmap, com.corrodinggames.rts.gameFramework.m.Texture_M e2, ITextureFilter af2) {
        this.e = af2;
        Texture b2 = this.a(bitmap, e2);
        if (af2 instanceof FilterGroup) {
            FilterGroup i2 = (FilterGroup)af2;
            b2 = i2.a(b2, this.a, new TextureManager$1(this));
        }
        return b2;
    }

    public void a(Bitmap bitmap) {
        Texture b2 = (Texture)this.b.get(bitmap);
        if (b2 != null && b2 instanceof DynamicTexture) {
            ((DynamicTexture)b2).l();
        }
        this.b().a(bitmap);
    }

    public Texture a(Bitmap bitmap, com.corrodinggames.rts.gameFramework.m.Texture_M e2) {
        Texture b2 = (Texture)this.b.get(bitmap);
        if (b2 == null) {
            this.a.e();
            this.c();
            b2 = new BitmapTexture(bitmap);
            b2.c(this.b());
            b2.j = e2.d();
            OpenGLRenderer.b(b2.e, b2.f);
            this.b.put(bitmap, b2);
            this.d();
        }
        return b2;
    }

    public void a(float f2, float f3, float f4, v v2) {
        if (v2.c() == Paint$Style.a) {
            this.d.a(0.5f);
        } else {
            float f5 = v2.b();
            if (f5 == 0.0f) {
                f5 = 1.0f;
            }
            this.d.a(f5 / (2.0f * f4));
        }
        this.a.a(f2 - f4, f3 - f4, f4, v2, (IShaderProgram)this.d);
    }

    public void a(float f2, float f3, float f4, float f5, v v2) {
        this.a.a(f2, f3, f4, f5, v2, this.c);
    }

    public void c() {
        this.a.b();
    }

    public void d() {
        this.a.c();
    }

    public void e() {
        for (Texture b2 : ((Collection<Texture>)this.b.values()) ){
            b2.j();
        }
        this.b.clear();
    }

    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        this.e();
    }

    public void a(int n2, int n3, int n4, int n5) {
        this.a.a(n2, n3, n4, n5);
    }

    public void a(String string2, float f2, float f3, Paint paint) {
        this.a.a(string2, f2, f3, paint);
    }

    public void a(float[] fArray, int n2, int n3, v v2) {
        this.a.a(fArray, n2, n3, v2, (IShaderProgram)this.c);
    }
}

