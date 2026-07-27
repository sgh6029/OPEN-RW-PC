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
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Color;
import android.graphics.PointF;

class g
extends c {
    final /* synthetic */ b b;

    g(b b2) {
        super(b2);
        this.b = b2;
    }

    @Override
    public String c() {
        return com.corrodinggames.rts.game.units.d.a.b.v;
    }

    @Override
    public int d() {
        return UnitTypeEnum.turret.c() + com.corrodinggames.rts.game.units.d.a.b.dL.c() + com.corrodinggames.rts.game.units.d.a.b.dM.c();
    }

    @Override
    public Texture_M d(int n2) {
        return com.corrodinggames.rts.game.units.d.a.b.dF();
    }

    @Override
    float a() {
        return 320.0f;
    }

    @Override
    public float a(int n2) {
        return 13.0f;
    }

    @Override
    public float b(int n2) {
        return 40.0f;
    }

    @Override
    public PointF c(int n2) {
      PointF var2 = com.corrodinggames.rts.game.units.d.a.b.c(this.b, n2);
      float var3 = this.b.E() ? this.b.cg : this.b.cL[n2].targetX;
      var3 += (float)(this.b.k == 1 ? -90 : 90);
      var2.x += GameUtils.k(var3) * 4.0F;
      var2.b += GameUtils.j(var3) * 4.0F;
      return var2;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.c(n2);
        f f2 = f.a(this.b, pointF.x, pointF.b);
        PointF pointF2 = this.b.K(n2);
        f2.K = pointF2.x;
        f2.L = pointF2.b;
        f2.l = am2;
        f2.h = 60.0f;
        f2.t = 9.0f;
        f2.ar = Color.a(255, 180, 30, 30);
        f2.U = this.b(n2);
        f2.P = (short)5;
        f2.x = 1.0f;
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(pointF.x, pointF.b, this.b.posZ, -1127220);
        l2.bR.a(pointF.x, pointF.b, this.b.posZ, this.b.cL[n2].targetX);
        float f3 = 1.0f + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.07f, 0.07f);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.t, 0.15f, f3, pointF.x, pointF.b);
        this.b.k = this.b.k == 1 ? 0 : 1;
    }

    @Override
    public void a(float f2) {
        if (this.b.cu < this.b.cv) {
            this.b.cu += 0.1f * f2;
            if (this.b.cu > this.b.cv) {
                this.b.cu = this.b.cv;
            }
        }
        this.b.s(f2);
    }

    @Override
    public int b() {
        return 3;
    }

    @Override
    public void a(c c2) {
        if (!(c2 instanceof com.corrodinggames.rts.game.units.d.a.f)) {
            this.b.cv += 400.0f;
            this.b.cu += 400.0f;
        }
        this.b.cv += 2800.0f;
        this.b.cu += 2800.0f;
    }
}
