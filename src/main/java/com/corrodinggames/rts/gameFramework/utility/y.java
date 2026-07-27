/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.game.b.MapTile;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.b.AirUnit;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.k.i;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.aa;
import com.corrodinggames.rts.gameFramework.utility.Vector3D;
import com.corrodinggames.rts.gameFramework.utility.z;

import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class y {
    static final Paint a = new Paint();
    static final RectF b = new RectF();
    static ArrayList<aa> c = new ArrayList<aa>();
    static final Rect d;
    static final RectF e;
    static Paint f;
    static z[] g;
    static boolean h;

    public static void a(BaseUnit am2, float f2) {
        y.a(am2, f2, false, false);
    }

    public static void a(BaseUnit am2, float f2, boolean bl2) {
        y.a(am2, f2, bl2, false);
    }

    public static boolean a(BaseUnit am2) {
        GameEngine l2 = GameEngine.getInstance();
        return am2.cG && l2.bS.q() == 1 && !l2.bS.g.e;
    }

    public static void a(BaseUnit am2, float f2, boolean bl2, boolean bl3) {
        GameEngine l2 = GameEngine.getInstance();
        if (y.a(am2) || bl2) {
            float f3 = am2.posX - l2.cw;
            float f4 = am2.posY - l2.cx;
            Paint paint = BaseUnit.dg;
            if (bl3) {
                paint = BaseUnit.dh;
            }
            try {
                l2.bO.a(f3, f4, f2, paint);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void a(BaseUnit am2, float f2, int n2, int n3, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        if (am2.cG && l2.bS.q() < 10 || bl2) {
            float f3 = am2.posX - l2.cw;
            float f4 = am2.posY - l2.cx;
            Paint paint = BaseUnit.dk;
            paint.b(n2);
            paint.a((float)n3);
            try {
                l2.bO.a(f3, f4, f2, paint);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void b(BaseUnit am2, float f2, boolean bl2) {
        y.a(am2, f2, bl2, BaseUnit.di);
    }

    public static void a(BaseUnit am2, float f2, boolean bl2, Paint paint) {
        GameEngine l2 = GameEngine.getInstance();
        if (y.a(am2) || bl2) {
            float f3 = am2.posX - l2.cw;
            float f4 = am2.posY - l2.cx;
            try {
                l2.bO.a(f3, f4, f2, paint);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void a(Texture_M e2, float f2, float f3, float f4, float f5, float f6, Paint paint, int n2, int n3, int n4) {
        GameEngine l2 = GameEngine.getInstance();
        int n5 = 0;
        int n6 = 0;
        d.a(n5 += n4 * n2, n6, n5 + n2, n6 + n3);
        float f7 = f6 * 0.5f;
        float f8 = (float)n2 * f7;
        float f9 = (float)n3 * f7;
        e.a(f2 - f8, (f3 -= f4) - f9, f2 + f8, f3 + f9);
        com.corrodinggames.rts.gameFramework.m.y y2 = l2.bO;
        y2.k();
        y2.a(f5 + 90.0f, f2, f3);
        if (f6 != 1.0f) {
            y2.a(f6, f6, f2, f3);
        }
        try {
            y2.a(e2, d, e, paint);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        y2.l();
    }

    public static boolean a(BaseUnit am2, boolean bl2, boolean bl3) {
        if (am2.cr() && bl3) {
            return false;
        }
        if (bl2 && (am2 instanceof AirUnit || am2 instanceof com.corrodinggames.rts.game.units.h.f)) {
            return false;
        }
        if (am2.bI()) {
            return false;
        }
        if (bl2 && (am2.cv() || am2.ct())) {
            return false;
        }
        if (am2.P()) {
            return false;
        }
        return am2.cN == null && am2.cO == null;
    }

    public static Paint a() {
        ag ag2 = new ag();
        GameEngine l2 = GameEngine.getInstance();
        if (l2.bQ.renderAntiAlias) {
            ((Paint)ag2).a(true);
            ag2.d(true);
            ag2.b(true);
        } else {
            ((Paint)ag2).a(false);
            ag2.d(false);
            ag2.b(false);
        }
        return ag2;
    }

    public static ag b() {
        ag ag2 = new ag();
        ag2.a(false);
        ag2.d(false);
        ag2.b(false);
        return ag2;
    }

    public static void a(com.corrodinggames.rts.game.units.y y2) {
        if (!y2.bV) {
            int n2 = y2.bl();
            for (int i2 = 0; i2 < n2; ++i2) {
                y.a(y2, i2);
            }
        }
    }

    public static void a(com.corrodinggames.rts.game.units.y y2, Texture_M e2, float f2, int n2) {
        if (!y2.bV && f2 != 0.0f) {
            GameEngine l2 = GameEngine.getInstance();
            Vector3D ai2 = y2.D(n2);
            l2.bO.k();
            l2.bO.b(ai2.a - l2.cw, ai2.b - ai2.c - y2.posZ - l2.cx);
            l2.bO.a(f2, f2);
            try {
                l2.bO.a(e2, 0.0f, 0.0f, null);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            l2.bO.l();
        }
    }

    public static void a(com.corrodinggames.rts.game.units.y y2, int n2) {
        Texture_M e2 = y2.d(n2);
        if (e2 == null) {
            return;
        }
        float f2 = y2.p(n2);
        Paint paint = y2.aN();
        GameEngine l2 = GameEngine.getInstance();
        Vector3D ai2 = y2.F(n2);
        float f3 = ai2.a - GameEngine.getInstance().cw;
        float f4 = ai2.b - GameEngine.getInstance().cx - y2.posZ - ai2.c;
        com.corrodinggames.rts.gameFramework.m.y y3 = l2.bO;
        y3.k();
        if (f2 != 1.0f) {
            y3.a(f2, f2, f3, f4);
        }
        y3.a(y2.cL[n2].targetX + 90.0f, f3, f4);
        try {
            y3.b(e2, f3 - e2.t - y2.h(n2), f4 - e2.u - y2.i(n2), paint);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        y3.l();
    }

    public static boolean a(BaseUnit am2, float f2, float f3) {
        return !y.a(f2, f3, am2.h());
    }

    public static boolean a(float f2, float f3, UnitMovementType ao2) {
        com.corrodinggames.rts.gameFramework.k.l l2 = GameEngine.getInstance().bU;
        com.corrodinggames.rts.game.b.TileMap b2 = GameEngine.getInstance().bL;
        b2.a(f2, f3);
        int n2 = b2.T;
        int n3 = b2.U;
        return l2.a(ao2, n2, n3);
    }

    public static short b(float f2, float f3, UnitMovementType ao2) {
        com.corrodinggames.rts.gameFramework.k.l l2 = GameEngine.getInstance().bU;
        com.corrodinggames.rts.game.b.TileMap b2 = GameEngine.getInstance().bL;
        i i2 = l2.a(ao2);
        if (i2.g == null) {
            return -3;
        }
        b2.a(f2, f3);
        int n2 = b2.T;
        int n3 = b2.U;
        if (!b2.c(n2, n3)) {
            return -2;
        }
        short s2 = i2.g[n2 * i2.c + n3];
        return s2;
    }

    public static int c(float f2, float f3, UnitMovementType ao2) {
        short s2 = y.b(f2, f3, ao2);
        if (s2 == -3 || s2 == -2 || s2 == -1 || s2 == 0) {
            return 0;
        }
        com.corrodinggames.rts.gameFramework.k.l l2 = GameEngine.getInstance().bU;
        i i2 = l2.a(ao2);
        Integer n2 = (Integer)i2.h.get(s2);
        if (n2 == null) {
            GameEngine.b("Could not find groupSize for:" + s2 + " at X:" + f2 + " y:" + f3);
            return 0;
        }
        return n2;
    }

    public static boolean a(float f2, float f3) {
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.game.b.TileMap b2 = l2.bL;
        if (b2 == null) {
            GameEngine.log("isInMap called without map loaded");
            return false;
        }
        int n2 = (int)(f2 * b2.r);
        int n3 = (int)(f3 * b2.s);
        return b2.c(n2, n3);
    }

    public static boolean b(float f2, float f3) {
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.game.b.TileMap b2 = l2.bL;
        if (b2 == null) {
            GameEngine.log("isOverClift called without map loaded");
            return false;
        }
        int n2 = (int)(f2 * b2.r);
        int n3 = (int)(f3 * b2.s);
        return l2.bU.b(n2, n3);
    }

    public static boolean c(float f2, float f3) {
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.game.b.TileMap b2 = l2.bL;
        if (b2 == null) {
            GameEngine.log("isOverWater called without map loaded");
            return false;
        }
        int n2 = (int)(f2 * b2.r);
        int n3 = (int)(f3 * b2.s);
        return l2.bU.a(n2, n3);
    }

    public static boolean d(float f2, float f3) {
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.game.b.TileMap b2 = l2.bL;
        if (b2 == null) {
            GameEngine.log("isOverLiquid called without map loaded");
            return false;
        }
        MapTile g2 = b2.c(f2, f3);
        if (g2 == null) {
            return false;
        }
        if (g2.e || g2.g) {
            return true;
        }
        int n2 = (int)(f2 * b2.r);
        int n3 = (int)(f3 * b2.s);
        return l2.bU.a(n2, n3);
    }

    public static final Paint a(int n2, int n3, int n4, int n5, Paint$Style paint$Style) {
        return y.a(com.corrodinggames.rts.gameFramework.GameUtils.b(n2, n3, n4, n5), paint$Style);
    }

    public static final Paint a(int n2, Paint$Style paint$Style) {
        for (int i2 = 0; i2 < g.length; ++i2) {
            z z2;
            if (g[i2] == null) {
                y.g[i2] = z2 = new z(n2, paint$Style);
                return z2.c;
            }
            z2 = g[i2];
            if (z2.a != n2 || z2.b != paint$Style) continue;
            return z2.c;
        }
        if (!h) {
            h = true;
            GameEngine.b("----- getCachingPaint --- Paint fallback was needed!!");
        }
        f.b(n2);
        f.a(paint$Style);
        return f;
    }

    public static void a(float f2) {
        if (c.size() == 0) {
            return;
        }
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            aa aa2 = (aa)iterator.next();
            if (aa2.e <= 0.0f) {
                iterator.remove();
                continue;
            }
            aa2.e -= f2;
            if (f2 != 0.0f || !(aa2.e < 1.0f)) continue;
            aa2.e = -1.0f;
        }
    }

    public static void b(float f2) {
        if (c.size() == 0) {
            return;
        }
        GameEngine l2 = GameEngine.getInstance();
        for (aa aa2 : c) {
            float f3 = aa2.b.left;
            float f4 = aa2.b.b;
            float f5 = aa2.b.c;
            float f6 = aa2.b.d;
            if (aa2.d) {
                f3 -= GameEngine.getInstance().cw;
                f4 -= GameEngine.getInstance().cx;
                f5 -= GameEngine.getInstance().cw;
                f6 -= GameEngine.getInstance().cx;
            }
            if (aa2.c) {
                try {
                    l2.bO.a(f3, f4, f5, f6, aa2.a);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                if (aa2.d) {
                    // empty if block
                }
                try {
                    l2.bO.a(aa2.b, aa2.a);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (aa2.f == null) continue;
            l2.bO.i();
            l2.S();
            float f7 = f5;
            float f8 = f6;
            if (aa2.d) {
                f7 *= l2.cX;
                f8 *= l2.cX;
            }
            try {
                l2.bO.a(aa2.f, f7, f8, aa2.a);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            l2.bO.j();
        }
    }

    public static final boolean a(int n2, int n3) {
        int n4 = GameEngine.getInstance().by;
        if (n2 + n3 < n4) {
            return true;
        }
        return n4 < n2 - 1000;
    }

    public static final boolean b(int n2, int n3) {
        int n4 = GameEngine.getInstance().by;
        if (n2 < 0) {
            return false;
        }
        return n2 + n3 >= n4 && n2 <= n4;
    }

    public static boolean a(float f2, float f3, float f4, float f5, UnitMovementType ao2) {
        if (ao2 == UnitMovementType.AIR || ao2 == UnitMovementType.NONE) {
            return true;
        }
        short s2 = y.b(f2, f3, ao2);
        short s3 = y.b(f4, f5, ao2);
        if (s2 == -3 || s3 == -3) {
            String string2 = "null";
            if (ao2 != null) {
                string2 = ao2.name();
            }
            GameEngine.g("pathPossible: no isolatedGroups found! (" + string2 + ")");
        }
        if (s2 == -1 || s3 == -1) {
            return false;
        }
        if (s2 == -2) {
            return false;
        }
        if (s3 == -2) {
            return false;
        }
        return s2 == s3;
    }

    public static boolean b(BaseUnit am2, float f2, float f3) {
        return y.a(am2.posX, am2.posY, f2, f3, am2.h());
    }

    public static void a(PlayerTeam n2, PointF pointF) {
        GameEngine l2 = GameEngine.getInstance();
        for (int i2 = 0; i2 <= 2; ++i2) {
            for (BaseUnit am2 : ((List<BaseUnit>)BaseUnit.bF()) ){
                if (!(am2 instanceof BaseUnit)) continue;
                BaseUnit am3 = am2;
                if (am3.bV || am3.bX != n2) continue;
                if (i2 == 0 && am3.bO) {
                    pointF.a(am3.posX, am3.posY);
                    return;
                }
                if (i2 == 1 && am3.bP) {
                    pointF.a(am3.posX, am3.posY);
                    return;
                }
                if (i2 != 2) continue;
                pointF.a(am3.posX, am3.posY);
                return;
            }
        }
        pointF.a(l2.bL.i() / 2.0f, l2.bL.j() / 2.0f);
    }

    public static void a(BaseUnit am2, com.corrodinggames.rts.game.units.y y2) {
        am2.cN = null;
        com.corrodinggames.rts.game.units.custom.b.n n2 = null;
        if (am2 instanceof com.corrodinggames.rts.game.units.y) {
            com.corrodinggames.rts.game.units.y y3 = (com.corrodinggames.rts.game.units.y)am2;
            if (y3.cO == y2) {
                n2 = y3.dn();
                if (n2 == null) {
                    GameEngine.log("Unload, attachment data is null");
                }
                y3.bx();
            }
        }
    }

    static {
        a.a(205, 255, 0, 0);
        a.a(Paint$Style.b);
        d = new Rect();
        e = new RectF();
        f = new Paint();
        g = new z[30];
        h = false;
    }
}

