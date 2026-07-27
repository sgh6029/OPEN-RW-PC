/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d.a;

import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.d.a.b;
import com.corrodinggames.rts.game.units.d.a.c;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Color;
import android.graphics.PointF;

class d
extends c {
    final /* synthetic */ b b;

    d(b b2) {
        super(b2);
        this.b = b2;
    }

    @Override
    public String c() {
        return com.corrodinggames.rts.game.units.d.a.b.w;
    }

    @Override
    public int d() {
        return UnitTypeEnum.turret.c() + com.corrodinggames.rts.game.units.d.a.b.dN.c();
    }

    @Override
    public Texture_M d(int n2) {
        return com.corrodinggames.rts.game.units.d.a.b.dG();
    }

    @Override
    float a() {
        return 350.0f;
    }

    @Override
    public float a(int n2) {
        return 220.0f;
    }

    @Override
    public float b(int n2) {
        return 100.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.c(n2);
        f f2 = f.a(this.b, pointF.x, pointF.b);
        PointF pointF2 = this.b.K(n2);
        f2.K = pointF2.x;
        f2.L = pointF2.b;
        f2.h = 150.0f;
        f2.t = 4.0f;
        f2.aQ = true;
        f2.ar = Color.a(255, 190, 190, 80);
        f2.R = (short)2;
        f2.P = 0;
        f2.x = 0.9f;
        PointF pointF3 = am2.a(pointF.x, pointF.b, f2.t, f2.h, this.a());
        f2.aC = true;
        f2.m = true;
        f2.n = pointF3.x;
        f2.o = pointF3.b;
        f2.Y = this.b(n2);
        f2.Z = 55.0f;
        f2.aa = true;
        GameEngine l2 = GameEngine.getInstance();
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.r, 0.3f, pointF.x, pointF.b);
        l2.bR.a(pointF.x, pointF.b, this.b.posZ, this.b.cL[n2].targetX);
        l2.bR.a(f2, -1118482);
        com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.a(pointF.x, pointF.b, this.b.posZ, -1118482);
        if (e2 != null) {
            e2.W = e2.V = 15.0f;
        }
    }

    @Override
    public int b() {
        return 2;
    }

    @Override
    public void a(c c2) {
        this.b.cv += 300.0f;
        this.b.cu += 300.0f;
    }

    @Override
    public float e(int n2) {
        return 2.5f;
    }

    @Override
    public float f(int n2) {
        return 0.2f;
    }

    @Override
    public float h(int n2) {
        return -2.0f;
    }
}

