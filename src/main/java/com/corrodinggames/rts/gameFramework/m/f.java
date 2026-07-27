/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 */
package com.corrodinggames.rts.gameFramework.m;

import android.graphics.PorterDuff;
import android.graphics.Paint;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.m.g;
import com.corrodinggames.rts.gameFramework.m.v;
import com.corrodinggames.rts.gameFramework.m.w;
import com.corrodinggames.rts.gameFramework.m.y;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class f {
    public Texture_M a;
    public y b;
    public Paint c;
    int d = 0;
    boolean e;
    int f;
    boolean g = false;
    int h = 0;
    int i = 0;
    int j = 0;
    int k = 1;
    HashMap l = new HashMap();
    ArrayList m = new ArrayList();

    public f(int n2, int n3) {
        this.a(n2, n3);
    }

    public void a(int n2, int n3) {
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.gameFramework.GameEngine.log("Creating BitmapOrTextureAlias: " + n2 + "x" + n3);
        this.a = l2.bO.a(n2, n3, true);
        this.b = l2.bO.b(this.a);
        this.c = new ag();
        this.c.a(new v(w.b));
    }

    public void a(Texture_M e2, int n2, int n3) {
        try {
            this.b.b(e2, (float) n2, (float) n3, this.c);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        this.b.p();
    }

    public void a() {
        this.b.a(0, PorterDuff.Mode.CLEAR);
    }

    public void b() {
        this.d = 0;
        this.e = false;
        this.f = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.l.clear();
        this.a();
    }

    public void c() {
        ++this.f;
        if (this.e && this.f > 600) {
            this.g = true;
            this.m.clear();
        }
    }

    public void d() {
        if (this.g) {
            this.g = false;
            this.b();
            for (Texture_M e2 : ((List<Texture_M>) this.m)) {
                this.a(e2);
            }
            this.m.clear();
        }
    }

    public g a(Texture_M e2) {
        g g2 = (g) this.l.get(e2);
        if (g2 != null) {
            if (this.g) {
                this.m.add(e2);
            }
            if (g2.f != e2.e) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("BitmapOrTextureAlias: Image was updated: " + e2.a());
                this.l.remove(e2);
            } else {
                return g2;
            }
        }
        if ((g2 = this.b(e2)) != null) {
            return g2;
        }
        return null;
    }

    public g b(Texture_M e2) {
        int n2 = e2.m();
        int n3 = e2.l();
        int n4 = this.a.m();
        int n5 = this.a.l();
        if (this.h + n2 > n4) {
            this.h = 0;
            this.i += this.j + this.k;
            this.j = 0;
        }
        if (this.i + n3 > n5) {
            if (!this.e) {
                this.e = true;
            }
            return null;
        }
        g g2 = new g();
        g2.a = this.a;
        int n6 = this.h;
        int n7 = this.i;
        this.h += n2 + this.k;
        if (this.j < n3) {
            this.j = n3;
        }
        this.a(e2, n6, n7);
        g2.b = n6;
        g2.c = n7;
        g2.d = n2;
        g2.e = n3;
        g2.f = e2.e;
        ++this.d;
        this.l.put(e2, g2);
        return g2;
    }
}
