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
import com.corrodinggames.rts.game.units.e.h;
import com.corrodinggames.rts.game.units.e.l;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

public class c
extends h {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    public static Texture_M d = null;
    public static Texture_M e = null;
    static Texture_M[] f = new Texture_M[10];
    int g;
    float h = 0.0f;
    f i;
    Rect j = new Rect();
    Paint k = y.a();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.experimentalHoverTank;
    }

    public static void f() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        Texture_M e2 = l2.bO.a(com.corrodinggames.rts.R.drawable.experimental_hovertank);
        f = com.corrodinggames.rts.game.PlayerTeam.a(e2);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.experimental_hovertank_dead);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.experimental_hovertank_turret);
        c = com.corrodinggames.rts.game.units.e.c.a(e2, e2.m() / 1, e2.l());
        d = l2.bO.a(com.corrodinggames.rts.R.drawable.experimental_hovertank_shield);
        e = l2.bO.a(com.corrodinggames.rts.R.drawable.shield_mid);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        if (this.i != null && this.i.ej) {
            this.i = null;
        }
        as2.a(this.i);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.i = (f)k2.a(f.class);
        super.a(k2);
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return a;
        }
        return f[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return c;
    }

    @Override
    public boolean F() {
        return com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bQ.renderExtraShadows && this.posZ > -2.0f;
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
        return b;
    }

    @Override
    public Texture_M T() {
        return d;
    }

    @Override
    public boolean e() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        this.M = a;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.largeUnit);
        return true;
    }

    public c(boolean bl2) {
        super(bl2);
        this.a(f[7], 1);
        this.cj = 30.0f;
        this.ck = this.cj + 1.0f;
        this.cu = this.cv = 3500.0f;
        this.cx = this.cA = 5000.0f;
        this.M = f[7];
    }

    @Override
    public float bW() {
        if (this.cA > 0.0f && this.cx < this.cA) {
            return this.cx / this.cA;
        }
        return super.bW();
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.bV || !this.bT()) {
            return;
        }
        if (!this.bV) {
            if (this.cl != 0.0f) {
                this.S(2);
            } else {
                this.S(4);
            }
        }
        if (this.cK) {
            // empty if block
        }
        this.h += 1.0f * f2;
        if (this.h > 360.0f) {
            this.h -= 360.0f;
        }
        this.posZ = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, 4.0f + com.corrodinggames.rts.gameFramework.GameUtils.j(this.h) * 2.0f, 0.1f * f2);
        this.cx = com.corrodinggames.rts.gameFramework.GameUtils.a(this.cx, this.cA, 0.25f * f2);
        this.cy = com.corrodinggames.rts.gameFramework.GameUtils.a(this.cy, 0.0f, 4.0f * f2);
        if (this.cy > 50.0f) {
            this.cy = 50.0f;
        }
        if (this.i != null) {
            PointF pointF = this.E(0);
            this.i.posX = pointF.x;
            this.i.posY = pointF.b;
            this.i.posZ = this.posZ;
            if (this.i.ej) {
                this.i = null;
            }
        }
    }

    @Override
    public float bN() {
        return 80000.0f;
    }

    @Override
    public float L(int n2) {
        return 0.0f;
    }

    @Override
    public PointF K(int n2) {
        PointF pointF = super.K(n2);
        if (this.i != null) {
            pointF.x += this.i.K;
            pointF.b += this.i.L;
        }
        return pointF;
    }

    @Override
    public float q(int n2) {
        return 0.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        PointF pointF = this.E(n2);
        if (this.i != null) {
            boolean bl2 = false;
            if (this.i.ej) {
                bl2 = true;
            }
            if (this.i.l != am2) {
                bl2 = true;
            }
            if (bl2) {
                this.i = null;
            }
        }
        float f2 = this.b(n2) + this.e(n2) + 5.0f;
        if (this.i != null) {
            this.i.h = f2;
        } else {
            f f3 = com.corrodinggames.rts.game.f.a(this, pointF.x, pointF.b);
            f3.U = 380.0f;
            f3.l = am2;
            f3.h = f2;
            f3.B = true;
            f3.A = true;
            f3.aQ = true;
            f3.E = true;
            f3.J = 70.0f;
            f3.F = 230.0f;
            f3.ak = 0.75f;
            f3.em = this.em;
            this.i = f3;
        }
    }

    @Override
    public float m() {
        return 180.0f;
    }

    @Override
    public float b(int n2) {
        return 8.0f;
    }

    @Override
    public float e(int n2) {
        return 8.0f;
    }

    @Override
    public float z() {
        return 0.6f;
    }

    @Override
    public float bc() {
        return 1.0f;
    }

    @Override
    public float A() {
        return 1.1f;
    }

    @Override
    public float B() {
        return 0.03f;
    }

    @Override
    public float c(int n2) {
        return 1.5f;
    }

    @Override
    public float C() {
        return 0.02f;
    }

    @Override
    public float D() {
        return 0.02f;
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
        this.j.a(n2 += this.g * this.es, n3, n2 + this.es, n3 + this.et);
        return this.j;
    }

    @Override
    public boolean c(float f2) {
        Texture_M e2;
        try {
            if (!super.c(f2)) {
                return false;
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        y.a(this);
        if (!this.bV) {
            float f3 = 0.0f;
            if (this.i != null) {
                f3 = com.corrodinggames.rts.gameFramework.GameUtils.b(this.i.e(), 0.25f) * 3.0f;
            }
            y.a(this, com.corrodinggames.rts.game.units.e.l.e, f3, 0);
        }
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (!this.bV && this.cx > 0.0f && this.cz == 0.0f && (e2 = this.T()) != null) {
            float f4 = 0.09f;
            f4 += this.cx / this.cA * 0.4f;
            this.k.a((int)((f4 += com.corrodinggames.rts.gameFramework.GameUtils.b(this.cy, 50.0f) / 50.0f * 0.5f) * 255.0f), 255, 255, 255);
            float f5 = this.posX - l2.cw;
            float f6 = this.posY - l2.cx - this.posZ;
            try {
                l2.bO.a(e2, f5, f6, this.d(false) - 90.0f, this.k);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
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
        return 8.0f;
    }

    @Override
    public PointF G(int n2) {
        float f2 = this.posX;
        float f3 = this.posY;
        bh.a(f2, f3);
        return bh;
    }

    @Override
    public int bl() {
        return 1;
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
    public int cw() {
        return 5;
    }

    @Override
    public boolean dd() {
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

