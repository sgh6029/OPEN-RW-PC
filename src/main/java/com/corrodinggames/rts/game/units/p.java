/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.b.MapLayer;
import com.corrodinggames.rts.game.b.MapLoadException;
import com.corrodinggames.rts.game.b.MapTile;
import com.corrodinggames.rts.game.units.r;
import com.corrodinggames.rts.game.units.s;
import com.corrodinggames.rts.gameFramework.GameEngine;

import android.graphics.Point;
import android.graphics.PointF;

import java.util.ArrayList;

public class p {
    static s[] a;
    static int b;
    static int c;
    static MapTile d;

    public static void a(r r2, PointF pointF) {
        MapTile g2;
        float f2 = pointF.x;
        float f3 = pointF.b;
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        if (b2 == null) {
            GameEngine.log("setTerrainType called without map loaded");
            return;
        }
        int n2 = (int)(f2 * b2.r);
        int n3 = (int)(f3 * b2.s);
        if (!b2.c(n2, n3)) {
            GameEngine.log("setTerrainType out of map range");
            return;
        }
        if (b2.u == null) {
            GameEngine.log("setTerrainType mainLayer missing");
            return;
        }
        if (!b2.R) {
            if (b2.S) {
                return;
            }
            // try {
                if (b2.v == null) {
                    b2.v = new MapLayer(b2, "grounddetails", b2.C, b2.D);
                    b2.z.add(b2.v);
                }
                if (b2.w == null) {
                    b2.w = new MapLayer(b2, "grounddetails2", b2.C, b2.D);
                    b2.z.add(b2.w);
                }
                b2.u.w = true;
                b2.v.w = true;
                b2.w.w = true;
            // }
            // catch (f f4) {
            //     f4.printStackTrace();
            //     l2.c("Failed to edit map", f4.getMessage());
            //     b2.S = true;
            //     return;
            // }
        }
        String string2 = r2.b();
        try {
            g2 = b2.a(string2, 0, 0);
        }
        catch (MapLoadException f5) {
            f5.printStackTrace();
            return;
        }
        if (g2 == null) {
            GameEngine.log("setTerrainType mapTile==null");
            return;
        }
        MapTile g3 = b2.u.a(n2, n3);
        if (b == n2 && c == n3 && MapTile.a(d, g2)) {
            return;
        }
        GameEngine.log("setTerrainType changing " + g3.b + " to " + g2.b + " at:" + n3 + "," + n3);
        b2.u.a(n2, n3, g2, false);
        b2.v.a(n2, n3, null, false);
        b2.w.a(n2, n3, null, false);
        b = n2;
        c = n3;
        d = g2;
        ArrayList<Point> arrayList = new ArrayList<Point>();
        arrayList.add(new Point(n2, n3));
        for (int i2 = 0; i2 <= 4; ++i2) {
            ArrayList arrayList2 = new ArrayList();
            for (Point point : arrayList) {
                p.a(r2, g2, point.x, point.b, arrayList2);
            }
            arrayList = arrayList2;
        }
        b2.g();
        l2.bU.a(b2, false);
    }

    public static void a(r r2, MapTile g2, int n2, int n3, ArrayList arrayList) {
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        for (int i2 = -1; i2 <= 1; ++i2) {
            for (int i3 = -1; i3 <= 1; ++i3) {
                boolean bl2;
                String string2;
                int n4 = n2 + i2;
                int n5 = n3 + i3;
                if (!b2.c(n4, n5) || i2 == 0 && i3 == 0 || (string2 = r2.a()) == null || !(bl2 = p.a(r2, g2, n4, n5, i2, i3, string2))) continue;
                arrayList.add(new Point(n4, n5));
            }
        }
    }

    public static void a(int[] nArray, s s2) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = nArray[i2] + 128;
            p.a[n2] = s2;
        }
    }

    public static void a() {
        a = new s[256];
        int n2 = 1;
        int n3 = 2;
        int n4 = 4;
        int n5 = 8;
        int n6 = 16;
        int n7 = 32;
        int n8 = 64;
        int n9 = -128;
        int n10 = -1;
        p.a(p.a(n2), new s(2, 2));
        p.a(p.a(n3), new s(0, 2));
        p.a(p.a(n4), new s(0, 0));
        p.a(p.a(n5), new s(2, 0));
        p.a(p.a(n6, n2, n3), new s(1, 2));
        p.a(p.a(n7, n3, n4), new s(0, 1));
        p.a(p.a(n8, n5, n4), new s(1, 0));
        p.a(p.a(n9, n2, n5), new s(2, 1));
        p.a(p.a(n6 + n7, n3, n2, n4), new s(0, 6));
        p.a(p.a(n7 + n8, n4, n5, n3), new s(0, 4));
        p.a(p.a(n8 + n9, n5, n4, n2), new s(2, 4));
        p.a(p.a(n9 + n6, n2, n5, n3), new s(2, 6));
        p.a(p.a(n2 + n3), new s(1, 1));
        p.a(p.a(n3 + n4), new s(1, 1));
        p.a(p.a(n4 + n5), new s(1, 1));
        p.a(p.a(n5 + n2), new s(1, 1));
        p.a(p.a(n6 + n7 + n8, n2, n3, n4, n5), new s(1, 1));
        p.a(p.a(n7 + n8 + n9, n2, n3, n4, n5), new s(1, 1));
        p.a(p.a(n8 + n9 + n6, n2, n3, n4, n5), new s(1, 1));
        p.a(p.a(n9 + n6 + n7, n2, n3, n4, n5), new s(1, 1));
        p.a(p.a(n6 + n8, n2, n3, n5, n4), new s(1, 1));
        p.a(p.a(n9 + n7, n2, n3, n5, n4), new s(1, 1));
        p.a(p.a(n2 + n4), new s(1, 1));
        p.a(p.a(n3 + n5), new s(1, 1));
        p.a(p.a(n6 + n4, n3, n2), new s(1, 1));
        p.a(p.a(n8 + n3, n4, n5), new s(1, 1));
        p.a(p.a(n9 + n3, n2, n5), new s(1, 1));
        p.a(p.a(n7 + n2, n3, n4), new s(1, 1));
        p.a(p.a(n6 + n4 + n5, n3, n2), new s(1, 1));
        p.a(p.a(n8 + n3 + n2, n4, n5), new s(1, 1));
        p.a(p.a(n9 + n3 + n4, n2, n5), new s(1, 1));
        p.a(p.a(n7 + n2 + n5, n3, n4), new s(1, 1));
        p.a(p.a(n10), new s(1, 1));
    }

    private static int[] a(int n2) {
        return new int[]{n2};
    }

    private static int[] a(int n2, int ... nArray) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(n2);
        if (nArray.length == 1) {
            arrayList.add(n2 + nArray[0]);
        } else if (nArray.length == 2) {
            arrayList.add(n2 + nArray[0]);
            arrayList.add(n2 + nArray[1]);
            arrayList.add(n2 + nArray[0] + nArray[1]);
        } else if (nArray.length == 3) {
            arrayList.add(n2 + nArray[0]);
            arrayList.add(n2 + nArray[1]);
            arrayList.add(n2 + nArray[2]);
            arrayList.add(n2 + nArray[0] + nArray[1]);
            arrayList.add(n2 + nArray[0] + nArray[2]);
            arrayList.add(n2 + nArray[1] + nArray[2]);
            arrayList.add(n2 + nArray[0] + nArray[1] + nArray[2]);
        } else if (nArray.length == 4) {
            arrayList.add(n2 + nArray[0]);
            arrayList.add(n2 + nArray[1]);
            arrayList.add(n2 + nArray[2]);
            arrayList.add(n2 + nArray[3]);
            arrayList.add(n2 + nArray[0] + nArray[1] + nArray[2] + nArray[3]);
            arrayList.add(n2 + nArray[0] + nArray[1] + nArray[2]);
            arrayList.add(n2 + nArray[0] + nArray[1] + nArray[3]);
            arrayList.add(n2 + nArray[1] + nArray[2] + nArray[3]);
            arrayList.add(n2 + nArray[0] + nArray[1]);
            arrayList.add(n2 + nArray[0] + nArray[2]);
            arrayList.add(n2 + nArray[0] + nArray[3]);
            arrayList.add(n2 + nArray[1] + nArray[2]);
            arrayList.add(n2 + nArray[1] + nArray[3]);
            arrayList.add(n2 + nArray[2] + nArray[3]);
        } else {
            throw new RuntimeException("unhandled:" + nArray.length);
        }
        int[] nArray2 = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            if (arrayList.get(i2) == null) continue;
            nArray2[i2] = (Integer)arrayList.get(i2);
        }
        return nArray2;
    }

    public static boolean a(r r2, MapTile g2, int n2, int n3, int n4, int n5, String string2) {
        MapTile g3;
        s s2;
        boolean bl2 = false;
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        byte by = p.b(r2, g2, n2, n3);
        if (a == null) {
            p.a();
        }
        if ((s2 = a[by + 128]) == null) {
            return false;
        }
        if (s2.a == 1 && s2.b == 1) {
            b2.u.a(n2, n3, g2, false);
            g3 = null;
            bl2 = true;
        } else {
            try {
                g3 = b2.a(string2, s2.a, s2.b);
            }
            catch (MapLoadException f2) {
                f2.printStackTrace();
                return false;
            }
        }
        p.a(r2, g2, g3, n2, n3);
        return bl2;
    }

    public static void a(r r2, MapTile g2, MapTile g3, int n2, int n3) {
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        MapTile g4 = b2.u.a(n2, n3);
        MapTile g5 = b2.v.a(n2, n3);
        MapTile g6 = b2.w.a(n2, n3);
        r r3 = p.a(g5);
        r r4 = p.a(g6);
        if (r3 == r2) {
            b2.v.a(n2, n3, null, false);
            g5 = null;
            r3 = null;
        }
        if (r4 == r2) {
            b2.w.a(n2, n3, null, false);
            g6 = null;
            r4 = null;
        }
        if (g5 == null && g6 != null) {
            b2.v.a(n2, n3, g6, false);
            b2.w.a(n2, n3, null, false);
            g5 = g6;
            g6 = null;
            r3 = r4;
            r4 = null;
        }
        if (MapTile.a(g4, g2)) {
            return;
        }
        if (g3 == null) {
            return;
        }
        if (g5 != null) {
            if (g6 != null) {
                b2.v.a(n2, n3, g6, false);
            }
            b2.w.a(n2, n3, g3, false);
        } else {
            b2.v.a(n2, n3, g3, false);
        }
    }

    public static r a(MapTile g2) {
        if (g2 == null) {
            return null;
        }
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        for (r r2 : r.values()) {
            String string2 = g2.a.a;
            if (string2 != null && string2.equals(r2.b())) {
                return r2;
            }
            if (string2 == null || !string2.equals(r2.a())) continue;
            return r2;
        }
        return null;
    }

    public static boolean a(r r2, MapTile g2, int n2, int n3) {
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        if (!b2.c(n2, n3)) {
            return false;
        }
        MapTile g3 = b2.u.a(n2, n3);
        return MapTile.a(g3, g2);
    }

    public static byte b(r r2, MapTile g2, int n2, int n3) {
        byte by = 0;
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        int n4 = b2.C;
        int n5 = b2.D;
        if (n2 >= 1) {
            if (p.a(r2, g2, n2 - 1, n3)) {
                by = (byte)(by - 128);
            }
            if (n3 >= 1 && p.a(r2, g2, n2 - 1, n3 - 1)) {
                by = (byte)(by + 1);
            }
            if (n3 < n5 - 1 && p.a(r2, g2, n2 - 1, n3 + 1)) {
                by = (byte)(by + 8);
            }
        }
        if (n3 >= 1) {
            if (p.a(r2, g2, n2, n3 - 1)) {
                by = (byte)(by + 16);
            }
            if (n2 < n4 - 1 && p.a(r2, g2, n2 + 1, n3 - 1)) {
                by = (byte)(by + 2);
            }
        }
        if (n2 < n4 - 1 && p.a(r2, g2, n2 + 1, n3)) {
            by = (byte)(by + 32);
        }
        if (n3 < n5 - 1) {
            if (p.a(r2, g2, n2, n3 + 1)) {
                by = (byte)(by + 64);
            }
            if (n2 < n4 - 1 && p.a(r2, g2, n2 + 1, n3 + 1)) {
                by = (byte)(by + 4);
            }
        }
        return by;
    }
}

