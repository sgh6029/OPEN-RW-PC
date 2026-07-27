/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.f.b;
import com.corrodinggames.rts.gameFramework.f.f$1;
import com.corrodinggames.rts.gameFramework.f.f$2;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.f.i;
import com.corrodinggames.rts.gameFramework.f.y;
import com.corrodinggames.rts.gameFramework.h.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Rect;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.effect.e;
import com.corrodinggames.rts.gameFramework.effect.h;

import java.io.IOException;
import java.util.ArrayList;

public class f {
    Paint a;
    boolean b = false;
    float c = 0.0f;
    float d = 0.0f;
    Rect e = new Rect();
    Rect f = new Rect();
    Rect g = new Rect();
    y h = null;
    ArrayList i = new ArrayList();
    int j = 30;
    int k = 140;
    int l = 30;
    final Rect m = new Rect();
    boolean n;
    boolean o;
    static String p = com.corrodinggames.rts.gameFramework.h.a.a("gui.rategame.text", new Object[0]);
    static String q = com.corrodinggames.rts.gameFramework.h.a.a("gui.rategame.yes", new Object[0]);
    static String r = com.corrodinggames.rts.gameFramework.h.a.a("gui.rategame.no", new Object[0]);
    boolean s = false;
    float t = 0.0f;

    public f() {
        GameEngine l2 = GameEngine.getInstance();
        this.a();
        this.a = new Paint();
        this.a.a(true);
        this.a.a(Paint$Align.b);
        this.a.a(255, 0, 255, 0);
        l2.a(this.a, 34.0f);
    }

    void a() {
        this.i.clear();
        this.i.add(new f$1(this, "Finish game"));
        this.i.add(new f$2(this, "Keep playing"));
    }

    boolean b() {
        GameEngine l2 = GameEngine.getInstance();
        return (l2.dq || l2.dt) && !l2.dr;
    }

    public void a(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        g g2 = l2.bS;
        boolean bl2 = this.b();
        this.m.h();
        this.n = false;
        if (bl2 && !g2.u) {
            int n2 = l2.a(this.j);
            int n3 = l2.a(this.k);
            int n4 = n2 + l2.a(this.l);
            int n5 = n3 + l2.a(this.l);
            int n6 = this.i.size();
            float f3 = 0.0f;
            if (g2.c) {
                g2.d += 2.0f * f2 / 60.0f;
                f3 = g2.d;
                f3 = com.corrodinggames.rts.gameFramework.GameUtils.b(f3, 0.0f, 1.0f);
                f3 = com.corrodinggames.rts.gameFramework.GameUtils.i(f3);
            }
            int n7 = l2.a(40) + n5 * n6;
            int n8 = l2.a(140);
            if (g2.b) {
                n8 += l2.a(50);
            }
            if (g2.c) {
                n7 = (int)com.corrodinggames.rts.gameFramework.GameUtils.f(n7, l2.cameraShakeX * 0.9f, f3);
                n8 = (int)com.corrodinggames.rts.gameFramework.GameUtils.f(n8, l2.cameraShakeIntensity * 0.9f, f3);
            }
            float f4 = l2.cp - (float)(n8 / 2);
            if (!g2.c) {
                f4 = com.corrodinggames.rts.gameFramework.GameUtils.f(f4, f4 / 2.0f, 1.0f - f3);
            }
            if (f4 < 20.0f) {
                f4 = 20.0f;
            }
            this.g.top = (int)f4;
            this.g.d = this.g.top + n8;
            this.g.left = (int)(l2.cameraShakeX / 2.0f - (float)(n7 / 2));
            this.g.c = (int)(l2.cameraShakeX / 2.0f + (float)(n7 / 2));
            this.m.a(this.g);
            if (this.m.b((int)g2.z, (int)g2.A)) {
                this.n = g2.U;
                g2.U = false;
                this.o = g2.I;
                g2.I = false;
            }
            g2.a(this.m);
        }
    }

    public void b(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        g g2 = l2.bS;
        boolean bl2 = this.b();
        if (!l2.dq) {
            this.b = false;
        } else if (!this.b) {
            this.b = true;
            if (!l2.isGamePaused && l2.bQ.numberOfWins >= 5 && !l2.bQ.rateGameShown && com.corrodinggames.rts.gameFramework.GameEngine.au) {
                this.s = true;
                l2.bQ.rateGameShown = true;
                l2.bQ.save();
            }
        }
        if (!bl2) {
            this.c = 0.0f;
        }
        if (bl2 && !g2.u) {
            Object object;
            int n2;
            int n3;
            this.c += f2;
            if (l2.bx < 120) {
                this.c = 100000.0f;
            }
            if (this.n) {
                g2.U = true;
            }
            if (this.o) {
                g2.I = true;
            }
            boolean bl3 = this.c > 80.0f;
            float f3 = 95.0f;
            boolean bl4 = this.c > 100.0f;
            boolean bl5 = this.c > 110.0f;
            int n4 = l2.a(this.j);
            int n5 = l2.a(this.k);
            int n6 = n4 + l2.a(this.l);
            int n7 = n5 + l2.a(this.l);
            int n8 = this.i.size();
            int n9 = n5 * n8 + (n8 - 1) * n6;
            int n10 = (int)(l2.cameraShakeX / 2.0f - (float)(n9 / 2));
            float f4 = 0.0f;
            float f5 = 0.0f;
            if (g2.c) {
                f4 = g2.d;
                f4 = com.corrodinggames.rts.gameFramework.GameUtils.b(f4, 0.0f, 1.0f);
                float f6 = f5 = (f4 = com.corrodinggames.rts.gameFramework.GameUtils.i(f4)) >= 1.0f ? 1.0f : 0.0f;
            }
            if (bl3) {
                float f7 = g2.bt.g;
                g2.bt.g = f5;
                g2.bt.c(l2.bO, this.m);
                g2.bt.g = f7;
            }
            int n11 = this.m.top + l2.a(40);
            int n12 = (int)(l2.cameraShakeX / 2.0f);
            int n13 = n3 = this.m.d - l2.a(45);
            int n14 = Color.a(140, 100, 100, 100);
            Paint paint = this.a;
            String string2 = "Victory!";
            if (l2.dt) {
                string2 = "Defeat";
            }
            float f8 = 1.0f;
            if (this.c < f3) {
                f8 = this.c / f3;
            }
            n11 = (int)((float)n11 - com.corrodinggames.rts.gameFramework.GameUtils.k(f8 * 90.0f) * 100.0f);
            paint.a(string2, 0, string2.length(), this.e);
            try {
                l2.bO.a(string2, (float)n12, (float)n11 - (paint.l() + paint.m()) / 2.0f, paint);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (this.c < 100.0f && !l2.dt) {
                this.d += f2;
                if (this.d > 0.5f) {
                    this.d = 0.0f;
                    l2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                    l2.bR.b();
                    n2 = Color.a(255, com.corrodinggames.rts.gameFramework.GameUtils.a(0, 255), com.corrodinggames.rts.gameFramework.GameUtils.a(0, 255), com.corrodinggames.rts.gameFramework.GameUtils.a(0, 255));
                    object = l2.bR.b(0.0f, 0.0f, 0.0f, n2);
                    if (object != null) {
                        ((e)object).ar = (short)4;
                        ((e)object).I = (float)n12 + com.corrodinggames.rts.gameFramework.GameUtils.c(-70.0f, 70.0f);
                        ((e)object).J = (float)n11 + com.corrodinggames.rts.gameFramework.GameUtils.c(-15.0f, 15.0f);
                        ((e)object).J += l2.cp / 2.0f;
                        ((e)object).K += l2.cp / 2.0f;
                        ((e)object).W = ((e)object).V = com.corrodinggames.rts.gameFramework.GameUtils.c(140.0f, 380.0f);
                        ((e)object).r = true;
                        ((e)object).s = true;
                        ((e)object).t = 5.0f;
                        ((e)object).E = 2.0f;
                        ((e)object).Q = com.corrodinggames.rts.gameFramework.GameUtils.c(-2.7f, 2.7f);
                        ((e)object).P = com.corrodinggames.rts.gameFramework.GameUtils.c(-12.7f, 12.7f);
                        ((e)object).G = 0.4f;
                        ((e)object).F = 0.2f;
                        ((e)object).R = com.corrodinggames.rts.gameFramework.GameUtils.c(2.0f, 4.0f);
                        ((e)object).w = 2.0f;
                        ((e)object).v = true;
                        ((e)object).p = true;
                    }
                }
            }
            n11 += 60;
            if (bl5) {
                boolean bl6;
                Rect rect = this.e;
                object = this.f;
                rect.a(this.m.left + l2.a(10), this.m.top + l2.a(60), this.m.c - l2.a(10), n13 - l2.a(10));
                ((Rect)object).a(rect);
                if (!g2.c) {
                    rect.top = this.m.d + l2.a(15);
                    rect.d = rect.top + l2.a(200);
                }
                boolean bl7 = bl6 = g2.d >= 1.0f;
                if (this.h != null) {
                    this.h.a(rect, (Rect)object, f2, bl6, g2.b);
                }
            }
            for (n2 = 0; n2 < this.i.size(); ++n2) {
                if (bl4 && g2.a(n10, n13, n5, n4, ((b)(object = (b)this.i.get(n2))).a(), com.corrodinggames.rts.gameFramework.f.i.none, false, n14, g2.aD, g2.br)) {
                    this.s = false;
                    ((b)object).b();
                }
                n10 += n6 + n5;
            }
            if (this.s) {
                this.c(f2);
            }
            if (this.m.b((int)g2.z, (int)g2.A)) {
                // empty if block
            }
            g2.a(this.m);
        }
    }

    void c(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        g g2 = l2.bS;
        int n2 = l2.a(180);
        int n3 = (int)(l2.cameraShakeX / 2.0f - (float)(n2 / 2));
        int n4 = l2.a(120);
        int n5 = (int)(l2.cameraShakeIntensity - (float)n4);
        this.g.a(n3, n5, n2, n4);
        try {
            l2.bO.b(this.g, g2.aP);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int n6 = n3 + n2 / 2;
        int n7 = n5;
        Paint paint = this.a;
        String string2 = p;
        paint.a(string2, 0, string2.length(), this.e);
        try {
            l2.bO.a(string2, (float)n6, (float)n7 - (paint.l() + paint.m()) / 2.0f, paint);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        int n8 = n5 + this.e.c();
        int n9 = l2.a(70);
        int n10 = l2.a(30);
        int n11 = n3 + n2 / 2 - l2.a(10) - n9;
        int n12 = Color.a(140, 100, 100, 100);
        String string3 = q;
        if (g2.a(n11, n8, n9, n10, string3, com.corrodinggames.rts.gameFramework.f.i.none, false, n12, g2.aD, null)) {
            this.s = false;
            com.corrodinggames.rts.appFramework.f f3 = l2.ao;
            if (f3 == null) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("showRateNow: gameView==null");
                return;
            }
            com.corrodinggames.rts.appFramework.g g3 = f3.i();
            if (g3 == null) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("showRateNow: inGameActivity==null");
                return;
            }
            g3.l();
        }
        if (g2.a(n11 = n3 + n2 / 2 + l2.a(10), n8, n9, n10, string3 = r, com.corrodinggames.rts.gameFramework.f.i.none, false, n12, g2.aD, null)) {
            this.s = false;
        }
    }

    public void c() {
        this.h = y.a();
    }
}

