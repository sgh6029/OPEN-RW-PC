/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.m;

import com.corrodinggames.rts.game.o;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ShaderProgram;

import android.graphics.Bitmap;

public class Texture_M {
    public Texture_M[] a;
    public Texture_M[] b;
    public Texture_M[] c;
    private static int x;
    public int d = x++;
    public int e = 1;
    public int f;
    public String g;
    public Integer h;
    ShaderProgram i;
    public int[] j;
    protected Bitmap k;
    public boolean l = true;
    public boolean m;
    public boolean n;
    public boolean o = false;
    public int p;
    public int q;
    public int r;
    public int s;
    public float t;
    public float u;
    public boolean v;
    boolean w = false;

    public Texture_M[] a(o o2) {
        if (o2 == com.corrodinggames.rts.game.o.pureGreen) {
            return this.a;
        }
        if (o2 == com.corrodinggames.rts.game.o.hueAdd) {
            return this.b;
        }
        if (o2 == com.corrodinggames.rts.game.o.hueShift) {
            return this.c;
        }
        com.corrodinggames.rts.gameFramework.GameEngine.b("getTeamImageCache coloringMode:" + (Object)((Object)o2));
        return this.a;
    }

    public void a(o o2, Texture_M[] eArray) {
        if (o2 == com.corrodinggames.rts.game.o.pureGreen) {
            this.a = eArray;
            return;
        }
        if (o2 == com.corrodinggames.rts.game.o.hueAdd) {
            this.b = eArray;
            return;
        }
        if (o2 == com.corrodinggames.rts.game.o.hueShift) {
            this.c = eArray;
            return;
        }
        com.corrodinggames.rts.gameFramework.GameEngine.b("setTeamImageCache coloringMode:" + (Object)((Object)o2));
        this.a = eArray;
    }

    public void a(String string2) {
        this.g = string2;
    }

    public String a() {
        return this.g;
    }

    public Bitmap b() {
        return this.k;
    }

    public Texture_M c() {
        return this;
    }

    public void a(boolean bl2) {
        this.o = bl2;
        this.e();
    }

    public void b(boolean bl2) {
        this.w = bl2;
    }

    public boolean d() {
        return this.w;
    }

    protected void e() {
    }

    public boolean f() {
        return this.m;
    }

    public void a(Bitmap bitmap) {
        this.k = bitmap;
        this.p = this.k.getWidth();
        this.q = this.k.getHeight();
        this.g();
    }

    public void g() {
        this.r = this.p / 2;
        this.s = this.q / 2;
        this.t = (float)this.p / 2.0f;
        this.u = (float)this.q / 2.0f;
    }

    public void a(Texture_M e2) {
        e2.o = this.o;
        e2.p = this.p;
        e2.q = this.q;
        e2.r = this.r;
        e2.s = this.s;
        e2.t = this.t;
        e2.u = this.u;
    }

    public Texture_M h() {
        Texture_M e2 = new Texture_M();
        e2.o = this.o;
        if (this.k != null) {
            Bitmap bitmap = this.k.copy(this.k.getConfig(), true);
            if (bitmap == null) {
                throw new OutOfMemoryError("Failed to copy bitmap: " + (Object)((Object)this.k.getConfig()));
            }
            e2.a(bitmap);
        }
        return e2;
    }

    public Texture_M a(int n2, int n3, boolean bl2) {
        Texture_M e2 = new Texture_M();
        e2.o = this.o;
        if (this.k != null) {
            Bitmap bitmap = Bitmap.createBitmap(n2, n3, this.k.getConfig());
            e2.a(bitmap);
            if (bl2) {
                for (int i2 = 0; i2 < bitmap.getWidth(); ++i2) {
                    for (int i3 = 0; i3 < bitmap.getHeight(); ++i3) {
                        bitmap.setPixel(i2, i3, this.k.getPixel(i2, i3));
                    }
                }
            }
        }
        return e2;
    }

    public void i() {
        if (this.j == null) {
            this.j();
        }
    }

    public void j() {
        if (this.k == null && com.corrodinggames.rts.gameFramework.GameEngine.isPausedStatic2 && !com.corrodinggames.rts.gameFramework.GameEngine.isIOSVersionStatic2) {
            return;
        }
        if (this.j == null) {
            this.j = new int[this.p * this.q];
        }
        this.k.getPixels(this.j, 0, this.p, 0, 0, this.p, this.q);
    }

    public boolean k() {
        return true;
    }

    public int a(int n2, int n3) {
        if (this.j != null) {
            return this.j[n2 + n3 * this.p];
        }
        return this.k.getPixel(n2, n3);
    }

    public void a(int n2, int n3, int n4) {
        if (this.j != null) {
            this.j[n2 + n3 * this.p] = n4;
            return;
        }
        this.k.setPixel(n2, n3, n4);
    }

    public int l() {
        return this.q;
    }

    public int m() {
        return this.p;
    }

    public void n() {
    }

    public void o() {
        if (this.k != null) {
            this.k = null;
        }
        if (this.w) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("remove with keepInGPUMemory=true");
        }
    }

    public void p() {
        if (this.k == null && com.corrodinggames.rts.gameFramework.GameEngine.isPausedStatic2 && !com.corrodinggames.rts.gameFramework.GameEngine.isAndroidVersionStatic2) {
            return;
        }
        if (this.j != null) {
            this.k.getPixels(this.j, 0, this.p, 0, 0, this.p, this.q);
            this.j = null;
        }
        ++this.e;
    }

    public void q() {
    }

    public void r() {
        this.j = null;
    }

    public void s() {
        this.r();
    }

    public void t() {
    }

    public int u() {
        return this.p * this.q * 8;
    }

    public void v() {
        this.a = null;
        this.b = null;
        this.c = null;
        ++this.e;
    }

    public void w() {
    }

    public void x() {
    }

    public void y() {
    }

    public void z() {
    }

    public boolean A() {
        return false;
    }

    public ShaderProgram B() {
        return this.i;
    }

    public void a(ShaderProgram ae2) {
        this.i = ae2;
    }

    public /* synthetic */ Object clone() {
        return this.h();
    }
}

