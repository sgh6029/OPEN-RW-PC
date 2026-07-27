/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.effect;

import java.io.IOException;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public final class g {
    public String a;
    public int b = 25;
    public int c = 25;
    public int d = 1;
    public int e = 1;
    public int f = 26;
    public int g = 26;
    public int h = Integer.MAX_VALUE;
    public Texture_M i = null;
    public Texture_M j = null;
    public boolean k = false;
    static final Rect l = new Rect();
    static final RectF m = new RectF();

    public void a() {
        this.j = this.i.h();
        this.j.j();
        for (int i2 = 0; i2 < this.j.m(); ++i2) {
            for (int i3 = 0; i3 < this.j.l(); ++i3) {
                int n2 = this.j.a(i2, i3);
                this.j.a(i2, i3, Color.a(Color.a(n2), 0, 0, 0));
            }
        }
        this.j.p();
        this.j.s();
    }

    public void a(int n2, float f2, float f3, Paint paint) {
        Rect rect = l;
        RectF rectF = m;
        boolean bl2 = true;
        GameEngine l2 = GameEngine.getInstance();
        int n3 = n2;
        int n4 = 0;
        if (n3 >= this.h) {
            n4 += n3 / this.h;
            n3 %= this.h;
        }
        int n5 = this.d + n3 * this.f;
        int n6 = this.e + n4 * this.g;
        l.a(n5, n6, n5 + this.b, n6 + this.c);
        rectF.a(f2, f3, f2 + (float)rect.b(), f3 + (float)rect.c());
        if (bl2) {
            rectF.a(-rectF.b() / 2.0f, -rectF.c() / 2.0f);
        }
        try {
            l2.bO.a(this.i, rect, rectF, paint);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

