/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.ProfilerSection;

import android.graphics.Paint;
import android.graphics.Rect;

import com.corrodinggames.rts.gameFramework.ProfilerData;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;

public final class PerformanceProfiler {
    GameEngine a;
    public int b = 0;
    public static int c = 40;
    public int d = 0;
    ProfilerData e = new ProfilerData(this);
    Paint f = new Paint();
    Rect g = new Rect();
    int h = -1;

    public PerformanceProfiler(GameEngine l2) {
        this.a = l2;
    }

    public static final long a() {
        return System.nanoTime();
    }

    public static final float a(long l2) {
        return (float)(System.nanoTime() - l2) / 1000000.0f;
    }

    public static final double a(long l2, long l3) {
        return (double)(l3 - l2) / 1000000.0;
    }

    public static final void a(String string2, long l2) {
        GameEngine.log(string2 + "" + PerformanceProfiler.a(PerformanceProfiler.a(l2)));
    }

    public final void a(ProfilerSection bs2) {
    }

    public final void b(ProfilerSection bs2) {
    }

    public static final String a(double d2) {
        return "" + com.corrodinggames.rts.gameFramework.GameUtils.a(d2, 3) + "ms";
    }

    public static final String b(double d2) {
        return "" + d2 / 1000000.0 + "ms";
    }

    public final void b() {
    }

    public final void c() {
    }

    public final void a(boolean bl2, boolean bl3) {
    }
}

