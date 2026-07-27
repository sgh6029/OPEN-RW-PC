/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.b;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

public class AirShip
extends AirUnit {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M d = null;
    static Texture_M[] e = new Texture_M[10];
    float f;
    Rect g = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.airShip;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.ship);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.ship_shadow);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.ship_dead);
        e = com.corrodinggames.rts.game.PlayerTeam.a(b);
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return a;
        }
        return e[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return c;
    }

    @Override
    public Texture_M d(int n2) {
        return d;
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

    public AirShip(boolean bl2) {
        super(bl2);
        this.T(24);
        this.U(22);
        this.cj = 11.0f;
        this.ck = this.cj + 0.0f;
        this.cu = this.cv = 250.0f;
        this.M = b;
        this.N = c;
        this.posZ = 0.0f;
        this.f = 0.18f;
        this.S(5);
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
        this.posZ = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, 20.0f, 0.3f * f2);
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.E(n2);
        f f2 = com.corrodinggames.rts.game.f.a((BaseUnit)this, pointF.x, pointF.b, this.posZ, n2);
        PointF pointF2 = this.K(n2);
        f2.K = pointF2.x;
        f2.L = pointF2.b;
        f2.U = 30.0f;
        f2.l = am2;
        f2.h = 75.0f;
        f2.t = 6.0f;
        f2.x = 2.0f;
        f2.y = 4.0f;
        f2.ar = Color.a(250, 74, 232, 255);
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
        if (e2 != null) {
            e2.aq = 10;
        }
        float f3 = 1.0f + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.1f, 0.1f);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.y, 0.14f, f3, pointF.x, pointF.b);
    }

    @Override
    public float m() {
        return 170.0f;
    }

    @Override
    public float b(int n2) {
        return 40.0f;
    }

    @Override
    public float z() {
        if (this.posZ < 15.0f) {
            return 0.0f;
        }
        return 2.4f;
    }

    @Override
    public float A() {
        return 3.7f;
    }

    @Override
    public float B() {
        return 0.4f;
    }

    @Override
    public float c(int n2) {
        return 3.7f;
    }

    @Override
    public boolean bm() {
        return false;
    }

    @Override
    public float w(int n2) {
        return 0.4f;
    }

    @Override
    public boolean E() {
        return false;
    }

    @Override
    public float g(int n2) {
        return 10.0f;
    }

    @Override
    public float C() {
        return 0.1f;
    }

    @Override
    public float D() {
        return 0.16f;
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
    public boolean ag() {
        return false;
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
    public float d(boolean bl2) {
        return this.cL[0].targetX + 90.0f;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

