/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 */
package com.corrodinggames.rts.game.units;

import android.graphics.PorterDuff;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;

import com.corrodinggames.rts.game.a.BaseZone;
import com.corrodinggames.rts.game.b.MapTile;
import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.l;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a_f;
import com.corrodinggames.rts.game.units.a.FilteredUnitAction;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.UnitStatistics;
import com.corrodinggames.rts.game.units.UnitSize;
import com.corrodinggames.rts.game.units.NearestUnitFinder;
import com.corrodinggames.rts.game.units.UnitStateTracker;
import com.corrodinggames.rts.game.units.PassiveTargetCallback;
import com.corrodinggames.rts.game.units.PositionData;
import com.corrodinggames.rts.game.units.CommandType;
import com.corrodinggames.rts.game.units.MultiTargetPassiveCallback;
import com.corrodinggames.rts.game.units.Tree;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitMovementData;
import com.corrodinggames.rts.game.units.PathfindingUtils;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.UnitCommand;
import com.corrodinggames.rts.game.units.UnitCommandType;
import com.corrodinggames.rts.game.units.UnitBehaviorType;
import com.corrodinggames.rts.game.units.custom.be;
import com.corrodinggames.rts.game.units.d.d;
import com.corrodinggames.rts.game.units.d.r;
import com.corrodinggames.rts.game.units.f.j;
import com.corrodinggames.rts.game.units.g.c;
import com.corrodinggames.rts.game.units.w;
import com.corrodinggames.rts.game.units.y$1;
import com.corrodinggames.rts.game.units.z;
import com.corrodinggames.rts.gameFramework.sound.e;
import com.corrodinggames.rts.gameFramework.ProfilerSection;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.k.p;
import com.corrodinggames.rts.gameFramework.utility.Vector3D;
import com.corrodinggames.rts.gameFramework.utility.m;
import com.corrodinggames.rts.gameFramework.utility.o;
import com.corrodinggames.rts.gameFramework.utility.UnitList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class y
        extends com.corrodinggames.rts.game.units.c_f {
    public static boolean L = false;
    protected com.corrodinggames.rts.gameFramework.m.Texture_M M;
    protected com.corrodinggames.rts.gameFramework.m.Texture_M N;
    private int a;
    private float b;
    private float c;
    private float d;
    private float e;
    private int f = 0;
    public static final UnitCommand[] O = new UnitCommand[0];
    private UnitCommand[] g = O;
    public a_f P = com.corrodinggames.rts.game.units.a_f.onlyInRange;
    int Q = -9999;
    public BaseUnit R;
    public float S;
    public float T;
    public float U;
    private boolean h;
    private int i = -9999;
    public float V;
    public float W;
    public float X;
    public float Y;
    private boolean j;
    private boolean k;
    private float l = 3.0f;
    private float m = 3.0f;
    private int n;
    private float o;
    private float p;
    private byte q;
    private int r;
    private float s;
    private boolean t;
    public BaseUnit Z;
    public int aa;
    public float ab;
    public int ac;
    public y ad;
    public boolean ae;
    public boolean af;
    public int ag;
    public short ah;
    public float ai;
    public boolean aj = false;
    public float ak = 0.0f;
    public float al = 0.0f;
    public float am = 0.0f;
    public int an = 0;
    public float ao = 0.0f;
    public boolean ap;
    public float aq = -999.0f;
    public boolean ar = false;
    public boolean as = false;
    public static final PositionData[] at = new PositionData[0];
    public com.corrodinggames.rts.gameFramework.k.c au;
    protected PositionData[] av = at;
    protected int aw = 0;
    private boolean u;
    private int v = 0;
    private int w;
    public boolean ax = true;
    public boolean ay;
    public float az;
    public float aA;
    public com.corrodinggames.rts.game.a.AIUnitGroupBase aB;
    public BaseZone aC;
    public boolean aD;
    public static final com.corrodinggames.rts.gameFramework.m.ag aE = new com.corrodinggames.rts.gameFramework.m.ag();
    public static final com.corrodinggames.rts.gameFramework.m.ag aF;
    public static final PointF aG;
    private com.corrodinggames.rts.gameFramework.m.ag x = null;
    private int y;
    private com.corrodinggames.rts.gameFramework.m.ag z = null;
    private int A;
    private static final Paint B;
    private static int C;
    private static final com.corrodinggames.rts.gameFramework.m.ag D;
    private static final com.corrodinggames.rts.gameFramework.m.ag E;
    public static j aH;
    public byte aI = 0;
    public BaseUnit[] aJ;
    public float[] aK;
    public int aL = -9999;
    public static final UnitList aM;
    public boolean aN;
    public boolean aO;
    static final UnitStateTracker aP;
    public static PassiveTargetCallback aQ;
    public static PassiveTargetCallback aR;
    public static MultiTargetPassiveCallback aS;
    public static MultiTargetPassiveCallback aT;
    com.corrodinggames.rts.gameFramework.k.k aU = null;
    static m aV;
    public static final PositionData aW;
    protected static PorterDuffColorFilter aX;
    protected static PorterDuffColorFilter aY;
    protected static PorterDuffColorFilter aZ;
    protected static PorterDuffColorFilter ba;
    protected static Paint bb;
    protected static Paint bc;
    protected static Paint bd;
    static final PointF be;
    protected static final Vector3D bf;
    protected static final PointF bg;
    protected static final PointF bh;
    protected static final Vector3D bi;
    protected static final PointF bj;
    static final Point bk;
    static final Point bl;
    static final PointF bm;
    static final z bn;
    public static final NearestUnitFinder bo;
    public m bp;
    static m bq;

    public void b(float f2) {
        if (this.az < f2) {
            this.az = f2;
        }
    }

    public Paint R() {
        boolean bl2 = this.aO();
        if (bl2) {
            return aF;
        }
        return aE;
    }

    public static void a(y y2, y y3) {
        try {
            com.corrodinggames.rts.gameFramework.j.GameOutputStream as2 = new com.corrodinggames.rts.gameFramework.j.GameOutputStream();
            int n2 = y2.f;
            for (int i2 = 0; i2 < n2; ++i2) {
                y2.g[i2].a(as2);
            }
            GameInputStream k2 = new GameInputStream(as2.d());
            y3.f = n2;
            for (int i3 = 0; i3 < n2; ++i3) {
                int n3 = i3;
                y3.m(n3);
                if (n3 >= y3.g.length) {
                    com.corrodinggames.rts.gameFramework.GameEngine.b("Too many waypoints:" + i3);
                    n3 = y3.g.length - 1;
                }
                if (y3.g[n3] == null) {
                    y3.g[n3] = new UnitCommand();
                }
                y3.g[n3].a(k2);
                y3.g[n3].c();
            }
        } catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.b);
        as2.a(this.c);
        as2.a(this.cL[0].rotation);
        as2.a(this.f);
        int n2 = this.f;
        as2.a(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.g[i2].a(as2);
        }
        as2.a(this.P);
        BaseUnit am2 = this.R;
        if (am2 != null && am2.bV) {
            am2 = null;
        }
        as2.a(am2);
        as2.a(this.S);
        as2.a(this.U);
        as2.a(this.V);
        as2.d("pathing_active:");
        as2.a(this.k);
        as2.a(this.l);
        as2.a(this.m);
        as2.a(this.s);
        as2.a(this.ad);
        as2.a(this.ae);
        as2.a(this.af);
        as2.a(this.aj);
        as2.a(this.ak);
        as2.a(this.al);
        as2.a(this.am);
        as2.a(this.an);
        as2.a(this.ac);
        as2.d("activePathCount:");
        as2.a(this.aw);
        for (int i3 = 0; i3 < this.aw; ++i3) {
            this.av[i3].a(as2);
        }
        as2.a(this.aw);
        as2.a(this.v);
        if (as2.f()) {
            // empty if block
        }
        as2.c(12);
        as2.a(this.o);
        as2.a(this.p);
        as2.a(this.d);
        as2.a(this.e);
        as2.a(this.u);
        as2.a(this.ai);
        as2.a(this.n);
        as2.a(this.W);
        as2.a(this.aq);
        as2.a(this.ar);
        as2.a(this.as);
        as2.a(this.ah);
        as2.a(this.ab);
        as2.a(this.w);
        as2.a(this.X);
        as2.a(this.az);
        as2.a(this.aA);
        com.corrodinggames.rts.game.units.g.c.a(this, as2);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        int n2;
        int n3;
        this.b = k2.g();
        this.c = k2.g();
        this.cL[0].rotation = k2.g();
        this.f = k2.readInt();
        if (this.f > 0) {
            this.m(com.corrodinggames.rts.gameFramework.GameUtils.c(this.f - 1, 29));
        }
        int n4 = 30;
        if (k2.b() >= 42) {
            n4 = k2.readInt();
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2;
            this.m(n5);
            if (n5 >= this.g.length) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("Too many waypoints:" + i2);
                n5 = this.g.length - 1;
            }
            if (this.g[n5] == null) {
                this.g[n5] = new UnitCommand();
            }
            this.g[n5].a(k2);
        }
        this.P = (a_f) k2.b(a_f.class);
        if (this.P == com.corrodinggames.rts.game.units.a_f.outOfRange) {
            if (!this.I()) {
                this.P = com.corrodinggames.rts.game.units.a_f.onlyInRange;
            }
            if (k2.b() < 74) {
                this.P = com.corrodinggames.rts.game.units.a_f.onlyInRange;
            }
        }
        long l2 = k2.n();
        this.S = k2.g();
        this.U = k2.g();
        this.V = k2.g();//float
        this.k = k2.e();//boolean
        this.l = k2.g();
        this.m = k2.g();
        this.s = k2.g();
        this.a(k2.p());
        this.ae = k2.e();
        this.af = k2.e();
        this.aj = k2.e();
        this.ak = k2.g();
        this.al = k2.g();
        this.am = k2.g();
        this.an = k2.readInt();

// GameEngine.e("=== Debug: Reading unit data ===");
// GameEngine.e("l2: " + l2);
// GameEngine.e("S: " + this.S);
// GameEngine.e("U: " + this.U);
// GameEngine.e("V: " + this.V);
// GameEngine.e("k: " + this.k);
// GameEngine.e("l: " + this.l);
// GameEngine.e("m: " + this.m);
// GameEngine.e("s: " + this.s);
// GameEngine.e("ae: " + this.ae);
// GameEngine.e("af: " + this.af);
// GameEngine.e("aj: " + this.aj);
// GameEngine.e("ak: " + this.ak);
// GameEngine.e("al: " + this.al);
// GameEngine.e("am: " + this.am);
// GameEngine.e("an: " + this.an);
        if (k2.b() >= 18) {
            this.ac = k2.readInt();
        }
        if (k2.b() >= 21) {
            n3 = k2.readInt();
            for (n2 = 0; n2 < n3; ++n2) {
                this.l(n2);
                if (this.av[n2] == null) {
                    this.av[n2] = new PositionData();
                }
                this.av[n2].a(k2);
            }
        } else {
            n3 = 60;
            for (n2 = 0; n2 < 60; ++n2) {
                this.l(n2);
                if (this.av[n2] == null) {
                    this.av[n2] = new PositionData();
                }
                this.av[n2].a(k2);
            }
        }
        this.aw = k2.readInt();
        this.v = k2.readInt();
        n3 = k2.d();
        if (n3 >= 1) {
            this.o = k2.g();
            this.p = k2.g();
        }
        if (n3 >= 2) {
            this.d = k2.g();
            this.e = k2.g();
        }
        if (n3 >= 3) {
            this.u = k2.e();
        }
        if (n3 >= 4) {
            this.ai = k2.g();
            this.n = k2.readInt();
        }
        if (n3 >= 5) {
            this.W = k2.g();
        }
        if (n3 >= 6) {
            this.aq = k2.g();
            this.ar = k2.e();
            this.as = k2.e();
        }
        if (n3 >= 7) {
            this.ah = k2.v();
        }
        if (n3 >= 8) {
            this.ab = k2.g();
        }
        if (n3 >= 9) {
            this.w = k2.readInt();
        }
        if (n3 >= 10) {
            this.X = k2.g();
        }
        if (n3 >= 11) {
            this.az = k2.g();
            this.aA = k2.g();
        }
        if (n3 >= 12) {
            com.corrodinggames.rts.game.units.g.c.a(this, k2);
        }
        super.a(k2);
        if (!this.bV) {
            this.R = com.corrodinggames.rts.gameFramework.GGameObject.a(l2, false);
            for (n2 = 0; n2 < this.f; ++n2) {
                if (this.g[n2] == null) {
                    com.corrodinggames.rts.gameFramework.GameEngine
                            .log("readIn: convertUnitIds is null: " + n2 + " waypointsCount:" + this.f);
                    continue;
                }
                this.g[n2].c();
            }
        }
        this.S();
        if (this.bV) {
            this.ew = true;
        }
    }

    @Override
    public void b(PlayerTeam n2) {
        super.b(n2);
        this.S();
    }

    public void S() {
        this.M = this.d();
        this.N = this.k();
    }

    public abstract com.corrodinggames.rts.gameFramework.m.Texture_M d();

    public abstract com.corrodinggames.rts.gameFramework.m.Texture_M k();

    public abstract com.corrodinggames.rts.gameFramework.m.Texture_M d(int var1);

    public float h(int n2) {
        return 0.0f;
    }

    public float i(int n2) {
        return 0.0f;
    }

    public com.corrodinggames.rts.gameFramework.m.Texture_M T() {
        return null;
    }

    public Paint a(int n2, ColorFilter colorFilter, boolean bl2) {
        int n3;
        Paint paint;
        if (n2 == -1 && colorFilter == null) {
            if (bl2) {
                return E;
            }
            return D;
        }
        if (this.cp) {
            if (colorFilter == null) {
                paint = B;
                n3 = C;
                C = n2;
            } else {
                paint = B;
                n3 = -1;
                if (colorFilter == aZ) {
                    paint = bc;
                }
                if (colorFilter == aY) {
                    paint = bb;
                }
                if (colorFilter == ba) {
                    paint = bd;
                }
            }
        } else if (bl2) {
            if (this.z == null) {
                this.z = com.corrodinggames.rts.game.units.y.a(true);
            }
            paint = this.z;
            n3 = this.A;
            this.A = n2;
        } else {
            if (this.x == null) {
                this.x = com.corrodinggames.rts.game.units.y.a(false);
            }
            paint = this.x;
            n3 = this.y;
            this.y = n2;
        }
        if (n3 != n2) {
            paint.b(n2);
        }
        if (paint.h() != colorFilter) {
            paint.a(colorFilter);
        }
        return paint;
    }

    public static com.corrodinggames.rts.gameFramework.m.ag a(boolean bl2) {
        com.corrodinggames.rts.gameFramework.m.ag ag2 = new com.corrodinggames.rts.gameFramework.m.ag();
        if (bl2) {
            ag2.a(true);
            ag2.d(true);
            ag2.b(true);
        } else {
            ag2.a(false);
            ag2.d(false);
            ag2.b(false);
        }
        return ag2;
    }

    public y(boolean bl2) {
        super(bl2);
    }

    public final void j(int n2) {
        int n3 = this.bl();
        for (int i2 = 0; i2 < n3; ++i2) {
            this.cL[i2].a(n2);
        }
    }

    public void a(String string2) {
        String string3 = this.r() != null ? this.r().i() : "<NO UNIT TYPE>";
        com.corrodinggames.rts.gameFramework.GameEngine.log("(Unit log:" + string3 + " id:" + this.objectId + "): " + string2);
    }

    public void U() {
        String string2 = this.r() != null ? this.r().i() : "<NO UNIT TYPE>";
        com.corrodinggames.rts.gameFramework.GameEngine.log("---- Debug for:" + string2 + " id:" + this.objectId + "---");
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.ay) {
            this.ay = false;
        }
        if (this.cl != 0.0f) {
            this.cl = com.corrodinggames.rts.gameFramework.GameUtils.a(this.cl, f2);
        }
        if (!this.bV && this.bT()) {
            float f3;
            float f4;
            UnitMovementData ap2;
            int n2;
            com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
            if (this.az > 0.0f) {
                this.az = com.corrodinggames.rts.gameFramework.GameUtils.a(this.az, f2);
            }
            if (this.aA > 0.0f) {
                this.aA = com.corrodinggames.rts.gameFramework.GameUtils.a(this.aA, f2);
            }
            if (this.bp != null) {
                com.corrodinggames.rts.game.units.g.c.a(this, f2);
            }
            float f5 = this.posX;
            float f6 = this.posY;
            int n3 = this.bl();
            for (n2 = 0; n2 < n3; ++n2) {
                ap2 = this.cL[n2];
                if (ap2.velocityY == 0.0f) {
                    f4 = this.C(n2);
                    if (!this.b(n2, f2) || ap2.targetX == f4)
                        continue;
                    f3 = com.corrodinggames.rts.gameFramework.GameUtils.c(ap2.targetX, f4, 360.0f);
                    if (com.corrodinggames.rts.gameFramework.GameUtils.c(f3) < 0.5f) {
                        ap2.velocityY = 20.0f;
                        ap2.velocityX = 0.0f;
                        continue;
                    }
                    this.a(f2, f4, n2);
                    continue;
                }
                ap2.velocityY = com.corrodinggames.rts.gameFramework.GameUtils.a(ap2.velocityY, f2);
            }
            if (!this.bk()) {
                try {
                    this.k(f2);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (n2 = 0; n2 < n3; ++n2) {
                ap2 = this.cL[n2];
                if (ap2.rotation == 0.0f)
                    continue;
                ap2.rotation = com.corrodinggames.rts.gameFramework.GameUtils.a(ap2.rotation, f2);
            }
            n2 = this.bi() ? 1 : 0;
            boolean bl2 = false;
            boolean bl3 = bl2 = this.cc != 0.0f || this.cd != 0.0f;
            if ((this.cf != 0.0f || bl2) && this.I()) {
                f4 = this.cg;
                f3 = this.z();
                if (this.bj()) {
                    f4 = this.ch;
                }
                if (n2 == 0) {
                    float f7 = f3 * this.cf * f2;
                    f5 += com.corrodinggames.rts.gameFramework.GameUtils.k(f4) * f7;
                    f6 += com.corrodinggames.rts.gameFramework.GameUtils.j(f4) * f7 * this.aZ();
                    if (bl2) {
                        f5 += this.cc * f2;
                        f6 += this.cd * f2 * this.aZ();
                        float f8 = com.corrodinggames.rts.gameFramework.GameUtils.a(0.0f, 0.0f, this.cc, this.cd);
                        if (f8 > f3 * f3) {
                            this.cc = (float) ((double) this.cc - (double) this.cc * 0.05 * (double) f2);
                            this.cd = (float) ((double) this.cd - (double) this.cd * 0.05 * (double) f2);
                        }
                        this.cc = com.corrodinggames.rts.gameFramework.GameUtils.a(this.cc, 0.0f, 0.5f * f3 * f2);
                        this.cd = com.corrodinggames.rts.gameFramework.GameUtils.a(this.cd, 0.0f, 0.5f * f3 * f2);
                    }
                } else {
                    float f9;
                    float f10;
                    float f11;
                    float f12;
                    if (this.cf != 0.0f) {
                        f12 = this.C() * 1.41f;
                        f11 = com.corrodinggames.rts.gameFramework.GameUtils.k(f4) * f3 * this.cf;
                        f10 = com.corrodinggames.rts.gameFramework.GameUtils.j(f4) * f3 * this.cf;
                    } else {
                        f12 = this.D() * 1.41f;
                        f11 = 0.0f;
                        f10 = 0.0f;
                    }
                    float f13 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.cc, this.cd, f11, f10);
                    if (f13 > f3 * f3) {
                        this.cc = (float) ((double) this.cc - (double) this.cc * 0.05 * (double) f2);
                        this.cd = (float) ((double) this.cd - (double) this.cd * 0.05 * (double) f2);
                    }
                    if (f13 < (f9 = f12 * f2) * f9) {
                        this.cc = f11;
                        this.cd = f10;
                    } else {
                        float f14 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.cc, this.cd, f11, f10);
                        this.cc += com.corrodinggames.rts.gameFramework.GameUtils.k(f14) * f9;
                        this.cd += com.corrodinggames.rts.gameFramework.GameUtils.j(f14) * f9;
                    }
                    f5 += this.cc * f2;
                    f6 += this.cd * f2 * this.aZ();
                }
                this.ay = true;
            }
            if (this.bZ != 0.0f || this.ca != 0.0f) {
                this.bZ = com.corrodinggames.rts.gameFramework.GameUtils.b(this.bZ, -9.0f, 9.0f);
                this.ca = com.corrodinggames.rts.gameFramework.GameUtils.b(this.ca, -9.0f, 9.0f);
                f5 += this.bZ;
                f6 += this.ca;
                this.ca = 0.0f;
                this.bZ = 0.0f;
                this.ay = true;
            }
            if (this.ay && this.I() && this.cO == null) {
                this.a(f2, l2, f5, f6);
            }
            if (this.ax) {
                this.ax = false;
                this.c(false);
                this.ay = true;
            }
        }
    }

    private void a(float var1, GameEngine var2, float var3, float var4) {
        TileMap var5 = var2.bL;
        float var6 = var5.r;
        float var7 = var5.s;
        float var8 = this.posX * var6;
        float var9 = this.posY * var7;
        float var10 = var3 * var6;
        float var11 = var4 * var7;
        PointF var12 = null;
        boolean var13 = false;
        int var14 = com.corrodinggames.rts.gameFramework.GameUtils.f(var8);
        int var15 = com.corrodinggames.rts.gameFramework.GameUtils.f(var9);
        int var16 = com.corrodinggames.rts.gameFramework.GameUtils.f(var10);
        int var17 = com.corrodinggames.rts.gameFramework.GameUtils.f(var11);
        boolean var18;
        boolean var19;
        if ((var14 != var16 || var15 != var17) && this.cl == 0.0F && var2.bU.a(this.h(), var16, var17)) {
            if (var14 != var16 && var15 != var17) {
                var18 = var2.bU.a(this.h(), var14, var17);
                var19 = var2.bU.a(this.h(), var16, var15);
                if (var18 && var19) {
                    var13 = true;
                    aG.a(var8, var9);
                    var12 = aG;
                }

                if (var12 == null && var18) {
                    var12 = com.corrodinggames.rts.game.units.PathfindingUtils.a(this.h(), var8, var9, var10, var11, var14, var17,
                            false);
                }

                if (var12 == null && var19) {
                    var12 = com.corrodinggames.rts.game.units.PathfindingUtils.a(this.h(), var8, var9, var10, var11, var16, var15,
                            false);
                }
            }

            if (var12 == null) {
                var12 = com.corrodinggames.rts.game.units.PathfindingUtils.a(this.h(), var8, var9, var10, var11, var16, var17, false);
            }

            if (var12 == null) {
                var13 = true;
                aG.a(var8, var9);
                var12 = aG;
            }
        }

        var18 = false;
        if (var12 != null) {
            var19 = false;
            boolean var20 = var2.bU.a(this.h(), var14, var15);
            if (var20 && !var2.bU.b(this.h(), var16, var17)) {
                var19 = true;
            }

            if (!var19) {
                var3 = var12.x * (float) var5.n;
                var4 = var12.b * (float) var5.o;
                var18 = true;
            } else {
                var13 = false;
            }
        }

        if (var18) {
            this.b += var1;
            this.a = 0;
        } else if (this.b != 0.0F && var1 > 0.0F) {
            ++this.a;
            if (this.a >= 3) {
                this.b = 0.0F;
            }
        }

        if (!var13) {
            int var21 = com.corrodinggames.rts.gameFramework.GameUtils.f(var3 * var6);
            int var22 = com.corrodinggames.rts.gameFramework.GameUtils.f(var4 * var7);
            this.posX = var3;
            this.posY = var4;
            if (var14 != var21 || var15 != var22) {
                this.c(true);
            }
        }

    }

    public void b(float f2, float f3) {
        com.corrodinggames.rts.game.b.TileMap b2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bL;
        float f4 = b2.r;
        float f5 = b2.s;
        int n2 = com.corrodinggames.rts.gameFramework.GameUtils.f(this.posX * f4);
        int n3 = com.corrodinggames.rts.gameFramework.GameUtils.f(this.posY * f5);
        int n4 = com.corrodinggames.rts.gameFramework.GameUtils.f(f2 * f4);
        int n5 = com.corrodinggames.rts.gameFramework.GameUtils.f(f3 * f5);
        this.posX = f2;
        this.posY = f3;
        if (n2 != n4 || n3 != n5) {
            this.c(true);
        }
    }

    public static void g(float f2) {
        y y2;
        int n2;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        l2.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.j);
        int n3 = l2.by;
        UnitList u2 = aM;
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n4 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (n2 = 0; n2 < n4; ++n2) {
            amArray[n2].bR();
        }
        for (n2 = 0; n2 < n4; ++n2) {
            float f3;
            if (!(amArray[n2] instanceof y))
                continue;
            y2 = (y) amArray[n2];
            if (!y2.ay && !y2.cb || !y2.I() || y2.aL > n3)
                continue;
            y2.cb = false;
            y2.ay = true;
            if (y2.cK) {
                f3 = y2.cj + 7.0f;
                y2.aL = y2.aI > 9 ? n3 + 200 + n2 % 50 : n3 + 50 + n2 % 50;
            } else {
                f3 = y2.cj + 5.0f;
                y2.aL = n3 + 250 + n2 % 50;
            }
            y2.aI = 0;
            u2.clear();
            l2.cc.b(y2.posX, y2.posY, f3, u2);
            BaseUnit[] amArray2 = u2.a();
            int n5 = u2.b;
            for (int i2 = 0; i2 < n5; ++i2) {
                BaseUnit am2 = amArray2[i2];
                y2.a(am2, f2, true);
            }
            if (y2.aI <= 9 || y2.bz <= n3 - 400)
                continue;
            y2.aL = l2.by + 5 + n2 % 5;
            y2.cb = true;
        }
        l2.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.j);
        l2.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.k);
        for (n2 = 0; n2 < n4; ++n2) {
            int n6;
            if (!(amArray[n2] instanceof y))
                continue;
            y2 = (y) amArray[n2];
            if (!y2.ay || (n6 = y2.aI) <= 0 || !y2.I())
                continue;
            if (!y2.cb) {
                y2.cb = true;
            }
            for (int i3 = 0; i3 < n6; ++i3) {
                BaseUnit am3 = y2.aJ[i3];
                y2.a(am3, f2, false);
            }
        }
        l2.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.k);
    }

    private final void a(BaseUnit otherUnit, float deltaTime, boolean isAddingToCollisionList) {
        // 如果碰撞的是自己，直接返回
        if (otherUnit == this) {
            return;
        }

        // 检查是否在同一团队
        int myTeamId = this.bU;
        if (myTeamId == -1 || otherUnit.bU != myTeamId) {
            return;
        }

        // 检查是否已经是彼此的碰撞对象
        if (this.bQ != otherUnit && otherUnit.bQ != this) {
            // 计算两个单位的中心位置
            float myCenterX = this.posX + this.bZ;
            float myCenterY = this.posY + this.ca;

            float otherCenterX = otherUnit.posX + otherUnit.bZ;
            float otherCenterY = otherUnit.posY + otherUnit.ca;

            // 计算两个单位之间的距离平方
            float distanceSquared = com.corrodinggames.rts.gameFramework.GameUtils.a(myCenterX, myCenterY, otherCenterX,
                    otherCenterY);

            // 计算碰撞半径之和
            float totalRadius = this.cj + otherUnit.cj;

            if (isAddingToCollisionList) {
                // 添加到碰撞列表的处理
                float collisionDistance = distanceSquared;

                // 检查是否发生碰撞
                if (distanceSquared < totalRadius * totalRadius) {
                    collisionDistance = 0.0f; // 发生碰撞时距离设为0
                }

                // 检查otherUnit是否是y类型单位，避免重复添加
                if (otherUnit instanceof y) {
                    y otherYUnit = (y) otherUnit;
                    byte collisionCount = otherYUnit.aI;

                    for (int i = 0; i < collisionCount; i++) {
                        if (otherYUnit.aJ[i] == this) {
                            return; // 已经存在，直接返回
                        }
                    }
                }

                // 初始化碰撞数组
                if (this.aJ == null) {
                    this.aJ = new BaseUnit[10];
                    this.aK = new float[10];
                }

                BaseUnit[] collisionArray = this.aJ;
                float[] distanceArray = this.aK;

                // 寻找插入位置（按距离排序）
                int insertIndex = -1;
                for (int i = 0; i < this.aI; i++) {
                    if (collisionDistance < distanceArray[i]) {
                        insertIndex = i;
                        break;
                    }
                }

                // 如果没有找到合适位置，插入到末尾
                if (insertIndex == -1) {
                    if (this.aI >= collisionArray.length) {
                        return; // 数组已满
                    }
                    insertIndex = this.aI;
                }

                // 增加碰撞计数
                if (this.aI < collisionArray.length) {
                    this.aI++;
                }

                // 移动数组元素为插入腾出空间
                for (int i = this.aI - 1; i > insertIndex; i--) {
                    collisionArray[i] = collisionArray[i - 1];
                    distanceArray[i] = distanceArray[i - 1];
                }

                // 插入新的碰撞关系
                collisionArray[insertIndex] = otherUnit;
                distanceArray[insertIndex] = collisionDistance;

            } else {
                // 物理碰撞响应处理

                // 检查是否发生碰撞且双方都可以碰撞
                if (distanceSquared < totalRadius * totalRadius &&
                        !otherUnit.a(this, deltaTime) &&
                        !this.a(otherUnit, deltaTime)) {

                    // 计算碰撞角度
                    float collisionAngle = com.corrodinggames.rts.gameFramework.GameUtils.d(myCenterX, myCenterY,
                            otherCenterX, otherCenterY);

                    // 计算实际距离
                    float actualDistance = (float) Math.sqrt(distanceSquared);

                    // 计算穿透深度
                    float penetration = totalRadius - actualDistance + 0.001f;

                    if (penetration > 0.0f) {
                        // 计算碰撞优先级
                        int myPriority = this.s(otherUnit);
                        int otherPriority = otherUnit.s(this);
                        int priority = Math.max(myPriority, otherPriority);

                        float force = penetration;

                        // 根据优先级调整力的大小
                        if (priority != 0) {
                            force = penetration / priority * deltaTime;
                            if (force > penetration) {
                                force = penetration;
                            }
                        }

                        // 应用力衰减
                        force *= 0.95f;

                        // 多级力衰减（防止过大的力）
                        if (force > 1.0f) {
                            force *= 0.7f;
                        }
                        if (force > 3.0f) {
                            force = 3.0f + (force - 3.0f) * 0.7f;
                        }
                        if (force > 6.0f) {
                            force = 6.0f + (force - 6.0f) * 0.7f;
                        }
                        if (force > 10.0f) {
                            force = 10.0f + (force - 10.0f) * 0.7f;
                        }

                        // 获取双方质量
                        float myMass = this.bN();
                        float otherMass = otherUnit.bN();

                        // 检查otherUnit是否是y类型
                        y otherYUnit = null;
                        if (otherUnit instanceof y) {
                            otherYUnit = (y) otherUnit;
                        }

                        float myForceRatio = 0.0f;

                        // 同队碰撞的特殊处理
                        if (this.bX == otherUnit.bX) {
                            boolean hasFormationRelation = false;
                            float formationMultiplier = 1.7f;

                            if (otherYUnit != null) {
                                // 重型单位处理
                                if (this.W > 200.0f || otherYUnit.W > 200.0f) {
                                    formationMultiplier = 5.0f;
                                }

                                // 编队关系处理
                                if (this.ad == otherYUnit) {
                                    // 当前单位跟随otherUnit
                                    otherMass *= formationMultiplier;
                                    hasFormationRelation = true;
                                }

                                if (otherYUnit.ad == this) {
                                    // otherUnit跟随当前单位
                                    myMass *= formationMultiplier;
                                    hasFormationRelation = true;
                                }

                                if (!hasFormationRelation) {
                                    // 复杂的编队逻辑
                                    if (this.ae && otherYUnit.ad != null) {
                                        myMass *= formationMultiplier;
                                    } else if (otherYUnit.ae && this.ad != null) {
                                        otherMass *= formationMultiplier;
                                    } else if (this.c == 0.0f && otherYUnit.c != 0.0f) {
                                        myMass *= formationMultiplier;
                                    } else if (otherYUnit.c == 0.0f && this.c != 0.0f) {
                                        otherMass *= formationMultiplier;
                                    }
                                }
                            }
                        }

                        // 计算力分配比例（基于质量）
                        if (otherUnit instanceof com.corrodinggames.rts.game.units.w) {
                            myForceRatio = myMass / (myMass + otherMass);
                        }

                        float otherForceRatio = 1.0f - myForceRatio;

                        // 计算碰撞方向分量
                        float cosAngle = com.corrodinggames.rts.gameFramework.GameUtils.k(collisionAngle);
                        float sinAngle = com.corrodinggames.rts.gameFramework.GameUtils.j(collisionAngle);

                        // 应用力到otherUnit
                        if (otherUnit instanceof com.corrodinggames.rts.game.units.w) {
                            float otherForce = force * myForceRatio;
                            otherUnit.bZ += cosAngle * otherForce;
                            otherUnit.ca += sinAngle * otherForce;
                        }

                        // 应用力到当前单位
                        float myForce = force * otherForceRatio;
                        this.bZ -= cosAngle * myForce;
                        this.ca -= sinAngle * myForce;

                        // 记录碰撞信息
                        GameEngine framework = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
                        int currentTime = framework.bx;

                        this.Z = otherUnit;
                        this.aa = currentTime;

                        if (otherYUnit != null) {
                            otherYUnit.Z = this;
                            otherYUnit.aa = currentTime;

                            // 处理相同编队的碰撞
                            if (this.ac != 0 && this.ac == otherYUnit.ac) {
                                // 检查并可能取消编队
                                UnitCommand formation;
                                if (this.ar() == null) {
                                    formation = otherYUnit.ar();
                                    if (formation != null &&
                                            (formation.a == com.corrodinggames.rts.game.units.UnitCommandType.move ||
                                                    formation.a == com.corrodinggames.rts.game.units.UnitCommandType.attackMove)) {
                                        otherYUnit.ay(); // 取消编队
                                    }
                                }

                                if (otherYUnit.ar() == null) {
                                    formation = this.ar();
                                    if (formation != null &&
                                            (formation.a == com.corrodinggames.rts.game.units.UnitCommandType.move ||
                                                    formation.a == com.corrodinggames.rts.game.units.UnitCommandType.attackMove)) {
                                        this.ay(); // 取消编队
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public int V() {
        return 1;
    }

    public void a(int n2) {
    }

    protected void W() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (this.bX == l2.bs) {
            l2.bS.i.b(this);
        }
    }

    public float b(float f2, float f3, float f4) {
        if (this.E()) {
            if (this.bI()) {
                return 0.0f;
            }
            float f5 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, f3, f4);
            return this.c(f2, f5);
        }
        if (this.bl() < 1) {
            return 0.0f;
        }
        int n2 = this.aT();
        if (n2 == -1) {
            n2 = 0;
        }
        PointF pointF = this.G(n2);
        float f6 = com.corrodinggames.rts.gameFramework.GameUtils.d(pointF.x, pointF.b, f3, f4);
        UnitMovementData ap2 = this.cL[n2];
        ap2.a(70);
        return this.a(f2, f6, n2);
    }

    public float c(float f2, float f3) {
        boolean bl2 = false;
        boolean bl3 = false;
        if (this.ci && this.bb()) {
            bl2 = true;
            bl3 = true;
        }
        return this.a(f2, f3, bl2, bl3);
    }

    @Override
    public void h(float f2) {
        float f3 = com.corrodinggames.rts.gameFramework.GameUtils.c(this.cg, f2, 360.0f);
        if ((double) com.corrodinggames.rts.gameFramework.GameUtils.c(f3) > 0.01) {
            this.i(f3);
        }
    }

    public float a(float f2, float f3, boolean bl2, boolean bl3) {
        this.ch = f3;
        if (com.corrodinggames.rts.gameFramework.GameUtils.c(this.cg - f3) < 0.01f) {
            if (bl2 && this.ci) {
                this.j(25);
                this.ci = false;
            }
            return 0.0f;
        }
        float f4 = com.corrodinggames.rts.gameFramework.GameUtils.c(this.cg, f3, 360.0f);
        if (bl2) {
            if (bl3 && com.corrodinggames.rts.gameFramework.GameUtils.c(f4) > 100.0f) {
                f4 = com.corrodinggames.rts.gameFramework.GameUtils.c(this.cg, f3 + 180.0f, 360.0f);
                if (!this.ci) {
                    this.j(25);
                    this.ci = true;
                }
            } else if (this.ci) {
                this.j(25);
                this.ci = false;
            }
        }
        if (com.corrodinggames.rts.gameFramework.GameUtils.c(f4) < 0.01f) {
            return 0.0f;
        }
        if (this.az <= 0.0f) {
            float f5 = this.B();
            if (f5 <= 0.0f) {
                float f6 = f4 > 0.0f ? 1.0f : -1.0f;
                float f7 = f6 * this.A() * f2;
                if (com.corrodinggames.rts.gameFramework.GameUtils
                        .c(f7) > com.corrodinggames.rts.gameFramework.GameUtils.c(f4)) {
                    f7 = f4;
                }
                this.i(f7);
            } else {
                float f8 = f4 > 0.0f ? 1.0f : -1.0f;
                float f9 = com.corrodinggames.rts.gameFramework.GameUtils.c(this.ce) / f5;
                this.ce = com.corrodinggames.rts.gameFramework.GameUtils.c(f4) < f9
                        ? com.corrodinggames.rts.gameFramework.GameUtils.a(this.ce, f8 * f5, f5 * f2)
                        : com.corrodinggames.rts.gameFramework.GameUtils.a(this.ce, f8 * this.A(), f5 * f2);
                float f10 = this.ce * f2;
                if (com.corrodinggames.rts.gameFramework.GameUtils
                        .c(f10) > com.corrodinggames.rts.gameFramework.GameUtils.c(f4)) {
                    this.ce = 0.0f;
                    f10 = f4;
                }
                this.i(f10);
            }
        }
        return f4;
    }

    public void i(float f2) {
        this.cg += f2;
        if (this.cg > 180.0f) {
            this.cg -= 360.0f;
        }
        if (this.cg < -180.0f) {
            this.cg += 360.0f;
        }
        if (this.bm()) {
            int n2 = this.bl();
            for (int i2 = 0; i2 < n2; ++i2) {
                UnitMovementData ap2 = this.cL[i2];
                ap2.targetX += f2;
                if (ap2.targetX > 180.0f) {
                    ap2.targetX -= 360.0f;
                }
                if (!(ap2.targetX < -180.0f))
                    continue;
                ap2.targetX += 360.0f;
            }
        }
    }

    public void j(float f2) {
        int n2 = this.bl();
        for (int i2 = 0; i2 < n2; ++i2) {
            UnitMovementData ap2 = this.cL[i2];
            ap2.targetX = f2 + this.B(i2);
        }
    }

    public void a(int n2, float f2) {
        UnitMovementData ap2 = this.cL[n2];
        ap2.targetX += f2;
    }

    public float a(float f2, float f3, int n2) {
        UnitMovementData ap2 = this.cL[n2];
        float f4 = ap2.targetX;
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.c(f4, f3, 360.0f);
        if (f5 == 0.0f) {
            return f5;
        }
        float f6 = this.w(n2);
        if (f6 <= 0.0f) {
            float f7 = com.corrodinggames.rts.gameFramework.GameUtils.c(ap2.targetX, f3, this.c(n2) * f2);
            this.a(n2, f7);
            f5 -= f7;
        } else {
            float f8 = this.y(n2);
            float f9 = f5 > 0.0f ? 1.0f : -1.0f;
            float f10 = com.corrodinggames.rts.gameFramework.GameUtils.c(ap2.velocityX) / f8;
            boolean bl2 = f5 > 0.0f == ap2.velocityX > 0.0f;
            ap2.velocityX = com.corrodinggames.rts.gameFramework.GameUtils.c(f5) < f10 && bl2
                    ? com.corrodinggames.rts.gameFramework.GameUtils.a(ap2.velocityX, f9 * f8, f8 * f2)
                    : com.corrodinggames.rts.gameFramework.GameUtils.a(ap2.velocityX, f9 * this.c(n2), f6 * f2);
            float f11 = ap2.velocityX * f2;
            if (com.corrodinggames.rts.gameFramework.GameUtils.c(f11) > com.corrodinggames.rts.gameFramework.GameUtils
                    .c(f5)) {
                ap2.velocityX = 0.0f;
                f11 = f5;
            }
            this.a(n2, f11);
            f5 -= f11;
        }
        return f5;
    }

    public BaseUnit X() {
        UnitCommand au2;
        if (this.h && (au2 = this.ar()) != null
                && (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.repair || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.reclaim)
                && au2.h != null && !au2.h.bV) {
            return au2.h;
        }
        return null;
    }

    public boolean Y() {
        UnitCommand au2 = this.ar();
        return au2 != null && au2.a == com.corrodinggames.rts.game.units.UnitCommandType.reclaim;
    }

    private void a(float f2, UnitCommand au2, UnitStateTracker ad2) throws IOException {
        if (au2.c == null) {
            this.ay();
            au2 = null;
        }
        if (au2 != null) {
            boolean bl2 = true;
            if (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.triggerActionWhenInRange) {
                // empty if block
            }
            if (bl2) {
                AbstractUnitAction s2 = this.a(au2.c);
                this.U();
                if (s2 == null) {
                    this.a("Failed to find action:" + au2.c.getId());
                } else {
                    PointF pointF = new PointF(au2.e, au2.f);
                    this.a(s2, false, pointF, au2.h);
                }
                this.ay();
                au2 = null;
            }
        }
    }

    private void b(float f2, UnitCommand au2, UnitStateTracker ad2) {
        BaseUnit am2 = au2.i();
        if (am2 != null) {
            this.R = am2;
            if (this.T > 5.0f) {
                this.T = 5.0f;
            }
        }
        this.ay();
        au2 = null;
    }

    private void c(float f2, UnitCommand au2, UnitStateTracker ad2) {
        float f3 = au2.g();
        float f4 = au2.h();
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f3, f4);
        boolean bl2 = au2.a == com.corrodinggames.rts.game.units.UnitCommandType.guard
                || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.follow;
        boolean bl3 = au2.a == com.corrodinggames.rts.game.units.UnitCommandType.guard;
        BaseUnit am2 = au2.h;
        if (bl2) {
            if (am2 == null || am2.bV) {
                this.ay();
                au2 = null;
            }
            if (au2 != null && am2 != null && !am2.cg() && this.bX.c(am2.bX)) {
                this.ay();
                au2 = null;
            }
        }
        if (au2 != null) {
            UnitCommand au3;
            y y2;
            BaseUnit am3;
            UnitCommand au4;
            boolean bl4 = false;
            float f6 = this.cj;
            if (bl2) {
                f6 += am2.cj;
            }
            f6 = au2.a == com.corrodinggames.rts.game.units.UnitCommandType.follow ? (this.cK ? (f6 += 30.0f) : (f6 += 50.0f))
                    : (this.cK ? (f6 += 80.0f) : (f6 += 100.0f));
            if (f5 > f6 * f6) {
                this.k = true;
                this.l = f3;
                this.m = f4;
                this.n = 2;
                if (this.s > 90.0f) {
                    this.s = 90.0f;
                }
                this.r = 18;
                if (this.ad != null && !this.ad.bT()) {
                    ad2.isReset = false;
                }
            } else {
                this.w = 0;
            }
            ad2.isReset = false;
            if (!bl4 && this.R != null && !this.R.bV) {
                boolean bl5 = false;
                if (this.b(this.R, false)) {
                    bl5 = true;
                }
                if (bl5) {
                    float f7 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, this.R.posX, this.R.posY);
                    float f8 = this.o(this.R);
                    boolean bl6 = false;
                    boolean bl7 = false;
                    if (f7 < f8 * f8) {
                        bl7 = true;
                    }
                    if (bl7 && !this.aa()) {
                        bl7 = false;
                    }
                    if (f5 < 22500.0f) {
                        this.w = 0;
                    }
                    if (!bl7 && (this.w == 1 || f5 > 122500.0f)) {
                        bl6 = true;
                        this.w = 1;
                    }
                    if (f5 > 302500.0f || this.w == 1 && f5 > 202500.0f) {
                        bl6 = true;
                        this.w = 1;
                    }
                    if (!bl6) {
                        bl4 = true;
                        this.w = 0;
                        if (bl7) {
                            this.k = false;
                        } else {
                            if (this.s > 90.0f) {
                                this.s = 90.0f;
                            }
                            this.k = true;
                            this.l = this.R.posX;
                            this.m = this.R.posY;
                            this.n = 0;
                            this.j = true;
                        }
                    }
                }
            }
            if (bl3 && !bl4) {
                BaseUnit am4 = am2.q(2.0f);
                if (am4 != null && !this.b(am4, true)) {
                    am4 = null;
                }
                if (am4 == null && this.w != 1 && (am4 = this.q(2.0f)) != null && !this.b(am4, true)) {
                    am4 = null;
                }
                if (am4 != null) {
                    bl4 = true;
                    if (this.s > 90.0f) {
                        this.s = 90.0f;
                    }
                    this.k = true;
                    this.l = am4.posX;
                    this.m = am4.posY;
                    this.n = 0;
                    this.j = true;
                }
            }
            if (bl3 && !bl4 && this.a(am2) && (am2.cu < am2.cv || am2.cm < 1.0f) && this.a(am2)
                    && (au4 = this.ao()) != null) {
                au4.b(am2);
                au4.m = true;
                bl4 = true;
                if (this.s > 20.0f) {
                    this.s = 20.0f;
                }
            }
            if (bl3 && !bl4 && this.ak() && am2 instanceof y && (am3 = (y2 = (y) am2).X()) != null && this.a(am3)
                    && (au3 = this.ao()) != null) {
                au3.b(am3);
                au3.m = true;
                bl4 = true;
                if (this.s > 20.0f) {
                    this.s = 20.0f;
                }
            }
        }
    }

    private void d(float f2, UnitCommand au2, UnitStateTracker ad2) {
        float f3 = au2.g();
        float f4 = au2.h();
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f3, f4);
        if (au2.h == null || au2.h.bV) {
            this.ay();
            au2 = null;
        }
        if (au2 != null) {
            float f6;
            boolean bl2 = false;
            if (au2.h.bI()) {
                if (f5 < 961.0f) {
                    this.Y += f2;
                }
                if (this.Y > 240.0f) {
                    bl2 = true;
                }
                f6 = 21.0f;
                if (au2.h.cc().a()) {
                    f6 = 11.0f;
                }
                if (this.b > 0.0f) {
                    f6 = au2.h.cj + this.cj + 31.0f;
                }
                if (f5 < f6 * f6) {
                    bl2 = true;
                }
            } else {
                f6 = au2.h.cj + this.cj + 5.0f;
                if (f5 < f6 * f6) {
                    bl2 = true;
                }
            }
            if (!bl2) {
                this.k = true;
                this.l = f3;
                this.m = f4;
                this.n = 0;
                if (au2.h.bI()) {
                    Rect rect = au2.h.cc();
                    int n2 = com.corrodinggames.rts.gameFramework.GameUtils.c(rect.c() / 2, rect.b() / 2);
                    this.n = n2 + 1;
                }
                if (this.s > 90.0f) {
                    this.s = 90.0f;
                }
                this.r = 18;
                if (f5 < 48400.0f) {
                    ad2.isReset = false;
                    if (this.s > 0.0f && this.aE() == null) {
                        this.j = true;
                    }
                }
                if (this.ad != null && !this.ad.bT()) {
                    ad2.isReset = false;
                }
            }
            if (bl2) {
                BaseUnit am2 = au2.h;
                this.a(com.corrodinggames.rts.game.units.custom.af.touchTargetSuccess, am2);
                this.ay();
            }
        }
    }

    private void e(float f2, UnitCommand au2, UnitStateTracker ad2) {
        float f3 = au2.g();
        float f4 = au2.h();
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f3, f4);
        if (au2.h == null || au2.h.bV || !au2.h.bT()) {
            this.ay();
            au2 = null;
        }
        if (au2 != null && !this.d(au2.h, false)) {
            this.ay();
        }
        if (au2 != null) {
            this.bQ = au2.h;
            float f6 = this.cs();
            if (f5 > f6 * f6) {
                this.k = true;
                this.l = f3;
                this.m = f4;
                if (this.s > 90.0f) {
                    this.s = 90.0f;
                }
                this.r = 18;
                if (f5 < 72900.0f) {
                    ad2.isReset = false;
                    if (this.s > 0.0f && this.aU == null) {
                        this.j = true;
                    }
                }
                if (this.ad != null && !this.ad.bT()) {
                    ad2.isReset = false;
                }
            } else {
                this.e(au2.h, false);
                this.ay();
            }
        }
    }

    private void a(float f2, UnitCommand au2, UnitStateTracker ad2, boolean bl2) {
        Object object;
        float f3 = au2.g();
        float f4 = au2.h();
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f3, f4);
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (!this.aR()) {
            boolean bl3 = false;
            object = this.dn();
            if (object != null && ((com.corrodinggames.rts.game.units.custom.b.n) object).H) {
                this.bx();
                bl3 = true;
            }
            if (!bl3) {
                this.ax();
                au2 = null;
            }
        }
        float f6 = 7.0f;
        if (f5 < 1681.0f) {
            this.Y += f2;
        }
        if (this.Y > 240.0f) {
            f6 = 16.0f;
        }
        if (this.Y > 340.0f) {
            f6 = 36.0f;
        }
        if (au2 != null && au2.a == com.corrodinggames.rts.game.units.UnitCommandType.patrol) {
            if (this.av() != 1) {
                f6 = 20.0f;
                float f7 = 30.0f;
                if (!bl2 || this.aa == l2.bx || this.aa == l2.bx - 1) {
                    f7 = 70.0f;
                }
                if (f5 < f7 * f7) {
                    this.d(au2);
                    this.ax();
                    au2 = null;
                }
            } else {
                f6 = 30.0f;
                if (!bl2 || this.aa == l2.bx || this.aa == l2.bx - 1) {
                    f6 = 80.0f;
                }
            }
        }
        if (au2 != null) {
            if (f5 < f6 * f6) {
                if (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.patrol) {
                    if (this.av() == 1) {
                        // empty if block
                    }
                } else if (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.attackMove) {
                    boolean bl4 = false;
                    if (this.R != null && !this.R.bV && this.a(this.R, false)) {
                        bl4 = true;
                    }
                    if (!bl4) {
                        this.ax();
                        au2 = null;
                    }
                } else {
                    this.ax();
                    au2 = null;
                }
            } else {
                this.k = true;
                this.l = f3;
                this.m = f4;
                this.n = 0;
                if (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.patrol) {
                    this.t = true;
                    this.aB();
                }
            }
        }
        if (au2 != null) {
            if (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.attackMove || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.patrol) {
                if (this.R != null && !this.R.bV && this.a(this.R, false)) {
                    this.a(f2, this.R, ad2, true);
                }
                if (this.ad != null && this.ad.R != null) {
                    ad2.isReset = false;
                }
            }
            if (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.patrol) {
                if (this.R == null && (object = this.q(3.0f)) != null && this.b((BaseUnit) object, true)) {
                    if (this.s > 90.0f) {
                        this.s = 90.0f;
                    }
                    this.k = true;
                    this.l = ((BaseUnit) object).posX;
                    this.m = ((BaseUnit) object).posY;
                    this.n = 0;
                    this.j = true;
                }
                if (this.ak() && (long) (l2.bx % 10) == this.objectId % 10L
                        && (object = com.corrodinggames.rts.game.units.d.r.a(this, f2, 150.0f, true)) != null) {
                    ((UnitCommand) object).m = false;
                    ((UnitCommand) object).k = 200.0f;
                    this.k = false;
                    this.aH();
                }
            }
        }
    }

    private void f(float f2, UnitCommand au2, UnitStateTracker ad2) {
        float f3 = au2.g();
        float f4 = au2.h();
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f3, f4);
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        UnitType as2 = au2.b;
        if (as2 == null) {
            this.a("activeBuildingType==null, removing waypoint");
            this.ay();
            au2 = null;
        }
        if (au2 != null) {
            boolean bl2;
            float f6 = this.f(as2);
            int n2 = 30;
            boolean bl3 = false;
            if (f6 <= 30.0f) {
                n2 = 9;
            }
            if (f6 <= 25.0f && this.posZ > 4.0f) {
                bl3 = true;
            }
            if (this.ad != null) {
                UnitCommand au3 = this.ad.ar();
                if (au3 == null || au3.a != com.corrodinggames.rts.game.units.UnitCommandType.build) {
                    ad2.isReset = false;
                }
                if (au3 != null && !au2.b(au3)) {
                    ad2.isReset = false;
                }
            }
            boolean bl4 = false;
            if (!com.corrodinggames.rts.gameFramework.utility.y.a(this.Q, 200)) {
                bl4 = true;
            }
            if (f6 > 800000.0f) {
                bl2 = true;
            } else {
                boolean bl5 = bl2 = f5 <= f6 * f6;
            }
            if (!bl2 || bl3) {
                if (!this.aR()) {
                    this.ay();
                    au2 = null;
                } else {
                    this.k = true;
                    this.l = f3;
                    this.m = f4;
                    if (f6 > 58.0f) {
                        this.n = (int) ((f6 - 41.0f) / ((float) l2.bL.n * 1.414f));
                    }
                    if (this.s > 90.0f) {
                        this.s = 90.0f;
                    }
                    if (this.q > 3) {
                        this.ay();
                        au2 = null;
                        return;
                    }
                }
            } else if (!(bl4
                    || this.b_() && com.corrodinggames.rts.gameFramework.GameUtils.c(this.b(f2, f3, f4)) > 30.0f)) {
                z z2 = this.a(au2, au2.b, au2.d, au2.e, au2.f);
                BaseUnit am2 = null;
                if (z2.a != null) {
                    am2 = z2.a;
                } else if (z2.b != null) {
                    am2 = z2.b;
                }
                if (am2 != null) {
                    z2.d.a((BaseUnit) this, am2);
                    if (this.a(am2)) {
                        if (this.b(am2) > 10000.0f) {
                            am2.r(1.0f);
                            this.ax();
                        } else {
                            au2.e();
                            au2.a = com.corrodinggames.rts.game.units.UnitCommandType.repair;
                            au2.h = am2;
                            this.aH();
                        }
                    } else {
                        this.ay();
                    }
                    this.Q = -9999;
                } else {
                    if (au2.b == null) {
                        com.corrodinggames.rts.gameFramework.GameEngine.log("active.build==null");
                    }
                    if (!z2.c) {
                        this.ay();
                    }
                }
            }
        }
    }

    private void a(float f2, BaseUnit am2, UnitStateTracker ad2, boolean bl2) {
        float f3;
        UnitBehaviorType b2 = this.be();
        float f4 = am2.posX;
        float f5 = am2.posY;
        float f6 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f4, f5);
        if (this.ad != null) {
            if (f6 < 490000.0f) {
                if (f6 < 48400.0f) {
                    ad2.isReset = false;
                }
                if ((f3 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.ad.posX, this.ad.posY, f4,
                        f5)) < 48400.0f) {
                    ad2.isReset = false;
                }
                if (f3 < 270400.0f && this.aV()) {
                    ad2.isReset = false;
                }
            }
            if (this.ad.R == am2) {
                ad2.isReset = false;
            }
            this.ai = ad2.isReset ? 0.0f : (this.ai += f2);
        } else {
            this.ai = 500.0f;
        }
        f3 = this.o(am2);
        boolean bl3 = true;
        if (f6 < f3 * f3) {
            if (this.R != am2) {
                if (com.corrodinggames.rts.game.units.PathfindingUtils.a(this, am2)) {
                    this.R = am2;
                    this.S = 10.0f;
                    this.M(-1);
                }
            } else {
                this.S = 10.0f;
            }
            float f7 = f3;
            if (!this.E()) {
                f7 -= 1.0f;
                if (this.aV()) {
                    f7 -= 2.0f;
                }
                if (this.e(0) > 5.0f) {
                    f7 -= 3.0f;
                }
            }
            if (f6 < f7 * f7 && this.be() != com.corrodinggames.rts.game.units.UnitBehaviorType.bomber) {
                if (am2 == null) {
                    bl3 = false;
                } else if (this.i(am2)) {
                    bl3 = false;
                    if (bl2) {
                        this.k = false;
                    }
                } else if (!this.j(am2)) {
                    bl3 = false;
                }
            }
        }
        if (bl3) {
            this.k = true;
            this.l = f4;
            this.m = f5;
            this.n = 0;
            if (b2 == com.corrodinggames.rts.game.units.UnitBehaviorType.bomber) {
                this.a(f6, f4, f5);
            }
            this.n = this.q(am2);
            if (this.s > 90.0f) {
                this.s = 90.0f;
            }
            if (f6 < 810000.0f) {
                if (this.ct() || this.aV()) {
                    this.j = true;
                }
                if (!ad2.isReset && this.ai < 120.0f) {
                    this.s = 0.1f;
                    this.j = true;
                }
            }
        }
    }

    private void g(float f2, UnitCommand au2, UnitStateTracker ad2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        UnitBehaviorType b2 = this.be();
        if (b2 == com.corrodinggames.rts.game.units.UnitBehaviorType.bomber) {
            if (au2 != null && (au2.h == null || au2.h.bV || au2.h.bX == this.bX) && !this.as) {
                if (this.R != null && this.R.bV) {
                    this.R = null;
                }
                float f3 = this.b(true) + 200.0f;
                this.a(l2, f2, f3);
                if (this.R != null) {
                    au2.h = this.R;
                    this.aB();
                    this.aH();
                } else {
                    this.as = true;
                    this.ar = true;
                }
            }
            if (au2 != null && (au2.h == null || au2.h.bV || au2.h.bX == this.bX)) {
                if (au2.h == null) {
                    this.ay();
                    au2 = null;
                } else if (!this.ar) {
                    this.ay();
                    au2 = null;
                }
            }
        } else if (au2.h == null || au2.h.bV || au2.h.bX == this.bX) {
            boolean bl2 = true;
            if (this.av() > 1) {
                bl2 = false;
            }
            au2.h = null;
            if (bl2) {
                if (this.R != null && this.R.bV) {
                    this.R = null;
                }
                float f4 = this.b(true);
                this.a(l2, f2, f4);
                if (this.R != null) {
                    au2.h = this.R;
                    this.aB();
                    this.aH();
                }
            }
            if (au2.h == null) {
                this.ay();
                au2 = null;
            }
        }
        if (au2 != null && au2.h != null && !au2.h.bV && !au2.h.cg() && this.bX.c(au2.h.bX)
                && !com.corrodinggames.rts.game.units.PathfindingUtils.b(this, au2.h)) {
            this.ay();
            au2 = null;
            return;
        }
        if (au2 != null && !this.aR() && !this.l()) {
            this.ay();
            au2 = null;
        }
        if (au2 != null) {
            this.a(f2, au2.h, ad2, false);
        }
    }

    private void h(float f2, UnitCommand au2, UnitStateTracker ad2) {
        float f3 = au2.g();
        float f4 = au2.h();
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f3, f4);
        if (au2.h == null || au2.h.bV) {
            this.ay();
            au2 = null;
        }
        if (au2 != null && !au2.h.d(this, false)) {
            this.ay();
        }
        if (au2 != null) {
            float f6;
            BaseUnit am2;
            this.bQ = am2 = au2.h;
            boolean bl2 = false;
            if (am2.bI()) {
                f6 = am2.cs();
                float f7 = f6 + 10.0f;
                if (f5 < f7 * f7) {
                    this.Y += f2;
                }
                if (this.Y > 240.0f) {
                    bl2 = true;
                }
                float f8 = 21.0f;
                if (am2.cc().a()) {
                    f8 = 11.0f;
                }
                if (this.b > 0.0f) {
                    f8 = am2.cj + 31.0f;
                }
                if (f5 < f8 * f8) {
                    bl2 = true;
                }
            } else {
                f6 = am2.cs();
                if (f5 < f6 * f6) {
                    bl2 = true;
                }
            }
            if (!bl2) {
                this.k = true;
                this.l = f3;
                this.m = f4;
                if (this.s > 90.0f) {
                    this.s = 90.0f;
                }
                this.r = 18;
                if (f5 < 48400.0f) {
                    ad2.isReset = false;
                    if (this.s > 0.0f && this.aU == null) {
                        this.j = true;
                    }
                }
                if (this.ad != null && !this.ad.bT()) {
                    ad2.isReset = false;
                }
            }
            if (bl2) {
                BaseUnit am3 = au2.h;
                am3.e(this, false);
                this.ay();
            }
        }
    }

    public float a_(BaseUnit am2) {
        float f2 = am2.r().D();
        if (am2.V() == 2) {
            f2 *= 0.5f;
        }
        if (am2.V() == 3) {
            f2 *= 0.25f;
        }
        return f2 *= this.b(am2);
    }

    public float f(BaseUnit am2) {
        float f2 = 5.1f;
        return 0.001f * f2;
    }

    public com.corrodinggames.rts.game.units.custom.d.b g(BaseUnit am2) {
        if (am2.by != null) {
            return am2.by;
        }
        return am2.r().B();
    }

    private void i(float f2, UnitCommand au2, UnitStateTracker ad2) {
        int n2;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        boolean bl2 = false;
        boolean bl3 = false;
        if (au2 == null) {
            return;
        }
        float f3 = au2.g();
        float f4 = au2.h();
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f3, f4);
        if (au2 != null && au2.a == com.corrodinggames.rts.game.units.UnitCommandType.reclaim && au2.h != null && au2.h.g() > 0.0f) {
            bl3 = true;
        }
        if (au2 != null && (au2.h == null || au2.h.bV || au2.h.cN != null)) {
            if (bl3) {
                bl2 = true;
            } else {
                this.ax();
                au2 = null;
            }
        }
        if (au2 != null && !bl2 && bl3 && au2.h != null) {
            boolean bl4 = true;
            if (this.i < l2.by - 100) {
                bl4 = false;
            }
            if (!this.g(au2.h, bl4)) {
                bl2 = true;
            }
            if (!bl2) {
                this.i = l2.by;
            }
        }
        if (au2 != null && bl2) {
            BaseUnit am2;
            com.corrodinggames.rts.game.units.custom.h h2 = null;
            if (au2.h != null) {
                h2 = au2.h.cR();
            }
            if ((am2 = com.corrodinggames.rts.game.units.y.a(this, au2.h.posX, au2.h.posY, n2 = this.cS(), h2)) != null) {
                au2.h = am2;
                f3 = au2.g();
                f4 = au2.h();
                f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f3, f4);
                this.aB();
            } else {
                this.ax();
                au2 = null;
            }
        }
        if (au2 != null) {
            if (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.repair) {
                if (!this.a(au2.h)) {
                    this.ay();
                    au2 = null;
                }
            } else if (!bl3 && !this.l(au2.h)) {
                this.ay();
                au2 = null;
            }
        }
        if (au2 != null && au2.a == com.corrodinggames.rts.game.units.UnitCommandType.repair && au2.h != null && au2.h.cu >= au2.h.cv
                && au2.h.cm >= 1.0f) {
            this.ax();
            au2 = null;
        }
        if (au2 != null && au2.h == this) {
            this.ay();
            au2 = null;
        }
        if (au2 != null && au2 != null && au2.h != null && au2.h.g() != 0.0f) {
            boolean bl5 = false;
            if (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.repair) {
                bl5 = true;
            }
            if (bl5) {
                this.ay();
                au2 = null;
            }
        }
        if (au2 != null && au2.a == com.corrodinggames.rts.game.units.UnitCommandType.reclaim && au2.h.bX != this.bX
                && au2.h.g() == 0.0f) {
            boolean bl6 = true;
            if (l2.P() && this.bX.d(au2.h.bX)) {
                bl6 = false;
            }
            if (bl6) {
                this.ay();
                au2 = null;
            }
        }
        if (au2 != null) {
            int n3;
            int n4;
            if (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.reclaim) {
                n4 = this.v(au2.h);
                n2 = this.w(au2.h) ? 1 : 0;
            } else {
                n4 = this.u(au2.h);
                n2 = this.x(au2.h) ? 1 : 0;
            }
            if (this.ad != null) {
                UnitCommand au3;
                float f6 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.ad.posX, this.ad.posY, f3, f4);
                if (f6 < (float) ((n3 = n4 + 80) * n3)) {
                    ad2.isReset = false;
                }
                if ((au3 = this.ad.ar()) == null) {
                    ad2.isReset = false;
                }
                if (au3 != null && !au2.b(au3)) {
                    ad2.isReset = false;
                }
            }
            float f7 = n4;
            if (this.h) {
                f7 += 5.0f;
            }
            n3 = 30;
            if (n4 <= 30) {
                n3 = 9;
            }
            if (f5 > f7 * f7) {
                if (!this.aR() || au2.k == 0.0f) {
                    this.ay();
                } else {
                    float f8;
                    boolean bl7 = false;
                    if (au2.k >= 0.0f
                            && au2.k < (f8 = (float) com.corrodinggames.rts.gameFramework.GameUtils.a((int) f5) - f7)) {
                        bl7 = true;
                    }
                    if (bl7) {
                        this.ay();
                    } else {
                        this.k = true;
                        this.l = f3;
                        this.m = f4;
                        this.n = n4 > 58 ? (int) (((float) n4 - 41.0f) / ((float) l2.bL.n * 1.414f)) : 0;
                        if (n4 < 30 || n2 != 0) {
                            if (f5 < 841.0f) {
                                this.j = true;
                            }
                            if (f5 < (f8 = (float) (n4 + 14)) * f8 && this.s > 0.0f && this.aU == null) {
                                this.j = true;
                            }
                        }
                        this.r = this.n;
                        if (this.s > 90.0f) {
                            this.s = 90.0f;
                        }
                    }
                }
            } else {
                Object object;
                int n5 = this.aT();
                if (n5 == -1) {
                    n5 = 0;
                }
                float f9 = 0.0f;
                if (this.b_()) {
                    f9 = this.b(f2, f3, f4);
                }
                boolean bl8 = false;
                if (com.corrodinggames.rts.gameFramework.GameUtils.c(f9) < 30.0f || !this.b_()) {
                    this.h = true;
                    ad2.stateFlag1 = true;
                    object = this.cL[n5];
                    if (((UnitMovementData) object).speed < this.e(n5)) {
                        ((UnitMovementData) object).speed += f2;
                    } else {
                        ((UnitMovementData) object).speed = this.e(n5);
                        bl8 = true;
                    }
                }
                if (bl8) {
                    object = au2.h;
                    if (au2.a != com.corrodinggames.rts.game.units.UnitCommandType.reclaim) {
                        if (((BaseUnit) object).cm < 1.0f) {
                            this.bC();
                            float f10 = this.a_((BaseUnit) object);
                            float f11 = f10 * f2;
                            boolean bl9 = false;
                            boolean bl10 = false;
                            com.corrodinggames.rts.game.units.custom.d.b b2 = this.g((BaseUnit) object);
                            if (b2 != null) {
                                if (((BaseUnit) object).cm + f11 > 1.0f) {
                                    f11 = 1.0f - ((BaseUnit) object).cm;
                                    bl9 = true;
                                }
                                double d2 = ((BaseUnit) object).cm + f11 - ((BaseUnit) object).cn;
                                double d3 = 0.0;
                                if (bl9) {
                                    d3 = 1.0f - ((BaseUnit) object).cn;
                                } else {
                                    double d4 = 0.001f;
                                    if (d2 >= d4) {
                                        int n6 = (int) (d2 / d4);
                                        d3 = (double) n6 * d4;
                                    }
                                }
                                boolean bl11 = false;
                                if (d3 > 0.0 && this.bX.am.a(b2)) {
                                    bl11 = true;
                                }
                                if (!bl11 && (d3 <= 0.0 || b2.c((BaseUnit) this, d3))) {
                                    ((BaseUnit) object).cn = (float) ((double) ((BaseUnit) object).cn + d3);
                                } else {
                                    if (!bl11) {
                                        this.bX.am.a(b2, (BaseUnit) this, d3);
                                    }
                                    f11 = 0.0f;
                                    bl9 = false;
                                    bl10 = true;
                                }
                            }
                            if (!bl10) {
                                this.a((BaseUnit) object, f2, n5);
                                float f12 = ((BaseUnit) object).cm + f11;
                                if (bl9) {
                                    f12 = 1.0f;
                                }
                                ((BaseUnit) object).r(f12);
                                if (f12 >= 1.0f && (double) f10 < 0.3 && ((BaseUnit) object).bX == l2.bs) {
                                    l2.bS.i.a((BaseUnit) object);
                                }
                                this.aO = false;
                            } else {
                                this.aO = true;
                            }
                        } else {
                            this.a((BaseUnit) object, f2, n5);
                            ((BaseUnit) object).cu += this.c((BaseUnit) object) * f2;
                            if (((BaseUnit) object).cu > ((BaseUnit) object).cv) {
                                ((BaseUnit) object).cu = ((BaseUnit) object).cv;
                                this.ay();
                            }
                            this.aO = false;
                        }
                    } else {
                        this.b((BaseUnit) object, f2, n5);
                        this.aO = false;
                        this.bC();
                        boolean bl12 = false;
                        boolean bl13 = this.y((BaseUnit) object);
                        float f13 = this.z((BaseUnit) object);
                        boolean bl14 = au2.h.g() > 0.0f;
                        com.corrodinggames.rts.game.units.custom.d.b b3 = this.g((BaseUnit) object);
                        if (bl14 || b3 != null) {
                            // empty if block
                        }
                        boolean bl15 = false;
                        if (!bl14 && this.V < 100.0f && !bl14) {
                            if ((double) ((BaseUnit) object).cm < 0.5) {
                                if (b3 == null) {
                                    bl15 = true;
                                }
                            } else if ((double) (((BaseUnit) object).cu / ((BaseUnit) object).cv) < 0.5) {
                                bl15 = true;
                            }
                        }
                        if (!bl15) {
                            float f14;
                            if (((BaseUnit) object).cm < 1.0f) {
                                f14 = this.f((BaseUnit) object) * f2;
                                if (f14 >= ((BaseUnit) object).cm) {
                                    f14 = ((BaseUnit) object).cm;
                                    ((BaseUnit) object).cm = 0.0f;
                                } else {
                                    ((BaseUnit) object).cm -= f14;
                                }
                                ((BaseUnit) object).cn = ((BaseUnit) object).cm;
                                if (b3 != null) {
                                    b3.a((BaseUnit) this, f14, true);
                                }
                                if (((BaseUnit) object).cm <= 0.0f) {
                                    bl12 = true;
                                }
                            } else {
                                f14 = f13 * f2;
                                if (f14 >= ((BaseUnit) object).cu) {
                                    f14 = ((BaseUnit) object).cu;
                                    ((BaseUnit) object).cu = -1.0f;
                                } else {
                                    ((BaseUnit) object).cu -= f14;
                                }
                                ((BaseUnit) object).dp = 1000.0f;
                                if (bl13) {
                                    float f15 = f14 / ((BaseUnit) object).cv;
                                    com.corrodinggames.rts.game.units.custom.d.b b4 = ((BaseUnit) object).cM();
                                    com.corrodinggames.rts.game.units.custom.d.b b5 = ((BaseUnit) object).cN();
                                    if (b5 != null) {
                                        b4 = b5;
                                    }
                                    if (bl14 || b3 != null) {
                                        // empty if block
                                    }
                                    if (b4.a() > 0) {
                                        this.ab += f15 * (float) b4.a();
                                        if (this.ab > 1.0f) {
                                            this.bX.o += (double) ((int) this.ab);
                                            this.ab -= (float) ((int) this.ab);
                                        }
                                        b4.a((BaseUnit) this, f15, false);
                                    } else {
                                        b4.a((BaseUnit) this, f15, true);
                                    }
                                }
                                if (((BaseUnit) object).cu <= 0.0f) {
                                    bl12 = true;
                                }
                            }
                        }
                        if (bl12 && !((BaseUnit) object).bV) {
                            if (!bl13) {
                                com.corrodinggames.rts.game.units.custom.d.b b6 = ((BaseUnit) object).cN();
                                if (b6 != null) {
                                    com.corrodinggames.rts.gameFramework.GameEngine
                                            .log("refund: " + b6.a(false, true, 10, true));
                                    b6.a((BaseUnit) this, 1.0, true);
                                } else {
                                    b6 = ((BaseUnit) object).cM();
                                    if (((BaseUnit) object).bx != null) {
                                        b6 = ((BaseUnit) object).bx;
                                        com.corrodinggames.rts.gameFramework.GameEngine.log(
                                                "refund==null overridePriceBuildCost: " + b6.a(false, true, 10, true));
                                    }
                                    b6.a((BaseUnit) this, 0.8f, true);
                                    if (((BaseUnit) object).cm >= 1.0f && b3 != null) {
                                        b3.a((BaseUnit) this, 0.8f, true);
                                    }
                                }
                            }
                            ((BaseUnit) object).bV = true;
                            ((BaseUnit) object).bW = l2.by;
                            ((BaseUnit) object).ci();
                            if (object instanceof y && ((BaseUnit) object).bI()) {
                                l2.bU.a((y) object);
                            }
                        }
                    }
                }
            }
        }
    }

    public void k(float f2) throws IOException {
        Object object;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (this.bQ != null) {
            this.bQ = null;
        }
        if (this.bR != null) {
            this.bS = com.corrodinggames.rts.gameFramework.GameUtils.a(this.bS, f2);
            this.bQ = this.bR;
            if (this.bS == 0.0f) {
                this.bR = null;
            }
        }
        if (this.s != 0.0f) {
            this.s = com.corrodinggames.rts.gameFramework.GameUtils.a(this.s, f2);
        }
        if (this.cf != 0.0f) {
            this.c = com.corrodinggames.rts.gameFramework.GameUtils.a(this.c, f2);
        }
        UnitCommand au2 = this.ar();
        this.j = false;
        boolean bl2 = this.k;
        this.k = false;
        this.t = false;
        this.r = 150;
        if (au2 != null && au2.l > 0.0f && au2.l < this.V) {
            this.ax();
            au2 = null;
        }
        UnitStateTracker ad2 = aP;
        ad2.a();
        if (au2 != null) {
            this.V += f2;
            object = au2.a;
            if (object == com.corrodinggames.rts.game.units.UnitCommandType.move || object == com.corrodinggames.rts.game.units.UnitCommandType.attackMove
                    || object == com.corrodinggames.rts.game.units.UnitCommandType.patrol) {
                this.a(f2, au2, ad2, bl2);
            } else if (object == com.corrodinggames.rts.game.units.UnitCommandType.attack) {
                this.g(f2, au2, ad2);
            } else if (object == com.corrodinggames.rts.game.units.UnitCommandType.build) {
                this.f(f2, au2, ad2);
            } else if (object == com.corrodinggames.rts.game.units.UnitCommandType.repair
                    || object == com.corrodinggames.rts.game.units.UnitCommandType.reclaim) {
                this.i(f2, au2, ad2);
            } else if (object == com.corrodinggames.rts.game.units.UnitCommandType.loadInto) {
                this.h(f2, au2, ad2);
            } else if (object == com.corrodinggames.rts.game.units.UnitCommandType.loadUp) {
                this.e(f2, au2, ad2);
            } else if (object == com.corrodinggames.rts.game.units.UnitCommandType.touchTarget) {
                this.d(f2, au2, ad2);
            } else if (object == com.corrodinggames.rts.game.units.UnitCommandType.guard
                    || object == com.corrodinggames.rts.game.units.UnitCommandType.guardAt
                    || object == com.corrodinggames.rts.game.units.UnitCommandType.follow) {
                this.c(f2, au2, ad2);
            } else if (object == com.corrodinggames.rts.game.units.UnitCommandType.triggerAction
                    || object == com.corrodinggames.rts.game.units.UnitCommandType.triggerActionWhenInRange) {
                this.a(f2, au2, ad2);
            } else if (object == com.corrodinggames.rts.game.units.UnitCommandType.setPassiveTarget) {
                this.b(f2, au2, ad2);
            }
            if (au2 != this.ar()) {
                au2 = null;
            }
        }
        this.h = ad2.stateFlag1;
        if (au2 != null && au2.m && this.f > 1) {
            boolean bl3 = true;
            UnitCommand au3 = this.k(1);
            if (au3 != null && (au3.a == com.corrodinggames.rts.game.units.UnitCommandType.guard
                    || au3.a == com.corrodinggames.rts.game.units.UnitCommandType.patrol)) {
                bl3 = false;
            }
            if (bl3) {
                this.ay();
                au2 = null;
            }
        }
        if (au2 == null) {
            this.k = false;
        }
        if (this.k) {
            object = this.dn();
            if (object != null && ((com.corrodinggames.rts.game.units.custom.b.n) object).H) {
                this.bx();
            }
        } else if (this.q != 0) {
            this.q = 0;
        }
        this.b(l2, f2);
        this.a(l2, f2, au2, ad2);
    }

    private void a(float f2, float f3, float f4) {
        if (this.aq < -900.0f) {
            float f5;
            this.aq = f5 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, f3, f4);
        }
        if (f2 < 10000.0f && this.bX()) {
            this.ar = true;
        }
        if (this.ar) {
            if ((double) this.cB < (double) this.bd() * 0.6 || f2 < 40000.0f && this.cB < this.bd()) {
                this.l += com.corrodinggames.rts.gameFramework.GameUtils.k(this.aq + 180.0f) * 600.0f;
                this.m += com.corrodinggames.rts.gameFramework.GameUtils.j(this.aq + 180.0f) * 600.0f;
            } else {
                this.ar = false;
                this.aq = -999.0f;
                this.aH();
            }
        }
    }

    private void a(float f2, PositionData af2, UnitStateTracker ad2, UnitCommand au2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        y y2 = this.ad;
        float f3 = y2.posX + this.ak;
        float f4 = y2.posY + this.al;
        boolean bl2 = false;
        int n2 = l2.by - y2.an;
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f3, f4);
        if (n2 > 300 || this.b > 1.0f) {
            this.d += f2;
        }
        boolean bl3 = false;
        if (this.d > 300.0f) {
            bl3 = true;
        }
        if (n2 > 300 && f5 > 250000.0f) {
            bl3 = true;
        }
        if (this.b > 1.0f) {
            if (this.c != 0.0f) {
                bl3 = true;
            }
            if (this.d > 10.0f) {
                bl3 = true;
            }
        }
        if (bl3) {
            this.c = 90.0f;
        }
        if (this.c == 0.0f) {
            float f6;
            float f7;
            float f8;
            PositionData af3;
            this.aH();
            ad2.stateValue1 = f3;
            ad2.stateValue2 = f4;
            PositionData af4 = null;
            if (n2 < 3000 && af4 == null && y2.v > 2 && y2.v - y2.aw <= 2) {
                af4 = y2.o(2);
            }
            if (n2 < 1500 && af4 == null && y2.v > 0 && y2.aw + 0 >= y2.v) {
                af3 = y2.o(0);
                af4 = aW;
                float f9 = com.corrodinggames.rts.gameFramework.GameUtils.d(y2.posX, y2.posY, af3.posX, af3.posY);
                f8 = 80.0f;
                if (n2 > 300) {
                    f7 = 0.06666667f;
                    f8 -= (float) (n2 - 300) * 0.06666667f;
                }
                af4.posX = y2.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(f9) * f8;
                af4.posY = y2.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(f9) * f8;
            }
            if (af4 != null) {
                ad2.stateFlag3 = true;
                ad2.stateValue1 = af4.posX + this.ak;
                ad2.stateValue2 = af4.posY + this.al;
            } else if (y2.v >= 2 && y2.aw >= 1) {
                PositionData af5;
                if (y2.aw >= 2) {
                    af3 = y2.o(0);
                    af5 = y2.o(1);
                } else {
                    af3 = y2.o(0);
                    af5 = y2.o(0);
                }
                if (af3 != null && af5 != null) {
                    float f10;
                    float f11;
                    f8 = com.corrodinggames.rts.gameFramework.GameUtils.c(y2.posX, y2.posY, af3.posX, af3.posY);
                    f7 = 1.0f - (f8 - 15.0f) * 0.05f;
                    if (f7 > 2.0f) {
                        f7 = 2.0f;
                    }
                    if (f7 < 0.0f) {
                        f7 = 0.0f;
                    }
                    if (f7 > 1.0f) {
                        if (y2.aw >= 3) {
                            PositionData af6 = y2.o(2);
                            f11 = af5.posX - af3.posX;
                            f6 = af5.posY - af3.posY;
                            f10 = af6.posX - af5.posX;
                            float f12 = af6.posY - af5.posY;
                            f11 += f10 * (f7 - 1.0f);
                            f6 += f12 * (f7 - 1.0f);
                        } else {
                            f11 = af5.posX - af3.posX;
                            f6 = af5.posY - af3.posY;
                        }
                    } else {
                        float f13 = af5.posX - af3.posX;
                        f10 = af5.posY - af3.posY;
                        f11 = f13 * f7;
                        f6 = f10 * f7;
                    }
                    f3 = af3.posX + this.ak + f11;
                    f4 = af3.posY + this.al + f6;
                    ad2.stateValue1 = f3;
                    ad2.stateValue2 = f4;
                }
            }
            float f14 = 45.0f;
            if (this.b <= 1.0f) {
                f14 = 60.0f;
            } else if (n2 < 500 && this.b <= 1.0f) {
                f14 = 110.0f;
            }
            if (f5 < f14 * f14) {
                this.d = 0.0f;
            }
            boolean bl4 = false;
            UnitCommand au3 = y2.ar();
            boolean bl5 = false;
            if (au3 == null || au2 != null) {
                // empty if block
            }
            if (au3 == null || bl5) {
                this.e += f2;
                boolean bl6 = false;
                if (au2 != null && (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.move
                        || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.attackMove
                        || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.patrol)) {
                    bl6 = true;
                }
                if (f5 < (f6 = bl6
                        && this.e > 600.0f
                                ? 260.0f
                                : (bl6 && this.e > 360.0f ? 140.0f
                                        : (bl6 && this.e > 180.0f ? 70.0f : (bl6 && this.e > 120.0f ? 50.0f : 16.0f))))
                        * f6) {
                    bl4 = true;
                }
                if (bl2) {
                    bl4 = true;
                }
            }
            if (bl4) {
                boolean bl7 = false;
                if (au3 == null) {
                    bl7 = true;
                }
                if (bl5) {
                    bl7 = true;
                }
                if (bl7 && com.corrodinggames.rts.gameFramework.GameUtils.c(f6 = this.c(f2, this.am)) < 3.0f
                        && au2 != null && (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.move
                                || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.attackMove)) {
                    this.ay();
                    if (y2 != null) {
                        boolean bl8 = false;
                        UnitCommand au4 = this.ar();
                        UnitCommand au5 = y2.ar();
                        if (au4 != null && au5 != null && au4.b(au5)) {
                            bl8 = true;
                        }
                        if (!bl8) {
                            this.a((y) null);
                        }
                    }
                }
            } else if (!bl2) {
                ad2.stateFlag2 = true;
            }
        } else {
            PositionData af7 = null;
            int n3 = 8;
            if (af7 == null && y2.v > 2 && n3 < y2.aw) {
                int n4 = n3;
                af7 = y2.o(n4);
            }
            if (af7 == null) {
                af7 = aW;
                af7.posX = y2.posX;
                af7.posY = y2.posY;
            }
            float f15 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, af7.posX, af7.posY);
            float f16 = this.cj + y2.cj + 15.0f;
            float f17 = this.cj + y2.cj + 100.0f;
            if (f15 < f16 * f16) {
                this.d = 0.0f;
                this.c = 0.0f;
            } else if (f15 < f17 * f17) {
                // empty if block
            }
            float f18 = 300.0f;
            boolean bl9 = true;
            if (this.aU == null && af2 != null
                    && (com.corrodinggames.rts.gameFramework.GameUtils.c(this.o - af7.posX) > 300.0f
                            || com.corrodinggames.rts.gameFramework.GameUtils.c(this.p - af7.posY) > 300.0f)
                    && this.s > 30.0f) {
                this.s = 30.0f;
            }
            if (this.s == 0.0f && this.aU == null) {
                this.s = 700.0f;
                boolean bl10 = false;
                this.a(af7.posX, af7.posY, 0, false, bl10);
            }
            if (af2 != null) {
                ad2.stateValue1 = af2.posX;
                ad2.stateValue2 = af2.posY;
                if (!bl2) {
                    ad2.stateFlag2 = true;
                }
            }
        }
    }

    private void a(com.corrodinggames.rts.gameFramework.GameEngine l2, float f2, UnitCommand au2, UnitStateTracker ad2) {
        boolean bl2 = this.I();
        if (this.aU != null) {
            this.b(l2);
        }
        if (this.ad != null && (this.ad.bV || !this.ad.bT())) {
            this.a((y) null);
        }
        if (this.k) {
            UnitCommand au3;
            PositionData af2 = this.aE();
            UnitCommand au4 = this.ar();
            if (au4 == null) {
                ad2.isReset = false;
            }
            if (L) {
                ad2.isReset = false;
            }
            if (this.ae && this.ag > 0 && this.aG()) {
                this.an = l2.by;
            }
            if (au4 != null && this.ad != null && ad2.isReset && (au3 = this.ad.ar()) != null && !au3.b(au4)) {
                ad2.isReset = false;
            }
            if (this.ad != null && ad2.isReset) {
                this.a(f2, af2, ad2, au2);
            } else if (this.cl != 0.0f) {
                ad2.stateValue1 = this.l;
                ad2.stateValue2 = this.m;
                ad2.stateFlag2 = true;
            } else {
                boolean bl3 = false;
                if (this.aU == null) {
                    float f3;
                    if (af2 == null) {
                        if (this.u && this.s < 450.0f && this.aU == null) {
                            bl3 = true;
                        }
                        if (this.s == 0.0f) {
                            bl3 = true;
                        }
                    }
                    if (this.s == 0.0f && (this.ct() || this.aV())) {
                        f3 = this.m() - 1.0f;
                        if (com.corrodinggames.rts.gameFramework.GameUtils.c(this.o - this.l) > f3
                                || com.corrodinggames.rts.gameFramework.GameUtils.c(this.p - this.m) > f3) {
                            bl3 = true;
                        }
                    }
                    if (au2 != null && this.s == 0.0f && (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.loadInto
                            || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.loadUp)) {
                        f3 = 12.0f;
                        if (com.corrodinggames.rts.gameFramework.GameUtils.c(this.o - this.l) > f3
                                || com.corrodinggames.rts.gameFramework.GameUtils.c(this.p - this.m) > f3) {
                            bl3 = true;
                        }
                    }
                    if (au2 != null) {
                        f3 = this.r;
                        if (com.corrodinggames.rts.gameFramework.GameUtils.c(this.o - this.l) > f3
                                || com.corrodinggames.rts.gameFramework.GameUtils.c(this.p - this.m) > f3) {
                            if (this.s > 30.0f) {
                                this.s = 30.0f;
                            }
                            if (this.s == 0.0f) {
                                bl3 = true;
                            }
                        }
                    }
                }
                if (bl3) {
                    this.s = 500.0f;
                    boolean bl4 = this.ae && this.ah > 1;
                    this.a(this.l, this.m, this.n, bl4, this.t);
                }
                if (af2 != null && this.au == null && this.aw >= 2 && this.z() > 5.0f) {
                    PositionData af3 = this.av[1];
                    float f4 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, af2.posX, af2.posY);
                    float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, af3.posX, af3.posY);
                    if (f4 < 36.0f) {
                        this.aJ();
                        af2 = this.aE();
                    } else if (f5 < 361.0f) {
                        this.aJ();
                        af2 = this.aE();
                    }
                }
                if (af2 != null) {
                    ad2.stateValue1 = af2.posX;
                    ad2.stateValue2 = af2.posY;
                    ad2.stateFlag2 = true;
                } else if (this.j) {
                    ad2.stateValue1 = this.l;
                    ad2.stateValue2 = this.m;
                    ad2.stateFlag2 = true;
                }
            }
        }
        this.a(f2, ad2, au2, bl2);
    }

    private void a(float f2, UnitStateTracker ad2, UnitCommand au2, boolean bl2) {
        float f3 = 0.0f;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (this.k && ad2.stateFlag2 && bl2) {
            boolean bl3;
            float f4;
            float f5 = ad2.stateValue1;
            float f6 = ad2.stateValue2;
            float f7 = this.z();
            float f8 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, f5, f6);
            float f9 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, f5,
                    (f6 - this.posY) * this.ba() + this.posY);
            boolean bl4 = false;
            float f10 = this.bc();
            if (f10 > 0.95f) {
                bl4 = true;
            } else if ((double) f10 > 0.87) {
                if (this.ah <= 1 && this.aw > 0 && this.aw <= 9 && this.ae && f8 < 250000.0f) {
                    bl4 = true;
                }
            } else if ((double) f10 > 0.7) {
                if (this.ah <= 1 && this.aw > 0 && this.aw <= 4 && this.ae && f8 < 40000.0f) {
                    bl4 = true;
                }
            } else if ((double) f10 > 0.4 && this.ah <= 1 && this.aw > 0 && this.aw <= 2 && this.ae && f8 < 10000.0f) {
                bl4 = true;
            }
            boolean bl5 = true;
            float f11 = 179.0f;
            if (this.R != null && this.E() && this.bj() && !this.aV()) {
                this.ch = f9;
            } else if (this.az <= 0.0f) {
                f11 = this.a(f2, f9, bl5, bl4);
            }
            float f12 = 20.0f;
            if (f8 > 361.0f) {
                f12 = 46.0f;
            }
            if (f8 > 3600.0f) {
                f12 = 89.0f;
            }
            if ((double) (f4 = this.A()) < 1.4) {
                f12 = f8 > 6400.0f ? (f12 *= 0.5f) : 17.0f;
            }
            if (f7 > 5.0f && (double) this.cf < 0.01 && (double) this.cf > -0.01) {
                f12 = 1.0f;
            }
            if ((double) f4 < 1.1) {
                f12 *= 0.7f;
            }
            if ((double) this.cf > 0.4 && f8 > 16900.0f) {
                f12 = 180.0f;
            }
            if (this.aY() && this.v == this.aw) {
                f12 = 1.0f;
            }
            if (this.bj()) {
                f12 = 181.0f;
            }
            float f13 = 4.0f;
            boolean bl6 = bl3 = this.aw == 1;
            if ((!bl3 || f8 >= f13 * f13) && com.corrodinggames.rts.gameFramework.GameUtils.c(f11) <= f12) {
                f3 = 1.0f;
                if (ad2.stateFlag3) {
                    if (f8 < 2500.0f) {
                        f3 -= 0.15f;
                    }
                    if (f8 < 900.0f) {
                        f3 -= 0.15f;
                    }
                    if (f8 < 225.0f) {
                        f3 -= 0.3f;
                    }
                } else if (this.ad != null) {
                    if (f8 > 400.0f) {
                        f3 += 0.2f;
                    }
                    if (f8 < 49.0f) {
                        f3 -= 0.15f;
                    }
                    if (f8 < 9.0f) {
                        f3 -= 0.15f;
                    }
                }
                if (f8 < 9.0f) {
                    f3 = 0.0f;
                }
            }
            if (bl3 && f3 != 0.0f) {
                if (f8 < 324.0f && this.D() < 0.13f && this.z() > 1.0f) {
                    f3 = 0.5f * f3;
                }
                if (f8 < 169.0f && this.D() < 0.15f && this.z() > 0.9f) {
                    f3 = 0.5f * f3;
                }
                if (f7 > 5.0f) {
                    if (f8 < 324.0f && f3 > 0.5f) {
                        f3 = 0.5f;
                    }
                    if (f8 < 81.0f && f3 > 0.25f) {
                        f3 = 0.25f;
                    }
                }
            }
            boolean bl7 = false;
            if (!bl3 && f8 < 256.0f) {
                bl7 = true;
            }
            if (bl3 && f8 < f13 * f13) {
                bl7 = true;
            }
            if ((this.aa == l2.bx || this.aa == l2.bx - 1) && this.Z != null && this.Z.c(f5, f6, 2.0f)) {
                bl7 = true;
            }
            if (f3 > 0.0f) {
                this.W += f2;
                if (this.W > 200.0f && f8 < 3600.0f && this.aw >= 2) {
                    float f14 = this.W;
                    this.aJ();
                    this.W = f14;
                }
                if (this.W > 600.0f && this.aw >= 2 && this.au == null) {
                    this.aH();
                }
                if (this.W > 80.0f && this.b > 30.0f) {
                    this.aH();
                }
                if (this.W > 40.0f && this.aw >= 2 && this.au == null) {
                    PositionData af2 = this.av[1];
                    float f15 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, af2.posX, af2.posY);
                    if (f15 < f8) {
                        float f16 = this.W;
                        this.aJ();
                        this.W = f16;
                    }
                }
            }
            if (bl7) {
                this.aJ();
                if (bl3) {
                    this.d = 0.0f;
                    this.c = 0.0f;
                    if (!this.u && this.ad == null && au2 != null && au2.a == com.corrodinggames.rts.game.units.UnitCommandType.move) {
                        this.ax();
                    }
                }
            }
        }
        if (this.ci && !this.bj()) {
            f3 = -f3 * this.bc();
        }
        if (this.az > 0.0f) {
            f3 = 0.0f;
        }
        if (!this.bi()) {
            if (this.cf < f3) {
                this.cf = com.corrodinggames.rts.gameFramework.GameUtils.a(this.cf, f3, this.C() * f2);
            }
            if (this.cf > f3) {
                this.cf = com.corrodinggames.rts.gameFramework.GameUtils.a(this.cf, f3, this.D() * f2);
            }
        } else {
            this.cf = f3;
        }
        this.cK = ad2.stateFlag2 && bl2;
    }

    @Deprecated
    public boolean Z() {
        return this.R != null;
    }

    public boolean aa() {
        if (this.R != null && !this.R.bV) {
            int n2 = this.bl();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this.cL[i2].targetUnit == null || !this.r(i2))
                    continue;
                return true;
            }
        }
        return false;
    }

    public BaseUnit ab() {
        if (this.R != null && !this.R.bV) {
            return this.R;
        }
        UnitCommand au2 = this.ar();
        if (au2 != null && au2.h != null && !au2.h.bV) {
            return au2.h;
        }
        return null;
    }

    private void a(com.corrodinggames.rts.gameFramework.GameEngine l2, float f2, float f3) {
        aQ.a(f3);
        l2.cc.a(this.posX, this.posY, f3, this, f2, aQ);
        if (!(com.corrodinggames.rts.game.units.y.aQ.callbackCount == 0 || this.R != null && this.h(this.R))) {
            aR.a(f3);
            l2.cc.a(this.posX, this.posY, f3, this, f2, aR);
        }
    }

    public boolean ac() {
        return this.bl() > 1;
    }

    private void a(com.corrodinggames.rts.gameFramework.GameEngine l2, float f2) {
        int n2;
        int n3 = this.bl();
        if (!this.ac()) {
            for (int i2 = 0; i2 < n3; ++i2) {
                this.cL[i2].targetUnit = this.R;
            }
            return;
        }
        boolean bl2 = false;
        for (n2 = 0; n2 < n3; ++n2) {
            UnitMovementData ap2 = this.cL[n2];
            if (this.v(n2) != -1)
                continue;
            boolean bl3 = false;
            boolean bl4 = false;
            if (this.a(n2, this.R, false, false)) {
                ap2.targetUnit = this.R;
                continue;
            }
            bl2 = true;
            if (ap2.targetUnit != this.R)
                continue;
            ap2.targetUnit = null;
        }
        if (bl2) {
            float f3 = this.b(false);
            aT.a(this);
            l2.cc.a(this.posX, this.posY, f3, this, f2, aT);
        }
        for (n2 = 0; n2 < n3; ++n2) {
            int n4 = this.v(n2);
            if (n4 == -1)
                continue;
            this.cL[n2].targetUnit = this.cL[n4].targetUnit;
        }
    }

    public boolean ad() {
        if (!this.l()) {
            return false;
        }
        com.corrodinggames.rts.game.units.custom.b.n n2 = this.dn();
        return n2 == null || n2.M;
    }

    private void b(com.corrodinggames.rts.gameFramework.GameEngine l2, float f2) {
        int n2;
        int n3 = this.bl();
        boolean bl2 = false;
        if (this.ad()) {
            n2 = 0;
            boolean bl3 = false;
            if (this.R != null) {
                boolean bl4;
                com.corrodinggames.rts.game.units.custom.b.n n4 = this.dn();
                if (n4 != null && this.cO != null && n4.L && this.cO.R == this.R) {
                    n2 = 1;
                }
                if (!this.a(this.R, false) && n2 == 0 && (bl4 = true)) {
                    this.R = null;
                }
            }
            if (this.R != null && n2 == 0) {
                bl3 = !this.h(this.R);
            }
            this.S = com.corrodinggames.rts.gameFramework.GameUtils.a(this.S, f2);
            this.T = com.corrodinggames.rts.gameFramework.GameUtils.a(this.T, f2);
            if ((this.R == null || bl3) && this.S == 0.0f && this.bf()) {
                this.S = 20.0f + this.posX % 5.0f + this.posY % 5.0f;
                float f3 = this.b(false);
                this.a(l2, f2, f3);
                if (this.R != null) {
                    this.T = 0.0f;
                }
            }
            if (this.R != null && this.T == 0.0f) {
                this.T = 20.0f + this.posX % 5.0f + this.posY % 5.0f;
                this.a(l2, f2);
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                this.cL[i2].isActive = false;
            }
            if (this.R != null) {
                float f4;
                float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, this.R.posX, this.R.posY);
                if (f5 < (f4 = this.o(this.R)) * f4 || n2 != 0) {
                    BaseUnit am2;
                    UnitMovementData ap2;
                    int n5;
                    int n6 = this.aT();
                    for (n5 = 0; n5 < n3; ++n5) {
                        boolean bl5;
                        boolean bl6;
                        ap2 = this.cL[n5];
                        am2 = ap2.targetUnit;
                        if (am2 == null)
                            continue;
                        boolean bl7 = bl6 = am2 == this.R;
                        if (!bl6 && !this.b(am2, true)) {
                            ap2.targetUnit = null;
                            continue;
                        }
                        boolean bl8 = false;
                        boolean bl9 = bl5 = !bl6;
                        if (!this.a(n5, am2, false, bl5)) {
                            ap2.targetUnit = null;
                            continue;
                        }
                        PointF pointF = this.G(n5);
                        PointF pointF2 = this.K(n5);
                        pointF2.x += am2.posX;
                        pointF2.b += am2.posY;
                        float f6 = com.corrodinggames.rts.gameFramework.GameUtils.d(pointF.x, pointF.b, pointF2.x,
                                pointF2.b);
                        if (this.v(n5) != -1 || n5 == n6)
                            continue;
                        if (!this.E()) {
                            ap2.a(70);
                            ap2.targetY = ap2.targetX;
                            float f7 = 179.0f;
                            if (!ap2.b()) {
                                f7 = this.a(f2, f6, n5);
                            }
                            if (!(com.corrodinggames.rts.gameFramework.GameUtils.c(f7) < this.x(n5)))
                                continue;
                            ap2.isActive = true;
                            continue;
                        }
                        boolean bl10 = false;
                        UnitCommand au2 = this.ar();
                        if (au2 != null && (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.build
                                || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.repair
                                || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.reclaim)) {
                            bl10 = true;
                        }
                        if (bl10 || this.k && !this.bj())
                            continue;
                        float f8 = this.c(f2, f6);
                        ap2.targetY = ap2.targetX;
                        if (!(com.corrodinggames.rts.gameFramework.GameUtils.c(f8) < this.x(n5)))
                            continue;
                        ap2.isActive = true;
                    }
                    for (n5 = 0; n5 < n3; ++n5) {
                        ap2 = this.cL[n5];
                        am2 = ap2.targetUnit;
                        if (am2 == null)
                            continue;
                        if (this.u(n5) && ap2.rotation == 0.0f) {
                            bl2 = true;
                        }
                        if (!this.u(n5))
                            continue;
                        this.a(f2, am2, n5);
                    }
                } else if (!this.k && this.an()) {
                    this.j = true;
                    this.k = true;
                    this.l = this.R.posX;
                    this.m = this.R.posY;
                    this.n = 0;
                }
            }
        }
        if (this.aN && this.X() != null) {
            bl2 = true;
        }
        for (n2 = 0; n2 < n3; ++n2) {
            UnitMovementData ap3 = this.cL[n2];
            if (bl2 || ap3.speed == 0.0f)
                continue;
            ap3.speed = com.corrodinggames.rts.gameFramework.GameUtils.a(ap3.speed, this.f(n2) * f2);
        }
    }

    public void b(BaseUnit am2, int n2) {
    }

    public boolean a(float f2, BaseUnit am2, int n2) {
        UnitMovementData ap2 = this.cL[n2];
        int n3 = this.v(n2);
        if (n3 != -1) {
            ap2.targetX = this.cL[n3].targetX;
        }
        boolean bl2 = this.s(n2);
        boolean bl3 = false;
        if (bl2) {
            if (ap2.speed < this.e(n2)) {
                if (ap2.speed == 0.0f) {
                    this.b(am2, n2);
                }
                ap2.speed += f2;
            } else {
                ap2.speed = this.e(n2);
            }
            bl3 = true;
        }
        if (ap2.rotation == 0.0f && this.r(n2)) {
            boolean bl4 = false;
            boolean bl5 = false;
            if (!this.a(n2, am2, false, false)) {
                ap2.rotation = -10.0f;
            } else {
                if (!bl2) {
                    if (ap2.speed < this.e(n2)) {
                        if (ap2.speed == 0.0f) {
                            this.b(am2, n2);
                        }
                        ap2.speed += f2;
                    } else {
                        bl3 = true;
                    }
                }
                if (bl3) {
                    ap2.rotation = this.b(n2) + this.t(n2);
                    if (!bl2) {
                        ap2.speed = 0.0f;
                    }
                    this.a(am2, n2);
                    this.M(n2);
                    ap2.m = !ap2.m;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean h(BaseUnit am2) {
        float f2;
        float f3 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, am2.posX, am2.posY);
        return f3 < (f2 = this.o(am2)) * f2;
    }

    public boolean ae() {
        return false;
    }

    public boolean af() {
        return true;
    }

    public boolean ag() {
        return true;
    }

    public boolean ah() {
        return true;
    }

    public boolean i(BaseUnit am2) {
        int n2 = this.bl();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            boolean bl2 = false;
            boolean bl3 = false;
            if (!this.r(i2) || !this.a(i2, am2, false, false)
                    || (n3 = this.v(i2)) != -1 && !this.a(n3, am2, false, false))
                continue;
            return true;
        }
        return false;
    }

    public boolean j(BaseUnit am2) {
        int n2 = this.bl();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            boolean bl2 = true;
            boolean bl3 = false;
            if (!this.r(i2) || !this.a(i2, am2, true, false)
                    || (n3 = this.v(i2)) != -1 && !this.a(n3, am2, true, false))
                continue;
            return true;
        }
        return false;
    }

    public boolean a(int n2, BaseUnit am2, boolean bl2, boolean bl3) {
        return bl2 || !bl3 || this.h(am2);
    }

    public boolean k(BaseUnit am2) {
        if (am2.i()) {
            return this.af();
        }
        if (am2.Q()) {
            return this.ae();
        }
        if (!this.ah() && !am2.cH()) {
            return false;
        }
        return this.ag();
    }

    public boolean a(BaseUnit am2) {
        return false;
    }

    public boolean l(BaseUnit am2) {
        if (am2.g() != 0.0f && this.h(am2, true)) {
            return true;
        }
        return this.a(am2);
    }

    public AbstractUnitAction a(UnitType as2, boolean bl2) {
        return this.a(as2, -1, bl2);
    }

    public boolean ai() {
        for (AbstractUnitAction s2 : ((ArrayList<AbstractUnitAction>) this.N())) {
            if (!s2.g())
                continue;
            return true;
        }
        return false;
    }

    public AbstractUnitAction a(UnitType as2, int n2, boolean bl2) {
        ArrayList<AbstractUnitAction> arrayList = this.N();
        AbstractUnitAction s2 = null;
        if (arrayList.size() > 0) {
            for (AbstractUnitAction s3 : arrayList) {
                UnitType as3;
                UnitType as4 = s3.y();
                if (bl2 && (as3 = s3.E()) != null) {
                    as4 = as3;
                }
                if (as4 != as2 || n2 != -1 && n2 != s3.t())
                    continue;
                s2 = s3;
                if (!s3.b(this) || !s3.a((BaseUnit) this, false))
                    continue;
                return s3;
            }
        }
        return s2;
    }

    public boolean b(UnitType as2, boolean bl2) {
        AbstractUnitAction s2 = this.a(as2, bl2);
        if (s2 != null) {
            if (s2.g(this)) {
                return false;
            }
            return s2.b(this);
        }
        return false;
    }

    @Override
    public boolean aj() {
        return this.r().m();
    }

    @Override
    public boolean ak() {
        return this.r().l();
    }

    public void m(BaseUnit am2) {
    }

    public boolean al() {
        return false;
    }

    public final boolean a(BaseUnit am2, boolean bl2) {
        if (this.bX == am2.bX || am2.bV || !this.bX.c(am2.bX)) {
            return false;
        }
        if (this.P == com.corrodinggames.rts.game.units.a_f.holdFire) {
            return false;
        }
        if (this.P == com.corrodinggames.rts.game.units.a_f.returnFire) {
            return false;
        }
        if (am2.cN != null) {
            return false;
        }
        if (!this.k(am2)) {
            return false;
        }
        if (!am2.d((BaseUnit) this)) {
            return false;
        }
        if (!bl2) {
            float f2;
            float f3;
            float f4 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, am2.posX, am2.posY);
            return f4 < (f3 = (f2 = this.b(false)) * f2);
        }
        return true;
    }

    public final boolean b(BaseUnit am2, boolean bl2) {
        if (am2.cu()) {
            return false;
        }
        return this.a(am2, bl2);
    }

    public float am() {
        return 0.0f;
    }

    public boolean an() {
        return this.P == com.corrodinggames.rts.game.units.a_f.outOfRange || this.P == com.corrodinggames.rts.game.units.a_f.guardArea
                || this.P == com.corrodinggames.rts.game.units.a_f.aggressive;
    }

    public float b(boolean bl2) {
        float f2 = this.m();
        UnitCommand au2 = this.ar();
        if (au2 != null
                && (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.attackMove || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.patrol
                        || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.guard)) {
            f2 = au2.a == com.corrodinggames.rts.game.units.UnitCommandType.patrol ? (f2 += 110.0f)
                    : (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.guard ? (f2 += 90.0f) : (f2 += 20.0f));
            if (f2 < 190.0f) {
                f2 = 190.0f;
            }
        }
        if (this.P == com.corrodinggames.rts.game.units.a_f.outOfRange) {
            f2 += 250.0f;
        } else if (this.P == com.corrodinggames.rts.game.units.a_f.guardArea) {
            f2 += 150.0f;
        } else if (this.P == com.corrodinggames.rts.game.units.a_f.aggressive) {
            f2 += 180.0f;
        } else {
            f2 += this.am();
            if (bl2) {
                f2 += 110.0f;
            }
        }
        return f2;
    }

    public UnitCommand ao() {
        this.m(29);
        if (this.f > 0) {
            this.b(this.g[0]);
        }
        UnitCommand au2 = this.g[29];
        for (int i2 = 29; i2 >= 1; --i2) {
            this.g[i2] = this.g[i2 - 1];
        }
        this.g[0] = au2;
        if (this.f < 29) {
            ++this.f;
        }
        if (this.g[0] == null) {
            this.g[0] = new UnitCommand();
        }
        UnitCommand au3 = this.g[0];
        au3.e();
        this.V = 0.0f;
        this.Y = 0.0f;
        this.W = 0.0f;
        this.c(au3);
        this.aH();
        return au3;
    }

    public void a(UnitCommand au2) {
    }

    public final void b(UnitCommand au2) {
        this.h = false;
    }

    public void c(UnitCommand au2) {
        this.bC();
        this.i = -9999;
        if (this.R != null && this.R.cu()) {
            this.R = null;
        }
    }

    public UnitCommand ap() {
        this.m(this.f);
        if (this.g[this.f] == null) {
            this.g[this.f] = new UnitCommand();
        }
        UnitCommand au2 = this.g[this.f];
        au2.e();
        if (this.f < 29) {
            ++this.f;
        }
        if (this.f > 0) {
            this.c(this.g[0]);
        }
        return au2;
    }

    public UnitCommand d(float f2, float f3) {
        UnitCommand au2 = this.ap();
        au2.a(f2, f3);
        return au2;
    }

    public UnitCommand n(BaseUnit am2) {
        UnitCommand au2 = this.ap();
        au2.a(am2);
        return au2;
    }

    public UnitCommand e(float f2, float f3) {
        UnitCommand au2 = this.ap();
        au2.b(f2, f3);
        return au2;
    }

    public boolean a(UnitCommand au2, boolean bl2) {
        if (au2 == null) {
            if (bl2) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("isValidNewWaypoint: Skipping null waypoint");
            }
            return false;
        }
        if (au2.d() == com.corrodinggames.rts.game.units.UnitCommandType.build) {
            if (au2.b == null) {
                if (bl2) {
                    com.corrodinggames.rts.gameFramework.GameEngine
                            .b("isValidNewWaypoint: Skipping build waypoint with no buildType");
                }
                return false;
            }
            AbstractUnitAction s2 = this.a(au2.b, au2.d, false);
            if (s2 == null) {
                if (bl2) {
                    com.corrodinggames.rts.gameFramework.GameEngine
                            .b("Unit '" + this.r().i() + "' can not queue build:" + au2.b.i());
                }
                return false;
            }
            if (!au2.n) {
                if (s2.g(this)) {
                    if (bl2) {
                        com.corrodinggames.rts.gameFramework.GameEngine
                                .b("Builder '" + this.r().i() + "' tried to queue a locked building:" + s2.O());
                    }
                    return false;
                }
                if (!s2.b(this)) {
                    if (bl2) {
                        com.corrodinggames.rts.gameFramework.GameEngine
                                .b("Builder '" + this.r().i() + "' tried to queue a unavailable building:" + s2.O());
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public UnitCommand d(UnitCommand au2) {
        UnitCommand au3 = this.ap();
        au3.c(au2);
        return au3;
    }

    public boolean aq() {
        return this.ar() == null;
    }

    public UnitCommand ar() {
        if (this.f == 0) {
            return null;
        }
        return this.g[0];
    }

    public UnitCommand as() {
        if (this.f <= 1) {
            return null;
        }
        return this.g[1];
    }

    public UnitCommand at() {
        if (this.f == 0) {
            return null;
        }
        return this.g[this.f - 1];
    }

    public void au() {
        if (this.f == 0) {
            return;
        }
        if (this.f == 1) {
            this.ay();
        } else {
            --this.f;
        }
    }

    public UnitCommand k(int n2) {
        return this.g[n2];
    }

    public int av() {
        return this.f;
    }

    public boolean aw() {
        UnitCommand au2 = this.ar();
        return au2 != null && au2.a == com.corrodinggames.rts.game.units.UnitCommandType.attack;
    }

    public boolean a(UnitType as2, float f2, float f3) {
        for (int i2 = 0; i2 < this.f; ++i2) {
            UnitCommand au2 = this.g[i2];
            if (au2.a != com.corrodinggames.rts.game.units.UnitCommandType.build || au2.b != as2
                    || !(com.corrodinggames.rts.gameFramework.GameUtils.c(au2.e - f2) < 10.0f)
                    || !(com.corrodinggames.rts.gameFramework.GameUtils.c(au2.f - f3) < 10.0f))
                continue;
            return true;
        }
        return false;
    }

    public void l(int n2) {
        if (n2 >= 120) {
            throw new RuntimeException("PathNode index:" + n2 + " too large");
        }
        if (this.av == at) {
            this.av = new PositionData[120];
        }
    }

    public void m(int n2) {
        if (n2 >= 30) {
            throw new RuntimeException("Waypoint index:" + n2 + " too large");
        }
        if (this.g == O) {
            this.g = new UnitCommand[30];
        }
    }

    public void n(int n2) {
        if (this.f <= n2) {
            throw new IndexOutOfBoundsException("completeWaypoint: waypointsCount:" + this.f + ", waypointIndex:" + n2);
        }
        if (n2 == 0) {
            this.ay();
            return;
        }
        if (this.g.length > 0) {
            UnitCommand au2 = this.g[n2];
            for (int i2 = n2; i2 < this.f - 1; ++i2) {
                this.g[i2] = this.g[i2 + 1];
            }
            this.g[this.f - 1] = au2;
        }
        --this.f;
    }

    public void ax() {
        this.aC();
        this.ay();
    }

    public void ay() {
        this.V = 0.0f;
        this.Y = 0.0f;
        this.W = 0.0f;
        this.ar = false;
        this.aq = -999.0f;
        this.as = false;
        this.w = 0;
        if (this.f == 0) {
            this.aH();
            this.e = 0.0f;
            this.d = 0.0f;
            this.c = 0.0f;
            return;
        }
        if (this.f == 1) {
            this.b(this.g[0]);
            this.f = 0;
            this.aH();
            this.e = 0.0f;
            this.d = 0.0f;
            this.c = 0.0f;
            this.c((UnitCommand) null);
            return;
        }
        if (this.g.length > 0) {
            UnitCommand au2 = this.g[0];
            this.b(au2);
            for (int i2 = 0; i2 < this.f - 1; ++i2) {
                this.g[i2] = this.g[i2 + 1];
            }
            this.g[this.f - 1] = au2;
        }
        --this.f;
        if (this.f > 0) {
            this.c(this.g[0]);
        } else {
            this.c((UnitCommand) null);
        }
        this.aH();
    }

    public void az() {
        int n2 = this.f;
        if (this.f > 0) {
            this.b(this.g[0]);
        }
        this.V = 0.0f;
        this.Y = 0.0f;
        this.ar = false;
        this.aq = -999.0f;
        this.as = false;
        this.f = 0;
        this.aH();
        this.aD();
        this.a((y) null);
        this.e = 0.0f;
        this.d = 0.0f;
        this.c = 0.0f;
        this.w = 0;
        if (n2 > 0) {
            this.c((UnitCommand) null);
        }
    }

    public void aA() {
        for (int i2 = 0; i2 < this.f; ++i2) {
            UnitCommand au2 = this.g[i2];
            if (au2 == null || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.build
                    || au2.a == com.corrodinggames.rts.game.units.UnitCommandType.repair)
                continue;
            this.n(i2);
        }
    }

    public void a(y y2) {
        if (this.ad != null) {
            --this.ad.ag;
        }
        this.ad = y2;
        if (y2 != null) {
            ++this.ad.ag;
        }
    }

    public void aB() {
        this.a((y) null);
        this.ae = false;
        this.aj = false;
        this.ak = 0.0f;
        this.al = 0.0f;
        this.ac = 0;
        this.c = 0.0f;
    }

    public void aC() {
        if (this.ag == 0) {
            return;
        }
        UnitCommand au2 = this.as();
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n2 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            BaseUnit am2 = amArray[i2];
            if (!(am2 instanceof y))
                continue;
            y y2 = (y) am2;
            if (y2.ad != this)
                continue;
            float f2 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, y2.posX, y2.posY);
            boolean bl2 = f2 < 108900.0f;
            boolean bl3 = false;
            boolean bl4 = false;
            UnitCommand au3 = y2.as();
            if (au2 != null && au3 != null) {
                if (au2.b(au3)) {
                    bl3 = true;
                }
            } else if (au2 == null && au3 == null) {
                bl4 = true;
            }
            if (bl3 && bl2) {
                y2.ay();
                continue;
            }
            if (bl4)
                continue;
            y2.a((y) null);
        }
    }

    public void aD() {
        com.corrodinggames.rts.gameFramework.ab ab2;
        UnitCommand au2;
        y y2 = null;
        if (this.ag == 0) {
            return;
        }
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n2 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            BaseUnit am2 = amArray[i2];
            if (!(am2 instanceof y))
                continue;
            y y3 = (y) am2;
            if (y3.ad != this)
                continue;
            y3.a((y) null);
            y2 = y3;
        }
        if (this.ag != 0) {
            this.ag = 0;
        }
        if (y2 != null && (au2 = y2.ar()) != null && (ab2 = au2.i) != null) {
            ab2.c();
        }
    }

    public PositionData aE() {
        if (this.aw == 0) {
            return null;
        }
        if (this.au != null) {
            return this.au.a(this);
        }
        return this.av[0];
    }

    public PositionData aF() {
        if (this.aw < 2) {
            return null;
        }
        if (this.au != null) {
            return this.au.b(this);
        }
        return this.av[1];
    }

    public void a(int n2, float f2, float f3) {
        this.l(n2);
        if (this.av[n2] == null) {
            this.av[n2] = new PositionData();
        }
        this.av[n2].posX = f2;
        this.av[n2].posY = f3;
    }

    public boolean aG() {
        if (this.au != null) {
            return false;
        }
        return this.aw >= 2
                && ((double) this.z() > 0.5 ? this.W > 150.0f || this.X > 150.0f : this.W > 300.0f || this.X > 300.0f);
    }

    public void aH() {
        this.aw = 0;
        this.u = false;
        this.v = 0;
        this.s = 0.0f;
        this.W = 0.0f;
        this.X = 0.0f;
        this.q = 0;
    }

    public void aI() {
        this.aH();
        this.av = at;
        this.aI = 0;
        this.aJ = null;
        this.aK = null;
    }

    public void aJ() {
        this.X = this.W;
        this.W = 0.0f;
        if (this.au != null) {
            this.au.c(this);
            return;
        }
        if (this.aw == 0) {
            return;
        }
        if (this.aw == 1) {
            this.aw = 0;
            return;
        }
        PositionData af2 = this.av[0];
        for (int i2 = 0; i2 < this.aw - 1; ++i2) {
            this.av[i2] = this.av[i2 + 1];
        }
        this.av[this.aw - 1] = af2;
        --this.aw;
    }

    public boolean aK() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        boolean bl2 = false;
        boolean bl3 = false;
        if (this.ct()) {
            bl2 = true;
        }
        l2.bL.a(this.posX, this.posY);
        int n2 = l2.bL.T;
        int n3 = l2.bL.U;
        if (l2.bU.a(this.h(), n2, n3) && !l2.bU.b(this.h(), n2, n3)) {
            bl2 = true;
            bl3 = true;
        }
        return bl2;
    }

    public void a(float f2, float f3, int n2, boolean bl2, boolean bl3) {
        boolean bl4;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        com.corrodinggames.rts.gameFramework.k.l l3 = l2.bU;
        com.corrodinggames.rts.game.b.TileMap b2 = l2.bL;
        this.cK = true;
        boolean bl5 = false;
        boolean bl6 = false;
        if (this.ct()) {
            bl5 = true;
        }
        b2.a(this.posX, this.posY);
        int n3 = b2.T;
        int n4 = b2.U;
        if (l3.a(this.h(), n3, n4) && !l3.b(this.h(), n3, n4)) {
            bl5 = true;
            bl6 = true;
        }
        if (f2 != this.o || this.p != f3) {
            this.q = 0;
        }
        this.o = f2;
        this.p = f3;
        if (bl5) {
            this.u = false;
            this.aw = 0;
            this.au = null;
            float f4 = b2.a(f2);
            float f5 = b2.b(f3);
            if (bl6) {
                float f6 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, f4, f5);
                float f7 = com.corrodinggames.rts.gameFramework.GameUtils.b(this.posX, this.posY, f4, f5);
                if (f7 > 60.0f) {
                    f7 = 60.0f;
                    this.u = true;
                    if (this.s > 10.0f) {
                        this.s = 10.0f;
                    }
                }
                f4 = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(f6) * f7;
                f5 = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(f6) * f7;
            }
            this.a(this.aw, f4, f5);
            ++this.aw;
            this.v = this.aw;
            return;
        }
        int n5 = 1;
        int n6 = 80;
        int n7 = 0;
        if (bl2) {
            n7 = 3;
        }
        if (bl4 = com.corrodinggames.rts.game.units.PathfindingUtils.a(this.h(), this.posX, this.posY, f2, f3, n6, n7, n5)) {
            this.u = false;
            this.aw = 0;
            this.au = null;
            float f8 = b2.a(f2);
            float f9 = b2.b(f3);
            float f10 = this.posX;
            float f11 = this.posY;
            float f12 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, f8, f9);
            float f13 = com.corrodinggames.rts.gameFramework.GameUtils.b(this.posX, this.posY, f8, f9);
            float f14 = com.corrodinggames.rts.gameFramework.GameUtils.k(f12);
            float f15 = com.corrodinggames.rts.gameFramework.GameUtils.j(f12);
            float f16 = 20.0f;
            float f17 = 0.05f;
            int n8 = (int) (f13 * 0.05f - 1.0f);
            int n9 = 1;
            if (n8 < 4) {
                n9 = 0;
            }
            for (int i2 = 0; i2 < n8; ++i2) {
                f10 += f14 * 20.0f;
                f11 += f15 * 20.0f;
                if (n9 > 0) {
                    --n9;
                    continue;
                }
                this.a(this.aw, f10, f11);
                ++this.aw;
                if (this.aw < 119)
                    continue;
                this.u = true;
                break;
            }
            if (!this.u) {
                if (this.aw < 119) {
                    this.a(this.aw, f8, f9);
                    ++this.aw;
                } else {
                    this.u = true;
                }
            }
            this.v = this.aw;
            return;
        }
        com.corrodinggames.rts.gameFramework.ab ab2 = null;
        boolean bl7 = false;
        UnitCommand au2 = this.ar();
        if (au2 == null || (ab2 = au2.i) == null) {
            // empty if block
        }
        if (ab2 != null && ab2.g != null) {
            com.corrodinggames.rts.gameFramework.MoveOrder d2 = null;
            float f18 = 3600.0f;
            for (com.corrodinggames.rts.gameFramework.MoveOrder d3 : ((List<com.corrodinggames.rts.gameFramework.MoveOrder>) ab2.g)) {
                float f19;
                bl7 = true;
                if (d3.a == null || d3.a.a() == null
                        || com.corrodinggames.rts.gameFramework.GameUtils.c(d3.e - f2) > 10.0f
                        || com.corrodinggames.rts.gameFramework.GameUtils.c(d3.f - f3) > 10.0f || d3.g + 180 < l2.bx
                        || d3.h != this.h() || !((f19 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX,
                                this.posY, d3.c, d3.d)) < f18))
                    continue;
                f19 = f18;
                d2 = d3;
            }
            if (d2 != null) {
                this.aU = d2.a;
                return;
            }
        }
        if (L && n2 > 2) {
            n2 = 2;
        }
        boolean bl8 = true;
        this.aU = this.a(f2, f3, n2, bl2, bl8, bl3);
    }

    public com.corrodinggames.rts.gameFramework.k.k a(float f2, float f3, int n2, boolean bl2, boolean bl3,
            boolean bl4) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        com.corrodinggames.rts.gameFramework.k.l l3 = l2.bU;
        com.corrodinggames.rts.game.b.TileMap b2 = l2.bL;
        com.corrodinggames.rts.gameFramework.k.k k2 = l3.a(bl3);
        b2.a(this.posX, this.posY);
        boolean bl5 = false;
        if (this.bb() || this.ci) {
            bl5 = true;
        }
        k2.a(this.h(), (short) b2.T, (short) b2.U, Float.valueOf(this.cg), bl5);
        b2.a(f2, f3);
        k2.a((short) b2.T, (short) b2.U, (short) n2);
        k2.p = bl2;
        k2.q = this.bh();
        k2.r = bl4;
        boolean bl6 = this.cK;
        this.cK = true;
        if (bl3 && k2.b()) {
            Iterator iterator = aV.iterator();
            while (iterator.hasNext()) {
                com.corrodinggames.rts.gameFramework.k.k k3 = (com.corrodinggames.rts.gameFramework.k.k) iterator
                        .next();
                if (k3.g + 60 < l2.bx) {
                    iterator.remove();
                    continue;
                }
                if (!k3.a(k2))
                    continue;
                return k3;
            }
        }
        l3.a(k2, bl3);
        this.cK = bl6;
        if (bl3 && k2.b()) {
            aV.add(k2);
        }
        return k2;
    }

    void b(com.corrodinggames.rts.gameFramework.GameEngine l2) {
        if (this.aU != null) {
            com.corrodinggames.rts.game.b.TileMap b2 = l2.bL;
            LinkedList<p> linkedList = this.aU.a();
            if (linkedList != null) {
                this.au = this.aU.a(this);
                com.corrodinggames.rts.gameFramework.k.k k2 = this.aU;
                this.aw = 0;
                this.u = false;
                for (p p2 : linkedList) {
                    b2.a(p2.a, p2.b);
                    float f2 = b2.T + b2.p;
                    float f3 = b2.U + b2.q;
                    this.a(this.aw, f2, f3);
                    ++this.aw;
                    if (this.aw < 120)
                        continue;
                    this.u = true;
                    break;
                }
                if (this.aw == 1) {
                    this.q = (byte) (this.q + 1);
                }
                boolean bl2 = true;
                boolean bl3 = false;
                if (linkedList.size() != 0) {
                    b2.a(this.o, this.p);
                    if (!this.u && ((p) linkedList.getLast()).a == b2.T && ((p) linkedList.getLast()).b == b2.U) {
                        bl3 = true;
                    }
                }
                if (bl3) {
                    if (!bl2) {
                        if (this.aw < 120) {
                            this.a(this.aw, this.o, this.p);
                            ++this.aw;
                        }
                    } else {
                        if (this.aw == 0) {
                            ++this.aw;
                        }
                        this.a(this.aw - 1, this.o, this.p);
                    }
                }
                this.aU = null;
                if (this.aw > 120) {
                    com.corrodinggames.rts.gameFramework.GameEngine
                            .b("activePathCount>maxPathNodes: activePathCount:" + this.aw);
                    this.aw = 120;
                }
                this.v = this.aw;
            }
        }
    }

    public long aL() {
        long l2 = 0L;
        for (int i2 = 0; i2 < this.aw; ++i2) {
            PositionData af2 = this.av[i2];
            if (af2 == null)
                continue;
            l2 += (long) Float.floatToRawIntBits(af2.posX);
            l2 += (long) Float.floatToRawIntBits(af2.posY);
        }
        return l2;
    }

    PositionData o(int n2) {
        if (this.au != null) {
            if (n2 == 0) {
                return this.aE();
            }
            return this.aF();
        }
        if (n2 >= this.aw) {
            return null;
        }
        return this.av[n2];
    }

    @Override
    public void d(float f2) {
        super.d(f2);
    }

    public float aM() {
        return 1.0f;
    }

    public int l(float f2) {
        if (f2 < -0.3f) {
            int n2 = (int) ((1.0f - -f2 / 10.0f) * 130.0f + 45.0f);
            if (n2 < 45) {
                n2 = 45;
            }
            return n2;
        }
        return 255;
    }

    public Paint aN() {
        PorterDuffColorFilter porterDuffColorFilter = null;
        int n2 = -1;
        if (this.posZ < -0.3f) {
            int bl2 = this.l(this.posZ);
            n2 = Color.a(bl2, 255, 255, 255);
        } else {
            n2 = -1;
        }
        if (this.cm < 1.0f && this.cm < this.aM()) {
            float f2 = this.cm / this.aM() * 220.0f;
            n2 = Color.a((int) (20.0f + f2), 140, 255, 140);
            porterDuffColorFilter = aX;
        }
        if (this.cp) {
            if (this.cs) {
                n2 = Color.a(200, 20, 255, 20);
                porterDuffColorFilter = aY;
            }
            if (this.ct) {
                n2 = Color.a(200, 255, 20, 20);
                porterDuffColorFilter = aZ;
            }
            if (this.cq) {
                n2 = Color.a(50, 70, 70, 245);
                porterDuffColorFilter = ba;
                if (this.ct) {
                    n2 = Color.a(50, 255, 20, 20);
                    porterDuffColorFilter = aZ;
                }
            }
            if (this.cr) {
                n2 = Color.a(150, 100, 100, 100);
            }
        }
        boolean bl2 = this.aO();
        return this.a(n2, porterDuffColorFilter, bl2);
    }

    public boolean aO() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        boolean bl2 = l2.bQ.renderAntiAlias;
        if (!this.dk()) {
            bl2 = false;
            float f2 = l2.cX;
            if (f2 < 1.0f) {
                bl2 = true;
            }
        }
        if (this.co) {
            bl2 = com.corrodinggames.rts.game.units.UnitTypeEnum.ag;
        }
        return bl2;
    }

    public float p(int n2) {
        return 1.0f;
    }

    @Override
    public boolean c(float f2) throws IOException {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        com.corrodinggames.rts.gameFramework.m.y y2 = l2.bO;
        Paint paint = this.aN();
        float f3 = this.cD();
        if (this.ew) {
            PointF pointF = this.cY();
            float f4 = this.posX + pointF.x - l2.cw;
            float f5 = this.posY + pointF.b - l2.cx - this.posZ;
            this.aQ();
            if (f3 != 1.0f) {
                y2.k();
                y2.a(f3, f3, f4, f5);
            }
            y2.a(this.M, f4, f5, this.d(false) - 90.0f, paint);
            if (f3 != 1.0f) {
                y2.l();
            }
        } else {
            PointF pointF = this.cY();
            RectF rectF = this.cF();
            float f6 = pointF.x;
            float f7 = pointF.b - this.posZ;
            rectF.left += f6;
            rectF.b += f7;
            rectF.c += f6;
            rectF.d += f7;
            Rect rect = this.a_(false);
            float f8 = (rectF.left + rectF.c) * 0.5f;
            float f9 = (rectF.b + rectF.d) * 0.5f;
            y2.k();
            this.aQ();
            if (f3 != 1.0f) {
                y2.a(f3, f3, f8, f9);
            }
            y2.a(this.d(false), f8, f9);
            y2.a(this.M, rect, rectF, paint);
            y2.l();
        }
        return true;
    }

    public boolean F() {
        return this.posZ > 0.0f && this.cm >= 1.0f && !this.cq;
    }

    public PointF aP() {
        be.a(this.G(), this.H());
        return be;
    }

    public float G() {
        return 0.0f;
    }

    public float H() {
        return 0.0f;
    }

    public boolean aQ() throws IOException {
        if (this.N != null && this.F()) {
            com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
            if (!l2.mouseWorldX && this.cj < 18.0f && (double) this.posZ < 0.5) {
                return true;
            }
            if (!l2.mouseWorldY && this.cj < 28.0f && this.posZ < 5.0f) {
                return true;
            }
            PointF pointF = this.aP();
            float f2 = this.posX + pointF.x - l2.cw;
            float f3 = this.posY + pointF.b - l2.cx;
            float f4 = this.cD();
            com.corrodinggames.rts.gameFramework.m.y y2 = l2.bO;
            if (f4 != 1.0f) {
                y2.k();
                y2.a(f4, f4, f2, f3);
            }
            if (this.cG()) {
                Rect rect = this.a_(true);
                RectF rectF = dB;
                rectF.a(f2 - this.eu, f3 - this.ev, f2 + this.eu, f3 + this.ev);
                y2.k();
                y2.a(this.d(true), f2, f3);
                y2.a(this.N, rect, rectF, this.R());
                y2.l();
            } else {
                y2.a(this.N, f2, f3, this.d(true) - 90.0f, this.R());
            }
            if (f4 != 1.0f) {
                y2.l();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean s_() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        return RectF.a(l2.cM, this.cE());
    }

    public abstract boolean I();

    public boolean aR() {
        com.corrodinggames.rts.game.units.custom.b.n n2 = this.dn();
        if (n2 != null && !n2.O) {
            return false;
        }
        return this.I();
    }

    public boolean aS() {
        return this.aR();
    }

    public boolean b_() {
        return true;
    }

    public int aT() {
        return -1;
    }

    public float o(BaseUnit am2) {
        if (this.aV() && am2 != null) {
            return this.m() + this.cj + am2.cj;
        }
        return this.m();
    }

    public float p(BaseUnit am2) {
        if (this.aV() && am2 != null) {
            return this.aU() + this.cj + am2.cj;
        }
        return this.aU();
    }

    public float aU() {
        return this.m();
    }

    public int q(BaseUnit am2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        int n2 = 0;
        float f2 = this.p(am2);
        if (f2 > 58.0f) {
            n2 = (int) ((f2 - 41.0f) / ((float) l2.bL.n * 1.414f));
        }
        return n2;
    }

    public abstract float m();

    public boolean aV() {
        return false;
    }

    public abstract float b(int var1);

    public float q(int n2) {
        return 0.0f;
    }

    public void aW() {
        int n2 = this.bl();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 >= this.cL.length)
                continue;
            UnitMovementData ap2 = this.cL[i2];
            if (!(ap2.rotation > this.b(i2)))
                continue;
            ap2.rotation = this.b(i2);
        }
    }

    public ArrayList aX() {
        ArrayList<UnitStatistics> arrayList = new ArrayList<UnitStatistics>();
        if (this.l()) {
            int n2 = this.bl();
            for (int i2 = 0; i2 < n2; ++i2) {
                float f2 = this.q(i2);
                if (f2 == 0.0f)
                    continue;
                float f3 = this.b(i2);
                if (f3 == 9000.0f) {
                    f3 = 0.0f;
                }
                boolean bl2 = false;
                for (UnitStatistics aa2 : arrayList) {
                    if (aa2.a != f2 || aa2.b != f3 && f3 != 0.0f && aa2.b != 0.0f)
                        continue;
                    ++aa2.d;
                    if (aa2.b == 0.0f) {
                        aa2.b = f3;
                    }
                    bl2 = true;
                    break;
                }
                if (bl2)
                    continue;
                UnitStatistics aa3 = new UnitStatistics();
                aa3.a = f2;
                aa3.b = f3;
                aa3.c = this.e(i2);
                arrayList.add(aa3);
            }
        }
        return arrayList;
    }

    public boolean r(int n2) {
        return true;
    }

    public float e(int n2) {
        return 0.0f;
    }

    public boolean s(int n2) {
        return false;
    }

    public float t(int n2) {
        return 0.0f;
    }

    public float f(int n2) {
        return 4.0f;
    }

    public boolean u(int n2) {
        int n3 = this.v(n2);
        if (n3 == -1) {
            return this.cL[n2].isActive;
        }
        return this.cL[n3].isActive;
    }

    public int v(int n2) {
        return -1;
    }

    public abstract float A();

    public float B() {
        return -1.0f;
    }

    public abstract float c(int var1);

    public float w(int n2) {
        return -1.0f;
    }

    public float x(int n2) {
        return 5.0f;
    }

    public float y(int n2) {
        return this.w(n2);
    }

    public boolean E() {
        return false;
    }

    public boolean aY() {
        return false;
    }

    public abstract float z();

    public float aZ() {
        return 1.0f;
    }

    public float ba() {
        return 1.0f;
    }

    public boolean bb() {
        return this.bc() > 0.95f;
    }

    public float bc() {
        return 0.6f;
    }

    @Override
    public float bd() {
        return 0.0f;
    }

    public UnitBehaviorType be() {
        return com.corrodinggames.rts.game.units.UnitBehaviorType.normal;
    }

    public boolean bf() {
        return true;
    }

    public boolean bg() {
        return true;
    }

    public int bh() {
        return 0;
    }

    public float C() {
        return 99.0f;
    }

    public float D() {
        return 99.0f;
    }

    public boolean bi() {
        return false;
    }

    public boolean bj() {
        return false;
    }

    public boolean b(int n2, float f2) {
        return true;
    }

    public abstract void a(BaseUnit var1, int var2);

    public boolean bk() {
        return false;
    }

    @Override
    public int bl() {
        return 1;
    }

    public boolean bm() {
        return true;
    }

    public float g(int n2) {
        return 0.0f;
    }

    public float z(int n2) {
        return 99999.0f;
    }

    public float A(int n2) {
        return -1.0f;
    }

    public float B(int n2) {
        return 0.0f;
    }

    public float C(int n2) {
        if (this.ci && this.bb()) {
            return this.cg + 180.0f;
        }
        return this.cg;
    }

    public Vector3D bn() {
        int n2 = this.aT();
        if (n2 == -1) {
            return this.D(0);
        }
        return this.D(n2);
    }

    public Vector3D D(int n2) {
        bf.a(this.E(n2));
        return bf;
    }

    public PointF E(int n2) {
        UnitMovementData ap2 = this.cL[n2];
        float f2 = this.g(n2);
        float f3 = this.E() ? this.cg : ap2.targetX;
        PointF pointF = this.G(n2);
        float f4 = pointF.x + com.corrodinggames.rts.gameFramework.GameUtils.k(f3) * f2;
        float f5 = pointF.b + com.corrodinggames.rts.gameFramework.GameUtils.j(f3) * f2;
        bg.a(f4, f5);
        return bg;
    }

    public Vector3D F(int n2) {
        bi.a(this.G(n2));
        com.corrodinggames.rts.game.units.y.bi.c = 0.0f;
        return bi;
    }

    public PointF G(int n2) {
        UnitMovementData ap2 = this.cL[n2];
        float f2 = this.posX;
        float f3 = this.posY;
        float f4 = this.H(n2);
        if (ap2.rotation != 0.0f && f4 != 0.0f) {
            float f5 = this.I(n2);
            float f6 = this.J(n2);
            float f7 = 0.0f;
            float f8 = this.b(n2) - ap2.rotation;
            if (f8 < f5) {
                f7 = f8 / f5 * f4;
            } else if (f8 < f6 + f5) {
                f7 = f4 - (f8 - f5) / f6 * f4;
            }
            if (f7 != 0.0f) {
                f2 += com.corrodinggames.rts.gameFramework.GameUtils.k(ap2.targetX) * f7;
                f3 += com.corrodinggames.rts.gameFramework.GameUtils.j(ap2.targetX) * f7;
            }
        }
        bh.a(f2, f3);
        return bh;
    }

    public float H(int n2) {
        return 0.0f;
    }

    public float I(int n2) {
        return 4.0f;
    }

    public float J(int n2) {
        return 6.0f;
    }

    public PointF K(int n2) {
        PointF pointF = bj;
        pointF.a(0.0f, 0.0f);
        UnitMovementData ap2 = this.cL[n2];
        pointF.x += ap2.h;
        pointF.b += ap2.i;
        return pointF;
    }

    public float L(int n2) {
        return 0.6f;
    }

    public void M(int n2) {
        if (n2 == -1) {
            int n3 = this.bl();
            for (int i2 = 0; i2 < n3; ++i2) {
                this.M(i2);
            }
            return;
        }
        UnitMovementData ap2 = this.cL[n2];
        ap2.h = 0.0f;
        ap2.i = 0.0f;
        if (this.R != null && this.L(n2) != 0.0f) {
            float f2 = this.R.cj * this.L(n2);
            ap2.h += (float) com.corrodinggames.rts.gameFramework.GameUtils
                    .a((com.corrodinggames.rts.gameFramework.GGameObject) this, (int) (-f2), (int) f2, 1 + n2);
            ap2.i += (float) com.corrodinggames.rts.gameFramework.GameUtils
                    .a((com.corrodinggames.rts.gameFramework.GGameObject) this, (int) (-f2), (int) f2, 2 + n2);
        }
    }

    public void a(UnitSize ab2) {
        this.a(ab2, true);
    }

    public void a(UnitSize ab2, boolean bl2) {
        com.corrodinggames.rts.gameFramework.effect.e e2;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (ab2 == com.corrodinggames.rts.game.units.UnitSize.verylargeBuilding) {
            l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.p, 0.8f, this.posX, this.posY);
            l2.bR.a(this.posX, this.posY, this.posZ);
            l2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
            e2 = l2.bR.c(this.posX, this.posY, this.posZ, -1127220);
            if (e2 != null) {
                e2.G = 0.2f;
                e2.F = 2.0f;
                e2.ar = (short) 2;
                e2.W = e2.V = 45.0f;
                e2.U = 0.0f;
            }
        } else if (ab2 == com.corrodinggames.rts.game.units.UnitSize.large || ab2 == com.corrodinggames.rts.game.units.UnitSize.building
                || ab2 == com.corrodinggames.rts.game.units.UnitSize.buildingNoShockwaveOrSmoke) {
            l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.p, 0.8f, this.posX, this.posY);
            l2.bR.a(this.posX, this.posY, this.posZ);
        } else if (ab2 == com.corrodinggames.rts.game.units.UnitSize.verysmall) {
            float f2 = 1.0f + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.07f, 0.07f);
            l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.o, 0.4f, f2, this.posX, this.posY);
            l2.bR.b(this.posX, this.posY, this.posZ);
        } else if (ab2 == com.corrodinggames.rts.game.units.UnitSize.largeUnit) {
            float f3 = 1.0f + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.07f, 0.07f);
            l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.o, 0.8f, f3, this.posX, this.posY);
            l2.bR.b(this.posX, this.posY, this.posZ);
            l2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
            com.corrodinggames.rts.gameFramework.effect.e e3 = l2.bR.c(this.posX, this.posY, this.posZ, -1127220);
            if (e3 != null) {
                e3.G = 0.2f;
                e3.F = 2.0f;
                e3.ar = (short) 2;
                e3.W = e3.V = 45.0f;
                e3.U = 0.0f;
            }
        } else {
            float f4 = 1.0f + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.07f, 0.07f);
            l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.o, 0.8f, f4, this.posX, this.posY);
            l2.bR.b(this.posX, this.posY, this.posZ);
        }
        if (ab2 != com.corrodinggames.rts.game.units.UnitSize.verysmall) {
            if (ab2 != com.corrodinggames.rts.game.units.UnitSize.buildingNoShockwaveOrSmoke && (e2 = l2.bR.d(this.posX, this.posY, this.posZ, 0)) != null) {
                e2.E = 0.9f;
            }
            if (bl2) {
                if (!this.bO()) {
                    this.bo();
                }
                if (ab2 != com.corrodinggames.rts.game.units.UnitSize.buildingNoShockwaveOrSmoke && !this.cK()) {
                    com.corrodinggames.rts.gameFramework.effect.f.a(this.posX, this.posY);
                    com.corrodinggames.rts.gameFramework.effect.f.b(this.posX, this.posY);
                    this.bq();
                }
            }
        }
    }

    public void bo() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        float f2 = 1.0f;
        float f3 = 1.0f;
        int n2 = this.bp();
        if (n2 >= 10) {
            f2 = 1.2f;
            f3 = 1.4f;
        }
        if (n2 >= 20) {
            f2 = 1.5f;
            f3 = 1.7f;
        }
        if (this.posZ > -1.0f) {
            for (int i2 = 0; i2 < n2; ++i2) {
                l2.bR.b(this.posX, this.posY, this.posZ, f2, f3);
            }
        }
    }

    public int bp() {
        if (this.dd()) {
            return 8;
        }
        if (this.bI()) {
            return 7;
        }
        return 4;
    }

    public void bq() {
        if (!this.cK()) {
            com.corrodinggames.rts.game.l.a(this.posX, this.posY);
        }
    }

    public int s() {
        return 15;
    }

    @Override
    public void c(boolean bl2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (this.cN != null || this.cO != null) {
            return;
        }
        int n2 = this.s();
        if (n2 > 0) {
            l2.bL.a(this.posX, this.posY, n2, this.bX, bl2);
        }
    }

    public void br() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        RectF rectF = new RectF();
        rectF.a(this.cd());
        rectF.b *= (float) l2.bL.o;
        rectF.d *= (float) l2.bL.o;
        rectF.left *= (float) l2.bL.n;
        rectF.c *= (float) l2.bL.n;
        rectF.a(this.posX, this.posY);
        rectF.a(-this.cZ(), -this.da());
        float f2 = 10.0f;
        rectF.b -= f2;
        rectF.d += f2;
        rectF.left -= f2;
        rectF.c += f2;
        o o2 = com.corrodinggames.rts.game.units.BaseUnit.bF();
        for (BaseUnit am2 : ((Iterable<BaseUnit>) o2)) {
            BaseUnit am3;
            if (!(am2 instanceof BaseUnit) || (am3 = am2) == this || !am3.a(rectF))
                continue;
            if (am3 instanceof y && am3.bV) {
                am3.a();
            }
            if (!(am3 instanceof Tree))
                continue;
            ((Tree) am3).k();
        }
    }

    public boolean c(PlayerTeam n2) {
        return this.b(false, n2) == null;
    }

    public boolean a(boolean bl2, PlayerTeam n2) {
        return this.b(bl2, n2) == null;
    }

    public String b(boolean var1, PlayerTeam var2) {
        GameEngine var3 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        be var4 = this.r().q();
        if (var4 != null) {
            String var5 = var4.a(this, this.posX, this.posY);
            if (var5 != null) {
                return var5;
            }
        }

        if (this.r().p()) {
            var3.bL.a(this.posX, this.posY);
            MapTile var14 = var3.bL.e(var3.bL.T, var3.bL.U);
            if (var14 == null || !var14.i) {
                return "{2}";
            }
        }

        if (!var1 && this.a((BaseUnit) null, (PlayerTeam) var2)) {
            return "{0}";
        } else {
            if (!this.r().p()) {
                Rect var15 = this.cd();
                Point var6 = this.a((TileMap) var3.bL, (Point) bk);
                int var7 = var6.x;
                int var8 = var6.b;
                com.corrodinggames.rts.game.units.UnitType var9 = this.r();
                UnitMovementType var10 = var9.o();

                for (int var11 = var7 + var15.left; var11 <= var7 + var15.c; ++var11) {
                    for (int var12 = var8 + var15.top; var12 <= var8 + var15.d; ++var12) {
                        String var13 = com.corrodinggames.rts.game.units.d.d.a(this, var9, var10, var11, var12, false,
                                var2);
                        if (var13 != null) {
                            return var13;
                        }
                    }
                }
            }

            return null;
        }
    }

    public void N(int n2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (!this.r().p()) {
            Rect rect = this.cd();
            Point point = this.a(l2.bL, bl);
            int n3 = point.x;
            int n4 = point.b;
            UnitType as2 = this.r();
            int n5 = n3 + rect.left;
            int n6 = n4 + rect.top;
            int n7 = n3 + rect.c;
            int n8 = n4 + rect.d;
            if (n2 != -2) {
                try {
                    l2.bL.a(this, n5, n6, n7, n8, (int) l2.cw, (int) l2.cx, l2.bO, true, n2);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean r(BaseUnit am2) {
        float f2 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, am2.posX, am2.posY);
        float f3 = 9.0f;
        if (!am2.bI() && (f3 = this.cj + am2.cj) < 11.0f) {
            f3 = 11.0f;
        }
        return f2 < f3 * f3;
    }

    public boolean a(BaseUnit am2, PlayerTeam n2) {
        boolean bl2 = false;
        if (!this.bI()) {
            bl2 = true;
        }
        float f2 = this.cj + com.corrodinggames.rts.game.units.custom.ag.p + 10.0f;
        float f3 = this.posX - f2;
        float f4 = this.posX + f2;
        float f5 = this.posY - f2;
        float f6 = this.posY + f2;
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n3 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            BaseUnit am3 = amArray[i2];
            float f7 = am3.posX;
            float f8 = am3.posY;
            if (!(f3 <= f7) || !(f7 <= f4) || !(f5 <= f8) || !(f8 <= f6) || am3 == this || !bl2 && !am3.bI() || am3.bV
                    || !this.r(am3) || am3 == am2 || n2 != null && !am3.d(n2))
                continue;
            return true;
        }
        return false;
    }

    public y bs() {
        for (BaseUnit am2 : ((List<BaseUnit>) com.corrodinggames.rts.game.units.BaseUnit.bE)) {
            if (am2 == this || !(am2 instanceof y))
                continue;
            y y2 = (y) am2;
            if (y2.bV || y2.bX != this.bX || y2.r() != this.r() || !this.t(y2))
                continue;
            return y2;
        }
        return null;
    }

    @Override
    public void a() {
        if (this.cO != null) {
            this.bx();
        }
        this.az();
        this.aI();
        super.a();
    }

    @Override
    public void bt() {
        this.a((y) null);
        this.R = null;
        this.az();
        this.aI();
    }

    @Override
    public void bu() {
        if (this.cO != null) {
            this.bx();
        }
        super.bu();
    }

    @Override
    public void bv() {
        super.bv();
    }

    @Override
    public int bw() {
        int n2 = 0;
        n2 = n2 * 31 + super.bw();
        n2 = n2 * 31 + (int) (this.z() * 100.0f);
        n2 = n2 * 31 + (int) (this.A() * 100.0f);
        n2 = n2 * 31 + (int) (this.m() * 100.0f);
        n2 = n2 * 31 + (int) this.b(0);
        n2 = n2 * 31 + (int) (this.C() * 100.0f);
        return n2;
    }

    @Override
    PointF m(float f2) {
        PointF pointF = this.n(f2);
        dE.a(this.posX + pointF.x, this.posY + pointF.b);
        return dE;
    }

    public PointF n(float f2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        if (this.I() && this.b == 0.0f) {
            if (this.bi()) {
                f3 = this.cc * f2;
                f4 = this.cd * f2;
            } else if (this.cf != 0.0f) {
                float f5 = this.cg;
                if (this.bj()) {
                    f5 = this.ch;
                }
                float f6 = this.z() * this.cf * f2;
                f3 = com.corrodinggames.rts.gameFramework.GameUtils.k(f5) * f6;
                f4 = com.corrodinggames.rts.gameFramework.GameUtils.j(f5) * f6;
            }
        }
        bm.a(f3, f4);
        return bm;
    }

    public boolean a(CommandType ag2) {
        return false;
    }

    public void a(AbstractUnitAction s2, boolean bl2, float f2, float f3) {
    }

    public boolean a(AbstractUnitAction s2, float f2, float f3) {
        return true;
    }

    public void a(BaseUnit am2, float f2, int n2) {
        this.U = com.corrodinggames.rts.gameFramework.GameUtils.a(this.U, f2);
        if (this.U == 0.0f) {
            this.U = 5.0f;
            if (this.s_()) {
                Vector3D ai2 = this.bn();
                com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine
                        .getInstance();
                com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.b(ai2.a, ai2.b, this.posZ + ai2.c,
                        com.corrodinggames.rts.gameFramework.effect.d.custom, false,
                        com.corrodinggames.rts.gameFramework.effect.h.low);
                if (e2 != null) {
                    float f3 = (float) ((double) am2.posX + (-8.0 + Math.random() * 16.0));
                    float f4 = (float) ((double) am2.posY + (-8.0 + Math.random() * 16.0));
                    float f5 = com.corrodinggames.rts.gameFramework.GameUtils.d(ai2.a, ai2.b, f3, f4);
                    e2.P = com.corrodinggames.rts.gameFramework.GameUtils.k(f5)
                            * com.corrodinggames.rts.gameFramework.GameUtils.c(2.0f, 4.0f);
                    e2.Q = com.corrodinggames.rts.gameFramework.GameUtils.j(f5)
                            * com.corrodinggames.rts.gameFramework.GameUtils.c(2.0f, 4.0f);
                    e2.ap = 6;
                    e2.W = e2.V = 20.0f;
                    e2.r = true;
                    e2.E = 0.8f;
                    e2.G = 0.2f;
                    e2.F = 1.0f;
                }
            }
        }
    }

    public void b(BaseUnit am2, float f2, int n2) {
        this.U = com.corrodinggames.rts.gameFramework.GameUtils.a(this.U, f2);
        if (this.U == 0.0f) {
            this.U = 5.0f;
            if (this.s_()) {
                PointF pointF = this.E(0);
                com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine
                        .getInstance();
                com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.b(am2.posX, am2.posY, am2.posZ,
                        com.corrodinggames.rts.gameFramework.effect.d.custom, false,
                        com.corrodinggames.rts.gameFramework.effect.h.low);
                if (e2 != null) {
                    float f3 = (float) ((double) pointF.x + (-8.0 + Math.random() * 16.0));
                    float f4 = (float) ((double) pointF.b + (-8.0 + Math.random() * 16.0));
                    float f5 = com.corrodinggames.rts.gameFramework.GameUtils.d(am2.posX, am2.posY - am2.posZ, f3, f4);
                    e2.P = com.corrodinggames.rts.gameFramework.GameUtils.k(f5)
                            * com.corrodinggames.rts.gameFramework.GameUtils.c(2.0f, 4.0f);
                    e2.Q = com.corrodinggames.rts.gameFramework.GameUtils.j(f5)
                            * com.corrodinggames.rts.gameFramework.GameUtils.c(2.0f, 4.0f);
                    e2.ap = 5;
                    e2.W = e2.V = 20.0f;
                    e2.r = true;
                    e2.E = 0.8f;
                    e2.G = 0.2f;
                    e2.F = 1.0f;
                }
            }
        }
    }

    public z a(UnitCommand au2, UnitType as2, int n2, float f2, float f3) {
        Object object;
        Object object2;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        AbstractUnitAction s2 = this.a(as2, n2, false);
        if (s2 == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("Unit '" + this.r().i() + "' can not build:" + as2.i());
            return bn.a();
        }
        if (!au2.n) {
            if (s2.g(this)) {
                com.corrodinggames.rts.gameFramework.GameEngine
                        .b("Builder '" + this.r().i() + "' tried to build a locked building:" + s2.O());
                return bn.a();
            }
            if (!s2.b(this) && !s2.u(this)) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("Builder '" + this.r().i()
                        + "' tried to build a unavailable building:" + s2.O() + " (add isLocked:false to fix)");
                return bn.a();
            }
        }
        if (!as2.k() && !s2.x() && this.bX.w() >= this.bX.x()) {
            if (this.bX == l2.bs) {
                l2.bS.b(l2.bS.g.al);
            }
            return bn.a();
        }
        BaseUnit am2 = com.corrodinggames.rts.game.units.BaseUnit.a(as2);
        if (am2 == null) {
            String string2 = "{build is null}";
            if (au2.b != null) {
                string2 = au2.b.i();
            }
            com.corrodinggames.rts.gameFramework.GameEngine.log("Build unit type missing: " + string2);
            return bn.a();
        }
        BaseUnit am3 = com.corrodinggames.rts.game.units.d.d.g(as2);
        if (!com.corrodinggames.rts.game.units.custom.d.b.b(as2.u(), s2.B())
                || !com.corrodinggames.rts.game.units.custom.d.b.b(as2.B(), s2.r_())) {
            am3.bx = s2.B();
            am3.by = s2.r_();
        }
        if (s2 instanceof FilteredUnitAction) {
            am3.bx = null;
            am3.by = null;
        }
        am3.cm = 0.0f;
        am3.cn = 0.0f;
        l2.bL.b(f2 - am3.cZ() + 1.0f, f3 - am3.da() + 1.0f);
        am3.posX = (float) l2.bL.T + am3.cZ();
        am3.posY = (float) l2.bL.U + am3.da();
        am3.f(this.bX);
        am3.B(this);
        if (n2 != 1 && am3 instanceof y) {
            ((y) am3).a(n2);
        }
        am3.cP();
        if (am3 instanceof y) {
            object2 = (y) am3;
            boolean bl2 = false;
            object = null;
            if (this.al()) {
                object = this;
            } else if (!this.bT && !this.bI()) {
                object = this;
            }
            if (((y) object2).a((BaseUnit) object, null)) {
                bl2 = true;
            }
            if (!bl2 && !((y) object2).a(true, null)) {
                bl2 = true;
            }
            if (bl2) {
                am3.a();
                z z2 = bn.a();
                y y2 = ((y) am3).bs();
                z2.b = y2;
                z2.d = s2;
                if (y2 == null) {
                    // empty if block
                }
                return z2;
            }
        }
        object2 = s2.B();
        if (au2.n) {
            object2 = com.corrodinggames.rts.game.units.custom.d.b.a;
        }
        if (!((com.corrodinggames.rts.game.units.custom.d.a) object2).c(this)) {
            am3.a();
            z z3 = bn.a();
            this.Q = l2.by;
            if (this.V < 1000.0f) {
                z3.c = true;
                object = com.corrodinggames.rts.gameFramework.effect.a.a(this.bX, am3.posX, am3.posY);
                if (object != null) {
                    ((com.corrodinggames.rts.gameFramework.effect.a) object).i = true;
                }
            }
            return z3;
        }
        this.m(am3);
        if (am3 instanceof y) {
            y y3 = (y) am3;
            y3.br();
            if (am3.bI()) {
                l2.bU.a(y3);
            }
        }
        com.corrodinggames.rts.game.PlayerTeam.c(am3);
        z z4 = bn.a();
        z4.a = am3;
        z4.d = s2;
        return z4;
    }

    public boolean a(y y2, com.corrodinggames.rts.game.units.custom.b.n n2) {
        return false;
    }

    public boolean b(y y2) {
        return false;
    }

    public void bx() {
        if (this.cO == null) {
            return;
        }
        if (this.cO.bV) {
            // empty if block
        }
        if (!this.cO.b(this)) {
            com.corrodinggames.rts.gameFramework.GameEngine
                    .b("Deattach failed, forcing deattach. Child:" + this.cB() + " Parent:" + this.cO.cB());
            this.cO = null;
            this.cP = null;
        }
    }

    public com.corrodinggames.rts.game.units.custom.b.n a(short s2) {
        return null;
    }

    public static BaseUnit a(y y2, float f2, float f3, float f4, com.corrodinggames.rts.game.units.custom.h h2) {
        if (f4 <= 0.0f) {
            return null;
        }
        com.corrodinggames.rts.game.units.y.bo.checkLineOfSight = true;
        com.corrodinggames.rts.game.units.y.bo.includeNonGroundUnits = false;
        com.corrodinggames.rts.game.units.y.bo.nearestUnit = null;
        com.corrodinggames.rts.game.units.y.bo.closestDistanceSq = f4 * f4;
        com.corrodinggames.rts.game.units.y.bo.animationSetFilter = h2;
        com.corrodinggames.rts.game.units.y.bo.searchPosX = f2;
        com.corrodinggames.rts.game.units.y.bo.searchPosY = f3;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        l2.cc.a(f2, f3, f4, y2, 0.0f, bo);
        return com.corrodinggames.rts.game.units.y.bo.nearestUnit;
    }

    public com.corrodinggames.rts.game.units.custom.d.b by() {
        return com.corrodinggames.rts.game.units.custom.d.b.a;
    }

    public m bz() {
        return bq;
    }

    public boolean bA() {
        return false;
    }

    public int bB() {
        return 0;
    }

    @Override
    public void bC() {
        com.corrodinggames.rts.game.units.custom.d.b b2 = this.bE();
        com.corrodinggames.rts.game.units.custom.d.b b3 = this.bD();
        com.corrodinggames.rts.game.units.custom.d.b b4 = b2 == null ? b3
                : (b3 == null ? b2 : com.corrodinggames.rts.game.units.custom.d.b.a(b2, b3));
        if (this.dJ == null && b4 == null) {
            return;
        }
        if (this.dJ != null && b4 != null && this.dJ.b(b4)) {
            return;
        }
        com.corrodinggames.rts.game.PlayerTeam.b((BaseUnit) this);
        this.dJ = b4;
        com.corrodinggames.rts.game.PlayerTeam.c(this);
    }

    public com.corrodinggames.rts.game.units.custom.d.b bD() {
        return null;
    }

    public com.corrodinggames.rts.game.units.custom.d.b bE() {
        UnitCommand au2;
        BaseUnit am2 = this.X();
        if (am2 != null && (au2 = this.ar()) != null) {
            float f2;
            com.corrodinggames.rts.game.units.custom.d.b b2;
            if (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.repair && am2.cm < 1.0f) {
                b2 = this.g(am2);
                f2 = this.a_(am2) * 60.0f;
                if (b2 != null) {
                    return com.corrodinggames.rts.game.units.custom.d.b.a(b2, -f2);
                }
            }
            if (au2.a == com.corrodinggames.rts.game.units.UnitCommandType.reclaim) {
                if (am2.cm < 1.0f) {
                    b2 = this.g(am2);
                    f2 = this.f(am2) * 60.0f;
                    if (b2 != null) {
                        return com.corrodinggames.rts.game.units.custom.d.b.a(b2, f2);
                    }
                } else {
                    boolean bl2 = this.y(am2);
                    if (bl2) {
                        f2 = this.z(am2);
                        com.corrodinggames.rts.game.units.custom.d.b b3 = am2.cM();
                        com.corrodinggames.rts.game.units.custom.d.b b4 = am2.cN();
                        if (b4 != null) {
                            b3 = b4;
                        }
                        float f3 = f2 * 60.0f;
                        float f4 = f3 / am2.cv;
                        return com.corrodinggames.rts.game.units.custom.d.b.a(b3, f4);
                    }
                }
            }
        }
        return null;
    }

    static /* synthetic */ void a(y y2, BaseUnit am2, float f2, boolean bl2) {
        y2.a(am2, f2, bl2);
    }

    static {
        aE.a(128, 255, 255, 255);
        aE.o();
        aF = new com.corrodinggames.rts.gameFramework.m.ag();
        aF.a(aE);
        aF.a(true);
        aF.d(true);
        aF.b(true);
        aF.o();
        aG = new PointF();
        B = new Paint();
        D = com.corrodinggames.rts.game.units.y.a(false);
        E = com.corrodinggames.rts.game.units.y.a(true);
        aH = new y$1();
        aM = new UnitList();
        aP = new UnitStateTracker();
        aQ = new PassiveTargetCallback(true);
        aR = new PassiveTargetCallback(false);
        aS = new MultiTargetPassiveCallback(true);
        aT = new MultiTargetPassiveCallback(false);
        aV = new m();
        aW = new PositionData();
        aX = new PorterDuffColorFilter(Color.a(200, 255, 200), PorterDuff.Mode.MULTIPLY);
        aY = new PorterDuffColorFilter(Color.a(70, 255, 70), PorterDuff.Mode.MULTIPLY);
        aZ = new PorterDuffColorFilter(Color.a(255, 40, 40), PorterDuff.Mode.MULTIPLY);
        ba = new PorterDuffColorFilter(Color.a(120, 120, 255), PorterDuff.Mode.MULTIPLY);
        bb = com.corrodinggames.rts.gameFramework.utility.y.b();
        bc = com.corrodinggames.rts.gameFramework.utility.y.b();
        bd = com.corrodinggames.rts.gameFramework.utility.y.b();
        be = new PointF();
        bf = new Vector3D();
        bg = new PointF();
        bh = new PointF();
        bi = new Vector3D();
        bj = new PointF();
        bk = new Point();
        bl = new Point();
        bm = new PointF();
        bn = new z();
        bo = new NearestUnitFinder();
        bq = new m();
    }
}
