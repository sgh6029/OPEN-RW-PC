/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.k;

import com.corrodinggames.rts.gameFramework.k.p;

public class g {
    int a;
    int b;
    int c;
    int d;
    byte[] e;
    byte[] f;

    public g(int n2, int n3) {
        this.a = n2;
        this.b = n3;
        this.e = new byte[n2 * n3];
        this.f = new byte[n2 * n3];
    }

    public final byte a(int n2, int n3) {
        return this.e[n2 * this.b + n3];
    }

    public final byte a(p p2) {
        return this.e[p2.a * this.b + p2.b];
    }

    public boolean b(p p2) {
        return this.a(p2) <= 0;
    }

    public void a(p p2, byte by) {
        this.e[p2.a * this.b + p2.b] = by;
    }

    public void a(p p2, boolean bl2) {
        this.f[p2.a * this.b + p2.b] = (byte)(bl2 ? 1 : 0);
    }

    public boolean c(p p2) {
        return this.f[p2.a * this.b + p2.b] == 1;
    }
}

