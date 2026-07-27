/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;


import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.PlaceBuildingAction;
import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.PointF;

import com.corrodinggames.rts.gameFramework.GameEngine;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class h_f
        extends com.corrodinggames.rts.game.units.e.j
        implements d_f2 {
    PointF[] a = new PointF[6];
    PointF[] b = new PointF[this.a.length];
    boolean c;
    static Paint d;
    static Paint e;
    static Paint f;
    static com.corrodinggames.rts.gameFramework.m.Texture_M g;
    static AbstractUnitAction h;
    static AbstractUnitAction i;
    static AbstractUnitAction j;
    static AbstractUnitAction k;
    static AbstractUnitAction l;
    static AbstractUnitAction m;
    static AbstractUnitAction n;
    static AbstractUnitAction o;
    static AbstractUnitAction p;
    static AbstractUnitAction q;
    String r;
    static AbstractUnitAction s;
    static AbstractUnitAction t;
    static AbstractUnitAction u;
    static AbstractUnitAction v;
    static AbstractUnitAction w;
    static AbstractUnitAction x;
    static AbstractUnitAction y;
    static AbstractUnitAction z;
    static AbstractUnitAction A;
    static AbstractUnitAction B;
    static AbstractUnitAction C;
    static ArrayList D;
    com.corrodinggames.rts.gameFramework.i.b E;
    o F;
    n G;
    String H;
    boolean I;
    String J;
    static com.corrodinggames.rts.game.units.a.ActionFilter K;

    public UnitTypeEnum f() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.editorOrBuilder;
    }

    public static boolean w() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        return l2.cb.i();
    }

    @Override
    public PointF[] b() {
        return this.a;
    }

    @Override
    public PointF[] e_() {
        return this.b;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        return dN[this.bX.R()];
    }

    public static void K() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        g = l2.bO.a(com.corrodinggames.rts.R.drawable.icon_search);
    }

    @Override
    public boolean a(BaseUnit am2) {
        return true;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d() {
        if (this.bV) {
            return com.corrodinggames.rts.game.units.e.b.b;
        }
        return com.corrodinggames.rts.game.units.e.b.d[this.bX.R()];
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M k() {
        return null;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d(int n2) {
        return null;
    }

    @Override
    public boolean e() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        l2.bR.b(this.posX, this.posY, this.posZ);
        this.M = com.corrodinggames.rts.game.units.e.b.b;
        this.S(0);
        this.bT = false;
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.o, 0.8f, this.posX, this.posY);
        this.bq();
        return true;
    }

    public h_f(boolean bl2) {
        super(bl2);
        d = new Paint();
        d.a(40, 0, 255, 0);
        d.a(true);
        d.a(2.0f);
        d.a(Paint$Cap.b);
        e = new Paint();
        e.a(d);
        e.a(55, 255, 60, 60);
        f = new Paint();
        f.a(60, 255, 255, 255);
        this.E = null;
        this.F = com.corrodinggames.rts.game.units.o.land;
        this.G = com.corrodinggames.rts.game.units.n.all;
        this.I = true;
        this.T(20);
        this.U(20);
        this.cj = 10.0f;
        this.posX = -1000.0f;
        this.posY = -1000.0f;
        this.ck = this.cj;
        this.cu = this.cv = 170000.0f;
        this.M = com.corrodinggames.rts.game.units.e.b.b;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = new PointF();
            this.b[i2] = new PointF();
        }
    }

    public static void a(float f2, d_f2 d2) {
        block4: {
            PointF[] pointFArray;
            PointF[] pointFArray2;
            block3: {
                y y2 = (y) ((Object) d2);
                pointFArray2 = d2.b();
                pointFArray = d2.e_();
                BaseUnit am2 = y2.X();
                boolean bl2 = y2.aN = am2 != null;
                if (am2 == null)
                    break block3;
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
                    if (!(com.corrodinggames.rts.gameFramework.GameUtils.c(pointF.b - pointF2.b) < 1.0f))
                        continue;
                    pointF2.b = com.corrodinggames.rts.gameFramework.GameUtils.d(-f3, f3);
                }
                break block4;
            }
            if (pointFArray2[0].x == 0.0f && pointFArray2[0].b == 0.0f)
                break block4;
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

    @Override
    public void a(float f2) {
        if (f2 < 0.3f) {
            f2 = 0.3f;
        }
        if (this.ax && this.bX.b()) {
            for (int i2 = 0; i2 < com.corrodinggames.rts.game.PlayerTeam.c; ++i2) {
                com.corrodinggames.rts.game.PlayerTeam n2 = com.corrodinggames.rts.game.PlayerTeam.k(i2);
                if (n2 == null || n2.b())
                    continue;
                this.e(n2);
                break;
            }
        }
        super.a(f2);
        if (!this.bV) {
            com.corrodinggames.rts.game.units.h_f.a(f2, this);
        }
        this.cu = this.cv;
    }

    @Override
    public void a(float f2, boolean bl2) {
        if (!this.bV) {
            // empty if block
        }
    }

    @Override
    public float e(int n2) {
        return 0.0f;
    }

    @Override
    public float f(int n2) {
        return 0.0f;
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
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        return true;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
    }

    @Override
    public boolean b_() {
        return false;
    }

    @Override
    public int y() {
        return 850000;
    }

    @Override
    public float b(BaseUnit am2) {
        return 1.0E7f;
    }

    @Override
    public float c(BaseUnit am2) {
        return 1.0E7f;
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
        return 0.0f;
    }

    @Override
    public float A() {
        return 9.8f;
    }

    @Override
    public float B() {
        return 9.35f;
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
    public void a(AbstractUnitAction var1, boolean var2) {
        GameEngine var3 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        boolean var5;
        if (var1 instanceof k) {
            k var4 = (k) var1;
            var5 = true;
            if (var2) {
                var5 = !var5;
            }

            if (var4.a) {
                var5 = !var5;
            }

            int var7;
            com.corrodinggames.rts.game.PlayerTeam var8;
            if (var5) {
                Object var6 = null;

                for (var7 = this.bX.k + 1; var7 < com.corrodinggames.rts.game.PlayerTeam.c; ++var7) {
                    var8 = com.corrodinggames.rts.game.PlayerTeam.k(var7);
                    if (var8 != null && !var8.b()) {
                        var6 = var8;
                        break;
                    }
                }

                if (var6 == null && this.bX.k < 4) {
                    var6 = com.corrodinggames.rts.game.PlayerTeam.k(this.bX.k + 1);
                    if (var6 == null) {
                        com.corrodinggames.rts.gameFramework.GameEngine.log("Sandbox adding new team:" + this.bX.k);
                        AIController var14 = new AIController(this.bX.k + 1);
                        var6 = var14;
                        var14.r = 1;
                        var14.F = true;
                        var14.G = true;
                        if (!this.c) {
                            var14.bG = 0.0F;
                        } else {
                            var14.bG = Float.MAX_VALUE;
                        }
                    }
                }

                if (var6 == null) {
                    for (var7 = 0; var7 < com.corrodinggames.rts.game.PlayerTeam.c; ++var7) {
                        var8 = com.corrodinggames.rts.game.PlayerTeam.k(var7);
                        if (var8 != null && !var8.b()) {
                            var6 = var8;
                            break;
                        }
                    }
                }

                if (var6 != null) {
                    this.e((com.corrodinggames.rts.game.PlayerTeam) var6);
                    if (!var3.cb.j()) {
                        var3.bs = (com.corrodinggames.rts.game.PlayerTeam) var6;
                    }
                }
            } else {
                com.corrodinggames.rts.game.PlayerTeam var15 = null;

                for (var7 = this.bX.k - 1; var7 >= 0; --var7) {
                    var8 = com.corrodinggames.rts.game.PlayerTeam.k(var7);
                    if (var8 != null && !var8.b()) {
                        var15 = var8;
                        break;
                    }
                }

                if (var15 == null) {
                    for (var7 = com.corrodinggames.rts.game.PlayerTeam.c - 1; var7 >= 0; --var7) {
                        var8 = com.corrodinggames.rts.game.PlayerTeam.k(var7);
                        if (var8 != null && !var8.b()) {
                            var15 = var8;
                            break;
                        }
                    }
                }

                if (var15 != null) {
                    this.e(var15);
                    if (!var3.cb.j()) {
                        var3.bs = var15;
                    }
                }
            }
        }

        if (var1 instanceof com.corrodinggames.rts.game.units.j) {
            com.corrodinggames.rts.game.units.j var12 = (com.corrodinggames.rts.game.units.j) var1;
            var5 = true;
            if (var2) {
                var5 = !var5;
            }

            if (var12.a) {
                var5 = !var5;
            }

            ArrayList var19 = var3.bZ.j();
            if (var19.size() == 0) {
                this.E = null;
            } else {
                boolean var17;
                com.corrodinggames.rts.gameFramework.i.b var18;
                if (var5) {
                    if (this.E == null) {
                        this.E = (com.corrodinggames.rts.gameFramework.i.b) var19.get(0);
                    } else {
                        var18 = null;
                        var17 = false;
                        Iterator var9 = var19.iterator();

                        while (var9.hasNext()) {
                            com.corrodinggames.rts.gameFramework.i.b var10 = (com.corrodinggames.rts.gameFramework.i.b) var9
                                    .next();
                            if (var17) {
                                var18 = var10;
                                break;
                            }

                            if (var10 == this.E) {
                                var17 = true;
                            }
                        }

                        this.E = var18;
                    }
                } else if (this.E == null) {
                    this.E = (com.corrodinggames.rts.gameFramework.i.b) var19.get(var19.size() - 1);
                } else {
                    var18 = null;
                    var17 = false;
                    ArrayList var16 = new ArrayList();
                    var16.addAll(var19);
                    Collections.reverse(var16);
                    Iterator var20 = var16.iterator();

                    while (var20.hasNext()) {
                        com.corrodinggames.rts.gameFramework.i.b var11 = (com.corrodinggames.rts.gameFramework.i.b) var20
                                .next();
                        if (var17) {
                            var18 = var11;
                            break;
                        }

                        if (var11 == this.E) {
                            var17 = true;
                        }
                    }

                    this.E = var18;
                }
            }
        }

        if (var1 instanceof com.corrodinggames.rts.game.units.l) {
            com.corrodinggames.rts.game.units.l var13 = (com.corrodinggames.rts.game.units.l) var1;
            var5 = true;
            if (var2) {
                var5 = !var5;
            }

            if (var13.a) {
                var5 = !var5;
            }

            this.F = this.F.a(!var5);
        }

        if (var1 instanceof i) {
            this.bX.d(10000.0F);
        }

        if (var1 instanceof m) {
            ((m) var1).n();
        }

    }

    static h_f L() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        return l2.bS.i();
    }

    @Override
    public void a(com.corrodinggames.rts.game.units.a.AbstractUnitAction sVar, boolean z, android.graphics.PointF pointF,
            com.corrodinggames.rts.game.units.BaseUnit amVar) throws IOException {
        com.corrodinggames.rts.gameFramework.GameEngine B = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();

        com.corrodinggames.rts.game.units.a.AbstractUnitAction sVar2 = sVar;
        if (sVar instanceof com.corrodinggames.rts.game.units.a.FilteredUnitAction) {
            sVar2 = ((com.corrodinggames.rts.game.units.a.FilteredUnitAction) sVar).q_();
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.h) {
            if (com.corrodinggames.rts.game.units.h_f.w()) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("Not reloading units: Need to keep network sync");
                B.bS.b("Not reloading units: Need to keep network sync");
                return;
            }
            if (!z) {
                if (B.bZ.h() == 0) {
                    B.bS.b("No custom units to reload");
                    return;
                }
                com.corrodinggames.rts.gameFramework.GameEngine.log("Reload units requested");
                try {
                    B.bZ.a(true, false);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                java.util.Iterator it = com.corrodinggames.rts.game.PlayerTeam.c().iterator();
                while (it.hasNext()) {
                    com.corrodinggames.rts.game.PlayerTeam nVar = (com.corrodinggames.rts.game.PlayerTeam) it.next();
                    if (nVar instanceof com.corrodinggames.rts.game.a.AIController) {
                        ((com.corrodinggames.rts.game.a.AIController) nVar).al();
                    }
                }
                B.bS.b("All custom unit files reloaded");
            }
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.i) {
            if (com.corrodinggames.rts.game.units.h_f.w()) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("Not reloading units: Need to keep network sync");
                return;
            }
            if (!z) {
                if (B.bZ.h() == 0) {
                    B.bS.b("No custom units to reload");
                    return;
                }
                com.corrodinggames.rts.gameFramework.GameEngine.log("Reload active only requested");
                try {
                    B.bZ.a(true, true);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                java.util.Iterator it2 = com.corrodinggames.rts.game.PlayerTeam.c().iterator();
                while (it2.hasNext()) {
                    com.corrodinggames.rts.game.PlayerTeam nVar2 = (com.corrodinggames.rts.game.PlayerTeam) it2.next();
                    if (nVar2 instanceof com.corrodinggames.rts.game.a.AIController) {
                        ((com.corrodinggames.rts.game.a.AIController) nVar2).al();
                    }
                }

                int i = com.corrodinggames.rts.game.units.custom.ag.d;
                String str = "Quick reloaded changed data for " + i + " units active on map.";
                int i2 = 100;
                if (B.bQ.liveReloading && i == 0) {
                    str = str
                            + " (Note: Live reloading is currently enabled, so changed units may have already be reloaded)";
                    i2 = 170;
                }
                B.bS.a(str, i2);
            }
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.k || sVar2 == com.corrodinggames.rts.game.units.h_f.l
                || sVar2 == com.corrodinggames.rts.game.units.h_f.j) {
            int i3 = 0;
            if (!z) {
                java.util.Iterator it3 = com.corrodinggames.rts.game.units.BaseUnit.bF().iterator();
                while (it3.hasNext()) {
                    com.corrodinggames.rts.game.units.BaseUnit amVar2 = (com.corrodinggames.rts.game.units.BaseUnit) it3.next();
                    if (amVar2 instanceof com.corrodinggames.rts.game.units.BaseUnit) {
                        if (com.corrodinggames.rts.gameFramework.GameUtils.a(amVar2.posX, amVar2.posY, pointF.x,
                                pointF.b) < 150.0f) {
                            if (sVar2 == com.corrodinggames.rts.game.units.h_f.k) {
                                if (amVar2.cN == null && amVar2.cO == null) {
                                    amVar2.ci();
                                    if (amVar2 instanceof com.corrodinggames.rts.game.units.y) {
                                        if (amVar2.bI()) {
                                            B.bU.a((com.corrodinggames.rts.game.units.y) amVar2);
                                        }
                                    }
                                }
                            } else if (sVar2 == com.corrodinggames.rts.game.units.h_f.l) {
                                if (amVar2.cN == null && amVar2.cO == null) {
                                    amVar2.cu = -0.5f;
                                }
                            } else if (sVar2 == com.corrodinggames.rts.game.units.h_f.j) {
                                if (i3 <= 4) {
                                    if (!amVar2.bI() && !(amVar2 instanceof com.corrodinggames.rts.game.units.Tree)
                                            && !amVar2.bV && amVar2.cN == null && amVar2.cO == null) {
                                        int i4 = i3 + 1;
                                        com.corrodinggames.rts.game.units.UnitType r = amVar2.r();
                                        for (int i5 = -25; i5 < 25; i5++) {
                                            com.corrodinggames.rts.game.units.BaseUnit a = r.createUnitInstance();
                                            a.posX = amVar2.posX + (((float) i5) * 0.25f) + 0.5f;
                                            a.posY = amVar2.posY + (((float) i5) * 0.25f) + 0.5f;
                                            a.b(amVar2.bX);
                                            com.corrodinggames.rts.game.PlayerTeam.c(a);
                                            a.cg = com.corrodinggames.rts.gameFramework.GameUtils.a(amVar2, -180f, 180f,
                                                    i5 + 25);
                                            if (a instanceof com.corrodinggames.rts.game.units.y) {
                                                ((com.corrodinggames.rts.game.units.y) a).ay = true;
                                            }
                                        }
                                        i3 = i4;
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            return;
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.n) {
            if (!z) {
                com.corrodinggames.rts.game.f a2 = com.corrodinggames.rts.game.units.d.q.a(this, pointF.x, pointF.b,
                        pointF.x, pointF.b);
                if (a2 != null) {
                    a2.posZ = 1.25f;
                    a2.j = null;
                }
            }
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.m) {
            if (!z) {
                java.util.Iterator it4 = com.corrodinggames.rts.game.units.BaseUnit.bF().iterator();
                while (it4.hasNext()) {
                    com.corrodinggames.rts.gameFramework.GGameObject wVar = (com.corrodinggames.rts.gameFramework.GGameObject) it4.next();
                    if (wVar instanceof com.corrodinggames.rts.game.units.y
                            && wVar instanceof com.corrodinggames.rts.game.units.d.l) {
                        if (com.corrodinggames.rts.gameFramework.GameUtils.a(wVar.posX, wVar.posY, pointF.x,
                                pointF.b) < 150.0f) {
                            ((com.corrodinggames.rts.game.units.d.l) wVar).dz();
                        }
                    }
                }
            }
            return;
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.o) {
            com.corrodinggames.rts.game.PlayerTeam nVar3 = this.bX;
            if (nVar3 instanceof com.corrodinggames.rts.game.a.AIController) {
                com.corrodinggames.rts.game.a.AIController aVar = (com.corrodinggames.rts.game.a.AIController) nVar3;
                if (aVar.bG > 0.0f) {
                    aVar.bG = 0.0f;
                } else {
                    aVar.bG = 50.0f;
                }
            }
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.p) {
            com.corrodinggames.rts.game.PlayerTeam nVar4 = this.bX;
            nVar4.r++;
            if (nVar4.r > 4) {
                nVar4.r = 0;
            }
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.u) {
            boolean z2 = false;
            boolean z3 = false;
            java.util.Iterator it5 = com.corrodinggames.rts.game.PlayerTeam.c().iterator();
            while (it5.hasNext()) {
                com.corrodinggames.rts.game.PlayerTeam nVar5 = (com.corrodinggames.rts.game.PlayerTeam) it5.next();
                if (nVar5 instanceof com.corrodinggames.rts.game.a.AIController) {
                    com.corrodinggames.rts.game.a.AIController aVar2 = (com.corrodinggames.rts.game.a.AIController) nVar5;
                    if (aVar2.bG > 0.0f) {
                        z2 = true;
                    }
                    z3 = true;
                }
            }
            boolean z4 = !z2;
            if (!z3) {
                z4 = !this.c;
            }
            this.c = z4;
            M();
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.z) {
            B.bl = !B.bl;
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.A) {
            com.corrodinggames.rts.game.a.AIController.as = !com.corrodinggames.rts.game.a.AIController.as;
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.B) {
            B.bn = !B.bn;
        }

        if (sVar2 == com.corrodinggames.rts.game.units.h_f.C) {
            B.bY.a();
        }

        if (sVar2 instanceof com.corrodinggames.rts.game.units.q) {
            com.corrodinggames.rts.game.units.q qVar = (com.corrodinggames.rts.game.units.q) sVar2;
            com.corrodinggames.rts.game.units.p.a(qVar.a, pointF);
        }

        super.a(sVar2, z, pointF, amVar);
    }

    public void M() {
        for (com.corrodinggames.rts.game.PlayerTeam n2 : ((ArrayList<com.corrodinggames.rts.game.PlayerTeam>) com.corrodinggames.rts.game.PlayerTeam
                .c())) {
            if (!(n2 instanceof AIController))
                continue;
            AIController a2 = (AIController) n2;
            if (!this.c) {
                a2.bG = 0.0f;
                continue;
            }
            a2.bG = Float.MAX_VALUE;
        }
    }

    public static boolean a(AbstractUnitAction s2, BaseUnit am2) {
        if (s2 instanceof com.corrodinggames.rts.game.units.a.FilteredUnitAction) {
            s2 = ((com.corrodinggames.rts.game.units.a.FilteredUnitAction) s2).q_();
        }
        if (s2 == o) {
            return true;
        }
        if (s2 == w) {
            return true;
        }
        if (s2 == x) {
            return true;
        }
        if (s2 == m) {
            return true;
        }
        if (s2 == k) {
            return true;
        }
        if (s2 == j) {
            return true;
        }
        if (s2 == z) {
            return true;
        }
        if (s2 == p) {
            return true;
        }
        if (s2 == q) {
            return true;
        }
        if (s2 == s) {
            return true;
        }
        if (s2 == t) {
            return true;
        }
        if (s2 == B) {
            return true;
        }
        return s2 == C;
    }

    @SuppressWarnings("unchecked")
    public static void a(ArrayList arrayList, int n2) {
        Object object;
        if (n2 != 1) {
            return;
        }
        D = new ArrayList();
        D.add(new k(true, false));
        D.add(new k(true, true));
        D.add(new k(false, false));
        D.add(new m(true, false));
        m m2 = new m(true, true);
        D.add(m2);
        D.add(new m(false, false));
        D.add(new j(true, false));
        D.add(new j(true, true));
        D.add(new j(false, false));
        D.add(new l(true, false));
        D.add(new l(true, true));
        D.add(new l(false, false));
        D.add(new com.corrodinggames.rts.game.units.q(com.corrodinggames.rts.game.units.r.a));
        D.add(new com.corrodinggames.rts.game.units.q(com.corrodinggames.rts.game.units.r.b));
        D.add(new com.corrodinggames.rts.game.units.q(com.corrodinggames.rts.game.units.r.c));
        D.add(new com.corrodinggames.rts.game.units.q(com.corrodinggames.rts.game.units.r.d));
        ArrayList<AbstractUnitAction> arrayList2 = new ArrayList<AbstractUnitAction>();
        arrayList2.add(new i());
        arrayList2.add(y);
        arrayList2.add(h);
        arrayList2.add(i);
        arrayList2.add(k);
        arrayList2.add(j);
        arrayList2.add(l);
        arrayList2.add(n);
        arrayList2.add(m);
        arrayList2.add(u);
        arrayList2.add(v);
        arrayList2.add(w);
        arrayList2.add(x);
        arrayList2.add(z);
        arrayList2.add(p);
        arrayList2.add(q);
        arrayList2.add(s);
        arrayList2.add(t);
        if (com.corrodinggames.rts.gameFramework.GameEngine.at) {
            arrayList2.add(A);
        }
        arrayList2.add(B);
        arrayList2.add(C);
        for (AbstractUnitAction object22 : arrayList2) {
            boolean as2 = true;
            object = new com.corrodinggames.rts.game.units.a.FilteredUnitAction(object22, K, as2);
            D.add(object);
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(com.corrodinggames.rts.game.units.UnitTypeEnum.ae);
        Collections.sort(arrayList3, new h$15());
        Iterator iterator = arrayList3.iterator();
        while (iterator.hasNext()) {
            Object object2;
            UnitType as2 = (UnitType) iterator.next();
            if (as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.wall_v || as2.i().equals("test_tank")
                    || as2.i().equals("missing") || as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.tankDestroyer
                    || as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.megaTank
                    || as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.fogRevealer
                    || as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.crystalResource
                    || as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.damagingBorder
                    || as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.zoneMarker
                    || as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.editorOrBuilder
                    || as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.dummyNonUnitWithTeam
                    || as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.supplyDepot
                    || !((object = com.corrodinggames.rts.game.units.BaseUnit.c(as2)) instanceof y))
                continue;
            if (as2 instanceof com.corrodinggames.rts.game.units.custom.l) {
                object2 = (com.corrodinggames.rts.game.units.custom.l) as2;
                if (!((com.corrodinggames.rts.game.units.custom.l) object2).aF)
                    continue;
            }
            object2 = new PlaceBuildingAction(as2, 1, null);
            object2 = new com.corrodinggames.rts.game.units.a.FilteredUnitAction((AbstractUnitAction) object2, K);
            boolean bl2 = false;
            for (AbstractUnitAction s2 : ((ArrayList<AbstractUnitAction>) D)) {
                if (!s2.equals(object2))
                    continue;
                bl2 = true;
            }
            if (bl2)
                continue;
            D.add(object2);
        }
    }

    @Override
    public ArrayList N() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        return D;
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
    public boolean u() {
        return true;
    }

    @Override
    public boolean I() {
        return false;
    }

    @Override
    public boolean d(BaseUnit am2) {
        return false;
    }

    @Override
    public boolean J() {
        return true;
    }

    @Override
    public float a(BaseUnit am2, float f2, f f3) {
        f2 = 0.0f;
        return super.a(am2, f2, f3);
    }

    @Override
    public void O() {
    }

    @Override
    public boolean P() {
        return true;
    }

    public void a(h_f h2) {
        this.r = h2.r;
        this.c = h2.c;
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.c(1);
        as2.a(this.G);
        as2.b(this.H);
        super.a(as2);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameInputStream k2) throws IOException {
        byte by = k2.d();
        this.G = (n) k2.b(n.class);
        if (this.G == null) {
            this.G = com.corrodinggames.rts.game.units.n.all;
        }
        if (by >= 1) {
            this.H = k2.j();
        }
        super.a(k2);
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.f();
    }

    static {
        h = new h$1("reloadUnits");
        i = new h$12("reloadOnlyActiveUnits");
        j = new h$17("unitClone");
        k = new h$18("removeUnits");
        l = new h$19("killUnits");
        m = new h$20("finishQueue");
        n = new h$21("nukeAt");
        o = new h$22("freezeAI");
        p = new h$23("changeAlliance");
        q = new h$2("startRecording");
        s = new h$3("startReplayPlayback");
        t = new h$4("hideInterface");
        u = new h$5("freezeAllAI");
        v = new h$6("pauseGame");
        w = new h$7("slowGame");
        x = new h$8("fastForward");
        y = new h$9("search");
        z = new h$10("enableDebug");
        A = new h$11("enableAIDebug");
        B = new h$13("enableTriggerDebug");
        C = new h$14("clearSaveHistory");
        K = new h$16();
    }
}
