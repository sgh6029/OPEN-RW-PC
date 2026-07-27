/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.m;

import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public final class q {
    public final m a = new m();
    public int b;
    public Class c;

    public q(Class clazz) {
        this.c = clazz;
    }

    public final Rect a(Rect rect) {
        if (this.b >= this.a.a) {
            this.a.add(new Rect());
        }
        Rect rect2 = (Rect)this.a.a(this.b);
        rect2.top = rect.top;
        rect2.d = rect.d;
        rect2.left = rect.left;
        rect2.c = rect.c;
        ++this.b;
        return rect2;
    }

    public final RectF a(RectF rectF) {
        if (this.b >= this.a.a) {
            this.a.add(new RectF());
        }
        RectF rectF2 = (RectF)this.a.a(this.b);
        rectF2.b = rectF.b;
        rectF2.d = rectF.d;
        rectF2.left = rectF.left;
        rectF2.c = rectF.c;
        ++this.b;
        return rectF2;
    }

    public final Paint a(Paint paint) {
        if (paint == null) {
            return null;
        }
        if (this.b >= this.a.a) {
            this.a.add(new Paint());
        }
        Paint paint2 = (Paint)this.a.a(this.b);
        paint2.a(paint);
        ++this.b;
        return paint2;
    }
}

