/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.h;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ReclaimTargetAction;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.PlaceBuildingAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d_f2;
import com.corrodinggames.rts.game.units.h.f;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.PointF;
import android.graphics.Rect;

import java.io.IOException;
import java.util.ArrayList;

public class b
extends f
implements d_f2 {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M d = null;
    static Texture_M[] e = new Texture_M[10];
    PointF[] f = new PointF[6];
    PointF[] g = new PointF[this.f.length];
    Rect h = new Rect();
    static AbstractUnitAction i = new ReclaimTargetAction(false);

    @Override
    public Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        return com.corrodinggames.rts.game.units.e.b.h[this.bX.R()];
    }

    public UnitTypeEnum f() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.builderShip;
    }

    @Override
    public PointF[] b() {
        return this.f;
    }

    @Override
    public PointF[] e_() {
        return this.g;
    }

    @Override
    public float bN() {
        return 6000.0f;
    }

    public static void t_() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.builder_ship);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.builder_ship_dead);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.builder_ship_turret);
        e = com.corrodinggames.rts.game.PlayerTeam.a(b);
        d = com.corrodinggames.rts.game.units.h.b.a(b, b.m(), b.l());
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

    public b(boolean bl2) {
        super(bl2);
        this.b(b);
        this.ck = this.cj = 13.0f;
        this.cu = this.cv = 500.0f;
        this.M = b;
        for (int i2 = 0; i2 < this.f.length; ++i2) {
            this.f[i2] = new PointF();
            this.g[i2] = new PointF();
        }
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
    public float A() {
        return 1.9f;
    }

    @Override
    public float B() {
        return 0.12f;
    }

    @Override
    public float c(int n2) {
        return 3.5f;
    }

    @Override
    public float w(int n2) {
        return 0.25f;
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
    public void a(float f2) {
        super.a(f2);
        if (!this.bV) {
            com.corrodinggames.rts.game.units.e.b.a(f2, this);
        }
    }

    @Override
    public void a(float f2, boolean bl2) {
        try {
            super.a(f2, bl2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (!this.bV) {
            com.corrodinggames.rts.game.units.e.b.b(f2, this);
        }
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
            l2.bO.b(pointF.x - l2.cw, pointF.b - l2.cx - this.posZ);
            l2.bO.a(f3, f3);
                try {
            if (this.Y()) {
                    l2.bO.a(com.corrodinggames.rts.game.units.e.b.f, 0.0f, 0.0f, null);
              
            } else {
                l2.bO.a(com.corrodinggames.rts.game.units.e.b.e, 0.0f, 0.0f, null);
            }  } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            l2.bO.j();
        }
        return true;
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public float g(int n2) {
        return 11.0f;
    }

    @Override
    public int bl() {
        return 1;
    }

    @Override
    public PointF G(int n2) {
        float f2 = 8.0f;
        float f3 = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(this.cg) * f2;
        float f4 = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(this.cg) * f2;
        bh.a(f3, f4);
        return bh;
    }

    @Override
    public float b(int n2) {
        return 120 - n2 * 28;
    }

    @Override
    public float e(int n2) {
        return 30.0f;
    }

    @Override
    public float f(int n2) {
        return 1.3f;
    }

    @Override
    public boolean a(BaseUnit am2) {
        if (am2.q()) {
            return false;
        }
        return am2.bI();
    }

    @Override
    public void a(AbstractUnitAction s2, boolean bl2) {
    }

    public static void a(ArrayList arrayList, int n2) {
        arrayList.add(i);
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.extractor, 1, 1));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.turret, 1, 2));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.antiAirTurret, 1, 3));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.landFactory, 1, 4));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.airFactory, 1, 5));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.seaFactory, 1, 6));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.fabricator, 1, 7));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.laserDefence, 1, 8));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.repairbay, 1, 9));
    }

    @Override
    public ArrayList N() {
        return this.f().a(this.V());
    }

    @Override
    public void a(BaseUnit am2, int n2) {
    }

    @Override
    public int y() {
        return 145;
    }

    @Override
    public boolean g(BaseUnit am2, boolean bl2) {
        return true;
    }

    @Override
    public float f(UnitType as2) {
        int n2 = this.y();
        int n3 = as2.a(this);
        if (n3 == 0 && as2.p()) {
            n3 = 110;
        }
        return n2 += n3;
    }

    @Override
    public int u(BaseUnit am2) {
        return (int)this.f(am2.r());
    }

    @Override
    public int v(BaseUnit am2) {
        return (int)this.f(am2.r());
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.f();
    }
}

