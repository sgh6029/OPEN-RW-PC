/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import android.graphics.PointF;

public final class Vector3D {
    public float a;
    public float b;
    public float c;

    public void a(PointF pointF) {
        this.a = pointF.x;
        this.b = pointF.b;
        this.c = 0.0f;
    }
}

