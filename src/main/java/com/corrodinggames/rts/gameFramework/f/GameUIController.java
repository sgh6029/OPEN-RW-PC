/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 *  android.view.Menu
 *  android.view.MenuItem
 */
package com.corrodinggames.rts.gameFramework.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.UnitStatistics;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.game.units.a.AttackModeAction;
import com.corrodinggames.rts.game.units.a.FilteredUnitAction;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.SelectUnitTypeAction;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.KeyBinding;
import com.corrodinggames.rts.gameFramework.Serializable;
import com.corrodinggames.rts.gameFramework.GGameObject;
import com.corrodinggames.rts.gameFramework.i.b;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.PorterDuff;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Paint$Style;
import android.graphics.PointF;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;

public class GameUIController
        extends Serializable {
    g a;
    GameEngine b;
    public boolean c = false;
    public boolean d = false;
    public boolean e;
    public float f;
    Paint g = new Paint();
    Paint h = new Paint();
    Paint i = new Paint();
    Paint j = new Paint();
    Paint k = new Paint();
    Paint l = new Paint();
    Paint m = new Paint();
    ag n;
    ag o;
    Paint p = new Paint();
    Paint q;
    Paint r;
    Rect s = new Rect();
    RectF t = new RectF();
    Rect u = new Rect();
    Rect v = new Rect();
    Rect w = new Rect();
    RectF x = new RectF();
    RectF y = new RectF();
    Rect z = new Rect();
    RectF A = new RectF();
    Rect B = new Rect();
    RectF C = new RectF();
    boolean D;
    float E;
    float F;
    float G;
    int H;
    boolean I;
    float J;
    float K;
    float L;
    float M;
    float N;
    float O;
    int P;
    float Q;
    float R;
    com.corrodinggames.rts.gameFramework.m.Texture_M S = null;
    com.corrodinggames.rts.gameFramework.m.Texture_M T = null;
    com.corrodinggames.rts.gameFramework.m.Texture_M U = null;
    com.corrodinggames.rts.gameFramework.m.Texture_M V = null;
    com.corrodinggames.rts.gameFramework.m.Texture_M W = null;
    com.corrodinggames.rts.gameFramework.m.Texture_M X = null;
    static Paint Y = new Paint();
    static PorterDuffColorFilter Z = new PorterDuffColorFilter(Color.a(200, 255, 200), PorterDuff.Mode.MULTIPLY);
    com.corrodinggames.rts.game.units.BaseUnit aa;
    AbstractUnitAction ab;
    float ac;
    long ad;
    float ae;
    float af;
    String ag;
    String ah;
    String ai;
    String aj;
    String ak;
    public String al;
    String am = null;
    float an = 0.0f;
    public float ao;
    public boolean ap;
    ArrayList<AbstractUnitAction> aq = new ArrayList();
    com.corrodinggames.rts.game.units.a.UnitInfoAction ar = new com.corrodinggames.rts.game.units.a.UnitInfoAction(false);
    com.corrodinggames.rts.game.units.a.UnitInfoAction as = new com.corrodinggames.rts.game.units.a.UnitInfoAction(true);
    AttackModeAction at = new AttackModeAction();
    ArrayList au = new ArrayList();
    ArrayList av = new ArrayList();
    m aw = new m();
    ArrayList ax = new ArrayList();
    RectF ay = new RectF();
    HashMap az = new HashMap();
    ArrayList<am> aA = new ArrayList();
    Rect aB = new Rect();
    float aC;
    v aD = new v();

    GameUIController(GameEngine l2, g g2) {
        this.a = g2;
        this.b = l2;
        this.b();
    }

    public void a() {
        this.ag = com.corrodinggames.rts.gameFramework.h.a.a("gui.unselectall", new Object[0]);
        this.ah = com.corrodinggames.rts.gameFramework.h.a.a("gui.common.allyUnit", new Object[0]);
        this.ai = com.corrodinggames.rts.gameFramework.h.a.a("gui.common.enemyUnit", new Object[0]);
        this.aj = com.corrodinggames.rts.gameFramework.h.a.a("gui.common.neutralUnit", new Object[0]);
        this.ak = com.corrodinggames.rts.gameFramework.h.a.a("gui.infoText.ownedBy", new Object[0]);
        this.al = com.corrodinggames.rts.gameFramework.h.a.a("gui.infoText.unitCapReached", new Object[0]);
    }

    public void b() {
        this.a();
        this.S = this.b.bO.a(com.corrodinggames.rts.R.drawable.zoom_button);
        this.T = this.b.bO.a(com.corrodinggames.rts.R.drawable.lock_icon_menu);
        this.U = this.b.bO.a(com.corrodinggames.rts.R.drawable.pause);
        this.V = this.b.bO.a(com.corrodinggames.rts.R.drawable.replay_pause);
        this.W = this.b.bO.a(com.corrodinggames.rts.R.drawable.fast);
        this.X = this.b.bO.a(com.corrodinggames.rts.R.drawable.replay_leaderboard);
        Y.a(255, 30, 30, 30);
        Y.a(Z);
        Y.d(true);
        this.q = new Paint();
        this.q.a(255, 255, 255, 255);
        this.q.a(Paint$Align.a);
        this.q.c(true);
        this.q.a(true);
        this.r = new Paint();
        this.r.a(255, 255, 255, 255);
        this.r.a(Paint$Align.a);
        this.r.c(true);
        this.r.a(true);
        this.n = new ag();
        this.n.b(Color.a(190, 255, 255, 255));
        this.n.o();
        this.o = new ag();
        this.o.b(Color.a(133, 255, 255, 255));
        this.o.o();
        this.aA.clear();
        for (int i2 = 0; i2 < 10; ++i2) {
            this.aA.add(new am(this, i2 < 3));
        }
    }

    private float p() {
        float f2 = 4.6f / this.b.cY;
        if (f2 > 4.6f) {
            f2 = 4.6f;
        }
        return f2;
    }

    private float q() {
        return this.r() / this.b.cY;
    }

    private float r() {
        if (this.b.cameraShakeX / this.b.bL.i() < this.b.cameraShakeIntensity / this.b.bL.j()) {
            return this.b.cameraShakeX / this.b.bL.i();
        }
        return this.b.cameraShakeIntensity / this.b.bL.j();
    }

    void a(float f2) {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        if (this.b.bQ.showZoomButton) {
            f7 = this.b.cj * 0.7f;
            int n2 = (int) (50.0f * f7);
            int n3 = (int) this.b.cp;
            f6 = com.corrodinggames.rts.gameFramework.l.a.c();
            if (f6 > 20.0f) {
                n2 = (int) ((float) n2 + (f6 - 20.0f));
            }
            if (this.D) {
                this.s.a(n2 - 4, (int) ((float) n3 - 50.0f * this.b.cj), n2 + 4,
                        (int) ((float) n3 + 50.0f * this.b.cj));
                this.i.a();
                this.i.b(Color.a(255, 0, 0, 0));
                try {
                    this.b.bO.b(this.s, this.i);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            float f8 = n3;
            if (this.b.cV > 1.0f) {
                f8 -= (this.b.cV - 1.0f) * 3.0f * this.b.cj;
            } else {
                f5 = 20.0f;
                f8 += (this.b.cV * -f5 + f5 + 1.0f) * this.b.cj;
            }
            f5 = 48.0f * f7;
            f4 = 54.0f * f7;
            float f9 = f5 / 2.0f;
            f3 = f4 / 2.0f;
            if (f8 < f3) {
                f8 = f3;
            }
            if (f8 > this.b.cm - f3) {
                f8 = (int) (this.b.cm - f3);
            }
            this.s.a((int) ((float) n2 - f9), (int) (f8 - f3), (int) ((float) n2 + f9), (int) (f8 + f3));
            if (!this.D) {
                Y.a(140, 215, 215, 215);
            } else {
                Y.a(255, 255, 255, 255);
            }
            try {
                this.b.bO.a(this.S, (float) this.s.left, (float) this.s.top, Y, 0.0f, f7);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            boolean bl2 = this.D;
            if (!this.D && this.a.b(this.s.left, this.s.top, this.s.b(), this.s.c(),
                    com.corrodinggames.rts.gameFramework.f.i.zoomButton)) {
                this.D = true;
                this.E = this.a.y;
            }
            if (!this.a.I) {
                this.D = false;
            }
            if (this.D) {
                this.F += f2;
                this.a.d();
                float f10 = this.a.y - this.E;
                if (f10 > 180.0f) {
                    f10 = 180.0f;
                }
                if (f10 < -180.0f) {
                    f10 = -180.0f;
                }
                if ((f10 *= this.b.cV) > 2.0f) {
                    this.b.cV -= 5.0E-4f * com.corrodinggames.rts.gameFramework.GameUtils.c(f10) * f2;
                    this.b.cW = false;
                    if (this.b.cV < this.q()) {
                        this.b.cV = this.q();
                        this.b.cW = true;
                    }
                } else if (f10 < -2.0f) {
                    this.b.cV += 5.0E-4f * com.corrodinggames.rts.gameFramework.GameUtils.c(f10) * f2;
                    this.b.cW = false;
                    if (this.b.cV > this.p()) {
                        this.b.cV = this.p();
                        this.b.cW = true;
                    }
                }
            } else {
                if (!bl2 || this.F < 12.0f) {
                    // empty if block
                }
                this.F = 0.0f;
            }
        }
        if (this.b.bQ.mouseSupport) {
            if (this.a.a(this.b.af(), this.b.ag()) && !this.a.L) {
                int n4 = this.b.ai();
                if (n4 != 0) {
                    this.G += (float) n4 / 120.0f * 0.18f;
                }
                if (this.G > 1.0f) {
                    this.G = 1.0f;
                }
                if (this.G < -1.0f) {
                    this.G = -1.0f;
                }
            }
            if (this.G != 0.0f) {
                f7 = 0.0032f * f2;
                if (this.G < 0.0f) {
                    f7 = -f7;
                }
                float f11 = this.G;
                this.G = com.corrodinggames.rts.gameFramework.GameUtils.a(this.G,
                        com.corrodinggames.rts.gameFramework.GameUtils.c(f7 += this.G * 0.18f * f2));
                if (this.G == 0.0f) {
                    f7 = f11;
                }
                this.b.cV += (f7 *= this.b.cV);
                this.b.cZ = true;
                this.b.mouseX = this.b.af();
                this.b.mouseY = this.b.ag();
                if (f7 != 0.0f) {
                    this.b.cW = false;
                }
            }
        }
        if (this.b.bQ.gestureZoom && this.b.ac() && this.b.ae() >= 3) {
            this.R = 20.0f;
        }
        if (this.R < 10.0f) {
            this.I = false;
        }
        if (this.R > 0.0f) {
            this.R = com.corrodinggames.rts.gameFramework.GameUtils.a(this.R, f2);
            boolean bl3 = this.b.ac() && this.b.ae() >= 3;
            this.a.aU = 3.0f;
            float f12 = 0.0f;
            float f13 = 0.0f;
            f6 = 0.0f;
            if (bl3) {
                int n5;
                for (n5 = 0; n5 < this.b.ae(); ++n5) {
                    f12 += this.b.b(n5);
                    f13 += this.b.c(n5);
                }
                f12 /= (float) this.b.ae();
                f13 /= (float) this.b.ae();
                f6 = 0.0f;
                for (n5 = 0; n5 < this.b.ae(); ++n5) {
                    f5 = this.b.b(n5);
                    f4 = this.b.c(n5);
                    f6 += com.corrodinggames.rts.gameFramework.GameUtils.b(f12, f13, f5, f4);
                }
            } else {
                f12 = this.M;
                f13 = this.N;
                f6 = this.O;
            }
            if (this.I && this.P != this.b.ae()) {
                this.I = false;
            }
            if (!this.I && bl3) {
                this.I = true;
                this.J = f12;
                this.K = f13;
                this.L = f6;
                this.Q = this.b.cV;
                this.M = f12;
                this.N = f13;
                this.O = f6;
                this.P = this.b.ae();
            }
            if (bl3) {
                float f14 = this.N - f13;
                f14 *= 2.0f;
                this.b.cV += (f14 *= this.b.cV) / 250.0f / this.b.cj;
                this.b.cW = false;
                f5 = this.O - f6;
                boolean bl4 = false;
                if (bl4) {
                    this.b.cV -= f5 / 350.0f / this.b.cj;
                    this.b.cW = false;
                }
                this.M = f12;
                this.N = f13;
                this.O = f6;
                this.P = this.b.ae();
                try {
                    for (int i2 = 0; i2 < this.b.ae(); ++i2) {
                        f3 = this.b.b(i2);
                        float f15 = this.b.c(i2);
                        this.b.bO.a(f12, f13, f3, f15, this.a.aN);
                    }
                    float f16 = 6.0f;
                    this.b.bO.a(f12, f13, f12, this.K, this.a.aO);
                    this.b.bO.a(f12, f13, f16, this.a.aN);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        if (this.b.cV > this.p()) {
            this.b.cV = this.p();
            this.b.cW = true;
        }
        if (this.b.cV < this.q()) {
            this.b.cV = this.q();
            this.b.cW = true;
        }
    }

    void b(float f2) {
        int n2;
        int n3;
        boolean bl2;
        this.e = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        int n4 = 7;
        if (com.corrodinggames.rts.gameFramework.GameEngine.aw()) {
            n4 = 14;
        }
        if (this.b.ac() && this.a.ac == null) {
            bl2 = this.a.c(this.b);
            n3 = 1;
            if (this.b.bQ.mouseOrders == 2) {
                n3 = 2;
            }
            n2 = this.b.f(n3);
            if (bl2 || this.b.bQ.mouseSupport && n2 != -1 && !this.a.J && !this.a.K) {
                float f3 = this.b.b(0);
                float f4 = this.b.c(0);
                if (n2 != -1) {
                    f3 = this.b.b(n2);
                    f4 = this.b.c(n2);
                }
                if (!this.c) {
                    bl4 = true;
                    this.y.left = (int) f3;
                    this.y.b = (int) f4;
                }
                this.y.c = (int) f3;
                this.y.d = (int) f4;
                if (Math.abs(this.y.left - this.y.c) > (float) n4 || Math.abs(this.y.b - this.y.d) > (float) n4) {
                    this.d = true;
                }
                bl3 = true;
            } else if (this.b.ae() == 2 && this.R == 0.0f) {
                this.y.left = (int) this.b.b(0);
                this.y.b = (int) this.b.c(0);
                this.y.c = (int) this.b.b(1);
                this.y.d = (int) this.b.c(1);
                this.d = false;
                bl3 = true;
            }
            if (bl3) {
                this.f += f2;
                if (this.f < 18.0f) {
                    bl5 = true;
                }
            } else {
                this.f = 0.0f;
            }
            if (bl3) {
                this.c = true;
                if (Math.abs(this.y.left - this.y.c) > (float) n4 || Math.abs(this.y.b - this.y.d) > (float) n4) {
                    this.z.d = (int) this.y.d;
                    this.z.top = (int) this.y.b;
                    this.z.left = (int) this.y.left;
                    this.z.c = (int) this.y.c;
                    com.corrodinggames.rts.gameFramework.GameUtils.a(this.z);
                    this.g.b(Color.a(255, 0, 255, 0));
                    this.g.a(Paint$Align.b);
                    this.g.a(1.0f);
                    try {
                        this.b.bO.b(this.z, this.g);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    this.e = true;
                }
            }
        }
        bl2 = false;
        n3 = 0;
        if (this.c && !bl3) {
            if (bl5 && this.b.ae() == 3) {
                n3 = 1;
            } else {
                bl2 = true;
            }
        }
        if (n3 != 0) {
            this.d = false;
            this.c = false;
        }
        if (bl3 && !bl5 || bl2) {
            if (bl4) {
                for (GGameObject w2 : ((List<GGameObject>) com.corrodinggames.rts.gameFramework.GGameObject.fastGameObjectList)) {
                    if (!(w2 instanceof com.corrodinggames.rts.game.units.c_f))
                        continue;
                    com.corrodinggames.rts.game.units.c_f c2 = (com.corrodinggames.rts.game.units.c_f) w2;
                    c2.cI = c2.cG;
                }
            }
            if (bl2) {
                this.d = false;
                this.c = false;
            }
            this.A.a(this.y);
            com.corrodinggames.rts.gameFramework.GameUtils.a(this.A);
            if (Math.abs(this.A.left - this.A.c) > (float) n4 || Math.abs(this.A.b - this.A.d) > (float) n4) {
                com.corrodinggames.rts.game.units.c_f c3;
                this.A.d /= this.b.cX;
                this.A.b /= this.b.cX;
                this.A.left /= this.b.cX;
                this.A.c /= this.b.cX;
                this.A.a(this.b.cu, this.b.cv);
                this.a.aU = 4.0f;
                this.a.aV = 40.0f;
                this.a.U = false;
                n2 = this.a.a(this.b) ? 1 : 0;
                boolean bl6 = this.a.b(this.b);
                boolean bl7 = true;
                boolean bl8 = true;
                boolean bl9 = false;
                if (this.b.bQ.smartSelection_v2) {
                    for (GGameObject w3 : ((List<GGameObject>) com.corrodinggames.rts.gameFramework.GGameObject.fastGameObjectList)) {
                        if (!(w3 instanceof y) || !this.a(c3 = (y) w3) || n2 != 0 && ((y) c3).cI)
                            continue;
                        if (!c3.bI()) {
                            bl7 = false;
                        }
                        if (!((y) c3).aS() || !c3.l())
                            continue;
                        bl8 = false;
                    }
                }
                if (bl6) {
                    bl7 = true;
                }
                for (GGameObject w3 : ((List<GGameObject>) com.corrodinggames.rts.gameFramework.GGameObject.fastGameObjectList)) {
                    if (!(w3 instanceof com.corrodinggames.rts.game.units.c_f))
                        continue;
                    c3 = (com.corrodinggames.rts.game.units.c_f) w3;
                    boolean bl10 = false;
                    if (this.a(c3)) {
                        bl10 = true;
                        if (!bl7 && c3.bI()) {
                            bl10 = false;
                        }
                        if (!bl8 && c3.ak() && !c3.l()) {
                            bl10 = false;
                        }
                    }
                    if (bl6) {
                        if (bl10) {
                            bl10 = !c3.cI;
                        } else if (c3.cI) {
                            bl10 = true;
                        }
                    } else if (n2 != 0 && c3.cI) {
                        bl10 = true;
                    }
                    if (bl10) {
                        this.a.j(c3);
                        if (!bl2 || c3.cH + 900 >= this.b.bA || (n2 != 0 || bl6) && c3.cI)
                            continue;
                        bl9 = true;
                        continue;
                    }
                    this.a.l(c3);
                }
                if (bl9) {
                    for (GGameObject w3 : ((List<GGameObject>) com.corrodinggames.rts.gameFramework.GGameObject.fastGameObjectList)) {
                        if (!(w3 instanceof com.corrodinggames.rts.game.units.c_f))
                            continue;
                        c3 = (com.corrodinggames.rts.game.units.c_f) w3;
                        c3.cH = this.b.bA;
                    }
                }
                this.a.E();
            }
        }
    }

    private boolean a(com.corrodinggames.rts.game.units.c_f c2) {
        if (!c2.bV && c2.cN == null) {
            float f2 = c2.posX;
            float f3 = c2.posY - c2.posZ;
            if (f3 <= 0.0f) {
                f3 += c2.posZ;
            }
            if (this.A.b(f2, f3) && (this.a.m(c2) || this.b.bs.b()) && !c2.t()) {
                return true;
            }
        }
        return false;
    }

    public void a(String string2, int n2) {
        this.am = string2;
        this.an = n2;
    }

    public void b(String string2, int n2) {
        if (this.an <= 0.0f || string2.equals(this.am)) {
            this.am = string2;
            this.an = n2;
        }
    }

    public void a(String string2) {
        if (this.an > 0.0f && string2.equals(this.am)) {
            this.an = 0.0f;
        }
    }

    public void c(float f2) {
        if (this.an > 0.0f && this.am != null) {
            this.an = com.corrodinggames.rts.gameFramework.GameUtils.a(this.an, f2);
            try {
                this.b.bO.a(this.am, this.b.co, this.b.cp, this.a.aD, this.a.aI, 8.0f);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static boolean a(AbstractUnitAction s2) {
        GameEngine l2 = GameEngine.getInstance();
        return l2.isGamePaused && s2.n_();
    }

    public void c() {
        this.H = 0;
    }

    public KeyBinding a(AbstractUnitAction var1, int var2, ArrayList var3) {
        GameEngine var4 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (!com.corrodinggames.rts.gameFramework.GameEngine.av()) {
            return null;
        } else if (var1.M() != null) {
            return var1.M();
        } else if (var1 instanceof com.corrodinggames.rts.game.units.a.RepairTargetAction) {
            return null;
        } else if (var1 instanceof AttackModeAction) {
            return null;
        } else if (var1.f() == com.corrodinggames.rts.game.units.a.ActionDisplayType.rally) {
            return var4.bT.T;
        } else if (var1.e() == com.corrodinggames.rts.game.units.a.ActionType.patrol) {
            return var4.bT.Q;
        } else if (var1.e() == com.corrodinggames.rts.game.units.a.ActionType.guardUnit) {
            return var4.bT.P;
        } else if (var1.e() == com.corrodinggames.rts.game.units.a.ActionType.reclaimTarget) {
            return var4.bT.R;
        } else {
            if (var1.f() == com.corrodinggames.rts.game.units.a.ActionDisplayType.upgrade) {
                int var5 = 0;
                Iterator var6 = var3.iterator();

                while (var6.hasNext()) {
                    AbstractUnitAction var7 = (AbstractUnitAction) var6.next();
                    if (var7 != var1 && var7.f() == com.corrodinggames.rts.game.units.a.ActionDisplayType.upgrade && this.a.b(var7)) {
                        ++var5;
                    }
                }

                if (var5 == 0) {
                    return var4.bT.S;
                }
            }

            ActionDisplayType var8 = var1.f();
            if (var8 != com.corrodinggames.rts.game.units.a.ActionDisplayType.infoOnly && var8 != com.corrodinggames.rts.game.units.a.ActionDisplayType.infoOnlyNoBox
                    && var8 != com.corrodinggames.rts.game.units.a.ActionDisplayType.infoOnlyStockpile) {
                KeyBinding var9 = null;
                KeyBinding[] var10 = var4.bT.ag;
                if (this.H < var10.length) {
                    var9 = var10[this.H];
                    ++this.H;
                }

                return var9;
            } else {
                return null;
            }
        }
    }

    public ArrayList d() {
        this.au.clear();
        com.corrodinggames.rts.game.units.BaseUnit[] amArray = this.a.bZ.a();
        int n2 = this.a.bZ.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            com.corrodinggames.rts.game.units.BaseUnit am2 = amArray[i2];
            UnitType as2 = am2.r();
            if (this.au.contains(as2))
                continue;
            this.au.add(as2);
        }
        return this.au;
    }

    public ArrayList a(com.corrodinggames.rts.game.units.BaseUnit var1, ArrayList var2) {
        int var3 = 0;
        this.aq.clear();
        int var4 = this.a.q();
        if (var4 == 0) {
            if (this.b.bQ.showChatAndPingShortcuts && this.b.M()) {
                this.aq.add(var3, this.a.q);
                this.aq.add(var3, this.a.r);
            }

            return this.aq;
        } else {
            if (com.corrodinggames.rts.gameFramework.f.g.bO && var1 != null
                    && !(var1 instanceof com.corrodinggames.rts.game.units.h_f)) {
                this.aq.add(this.ar);
                this.aq.add(this.as);
            }

            if (var1 == null) {
            }

            int var6;
            ArrayList var8;
            Iterator var9;
            AbstractUnitAction var10;
            Iterator var12;
            if (var1 != null) {
                var3 = this.aq.size();
                if (var1.cG) {
                    ArrayList var5;
                    if (this.a.m(var1)) {
                        var5 = var1.N();
                        if (var5 != null) {
                            this.aq.addAll(var5);
                        }
                    } else {
                        var5 = var1.N();
                        if (var5 != null) {
                            this.aq.addAll(var5);
                        }
                    }
                }

                int var14 = 0;

                for (var6 = var2.size(); var14 < var6; ++var14) {
                    com.corrodinggames.rts.game.units.BaseUnit var7 = (com.corrodinggames.rts.game.units.BaseUnit) var2.get(var14);
                    if (this.a.m(var7) && (var7.r() != var1.r() || var7.V() != var1.V())) {
                        var8 = var7.N();
                        if (var8 != null) {
                            var9 = var8.iterator();

                            while (var9.hasNext()) {
                                var10 = (AbstractUnitAction) var9.next();
                                boolean var11 = false;
                                var12 = this.aq.iterator();

                                while (var12.hasNext()) {
                                    AbstractUnitAction var13 = (AbstractUnitAction) var12.next();
                                    if (var13.N().equals(var10.N())) {
                                        var11 = true;
                                    }
                                }

                                if (!var11) {
                                    this.aq.add(var10);
                                }
                            }
                        }
                    }
                }
            }

            boolean var15 = false;
            var6 = 0;

            for (int var17 = var2.size(); var6 < var17; ++var6) {
                com.corrodinggames.rts.game.units.BaseUnit var19 = (com.corrodinggames.rts.game.units.BaseUnit) var2.get(var6);
                if (this.a.m(var19) && var19 instanceof com.corrodinggames.rts.game.units.y) {
                    com.corrodinggames.rts.game.units.y var21 = (com.corrodinggames.rts.game.units.y) var19;
                    if (!var21.aS()) {
                        var15 = true;
                    }
                }
            }

            com.corrodinggames.rts.game.units.BaseUnit var16 = this.e();
            if (!var15 && var16 != null && this.a.m(var16)) {
                this.aq.add(var3, this.a.m);
                this.aq.add(var3, this.a.n);
            }

            boolean var18 = false;
            if (com.corrodinggames.rts.gameFramework.f.g.bO && (this.b.bQ.showSelectedUnitsList || var4 == 1)) {
                var18 = true;
            }

            if (com.corrodinggames.rts.gameFramework.GameEngine.at() && var4 > 0) {
                var18 = true;
            }

            if (var18 && !(var1 instanceof com.corrodinggames.rts.game.units.h_f)) {
                if (var4 == 1 && var16 != null) {
                    m var20 = var16.e(true);
                    if (var20 != null && var20.size() > 0) {
                        int var22 = 0;

                        label152: while (true) {
                            if (var22 >= var20.a) {
                                this.aw.clear();
                                var9 = var20.iterator();

                                while (true) {
                                    if (!var9.hasNext()) {
                                        break label152;
                                    }

                                    var10 = (AbstractUnitAction) var9.next();
                                    if (var10 instanceof com.corrodinggames.rts.game.units.a.WrapperUnitAction) {
                                        this.aw.add((com.corrodinggames.rts.game.units.a.WrapperUnitAction) var10);
                                    }

                                    this.aq.add(var10);
                                }
                            }

                            var10 = (AbstractUnitAction) var20.get(var22);
                            if (var10 instanceof com.corrodinggames.rts.game.units.a.WrapperUnitAction) {
                                com.corrodinggames.rts.game.units.a.WrapperUnitAction var25 = (com.corrodinggames.rts.game.units.a.WrapperUnitAction) var10;
                                var12 = this.aw.iterator();

                                while (var12.hasNext()) {
                                    com.corrodinggames.rts.game.units.a.WrapperUnitAction var27 = (com.corrodinggames.rts.game.units.a.WrapperUnitAction) var12
                                            .next();
                                    if (var27.a(var25)) {
                                        var20.set(var22, var27);
                                    }
                                }
                            }

                            ++var22;
                        }
                    }
                }

                var8 = this.d();
                this.av.clear();
                var9 = var8.iterator();

                while (var9.hasNext()) {
                    UnitType var23 = (UnitType) var9.next();
                    SelectUnitTypeAction var26 = var23.d();
                    var26.K();
                    this.av.add(var26);
                }

                Collections.sort(this.av);
                if (com.corrodinggames.rts.gameFramework.f.g.bO) {
                    Collections.reverse(this.av);
                }

                var9 = this.av.iterator();

                while (var9.hasNext()) {
                    SelectUnitTypeAction var24 = (SelectUnitTypeAction) var9.next();
                    if (com.corrodinggames.rts.gameFramework.f.g.bO) {
                        this.aq.add(0, var24);
                    } else {
                        this.aq.add(var24);
                    }
                }
            }

            return this.aq;
        }
    }

    com.corrodinggames.rts.game.units.BaseUnit e() {
        if (this.a.bZ.size() > 0) {
            return this.a.bZ.a(0);
        }
        return null;
    }

    com.corrodinggames.rts.game.units.BaseUnit f() {
        com.corrodinggames.rts.game.units.BaseUnit am2 = null;
        if (this.a.aX > 0) {
            com.corrodinggames.rts.game.units.BaseUnit[] amArray = this.a.bZ.a();
            int n2 = this.a.bZ.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                com.corrodinggames.rts.game.units.BaseUnit am3 = amArray[i2];
                if (!am3.cG)
                    continue;
                if (am2 == null) {
                    am2 = am3;
                    continue;
                }
                if (!com.corrodinggames.rts.gameFramework.f.GameUIController.a(am2, am3)) {
                    am2 = null;
                    break;
                }
                if (am2.V() <= am3.V())
                    continue;
                am2 = am3;
            }
        }
        return am2;
    }

    public static boolean a(com.corrodinggames.rts.game.units.BaseUnit am2, com.corrodinggames.rts.game.units.BaseUnit am3) {
        UnitType as2;
        UnitType as3 = am2.r();
        if (as3 == (as2 = am3.r())) {
            return true;
        }
        if (as3 instanceof com.corrodinggames.rts.game.units.custom.l
                && as2 instanceof com.corrodinggames.rts.game.units.custom.l) {
            com.corrodinggames.rts.game.units.custom.l l2 = (com.corrodinggames.rts.game.units.custom.l) as3;
            com.corrodinggames.rts.game.units.custom.l l3 = (com.corrodinggames.rts.game.units.custom.l) as2;
            if (l2.fL.contains(as2)) {
                return true;
            }
            if (l2.fO != null && com.corrodinggames.rts.game.units.custom.g.a(l2.fO, l3.x())) {
                return true;
            }
            if (l3.fO != null && com.corrodinggames.rts.game.units.custom.g.a(l3.fO, l2.x())) {
                return true;
            }
        }
        return false;
    }

    ArrayList g() {
        this.ax.clear();
        com.corrodinggames.rts.game.units.BaseUnit[] amArray = this.a.bZ.a();
        int n2 = this.a.bZ.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            com.corrodinggames.rts.game.units.BaseUnit am2 = amArray[i2];
            if (!(am2 instanceof y))
                continue;
            this.ax.add((y) am2);
        }
        return this.ax;
    }

    float h() {
        float f2 = this.b.cm / 14.0f / this.b.cj;
        f2 = com.corrodinggames.rts.gameFramework.GameUtils.b(f2, 25.0f * this.b.cj, 40.0f * this.b.cj);
        return f2;
    }

    private boolean c(AbstractUnitAction s2) {
        if (s2.s()) {
            return true;
        }
        if (s2 instanceof com.corrodinggames.rts.game.units.a.WrapperUnitAction) {
            com.corrodinggames.rts.game.units.a.WrapperUnitAction g2 = (com.corrodinggames.rts.game.units.a.WrapperUnitAction) s2;
            return this.a.m(g2.b);
        }
        ArrayList<y> arrayList = this.g();
        com.corrodinggames.rts.game.units.a.ActionId c2 = s2.N();
        for (y y2 : arrayList) {
            AbstractUnitAction s3 = y2.a(c2);
            if (s3 == null || !this.a.m(y2))
                continue;
            return true;
        }
        return false;
    }

    private boolean a(AbstractUnitAction s2, ArrayList arrayList) {
        FilteredUnitAction h2 = null;
        if (s2 instanceof FilteredUnitAction) {
            h2 = (FilteredUnitAction) s2;
        }
        if (h2 != null && h2.d == com.corrodinggames.rts.gameFramework.f.g.cd) {
            return h2.e;
        }
        boolean bl2 = this.b(s2, arrayList);
        if (h2 != null) {
            h2.d = com.corrodinggames.rts.gameFramework.f.g.cd;
            h2.e = bl2;
        }
        return bl2;
    }

    private boolean b(AbstractUnitAction s2, ArrayList<y> arrayList) {
        if (s2.s()) {
            return true;
        }
        if (s2 instanceof com.corrodinggames.rts.game.units.a.WrapperUnitAction) {
            com.corrodinggames.rts.game.units.a.WrapperUnitAction g2 = (com.corrodinggames.rts.game.units.a.WrapperUnitAction) s2;
            if (!g2.r(g2.b)) {
                return false;
            }
            return this.a.m(g2.b) || g2.a((com.corrodinggames.rts.game.units.BaseUnit) g2.b, this.b.bs);
        }
        com.corrodinggames.rts.game.units.a.ActionId c2 = s2.N();
        for (y y2 : arrayList) {
            AbstractUnitAction s3 = y2.a(c2);
            if (s3 == null || !s3.r(y2) || !this.a.m(y2) && !s3.a((com.corrodinggames.rts.game.units.BaseUnit) y2, this.b.bs))
                continue;
            return true;
        }
        return false;
    }

    private boolean c(AbstractUnitAction s2, ArrayList<y> arrayList) {
        Object object;
        if (s2.s()) {
            return true;
        }
        if (s2 instanceof com.corrodinggames.rts.game.units.a.WrapperUnitAction
                && ((com.corrodinggames.rts.game.units.a.WrapperUnitAction) (object = (com.corrodinggames.rts.game.units.a.WrapperUnitAction) s2)).a(
                        (com.corrodinggames.rts.game.units.BaseUnit) ((com.corrodinggames.rts.game.units.a.WrapperUnitAction) object).b,
                        true)) {
            return true;
        }
        for (y y2 : arrayList) {
            AbstractUnitAction s3 = y2.a(s2.N());
            if (s3 == null || !s3.a((com.corrodinggames.rts.game.units.BaseUnit) y2, true))
                continue;
            return true;
        }
        return false;
    }

    private float d(AbstractUnitAction s2, ArrayList<y> arrayList) {
        int n2 = 0;
        float f2 = -1.0f;
        if (s2.o_()) {
            return -1.0f;
        }
        for (y y2 : arrayList) {
            float f3;
            AbstractUnitAction s3 = y2.a(s2.N());
            if (s3 == null || !((f3 = s3.p(y2)) > f2))
                continue;
            f2 = f3;
            ++n2;
        }
        return f2;
    }

    private com.corrodinggames.rts.game.units.g.e d(AbstractUnitAction s2) {
        float f2 = -1.0f;
        Object object = null;
        if (s2.o_()) {
            return null;
        }
        if (s2 instanceof com.corrodinggames.rts.game.units.a.WrapperUnitAction) {
            com.corrodinggames.rts.game.units.a.WrapperUnitAction g2 = (com.corrodinggames.rts.game.units.a.WrapperUnitAction) s2;
            Object object2 = com.corrodinggames.rts.game.units.g.e.b(g2.b, s2.N());
            if (object2 != null) {
                if (f2 < (float) ((com.corrodinggames.rts.game.units.g.a) object2).a()) {
                    f2 = ((com.corrodinggames.rts.game.units.g.a) object2).a();
                    object = object2;
                }
            } else {
                return null;
            }
        }
        for (Object object2 : this.a.bZ) {
            y y2;
            AbstractUnitAction s3;
            if (!(object2 instanceof y) || (s3 = (y2 = (y) object2).a(s2.N())) == null)
                continue;
            com.corrodinggames.rts.game.units.g.e e2 = com.corrodinggames.rts.game.units.g.e.b(y2, s2.N());
            if (e2 != null) {
                if (!(f2 < (float) e2.a()))
                    continue;
                f2 = e2.a();
                object = e2;
                continue;
            }
            return null;
        }
        if (object == null) {
            return null;
        }
        return (com.corrodinggames.rts.game.units.g.e) object;
    }

    private float e(AbstractUnitAction s2) {
        com.corrodinggames.rts.game.units.g.e e2 = this.d(s2);
        if (e2 == null) {
            return 0.0f;
        }
        return e2.c();
    }

    float b(AbstractUnitAction s2) {
        com.corrodinggames.rts.game.units.g.e e2 = this.d(s2);
        if (e2 == null) {
            return 0.0f;
        }
        return e2.d();
    }

    /*
     * Could not resolve type clashes
     */
    int d(float var1) throws IOException {
        this.ap = false;
        byte var2 = 1;
        if (com.corrodinggames.rts.gameFramework.f.g.bP) {
            var2 = 2;
        }

        boolean var3 = false;
        int var4 = 0;
        boolean var5 = false;
        com.corrodinggames.rts.gameFramework.f.c.a(var1);
        ArrayList var6 = this.g();
        com.corrodinggames.rts.game.units.BaseUnit var7 = this.f();
        ArrayList var8 = null;
        if (this.a.ac != null) {
            var8 = this.a.ac.q(var7);
        }

        ArrayList var9;
        if (var8 != null) {
            var9 = var8;
        } else {
            var9 = this.a(var7, var6);
        }

        if (var7 == null && var9.size() > 0) {
            var7 = this.e();
            if (var7 == null && com.corrodinggames.rts.game.units.custom.l.b != null) {
                var7 = com.corrodinggames.rts.game.units.BaseUnit.c(com.corrodinggames.rts.game.units.custom.l.b);
            }
        }

        this.a.t = false;
        if (var9.contains(this.a.m)) {
            this.a.t = true;
        }

        if (var7 == null) {
            var7 = this.e();
        }

        boolean var10 = true;
        if (var7 == null) {
            this.ad = -1L;
        }

        if (var7 != null) {
            int var11 = var9.size();
            if (var11 > 0) {
                ArrayList var12 = var9;
                float var13 = 2.0F;
                float var14 = this.h();
                float var15 = 2.0F;
                float var16 = var14 + var15;
                boolean var20 = false;
                float var17;
                float var18;
                float var19;
                if (!com.corrodinggames.rts.gameFramework.f.g.bR) {
                    var19 = (float) (this.b.bW.b() + 2);
                    var18 = this.b.cl - this.b.bW.c;
                    var17 = this.b.bW.c;
                } else {
                    var19 = this.b.bW.b;
                    var18 = this.b.bW.c;
                    var17 = this.b.bW.c;
                    var20 = true;
                }

                if (com.corrodinggames.rts.gameFramework.f.g.bO) {
                    var14 += 15.0F * this.b.cj;
                    var16 += 15.0F * this.b.cj;
                    var13 = 2.0F * this.b.cj;
                    if (com.corrodinggames.rts.gameFramework.GameEngine.au()) {
                        var13 = 2.0F * this.b.cj;
                    }

                    var16 += 2.0F;
                    var15 += 2.0F;
                    var19 += 3.0F;
                }

                float var22;
                if (!com.corrodinggames.rts.gameFramework.f.g.a) {
                    boolean var21 = true;
                    if (this.a.f != null && this.a.aX == 1 && this.a.f.cG) {
                        var21 = false;
                    }

                    if (var21) {
                        var22 = this.i();
                        var19 += var22;
                        var19 += 2.0F;
                    }
                }

                int var82 = 0;
                var22 = 0.0F;
                float var23 = 0.0F;
                float var24 = 0.0F;
                Iterator var25 = var9.iterator();

                float var27;
                float var29;
                boolean var30;
                while (var25.hasNext()) {
                    AbstractUnitAction var26 = (AbstractUnitAction) var25.next();
                    if (this.a(var26, var6)) {
                        ++var82;
                        var27 = var16 * var26.l();
                        int var28 = var2;
                        if (var26.m() > 0) {
                            var28 = var26.m();
                        }

                        var29 = var17 / (float) var28;
                        var30 = false;
                        if (var23 + var29 - 0.1F >= var17) {
                            var30 = true;
                        }

                        if (!var30 && var22 > 0.0F && var27 + 0.1F < var22) {
                            var30 = true;
                        }

                        if (var30) {
                            var24 += var22;
                            var22 = 0.0F;
                            var23 = 0.0F;
                        }

                        if (var22 < var27) {
                            var22 = var27;
                        }

                        var23 += var29;
                    }
                }

                if (var23 > 0.0F) {
                    var24 += var22;
                }

                float var83 = var19 + var24;
                float var84 = var19++;
                if (this.b.bQ.showUnitGroups) {
                    var27 = this.b.cameraShakeIntensity - 34.0F * this.b.cj;
                } else {
                    var27 = this.b.cameraShakeIntensity;
                }

                this.ad = var7.objectId;
                var19 -= (float) ((int) var7.br);
                float var85 = 0.0F;
                var29 = 1.0F + var14 * 0.25F;
                var30 = var83 - var7.br > var27 + var29;
                boolean var31 = var7.br > var29;
                this.ap = var30 || var31;
                if (this.b.bQ.mouseSupport && !this.a.a(this.b.af(), this.b.ag())) {
                    int var32 = this.b.ai();
                    if (var32 != 0) {
                        var85 = -((float) var32 / 120.0F);
                    }
                }

                float var86 = 0.0F;
                if (var85 > 0.0F) {
                    this.ao = (float) ((double) this.ao + 0.5 * (double) var16);
                }

                if (var85 < 0.0F) {
                    this.ao = (float) ((double) this.ao - 0.5 * (double) var16);
                }

                float var33;
                if (var30) {
                    var33 = 0.4F;
                    this.s.left = (int) (var18 + 2.0F);
                    this.s.c = (int) (var18 + var17 - 2.0F);
                    this.s.top = (int) (var27 - var14 * var33);
                    this.s.d = (int) ((float) this.s.top + var14 * var33);
                    if (this.a.a(this.s.left, this.s.top, this.s.b(), this.s.c(), "\\/",
                            com.corrodinggames.rts.gameFramework.f.i.none, false, Color.a(80, 100, 150, 100), this.a.aC,
                            (com.corrodinggames.rts.gameFramework.f.a.h) null) && this.a.J()) {
                        var86 += 3.0F * var16;
                        this.a.U = false;
                    }

                    var27 -= var16 * var33 + 2.0F;
                }

                if (var31) {
                    var33 = 0.4F;
                    this.s.left = (int) (var18 + 2.0F);
                    this.s.c = (int) (var18 + var17 - 2.0F);
                    this.s.top = (int) var84;
                    this.s.d = (int) ((float) this.s.top + var14 * var33);
                    if (this.a.a(this.s.left, this.s.top, this.s.b(), this.s.c(), "/\\",
                            com.corrodinggames.rts.gameFramework.f.i.none, false, Color.a(80, 100, 150, 100), this.a.aC,
                            (com.corrodinggames.rts.gameFramework.f.a.h) null) && this.a.J()) {
                        var86 -= 3.0F * var16;
                        this.a.U = false;
                    }

                    var84 += var16 * var33 + 2.0F;
                }

                this.b.bO.i();
                this.ay.a(0.0F, var84 - 1.0F, this.b.cl, var27 + 1.0F);
                this.b.bO.a(this.ay);
                if (com.corrodinggames.rts.gameFramework.GameEngine.au()) {
                    if (this.ad != var7.objectId) {
                        this.ae = 0.0F;
                        this.af = var7.br;
                    } else if (this.ao != 0.0F) {
                        this.ae = this.ao;
                    } else {
                        if (!this.a.I) {
                            this.ao += this.ae * var1;
                        }

                        this.ae = com.corrodinggames.rts.gameFramework.GameUtils.a(this.ae, var1);
                    }
                }

                var7.br += this.ao + var86;
                this.ao = 0.0F;
                var33 = 0.0F;
                int var34 = (int) (var83 - var27);
                if (var34 > 0) {
                    if (var7.br > (float) var34 + var33) {
                        var7.br = (float) var34 + var33;
                    }

                    if (var7.br < 0.0F - var33) {
                        var7.br = 0.0F - var33;
                    }
                } else {
                    var7.br = 0.0F;
                }

                var3 = true;
                int var35 = -1;
                float var36 = 0.0F;
                var22 = 0.0F;
                var23 = 0.0F;
                this.c();
                Iterator var37 = var9.iterator();

                label760: while (true) {
                    AbstractUnitAction var38;
                    do {
                        if (!var37.hasNext()) {
                            this.b.bO.j();
                            this.ay.f();
                            break label760;
                        }

                        var38 = (AbstractUnitAction) var37.next();
                    } while (!this.a(var38, var6));

                    ++var4;
                    boolean var39 = this.c(var38, var6);
                    ++var35;
                    float var40 = var14 * var38.l();
                    int var41 = var2;
                    if (var38.m() > 0) {
                        var41 = var38.m();
                    }

                    float var42 = var17 / (float) var41;
                    float var43;
                    float var44;
                    if (!var20) {
                        var43 = var40;
                        var44 = var42;
                    } else {
                        var43 = var42;
                        var44 = var40;
                    }

                    boolean var45 = false;
                    if (var23 + var44 - 0.1F > var17) {
                        var45 = true;
                    }

                    if (!var45 && var22 > 0.0F && var43 + 0.1F < var22) {
                        var45 = true;
                    }

                    if (var45) {
                        var36 += var22 + var15;
                        var22 = 0.0F;
                        var23 = 0.0F;
                    }

                    if (var22 < var43) {
                        var22 = var43;
                    }

                    if (!var20) {
                        this.s.left = (int) (var18 + var13);
                        this.s.c = (int) ((float) this.s.left + var42 - var13 * 2.0F);
                        this.s.top = (int) (var36 + var19);
                        this.s.d = (int) ((float) this.s.top + var40);
                        this.s.a((int) var23, 0);
                    } else {
                        this.s.left = (int) (var18 + var13 + var36);
                        this.s.c = (int) ((float) this.s.left + var42 - var13 * 2.0F);
                        this.s.top = (int) var19;
                        this.s.d = (int) ((float) this.s.top + var40);
                        this.s.a(0, (int) var23);
                    }

                    boolean var46 = true;
                    this.t.a(this.s);
                    if (!this.t.b(this.ay)) {
                        var46 = false;
                    }

                    var23 += var44;
                    ActionDisplayType var47 = var38.f();
                    boolean var48 = false;
                    if (var47 == com.corrodinggames.rts.game.units.a.ActionDisplayType.infoOnly
                            || var47 == com.corrodinggames.rts.game.units.a.ActionDisplayType.infoOnlyNoBox
                            || var47 == com.corrodinggames.rts.game.units.a.ActionDisplayType.infoOnlyStockpile) {
                        var48 = true;
                    }

                    boolean var50 = a(var38);
                    boolean var51 = var38.G();
                    Paint var52 = this.j;
                    boolean var53 = var39;
                    if (var47 == com.corrodinggames.rts.game.units.a.ActionDisplayType.infoOnlyStockpile) {
                        var53 = true;
                    }

                    if (var53) {
                        var52.b(Color.a(70, 100, 100, 100));
                    } else {
                        var52.b(Color.a(50, 170, 100, 100));
                    }

                    if (var50) {
                        var52.b(Color.a(100, 180, 100, 100));
                    }

                    boolean var54 = false;
                    boolean var55 = false;
                    if (this.aa == var7 && this.ab == var38) {
                        var54 = true;
                    }

                    if (this.a.ac == var38) {
                        var54 = true;
                        var55 = true;
                    }

                    if (var54) {
                        var52.b(Color.a(80, 100, 100, 200));
                    }

                    if (var55) {
                        var52.b(Color.a(80, 100, 200, 100));
                    }

                    ag var56;
                    if (var51) {
                        var52.c((int) ((float) var52.f() * 0.7F));
                        var56 = this.o;
                    } else {
                        var56 = this.n;
                    }

                    float var57 = 0.0F;
                    float var60;
                    if (var46) {
                        var57 = com.corrodinggames.rts.gameFramework.f.c.b(var7, var38, false);
                        if (var38.f() != com.corrodinggames.rts.game.units.a.ActionDisplayType.infoOnlyNoBox) {
                            boolean var58 = this.a.a(var38);
                            float var59 = 0.0F;
                            if (var58) {
                                var60 = (float) (com.corrodinggames.rts.gameFramework.GameEngine.V() % 1000L) / 1000.0F;
                                var59 = com.corrodinggames.rts.gameFramework.GameUtils
                                        .c(com.corrodinggames.rts.gameFramework.GameUtils.k(var60 * 180.0F));
                            }

                            int var61;
                            if (var57 != 0.0F) {
                                var60 = com.corrodinggames.rts.gameFramework.GameUtils.c(var57) * 0.7F - 0.3F;
                                var60 = com.corrodinggames.rts.gameFramework.GameUtils.b(var60, 0.0F, 1.0F);
                                if (var57 > 0.0F) {
                                    var61 = Color.a(110, 210, 210, 210);
                                } else {
                                    var61 = Color.a(110, 210, 110, 110);
                                }

                                int var62 = com.corrodinggames.rts.gameFramework.GameUtils.a(var61, var52.e(), var60);
                                var52 = this.i;
                                var52.b(var62);
                            }

                            this.a.a(this.s, var52, var56);
                            var60 = this.d(var38, var6);
                            Rect var10000;
                            if (var60 >= 0.0F) {
                                this.l.a(80, 0, 0, 100);
                                this.B.a(this.s);
                                var10000 = this.B;
                                var10000.c = (int) ((float) var10000.c - (1.0F - var60) * (float) this.B.b());
                                this.b.bO.b(this.B, this.l);
                                this.m.a(190, 148, 189, 255);
                                this.b.bO.a((float) this.B.c, (float) this.B.top, (float) this.B.c, (float) this.B.d,
                                        this.l);
                            } else {
                                float var91 = this.e(var38);
                                if (var91 > 0.0F) {
                                    this.l.a(80, 100, 0, 0);
                                    this.B.a(this.s);
                                    var10000 = this.B;
                                    var10000.c = (int) ((float) var10000.c - (1.0F - var91) * (float) this.B.b());
                                    this.b.bO.b(this.B, this.l);
                                    this.m.a(190, 148, 189, 255);
                                    this.b.bO.a((float) this.B.c, (float) this.B.top, (float) this.B.c, (float) this.B.d,
                                            this.l);
                                }
                            }

                            var61 = Color.a(255, 0, 0, 0);
                            if (com.corrodinggames.rts.gameFramework.f.g.bO) {
                                var61 = Color.a(100, 0, 0, 0);
                                if (var51) {
                                    var61 = Color.a(50, 155, 155, 155);
                                }
                            }

                            boolean var92 = false;
                            if (var58) {
                                var92 = true;
                                var61 = Color.a((int) (100.0F + 150.0F * var59), 255, 255, 255);
                            }

                            this.a.a(this.s, var61, var92);
                        }
                    }

                    KeyBinding var87 = this.a(var38, var35, var12);
                    if (var87 != null && var46) {
                        String var88 = var87.c();
                        var60 = (float) this.b.bO.a("A", this.a.az);
                        this.b.bO.a(var88, (float) (this.s.left + 3), (float) this.s.top + var60 + 1.0F, this.a.az);
                    }

                    boolean var89 = false;
                    UnitType var90 = var38.i();
                    com.corrodinggames.rts.gameFramework.m.Texture_M var95 = var38.j();
                    com.corrodinggames.rts.game.units.BaseUnit var93 = var38.i(var7);
                    if (var93 != null) {
                        var90 = var93.r();
                    }

                    if (var95 == null && var90 != null) {
                        var95 = var90.z();
                    }

                    float var64;
                    float var65;
                    float var66;
                    float var67;
                    boolean var69;
                    boolean var70;
                    int var72;
                    int var99;
                    if (var95 != null) {
                        Rect var94 = var38.v();
                        if (var94 == null) {
                            var94 = this.B;
                            var94.a(0, 0, var95.m(), var95.l());
                        }

                        var64 = (float) this.s.c() * 0.7F / (float) var94.c();
                        int var97 = (int) ((float) this.s.d() - (float) var94.b() * 0.5F * var64);
                        var99 = (int) ((float) this.s.e() - (float) var94.c() * 0.5F * var64);
                        this.p.a(100, 255, 255, 255);
                        RectF var102 = this.C;
                        var102.a((float) var97, (float) var99, (float) var97 + (float) var94.b() * var64,
                                (float) var99 + (float) var94.c() * var64);
                        this.b.bO.a(var95, var94, var102, this.p);
                        var89 = true;
                    } else if (var90 != null) {
                        float var63 = (float) this.s.d();
                        var64 = (float) this.s.e();
                        if ((double) var57 > 0.5) {
                            ++var64;
                        }

                        if ((double) var57 < -0.5) {
                            --var64;
                        }

                        var65 = (float) this.s.c() * 0.7F;
                        var66 = (float) this.s.c() * 0.95F;
                        if (com.corrodinggames.rts.gameFramework.f.g.bO) {
                            var65 = (float) this.s.c() * 0.4F;
                            var66 = (float) this.s.c() * 0.85F;
                        }

                        this.x.a(this.s);
                        if (this.x.b(this.ay)) {
                            this.b.bO.i();
                            this.b.bO.a(this.x);
                            com.corrodinggames.rts.game.units.UnitTypeEnum.a(var90, var63, var64, 0.0F, 0.0F, var7.bX, var65,
                                    var66, false, false, var38.t(), var93);
                            if (var93 != null) {
                                var67 = var93.x();
                                float var68 = var93.bV();
                                int var71;
                                Paint var73;
                                Paint var74;
                                byte var75;
                                int var76;
                                byte var77;
                                int var78;
                                if (var68 != -1.0F && var38.t(var7)) {
                                    var69 = true;
                                    var70 = true;
                                    var71 = com.corrodinggames.rts.gameFramework.GameUtils.b(200, 0, 0, 150);
                                    var72 = com.corrodinggames.rts.gameFramework.GameUtils.b(120, 0, 0, 230);
                                    var73 = com.corrodinggames.rts.gameFramework.utility.y.a(var71, Paint$Style.a);
                                    var74 = com.corrodinggames.rts.gameFramework.utility.y.a(var72, Paint$Style.b);
                                    var75 = 3;
                                    var76 = (int) (this.x.b() / 3.0F) - 3;
                                    var77 = 0;
                                    var78 = var76 * 2;
                                    this.C.a(var63 - (float) var76, var64 + (float) var77,
                                            var63 - (float) var76 + (float) var78 * var68,
                                            var64 + (float) var77 + (float) var75);
                                    this.b.bO.a(this.C, var73);
                                    this.C.a(var63 - (float) var76, var64 + (float) var77,
                                            var63 - (float) var76 + (float) var78,
                                            var64 + (float) var77 + (float) var75);
                                    this.b.bO.a(this.C, var74);
                                } else if (var67 != -1.0F && var38.s(var7)) {
                                    var69 = true;
                                    var70 = true;
                                    var71 = com.corrodinggames.rts.gameFramework.GameUtils.b(200, 0, 150, 0);
                                    var72 = com.corrodinggames.rts.gameFramework.GameUtils.b(120, 0, 230, 0);
                                    var73 = com.corrodinggames.rts.gameFramework.utility.y.a(var71, Paint$Style.a);
                                    var74 = com.corrodinggames.rts.gameFramework.utility.y.a(var72, Paint$Style.b);
                                    var75 = 3;
                                    var76 = (int) (this.x.b() / 3.0F) - 3;
                                    var77 = 0;
                                    var78 = var76 * 2;
                                    this.C.a(var63 - (float) var76, var64 + (float) var77,
                                            var63 - (float) var76 + (float) var78 * var67,
                                            var64 + (float) var77 + (float) var75);
                                    this.b.bO.a(this.C, var73);
                                    this.C.a(var63 - (float) var76, var64 + (float) var77,
                                            var63 - (float) var76 + (float) var78,
                                            var64 + (float) var77 + (float) var75);
                                    this.b.bO.a(this.C, var74);
                                }
                            }

                            this.b.bO.j();
                        }

                        var89 = true;
                    }

                    com.corrodinggames.rts.gameFramework.m.Texture_M var96 = var38.h(var7);
                    if (var96 != null) {
                        Rect var98 = var38.v();
                        if (var98 == null) {
                            var98 = this.B;
                            var98.a(0, 0, var96.m(), var96.l());
                        }

                        var65 = (float) this.s.c() * 0.7F / (float) var98.c();
                        var99 = (int) ((float) this.s.d() - (float) var98.b() * 0.5F * var65);
                        int var104 = (int) ((float) this.s.e() - (float) var98.c() * 0.5F * var65);
                        this.p.b(var38.J());
                        RectF var106 = this.C;
                        var106.a((float) var99, (float) var104, (float) var99 + (float) var98.b() * var65,
                                (float) var104 + (float) var98.c() * var65);
                        this.b.bO.a(var96, var98, var106, this.p);
                        var89 = true;
                    }

                    if (var46) {
                        String var100 = var38.d();
                        if (var50) {
                            this.b.bO.a(this.T, (float) (this.s.left + 25), this.s.g(), (Paint) null);
                        }

                        var65 = (float) this.b.bO.b(var100, this.a.aC);
                        if (var65 > (float) (this.s.b() - 2)) {
                            var66 = (float) this.b.bO.b(var100, this.a.aB);
                            if (var66 > (float) (this.s.b() - 2)) {
                                this.i.a(this.a.aA);
                            } else {
                                this.i.a(this.a.aB);
                            }
                        } else {
                            this.i.a(this.a.aC);
                        }

                        if (!var53) {
                            this.i.b(Color.a(255, 0, 100, 0));
                        }

                        if (var47 == com.corrodinggames.rts.game.units.a.ActionDisplayType.rally) {
                            this.i.a(255, 255, 255, 255);
                        } else if (var47 != com.corrodinggames.rts.game.units.a.ActionDisplayType.upgrade
                                && var47 != com.corrodinggames.rts.game.units.a.ActionDisplayType.action) {
                            if (var47 == com.corrodinggames.rts.game.units.a.ActionDisplayType.queueUnit) {
                                UnitType var105 = var38.i();
                                if (var105 != null && var105.g() > 1) {
                                    if (!var53) {
                                        this.i.a(255, 117, 120, 15);
                                    } else {
                                        this.i.a(255, 235, 240, 30);
                                    }
                                }
                            } else if (var48) {
                                this.i.a(155, 255, 255, 255);
                            }
                        } else if (!var53) {
                            this.i.a(255, 19, 101, 94);
                        } else {
                            this.i.a(255, 39, 202, 189);
                        }

                        var99 = this.b.bO.a(var100, this.i);
                        var67 = this.s.g() + (float) (var99 / 2);
                        if (var48) {
                            var67 = this.s.g();
                        }

                        if (var89 && !var100.contains("\n")) {
                            if (var48) {
                                var67 = (float) (this.s.d - var99 / 2 - 1);
                            } else {
                                var67 = (float) (this.s.d - 6);
                            }
                        }

                        if (var48) {
                            com.corrodinggames.rts.gameFramework.m.aa.a(var100, this.s.f(), var67, this.i);
                        } else {
                            this.b.bO.a(var100, this.s.f(), var67, this.i);
                        }
                    }

                    boolean var103 = false;
                    boolean var101 = false;
                    boolean var107 = false;
                    if (var87 != null && var87.a()) {
                        var103 = true;
                        var107 = true;
                    }

                    this.u.a(this.s);
                    if (com.corrodinggames.rts.gameFramework.GameEngine.au()) {
                        com.corrodinggames.rts.gameFramework.GameUtils.b(this.u, 2.0F);
                    }

                    this.a.a((float) this.u.left, (float) this.u.top, (float) this.u.b(), (float) this.u.c());
                    if (!this.d && this.u.b((int) this.a.z, (int) this.a.A)
                            && this.ay.b((float) ((int) this.a.z), (float) ((int) this.a.A))) {
                        var5 = true;
                        if (com.corrodinggames.rts.gameFramework.GameEngine.av()) {
                            var101 = true;
                        }

                        if ((this.a.U || this.a.I) && this.a.U && this.a.J()) {
                            this.a.U = false;
                            var103 = true;
                        }
                    }

                    if (com.corrodinggames.rts.gameFramework.GameEngine.av() && this.a.ac == null) {
                        if (var101) {
                            this.aa = var7;
                            this.ab = var38;
                            this.ac = var36 + var19;
                        } else if (com.corrodinggames.rts.game.units.a.AbstractUnitAction.a(this.ab, var38)) {
                            this.aa = null;
                            this.ab = null;
                        }
                    }

                    boolean var110 = false;
                    if (var103 && !var107 && this.b.bQ.mouseSupport && this.b.e(2)) {
                        var110 = true;
                    }

                    if (var103) {
                        com.corrodinggames.rts.gameFramework.f.g.K();
                        if (var38.c(var7, var110)) {
                            var103 = false;
                        }

                        if (this.b.cb.j()) {
                            var103 = false;
                        }

                        if (!this.c(var38)) {
                            var103 = false;
                        }
                    }

                    if (var103) {
                        boolean var108;
                        if (var38.e() != com.corrodinggames.rts.game.units.a.ActionType.none
                                && var38.e() != com.corrodinggames.rts.game.units.a.ActionType.popupQueue) {
                            if (var38.e() != com.corrodinggames.rts.game.units.a.ActionType.patrol
                                    && var38.e() != com.corrodinggames.rts.game.units.a.ActionType.guardUnit
                                    && var38.e() != com.corrodinggames.rts.game.units.a.ActionType.pingMap) {
                                if (var38.e() != com.corrodinggames.rts.game.units.a.ActionType.setRally
                                        && var38.e() != com.corrodinggames.rts.game.units.a.ActionType.reclaimTarget
                                        && var38.e() != com.corrodinggames.rts.game.units.a.ActionType.repairTarget
                                        && var38.e() != com.corrodinggames.rts.game.units.a.ActionType.targetGround) {
                                    if (var38.e() == com.corrodinggames.rts.game.units.a.ActionType.placeBuilding) {
                                        if (a(var38)) {
                                            this.b.bM.b(com.corrodinggames.rts.gameFramework.sound.e.l, 0.8F);
                                        } else if (!var39) {
                                            this.b.bM.b(com.corrodinggames.rts.gameFramework.sound.e.l, 0.8F);
                                        } else {
                                            this.b.bM.b(com.corrodinggames.rts.gameFramework.sound.e.g, 0.8F);
                                        }

                                        com.corrodinggames.rts.gameFramework.f.c.a(var7, var38, false, false);
                                        this.aa = null;
                                        this.ab = null;
                                        if (this.a.ac == null) {
                                            this.a.ai = false;
                                        }

                                        this.a.aa = var7;
                                        this.a.ac = var38;
                                        this.a.af = 0.0F;
                                        this.a.aq = -99.0F;
                                        this.a.ar = -99.0F;
                                        if (!this.a.ae) {
                                            this.a.ag = this.b.cameraShakeDecay * this.b.cX;
                                            this.a.ah = this.b.cameraShakeTime * this.b.cX;
                                        }

                                        this.a.ae = true;
                                        this.b.bL.e();
                                    } else if (var38.e() == com.corrodinggames.rts.game.units.a.ActionType.directToAction) {
                                        com.corrodinggames.rts.gameFramework.f.c.a(var7, var38, false, false);
                                        var38.c(var7);
                                    } else {
                                        if (var38.e() != com.corrodinggames.rts.game.units.a.ActionType.infoOnly) {
                                            throw new RuntimeException("unknown gui action:" + var38.e());
                                        }

                                        if (var38.C()) {
                                            this.aa = var7;
                                            this.ab = var38;
                                            this.ac = var36 + var19;
                                            this.a.ac = null;
                                        }
                                    }
                                } else {
                                    var108 = false;
                                    var69 = false;
                                    if (var38.e() == com.corrodinggames.rts.game.units.a.ActionType.targetGround) {
                                        var69 = true;
                                    }

                                    if (var110 && var69) {
                                        var108 = true;
                                    }

                                    if (var108) {
                                        com.corrodinggames.rts.gameFramework.GameCommand var112 = this.a.x();
                                        if (!var38.I()) {
                                            this.a.a(var112, var38);
                                        } else {
                                            this.a.a(var112, var38, var108);
                                        }

                                        var112.g = true;
                                        var112.a(var38.z());
                                    } else {
                                        com.corrodinggames.rts.gameFramework.GameEngine
                                                .log("Clicked button: actionActive: " + var39);
                                        if (!var39) {
                                            this.b.bM.b(com.corrodinggames.rts.gameFramework.sound.e.l, 0.8F);
                                        } else {
                                            com.corrodinggames.rts.gameFramework.f.c.a(var7, var38, false, false);
                                            this.aa = null;
                                            this.ab = null;
                                            this.a.ac = var38;
                                        }
                                    }
                                }
                            } else if (var110) {
                                if (var38 != null && var38.equals(this.a.ac)) {
                                    this.a.l();
                                }
                            } else if (!var39) {
                                this.b.bM.b(com.corrodinggames.rts.gameFramework.sound.e.l, 0.8F);
                            } else {
                                com.corrodinggames.rts.gameFramework.f.c.a(var7, var38, false, false);
                                this.aa = null;
                                this.ab = null;
                                this.a.ac = var38;
                            }
                        } else {
                            this.a.ac = null;
                            var108 = false;
                            if (var107) {
                                var108 = true;
                            } else if (!var38.u()) {
                                var108 = true;
                            } else {
                                if (var38.k(var7)) {
                                    var108 = true;
                                } else if (this.aa == var7 && com.corrodinggames.rts.game.units.a.AbstractUnitAction.a(this.ab, var38)) {
                                    var108 = true;
                                }

                                this.aa = var7;
                                this.ab = var38;
                                this.ac = var36 + var19;
                            }

                            if (var108) {
                                byte var109 = 1;
                                if (var38.g()) {
                                    if (this.a.a(this.b)) {
                                        var109 = 5;
                                    }

                                    if (this.a.b(this.b)) {
                                        var109 = 10;
                                    }
                                }

                                var70 = false;
                                boolean var111;
                                if (!var107) {
                                    var111 = false;
                                    if (var7 != null && var38.b(var7, false) != -1) {
                                        var111 = true;
                                    }

                                    if (var110 && var111) {
                                        var70 = true;
                                    }
                                }

                                if (a(var38)) {
                                    this.b.bM.b(com.corrodinggames.rts.gameFramework.sound.e.l, 0.8F);
                                } else if (!var39 && !var70) {
                                    this.b.bM.b(com.corrodinggames.rts.gameFramework.sound.e.l, 0.8F);
                                } else {
                                    var111 = var38.g();
                                    if (var111 && !var70 && this.b.bs.x() <= this.b.bs.w()) {
                                        this.a.b(this.al);
                                    }

                                    if (var111) {
                                        if (!var70) {
                                            this.b.bM.b(com.corrodinggames.rts.gameFramework.sound.e.h, 0.5F);
                                        } else {
                                            this.b.bM.b(com.corrodinggames.rts.gameFramework.sound.e.i, 0.5F);
                                        }
                                    } else {
                                        this.b.bM.b(com.corrodinggames.rts.gameFramework.sound.e.g, 0.8F);
                                    }

                                    com.corrodinggames.rts.gameFramework.f.c.a(var7, var38, var70, false);

                                    for (var72 = 0; var72 < var109; ++var72) {
                                        com.corrodinggames.rts.gameFramework.GameCommand var113 = this.a.x();
                                        if (!var38.I()) {
                                            this.a.a(var113, var38);
                                        } else {
                                            this.a.a(var113, var38, var70);
                                        }

                                        if (var70) {
                                            var113.g = true;
                                        }

                                        var113.a(var38.z());
                                        if (!var70) {
                                            this.a.a(var38, (PointF) null, (com.corrodinggames.rts.game.units.BaseUnit) null,
                                                    var113);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (this.ab == var38) {
                        var10 = var39;
                    }
                }
            }
        }

        if (var7 != null && var7 == this.aa) {
            if (this.ab != null) {
                boolean var79 = true;
                if (com.corrodinggames.rts.gameFramework.GameEngine.av()) {
                    var79 = false;
                }

                boolean var80 = false;
                if (this.ab.u()) {
                    var80 = true;
                }

                if (com.corrodinggames.rts.gameFramework.GameEngine.av() && this.ab.h()) {
                    var80 = true;
                }

                if (var80) {
                    boolean var81 = true;
                    if (!var10) {
                        var81 = false;
                    }

                    if (this.a.a(this.ab, var79, this.aa, !var81, true, this.ac, false)) {
                        this.aa = null;
                    }
                }
            }
        } else {
            this.aa = null;
        }

        if (com.corrodinggames.rts.gameFramework.GameEngine.av() && !var5) {
            this.aa = null;
            this.ab = null;
        }

        return var4;
    }

    float i() {
        float f2 = this.b.cm / 14.0f / this.b.cj;
        f2 = com.corrodinggames.rts.gameFramework.GameUtils.b(f2, 25.0f * this.b.cj, 40.0f * this.b.cj);
        f2 = (float) ((double) f2 * 0.9);
        return f2;
    }

    void a(float f2, int n2) {
        boolean bl2 = true;
        if (n2 == 0) {
            bl2 = true;
        }
        if (com.corrodinggames.rts.gameFramework.f.g.a) {
            bl2 = false;
        }
        if (this.a.aX > 0) {
            float f3;
            int n3;
            if (this.a.f != null && this.a.aX == 1 && this.a.f.cG) {
                bl2 = false;
            }
            if (bl2) {
                float f4 = this.i();
                if (this.a.b((int) (this.b.cl - this.b.bW.c + 2.0f), this.b.bW.b() + 2, (int) (this.b.bW.c - 4.0f),
                        (int) f4, this.ag, com.corrodinggames.rts.gameFramework.f.i.unselectAllButton, false,
                        Color.a(140, 100, 100, 100)) && !this.a.T) {
                    this.a.d();
                    this.a.l();
                    this.a.y();
                }
            }
            PlayerTeam n4 = null;
            boolean bl3 = false;
            this.az.clear();
            com.corrodinggames.rts.game.units.BaseUnit am2 = null;
            com.corrodinggames.rts.game.units.BaseUnit[] amArray = this.a.bZ.a();
            int n5 = this.a.bZ.size();
            for (n3 = 0; n3 < n5; ++n3) {
                com.corrodinggames.rts.game.units.BaseUnit am3 = amArray[n3];
                if (!am3.cG)
                    continue;
                am2 = am3;
                if (this.a.m(am3)) {
                    UnitType as2 = am3.r();
                    Integer n6 = (Integer) this.az.get(as2);
                    if (n6 == null) {
                        this.az.put(as2, 1);
                    } else {
                        this.az.put(as2, n6 + 1);
                    }
                    bl3 = true;
                    continue;
                }
                n4 = am3.bX;
            }
            n3 = this.b.bv ? 1 : 0;
            if (n4 != null && this.b.bs != null && n4.b(this.b.bs)) {
                n3 = 1;
            }
            n5 = (int) this.h();
            int n7 = n5 + 2;
            int n8 = (int) (10.0f * this.b.cj);
            float f5 = f3 = (float) (this.b.bW.b() + n5 + 30);
            float f6 = this.b.cl - this.b.cq + (float) n8;
            f5 += 5.0f;
            if (am2 != null) {
                f5 += (float) n7;
                f5 += (float) (n7 * n2);
                if (this.a.t) {
                    f5 -= (float) (2 * n7) * 0.4f;
                }
            }
            this.s.a((int) f6, (int) f5, (int) (f6 + this.b.cq - (float) (n8 * 2)), (int) (f5 + (float) n5));
            boolean bl4 = false;
            if (!com.corrodinggames.rts.gameFramework.f.g.bQ) {
                Object object;
                Object object2;
                if (n2 < 3 && !bl3 && n4 != null) {
                    object2 = this.a.aF;
                    if (this.b.bs.d(n4)) {
                        object2 = this.a.aG;
                    }
                    object = this.a(n4);
                    this.a.a((String) object, this.s, (Paint) object2, (Paint) object2);
                    bl4 = true;
                }
                if (this.a.q() == 1 && am2 != null && (am2.cq() <= 3 || n4 != null && n3 == 0)) {
                    object2 = this.a(am2, false);
                    if (bl4) {
                        object2 = "\n" + (String) object2;
                        object2 = "\n" + (String) object2;
                        object2 = "\n" + (String) object2;
                    }
                    object = this.i;
                    ((Paint) object).a();
                    ((Paint) object).b(Color.a(50, 100, 100, 100));
                    this.a.a((String) object2, this.s, this.a.aH, this.a.aH);
                }
            }
        }
    }

    public String a(PlayerTeam n2) {
        String string2 = "";
        boolean bl2 = false;
        if (this.b.bs.b()) {
            bl2 = true;
        } else if (this.b.bs.d(n2)) {
            string2 = string2 + this.ah;
        } else if (this.b.bs.c(n2)) {
            string2 = string2 + this.ai;
        } else {
            bl2 = true;
        }
        if (bl2) {
            string2 = n2 == com.corrodinggames.rts.game.PlayerTeam.i ? string2 + this.aj : string2 + "Team - " + n2.h();
        }
        string2 = string2 + "\n";
        if (n2.v != null) {
            string2 = string2 + n2.v;
        }
        if (!n2.w && this.b.N() && n2.B()) {
            string2 = string2 + "\n";
            string2 = string2 + "(disconnected)";
        }
        return string2;
    }

    public String a(com.corrodinggames.rts.game.units.BaseUnit am2, boolean bl2) {
        com.corrodinggames.rts.game.units.custom.d.b b2;
        String string2 = "";
        if (bl2) {
            string2 = string2 + am2.r().e() + "\n";
        }
        if (am2.g() > 0.0f) {
            b2 = am2.cM();
            float f2 = am2.cu / am2.cv;
            com.corrodinggames.rts.game.units.custom.d.b b3 = com.corrodinggames.rts.game.units.custom.d.b.a(b2, f2);
            boolean bl3 = false;
            String string3 = b3.a(true, true, 3, bl3);
            string2 = string2 + string3;
        } else {
            string2 = string2 + (int) Math.ceil(am2.cu) + "/" + (int) am2.cv + "\n";
        }
        if (am2.cA != 0.0f) {
            string2 = string2 + "(" + (int) am2.cx + "/" + (int) am2.cA + ")\n";
        }
        b2 = am2.dq();
        com.corrodinggames.rts.game.units.custom.e.f f3 = am2.cz();
        if (b2 != null) {
            f3 = com.corrodinggames.rts.game.units.custom.e.f.d(f3);
            f3.a(b2);
        }
        if (!f3.c()) {
            for (com.corrodinggames.rts.game.units.custom.e.e e2 : ((List<com.corrodinggames.rts.game.units.custom.e.e>) f3.b)) {
                if (e2.b == 0.0 || e2.a.a())
                    continue;
                string2 = string2 + e2.a.a(e2.b, true, false) + "\n";
            }
        }
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.j(string2);
        return string2;
    }

    public static String a(AbstractUnitAction s2, boolean bl2) {
        com.corrodinggames.rts.game.units.a.PopupQueueAction w2;
        float f2;
        String string2 = bl2 ? "\n" : " | ";
        String string3 = "";
        if (s2 instanceof com.corrodinggames.rts.game.units.a.PopupQueueAction
                && (f2 = (w2 = (com.corrodinggames.rts.game.units.a.PopupQueueAction) s2).K()) < 1.0f) {
            GameEngine l2 = GameEngine.getInstance();
            float f3 = -1.0f;
            com.corrodinggames.rts.game.units.BaseUnit[] amArray = l2.bS.bZ.a();
            int n2 = l2.bS.bZ.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                com.corrodinggames.rts.game.units.BaseUnit am2 = amArray[i2];
                float f4 = am2.cx();
                if (f3 != -1.0f && !(f4 < f3))
                    continue;
                f3 = f4;
            }
            if (f3 == -1.0f) {
                f3 = 1.0f;
            }
            float f5 = 1.0f / (w2.K() * f3 * 60.0f) + 1.0E-4f;
            string3 = string3 + com.corrodinggames.rts.gameFramework.GameUtils.h(f5) + string2;
        }
        string3 = com.corrodinggames.rts.gameFramework.GameUtils.a(string3, string2);
        return string3;
    }

    public static String a(com.corrodinggames.rts.game.units.BaseUnit am2, boolean bl2, boolean bl3, boolean bl4) {
        String string2;
        com.corrodinggames.rts.game.units.custom.e.f f2;
        int n2;
        float f3;
        String string3 = bl3 ? "\n" : " | ";
        String string4 = "";
        j j2 = null;
        com.corrodinggames.rts.game.units.custom.l l2 = null;
        if (am2 instanceof j) {
            j2 = (j) am2;
            l2 = j2.x;
        }
        if (bl2) {
            string4 = string4 + am2.r().e() + string3;
        }
        if (l2 == null || !l2.aO) {
            string4 = !bl4 ? string4 + "HP: " + (int) Math.ceil(am2.cu) + "/" + (int) am2.cv + string3
                    : string4 + "HP: " + (int) am2.cv + string3;
        }
        if (am2.cA != 0.0f) {
            string4 = !bl4 ? string4 + "Shield: " + (int) am2.cx + "/" + (int) am2.cA + string3
                    : string4 + "Shield: " + (int) am2.cA + string3;
        }
        if (j2 != null && (f3 = j2.y.l) >= 1.0f) {
            string4 = string4 + "Armour: " + (int) f3 + string3;
        }
        com.corrodinggames.rts.game.units.custom.d.b b2 = am2.dq();
        float f4 = am2.cy();
        if (b2 != null) {
            f4 += (float) b2.a();
        }
        if (f4 != 0.0f) {
            string4 = f4 < 0.0f
                    ? string4 + "Income: -$" + com.corrodinggames.rts.gameFramework.GameUtils.a(-f4, 1) + string3
                    : string4 + "Income: +$" + com.corrodinggames.rts.gameFramework.GameUtils.a(f4, 1) + string3;
        }
        if (am2 instanceof y) {
            ArrayList<UnitStatistics> arrayList;
            y y2 = (y) am2;
            if (y2.bd() != 0.0f && !bl4) {
                string4 = string4 + "Energy: " + com.corrodinggames.rts.gameFramework.GameUtils.g(am2.cB) + "/"
                        + com.corrodinggames.rts.gameFramework.GameUtils.g(y2.bd()) + string3;
            }
            float f5 = y2.z();
            if (!y2.aR()) {
                f5 = 0.0f;
            }
            if (f5 != 0.0f) {
                string4 = string4 + "Speed: " + com.corrodinggames.rts.gameFramework.GameUtils.g(f5) + string3;
            }
            if (y2.l() && (arrayList = y2.aX()).size() > 0) {
                string4 = string4 + "Attack: ";
                n2 = 1;
                for (UnitStatistics aa2 : arrayList) {
                    if (n2 == 0) {
                        string4 = string4 + ", ";
                    }
                    n2 = 0;
                    string4 = string4 + com.corrodinggames.rts.gameFramework.GameUtils.g(aa2.a);
                    if (aa2.d > 1) {
                        string4 = string4 + "x" + aa2.d;
                    }
                    string4 = string4 + "/" + com.corrodinggames.rts.gameFramework.GameUtils.g(aa2.a()) + "s";
                }
                string4 = string4 + string3;
            }
            float f6 = y2.m();
            if (!y2.l()) {
                f6 = 0.0f;
            }
            if (f6 != 0.0f) {
                string4 = string4 + "Range: " + com.corrodinggames.rts.gameFramework.GameUtils.g(f6) + string3;
            }
            if (bl4 && y2.ck()) {
                string4 = string4 + "Upgradable" + string3;
            }
        }
        if (!bl4 && am2.cU > 0) {
            string4 = string4 + "Kills: " + am2.cU + string3;
        }
        boolean bl5 = false;
        if (com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bl) {
            b b3;
            string4 = string4 + "\n";
            string4 = string4 + "--Debug--" + string3;
            UnitType as2 = am2.r();
            string4 = string4 + "name: " + as2.i() + string3;
            if (as2 instanceof com.corrodinggames.rts.game.units.custom.l
                    && (b3 = ((com.corrodinggames.rts.game.units.custom.l) as2).J) != null) {
                String string5 = b3.a();
                string5 = com.corrodinggames.rts.gameFramework.GameUtils.a(string5, 30);
                string4 = string4 + "(mod: " + string5 + ")" + string3;
            }
            if (am2.objectId != 0L) {
                string4 = string4 + "id: " + am2.objectId + string3;
            }
            if (am2.cF != 0) {
                String string6 = "";
                for (n2 = 0; n2 < 32; ++n2) {
                    if (!com.corrodinggames.rts.game.units.custom.d.b.a(am2.cF, n2))
                        continue;
                    if (string6.length() > 0) {
                        string6 = string6 + ",";
                    }
                    string6 = string6 + n2;
                }
                string4 = string4 + "flags: " + string6 + string3;
            }
            if (am2.cE != 0) {
                string4 = string4 + "ammo: " + am2.cE + string3;
            }
            if (!am2.cp) {
                string4 = string4 + "x: " + com.corrodinggames.rts.gameFramework.GameUtils.g(am2.posX) + string3;
                string4 = string4 + "y: " + com.corrodinggames.rts.gameFramework.GameUtils.g(am2.posY) + string3;
            }
            if (am2.cc != 0.0f || am2.cd != 0.0f) {
                string4 = string4 + "x/y speed: " + com.corrodinggames.rts.gameFramework.GameUtils.g(am2.cc) + ", "
                        + com.corrodinggames.rts.gameFramework.GameUtils.g(am2.cd) + string3;
            }
            if (!am2.cp) {
                string4 = string4 + "height: " + com.corrodinggames.rts.gameFramework.GameUtils.g(am2.posZ) + string3;
                string4 = string4 + "dir: " + com.corrodinggames.rts.gameFramework.GameUtils.g(am2.cg) + string3;
            }
            if (am2.cm < 1.0f) {
                string4 = string4 + "built: " + com.corrodinggames.rts.gameFramework.GameUtils.g(am2.cm) + string3;
            }
            if (am2 instanceof j) {
                j j3 = (j) am2;
                string4 = string4 + "frame: " + j3.a + string3;
                string4 = string4 + "drawLayer: " + j3.em + string3;
                if (j3.de() != null) {
                    string4 = string4 + "tags: " + j3.de() + string3;
                }
                if (j3.cO != null) {
                    string4 = string4 + "attachedTo: " + j3.cO.cB() + string3;
                }
                if (j3.bu != null && !j3.bu.bV) {
                    string4 = string4 + "customTarget1: " + j3.bu.cB() + string3;
                }
                if (j3.bv != null && !j3.bv.bV) {
                    string4 = string4 + "customTarget2: " + j3.bv.cB() + string3;
                }
                if (j3.bA != -9999) {
                    string4 = string4 + "customTimer: "
                            + com.corrodinggames.rts.gameFramework.GameUtils.h((float) j3.bA / 1000.0f) + string3;
                }
                if (j3.bw != null && !j3.bw.isEmpty()) {
                    string4 = string4 + "-- memory --: " + string3 + j3.bw.debugMemory(true, true) + string3;
                }
            }
            bl5 = true;
        }
        if ((f2 = am2.df()) != null && !f2.c() && !(string2 = f2.a(bl3, true, 10, bl5, false)).equals("")) {
            string4 = string4 + string2 + string3;
        }
        string4 = com.corrodinggames.rts.gameFramework.GameUtils.a(string4, string3);
        return string4;
    }

    void j() {
        for (am am2 : this.aA) {
            am2.h = true;
        }
    }

    void k() {
        for (am am2 : this.aA) {
            am2.b();
        }
        this.am = null;
        this.an = 0.0f;
    }

    void a(int n2, int n3, int n4, String string2, String string3, Paint paint, float f2) {
        int n5 = (int) ((double) n4 * 2.5);
        int n6 = (int) (40.0f * this.b.cj);
        int n7 = n2 + n4 / 2;
        int n8 = (int) ((float) (n3 - n6) - 35.0f * this.b.cj);
        this.aB.a(n7 - n5 / 2, n8, n5, n6);
        this.a.a(this.aB.left, this.aB.top, this.aB.c, this.aB.d, "", Color.a(180, 100, 100, 100), this.a.aC, false, null,
                null);
        this.s.a(this.aB.left, this.aB.top, this.aB.c, this.aB.d);
        this.s.c = (int) ((float) this.s.c * f2);
        try {
            this.b.bO.c(this.s, paint);
            this.b.bO.a(string2, (float) n7, (float) n8 + (this.a.aC.k() + 5.0f) * 1.0f, this.a.aC);
            this.b.bO.a(string3, (float) n7, (float) n8 + (this.a.aC.k() + 5.0f) * 2.0f, this.a.aC);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void a(float f2, boolean bl2) {
        try {
            float f3 = this.b.cj * 0.7f;
            if (com.corrodinggames.rts.gameFramework.GameEngine.au() && (double) f3 < 0.7) {
                f3 = 0.7f;
            }
            int n2 = this.U.m();
            int n3 = (int) ((float) n2 * f3);
            int n4 = 4 + n3 / 2;
            int n5 = 4 + n3 / 2;
            if (this.b.g(111)) {
                boolean bl3 = false;
                if (!this.a.u) {
                    bl3 = this.a.l();
                }
                if (!bl3) {
                    boolean bl4 = this.a.u = !this.a.u;
                }
            }
            if (this.a.u) {
                this.aC += 0.008f * f2;
                if (this.aC > 1.0f) {
                    this.aC = 0.0f;
                }
                float f4 = com.corrodinggames.rts.gameFramework.GameUtils.j(this.aC * 180.0f);
                this.h.c(150 + (int) (100.0f * f4));
            } else {
                this.aC = 0.0f;
                this.h.c(80);
            }
            this.v.a(n4, n5, n4 + n3, n5 + n3);
            this.v.a(-(n3 / 2), -(n3 / 2));
            if (bl2) {
                this.b.bO.a(this.U, (float) this.v.left, (float) this.v.top, this.h, 0.0f, f3);
                if (this.b.bQ.newRender) {
                    this.B.a(this.v.d() - 4, this.v.e() - 4, this.v.d() + 4, this.v.e() + 4);
                    this.p.a(100, 0, 155, 0);
                    this.b.bO.b(this.B, this.p);
                }
            }
            if (com.corrodinggames.rts.gameFramework.GameEngine.au()) {
                com.corrodinggames.rts.gameFramework.GameUtils.a(this.v, 4.0f);
            }
            if (this.a.U && !this.a.T && this.v.b((int) this.a.x, (int) this.a.y)) {
                this.a.U = false;
                this.a.u = !this.a.u;
            }
            this.a.a(this.v);
            if (this.b.cb.j()) {
                com.corrodinggames.rts.gameFramework.g.a a2;
                this.h.c(80);
                if (this.b.cb.v != 1) {
                    this.h.c(200);
                }
                n2 = this.W.q;
                n3 = (int) ((float) n2 * this.b.cj * 1.6f);
                n4 = (int) (this.b.cameraShakeX / 2.0f);
                n5 = 7 + (int) this.a.aE.k();
                String string2 = com.corrodinggames.rts.gameFramework.GameUtils.a((long) (this.b.by / 1000));
                this.b.bO.a(string2, (float) n4, (float) n5, this.a.aE);
                this.v.a(n4 += n3 / 2 + 5, n5 += n3 / 2 + 10, n4 + n3, n5 + n3);
                this.v.a(-this.v.b() / 2, -this.v.c() / 2);
                if (bl2) {
                    this.b.bO.a(this.W, (float) this.v.left, (float) this.v.top, this.h, 0.0f, (float) (n3 / n2));
                }
                if (this.a.U && !this.a.T && this.v.b((int) this.a.x, (int) this.a.y)) {
                    this.a.U = false;
                    this.b.cb.b();
                }
                if (this.b.bt != 1.0f && bl2) {
                    this.b.bO.a("x" + this.b.bt, (float) (this.v.d() + n3 / 2), (float) this.v.e(), this.a.aC);
                }
                com.corrodinggames.rts.gameFramework.m.Texture_M e2 = this.V;
                n2 = e2.q;
                n3 = (int) ((float) n2 * this.b.cj * 1.6f);
                this.v.a(n4 -= n3 + 5, n5, n4 + n3, n5 + n3);
                this.v.a(-this.v.b() / 2, -this.v.c() / 2);
                if (bl2) {
                    this.b.bO.a(e2, (float) this.v.left, (float) this.v.top, this.h, 0.0f, (float) (n3 / n2));
                }
                if (this.a.U && !this.a.T && this.v.b((int) this.a.x, (int) this.a.y)) {
                    this.a.U = false;
                    this.b.cb.a();
                }
                e2 = this.X;
                n4 = (int) (this.b.cl - this.b.cq - (float) (n3 + 5));
                this.v.a(n4, n5, n4 + n3, n5 + n3);
                this.v.a(-this.v.b() / 2, -this.v.c() / 2);
                if (bl2) {
                    this.b.bO.a(e2, (float) this.v.left, (float) this.v.top, this.h, 0.0f, (float) (n3 / n2));
                }
                if (this.a.U && !this.a.T && this.v.b((int) this.a.x, (int) this.a.y) && (a2 = this.b.cg) != null) {
                    a2.c();
                }
            }
            if (this.a.u) {
                this.b.cU = false;
                int n6 = this.b.a(190);
                this.s.left = (int) (this.b.cameraShakeX / 2.0f - (float) (n6 / 2));
                this.s.c = (int) (this.b.cameraShakeX / 2.0f + (float) (n6 / 2));
                int n7 = this.b.a(34);
                int n8 = n7 + this.b.a(15);
                Menu menu = this.o();
                int n9 = 1 + menu.size();
                int n10 = this.b.a(50) + n8 * n9;
                this.s.top = (int) (this.b.cp - (float) (n10 / 2));
                this.s.d = (int) (this.b.cp + (float) (n10 / 2));
                if (bl2) {
                    this.a.bt.c(this.b.bO, this.s);
                }
                int n11 = this.s.top + this.b.a(40);
                int n12 = this.b.a(152);
                int n13 = (int) (this.b.cameraShakeX / 2.0f - (float) (n12 / 2));
                int n14 = n11;
                int n15 = Color.a(140, 100, 100, 100);
                if (this.a.a(n13, n14, n12, n7,
                        com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.resume", new Object[0]),
                        com.corrodinggames.rts.gameFramework.f.i.none, false, n15, this.a.aD, this.a.br)) {
                    this.a.U = false;
                    this.a.aV = 40.0f;
                    this.a.u = false;
                }
                n14 += n8;
                for (int i2 = 0; i2 < menu.size(); ++i2) {
                    MenuItem menuItem = menu.getItem(i2);
                    if (this.a.a(n13, n14, n12, n7, menuItem.getTitle().toString(),
                            com.corrodinggames.rts.gameFramework.f.i.none, false, n15, this.a.aD, this.a.br)) {
                        this.a(menuItem.getItemId());
                        this.a.U = false;
                        this.a.aV = 40.0f;
                    }
                    n14 += n8;
                }
                this.a.a(this.s);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void l() {
        this.a(20);
    }

    public void m() {
        this.a(21);
    }

    public void n() {
        this.a(16);
    }

    void a(int n2) {
        com.corrodinggames.rts.appFramework.f f2 = this.b.ao;
        if (f2 == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("selectMenuOption: gameView==null");
            return;
        }
        com.corrodinggames.rts.appFramework.g g2 = f2.i();
        if (g2 == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("selectMenuOption: inGameActivity==null");
            return;
        }
        g2.c(n2);
    }

    Menu o() {
        this.aD.clear();
        com.corrodinggames.rts.appFramework.f f2 = this.b.ao;
        if (f2 == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("selectMenuOption: gameView==null");
            return this.aD;
        }
        com.corrodinggames.rts.appFramework.g g2 = f2.i();
        if (g2 == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("selectMenuOption: inGameActivity==null");
            return this.aD;
        }
        g2.a(this.aD);
        return this.aD;
    }

    void e(float f2) {
        int n2;
        float f3 = 30.0f * this.b.cj;
        int n3 = n2 = (int) (this.b.cameraShakeIntensity - f3);
        int n4 = (int) (this.b.cl - this.b.cq + 10.0f);
        int n5 = (int) (this.b.cq - 20.0f) / 3;
        int n6 = n5 - 5;
        int n7 = 100;
        int n8 = 50;
        for (int i2 = 0; i2 < this.aA.size(); ++i2) {
            am am2 = (am) this.aA.get(i2);
            if (am2.h) {
                am2.e();
                am2.h = false;
            }
            am2.d();
            if (this.b.bQ.keyboardSupport && i2 < this.b.bT.ai.length) {
                if (this.b.bT.ak[i2].a()) {
                    am2.b();
                    am2.c();
                }
                if (this.b.bT.aj[i2].a()) {
                    this.a.l();
                    am2.a();
                }
                if (this.b.bT.ai[i2].a()) {
                    this.a.l();
                    this.a.y();
                    am2.a();
                }
            }
            if (!this.b.bQ.showUnitGroups || i2 >= 3)
                continue;
            String string2 = am2.a.size() == 0 ? (this.a.bN ? "Empty" : "(" + (i2 + 1) + ")") : "" + am2.a.size();
            boolean bl2 = false;
            am2.d = com.corrodinggames.rts.gameFramework.GameUtils.a(am2.d, 0.01f * f2);
            am2.e = com.corrodinggames.rts.gameFramework.GameUtils.a(am2.e, 0.01f * f2);
            am2.f = com.corrodinggames.rts.gameFramework.GameUtils.a(am2.f, 0.01f * f2);
            int n9 = Color.a(50, (int) (100.0f + am2.f * 100.0f), (int) (100.0f + am2.e * 100.0f),
                    (int) (100.0f + am2.d * 100.0f));
            if (this.a.a(n4, n3, n6, (int) (31.0f * this.b.cj), string2, com.corrodinggames.rts.gameFramework.f.i.none,
                    true, n9) && this.a.ac == null && !this.a.T) {
                bl2 = true;
                am2.b += f2;
                this.a.d();
                float f4 = 1.0f;
                this.i.a();
                this.i.b(Color.a(120, 200, 0, 0));
                if (am2.b < 50.0f) {
                    f4 = am2.b / 50.0f;
                    this.i.b(Color.a((int) (150.0f + f4 * 40.0f), 0, 200, 0));
                    this.a(n4, n3, n6, "Select Group", "(Hold for more..)", this.i, f4);
                } else if (am2.b < 100.0f) {
                    f4 = (am2.b - 50.0f) / 50.0f;
                    this.i.b(Color.a((int) (150.0f + f4 * 40.0f), 200, 0, 0));
                    this.a(n4, n3, n6, "Add to Group", "(Hold for more..)", this.i, f4);
                } else {
                    this.a(n4, n3, n6, "Replace Group", "", this.i, 0.0f);
                }
                int n10 = (int) (31.0f * this.b.cj);
                this.s.a(n4, (int) ((float) (n3 + n10) - (float) n10 * f4), n4 + n6, n3 + n10);
                try {
                    this.b.bO.b(this.s, this.i);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            if (!bl2) {
                if (am2.b != 0.0f && !this.a.I) {
                    if (am2.b > 100.0f) {
                        am2.b();
                        am2.c();
                        am2.f = 1.0f;
                    } else if (am2.b > 50.0f) {
                        am2.c();
                        this.a.l();
                        this.a.y();
                        am2.a();
                        am2.e = 1.0f;
                    } else if (am2.a.size() != 0) {
                        this.a.l();
                        this.a.y();
                        am2.a();
                        am2.d = 1.0f;
                    } else {
                        am2.b();
                        am2.c();
                        am2.e = 1.0f;
                    }
                }
                if (!bl2) {
                    am2.b = 0.0f;
                }
            }
            n4 += n5;
        }
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        int n2 = this.aA.size();
        as2.a(n2);
        for (am am2 : this.aA) {
            am2.a(as2);
        }
        as2.c(0);
    }

    public void a(GameInputStream k2, boolean bl2) throws IOException {
        if (!bl2) {
            this.aA.clear();
        }
        int n2 = k2.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            am am2 = new am(this, i2 < 3);
            am2.a(k2);
            if (bl2)
                continue;
            this.aA.add(am2);
        }
        k2.d();
    }
}
