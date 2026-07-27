/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f.a;

import com.corrodinggames.rts.gameFramework.f.a.h;
import com.corrodinggames.rts.gameFramework.f.a.l;
import com.corrodinggames.rts.gameFramework.m.y;

import android.graphics.RectF;

public class n
extends l {
    h b = com.corrodinggames.rts.gameFramework.f.a.h.j;

    @Override
    public void a(float f2, float f3) {
        super.a(f2, f3);
        y y2 = this.d();
        RectF rectF = this.a(new RectF(), f2, f3);
        this.b.a(y2, rectF);
    }
}

