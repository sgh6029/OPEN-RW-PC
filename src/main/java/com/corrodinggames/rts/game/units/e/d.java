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

public class d
extends j {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M[] d = new Texture_M[10];
    int e;
    float f;
    Rect g = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.experimentalTank;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        Texture_M e2 = l2.bO.a(com.corrodinggames.rts.R.drawable.experimental_tank);
        d = PlayerTeam.a(e2);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.experimental_tank_dead);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.experimental_tank_turret);
        c = com.corrodinggames.rts.game.units.e.d.a(e2, e2.m() / 2, e2.l());
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
        return GameEngine.getInstance().bQ.renderExtraShadows && this.posZ > -2.0f && this.cm >= 1.0f;
    }

    @Override
    public float G() {
        return 4.0f;
    }

    @Override
    public float H() {
        return 4.0f;
    }

    @Override
    public Texture_M d(int n2) {
        if (this.R(n2)) {
            return null;
        }
        return b;
    }

    @Override
    public boolean e() {
        GameEngine l2 = GameEngine.getInstance();
        this.a(com.corrodinggames.rts.game.units.UnitSize.largeUnit);
        this.M = a;
        this.S(0);
        this.bT = false;
        return true;
    }

    public d(boolean bl2) {
        super(bl2);
        this.a(d[7], 2);
        this.cj = 37.0f;
        this.ck = this.cj + 1.0f;
        this.cu = this.cv = 6000.0f;
        this.M = d[7];
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bV) {
            if (this.cl != 0.0f) {
                this.S(2);
            } else {
                this.S(4);
            }
        }
        if (this.cK) {
            this.f += f2;
            if (this.f > 5.0f) {
                this.f = 0.0f;
                this.e = 1 - this.e;
            }
        }
    }

    @Override
    public float bN() {
        return 80000.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        if (!this.R(n2)) {
            PointF pointF = this.E(n2);
            f f2 = com.corrodinggames.rts.game.f.a(this, pointF.x, pointF.b);
            PointF pointF2 = this.K(n2);
            f2.K = pointF2.x;
            f2.L = pointF2.b;
            f2.ar = Color.a(255, 247, 212, 129);
            f2.h = 120.0f;
            f2.t = 5.0f;
            f2.l = am2;
            f2.Y = 60.0f;
            f2.U = 40.0f;
            f2.Z = 45.0f;
            f2.aa = true;
            f2.x = 2.0f;
            f2.aQ = true;
            f2.P = (short)9;
            f2.x = 1.0f;
            f2.em = this.em;
            GameEngine l2 = GameEngine.getInstance();
            l2.bR.a(pointF.x, pointF.b, this.posZ, 16745216);
            l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
            l2.bR.a(f2, -1127220);
            l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.v, 0.3f, this.posX, this.posY);
        } else {
            PointF pointF = this.E(n2);
            pointF.a(this.posX, this.posY);
            f f3 = com.corrodinggames.rts.game.f.a(this, this.posX, this.posY);
            f3.ar = Color.a(255, 230, 230, 50);
            f3.U = 60.0f;
            f3.l = am2;
            f3.h = 190.0f;
            f3.t = 3.0f;
            f3.r = 6.0f;
            f3.aH = true;
            f3.aI = 10.0f;
            f3.aJ = 15.0f;
            f3.aM = true;
            f3.aQ = true;
            f3.aG = true;
            f3.em = this.em;
            GameEngine l3 = GameEngine.getInstance();
            l3.bM.a(com.corrodinggames.rts.gameFramework.sound.e.m, 0.2f, this.posX, this.posY);
            l3.bR.a(f3, -1118720);
            l3.bR.a(pointF.x, pointF.b, this.posZ, -1127220);
        }
    }

    @Override
    public boolean a(int n2, BaseUnit am2, boolean bl2, boolean bl3) {
        if (!bl2 && bl3 && !this.h(am2)) {
            return false;
        }
        return !(this.R(n2) ? !am2.i() : am2.i());
    }

    @Override
    public float m() {
        return 310.0f;
    }

    @Override
    public float b(int n2) {
        if (this.R(n2)) {
            n2 -= 4;
        }
        return 110 - n2 * 20;
    }

    @Override
    public float e(int n2) {
        if (this.R(n2)) {
            n2 -= 4;
        }
        return n2 * 20;
    }

    @Override
    public float z() {
        return 0.4f;
    }

    @Override
    public float bc() {
        return 1.0f;
    }

    @Override
    public int bh() {
        return 1;
    }

    @Override
    public float A() {
        return 0.8f;
    }

    @Override
    public float B() {
        return 0.04f;
    }

    @Override
    public float w(int n2) {
        if (this.R(n2)) {
            return 1.0f;
        }
        return 0.08f;
    }

    @Override
    public float c(int n2) {
        if (this.R(n2)) {
            return 4.5f;
        }
        return 2.5f;
    }

    @Override
    public float C() {
        return 0.03f;
    }

    @Override
    public float D() {
        return 0.08f;
    }

    @Override
    public Rect a_(boolean bl2) {
        if (this.bV && !bl2) {
            return super.a_(bl2);
        }
        if (bl2) {
            return super.a_(bl2);
        }
        int n2 = 0;
        int n3 = 0;
        this.g.a(n2 += this.e * this.es, n3, n2 + this.es, n3 + this.et);
        return this.g;
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
        return true;
    }

    @Override
    public float g(int n2) {
        return 20.0f;
    }

    @Override
    public PointF G(int n2) {
        PointF pointF = super.G(n2);
        float f2 = pointF.x;
        float f3 = pointF.b;
        if (!this.R(n2)) {
            if (n2 <= 1) {
                f2 += com.corrodinggames.rts.gameFramework.GameUtils.k(this.cg) * 5.0f;
                f3 += com.corrodinggames.rts.gameFramework.GameUtils.j(this.cg) * 5.0f;
            }
            float f4 = -45 + 90 * n2;
            f2 += com.corrodinggames.rts.gameFramework.GameUtils.k(this.cg + f4) * 18.0f;
            f3 += com.corrodinggames.rts.gameFramework.GameUtils.j(this.cg + f4) * 18.0f;
        }
        bh.a(f2, f3);
        return bh;
    }

    public boolean R(int n2) {
        return n2 >= 4;
    }

    @Override
    public int bl() {
        return 6;
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
    public int cw() {
        return 5;
    }

    @Override
    public boolean dd() {
        return true;
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

