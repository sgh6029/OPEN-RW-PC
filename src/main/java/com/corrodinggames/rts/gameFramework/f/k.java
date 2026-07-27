/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.f.l;
import com.corrodinggames.rts.gameFramework.g.d;
import com.corrodinggames.rts.gameFramework.h.a;
import com.corrodinggames.rts.gameFramework.m.ag;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.RectF;
import android.graphics.Typeface;

import java.io.IOException;
import java.util.ArrayList;

public class k {
    g a;
    com.corrodinggames.rts.gameFramework.GameEngine b;
    Paint c;
    Paint d;
    RectF e = new RectF();

    k(com.corrodinggames.rts.gameFramework.GameEngine l2, g g2) {
        this.a = g2;
        this.b = l2;
        this.a();
    }

    public void a() {
        this.d = new Paint();
        this.d.a(255, 255, 255, 255);
        this.d.a(true);
        this.d.c(true);
        this.d.a(Typeface.a(Typeface.c, 1));
        this.b.a(this.d, 16.0f);
        this.c = new Paint();
        this.c.a(255, 255, 255, 255);
        this.c.a(true);
        this.c.c(true);
        this.c.a(Typeface.a(Typeface.c, 0));
        this.b.a(this.c, 16.0f);
    }

    public int a(float f2, int n2) {
        Object object;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        com.corrodinggames.rts.gameFramework.g.a a2 = l2.cg;
        if (a2.e() == com.corrodinggames.rts.gameFramework.g.f.none) {
            return n2;
        }
        ArrayList<d> arrayList = a2.d();
        ArrayList<l> arrayList2 = new ArrayList<l>();
        String string2 = a2.e().name();
        string2 = com.corrodinggames.rts.gameFramework.h.a.a("gui.leaderboard.type." + string2, new Object[0]);
        l l3 = new l("", this.c, string2, this.d);
        arrayList2.add(l3);
        int n3 = n2;
        int n4 = 6;
        int n5 = (int)(l2.cl - l2.cq) - n4;
        int n6 = (int)(20.0f * l2.cj);
        for (d d2 : arrayList) {
            object = d2.a() ? this.d : this.c;
            l l4 = new l(a2.a(d2), this.d, " " + d2.b(), (Paint)object);
            l4.g = d2.c();
            l4.c = d2.d();
            arrayList2.add(l4);
        }
        float f3 = 0f;
        try {
            f3 = l2.bO.b(string2, this.c);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        float f4 = 0.0f;
        for (l l4 : arrayList2) {
            if (!(l4.d > f4)) continue;
            f4 = l4.d;
        }
        for (l l4 : arrayList2) {
            float f5;
            if (GameUtils.c(l4.d - f4) < 40.0f) {
                l4.d = f4;
            }
            if (!((f5 = l4.d + l4.h) > f3)) continue;
            f3 = f5;
        }
        f3 = GameUtils.e(f3 / 20.0f) * 20.0f;
        this.e.left = (n5 -= (int)(f3 + 0.5f)) - n4;
        this.e.c = (float)(n5 + n4) + f3;
        this.e.b = n3 - n4 - n6;
        this.e.d = n3 + n4 + (arrayList2.size() - 1) * n6;
        object = new ag();
        ((Paint)object).b(Color.a(100, 0, 0, 0));
        ((Paint)object).a(Paint$Style.c);
        try {
            l2.bO.a(this.e, (Paint)object);
        for (int i2 = 0; i2 < arrayList2.size(); ++i2) {
            l l5 = (l)arrayList2.get(i2);
            l5.a.b(l5.c);
            l2.bO.a(l5.b, (float)n5, (float)n3, l5.a);
            l5.e.b(l5.g);
            l2.bO.a(l5.f, (float)n5 + l5.d, (float)n3, l5.e);
            n3 += n6;
        }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return n3 + n6;
    }
}

