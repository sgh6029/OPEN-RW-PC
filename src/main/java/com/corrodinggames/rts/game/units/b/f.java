/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.b;

import java.io.IOException;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.b.AirUnit;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

public class f
extends AirUnit {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M d = null;
    static Texture_M e = null;
    static Texture_M[] f = new Texture_M[10];
    boolean g = false;
    float o;
    float p = 0.0f;
    float q;
    Rect r = new Rect();
    Rect s = new Rect();

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.p);
        as2.a(this.o);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        if (k2.b() >= 9) {
            this.p = k2.g();
            this.o = k2.g();
            if (k2.b() == 8) {
                this.g = k2.e();
            }
        } else {
            this.o = 0.5f;
        }
        super.a(k2);
    }

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.helicopter;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.helicopter);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.helicopter_blades);
        d = l2.bO.a(com.corrodinggames.rts.R.drawable.helicopter_shadow);
        e = l2.bO.a(com.corrodinggames.rts.R.drawable.helicopter_shadow_blades);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.helicopter_dead);
        f = com.corrodinggames.rts.game.PlayerTeam.a(b);
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return a;
        }
        return f[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return d;
    }

    @Override
    public Texture_M d(int n2) {
        return null;
    }

    @Override
    public boolean e() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.b(this.posX, this.posY, this.posZ);
        this.M = a;
        this.S(0);
        this.bT = false;
        return true;
    }

    public f(boolean bl2) {
        super(bl2);
        this.T(26);
        this.U(46);
        this.cj = 13.0f;
        this.ck = this.cj + 2.0f;
        this.cu = this.cv = 150.0f;
        this.M = b;
        this.N = d;
        this.posZ = 0.0f;
        this.o = 0.14f;
        this.q = 0.0f;
        this.S(5);
    }

    @Override
    public void n() {
        super.n();
        this.posZ = 20.0f;
        this.o = 0.5f;
    }

    @Override
    public boolean I() {
        return true;
    }

    @Override
    public boolean i() {
        return true;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.bV) {
            return;
        }
        this.o = com.corrodinggames.rts.gameFramework.GameUtils.a(this.o, 0.5f, 0.003f * f2);
        this.q += 70.0f * this.o * f2;
        if (this.q >= 360.0f) {
            this.q -= 360.0f;
            this.q += (float)com.corrodinggames.rts.gameFramework.GameUtils.a(this, 0, 4);
        }
        if (this.o > 0.4f) {
            this.p += 2.0f * f2;
            if (this.p > 360.0f) {
                this.p -= 360.0f;
            }
            this.posZ = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, 20.0f + com.corrodinggames.rts.gameFramework.GameUtils.j(this.p) * 1.5f, 0.1f * f2);
        }
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.E(n2);
        com.corrodinggames.rts.game.f f2 = com.corrodinggames.rts.game.f.a((BaseUnit)this, pointF.x, pointF.b, this.posZ, n2);
        PointF pointF2 = this.K(n2);
        f2.K = pointF2.x;
        f2.L = pointF2.b;
        f2.U = 17.0f;
        f2.l = am2;
        f2.h = 30.0f;
        f2.t = 8.0f;
        f2.S = false;
        f2.ar = Color.a(255, 180, 180, 0);
        f2.A = true;
        f2.aR = false;
        GameEngine l2 = GameEngine.getInstance();
        float f3 = 1.0f + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.08f, 0.08f);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.s, 0.2f, f3, pointF.x, pointF.b);
        l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
        l2.bR.a(pointF.x, pointF.b, this.posZ, -1118720);
    }

    @Override
    public float m() {
        return 130.0f;
    }

    @Override
    public float b(int n2) {
        return 60.0f;
    }

    @Override
    public float z() {
        if (this.posZ < 15.0f) {
            return 0.0f;
        }
        return 2.2f;
    }

    @Override
    public float bc() {
        return 0.1f;
    }

    @Override
    public float A() {
        return 6.0f;
    }

    @Override
    public float B() {
        return 0.4f;
    }

    @Override
    public boolean bi() {
        return true;
    }

    @Override
    public boolean bj() {
        return true;
    }

    @Override
    public float c(int n2) {
        return 16.0f;
    }

    @Override
    public Rect a_(boolean bl2) {
        return super.a_(bl2);
    }

    @Override
    public boolean c(float f2) throws IOException {
        if (!super.c(f2)) {
            return false;
        }
        if (!this.bV) {
            Paint paint = this.aN();
            GameEngine l2 = GameEngine.getInstance();
            this.s.a(0, 0, c.m(), c.l());
            float f3 = this.q;
            if (this.co) {
                // empty if block
            }
            l2.bO.a(c, this.s, this.posX - com.corrodinggames.rts.gameFramework.GameEngine.getInstance().cw, this.posY - com.corrodinggames.rts.gameFramework.GameEngine.getInstance().cx - this.posZ, f3, paint);
        }
        return true;
    }

    @Override
    public float C() {
        return 0.07f;
    }

    @Override
    public float D() {
        return 0.1f;
    }

    @Override
    public boolean l() {
        return true;
    }

    @Override
    public float g(int n2) {
        return 7.0f;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

