/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.e;

import java.io.IOException;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.units.UnitSize;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.e.j;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.PointF;
import android.graphics.Rect;

public class n
extends j {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M d = null;
    static Texture_M[] e = new Texture_M[10];
    int f;
    float g;
    float h;
    Rect i = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.tank;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.tank2);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.tank2_dead);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.tank2_turret);
        d = l2.bO.a(com.corrodinggames.rts.R.drawable.tank2_shadow);
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
        return d;
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
        return c;
    }

    @Override
    public boolean e() {
        this.M = a;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.small);
        return true;
    }

    public n(boolean bl2) {
        super(bl2);
        this.a(b, 3);
        this.cj = 11.0f;
        this.ck = this.cj + 1.0f;
        this.cu = this.cv = 210.0f;
        this.M = b;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.bV) {
            return;
        }
        if (this.cf != 0.0f) {
            this.g += f2;
            if (this.g > 1.0f) {
                this.g = 0.0f;
                ++this.f;
                if (this.f > 2) {
                    this.f = 0;
                }
            }
            if (this.cf > 0.0f && this.el) {
                this.h += f2;
                if (this.h > 9.0f) {
                    this.h = 0.0f;
                    this.K();
                }
            }
        }
    }

    public void K() {
        GameEngine l2 = GameEngine.getInstance();
        for (int i2 = 0; i2 <= 1; ++i2) {
            float f2 = i2 == 0 ? -20 : 20;
            float f3 = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(this.cg + 180.0f + f2) * this.cj;
            float f4 = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(this.cg + 180.0f + f2) * this.cj;
            l2.bR.c(f3, f4, this.posZ, this.cg + 180.0f, 0);
        }
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.E(n2);
        f f2 = com.corrodinggames.rts.game.f.a(this, pointF.x, pointF.b);
        PointF pointF2 = this.K(n2);
        f2.K = pointF2.x;
        f2.L = pointF2.b;
        f2.U = 30.0f;
        f2.l = am2;
        f2.h = 60.0f;
        f2.t = 3.0f;
        f2.P = 1;
        f2.x = 1.0f;
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(pointF.x, pointF.b, this.posZ, -1127220);
        l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
        float f3 = 1.0f + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.07f, 0.07f);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.q, 0.3f, f3, pointF.x, pointF.b);
    }

    @Override
    public float m() {
        return 130.0f;
    }

    @Override
    public float b(int n2) {
        return 75.0f;
    }

    @Override
    public float z() {
        return 1.0f;
    }

    @Override
    public float A() {
        return 4.1f;
    }

    @Override
    public float c(int n2) {
        return 4.0f;
    }

    @Override
    public float B() {
        return 0.25f;
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
        if (!this.bV) {
            // empty if block
        }
        return true;
    }

    @Override
    public float C() {
        return 0.07f;
    }

    @Override
    public float D() {
        return 0.17f;
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
        return 20.0f;
    }

    @Override
    public Rect a_(boolean bl2) {
        if (bl2) {
            return super.a_(bl2);
        }
        if (this.bV) {
            return super.a_(bl2);
        }
        return super.a(bl2, this.f);
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

