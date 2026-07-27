/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.h;

import java.io.IOException;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.effect.c;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

public class a
extends com.corrodinggames.rts.game.units.h.f {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M d = null;
    static Texture_M[] e = new Texture_M[10];
    Rect f = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.battleShip;
    }

    @Override
    public float bN() {
        return 9000.0f;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.battle_ship_t2);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.battle_ship_t2_dead);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.battle_ship_t2_turret);
        e = com.corrodinggames.rts.game.PlayerTeam.a(b);
        d = com.corrodinggames.rts.game.units.h.a.a(b, b.m(), b.l());
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return a;
        }
        return e[this.bX.R()];
    }

    @Override
    public Texture_M d(int n2) {
        return c;
    }

    @Override
    public Texture_M k() {
        return d;
    }

    @Override
    public boolean F() {
        return GameEngine.getInstance().bQ.renderExtraShadows && this.posZ > -2.0f;
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
    public boolean e() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.b(this.posX, this.posY, this.posZ);
        this.M = a;
        this.S(0);
        this.bT = false;
        return true;
    }

    public a(boolean bl2) {
        super(bl2);
        this.b(b);
        this.ck = this.cj = 20.0f;
        this.cu = this.cv = 1200.0f;
        this.M = b;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
    }

    @Override
    public float q(int n2) {
        return 65.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.E(n2);
        f f2 = com.corrodinggames.rts.game.f.a((BaseUnit)this, pointF.x, pointF.b, this.posZ, n2);
        PointF pointF2 = this.K(n2);
        f2.K = pointF2.x;
        f2.L = pointF2.b;
        f2.U = this.q(n2);
        f2.l = am2;
        f2.h = 80.0f;
        f2.x = 2.0f;
        f2.t = 4.0f;
        f2.S = true;
        f2.ar = Color.a(255, 180, 180, 0);
        f2.aQ = true;
        GameEngine l2 = GameEngine.getInstance();
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.r, 0.2f, pointF.x, pointF.b);
        l2.bR.a(f2, -1118720);
        com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
        if (e2 != null) {
            com.corrodinggames.rts.gameFramework.effect.c.a(e2, this);
        }
        l2.bR.a(pointF.x, pointF.b, this.posZ, -1118720);
    }

    @Override
    public float m() {
        return 240.0f;
    }

    @Override
    public float z() {
        return 0.8f;
    }

    @Override
    public float bc() {
        return 1.0f;
    }

    @Override
    public float C(int n2) {
        if (this.ci && (double)this.bc() > 0.95) {
            if (n2 == 0) {
                return this.cg + 140.0f;
            }
            return this.cg - 140.0f;
        }
        return this.cg;
    }

    @Override
    public float A() {
        return 1.8f;
    }

    @Override
    public float B() {
        return 0.08f;
    }

    @Override
    public float c(int n2) {
        return 2.5f;
    }

    @Override
    public float w(int n2) {
        return 0.08f;
    }

    @Override
    public float C() {
        return 0.03f;
    }

    @Override
    public float D() {
        return 0.1f;
    }

    @Override
    public boolean c(float f2) {
        try {
            if (!super.c(f2)) {
                return false;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        y.a(this);
        return true;
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
    public int bl() {
        return 2;
    }

    @Override
    public PointF G(int n2) {
        PointF pointF = super.G(n2);
        float f2 = pointF.x;
        float f3 = pointF.b;
        float f4 = n2 == 0 ? 22.0f : 4.0f;
        bh.a(f2 += com.corrodinggames.rts.gameFramework.GameUtils.k(this.cg) * f4, f3 += com.corrodinggames.rts.gameFramework.GameUtils.j(this.cg) * f4);
        return bh;
    }

    @Override
    public float b(int n2) {
        return 120 - n2 * 28;
    }

    @Override
    public float e(int n2) {
        return n2 * 30;
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
    public float H(int n2) {
        return -2.0f;
    }

    @Override
    public float I(int n2) {
        return 4.0f;
    }

    @Override
    public float J(int n2) {
        return 12.0f;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

