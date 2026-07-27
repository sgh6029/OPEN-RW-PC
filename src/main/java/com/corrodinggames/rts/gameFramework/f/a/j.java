/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f.a;

import com.corrodinggames.rts.gameFramework.f.a.h;
import com.corrodinggames.rts.gameFramework.f.d;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.m.y;

import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Rect;
import android.graphics.RectF;

import java.io.IOException;
import java.util.ArrayList;

public class j
extends com.corrodinggames.rts.gameFramework.f.a.l {
    String a;
    Paint b = new ag();
    h c = com.corrodinggames.rts.gameFramework.f.a.h.l;
    ArrayList<String> d;

    public j() {
        this.b.a(Paint$Align.b);
        this.b.b(-16777216);
        this.a(18.0f);
    }

    public void a(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.b(this.b, f2);
        this.e();
    }

    public void a(int n2) {
        this.b.b(n2);
    }

    @Override
    public String a() {
        return super.a() + " (text:" + this.a + ")";
    }

    @Override
    public void a(float f2, float f3) {
        super.a(f2, f3);
        y y2 = this.d();
        RectF rectF = this.a(new RectF(), f2, f3);
        this.c.a(y2, rectF);
        if (this.a == null) {
            return;
        }
        if (this.d == null) {
            try {
                y2.a(this.a, rectF.d(), rectF.d - this.l, this.b);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            int n2 = 0;
            for (String string2 : this.d) {
                Paint paint = this.b;
                try {
                int n3 = com.corrodinggames.rts.gameFramework.f.d.a(paint);
                    y2.a(string2, rectF.d(), rectF.b + this.k + (float)n3 + (float)(n2 * n3), paint);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                ++n2;
            }
        }
    }

    public void a(String string2) {
        this.a = string2;
        this.e();
    }

    public Rect c() {
        RectF rectF = this.a(new RectF(), 0.0f, 0.0f);
        Rect rect = new Rect();
        rect.d = (int)rectF.d;
        rect.top = (int)rectF.b;
        rect.left = (int)rectF.left;
        rect.c = (int)rectF.c;
        rect.c = 10000;
        return rect;
    }

    @Override
    public void b() {
        super.b();
        y y2 = this.d();
        Rect rect = this.c();
        this.d = new ArrayList(com.corrodinggames.rts.gameFramework.f.d.a(this.a, rect, this.b, this.b, true));
        this.i = rect.b();
        this.j = rect.c();
        this.i += this.m + this.n;
        this.j += this.k + this.l;
    }
}

