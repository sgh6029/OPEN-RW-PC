/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.h;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.h.e$1;
import com.corrodinggames.rts.game.units.h.e$2;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.Color;
import android.graphics.PointF;

import java.io.IOException;
import java.util.ArrayList;

public class e
extends com.corrodinggames.rts.game.units.h.f {
    boolean a = false;
    boolean b = true;
    float c = 0.0f;
    static com.corrodinggames.rts.gameFramework.m.Texture_M d = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M e = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M f = null;
    public static com.corrodinggames.rts.gameFramework.m.Texture_M g = null;
    public static com.corrodinggames.rts.gameFramework.m.Texture_M[] h = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] i = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    public static final AbstractUnitAction j = new e$1(151);
    public static final AbstractUnitAction k = new e$2(152);
    static ArrayList l = new ArrayList();

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.a);
        as2.a(this.c);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.a = k2.e();
        boolean bl2 = this.b = !this.Q();
        if (k2.b() >= 21) {
            this.c = k2.g();
        }
        this.L();
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
        GameEngine l2 = GameEngine.getInstance();
        e = l2.bO.a(com.corrodinggames.rts.R.drawable.attack_submarine);
        f = com.corrodinggames.rts.game.units.h.e.a(e, e.m(), e.l());
        d = l2.bO.a(com.corrodinggames.rts.R.drawable.attack_submarine_dead);
        g = l2.bO.a(com.corrodinggames.rts.R.drawable.unit_icon_water);
        h = com.corrodinggames.rts.game.PlayerTeam.a(g);
        i = com.corrodinggames.rts.game.PlayerTeam.a(e);
    }

    @Override
    public boolean F() {
        return com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bQ.renderExtraShadows && this.posZ >= 0.0f;
    }

    @Override
    public float G() {
        return 0.0f;
    }

    @Override
    public float H() {
        return 0.0f;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d() {
        if (this.bV) {
            return d;
        }
        return i[this.bX.R()];
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M k() {
        return f;
    }

    @Override
    public UnitMovementType h() {
        return com.corrodinggames.rts.game.units.UnitMovementType.WATER;
    }

    public UnitTypeEnum f() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.attackSubmarine;
    }

    @Override
    public boolean K() {
        return !this.Q();
    }

    public e(boolean bl2) {
        super(bl2);
        this.b(e);
        this.cj = 15.0f;
        this.ck = this.cj - 2.0f;
        this.cu = this.cv = 260.0f;
        this.M = e;
    }

    public void L() {
        if (!this.b) {
            this.S(1);
        } else {
            this.S(2);
        }
    }

    @Override
    public void s(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        float f3 = this.a ? 1.0f : -8.0f;
        this.c = com.corrodinggames.rts.gameFramework.GameUtils.c(this.posZ - f3) > 2.0f ? com.corrodinggames.rts.gameFramework.GameUtils.a(this.c, 0.08f, 0.003f * f2) : com.corrodinggames.rts.gameFramework.GameUtils.a(this.c, 0.02f, 0.003f * f2);
        this.posZ = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, f3, this.c * f2);
        boolean bl2 = false;
        if (this.b && this.Q()) {
            this.b = false;
            this.L();
            bl2 = true;
        }
        if (!this.b && !this.Q()) {
            this.b = true;
            this.L();
            bl2 = true;
        }
        if (bl2) {
            l2.bR.a(this.posX, this.posY, 0.0f, 0, 0.0f, 0.0f, this.cg);
        }
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bT() || this.bV) {
            return;
        }
    }

    @Override
    public float m() {
        if (!this.Q()) {
            return 250.0f;
        }
        return 180.0f;
    }

    @Override
    public float b(int n2) {
        return 170.0f;
    }

    @Override
    public float e(int n2) {
        return 10.0f;
    }

    @Override
    public float z() {
        if (!this.Q()) {
            return 0.8f;
        }
        return 0.45f;
    }

    @Override
    public float A() {
        return 1.2f;
    }

    @Override
    public float B() {
        return 0.06f;
    }

    @Override
    public float c(int n2) {
        return 2.5f;
    }

    @Override
    public float w(int n2) {
        return 0.08f;
    }

    @Override
    public float C() {
        return 0.018f;
    }

    @Override
    public float D() {
        return 0.1f;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d(int n2) {
        return null;
    }

    @Override
    public boolean l() {
        return true;
    }

    @Override
    public boolean Q() {
        return this.posZ < -1.0f;
    }

    @Override
    public boolean ah() {
        return !this.Q();
    }

    @Override
    public boolean ae() {
        return this.Q();
    }

    @Override
    public boolean af() {
        return !this.Q();
    }

    @Override
    public boolean ag() {
        if (!this.Q()) {
            return true;
        }
        return true;
    }

    @Override
    public float q(int n2) {
        return 42.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        if (!this.Q()) {
            PointF pointF = this.E(n2);
            f f2 = com.corrodinggames.rts.game.f.a((BaseUnit)this, pointF.x, pointF.b, this.posZ, n2);
            PointF pointF2 = this.K(n2);
            f2.K = pointF2.x;
            f2.L = pointF2.b;
            f2.ar = Color.a(255, 230, 230, 50);
            f2.U = 42.0f;
            f2.l = am2;
            f2.h = 190.0f;
            f2.t = 2.0f;
            f2.aH = true;
            f2.aM = true;
            f2.aQ = true;
            GameEngine l2 = GameEngine.getInstance();
            l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.m, 0.8f, this.posX, this.posY);
            l2.bR.a(this.posX, this.posY, this.posZ, -1118720);
        } else {
            PointF pointF = this.E(n2);
            f f3 = com.corrodinggames.rts.game.f.a((BaseUnit)this, pointF.x, pointF.b, this.posZ, n2);
            PointF pointF3 = this.K(n2);
            f3.K = pointF3.x;
            f3.L = pointF3.b;
            f3.ar = Color.a(255, 30, 30, 150);
            f3.x = 1.0f;
            f3.U = 42.0f;
            f3.l = am2;
            f3.h = 250.0f;
            f3.t = 1.3f;
            f3.aH = false;
            f3.aM = true;
            f3.aQ = true;
            GameEngine l3 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        }
    }

    @Override
    public boolean e() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.b(this.posX, this.posY, this.posZ);
        this.M = d;
        this.S(0);
        this.bT = false;
        return true;
    }

    @Override
    public void a(AbstractUnitAction s2, boolean bl2) {
        if (s2 == j) {
            this.a = true;
        }
        if (s2 == k) {
            this.a = false;
        }
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
        y.a((BaseUnit)this, f3);
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.f();
    }

    static {
        l.add(j);
        l.add(k);
    }
}

