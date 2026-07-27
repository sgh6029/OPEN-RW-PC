/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import java.io.IOException;

import android.graphics.Paint;

public class l {
    Paint a;
    String b;
    int c = -1;
    float d;
    Paint e;
    String f;
    int g = -1;
    float h;

    public l(String string2, Paint paint, String string3, Paint paint2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        this.a = paint;
        this.b = string2;
        try {
            this.d = l2.bO.b(string2, paint);
            this.e = paint2;
            this.f = string3;
            this.h = l2.bO.b(string3, paint2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
