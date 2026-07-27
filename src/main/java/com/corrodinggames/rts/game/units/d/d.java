/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import java.io.IOException;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.b.MapTile;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.game.units.custom.be;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.effect.a;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;

public abstract class d
        extends y {
    Texture_M m;
    public Rect n = new Rect();
    public Rect o = new Rect();
    public static Texture_M p = null;
    public static Texture_M[] q = new Texture_M[10];
    int r = 1;
    int s = 0;

    public boolean ds() {
        return false;
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.r);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        if (k2.b() >= 15) {
            int n2 = k2.readInt();
            this.R(n2);
        }
        super.a(k2);
    }

    public static boolean a(UnitType as2, float f2, float f3, PlayerTeam n2) {
        GameEngine l2 = GameEngine.getInstance();
        y y2 = (y) com.corrodinggames.rts.game.units.BaseUnit.a(as2);
        l2.bL.b(f2, f3);
        y2.posX = (float) l2.bL.T + y2.cZ();
        y2.posY = (float) l2.bL.U + y2.cZ();
        y2.b(n2);
        boolean bl2 = y2.c((PlayerTeam) null);
        return bl2;
    }

    public void R(int n2) {
        this.r = n2;
    }

    @Override
    public Texture_M d(int n2) {
        return null;
    }

    @Override
    public Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        return q[this.bX.R()];
    }

    public static void dt() {
        GameEngine l2 = GameEngine.getInstance();
        p = l2.bO.a(com.corrodinggames.rts.R.drawable.unit_icon_building);
        q = com.corrodinggames.rts.game.PlayerTeam.a(p);
    }

    public d(boolean bl2) {
        super(bl2);
        this.cg = -90.0f;
        this.bT = false;
    }

    @Override
    public void f_() {
        this.bT = false;
    }

    public boolean L() {
        this.a(com.corrodinggames.rts.game.units.UnitSize.large);
        return false;
    }

    @Override
    public boolean e() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bU.a(this);
        if (this.cm < 1.0f) {
            this.a(com.corrodinggames.rts.game.units.UnitSize.verysmall);
            return false;
        }
        this.s = 0;
        return this.L();
    }

    @Override
    public Rect cd() {
        return this.o;
    }

    @Override
    public Rect cc() {
        return this.n;
    }

    public static boolean a(y y2, UnitType as2, UnitMovementType ao2, int n2, int n3, int n4) {
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        if (!b2.c(n2, n3)) {
            return false;
        }
        boolean bl2 = false;
        if (b2.E && l2.bs.N != null) {
            if (!b2.G && l2.bs.N[n2][n3] == 10) {
                return false;
            }
            boolean bl3 = bl2 = l2.bs.N[n2][n3] >= 5;
        }
        if (d.a(y2, as2, ao2, n2, n3, bl2)) {
            if (as2.p()) {
                MapTile g2 = b2.e(n2, n3);
                return g2 != null && g2.i;
            }
            return !a.a(l2.bs, n2, n3, n4);
        }
        return false;
    }

    public static boolean a(y y2, UnitType as2, UnitMovementType ao2, int n2, int n3, boolean bl2) {
        return d.a(y2, as2, ao2, n2, n3, bl2, null) == null;
    }

    public static String a(y y2, UnitType as2, UnitMovementType ao2, int n2, int n3, boolean bl2, PlayerTeam n4) {
        Object object;
        GameEngine l2 = GameEngine.getInstance();
        if (!l2.bL.c(n2, n3)) {
            return "{0}";
        }
        be be2 = as2.q();
        if (be2 != null && (object = be2.a(y2, n2, n3)) != null) {
            return (String) object;
        }
        if (as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.seaFactory || ao2 == com.corrodinggames.rts.game.units.UnitMovementType.WATER) {
            if (!l2.bU.a(l2.bU.A, n2, n3)) {
                return null;
            }
            return "{3}";
        }
        object = l2.bL.e(n2, n3);
        if (object != null && ((MapTile) object).i) {
            if (as2.p()) {
                return null;
            }
            return "{0}";
        }
        if (ao2 == com.corrodinggames.rts.game.units.UnitMovementType.AIR) {
            return null;
        }
        if (ao2 == com.corrodinggames.rts.game.units.UnitMovementType.OVER_CLIFF_WATER) {
            if (!l2.bU.a(l2.bU.C, n2, n3)) {
                return null;
            }
            return "{0}";
        }
        if (ao2 == com.corrodinggames.rts.game.units.UnitMovementType.OVER_CLIFF) {
            if (!l2.bU.a(l2.bU.D, n2, n3)) {
                return null;
            }
            return "{0}";
        }
        if (ao2 == com.corrodinggames.rts.game.units.UnitMovementType.OVER_CLIFF_WATER) {
            if (!l2.bU.a(l2.bU.E, n2, n3)) {
                return null;
            }
            return "{0}";
        }
        if (l2.bU.a(l2.bU.z, n2, n3, bl2)) {
            boolean bl3 = false;
            if (n4 != null && !l2.bL.a(n2, n3, n4)) {
                bl3 = true;
            }
            if (!bl3) {
                return "{0}";
            }
        }
        return null;
    }

    public static BaseUnit b(int n2, int n3) {
        GameEngine l2 = GameEngine.getInstance();
        l2.bL.a(n2, n3);
        float f2 = l2.bL.T + l2.bL.p;
        float f3 = l2.bL.U + l2.bL.q;
        for (BaseUnit am2 : ((Iterable<BaseUnit>) l2.cc.b(f2, f3, 0.0f))) {
            if (!am2.bI() || am2.bV || !am2.c(f2, f3, 0.0f))
                continue;
            return am2;
        }
        return null;
    }

    @Override
    public void a(int n2) {
    }

    public static BaseUnit g(UnitType as2) {
        if (as2 == null) {
            throw new RuntimeException("type is null");
        }
        return as2.createUnitInstance();
    }

    @Override
    public boolean I() {
        return false;
    }

    @Override
    public UnitMovementType h() {
        return com.corrodinggames.rts.game.units.UnitMovementType.NONE;
    }

    @Override
    public boolean i() {
        return false;
    }

    @Override
    public boolean Q() {
        return false;
    }

    @Override
    public float z() {
        return 0.0f;
    }

    @Override
    public float A() {
        return 0.0f;
    }

    @Override
    public boolean b_() {
        return false;
    }

    public Paint f() {
        int n2;
        GameEngine l2 = GameEngine.getInstance();
        PorterDuffColorFilter porterDuffColorFilter = null;
        if (this.cm < 1.0f) {
            n2 = Color.a((int) (40.0f + this.cm * 200.0f), 140, 255, 140);
            porterDuffColorFilter = aX;
        } else {
            n2 = Color.a(255, 255, 255, 255);
        }
        if (this.cp) {
            if (this.cs) {
                n2 = Color.a(200, 20, 255, 20);
                porterDuffColorFilter = aY;
            }
            if (this.ct) {
                n2 = Color.a(200, 255, 20, 20);
                porterDuffColorFilter = aZ;
            }
            if (this.cq) {
                n2 = Color.a(70, 70, 70, 245);
                porterDuffColorFilter = ba;
                if (this.ct) {
                    n2 = Color.a(70, 255, 20, 20);
                    porterDuffColorFilter = aZ;
                }
            }
            if (this.cr) {
                n2 = Color.a(150, 100, 100, 100);
            }
        }
        boolean bl2 = l2.bQ.renderAntiAlias;
        if (!this.dk()) {
            bl2 = false;
            if (l2.cX < 1.0f) {
                bl2 = true;
            }
        }
        if (this.co) {
            bl2 = com.corrodinggames.rts.game.units.UnitTypeEnum.ag;
        }
        return this.a(n2, porterDuffColorFilter, bl2);
    }

    @Override
    public boolean c(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        int n2 = this.s * this.es;
        int n3 = 0;
        RectF rectF = this.cF();
        dv.a(n2, n3, n2 + this.es, n3 + this.et);
        try {
            l2.bO.a(this.M, dv, rectF, this.f());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void d(float f2) {
        try {
            super.d(f2);
            if (this.m == null) {
                return;
            }
            GameEngine l2 = GameEngine.getInstance();
            if (this.ds()) {
                l2.bO.b(this.m, this.posX - (float) ((int) (this.m.t + 0.1f)) - l2.cw,
                        this.posY - (float) ((int) (this.m.u + 0.1f)) - l2.cx, this.f());
            } else {
                int n2 = 0;
                int n3 = 0;
                RectF rectF = this.cF();
                dv.a(n2, n3, n2 + this.es, n3 + this.et);
                l2.bO.a(this.m, dv, rectF, this.f());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean bI() {
        return true;
    }
}
