/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.corrodinggames.rts.gameFramework.b.a;

import android.opengl.GLES20;
import com.corrodinggames.rts.gameFramework.b.a.a.ShaderProgramBase;
import com.corrodinggames.rts.gameFramework.b.a.GlyphInfo;
import com.corrodinggames.rts.gameFramework.b.a.FontPage;
import com.corrodinggames.rts.gameFramework.b.a.TextMesh;

public class TextRenderer {
    com.corrodinggames.rts.gameFramework.b.a.FontRenderer a;
    TextMesh b;
    float[] c;
    int d;
    int e;
    int f;
    private float[] h;
    private int i;
    int g;

    public TextRenderer(int n2, ShaderProgramBase b2, com.corrodinggames.rts.gameFramework.b.a.FontRenderer b3) {
        this.a = b3;
        this.c = new float[n2 * 4 * 5];
        this.b = new TextMesh(n2 * 4, n2 * 6);
        this.d = 0;
        this.e = n2;
        this.f = 0;
        short[] sArray = new short[n2 * 6];
        int n3 = sArray.length;
        int n4 = 0;
        int n5 = 0;
        while (n5 < n3) {
            sArray[n5 + 0] = (short)(n4 + 0);
            sArray[n5 + 1] = (short)(n4 + 1);
            sArray[n5 + 2] = (short)(n4 + 2);
            sArray[n5 + 3] = (short)(n4 + 2);
            sArray[n5 + 4] = (short)(n4 + 3);
            sArray[n5 + 5] = (short)(n4 + 0);
            n5 += 6;
            n4 = (short)(n4 + 4);
        }
        this.b.a(sArray, 0, n3);
        this.i = GLES20.glGetUniformLocation((int)b2.b(), (String)"u_MVPMatrix");
    }

    public void a(float[] fArray) {
        this.f = 0;
        this.d = 0;
        this.h = fArray;
        this.g = -1;
    }

    void a(GlyphInfo c2) {
        int n2 = c2.b;
        if (this.g == n2) {
            return;
        }
        this.a();
        FontPage e2 = (FontPage)this.a.s.get(n2);
        GLES20.glBindTexture((int)3553, (int)e2.a);
        this.g = n2;
    }

    public void a() {
        if (this.f > 0) {
            GLES20.glUniformMatrix4fv((int)this.i, (int)1, (boolean)false, (float[])this.h, (int)0);
            this.b.a(this.c, 0, this.d);
            this.b.a();
            this.b.a(4, 0, this.f * 6);
            this.b.b();
            this.f = 0;
            this.d = 0;
        }
    }

    public void a(float f2, float f3, float f4, float f5, GlyphInfo c2) {
        if (this.f == this.e) {
            this.a();
        }
        this.a(c2);
        float f6 = f4 / 2.0f;
        float f7 = f5 / 2.0f;
        float f8 = f2 - f6;
        float f9 = f3 - f7;
        float f10 = f2 + f6;
        float f11 = f3 + f7;
        this.c[this.d++] = f8;
        this.c[this.d++] = f9;
        this.c[this.d++] = c2.d;
        this.c[this.d++] = c2.g;
        this.c[this.d++] = f10;
        this.c[this.d++] = f9;
        this.c[this.d++] = c2.f;
        this.c[this.d++] = c2.g;
        this.c[this.d++] = f10;
        this.c[this.d++] = f11;
        this.c[this.d++] = c2.f;
        this.c[this.d++] = c2.e;
        this.c[this.d++] = f8;
        this.c[this.d++] = f11;
        this.c[this.d++] = c2.d;
        this.c[this.d++] = c2.e;
        ++this.f;
    }
}

