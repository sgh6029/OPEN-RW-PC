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
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

public class d
extends com.corrodinggames.rts.game.units.h.f {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M[] d = new Texture_M[10];
    static PointF e = new PointF();
    Rect f = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.missileShip;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.scout_ship);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.scout_ship_dead);
        c = com.corrodinggames.rts.game.units.h.d.a(b, b.m(), b.l());
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
        l2.bR.b(this.posX, this.posY, this.posZ);
        this.M = a;
        this.S(0);
        this.bT = false;
        return true;
    }

    public d(boolean bl2) {
        super(bl2);
        this.T(17);
        this.U(31);
        this.cj = 15.0f;
        this.ck = this.cj - 2.0f;
        this.cu = this.cv = 350.0f;
        this.M = b;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
    }

    @Override
    public PointF E(int n2) {
        float f2 = 6.0f;
        float f3 = this.cg;
        float f4 = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(f3) * f2;
        float f5 = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(f3) * f2;
        e.a(f4, f5);
        return e;
    }

    @Override
    public float q(int n2) {
        return 62.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        GameEngine l2 = GameEngine.getInstance();
        PointF pointF = this.E(n2);
        if (!am2.Q()) {
            f f2 = com.corrodinggames.rts.game.f.a((BaseUnit)this, pointF.x, pointF.b, this.posZ, n2);
            PointF pointF2 = this.K(n2);
            f2.K = pointF2.x;
            f2.L = pointF2.b;
            f2.ar = Color.a(255, 230, 230, 50);
            f2.U = 62.0f;
            f2.l = am2;
            f2.h = 190.0f;
            f2.t = 2.0f;
            f2.aH = true;
            f2.aM = true;
            f2.aQ = true;
            l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.m, 0.8f, this.posX, this.posY);
            l2.bR.a(this.posX, this.posY, this.posZ, -1118720);
            l2.bR.a(f2, -1118720);
        } else {
            f f3 = com.corrodinggames.rts.game.f.a((BaseUnit)this, pointF.x, pointF.b, this.posZ - 1.0f, n2);
            f3.ar = Color.a(255, 0, 0, 150);
            f3.x = 1.0f;
            f3.U = 42.0f;
            f3.l = am2;
            f3.h = 220.0f;
            f3.t = 1.9f;
            f3.aM = true;
            f3.aQ = true;
            l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.m, 0.8f, this.posX, this.posY);
            l2.bR.a(this.posX, this.posY, this.posZ, -1118720);
        }
    }

    @Override
    public float m() {
        return 200.0f;
    }

    @Override
    public float b(int n2) {
        return 170.0f;
    }

    @Override
    public float z() {
        return 1.2f;
    }

    @Override
    public float bc() {
        return 1.0f;
    }

    @Override
    public float A() {
        return 1.9f;
    }

    @Override
    public float B() {
        return 0.2f;
    }

    @Override
    public float c(int n2) {
        return 99.0f;
    }

    @Override
    public float C() {
        return 0.05f;
    }

    @Override
    public float D() {
        return 0.1f;
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
    public boolean ae() {
        return true;
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
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

