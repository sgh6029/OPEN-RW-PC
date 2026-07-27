/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.a.AIUnitGroupBase;
import com.corrodinggames.rts.game.a.BaseZone;
import com.corrodinggames.rts.game.a.BaseZoneStage;
import com.corrodinggames.rts.game.a.o;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.PathfindingUtils;
import com.corrodinggames.rts.gameFramework.GameCommand;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.PointF;

import com.corrodinggames.rts.game.units.y;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnitGroup
extends AIUnitGroupBase {
    boolean a;
    String b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    y g;
    boolean h = true;
    int i;
    int j;
    BaseZone k;
    float l = 1000.0f;
    float m = 100.0f;
    float n = 4000.0f;
    float o = 0.0f;
    float p = 1000.0f;
    boolean q = false;
    boolean r = false;
    boolean s = false;
    float t = 0.0f;
    float u = 0.0f;
    boolean v;
    BaseUnit w;
    float x;
    float y;
    float z;
    int A;
    boolean B;
    public int C = -9999;
    public BaseUnit D = null;
    UnitMovementType E = UnitMovementType.NONE;

    @Override
    public boolean a() {
        return this.a;
    }

    @Override
    public boolean b() {
        return !this.h;
    }

    public static UnitGroup a(AIController a2, y y2) {
        UnitGroup g2 = new UnitGroup(a2, false);
        g2.a = true;
        g2.c = true;
        g2.d = true;
        g2.e = true;
        g2.g = y2;
        g2.a(y2);
        g2.A = 0;
        g2.k();
        return g2;
    }

    @Override
    public void a(GameOutputStream as2) throws IOException {
        as2.a(this.h);
        as2.a(this.i);
        as2.a(this.j);
        int n2 = this.F.size();
        as2.a(n2);
        ArrayList<y> tmp = this.F;
        for (y y2 : tmp) {
            as2.a(y2);
        }
        as2.c(7);
        as2.a(false);
        as2.a(this.s);
        as2.a(this.o);
        as2.a(this.G.size());
        ArrayList<y> tmp2 = this.G;
        for (y y2 : tmp2) {
            as2.a(y2);
        }
        as2.a(this.B);
        as2.a(this.a);
        as2.a(this.c);
        as2.a(this.d);
        as2.a(this.e);
        as2.a(this.f);
        as2.a(this.g);
        as2.a(this.A);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        int n2;
        this.h = k2.e();
        this.i = k2.readInt();
        this.j = k2.readInt();
        this.q();
        int n3 = k2.readInt();
        for (n2 = 0; n2 < n3; ++n2) {
            y y2 = k2.p();
            if (y2 == null) continue;
            this.a(y2);
        }
        n2 = k2.d();
        if (n2 >= 1) {
            k2.e();
        }
        if (n2 >= 2) {
            this.s = k2.e();
        }
        if (n2 >= 3) {
            this.o = k2.g();
        }
        if (n2 >= 4) {
            this.G.clear();
            int n4 = k2.readInt();
            for (int i2 = 0; i2 < n4; ++i2) {
                y y3 = k2.p();
                if (y3 == null) continue;
                this.G.add(y3);
            }
        }
        if (n2 >= 5) {
            this.B = k2.e();
        }
        if (n2 >= 6) {
            this.a = k2.e();
            this.c = k2.e();
            this.d = k2.e();
            this.e = k2.e();
            this.f = k2.e();
            this.g = k2.p();
        }
        if (n2 >= 7) {
            this.A = k2.readInt();
        }
        if (!this.B) {
            Iterator iterator = this.F.iterator();
            while (iterator.hasNext()) {
                y y4 = (y)iterator.next();
                if (!(y4 instanceof com.corrodinggames.rts.game.units.h.f)) continue;
                if (y4 != null && y4.aB == this) {
                    y4.aB = null;
                }
                if (y4 != null) {
                    this.G.remove(y4);
                }
                iterator.remove();
            }
        }
        super.a(k2);
    }

    public UnitGroup(AIController a2) {
        super(a2);
    }

    public UnitGroup(AIController a2, boolean bl2) {
        this(a2);
        this.h = bl2;
    }

    @Override
    protected void a(y y2) {
        super.a(y2);
        this.E = this.j();
    }

    public void c() {
        List<BaseUnit> tmp2 = BaseUnit.bE;
        for (BaseUnit am2 :tmp2) {
            if (am2.bV || am2.bX != this.R || this.A <= this.F.size() || !(am2 instanceof y)) continue;
            y y2 = (y)am2;
            if (y2.bM || y2.bN || y2.aB != null || !this.R.h(y2) || !this.R.i(y2) || (!this.B ? am2.h() == UnitMovementType.WATER : am2.h() == UnitMovementType.LAND)) continue;
            if (!this.R.a((BaseUnit)y2, this.S, this.T) && (this.b() || com.corrodinggames.rts.gameFramework.GameUtils.a(0, 100) > 2)) continue;
            this.a(y2);
        }
    }

    public boolean d() {
        return this.A <= this.F.size();
    }

    public BaseUnit a(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        if ((float)l2.by - f2 * 1000.0f < (float)this.C) {
            return this.D;
        }
        return null;
    }

    public BaseUnit e() {
        BaseUnit am2 = this.a(6.0f);
        if (am2 != null) {
            return am2;
        }
        return null;
    }

    public BaseUnit f() {
        ArrayList<y> tmp =  this.F;
        for (y y2 :tmp) {
            BaseUnit am2 = y2.ab();
            if (am2 == null) continue;
            return am2;
        }
        return null;
    }

    public void a(com.corrodinggames.rts.gameFramework.GameCommand e2, boolean bl2, BaseUnit am2) {
        ArrayList<y> tmp =  this.F;
        for (y y2 :tmp) {
            if (bl2 && !y2.aq() || am2 != null && !this.R.a((BaseUnit)y2, am2)) continue;
            e2.a(y2);
        }
    }

    public void a(String string2) {
        this.b = string2;
    }

    public PointF a(BaseUnit am2) {
        PointF pointF = new PointF();
        pointF.x = this.S;
        pointF.b = this.T;
        float f2 = 50.0f;
        float f3 = 100.0f;
        float f4 = (float)(Math.random() * 360.0);
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.c(f2, f3);
        pointF.x += com.corrodinggames.rts.gameFramework.GameUtils.k(f4) * f5;
        pointF.b += com.corrodinggames.rts.gameFramework.GameUtils.j(f4) * f5;
        if (am2 != null) {
            f2 = 100.0f;
            f3 = 200.0f;
            f4 = com.corrodinggames.rts.gameFramework.GameUtils.d(pointF.x, pointF.b, am2.posX, am2.posY);
            f5 = com.corrodinggames.rts.gameFramework.GameUtils.c(f2, f3);
            pointF.x += com.corrodinggames.rts.gameFramework.GameUtils.k(f4) * -f5;
            pointF.b += com.corrodinggames.rts.gameFramework.GameUtils.j(f4) * -f5;
        }
        return pointF;
    }

    @Override
    public void b(float f2) {
        BaseUnit am2;
        BaseUnit am3;
        super.b(f2);
        this.n();
        this.E = this.j();
        if (!this.f && (am3 = this.e()) != null && (am2 = this.f()) == null) {
            if (this.a(am3, false)) {
                this.a("fighting attacker");
                GameEngine l2 = GameEngine.getInstance();
                GameCommand e2 = l2.cf.a(this.R);
                this.a(e2, true, am3);
                boolean bl2 = false;
                e2.a(am3.posX, am3.posY, bl2);
            } else {
                this.a("flight from attacker");
                PointF pointF = this.a(am3);
                this.S = pointF.x;
                this.T = pointF.b;
                if (this.z > 200.0f) {
                    this.z = 200.0f;
                }
            }
        }
    }

    @Override
    public void c(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        this.x += f2;
        for (Object object : this.F) {
            if (object == null || this.C >= ((y)object).bs) continue;
            this.C = ((y)object).bs;
            this.D = ((y)object).bt;
        }
        this.n();
        if (this.d()) {
            this.l = com.corrodinggames.rts.gameFramework.GameUtils.a(this.l, f2);
        } else if (this.v) {
            // empty if block
        }
        this.y = com.corrodinggames.rts.gameFramework.GameUtils.a(this.y, f2);
        this.z = com.corrodinggames.rts.gameFramework.GameUtils.a(this.z, f2);
        this.p = com.corrodinggames.rts.gameFramework.GameUtils.a(this.p, f2);
        if (!(this.v || this.r || this.d() || this.y != 0.0f)) {
            this.y = 200 + com.corrodinggames.rts.gameFramework.GameUtils.c(200);
            this.c();
        }
        if (!this.v || this.q) {
            Object object;
            if (!this.q) {
                this.n = com.corrodinggames.rts.gameFramework.GameUtils.a(this.n, f2);
                if (this.n == 0.0f) {
                    if (this.k == null) {
                        this.k = this.g();
                    }
                    if (this.k != null) {
                        object = this.k.w();
                        if (!this.a(((PointF)object).x, ((PointF)object).b)) {
                            this.n = 100.0f;
                            this.a("random move: bad target");
                        } else {
                            this.n = 4000.0f;
                            this.S = ((PointF)object).x;
                            this.T = ((PointF)object).b;
                            this.a("random move");
                        }
                    } else {
                        this.a("random move: no linked base");
                    }
                }
            }
            if (this.z == 0.0f) {
                this.z = 800.0f;
                object = l2.cf.a(this.R);
        ArrayList<y> tmp =  this.F;
        for (y y2 :tmp) {
                    boolean bl2 = true;
                    if (this.c(y2) < 28900.0f) {
                        bl2 = false;
                    }
                    if (!this.f && y2.aj() && !y2.aq()) {
                        bl2 = false;
                    }
                    if (!bl2) continue;
                    ((GameCommand)object).a(y2);
                }
                if (this.f) {
                    ((GameCommand)object).a(this.S, this.T);
                } else {
                    ((GameCommand)object).b(this.S, this.T);
                }
            }
        }
        if (this.h) {
            this.e(f2);
        } else {
            this.d(f2);
        }
        if (this.A == 0 && this.F.size() == 0) {
            this.p();
        }
        if (this.c && (this.g == null || this.g.bV)) {
            this.p();
        }
    }

    BaseZone g() {
        float f2 = -1.0f;
        BaseZone i2 = null;
        ArrayList<o> tmp =this.R.bn;
        for (o o2 : tmp) {
            if (!(o2 instanceof BaseZone)) continue;
            BaseZone i3 = (BaseZone)o2;
            if (!this.b(i3.S, i3.T)) continue;
            float f3 = i3.d(this.S, this.T);
            if (i2 != null && !(f3 < f2)) continue;
            f2 = f3;
            i2 = i3;
        }
        return i2;
    }

    public void d(float f2) {
        int n2;
        if (this.k == null || this.k.V) {
            this.k();
        }
        if (this.c && this.g != null) {
            if (this.e && !this.f) {
                if ((double)(this.g.cu / this.g.cv) < 0.5) {
                    this.f = true;
                    if (this.z > 100.0f) {
                        this.z = 100.0f;
                    }
                }
                if (this.w == null) {
                    this.k();
                }
            } else {
                if ((double)(this.g.cu / this.g.cv) > 0.6) {
                    this.f = false;
                }
                n2 = 0;
                if (this.k != null && !this.k.t) {
                    n2 = 1;
                }
                if (n2 == 0) {
                    boolean bl2 = true;
                    BaseZone i2 = this.R.a(this.g.h(), this.g.posX, this.g.posY, bl2);
                    if (i2 != null) {
                        this.k = i2;
                    }
                    if (this.k != null) {
                        PointF pointF = this.k.w();
                        this.S = pointF.x;
                        this.T = pointF.b;
                        if (this.z > 100.0f) {
                            this.z = 100.0f;
                        }
                        this.a("moving to new base");
                    }
                }
            }
        }
        if (this.k != null) {
            for (n2 = 0; n2 < 2; ++n2) {
                if (this.p != 0.0f) continue;
                BaseUnit am2 = this.k.g();
                if (am2 == null) break;
                if (!this.a(am2, false)) continue;
                this.w = am2;
                this.p = 500.0f;
                this.n = 2000.0f;
                if (!this.f) {
                    this.S = am2.posX;
                    this.T = am2.posY;
                }
                if (this.z > 100.0f) {
                    this.z = 100.0f;
                }
                this.a("defending base");
            }
            if (this.p == 0.0f) {
                this.f = false;
                this.w = null;
            }
        }
    }

    public void e(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        if (!this.v) {
            if (this.l == 0.0f) {
                this.v = true;
                this.q = true;
            }
        } else {
            if (this.w == null || !this.w.bT() || this.w.bV || !this.r) {
                this.w = this.R.as();
                if (this.w != null && !this.a(this.w, true)) {
                    this.w = null;
                }
            }
            if (this.w != null) {
                if (this.q) {
                    this.u += f2;
                    if (!this.r) {
                        this.t = com.corrodinggames.rts.gameFramework.GameUtils.a(this.t, f2);
                        if (this.t == 0.0f) {
                            this.t = 20.0f;
                            this.h();
                        }
                    } else {
                        boolean bl2 = false;
        ArrayList<y> tmp =  this.F;
        for (y y2 :tmp) {
                            if (!(this.c(y2) > 28900.0f)) continue;
                            bl2 = true;
                        }
                        if (!bl2) {
                            this.q = false;
                        }
        ArrayList<y> tmp2 =  this.F;
        for (y y2 :tmp2) {
                            if (y2.bs <= l2.by - 1000) continue;
                            this.q = false;
                            this.a("Not staging due to damage");
                        }
                    }
                    if (this.u > 17000.0f) {
                        this.q = false;
                        this.a("attacking target");
                    }
                } else {
                    this.o += f2;
                    if (this.z == 0.0f) {
                        this.z = 800.0f;
                        boolean bl3 = false;
                        m m2 = new m();
        ArrayList<y> tmp =  this.F;
        for (y y3 :tmp) {
                            boolean bl4 = true;
                            if (this.w != null) {
                                if (!this.R.a((BaseUnit)y3, this.w)) {
                                    bl4 = false;
                                }
                                if (bl4 && !PathfindingUtils.a(y3, this.w)) {
                                    bl4 = false;
                                }
                            }
                            if (!bl4) continue;
                            bl3 = true;
                            m2.add(y3);
                        }
                        if (!bl3) {
                            this.q = false;
                            this.a("cannot reach main target");
                        } else {
                            GameCommand e2 = l2.cf.a(this.R);
                            e2.a(m2);
                            boolean bl5 = true;
                            if (this.w != null && com.corrodinggames.rts.gameFramework.GameUtils.a(0, 100) < 80) {
                                e2.a(this.w.posX, this.w.posY, bl5);
                            } else {
                                e2.a(this.w, bl5);
                            }
                            this.a("attacking main target");
                        }
                    }
                }
            }
        }
        if (this.v) {
            if (this.F.size() == 0) {
                this.p();
            }
            if (this.o > 1000.0f && this.F.size() < 3) {
                this.p();
            }
            if (this.o > 11000.0f) {
                this.p();
            }
        }
    }

    public void h() {
        int n2;
        float f2 = this.w.posX;
        float f3 = this.w.posY;
        float f4 = com.corrodinggames.rts.gameFramework.GameUtils.d(f2, f3, this.S, this.T);
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.b(f2, f3, this.S, this.T);
        if (com.corrodinggames.rts.gameFramework.GameUtils.a(0, 100) < 80) {
            f4 += (float)com.corrodinggames.rts.gameFramework.GameUtils.a(-110, 110);
        }
        if ((n2 = (int)((double)f5 * 0.6)) < 720) {
            n2 = 720;
        }
        float f6 = com.corrodinggames.rts.gameFramework.GameUtils.a(50, n2);
        if (com.corrodinggames.rts.gameFramework.GameUtils.a(0, 100) < 80 && f6 < 450.0f) {
            f6 = com.corrodinggames.rts.gameFramework.GameUtils.a(450, n2);
        }
        boolean bl2 = true;
        if (!this.a(f2 += com.corrodinggames.rts.gameFramework.GameUtils.k(f4) * f6, f3 += com.corrodinggames.rts.gameFramework.GameUtils.j(f4) * f6)) {
            bl2 = false;
        }
        boolean bl3 = false;
        boolean bl4 = false;
        ArrayList<y> tmp = this.F;
        for (y y2 : tmp) {
            if (y2.h() == UnitMovementType.LAND) {
                bl3 = true;
            }
            if (y2.h() != UnitMovementType.WATER) continue;
            bl4 = true;
        }
        if (bl3) {
            if (this.R.aG == 0 && !this.b(f2, f3)) {
                bl2 = false;
            }
            if (!this.R.a(f2, f3, this.w.posX, this.w.posY, UnitMovementType.LAND) && com.corrodinggames.rts.gameFramework.GameUtils.a(0, 100) < 98) {
                bl2 = false;
            }
        }
        if (bl4) {
            if (!this.b(f2, f3)) {
                bl2 = false;
            }
            if (!this.R.a(f2, f3, this.w.posX, this.w.posY, UnitMovementType.WATER)) {
                bl2 = false;
            }
        }
        if (bl2) {
            this.S = f2;
            this.T = f3;
            this.z = 0.0f;
            this.r = true;
            this.G.clear();
        ArrayList<y> tmp2 = this.F;
        for (y y2 : tmp2) {
                if (y2.h() == UnitMovementType.WATER || this.R.a((BaseUnit)y2, this.S, this.T)) continue;
                this.G.add(y2);
            }
        }
    }

    public UnitMovementType i() {
        return this.E;
    }

    public UnitMovementType j() {
        if (this.F.size() == 0) {
            if (this.B) {
                return UnitMovementType.WATER;
            }
            return UnitMovementType.LAND;
        }
        boolean bl2 = true;
        for (Object object : this.F) {
            Object object2 = ((BaseUnit)object).h();
            if (object2 == UnitMovementType.AIR) continue;
            bl2 = false;
            break;
        }
        if (bl2) {
            return UnitMovementType.AIR;
        }
        if (this.B) {
            boolean bl3 = true;
            for (Object object2 : this.F) {
                UnitMovementType ao2 = ((BaseUnit)object2).h();
                if (ao2 != UnitMovementType.WATER) continue;
                bl3 = false;
            }
            if (bl3) {
                return UnitMovementType.HOVER;
            }
            return UnitMovementType.WATER;
        }
        boolean bl4 = true;
        for (Object object2 : this.F) {
            UnitMovementType ao3 = ((BaseUnit)object2).h();
            if (ao3 != UnitMovementType.LAND && ao3 != UnitMovementType.OVER_CLIFF) continue;
            bl4 = false;
        }
        if (bl4) {
            return UnitMovementType.HOVER;
        }
        return UnitMovementType.LAND;
    }

    public boolean a(float f2, float f3) {
        return !com.corrodinggames.rts.gameFramework.utility.y.a(f2, f3, this.i());
    }

    public boolean b(float f2, float f3) {
        ArrayList<y> tmp = this.F;
        for (y y2 : tmp) {
            if (this.R.a((BaseUnit)y2, f2, f3)) continue;
            return false;
        }
        return true;
    }

    public boolean a(BaseUnit am2, boolean bl2) {
        ArrayList<y> tmp = this.F;
        for (y y2 : tmp) {
            if (!bl2 && !this.R.a((BaseUnit)y2, am2.posX, am2.posY) || !PathfindingUtils.a(y2, am2)) continue;
            return true;
        }
        return false;
    }

    public void k() {
        boolean bl2 = true;
        PointF pointF = null;
        if (this.c && this.g != null) {
            this.S = this.g.posX;
            this.T = this.g.posY;
            this.k = this.R.c(this.g.posX, this.g.posY);
            return;
        }
        if (bl2) {
            for (int i2 = 0; i2 < 7; ++i2) {
                boolean bl3;
                boolean bl4 = bl3 = i2 > 3;
                if (pointF != null) continue;
                ArrayList<o> tmp=this.R.bn;
                for (o o2 : tmp) {
                    if (!(o2 instanceof BaseZone)) continue;
                    BaseZone i3 = (BaseZone)o2;
                    if (i3.b != com.corrodinggames.rts.game.a.BaseZoneStage.Active || i3.u() <= 2 && !bl3 || pointF != null && com.corrodinggames.rts.gameFramework.GameUtils.c(this.R.ay + 2) != 0) continue;
                    for (int i4 = 0; i4 < 10; ++i4) {
                        if (pointF != null) continue;
                        PointF pointF2 = i3.w();
                        if (!this.a(pointF2.x, pointF2.b)) continue;
                        pointF = pointF2;
                    }
                    this.k = i3;
                }
            }
        }
        if (pointF == null) {
            pointF = this.R.am();
            this.k = null;
        }
        this.S = pointF.x;
        this.T = pointF.b;
    }
}

