/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.PathfindingUtils;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.UnitCommand;
import com.corrodinggames.rts.game.units.f_f;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.d.t;
import com.corrodinggames.rts.gameFramework.utility.UnitList;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.PointF;

public final class AIController
        extends PlayerTeam {
    public static boolean as;
    final int at = 3000;
    int au;
    int av;
    int aw;
    int ax;
    int ay;
    int az;
    int aA;
    int aB;
    int aC;
    int aD;
    int aE;
    int aF;
    int aG;
    int aH;
    public int aI;
    int aJ = 0;
    boolean aK;
    float aL;
    float aM;
    float aN;
    float aO;
    float aP;
    float aQ;
    float aR = 0.0f;
    float aS = 0.0f;
    float aT;
    float aU;
    int aV;
    float aW;
    public boolean aX;
    public boolean aY;
    public boolean aZ;
    int ba;
    int bb;
    int bc;
    boolean bd = true;
    boolean be = true;
    boolean bf = false;
    com.corrodinggames.rts.game.units.f_f bg;
    boolean bh;
    boolean bi;
    boolean bj;
    boolean bk;
    int bl;
    ConcurrentLinkedQueue bm = new ConcurrentLinkedQueue();
    ArrayList bn = new ArrayList();
    PointF bo = new PointF();
    Paint bp;
    ArrayList bq = new ArrayList();
    UnitBuildStrategy br = new AIController$1(this, "attackingUnitsLand");
    UnitBuildStrategy bs = new AIController$6(this, "attackingUnitsHover");
    UnitBuildStrategy bt = new AIController$7(this, "attackingUnitsAir");
    UnitBuildStrategy bu = new AIController$8(this, "attackingUnitsWater");
    UnitBuildStrategy bv = new AIController$9(this, "buildingUnits");
    UnitBuildStrategy bw = new AIController$10(this, "transportUnits");
    UnitBuildStrategy bx = new AIController$11(this, "transportUnitsFlying");
    UnitBuildStrategy by = new AIController$12(this, "transportUnitsNonFlying");
    UnitBuildStrategy bz = new AIController$13(this, "builderUnits");
    UnitBuildStrategy bA = new AIController$2(this, "harvesterUnits");
    UnitBuildStrategy bB = new AIController$3(this, "extractorUnits");
    UnitBuildStrategy bC = new AIController$4(this, "buildingFactories");
    UnitBuildStrategy bD = new AIController$5(this, "buildingFactoriesForBuilders");
    public BuildPreferenceCache bE = new BuildPreferenceCache();
    int bF;
    public float bG = 0.0f;
    ArrayList bH = new ArrayList();
    private static ArrayList bK;
    public static final UnitList bI;
    public final com.corrodinggames.rts.gameFramework.utility.m bJ = new com.corrodinggames.rts.gameFramework.utility.m();

    public boolean ac() {
        int n2 = this.ag();
        return this.ag() == 3 || n2 > 300;
    }

    public boolean ad() {
        return this.ag() >= 2;
    }

    public boolean ae() {
        return (1 & this.aJ) == 1;
    }

    public boolean af() {
        return this.ae();
    }

    public int ag() {
        return this.bF;
    }

    public boolean ah() {
        com.corrodinggames.rts.gameFramework.k.l l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bU;
        return l2.A.i > 3000;
    }

    public boolean ai() {
        if (this.ah()) {
            return true;
        }
        if (!this.bh || !this.bi) {
            return true;
        }
        if (!this.bj) {
            return true;
        }
        return !this.bk;
    }

    public boolean aj() {
        if (!this.bk) {
            return false;
        }
        return this.ai() && this.bi;
    }

    public boolean a(float f2, float f3, o o2, UnitMovementType ao2) {
        if (this.a(f2, f3, o2.S, o2.T, ao2)) {
            return true;
        }
        for (float f4 = -180.0f; f4 < 180.0f; f4 += 90.0f) {
            float f5;
            float f6 = o2.S + com.corrodinggames.rts.gameFramework.GameUtils.k(f4) * o2.U * 0.4f;
            if (!this.a(f2, f3, f6, f5 = o2.T + com.corrodinggames.rts.gameFramework.GameUtils.j(f4) * o2.U * 0.4f,
                    ao2))
                continue;
            return true;
        }
        return false;
    }

    public boolean a(float f2, float f3, float f4, float f5, UnitMovementType ao2) {
        if (ao2 == com.corrodinggames.rts.game.units.UnitMovementType.NONE || ao2 == com.corrodinggames.rts.game.units.UnitMovementType.AIR) {
            return true;
        }
        short s2 = com.corrodinggames.rts.gameFramework.utility.y.b(f2, f3, ao2);
        short s3 = com.corrodinggames.rts.gameFramework.utility.y.b(f4, f5, ao2);
        if (s2 == -3 || s3 == -3) {
            String string2 = "null";
            if (ao2 != null) {
                string2 = ao2.name();
            }
            this.d("pathPossible: no isolatedGroups found! (" + string2 + ")");
            com.corrodinggames.rts.gameFramework.GameEngine.T();
        }
        if (s2 == -1 || s3 == -1) {
            return false;
        }
        if (s2 == -2) {
            return false;
        }
        if (s3 == -2) {
            return false;
        }
        return s2 == s3;
    }

    public boolean a(BaseUnit am2, float f2, float f3) {
        return this.a(am2.posX, am2.posY, f2, f3, am2.h());
    }

    public boolean b(BaseUnit am2, float f2, float f3) {
        float f4 = 60.0f;
        UnitMovementType ao2 = am2.h();
        if (this.a(am2.posX, am2.posY, f2, f3, ao2)) {
            return true;
        }
        if (this.a(am2.posX, am2.posY, f2 + f4, f3, ao2)) {
            return true;
        }
        if (this.a(am2.posX, am2.posY, f2 - f4, f3, ao2)) {
            return true;
        }
        if (this.a(am2.posX, am2.posY, f2, f3 + f4, ao2)) {
            return true;
        }
        return this.a(am2.posX, am2.posY, f2, f3 - f4, ao2);
    }

    public boolean a(BaseUnit am2, BaseUnit am3) {
        return this.b(am2, am3.posX, am3.posY);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException{
        as2.a(this.aK);
        as2.a(this.aL);
        as2.a(this.aM);
        as2.a(this.aN);
        as2.a(this.aO);
        as2.a(this.aT);
        as2.a(this.aV);
        as2.a(this.aW);
        as2.a(this.aX);
        as2.a(this.ba);
        as2.a(this.bm.size());
        for (Object object : this.bm) {
            int n2 = -1;
            if (object instanceof BaseZone) {
                n2 = 1;
            } else if (object instanceof UnitGroup) {
                n2 = 2;
            } else if (object instanceof com.corrodinggames.rts.game.a.TransporterGroup) {
                n2 = 3;
            } else if (object instanceof PlainZone) {
                n2 = 4;
            } else if (object instanceof RallyGroup) {
                n2 = 5;
            } else {
                throw new RuntimeException("zone not instance not supported:" + object.getClass().getName());
            }
            as2.c(n2);
            as2.a(((o) object).Q);
        }
        for (Object object : this.bm) {
            as2.a(((o) object).Q);
            ((o) object).a(as2);
        }
        as2.c(9);
        as2.a(this.aI);
        as2.a(this.bd);
        as2.a(this.bh);
        as2.a(this.bi);
        as2.a(this.bj);
        as2.a(this.bk);
        as2.a(this.aU);
        as2.a(this.bl);
        as2.a(this.au);
        as2.a(this.av);
        as2.a(this.aw);
        as2.a(this.aY);
        as2.a(this.aJ);
        as2.e();
        as2.a(this.bJ.a);
        for (int i2 = 0; i2 < this.bJ.a; ++i2) {
            Object object;
            object = (com.corrodinggames.rts.game.a.a.AIBehavior) this.bJ.get(i2);
            as2.a(((com.corrodinggames.rts.game.a.a.AIBehavior) object).a());
            ((com.corrodinggames.rts.game.a.a.AIBehavior) object).a(as2);
        }
        as2.e();
        super.a(as2);
    }

    public o l(int n2) {
        if (n2 == 1) {
            return new BaseZone(this, -1.0f, -1.0f);
        }
        if (n2 == 2) {
            return new UnitGroup(this);
        }
        if (n2 == 3) {
            return new com.corrodinggames.rts.game.a.TransporterGroup(this);
        }
        if (n2 == 4) {
            return new PlainZone(this);
        }
        if (n2 == 5) {
            return new RallyGroup(this);
        }
        if (n2 == 0) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("Found zone type 0, loading PlainZone instead");
            return new PlainZone(this);
        }
        throw new RuntimeException("Unknown zone type:" + n2);
    }

    @Override
    public void c(com.corrodinggames.rts.gameFramework.j.GameInputStream k2) throws IOException {
        int n2;
        this.aK = k2.e();
        this.aL = k2.g();
        this.aM = k2.g();
        this.aN = k2.g();
        this.aO = k2.g();
        this.aT = k2.g();
        this.aV = k2.readInt();
        this.aW = k2.g();
        this.aX = k2.e();
        this.ba = k2.readInt();
        int n3 = k2.readInt();
        this.bm.clear();
        boolean bl2 = false;
        if (k2.b() >= 20) {
            bl2 = true;
            for (n2 = 0; n2 < n3; ++n2) {
                byte by = k2.d();
                o o2 = this.l(by);
                o2.Q = k2.readInt();
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            o o3;
            if (!bl2) {
                byte by = k2.d();
                o3 = this.l(by);
            } else {
                o3 = this.m(k2.readInt());
            }
            o3.a(k2);
        }
        n2 = k2.d();
        if (n2 >= 1) {
            this.aI = k2.readInt();
        }
        this.bn.clear();
        this.bn.addAll(this.bm);
        if (n2 >= 2) {
            this.bd = k2.e();
            this.bh = k2.e();
            this.bi = k2.e();
        }
        if (n2 >= 3) {
            this.bj = k2.e();
            this.bk = k2.e();
        }
        if (n2 >= 4) {
            this.aU = k2.g();
        }
        if (n2 >= 5) {
            this.bl = k2.readInt();
        }
        if (n2 >= 6) {
            this.au = k2.readInt();
            this.av = k2.readInt();
            this.aw = k2.readInt();
        }
        if (n2 >= 7) {
            this.aY = k2.e();
        }
        if (n2 >= 8) {
            this.aJ = k2.readInt();
        }
        if (n2 >= 9) {
            k2.a("ai-c s");
            this.bJ.clear();
            int n4 = k2.readInt();
            for (int i2 = 0; i2 < n4; ++i2) {
                com.corrodinggames.rts.game.a.a.AIBehaviorType b2 = (com.corrodinggames.rts.game.a.a.AIBehaviorType) k2
                        .b(com.corrodinggames.rts.game.a.a.AIBehaviorType.class);
                com.corrodinggames.rts.game.a.a.AIBehavior a2 = b2.a();
                a2.a(k2);
                this.a(a2);
            }
            k2.a("ai-c e");
        }
        super.c(k2);
        this.ak();
    }

    public o m(int n2) {
        for (o o2 : ((ConcurrentLinkedQueue<o>) this.bm)) {
            if (o2.Q != n2)
                continue;
            return o2;
        }
        return null;
    }

    public int a(o o2) {
        if (o2 == null) {
            return -1;
        }
        return o2.Q;
    }

    void ak() {
        this.az = 0;
        this.aC = 0;
        this.aD = 0;
        this.aE = 0;
        this.aA = 0;
        this.aB = 0;
        this.aF = 0;
        this.aG = 0;
        this.ax = 0;
        this.ay = 0;
        this.aH = 0;
        for (o o2 : ((ArrayList<o>) this.bn)) {
            o o3;
            if (o2 instanceof BaseZone) {
                o3 = (BaseZone) o2;
                ++this.ax;
                if (((BaseZone) o3).u() >= 2) {
                    ++this.ay;
                }
                if (((BaseZone) o3).n) {
                    ++this.aH;
                }
            }
            if (o2 instanceof UnitGroup) {
                o3 = (UnitGroup) o2;
                if (((UnitGroup) o3).a)
                    continue;
                if (((UnitGroup) o3).h) {
                    ++this.az;
                    if (!((UnitGroup) o3).v && !((UnitGroup) o3).d()) {
                        if (!((UnitGroup) o3).B) {
                            ++this.aA;
                        } else {
                            ++this.aB;
                        }
                    }
                } else {
                    ++this.aC;
                    if (((UnitGroup) o3).d()) {
                        ++this.aD;
                    }
                    this.aE += ((AIUnitGroupBase) o3).l();
                }
            }
            if (!(o2 instanceof com.corrodinggames.rts.game.a.TransporterGroup))
                continue;
            o3 = (AIUnitGroupBase) o2;
            ++this.aF;
            if (((AIUnitGroupBase) o3).l() <= 0)
                continue;
            ++this.aG;
        }
    }

    private boolean a(UnitType as2) {
        BaseUnit am2 = com.corrodinggames.rts.game.units.BaseUnit.b(as2);
        if (!am2.bI() && am2 instanceof y && !this.g(am2) && !am2.aj() && ((y) am2).l()) {
            if (as2 instanceof com.corrodinggames.rts.game.units.custom.l) {
                com.corrodinggames.rts.game.units.custom.l l2 = (com.corrodinggames.rts.game.units.custom.l) as2;
                if (l2.fw || !l2.fs) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public AIController(int n2) {
        this(n2, true);
    }

    public AIController(int n2, boolean bl2) {
        super(n2, bl2);
        this.av();
    }

    private void av() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        this.aL = 100 + this.k * 9;
        this.aN = 202 + this.k * 19;
        this.aP = 50 + this.k * 2;
        this.aW = 4200 + this.k * 5;
        this.aT = 3500 + this.k * 5;
        this.aU = 7500 + this.k * 5;
        this.bp = new Paint();
        this.bp.b(Color.a(0, 255, 0));
        this.bp.a(Paint$Style.b);
        this.bp.a(true);
        l2.b(this.bp, 14.0f);
        this.al();
    }

    public void al() {
        for (UnitBuildStrategy d2 : ((ArrayList<UnitBuildStrategy>) this.bq)) {
            d2.b();
        }
    }

    public void d(String string2) {
        com.corrodinggames.rts.gameFramework.GameEngine.b("ai_debug(" + this.k + ")", string2);
    }

    public PointF am() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        l2.bL.a(com.corrodinggames.rts.gameFramework.GameUtils.a(0, l2.bL.C),
                com.corrodinggames.rts.gameFramework.GameUtils.a(0, l2.bL.D));
        this.bo.a(l2.bL.T, l2.bL.U);
        return this.bo;
    }

    public PointF an() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (l2.bL.A.size() == 0) {
            return null;
        }
        int n2 = com.corrodinggames.rts.gameFramework.GameUtils.c(l2.bL.A.size());
        Point point = (Point) l2.bL.A.get(n2);
        l2.bL.a(point.x, point.b);
        this.bo.a(l2.bL.T, l2.bL.U);
        return this.bo;
    }

    public PointF a(float f2, float f3) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        float f4 = -1.0f;
        PointF pointF = new PointF();
        for (int i2 = 0; i2 < l2.bL.A.size(); ++i2) {
            Point point = (Point) l2.bL.A.get(i2);
            l2.bL.a(point.x, point.b);
            this.bo.a(l2.bL.T, l2.bL.U);
            PointF pointF2 = this.bo;
            float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(pointF2.x, pointF2.b, f2, f3);
            if (!(f5 < f4) && f4 != -1.0f)
                continue;
            f4 = f5;
            pointF.a(pointF2);
        }
        if (f4 == -1.0f) {
            return null;
        }
        return pointF;
    }

    BaseZone e(BaseUnit am2) {
        for (o o2 : ((ArrayList<o>) this.bn)) {
            BaseZone i2;
            if (!(o2 instanceof BaseZone) || !(i2 = (BaseZone) o2).b(am2))
                continue;
            return i2;
        }
        return null;
    }

    BaseZone b(float f2, float f3) {
        for (o o2 : ((ArrayList<o>) this.bn)) {
            BaseZone i2;
            if (!(o2 instanceof BaseZone) || !(i2 = (BaseZone) o2).c(f2, f3))
                continue;
            return i2;
        }
        return null;
    }

    BaseZone f(BaseUnit am2) {
        return this.c(am2.posX, am2.posY);
    }

    BaseZone c(float f2, float f3) {
        float f4 = -1.0f;
        BaseZone i2 = null;
        for (o o2 : ((ArrayList<o>) this.bn)) {
            if (!(o2 instanceof BaseZone))
                continue;
            BaseZone i3 = (BaseZone) o2;
            float f5 = i3.d(f2, f3);
            if (i2 != null && !(f5 < f4))
                continue;
            f4 = f5;
            i2 = i3;
        }
        return i2;
    }

    BaseZone a(UnitMovementType ao2, float f2, float f3, boolean bl2) {
        float f4 = -1.0f;
        BaseZone i2 = null;
        for (o o2 : ((ArrayList<o>) this.bn)) {
            if (!(o2 instanceof BaseZone))
                continue;
            BaseZone i3 = (BaseZone) o2;
            float f5 = i3.d(f2, f3);
            if (!this.a(f2, f3, i3, ao2) || bl2 && i3.t || i2 != null && !(f5 < f4))
                continue;
            f4 = f5;
            i2 = i3;
        }
        return i2;
    }

    public static boolean a(BaseUnit am2, float f2, float f3, float f4) {
        float f5;
        float f6 = com.corrodinggames.rts.gameFramework.GameUtils.a(am2.posX, am2.posY, f2, f3);
        return f6 < (f5 = f4) * f5;
    }

    private boolean a(PointF pointF) {
        float f2;
        if (AIController.a(this, pointF.x, pointF.b, 290.0f) != null) {
            return false;
        }
        BaseZone i2 = this.c(pointF.x, pointF.b);
        if (i2 != null && i2.d(pointF.x, pointF.b) < 490000.0f) {
            return false;
        }
        PointF pointF2 = this.a(pointF.x, pointF.b);
        if (pointF2 != null && (f2 = com.corrodinggames.rts.gameFramework.GameUtils.a(pointF.x, pointF.b, pointF2.x,
                pointF2.b)) < 160000.0f) {
            return false;
        }
        f2 = 60.0f;
        return !com.corrodinggames.rts.gameFramework.utility.y.d(pointF.x, pointF.b)
                && !com.corrodinggames.rts.gameFramework.utility.y.d(pointF.x + f2, pointF.b)
                && !com.corrodinggames.rts.gameFramework.utility.y.d(pointF.x, pointF.b + f2)
                && !com.corrodinggames.rts.gameFramework.utility.y.d(pointF.x - f2, pointF.b)
                && !com.corrodinggames.rts.gameFramework.utility.y.d(pointF.x, pointF.b + f2);
    }

    private boolean b(PointF pointF) {
        for (BaseUnit am2 : ((Iterable<BaseUnit>) com.corrodinggames.rts.game.units.BaseUnit.bE)) {
            if (am2.bX == this || !(am2 instanceof com.corrodinggames.rts.game.units.d.e))
                continue;
            if (am2.bX.c(this) && AIController.a(am2, pointF.x, pointF.b, 300.0f)) {
                return false;
            }
            if (!am2.bX.d(this) || !AIController.a(am2, pointF.x, pointF.b, 320.0f))
                continue;
            return false;
        }
        if (AIController.b(this, pointF.x, pointF.b, 360.0f) >= 4) {
            return false;
        }
        boolean bl2 = true;
        return AIController.a(this, pointF.x, pointF.b, 360.0f, bl2) < 2;
    }

    public int a(UnitBuildStrategy d2, b b2) {
        int n2 = 0;
        for (e e2 : ((ArrayList<e>) d2.c)) {
            n2 += this.a(e2.a, b2);
        }
        return n2;
    }

    public int a(UnitType as2, b b2) {
        return this.a(as2, true, b2);
    }

    public int a(UnitType as2, boolean bl2, b b2) {
        boolean bl3 = as2.j();
        Integer n2 = this.bE.a(bl3, as2, bl2);
        if (n2 != null) {
            return n2;
        }
        int n3 = 0;
        if (bl3) {
            bl2 = false;
        }
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n4 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (int i2 = 0; i2 < n4; ++i2) {
            BaseUnit am2 = amArray[i2];
            if (am2.bX != this || b2 != b.a && am2.bM)
                continue;
            if (am2.dz == as2) {
                ++n3;
            }
            if (!bl2 || !(am2 instanceof com.corrodinggames.rts.game.units.d.l))
                continue;
            com.corrodinggames.rts.game.units.d.l l2 = (com.corrodinggames.rts.game.units.d.l) ((Object) am2);
            n3 += l2.h(as2);
        }
        this.bE.a(bl3, as2, bl2, n3);
        return n3;
    }

    public int ao() {
        int n2 = 0;
        for (o o2 : ((ArrayList<o>) this.bn)) {
            if (!(o2 instanceof UnitGroup))
                continue;
            UnitGroup g2 = (UnitGroup) o2;
            n2 += g2.G.size();
        }
        return n2;
    }

    public boolean g(BaseUnit am2) {
        y y2;
        if (am2 instanceof y && (y2 = (y) am2).cr()) {
            UnitType as2 = y2.r();
            if (as2 instanceof com.corrodinggames.rts.game.units.custom.l) {
                com.corrodinggames.rts.game.units.custom.l l2 = (com.corrodinggames.rts.game.units.custom.l) as2;
                if (!l2.ft) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean h(BaseUnit am2) {
        y y2;
        if (am2 instanceof y && !(y2 = (y) am2).bI() && y2.l() && !this.g(y2) && !y2.aj()) {
            UnitType as2 = y2.r();
            if (as2 instanceof com.corrodinggames.rts.game.units.custom.l) {
                com.corrodinggames.rts.game.units.custom.l l2 = (com.corrodinggames.rts.game.units.custom.l) as2;
                if (!l2.fs) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean b(BaseUnit am2, BaseUnit am3) {
        y y2;
        if (this.U) {
            y y3;
            return am2 instanceof y && (y3 = (y) am2).aq() && PathfindingUtils.a(y3, am3);
        }
        return this.h(am2) && am2 instanceof y && PathfindingUtils.a(y2 = (y) am2, am3);
    }

    public void i(float f2) throws IOException {
        float f3;
        float f4;
        float f5;
        float f6;
        Object object;
        if (!as || !com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bl) {
            return;
        }
        if (this.aZ || this.aX) {
            return;
        }
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n2 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            float f7;
            BaseUnit am2 = amArray[i2];
            if (am2.bX != this || !l2.cN.b((int) (am2.posX - (f7 = 200.0f)), (int) (am2.posY - f7), (int) (am2.posX + f7),
                    (int) (am2.posY + f7)))
                continue;
            if (am2 instanceof y) {
                object = (y) am2;
            }
            object = "";
            f6 = am2.posY - l2.cx - 60.0f;
            this.bp.b(Color.a(0, 255, 0));
            if (am2 instanceof com.corrodinggames.rts.game.units.d.e) {
                f6 -= 80.0f;
                object = (String) object + "Base ( Team:" + this.k + " )";
                object = (String) object + "\nuseTransportsOnThisMap: " + this.ai();
                object = (String) object + "\nuseHoverTransportsOnThisMap: " + this.aj();
                object = (String) object + "\nattackingCount: " + this.ba;
                object = (String) object + "\ndefendingCount: " + this.bb;
                object = (String) object + "\nnumOfUnitsNeedingTransport: " + this.ao();
                object = (String) object + "\ntransport: " + this.aG;
                if (this.ae()) {
                    object = (String) object + "\nTurtling: true";
                }
                this.bp.b(Color.a(255, 255, 255));
            }
            if (((String) object).length() == 0)
                continue;
            for (String object2 : ((String) object).split("\n")) {
                f5 = am2.posX - l2.cw;
                f4 = f6;
                f3 = -this.bp.l() + this.bp.m();
                l2.bO.k();
                if (l2.cX > 1.0f) {
                    l2.S();
                    f5 *= l2.cX;
                    f4 *= l2.cX;
                    f3 /= l2.cX;
                }
                l2.bO.a(object2, f5, f4, this.bp);
                l2.bO.l();
                f6 += f3;
            }
        }
        for (o o2 : ((Iterable<o>) this.bm)) {
            Object object3;
            if (!l2.cN.b((int) (o2.S - o2.U), (int) (o2.T - o2.U), (int) (o2.S + o2.U), (int) (o2.T + o2.U)))
                continue;
            this.bp.b(this.K());
            l2.bO.a(o2.S - l2.cw, o2.T - l2.cx, o2.U + 2.0f, this.bp);
            int n3 = Color.a(0, 255, 0);
            String string2 = "";
            object = o2.getClass().getSimpleName();
            string2 = string2 + "\n" + (String) object + " ( Team:" + this.k + " )";
            f6 = o2.T - l2.cx;
            if (o2 instanceof BaseZone) {
                f6 -= 50.0f;
                object3 = (BaseZone) o2;
                string2 = string2 + "\nState: " + ((BaseZone) object3).b.name() + "(id:" + ((BaseZone) object3).Q + ")";
                string2 = string2 + "\nunsafe: " + ((BaseZone) object3).f() + " (" + ((BaseZone) object3).s + ")";
                string2 = string2 + "\nunsafeBaseTimer: " + ((BaseZone) object3).v;
                string2 = string2 + "\nallowedUnits: " + ((BaseZone) object3).d;
                if (((BaseZone) object3).z != null) {
                    string2 = string2 + "\nlastAttemptedBuilding: " + ((BaseZone) object3).z.i();
                }
                if (((BaseZone) object3).A != null) {
                    string2 = string2 + "\nlastAttemptedBuilding-cannotAffordPrice: "
                            + ((BaseZone) object3).A.a(false, true, 4, true);
                }
                if (((BaseZone) object3).B != null) {
                    string2 = string2 + "\nlastAttemptedBuilding-cannotAffordBy: "
                            + ((BaseZone) object3).B.a(false, true, 4, true);
                }
                string2 = string2 + "\nlastAttemptedBuildingCount: " + ((BaseZone) object3).C;
                string2 = string2 + "\nlastAttemptedBuildingFailed: " + ((BaseZone) object3).D;
                string2 = string2 + "\nlastUnitAttempt: " + ((BaseZone) object3).E + " (" + ((BaseZone) object3).F + " - "
                        + ((BaseZone) object3).G + ")";
                string2 = string2 + "\nbuildBuildingDelay: " + ((BaseZone) object3).e;
                string2 = string2 + "\ncredits: " + com.corrodinggames.rts.gameFramework.GameUtils.c(this.o) + " (x"
                        + com.corrodinggames.rts.gameFramework.GameUtils.g(this.E()) + ")";
                if (((BaseZone) object3).b == com.corrodinggames.rts.game.a.BaseZoneStage.Active) {
                    string2 = string2 + "\nclaimedBaseTimer: " + ((BaseZone) object3).l;
                }
                if (((BaseZone) object3).k > 100.0f) {
                    string2 = string2 + "\nabandonedTimer: " + ((BaseZone) object3).k;
                }
                if (((BaseZone) object3).g > 0.0f) {
                    string2 = string2 + "\nrequestedBuildersDelay: " + ((BaseZone) object3).g + " (" + ((BaseZone) object3).h + ")";
                }
                string2 = string2 + "\nBuilders: " + ((BaseZone) object3).J;
                string2 = string2 + "\nIdle Builders: " + ((BaseZone) object3).K;
            }
            if (o2 instanceof UnitGroup) {
                object3 = (UnitGroup) o2;
                if (((UnitGroup) object3).c) {
                    string2 = string2 + "\nVIP Mode";
                }
                string2 = string2 + "\n" + (((UnitGroup) object3).b() ? "Defensive Type" : "Attack Type");
                string2 = string2 + "\nUnits: " + ((UnitGroup) object3).F.size() + " / " + ((UnitGroup) object3).A;
                string2 = string2 + "\nStagingForAttack: " + ((UnitGroup) object3).q;
                string2 = string2 + "\nAttackDelay: " + ((UnitGroup) object3).l;
                if (((UnitGroup) object3).u != 0.0f) {
                    string2 = string2 + "\nStagingTimer: " + ((UnitGroup) object3).u;
                }
                string2 = string2 + "\nStagingTargetFound: " + ((UnitGroup) object3).r;
                if (((UnitGroup) object3).o != 0.0f) {
                    string2 = string2 + "\nattackingFor: " + ((UnitGroup) object3).o;
                }
                string2 = string2 + "\ncommonMovement: " + ((UnitGroup) object3).i().name();
                if (((UnitGroup) object3).B) {
                    string2 = string2 + " (seaGroup)";
                }
                if (((UnitGroup) object3).G.size() > 0) {
                    string2 = string2 + "\nunitsNeedingTransport:" + ((UnitGroup) object3).G.size();
                }
                if (((UnitGroup) object3).b != null) {
                    string2 = string2 + "\nlast action:" + ((UnitGroup) object3).b;
                }
                if (!((UnitGroup) object3).v && !((UnitGroup) object3).q) {
                    string2 = string2 + "\nnext move:" + (int) this.k(((UnitGroup) object3).n) + "s";
                }
            }
            if (o2 instanceof com.corrodinggames.rts.game.a.TransporterGroup) {
                object3 = (com.corrodinggames.rts.game.a.TransporterGroup) o2;
                string2 = string2 + "\nUnitsWanted: " + ((com.corrodinggames.rts.game.a.TransporterGroup) object3).l;
                string2 = string2 + "\nunits: " + ((com.corrodinggames.rts.game.a.TransporterGroup) object3).F.size();
                string2 = string2 + "\nreadyToMoveOut: " + ((com.corrodinggames.rts.game.a.TransporterGroup) object3).q;
                if (((com.corrodinggames.rts.game.a.TransporterGroup) object3).m != null) {
                    string2 = string2 + "\nCurrentlyHelping: " + ((com.corrodinggames.rts.game.a.TransporterGroup) object3).m.Q;
                }
            }
            if (o2 instanceof RallyGroup) {
                object3 = (RallyGroup) o2;
                string2 = string2 + "\nneedsTransportGroup: " + ((RallyGroup) object3).a;
            }
            this.bp.b(this.K());
            for (String string3 : string2.split("\n")) {
                if (string3.trim().equals(""))
                    continue;
                f5 = o2.S - l2.cw;
                f4 = f6;
                f3 = -this.bp.l() + this.bp.m();
                l2.bO.k();
                if (l2.cX > 1.0f) {
                    l2.S();
                    f5 *= l2.cX;
                    f4 *= l2.cX;
                    f3 /= l2.cX;
                }
                l2.bO.a(string3, f5, f4, this.bp);
                l2.bO.l();
                f6 += f3;
                this.bp.b(n3);
            }
        }
    }

    public BaseUnit e(PlayerTeam n2) {
        for (BaseUnit am2 : ((Iterable<BaseUnit>) com.corrodinggames.rts.game.units.BaseUnit.bE)) {
            if (am2.bX != n2 || !(am2 instanceof com.corrodinggames.rts.game.units.d.e) && !am2.bP)
                continue;
            return am2;
        }
        for (BaseUnit am2 : ((Iterable<BaseUnit>) com.corrodinggames.rts.game.units.BaseUnit.bE)) {
            if (am2.bX != n2 || !am2.bO)
                continue;
            return am2;
        }
        return null;
    }

    @Override
    public void a(float var1) {
        super.a(var1);
        com.corrodinggames.rts.gameFramework.GameEngine var2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (!this.aX && !this.aZ) {
            if (var2.networkEngine.B) {
                if (!var2.networkEngine.C) {
                    return;
                }

                if (var2.cb.j()) {
                    return;
                }
            }

            if (this.bG > 0.0F) {
                this.bG -= var1;
            } else {
                this.bF = this.C();
                int var4;
                int var5;
                BaseUnit var6;
                if (this.be && var2.by > 3000) {
                    this.be = false;
                    BaseUnit[] var3 = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
                    var4 = 0;

                    for (var5 = com.corrodinggames.rts.game.units.BaseUnit.bE.size(); var4 < var5; ++var4) {
                        var6 = var3[var4];
                        if (var6 instanceof com.corrodinggames.rts.game.units.f_f ) {
                            this.d("firstRunDelayed: Found damagingBorder");
                            this.bg = (f_f) var6;
                            break;
                        }
                    }
                }

                if (this.bd) {
                    this.bd = false;
                    this.bh = true;
                    this.bi = true;
                    this.bj = true;
                    this.bk = true;
                    BaseUnit var10 = this.e((PlayerTeam) this);
                    if (var10 == null) {
                        this.d("firstRun: no command center found");
                    }

                    if (var10 != null) {
                        for (var4 = 0; var4 < com.corrodinggames.rts.game.PlayerTeam.c; ++var4) {
                            PlayerTeam var13 = com.corrodinggames.rts.game.PlayerTeam.k(var4);
                            if (var13 != null && var13 != this) {
                                var6 = this.e(var13);
                                if (var6 != null) {
                                    if (!this.a(var10.posX, var10.posY, var6.posX, var6.posY, com.corrodinggames.rts.game.units.UnitMovementType.LAND)) {
                                        this.bh = false;
                                    }

                                    if (!this.a(var10.posX, var10.posY, var6.posX, var6.posY, com.corrodinggames.rts.game.units.UnitMovementType.OVER_CLIFF_WATER)) {
                                        this.bi = false;
                                    }
                                }
                            }
                        }

                        Iterator var12 = var2.bL.A.iterator();

                        while (var12.hasNext()) {
                            Point var15 = (Point) var12.next();
                            PointF var17 = var2.bL.a(var15);
                            if (!this.a(var10.posX, var10.posY, var17.x, var17.b + (float) var2.bL.o, com.corrodinggames.rts.game.units.UnitMovementType.LAND)) {
                                this.bj = false;
                            }

                            if (!this.a(var10.posX, var10.posY, var17.x, var17.b + (float) var2.bL.o, com.corrodinggames.rts.game.units.UnitMovementType.OVER_CLIFF_WATER)) {
                                this.bk = false;
                            }
                        }
                    }
                }

                this.aP += var1;
                this.aQ += var1;
                if (this.aP > 25.0F) {
                    this.aP -= 25.0F;
                    if (this.aP > 25.0F) {
                        this.aP = 25.0F;
                    }

                    if (this.aP < -1.0F) {
                        this.aP = -1.0F;
                    }

                    boolean var11 = false;
                    boolean var14 = false;
                    Iterator var16 = this.bm.iterator();

                    while (var16.hasNext()) {
                        o var18 = (o) var16.next();
                        if (var18 instanceof BaseZone) {
                            BaseZone var7 = (BaseZone) var18;
                            var7.a += this.aQ;
                        }
                    }

                    label134: for (var5 = 0; var5 < 2; ++var5) {
                        BaseZone var19 = null;
                        Iterator var20 = this.bm.iterator();

                        while (true) {
                            BaseZone var9;
                            do {
                                o var8;
                                do {
                                    if (!var20.hasNext()) {
                                        if (var19 == null || var19.a < 50.0F) {
                                            break label134;
                                        }

                                        var19.b(var19.a);
                                        var19.d(var19.a);
                                        var19.a = 0.0F;
                                        continue label134;
                                    }

                                    var8 = (o) var20.next();
                                } while (!(var8 instanceof BaseZone));

                                var9 = (BaseZone) var8;
                            } while (var19 != null && !(var19.a < var9.a));

                            var19 = var9;
                        }
                    }

                    this.aQ = 0.0F;
                }

                this.aL += var1;
                this.aM += var1;
                if (this.aL > 80.0F) {
                    this.n(this.aM);
                    this.aL -= 80.0F;
                    if (this.aL > 80.0F) {
                        this.aL = 80.0F;
                    }

                    if (this.aL < -1.0F) {
                        this.aL = -1.0F;
                    }

                    this.aM = 0.0F;
                }

                this.aN += var1;
                this.aO += var1;
                if (this.aN > 250.0F) {
                    this.m(this.aO);
                    this.aN -= 250.0F;
                    if (this.aN > 250.0F) {
                        this.aN = 250.0F;
                    }

                    if (this.aN < -1.0F) {
                        this.aN = -1.0F;
                    }

                    this.aO = 0.0F;
                }

            }
        }
    }

    public float j(float f2) {
        return f2 / 60.0f * 1000.0f;
    }

    public float k(float f2) {
        return f2 / 60.0f;
    }

    public void a(y y2, com.corrodinggames.rts.game.units.a.ActionId c2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        com.corrodinggames.rts.gameFramework.GameCommand e2 = l2.cf.a(this);
        e2.a(y2);
        e2.a(c2);
    }

    public void l(float f2) {
        for (BaseUnit am2 : ((Iterable<BaseUnit>)com.corrodinggames.rts.game.units.BaseUnit.bE)) {
            boolean bl2;
            Object object;
            boolean bl3;
            if (am2.bX != this || !(am2 instanceof y) || !this.i(am2))
                continue;
            y y2 = (y) am2;
            if (y2 instanceof com.corrodinggames.rts.game.units.h.e) {
                bl3 = false;
                object = y2.ab();
                if (object != null && y2.h((BaseUnit) object)) {
                    bl3 = !((BaseUnit) object).cH();
                }
                boolean bl4 = bl2 = !y2.Q();
                if (bl3 && bl3 != bl2) {
                    this.a(y2, com.corrodinggames.rts.game.units.h.e.j.N());
                }
                if (!bl3 && bl3 != bl2) {
                    this.a(y2, com.corrodinggames.rts.game.units.h.e.k.N());
                }
            }
            if (y2 instanceof com.corrodinggames.rts.game.units.b.c) {
                bl3 = true;
                object = y2.ab();
                if (object != null && y2.h((BaseUnit) object)) {
                    bl3 = !((BaseUnit) object).Q();
                }
                boolean bl5 = bl2 = !y2.Q();
                if (bl3 && bl3 != bl2) {
                    this.a(y2, com.corrodinggames.rts.game.units.b.c.y.N());
                }
                if (!bl3 && bl3 != bl2) {
                    this.a(y2, com.corrodinggames.rts.game.units.b.c.z.N());
                }
            }
            if (y2.be() != com.corrodinggames.rts.game.units.UnitBehaviorType.bomber || !y2.aq() || y2.ab() == null)
                continue;
            com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
            object = l2.cf.a(this);
            ((com.corrodinggames.rts.gameFramework.GameCommand) object).a(y2);
            ((com.corrodinggames.rts.gameFramework.GameCommand) object).a(y2.ab());
        }
    }

    public com.corrodinggames.rts.game.units.a_f c(y y2) {
        if (y2.aS()) {
            boolean bl2 = true;
            if (y2.aj()) {
                bl2 = false;
            }
            if (this.g(y2)) {
                bl2 = false;
            }
            if (bl2) {
                if (this.aY) {
                    return com.corrodinggames.rts.game.units.a_f.aggressive;
                }
                return com.corrodinggames.rts.game.units.a_f.outOfRange;
            }
        }
        return com.corrodinggames.rts.game.units.a_f.onlyInRange;
    }

    public ArrayList ap() {
        bK.clear();
        return bK;
    }

    public void d(y y2) {
        for (com.corrodinggames.rts.game.a.a.AIBehavior a2 : ((Iterable<com.corrodinggames.rts.game.a.a.AIBehavior>)this.bJ)) {
            a2.a(this, y2);
        }
    }

    public void e(y y2) {
        for (com.corrodinggames.rts.game.a.a.AIBehavior a2 : ((Iterable<com.corrodinggames.rts.game.a.a.AIBehavior>)this.bJ)) {
            a2.b(this, y2);
        }
    }

public void m(float deltaTime) {
    com.corrodinggames.rts.gameFramework.GameEngine framework = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
    
    // 初始化部分
    this.bE.b();
    Iterator iterator = this.bJ.iterator();
    while (iterator.hasNext()) {
        com.corrodinggames.rts.game.a.a.AIBehavior element = (com.corrodinggames.rts.game.a.a.AIBehavior) iterator.next();
        element.b(this.j(deltaTime), this);
    }

    int unitCount = 0;
    BaseUnit[] allUnits = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
    int totalUnits = com.corrodinggames.rts.game.units.BaseUnit.bE.size();

    // 第一轮单位处理
    for (int i = 0; i < totalUnits; i++) {
        BaseUnit unit = allUnits[i];
        if (unit.bX == this && !unit.u()) {
            unitCount++;
            if (unit instanceof com.corrodinggames.rts.game.units.y) {
                com.corrodinggames.rts.game.units.y yUnit = (com.corrodinggames.rts.game.units.y) unit;
                
                if (!yUnit.bD) {
                    yUnit.bD = true;
                    this.d(yUnit);
                }

                if (unit.cN == null) {
                    BaseZone oldAI = yUnit.aC;
                    yUnit.aC = this.f(unit);
                    
                    if (yUnit.aC != null && oldAI != yUnit.aC) {
                        boolean pathValid;
                        if (yUnit.bI()) {
                            pathValid = this.a(unit.posX, unit.posY, yUnit.aC.S, yUnit.aC.T, com.corrodinggames.rts.game.units.UnitMovementType.LAND);
                            if (!pathValid && yUnit.r().p()) {
                                pathValid = this.a(unit.posX, unit.posY + 15.0F, yUnit.aC.S, yUnit.aC.T, com.corrodinggames.rts.game.units.UnitMovementType.LAND);
                            }
                            yUnit.aD = pathValid;
                        } else {
                            yUnit.aD = this.a(unit.posX, unit.posY, yUnit.aC.S, yUnit.aC.T, com.corrodinggames.rts.game.units.UnitMovementType.LAND);
                        }
                    }
                }
            }
        }
    }

    this.l(deltaTime);

    // 第二轮单位处理
    Iterator unitIterator = com.corrodinggames.rts.game.units.BaseUnit.bE.iterator();
    while (unitIterator.hasNext()) {
        BaseUnit unit = (BaseUnit) unitIterator.next();
        if (unit.bX == this && unit instanceof com.corrodinggames.rts.game.units.y) {
            com.corrodinggames.rts.game.units.y yUnit = (com.corrodinggames.rts.game.units.y) unit;
            com.corrodinggames.rts.game.units.a_f action = this.c(yUnit);
            
            if (yUnit.P != action && this.i(yUnit)) {
                com.corrodinggames.rts.gameFramework.GameCommand effect = framework.cf.a(this);
                effect.a(yUnit);
                effect.a(action);
            }

            if (yUnit.aj() && yUnit.dd() && yUnit.aB == null && this.i(yUnit)) {
                com.corrodinggames.rts.game.a.UnitGroup.a(this, yUnit);
            }
        }
    }

    // 状态检查
    if (unitCount == 0 && !this.U) {
        this.aZ = true;
    }

    // 计时器更新
    this.aU = com.corrodinggames.rts.gameFramework.GameUtils.a(this.aU, deltaTime);
    this.aT = com.corrodinggames.rts.gameFramework.GameUtils.a(this.aT, deltaTime);
    
    if (this.ac()) {
        this.aT = com.corrodinggames.rts.gameFramework.GameUtils.a(this.aT, 4.0F * deltaTime);
    }

    // 基地建设逻辑
    if (this.aT == 0.0F) {
        int baseCount = 0;
        Iterator bnIterator = this.bn.iterator();
        
        while (bnIterator.hasNext()) {
            o obj = (o) bnIterator.next();
            if (obj instanceof BaseZone) {
                BaseZone aiObj = (BaseZone) obj;
                if (aiObj.b == com.corrodinggames.rts.game.a.BaseZoneStage.Active) {
                    baseCount++;
                }
            }
        }

        boolean shouldCreateBase = baseCount > 2;
        
        if (shouldCreateBase) {
            this.aT = 300.0F;
        } else {
            PointF baseLocation = this.an();
            if (baseLocation != null) {
                baseLocation.b += (float) framework.bL.o;
                if (this.b(baseLocation.x, baseLocation.b) == null && this.b(baseLocation)) {
                    this.aT = 2000.0F;
                    BaseZone newBase = new BaseZone(this, baseLocation.x, baseLocation.b);
                    newBase.U = 360.0F;
                    newBase.b = com.corrodinggames.rts.game.a.BaseZoneStage.Active;
                    newBase.c = com.corrodinggames.rts.game.a.BaseZoneType.ResourceOutpost;
                    this.aw++;
                }
            }
        }
    }

    // 工厂建设逻辑
    if (this.aU == 0.0F) {
        this.aU = 100.0F;
        int factoryCount = 0;
        Iterator bnIterator = this.bn.iterator();
        
        while (bnIterator.hasNext()) {
            o obj = (o) bnIterator.next();
            if (obj instanceof BaseZone) {
                BaseZone aiObj = (BaseZone) obj;
                if (aiObj.c == com.corrodinggames.rts.game.a.BaseZoneType.ForwardOutpost) {
                    factoryCount++;
                }
            }
        }

        if (factoryCount < 3) {
            BaseUnit suitableUnit = this.ar();
            if (suitableUnit != null) {
                PointF factoryLocation = new PointF();
                factoryLocation.x = suitableUnit.posX;
                factoryLocation.b = suitableUnit.posY;
                
                if (this.b(factoryLocation.x, factoryLocation.b) == null && this.a(factoryLocation)) {
                    this.aU = 5000.0F;
                    BaseZone newFactory = new BaseZone(this, factoryLocation.x, factoryLocation.b);
                    newFactory.U = 310.0F;
                    newFactory.b = com.corrodinggames.rts.game.a.BaseZoneStage.Pre;
                    newFactory.c = com.corrodinggames.rts.game.a.BaseZoneType.ForwardOutpost;
                    this.aw++;
                }
            }
        }
    }

    // 单位统计
    this.bc = 0;
    this.ba = 0;
    this.bb = 0;
    
    allUnits = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
    totalUnits = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
    
    for (int i = 0; i < totalUnits; i++) {
        BaseUnit unit = allUnits[i];
        if (unit.bX == this && unit instanceof com.corrodinggames.rts.game.units.y) {
            com.corrodinggames.rts.game.units.y yUnit = (com.corrodinggames.rts.game.units.y) unit;
            
            if (!unit.bI()) {
                if (yUnit.aB != null && yUnit.aB.b()) {
                    this.bb++;
                } else if (this.h(yUnit) && !yUnit.bM) {
                    if (yUnit.h() == com.corrodinggames.rts.game.units.UnitMovementType.WATER) {
                        this.bc++;
                    } else {
                        this.ba++;
                    }
                }
            }
        }
    }

    // 生产逻辑
    this.aR = com.corrodinggames.rts.gameFramework.GameUtils.a(this.aR, deltaTime);
    this.aS += deltaTime;
    
    if (this.aR == 0.0F) {
        int builderCount = 0;
        int advancedBuilderCount = 0;
        int airUnitCount = 0;
        int airFactoryCount = 0;

        // 统计单位类型
        Iterator statIterator = com.corrodinggames.rts.game.units.BaseUnit.bE.iterator();
        while (statIterator.hasNext()) {
            BaseUnit unit = (BaseUnit) statIterator.next();
            if (unit.bX == this && unit.bT()) {
                // 建筑单位统计
                if ((unit instanceof com.corrodinggames.rts.game.units.d.m || 
                     unit instanceof com.corrodinggames.rts.game.units.d.a_f || 
                     unit instanceof t) && 
                    unit instanceof com.corrodinggames.rts.game.units.d.a_f) {
                    builderCount++;
                    com.corrodinggames.rts.game.units.d.a_f builder = (com.corrodinggames.rts.game.units.d.a_f) unit;
                    if (builder.V() > 1) {
                        advancedBuilderCount++;
                    }
                }

                // 空中单位统计
                if (unit.r().p()) {
                    airUnitCount++;
                    com.corrodinggames.rts.game.units.a.ActionId unitType = unit.cm();
                    if (com.corrodinggames.rts.game.units.a.AbstractUnitAction.c(unitType)) {
                        airFactoryCount++;
                    }
                }
            }
        }

        // 生产决策
        if (this.a(4100.0) || this.aS > 2400.0F || this.aH == 0) {
            // 升级处理
            Iterator upgradeIterator = com.corrodinggames.rts.game.units.BaseUnit.bE.iterator();
            while (upgradeIterator.hasNext()) {
                BaseUnit unit = (BaseUnit) upgradeIterator.next();
                if (unit.bX == this && unit instanceof com.corrodinggames.rts.game.units.y) {
                    com.corrodinggames.rts.game.units.y yUnit = (com.corrodinggames.rts.game.units.y) unit;
                    if (yUnit.cl()) {
                        ArrayList availableUpgrades = yUnit.N();
                        ArrayList validUpgrades = this.ap();
                        
                        Iterator upgradeListIterator = availableUpgrades.iterator();
                        while (upgradeListIterator.hasNext()) {
                            AbstractUnitAction upgrade = (AbstractUnitAction) upgradeListIterator.next();
                            if (upgrade.n(yUnit)) {
                                validUpgrades.add(upgrade);
                            }
                        }
                        
                        if (validUpgrades.size() > 0) {
                            this.a(yUnit, (AbstractUnitAction) com.corrodinggames.rts.game.a.f.a(validUpgrades));
                        }
                    }
                }
            }

            // 单位生产
            boolean advancedAI = this.a(30000.0);
            Iterator productionIterator = com.corrodinggames.rts.game.units.BaseUnit.bE.iterator();
            
            productionLoop:
            while (productionIterator.hasNext()) {
                BaseUnit unit = (BaseUnit) productionIterator.next();
                if (unit.bX == this && unit instanceof com.corrodinggames.rts.game.units.y) {
                    com.corrodinggames.rts.game.units.y yUnit = (com.corrodinggames.rts.game.units.y) unit;
                    com.corrodinggames.rts.game.units.a.ActionId productionType = yUnit.cm();
                    
                    if (com.corrodinggames.rts.game.units.a.AbstractUnitAction.c(productionType)) {
                        float productionTime = yUnit.cn();
                        boolean canProduce = productionTime >= 0.0F;
                        
                        if (!canProduce) {
                            productionTime = 6.0F;
                        }

                        if (productionTime != 0.0F) {
                            int randomChance = com.corrodinggames.rts.gameFramework.GameUtils.c(100);
                            float threshold = 100.0F - productionTime;
                            
                            if (advancedAI) {
                                threshold -= 4.0F;
                            }

                            if (!canProduce) {
                                if (unit.r().p() && airFactoryCount > 0) {
                                    threshold = 50.0F;
                                }

                                if (builderCount > 0 && advancedBuilderCount == 0) {
                                    threshold = 99.0F;
                                    if (unit instanceof com.corrodinggames.rts.game.units.d.a_f) {
                                        threshold = 40.0F;
                                    }
                                }
                            }

                            if (threshold < 10.0F) {
                                threshold = 10.0F;
                            }

                            boolean shouldProduce = (float) randomChance > threshold;
                            
                            if (shouldProduce) {
                                boolean canProduceNow = yUnit.co();
                                
                                // 随机选择生产类型
                                if (com.corrodinggames.rts.gameFramework.GameUtils.c(100) > 50) {
                                    yUnit.a(this.bH);
                                    if (this.bH.size() != 0) {
                                        productionType = (com.corrodinggames.rts.game.units.a.ActionId) this.bH.get(
                                            (new Random()).nextInt(this.bH.size())
                                        );
                                    }
                                }

                                boolean canBuild = true;
                                AbstractUnitAction production = yUnit.a(productionType);
                                
                                if (production != null) {
                                    if (production.m(yUnit) ||
                                        production.e() == com.corrodinggames.rts.game.units.a.ActionType.targetGround ||
                                        !production.b(yUnit) ||
                                        !production.a(yUnit, false)) {
                                        canBuild = false;
                                    }
                                } else {
                                    canBuild = false;
                                }

                                if (canBuild) {
                                    this.a(yUnit, productionType);
                                    com.corrodinggames.rts.game.units.custom.d.b customData = production.B();
                                    this.a(yUnit, customData, true);
                                    
                                    this.aR = 900.0F;
                                    this.aS = 0.0F;
                                    
                                    if (!advancedAI) {
                                        break productionLoop;
                                    } else if (this.a(40000.0)) {
                                        if (com.corrodinggames.rts.gameFramework.GameUtils.c(100) > 95) {
                                            break productionLoop;
                                        }
                                    } else if (com.corrodinggames.rts.gameFramework.GameUtils.c(100) > 80) {
                                        break productionLoop;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // 处理器更新
    Iterator processorIterator = this.bm.iterator();
    while (processorIterator.hasNext()) {
        o processor = (o) processorIterator.next();
        if (processor instanceof AIUnitGroupBase) {
            ((AIUnitGroupBase) processor).b(deltaTime);
        }
    }
}
    public boolean a(y y2, AbstractUnitAction s2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (s2.b(y2) && s2.a((BaseUnit) y2, false)) {
            com.corrodinggames.rts.gameFramework.GameCommand e2 = l2.cf.a(this);
            e2.a(y2);
            e2.a(s2.z());
            return true;
        }
        return false;
    }

    public boolean a(y y2, AbstractUnitAction s2, PointF pointF, BaseUnit am2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (s2.b(y2) && s2.a((BaseUnit) y2, false)) {
            com.corrodinggames.rts.gameFramework.GameCommand e2 = l2.cf.a(this);
            e2.a(y2);
            e2.a(s2.z(), pointF, am2);
            return true;
        }
        return false;
    }

    public void aq() {
        for (Object object : this.bm) {
            if (!(object instanceof BaseZone))
                continue;
            ((BaseZone) object).t();
        }
        for (Object object : this.bm) {
            for (o o2 :  ((Iterable<o>)this.bm)) {
                if (object == o2 || ((o) object).Q != o2.Q)
                    continue;
                com.corrodinggames.rts.gameFramework.GameEngine.a("Id overlap on:" + ((o) object).Q);
                com.corrodinggames.rts.gameFramework.GameEngine.a("zone x:" + ((o) object).S);
                com.corrodinggames.rts.gameFramework.GameEngine.a("zone y:" + ((o) object).T);
                com.corrodinggames.rts.gameFramework.GameEngine.a("zone radius:" + ((o) object).U);
                com.corrodinggames.rts.gameFramework.GameEngine.a("zone type:" + object.getClass().getName());
            }
        }
        int n2 = 0;
        for (Object object : this.bm) {
            if (!(object instanceof BaseZone))
                continue;
            ++n2;
        }
        int n3 = 0;
        for (o o2 : ((Iterable<o>)this.bm)) {
            if (!(o2 instanceof BaseZone))
                continue;
            for (o o3 :((Iterable<o>)this.bm)) {
                float f2;
                if (!(o3 instanceof BaseZone) || o2 == o3
                        || !((f2 = com.corrodinggames.rts.gameFramework.GameUtils.a(o2.S, o2.T, o3.S, o3.T)) < 400.0f))
                    continue;
                ++n3;
            }
        }
        if (n3 > 0) {
            this.d("baseOverlapCount:" + n3);
        }
    }

    @Override
    public void a(y y2) {
        if (y2.bX == this) {
            this.bE.a(y2);
        }
    }






public void n(float deltaTime) {
    com.corrodinggames.rts.gameFramework.GameEngine framework = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
    
    // 初始化处理
    this.bE.a();
    Iterator iterator = this.bJ.iterator();
    while (iterator.hasNext()) {
        com.corrodinggames.rts.game.a.a.AIBehavior element = (com.corrodinggames.rts.game.a.a.AIBehavior) iterator.next();
        element.a(this.j(deltaTime), this);
    }

    // 处理器更新
    iterator = this.bm.iterator();
    while (iterator.hasNext()) {
        o processor = (o) iterator.next();
        if (processor instanceof AIUnitGroupBase) {
            AIUnitGroupBase handler = (AIUnitGroupBase) processor;
            handler.c(deltaTime);
        }
    }

    // 区域选择处理
    if (this.bg != null) {
        iterator = this.bm.iterator();
        while (iterator.hasNext()) {
            o obj = (o) iterator.next();
            if (this.bg.a(obj.S, obj.T)) {
                if (obj instanceof BaseZone) {
                    obj.p();
                    break;
                }
                if (obj instanceof UnitGroup) {
                    PointF newPos = this.bg.a(obj.S, obj.T, obj.U + 20.0F);
                    obj.S = newPos.x;
                    obj.T = newPos.b;
                }
            }
        }
    }

    // 计时器更新
    this.aW = com.corrodinggames.rts.gameFramework.GameUtils.a(this.aW, deltaTime);
    
    // 统计i类型对象数量
    int iObjectCount = 0;
    Iterator bnIterator = this.bn.iterator();
    while (bnIterator.hasNext()) {
        o obj = (o) bnIterator.next();
        if (obj instanceof BaseZone) {
            iObjectCount++;
        }
    }

    // 创建i对象的逻辑
    if (iObjectCount < 1) {
        Iterator unitIterator = com.corrodinggames.rts.game.units.BaseUnit.bE.iterator();
        BaseZone newIObject = null;
        
        // 尝试从y类型单位创建
        while (unitIterator.hasNext()) {
            BaseUnit unit = (BaseUnit) unitIterator.next();
            if (unit.bX == this && unit instanceof com.corrodinggames.rts.game.units.y) {
                newIObject = new BaseZone(this, unit.posX, unit.posY);
                newIObject.U = 420.0F;
                newIObject.b = com.corrodinggames.rts.game.a.BaseZoneStage.Active;
                newIObject.c = com.corrodinggames.rts.game.a.BaseZoneType.Main;
                iObjectCount++;
                break;
            }
        }

        // 尝试从符合bz条件的单位创建
        if (iObjectCount < 1) {
            unitIterator = com.corrodinggames.rts.game.units.BaseUnit.bE.iterator();
            while (unitIterator.hasNext()) {
                BaseUnit unit = (BaseUnit) unitIterator.next();
                if (unit.bX == this && this.bz.b(unit.r())) {
                    newIObject = new BaseZone(this, unit.posX, unit.posY);
                    newIObject.U = 420.0F;
                    newIObject.b = com.corrodinggames.rts.game.a.BaseZoneStage.Active;
                    newIObject.c = com.corrodinggames.rts.game.a.BaseZoneType.Main;
                    iObjectCount++;
                    break;
                }
            }
        }

        // 尝试从符合特定条件的y类型单位创建
        if (iObjectCount < 1) {
            unitIterator = com.corrodinggames.rts.game.units.BaseUnit.bE.iterator();
            while (unitIterator.hasNext()) {
                BaseUnit unit = (BaseUnit) unitIterator.next();
                if (unit.bX == this && unit instanceof com.corrodinggames.rts.game.units.y) {
                    com.corrodinggames.rts.game.units.y yUnit = (com.corrodinggames.rts.game.units.y) unit;
                    boolean hasRequiredTech = false;
                    Iterator techIterator = this.bz.c.iterator();
                    
                    while (techIterator.hasNext()) {
                        com.corrodinggames.rts.game.a.e tech = (com.corrodinggames.rts.game.a.e) techIterator.next();
                        if (yUnit.b(tech.a, true)) {
                            hasRequiredTech = true;
                            break;
                        }
                    }
                    
                    if (hasRequiredTech) {
                        newIObject = new BaseZone(this, unit.posX, unit.posY);
                        newIObject.U = 420.0F;
                        newIObject.b = com.corrodinggames.rts.game.a.BaseZoneStage.Active;
                        newIObject.c = com.corrodinggames.rts.game.a.BaseZoneType.Main;
                        iObjectCount++;
                        break;
                    }
                }
            }
        }

        // 尝试从ai为true的y类型单位创建
        if (iObjectCount < 1) {
            unitIterator = com.corrodinggames.rts.game.units.BaseUnit.bE.iterator();
            while (unitIterator.hasNext()) {
                BaseUnit unit = (BaseUnit) unitIterator.next();
                if (unit.bX == this && unit instanceof com.corrodinggames.rts.game.units.y) {
                    com.corrodinggames.rts.game.units.y yUnit = (com.corrodinggames.rts.game.units.y) unit;
                    if (yUnit.ai()) {
                        newIObject = new BaseZone(this, unit.posX, unit.posY);
                        newIObject.U = 420.0F;
                        newIObject.b = com.corrodinggames.rts.game.a.BaseZoneStage.Active;
                        newIObject.c = com.corrodinggames.rts.game.a.BaseZoneType.Main;
                        iObjectCount++;
                        break;
                    }
                }
            }
        }

        // 首次运行时的特殊处理
        if (!this.bf) {
            this.bf = true;
            int buildingCount = this.a(this.bB, com.corrodinggames.rts.game.a.b.a);
            if (buildingCount >= 1) {
                for (int i = 0; i < framework.bL.A.size(); i++) {
                    Point point = (Point) framework.bL.A.get(i);
                    framework.bL.a(point.x, point.b);
                    this.bo.a((float) framework.bL.T, (float) framework.bL.U);
                    PointF position = this.bo;
                    position.b += (float) framework.bL.o;
                    
                    if (this.b(position.x, position.b) == null && 
                        this.a((UnitBuildStrategy) this.bB, position.x, position.b, 200) >= 1 && 
                        this.b(position)) {
                        BaseZone baseObject = new BaseZone(this, position.x, position.b);
                        baseObject.U = 360.0F;
                        baseObject.b = com.corrodinggames.rts.game.a.BaseZoneStage.Pre;
                        baseObject.c = com.corrodinggames.rts.game.a.BaseZoneType.ResourceOutpost;
                    }
                }
            }
        }
    }

    // 单位行为处理
    BaseUnit[] allUnits = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
    int totalUnits = com.corrodinggames.rts.game.units.BaseUnit.bE.size();

    // 第一轮单位处理 - 路径查找
    for (int i = 0; i < totalUnits; i++) {
        BaseUnit unit = allUnits[i];
        if (unit.bX == this && unit.cN == null && unit instanceof com.corrodinggames.rts.game.units.y && 
            unit.aj() && this.i(unit)) {
            com.corrodinggames.rts.game.units.y yUnit = (com.corrodinggames.rts.game.units.y) unit;
            BaseZone targetAI = this.e((BaseUnit)yUnit);
            
            if (targetAI != null) {
                if (yUnit.aq()) {
                    // 空操作 - 保留原始逻辑
                }
            } else if (yUnit.aq()) {
                BaseZone fallbackAI = this.f(yUnit);
                if (fallbackAI != null) {
                    PointF targetPos = fallbackAI.w();
                    com.corrodinggames.rts.gameFramework.GameCommand effect = framework.cf.a(this);
                    effect.a(yUnit);
                    effect.a(targetPos.x, targetPos.b);
                }
            }
        }
    }

    // 第二轮单位处理 - 特殊行为
    for (int i = 0; i < totalUnits; i++) {
        BaseUnit unit = allUnits[i];
        if (unit.bX == this && unit instanceof com.corrodinggames.rts.game.units.y) {
            com.corrodinggames.rts.game.units.y yUnit = (com.corrodinggames.rts.game.units.y) unit;
            
            // 长时间闲置单位处理
            if (yUnit.V > 2400.0F && this.i(yUnit)) {
                if (yUnit.aN && yUnit.V < 24000.0F) {
                    continue;
                }
                com.corrodinggames.rts.gameFramework.GameCommand effect = framework.cf.a(this);
                effect.a(yUnit);
                effect.h();
            }

            // 攻击行为处理
            if (yUnit.aj() && this.i(yUnit)) {
                UnitCommand attackTarget = yUnit.ar();
                if (attackTarget != null && attackTarget.d() == com.corrodinggames.rts.game.units.UnitCommandType.build && 
                    yUnit.V > 700.0F) {
                    com.corrodinggames.rts.gameFramework.GameCommand effect = framework.cf.a(this);
                    effect.a(yUnit);
                    effect.h();
                }
            }
        }
    }

    // AI策略管理
    if (!this.U) {
        this.ak();
        int strategyLevel = 1;
        boolean hasSpecialCondition = this.af();
        boolean canCreateNew = true;
        
        if (hasSpecialCondition) {
            strategyLevel++;
            canCreateNew = false;
        }

        if (this.ay > 6) {
            strategyLevel = 2;
        }
        if (this.ay > 11) {
            strategyLevel = 3;
        }

        // 创建不同类型的g对象
        if (this.aC < strategyLevel) {
            UnitGroup newG = new UnitGroup(this, false);
            newG.A = 8;
            if (this.ac()) {
                newG.A = 10;
            }
            newG.k();
            this.av++;
        }

        if ((this.aD >= strategyLevel || this.aE > 6) && this.aA < 1 && canCreateNew) {
            UnitGroup newG = new UnitGroup(this, true);
            if (this.au < 2) {
                newG.A = 3;
            } else if (this.au < 5) {
                newG.A = 5;
            } else {
                newG.A = 7;
                if (this.ac()) {
                    if (this.au < 25) {
                        newG.A = 14;
                    } else {
                        newG.A = 18;
                    }
                }
            }
            newG.k();
            this.au++;
        }

        if (this.ah() && this.aB < 1 && canCreateNew) {
            UnitGroup newG = new UnitGroup(this, true);
            newG.B = true;
            newG.A = 5;
            if (this.ac()) {
                newG.A = 10;
            }
            newG.k();
        }

        if (this.ai() && this.aF < 3) {
            com.corrodinggames.rts.game.a.TransporterGroup specialObject = new com.corrodinggames.rts.game.a.TransporterGroup(this);
            specialObject.l = 1;
            specialObject.f();
        }
    }

    // U状态的特殊处理
    if (this.U) {
        if (this.aW > 30.0F) {
            this.aW = 30.0F;
        }

        if (this.aW == 0.0F) {
            this.aV++;
            if (this.aV == 1) {
                this.aW = 1000.0F;
            } else if (this.aV == 2) {
                this.aW = 3000.0F;
                BaseUnit targetUnit = this.as();
                if (targetUnit != null) {
                    int maxUnitsToSend = this.U ? 0 : 2;
                    if (this.ba < 4) {
                        maxUnitsToSend = 5;
                    }

                    com.corrodinggames.rts.gameFramework.GameCommand effect = framework.cf.a(this);
                    int unitsSent = 0;

                    for (int i = 0; i < com.corrodinggames.rts.game.units.BaseUnit.bE.size(); i++) {
                        BaseUnit unit = allUnits[i];
                        if (unit.bX == this && unit instanceof com.corrodinggames.rts.game.units.y) {
                            com.corrodinggames.rts.game.units.y yUnit = (com.corrodinggames.rts.game.units.y) unit;
                            if (!yUnit.bM && this.b(yUnit, targetUnit)) {
                                if (maxUnitsToSend <= 0) {
                                    effect.a(yUnit);
                                } else {
                                    maxUnitsToSend--;
                                    unitsSent++;
                                }
                            }
                        }
                    }
                    effect.b(targetUnit.posX, targetUnit.posY);
                }
            } else {
                this.aV = 0;
            }
        }
    }
}
    public boolean i(BaseUnit am2) {
        if (am2.u() || am2.t()) {
            return false;
        }
        if (am2.cW()) {
            return false;
        }
        return !am2.bN;
    }

    public BaseUnit ar() {
        int n2;
        BaseUnit am2 = null;
        int n3 = 0;
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n4 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (n2 = 0; n2 < n4; ++n2) {
            BaseUnit am3 = amArray[n2];
            if (am3.bV || am3.cN != null || this != am3.bX || !this.h(am3))
                continue;
            ++n3;
        }
        n2 = (int) (Math.random() * (double) n3);
        n4 = 0;
        for (BaseUnit am4 : ((List<BaseUnit>)com.corrodinggames.rts.game.units.BaseUnit.bE)) {
            if (am4.bV || am4.cN != null || this != am4.bX || !this.h(am4))
                continue;
            if (n4 == n2) {
                am2 = am4;
                break;
            }
            ++n4;
        }
        return am2;
    }

    public BaseUnit as() {
        int n2;
        BaseUnit am2 = null;
        int n3 = 0;
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n4 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (n2 = 0; n2 < n4; ++n2) {
            BaseUnit am3 = amArray[n2];
            if (am3.bV || am3.cN != null || am3.u() || !this.c(am3.bX) || !this.j(am3))
                continue;
            ++n3;
        }
        n2 = (int) (Math.random() * (double) n3);
        n4 = 0;
        for (BaseUnit am4 : ((List<BaseUnit>)com.corrodinggames.rts.game.units.BaseUnit.bE)) {
            if (am4.bV || am4.cN != null || am4.u() || !this.c(am4.bX) || !this.j(am4))
                continue;
            if (n4 == n2) {
                am2 = am4;
                break;
            }
            ++n4;
        }
        return am2;
    }

    public PointF at() {
        int n2;
        BaseUnit am2 = null;
        int n3 = 0;
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n4 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (n2 = 0; n2 < n4; ++n2) {
            BaseUnit am3 = amArray[n2];
            if (am3.bV || am3.cN != null || am3.u() || !this.c(am3.bX) || !this.j(am3))
                continue;
            ++n3;
        }
        n2 = (int) (Math.random() * (double) n3);
        n4 = 0;
        for (BaseUnit am4 : ((List<BaseUnit>)com.corrodinggames.rts.game.units.BaseUnit.bE)) {
            if (am4.bV || am4.cN != null || am4.u() || !this.c(am4.bX) || !this.j(am4))
                continue;
            if (n4 == n2) {
                am2 = am4;
                break;
            }
            ++n4;
        }
        if (am2 != null) {
            return new PointF(am2.posX, am2.posY);
        }
        return null;
    }

    public static BaseUnit a(PlayerTeam n2, float f2, float f3, float f4) {
        float f5 = f4;
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n3 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            BaseUnit am2 = amArray[i2];
            if (!(am2.posX + f5 > f2) || !(am2.posX - f5 < f2) || !(am2.posY + f5 > f3) || !(am2.posY - f5 < f3) || am2.bX == n2
                    || !com.corrodinggames.rts.game.a.AIController.a(am2, f2, f3, f4) || !am2.bX.c(n2))
                continue;
            return am2;
        }
        return null;
    }

    public static int a(PlayerTeam n2, float f2, float f3, float f4, boolean bl2) {
        int n3 = 0;
        float f5 = f4;
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n4 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (int i2 = 0; i2 < n4; ++i2) {
            BaseUnit am2 = amArray[i2];
            if (!(am2.posX + f5 > f2) || !(am2.posX - f5 < f2) || !(am2.posY + f5 > f3) || !(am2.posY - f5 < f3) || am2.bX == n2
                    || !AIController.a(am2, f2, f3, f4) || !am2.bX.d(n2) || bl2 && !am2.bI())
                continue;
            ++n3;
        }
        return n3;
    }

    public static int b(PlayerTeam n2, float f2, float f3, float f4) {
        int n3 = 0;
        float f5 = f4;
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n4 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (int i2 = 0; i2 < n4; ++i2) {
            BaseUnit am2 = amArray[i2];
            if (!(am2.posX + f5 > f2) || !(am2.posX - f5 < f2) || !(am2.posY + f5 > f3) || !(am2.posY - f5 < f3) || am2.bX == n2
                    || !AIController.a(am2, f2, f3, f4) || !am2.bX.c(n2))
                continue;
            ++n3;
        }
        return n3;
    }

    public int a(UnitBuildStrategy d2, float f2, float f3, int n2) {
        int n3 = 0;
        for (e e2 : d2.c) {
            n3 += this.a(e2.a, f2, f3, n2);
        }
        return n3;
    }

    public int a(UnitType as2, float f2, float f3, int n2) {
        int n3 = 0;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        bI.clear();
        l2.cc.a(this, f2, f3, (float) n2, bI);
        BaseUnit[] amArray = bI.a();
        int n4 = bI.size();
        for (int i2 = 0; i2 < n4; ++i2) {
            BaseUnit am2 = amArray[i2];
            if (am2.bX != this || am2.dz != as2 || !AIController.a(am2, f2, f3, (float) n2))
                continue;
            ++n3;
        }
        return n3;
    }

    public int au() {
        int n2 = 0;
        BaseUnit[] amArray = com.corrodinggames.rts.game.units.BaseUnit.bE.a();
        int n3 = com.corrodinggames.rts.game.units.BaseUnit.bE.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            BaseUnit am2 = amArray[i2];
            ++n2;
        }
        return n2;
    }

    @Override
    public void T() {
        if (this.aZ && this.au() != 0) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("waking up AI");
            this.aZ = false;
        }
    }

    @Override
    public void d(BaseUnit am2) {
        if (!(am2 instanceof y)) {
            return;
        }
        y y2 = (y) am2;
        y2.bD = false;
        if (y2.aC != null) {
            y2.aC.a(y2);
            y2.aC = null;
        }
        if (y2.aB != null) {
            y2.aB.b(y2);
            y2.aB = null;
        }
        this.e(y2);
    }

    public void a(y y2, com.corrodinggames.rts.game.units.custom.d.b b2, boolean bl2) {
        if (y2.aC != null) {
            y2.aC.a(y2, b2, bl2);
        }
    }

    public boolean j(BaseUnit am2) {
        return am2.cg() || !this.c(am2.bX);
    }

    public boolean a(com.corrodinggames.rts.game.units.custom.d.b b2, BaseUnit am2) {
        return this.a(b2, am2, false);
    }

    public boolean a(com.corrodinggames.rts.game.units.custom.d.b b2, BaseUnit am2, boolean bl2) {
        return b2.b(am2);
    }

    public void a(com.corrodinggames.rts.game.a.a.AIBehavior a2) {
        if (!this.bJ.contains(a2)) {
            this.bJ.add(a2);
        } else {
            this.c("Skipping add of component: " + a2.a().name());
        }
    }

    public static /* synthetic */ boolean a(AIController a2, UnitType as2) {
        return a2.a(as2);
    }

    static {
        bK = new ArrayList();
        bI = new UnitList();
    }
}
