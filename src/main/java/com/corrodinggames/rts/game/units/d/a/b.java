/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d.a;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.UnitSize;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.a.a;
import com.corrodinggames.rts.game.units.d.a.b$1;
import com.corrodinggames.rts.game.units.d.a.b$2;
import com.corrodinggames.rts.game.units.d.a.b$3;
import com.corrodinggames.rts.game.units.d.a.b$4;
import com.corrodinggames.rts.game.units.d.a.c;
import com.corrodinggames.rts.game.units.d.a.d;
import com.corrodinggames.rts.game.units.d.a.e;
import com.corrodinggames.rts.game.units.d.a.f;
import com.corrodinggames.rts.game.units.d.a.g;
import com.corrodinggames.rts.game.units.d.a.h;
import com.corrodinggames.rts.game.units.d.i;
import com.corrodinggames.rts.game.units.d.j;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.PointF;
import android.graphics.Rect;

import java.io.IOException;
import java.util.ArrayList;

public class b extends i {
    static com.corrodinggames.rts.gameFramework.m.Texture_M g = null;
    private static com.corrodinggames.rts.gameFramework.m.Texture_M a = null;
    private static com.corrodinggames.rts.gameFramework.m.Texture_M b = null;
    private static com.corrodinggames.rts.gameFramework.m.Texture_M c = null;
    private static com.corrodinggames.rts.gameFramework.m.Texture_M d = null;
    private static com.corrodinggames.rts.gameFramework.m.Texture_M e = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] h = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M i = null;
    boolean j;
    int k;
    c l = new h(this);
    static String t = "gun";
    static String u = "gunT2";
    static String v = "gunT3";
    static String w = "artillery";
    static String x = "flamethrower";
    static String C = "aa_t1";
    static String D = "aa_t2";
    static String E = "aa_flak";
    static com.corrodinggames.rts.gameFramework.m.Texture_M F = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] G = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    boolean H = true;
    float I;
    float J;
    boolean K;
    Rect dK = new Rect();
    public static AbstractUnitAction dL = new b$1(101);
    public static AbstractUnitAction dM = new b$2(104);
    public static AbstractUnitAction dN = new b$3(102);
    public static AbstractUnitAction dO = new b$4(103);
    static ArrayList dP = new ArrayList();

    public int M() {
        return this.l.b();
    }

    @Override
    public float H(int n2) {
        return this.l.h(n2);
    }

    @Override
    public void a_(String string2) {
        this.b(string2);
    }

    public void b(String string2) {
        if (!this.l.a(string2)) {
            c c2 = this.l;
            this.l = this.c(string2);
            this.l.a(c2);
        }
    }

    public c c(String string2) {
        if (string2.equals(t)) {
            return new h(this);
        }
        if (string2.equals(u)) {
            return new f(this);
        }
        if (string2.equals(v)) {
            return new g(this);
        }
        if (string2.equals(w)) {
            return new d(this);
        }
        if (string2.equals(x)) {
            return new e(this);
        }
        return null;
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2)  throws IOException {
        as2.a(this.j);
        as2.a(this.k == 1);
        as2.writeUTF(this.l.c());
        as2.a(this.k);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        boolean bl2 = k2.e();
        if (bl2) {
            this.a(2);
        }
        if (k2.b() >= 27) {
            int n2 = this.k = k2.e() ? 1 : 0;
        }
        if (k2.b() >= 35) {
            String string2 = k2.l();
            if (!this.l.a(string2)) {
                this.b(string2);
            }
            this.k = k2.readInt();
        } else if (bl2 && !(this instanceof a)) {
            this.b(u);
        }
        super.a(k2);
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        return G[this.bX.R()];
    }

    public static void dB() {
        GameEngine l2 = GameEngine.getInstance();
        g = l2.bO.a(com.corrodinggames.rts.R.drawable.turret_base);
        i = l2.bO.a(com.corrodinggames.rts.R.drawable.turret_base_dead);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.turret_top);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.turret_top_l2);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.turret_top_l3);
        d = l2.bO.a(com.corrodinggames.rts.R.drawable.turret_top_artillery);
        e = l2.bO.a(com.corrodinggames.rts.R.drawable.turret_top_flame);
        h = com.corrodinggames.rts.game.PlayerTeam.a(g);
        F = l2.bO.a(com.corrodinggames.rts.R.drawable.unit_icon_building_turrent);
        G = com.corrodinggames.rts.game.PlayerTeam.a(F);
    }

    @Override
    public boolean L() {
        this.M = i;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.large);
        return true;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d() {
        if (this.bV) {
            return i;
        }
        if (this.bX == null) {
            return h[h.length - 1];
        }
        return h[this.bX.R()];
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M k() {
        return null;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d(int n2) {
        return this.l.d(n2);
    }

    public b(boolean bl2) {
        super(bl2);
        this.T(35);
        this.U(42);
        this.ck = this.cj = 16.0f;
        this.cu = this.cv = 700.0f;
        this.M = g;
        this.cL[0].targetX = com.corrodinggames.rts.gameFramework.GameUtils.a(this, -180, 180);
        this.n.a(0, 0, 1, 1);
        this.o.a(0, 0, 1, 1);
    }

    public void s(float f2) {
        int n2 = 0;
        if (this.cL[n2].a()) {
            if (this.H) {
                this.I = this.cL[n2].targetX;
                this.H = false;
                this.J = com.corrodinggames.rts.gameFramework.GameUtils.a(this, 0, 120);
            }
            this.J += f2;
            if (this.J > 450.0f) {
                this.J = com.corrodinggames.rts.gameFramework.GameUtils.a(this, 0, 30);
                boolean bl2 = this.K = !this.K;
            }
            if (this.J < 120.0f) {
                if (this.K) {
                    this.a(f2 * 0.3f, this.I - 20.0f, n2);
                } else {
                    this.a(f2 * 0.3f, this.I + 20.0f, n2);
                }
            }
        } else {
            this.H = true;
        }
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.bT()) {
            this.l.a(f2);
        }
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        this.l.a(am2, n2);
    }

    @Override
    public float m() {
        return this.l.a();
    }

    @Override
    public float b(int n2) {
        return this.l.a(n2);
    }

    @Override
    public float c(int n2) {
        return this.l.e(n2);
    }

    @Override
    public float w(int n2) {
        return this.l.f(n2);
    }

    @Override
    public boolean b(int n2, float f2) {
        return false;
    }

    @Override
    public boolean c(float f2) {
        if (!super.c(f2)) {
            return false;
        }
        if (!this.bV) {
            this.dC();
        }
        return true;
    }

    void dC() {
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.gameFramework.m.Texture_M e2 = null;
        int n2 = 0;
        e2 = this.d(n2);
        PointF pointF = this.G(n2);
        try {
            l2.bO.a(e2, pointF.x - com.corrodinggames.rts.gameFramework.GameEngine.getInstance().cw, pointF.b - com.corrodinggames.rts.gameFramework.GameEngine.getInstance().cx, this.cL[n2].targetX, this.f());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public UnitTypeEnum K() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.turret;
    }

    @Override
    public boolean l() {
        return true;
    }

    @Override
    public boolean af() {
        return false;
    }

    @Override
    public float g(int n2) {
        return this.l.g(n2);
    }

    @Override
    public void M(int n2) {
        if (this.b(n2) < 10.0f) {
            return;
        }
        super.M(n2);
    }

    @Override
    public void a(j j2) {
        AbstractUnitAction s2 = this.a(j2.j);
        if (s2 != null) {
            s2.f(this);
        } else {
            com.corrodinggames.rts.gameFramework.j.NetworkEngine.a("specialAction=null on completeQueueItem(turret) for item.uIndex:" + j2.j + " id:" + this.objectId, true);
        }
    }

    @Override
    public com.corrodinggames.rts.game.units.a.ActionId cm() {
        if (this.M() == 1) {
            return dL.N();
        }
        if (this.l instanceof f) {
            return dM.N();
        }
        return AbstractUnitAction.NONE_ACTION_ID;
    }

    @Override
    public void a(ArrayList arrayList) {
        arrayList.clear();
        if (this.M() == 1) {
            arrayList.add(dN.N());
            arrayList.add(dO.N());
        }
    }

    @Override
    public void a(int n2) {
        if (n2 == 1) {
            this.j = false;
        } else if (n2 == 2 && !this.j) {
            this.j = true;
        }
    }

    @Override
    public PointF E(int n2) {
        return this.l.c(n2);
    }

    @Override
    public float bV() {
        if (this.cL[0].rotation > 0.0f && this.l.a(w)) {
            return 1.0f - this.cL[0].rotation / this.b(0);
        }
        return super.bV();
    }

    @Override
    public PointF G(int n2) {
        bh.a(super.G(n2));
        bh.b(0.0f, -5.0f);
        return bh;
    }

    @Override
    public ArrayList N() {
        return dP;
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
    public int cL() {
        return this.l.d();
    }

    @Override
    public float q(int n2) {
        return this.l.b(n2);
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.K();
    }

    static /* synthetic */ PointF a(b b2, int n2) {
        return b2.G(n2);//直接调用父类方法，避免循环
    }

    static /* synthetic */ com.corrodinggames.rts.gameFramework.m.Texture_M dD() {
        return a;
    }

    static /* synthetic */ com.corrodinggames.rts.gameFramework.m.Texture_M dE() {
        return b;
    }

    static /* synthetic */ PointF b(b b2, int n2) {
        return b2.G(n2);//直接调用父类方法，避免循环
    }

    static /* synthetic */ com.corrodinggames.rts.gameFramework.m.Texture_M dF() {
        return c;
    }

    static /* synthetic */ PointF c(b b2, int n2) {
        return b2.G(n2);//直接调用父类方法，避免循环
    }

    static /* synthetic */ com.corrodinggames.rts.gameFramework.m.Texture_M dG() {
        return d;
    }

    static /* synthetic */ com.corrodinggames.rts.gameFramework.m.Texture_M dH() {
        return e;
    }

    static /* synthetic */ void a(b b2) {
        b2.W();
    }

    static /* synthetic */ void b(b b2) {
        b2.W();
    }

    static /* synthetic */ void c(b b2) {
        b2.W();
    }

    static /* synthetic */ void d(b b2) {
        b2.W();
    }

    static {
        dP.add(dL);
        dP.add(dM);
        dP.add(dN);
        dP.add(dO);
    }
}
