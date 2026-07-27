/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.graphics.PorterDuff$Mode
 *  android.os.Build$VERSION
 */
package com.corrodinggames.rts.game.b;

import android.content.res.AssetFileDescriptor;
import android.graphics.PorterDuff;
import android.os.Build;
import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;


import com.corrodinggames.rts.game.l;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.Tree;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.Serializable;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.utility.IFileLoader;
import com.corrodinggames.rts.gameFramework.utility.o;
import com.corrodinggames.rts.gameFramework.GGameObject;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public final class TileMap {
    static final boolean a = false;
    static final boolean b = false;
    static final boolean c = false;
    public static boolean d = false;
    static ReentrantLock e = new ReentrantLock();
    static boolean f;
    static Paint g;
    static Paint h;
    static Paint i;
    static Paint j;
    boolean[] k = new boolean[256];
    public static TileAtlasCache l;
    public static TileAtlasCache m;
    public int n = 20;
    public int o = 20;
    public int p;
    public int q;
    public float r;
    public float s;
    public ArrayList<Tileset> t = new ArrayList<Tileset>();
    public MapLayer u = null;
    public MapLayer v = null;
    public MapLayer w = null;
    public MapLayer x;
    public MapLayer y = null;
    public ArrayList z = new ArrayList();
    public ArrayList<Point> A = new ArrayList<Point>();
    private int as = 1;
    public MapTile[] B = new MapTile[0];
    public int C;
    public int D;
    public boolean E = true;
    public boolean F = false;
    public boolean G = false;
    public static boolean H;
    public static boolean I;
    public static boolean J;
    public static com.corrodinggames.rts.gameFramework.m.Texture_M K;
    public static com.corrodinggames.rts.gameFramework.m.y L;
    public byte[][] M;
    public byte[][] N;
    Rect O = new Rect();
    protected ArrayList P = new ArrayList();
    public MapObjectLayer Q;
    public boolean R;
    public boolean S;
    public int T;
    public int U;
    public PointF V = new PointF();
    public boolean W;
    public boolean X;
    public int Y;
    public int Z;
    float aa = 0.0f;
    Paint ab;
    Paint ac;
    Paint ad;
    Paint ae;
    Paint af;
    Paint ag;
    HashMap ah;
    float ai;
    float aj = 1.0f;
    int ak = 0;
    public static LayerBufferManager al;
    Paint am = new Paint();
    Rect an = new Rect();
    Rect ao = new Rect();
    long ap;
    float aq;
    float ar;

    public static void a() {
        if (f) {
            return;
        }
        e.lock();
    }

    public static void b() {
        if (f) {
            return;
        }
        e.unlock();
    }

    public static void c() throws IOException {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        g.a(150, 255, 255, 255);
        g.a(Paint$Style.b);
        g.a(1.0f);
        l2.a(g, 16.0f);
        h.a(150, 255, 0, 0);
        h.a(Paint$Style.b);
        h.a(1.0f);
        i.a(150, 0, 255, 0);
        i.a(Paint$Style.b);
        i.a(1.0f);
        j.a(150, 255, 0, 0);
        long l3 = PerformanceProfiler.a();
        com.corrodinggames.rts.gameFramework.m.Texture_M e2 = l2.bO.a(com.corrodinggames.rts.R.drawable.fog_smooth);
        int n2 = 20;
        int n3 = 20;
        int n4 = 1;
        K = l2.bO.b((n2 + 2) * 16 + 1, (n3 + 2) * 16 + 1, true);
        com.corrodinggames.rts.game.b.TileMap.K.m = true;
        K.b(true);
        L = l2.bO.b(K);
        com.corrodinggames.rts.gameFramework.m.Texture_M e3 = l2.bO.b(n2 + n4, n3 + n4, true);
        com.corrodinggames.rts.gameFramework.m.y y2 = l2.bO.b(e3);
        int n5 = 1;
        int n6 = 2;
        int n7 = 4;
        int n8 = 8;
        int n9 = 16;
        int n10 = 32;
        int n11 = 64;
        int n12 = -128;
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n5), 2, 5, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n6), 0, 5, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n7), 0, 3, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n8), 2, 3, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n9, new int[]{n5, n6}), 1, 0, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n10, new int[]{n6, n7}), 2, 1, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n11, new int[]{n8, n7}), 1, 2, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n12, new int[]{n5, n8}), 0, 1, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n9 + n10, new int[]{n6, n5, n7}), 2, 0, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n10 + n11, new int[]{n7, n8, n6}), 2, 2, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n11 + n12, new int[]{n8, n7, n5}), 0, 2, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n12 + n9, new int[]{n5, n8, n6}), 0, 0, true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n5 + n6), com.corrodinggames.rts.game.b.TileMap.a(new int[]{2, 5, 0, 5}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n6 + n7), com.corrodinggames.rts.game.b.TileMap.a(new int[]{0, 5, 0, 3}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n7 + n8), com.corrodinggames.rts.game.b.TileMap.a(new int[]{0, 3, 2, 3}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n8 + n5), com.corrodinggames.rts.game.b.TileMap.a(new int[]{2, 3, 2, 5}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n9 + n10 + n11, new int[]{n5, n6, n7, n8}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{2, 0, 2, 2}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n10 + n11 + n12, new int[]{n5, n6, n7, n8}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{2, 2, 0, 2}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n11 + n12 + n9, new int[]{n5, n6, n7, n8}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{0, 2, 0, 0}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n12 + n9 + n10, new int[]{n5, n6, n7, n8}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{0, 0, 2, 0}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n9 + n11), com.corrodinggames.rts.game.b.TileMap.a(new int[]{1, 0, 1, 2}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n12 + n10), com.corrodinggames.rts.game.b.TileMap.a(new int[]{0, 1, 2, 1}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n5 + n7), com.corrodinggames.rts.game.b.TileMap.a(new int[]{2, 5, 0, 3}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(n6 + n8), com.corrodinggames.rts.game.b.TileMap.a(new int[]{0, 5, 2, 3}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n9 + n7, new int[]{n6, n5}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{1, 0, 0, 3}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n11 + n6, new int[]{n7, n8}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{1, 2, 0, 5}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n12 + n6, new int[]{n5, n8}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{0, 1, 0, 5}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n10 + n5, new int[]{n6, n7}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{2, 1, 2, 5}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n9 + n8, new int[]{n6, n5}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{1, 0, 2, 3}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n11 + n5, new int[]{n7, n8}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{1, 2, 2, 5}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n12 + n7, new int[]{n5, n8}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{0, 1, 0, 3}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n10 + n8, new int[]{n6, n7}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{2, 1, 2, 3}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n9 + n7 + n8, new int[]{n6, n5}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{1, 0, 0, 3, 2, 3}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n11 + n6 + n5, new int[]{n7, n8}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{1, 2, 0, 5, 2, 5}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n12 + n6 + n7, new int[]{n5, n8}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{0, 1, 2, 5, 2, 3}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.a(n10 + n5 + n8, new int[]{n6, n7}), com.corrodinggames.rts.game.b.TileMap.a(new int[]{2, 1, 0, 5, 0, 3}), true, e3, y2, e2);
        com.corrodinggames.rts.game.b.TileMap.a(com.corrodinggames.rts.game.b.TileMap.b(-1), com.corrodinggames.rts.game.b.TileMap.a(new int[]{1, 4}), true, e3, y2, e2);
        L.p();
        L.q();
        L = null;
        y2.q();
        y2 = null;
        PerformanceProfiler.a("smoothFog load took:", l3);
        com.corrodinggames.rts.game.b.TileMap.d();
        l = new TileAtlasCache(1.0f, false);
        l.a();
        m = new TileAtlasCache(0.5f, false);
        m.a();
    }

    public static void d() {
        if (H) {
            return;
        }
        H = true;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        I = l2.bQ.softFogFading;
        if (com.corrodinggames.rts.gameFramework.GameEngine.at() && Build.VERSION.SDK_INT > 26) {
            long l3 = Runtime.getRuntime().maxMemory() / 0x100000L;
            com.corrodinggames.rts.gameFramework.GameEngine.log("MaxHeapSizeInMB:" + l3);
            if (l3 > 200L) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("enabling softFades");
                I = true;
            }
        }
    }

    private static int[] b(int n2) {
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

    private static int[] a(int ... nArray) {
        return nArray;
    }

    private static void a(int[] nArray, int n2, int n3, boolean bl2, com.corrodinggames.rts.gameFramework.m.Texture_M e2, com.corrodinggames.rts.gameFramework.m.y y2, com.corrodinggames.rts.gameFramework.m.Texture_M e3) throws IOException {
        com.corrodinggames.rts.game.b.TileMap.a(nArray, com.corrodinggames.rts.game.b.TileMap.a(new int[]{n2, n3}), bl2, e2, y2, e3);
    }

    private static void a(int[] nArray, int[] nArray2, boolean bl2, com.corrodinggames.rts.gameFramework.m.Texture_M e2, com.corrodinggames.rts.gameFramework.m.y y2, com.corrodinggames.rts.gameFramework.m.Texture_M e3) throws IOException {
        int n2;
        int n3;
        if (bl2) {
            y2.o();
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int n4 = 20;
        int n5 = 20;
        rect.a(0, 0, n4, n5);
        com.corrodinggames.rts.gameFramework.m.y y3 = y2;
        for (n3 = 0; n3 < nArray2.length; n3 += 2) {
            n2 = nArray2[n3 + 0] * 20;
            int n6 = nArray2[n3 + 1] * 20;
            rect2.a(n2, n6, n2 + n4, n6 + n5);
            y3.a(e3, rect2, rect, null);
            rect4.a(rect2.c - 1, rect2.top, rect2.c, rect2.d);
            rect3.a(rect.c, rect.top, rect.c + 1, rect.d);
            y3.a(e3, rect4, rect3, null);
            rect4.a(rect2.left, rect2.d - 1, rect2.c, rect2.d);
            rect3.a(rect.left, rect.d, rect.c, rect.d + 1);
            y3.a(e3, rect4, rect3, null);
        }
        y3.p();
        for (n3 = 0; n3 < nArray.length; ++n3) {
            n2 = nArray[n3] + 128;
            com.corrodinggames.rts.game.b.TileMap.a(n2, e2);
        }
    }

    public static void a(int n2, com.corrodinggames.rts.gameFramework.m.Texture_M e2) throws IOException {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        rect2.a(0, 0, 20, 20);
        com.corrodinggames.rts.game.b.TileMap.a(n2, rect);
        com.corrodinggames.rts.game.b.TileAtlasCache.a(L, e2, rect2, rect, null);
    }

    public static void a(int n2, Rect rect) {
        int n3 = 20;
        int n4 = 20;
        int n5 = n2 % 16;
        int n6 = (int)((float)n2 * 0.0625f);
        int n7 = n5 * (n3 + 2) + 1;
        int n8 = n6 * (n4 + 2) + 1;
        rect.left = n7;
        rect.top = n8;
        rect.c = n7 + n3;
        rect.d = n8 + n4;
    }

    public final short a(MapTile g2) {
        if (this.as >= this.B.length) {
            MapTile[] gArray = new MapTile[com.corrodinggames.rts.gameFramework.GameUtils.c(this.B.length + 100, Short.MAX_VALUE)];
            System.arraycopy(this.B, 0, gArray, 0, this.B.length);
            this.B = gArray;
        }
        int n2 = this.as;
        if (this.as < 32766) {
            ++this.as;
        } else {
            com.corrodinggames.rts.gameFramework.GameEngine.b("Max unique tile limit reached at: " + this.as);
        }
        this.B[n2] = g2;
        return (short)n2;
    }

    public final MapTile a(short s2) {
        return this.B[s2];
    }

    public MapTile a(MapTile g2, int n2, int n3) {
        if (g2 != null && g2.m != null) {
            int n4 = (n2 * 13 + n3 * 1313) % (g2.m.length + 1);
            if (--n4 >= 0) {
                return g2.m[n4];
            }
        }
        return g2;
    }

    public boolean a(float f2, float f3, PlayerTeam n2) {
        if (this.E) {
            int n3 = (int)(f2 * this.r);
            int n4 = (int)(f3 * this.s);
            if (n2.N != null && this.c(n3, n4) && n2.N[n3][n4] >= 5) {
                return false;
            }
        }
        return true;
    }

    public boolean a(int n2, int n3, PlayerTeam n4) {
        return !this.E || n4.N == null || !this.c(n2, n3) || n4.N[n2][n3] < 5;
    }

    public void a(float f2, float f3) {
        this.T = (int)(f2 * this.r);
        this.U = (int)(f3 * this.s);
    }

    public void a(int n2, int n3) {
        this.T = n2 * this.n;
        this.U = n3 * this.o;
    }

    public void b(int n2, int n3) {
        this.T = n2 * this.n + this.p;
        this.U = n3 * this.o + this.q;
    }

    public PointF a(Point point) {
        this.V.a(point.x * this.n, point.b * this.o);
        return this.V;
    }

    public void b(float f2, float f3) {
        this.a(f2, f3);
        this.a(this.T, this.U);
    }

    public float a(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.i()) {
            f2 = this.i();
        }
        return f2;
    }

    public float b(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.j()) {
            f2 = this.j();
        }
        return f2;
    }

    public final boolean c(int n2, int n3) {
        return n2 >= 0 && n2 < this.C && n3 >= 0 && n3 < this.D;
    }

    public MapTile c(float f2, float f3) {
        int n2 = (int)(f2 * this.r);
        int n3 = (int)(f3 * this.s);
        if (n2 < 0 || n2 >= this.C || n3 < 0 || n3 >= this.D) {
            return null;
        }
        return this.u.a(n2, n3);
    }

    public MapTile d(int n2, int n3) {
        if (!this.c(n2, n3)) {
            return null;
        }
        return this.u.a(n2, n3);
    }

    public MapTile e(int n2, int n3) {
        if (!this.c(n2, n3)) {
            return null;
        }
        if (this.y == null) {
            return null;
        }
        return this.y.a(n2, n3);
    }

    void a(RectF rectF) {
        if (com.corrodinggames.rts.gameFramework.GameEngine.C()) {
            rectF.left *= (float)(this.n / 20);
            rectF.c *= (float)(this.n / 20);
            rectF.b *= (float)(this.o / 20);
            rectF.d *= (float)(this.o / 20);
        }
    }

    public TileMap() {
        if (com.corrodinggames.rts.gameFramework.GameEngine.C()) {
            this.n = 60;
            this.o = 60;
        }
        this.p = this.n / 2;
        this.q = this.o / 2;
        this.r = 1.0f / (float)this.n;
        this.s = 1.0f / (float)this.o;
        this.ab = new ag();
        this.ab.a(100, 255, 0, 0);
        this.ab.b(16.0f);
        this.ac = new ag();
        this.ac.a(Paint$Style.b);
        this.ac.a(1.0f);
        this.ac.a(255, 0, 225, 0);
        this.ad = new ag();
        this.ad.a(Paint$Style.b);
        this.ad.a(1.0f);
        this.ad.a(100, 0, 185, 0);
        this.ae = new ag();
        this.ae.a(Paint$Style.b);
        this.ae.a(1.0f);
        this.ae.a(255, 175, 0, 0);
        this.af = new ag();
        this.af.a(155, 175, 0, 0);
        this.ag = new ag();
        this.ag.a(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public static void a(String string2, com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        InputStream inputStream = com.corrodinggames.rts.game.b.TileMap.b(string2);
        if (inputStream == null) {
            throw new IOException("writeMapStream: Could not find map:" + string2);
        }
        int n2 = (int)com.corrodinggames.rts.game.b.TileMap.a(string2);
        if (n2 == -1) {
            new IOException("writeMapStream: Failed to get map size");
        }
        if (n2 == 0) {
            new IOException("writeMapStream: Got empty map size");
        }
        com.corrodinggames.rts.gameFramework.GameEngine.log("Sending map stream of size: " + n2);
        as2.a(inputStream, n2);
    }

    public static long a(String string2) {
        String string3 = "" + string2;
        String string4 = com.corrodinggames.rts.gameFramework.storage.a.e(string3);
        IFileLoader af2 = com.corrodinggames.rts.gameFramework.utility.FileLoaderFactory.a(string4);
        if (af2 != null && !string4.endsWith(".rwmod")) {
            long l2 = af2.a(string4, false);
            if (l2 == -1L) {
                // empty if block
            }
            return l2;
        }
        if (com.corrodinggames.rts.gameFramework.storage.a.c(string3)) {
            AssetManager assetManager = com.corrodinggames.rts.gameFramework.GameEngine.getInstance().am.d();
            try {
                AssetFileDescriptor assetFileDescriptor = assetManager.b(string4);
                return assetFileDescriptor.getLength();
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
        File file = new File(string4);
        return file.length();
    }

    public static InputStream b(String string2) {
        InputStream inputStream;
        InputStream inputStream2 = com.corrodinggames.rts.game.b.TileMap.d(string2);
        if (inputStream2 == null && (inputStream = com.corrodinggames.rts.game.b.TileMap.d(string2.replace(".tmx", "") + "_moved")) != null) {
            String string3 = com.corrodinggames.rts.gameFramework.GameUtils.a(inputStream);
            string3 = string3.trim();
            com.corrodinggames.rts.gameFramework.GameEngine.log("Found moved map at:" + string3);
            inputStream2 = com.corrodinggames.rts.game.b.TileMap.d(string3);
        }
        return inputStream2;
    }

    public static String c(String string2) {
        if (string2 == null) {
            return null;
        }
        String string3 = com.corrodinggames.rts.gameFramework.storage.a.e(string2);
        return string3;
    }

    public static InputStream d(String string2) {
        String string3 = com.corrodinggames.rts.game.b.TileMap.c("" + string2);
        com.corrodinggames.rts.gameFramework.GameEngine.log("Mapfile: " + string3);
        com.corrodinggames.rts.gameFramework.utility.AssetInputStream j2 = com.corrodinggames.rts.gameFramework.storage.a.k(string3);
        return j2;
    }

    public void a(Document document, OutputStream outputStream) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty("indent", "yes");
        DOMSource dOMSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(outputStream);
        transformer.transform(dOMSource, streamResult);
    }

    public void a(InputStream inputStream, OutputStream outputStream) throws ParserConfigurationException, SAXException, IOException, MapLoadException, TransformerException {
        Object object;
        Object object2;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(false);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.setEntityResolver(new TileMap$1(this));
        Document document = documentBuilder.parse(inputStream);
        Element element = document.getDocumentElement();
        String string2 = element.getAttribute("orientation");
        if (!string2.equals("orthogonal")) {
            throw new MapLoadException("Only orthogonal maps are supported, found: " + string2);
        }
        NodeList nodeList = element.getElementsByTagName("SOMETHING");
        for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
            Element element2 = (Element)nodeList.item(i2);
        }
        NodeList nodeList2 = element.getElementsByTagName("layer");
        for (int i3 = 0; i3 < nodeList2.getLength(); ++i3) {
            Element element3 = (Element)nodeList2.item(i3);
            object2 = element3.getAttribute("name");
            if (!"units".equalsIgnoreCase((String)object2)) continue;
            element3.getParentNode().removeChild(element3);
        }
        NodeList nodeList3 = element.getElementsByTagName("objectgroup");
        for (int i4 = 0; i4 < nodeList3.getLength(); ++i4) {
            object2 = (Element)nodeList3.item(i4);
            object = ((Element)object2).getAttribute("name");
            if (!"UnitObjects".equalsIgnoreCase((String)object)) continue;
            ((Element)object2).getParentNode().removeChild((Node)object2);
        }
        Element element4 = document.createElement("objectgroup");
        element4.setAttribute("name", "UnitObjects");
        object2 = com.corrodinggames.rts.game.units.BaseUnit.bF();
        object = ((o)object2).iterator();
        while (((Iterator) object).hasNext()) {
            BaseUnit am2 = (BaseUnit)((Iterator) object).next();
            if (!(am2 instanceof BaseUnit) || am2 instanceof Tree && ((Tree)am2).bM) continue;
            BaseUnit am3 = am2;
            if (am3.bV || am3.u()) continue;
            com.corrodinggames.rts.game.units.custom.b.n n2 = am3.dn();
            if (am3.cO != null && n2 != null) {
                if (n2.D) continue;
                continue;
            }
            Element element5 = document.createElement("object");
            int n3 = 20;
            if ((float)n3 < am3.cj) {
                n3 = (int)am3.cj;
            }
            element5.setAttribute("name", am3.r().i() + " (t:" + am3.bX.k + ")");
            element5.setAttribute("x", "" + (am3.posX - (float)(n3 / 2)));
            element5.setAttribute("y", "" + (am3.posY - (float)(n3 / 2)));
            element5.setAttribute("width", "" + n3);
            element5.setAttribute("height", "" + n3);
            float f2 = am3.bI() ? am3.cg : am3.cg + 90.0f;
            element5.setAttribute("rotation", "" + f2);
            Integer n4 = this.a(am3.r());
            if (n4 != null) {
                element5.setAttribute("gid", "" + n4);
            }
            Element element6 = document.createElement("properties");
            Element element7 = document.createElement("property");
            element7.setAttribute("name", "unit");
            element7.setAttribute("value", am3.r().i());
            element6.appendChild(element7);
            element7 = document.createElement("property");
            element7.setAttribute("name", "team");
            element7.setAttribute("value", "" + am3.bX.k);
            element6.appendChild(element7);
            element5.appendChild(element6);
            element4.appendChild(element5);
        }
        element.appendChild(element4);
        this.a(document, outputStream);
    }

    public boolean a(String string2, String string3) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        try {
            this.b(string2, string3);
            l2.bS.h.a(null, "Map exported.");
            return true;
        }
        catch (MapLoadException f2) {
            l2.c("Error exporting map", "Failed to export map. error: " + f2.getMessage());
            return false;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            l2.c("Error exporting map", "Failed to export map. IO error: " + iOException.getMessage());
            return false;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            noClassDefFoundError.printStackTrace();
            l2.c("Error exporting map", "Failed to export map. Class not found: " + noClassDefFoundError.getMessage());
            return false;
        }
    }

    public void b(String string2, String string3) throws IOException, MapLoadException {
        OutputStream outputStream;
        com.corrodinggames.rts.gameFramework.GameEngine.log(" --- Saving map:" + string2 + " to: " + string3);
        InputStream inputStream = com.corrodinggames.rts.game.b.TileMap.b(string2);
        if (inputStream == null) {
            throw new IOException("Could not find orginal map: " + string2);
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        File file = new File(string3 = com.corrodinggames.rts.gameFramework.storage.a.e(string3)).getParentFile();
        if (!com.corrodinggames.rts.gameFramework.storage.a.i(file.getAbsolutePath())) {
            com.corrodinggames.rts.gameFramework.storage.a.l(file.getAbsolutePath());
        }
        if (!com.corrodinggames.rts.gameFramework.storage.a.f(file.getAbsolutePath())) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("Save Map: Could not create parent directory");
        }
        try {
            outputStream = com.corrodinggames.rts.gameFramework.storage.a.b(string3, false);
            if (outputStream == null) {
                throw new IOException("Failed to get save target:" + string3);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw new IOException("Failed to open save target:" + string3);
        }
        try {
            this.a((InputStream)bufferedInputStream, outputStream);
        }
        catch (ParserConfigurationException parserConfigurationException) {
            throw new IOException(parserConfigurationException);
        }
        catch (SAXException sAXException) {
            throw new IOException(sAXException);
        }
        catch (IOException iOException) {
            throw new IOException(iOException);
        }
        catch (TransformerException transformerException) {
            throw new IOException(transformerException);
        }
        try {
            outputStream.close();
            bufferedInputStream.close();
            inputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void a(String string2, boolean bl2) throws MapLoadException {
        com.corrodinggames.rts.gameFramework.GameEngine.log(" --- Loading map ---");
        InputStream inputStream = com.corrodinggames.rts.game.b.TileMap.b(string2);
        if (inputStream == null) {
            String string3 = com.corrodinggames.rts.game.b.TileMap.c(string2);
            throw new MapLoadException("Could not find map: " + com.corrodinggames.rts.gameFramework.storage.a.d(string3));
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        this.a((InputStream)bufferedInputStream, bl2);
        try {
            bufferedInputStream.close();
            inputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public Tileset e(String string2) throws MapLoadException {
        Tileset j2 = null;
        for (Tileset j3 : this.t) {
            if (!string2.equals(j3.a)) continue;
            j2 = j3;
        }
        if (j2 == null) {
            Tileset j3;
            int n2 = 1;
            if (this.t.size() > 0) {
                j3 = (Tileset)this.t.get(this.t.size() - 1);
                n2 = j3.l + 100;
                j3.c(n2);
            }
            j3 = new Tileset(this, string2, n2 + 1);
            this.t.add(j3);
            j2 = j3;
        }
        if (j2.b == null) {
            j2.c();
        }
        return j2;
    }

    public MapTile a(String string2, int n2, int n3) throws MapLoadException {
        Tileset j2 = this.e(string2);
        if (this.ah == null) {
            this.ah = new HashMap();
        }
        boolean bl2 = true;
        int n4 = j2.a(n2, n3);
        int n5 = j2.l + n4;
        MapTile g2 = (MapTile)this.ah.get(n5);
        if (g2 != null) {
            return g2;
        }
        MapTile g3 = com.corrodinggames.rts.game.b.MapTile.a(this, this.u, j2, n5 - j2.l, (short)0, (short)0, bl2);
        this.ah.put(n5, g3);
        return g3;
    }

   public void a(InputStream var1, boolean var2) throws MapLoadException {
      this.A.clear();
      l.b();
      m.b();

      String var7;
      try {
         com.corrodinggames.rts.gameFramework.GameEngine.log("---- Loading map data ----");
         DocumentBuilderFactory var3 = DocumentBuilderFactory.newInstance();
         var3.setValidating(false);
         DocumentBuilder var4 = var3.newDocumentBuilder();
         var4.setEntityResolver(new TileMap$2(this));
         Document var5 = var4.parse(var1);
         Element var6 = var5.getDocumentElement();
         var7 = var6.getAttribute("orientation");
         if (!var7.equals("orthogonal")) {
            throw new com.corrodinggames.rts.game.b.MapLoadException("Only orthogonal maps are supported, found: " + var7);
         }

         int var9 = Integer.parseInt(var6.getAttribute("width"));
         int var10 = Integer.parseInt(var6.getAttribute("height"));
         this.C = var9;
         this.D = var10;
         com.corrodinggames.rts.gameFramework.GameEngine.log("Map size: " + this.C + ", " + this.D);
         this.ar = 150.0F;
         int var11;
         PlayerTeam var12;
         int var13;
         if (!this.E) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("No team fog on this map..");

            for(var11 = 0; var11 < com.corrodinggames.rts.game.PlayerTeam.c; ++var11) {
               var12 = com.corrodinggames.rts.game.PlayerTeam.k(var11);
               if (var12 != null) {
                  var12.N = (byte[][])null;
               }
            }
         } else {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Setting up team fog..");

            for(var11 = 0; var11 < com.corrodinggames.rts.game.PlayerTeam.c; ++var11) {
               var12 = com.corrodinggames.rts.game.PlayerTeam.k(var11);
               if (var12 != null) {
                  var12.L = this.C;
                  var12.M = this.D;
                  var12.N = new byte[this.C][this.D];

                  for(var13 = 0; var13 < this.C; ++var13) {
                     for(int var14 = 0; var14 < this.D; ++var14) {
                        var12.N[var13][var14] = 10;
                     }
                  }
               }
            }
         }

         Element var35 = (Element)var6.getElementsByTagName("properties").item(0);
         if (var35 != null) {
            NodeList var36 = var35.getElementsByTagName("property");
            if (var36 != null) {
               Properties var8 = new Properties();

               for(var13 = 0; var13 < var36.getLength(); ++var13) {
                  Element var39 = (Element)var36.item(var13);
                  String var15 = var39.getAttribute("name");
                  String var16 = var39.getAttribute("value");
                  var8.setProperty(var15, var16);
               }
            }
         }

         com.corrodinggames.rts.game.b.Tileset var37 = null;
         NodeList var38 = var6.getElementsByTagName("tileset");

         for(short var40 = 0; var40 < var38.getLength(); ++var40) {
            Element var41 = (Element)var38.item(var40);
            com.corrodinggames.rts.game.b.Tileset var44 = new com.corrodinggames.rts.game.b.Tileset(this, var41);
            var44.n = var40;
            if (var37 != null) {
               var37.c(var44.l - 1);
            }

            var37 = var44;
            this.t.add(var44);
         }

         NodeList var42 = var6.getElementsByTagName("layer");

         MapLayer var18;
         int var43;
         for(var43 = 0; var43 < var42.getLength(); ++var43) {
            Element var46 = (Element)var42.item(var43);
            String var17 = var46.getAttribute("name");
            if (!"set".equalsIgnoreCase(var17) && !"set-disabled".equalsIgnoreCase(var17)) {
               var18 = new MapLayer(this, var46);
               var18.j = var43;
               this.z.add(var18);
            }
         }

         Iterator var45 = this.z.iterator();

         while(var45.hasNext()) {
            MapLayer var47 = (MapLayer)var45.next();
            if (var47.r) {
               this.u = var47;
            }

            if (var47.k.equalsIgnoreCase("grounddetails")) {
               this.v = var47;
            }

            if (var47.k.equalsIgnoreCase("grounddetails2")) {
               this.w = var47;
            }

            if (var47.k.equalsIgnoreCase("Items") || var47.k.equalsIgnoreCase("Objects")) {
               this.y = var47;
            }

            if (var47.k.equalsIgnoreCase("PathingOverride")) {
               this.x = var47;
            }
         }

         if (this.u == null) {
            throw new com.corrodinggames.rts.game.b.MapLoadException("'Ground' layer was not found in map, this layer is required");
         }

         if (this.B == null || this.B.length == 0) {
            throw new com.corrodinggames.rts.game.b.MapLoadException("Invalid map, no tiles have been set");
         }

         int var49;
         if (!com.corrodinggames.rts.gameFramework.GameEngine.C() && !com.corrodinggames.rts.gameFramework.GameEngine.D()) {
            for(var43 = 0; var43 < this.C; ++var43) {
               for(var49 = 0; var49 < this.D; ++var49) {
                  if (this.u.a(var43, var49) == null) {
                     throw new com.corrodinggames.rts.game.b.MapLoadException("An empty tile on the Ground layer at " + var43 + "," + var49 + " all tiles must be filled");
                  }
               }
            }
         }

         if (this.y == null) {
            throw new com.corrodinggames.rts.game.b.MapLoadException("'Items' layer was not found in map, this layer is required");
         }

         NodeList var48 = var6.getElementsByTagName("objectgroup");

         for(var49 = 0; var49 < var48.getLength(); ++var49) {
            Element var50 = (Element)var48.item(var49);
            MapObjectLayer var53 = new MapObjectLayer(var50, this);
            var53.a = var49;
            this.P.add(var53);
         }

         com.corrodinggames.rts.game.b.Tileset.a();
         Iterator var54 = this.t.iterator();

         while(var54.hasNext()) {
            com.corrodinggames.rts.game.b.Tileset var51 = (com.corrodinggames.rts.game.b.Tileset)var54.next();
            if (var51.q) {
               var51.c();
            }
         }

         com.corrodinggames.rts.game.b.Tileset.b();

         for(var49 = 0; var49 <= 1; ++var49) {
            Iterator var52 = this.z.iterator();

            while(var52.hasNext()) {
               var18 = (MapLayer)var52.next();
               boolean var19 = var18 == this.u;
               boolean var20 = var49 == 0;
               if (var19 == var20) {
                  var18.w = false;
                  if (var18.s) {
                     for(int var21 = 0; var21 < this.C; ++var21) {
                        for(int var22 = 0; var22 < this.D; ++var22) {
                           MapTile var23 = var18.a(var21, var22);
                           if (var23 != null && var23.c == -2) {
                              var23.c = l.a(var23.a, var23.b);
                              if (var23.c >= 0) {
                                 int var24 = m.a(var23.a, var23.b);
                                 if (var24 != var23.c) {
                                    throw new RuntimeException("Meta index mismatch: " + var24 + " vs " + var23.c);
                                 }
                              }

                              if (var23.c < 0) {
                                 var18.w = true;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         l.c();
         m.c();
         this.Q = this.f("triggers");
      } catch (IOException var26) {
         throw new com.corrodinggames.rts.game.b.MapLoadException("Failed to parse map", var26);
      } catch (ParserConfigurationException var27) {
         throw new RuntimeException("Failed to parse map", var27);
      } catch (SAXException var28) {
         com.corrodinggames.rts.gameFramework.GameEngine.log(" --- SAXException: Failed to parse map - " + var28.getMessage() + " ---");

         try {
            com.corrodinggames.rts.gameFramework.GameEngine.log("available:" + var1.available());
            var1.reset();
            com.corrodinggames.rts.gameFramework.GameEngine.log("after reset:" + var1.available());
         } catch (IOException var25) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("-- error writing debug info --");
            var25.printStackTrace();
         }

         throw new com.corrodinggames.rts.game.b.MapLoadException("Failed to parse map - " + var28.getMessage(), var28);
      }

      com.corrodinggames.rts.game.b.MapObject var29 = null;
      if (this.Q != null) {
         var29 = this.Q.a("map_info");
      }

      boolean var30 = false;
      boolean var31 = false;
      GameEngine var32 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
      var32.ce = null;
      var7 = null;
      String var33 = null;
      if (var29 != null) {
         String var34 = var29.b("type");
         var33 = var29.b("fog");
         if (!"mission".equalsIgnoreCase(var34) && !"survival".equalsIgnoreCase(var34) && !"challenge".equalsIgnoreCase(var34) && !"skirmish".equalsIgnoreCase(var34)) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("Unknown map type:" + var34);
         } else {
            var7 = var34;
         }
      } else {
         com.corrodinggames.rts.gameFramework.GameEngine.b("Map type not found on mapInfo");
      }

      if (var7 == null) {
         com.corrodinggames.rts.gameFramework.GameEngine.b("Defaulting to skirmish map type");
         var7 = "skirmish";
      } else {
         com.corrodinggames.rts.gameFramework.GameEngine.b("Map type: " + var7);
      }

      var32.ce = new com.corrodinggames.rts.gameFramework.n.MissionEngine();
      var32.ce.a(var2);
      if (var33 != null && !"".equals(var33)) {
         if (!var33.equalsIgnoreCase("none")) {
            var30 = true;
            if (var33.equalsIgnoreCase("los")) {
               var31 = true;
            } else if (!var33.equalsIgnoreCase("map")) {
               com.corrodinggames.rts.gameFramework.GameEngine.log("Unknown map fog type: " + var33);
            }
         }
      } else if (com.corrodinggames.rts.gameFramework.GameEngine.av() && !var32.N()) {
         var30 = true;
         if (var7 != null && var7.equalsIgnoreCase("skirmish")) {
            var31 = true;
         }
      }

      if (!var30) {
         this.E = false;
      }

      if (var30 && var31) {
         this.F = true;
      }

      this.W = true;
   }

    public void e() {
    }

    public void a(l l2) {
        if (com.corrodinggames.rts.gameFramework.GameEngine.isPausedStatic2 && !com.corrodinggames.rts.gameFramework.GameEngine.isAndroidVersionStatic2) {
            return;
        }
        try {
            al.a(l2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void a(y y2, int n2, int n3, int n4, int n5, int n6, int n7, com.corrodinggames.rts.gameFramework.m.y y3, boolean bl2, int n8) throws IOException {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        TileMap b2 = l2.bL;
        UnitType as2 = l2.bS.ac.i();
        UnitMovementType ao2 = as2.o();
        for (int i2 = n2; i2 <= n4; ++i2) {
            for (int i3 = n3; i3 <= n5; ++i3) {
                boolean bl3 = com.corrodinggames.rts.game.units.d.d.a(y2, as2, ao2, i2, i3, n8);
                int n9 = i2 * b2.n - n6;
                int n10 = i3 * b2.o - n7;
                this.an.a(n9, n10, n9 + b2.n - 1, n10 + b2.o - 1);
                if (bl2) {
                    if (bl3) {
                        y3.b(this.an, b2.ad);
                        continue;
                    }
                    y3.b(this.an, b2.af);
                    y3.b(this.an, b2.ae);
                    continue;
                }
                if (bl3) {
                    y3.b(this.an, b2.ac);
                    continue;
                }
                y3.b(this.an, b2.ae);
            }
        }
    }

    public static void f() {
        al.d();
    }

    public void c(float f2) throws IOException {
        al.a(f2);
    }

    public void g() {
        al.c();
    }

    public void d(float f2) throws IOException {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        boolean bl2 = com.corrodinggames.rts.gameFramework.GameEngine.at();
        if (bl2) {
            l2.bO.a(e);
        }
        this.c(f2);
        if (bl2) {
            l2.bO.b(e);
        }
        if (this.X) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            int n2 = this.Y * this.n;
            int n3 = this.Z * this.o;
            rect2.a(n2, n3, n2 + this.n, n3 + this.o);
            rect2.a(-com.corrodinggames.rts.gameFramework.GameEngine.getInstance().cu, -com.corrodinggames.rts.gameFramework.GameEngine.getInstance().cv);
        }
    }

    public void e(float f2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        this.f(f2);
    }

    public void clearAllMapData() {
        for (Object object : this.t) {
            ((Tileset)object).d();
        }
        this.t.clear();
        for (Object object : this.z) {
            ((MapLayer)object).b();
        }
        this.z.clear();
        this.P.clear();
        this.Q = null;
        al.c();
    }

    public Tileset a(int n2) {
        for (int i2 = 0; i2 < this.t.size(); ++i2) {
            Tileset j2 = (Tileset)this.t.get(i2);
            if (!j2.d(n2)) continue;
            return j2;
        }
        return null;
    }

    public Integer a(UnitType as2) {
        String string2 = as2.i();
        Integer n2 = this.c("unit", string2);
        if (n2 == null) {
            n2 = this.c("customUnit", string2);
        }
        return n2;
    }

    public Integer c(String string2, String string3) {
        for (int i2 = 0; i2 < this.t.size(); ++i2) {
            Tileset j2 = (Tileset)this.t.get(i2);
            Integer n2 = j2.b(string2, string3);
            if (n2 == null) continue;
            return n2;
        }
        return null;
    }

    public MapObjectLayer f(String string2) {
        for (MapObjectLayer i2 : ((ArrayList<MapObjectLayer>)this.P)) {
            if (!string2.equalsIgnoreCase(i2.b)) continue;
            return i2;
        }
        return null;
    }

    public float i() {
        return this.C * this.n;
    }

    public float j() {
        return this.D * this.o;
    }

    public void a(float f2, float f3, int n2, PlayerTeam n3, boolean bl2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (this.E) {
            com.corrodinggames.rts.gameFramework.n.MissionEngine f4;
            long l3 = 0L;
            if (a) {
                l3 = PerformanceProfiler.a();
            }
            boolean bl3 = true;
            boolean bl4 = n3.E;
            if (!(l2.ay() || (f4 = l2.ce) == null || f4.a() || f4.b())) {
                bl3 = false;
            }
            if (!bl3) {
                this.b(f2, f3, n2, n3, bl2);
            } else {
                for (int i2 = 0; i2 < com.corrodinggames.rts.game.PlayerTeam.c; ++i2) {
                    PlayerTeam n4 = com.corrodinggames.rts.game.PlayerTeam.k(i2);
                    if (n4 == null || n4 != n3 && (n4.w || !n4.d(n3) && !bl4)) continue;
                    this.b(f2, f3, n2, n4, bl2);
                }
            }
            if (a) {
                this.ap += PerformanceProfiler.a() - l3;
            }
        }
    }

    public byte a(int n2, int n3, byte[][] byArray, byte by) {
        byte by2 = 0;
        int n4 = this.C;
        int n5 = this.D;
        if (n2 >= 1) {
            if (byArray[n2 - 1][n3] >= by) {
                by2 = (byte)(by2 - 128);
            }
            if (n3 >= 1 && byArray[n2 - 1][n3 - 1] >= by) {
                by2 = (byte)(by2 + 1);
            }
            if (n3 < n5 - 1 && byArray[n2 - 1][n3 + 1] >= by) {
                by2 = (byte)(by2 + 8);
            }
        }
        if (n3 >= 1) {
            if (byArray[n2][n3 - 1] >= by) {
                by2 = (byte)(by2 + 16);
            }
            if (n2 < n4 - 1 && byArray[n2 + 1][n3 - 1] >= by) {
                by2 = (byte)(by2 + 2);
            }
        }
        if (n2 < n4 - 1 && byArray[n2 + 1][n3] >= by) {
            by2 = (byte)(by2 + 32);
        }
        if (n3 < n5 - 1) {
            if (byArray[n2][n3 + 1] >= by) {
                by2 = (byte)(by2 + 64);
            }
            if (n2 < n4 - 1 && byArray[n2 + 1][n3 + 1] >= by) {
                by2 = (byte)(by2 + 4);
            }
        }
        if (by2 == 127) {
            by2 = -1;
        }
        return by2;
    }

    public void k() {
        this.l();
        for (int i2 = 0; i2 < this.C; ++i2) {
            for (int i3 = 0; i3 < this.D; ++i3) {
                this.M[i2][i3] = 0;
                this.N[i2][i3] = 0;
            }
        }
    }

    public void f(int n2, int n3) {
        this.M[n2][n3] = 0;
        this.N[n2][n3] = 0;
    }

    public void g(int n2, int n3) {
        int n4 = n2 - 1;
        int n5 = n3 - 1;
        if (n4 < 0) {
            n4 = 0;
        }
        if (n5 < 0) {
            n5 = 0;
        }
        int n6 = n2 + 1;
        int n7 = n3 + 1;
        if (n6 > this.C - 1) {
            n6 = this.C - 1;
        }
        if (n7 > this.D - 1) {
            n7 = this.D - 1;
        }
        for (int i2 = n4; i2 <= n6; ++i2) {
            for (int i3 = n5; i3 <= n7; ++i3) {
                if (this.M[i2][i3] != 0) {
                    this.M[i2][i3] = 127;
                }
                if (this.N[i2][i3] == 0) continue;
                this.N[i2][i3] = 127;
            }
        }
    }

    public void l() {
        boolean bl2 = false;
        if (this.M == null) {
            bl2 = true;
        } else if (this.M.length != this.C || this.M[0].length != this.D) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("smoothFog_cache: Size mismatch");
            bl2 = true;
        }
        if (bl2) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Building smoothFog_cache");
            this.M = new byte[this.C][this.D];
            this.N = new byte[this.C][this.D];
            for (int i2 = 0; i2 < this.C; ++i2) {
                for (int i3 = 0; i3 < this.D; ++i3) {
                    this.M[i2][i3] = 127;
                    this.N[i2][i3] = 127;
                }
            }
        }
    }

    public void b(float f2, float f3, int n2, PlayerTeam n3, boolean bl2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (this.E && n3.N != null) {
            this.l();
            int n4 = n2;
            float f4 = (n4 - 5) * (n4 - 5);
            float f5 = (n4 - 3) * (n4 - 3);
            float f6 = n4 * n4;
            float f7 = 1.0f / (f6 - f5) * 10.0f;
            TileMap b2 = this;
            b2.a(f2, f3);
            int n5 = b2.T;
            int n6 = b2.U;
            float f8 = f2 * b2.r;
            float f9 = f3 * b2.s;
            byte[][] byArray = n3.N;
            int n7 = n4 - 1;
            int n8 = n5 - n7;
            int n9 = n6 - n7;
            if (n8 < 0) {
                n8 = 0;
            }
            if (n9 < 0) {
                n9 = 0;
            }
            int n10 = n5 + n7;
            int n11 = n6 + n7;
            if (n10 > this.C - 1) {
                n10 = this.C - 1;
            }
            if (n11 > this.D - 1) {
                n11 = this.D - 1;
            }
            LayerBufferManager c2 = al;
            boolean bl3 = false;
            boolean bl4 = n3.q();
            for (int i2 = n8; i2 <= n10; ++i2) {
                for (int i3 = n9; i3 <= n11; ++i3) {
                    byte by;
                    byte by2 = byArray[i2][i3];
                    if (by2 == 0) continue;
                    float f10 = com.corrodinggames.rts.gameFramework.GameUtils.a(f8, f9, (float)i2, (float)i3);
                    if (f10 <= f5) {
                        if (by2 <= 0) continue;
                        byArray[i2][i3] = 0;
                        if (!bl4) continue;
                        c2.a(i2, i3, true);
                        bl3 = true;
                        if (f10 <= f4 && bl2) {
                            this.f(i2, i3);
                            continue;
                        }
                        this.g(i2, i3);
                        continue;
                    }
                    if (!(f10 <= f6) || by2 <= (by = (byte)((f10 - f5) * f7))) continue;
                    byArray[i2][i3] = by;
                    if (!bl4) continue;
                    c2.a(i2, i3, true);
                    bl3 = true;
                    this.g(i2, i3);
                }
            }
            if (bl3) {
                l2.bW.O = true;
            }
        }
    }

    public void f(float f2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (a) {
            this.aq += f2;
            if (this.aq > 60.0f) {
                this.aq = 0.0f;
                if (this.ap > 0L) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("seeThoughFogOfWarTimes: " + PerformanceProfiler.b(this.ap));
                    this.ap = 0L;
                }
                if (this.ap < 0L) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("seeThoughFogOfWarTimes negative: " + PerformanceProfiler.b(this.ap));
                    this.ap = 0L;
                }
            }
        }
        if (this.E && this.F) {
            this.l();
            this.ar += f2;
            if (this.ar > 260.0f) {
                Serializable bq2;
                int n2;
                this.ar = 0.0f;
                GGameObject[] wArray = com.corrodinggames.rts.game.units.BaseUnit.fastGameObjectList.a();
                int n3 = com.corrodinggames.rts.gameFramework.GGameObject.fastGameObjectList.size();
                boolean bl2 = false;
                for (n2 = 0; n2 < com.corrodinggames.rts.game.PlayerTeam.c; ++n2) {
                    Object object;
                    int n4;
                    bq2 = com.corrodinggames.rts.game.PlayerTeam.k(n2);
                    if (bq2 == null || ((PlayerTeam)bq2).G) continue;
                    bl2 = true;
                    for (n4 = 0; n4 < n3; ++n4) {
                        GGameObject w2 = wArray[n4];
                        if (!(w2 instanceof y) || !((BaseUnit)(object = (y)w2)).bI()) continue;
                        ((BaseUnit)object).g((PlayerTeam)bq2);
                    }
                    if (((PlayerTeam)bq2).N == null) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("fogOfWar_map==null for:" + n2);
                    }
                    n4 = 0;
                    boolean bl3 = ((PlayerTeam)bq2).q();
                    object = ((PlayerTeam)bq2).N;
                    byte[][] byArray = this.N;
                    byte[][] objectArray = (byte[][]) object;
                    for (int i2 = 0; i2 < this.C; ++i2) {
                        for (int i3 = 0; i3 < this.D; ++i3) {
                            if (objectArray[i2][i3] >= 5) continue;
                            objectArray[i2][i3] = 5;
                            if (!bl3) continue;
                            al.a(i2, i3, true);
                            n4 = 1;
                            byArray[i2][i3] = 127;
                        }
                    }
                    if (n4 == 0) continue;
                    l2.bW.O = true;
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    bq2 = wArray[n2];
                    if (!(bq2 instanceof y)) continue;
                    y y2 = (y)bq2;
                    if (y2.bV) continue;
                    y2.c(false);
                }
                if (bl2) {
                    for (n2 = 0; n2 < n3; ++n2) {
                        y y3;
                        bq2 = wArray[n2];
                        if (!(bq2 instanceof y) || !(y3 = (y)bq2).bI()) continue;
                        y3.cX();
                    }
                }
            }
        }
    }

    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(false);
    }

    public void a(GameInputStream k2) throws IOException {
        boolean bl2 = k2.e();
        if (bl2) {
            int n2 = k2.readInt();
            int n3 = k2.readInt();
            for (int i2 = 0; i2 < n2; ++i2) {
                for (int i3 = 0; i3 < n3; ++i3) {
                    k2.d();
                }
            }
        }
    }

    private InputStream a(String string2, String string3, int n2) {
        String[] stringArray = string3.split("/");
        if (stringArray.length >= n2) {
            String string4 = "";
            boolean bl2 = true;
            for (int i2 = stringArray.length - n2; i2 < stringArray.length; ++i2) {
                if (!bl2) {
                    string4 = string4 + "/";
                }
                bl2 = false;
                string4 = string4 + stringArray[i2];
            }
            // 检查构建的路径是否有效
            InputStream inputStream = com.corrodinggames.rts.gameFramework.storage.a.j(string2 + string4);
            if (inputStream != null) {
                return inputStream;
            }
            // 如果构建的路径无效，尝试直接使用原始路径
            inputStream = com.corrodinggames.rts.gameFramework.storage.a.j(string2 + string3);
            if (inputStream != null) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("FileLoader: Using original path for: " + string2 + string3);
                return inputStream;
            }
        }
        return null;
    }

    public InputStream d(String string2, String string3) throws IOException {
        InputStream inputStream = null;
        inputStream = com.corrodinggames.rts.gameFramework.storage.a.j(string2 + string3);
        if (inputStream == null) {
            inputStream = this.a(string2, string3, 3);
        }
        if (inputStream == null) {
            inputStream = this.a(string2, string3, 2);
        }
        if (inputStream == null) {
            inputStream = this.a(string2, string3, 1);
        }
        if (inputStream == null) {
            throw new IOException("File could not be found:" + string2 + string3);
        }
        return inputStream;
    }

    public boolean a(PlayerTeam n2, int n3, int n4) {
        TileMap b2 = this;
        return this.G || !b2.E || n2.N == null || !b2.c(n3, n4) || n2.N[n3][n4] != 10;
    }

    static {
        g = new Paint();
        h = new Paint();
        i = new Paint();
        j = new Paint();
        H = false;
        I = false;
        J = false;
        al = new LayerBufferManager();
    }
}
