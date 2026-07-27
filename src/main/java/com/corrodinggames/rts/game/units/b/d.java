/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.b;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.TransportUnitInterface;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.b.AirUnit;
import com.corrodinggames.rts.game.units.b.d$1;
import com.corrodinggames.rts.game.units.b.d$2;
import com.corrodinggames.rts.game.units.e.i;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.sound.e;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class d
extends AirUnit
implements TransportUnitInterface {
    static com.corrodinggames.rts.gameFramework.m.Texture_M a = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M b = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M c = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] d = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    float e = 0.0f;
    float f;
    boolean g;
    m o = new m();
    Rect p = new Rect();
    public static final AbstractUnitAction q = new d$1(109);
    public static final AbstractUnitAction r = new d$2(110);
    static ArrayList s = new ArrayList();

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.e);
        as2.a(this.f);
        as2.a(this.g);
        as2.a(this.o.size());
        for (BaseUnit am2 : ((List<BaseUnit>)this.o)) {
            as2.a(am2);
        }
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.e = k2.g();
        this.f = k2.g();
        this.g = k2.e();
        this.o.clear();
        int n2 = k2.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            BaseUnit am2 = k2.o();
            if (am2 == null) continue;
            this.o.add(am2);
        }
        super.a(k2);
    }

    @Override
    public int bY() {
        return com.corrodinggames.rts.game.units.e.i.a(this.o);
    }

    @Override
    public int bZ() {
        return 4;
    }

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.dropship;
    }

    public static void L() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.dropship);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.dropship_shadow);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.dropship_dead);
        d = com.corrodinggames.rts.game.PlayerTeam.a(b);
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d() {
        if (this.bV) {
            return a;
        }
        return d[this.bX.R()];
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M k() {
        return c;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d(int n2) {
        return null;
    }

    @Override
    public boolean e() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.b(this.posX, this.posY, this.posZ);
        this.M = a;
        this.S(0);
        this.bT = false;
        this.f(true);
        return true;
    }

    public d(boolean bl2) {
        super(bl2);
        this.T(45);
        this.U(47);
        this.cj = 20.0f;
        this.ck = this.cj + 0.0f;
        this.cu = this.cv = 500.0f;
        this.M = b;
        this.N = c;
        this.posZ = 0.0f;
    }

    @Override
    public boolean I() {
        return true;
    }

    @Override
    public boolean i() {
        return this.posZ >= 4.0f;
    }

    @Override
    public boolean ct() {
        return true;
    }

    @Override
    public void a(float f2) {
        boolean bl2;
        super.a(f2);
        if (this.bV) {
            return;
        }
        boolean bl3 = this.cK();
        if (this.g && !bl3 && !this.cK && this.posZ < 4.0f) {
            this.f = com.corrodinggames.rts.gameFramework.GameUtils.a(this.f, f2);
            if (this.f == 0.0f) {
                this.f = 30.0f;
                if (this.o.size() == 0) {
                    this.g = false;
                } else {
                    bl2 = this.o.size() % 2 == 0;
                    float f3 = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(this.cg) * -9.0f;
                    float f4 = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(this.cg) * -9.0f;
                    f3 += com.corrodinggames.rts.gameFramework.GameUtils.k(this.cg + 90.0f) * (float)(bl2 ? -7 : 7);
                    BaseUnit am2 = (BaseUnit)this.o.remove(this.o.size() - 1);
                    if (!com.corrodinggames.rts.gameFramework.utility.y.a(am2, f3 += com.corrodinggames.rts.gameFramework.GameUtils.j(this.cg + 90.0f) * (float)(bl2 ? -7 : 7), f4)) {
                        f3 += 10.0f;
                    }
                    if (!com.corrodinggames.rts.gameFramework.utility.y.a(am2, f3, f4)) {
                        f3 -= 20.0f;
                    }
                    if (!com.corrodinggames.rts.gameFramework.utility.y.a(am2, f3, f4)) {
                        f3 -= 10.0f;
                        f4 += 10.0f;
                    }
                    if (!com.corrodinggames.rts.gameFramework.utility.y.a(am2, f3, f4)) {
                        f4 -= 20.0f;
                    }
                    if (!com.corrodinggames.rts.gameFramework.utility.y.a(am2, f3, f4)) {
                        this.o.add(am2);
                    } else {
                        am2.cN = null;
                        am2.posX = f3;
                        am2.posY = f4;
                        am2.bZ += 0.1f;
                        am2.cg = this.cg + 180.0f;
                        am2.bR = this;
                        am2.bS = 45.0f;
                        if (am2 instanceof y) {
                            y y2 = (y)am2;
                            y2.az();
                            y2.d(this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(this.cg) * -66.0f, this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(this.cg) * -66.0f);
                        }
                        if (this.o.size() == 0) {
                            this.g = false;
                        }
                    }
                }
            }
        }
        this.e += 2.0f * f2;
        if (this.e > 360.0f) {
            this.e -= 360.0f;
        }
        bl2 = this.i();
        if (this.bT()) {
            this.posZ = this.aq() && !bl3 ? com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, 2.0f, 0.4f * f2) : com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, 35.0f + com.corrodinggames.rts.gameFramework.GameUtils.j(this.e) * 1.5f, 0.35f * f2);
        }
        if (bl2 != this.i()) {
            this.ay = true;
            if (this.i()) {
                this.S(5);
            } else {
                this.S(2);
            }
        }
    }

    @Override
    public PointF E(int n2) {
        float f2 = this.g(n2);
        float f3 = this.cg;
        float f4 = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(f3) * f2;
        float f5 = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(f3) * f2;
        bg.a(f4, f5);
        return bg;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.E(n2);
        f f2 = com.corrodinggames.rts.game.f.a((BaseUnit)this, pointF.x, pointF.b, this.posZ, n2);
        f2.ar = Color.a(255, 150, 230, 40);
        f2.U = 35.0f;
        f2.l = am2;
        f2.h = 80.0f;
        f2.t = 4.0f;
        f2.x = 2.0f;
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(pointF.x, pointF.b, this.posZ, -1127220);
        l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.u, 0.3f, this.posX, this.posY);
    }

    @Override
    public float m() {
        return 140.0f;
    }

    @Override
    public float b(int n2) {
        return 40.0f;
    }

    @Override
    public float z() {
        return 2.3f;
    }

    @Override
    public float A() {
        return 1.4f;
    }

    @Override
    public float c(int n2) {
        return 99.0f;
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
        return 0.05f;
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public float g(int n2) {
        return 15.0f;
    }

    @Override
    public void a() {
        this.f(true);
        super.a();
    }

    public void f(boolean bl2) {
        for (BaseUnit am2 : ((List<BaseUnit>)this.o)) {
            am2.cN = null;
            am2.posX = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(this.cg) * -9.0f;
            am2.posY = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(this.cg) * -9.0f;
            if (!bl2) continue;
            am2.cj();
        }
        this.o.clear();
    }

    @Override
    public boolean bA() {
        return this.g;
    }

    public void M() {
        this.g = true;
        this.f = 30.0f;
    }

    public void ds() {
        this.g = false;
    }

    @Override
    public float bN() {
        return 16000.0f;
    }

    @Override
    public boolean d(BaseUnit am2, boolean bl2) {
        if (this.g) {
            return false;
        }
        if (!com.corrodinggames.rts.game.units.e.i.a(this.o, 4, am2)) {
            return false;
        }
        if (am2 == this) {
            return false;
        }
        if (this.bX != am2.bX && !bl2) {
            return false;
        }
        return com.corrodinggames.rts.gameFramework.utility.y.a(am2, true, true);
    }

    @Override
    public boolean e(BaseUnit am2, boolean bl2) {
        if (!this.d(am2, bl2)) {
            return false;
        }
        this.C(am2);
        return true;
    }

    public void C(BaseUnit am2) {
        am2.cN = this;
        this.o.add(am2);
        GameEngine l2 = GameEngine.getInstance();
        l2.bS.l(am2);
    }

    @Override
    public void e(BaseUnit am2) {
        if (am2.cN == this) {
            this.o.remove(am2);
            am2.cN = null;
        } else {
            com.corrodinggames.rts.gameFramework.GameEngine.g("Unit is not being transported");
        }
    }

    @Override
    public void a(AbstractUnitAction s2, boolean bl2) {
        if (s2 == q) {
            this.M();
        }
        if (s2 == r) {
            this.ds();
        }
    }

    @Override
    public int bB() {
        return this.o.size();
    }

    @Override
    public boolean cr() {
        return true;
    }

    @Override
    public ActionId cp() {
        return q.N();
    }

    @Override
    public ArrayList N() {
        return s;
    }

    @Override
    public boolean f() {
        return !this.cK();
    }

    @Override
    public boolean j() {
        return true;
    }

    @Override
    public m bz() {
        return this.o;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }

    static {
        s.add(q);
        s.add(r);
    }
}

