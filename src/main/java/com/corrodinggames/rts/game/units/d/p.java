/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.i;
import com.corrodinggames.rts.game.units.d.j;
import com.corrodinggames.rts.game.units.d.p$1;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.sound.e;

import android.graphics.PointF;
import android.graphics.Rect;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.effect.d;
import com.corrodinggames.rts.gameFramework.effect.h;

import java.io.IOException;
import java.util.ArrayList;

public class p
extends i {
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] a = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] b = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M c = null;
    boolean d;
    boolean e;
    float f;
    static com.corrodinggames.rts.gameFramework.m.Texture_M g = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] h = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    PointF i = new PointF();
    Rect j = new Rect();
    static AbstractUnitAction k = new p$1(102);
    static ArrayList l = new ArrayList();

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.d);
        as2.a(this.cB);
        as2.a(this.e);
        as2.a(this.f);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.d = k2.e();
        this.cB = k2.g();
        this.e = k2.e();
        if (k2.b() >= 38) {
            this.f = k2.g();
        }
        super.a(k2);
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        return h[this.bX.R()];
    }

    public static void b() {
        GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.laser_defence_dead);
        com.corrodinggames.rts.gameFramework.m.Texture_M e2 = l2.bO.a(com.corrodinggames.rts.R.drawable.laser_defence);
        com.corrodinggames.rts.gameFramework.m.Texture_M e3 = l2.bO.a(com.corrodinggames.rts.R.drawable.laser_defence_t2);
        a = com.corrodinggames.rts.game.PlayerTeam.a(e2);
        b = com.corrodinggames.rts.game.PlayerTeam.a(e3);
        e2.n();
        e2 = null;
        e3.n();
        e3 = null;
        g = l2.bO.a(com.corrodinggames.rts.R.drawable.unit_icon_building_turrent);
        h = com.corrodinggames.rts.game.PlayerTeam.a(g);
    }

    @Override
    public boolean L() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(this.posX, this.posY, this.posZ);
        this.M = c;
        this.S(0);
        this.bT = false;
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.p, 0.8f, this.posX, this.posY);
        return true;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d() {
        if (this.bV) {
            return c;
        }
        if (this.bX == null) {
            return a[a.length - 1];
        }
        if (!this.d) {
            return a[this.bX.R()];
        }
        return b[this.bX.R()];
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M k() {
        return null;
    }

    public p(boolean bl2) {
        super(bl2);
        this.a(a[0], 2);
        this.cB = 1.0f;
        this.ck = this.cj = 19.0f;
        this.cu = this.cv = 500.0f;
        this.M = a[a.length - 1];
        this.n.a(0, 0, 1, 1);
        this.o.a(0, 0, 1, 1);
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bT() || this.bV) {
            return;
        }
        GameEngine l2 = GameEngine.getInstance();
        float f3 = 4.0E-4f * f2;
        if (this.d) {
            f3 += 2.0E-4f * f2;
        }
        this.cB = com.corrodinggames.rts.gameFramework.GameUtils.a(this.cB, 1.0f, f3);
        if (this.cB >= 1.0f) {
            this.e = false;
        }
        this.f -= f2;
        this.i.a(this.E(0));
        if (this.cB > 0.0f && !this.e) {
            float f4 = !this.d ? 0.11f : 0.05f;
            if (com.corrodinggames.rts.game.units.d.p.a((y)this, this.i.x, this.i.b, this.posZ, this.m(), f4)) {
                this.f = 3.0f;
            }
            if (this.cB < 0.0f) {
                this.cB = 0.0f;
                this.e = true;
            }
        }
        this.s = this.e ? 1 : 0;
    }

    public static boolean a(y y2, float f2, float f3, float f4, float f5, float f6) {
        GameEngine l2 = GameEngine.getInstance();
        float f7 = f5 * f5;
        Object[] objectArray = com.corrodinggames.rts.game.f.a.a();
        int n2 = com.corrodinggames.rts.game.f.a.a;
        for (int i2 = 0; i2 < n2; ++i2) {
            com.corrodinggames.rts.gameFramework.effect.e e2;
            float f8;
            f f9 = (f)objectArray[i2];
            if (f9.A || f9.C || !(f9.J > 7.0f) && (!(f9.J > 2.0f) || !(f9.t > 8.0f)) || f9.aS || !((f8 = (f9.posX - f2) * (f9.posX - f2) + (f9.posY - f3) * (f9.posY - f3)) < f7) || f9.posZ < -1.0f) continue;
            boolean bl2 = false;
            if (f9.l != null && y2.bX.d(f9.l.bX)) {
                bl2 = true;
            }
            if (!bl2 && f9.j != null && y2.bX.c(f9.j.bX)) {
                bl2 = true;
            }
            if (!bl2) continue;
            com.corrodinggames.rts.gameFramework.effect.e e3 = l2.bR.a(f2, f3, f4, f9.posX, f9.posY, f9.posZ);
            if (e3 != null) {
                e3.W = e3.V = 10.0f;
            }
            if ((e2 = l2.bR.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.high)) != null) {
                e2.P = 0.0f;
                e2.Q = 0.0f;
                e2.ap = 4;
                e2.W = e2.V = 39.0f;
                e2.r = true;
                e2.E = 1.3f;
                e2.G = 1.1f;
                e2.F = 0.7f;
            }
            f9.H -= 1.01f;
            if (f9.H <= 0.0f) {
                f9.d();
                e2 = l2.bR.b(f9.posX, f9.posY, f9.posZ, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.high);
                if (e2 != null) {
                    e2.P = 0.0f;
                    e2.Q = 0.0f;
                    e2.ap = 4;
                    e2.W = e2.V = 23.0f;
                    e2.r = true;
                    e2.E = 0.9f;
                    e2.G = 0.5f;
                    e2.F = 0.2f;
                }
                float f10 = 1.0f + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.07f, 0.07f);
                l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.F, 0.2f, f10, f9.posX, f9.posY);
            }
            y2.cB -= f6;
            return true;
        }
        return false;
    }

    @Override
    public PointF E(int n2) {
        bg.a(this.posX, this.posY - 13.0f);
        return bg;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
    }

    @Override
    public float m() {
        if (!this.d) {
            return 160.0f;
        }
        return 210.0f;
    }

    @Override
    public float c(int n2) {
        return 4.0f;
    }

    @Override
    public boolean b(int n2, float f2) {
        return false;
    }

    @Override
    public boolean c(float f2) {
        return super.c(f2);
    }

    public UnitTypeEnum K() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.laserDefence;
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public float g(int n2) {
        return 1.0f;
    }

    @Override
    public float bW() {
        if (this.cB != 1.0f) {
            return this.cB;
        }
        return super.bW();
    }

    @Override
    public boolean bX() {
        return this.e;
    }

    @Override
    public float bd() {
        return 1.0f;
    }

    @Override
    public void a(j j2) {
        if (j2.j.equals(k.N())) {
            com.corrodinggames.rts.game.PlayerTeam.b((BaseUnit)this);
            this.a(2);
            com.corrodinggames.rts.game.PlayerTeam.c(this);
            this.W();
        }
    }

    @Override
    public ActionId cm() {
        if (!this.d) {
            return k.N();
        }
        return com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID;
    }

    @Override
    public int V() {
        if (this.d) {
            return 2;
        }
        return 1;
    }

    @Override
    public void a(int n2) {
        if (n2 == 1) {
            this.d = false;
        } else if (n2 == 2 && !this.d) {
            this.d = true;
            this.cv += 900.0f;
            this.cu += 900.0f;
        }
        this.S();
    }

    @Override
    public ArrayList N() {
        return l;
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
    public float cZ() {
        return com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bL.n;
    }

    @Override
    public float da() {
        return com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bL.o;
    }

    @Override
    public float db() {
        return super.db() - 8.0f;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.K();
    }

    static {
        l.add(k);
    }
}

