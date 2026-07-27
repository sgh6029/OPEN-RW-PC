/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.UnitSize;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.c$1;
import com.corrodinggames.rts.game.units.d.c$2;
import com.corrodinggames.rts.game.units.d.i;
import com.corrodinggames.rts.game.units.d.j;
import com.corrodinggames.rts.gameFramework.sound.e;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class c
extends i {
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] a = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M b = null;
    boolean c;
    int d;
    float e;
    static com.corrodinggames.rts.gameFramework.m.Texture_M f = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] g = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    PointF h = new PointF();
    Rect i = new Rect();
    static AbstractUnitAction j = new c$1(145);
    static AbstractUnitAction k = new c$2(144);
    static ArrayList l = new ArrayList();

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2)  throws IOException {
        as2.a(this.c);
        as2.a(this.d);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.c = k2.e();
        if (k2.b() >= 30) {
            this.d = k2.readInt();
        }
        super.a(k2);
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        return g[this.bX.R()];
    }

    public static void b() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.antinuke_launcher_dead);
        com.corrodinggames.rts.gameFramework.m.Texture_M e2 = l2.bO.a(com.corrodinggames.rts.R.drawable.antinuke_launcher);
        a = com.corrodinggames.rts.game.PlayerTeam.a(e2);
        e2.n();
        f = l2.bO.a(com.corrodinggames.rts.R.drawable.unit_icon_building_turrent);
        g = com.corrodinggames.rts.game.PlayerTeam.a(f);
    }

    @Override
    public boolean L() {
        GameEngine l2 = GameEngine.getInstance();
        this.M = b;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.verylargeBuilding);
        return true;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d() {
        if (this.bV) {
            return b;
        }
        return a[this.bX.R()];
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M k() {
        return null;
    }

    @Override
    public void a(int n2) {
    }

    public c(boolean bl2) {
        super(bl2);
        this.M = a[a.length - 1];
        this.b(this.M);
        this.ck = this.cj = 24.0f;
        this.cu = this.cv = 2800.0f;
        this.n.a(-1, -1, 1, 1);
        this.o.a(-1, -1, 1, 1);
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bT() || this.bV) {
            return;
        }
        if (this.d > 0) {
            f f3 = null;
            this.e = com.corrodinggames.rts.gameFramework.GameUtils.a(this.e, f2);
            if (this.e == 0.0f) {
                this.e = 15.0f;
                for (f f4 : ((List<f>)com.corrodinggames.rts.game.f.a) ){
                    float f5;
                    if (!f4.D || !(f4.posZ > 50.0f)) continue;
                    float f6 = 2200.0f;
                    float f7 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f4.posX, f4.posY);
                    if (!(f7 < f6 * f6) || !((f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f4.n, f4.o)) < 1000000.0f) || f4.j != null && (f4.j.bX.d(this.bX) || f4.j.bX == this.bX) || this.a(f4)) continue;
                    f3 = f4;
                }
            }
            if (f3 != null) {
                this.b(f3);
            }
        }
    }

    public boolean a(f f2) {
        Object[] objectArray = com.corrodinggames.rts.game.f.a.a();
        int n2 = com.corrodinggames.rts.game.f.a.a;
        for (int i2 = 0; i2 < n2; ++i2) {
            f f3 = (f)objectArray[i2];
            if (f3 == f2 || f3.q != f2) continue;
            return true;
        }
        return false;
    }

    public void b(f f2) {
        GameEngine l2 = GameEngine.getInstance();
        if (this.d <= 0) {
            return;
        }
        --this.d;
        int n2 = 0;
        PointF pointF = this.E(n2);
        f f3 = com.corrodinggames.rts.game.f.a(this, pointF.x, pointF.b);
        f3.S(10);
        f3.P = (short)10;
        f3.R = 0;
        f3.x = 1.0f;
        f3.aC = true;
        f3.q = f2;
        f3.h = 99999.0f;
        f3.t = 0.2f;
        f3.r = 6.5f;
        f3.ar = Color.a(255, 80, 60, 180);
        f3.U = 600.0f;
        f3.aH = true;
        f3.aM = true;
        f3.aQ = true;
        f3.C = true;
        f3.aI = 80.0f;
        f3.aJ = 100.0f;
        f3.aL = 2.0f;
        l2.bR.a(pointF.x, pointF.b, this.posZ, -1127220);
        com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.d(pointF.x, pointF.b, 0.0f, -1);
        if (e2 != null) {
            e2.G = 0.5f;
            e2.F = 2.1f;
            e2.ar = (short)2;
            e2.W = e2.V = 90.0f;
            e2.U = 0.0f;
        }
        float f4 = 1.5f;
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.D, 0.15f, f4, pointF.x, pointF.b);
    }

    @Override
    public PointF E(int n2) {
        bg.a(this.posX, this.posY - 9.0f);
        return bg;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
    }

    @Override
    public float m() {
        return 1000.0f;
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
        return com.corrodinggames.rts.game.units.UnitTypeEnum.AntiNukeLaucher;
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
    public float bV() {
        return super.bV();
    }

    public void M() {
        ++this.d;
    }

    @Override
    public void a(j j2) {
        if (j2.j.equals(k.N())) {
            this.M();
        }
    }

    @Override
    public com.corrodinggames.rts.game.units.a.ActionId cm() {
        if (this.d < 4) {
            return k.N();
        }
        return com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID;
    }

    @Override
    public boolean ck() {
        return false;
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
    }

    @Override
    public void O() {
    }

    @Override
    public void cb() {
        float f2 = 990.0f;
        boolean bl2 = false;
        boolean bl3 = true;
        com.corrodinggames.rts.gameFramework.utility.y.a((BaseUnit)this, f2, bl2, bl3);
    }

    @Override
    public boolean a(GameEngine l2) {
        if (!this.cG) return super.a((GameEngine)l2);
        return true;
    }

    @Override
    public float a(BaseUnit am2, float f2, f f3) {
        if (f2 > 2600.0f) {
            f2 = 2600.0f;
        }
        return super.a(am2, f2, f3);
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.K();
    }

    static {
        l.add(j);
        l.add(k);
    }
}

