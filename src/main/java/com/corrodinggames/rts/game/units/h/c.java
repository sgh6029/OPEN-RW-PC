/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.h;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import java.io.IOException;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

public class c
extends com.corrodinggames.rts.game.units.h.f {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M[] d = new Texture_M[10];
    Rect e = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.gunBoat;
    }

    @Override
    public float bN() {
        return 1500.0f;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.gun_boat);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.gun_boat_dead);
        c = com.corrodinggames.rts.game.units.h.c.a(b, b.m(), b.l());
        d = com.corrodinggames.rts.game.PlayerTeam.a(b);
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return a;
        }
        return d[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return c;
    }

    @Override
    public boolean F() {
        return GameEngine.getInstance().bQ.renderExtraShadows && this.posZ > -2.0f;
    }

    @Override
    public float G() {
        return 1.0f;
    }

    @Override
    public float H() {
        return 1.0f;
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

    public c(boolean bl2) {
        super(bl2);
        this.T(15);
        this.U(27);
        this.cj = 12.0f;
        this.ck = this.cj - 2.0f;
        this.cu = this.cv = 170.0f;
        this.M = b;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
    }

    @Override
    public float q(int n2) {
        return 12.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.E(n2);
        f f2 = f.a(this, pointF.x, pointF.b);
        PointF pointF2 = this.K(n2);
        f2.K = pointF2.x;
        f2.L = pointF2.b;
        f2.posZ = this.posZ;
        f2.U = this.q(n2);
        f2.l = am2;
        f2.h = 30.0f;
        f2.t = 8.0f;
        f2.S = false;
        f2.ar = Color.a(255, 180, 180, 0);
        GameEngine l2 = GameEngine.getInstance();
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.s, 0.2f, pointF.x, pointF.b);
        l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
        l2.bR.a(pointF.x, pointF.b, this.posZ, -1118720);
    }

    @Override
    public float m() {
        return 120.0f;
    }

    @Override
    public float b(int n2) {
        return 60.0f;
    }

    @Override
    public float z() {
        return 1.5f;
    }

    @Override
    public float A() {
        return 2.8f;
    }

    @Override
    public float B() {
        return 0.35f;
    }

    @Override
    public float c(int n2) {
        return 99.0f;
    }

    @Override
    public float C() {
        return 0.06f;
    }

    @Override
    public float D() {
        return 0.2f;
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
        return false;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

