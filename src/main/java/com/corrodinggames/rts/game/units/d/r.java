/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import java.io.IOException;
import java.util.ArrayList;


import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.UnitCommand;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.game.units.a.ReclaimTargetAction;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.PointF;
import android.graphics.Rect;

public class r
extends d
implements com.corrodinggames.rts.game.units.d_f2 {
    static Texture_M a = null;
    static Texture_M[] b = new Texture_M[10];
    static Texture_M c = null;
    float d;
    public static s e = new s(true);
    Rect f = new Rect();
    Rect g = new Rect();
    static ArrayList h = new ArrayList();
    PointF[] i = new PointF[6];
    PointF[] j = new PointF[this.i.length];

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        super.a(k2);
    }

    public UnitTypeEnum K() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.repairbay;
    }

    public static void M() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.repair_bay);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.repair_bay_dead);
        b = com.corrodinggames.rts.game.PlayerTeam.a(a);
    }

    @Override
    public boolean L() {
        this.M = c;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.normal);
        return true;
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return c;
        }
        if (this.bX == null) {
            return b[b.length - 1];
        }
        return b[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return null;
    }

    @Override
    public void a(int n2) {
    }

    public r(boolean bl2) {
        super(bl2);
        this.M = a;
        this.b(a);
        this.ck = this.cj = 30.0f;
        this.cu = this.cv = 1000.0f;
        this.n.a(-1, -1, 1, 1);
        this.o.a(-1, -1, 1, 1);
        for (int i2 = 0; i2 < this.i.length; ++i2) {
            this.i[i2] = new PointF();
            this.j[i2] = new PointF();
        }
    }

    @Override
    public int y() {
        return 230;
    }

    @Override
    public float c(BaseUnit am2) {
        return 0.2f;
    }

    @Override
    public boolean a(BaseUnit am2) {
        return !am2.q();
    }

    public static UnitCommand a(y y2, float f2, float f3, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        e.a((float)y2.y() + f3, bl2);
        l2.cc.a(y2.posX, y2.posY, (float)y2.y() + f3, y2, f2, e);
        BaseUnit am2 = com.corrodinggames.rts.game.units.d.r.e.e;
        if (am2 != null) {
            UnitCommand au2 = y2.ao();
            au2.b(am2);
            if (au2 != null) {
                au2.k = f3;
                au2.m = true;
                return au2;
            }
        }
        return null;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bT() || this.bV) {
            return;
        }
        this.d += f2;
        if (this.aq() && this.d > 40.0f) {
            this.d = 0.0f;
            com.corrodinggames.rts.game.units.d.r.a(this, f2, 0.0f, false);
        }
        if (!this.bV) {
            com.corrodinggames.rts.game.units.e.b.a(f2, this);
        }
    }

    @Override
    public boolean c(float f2) {
        return super.c(f2);
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
    public boolean l() {
        return false;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        throw new RuntimeException("Unit cannot shoot");
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
    public PointF E(int n2) {
        PointF pointF = this.G(n2);
        float f2 = pointF.x + 0.0f;
        float f3 = pointF.b - 33.0f;
        bg.a(f2, f3);
        return bg;
    }

    @Override
    public ArrayList N() {
        return h;
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
    public float m() {
        return this.y();
    }

    @Override
    public void e(float f2) {
        try {
            super.e(f2);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        float f3 = this.y();
        com.corrodinggames.rts.gameFramework.utility.y.a((BaseUnit)this, f3);
    }

    @Override
    public boolean g(BaseUnit am2, boolean bl2) {
        return true;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.K();
    }

    static {
        h.add(new ReclaimTargetAction(true));
        h.add(new com.corrodinggames.rts.game.units.a.RepairTargetAction());
    }
}

