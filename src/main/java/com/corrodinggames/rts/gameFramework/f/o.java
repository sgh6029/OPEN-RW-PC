/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.effect.a;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.f.o$1;
import com.corrodinggames.rts.gameFramework.f.p;
import com.corrodinggames.rts.gameFramework.f.q;
import com.corrodinggames.rts.gameFramework.f.r;
import com.corrodinggames.rts.gameFramework.f.s;
import com.corrodinggames.rts.gameFramework.f.t;
import com.corrodinggames.rts.gameFramework.f.u;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.m.m;
import com.corrodinggames.rts.gameFramework.m.y;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.Rect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class o {
    float a;
    float b;
    public float c = 120.0f;
    public float d = 120.0f;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public float i;
    public float j;
    int k;
    int l;
    boolean m;
    final Paint n = new Paint();
    final Paint o = new Paint();
    final Paint p = new Paint();
    float q = 0.0f;
    float r = 0.0f;
    final Paint s = new ag();
    final Paint t = new Paint();
    final Paint u = new Paint();
    final Paint v = new Paint();
    public final Rect w = new Rect();
    final Paint x = new ag();
    final Paint y = new ag();
    final Paint z = new ag();
    final Paint A = new ag();
    final Paint B = new ag();
    final Paint C = new ag();
    final Paint D = new ag();
    final Rect E = new Rect();
    Texture_M F;
    y G;
    Texture_M H;
    y I;
    public Texture_M J;
    y K;
    float L = 0.0f;
    float M;
    float N;
    public boolean O = false;
    public boolean P = false;
    public float Q = 0.0f;
    int R = 30;
    int S = -1;
    public Texture_M T;
    public Texture_M U;
    final Rect V = new Rect();
    ag[] W;
    ag X;
    float Y;
    public final ArrayList<q> Z = new ArrayList<q>();
    public final ArrayList aa = new ArrayList();
    private final ArrayList ag = new ArrayList();
    Rect ab = new Rect();
    static ArrayList<s> ac = new ArrayList();
    Point ad = new Point();
    m ae = new o$1(this);
    ArrayList af = new ArrayList();

    public void a(int n2, int n3, float f2, BaseUnit am2) {
        boolean bl2 = am2 != null && am2.bI();
        for (q q2 : this.Z) {
            if (q2.a != bl2 || com.corrodinggames.rts.gameFramework.GameUtils.d(n2 - q2.b) >= 40 || com.corrodinggames.rts.gameFramework.GameUtils.d(n3 - q2.c) >= 40) continue;
            q2.d += f2;
            return;
        }
        q q3 = new q(this, f2, n2, n3, bl2);
        this.Z.add(q3);
    }

    public void a(Context context) {
        this.o.a(Paint$Style.b);
        this.o.a(1.0f);
        this.s.a(255, 255, 255, 255);
        this.s.a(Paint$Style.b);
        this.s.a(1.0f);
        this.W = new ag[11];
        for (int i2 = 0; i2 <= 10; ++i2) {
            this.W[i2] = new ag();
            this.W[i2].b(-16777216);
            this.W[i2].a(Paint$Style.a);
            this.W[i2].c(i2 * 25);
        }
        this.X = new ag();
        this.X.b(-16777216);
        this.X.a(Paint$Style.a);
        this.t.a(255, 255, 0, 0);
        this.t.a(Paint$Style.b);
        this.t.a(2.0f);
        this.u.a(155, 255, 0, 0);
        this.u.a(Paint$Style.b);
        this.u.a(2.0f);
        this.v.a(200, 12, 227, 219);
        this.v.a(Paint$Style.b);
        this.v.a(2.0f);
        this.x.b(-16711936);
        this.y.b(-256);
        this.z.b(-65536);
        this.A.b(com.corrodinggames.rts.gameFramework.f.o.a(this.x.e()));
        this.B.b(com.corrodinggames.rts.gameFramework.f.o.a(this.y.e()));
        this.C.b(com.corrodinggames.rts.gameFramework.f.o.a(this.z.e()));
        this.D.a(210, 255, 255, 255);
    }

    public static int a(int n2) {
        int n3 = Color.a(Color.a(n2), (int)((float)Color.b(n2) * 0.5f), (int)((float)Color.c(n2) * 0.5f), (int)((float)Color.d(n2) * 0.5f));
        return n3;
    }

    public void a() {
        GameEngine l2 = GameEngine.getInstance();
        if (!com.corrodinggames.rts.gameFramework.f.g.bR) {
            this.a = (int)(l2.cl - (this.c + 0.0f));
            this.b = 0.0f;
        } else {
            this.a = 0.0f;
            this.b = (int)(l2.cm - (this.d + 0.0f));
        }
    }

    public int b() {
        return (int)(this.b + this.d);
    }

    public void a(TileMap b2, boolean bl2) {
        this.af.clear();
        if (bl2) {
            this.m = true;
            return;
        }
        this.g = 1;
        this.h = 1;
        this.i = 1.0f;
        this.j = 1.0f;
        this.f = false;
        this.e = false;
    }

    public void c() {
        if (this.J != null) {
            this.J.o();
            this.J = null;
        }
        if (this.F != null) {
            this.F.o();
            this.F = null;
        }
        if (this.T != null) {
            this.T.o();
            this.T = null;
        }
        if (this.U != null) {
            this.U.o();
            this.U = null;
        }
        if (this.I != null) {
            this.I.q();
            this.I = null;
        }
        if (this.H != null) {
            this.H.o();
            this.H = null;
        }
        this.K = null;
        this.e = false;
    }

    public float d() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.cq;
    }

    public void e() {
        GameEngine l2 = GameEngine.getInstance();
        this.f();
        com.corrodinggames.rts.gameFramework.GameEngine.log("Creating minimap image buffers..");
        if (this.F == null) {
            this.F = l2.bO.a((int)this.c, (int)this.d, false);
            this.G = l2.bO.b(this.F);
        }
        if (this.J == null) {
            this.J = l2.bO.a((int)this.c, (int)this.d, false);
            this.K = l2.bO.b(this.J);
        }
        if (this.H == null) {
            this.H = l2.bO.a((int)this.c, (int)this.d, false);
            this.I = l2.bO.b(this.H);
        }
    }

    public void f() {
        this.d = this.c = this.d();
        this.a();
    }

    public void g() {
        boolean bl2 = true;
        long l2 = PerformanceProfiler.a();
        com.corrodinggames.rts.gameFramework.GameEngine.log("--setting up minimap--");
        GameEngine l3 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        this.f();
        this.g = l3.bL.C * l3.bL.n;
        this.h = l3.bL.D * l3.bL.o;
        if (this.g <= 0) {
            this.g = 1;
        }
        if (this.h <= 0) {
            this.h = 1;
        }
        this.i = 1.0f / (float)this.g;
        this.j = 1.0f / (float)this.h;
        this.f = true;
        this.e();
        this.Z.clear();
        this.aa.clear();
        this.ag.clear();
        for (Point point : l3.bL.A) {
            this.ag.add(new t(this, point.x, point.b));
        }
        this.G.b(-16777216);
        this.K.b(-16777216);
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
            try {
        if (!bl2) {
            Rect rect = new Rect(0, 0, (int)this.c, (int)this.d);
                l3.bL.u.a(this.G, 0.0f, 0.0f, 0.0f, 0.0f, this.g, this.h, this.c / (float)this.g, this.d / (float)this.h, false, false, false);
            Paint paint = new Paint();
            paint.a(50, 0, 0, 0);
            this.G.b(rect, paint);
        } else {
            int n2 = 2;
            for (int i2 = 0; i2 < n2; ++i2) {
                for (int i3 = 0; i3 < n2; ++i3) {
                    this.I.b(-16777216);
                    int n3 = (int)this.c / n2;
                    int n4 = (int)this.d / n2;
                    int n5 = this.g / n2;
                    int n6 = this.h / n2;
                    l3.bL.u.a(this.I, n5 * i2, n6 * i3, n5 * i2, n6 * i3, n5, n6, this.c / (float)n5, this.d / (float)n6, false, false, false);
                    Rect rect = new Rect(0, 0, (int)this.c, (int)this.d);
                    Rect rect2 = new Rect(n3 * i2, n4 * i3, n3 * (i2 + 1), n4 * (i3 + 1));
                    Paint paint = new Paint();
                    paint.a(true);
                    paint.d(true);
                    paint.b(true);
                    this.K.a(this.H, rect, rect2, paint);
                }
            }
            Rect rect = new Rect(0, 0, (int)this.c, (int)this.d);
            this.G.b(-16777216);
            Paint paint = new Paint();
            paint.a(true);
            paint.d(true);
            paint.b(true);
            paint.a(200, 255, 255, 255);
            this.G.a(this.J, rect, rect, paint);
        }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        this.I.b(-16777216);
        this.K.b(-16777216);
        this.M = 50.0f;
        this.a(0.0f, 1.0f);
        this.e = true;
        double d2 = PerformanceProfiler.a(l2);
        com.corrodinggames.rts.gameFramework.GameEngine.log("Minimap map render took:" + PerformanceProfiler.a(d2));
    }

    void a(float f2, float f3) {
        GameEngine l2 = GameEngine.getInstance();
        this.ab.a(0, (int)(f2 * this.d), (int)this.c, (int)(f3 * this.d));
        try {
            this.I.a(this.F, this.ab, this.ab, null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TileMap b2 = l2.bL;
        if (b2.E) {
            float f4;
            boolean bl2 = b2.G;
            ag ag2 = this.W[5];
            ag ag3 = this.W[10];
            ag ag4 = this.X;
            ag4.c(255);
            if (bl2) {
                ag3 = this.W[7];
                f4 = 1.0f - (1.0f - (float)ag2.f() / 255.0f) * (1.0f - (float)ag3.f() / 255.0f);
                ag4.c((int)(f4 * 255.0f));
            }
            f4 = this.c / (float)b2.C;
            float f5 = this.d / (float)b2.D;
            int n2 = 0;
            int n3 = 0;
            int n4 = (int)(f2 * (float)b2.D) - 1;
            int n5 = (int)(f3 * (float)b2.D) + 1;
            if (n4 < 0) {
                n4 = 0;
            }
            if (n5 < 0) {
                n5 = 0;
            }
            if (n4 > l2.bL.D) {
                n4 = b2.D;
            }
            if (n5 > l2.bL.D) {
                n5 = b2.D;
            }
            int n6 = 0;
            byte[][] byArray = l2.bs.N;
            if (byArray != null) {
                int n7 = b2.C;
                Rect rect = this.V;
                for (int i2 = n4; i2 < n5; ++i2) {
                    for (int i3 = 0; i3 < n7; ++i3) {
                        int n8;
                        byte by = byArray[i3][i2];
                        if (by == 0) continue;
                        int n9 = i3;
                        for (n8 = i3; n8 < n7 - 1 && byArray[n8][i2] == by; ++n8) {
                        }
                        i3 = n8;
                        rect.a(n2 + (int)((float)n9 * f4), n3 + (int)((float)i2 * f5), n2 + (int)((float)(n8 + 1) * f4), n3 + (int)((float)(i2 + 1) * f5));
                        ag ag5 = by == 10 ? ag4 : ag2;
                        try {
                            this.I.b(rect, (Paint)ag5);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        if (++n6 <= 2) continue;
                        n6 = 0;
                    }
                }
            }
        }
        try {
            this.K.a(this.H, this.ab, this.ab, null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.J.p();
        if (com.corrodinggames.rts.gameFramework.GameEngine.isPCVersionStatic2) {
            // empty if block
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static s a(int n2, Paint paint) {
        ArrayList <s>arrayList = ac;
        synchronized (arrayList) {
            s s2 = null;
            for (s s3 : ac) {
                if (s3.d < n2 || s2 != null && s3.d >= s2.d) continue;
                s2 = s3;
            }
            if (s2 != null) {
                ac.remove(s2);
                s2.c = paint;
                return s2;
            }
        }
        return new s(n2 + 15, paint);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void a(s s2) {
        s2.c = null;
        s2.b = 0;
        ArrayList arrayList = ac;
        synchronized (arrayList) {
            if (ac.size() < 20) {
                ac.add(s2);
                return;
            }
            Iterator iterator = ac.iterator();
            while (iterator.hasNext()) {
                s s3 = (s)iterator.next();
                if (s3.d >= s2.d) continue;
                iterator.remove();
                ac.add(s2);
                return;
            }
        }
    }

   void a(y var1, int var2, int var3, float var4, float var5) {
      GameEngine var6 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
      boolean var11 = true;
      byte var7;
      byte var8;
      byte var9;
      byte var10;
      byte var24;
      if (this.c < 50.0F) {
         var8 = 0;
         var7 = 0;
         var10 = 1;
         var9 = 1;
         var24 = 1;
      } else if (this.c < 120.0F) {
         var8 = 0;
         var7 = 0;
         var10 = 2;
         var9 = 2;
         var24 = 2;
      } else {
         var8 = -1;
         var7 = -1;
         var10 = 2;
         var9 = 2;
         var24 = 3;
      }

      int var10000 = var7 + var2;
      var10000 = var10 + var2;
      var10000 = var9 + var3;
      var10000 = var8 + var3;
      boolean var12 = false;
      if (var6.bs.b() || var6.cb.j()) {
         var12 = true;
      }

      for(int var13 = -1; var13 < com.corrodinggames.rts.game.PlayerTeam.c; ++var13) {
         PlayerTeam var14 = com.corrodinggames.rts.game.PlayerTeam.k(var13);
         if (var14 != null) {
            Paint var15 = var14.ae;
            if (var6.bQ.useMinimapAllyColors) {
               if (var12) {
                  this.p.b(com.corrodinggames.rts.game.PlayerTeam.i(var14.r));
                  var15 = this.p;
               } else if (var6.bs == var14) {
                  var15 = this.x;
               } else if (var6.bs.d(var14)) {
                  var15 = this.y;
               } else if (var6.bs.c(var14)) {
                  var15 = this.z;
               }
            }

            int var16 = 0;
            int var18;
            int var19;
            if (var14.a(true, false) > 0) {
               BaseUnit[] var17 = BaseUnit.bE.a();
               var18 = 0;

               for(var19 = BaseUnit.bE.size(); var18 < var19; ++var18) {
                  BaseUnit var20 = var17[var18];
                  if (var20.bX == var14 && var20.cR) {
                     ++var16;
                  }
               }
            }

            int var29;
            if (var16 > 0) {
               var15.a((float)var24);
               s var25 = a(var16, var15);
               var25.e = !var6.bQ.renderWithLineWidth;
               BaseUnit[] var27 = BaseUnit.bE.a();
               var19 = 0;

               for(var29 = BaseUnit.bE.size(); var19 < var29; ++var19) {
                  BaseUnit var21 = var27[var19];
                  if (var21.bX == var14 && var21.cR) {
                     var25.a((float)var21.cS, (float)var21.cT);
                  }
               }

               if (var25.b != 0) {
                  var6.bO.a(var25);
               }
            }

            Paint var26 = var14.af;
            if (var6.bQ.useMinimapAllyColors) {
               if (var12) {
                  this.p.b(com.corrodinggames.rts.game.PlayerTeam.i(var14.r));
                  var15 = this.p;
               } else if (var6.bs == var14) {
                  var26 = this.A;
               } else if (var6.bs.d(var14)) {
                  var26 = this.B;
               } else if (var6.bs.c(var14)) {
                  var26 = this.C;
               }
            }

            var18 = 0;
            Object[] var28 = com.corrodinggames.rts.gameFramework.effect.a.w.b();
            var29 = 0;

            int var31;
            for(var31 = com.corrodinggames.rts.gameFramework.effect.a.w.size(); var29 < var31; ++var29) {
               a var22 = (a)var28[var29];
               if (var22.e == var14 && var22.k) {
                  ++var18;
               }
            }

            if (var18 > 0) {
               var26.a((float)var24);
               s var30 = a(var18, var26);
               Object[] var32 = com.corrodinggames.rts.gameFramework.effect.a.w.b();
               var31 = 0;

               for(int var33 = com.corrodinggames.rts.gameFramework.effect.a.w.size(); var31 < var33; ++var31) {
                  a var23 = (a)var32[var31];
                  if (var23.e == var14 && var23.k) {
                     var30.a((float)var23.l, (float)var23.m);
                  }
               }

               if (var30.b != 0) {
                  var6.bO.a(var30);
               }
            }
         }
      }

   }

    public void a(int n2, int n3, r r2) {
        p p2 = new p(this);
        p2.a = n2;
        p2.b = n3;
        p2.e = r2;
        p2.c = 0.9f;
        p2.d = 0.9f;
        this.aa.add(p2);
    }

   public void h() {
      GameEngine var1 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
      this.m = false;
      this.k = (int)this.a;
      this.l = (int)this.b;
      BaseUnit[] var2 = BaseUnit.bE.a();
      int var3 = 0;

      int var4;
      for(var4 = BaseUnit.bE.size(); var3 < var4; ++var3) {
         BaseUnit var5 = var2[var3];
         if (!var5.bV && var5.cN == null && var5.cf() && var5.c_() && !var5.u()) {
            Point var6 = this.b(var5.posX, var5.posY);
            var5.cS = var6.x;
            var5.cT = var6.b;
            var5.cR = true;
         } else {
            var5.cR = false;
         }
      }

      Object[] var8 = com.corrodinggames.rts.gameFramework.effect.a.w.b();
      var4 = 0;

      Point var7;
      for(int var10 = com.corrodinggames.rts.gameFramework.effect.a.w.size(); var4 < var10; ++var4) {
         a var12 = (a)var8[var4];
         if (!var12.n && var12.u) {
            var7 = this.b(var12.g, var12.h);
            var12.l = var7.x;
            var12.m = var7.b;
            var12.k = true;
         }
      }

      PlayerTeam var9 = var1.bs;
      Iterator var11 = this.ag.iterator();

      while(var11.hasNext()) {
         t var13 = (t)var11.next();
         var13.e = false;
         if (var1.bL.a(var9, var13.a, var13.b)) {
            var13.e = true;
            var7 = this.b((float)(var13.a * var1.bL.n), (float)(var13.b * var1.bL.o));
            var13.c = var7.x;
            var13.d = var7.b;
         }
      }

   }

    public void a(float f2) {
        if (com.corrodinggames.rts.gameFramework.GameEngine.isPausedStatic2 && !com.corrodinggames.rts.gameFramework.GameEngine.isAndroidVersionStatic2) {
            return;
        }
        GameEngine l2 = GameEngine.getInstance();
        this.L = com.corrodinggames.rts.gameFramework.GameUtils.a(this.L, f2);
        if (this.L == 0.0f) {
            this.L = 15.0f;
            this.h();
        }
        this.Y += f2;
        if (this.Y > 15.0f) {
            Object object = null;
            for (Object object2 : this.Z) {
                if (((q)object2).e != 0.0f) {
                    ((q)object2).d = 0.0f;
                } else if (((q)object2).d > 15.0f) {
                    ((q)object2).d = 0.0f;
                    ((q)object2).e = 300.0f;
                    p p2 = new p(this);
                    p2.a = ((q)object2).b;
                    p2.b = ((q)object2).c;
                    if (((q)object2).a) {
                        p2.e = com.corrodinggames.rts.gameFramework.f.r.base;
                    } else {
                        p2.e = com.corrodinggames.rts.gameFramework.f.r.unit;
                        p2.c = 0.4f;
                        p2.d = 0.8f;
                    }
                    this.aa.add(p2);
                }
                ((q)object2).d = com.corrodinggames.rts.gameFramework.GameUtils.a(((q)object2).d, 2.0f * this.Y);
                ((q)object2).e = com.corrodinggames.rts.gameFramework.GameUtils.a(((q)object2).e, this.Y);
                if (((q)object2).d != 0.0f || ((q)object2).e != 0.0f) continue;
                object = object2;
            }
            if (object != null) {
                this.Z.remove(object);
            }
            for (Object object2 : this.aa) {
                if (((p)object2).e == com.corrodinggames.rts.gameFramework.f.r.message || !l2.cQ.b(((p)object2).a, ((p)object2).b)) continue;
                ((p)object2).c = 0.0f;
                ((p)object2).d = 0.0f;
            }
            this.Y = 0.0f;
        }
    }

    public float b(float f2) {
        return f2 * this.i * this.c;
    }

    public Point b(float f2, float f3) {
        if (!this.f) {
            this.ad.a(-1, -1);
            return this.ad;
        }
        int n2 = (int)(f2 * this.i * this.c + this.a);
        int n3 = (int)(f3 * this.j * this.d + this.b);
        this.ad.a(n2, n3);
        return this.ad;
    }

    public Point c(float f2, float f3) {
        if (f2 < this.a || f3 < this.b || f2 > this.a + this.c || f3 > this.b + this.d) {
            return null;
        }
        int n2 = (int)((f2 - this.a) / this.c * (float)this.g);
        int n3 = (int)((f3 - this.b) / this.d * (float)this.h);
        this.ad.a(n2, n3);
        return this.ad;
    }

    public float c(float f2) {
        if (f2 < this.a) {
            return this.a;
        }
        if (f2 > this.a + this.c) {
            return this.a + this.c;
        }
        return f2;
    }

    public float d(float f2) {
        if (f2 < this.b) {
            return this.b;
        }
        if (f2 > this.b + this.d) {
            return this.b + this.d;
        }
        return f2;
    }

    public void e(float f2) {
        float f3;
        Point point;
        Object object;
        GameEngine l2 = GameEngine.getInstance();
        y y2 = l2.bO;
        this.a();
        if (this.J != null && !com.corrodinggames.rts.gameFramework.GameUtils.e(this.c, this.d(), 5.0f)) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("minimap", "minimap size has changed, reseting");
            this.c();
        }
        if (!this.e || this.J == null) {
            this.g();
        }
        if (this.k != (int)this.a || this.l != (int)this.b || this.m) {
            this.h();
        }
        if (l2.bL.E) {
            if (this.O && !this.P) {
                this.M = com.corrodinggames.rts.gameFramework.GameUtils.a(this.M, 1.0f);
                if (this.M == 0.0f) {
                    this.M = 40.0f;
                    this.O = false;
                    this.Q = 0.0f;
                    this.P = true;
                }
            }
            if (this.P) {
                this.N = com.corrodinggames.rts.gameFramework.GameUtils.a(this.N, 1.0f);
                if (this.N == 0.0f) {
                    this.N = 3.0f;
                    if (this.J != null) {
                        float f4 = this.Q - 0.005f;
                        this.Q = (float)((double)this.Q + 0.04);
                        if (f4 < 0.0f) {
                            f4 = 0.0f;
                        }
                        if (this.Q >= 1.0f) {
                            this.Q = 1.0f;
                            this.P = false;
                        }
                        this.a(f4, this.Q);
                    }
                }
            }
        }
        try {
            y2.b(this.J, this.a, this.b, this.n);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        this.w.a((int)this.a, (int)this.b, (int)(this.a + this.c), (int)((double)(this.b + this.d) - 0.4));
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        Object[] objectArray = com.corrodinggames.rts.game.f.a.a();
        int n2 = com.corrodinggames.rts.game.f.a.a;
        for (int i2 = 0; i2 < n2; ++i2) {
            object = (com.corrodinggames.rts.game.f)objectArray[i2];
            if (!((com.corrodinggames.rts.game.f)object).D) continue;
            bl4 = true;
            bl3 = true;
        }
        for (p p2 : ((ArrayList<p>)this.aa) ){
            if (p2.e == com.corrodinggames.rts.gameFramework.f.r.unit) continue;
            bl2 = true;
            if (p2.e == com.corrodinggames.rts.gameFramework.f.r.message) continue;
            bl3 = true;
        }
        if (!bl2 && !bl4) {
            this.o.a(255, 100, 100, 100);
            this.o.a(1.0f);
            if (com.corrodinggames.rts.gameFramework.f.g.bO) {
                this.o.a(115, 0, 0, 0);
                this.o.a(2.0f);
            }
        } else {
            this.q += 5.0f * f2;
            if (this.q > 180.0f) {
                this.q -= 180.0f;
            }
            float f5 = com.corrodinggames.rts.gameFramework.GameUtils.j(this.q);
            if (bl4) {
                this.o.a(255, 0, (int)(0.0f + f5 * 230.0f), 0);
            } else if (!bl3) {
                this.o.a(255, 12, (int)(0.0f + f5 * 220.0f), (int)(0.0f + f5 * 220.0f));
            } else {
                this.o.a(255, (int)(0.0f + f5 * 230.0f), 0, 0);
            }
            this.o.a(2.0f);
        }
        try {
            y2.b(this.w, this.o);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        for (t t2 : ((ArrayList<t>)this.ag) ){
            if (!t2.e) continue;
            this.V.a(t2.c, t2.d, t2.c + 2, t2.d + 2);
            try {
                y2.b(this.V, this.D);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        this.a(y2, 0, 0, 0.0f, 1.0f);
        if (this.af.size() != 0) {
            Iterator iterator = this.af.iterator();
            while (iterator.hasNext()) {
                u u2 = (u)iterator.next();
                if (u2.a.bV) {
                    iterator.remove();
                    continue;
                }
                object = u2.a;
                point = this.b(((BaseUnit)object).posX, ((BaseUnit)object).posY);
                if (((BaseUnit)object).a(point.x, point.b)) continue;
                try {
                    y2.a((float)point.x, (float)point.b, 4.0f, ((BaseUnit)object).bX.ae);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
        n2 = com.corrodinggames.rts.game.f.a.a;
        for (int i3 = 0; i3 < n2; ++i3) {
            object = (com.corrodinggames.rts.game.f)objectArray[i3];
            if (!((com.corrodinggames.rts.game.f)object).D && (((com.corrodinggames.rts.game.f)object).q == null || !((com.corrodinggames.rts.game.f)object).q.D) || ((com.corrodinggames.rts.game.f)object).j == null) continue;
            point = this.b(((com.corrodinggames.rts.game.f)object).posX, ((com.corrodinggames.rts.game.f)object).posY);
            f3 = 2.0f;
            if (((com.corrodinggames.rts.game.f)object).D) {
                f3 = 4.0f;
            }
            try {
                y2.a((float)point.x, (float)point.b, f3, ((com.corrodinggames.rts.game.f)object).j.bX.ae);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        Object object2 = this.b(l2.cw, l2.cx);
        this.E.left = ((Point)object2).x;
        this.E.top = ((Point)object2).b;
        object2 = this.b(l2.cw + l2.screenHeight, l2.cx + l2.uiScale);
        this.E.c = ((Point)object2).x;
        this.E.d = ((Point)object2).b;
        if (this.E.left < this.w.left) {
            this.E.left = this.w.left;
        }
        if (this.E.c > this.w.c) {
            this.E.c = this.w.c;
        }
        if (this.E.top < this.w.top) {
            this.E.top = this.w.top;
        }
        if (this.E.d > this.w.d) {
            this.E.d = this.w.d;
        }
        try {
            y2.b(this.E, this.s);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        this.r += 6.0f * f2;
        if (this.r > 180.0f) {
            this.r -= 180.0f;
        }
        object2 = this.aa.iterator();
        while (((Iterator) object2).hasNext()) {
            float f6;
            Paint paint;
            p p3 = (p)((Iterator) object2).next();
            object = this.b(p3.a, p3.b);
            float f7 = p3.c;
            f3 = 0.05f;
            if (p3.e == com.corrodinggames.rts.gameFramework.f.r.unit) {
                paint = this.u;
                f3 = 0.03f;
                f6 = com.corrodinggames.rts.gameFramework.GameUtils.j(this.r);
                paint.a((int)(50.0f + f6 * 190.0f), (int)(50.0f + f6 * 190.0f), 0, 0);
            } else if (p3.e == com.corrodinggames.rts.gameFramework.f.r.message) {
                paint = this.v;
            } else {
                paint = this.t;
                f6 = com.corrodinggames.rts.gameFramework.GameUtils.j(this.r);
                paint.a((int)(50.0f + f6 * 190.0f), (int)(50.0f + f6 * 190.0f), 0, 0);
            }
            f7 = com.corrodinggames.rts.gameFramework.GameUtils.b(f7, f3, 1.0f);
                try {
            if (p3.e == com.corrodinggames.rts.gameFramework.f.r.unit) {
                f6 = this.c * f7;
                float f8 = this.d * f7;
                y2.a(this.c((float)((Point)object).x - f6), this.d((float)((Point)object).b - f8), this.c((float)((Point)object).x + f6), this.d((float)((Point)object).b + f8), paint);
                y2.a(this.c((float)((Point)object).x + f6), this.d((float)((Point)object).b - f8), this.c((float)((Point)object).x - f6), this.d((float)((Point)object).b + f8), paint);
            } else {
                y2.a(this.c((float)((Point)object).x - this.c * f7), this.d(((Point)object).b), this.c((float)((Point)object).x + this.c * f7), this.d(((Point)object).b), paint);
                    y2.a(this.c(((Point)object).x), this.d((float)((Point)object).b - this.d * f7), this.c(((Point)object).x), this.d((float)((Point)object).b + this.d * f7), paint);
            }
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            p3.c = com.corrodinggames.rts.gameFramework.GameUtils.a(p3.c, 0.04f * f2);
            if (p3.c != 0.0f) continue;
            p3.d = com.corrodinggames.rts.gameFramework.GameUtils.a(p3.d, 0.005f * f2);
            if (p3.d != 0.0f) continue;
            ((Iterator) object2).remove();
        }
    }

    public void a(BaseUnit am2) {
        if (this.af.contains(am2)) {
            return;
        }
        u u2 = new u(this);
        u2.a = am2;
        this.af.add(u2);
    }
}

