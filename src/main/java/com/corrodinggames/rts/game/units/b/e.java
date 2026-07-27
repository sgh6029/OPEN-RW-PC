/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.b;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.b.AirUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

public class e
extends AirUnit {
    static com.corrodinggames.rts.gameFramework.m.Texture_M a = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M b = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M c = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M d = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] e = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    float f = 0.0f;
    Rect g = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.gunShip;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.gunship);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.gunship_shadow);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.gunship_dead);
        e = com.corrodinggames.rts.game.PlayerTeam.a(b);
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d() {
        if (this.bV) {
            return a;
        }
        return e[this.bX.R()];
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M k() {
        return c;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d(int n2) {
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

    public e(boolean bl2) {
        super(bl2);
        this.T(25);
        this.U(35);
        this.cj = 15.0f;
        this.ck = this.cj + 0.0f;
        this.cu = this.cv = 260.0f;
        this.M = b;
        this.N = c;
        this.posZ = 0.0f;
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
        this.f += 2.0f * f2;
        if (this.f > 360.0f) {
            this.f -= 360.0f;
        }
        this.posZ = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, 20.0f + com.corrodinggames.rts.gameFramework.GameUtils.j(this.f) * 1.5f, 0.1f * f2);
    }

    @Override
    public PointF E(int n2) {
        float f2 = this.g(n2);
        float f3 = this.cg;
        float f4 = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(f3) * f2;
        float f5 = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(f3) * f2;
        bg.a(f4, f5);
        return bg;
    }

    @Override
    public float q(int n2) {
        return 35.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.E(n2);
        f f2 = com.corrodinggames.rts.game.f.a((BaseUnit)this, pointF.x, pointF.b, this.posZ, n2);
        PointF pointF2 = this.K(n2);
        f2.K = pointF2.x;
        f2.L = pointF2.b;
        f2.ar = Color.a(255, 150, 230, 40);
        f2.U = this.q(n2);
        f2.l = am2;
        f2.h = 80.0f;
        f2.t = 4.0f;
        f2.x = 2.0f;
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(pointF.x, pointF.b, this.posZ, -1127220);
        l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.u, 0.3f, this.posX, this.posY);
    }

    @Override
    public float m() {
        return 140.0f;
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
        return 1.4f;
    }

    @Override
    public float A() {
        return 4.0f;
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
    public float c(int n2) {
        return 99.0f;
    }

    @Override
    public boolean E() {
        return false;
    }

    @Override
    public float C() {
        return 0.2f;
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
    public boolean af() {
        return false;
    }

    @Override
    public float g(int n2) {
        return 15.0f;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

