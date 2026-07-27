/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

public class ad {
    private int a;
    private int[] b;
    private int c = -1;

    public ad(int n2) {
        this.a = 0;
        this.b = new int[n2];
    }

    public ad(int n2, ad ad2) {
        this.a = n2;
        this.b = new int[ad2.b.length];
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            this.b[i2] = ad2.b[i2];
        }
    }

    public void a(int n2, int n3) {
        this.b[n2] = n3;
    }

    public float a(int n2) {
        if (this.c < 0) {
            this.c = 0;
            for (int i2 = 0; i2 < this.b.length; ++i2) {
                if (this.b[i2] <= 0) continue;
                this.c += this.b[i2];
            }
        }
        if (this.c == 0 || this.b[n2] <= 0) {
            return 0.0f;
        }
        return (float)this.b[n2] / (float)this.c;
    }

    static /* synthetic */ int a(ad ad2) {
        return ad2.a;
    }
}

