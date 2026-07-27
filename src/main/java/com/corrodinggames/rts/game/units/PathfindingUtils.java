/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.k.i;
import com.corrodinggames.rts.gameFramework.k.l;

import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;

public final class PathfindingUtils {
    public static final Paint a = new Paint();
    static final Point b = new Point();
    static final Rect c = new Rect();
    static final PointF d = new PointF();
    static final PointF e = new PointF();
    static final PointF f = new PointF();
    static final PointF g = new PointF();
    static final PointF h = new PointF();
    static final PointF i = new PointF();
    static final PointF j = new PointF();

    private static Point findPathObstacle(UnitMovementType ao2, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        l l3 = l2.bU;
        i i2 = l3.a(ao2);
        int n9 = com.corrodinggames.rts.gameFramework.GameUtils.d(n4 - n2);
        int n10 = com.corrodinggames.rts.gameFramework.GameUtils.d(n5 - n3);
        int n11 = n2;
        int n12 = n3;
        int n13 = 1 + n9 + n10;
        int n14 = n4 > n2 ? 1 : -1;
        int n15 = n5 > n3 ? 1 : -1;
        int n16 = n9 - n10;
        n9 *= 2;
        n10 *= 2;
        int n17 = 0;
        while (n13 > 0) {
            int n18;
            int n19 = n11;
            int n20 = n12;
            if (n7 != 0 && (n18 = l3.c(i2, n19, n20)) < n7) {
                b.a(n19, n20);
                return b;
            }
            if (n6 != 0) {
                n18 = l3.b(i2, n19, n20);
                if (n18 == -1) {
                    b.a(n19, n20);
                    return b;
                }
                if (n8 > 0) {
                    --n8;
                } else {
                    n17 += n18;
                }
                if (n17 >= n6) {
                    b.a(n19, n20);
                    return b;
                }
            } else if (l3.a(i2, n19, n20)) {
                b.a(n19, n20);
                return b;
            }
            if (n16 > 0) {
                n11 += n14;
                n16 -= n10;
            } else if (n16 < 0) {
                n12 += n15;
                n16 += n9;
            } else if (n16 == 0) {
                n11 += n14;
                n12 += n15;
                n16 -= n10;
                n16 += n9;
                --n13;
            }
            --n13;
        }
        return null;
    }

    public static boolean a(UnitMovementType ao2, float f2, float f3, float f4, float f5, int n2, int n3, int n4) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        boolean bl2 = true;
        i i2 = l2.bU.a(ao2);
        l2.bU.a(i2, true);
        return PathfindingUtils.canReachTarget(ao2, f2, f3, f4, f5, n2, n3, n4);
    }

    public static boolean canReachTarget(UnitMovementType ao2, float f2, float f3, float f4, float f5, int n2, int n3, int n4) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        TileMap b2 = l2.bL;
        b2.a(f2, f3);
        int n5 = b2.T;
        int n6 = b2.U;
        b2.a(f4, f5);
        int n7 = b2.T;
        int n8 = b2.U;
        Point point = PathfindingUtils.findPathObstacle(ao2, n5, n6, n7, n8, n2, n3, n4);
        return point == null;
    }

    public static PointF a(UnitMovementType ao2, float f2, float f3, float f4, float f5, int n2, int n3, boolean bl2) {
        boolean bl3;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        l l3 = l2.bU;
        c.a(n2, n3, n2 + 1, n3 + 1);
        d.a(f2, f3);
        e.a(f4, f5);
        f.a(e);
        int n4 = -1;
        g.a(PathfindingUtils.c.left, PathfindingUtils.c.d);
        h.a(PathfindingUtils.c.c, PathfindingUtils.c.top);
        i.a(PathfindingUtils.c.left, PathfindingUtils.c.top);
        j.a(PathfindingUtils.c.c, PathfindingUtils.c.d);
        if (PathfindingUtils.d.b < PathfindingUtils.e.b) {
            boolean bl4 = bl3 = bl2 || !l3.a(ao2, n2, n3 - 1);
            if (bl3 && com.corrodinggames.rts.gameFramework.GameUtils.a(d, e, i, h)) {
                n4 = 3;
            }
        } else {
            boolean bl5 = bl3 = bl2 || !l3.a(ao2, n2, n3 + 1);
            if (bl3 && com.corrodinggames.rts.gameFramework.GameUtils.a(d, e, g, j)) {
                n4 = 1;
            }
        }
        if (PathfindingUtils.d.x < PathfindingUtils.e.x) {
            boolean bl6 = bl3 = bl2 || !l3.a(ao2, n2 - 1, n3);
            if (bl3 && com.corrodinggames.rts.gameFramework.GameUtils.a(d, e, i, g)) {
                n4 = 2;
            }
        } else {
            boolean bl7 = bl3 = bl2 || !l3.a(ao2, n2 + 1, n3);
            if (bl3 && com.corrodinggames.rts.gameFramework.GameUtils.a(d, e, h, j)) {
                n4 = 0;
            }
        }
        if (n4 == -1) {
            return null;
        }
        if (n4 == 0) {
            PathfindingUtils.f.x = (float)(n2 + 1) + 0.01f;
        }
        if (n4 == 2) {
            PathfindingUtils.f.x = (float)n2 - 0.01f;
        }
        if (n4 == 1) {
            PathfindingUtils.f.b = (float)(n3 + 1) + 0.01f;
        }
        if (n4 == 3) {
            PathfindingUtils.f.b = (float)n3 - 0.01f;
        }
        return f;
    }

    public static boolean a(y y2, BaseUnit am2) {
        if (am2.cN != null) {
            return false;
        }
        if (!y2.k(am2)) {
            return false;
        }
        return am2.d((BaseUnit)y2);
    }

    public static boolean b(y y2, BaseUnit am2) {
        if (!PathfindingUtils.a(y2, am2)) {
            return false;
        }
        if (!y2.h(am2)) {
            return false;
        }
        return y2.i(am2);
    }
}

