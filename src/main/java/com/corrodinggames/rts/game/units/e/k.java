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
import com.corrodinggames.rts.game.units.e.j;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

public class k
extends j {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M d = null;
    static Texture_M[] e = new Texture_M[10];
    static Texture_M f = null;
    Rect g = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.laserTank;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.laser_tank_base);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.laser_tank_dead);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.laser_tank_turrent);
        d = l2.bO.a(com.corrodinggames.rts.R.drawable.laser_tank_charge);
        e = PlayerTeam.a(b);
        f = k.a(b, b.m(), b.l());
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
        return f;
    }

    @Override
    public boolean F() {
        return GameEngine.getInstance().bQ.renderExtraShadows && !this.bV;
    }

    @Override
    public float G() {
        return 2.0f;
    }

    @Override
    public float H() {
        return 2.0f;
    }

    @Override
    public Texture_M d(int n2) {
        return c;
    }

    @Override
    public boolean e() {
        GameEngine l2 = GameEngine.getInstance();
        this.M = a;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.verylargeBuilding);
        return true;
    }

    public k(boolean bl2) {
        super(bl2);
        this.a(b, 1);
        this.cj = 14.0f;
        this.ck = this.cj + 2.0f;
        this.cu = this.cv = 300.0f;
        this.M = b;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
    }

    @Override
    public float q(int n2) {
        return 450.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.E(n2);
        f f2 = com.corrodinggames.rts.game.f.a(this, pointF.x, pointF.b);
        f2.U = this.q(n2);
        f2.l = am2;
        f2.h = 8.0f;
        f2.B = true;
        f2.A = true;
        f2.aQ = true;
        f2.ar = Color.a(80, 255, 0, 0);
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(pointF.x, pointF.b, this.posZ, -1127220);
        l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.y, 0.3f, pointF.x, pointF.b);
    }

    @Override
    public float bW() {
        if (this.cL[0].rotation > 0.0f) {
            return 1.0f - this.cL[0].rotation / this.b(0);
        }
        if (this.cL[0].speed != 0.0f) {
            return this.cL[0].speed / this.e(0);
        }
        return super.bW();
    }

    @Override
    public boolean bX() {
        return this.cL[0].rotation > 0.0f;
    }

    @Override
    public float m() {
        return 190.0f;
    }

    @Override
    public float b(int n2) {
        return 450.0f;
    }

    @Override
    public float e(int n2) {
        return 80.0f;
    }

    @Override
    public float z() {
        return 0.7f;
    }

    @Override
    public float A() {
        return 1.5f;
    }

    @Override
    public float B() {
        return 0.1f;
    }

    @Override
    public float c(int n2) {
        return 3.0f;
    }

    @Override
    public boolean c(float f2) {
        float f3;
        try {
            if (!super.c(f2)) {
                return false;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GameEngine l2 = GameEngine.getInstance();
        y.a(this);
        if (!this.bV && (f3 = this.cL[0].speed / this.e(0)) != 0.0f) {
            PointF pointF = this.E(0);
            l2.bO.i();
            l2.bO.b(pointF.x - l2.cw, pointF.b - l2.cx);
            l2.bO.a(f3, f3);
            try {
                l2.bO.a(d, 0.0f, 0.0f, null);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            l2.bO.j();
        }
        return true;
    }

    @Override
    public float C() {
        return 0.07f;
    }

    @Override
    public float D() {
        return 0.12f;
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
        return 19.0f;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

