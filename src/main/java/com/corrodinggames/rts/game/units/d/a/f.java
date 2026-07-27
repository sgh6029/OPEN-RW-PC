/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.d.a.b;
import com.corrodinggames.rts.game.units.d.a.c;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Color;
import android.graphics.PointF;

class f
extends c {
    final /* synthetic */ b b;

    f(b b2) {
        super(b2);
        this.b = b2;
    }

    @Override
    public String c() {
        return com.corrodinggames.rts.game.units.d.a.b.u;
    }

    @Override
    public int d() {
        return UnitTypeEnum.turret.c() + com.corrodinggames.rts.game.units.d.a.b.dL.c();
    }

    @Override
    public Texture_M d(int n2) {
        return com.corrodinggames.rts.game.units.d.a.b.dE();
    }

    @Override
    float a() {
        return 185.0f;
    }

    @Override
    public float a(int n2) {
        return 20.0f;
    }

    @Override
    public float b(int n2) {
        return 44.0f;
    }

    @Override
    public float g(int n2) {
        return 21.0f;
    }

    @Override
    public PointF c(int n2) {
        PointF pointF = com.corrodinggames.rts.game.units.d.a.b.b(this.b, n2);
        float f2 = this.b.E() ? this.b.cg : this.b.cL[n2].targetX;
        pointF.x += com.corrodinggames.rts.gameFramework.GameUtils.k(f2 += (float)(this.b.k == 1 ? -90 : 90)) * 4.0f;
        pointF.b += com.corrodinggames.rts.gameFramework.GameUtils.j(f2) * 4.0f;
        return pointF;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.c(n2);
        com.corrodinggames.rts.game.f f2 = com.corrodinggames.rts.game.f.a(this.b, pointF.x, pointF.b);
        PointF pointF2 = this.b.K(n2);
        f2.K = pointF2.x;
        f2.L = pointF2.b;
        f2.l = am2;
        f2.h = 60.0f;
        f2.t = 6.0f;
        f2.ar = Color.a(255, 40, 30, 110);
        f2.U = this.b(n2);
        f2.P = (short)5;
        f2.x = 1.0f;
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(pointF.x, pointF.b, this.b.posZ, -1127220);
        l2.bR.a(pointF.x, pointF.b, this.b.posZ, this.b.cL[n2].targetX);
        float f3 = 1.0f + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.07f, 0.07f);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.t, 0.3f, f3, pointF.x, pointF.b);
        this.b.k = this.b.k == 1 ? 0 : 1;
    }

    @Override
    public int b() {
        return 2;
    }

    @Override
    public void a(c c2) {
        this.b.cv += 400.0f;
        this.b.cu += 400.0f;
    }

    @Override
    public void a(float f2) {
        this.b.s(f2);
    }
}

