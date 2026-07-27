/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.gameFramework.Point2i;
import com.corrodinggames.rts.gameFramework.IntLookupTable;
import com.corrodinggames.rts.gameFramework.StatisticType;
import com.corrodinggames.rts.gameFramework.TeamStatistics;
import com.corrodinggames.rts.gameFramework.TeamHistory;
import com.corrodinggames.rts.gameFramework.StatisticsData;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.f.aa;
import com.corrodinggames.rts.gameFramework.f.ab;
import com.corrodinggames.rts.gameFramework.f.ac;
import com.corrodinggames.rts.gameFramework.f.ad;
import com.corrodinggames.rts.gameFramework.f.e;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.f.i;
import com.corrodinggames.rts.gameFramework.f.z;
import com.corrodinggames.rts.gameFramework.h.a;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ag;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Paint$Cap;
import android.graphics.Rect;
import android.graphics.Typeface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class y {
    private ArrayList<e> e;
    private ac f = ac.overallStats;
    private z g = z.a;
    private ArrayList<aa> h = new ArrayList();
    private ab[] i = new ab[StatisticType.values().length];
    private ArrayList<aa> j = new ArrayList();
    private ab[] k = new ab[StatisticType.values().length];
    private ArrayList<aa> l;
    private ab[] m;
    aa a;
    private long n;
    private com.corrodinggames.rts.gameFramework.m.Texture_M o;
    private com.corrodinggames.rts.gameFramework.m.Texture_M[] p;
    private Rect q;
    private Rect r;
    private ArrayList<String> s = new ArrayList<String>();
    private ArrayList t = new ArrayList();
    private int u = -1;
    private int v = -1;
    private int w = -1;
    Rect b = new Rect();
    Paint c;
    Paint d;

    public static y a() {
        GameEngine l2 = GameEngine.getInstance();
        ArrayList arrayList = l2.bY.d();
        ArrayList arrayList2 = com.corrodinggames.rts.gameFramework.f.e.a();
        return new y(arrayList, arrayList2);
    }
   private y(ArrayList var1, ArrayList var2) {
      this.f = ac.overallStats;
      this.g = z.a;
      this.h = new ArrayList<aa>();
      this.i = new ab[StatisticType.values().length];
      this.j = new ArrayList<aa>();
      this.k = new ab[StatisticType.values().length];
      this.s = new ArrayList<String>();
      this.t = new ArrayList();
      this.u = -1;
      this.v = -1;
      this.w = -1;
      this.b = new Rect();
      this.e = var2;
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         StatisticsData var4 = (StatisticsData)var3.next();
         PlayerTeam var5 = com.corrodinggames.rts.game.PlayerTeam.k(var4.l.b());
         this.h.add(new aa(var4.l, var5.v, var5.K()));
      }

      ArrayList var10 = com.corrodinggames.rts.game.PlayerTeam.f();
      Iterator var11 = var10.iterator();

      while(var11.hasNext()) {
         Integer var13 = (Integer)var11.next();
         ArrayList var6 = new ArrayList();
         Iterator var7 = var1.iterator();

         while(var7.hasNext()) {
            StatisticsData var8 = (StatisticsData)var7.next();
            PlayerTeam var9 = com.corrodinggames.rts.game.PlayerTeam.k(var8.l.b());
            if (var9.r == var13) {
               var6.add(var8);
            }
         }

         if (!var6.isEmpty()) {
            TeamStatistics var16 = new TeamStatistics(var6);
            this.j.add(new aa(var16.l, "Team " + com.corrodinggames.rts.game.PlayerTeam.a(var13), com.corrodinggames.rts.game.PlayerTeam.i(var13)));
         }
      }

      StatisticType[] var12 = StatisticType.values();
      int var14 = var12.length;

      for(int var15 = 0; var15 < var14; ++var15) {
         StatisticType var17 = var12[var15];
         this.i[var17.ordinal()] = new ab(var17, this.h);
         this.k[var17.ordinal()] = new ab(var17, this.j);
      }

      this.l = this.h;
      this.m = this.i;
      this.b();
   }

    public void b() {
        this.f = ac.overallStats;
        GameEngine l2 = GameEngine.getInstance();
        this.c = new Paint();
        this.c.a(true);
        this.c.a(Paint$Align.a);
        this.c.a(255, 0, 255, 0);
        l2.b(this.c, 16.0f);
        this.d = new Paint();
        this.d.a(true);
        this.d.a(Paint$Align.c);
        this.d.a(255, 0, 255, 0);
        l2.b(this.d, 16.0f);
        this.c();
    }

    private void c() {
        GameEngine l2 = GameEngine.getInstance();
        this.p = new com.corrodinggames.rts.gameFramework.m.Texture_M[ac.values().length + 2];
        this.p[0] = l2.bO.a(com.corrodinggames.rts.R.drawable.stats_button_info);
        this.p[1] = l2.bO.a(com.corrodinggames.rts.R.drawable.stats_button_income);
        this.p[2] = l2.bO.a(com.corrodinggames.rts.R.drawable.stats_button_armyvalue);
        this.p[3] = l2.bO.a(com.corrodinggames.rts.R.drawable.stats_button_buildingvalue);
        this.p[4] = l2.bO.a(com.corrodinggames.rts.R.drawable.stats_button_totalvalue);
        this.p[5] = l2.bO.a(com.corrodinggames.rts.R.drawable.stats_toggle_relative);
        this.p[6] = l2.bO.a(com.corrodinggames.rts.R.drawable.stats_toggle_teams);
        this.r = new Rect(0, 0, this.p[0].m(), this.p[0].l());
    }

    public void a(Rect rect, Rect rect2, float f2, boolean bl2, boolean bl3) {
                try {
        GameEngine l2 = GameEngine.getInstance();
        g g2 = l2.bS;
        boolean bl4 = true;
        if (bl3) {
            Paint paint;
            Object object;
            int n2;
            int n3 = ac.values().length;
            int n4 = l2.a(30);
            int n5 = n4 * 2;
            int n6 = l2.a(20);
            int n7 = rect2.d - n4 - n6;
            int n8 = 2;
            int n9 = n3;
            n9 = g2.c ? (n9 += n8) : --n9;
            int n10 = n5 * n9 + n6 * (n9 - 1);
            int n11 = (int)(l2.cameraShakeX / 2.0f - (float)(n10 / 2));
            Paint paint2 = new Paint();
            Paint paint3 = new Paint();
            paint3.a(100, 255, 255, 255);
            for (n2 = 0; n2 < n3; ++n2) {
                object = ac.values()[n2];
                if (!g2.c && object == ac.overallStats) continue;
                if (g2.a(n11, n7, n5, n4, com.corrodinggames.rts.gameFramework.f.i.none, false)) {
                    if (this.f != object) {
                        this.f = (ac) object;
                        this.n = System.currentTimeMillis();
                        this.u = -1;
                        this.v = -1;
                        this.w = -1;
                    }
                    if (this.f != ac.overallStats) {
                        g2.c = true;
                    }
                }
                this.b.a(n11, n7, n11 + n5, n7 + n4);
                l2.bO.a(l2.bS.bn, this.r, this.b, paint2);
                paint = paint3;
                if (!g2.c || this.f == object) {
                    paint = paint2;
                }
                l2.bO.a(this.p[n2], this.r, this.b, paint);
                n11 += n6 + n5;
            }
            n11 += n6;
            if (g2.c) {
                int n12 = n2 = this.g != z.a ? 1 : 0;
                if (g2.a(n11, n7, n5, n4, com.corrodinggames.rts.gameFramework.f.i.none, false)) {
                    this.g = n2 == 0 ? z.b : z.a;
                    this.n = System.currentTimeMillis();
                }
                this.b.a(n11, n7, n11 + n5, n7 + n4);
                object = paint2;
                if (this.f == ac.overallStats) {
                    object = paint3;
                }
                l2.bO.a(l2.bS.bn, this.r, this.b, (Paint)object);
                paint = paint2;
                if (n2 == 0 || this.f == ac.overallStats) {
                    paint = paint3;
                }
                l2.bO.a(this.p[5], this.r, this.b, paint);
                int n13 = n2 = this.l == this.j ? 1 : 0;
                if (g2.a(n11 += n6 + n5, n7, n5, n4, com.corrodinggames.rts.gameFramework.f.i.none, false)) {
                    if (n2 == 0) {
                        this.l = this.j;
                        this.m = this.k;
                    } else {
                        this.l = this.h;
                        this.m = this.i;
                    }
                    this.n = System.currentTimeMillis();
                }
                this.b.a(n11, n7, n11 + n5, n7 + n4);
                object = paint2;
                if (this.f == ac.overallStats) {
                    object = paint3;
                }
                l2.bO.a(l2.bS.bn, this.r, this.b, (Paint)object);
                paint = paint2;
                if (n2 == 0 || this.f == ac.overallStats) {
                    paint = paint3;
                }
                    l2.bO.a(this.p[6], this.r, this.b, paint);
                n11 += n6 + n5;
            }
            if (this.f == ac.overallStats) {
                bl4 = true;
            } else {
                bl4 = false;
                rect.d = n7 - l2.a(10);
                if (bl2) {
                    this.a(this.f.a(), this.g, rect);
                }
            }
        }
        if (bl4) {
            this.a(rect, f2);
        }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
    }

    private void a(Rect rect, float f2) {
            try {
        GameEngine l2 = GameEngine.getInstance();
        float f3 = 1.5f;
        int n2 = rect.top + l2.a(25);
        int n3 = rect.d();
        String string2 = "123|";
        this.c.a(string2, 0, string2.length(), this.b);
        float f4 = this.b.c() + 6;
        for (e e2 : this.e) {
            if (e2.d != 1.0f && f3 > 0.0f) {
                e2.d = com.corrodinggames.rts.gameFramework.GameUtils.a(e2.d, 1.0f, 0.01f * f3 * f2);
                f3 -= 1.0f - e2.d;
            }
            float f5 = e2.d;
            f5 = com.corrodinggames.rts.gameFramework.GameUtils.b(f5, 0.0f, 1.0f);
            String string3 = "";
            if (e2.b != null) {
                string3 = e2.b;
            } else {
                string3 = "" + (int)(e2.c * f5);
                if (f5 <= 0.0f) {
                    string3 = " ";
                }
            }
            String string4 = e2.a;
            float f6 = e2.d * 2.2f;
            f6 = com.corrodinggames.rts.gameFramework.GameUtils.b(f6, 0.0f, 1.0f);
            int n4 = 0;
            if (f6 > 0.0f) {
                n4 = (int)((float)string4.length() * f6);
            }
            n4 = com.corrodinggames.rts.gameFramework.GameUtils.b(n4, 0, string4.length());
            String string5 = "";
            if (n4 > 0 && n4 < string4.length() - 1) {
                string5 = "_";
            }
            string4 = string4.substring(0, n4) + string5 + com.corrodinggames.rts.gameFramework.GameUtils.d(" ", string4.length() + string5.length() - n4);
                l2.bO.a(string4, (float)n3 - 8.0f * this.c.k(), (float)n2, this.c);
            l2.bO.a(string3, (float)n3 + 8.0f * this.c.k(), (float)n2, this.d);
            n2 = (int)((float)n2 + f4);
        }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
    }

    private void a(StatisticType bj2, z z2, Rect rect) {
        GameEngine l2 = GameEngine.getInstance();
        this.a(l2.bO, bj2, z2, rect);
    }

    private void a(com.corrodinggames.rts.gameFramework.m.y y2, StatisticType bj2, z z2, Rect rect) {
                try {
        float f2;
        float f3;
        float f4;
        int n2;
        int n3;
        String string2;
        GameEngine l2 = GameEngine.getInstance();
        g g2 = l2.bS;
        ab ab2 = this.m[bj2.ordinal()];
        float f5 = (float)(System.currentTimeMillis() - this.n) / 250.0f;
        Paint paint = new Paint();
        paint.a(255, 0, 255, 0);
        paint.a(true);
        paint.c(true);
        paint.a(Typeface.a(Typeface.c, 0));
        l2.b(paint, 14.0f);
        Paint paint2 = new Paint(paint);
        paint2.a(Paint$Align.b);
        l2.b(paint2, 14.0f);
        Paint paint3 = new Paint();
        paint3.a(2.0f);
        if (com.corrodinggames.rts.gameFramework.GameEngine.isDebugVersionStatic2) {
            paint3.a(3.0f);
        }
        paint3.a(Paint$Cap.b);
        Rect rect2 = new Rect();
        Paint paint4 = g2.aD;
        String string3 = com.corrodinggames.rts.gameFramework.h.a.a("gui.leaderboard.type." + bj2.name(), new Object[0]);
        paint4.a(string3, 0, string3.length(), this.b);
        y2.a(string3, (float)rect.d(), (float)(rect.top + this.b.c()), paint4);
        rect2.top = rect.top + this.b.c() + 3;
        rect2.d = rect.d - this.b.c() - 3;
        int n4 = Math.max(1, ab.a(ab2) - ab.b(ab2));
        float f6 = (float)rect2.c() / (float)n4;
        String string4 = com.corrodinggames.rts.gameFramework.GameUtils.a(0L);
        int n5 = y2.b(string4, paint2);
        y2.a(string4, (float)(rect.left + n5 / 2), (float)rect.d, paint2);
        rect2.left = rect.left + n5 / 2;
        String string5 = "123|";
        paint.a(string5, 0, string5.length(), this.b);
        int n6 = this.b.c();
        if (z2 == z.a) {
            string2 = com.corrodinggames.rts.gameFramework.g.a.a(ab.c(ab2).a(), ab.a(ab2));
            String string6 = com.corrodinggames.rts.gameFramework.g.a.a(ab.c(ab2).a(), ab.b(ab2));
            n5 = Math.max(y2.b(string2, paint), y2.b(string6, paint));
            rect2.c = rect.c - n5 - 2;
            n3 = n6 / 2;
            y2.b(rect2, g2.aM);
            paint3.b(-13619152);
            for (n2 = 0; n2 <= 4; ++n2) {
                float f7 = (float)ab.b(ab2) + (float)n4 * (float)n2 / 4.0f;
                float f8 = (float)rect2.d - (f7 - (float)ab.b(ab2)) * f6;
                String string7 = com.corrodinggames.rts.gameFramework.g.a.a(ab.c(ab2).a(), (int)f7);
                y2.a(string7, (float)(rect2.c + 2), f8 + (float)n3, paint);
                if (n2 <= 0 || n2 >= 4) continue;
                y2.a(rect2.left, f8, (float)rect2.c, f8, paint3);
            }
        } else {
            rect2.c = rect.c - l2.a(10);
        }
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a((long)(ab.d(ab2) / 1000));
        n5 = y2.b(string2, paint2);
        y2.a(string2, (float)rect2.c, (float)rect.d, paint2);
        float f9 = (float)rect2.b() / (float)ab.d(ab2);
        if (z2 == z.a) {
            for (n3 = 0; n3 <= 2; ++n3) {
                for (aa aa2 : this.l) {
                    int n7;
                    boolean bl2;
                    IntLookupTable bi2 = aa2.a.a(bj2);
                    boolean bl3 = bl2 = n3 == 0;
                    if (!bl2) {
                        n7 = 220;
                        if (this.a != null) {
                            n7 = aa2 == this.a ? 255 : 50;
                        }
                    } else {
                        if (aa2.c != -16777216) continue;
                        n7 = 255;
                        if (this.a != null) {
                            n7 = aa2 == this.a ? 255 : 50;
                        }
                    }
                    if (n3 == 2 ? aa2 != this.a : n3 == 1 && aa2 == this.a) continue;
                    Point2i bh2 = (Point2i)bi2.get(0);
                    float f10 = rect2.left;
                    f4 = (float)rect2.d - f6 * (float)(bh2.b - ab.b(ab2));
                    for (int i2 = 1; i2 < bi2.size(); ++i2) {
                        bh2 = (Point2i)bi2.get(i2);
                        f3 = (float)rect2.left + f9 * (float)bh2.a;
                        f2 = (float)rect2.d - f6 * (float)(bh2.b - ab.b(ab2));
                        int n8 = (int)((float)n7 * Math.min(1.0f, Math.max(0.0f, f5 - (float)bh2.a / (float)ab.d(ab2))));
                        ag ag2 = aa2.a(n8, bl2);
                        y2.a(f10, f4, f3, f4, (Paint)ag2);
                        y2.a(f3, f4, f3, f2, (Paint)ag2);
                        f10 = f3;
                        f4 = f2;
                    }
                }
            }
        } else {
            ArrayList arrayList = ab.e(ab2);
            ad ad2 = (ad)arrayList.get(0);
            for (int i3 = 1; i3 < arrayList.size(); ++i3) {
                ad ad3 = (ad)arrayList.get(i3);
                float f11 = (float)rect2.left + f9 * (float)ad.a(ad2);
                float f12 = (float)rect2.left + f9 * (float)ad.a(ad3);
                float f13 = rect2.d;
                for (int i4 = 0; i4 < this.l.size(); ++i4) {
                    f4 = ad2.a(i4);
                    float f14 = f13 - (float)rect2.c() * f4;
                    if (f4 > 0.0f) {
                        aa aa3 = (aa)this.l.get(i4);
                        f2 = Math.min(1.0f, Math.max(0.0f, f5 - (float)ad.a(ad2) / (float)ab.d(ab2)));
                        ag ag3 = aa3.a((int)(f2 * 255.0f), false);
                        this.b.a((int)f11, (int)(f14 + 0.5f), (int)f12, (int)(f13 + 0.5f));
                        if (this.o != null) {
                            y2.a(this.o, this.q, this.b, (Paint)ag3);
                        } else {
                            y2.b(this.b, (Paint)ag3);
                        }
                    }
                    f13 = f14;
                }
                ad2 = ad3;
            }
        }
        if (rect2.b((int)g2.x, (int)g2.y)) {
            g2.a((float)rect2.left, (float)rect2.top, (float)rect2.b(), rect2.c());
            paint3.b(-1);
            y2.a(g2.x, (float)rect2.top, g2.x, (float)rect2.d, paint3);
            int n9 = (int)g2.x;
            n2 = (int)g2.y;
            int n10 = (int)((g2.x - (float)rect2.left) / f9);
            if (this.v != n9 || this.w != n2) {
                this.v = n9;
                this.w = n2;
                this.u = n10;
                this.s.clear();
                this.t.clear();
                this.s.add(com.corrodinggames.rts.gameFramework.GameUtils.a((long)(this.u / 1000)));
                this.t.add(-1);
                aa aa4 = null;
                if (z2 == z.a) {
                    float f15 = 30.0f;
                    for (aa aa5 : this.l) {
                        TeamHistory bn2 = aa5.a;
                        int n11 = bn2.a(bj2, this.u);
                        float f16 = (float)rect2.d - f6 * (float)(n11 - ab.b(ab2));
                        f3 = com.corrodinggames.rts.gameFramework.GameUtils.c(f16 - g2.y);
                        if (!(f3 < f15)) continue;
                        f15 = f3;
                        aa4 = aa5;
                    }
                }
                this.a = aa4;
                for (aa aa6 : this.l) {
                    TeamHistory bn3 = aa6.a;
                    int n12 = bn3.a(bj2, this.u);
                    String string8 = com.corrodinggames.rts.gameFramework.g.a.a(ab.c(ab2).a(), n12) + " " + aa6.b;
                    this.s.add(string8);
                    int n13 = aa6.c;
                    if (this.a != null && this.a != aa6) {
                        int n14 = 60;
                        n13 = Color.a(n14, Color.b(n13), Color.c(n13), Color.d(n13));
                    }
                    this.t.add(n13);
                }
            }
            this.b.left = rect2.left + l2.a(5);
            this.b.top = rect2.top + l2.a(5);
            this.b.d = this.b.top + l2.a(5) + n6 * this.s.size();
            String string9 = "";
            for (String string10 : this.s) {
                if (string9.length() >= string10.length()) continue;
                string9 = string10;
            }
            int n15 = y2.b(string9, paint);
            this.b.c = this.b.left + l2.a(10) + n15;
            y2.b(this.b, g2.aL);
            int n16 = this.b.top + n6 + 3;
            for (int i5 = 0; i5 < this.s.size(); ++i5) {
                paint.b((Integer)this.t.get(i5));
                    y2.a((String)this.s.get(i5), (float)(this.b.left + 3), (float)n16, paint);
                n16 += n6;
            }
        } else {
            this.a = null;
        }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
    }
}

