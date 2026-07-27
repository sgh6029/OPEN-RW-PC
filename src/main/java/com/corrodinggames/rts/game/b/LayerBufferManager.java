/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 */
package com.corrodinggames.rts.game.b;

import android.graphics.PorterDuff;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.b.LayerBufferCell;
import com.corrodinggames.rts.game.b.MapLayer;
import com.corrodinggames.rts.game.l;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.m.y;
import com.corrodinggames.rts.gameFramework.m.z;
import com.corrodinggames.rts.gameFramework.AssetType;
import com.corrodinggames.rts.gameFramework.GGameObject;

import java.io.IOException;
import java.util.ArrayList;

public final class LayerBufferManager {
    int a = 7;
    public com.corrodinggames.rts.gameFramework.m.Texture_M b = null;
    public y c = null;
    LayerBufferCell[][] d = null;
    public ag e = new ag();
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    float l;
    float m = 1.0f;
    boolean n;
    Rect o = new Rect();
    int p = 0;

    public void a() {
        float f2;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        this.m = f2 = this.g();
        if (this.m > 1.0f) {
            // empty if block
        }
        this.i = (int)((float)this.h / this.m);
        this.k = (int)((float)this.j / this.m);
        this.l = 1.0f / (float)this.k;
        this.f = l2.cu - this.i / 2;
        this.g = l2.cv - this.i / 2;
        int n2 = 20;
        float f3 = 1.0f / (float)n2;
        this.f = (int)((float)this.f * f3) * n2;
        this.g = (int)((float)this.g * f3) * n2;
        for (int i2 = 0; i2 < this.a; ++i2) {
            for (int i3 = 0; i3 < this.a; ++i3) {
                LayerBufferCell d2 = this.d[i2][i3];
                d2.k = true;
                d2.n = false;
            }
        }
    }

    public void b() {
        for (int i2 = 0; i2 < this.a; ++i2) {
            int n2 = 0;
            while (n2 < this.a) {
                LayerBufferCell d2 = this.d[i2][n2];
                d2.i = i2;
                d2.j = n2++;
            }
        }
    }

    public void a(int n2) {
        LayerBufferCell[] dArray = new LayerBufferCell[this.a];
        if (n2 > 0) {
            int n3;
            for (n3 = 0; n3 < this.a; ++n3) {
                dArray[n3] = this.d[n3][0];
            }
            for (n3 = 1; n3 < this.a; ++n3) {
                for (int i2 = 0; i2 < this.a; ++i2) {
                    this.d[i2][n3 - 1] = this.d[i2][n3];
                }
            }
            for (n3 = 0; n3 < this.a; ++n3) {
                this.d[n3][this.a - 1] = dArray[n3];
            }
            for (n3 = 0; n3 < this.a; ++n3) {
                this.d[n3][this.a - 1].k = true;
            }
        } else {
            int n4;
            for (n4 = 0; n4 < this.a; ++n4) {
                dArray[n4] = this.d[n4][this.a - 1];
            }
            for (n4 = this.a - 2; n4 >= 0; --n4) {
                for (int i3 = 0; i3 < this.a; ++i3) {
                    this.d[i3][n4 + 1] = this.d[i3][n4];
                }
            }
            for (n4 = 0; n4 < this.a; ++n4) {
                this.d[n4][0] = dArray[n4];
            }
            for (n4 = 0; n4 < this.a; ++n4) {
                this.d[n4][0].k = true;
            }
        }
        this.b();
    }

    public void b(int n2) {
        LayerBufferCell[] dArray = new LayerBufferCell[this.a];
        if (n2 > 0) {
            int n3;
            for (n3 = 0; n3 < this.a; ++n3) {
                dArray[n3] = this.d[0][n3];
            }
            for (n3 = 1; n3 < this.a; ++n3) {
                for (int i2 = 0; i2 < this.a; ++i2) {
                    this.d[n3 - 1][i2] = this.d[n3][i2];
                }
            }
            for (n3 = 0; n3 < this.a; ++n3) {
                this.d[this.a - 1][n3] = dArray[n3];
            }
            for (n3 = 0; n3 < this.a; ++n3) {
                this.d[this.a - 1][n3].k = true;
            }
        } else {
            int n4;
            for (n4 = 0; n4 < this.a; ++n4) {
                dArray[n4] = this.d[this.a - 1][n4];
            }
            for (n4 = this.a - 2; n4 >= 0; --n4) {
                for (int i3 = 0; i3 < this.a; ++i3) {
                    this.d[n4 + 1][i3] = this.d[n4][i3];
                }
            }
            for (n4 = 0; n4 < this.a; ++n4) {
                this.d[0][n4] = dArray[n4];
            }
            for (n4 = 0; n4 < this.a; ++n4) {
                this.d[0][n4].k = true;
            }
        }
        this.b();
    }

    public LayerBufferCell a(int n2, int n3) {
        if (n2 < 0 || n2 >= this.a) {
            return null;
        }
        if (n3 < 0 || n3 >= this.a) {
            return null;
        }
        if (this.d == null) {
            return null;
        }
        return this.d[n2][n3];
    }

    public void a(int n2, int n3, boolean bl2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        TileMap b2 = l2.bL;
        int n4 = b2.n;
        int n5 = b2.o;
        int n6 = n2 * n4;
        int n7 = n3 * n5;
        int n8 = n6 - this.f;
        int n9 = n7 - this.g;
        this.a(n8 - n4, n9 - n5, 3 * n4, 3 * n5, bl2);
    }

    public void c() {
        if (this.d != null) {
            for (int i2 = 0; i2 < this.a; ++i2) {
                for (int i3 = 0; i3 < this.a; ++i3) {
                    LayerBufferCell d2 = this.d[i2][i3];
                    d2.k = true;
                }
            }
        }
    }

    public void a(int n2, int n3, int n4, int n5, boolean bl2) {
        int n6 = (int)((float)n2 * this.l);
        int n7 = (int)((float)n3 * this.l);
        LayerBufferCell d2 = this.a(n6, n7);
        if (d2 != null) {
            LayerBufferCell d3;
            if (bl2) {
                d2.l = true;
            } else {
                d2.k = true;
            }
            boolean bl3 = false;
            boolean bl4 = false;
            if (n2 + n4 >= d2.i * this.k + this.i) {
                bl3 = true;
            }
            if (n3 + n5 >= d2.j * this.k + this.i) {
                bl4 = true;
            }
            if (bl3 && (d3 = this.a(n6 + 1, n7)) != null) {
                if (bl2) {
                    d3.l = true;
                } else {
                    d3.k = true;
                }
            }
            if (bl4 && (d3 = this.a(n6, n7 + 1)) != null) {
                if (bl2) {
                    d3.l = true;
                } else {
                    d3.k = true;
                }
            }
            if (bl3 && bl4 && (d3 = this.a(n6 + 1, n7 + 1)) != null) {
                if (bl2) {
                    d3.l = true;
                } else {
                    d3.k = true;
                }
            }
        }
    }

    public void a(l l2) throws IOException {
        RectF rectF = l2.c();
        for (int i2 = 0; i2 < this.a; ++i2) {
            for (int i3 = 0; i3 < this.a; ++i3) {
                boolean bl2;
                LayerBufferCell d2;
                Rect rect;
                if (this.d == null || !com.corrodinggames.rts.gameFramework.GameUtils.a(rect = (d2 = this.d[i2][i3]).b(), rectF)) continue;
                boolean bl3 = bl2 = this.m != 1.0f;
                if (bl2) {
                    // empty if block
                }
                l2.a(d2.a, d2.c(), d2.d(), this.m);
                d2.d.p();
                if (!bl2) continue;
            }
        }
    }

    public void a(int n2, int n3, y y2) throws IOException {
        boolean bl2;
        LayerBufferCell d2 = this.d[n2][n3];
        boolean bl3 = bl2 = this.m != 1.0f;
        if (bl2) {
            // empty if block
        }
        Rect rect = d2.b();
        com.corrodinggames.rts.gameFramework.GameUtils.a(rect, 95.0f);
        GGameObject[] wArray = GGameObject.fastGameObjectList.a();
        int n4 = GGameObject.fastGameObjectList.size();
        for (int i2 = 0; i2 < n4; ++i2) {
            GGameObject w2 = wArray[i2];
            if (!(w2 instanceof l)) continue;
            l l2 = (l)w2;
            if (!rect.b((int)l2.posX, (int)l2.posY)) continue;
            l2.a(y2, d2.c(), d2.d(), this.m);
        }
        if (bl2) {
            // empty if block
        }
    }

    public void b(int n2, int n3, y y2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        TileMap b2 = l2.bL;
        if (l2.bS.F()) {
            boolean bl2;
            int n4;
            int n5;
            int n6;
            int n7 = this.f + n2 * this.k;
            int n8 = this.g + n3 * this.k;
            int n9 = n7;
            int n10 = n8;
            int n11 = this.i;
            int n12 = this.i;
            int n13 = b2.u.n;
            int n14 = b2.u.o;
            int n15 = (int)((float)n9 * b2.r);
            if (n15 < 0) {
                n15 = 0;
            }
            if ((n6 = (int)((float)n10 * b2.s)) < 0) {
                n6 = 0;
            }
            if ((n5 = (int)((float)(n9 + n11) * b2.r)) > n13 - 1) {
                n5 = n13 - 1;
            }
            if ((n4 = (int)((float)(n10 + n12) * b2.s)) > n14 - 1) {
                n4 = n14 - 1;
            }
            if ((double)this.m < 0.4) {
                return;
            }
            boolean bl3 = bl2 = this.m != 1.0f;
            if (bl2) {
                y2.i();
                y2.a(this.m, this.m);
            }
            if (bl2) {
                y2.j();
            }
        }
    }

    public void b(int n2, int n3) throws IOException {
        LayerBufferCell d2 = com.corrodinggames.rts.game.b.TileMap.al.d[n2][n3];
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        TileMap b2 = l2.bL;
        d2.n = true;
        this.c.b(-16777216);
        com.corrodinggames.rts.gameFramework.m.Texture_M e2 = l2.bW.J;
        if (e2 != null) {
            Rect rect = new Rect();
            RectF rectF = new RectF();
            float f2 = (float)(this.f + n2 * this.k) / (float)(b2.n * b2.C);
            float f3 = (float)(this.g + n3 * this.k) / (float)(b2.o * b2.D);
            float f4 = (float)(this.f + (n2 + 1) * this.k) / (float)(b2.n * b2.C);
            float f5 = (float)(this.g + (n3 + 1) * this.k) / (float)(b2.o * b2.D);
            rect.a((int)(f2 * (float)e2.p), (int)(f3 * (float)e2.q), (int)(f4 * (float)e2.p), (int)(f5 * (float)e2.q));
            rectF.a(0.0f, 0.0f, this.h, this.h);
            this.c.a(e2, rect, rectF, (Paint)this.e);
        }
        this.c.p();
        if (com.corrodinggames.rts.gameFramework.GameEngine.isAndroidVersionStatic2) {
            d2.a.a(0, PorterDuff.Mode.CLEAR);
        }
        d2.a.b(this.b, 0.0f, 0.0f, null);
        d2.d.p();
    }

    public void c(int n2, int n3) throws IOException {
        this.c(n2, n3, this.c);
    }

    public void c(int n2, int n3, y y2) throws IOException {
        int n4;
        LayerBufferCell d2 = com.corrodinggames.rts.game.b.TileMap.al.d[n2][n3];
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        TileMap b2 = l2.bL;
        boolean bl2 = false;
        if (l2.bQ.renderFancyWater) {
            bl2 = true;
        }
        if (com.corrodinggames.rts.gameFramework.GameEngine.C() || com.corrodinggames.rts.gameFramework.GameEngine.D()) {
            bl2 = true;
        }
        if (bl2) {
            y2.a(0, PorterDuff.Mode.CLEAR);
        } else {
            n4 = 0;
            if (com.corrodinggames.rts.gameFramework.GameEngine.C()) {
                n4 = 1;
            }
            if (com.corrodinggames.rts.gameFramework.GameEngine.isIOSVersionStatic2) {
                n4 = 1;
            }
            if (com.corrodinggames.rts.gameFramework.f.g.bO) {
                // empty if block
            }
            if (b2.E) {
                // empty if block
            }
            if (n4 != 0) {
                y2.b(-16777216);
            }
        }
        if (com.corrodinggames.rts.gameFramework.GameEngine.isIOSVersionStatic2) {
            y2.a(0, PorterDuff.Mode.CLEAR);
        }
        n4 = this.f + n2 * this.k;
        int n5 = this.g + n3 * this.k;
        boolean bl3 = true;
        boolean bl4 = false;
        boolean bl5 = true;
        boolean bl6 = false;
        boolean bl7 = false;
        boolean bl8 = false;
        if (!b2.u.w) {
            bl7 = true;
        }
        if (b2.E) {
            bl8 = true;
        }
        if (com.corrodinggames.rts.game.b.TileMap.d) {
            bl7 = false;
            bl8 = false;
        }
        if (bl7) {
            y2.a(true);
        }
        b2.u.a(y2, n4, n5, n4, n5, this.i, this.i, this.m, this.m, b2.E, false, false);
        if (b2.v != null) {
            if (bl7 && b2.v.w) {
                y2.f();
                com.corrodinggames.rts.gameFramework.GameEngine.log("Ending blit early");
            }
            b2.v.a(y2, n4, n5, n4, n5, this.i, this.i, this.m, this.m, b2.E, false, false);
        }
        if (b2.w != null) {
            if (bl7 && b2.w.w) {
                y2.f();
                com.corrodinggames.rts.gameFramework.GameEngine.log("Ending blit early");
            }
            b2.w.a(y2, n4, n5, n4, n5, this.i, this.i, this.m, this.m, b2.E, false, false);
        }
        for (MapLayer e2 : ((ArrayList<MapLayer>)b2.z)) {
            if (!e2.m) continue;
            if (bl7 && e2.w) {
                y2.f();
                com.corrodinggames.rts.gameFramework.GameEngine.log("Ending blit early");
            }
            e2.a(y2, n4, n5, n4, n5, this.i, this.i, this.m, this.m, b2.E, false, false);
        }
        this.a(n2, n3, y2);
        if (b2.E) {
            if (bl8) {
                y2.a(false);
            }
            b2.u.a(y2, n4, n5, n4, n5, this.i, this.i, this.m, this.m, b2.E, true, true);
        }
        if (bl7 || bl8) {
            y2.f();
        }
        if (l2.bS.F()) {
            this.b(n2, n3, y2);
        }
        d2.k = false;
        d2.l = false;
        d2.m = 0;
        d2.n = false;
        y2.p();
        if (bl2 || com.corrodinggames.rts.gameFramework.GameEngine.isAndroidVersionStatic2) {
            d2.a.a(0, PorterDuff.Mode.CLEAR);
        }
        d2.a.b(this.b, 0.0f, 0.0f, null);
        d2.d.p();
        if (com.corrodinggames.rts.game.b.TileMap.c) {
            d2.a.a("" + d2.c, 40.0f, 40.0f, com.corrodinggames.rts.game.b.TileMap.h);
        }
        ++d2.c;
    }

    public void d() {
        if (com.corrodinggames.rts.gameFramework.GameEngine.isPausedStatic2 && !com.corrodinggames.rts.gameFramework.GameEngine.isIOSVersionStatic2 && !com.corrodinggames.rts.gameFramework.GameEngine.isPCVersionStatic2) {
            return;
        }
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        int n2 = Math.max((int)l2.cameraShakeX, (int)l2.cameraShakeIntensity) + 3;
        if (this.d != null && this.h * this.a < n2 + this.h + 1) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("map", "screen must have changed size, layerBufferSize too small at " + this.a + ", adding to LayerBitmapBuffer");
            com.corrodinggames.rts.gameFramework.GameEngine.b("map", "new viewpoint:" + l2.cameraShakeX + ", " + l2.cameraShakeIntensity);
            this.c(this.a + 1);
        }
        if (this.d == null) {
            int n3;
            com.corrodinggames.rts.gameFramework.GameEngine.b("map", "setupLayerBuffers for size:" + n2);
            long l3 = System.nanoTime();
            if (com.corrodinggames.rts.gameFramework.GameEngine.isIOSVersionStatic2 || com.corrodinggames.rts.gameFramework.GameEngine.isPCVersionStatic2) {
                this.h = 1024;
                this.a = (int)((float)n2 / (float)this.h + 1.5f);
            } else {
                n2 = Math.max(600, n2);
                this.h = n2 / (this.a - 2) + 7 + 4;
                n3 = 20;
                float f2 = 1.0f / (float)n3;
                this.h = (int)((float)this.h * f2 + 0.5f) * n3;
            }
            if (this.h * this.a < n2 + this.h + 1) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("layerBufferSize is too small");
                com.corrodinggames.rts.gameFramework.GameEngine.b("layerBufferCount:" + this.a);
                com.corrodinggames.rts.gameFramework.GameEngine.b("(layerBufferSize*(layerBufferCount):" + this.h * this.a);
                com.corrodinggames.rts.gameFramework.GameEngine.b("longest+layerBufferSize+1:" + (n2 + this.h + 1));
                com.corrodinggames.rts.gameFramework.GameEngine.b("longest:" + n2);
                if (com.corrodinggames.rts.gameFramework.GameEngine.isIOSVersionStatic2 || com.corrodinggames.rts.gameFramework.GameEngine.isPCVersionStatic2) {
                    ++this.a;
                } else {
                    this.h += 100;
                }
            }
            com.corrodinggames.rts.gameFramework.GameEngine.log("layerBufferSize:" + this.h);
            this.j = this.h - 4;
            com.corrodinggames.rts.gameFramework.GameEngine.b("layerBuffer:" + this.a + "x" + this.a + " = " + this.a * this.a + (com.corrodinggames.rts.game.b.TileMap.I ? " x2 for soft fade " : ""));
            this.d = new LayerBufferCell[this.a][this.a];
            n3 = 0;
            if (l2.bQ.renderFancyWater) {
                n3 = 1;
            }
            if (com.corrodinggames.rts.gameFramework.GameEngine.C() || com.corrodinggames.rts.gameFramework.GameEngine.D()) {
                n3 = 1;
            }
            if (this.h <= 0) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("layerBuffer buffer size was too small at: " + this.h);
                this.h = 512;
            }
            this.b = n3 != 0 ? l2.bO.a(this.h, this.h, true) : l2.bO.a(this.h, this.h, false);
            this.b.b(true);
            this.c = l2.bO.b(this.b);
            this.f();
            long l4 = System.nanoTime();
            com.corrodinggames.rts.gameFramework.GameEngine.log("----- layerBuffers create in:" + (double)(l4 - l3) / 1000000.0 + " ms");
        }
    }

    public void c(int n2) {
        if (n2 < this.a) {
            com.corrodinggames.rts.gameFramework.GameEngine.g("newLayerBufferCount:" + n2);
            return;
        }
        LayerBufferCell[][] dArray = new LayerBufferCell[n2][n2];
        for (int i2 = 0; i2 < this.a; ++i2) {
            for (int i3 = 0; i3 < this.a; ++i3) {
                dArray[i2][i3] = this.d[i2][i3];
            }
        }
        this.d = dArray;
        this.a = n2;
        this.f();
    }

    public void e() {
        com.corrodinggames.rts.game.b.TileMap.I = false;
        com.corrodinggames.rts.game.b.TileMap.J = true;
        for (int i2 = 0; i2 < this.a; ++i2) {
            for (int i3 = 0; i3 < this.a; ++i3) {
                LayerBufferCell d2 = this.d[i2][i3];
                if (d2 == null) continue;
                if (d2.f != null) {
                    d2.f.q();
                    d2.f = null;
                }
                if (d2.e == null) continue;
                d2.e.o();
                d2.e = null;
            }
        }
    }

    public void f() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        ArrayList<LayerBufferCell> arrayList = null;
        boolean bl2 = false;
        for (int i2 = 0; i2 < this.a; ++i2) {
            for (int i3 = 0; i3 < this.a; ++i3) {
                LayerBufferCell d2 = this.d[i2][i3];
                if (d2 != null) continue;
                d2 = new LayerBufferCell(this, i2, i3);
                d2.b = this.p++;
                this.d[i2][i3] = d2;
                if (this.h <= 0) {
                    com.corrodinggames.rts.gameFramework.GameEngine.b("initMissingLayerBufferImages: layerBuffer buffer size was too small at: " + this.h);
                    this.h = 512;
                }
                d2.d = bl2 ? l2.bO.r() : (l2.bQ.renderFancyWater ? l2.bO.a(this.h, this.h, true) : l2.bO.a(this.h, this.h, false));
                d2.d.b(true);
                if (d2.d.A()) {
                    if (!bl2) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("initMissingLayerBufferImages: Failed to create map buffer at :" + this.h + "px");
                    }
                    d2.a = new z();
                } else {
                    try {
                        d2.a = l2.bO.b(d2.d);
                    }
                    catch (OutOfMemoryError outOfMemoryError) {
                        if (!bl2) {
                            com.corrodinggames.rts.gameFramework.GameEngine.a(AssetType.gameImageCreate, (Throwable)outOfMemoryError);
                        }
                        bl2 = true;
                        d2.a = new z();
                    }
                }
                if (arrayList == null) {
                    arrayList = new ArrayList<LayerBufferCell>();
                }
                arrayList.add(d2);
            }
        }
        if (bl2 && com.corrodinggames.rts.game.b.TileMap.I) {
            this.e();
        }
        if (arrayList != null) {
            for (LayerBufferCell d3 : arrayList) {
                if (!com.corrodinggames.rts.game.b.TileMap.I) continue;
                try {
                    d3.a();
                }
                catch (OutOfMemoryError outOfMemoryError) {
                    this.e();
                    com.corrodinggames.rts.gameFramework.GameEngine.b("Not enough free memory to enable smooth fog fading");
                    System.gc();
                    break;
                }
            }
        }
        this.a();
    }

    public float g() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (l2.cX > 1.0f) {
            return 1.0f;
        }
        return l2.cX;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(float f2) throws IOException {
        float f3;
        float f4;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        TileMap b2 = l2.bL;
        Long l3 = null;
        boolean bl2 = false;
        float f5 = this.g();
        boolean bl3 = false;
        float f6 = f5 / this.m;
        if (com.corrodinggames.rts.gameFramework.GameUtils.c(f6 - 1.0f) < 0.01f) {
            f6 = 1.0f;
        }
        if ((double)f5 > 0.6) {
            float f7 = 0.3f;
            if (com.corrodinggames.rts.gameFramework.GameEngine.av()) {
                f7 = 0.1f;
            }
            if (f5 - this.m > f7) {
                bl3 = true;
            }
            if (f5 == 1.0f && this.m != 1.0f) {
                bl3 = true;
            }
        }
        if (f6 != 1.0f) {
            int n2 = 10;
            f4 = 0.03f;
            f3 = 0.03f;
            if (f5 < 0.3f) {
                n2 = 20;
                f4 = 0.09f;
            } else if (f5 < 0.5f) {
                n2 = 20;
                f4 = 0.07f;
            }
            if (f5 > 1.3f) {
                n2 = 7;
            }
            if (!com.corrodinggames.rts.gameFramework.GameEngine.av()) {
                n2 += 10;
            }
            if (com.corrodinggames.rts.gameFramework.GameUtils.c(b2.aj - f5) > f3) {
                b2.aj = l2.cX;
                b2.ak = 0;
            } else {
                ++b2.ak;
            }
            if (b2.ak < 3) {
                b2.ai = 0.0f;
            } else if (com.corrodinggames.rts.gameFramework.GameUtils.c(f5 - this.m) > f4) {
                b2.ai += 1.0f;
            }
            if (b2.ai > (float)n2) {
                b2.ai = 0.0f;
                bl3 = true;
            }
        }
        if ((float)l2.cu + l2.screenHeight + 4.0f > (float)(this.f + this.a * this.k)) {
            this.f += this.k;
            this.b(1);
        }
        if (l2.cu - 1 < this.f) {
            this.f -= this.k;
            this.b(-1);
        }
        if ((float)l2.cv + l2.uiScale + 4.0f > (float)(this.g + this.a * this.k)) {
            this.g += this.k;
            this.a(1);
        }
        if (l2.cv - 1 < this.g) {
            this.g -= this.k;
            this.a(-1);
        }
        if ((float)l2.cu + l2.screenHeight + 4.0f > (float)(this.f + this.a * this.k)) {
            bl3 = true;
        }
        if (l2.cu - 1 < this.f) {
            bl3 = true;
        }
        if ((float)l2.cv + l2.uiScale + 4.0f > (float)(this.g + this.a * this.k)) {
            bl3 = true;
        }
        if (l2.cv - 1 < this.g) {
            bl3 = true;
        }
        if (bl3) {
            this.a();
        }
        if (com.corrodinggames.rts.gameFramework.GameUtils.c((f6 = l2.cX / this.m) - 1.0f) < 1.0E-4f) {
            f6 = 1.0f;
        }
        float f8 = l2.cameraShakeX / f6 + 2.0f;
        f4 = l2.cameraShakeIntensity / f6 + 2.0f;
        if (f6 != 1.0f) {
            l2.bO.k();
            l2.bO.a(f6, f6);
            b2.ao.a(l2.cameraBoundsEnabled);
            b2.ao.c = (int)((float)b2.ao.left + (float)b2.ao.b() / f6) + 2;
            b2.ao.d = (int)((float)b2.ao.top + (float)b2.ao.c() / f6) + 2;
            l2.bO.a(b2.ao);
        }
        f3 = ((float)this.f - l2.cw) * this.m;
        float f9 = ((float)this.g - l2.cx) * this.m;
        float f10 = (int)f3;
        float f11 = (int)f9;
        int n3 = 0;
        boolean bl4 = false;
        if (com.corrodinggames.rts.gameFramework.GameEngine.av() && (double)l2.cX < 0.3) {
            bl4 = true;
        }
        this.e.a(bl4);
        this.e.d(bl4);
        this.e.b(bl4);
        boolean bl5 = false;
        try {
            for (int i2 = 0; i2 < this.a; ++i2) {
                for (int i3 = 0; i3 < this.a; ++i3) {
                    int n4;
                    LayerBufferCell d2 = this.d[i2][i3];
                    int n5 = (int)(f10 + (float)(i2 * this.k) * this.m);
                    int n6 = (int)(f11 + (float)(i3 * this.k) * this.m);
                    if (d2.l && !this.n) {
                        ++d2.m;
                    }
                    d2.p.a(n5 + 1, n6 + 1, n5 + this.h - 2, n6 + this.h - 2);
                    if (!((float)d2.p.left <= f8) || !((float)d2.p.top <= f4)) continue;
                    if ((float)d2.p.c > f8) {
                        d2.p.c = (int)f8;
                    }
                    if ((float)d2.p.d > f4) {
                        d2.p.d = (int)f4;
                    }
                    int n7 = (int)((0.0f - l2.cw) * this.m);
                    int n8 = (int)((0.0f - l2.cx) * this.m);
                    int n9 = (int)((b2.i() - l2.cw) * this.m);
                    int n10 = (int)((b2.j() - l2.cx) * this.m);
                    if (d2.p.left < n7) {
                        d2.p.left = n7;
                    }
                    if (d2.p.top < n8) {
                        d2.p.top = n8;
                    }
                    if (d2.p.c > n9) {
                        d2.p.c = n9;
                    }
                    if (d2.p.d > n10) {
                        d2.p.d = n10;
                    }
                    if (d2.p.a()) continue;
                    boolean bl6 = false;
                    boolean bl7 = true;
                    if (d2.k) {
                        bl6 = true;
                        bl7 = false;
                    }
                    if (d2.l) {
                        n4 = 10;
                        if (n3 > 3) {
                            n4 += 2;
                        }
                        if (n3 > 6) {
                            n4 += 2;
                        }
                        if (d2.m > n4) {
                            d2.m = 0;
                            bl6 = true;
                            ++n3;
                        }
                    }
                    if (bl6) {
                        bl2 = true;
                        n4 = 0;
                        long l4 = PerformanceProfiler.a();
                        if (l3 == null) {
                            l3 = l4;
                        } else {
                            int n11 = 200;
                            if (this.n) {
                                n11 = 30;
                            }
                            if (PerformanceProfiler.a(l3, l4) > (double)n11) {
                                n4 = 1;
                                this.n = true;
                            }
                        }
                        if (n4 != 0 && d2.k && !d2.n) {
                            this.b(i2, i3);
                        }
                        if (n4 == 0) {
                            if (com.corrodinggames.rts.game.b.TileMap.I) {
                                if (d2.e != null && d2.e.p != d2.d.p) {
                                    com.corrodinggames.rts.gameFramework.GameEngine.log("wrong sized fadeOutBitmap width:" + d2.e.p + " vs " + d2.d.p);
                                    d2.e.o();
                                    d2.e = null;
                                }
                                if (d2.e == null) {
                                    try {
                                        d2.a();
                                    }
                                    catch (OutOfMemoryError outOfMemoryError) {
                                        outOfMemoryError.printStackTrace();
                                        com.corrodinggames.rts.gameFramework.GameEngine.a(AssetType.gameImageCreate, (Throwable)outOfMemoryError);
                                        this.e();
                                        com.corrodinggames.rts.gameFramework.GameEngine.b("Not enough free memory to keep smooth fog fading");
                                        System.gc();
                                    }
                                    if (com.corrodinggames.rts.game.b.TileMap.I && d2.e == null) {
                                        l2.i("Disabling smooth fog fading due to error");
                                        this.e();
                                        com.corrodinggames.rts.gameFramework.GameEngine.b("fadeOutBitmap == null");
                                        System.gc();
                                    }
                                }
                            }
                            if (com.corrodinggames.rts.game.b.TileMap.I) {
                                if (d2.g > 0.0f) {
                                    // empty if block
                                }
                                com.corrodinggames.rts.gameFramework.m.Texture_M e2 = d2.d;
                                d2.d = d2.e;
                                d2.e = e2;
                                y y2 = d2.a;
                                d2.a = d2.f;
                                d2.f = y2;
                                d2.g = bl7 ? 1.0f : 0.0f;
                            } else {
                                d2.g = 0.0f;
                            }
                            if (com.corrodinggames.rts.gameFramework.GameEngine.at() && !bl5) {
                                com.corrodinggames.rts.game.b.TileMap.a();
                                bl5 = true;
                            }
                            l2.bO.i();
                            this.c(i2, i3);
                            l2.bO.j();
                            if (com.corrodinggames.rts.game.b.TileMap.a) {
                                PerformanceProfiler.a("re-drawTile", l4);
                            }
                        }
                    }
                    d2.o.a(d2.p);
                    d2.o.a(-n5, -n6);
                    d2.q.a(d2.p);
                    d2.q.a(-f10, -f11);
                    d2.q.a(f3, f9);
                    if (d2.g > 0.0f) {
                        d2.h.a(bl4);
                        d2.h.c((int)((1.0f - d2.g) * 255.0f));
                        l2.bO.a(d2.e, d2.o, d2.q, (Paint)this.e);
                        if ((double)d2.g < 0.98) {
                            l2.bO.a(d2.d, d2.o, d2.q, d2.h);
                        }
                        d2.g -= 0.1f * f2;
                        continue;
                    }
                    if (d2.d.A()) {
                        l2.bO.a(d2.d, d2.q, (Paint)this.e, 0.0f, 0.0f, 0, 0);
                        continue;
                    }
                    l2.bO.a(d2.d, d2.o, d2.q, (Paint)this.e);
                }
            }
        }
        finally {
            if (bl5) {
                com.corrodinggames.rts.game.b.TileMap.b();
            }
        }
        if (f6 != 1.0f) {
            l2.bO.l();
        }
        if (!bl2) {
            this.n = false;
        }
    }
}

