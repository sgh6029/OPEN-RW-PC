/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.e;

import java.io.IOException;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.Color;
import android.graphics.PointF;

public class a
extends j {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M[] d = new Texture_M[10];

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.artillery;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.artillery2);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.artillery1_dead);
        d = PlayerTeam.a(a);
        c = com.corrodinggames.rts.game.units.e.a.a(a);
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return b;
        }
        return d[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return c;
    }

    @Override
    public boolean F() {
        return GameEngine.getInstance().bQ.renderExtraShadows && !this.bV;
    }

    @Override
    public float G() {
        return 3.0f;
    }

    @Override
    public float H() {
        return 3.0f;
    }

    @Override
    public Texture_M d(int n2) {
        return null;
    }

    @Override
    public boolean e() {
        GameEngine l2 = GameEngine.getInstance();
        this.M = b;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.normal);
        return true;
    }

    public a(boolean bl2) {
        super(bl2);
        this.T(28);
        this.U(50);
        this.ck = this.cj = 18.0f;
        this.cu = this.cv = 140.0f;
        this.M = a;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.E(n2);
        f f2 = f.a(this, pointF.x, pointF.b);
        PointF pointF2 = this.K(n2);
        f2.K = pointF2.x;
        f2.L = pointF2.b;
        f2.h = 150.0f;
        f2.t = 4.0f;
        f2.aQ = true;
        f2.ar = Color.a(255, 190, 190, 80);
        f2.R = (short)2;
        f2.P = 1;
        f2.x = 0.9f;
        PointF pointF3 = am2.a(pointF.x, pointF.b, f2.t, f2.h, this.m());
        f2.aC = true;
        f2.m = true;
        f2.n = pointF3.x;
        f2.o = pointF3.b;
        f2.Y = 80.0f;
        f2.Z = 45.0f;
        f2.aa = true;
        GameEngine l2 = GameEngine.getInstance();
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.r, 0.3f, pointF.x, pointF.b);
        l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
        com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.a(pointF.x, pointF.b, this.posZ, -1118482);
        if (e2 != null) {
            e2.W = e2.V = 15.0f;
        }
    }

    @Override
    public float bW() {
        if (this.cL[0].rotation > 0.0f) {
            return 1.0f - this.cL[0].rotation / this.b(0);
        }
        return super.bW();
    }

    @Override
    public float m() {
        return 290.0f;
    }

    @Override
    public float b(int n2) {
        return 240.0f;
    }

    @Override
    public float z() {
        return 0.9f;
    }

    @Override
    public float A() {
        return 1.7f;
    }

    @Override
    public float B() {
        return 0.05f;
    }

    @Override
    public float c(int n2) {
        return 99.0f;
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
    public boolean E() {
        return true;
    }

    @Override
    public float g(int n2) {
        return 20.0f;
    }

    @Override
    public float C() {
        return 0.05f;
    }

    @Override
    public float D() {
        return 0.12f;
    }

    @Override
    public void e(float f2) {
        try {
            super.e(f2);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        float f3 = this.m();
        y.a((BaseUnit)this, f3);
    }

    @Override
    public float bN() {
        return 14000.0f;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

