/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.e;

import java.io.IOException;
import java.util.ArrayList;


import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d_f2;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.game.units.a.ReclaimTargetAction;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.PlaceBuildingAction;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.Vector3D;

import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.PointF;

public class b
extends j
implements d_f2 {
    static Texture_M a = null;
    public static Texture_M b = null;
    static Texture_M c = null;
    public static Texture_M[] d = new Texture_M[10];
    public static Texture_M e = null;
    public static Texture_M f = null;
    static Texture_M g = null;
    public static Texture_M[] h = new Texture_M[10];
    PointF[] i = new PointF[6];
    PointF[] j = new PointF[this.i.length];
    static Paint k;
    static Paint l;
    static Paint m;
    static AbstractUnitAction n;

    public UnitTypeEnum f() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.builder;
    }

    @Override
    public PointF[] b() {
        return this.i;
    }

    @Override
    public PointF[] e_() {
        return this.j;
    }

    @Override
    public Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        return h[this.bX.R()];
    }

    public static void K() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.builder);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.builder_dead);
        c = com.corrodinggames.rts.game.units.e.b.a(a, a.m(), a.l());
        d = com.corrodinggames.rts.game.PlayerTeam.a(a);
        e = l2.bO.a(com.corrodinggames.rts.R.drawable.builder_charge);
        f = l2.bO.a(com.corrodinggames.rts.R.drawable.builder_decharge);
        g = l2.bO.a(com.corrodinggames.rts.R.drawable.unit_icon_builder);
        h = com.corrodinggames.rts.game.PlayerTeam.a(g);
    }

    @Override
    public boolean a(BaseUnit am2) {
        if (am2.q()) {
            return false;
        }
        return am2.bI();
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return b;
        }
        return d[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return c;
    }

    @Override
    public Texture_M d(int n2) {
        return null;
    }

    @Override
    public boolean e() {
        GameEngine l2 = GameEngine.getInstance();
        this.M = b;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.small);
        return true;
    }

    public b(boolean bl2) {
        super(bl2);
        k = new Paint();
        k.a(40, 0, 255, 0);
        k.a(true);
        k.a(2.0f);
        k.a(Paint$Cap.b);
        l = new Paint();
        l.a(k);
        l.a(55, 255, 60, 60);
        m = new Paint();
        m.a(60, 255, 255, 255);
        this.T(20);
        this.U(20);
        this.cj = 10.0f;
        this.ck = this.cj + 2.0f;
        this.cu = this.cv = 170.0f;
        this.M = a;
        for (int i2 = 0; i2 < this.i.length; ++i2) {
            this.i[i2] = new PointF();
            this.j[i2] = new PointF();
        }
    }

    public static void a(float f2, d_f2 d2) {
        block4: {
            PointF[] pointFArray;
            PointF[] pointFArray2;
            block3: {
                y y2 = (y)((Object)d2);
                pointFArray2 = d2.b();
                pointFArray = d2.e_();
                BaseUnit am2 = y2.X();
                boolean bl2 = y2.aN = am2 != null;
                if (am2 == null) break block3;
                for (int i2 = 0; i2 < pointFArray2.length; ++i2) {
                    PointF pointF = pointFArray2[i2];
                    PointF pointF2 = pointFArray[i2];
                    pointF.x = com.corrodinggames.rts.gameFramework.GameUtils.a(pointF.x, pointF2.x, 0.1f * f2);
                    pointF.b = com.corrodinggames.rts.gameFramework.GameUtils.a(pointF.b, pointF2.b, 0.1f * f2);
                    pointF.x += (pointF2.x - pointF.x) * 0.04f * f2;
                    pointF.b += (pointF2.b - pointF.b) * 0.04f * f2;
                    float f3 = am2.cj * 0.75f;
                    if (com.corrodinggames.rts.gameFramework.GameUtils.c(pointF.x - pointF2.x) < 1.0f) {
                        pointF2.x = com.corrodinggames.rts.gameFramework.GameUtils.d(-f3, f3);
                    }
                    if (!(com.corrodinggames.rts.gameFramework.GameUtils.c(pointF.b - pointF2.b) < 1.0f)) continue;
                    pointF2.b = com.corrodinggames.rts.gameFramework.GameUtils.d(-f3, f3);
                }
                break block4;
            }
            if (pointFArray2[0].x == 0.0f && pointFArray2[0].b == 0.0f) break block4;
            for (int i3 = 0; i3 < pointFArray2.length; ++i3) {
                PointF pointF = pointFArray2[i3];
                PointF pointF3 = pointFArray[i3];
                pointF.x = 0.0f;
                pointF.b = 0.0f;
                pointF3.x = 0.0f;
                pointF3.b = 0.0f;
            }
        }
    }

    public static void b(float f2, d_f2 d2) {
        y y2 = (y)((Object)d2);
        BaseUnit am2 = y2.X();
        if (am2 != null) {
            boolean bl2 = y2.Y();
            if (!bl2 && y2.aO) {
                return;
            }
            GameEngine l2 = GameEngine.getInstance();
            PointF[] pointFArray = d2.b();
            Paint paint = k;
            if (bl2) {
                paint = l;
            }
            Vector3D ai2 = y2.bn();
            for (int i2 = 0; i2 < pointFArray.length; ++i2) {
                PointF pointF = pointFArray[i2];
                float f3 = am2.posX + pointF.x - l2.cw;
                float f4 = am2.posY - am2.posZ + pointF.b - l2.cx;
                try {
                    l2.bO.a(ai2.a + pointF.x * 0.15f - l2.cw, ai2.b - ai2.c + pointF.b * 0.15f - l2.cx - y2.posZ, f3, f4, paint);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    l2.bO.k();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    l2.bO.b(f3, f4);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                l2.bO.a(0.5f, 0.5f);
                if (bl2) {
                    try {
                        l2.bO.a(f, 0.0f, 0.0f, m);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    try {
                        l2.bO.a(e, 0.0f, 0.0f, m);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                l2.bO.l();
            }
        }
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
    public float e(int n2) {
        return 30.0f;
    }

    @Override
    public float f(int n2) {
        return 1.3f;
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
        if (!this.bV && (f3 = this.cL[0].speed / this.e(0)) != 0.0f) {
            Vector3D ai2 = this.bn();
            l2.bO.i();
            l2.bO.b(ai2.a - l2.cw, ai2.b - ai2.c - l2.cx);
            l2.bO.a(f3, f3);
            if (this.Y()) {
                try {
                    l2.bO.a(f, 0.0f, 0.0f, null);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                try {
                    l2.bO.a(e, 0.0f, 0.0f, null);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            l2.bO.j();
        }
        return true;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
    }

    @Override
    public float m() {
        return 30.0f;
    }

    @Override
    public float b(int n2) {
        return 100.0f;
    }

    @Override
    public float z() {
        if (this.cK()) {
            return 0.6f;
        }
        return 0.8f;
    }

    @Override
    public float A() {
        if (this.cK()) {
            return 1.7f;
        }
        return 3.8f;
    }

    @Override
    public float B() {
        return 0.35f;
    }

    @Override
    public float c(int n2) {
        return 99.0f;
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public float C() {
        return 0.04f;
    }

    @Override
    public float D() {
        return 0.1f;
    }

    @Override
    public void a(AbstractUnitAction s2, boolean bl2) {
    }

    @SuppressWarnings("unchecked")
    public static void a(ArrayList arrayList, int n2) {
        arrayList.add(n);
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.extractor, 1, 1));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.turret, 1, 2));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.antiAirTurret, 1, 3));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.landFactory, 1, 4));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.airFactory, 1, 5));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.seaFactory, 1, 6));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.laserDefence, 1, 7));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.repairbay, 1, 8));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.fabricator, 1, 9));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.experimentalLandFactory, 1, 10));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.NukeLaucher, 1, 14));
        arrayList.add(new PlaceBuildingAction(com.corrodinggames.rts.game.units.UnitTypeEnum.AntiNukeLaucher, 1, 15));
    }

    @Override
    public ArrayList N() {
        return this.f().a(this.V());
    }

    @Override
    public boolean E() {
        return true;
    }

    @Override
    public float g(int n2) {
        return 10.0f;
    }

    @Override
    public boolean F() {
        return com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bQ.renderExtraShadows && !this.bV;
    }

    @Override
    public float G() {
        return 1.0f;
    }

    @Override
    public float H() {
        return 1.0f;
    }

    @Override
    public boolean g(BaseUnit am2, boolean bl2) {
        return true;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.f();
    }

    static {
        n = new ReclaimTargetAction(false);
    }
}

