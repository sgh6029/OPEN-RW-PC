/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.a.a;

import com.corrodinggames.rts.a.a.l;
import com.corrodinggames.rts.a.a.n;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.GameUtils;

public class d
extends l {
    int a;

    public void a() {
        int n2;
        com.corrodinggames.rts.gameFramework.GameEngine.log("Running unit tests - maths (v3)");
        GameUtils.i(100.0f, 100.0f);
        GameUtils.i(0.0f, 100.0f);
        GameUtils.i(100.0f, 0.0f);
        GameUtils.i(0.0f, -100.0f);
        GameUtils.i(-100.0f, 0.0f);
        GameUtils.i(0.0f, 0.0f);
        com.corrodinggames.rts.gameFramework.GameEngine.log("fast_atan2 - NaN");
        GameUtils.i(Float.NaN, 0.0f);
        GameUtils.i(0.0f, Float.NaN);
        GameUtils.i(Float.NaN, Float.NaN);
        com.corrodinggames.rts.gameFramework.GameEngine.log("fast_atan2 - Max");
        GameUtils.i(Float.MAX_VALUE, 0.0f);
        GameUtils.i(Float.MIN_VALUE, 0.0f);
        GameUtils.i(0.0f, Float.MAX_VALUE);
        GameUtils.i(0.0f, Float.MIN_VALUE);
        com.corrodinggames.rts.gameFramework.GameEngine.log("fast_atan2 - NaN+Max");
        GameUtils.i(Float.MAX_VALUE, Float.NaN);
        GameUtils.i(Float.MIN_VALUE, Float.MAX_VALUE);
        GameUtils.i(Float.MAX_VALUE, Float.MIN_VALUE);
        GameUtils.i(900000.0f, 900000.0f);
        GameUtils.i(3.4028236E33f, 3.4028236E33f);
        GameUtils.i(3.4028236E34f, 3.4028236E34f);
        GameUtils.i(3.4028234E35f, 3.4028234E35f);
        GameUtils.i(3.4028236E36f, 3.4028236E36f);
        GameUtils.i(3.4028235E37f, 3.4028235E37f);
        GameUtils.i(Float.MAX_VALUE, Float.MAX_VALUE);
        com.corrodinggames.rts.gameFramework.GameEngine.log("fast_atan2 - max,max");
        GameUtils.i(Float.MAX_VALUE, Float.MAX_VALUE);
        GameUtils.i(Float.MIN_VALUE, Float.MIN_VALUE);
        com.corrodinggames.rts.gameFramework.GameEngine.log("cos/sin");
        n.a(GameUtils.k(0.0f), 1.0f);
        n.a(GameUtils.k(360.0f), 1.0f);
        n.a(GameUtils.k(10800.0f), 1.0f);
        n.a(GameUtils.k(45.0f), 0.70710677f);
        n.a(GameUtils.k(90.0f), 0.0f);
        n.a(GameUtils.k(450.0f), 0.0f);
        n.a(GameUtils.k(10890.0f), 0.0f);
        n.a(GameUtils.j(0.0f), 0.0f);
        n.a(GameUtils.j(90.0f), 1.0f);
        GameUtils.k(-999999.0f);
        GameUtils.k(999999.0f);
        GameUtils.k(Float.MAX_VALUE);
        GameUtils.k(Float.MIN_VALUE);
        GameUtils.j(Float.MAX_VALUE);
        GameUtils.j(Float.MIN_VALUE);
        com.corrodinggames.rts.gameFramework.GameEngine.log("diff sin(0):  " + String.format("%.12f", Float.valueOf(GameUtils.j(0.0f) - (float)StrictMath.sin(0.0))));
        com.corrodinggames.rts.gameFramework.GameEngine.log("diff sin(45): " + String.format("%.12f", Float.valueOf(GameUtils.j(45.0f) - (float)StrictMath.sin(0.7853981633974483))));
        com.corrodinggames.rts.gameFramework.GameEngine.log("diff sin(90): " + String.format("%.12f", Float.valueOf(GameUtils.j(90.0f) - (float)StrictMath.sin(1.5707963267948966))));
        com.corrodinggames.rts.gameFramework.GameEngine.log("diff sin(180):" + String.format("%.12f", Float.valueOf(GameUtils.j(180.0f) - (float)StrictMath.sin(Math.PI))));
        com.corrodinggames.rts.gameFramework.GameEngine.log("diff sin(360):" + String.format("%.12f", Float.valueOf(GameUtils.j(360.0f) - (float)StrictMath.sin(Math.PI * 2))));
        com.corrodinggames.rts.gameFramework.GameEngine.log("Testing squareroot");
        for (n2 = 0; n2 < 1005; ++n2) {
            n.a((float)GameUtils.a(n2), GameUtils.d(GameUtils.a((float)n2)));
        }
        n2 = 5;
        int n3 = 0;
        com.corrodinggames.rts.gameFramework.GameEngine.log("=== cos/sin tests (runs:" + n2 + ")");
        Long l2 = PerformanceProfiler.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < 2000; ++i3) {
                if (GameUtils.k(i3) == 0.0f) {
                    ++n3;
                }
                if (GameUtils.j(i3) != 0.0f) continue;
                ++n3;
            }
        }
        Long l3 = PerformanceProfiler.a();
        double d2 = PerformanceProfiler.a(l2, (long)l3);
        this.a += n3;
        com.corrodinggames.rts.gameFramework.GameEngine.log("Took: " + d2);
    }
}

