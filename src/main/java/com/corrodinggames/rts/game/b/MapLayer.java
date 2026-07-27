/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.b;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.m.y;

import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

public class MapLayer {
    private static byte[] x;
    static ag a;
    static ag[] b;
    static ag c;
    static ag d;
    static ag e;
    static ag f;
    static ag g;
    static ag[] h;
    public TileMap i;
    public int j;
    public String k;
    public String l;
    public boolean m;
    public int n;
    public int o;
    public Properties p;
    public short[] q;
    public boolean r;
    public boolean s;
    final Rect t = new Rect();
    final Rect u = new Rect();
    final RectF v = new RectF();
    public boolean w;

    public final MapTile a(int n2, int n3) {
        if (this.q == null) {
            this.q = new short[this.n * this.o];
        }
        return this.i.a(this.q[n2 * this.o + n3]);
    }

    public short[] a() {
        if (this.q == null) {
            this.q = new short[this.n * this.o];
        }
        return this.q;
    }

    public void a(int n2, int n3, MapTile g2, boolean bl2) {
        if (this.q == null) {
            this.q = new short[this.n * this.o];
        }
        if (g2 == null) {
            this.q[n2 * this.o + n3] = 0;
            return;
        }
        if (bl2) {
            g2 = this.i.a(g2, n2, n3);
        }
        if (g2.i) {
            boolean bl3 = false;
            for (Point point : ((ArrayList<Point>)this.i.A)) {
                if (point.x != n2 || point.b != n3) continue;
                com.corrodinggames.rts.gameFramework.GameEngine.log("resPools point:" + n2 + ", " + n3 + " already exists");
                bl3 = true;
            }
            if (!bl3) {
                this.i.A.add(new Point(n2, n3));
            }
        }
        if (g2.d == -1) {
            g2.d = this.i.a(g2);
        }
        this.q[n2 * this.o + n3] = g2.d;
    }

    public void a(y y2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, boolean bl2, boolean bl3, boolean bl4) throws IOException {
        ag ag2;
        boolean bl5;
        int n2;
        int n3;
        int n4;
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = this.i;
        int n5 = (int)(f4 * b2.r);
        if (n5 < 0) {
            n5 = 0;
        }
        if ((n4 = (int)(f5 * b2.s)) < 0) {
            n4 = 0;
        }
        if ((n3 = (int)((f4 + f6) * b2.r)) > this.n - 1) {
            n3 = this.n - 1;
        }
        if ((n2 = (int)((f5 + f7) * b2.s)) > this.o - 1) {
            n2 = this.o - 1;
        }
        byte[][] byArray = l2.bs.N;
        float f10 = f2 * f8;
        float f11 = f3 * f9;
        float f12 = (float)b2.n * f8;
        float f13 = (float)b2.o * f9;
        boolean bl6 = true;
        byte by = 15;
        if (!bl3) {
            by = 10;
        }
        if (bl5 = b2.G) {
            by = 15;
        }
        if (bl2 && byArray == null) {
            bl2 = false;
        }
        ag ag3 = b[5];
        ag ag4 = a;
        ag ag5 = c;
        ag5.c(255);
        if (bl5) {
            ag4 = b[7];
            float f14 = 1.0f - (1.0f - (float)ag3.f() / 255.0f) * (1.0f - (float)ag4.f() / 255.0f);
            ag5.c((int)(f14 * 255.0f));
        }
        boolean bl7 = false;
        if (com.corrodinggames.rts.gameFramework.GameEngine.av() && f8 < 1.0f && f9 < 1.0f) {
            bl7 = true;
        }
        if (bl4) {
            // empty if block
        }
        if (!this.r) {
            ag2 = f;
            if (bl7) {
                ag2 = g;
            }
        } else {
            ag2 = d;
            if (bl7) {
                ag2 = e;
            }
        }
        ag ag6 = ag2;
        float f15 = 0.0f;
        float f16 = 0.0f;
        boolean bl8 = false;
        if (!com.corrodinggames.rts.gameFramework.GameEngine.av()) {
            bl8 = true;
        } else if (!bl4) {
            if (f8 < 1.0f || f9 < 1.0f) {
                f15 = 0.5f * f8;
            }
        } else if (f8 < 1.0f || f9 < 1.0f) {
            // empty if block
        }
        TileAtlasCache h2 = f8 < 0.5f ? com.corrodinggames.rts.game.b.TileMap.m : com.corrodinggames.rts.game.b.TileMap.l;
        short[] sArray = this.a();
        MapTile[] gArray = b2.B;
        RectF rectF = this.v;
        Rect rect = this.u;
        int n6 = this.o;
        boolean bl9 = this.r;
        Rect rect2 = this.t;
        b2.l();
        byte[][] byArray2 = b2.M;
        byte[][] byArray3 = b2.N;
        com.corrodinggames.rts.gameFramework.m.Texture_M e2 = com.corrodinggames.rts.game.b.TileMap.K;
        for (int i2 = n5; i2 < n3 + 1; ++i2) {
            for (int i3 = n4; i3 < n2 + 1; ++i3) {
                com.corrodinggames.rts.gameFramework.m.Texture_M e3;
                Object object;
                short s2 = sArray[i2 * n6 + i3];
                MapTile g2 = gArray[s2];
                if (g2 == null) continue;
                byte by2 = 0;
                if (bl2) {
                    by2 = byArray[i2][i3];
                }
                if (by2 == by) continue;
                float f17 = (float)i2 * f12 + f16;
                float f18 = (float)i3 * f13 + f16;
                float f19 = (float)(i2 + 1) * f12 + f15;
                float f20 = (float)(i3 + 1) * f13 + f15;
                rectF.a(f17 - f10, f18 - f11, f19 - f10, f20 - f11);
                if (bl7 && !bl4) {
                    rectF.b = (int)rectF.b;
                    rectF.left = (int)rectF.left;
                }
                if (!bl4) {
                    object = g2.a;
                    if (!bl8) {
                        if (g2.c >= 0) {
                            Rect rect3 = h2.b(g2.c);
                            e3 = h2.a(g2.c);
                            y2.a(e3, rect3, rectF, (Paint)ag6);
                        } else {
                            g2.a(y2, rectF, f8, ag6);
                        }
                    } else {
                        rect.a((int)(f17 - f10), (int)(f18 - f11), (int)(f19 - f10), (int)(f20 - f11));
                        if (g2.c >= 0) {
                            Rect rect4 = h2.b(g2.c);
                            e3 = h2.a(g2.c);
                            y2.b(e3, rect4, rect, (Paint)ag6);
                        } else {
                            Rect rect5 = ((Tileset)object).b(g2.b);
                            y2.a(((Tileset)object).b, rect5, rect, (Paint)ag6);
                        }
                    }
                }
                if (!bl2 || !bl9 || !bl3 || by2 == 0 && byArray3[i2][i3] == 0 && byArray2[i2][i3] == 0) continue;
                if (by2 >= 5) {
                    if (bl4 && (by2 == 10 || byArray2[i2][i3] == 0)) {
                        byte by3;
                        int n7;
                        for (n7 = i3 + 1; n7 < n2 && by2 == (by3 = byArray[i2][n7]) && (by2 == 10 || byArray2[i2][n7] == 0); ++n7) {
                        }
                        if (--n7 > i3) {
                            rectF.d += (float)(n7 - i3) * f13;
                            i3 = n7;
                        }
                    }
                    object = by2 == 10 ? ag5 : ag3;
                    rect.left = (int)rectF.left;
                    rect.c = (int)rectF.c;
                    rect.top = (int)rectF.b;
                    rect.d = (int)rectF.d;
                    y2.a(rect, (Paint)object);
                } else {
                    byte by4 = byArray3[i2][i3];
                    if (by4 == 127) {
                        byArray3[i2][i3] = by4 = b2.a(i2, i3, byArray, (byte)5);
                    }
                    if (by4 != 0) {
                        int n8 = by4 + 128;
                        e3 = e2;
                        if (e3 != null) {
                            com.corrodinggames.rts.game.b.TileMap.a(n8, rect2);
                            rect.a((int)(f17 - f10), (int)(f18 - f11), (int)(f19 - f10), (int)(f20 - f11));
                            y2.b(e3, rect2, rect, (Paint)ag3);
                        } else if (!b2.k[by4 + 128]) {
                            com.corrodinggames.rts.gameFramework.GameEngine.log("SmoothFog, missing: " + by4);
                            b2.k[by4 + 128] = true;
                        }
                    }
                }
                if (by2 == 10) continue;
                byte by5 = byArray2[i2][i3];
                if (by5 == 127) {
                    byArray2[i2][i3] = by5 = b2.a(i2, i3, byArray, (byte)10);
                }
                if (by5 == 0) continue;
                int n9 = by5 + 128;
                e3 = e2;
                if (e3 != null) {
                    com.corrodinggames.rts.game.b.TileMap.a(n9, rect2);
                    rect.a((int)(f17 - f10), (int)(f18 - f11), (int)(f19 - f10), (int)(f20 - f11));
                    y2.b(e3, rect2, rect, (Paint)ag4);
                    continue;
                }
                if (b2.k[by5 + 128]) continue;
                com.corrodinggames.rts.gameFramework.GameEngine.log("SmoothFog, missing: " + by5);
                b2.k[by5 + 128] = true;
            }
        }
    }

    public void b() {
        this.q = null;
        this.p = null;
        this.i = null;
    }

    public MapLayer(TileMap b2, String string2, int n2, int n3) {
        this.i = b2;
        this.a(string2);
        this.n = n2;
        this.o = n3;
        this.a();
    }

    void a(String string2) {
        this.k = string2;
        Log.d("RustedWarfare", "MapLayer create: " + string2);
        if (string2 != null) {
            this.l = string2.toLowerCase(Locale.ENGLISH);
        }
        this.m = this.l.contains("items");
        this.r = this.l.equalsIgnoreCase("ground");
        if (this.m || this.r) {
            this.s = true;
        }
        if (string2 != null && string2.equalsIgnoreCase("grounddetails")) {
            this.s = true;
        }
    }

    public MapLayer(TileMap b2, Element element) throws MapLoadException {
        String string2;
        Object object;
        Object object2;
        Object object3;
        this.i = b2;
        this.a(element.getAttribute("name"));
        this.n = Short.parseShort(element.getAttribute("width"));
        this.o = Short.parseShort(element.getAttribute("height"));
        Element element2 = (Element)element.getElementsByTagName("properties").item(0);
        if (element2 != null && (object3 = element2.getElementsByTagName("property")) != null) {
            this.p = new Properties();
            for (int i2 = 0; i2 < ((NodeList) object3).getLength(); ++i2) {
                object2 = (Element)((NodeList) object3).item(i2);
                object = ((Element) object2).getAttribute("name");
                string2 = ((Element) object2).getAttribute("value");
                this.p.setProperty((String)object, string2);
            }
        }
        if ((object3 = (Element)element.getElementsByTagName("data").item(0)) == null) {
            throw new MapLoadException("Map is missing <data> element");
        }
        String string3 = ((Element) object3).getAttribute("encoding");
        object2 = ((Element) object3).getAttribute("compression");
        try {
            object = ((Node) object3).getFirstChild();
            string2 = ((Node) object).getNodeValue();
            InputStream inputStream = com.corrodinggames.rts.game.b.MapLayer.a(string2, string3, (String)object2);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            this.a(bufferedInputStream);
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        catch (IOException iOException) {
            throw new MapLoadException("Unable to decompress base64 block", iOException);
        }
    }

    void a(InputStream inputStream) throws MapLoadException, IOException {
        TileMap b2 = this.i;
        MapTile g2 = null;
        int n2 = -1;
        boolean bl2 = this.s;
        HashMap<Integer, MapTile> hashMap = new HashMap<Integer, MapTile>();
        for (short s2 = 0; s2 < this.o; s2 = (short)((short)(s2 + 1))) {
            for (short s3 = 0; s3 < this.n; s3 = (short)((short)(s3 + 1))) {
                int n3 = 0;
                n3 |= inputStream.read();
                n3 |= inputStream.read() << 8;
                n3 |= inputStream.read() << 16;
                boolean bl3 = ((n3 |= inputStream.read() << 24) & Integer.MIN_VALUE) != 0;
                boolean bl4 = (n3 & 0x40000000) != 0;
                boolean bl5 = (n3 & 0x20000000) != 0;
                n3 &= 0x1FFFFFFF;
                if (bl3 || bl4 || bl5) {
                    // empty if block
                }
                if (n3 == 0) continue;
                if (n2 == n3 && g2 != null) {
                    this.a(s3, s2, g2, true);
                    continue;
                }
                MapTile g3 = (MapTile)hashMap.get(n3);
                if (g3 != null) {
                    g2 = g3;
                    n2 = n3;
                    this.a(s3, s2, g2, true);
                    continue;
                }
                Tileset j2 = b2.a(n3);
                if (j2 != null) {
                    g2 = com.corrodinggames.rts.game.b.MapTile.a(b2, this, j2, n3 - j2.l, s3, s2, bl2);
                    if (g2 != null) {
                        this.a(s3, s2, g2, true);
                        hashMap.put(n3, g2);
                    }
                    n2 = n3;
                    continue;
                }
                throw new MapLoadException("Unable to decode base64 block, could not find tileId: " + n3);
            }
        }
    }

   public static InputStream a(String var0, String var1, String var2) throws MapLoadException {
      if (var1.equals("base64")) {
         char[] var4 = var0.toCharArray();
         byte[] var3 = a(var4);
         Object var7;
         if ("gzip".equals(var2)) {
            try {
               GZIPInputStream var5 = new GZIPInputStream(new ByteArrayInputStream(var3));
               var7 = var5;
            } catch (IOException var6) {
               throw new MapLoadException("Unable to decode block in map", var6);
            }
         } else if ("".equals(var2)) {
            var7 = new ByteArrayInputStream(var3);
         } else {
            if (!"zlib".equals(var2)) {
               throw new MapLoadException("Unsupport tiled map compression: " + var1 + "," + var2 + " (only gzip base64 is supported, this can be set in Tiled's Preferences)");
            }

            InflaterInputStream var8 = new InflaterInputStream(new ByteArrayInputStream(var3));
            var7 = var8;
         }

         return (InputStream)var7;
      } else {
         throw new MapLoadException("Unsupport tiled map encoding: " + var1 + "," + var2 + " (only gzip base64 is supported, this can be set in Tiled's Preferences)");
      }
   }

    public static byte[] a(char[] cArray) {
        int n2;
        int n3 = cArray.length;
        byte[] byArray = x;
        for (n2 = 0; n2 < cArray.length; ++n2) {
            if (cArray[n2] <= '\u00ff' && byArray[cArray[n2]] >= 0) continue;
            --n3;
        }
        n2 = n3 / 4 * 3;
        if (n3 % 4 == 3) {
            n2 += 2;
        }
        if (n3 % 4 == 2) {
            ++n2;
        }
        byte[] byArray2 = new byte[n2];
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            int n7;
            int n8 = n7 = cArray[i2] > '\u00ff' ? -1 : byArray[cArray[i2]];
            if (n7 < 0) continue;
            n5 <<= 6;
            n5 |= n7;
            if ((n4 += 6) < 8) continue;
            byArray2[n6++] = (byte)(n5 >> (n4 -= 8) & 0xFF);
        }
        if (n6 != byArray2.length) {
            throw new RuntimeException("Data length appears to be wrong (wrote " + n6 + " should be " + byArray2.length + ")");
        }
        return byArray2;
    }

    static {
        int n2;
        x = new byte[256];
        for (n2 = 0; n2 < 256; ++n2) {
            com.corrodinggames.rts.game.b.MapLayer.x[n2] = -1;
        }
        for (n2 = 65; n2 <= 90; ++n2) {
            com.corrodinggames.rts.game.b.MapLayer.x[n2] = (byte)(n2 - 65);
        }
        for (n2 = 97; n2 <= 122; ++n2) {
            com.corrodinggames.rts.game.b.MapLayer.x[n2] = (byte)(26 + n2 - 97);
        }
        for (n2 = 48; n2 <= 57; ++n2) {
            com.corrodinggames.rts.game.b.MapLayer.x[n2] = (byte)(52 + n2 - 48);
        }
        com.corrodinggames.rts.game.b.MapLayer.x[43] = 62;
        com.corrodinggames.rts.game.b.MapLayer.x[47] = 63;
        a = new ag();
        a.b(-16777216);
        a.a(Paint$Style.a);
        b = new ag[11];
        for (n2 = 0; n2 <= 10; ++n2) {
            com.corrodinggames.rts.game.b.MapLayer.b[n2] = new ag();
            b[n2].b(-16777216);
            b[n2].a(Paint$Style.a);
            b[n2].c(n2 * 25);
        }
        c = new ag();
        c.b(-16777216);
        c.a(Paint$Style.a);
        d = new ag();
        d.a(false);
        d.d(false);
        d.b(false);
        e = new ag();
        e.a(true);
        f = new ag();
        f.a(false);
        f.d(false);
        f.b(false);
        g = new ag();
        g.a(true);
        h = new ag[11];
        for (n2 = 0; n2 <= 10; ++n2) {
            ag ag2 = new ag();
            ag2.a(new LightingColorFilter(Color.a(255 - n2 * 25, 255 - n2 * 25, 255 - n2 * 25), 0));
            com.corrodinggames.rts.game.b.MapLayer.h[n2] = ag2;
        }
    }
}

