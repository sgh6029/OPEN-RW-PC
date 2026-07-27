/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.b;

import com.corrodinggames.rts.game.b.LayerBufferManager;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.m.y;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class LayerBufferCell {
    public y a;
    int b;
    int c;
    public Texture_M d;
    public Texture_M e;
    public y f;
    public float g;
    public Paint h = new ag();
    public int i;
    public int j;
    public boolean k = true;
    public boolean l = true;
    public int m = 0;
    public boolean n = false;
    public final Rect o = new Rect();
    public final Rect p = new Rect();
    public final RectF q = new RectF();
    public final Rect r = new Rect();
    final /* synthetic */ LayerBufferManager s;

    public void a() {
        GameEngine l2 = GameEngine.getInstance();
        this.e = l2.bO.a(this.d.p, this.d.q, true);
        if (this.e != null && !this.e.A()) {
            this.e.a("fadeOutBitmap");
        }
        if (this.e == null || this.e.A()) {
            throw new OutOfMemoryError("Failed to create fade out bitmap");
        }
        this.e.b(true);
        this.f = l2.bO.b(this.e);
    }

    public Rect b() {
        this.r.a(this.c(), this.d(), this.c() + this.s.i, this.d() + this.s.i);
        return this.r;
    }

    public LayerBufferCell(LayerBufferManager c2, int n2, int n3) {
        this.s = c2;
        this.i = n2;
        this.j = n3;
    }

    public int c() {
        return this.s.f + this.i * this.s.k;
    }

    public int d() {
        return this.s.g + this.j * this.s.k;
    }
}

