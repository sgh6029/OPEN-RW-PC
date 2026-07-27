/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.m.y;

import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Rect;
import android.graphics.RectF;

import java.io.IOException;
import java.util.ArrayList;

public class d {
    static Rect a = new Rect();
    static ArrayList b = new ArrayList();
    static final RectF c = new RectF();
    static final RectF d = new RectF();

    public static int a(Paint paint) throws IOException {
        String string2 = "abcABC123!|";
            return GameEngine.getInstance().bO.a(string2, paint) + 4;
    }

    public static int b(Paint paint) {
        String string2 = "abcABC123!|";
        int n2 = 0;
        try {
            n2 = GameEngine.getInstance().bO.a(string2, paint);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (GameEngine.isPCVersionStatic2) {
            return n2 + 2;
        }
        return n2;
    }

    public static ArrayList a(String string2, Rect rect, Paint paint, Paint paint2, boolean bl2) {
        int n2;
        b.clear();
        String string3 = "";
        int n3 = 0;
        for (int i2 = 0; i2 < string2.length() && (n2 = paint2.a(string2, i2, string2.length(), true, (float)(rect.b() - 5), null)) != 0; i2 += n2) {
            String string4;
            int n4;
            int n5 = string2.indexOf("\n", i2 + 1);
            if (n5 != -1 && n5 < i2 + n2) {
                n2 = n5 - i2;
            } else if (i2 + n2 < string2.length() && (n4 = (string4 = string2.substring(i2, i2 + n2)).lastIndexOf(" ")) != -1 && n4 != 0) {
                n2 = n4;
            }
            string4 = string2.substring(i2, i2 + n2);
            string4 = string4.replaceAll("(\\n)", "");
            if (string4.length() > string3.length()) {
                string3 = string4;
                n3 = b.size();
            }
            b.add(string4);
        }
        try {
            rect.d = rect.top + b.size() * com.corrodinggames.rts.gameFramework.f.d.a(paint2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (bl2) {
            float f2;
            float f3 = rect.d();
            Paint paint3 = paint2;
            if (n3 == 0) {
                paint3 = paint;
            }
            try {
                if ((f2 = (float)GameEngine.getInstance().bO.b(string3, paint3)) < (float)rect.b()) {
                    rect.left = (int)(f3 - f2 / 2.0f);
                    rect.c = (int)(f3 + f2 / 2.0f);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return b;
    }

    public static void a(String string2, float f2, float f3, Paint paint, Paint paint2, float f4, float f5, float f6, float f7) {
        y y2 = GameEngine.getInstance().bO;
        float f8 = 0f;
        try {
            f8 = y2.b(string2, paint);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            d.a(f2, f3, f2 + f8, f3 + (float)y2.a(string2, paint));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c.a(d);
        if (paint.j() == Paint$Align.b) {
            c.a(-(f8 / 2.0f), 0.0f);
        }
        com.corrodinggames.rts.gameFramework.f.d.c.left -= f4;
        com.corrodinggames.rts.gameFramework.f.d.c.b -= f5;
        com.corrodinggames.rts.gameFramework.f.d.c.c += f6;
        com.corrodinggames.rts.gameFramework.f.d.c.d += f7;
        try {
            y2.a(c, paint2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            y2.a(string2, com.corrodinggames.rts.gameFramework.f.d.d.left, com.corrodinggames.rts.gameFramework.f.d.d.d, paint);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static float a(Texture_M e2, float f2, float f3) {
        return com.corrodinggames.rts.gameFramework.f.d.a(e2, f2, f3, f2, f3);
    }

    public static float a(Texture_M e2, float f2, float f3, float f4, float f5) {
        float f6;
        float f7 = e2.p;
        float f8 = e2.q;
        float f9 = 1.0f;
        if (f7 * f9 < f2 && (f6 = f2 / f7) > f9) {
            f9 = f6;
        }
        if (f8 * f9 < f3 && (f6 = f3 / f8) > f9) {
            f9 = f6;
        }
        if (f7 * f9 > f4 && (f6 = f4 / f7) < f9) {
            f9 = f6;
        }
        if (f8 * f9 > f5 && (f6 = f5 / f8) < f9) {
            f9 = f6;
        }
        return f9;
    }
}

