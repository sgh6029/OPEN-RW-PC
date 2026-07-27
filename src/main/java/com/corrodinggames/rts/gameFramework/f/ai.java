/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.f.ae;
import com.corrodinggames.rts.gameFramework.f.af;

import android.graphics.Paint;

import java.io.IOException;

import com.corrodinggames.rts.gameFramework.GameEngine;

public class ai
extends af {
    String d;
    final /* synthetic */ ae e;

    @Override
    public int a(Paint paint) {
        GameEngine l2 = GameEngine.getInstance();
        Paint paint2 = this.b(paint);
        int n2 = 0;
        try {
            n2 = l2.bO.b(this.d, paint2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (GameEngine.at()) {
            // empty if block
        }
        return n2;
    }

    public Paint b(Paint paint) {
        return paint;
    }

    ai(ae ae2, String string2) {
        this.e = ae2;
        this.d = string2;
    }

    public ai b(String string2) {
        ai ai2 = new ai(this.e, string2);
        return ai2;
    }
}

