/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.effect;

import com.corrodinggames.rts.game.b.TileMap;

import java.io.IOException;
import java.util.List;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.utility.o;

import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

public class a {
    float a;
    float b;
    public boolean c;
    public UnitType d;
    public PlayerTeam e;
    public int f = 1;
    public float g;
    public float h;
    public boolean i;
    public PlayerTeam j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public y o;
    boolean p = false;
    public boolean q = false;
    public int r;
    public float s;
    public float t = 0.04f;
    public boolean u;
    public BaseUnit v;
    public static o w = new o();
    static Point x = new Point();
    static RectF y = new RectF();
    static RectF z = new RectF();
    static RectF A = new RectF();
    Paint B = new Paint();
    static Paint C;
    static Paint D;
    static RectF E;

    public a() {
        w.add(this);
        w.a();
    }

    public static void a() {
        w.clear();
    }

    public static void a(float f2) {
        for (a a2 : ((List<a>) w)) {
            a2.c(f2);
        }
        w.a();
    }

    public static void b(float f2) {
        Object[] objectArray = w.b();
        int n2 = w.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            a a2 = (a) objectArray[i2];
            a2.d(f2);
        }
    }

    public static boolean a(PlayerTeam n2, int n3, int n4, int n5) {
        GameEngine l2 = GameEngine.getInstance();
        l2.bL.a(n3, n4);
        float f2 = l2.bL.T + l2.bL.p;
        float f3 = l2.bL.U + l2.bL.q;
        y.a(f2, f3, f2 + 1.0f, f3 + 1.0f);
        return com.corrodinggames.rts.gameFramework.effect.a.a(n2, y, n5);
    }

    public static boolean a(PlayerTeam n2, y y2, int n3) {
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        y = y2.a(b2, y);
        return com.corrodinggames.rts.gameFramework.effect.a.a(n2, y, n3);
    }

    public static boolean a(y y2, y y3) {
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        return com.corrodinggames.rts.gameFramework.GameUtils.a(y = y2.a(b2, y), z = y3.a(b2, z));
    }

    public static boolean a(PlayerTeam n2, RectF rectF, int n3) {
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        RectF rectF2 = A;
        for (a a2 :((List<a>)w) ){
            if (a2.j != n2 || !a2.n || n3 != -1 && n3 != a2.r)
                continue;
            BaseUnit am2 = BaseUnit.a(a2.d);
            if (am2 == null) {
                com.corrodinggames.rts.gameFramework.GameEngine
                        .log("isTileRectOverBlueprint: Failed to get shared unit for: " + a2.d);
                continue;
            }
            am2.posX = a2.g;
            am2.posY = a2.h;
            if (!com.corrodinggames.rts.gameFramework.GameUtils.a(rectF2 = am2.a(b2, rectF2), rectF))
                continue;
            return true;
        }
        return false;
    }

    public static a a(PlayerTeam n2, float f2, float f3) {
        for (a a2 : ((List<a>)w) ){
            if (a2.j != n2 || !a2.n)
                continue;
            float f4 = com.corrodinggames.rts.gameFramework.GameUtils.a(a2.g, a2.h, f2, f3);
            BaseUnit am2 = BaseUnit.a(a2.d);
            float f5 = am2.cj + 1.0f;
            if (f5 < 20.0f) {
                f5 = 20.0f;
            }
            if (!(f4 < f5 * f5))
                continue;
            return a2;
        }
        return null;
    }

    public boolean b() {
        if (this.n) {
            if (this.o == null || this.o.bV) {
                return false;
            }
            if (!UnitTypeEnum.a(this.d, this.g, this.h, 0.0f, 0.0f, this.e)) {
                return false;
            }
        } else {
            if (this.v == null) {
                return false;
            }
            if (this.v.cf()) {
                return false;
            }
        }
        return true;
    }

    public void c(float f2) {
        this.a += 1.0f;
        this.b += f2;
        boolean bl2 = false;
        this.s = com.corrodinggames.rts.gameFramework.GameUtils.a(this.s, this.t * f2);
        if (this.n) {
            if (this.a > 6.0f) {
                this.a = 0.0f;
                boolean bl3 = this.o.a(this.d, this.g, this.h);
                if (!this.p && bl3) {
                    this.p = true;
                }
                if (!bl3) {
                    if (this.p) {
                        bl2 = true;
                    } else if (this.b > 180.0f) {
                        bl2 = true;
                    }
                }
                if (!this.b()) {
                    bl2 = true;
                }
            }
        } else if (this.a > 2.0f && !this.b()) {
            bl2 = true;
        }
        if (bl2) {
            this.c = true;
            w.b(this);
        }
    }

    public void d(float f2) {
            try {
        Rect rect;
        BaseUnit am2;
        GameEngine l2 = GameEngine.getInstance();
        if (l2.bs != this.j) {
            return;
        }
        if (!l2.cO.b(this.g, this.h)) {
            return;
        }
        if (this.q && !this.p) {
            return;
        }
        float f3 = 0.0f;
        float f4 = this.g;
        float f5 = this.h;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 1.0f;
        float f9 = 500.0f;
        boolean bl2 = false;
        boolean bl3 = false;
        if (this.n) {
            bl3 = true;
        } else {
            bl2 = true;
        }
        boolean bl4 = true;
        if (this.i) {
            bl4 = false;
        }
        if (bl3) {
            f3 = this.s;
            f3 = f3 <= 0.0f ? 0.0f
                    : (this.s < 1.0f ? 1.0f - com.corrodinggames.rts.gameFramework.GameUtils.k(f3 * 90.0f) : 1.0f);
        }
        if (bl3 && this.s < 1.0f && (am2 = BaseUnit.c(this.d)) != null && am2.bI() && (rect = am2.cd()) != null) {
            E.a(rect);
            com.corrodinggames.rts.gameFramework.effect.a.E.b *= (float) l2.bL.o;
            com.corrodinggames.rts.gameFramework.effect.a.E.d *= (float) l2.bL.o;
            com.corrodinggames.rts.gameFramework.effect.a.E.left *= (float) l2.bL.n;
            com.corrodinggames.rts.gameFramework.effect.a.E.c *= (float) l2.bL.n;
            float f10 = (float) (l2.bL.p - 3) + f3 * 5.0f;
            E.a(-(am2.cZ() - (float) l2.bL.p), -(am2.da() - (float) l2.bL.q));
            com.corrodinggames.rts.gameFramework.GameUtils.a(E, f10);
            float f11 = this.g - l2.cw;
            float f12 = this.h - l2.cx - f7;
            E.a(f11, f12);
            float f13 = 3.0f + f3 * 7.0f;
            Paint paint = C;
            if (this.s <= 0.0f) {
                paint = D;
            }
            l2.bO.a(com.corrodinggames.rts.gameFramework.effect.a.E.left - f13,
                    com.corrodinggames.rts.gameFramework.effect.a.E.b,
                    com.corrodinggames.rts.gameFramework.effect.a.E.c + f13,
                    com.corrodinggames.rts.gameFramework.effect.a.E.b, paint);
            l2.bO.a(com.corrodinggames.rts.gameFramework.effect.a.E.left - f13,
                    com.corrodinggames.rts.gameFramework.effect.a.E.d,
                    com.corrodinggames.rts.gameFramework.effect.a.E.c + f13,
                    com.corrodinggames.rts.gameFramework.effect.a.E.d, paint);
                l2.bO.a(com.corrodinggames.rts.gameFramework.effect.a.E.left,
                        com.corrodinggames.rts.gameFramework.effect.a.E.b - f13,
                        com.corrodinggames.rts.gameFramework.effect.a.E.left,
                        com.corrodinggames.rts.gameFramework.effect.a.E.d + f13, paint);
            l2.bO.a(com.corrodinggames.rts.gameFramework.effect.a.E.c,
                    com.corrodinggames.rts.gameFramework.effect.a.E.b - f13,
                    com.corrodinggames.rts.gameFramework.effect.a.E.c,
                    com.corrodinggames.rts.gameFramework.effect.a.E.d + f13, paint);
        }
        float f14 = 0.0f;
        if (bl3) {
            f14 -= 10.0f * f3;
        }
        UnitTypeEnum.a(this.d, f4, f5 + f14, f6, f7, this.e, f8, f9, bl2, bl3, this.f, bl4, null);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    static {
        E = new RectF();
        C = new ag();
        C.a(90, 0, 0, 255);
        C.a(Paint$Style.b);
        C.a(2.0f);
        D = new ag();
        D.a(40, 0, 0, 255);
        D.a(Paint$Style.b);
        D.a(2.0f);
    }
}
