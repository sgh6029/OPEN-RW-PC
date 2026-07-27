/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class ProfilerTimer {
    boolean a = true;
    int b;
    double c;
    double d;
    long e;
    String f;

    public ProfilerTimer(String string2) {
        this.f = string2;
    }

    public ProfilerTimer(String string2, boolean bl2) {
        this.f = string2;
        this.a = bl2;
    }

    public void a() {
        if (!this.a) {
            return;
        }
        this.e = this.e != 0L ? Long.MIN_VALUE : PerformanceProfiler.a();
    }

    public void b() {
        if (!this.a) {
            return;
        }
        long l2 = PerformanceProfiler.a();
        double d2 = PerformanceProfiler.a(this.e, l2);
        this.c += d2;
        ++this.b;
        if (d2 > this.d) {
            this.d = d2;
        }
        this.e = 0L;
    }

    public String c() {
        if (!this.a) {
            return "{ Not enabled }";
        }
        String string2 = "{ ";
        if (this.b > 0) {
            string2 = string2 + "#" + this.b + " = ";
            string2 = string2 + "peak:" + com.corrodinggames.rts.gameFramework.GameUtils.a(this.d, 2) + "ms ";
            string2 = string2 + "avg:" + com.corrodinggames.rts.gameFramework.GameUtils.a(this.c / (double)this.b, 2) + "ms ";
            string2 = string2 + "total:" + com.corrodinggames.rts.gameFramework.GameUtils.a(this.c, 2) + "ms ";
        } else {
            string2 = string2 + "#0 = NA";
        }
        string2 = string2 + "}";
        return string2;
    }

    public void d() {
        if (!this.a) {
            return;
        }
        this.b();
        this.e();
    }

    public void e() {
        if (!this.a) {
            return;
        }
        if (this.b > 0) {
            GameEngine.log(GameEngine.a(this.f + " - " + this.c(), "\u001b[36m"));
            this.f();
        }
    }

    public void f() {
        this.b = 0;
        this.c = 0.0;
        this.d = 0.0;
    }
}

