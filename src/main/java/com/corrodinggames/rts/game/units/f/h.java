/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.f;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.f.e;

import android.graphics.RectF;

public final class h
extends e {
    public RectF a = new RectF();
    public float b;
    public float c;
    public float d;
    public float e;

    @Override
    public final boolean a(BaseUnit am2) {
        float f2 = am2.cj;
        float f3 = am2.posX;
        float f4 = am2.posY;
        return this.b - f2 <= f3 && f3 <= this.c + f2 && this.d - f2 <= f4 && f4 <= this.e + f2;
    }
}

