/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.e;

import java.io.IOException;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.UnitSize;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.e.h;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

public class g
        extends h {
    float a = 0.0f;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M d = null;
    static Texture_M[] e = new Texture_M[10];
    Rect f = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.hoverTank;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.hover_tank);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.hover_tank_dead);
        d = l2.bO.a(com.corrodinggames.rts.R.drawable.hover_tank_shadow);
        e = com.corrodinggames.rts.game.PlayerTeam.a(c);
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return b;
        }
        return e[this.bX.R()];
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
        this.M = b;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.small);
        return true;
    }

    public g(boolean bl2) {
        super(bl2);
        this.b(c);
        this.cj = 7.0f;
        this.ck = this.cj + 2.0f;
        this.cu = this.cv = 150.0f;
        this.M = c;
        this.N = d;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.bV || !this.bT()) {
            return;
        }
        this.a += 3.0f * f2;
        if (this.a > 360.0f) {
            this.a -= 360.0f;
        }
        this.posZ = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ,
                4.0f + com.corrodinggames.rts.gameFramework.GameUtils.j(this.a) * 1.5f, 0.1f * f2);
    }

    @Override
    public float q(int n2) {
        return 23.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.E(n2);
        f f2 = com.corrodinggames.rts.game.f.a((BaseUnit) this, pointF.x, pointF.b, this.posZ, n2);
        PointF pointF2 = this.K(n2);
        f2.K = pointF2.x;
        f2.L = pointF2.b;
        f2.ar = Color.a(255, 50, 230, 50);
        f2.U = this.q(n2);
        f2.l = am2;
        f2.h = 85.0f;
        f2.t = 2.0f;
        f2.r = 6.0f;
        f2.s = 0.2f;
        f2.P = (short) 6;
        f2.x = 1.0f;
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(pointF.x, pointF.b, this.posZ, -14483678);
        l2.bR.a(f2, -16716288);
        float f3 = 1.3f + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.07f, 0.07f);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.z, 0.3f, f3, pointF.x, pointF.b);
    }

    @Override
    public boolean E() {
        return false;
    }

    @Override
    public float m() {
        return 140.0f;
    }

    @Override
    public float b(int n2) {
        return 90.0f;
    }

    @Override
    public float z() {
        return 1.0f;
    }

    @Override
    public float A() {
        return 180.0f;
    }

    @Override
    public void i(float f2) {
        this.cg += f2;
        if (this.cg > 180.0f) {
            this.cg -= 360.0f;
        }
        if (this.cg < -180.0f) {
            this.cg += 360.0f;
        }
    }

    @Override
    public float C() {
        return 0.04f;
    }

    @Override
    public float D() {
        return 0.09f;
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
        return 4.0f;
    }

    @Override
    public float w(int n2) {
        return 0.2f;
    }

    @Override
    public float d(boolean bl2) {
        return this.cL[0].targetX + 90.0f;
    }

    @Override
    public boolean c(float f2) throws IOException {
        return super.c(f2);
    }

    @Override
    public boolean l() {
        return true;
    }

    @Override
    public boolean af() {
        return true;
    }

    @Override
    public float g(int n2) {
        return 2.0f;
    }

    @Override
    public float B() {
        return 0.5f;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}
