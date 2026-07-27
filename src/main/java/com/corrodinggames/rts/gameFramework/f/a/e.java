/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f.a;

import java.io.IOException;

import com.corrodinggames.rts.gameFramework.f.a.h;
import com.corrodinggames.rts.gameFramework.m.aa;
import com.corrodinggames.rts.gameFramework.m.y;

import android.graphics.Paint;
import android.graphics.Rect;

public class e
extends h {
    int a;
    int b;
    float c;
    float d;
    public boolean e = true;
    public boolean f = false;
    public float g = 1.0f;
    static Rect h = new Rect();
    static Rect i = new Rect();

    public e() {
    }

    public e(com.corrodinggames.rts.gameFramework.m.Texture_M e2, int n2, int n3) {
        this.a(e2);
        this.a(e2, n2, n3);
    }

    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, int n2, int n3) {
        this.a = n2;
        this.b = n3;
        this.c = (float)n2 / (float)e2.p;
        this.d = (float)n3 / (float)e2.q;
    }

    public e a() {
        e e2 = new e();
        e2.a(this);
        return e2;
    }

    @Override
    public void a(h h2) {
        e e2 = (e)h2;
        this.a = e2.a;
        this.b = e2.b;
        this.c = e2.c;
        this.d = e2.d;
        this.e = e2.e;
        super.a(e2);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2) {
        super.a(e2);
    }

    @Override
    public void a(y y2, Rect rect) {
        this.b(y2, rect);
        if (this.q != null) {
            // empty if block
        }
    }

    public void b(y y2, Rect rect) {
        com.corrodinggames.rts.gameFramework.m.Texture_M e2 = this.p;
        Paint paint = this.o;
        this.a(y2, e2, paint, rect);
    }

    private boolean c() {
        return true;
    }

    private void a(y y2, com.corrodinggames.rts.gameFramework.m.Texture_M e2, Paint paint, Rect rect) {
        int n2;
        int n3 = rect.left;
        int n4 = rect.top;
        int n5 = rect.b();
        int n6 = rect.c();
        int n7 = this.a;
        int n8 = this.b;
        if (!this.e) {
            if (n7 > n5 / 2) {
                n7 = n5 / 2;
            }
            if (n8 > n6 / 2) {
                n8 = n6 / 2;
            }
        } else {
            float f2 = 1.0f;
            n2 = n5 / 2;
            int n9 = n6 / 2;
            if ((float)n7 * f2 > (float)n2) {
                f2 = (float)n2 / (float)n7;
            }
            if ((float)n8 * f2 > (float)n9) {
                f2 = (float)n9 / (float)n8;
            }
            n7 = (int)((float)this.a * f2);
            n8 = (int)((float)this.b * f2);
        }
        int n10 = n5 - 2 * n7;
        n2 = n6 - 2 * n8;
        float f3 = this.c;
        float f4 = this.d;
        if (this.c()) {
            this.a(y2, e2, paint, n3 + n7, n4 + 0, n10, n8, f3, 0.0f, 1.0f - f3, f4, this.f);
            this.a(y2, e2, paint, n3 + 0, n4 + n8, n7, n2, 0.0f, f4, f3, 1.0f - f4, this.f);
            this.a(y2, e2, paint, n3 + n7, n4 + n6 - n8, n10, n8, f3, 1.0f - f4, 1.0f - f3, 1.0f, this.f);
            this.a(y2, e2, paint, n3 + n5 - n7, n4 + n8, n7, n2, 1.0f - f3, f4, 1.0f, 1.0f - f4, this.f);
            this.a(y2, e2, paint, n3 + 0, n4 + 0, n7, n8, 0.0f, 0.0f, this.c, this.d);
            this.a(y2, e2, paint, n3 + n5 - n7, n4 + 0, n7, n8, 1.0f - this.c, 0.0f, 1.0f, this.d);
            this.a(y2, e2, paint, n3 + 0, n4 + n6 - n8, n7, n8, 0.0f, 1.0f - this.d, this.c, 1.0f);
            this.a(y2, e2, paint, n3 + n5 - n7, n4 + n6 - n8, n7, n8, 1.0f - this.c, 1.0f - this.d, 1.0f, 1.0f);
        }
        this.a(y2, e2, paint, n3 + n7, n4 + n8, n10, n2, f3, f4, 1.0f - f3, 1.0f - f4, this.f);
    }

    public void a(y y2, com.corrodinggames.rts.gameFramework.m.Texture_M e2, Paint paint, int n2, int n3, int n4, int n5, float f2, float f3, float f4, float f5) {
        this.a(y2, e2, paint, n2, n3, n4, n5, f2, f3, f4, f5, false);
    }

    public void a(y y2, com.corrodinggames.rts.gameFramework.m.Texture_M e2, Paint paint, int n2, int n3, int n4, int n5, float f2, float f3, float f4, float f5, boolean bl2) {
        Rect rect = h;
        Rect rect2 = i;
        rect.a((int)(f2 * (float)e2.p), (int)(f3 * (float)e2.q), (int)(f4 * (float)e2.p), (int)(f5 * (float)e2.q));
        rect2.a(n2, n3, n2 + n4, n3 + n5);
        if (!bl2) {
            try {
                y2.a(e2, rect, rect2, paint);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            aa.a(y2, e2, rect, rect2, paint, 0, 0, 0, 0, this.g);
        }
    }

    public /* synthetic */ Object clone() {
        return this.a();
    }
}

