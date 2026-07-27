/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 *  android.opengl.Matrix
 */
package com.corrodinggames.rts.gameFramework.b.a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Paint$FontMetrics;
import android.util.Log;

import com.corrodinggames.rts.gameFramework.b.a.a.FontShader;
import com.corrodinggames.rts.gameFramework.b.a.GlyphInfo;
import com.corrodinggames.rts.gameFramework.b.a.TextRenderer;
import com.corrodinggames.rts.gameFramework.b.a.FontPage;
import java.util.ArrayList;

public class FontRenderer {
    AssetManager a;
    TextRenderer b;
    int c;
    int d;
    float e;
    float f;
    float g;
    float h;
    float i;
    int j;
    int k;
    int l;
    int m;
    float n;
    float o;
    float p;
    boolean q = true;
    private com.corrodinggames.rts.gameFramework.b.a.a.ShaderProgramBase x;
    private int y;
    private int z;
    public Paint r;
    public ArrayList s = new ArrayList();
    GlyphInfo[][] t = new GlyphInfo[256][];
    boolean u;
    int v = Integer.MAX_VALUE;
    public static boolean w = true;

    public GlyphInfo a(char c2) {
        GlyphInfo c3 = this.b(c2);
        if (c3 == null && this.u) {
            com.corrodinggames.rts.gameFramework.b.a.FontRenderer.b("Loading glyph:" + c2);
            this.c(c2);
            this.a();
        }
        return c3;
    }

    public GlyphInfo b(char c2) {
        if (c2 > '\uffff') {
            return null;
        }
        GlyphInfo[] cArray = this.t[c2 / 256];
        if (cArray != null) {
            GlyphInfo c3 = cArray[c2 & 0xFF];
            return c3;
        }
        return null;
    }

    public void a(char c2, GlyphInfo c3) {
        GlyphInfo[] cArray = this.t[c2 / 256];
        if (cArray == null) {
            cArray = new GlyphInfo[257];
            this.t[c2 / 256] = cArray;
        }
        cArray[c2 & 0xFF] = c3;
    }

    public void c(char c2) {
        if (c2 > '\uffff') {
            return;
        }
        if (this.s.size() == 0) {
            this.b();
        }
        if (!((FontPage)this.s.get(this.s.size() - 1)).a()) {
            if (this.s.size() < this.v) {
                this.b();
            } else {
                return;
            }
        }
        GlyphInfo c3 = ((FontPage)this.s.get(this.s.size() - 1)).a(c2, this.r);
        this.a(c2, c3);
    }

    public void a() {
        if (this.s.size() > 0) {
            ((FontPage)this.s.get(this.s.size() - 1)).c();
        }
    }

    public void b() {
        this.a();
        int n2 = 512;
        FontPage e2 = new FontPage(n2, this.s.size(), this.j, this.k, this.c, this.d);
        this.s.add(e2);
    }

    public FontRenderer(com.corrodinggames.rts.gameFramework.b.a.a.ShaderProgramBase b2, AssetManager assetManager) {
        if (b2 == null) {
            b2 = new FontShader();
            b2.a();
        }
        this.a = assetManager;
        this.b = new TextRenderer(24, b2, this);
        this.c = 0;
        this.d = 0;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = 0.0f;
        this.x = b2;
        this.y = GLES20.glGetUniformLocation((int)this.x.b(), (String)"u_Color");
        this.z = GLES20.glGetUniformLocation((int)this.x.b(), (String)"u_Texture");
    }

    public void a(boolean bl2) {
        this.u = bl2;
    }

    public void a(int n2) {
        this.v = n2;
    }

    public FontRenderer(AssetManager assetManager) {
        this(null, assetManager);
    }

    public boolean a(Paint paint, int n2, int n3, int n4) {
        char c2;
        if (this.r != null) {
            throw new RuntimeException("Already loaded");
        }
        this.c = n3;
        this.d = n4;
        this.r = paint;
        this.r.a(true);
        this.r.b((float)n2);
        this.r.b(-1);
        Paint$FontMetrics paint$FontMetrics = this.r.n();
        this.e = (float)Math.ceil(Math.abs(paint$FontMetrics.d) + Math.abs(paint$FontMetrics.a));
        this.f = (float)Math.ceil(Math.abs(paint$FontMetrics.b));
        this.g = (float)Math.ceil(Math.abs(paint$FontMetrics.c));
        char[] cArray = new char[2];
        this.i = 0.0f;
        this.h = 0.0f;
        float[] fArray = new float[2];
        int n5 = 0;
        for (c2 = ' '; c2 <= '~'; c2 = (char)((char)(c2 + 1))) {
            cArray[0] = c2;
            paint.a(cArray, 0, 1, fArray);
            float f2 = fArray[0];
            if (f2 > this.h) {
                this.h = f2;
            }
            ++n5;
        }
        this.i = this.e;
        this.j = (int)this.h + 2 * this.c;
        this.k = (int)this.i + 2 * this.d;
        for (c2 = ' '; c2 <= '~'; c2 = (char)(c2 + '\u0001')) {
            this.c(c2);
        }
        this.a();
        return true;
    }

    public void a(float f2, float f3, float f4, float f5, float[] fArray) {
        this.a(f2, f3, f4, f5);
        this.b.a(fArray);
    }

    public static void c() {
        int n2;
        if (w && (n2 = GLES20.glGetError()) != 0) {
            Throwable throwable = new Throwable();
            Log.b("GLTEXT", "GL error: " + n2, throwable);
        }
    }

    void a(float f2, float f3, float f4, float f5) {
        GLES20.glUseProgram((int)this.x.b());
        float[] fArray = new float[]{f2, f3, f4, f5};
        GLES20.glUniform4fv((int)this.y, (int)1, (float[])fArray, (int)0);
        GLES20.glActiveTexture((int)33984);
        GLES20.glUniform1i((int)this.z, (int)0);
        com.corrodinggames.rts.gameFramework.b.a.FontRenderer.c();
    }

    public void d() {
        this.b.a();
    }

    public void a(String string2, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = (float)this.k * this.o;
        float f9 = (float)this.j * this.n;
        int n2 = string2.length();
        float f10 = f9 / 2.0f - (float)this.c * this.n;
        float f11 = f8 / 2.0f - (float)this.d * this.o - this.g * this.o;
        if (this.q) {
            f10 = (int)f10;
            f11 = (int)f11;
        }
        f2 += f10;
        f3 += f11;
        float[] fArray = null;
        boolean bl2 = false;
        if (f4 == 0.0f && f7 == 0.0f && f5 == 0.0f && f6 == 0.0f) {
            bl2 = true;
        } else {
            fArray = new float[16];
            Matrix.setIdentityM((float[])fArray, (int)0);
            Matrix.translateM((float[])fArray, (int)0, (float)f2, (float)f3, (float)f4);
            if (f7 != 0.0f || f5 != 0.0f || f6 != 0.0f) {
                Matrix.rotateM((float[])fArray, (int)0, (float)f7, (float)0.0f, (float)0.0f, (float)1.0f);
                Matrix.rotateM((float[])fArray, (int)0, (float)f5, (float)1.0f, (float)0.0f, (float)0.0f);
                Matrix.rotateM((float[])fArray, (int)0, (float)f6, (float)0.0f, (float)1.0f, (float)0.0f);
            }
        }
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i2 = 0; i2 < n2; ++i2) {
            GlyphInfo c2;
            char c3 = string2.charAt(i2);
            int n3 = c3 - 32;
            if (n3 < 0 || n3 >= 96) {
                n3 = 95;
            }
            float f14 = f13;
            float f15 = f12;
            if (bl2) {
                f14 += f2;
                f15 += f3;
            }
            if ((c2 = this.a(c3)) == null) continue;
            this.b.a(f14, f15, f9, f8, c2);
            float f16 = (c2.c + this.p) * this.n;
            if (this.q) {
                f16 = (int)(f16 + 0.95f);
            }
            f13 += f16;
        }
    }

    public void a(String string2, float f2, float f3, float f4, float f5) {
        this.a(string2, f2, f3, f4, 0.0f, 0.0f, f5);
    }

    public void a(String string2, float f2, float f3, float f4) {
        this.a(string2, f2, f3, 0.0f, f4);
    }

    public void a(String string2, float f2, float f3) {
        this.a(string2, f2, f3, 0.0f, 0.0f);
    }

    public void a(float f2) {
        this.n = this.o = f2;
    }

    public float a(String string2) {
        float f2 = 0.0f;
        int n2 = string2.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string2.charAt(i2);
            GlyphInfo c3 = this.b(c2);
            if (c3 == null) continue;
            f2 += c3.c * this.n;
        }
        return f2 += n2 > 1 ? (float)(n2 - 1) * this.p * this.n : 0.0f;
    }

    public static void b(String string2) {
        Log.b("GLTEXT", "debug:" + string2);
    }
}

