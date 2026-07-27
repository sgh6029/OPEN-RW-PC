/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.b;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.b.AirUnit;
import com.corrodinggames.rts.game.units.b.c$1;
import com.corrodinggames.rts.game.units.b.c$2;
import com.corrodinggames.rts.gameFramework.sound.e;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

import java.io.IOException;
import java.util.ArrayList;

public class c
extends AirUnit {
    static com.corrodinggames.rts.gameFramework.m.Texture_M a = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M b = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M c = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M d = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] e = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] f = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] g = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M o = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M p = null;
    float q;
    boolean r = true;
    boolean s = true;
    float t = 0.0f;
    float u = 0.0f;
    protected Paint v = new ag();
    PointF w = new PointF();
    Rect x = new Rect();
    public static final AbstractUnitAction y = new c$1(151);
    public static final AbstractUnitAction z = new c$2(152);
    static ArrayList A = new ArrayList();

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.r);
        as2.a(this.t);
        as2.a(this.u);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.r = k2.e();
        boolean bl2 = this.s = !this.Q();
        if (k2.b() >= 21) {
            this.t = k2.g();
        }
        if (k2.b() >= 22) {
            this.u = k2.g();
        }
        this.M();
        super.a(k2);
    }

    @Override
    public boolean Q() {
        return this.posZ < -1.0f;
    }

    public boolean b() {
        return !this.r || this.posZ < 0.0f;
    }

    @Override
    public UnitMovementType h() {
        if (this.cp) {
            return com.corrodinggames.rts.game.units.UnitMovementType.AIR;
        }
        if (this.b()) {
            return com.corrodinggames.rts.game.units.UnitMovementType.WATER;
        }
        return com.corrodinggames.rts.game.units.UnitMovementType.AIR;
    }

    public UnitTypeEnum f() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.amphibiousJet;
    }

    public static void L() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.amphibious_jet);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.amphibious_jet_shadow);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.amphibious_jet_dead);
        e = com.corrodinggames.rts.game.PlayerTeam.a(b);
        com.corrodinggames.rts.gameFramework.m.Texture_M e2 = l2.bO.a(com.corrodinggames.rts.R.drawable.amphibious_jet_p1);
        com.corrodinggames.rts.gameFramework.m.Texture_M e3 = l2.bO.a(com.corrodinggames.rts.R.drawable.amphibious_jet_p2);
        f = com.corrodinggames.rts.game.PlayerTeam.a(e2);
        g = com.corrodinggames.rts.game.PlayerTeam.a(e3);
        o = com.corrodinggames.rts.game.units.b.c.a(e2);
        p = com.corrodinggames.rts.game.units.b.c.a(e3);
    }

    @Override
    public boolean aQ() throws IOException {
        if (super.aQ()) {
            this.f(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean c(float f2) throws IOException {
        if (!super.c(f2)) {
            return false;
        }
        if (this.bV) {
            return true;
        }
        this.f(false);
        if (!this.bV) {
            for (int i2 = 0; i2 < this.bl(); ++i2) {
                float f3;
                if (i2 == this.ds() || (f3 = this.cL[i2].speed / this.e(i2)) == 0.0f) continue;
                GameEngine l2 = GameEngine.getInstance();
                PointF pointF = this.E(i2);
                l2.bO.i();
                l2.bO.b(pointF.x - l2.cw, pointF.b - l2.cx - this.posZ);
                l2.bO.a(f3 * 0.7f, f3 * 0.7f);
                l2.bO.a(com.corrodinggames.rts.game.units.e.l.e, 0.0f, 0.0f, null);
                l2.bO.j();
            }
        }
        return true;
    }

    public void f(boolean bl2) throws IOException {
        Paint paint;
        GameEngine l2 = GameEngine.getInstance();
        if (!bl2) {
            paint = this.aN();
        } else {
            this.v.a(50, 255, 255, 255);
            paint = this.v;
        }
        for (int i2 = 0; i2 <= 1; ++i2) {
            com.corrodinggames.rts.gameFramework.m.Texture_M e2;
            PointF pointF = this.a(i2, bl2);
            float f2 = pointF.x - l2.cw;
            float f3 = pointF.b - l2.cx;
            float f4 = this.d(false) - 90.0f;
            if (!bl2) {
                f3 -= this.posZ;
            }
            if (i2 == 0) {
                e2 = bl2 ? p : g[this.bX.R()];
                f4 += 0.0f;
            } else {
                e2 = bl2 ? o : f[this.bX.R()];
                f4 -= 0.0f;
            }
            l2.bO.a(e2, f2, f3, f4, paint);
        }
    }

    @Override
    public int bl() {
        return 3;
    }

    @Override
    public PointF G(int n2) {
        if (n2 == this.ds()) {
            return super.G(n2);
        }
        float f2 = this.d(false) - 90.0f;
        PointF pointF = this.a(n2, false);
        float f3 = pointF.x;
        float f4 = pointF.b;
        bh.a(f3 += com.corrodinggames.rts.gameFramework.GameUtils.k(f2) * 5.0f, f4 += com.corrodinggames.rts.gameFramework.GameUtils.j(f2) * 5.0f);
        return bh;
    }

    public PointF a(int n2, boolean bl2) {
        float f2 = this.d(false) - 90.0f;
        if (n2 == this.ds()) {
            throw new RuntimeException("index==2 is for base");
        }
        float f3 = this.posX;
        float f4 = this.posY;
        float f5 = this.u * 4.0f;
        f5 = com.corrodinggames.rts.gameFramework.GameUtils.b(f5, 0.0f, 1.0f);
        float f6 = this.u * 2.0f - 1.0f;
        f6 = com.corrodinggames.rts.gameFramework.GameUtils.b(f6, 0.0f, 1.0f);
        f3 += com.corrodinggames.rts.gameFramework.GameUtils.k(f2) * (7.0f - 5.0f * f5);
        f4 += com.corrodinggames.rts.gameFramework.GameUtils.j(f2) * (7.0f - 5.0f * f5);
        float f7 = -90 + 180 * n2;
        this.w.a(f3 += com.corrodinggames.rts.gameFramework.GameUtils.k(f2 + f7) * (12.0f - 5.0f * f6), f4 += com.corrodinggames.rts.gameFramework.GameUtils.j(f2 + f7) * (12.0f - 5.0f * f6));
        return this.w;
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
        return d;
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

    public c(boolean bl2) {
        super(bl2);
        this.b(b);
        this.cj = 12.0f;
        this.ck = this.cj + 1.0f;
        this.cu = this.cv = 530.0f;
        this.M = b;
        this.N = c;
        this.posZ = 0.0f;
        this.S(5);
    }

    @Override
    public boolean i() {
        return !this.b();
    }

    public void M() {
        if (!this.s) {
            this.S(1);
        } else {
            this.S(5);
        }
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bT() || this.bV) {
            return;
        }
        GameEngine l2 = GameEngine.getInstance();
        this.q += 2.0f * f2;
        if (this.q > 360.0f) {
            this.q -= 360.0f;
        }
        float f3 = this.r ? 20.0f + com.corrodinggames.rts.gameFramework.GameUtils.j(this.q) * 1.5f : -8.0f;
        this.u = this.r && !this.Q() ? com.corrodinggames.rts.gameFramework.GameUtils.a(this.u, 0.0f, 0.018f * f2) : com.corrodinggames.rts.gameFramework.GameUtils.a(this.u, 1.0f, 0.018f * f2);
        if (com.corrodinggames.rts.gameFramework.GameUtils.c(this.posZ - f3) > 3.0f) {
            float f4 = 0.6f;
            if (this.Q()) {
                f4 /= 6.0f;
            }
            this.t = com.corrodinggames.rts.gameFramework.GameUtils.b(this.t, f4);
            this.t = com.corrodinggames.rts.gameFramework.GameUtils.a(this.t, f4, 0.006f * f2);
        } else {
            this.t = com.corrodinggames.rts.gameFramework.GameUtils.a(this.t, 0.07f, 0.006f * f2);
        }
        this.posZ = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, f3, this.t * f2);
        boolean bl2 = false;
        if (this.s && this.Q()) {
            if (!this.cJ()) {
                this.r = true;
            } else {
                this.s = false;
                this.M();
                bl2 = true;
            }
        }
        if (!this.s && !this.Q()) {
            this.s = true;
            this.M();
            bl2 = true;
        }
        if (bl2) {
            l2.bR.a(this.posX, this.posY, 0.0f, 0, 0.0f, 0.0f);
            for (int i2 = -180; i2 < 180; i2 += 45) {
                float f5;
                float f6 = this.cg + (float)i2;
                float f7 = (float)((double)this.posX + Math.cos(Math.toRadians(f6)) * -5.0);
                com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.b(f7, f5 = (float)((double)this.posY + Math.sin(Math.toRadians(f6)) * -5.0), 0.0f, f6);
                if (e2 == null) continue;
                e2.ar = (short)2;
                e2.s = true;
                e2.t = 7.0f;
            }
        }
    }

    @Override
    public float q(int n2) {
        if (n2 == this.ds()) {
            return 0.0f;
        }
        return 45.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        if (n2 == this.ds()) {
            return;
        }
        PointF pointF = this.E(n2);
        f f2 = com.corrodinggames.rts.game.f.a((BaseUnit)this, pointF.x, pointF.b, this.posZ, n2);
        f2.ar = Color.a(255, 247, 212, 129);
        f2.U = this.q(n2);
        f2.l = am2;
        f2.h = 10.0f;
        f2.t = 4.0f;
        f2.x = 2.0f;
        f2.aQ = false;
        f2.A = true;
        f2.M = true;
        f2.ai = 0.5f;
        f2.ak = 1.0f;
        f2.al = 0.1f;
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(pointF.x, pointF.b, this.posZ, -1118482);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.x, 0.2f, this.posX, this.posY);
    }

    @Override
    public float m() {
        if (this.b()) {
            return 100.0f;
        }
        return 170.0f;
    }

    @Override
    public float b(int n2) {
        return 110.0f;
    }

    @Override
    public float e(int n2) {
        return 25 + n2 * 10;
    }

    @Override
    public float f(int n2) {
        return 0.2f;
    }

    @Override
    public float z() {
        if (!this.Q()) {
            return 1.4f;
        }
        return 0.4f;
    }

    @Override
    public float A() {
        if (!this.Q()) {
            return 3.8f;
        }
        return 1.5f;
    }

    @Override
    public float B() {
        return 0.3f;
    }

    @Override
    public float c(int n2) {
        return 4.0f;
    }

    @Override
    public float w(int n2) {
        return 0.35f;
    }

    @Override
    public float y(int n2) {
        return 0.38f;
    }

    @Override
    public boolean E() {
        return false;
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
    public boolean l() {
        return true;
    }

    @Override
    public boolean bi() {
        return true;
    }

    @Override
    public boolean bj() {
        return true;
    }

    @Override
    public void i(float f2) {
        if (!this.Z()) {
            super.i(f2);
            return;
        }
        this.cg += f2;
        if (this.cg > 180.0f) {
            this.cg -= 360.0f;
        }
        if (this.cg < -180.0f) {
            this.cg += 360.0f;
        }
    }

    public int ds() {
        return 2;
    }

    @Override
    public float d(boolean bl2) {
        return this.cL[this.ds()].targetX + 90.0f;
    }

    @Override
    public boolean ah() {
        return !this.Q();
    }

    @Override
    public boolean ae() {
        return this.Q();
    }

    @Override
    public boolean af() {
        return !this.Q();
    }

    @Override
    public boolean ag() {
        if (!this.Q()) {
            return true;
        }
        return true;
    }

    @Override
    public void a(AbstractUnitAction s2, boolean bl2) {
        if (s2 == y) {
            this.r = true;
        }
        if (s2 == z) {
            this.r = false;
        }
    }

    @Override
    public ArrayList N() {
        return A;
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
        com.corrodinggames.rts.gameFramework.utility.y.a((BaseUnit)this, f3);
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.f();
    }

    static {
        A.add(y);
        A.add(z);
    }
}

