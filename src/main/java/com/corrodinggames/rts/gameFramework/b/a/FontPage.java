/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 *  android.opengl.GLUtils
 */
package com.corrodinggames.rts.gameFramework.b.a;

import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint$FontMetrics;
import android.graphics.Bitmap.Config;

import com.corrodinggames.rts.gameFramework.b.a.FontRenderer;
import com.corrodinggames.rts.gameFramework.b.a.GlyphInfo;

public class FontPage {
    int a;
    int b;
    Canvas c;
    public Bitmap d;
    int e;
    int f;
    int g = 0;
    int h = 0;
    int i = 0;
    int j;
    int k;
    int l;
    int m;
    int n;

    public boolean a() {
        return this.g < this.e * this.f;
    }

    public FontPage(int n2, int n3, int n4, int n5, int n6, int n7) {
        this.l = n3;
        this.b = n2;
        this.e = n2 / n4;
        this.f = n2 / n5;
        this.j = n4;
        this.k = n5;
        this.m = n6;
        this.n = n7;
    }

    public void b() {
        this.d = Bitmap.createBitmap(this.b, this.b, Bitmap.Config.ALPHA_8);
        this.c = new Canvas();
        this.c.a(this.d);
        this.d.eraseColor(0);
    }

    public void c() {
        if (this.d == null) {
            return;
        }
        if (this.a == 0) {
            int[] nArray = new int[1];
            GLES20.glGenTextures((int)1, (int[])nArray, (int)0);
            this.a = nArray[0];
            if (this.a == 0) {
                com.corrodinggames.rts.gameFramework.b.a.FontRenderer.b("Failed to gen texture page");
                return;
            }
        }
        GLES20.glBindTexture((int)3553, (int)this.a);
        GLES20.glTexParameteri((int)3553, (int)10241, (int)9729);
        GLES20.glTexParameteri((int)3553, (int)10240, (int)9729);
        GLES20.glTexParameterf((int)3553, (int)10242, (float)33071.0f);
        GLES20.glTexParameterf((int)3553, (int)10243, (float)33071.0f);
        GLUtils.texImage2D((int)3553, (int)0, (Bitmap)this.d, (int)0);
    }

    public GlyphInfo a(char c2, Paint paint) {
        boolean bl2 = true;
        if (this.c == null) {
            this.b();
        }
        int n2 = this.g / this.e;
        int n3 = this.g % this.e;
        int n4 = n3 * this.j;
        int n5 = n2 * this.k;
        Paint$FontMetrics paint$FontMetrics = paint.n();
        float f2 = (float)Math.ceil(Math.abs(paint$FontMetrics.c));
        float[] fArray = new float[2];
        char[] cArray = new char[2];
        cArray[0] = c2;
        paint.a(cArray, 0, 1, fArray);
        float f3 = fArray[0];
        f3 = (int)f3;
        if (f3 > (float)this.j) {
            com.corrodinggames.rts.gameFramework.b.a.FontRenderer.b("Warning chr is larger then cellWidth: " + c2);
        }
        float f4 = n4 + this.m;
        float f5 = (float)(n5 + this.k) - f2 - (float)this.n;
        f4 = (int)f4;
        f5 = (int)f5;
        this.c.a(cArray, 0, 1, f4, f5, paint);
        GlyphInfo c3 = new GlyphInfo();
        c3.a = c2;
        c3.b = this.l;
        this.a(c3, n4, n5, this.j, this.k);
        c3.c = f3;
        ++this.g;
        return c3;
    }

    private void a(GlyphInfo c2, float f2, float f3, float f4, float f5) {
        c2.d = f2 / (float)this.b;
        c2.e = f3 / (float)this.b;
        c2.f = c2.d + f4 / (float)this.b;
        c2.g = c2.e + f5 / (float)this.b;
    }
}
