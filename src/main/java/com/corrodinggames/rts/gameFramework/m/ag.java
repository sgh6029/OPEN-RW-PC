/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.m;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ShaderProgram;

import android.graphics.Paint;
import android.graphics.Typeface;

public class ag
extends Paint {
    public static final ag r = new ag();
    boolean s = false;
    ShaderProgram t;
    boolean u = false;

    public void o() {
        this.u = true;
    }

    public void c(float f2) {
        super.b(f2);
    }

    @Override
    public void b(float f2) {
        if (this.u) {
            GameEngine.b("UniquePaint changed when locked down:");
            GameEngine.b("from:" + this.k() + " to: " + f2);
            GameEngine.T();
        }
        super.b(f2);
    }

    @Override
    public Typeface a(Typeface typeface) {
        if (this.u) {
            GameEngine.b("UniquePaint changed when locked down:");
            GameEngine.T();
        }
        return super.a(typeface);
    }

    public static void b(Paint paint) {
        ((ag)paint).o();
    }

    public boolean p() {
        return this.s;
    }

    @Override
    public void a(boolean bl2) {
        this.s = bl2;
        super.a(bl2);
    }

    public ShaderProgram q() {
        return this.t;
    }

    public void a(ShaderProgram ae2) {
        this.t = ae2;
    }

    static {
        r.b(-1);
        r.o();
    }
}

