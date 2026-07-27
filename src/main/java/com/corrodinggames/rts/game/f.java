/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game;

import java.io.IOException;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.af;
import com.corrodinggames.rts.game.units.custom.ay;
import com.corrodinggames.rts.game.units.custom.bp;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.z;
import com.corrodinggames.rts.game.units.d.d;
import com.corrodinggames.rts.gameFramework.storage.e;
import com.corrodinggames.rts.gameFramework.PositionedObject;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.utility.Vector3D;
import com.corrodinggames.rts.gameFramework.utility.m;
import com.corrodinggames.rts.gameFramework.utility.UnitList;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.corrodinggames.rts.gameFramework.GGameObject;

public class f
        extends PositionedObject {
    public static final m a = new m();
    private static final f bm = new f(true);
    static com.corrodinggames.rts.gameFramework.m.Texture_M b = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M c = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M d = null;
    static final Rect e = new Rect();
    static final RectF f = new RectF();
    public com.corrodinggames.rts.game.g g = com.corrodinggames.rts.game.g.a;
    public float h;
    public float i;
    public BaseUnit j;
    public short k = (short) -1;
    public BaseUnit l;
    public boolean m;
    public float n;
    public float o;
    public float p;
    public f q;
    public float r = -1.0f;
    public float s = 0.1f;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x = 2.0f;
    public float y = -1.0f;
    public boolean z = true;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public float F;
    public boolean G;
    public float H = 1.0f;
    public float I;
    public float J;
    public float K;
    public float L;
    public boolean M;
    public float N;
    public float[] O;
    public short P = (short) -1;
    public short Q = (short) -1;
    public short R = 0;
    public boolean S = true;
    public boolean T;
    public float U;
    public boolean V = false;
    public float W = 0.0f;
    public float X = 0.0f;
    public float Y;
    public float Z;
    public boolean aa;
    public boolean ab = false;
    public boolean ac = false;
    public boolean ad = false;
    public boolean ae = true;
    public boolean af;
    public float ag;
    public float ah;
    public float ai = 1.0f;
    public float aj = 1.0f;
    public float ak = 1.0f;
    public float al = 1.0f;
    public float am = 1.0f;
    public float an;
    public boolean ao;
    public m ap;
    static final int aq = Color.a(255, 255, 255, 255);
    public int ar = aq;
    public boolean as;
    public boolean at;
    public GGameObject au;
    public int av = -1;
    public float aw;
    public float ax;
    public float ay;
    public float az;
    public float aA;
    public boolean aB;
    public boolean aC;
    public int aD;
    public h aE;
    public float aF;
    public boolean aG;
    public boolean aH;
    public float aI = 40.0f;
    public float aJ = 60.0f;
    public boolean aK = false;
    public float aL = 2.0f;
    public boolean aM;
    public float aN;
    public float aO;
    public com.corrodinggames.rts.gameFramework.effect.e aP;
    public boolean aQ;
    public boolean aR = true;
    private boolean bn;
    public boolean aS;
    public float aT = 0.0f;
    public boolean aU;
    float aV;
    float aW;
    float aX;
    public boolean aY;
    public boolean aZ;
    public static final ag ba = new ag();
    public static final Paint bb = new Paint();
    public static final Paint bc;
    public static final Paint bd;
    public static final Paint be;
    public static final Paint bf;
    public static final Paint bg;
    public static final Paint bh;
    public static final UnitList bi;
    public ag bj;
    public static ag bk;
    public static int bl;

    public f(boolean bl2) {
        super(bl2);
        if (!bl2) {
            a.add(this);
        }
    }

    @Override
    public void a() {
        a.remove(this);
        super.a();
    }

    public static f a(f f2) {
        f f3 = bm;
        f3.aD = -1;
        if (f2 == null) {
            f3.am = 1.0f;
            f3.ak = 1.0f;
            f3.al = 1.0f;
            f3.an = 0.0f;
        } else {
            f3.am = f2.am;
            f3.ak = f2.ak;
            f3.al = f2.al;
            f3.an = f2.an;
        }
        return f3;
    }

    public void a(BaseUnit am2, float f2, float f3, float f4) {
        this.j = am2;
        this.posX = f2;
        this.posY = f3;
        this.posZ = f4;
        this.bn = false;
        this.V = false;
    }

    public void b() {
        if (this.D) {
            GameEngine l2 = GameEngine.getInstance();
            com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.d(this.posX, this.posY, this.posZ, 0);
            if (e2 != null) {
                e2.G = 0.7f;
                e2.F = 2.1f;
                e2.ar = (short) 2;
                e2.W = e2.V = 90.0f;
            }
            l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.p, 0.8f, this.posX, this.posY);
        }
        this.a();
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.h);
        as2.a(this.j);
        as2.a(this.l);
        as2.a(this.t);
        as2.a(99);
        as2.a(this.A);
        as2.a(this.B);
        as2.a(this.S);
        as2.a(this.T);
        as2.a(this.U);
        as2.a(this.Y);
        as2.a(this.Z);
        as2.a(this.ar);
        as2.a(this.aH);
        as2.a(this.aI);
        as2.a(this.aJ);
        as2.a(this.aK);
        as2.a(this.aL);
        as2.a(this.aM);
        as2.a(this.aN);
        as2.a(this.aQ);
        as2.a(this.aR);
        as2.a(this.bn);
        as2.a(this.aS);
        as2.a(this.M);
        as2.a(this.P);
        as2.a(this.r);
        as2.a(this.s);
        as2.a(this.as);
        as2.a(this.at);
        as2.a(this.az);
        as2.a(this.aA);
        as2.a(this.aB);
        as2.a(this.aC);
        as2.a(false);
        as2.a(0.0f);
        as2.a(0.0f);
        as2.a(this.E);
        as2.a(this.F);
        as2.a(this.J);
        as2.a(this.K);
        as2.a(this.L);
        as2.a(this.m);
        as2.a(this.n);
        as2.a(this.o);
        as2.a(this.C);
        as2.a(this.D);
        as2.a(this.q);
        as2.a(this.aV);
        as2.a(this.aW);
        as2.a(this.aX);
        as2.a(this.V);
        as2.a(this.W);
        as2.a(this.X);
        as2.a(this.aU);
        as2.a(this.R);
        as2.a(this.ao);
        as2.a(this.ap);
        as2.a(this.Q);
        as2.a(this.x);
        as2.a(this.aa);
        as2.a(this.ad);
        as2.a(this.G);
        as2.a(this.H);
        as2.a(this.ae);
        as2.a(this.aG);
        as2.a(this.z);
        as2.a(this.y);
        as2.a(this.aO);
        as2.a(this.i);
        as2.a(this.aY);
        as2.a(this.af);
        as2.a(this.ag);
        as2.a(this.ah);
        as2.a(this.ai);
        as2.a(this.aj);
        as2.a(0);
        as2.a(0.0f);
        as2.a(0.0f);
        as2.a((UnitType) null);
        as2.a(0);
        as2.a(false);
        com.corrodinggames.rts.game.units.custom.g.a(this.aE, as2);
        as2.a(this.ak);
        as2.a(this.al);
        as2.a(this.ab);
        as2.a(this.ac);
        as2.a(this.an);
        as2.a(false);
        com.corrodinggames.rts.game.g.a(this.g, as2);
        boolean bl2 = this.au != null && !this.au.ej;
        as2.a(bl2);
        if (bl2) {
            as2.a(this.au);
            as2.a(this.aw);
            as2.a(this.ax);
            as2.a(this.ay);
        }
        as2.a(this.k);
        as2.a(this.aD);
        as2.a(this.am);
        as2.a(this.p);
        as2.a(this.av);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        boolean bl2;
        this.h = k2.g();
        this.j = k2.o();
        this.l = k2.a(com.corrodinggames.rts.gameFramework.j.m.a);
        this.t = k2.g();
        this.x = k2.readInt();
        this.A = k2.e();
        this.B = k2.e();
        this.S = k2.e();
        this.T = k2.e();
        this.U = k2.g();
        this.Y = k2.g();
        this.Z = k2.g();
        this.ar = k2.readInt();
        this.aH = k2.e();
        this.aI = k2.g();
        this.aJ = k2.g();
        this.aK = k2.e();
        this.aL = k2.g();
        this.aM = k2.e();
        this.aN = k2.g();
        this.aQ = k2.e();
        this.aR = k2.e();
        this.bn = k2.e();
        if (k2.b() >= 7) {
            this.aS = k2.e();
        }
        if (k2.b() >= 13) {
            this.M = k2.e();
            this.P = k2.v();
        }
        if (k2.b() >= 16) {
            this.r = k2.g();
            this.s = k2.g();
        }
        if (k2.b() >= 17) {
            this.as = k2.e();
            this.at = k2.e();
            this.az = k2.g();
            this.aA = k2.g();
            this.aB = k2.e();
            this.aC = k2.e();
        }
        if (k2.b() >= 18) {
            k2.e();
            k2.g();
            k2.g();
        }
        if (k2.b() >= 28) {
            this.E = k2.e();
            this.F = k2.g();
            this.J = k2.g();
            this.K = k2.g();
            this.L = k2.g();
        }
        if (k2.b() >= 29) {
            this.m = k2.e();
            this.n = k2.g();
            this.o = k2.g();
            this.C = k2.e();
            this.D = k2.e();
            this.q = (f) k2.a(f.class);
            this.aV = k2.g();
            this.aW = k2.g();
            this.aX = k2.g();
            this.V = k2.e();
            this.W = k2.g();
            this.X = k2.g();
            this.aU = k2.e();
            this.R = k2.v();
            this.ao = k2.e();
            m m2 = new m();
            k2.a(m2, BaseUnit.class);
            if (m2.size() > 0) {
                this.ap = m2;
            }
            this.Q = k2.v();
        }
        if (k2.b() >= 35) {
            this.x = k2.g();
            this.aa = k2.e();
            this.ad = k2.e();
            this.G = k2.e();
        }
        if (k2.b() >= 38) {
            this.H = k2.g();
        }
        if (k2.b() >= 39) {
            this.ae = k2.e();
        }
        if (k2.b() >= 41) {
            this.aG = k2.e();
        }
        if (k2.b() >= 43) {
            this.z = k2.e();
            this.y = k2.g();
        }
        if (k2.b() >= 44) {
            this.aO = k2.g();
        }
        if (k2.b() >= 47) {
            this.i = k2.g();
        }
        if (k2.b() >= 48) {
            this.aY = k2.e();
        }
        if (k2.b() >= 59) {
            this.af = k2.e();
            this.ag = k2.g();
            this.ah = k2.g();
            this.ai = k2.g();
        }
        if (k2.b() >= 60) {
            this.aj = k2.g();
            k2.readInt();
            k2.g();
            k2.g();
        }
        if (k2.b() >= 62) {
            k2.q();
            k2.readInt();
            k2.e();
        }
        if (k2.b() >= 63) {
            this.aE = com.corrodinggames.rts.game.units.custom.g.a(k2);
        }
        if (k2.b() >= 64) {
            this.ak = k2.g();
            this.al = k2.g();
        }
        if (k2.b() >= 66) {
            this.ab = k2.e();
            this.ac = k2.e();
        }
        if (k2.b() >= 67 && k2.b() < 78) {
            bp.a(k2, true);
        }
        if (k2.b() >= 68) {
            this.an = k2.g();
        }
        if (k2.b() >= 77) {
            k2.e();
        }
        if (k2.b() >= 78) {
            this.g = com.corrodinggames.rts.game.g.a(k2);
        }
        if (k2.b() >= 81 && (bl2 = k2.e())) {
            this.au = k2.a(GGameObject.class);
            this.aw = k2.g();
            this.ax = k2.g();
            this.ay = k2.g();
        }
        if (k2.b() >= 83) {
            this.k = k2.v();
            this.aD = k2.readInt();
        }
        if (k2.b() >= 88) {
            this.am = k2.g();
        }
        if (k2.b() >= 89) {
            this.p = k2.g();
            this.av = k2.readInt();
        }
        super.a(k2);
    }

    public static void c() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.projectiles);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.projectiles2);
        d = l2.bO.a(com.corrodinggames.rts.R.drawable.projectiles_large);
    }

    public void d() {
        this.aS = true;
    }

    public static f a(BaseUnit am2, float f2, float f3) {
        f f4 = new f(false);
        f4.j = am2;
        f4.posX = f2;
        f4.posY = f3;
        f4.ar = Color.a(255, 100, 30, 30);
        f4.en = am2.en + 1;
        f4.em = 4;
        return f4;
    }

    public static f a(BaseUnit am2, float f2, float f3, float f4, int n2) {
        f f5 = com.corrodinggames.rts.game.f.a(am2, f2, f3);
        f5.posZ = f4;
        f5.k = (short) n2;
        f5.I = com.corrodinggames.rts.gameFramework.GameUtils.b(am2, 0.0f, 1.0f, am2.bC);
        ++am2.bC;
        return f5;
    }

    public void a(BaseUnit am2) {
        if (this.ag != 0.0f || this.ah != 0.0f) {
            if (am2.bI()) {
                return;
            }
            float f2 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.aV, this.aW, am2.posX, am2.posY);
            float f3 = f2 > 100.0f ? com.corrodinggames.rts.gameFramework.GameUtils.d(this.aV, this.aW, am2.posX, am2.posY)
                    : this.az;
            float f4 = this.ah;
            am2.cc += com.corrodinggames.rts.gameFramework.GameUtils.k(f3) * (f4 += this.ag / am2.bN());
            am2.cd += com.corrodinggames.rts.gameFramework.GameUtils.j(f3) * f4;
        }
    }

    public static void a(BaseUnit am2, BaseUnit am3, float f2, f f3, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.bw && f2 > 0.0f) {
            f2 = 0.0f;
        }
        if (am3 != null && !am3.bV) {
            float f4;
            float f5;
            float f6;
            if (f3 != null && f3.g.bc && am2 != null) {
                am3.e(am2.bX);
            }
            if (f3 != null) {
                if (f3.ai != 1.0f && am3.bI()) {
                    f2 *= f3.ai;
                }
                if (f3.aj != 1.0f && am3.i()) {
                    f2 *= f3.aj;
                }
            }
            if (f2 < 0.0f) {
                f6 = am3.b(am2, -f2, f3);
            } else {
                boolean bl3 = !am3.bV && am3.cu > 0.0f;
                f5 = am3.a(am2, f2, f3);
                f4 = f2;
                if (am3.J()) {
                    f4 = 0.0f;
                }
                if (f4 > 0.0f) {
                    l2.bY.a(am2, am3, f4);
                }
                if (am2 != null) {
                    am2.cV += f4;
                    if (bl3 && (am3.bV || am3.cu < 0.0f)) {
                        ++am2.cU;
                        am2.a(com.corrodinggames.rts.game.units.custom.af.killedAnyUnit, am3);
                    }
                }
            }
            if (f3 != null && !am3.bV && (f6 = am3.bQ()) != -1.0f) {
                f5 = 100.0f;
                f4 = com.corrodinggames.rts.gameFramework.GameUtils.d(f3.posX, f3.posY, am3.posX, am3.posY);
                am3.cc += com.corrodinggames.rts.gameFramework.GameUtils.k(f4) * (f5 /= f6);
                am3.cd += com.corrodinggames.rts.gameFramework.GameUtils.j(f4) * f5;
            }
        }
    }

    public float e() {
        float f2 = 1.0f;
        if (this.J < this.F) {
            f2 = this.J / this.F;
        }
        return f2;
    }

    @Override
    public void a(float var1) {
        GameEngine var2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (this.aS) {
            this.a();
        }

        if (this.l == null && !this.aC) {
            this.a();
        } else {
            if (this.i > 0.0F) {
                this.i = com.corrodinggames.rts.gameFramework.GameUtils.a(this.i, var1);
                if (this.i > 0.0F) {
                    return;
                }
            }

            com.corrodinggames.rts.game.g var3 = this.g;
            com.corrodinggames.rts.gameFramework.effect.e var8;
            if (this.i == 0.0F) {
                this.i = -1.0F;
                if (var3.al != null) {
                    Object var4 = null;
                    boolean var5 = false;
                    BaseUnit var6 = this.j;
                    var3.al.a(this.posX, this.posY, this.posZ, this.az, var6, (m) var4, var5, this.aD + 1, this, (BaseUnit) null);
                }
            }

            this.h = com.corrodinggames.rts.gameFramework.GameUtils.a(this.h, var1);
            boolean var28 = false;
            if (this.aG) {
                if (this.l == null) {
                    var28 = true;
                } else if (this.l.bV) {
                    var28 = true;
                }
            }

            if (var28) {
                this.a(var3.ax, var3.ay, (h) null);
            }

            if (var3.az) {
                this.aF = com.corrodinggames.rts.gameFramework.GameUtils.a(this.aF, var1);
                if (this.aF == 0.0F) {
                    this.aF = var3.aA;
                    var28 = true;
                    this.a(var3.aB, var3.aC, var3.aD);
                }
            }

            float var29;
            if (var3.R != 0.0F || var3.S != 0.0F) {
                var29 = var3.R;
                if (this.l != null) {
                    var29 += this.l.cj * var3.S;
                }

                this.K = com.corrodinggames.rts.gameFramework.GameUtils.j((360.0F * this.I + this.J * 1.0F) % 360.0F)
                        * var29;
                this.L = com.corrodinggames.rts.gameFramework.GameUtils.j((360.0F * this.I + this.J * 1.5F) % 360.0F)
                        * var29;
            }

            float var30;
            if (this.E && this.l != null) {
                this.K = com.corrodinggames.rts.gameFramework.GameUtils.j(this.J * 1.0F % 360.0F) * this.l.cj * 0.4F;
                this.L = com.corrodinggames.rts.gameFramework.GameUtils.j(this.J * 1.5F % 360.0F) * this.l.cj * 0.4F;
                var29 = this.l.posX + this.K;
                var30 = this.l.posY + this.L;
                if (this.el) {
                    this.aN += var1;
                    this.aO += var1;
                    if (this.aN > 11.0F) {
                        this.aN = com.corrodinggames.rts.gameFramework.GameUtils.c(1.0F, 4.0F);
                        boolean var7 = false;
                        var8 = var2.bR.b(var29, var30, this.l.posZ, com.corrodinggames.rts.gameFramework.effect.d.custom, var7,
                                com.corrodinggames.rts.gameFramework.effect.h.low);
                        if (var8 != null) {
                            var8.aq = 0;
                            var8.ap = 0;
                            var8.ar = 2;
                            var8.r = true;
                            var8.E = 0.5F;
                            var8.W = 60.0F;
                            var8.V = 60.0F;
                            var8.G = 0.7F;
                            var8.F = 0.3F;
                            var8.as = false;
                            var8.P = com.corrodinggames.rts.gameFramework.GameUtils.c(-0.3F, 0.3F);
                            var8.Q = -0.9F + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.3F, 0.3F);
                        }
                    }

                    if (this.aO > 75.0F) {
                        this.aO = com.corrodinggames.rts.gameFramework.GameUtils.c(1.0F, 20.0F);
                        var2.bR.b(var29, var30, this.l.posZ);
                    }
                }
            }

            float var9 = 5.0F;
            boolean var10 = false;
            boolean var11 = false;
            float var12;
            float var13;
            float var14;
            float var31;
            float var32;
            if (!this.aC) {
                var12 = this.l.posX + this.K;
                var13 = this.l.posY + this.L;
                var14 = this.l.posZ;
                var29 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, var12, var13);
                var30 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, var12, var13);
                var32 = var14;
                var31 = var14 - this.posZ;
                var9 = this.l.cj;
                var10 = this.l instanceof com.corrodinggames.rts.game.units.d.d;
                var11 = this.l.cx > 10.0F + this.U;
            } else {
                var30 = 999.0F;
                var31 = 0.0F;
                var29 = this.az;
                var32 = 0.0F;
                if (this.q != null) {
                    var12 = this.q.posX + this.K;
                    var13 = this.q.posY + this.L;
                    var14 = this.q.posZ;
                    var29 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, var12, var13);
                    var30 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, var12, var13);
                    var32 = var14;
                    var31 = var14 - this.posZ;
                } else if (this.l != null) {
                    var12 = this.l.posX + this.K;
                    var13 = this.l.posY + this.L;
                    var14 = this.l.posZ;
                    var29 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, var12, var13);
                    var30 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, var12, var13);
                    var32 = var14;
                    var31 = var14 - this.posZ;
                    var9 = this.l.cj;
                    var10 = this.l instanceof com.corrodinggames.rts.game.units.d.d;
                    var11 = this.l.cx > 10.0F + this.U;
                } else if (this.m) {
                    var12 = this.n + this.K;
                    var13 = this.o + this.L;
                    var14 = this.p;
                    var29 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, var12, var13);
                    var30 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, var12, var13);
                    var32 = var14;
                    var31 = var14 - this.posZ;
                } else {
                    var12 = this.n + this.K;
                    var13 = this.o + this.L;
                    var14 = 0.0F;
                    var29 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, var12, var13);
                    var30 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, var12, var13);
                    var32 = var14;
                    var31 = var14 - this.posZ;
                }
            }

            var12 = var3.O;
            if (var30 < 225.0F) {
                var12 = var3.P;
            }

            if (var12 >= 0.0F) {
                var13 = com.corrodinggames.rts.gameFramework.GameUtils.c(this.az, var29, var12 * var1);
                this.az += var13;
                var29 = this.az;
            } else {
                this.az = var29;
            }

            boolean var33 = false;
            boolean var34 = false;
            float var15 = var29;
            float var16;
            float var17;
            Vector3D var20;
            float var21;
            float var36;
            float var40;
            if (this.au != null && !this.au.ej) {
                float var18;
                if (this.av >= 0) {
                    com.corrodinggames.rts.game.units.y var19 = (com.corrodinggames.rts.game.units.y) this.au;
                    if (this.av >= var19.bl()) {
                        this.av = 0;
                    }

                    var20 = var19.D(this.av);
                    var16 = var20.a;
                    var17 = var20.b;
                    var18 = this.j.posZ + var20.c;
                } else {
                    var16 = this.au.posX;
                    var17 = this.au.posY;
                    var18 = this.au.posZ;
                }

                var36 = var16 - this.aw;
                var40 = var17 - this.ax;
                var21 = var18 - this.ay;
                this.posX += var36;
                this.posY += var40;
                this.posZ += var21;
                this.aw = var16;
                this.ax = var17;
                this.ay = var18;
            }

            if (!this.A) {
                this.posX += this.u * var1;
                this.posY += this.v * var1;
                if (this.w != 0.0F) {
                    var16 = this.w * var1;
                    this.posZ += var16;
                    var31 = var32 - this.posZ;
                }

                if (this.posZ > 0.0F) {
                    if (var3.G != 0.0F) {
                        this.posZ -= var3.G * var1;
                        var31 = var32 - this.posZ;
                    }

                    if (var3.H != 0.0F) {
                        this.w -= var3.H * var1;
                    }
                }

                if (!this.aH || this.aI < this.posZ || this.aK) {
                    var16 = this.t * var1;
                    var33 = true;
                    if (var30 < var16 * var16) {
                        var16 = com.corrodinggames.rts.gameFramework.GameUtils.a(var30);
                        var30 = 0.0F;
                    }

                    this.posX += com.corrodinggames.rts.gameFramework.GameUtils.k(var29) * var16;
                    this.posY += com.corrodinggames.rts.gameFramework.GameUtils.j(var29) * var16;
                }

                if (this.aH) {
                    if (this.aL < 0.0F) {
                        var16 = this.t * var1;
                        var33 = true;
                    } else {
                        var16 = this.aL * var1;
                    }

                    if (!this.aK) {
                        this.posZ = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, this.aJ, var16);
                        if (this.posZ < this.aI) {
                            var15 = -90.0F;
                        }

                        if (this.posZ >= this.aJ) {
                            this.aK = true;
                        }
                    } else if (var30 < 400.0F) {
                        this.posZ = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, var32, var16);
                        if (com.corrodinggames.rts.gameFramework.GameUtils.c(this.posZ - var32) > 0.5F) {
                            var15 = 90.0F;
                            var34 = true;
                        }
                    }
                } else {
                    var17 = this.t * var1;
                    var33 = true;
                    if (var31 != 0.0F) {
                        if ((double) var30 > 0.1) {
                            var17 = com.corrodinggames.rts.gameFramework.GameUtils.c(var31)
                                    / com.corrodinggames.rts.gameFramework.GameUtils.a(var30) * this.t * var1;
                            var17 = com.corrodinggames.rts.gameFramework.GameUtils.b(var17, this.t * var1);
                        }

                        this.posZ += com.corrodinggames.rts.gameFramework.GameUtils.b(var31, var17);
                        var31 = var32 - this.posZ;
                    }
                }
            }

            if (var33 && this.r > 0.0F) {
                this.t = com.corrodinggames.rts.gameFramework.GameUtils.a(this.t, this.r, this.s * var1);
            }

            if (var3.am != 0.0F) {
                var16 = com.corrodinggames.rts.gameFramework.GameUtils
                        .j((this.J * 360.0F / var3.an + 360.0F * this.I) % 360.0F);
                var16 = var16 * var3.am * var1;
                this.posX += com.corrodinggames.rts.gameFramework.GameUtils.k(var29 + 90.0F) * var16;
                this.posY += com.corrodinggames.rts.gameFramework.GameUtils.j(var29 + 90.0F) * var16;
            }

            boolean var41;
            if (this.el && (this.aM || var3.ah != null) && !this.bn) {
                this.aN += var1;
                if (this.aN > var3.ag) {
                    this.aN = 0.0F;
                    var41 = false;
                    if (this.D) {
                        var41 = true;
                    }

                    if (var3.ah != null) {
                        var3.ah.a(this.posX, this.posY, this.posZ, this.aT, this);
                    }

                    if (this.aM) {
                        com.corrodinggames.rts.gameFramework.effect.e var37 = var2.bR.b(this.posX, this.posY, this.posZ,
                                com.corrodinggames.rts.gameFramework.effect.d.custom, var41,
                                com.corrodinggames.rts.gameFramework.effect.h.low);
                        if (var37 != null) {
                            if (this.posZ >= 0.0F) {
                                var37.aq = 0;
                                var37.ap = 0;
                                var37.ar = 2;
                                var37.r = true;
                                var37.E = 0.5F;
                                var37.V = 70.0F;
                                var37.W = var37.V;
                                var37.as = true;
                                if (var34) {
                                    var37.as = false;
                                }

                                var37.Q = 0.1F;
                                var37.s = true;
                                var37.t = 5.0F;
                                var37.G = 0.5F;
                                var37.F = 1.2F;
                                var37.Y = com.corrodinggames.rts.gameFramework.GameUtils.c(-180.0F, 180.0F);
                                if (this.D) {
                                    var37.G = 0.5F;
                                    var37.F = 2.1F;
                                }
                            } else {
                                var37.aq = 9;
                                var37.ap = 1;
                                var37.ar = 1;
                                var37.r = true;
                                var37.E = 0.5F;
                                var37.W = 60.0F;
                                var37.V = 60.0F;
                                var37.Q = 0.1F;
                            }
                        }
                    }
                }
            }

            if (!this.bn) {
                var41 = false;
                BaseUnit var38 = null;
                boolean var35 = false;
                var36 = 6.0F;
                if (var10) {
                    var36 = var9 * 0.8F;
                    if (var36 < 6.0F) {
                        var36 = 6.0F;
                    }
                }

                if (var11) {
                    var36 = var9 * 1.1F;
                }

                var40 = 3.0F;
                if (this.w != 0.0F || var3.G != 0.0F) {
                    var40 += com.corrodinggames.rts.gameFramework.GameUtils.c(this.w * var1)
                            + com.corrodinggames.rts.gameFramework.GameUtils.c(var3.G * var1);
                }

                if (var30 < var36 * var36 && com.corrodinggames.rts.gameFramework.GameUtils.c(var31) < var40) {
                    var41 = true;
                    var38 = this.l;
                }

                if (this.A) {
                    var41 = true;
                    var38 = this.l;
                }

                if (this.af && this.h == 0.0F) {
                    var41 = true;
                }

                int var24;
                BaseUnit var25;
                if (this.as) {
                    var21 = this.aA + 50.0F;
                    BaseUnit[] var22 = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
                    int var23 = 0;

                    for (var24 = com.corrodinggames.rts.game.units.BaseUnit.bE.size(); var23 < var24; ++var23) {
                        var25 = var22[var23];
                        if (var25.posX + var21 > this.posX && var25.posX - var21 < this.posX && var25.posY + var21 > this.posY
                                && var25.posY - var21 < this.posY && var25.bT && !var25.i() && var25.cN == null) {
                            float var26 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, var25.posX,
                                    var25.posY);
                            float var27 = this.aA + var25.cj;
                            if (var26 < var27 * var27) {
                                var41 = true;
                                var38 = var25;
                            }
                        }
                    }
                }

                if (this.at) {
                    var2.bL.a(this.posX, this.posY);
                    int var43 = var2.bL.T;
                    int var45 = var2.bL.U;
                    if (var2.bU.a(com.corrodinggames.rts.game.units.UnitMovementType.OVER_CLIFF_WATER, var43, var45)) {
                        var41 = true;
                        var35 = true;
                    }
                }

                if (this.aC) {
                }

                if (this.aY && (this.aH && var34 && this.posZ < 30.0F || var41) && this.j != null) {
                    this.aY = false;
                    com.corrodinggames.rts.game.units.u var44 = new com.corrodinggames.rts.game.units.u(false);
                    var44.posX = this.posX;
                    var44.posY = this.posY;
                    var44.b(this.j.bX);
                    var44.a = 15;
                    var44.b = 360.0F;
                    com.corrodinggames.rts.game.PlayerTeam.c(var44);
                }

                if (var41) {
                    this.bn = true;
                    this.aV = this.posX;
                    this.aW = this.posY;
                    this.aX = this.posZ;
                    if (this.A) {
                        if (this.aC) {
                            this.aV = this.n;
                            this.aW = this.o;
                            this.aX = 0.0F;
                        }

                        if (this.l != null) {
                            this.aV = this.l.posX + this.K;
                            this.aW = this.l.posY + this.L;
                            this.aX = this.l.posZ;
                        }
                    }

                    if (!this.B && !this.M && !var3.X) {
                        this.S = false;
                    }

                    boolean var46 = false;
                    if (this.l != null) {
                        var46 = this.l.cx > 10.0F;
                    }

                    z var47 = var3.aX;
                    if (var46) {
                        var47 = var3.aY;
                    }

                    z var48;
                    if (this.l != null) {
                        var48 = var3.a(this.l);
                        if (var48 != null) {
                            var47 = var48;
                        }
                    }

                    if (var47 != null) {
                        var47.a(this.aV, this.aW, this.aX, this.aT, this.l);
                    }

                    if (var3.aj != null) {
                        var48 = null;
                        boolean var50 = false;
                        var25 = this.j;
                        BaseUnit var60 = this.l;
                        var3.aj.a(this.posX, this.posY, this.posZ, this.az, var25, null, var50, this.aD + 1, this, var60);
                    }

                    if (var3.aZ != null && this.j != null) {
                        var3.aZ.a(this.aV, this.aW, 0.0F, this.az, this.j.bX, false, this.j);
                    }

                    if (var3.ba > 0 && this.j != null && this.j instanceof j) {
                        j var51 = (j) this.j;

                        for (var24 = 0; var24 < var3.ba; ++var24) {
                            if (var51.B != null && var51.B.size() > 0) {
                                var25 = (BaseUnit) var51.B.remove(var51.B.size() - 1);
                                com.corrodinggames.rts.gameFramework.utility.y.a(var25, var51);
                                var25.posX = this.aV;
                                var25.posY = this.aW;
                                var25.cg = this.az;
                                var25.cd = 0.0F;
                                var25.cc = 0.0F;
                                var25.bZ = 0.0F;
                                var25.ca = 0.0F;
                                if (var25 instanceof com.corrodinggames.rts.game.units.y) {
                                    com.corrodinggames.rts.game.units.y var57 = (com.corrodinggames.rts.game.units.y) var25;
                                    var57.az();
                                    var57.j(var25.cg);
                                    if (var25 instanceof j) {
                                        ((j) var25).dF();
                                    }
                                }

                                var51.D(var25);
                            }
                        }
                    }

                    if (var3.bb && this.j != null) {
                        this.j.f(this.aV, this.aW);
                    }

                    if (!var35 && var38 != null) {
                        float var52;
                        if (this.E) {
                            this.bn = false;
                            var52 = this.U / 60.0F * var1 * this.e();
                            if (this.Z == 0.0F) {
                                this.a(var38);
                            }

                            var52 = var3.a(var38, var52, true);
                            a(this.j, var38, var52, this, false);
                        } else {
                            if (this.Z == 0.0F) {
                                this.a(var38);
                            }

                            var52 = this.U;
                            var52 = var3.a(var38, var52, false);
                            a(this.j, var38, var52, this, false);
                        }
                    }

                    if (this.q != null) {
                        if (var3.d) {
                            this.q.h = 0.0F;
                        } else {
                            this.q.b();
                        }

                        this.a();
                    }

                    if (!this.E) {
                        boolean var55 = true;
                        com.corrodinggames.rts.gameFramework.effect.e var53;
                        if (this.l != null && this.l.cx > 10.0F) {
                            var55 = false;
                            if (var3.aY == null) {
                                var53 = var2.bR.d(this.aV, this.aW, this.aX, -1127220);
                                if (var53 != null) {
                                    var53.V = 10.0F;
                                    var53.F = 0.5F;
                                    if (this.aQ) {
                                        var53.V = 25.0F;
                                        var53.F = 1.0F;
                                    }

                                    var53.ar = 2;
                                    var53.W = var53.V;
                                }
                            }
                        }

                        if (this.G) {
                            var55 = false;
                            com.corrodinggames.rts.gameFramework.effect.f var54 = com.corrodinggames.rts.gameFramework.effect.f
                                    .b(this.posX, this.posY);
                            var54.a = 21.0F;
                        }

                        if (var55) {
                            float var58;
                            if (!this.aQ) {
                                if (var3.aX == null) {
                                    var2.bR.c(this.aV, this.aW, this.aX);
                                }
                            } else if (var3.aX == null) {
                                if (this.Z > 10.0F) {
                                    var53 = var2.bR.d(this.aV, this.aW, this.aX, 0);
                                    if (var53 != null) {
                                        var53.F = this.Z / 25.0F;
                                        var53.E = 0.7F;
                                        if (this.aX > 5.0F) {
                                            var53.ar = 2;
                                        }
                                    }
                                }

                                var2.bR.b(this.aV, this.aW, this.aX);
                                if (this.aR && !this.D) {
                                    var58 = 1.0F + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.06F, 0.06F);
                                    var2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.n, 0.5F, var58, this.aV,
                                            this.aW);
                                }
                            }

                            if (this.D && var3.aX == null) {
                                var58 = 0.7F;
                                var2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.C, 1.6F, var58, this.aV,
                                        this.aW);
                                var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                com.corrodinggames.rts.gameFramework.effect.e var56 = var2.bR.a(this.aV, this.aW,
                                        this.posZ, Color.a(255, 255, 255, 255));
                                if (var56 != null) {
                                    var56.G = 14.0F;
                                    var56.F = 8.0F;
                                    var56.E = 0.9F;
                                    var56.V = 35.0F;
                                    var56.W = var56.V;
                                    var56.r = true;
                                }

                                var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                var56 = var2.bR.c(this.aV, this.aW, this.aX, -1127220);
                                if (var56 != null) {
                                    var56.G = 1.5F;
                                    var56.F = 3.0F;
                                    var56.ar = 2;
                                    var56.V = 20.0F;
                                    var56.W = var56.V;
                                    var56.U = 0.0F;
                                }

                                var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                var56 = var2.bR.c(this.aV, this.aW, this.aX, -1127220);
                                if (var56 != null) {
                                    var56.G = 0.2F;
                                    var56.F = 5.0F;
                                    var56.ar = 2;
                                    var56.V = 65.0F;
                                    var56.W = var56.V;
                                    var56.U = 0.0F;
                                }

                                var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.posZ, Color.a(255, 255, 255, 255));
                                if (var56 != null) {
                                    var56.G = 3.0F;
                                    var56.F = 6.0F;
                                    var56.E = 0.9F;
                                    var56.V = 290.0F;
                                    var56.W = var56.V;
                                }

                                var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.posZ, Color.a(255, 255, 244, 230));
                                if (var56 != null) {
                                    var56.G = 2.0F;
                                    var56.F = 6.0F;
                                    var56.E = 0.5F;
                                    var56.V = 370.0F;
                                    var56.W = var56.V;
                                    var56.U = 10.0F;
                                }

                                int var59;
                                for (var59 = 0; var59 < 1; ++var59) {
                                    var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                    var56 = var2.bR.a(this.aV, this.aW, this.posZ, Color.a(255, 255, 244, 230));
                                    if (var56 != null) {
                                        var56.G = 0.2F;
                                        var56.F = 9.0F;
                                        var56.E = 0.7F;
                                        var56.V = 210.0F;
                                        var56.W = var56.V;
                                        var56.U = (float) (20 + var59 * 110);
                                    }
                                }

                                var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.posZ, Color.a(255, 255, 255, 255));
                                if (var56 != null) {
                                    var56.G = 3.0F;
                                    var56.F = 4.0F;
                                    var56.E = 0.2F;
                                    var56.V = 870.0F;
                                    var56.W = var56.V;
                                    var56.r = true;
                                    var56.U = 70.0F;
                                }

                                var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.posZ, Color.a(255, 206, 255, 239));
                                if (var56 != null) {
                                    var56.G = 4.0F;
                                    var56.F = 1.0F;
                                    var56.E = 0.9F;
                                    var56.V = 320.0F;
                                    var56.W = var56.V;
                                }

                                var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.posZ, Color.a(255, 255, 242, 129));
                                if (var56 != null) {
                                    var56.G = 2.0F;
                                    var56.F = 1.0F;
                                    var56.E = 1.0F;
                                    var56.V = 340.0F;
                                    var56.W = var56.V;
                                    var56.s = true;
                                    var56.t = 20.0F;
                                }

                                var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.posZ, Color.a(245, 255, 182, 110));
                                if (var56 != null) {
                                    var56.G = 1.5F;
                                    var56.F = 1.5F;
                                    var56.E = 0.3F;
                                    var56.V = 1340.0F;
                                    var56.W = var56.V;
                                    var56.s = true;
                                    var56.t = 40.0F;
                                    var56.U = 140.0F;
                                }

                                for (var59 = 0; var59 < 4; ++var59) {
                                    var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                    var56 = var2.bR.a(this.aV, this.aW, this.posZ, Color.a(225, 255, 242, 129));
                                    if (var56 != null) {
                                        var56.G = 1.5F;
                                        var56.F = 1.4F;
                                        var56.E = 1.3F;
                                        var56.V = 340.0F;
                                        var56.W = var56.V;
                                        var56.Q = -0.29F;
                                        var56.s = true;
                                        var56.t = 50.0F;
                                        var56.U = (float) (30 + var59 * 40);
                                    }
                                }

                                for (var59 = 0; var59 < 2; ++var59) {
                                    var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                    var56 = var2.bR.a(this.aV, this.aW, this.posZ, Color.a(185, 255, 242, 129));
                                    if (var56 != null) {
                                        var56.G = 1.3F;
                                        var56.F = 1.0F;
                                        var56.E = 1.0F;
                                        var56.V = 340.0F;
                                        var56.W = var56.V;
                                        var56.Q = -0.14F;
                                        var56.s = true;
                                        var56.t = 50.0F;
                                        var56.U = (float) (70 + var59 * 70);
                                    }
                                }

                                for (var59 = 0; var59 < 4; ++var59) {
                                    var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                    var56 = var2.bR.a(this.aV, this.aW - 30.0F, this.posZ, -16711936);
                                    if (var56 != null) {
                                        var56.G = 1.5F;
                                        var56.F = 2.6F;
                                        var56.E = 1.3F;
                                        var56.V = 510.0F;
                                        var56.W = var56.V;
                                        var56.Q = -0.2F;
                                        var56.s = true;
                                        var56.t = 50.0F;
                                        var56.B = null;
                                        var56.x = Color.a(175, 235, 235, 235);
                                        var56.U = (float) (20 + var59 * 40);
                                    }
                                }

                                for (var59 = 0; var59 < 2; ++var59) {
                                    var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                    var56 = var2.bR.a(this.aV, this.aW - 30.0F, this.posZ, -16711936);
                                    if (var56 != null) {
                                        var56.G = 1.5F;
                                        var56.F = 3.8F;
                                        var56.E = 0.8F;
                                        var56.V = 590.0F;
                                        var56.W = var56.V;
                                        var56.Q = -0.2F;
                                        var56.s = true;
                                        var56.t = 50.0F;
                                        var56.B = null;
                                        var56.x = Color.a(105, 115, 115, 115);
                                        var56.U = (float) (20 + var59 * 40);
                                    }
                                }

                                for (var59 = 0; var59 < 1; ++var59) {
                                    com.corrodinggames.rts.gameFramework.effect.f var61 = com.corrodinggames.rts.gameFramework.effect.f
                                            .a(this.aV + com.corrodinggames.rts.gameFramework.GameUtils.a(-10.0F, 10.0F,
                                                    (int) this.objectId),
                                                    this.aW + com.corrodinggames.rts.gameFramework.GameUtils.a(-10.0F,
                                                            10.0F, (int) this.objectId + var59));
                                    if (var61 != null) {
                                        var61.t = (float) (200 + var59 * 70);
                                        var61.a = (float) (980 + var59 * 800);
                                    }
                                }

                                if (!com.corrodinggames.rts.gameFramework.utility.y.d(this.aV, this.aW)) {
                                    com.corrodinggames.rts.game.l.a(this.aV, this.aW, com.corrodinggames.rts.game.m.b);
                                }

                                if (com.corrodinggames.rts.gameFramework.GameEngine.aB()) {
                                    if (var2.bR.m == null) {
                                        var2.bR.m = var2.bO.a(com.corrodinggames.rts.R.drawable.shockwave_normal_256, true);
                                    }

                                    var2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
                                    var56 = var2.bR.a(this.aV, this.aW, this.posZ, -1);
                                    if (var56 != null && var2.bR.m != null) {
                                        var56.a = new ay(null);
                                        var56.a.imageStrip = new com.corrodinggames.rts.gameFramework.effect.g();
                                        var56.a.imageStrip.k = true;
                                        var56.a.imageStrip.i = var2.bR.m;
                                        var56.a.imageStrip.b = var56.a.imageStrip.i.m();
                                        var56.a.imageStrip.c = var56.a.imageStrip.i.l();
                                        var56.ar = 3;
                                        var56.G = 0.5F;
                                        var56.F = 3.5F;
                                        var56.E = 0.5F;
                                        var56.V = 60.0F;
                                        var56.W = var56.V;
                                        var56.Q = -0.2F;
                                        var56.s = true;
                                        var56.t = 1.0F;
                                        var56.B = null;
                                        var56.U = 0.0F;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (this.bn && !this.V) {
                this.W = com.corrodinggames.rts.gameFramework.GameUtils.a(this.W, var1);
                if (this.ao) {
                    var16 = 1.0F - this.W / this.X;
                    this.b(var16);
                }

                if (this.W == 0.0F) {
                    this.V = true;
                    this.b(1.0F);
                    if (!this.B && !this.M && !var3.X) {
                        this.a();
                    }
                }
            }

            this.J += var1;
            if (this.h == 0.0F && (!this.bn || this.V)) {
                if (var3.ak != null) {
                    Object var49 = null;
                    boolean var42 = false;
                    BaseUnit var39 = this.j;
                    var20 = null;
                    var3.ak.a(this.posX, this.posY, this.posZ, this.az, var39, (m) null, var42, this.aD + 1, this, null);
                }

                this.a();
            }

            if (!this.aU) {
                this.aT = var15;
                this.aU = true;
            }

            var16 = com.corrodinggames.rts.gameFramework.GameUtils.c(this.aT, var15, 12.0F * var1);
            this.aT += var16;
        }
    }

    public void b(float f2) {
        float f3;
        boolean bl2 = false;
        if (this.g.f) {
            return;
        }
        if (this.g.e) {
            bl2 = true;
        }
        if (!bl2) {
            if (this.Y != 0.0f && this.Z > 0.0f) {
                bl2 = true;
            }
            if ((this.ag != 0.0f || this.ah != 0.0f) && this.Z > 0.0f) {
                bl2 = true;
            }
        }
        if (!bl2) {
            return;
        }
        float f4 = f3 = this.Z * f2;
        if (this.g.h) {
            f4 += 150.0f;
        }
        GameEngine l2 = GameEngine.getInstance();
        bi.clear();
        l2.cc.b(this.aV, this.aW, f4, bi);
        BaseUnit[] amArray = bi.a();
        int n2 = bi.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            BaseUnit am2 = amArray[i2];
            this.b(am2, f2, f3);
        }
        bi.clear();
    }

    public void b(BaseUnit am2, float f2, float f3) {
        float f4;
        if (am2.cN != null) {
            return;
        }
        if (this.ap != null && this.ap.contains(am2)) {
            return;
        }
        if (this.j != null) {
            PlayerTeam n2 = am2.bX;
            PlayerTeam n3 = this.j.bX;
            if (n2 != n3 && n3.d(n2)) {
                return;
            }
            if (this.aa && !n3.c(n2)) {
                return;
            }
            if (this.ab && n3.c(n2)) {
                return;
            }
        }
        if (am2.posZ < -5.0f && this.aX >= -2.0f && !this.ac) {
            return;
        }
        if (this.ae) {
            boolean bl2;
            boolean bl3 = bl2 = this.aX >= 5.0f;
            if (am2.i() != bl2) {
                return;
            }
        } else if (!this.ad && am2.i()) {
            return;
        }
        if ((f4 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.aV, this.aW, am2.posX, am2.posY)) > f3 * f3
                && !this.g.h) {
            return;
        }
        float f5 = (float) StrictMath.sqrt(f4);
        if (this.g.h && (f5 -= am2.cj) < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > f3) {
            return;
        }
        if (f5 < this.g.j) {
            return;
        }
        this.a(f2, am2, f5);
    }

    public void a(float f2, BaseUnit am2, float f3) {
        float f4 = 1.0f - f3 / this.Z;
        if ((f4 = (float) ((double) f4 + 0.1)) > 1.0f) {
            f4 = 1.0f;
        }
        if (this.g.g) {
            f4 = 1.0f;
        }
        float f5 = f4 * this.Y;
        this.a(am2);
        f5 = this.g.a(am2, f5, true);
        com.corrodinggames.rts.game.f.a(this.j, am2, f5, this, true);
        if (this.ao) {
            if (this.ap == null) {
                this.ap = new m();
            }
            this.ap.add(am2);
        }
    }

    @Override
    public boolean a(GameEngine l2) {
        if (l2.cO.b(this.posX, this.posY)) {
            return true;
        }
        return (this.B || this.E || this.g.X) && this.l != null && l2.cO.b(this.l.posX, this.l.posY);
    }

    @Override
    public boolean c(float f2) throws IOException {
        int n2;
        float f3;
        float f4;
        float f5;
        if (!this.S) {
            return false;
        }
        if (this.i > 0.0f) {
            return false;
        }
        com.corrodinggames.rts.game.g g2 = this.g;
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.gameFramework.m.y y2 = l2.bO;
        float f6 = this.posX - l2.cw;
        float f7 = this.posY - l2.cx;
        if (this.l != null) {
            f5 = this.l.posX;
            f4 = this.l.posY;
            f3 = this.l.posZ;
        } else {
            f5 = this.n;
            f4 = this.o;
            f3 = this.p;
        }
        if (!this.aZ && !this.D) {
            n2 = 0;
            if (this.A) {
                if (this.l != null) {
                    if (!l2.bL.a(this.l.posX, this.l.posY, l2.bs)) {
                        n2 = 1;
                    }
                } else if (this.m && !l2.bL.a(this.n, this.o, l2.bs)) {
                    n2 = 1;
                }
            }
            if (!l2.bL.a(this.posX, this.posY, l2.bs) && n2 == 0) {
                return false;
            }
            this.aZ = true;
        }
        if (this.E || g2.X) {
            if (g2.Y != null) {
                Paint paint = this.f();
                float f8 = 0.0f;
                float f9 = 0.0f;
                if (g2.ad != 0.0f) {
                    f9 += g2.ad * this.J;
                }
                float f10 = this.posX - l2.cw;
                float f11 = this.posY - l2.cx - this.posZ;
                float f12 = f5 - l2.cw + this.K;
                float f13 = f4 - f3 - l2.cx + this.L;
                float f14 = (f12 + f10) * 0.5f;
                float f15 = (f13 + f11) * 0.5f;
                float f16 = com.corrodinggames.rts.gameFramework.GameUtils.b(f14, f15, f12, f13);
                float f17 = com.corrodinggames.rts.gameFramework.GameUtils.d(f14, f15, f12, f13);
                y2.k();
                f.a(f14 - (float) g2.Y.r, f15 - f16, f14 + (float) g2.Y.r, f15 + f16);
                y2.a(f17 + 90.0f, f14, f15);
                y2.a(g2.Y, f, paint, f8, f9, 0, 0);
                y2.l();
                if (g2.Z != null) {
                    if (g2.aa) {
                        y2.k();
                        y2.a(f17 + 90.0f, f10, f11);
                        y2.a(g2.Z, f10, f11, paint);
                        y2.l();
                    } else {
                        y2.a(g2.Z, f10, f11, paint);
                    }
                }
                if (g2.ab != null) {
                    if (g2.ac) {
                        y2.k();
                        y2.a(f17 + 90.0f, f12, f13);
                        y2.a(g2.ab, f12, f13, paint);
                        y2.l();
                    } else {
                        y2.a(g2.ab, f12, f13, paint);
                    }
                }
            } else {
                bf.c((int) (60.0f + this.e() * 60.0f));
                float f18 = f5 - l2.cw + this.K;
                float f19 = f4 - f3 - l2.cx + this.L;
                bf.a(6.0f);
                y2.a(this.posX - l2.cw, this.posY - l2.cx - this.posZ, f18, f19, bf);
                bf.a(3.0f);
                y2.a(this.posX - l2.cw, this.posY - l2.cx - this.posZ, f18, f19, bf);
                y2.a(f18, f19, 8.0f, bf);
                y2.a(f18, f19, 5.0f, bf);
            }
        } else if (this.B) {
            float f20 = f5 - l2.cw + this.K;
            float f21 = f4 - f3 - l2.cx + this.L;
            bd.b(this.ar);
            be.b(this.ar);
            be.c((int) ((float) be.f() * 0.5f));
            y2.a(this.posX - l2.cw, this.posY - l2.cx - this.posZ, f20, f21, be);
            y2.a(this.posX - l2.cw, this.posY - l2.cx - this.posZ, f20, f21, bd);
            y2.a(f20, f21, 5.0f, bd);
        } else if (this.M) {
            this.N = com.corrodinggames.rts.gameFramework.GameUtils.a(this.N, f2);
            if (this.O == null) {
                this.O = new float[20];
                this.N = 0.0f;
            }
            if (this.N == 0.0f) {
                this.N = 4.0f;
                for (n2 = 0; n2 < this.O.length; ++n2) {
                    this.O[n2] = com.corrodinggames.rts.gameFramework.GameUtils.c(-10.0f, 10.0f);
                }
            }
            float f22 = this.posX - l2.cw;
            float f23 = this.posY - l2.cx - this.posZ;
            float f24 = f5 - l2.cw;
            float f25 = f4 - f3 - l2.cx;
            float f26 = com.corrodinggames.rts.gameFramework.GameUtils.c(f22, f23, f24, f25);
            int n3 = this.O.length;
            if (f26 < 200.0f) {
                n3 = com.corrodinggames.rts.gameFramework.GameUtils.b(0, n3 - 5);
            } else if (f26 < 100.0f) {
                n3 = com.corrodinggames.rts.gameFramework.GameUtils.b(0, n3 - 10);
            }
            float f27 = f26 / (float) (n3 - 1);
            float f28 = com.corrodinggames.rts.gameFramework.GameUtils.d(f22, f23, f24, f25);
            float f29 = f22;
            float f30 = f23;
            float f31 = com.corrodinggames.rts.gameFramework.GameUtils.k(f28);
            float f32 = com.corrodinggames.rts.gameFramework.GameUtils.j(f28);
            for (int i2 = 0; i2 < n3; ++i2) {
                float f33 = this.O[i2];
                float f34 = f22 + f31 * (float) i2 * f27;
                float f35 = f23 + f32 * (float) i2 * f27;
                if (i2 != n3 - 1) {
                    f34 -= f32 * f33;
                    f35 += f31 * f33;
                }
                y2.a(f29, f30, f34, f35, bg);
                f29 = f34;
                f30 = f35;
            }
        } else if (this.P != -1) {
            Object object;
            com.corrodinggames.rts.gameFramework.m.Texture_M e2 = b;
            int n4 = 20;
            int n5 = 20;
            if (this.R == 1) {
                e2 = d;
                n4 = 60;
                n5 = 60;
            } else if (this.R == 2) {
                e2 = c;
                n4 = 20;
                n5 = 20;
            }
            if (g2.C != null) {
                object = g2.C;
                int n6 = g2.C.p;
                int n7 = g2.C.q;
                int n8 = 0;
                com.corrodinggames.rts.gameFramework.utility.y.a((com.corrodinggames.rts.gameFramework.m.Texture_M) object, f6,
                        f7, 0.0f, this.aT, this.x, bc, n6, n7, n8);
            } else if (this.Q != -1 && this.z) {
                object = e2;
                int n9 = n4;
                int n10 = n5;
                com.corrodinggames.rts.gameFramework.utility.y.a((com.corrodinggames.rts.gameFramework.m.Texture_M) object, f6,
                        f7, 0.0f, this.aT, this.x, bc, n9, n10, this.Q);
            }
            if (g2.B != null) {
                e2 = g2.B;
                n4 = g2.B.p;
                n5 = g2.B.q;
            }
            object = this.f();
            com.corrodinggames.rts.gameFramework.utility.y.a(e2, f6, f7, this.posZ, this.aT, this.x, (Paint) object, n4,
                    n5, this.P);
        } else {
            bb.b(this.ar);
            if (this.posZ > 0.0f && this.z) {
                y2.a(f6, f7, this.x, bc);
            }
            y2.a(f6, f7 - this.posZ, this.x, bb);
            if (this.y > 0.0f) {
                bb.c(bb.f() / 3);
                y2.a(f6, f7 - this.posZ, this.y, bb);
            }
        }
        return true;
    }

    @Override
    public void a(float f2, boolean bl2) {
    }

    @Override
    public void d(float f2) {
    }

    @Override
    public void e(float f2) {
    }

    @Override
    public boolean f(float f2) {
        return false;
    }

    public Paint f() {
        Paint paint;
        if (this.ar != aq) {
            if (com.corrodinggames.rts.gameFramework.GameEngine.at()) {
                paint = this.a(this.ar);
            } else {
                paint = bb;
                paint.b(this.ar);
            }
        } else {
            paint = ba;
        }
        return paint;
    }

    public ag a(int n2) {
        if (this.bj != null) {
            return this.bj;
        }
        if (bk != null && bl == n2) {
            this.bj = bk;
            return this.bj;
        }
        ag ag2 = new ag();
        ag2.a(new LightingColorFilter(n2, 0));
        ag2.b(n2);
        bk = ag2;
        bl = n2;
        this.bj = ag2;
        return this.bj;
    }

    public void a(float f2, float f3, h h2) {
        GameEngine l2 = GameEngine.getInstance();
        if (this.j == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("Projectile: cannot Retarget: source==null");
        } else {
            float f4 = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(this.az) * f3;
            float f5 = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(this.az) * f3;
            float f6 = f2;
            float f7 = f6 * f6;
            float f8 = -1.0f;
            com.corrodinggames.rts.game.units.y y2 = null;
            BaseUnit am2 = null;
            if (this.j instanceof com.corrodinggames.rts.game.units.y) {
                y2 = (com.corrodinggames.rts.game.units.y) this.j;
                am2 = y2.ab();
            }
            for (BaseUnit am3 : ((Iterable<BaseUnit>) l2.cc.a(f4, f5, f6))) {
                if (this.j.bX == am3.bX)
                    continue;
                boolean bl2 = true;
                if (y2 != null) {
                    bl2 = y2.b(am3, true);
                }
                if (bl2 && this.k >= 0 && y2 != null && this.k < y2.bl() && !y2.a(this.k, am3, true, false)) {
                    bl2 = false;
                }
                if (h2 != null && !com.corrodinggames.rts.game.units.custom.g.a(h2, am3.de())) {
                    bl2 = false;
                }
                if (!bl2)
                    continue;
                float f9 = com.corrodinggames.rts.gameFramework.GameUtils.a(f4, f5, am3.posX, am3.posY);
                boolean bl3 = false;
                if (f8 == -1.0f || f9 < f8) {
                    bl3 = true;
                }
                if (am2 == am3) {
                    bl3 = true;
                }
                if (!bl3 || !(f9 < f7))
                    continue;
                f8 = f9;
                this.l = am3;
            }
        }
    }

    static {
        bd = new Paint();
        be = new Paint();
        bf = new Paint();
        bg = new Paint();
        bh = new Paint();
        bc = new ag();
        bc.b(-16777216);
        bc.c(108);
        bd.a(80, 255, 0, 0);
        bd.a(true);
        bd.a(5.0f);
        be.a(30, 255, 0, 0);
        be.a(true);
        be.a(8.0f);
        bf.a(80, 128, 166, 255);
        bf.a(true);
        bf.a(5.0f);
        bg.a(150, 224, 239, 255);
        bg.a(true);
        bg.a(3.0f);
        bh.a(110, 224, 239, 255);
        bh.a(true);
        bh.a(8.0f);
        bi = new UnitList();
        bk = null;
        bl = 0;
    }
}
