/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import java.io.IOException;


import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.b.MapTile;
import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Point;
import android.graphics.Rect;

import com.corrodinggames.rts.gameFramework.GGameObject;

public class FireUnit
extends v {
    static Texture_M[] a = new Texture_M[2];
    Texture_M b;
    int c;
    int d = 0;
    float e;
    float f;
    int g = 0;
    int h = 0;
    float i;
    float j;
    boolean k = false;
    float l;
    float m;
    float n;
    float o;
    float p;
    float q;
    boolean r;
    static Point s = new Point();
    public static FireUnitFinder t = new FireUnitFinder();
    Rect u = new Rect();

    public static void b() {
        GameEngine l2 = GameEngine.getInstance();
        FireUnit.a[0] = l2.bO.a(com.corrodinggames.rts.R.drawable.fire);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.c);
        as2.a(this.d);
        as2.a(this.e);
        as2.c(0);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.c = k2.readInt();
        this.d = k2.readInt();
        this.e = k2.g();
        k2.d();
        try {
            super.a(k2);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public Texture_M d() {
        return this.b;
    }

    @Override
    public boolean e() {
        return false;
    }

    public FireUnit(boolean bl2) {
        super(bl2);
        this.a(0);
        this.cj = 20.0f;
        this.ck = this.cj + 1.0f;
        this.cu = this.cv = 100.0f;
        this.cg = -90.0f;
        this.bT = false;
        this.o = 0.05f;
        this.p = 120.0f;
        this.S(3);
    }

    @Override
    public void f_() {
        this.bT = false;
    }

    public void a(int n2) {
        this.c = n2;
        if (this.c != 0) {
            throw new RuntimeException("Fire type:" + this.c + " is not supported");
        }
        this.T(20);
        this.U(20);
        this.g = 0;
        this.h = 0;
        this.b = a[0];
    }

    public void f() {
        this.k = true;
        this.i = GameUtils.a((GGameObject)this, -5, 5, 1);
        this.j = GameUtils.a((GGameObject)this, -5, 5, 2);
        this.e = GameUtils.a((GGameObject)this, 1, 10, 3);
        this.d = GameUtils.a((GGameObject)this, 0, 2, 4);
        this.f = GameUtils.a((GGameObject)this, 7, 13, 5);
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        l2.bL.a(this.posX, this.posY);
        int n2 = l2.bL.T;
        int n3 = l2.bL.U;
        if (!b2.c(n2, n3)) {
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 2.0f;
            return;
        }
        MapTile g2 = l2.bL.u.a(n2, n3);
        boolean bl2 = false;
        if (g2.e || g2.h || g2.k || g2.f) {
            bl2 = true;
        }
        if (bl2) {
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 2.0f;
            return;
        }
        this.l = 5.0E-4f;
        this.m = 1.0f;
        this.n = 0.3f;
        this.o += (float)GameUtils.a((GGameObject)this, 0, 10, 10) / 1000.0f;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.k) {
            this.f();
        }
        if (this.o < this.m) {
            this.o += this.l * f2;
            if (this.o > this.m) {
                this.o = this.m;
            }
        }
        if (this.o > this.n) {
            this.q = (float)((double)this.q + 0.01 * (double)f2);
            if (!this.r && this.q > 1.0f || this.q > 8.0f) {
                this.q = (float)GameUtils.a((GGameObject)this, 0, 10, 10) / 1000.0f;
                this.k();
            }
        }
        this.e += f2;
        if (this.e > 10.0f) {
            this.e = 0.0f;
            ++this.d;
            if (this.d > 3) {
                this.d = 0;
            }
        }
        if (this.o < 0.0f) {
            this.bv();
        }
    }

    public void k() {
        this.r = true;
        this.b(-1, -1);
        this.b(0, -1);
        this.b(1, -1);
        this.b(-1, 0);
        this.b(1, 0);
        this.b(-1, 1);
        this.b(0, 1);
        this.b(1, 1);
    }

    public void b(int n2, int n3) {
        GameEngine l2 = GameEngine.getInstance();
        float f2 = (int)(this.posX + (float)(n2 * l2.bL.n));
        float f3 = (int)(this.posY + (float)(n3 * l2.bL.o));
        FireUnit ai2 = FireUnit.a(f2, f3);
        if (ai2 == null) {
            FireUnit ai3 = new FireUnit(false);
            ai3.posX = f2;
            ai3.posY = f3;
            ai3.b(this.bX);
            l2.cc.a(ai3);
            com.corrodinggames.rts.game.PlayerTeam.c(ai3);
            this.r = false;
        }
    }

    public static FireUnit a(float f2, float f3) {
        GameEngine l2 = GameEngine.getInstance();
        t.a(f2, f3);
        l2.cc.a(f2, f3, 30.0f, null, 1.0f, t);
        return FireUnit.t.c;
    }

    @Override
    public Rect a_(boolean bl2) {
        int n2 = this.g;
        int n3 = this.h;
        dC.a(n2 += this.d * this.es, n3, n2 + this.es, n3 + this.et);
        return dC;
    }

    @Override
    public boolean c(float f2) {
        Texture_M e2 = this.d();
        GameEngine l2 = GameEngine.getInstance();
        du.a(this.cF());
        du.a(0.0f, (int)(-this.posZ));
        du.a(this.i, this.j);
        dv.a(this.a_(false));
        l2.bO.k();
        float f3 = du.d();
        float f4 = du.e();
        l2.bO.a(this.d(false), f3, f4);
        l2.bO.a(this.o * 2.7f, this.o * 2.7f, f3, f4);
        try {
            l2.bO.a(e2, dv, du, null);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        l2.bO.l();
        return true;
    }

    @Override
    public UnitMovementType h() {
        return UnitMovementType.NONE;
    }

    @Override
    public boolean i() {
        return false;
    }

    @Override
    public boolean Q() {
        return false;
    }

    @Override
    public boolean ak() {
        return false;
    }

    @Override
    public boolean aj() {
        return false;
    }

    @Override
    public boolean s_() {
        return true;
    }

    @Override
    public boolean c_() {
        return false;
    }

    public UnitTypeEnum s() {
        return UnitTypeEnum.spreadingFire;
    }

    @Override
    public void n() {
        super.n();
    }

    @Override
    public float x() {
        return -1.0f;
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public boolean P() {
        return true;
    }

    @Override
    public float a(BaseUnit am2, float f2, f f3) {
        this.o -= f2 / 100.0f;
        f2 = 0.0f;
        return super.a(am2, f2, f3);
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.s();
    }
}

