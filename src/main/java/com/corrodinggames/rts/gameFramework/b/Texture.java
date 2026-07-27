/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.b;

import com.corrodinggames.rts.gameFramework.b.IRenderCallback;

import android.graphics.RectF;
import android.util.Log;

import com.corrodinggames.rts.gameFramework.b.IGraphicsEngine;
import java.util.WeakHashMap;

public abstract class Texture
implements IRenderCallback {
    protected int a = -1;
    protected int b;
    protected int c = -1;
    protected int d = -1;
    protected int e;
    protected int f;
    protected float g;
    protected float h;
    private boolean l;
    private boolean m;
    public int i;
    public boolean j;
    protected IGraphicsEngine k = null;
    private static WeakHashMap n = new WeakHashMap();
    private static ThreadLocal o = new ThreadLocal();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected Texture(IGraphicsEngine k2, int n2, int n3) {
        this.a(k2);
        this.a = n2;
        this.b = n3;
        WeakHashMap weakHashMap = n;
        synchronized (weakHashMap) {
            n.put(this, null);
        }
    }

    protected Texture() {
        this(null, 0, 0);
    }

    protected void a(IGraphicsEngine k2) {
        this.k = k2;
    }

    public void a(int n2, int n3) {
        this.c = n2;
        this.d = n3;
        this.e = n2 > 0 ? com.corrodinggames.rts.gameFramework.b.Texture.a(n2) : 0;
        this.f = n3 > 0 ? com.corrodinggames.rts.gameFramework.b.Texture.a(n3) : 0;
        this.g = this.e == 0 ? 0.0f : 1.0f / (float)this.e;
        this.h = this.f == 0 ? 0.0f : 1.0f / (float)this.f;
        if (this.e > 4096 || this.f > 4096) {
            Log.a("BasicTexture", String.format("secondBitmap is too large: %d x %d", this.e, this.f), new Exception());
        }
    }

    public static int a(int n2) {
        if (n2 <= 0 || n2 > 0x40000000) {
            throw new IllegalArgumentException("n is invalid: " + n2);
        }
        --n2;
        n2 |= n2 >> 16;
        n2 |= n2 >> 8;
        n2 |= n2 >> 4;
        n2 |= n2 >> 2;
        n2 |= n2 >> 1;
        return n2 + 1;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public boolean f() {
        return this.l;
    }

    protected void a(boolean bl2) {
        this.l = bl2;
    }

    public abstract void b(IGraphicsEngine var1);

    protected abstract boolean c(IGraphicsEngine var1);

    protected abstract int g();

    public abstract void b(int var1);

    public abstract int h();

    public boolean i() {
        return this.b == 1;
    }

    public void j() {
        this.m = true;
        this.k();
    }

    private void k() {
        IGraphicsEngine k2 = this.k;
        if (k2 != null && this.a != -1) {
            k2.a(this);
            this.a = -1;
        }
        this.b = 0;
        this.a((IGraphicsEngine)null);
    }

    protected void finalize() {
        o.set(Texture.class);
        this.j();
        o.set(null);
    }

    public void a(RectF rectF) {
        float f2;
        int n2 = this.b();
        int n3 = this.c();
        int n4 = this.d();
        int n5 = this.e();
        rectF.left /= (float)n4;
        rectF.c /= (float)n4;
        rectF.b /= (float)n5;
        rectF.d /= (float)n5;
        float f3 = (float)n2 / (float)n4;
        if (rectF.c > f3) {
            rectF.c = f3;
        }
        if (rectF.d > (f2 = (float)n3 / (float)n5)) {
            rectF.d = f2;
        }
    }

    public void a(RectF rectF, RectF rectF2) {
        Texture b2 = this;
        float f2 = (float)b2.c() / (float)b2.e();
        float f3 = (float)b2.b() / (float)b2.d();
        if (rectF.c > f3) {
            rectF2.c = rectF2.left + rectF2.b() * (f3 - rectF.left) / rectF.b();
        }
        if (rectF.d > f2) {
            rectF2.d = rectF2.b + rectF2.c() * (f2 - rectF.b) / rectF.c();
        }
    }
}

