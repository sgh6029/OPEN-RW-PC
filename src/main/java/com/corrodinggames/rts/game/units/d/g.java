/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.g$1;
import com.corrodinggames.rts.game.units.d.g$2;
import com.corrodinggames.rts.game.units.d.i;
import com.corrodinggames.rts.game.units.d.j;
import com.corrodinggames.rts.gameFramework.sound.e;

import android.graphics.Rect;

import com.corrodinggames.rts.gameFramework.effect.h;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;

import java.io.IOException;
import java.util.ArrayList;

public class g
extends i {
    float a;
    int b = 1;
    float c = 0.0f;
    int d = 0;
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] e = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] f = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] g = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M h = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M i = null;
    Rect j = new Rect();
    Rect k = new Rect();
    public static int l = 0;
    static AbstractUnitAction t = new g$1(102);
    static AbstractUnitAction u = new g$2(103);
    static ArrayList v = new ArrayList();
    static ArrayList w;
    static ArrayList x;

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2)  throws IOException {
        as2.a(this.a);
        as2.a(this.b > 1);
        as2.a(this.b);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.a = k2.g();
        int n2 = 1;
        boolean bl2 = k2.e();
        if (bl2) {
            n2 = 2;
        }
        if (k2.b() >= 31) {
            n2 = k2.readInt();
        }
        if (n2 != 1) {
            this.a(n2);
        }
        super.a(k2);
    }

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.extractor;
    }

    @Override
    public boolean c(PlayerTeam n2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.bL.a(this.posX, this.posY);
        com.corrodinggames.rts.game.b.MapTile g2 = l2.bL.e(l2.bL.T, l2.bL.U);
        if (g2 == null || !g2.i) {
            return false;
        }
        return super.c(n2);
    }

    public static void K() {
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.gameFramework.m.Texture_M e2 = l2.bO.a(com.corrodinggames.rts.R.drawable.extractor);
        com.corrodinggames.rts.gameFramework.m.Texture_M e3 = l2.bO.a(com.corrodinggames.rts.R.drawable.extractor_t2);
        com.corrodinggames.rts.gameFramework.m.Texture_M e4 = l2.bO.a(com.corrodinggames.rts.R.drawable.extractor_t3);
        i = l2.bO.a(com.corrodinggames.rts.R.drawable.extractor_dead);
        e = com.corrodinggames.rts.game.PlayerTeam.a(e2);
        f = com.corrodinggames.rts.game.PlayerTeam.a(e3);
        g = com.corrodinggames.rts.game.PlayerTeam.a(e4);
        e2.n();
        e3.n();
        e4.n();
        h = l2.bO.a(com.corrodinggames.rts.R.drawable.extractor_back);
    }

    @Override
    public boolean L() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(this.posX, this.posY, this.posZ);
        this.M = i;
        this.m = null;
        this.S(0);
        this.bT = false;
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.p, 0.8f, this.posX, this.posY);
        com.corrodinggames.rts.gameFramework.effect.f f2 = com.corrodinggames.rts.gameFramework.effect.f.a(this.posX, this.posY);
        f2.j = -6684775;
        com.corrodinggames.rts.gameFramework.effect.f f3 = com.corrodinggames.rts.gameFramework.effect.f.b(this.posX, this.posY);
        f3.a = 500.0f;
        f3.j = -6684775;
        l2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
        com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.c(this.posX, this.posY, this.posZ, -1127220);
        if (e2 != null) {
            e2.G = 0.15f;
            e2.F = 1.0f;
            e2.ar = (short)2;
            e2.W = e2.V = 35.0f;
            e2.U = 0.0f;
            e2.x = -13378253;
        }
        this.bo();
        return false;
    }

    @Override
    public int bp() {
        return 16;
    }

    @Override
    public void S() {
        super.S();
        this.m = this.bV ? null : h;
    }

    @Override
    public boolean ds() {
        return true;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d() {
        if (this.bV) {
            return i;
        }
        if (this.bX == null) {
            return e[e.length - 1];
        }
        if (this.b == 3) {
            return g[this.bX.R()];
        }
        if (this.b == 2) {
            return f[this.bX.R()];
        }
        return e[this.bX.R()];
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M k() {
        return null;
    }

    public g(boolean bl2) {
        super(bl2);
        this.M = e[9];
        this.T(37);
        this.U(56);
        this.ck = this.cj = 18.0f;
        this.cu = this.cv = 800.0f;
        this.n.a(0, -1, 0, 0);
        this.o.a(this.n);
        this.S();
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bT() || this.bV) {
            return;
        }
        this.c = com.corrodinggames.rts.gameFramework.GameUtils.a(this.c, f2 * (float)this.b);
        if (this.c == 0.0f) {
            this.c = 17.0f;
            ++this.d;
            if (this.d > 7) {
                this.d = 0;
            }
            this.s = this.d <= 3 ? this.d : 7 - this.d;
        }
        this.a += f2;
        if (this.a > com.corrodinggames.rts.game.PlayerTeam.ap - 0.1f) {
            this.a -= com.corrodinggames.rts.game.PlayerTeam.ap;
            this.bX.b(this.cy() * (com.corrodinggames.rts.game.PlayerTeam.ap / com.corrodinggames.rts.game.PlayerTeam.ao));
        }
    }

    @Override
    public float cy() {
        if (this.b == 3) {
            return 18.0f;
        }
        if (this.b == 2) {
            return 12.0f;
        }
        return 8.0f;
    }

    @Override
    public boolean c(float f2) {
        return super.c(f2);
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        throw new RuntimeException("Unit cannot shoot");
    }

    @Override
    public float m() {
        return 0.0f;
    }

    @Override
    public float b(int n2) {
        return 0.0f;
    }

    @Override
    public float c(int n2) {
        return 0.0f;
    }

    @Override
    public void a(j j2) {
        if (j2.j.equals(t.N())) {
            this.a(2);
            this.W();
        }
        if (j2.j.equals(u.N())) {
            this.a(3);
            this.W();
        }
    }

    @Override
    public ActionId cm() {
        if (this.b == 1) {
            return t.N();
        }
        if (this.b == 2) {
            return u.N();
        }
        return com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID;
    }

    @Override
    public int V() {
        return this.b;
    }

    @Override
    public void a(int n2) {
        com.corrodinggames.rts.game.PlayerTeam.b((BaseUnit)this);
        if (this.b > n2) {
            this.b = 1;
            this.cv = 800.0f;
            if (this.cu > this.cv) {
                this.cu = this.cv;
            }
        }
        if (this.b < 2 && n2 >= 2) {
            this.cv += 200.0f;
            this.cu += 200.0f;
        }
        if (this.b < 3 && n2 >= 3) {
            this.cv += 1000.0f;
            this.cu += 1000.0f;
        }
        this.b = n2;
        com.corrodinggames.rts.game.PlayerTeam.c(this);
        this.S();
    }

    @Override
    public ArrayList N() {
        if (this.b == 1) {
            return v;
        }
        if (this.b == 2) {
            return w;
        }
        return x;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }

    static {
        v.add(t);
        w = new ArrayList();
        w.add(u);
        x = new ArrayList();
    }
}

