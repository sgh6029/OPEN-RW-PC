/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import java.io.IOException;

import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.gameFramework.ab;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GGameObject;

/*
com.corrodinggames.rts.game.units.au -> com.corrodinggames.rts.game.units.UnitCommand:
    com.corrodinggames.rts.game.units.av a -> commandType
    com.corrodinggames.rts.game.units.as b -> buildUnitType
    com.corrodinggames.rts.game.units.a.c c -> actionId
    int d -> buildQueueSize
    float e -> targetX
    float f -> targetY
    long g -> targetUnitId
    com.corrodinggames.rts.game.units.am h -> targetUnit
    com.corrodinggames.rts.gameFramework.ab i -> transportTarget
    boolean j -> isQueued
    float k -> attackMoveRange
    float l -> patrolRange
    boolean m -> isRepeating
    boolean n -> isForceMove
    com.corrodinggames.rts.game.units.as a() -> getBuildUnitType
    void a(float,float) -> setMoveTarget
    void a(float,float,com.corrodinggames.rts.game.units.as,int) -> setBuildCommand
    void a(com.corrodinggames.rts.game.units.am) -> setAttackTarget
    boolean a(com.corrodinggames.rts.game.units.au) -> isApproximatelySameTarget
    void a(com.corrodinggames.rts.gameFramework.j.as) -> serialize
    void a(com.corrodinggames.rts.gameFramework.j.k) -> deserialize
    int b() -> getBuildQueueSize
    void b(float,float) -> setAttackMoveTarget
    void b(com.corrodinggames.rts.game.units.am) -> setRepairCommand
    boolean b(com.corrodinggames.rts.game.units.au) -> isSameCommand
    void c() -> resolveTargetUnitFromId
    void c(float,float) -> setPatrolPoint
    void c(com.corrodinggames.rts.game.units.am) -> setGuardCommand
    void c(com.corrodinggames.rts.game.units.au) -> copyFrom
    com.corrodinggames.rts.game.units.av d() -> getCommandType
    void d(com.corrodinggames.rts.game.units.am) -> setTouchTargetUnit
    void e() -> resetCommand
    void e(com.corrodinggames.rts.game.units.am) -> setFollowTargetUnit
    boolean f() -> isUnitTargetCommand
    void f(com.corrodinggames.rts.game.units.am) -> setReclaimTargetUnit
    float g() -> getTargetX
    void g(com.corrodinggames.rts.game.units.am) -> setLoadIntoTargetUnit
    float h() -> getTargetY
    void h(com.corrodinggames.rts.game.units.am) -> setLoadUpTargetUnit
    com.corrodinggames.rts.game.units.am i() -> getTargetUnit
    long j() -> getCommandTypeOrdinal
    void k() -> updateTargetUnitIdFromUnit
    com.corrodinggames.rts.game.units.am l() -> getResolvedTargetEntity

*/
//au.java
public final class UnitCommand {
    UnitCommandType a;
    UnitType b;
    ActionId c;
    int d;
    float e = 1.0f;
    float f = 1.0f;
    long g = -1L;
    BaseUnit h;
    public ab i;
    public boolean j;
    public float k = -1.0f;
    public float l = -1.0f;
    public boolean m;
    public boolean n;

    public boolean a(UnitCommand au2) {
        return !(com.corrodinggames.rts.gameFramework.GameUtils.c(this.e - au2.e) > 3.0f)
                && !(com.corrodinggames.rts.gameFramework.GameUtils.c(this.f - au2.f) > 3.0f);
    }

    public boolean b(UnitCommand au2) {
        if (au2 == null) {
            return false;
        }
        if (this.a != au2.a) {
            return false;
        }
        if (this.b != au2.b) {
            return false;
        }
        if (com.corrodinggames.rts.gameFramework.GameUtils.c(this.e - au2.e) > 1.0f
                || com.corrodinggames.rts.gameFramework.GameUtils.c(this.f - au2.f) > 1.0f) {
            return false;
        }
        if (this.d != au2.d) {
            return false;
        }
        return this.h == au2.h;
    }

    public UnitType a() {
        return this.b;
    }

    public int b() {
        return this.d;
    }

    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.a);
        as2.a(this.b);
        as2.a(this.e);
        as2.a(this.f);
        if (this.g != -1L) {
            as2.a(this.g);
        } else {
            as2.a(this.h);
        }
        as2.c(this.d);
        as2.a(this.k);
        as2.a(this.l);
        as2.a(this.m);
        as2.a(this.j);
        as2.a(this.n);
        com.corrodinggames.rts.game.units.a.ActionId.serialize(as2, this.c);
    }

    public void a(GameInputStream k2) throws IOException {
        this.a = (UnitCommandType) k2.b(UnitCommandType.class);
        this.b = k2.q();
        this.e = k2.g();
        this.f = k2.g();
        this.g = k2.n();
        this.h = null;
        if (k2.b() >= 40) {
            this.d = k2.d();
        }
        if (k2.b() >= 46) {
            this.k = k2.g();
            this.l = k2.g();
        }
        if (k2.b() >= 58) {
            this.m = k2.e();
        }
        if (k2.b() >= 65) {
            this.j = k2.e();
        }
        if (k2.b() >= 79) {
            this.n = k2.e();
        }
        if (k2.b() >= 82) {
            this.c = com.corrodinggames.rts.game.units.a.ActionId.deserialize(k2);
        }
    }

    public void c() {
        if (this.g != -1L) {
            this.h = GGameObject.a(this.g, true);
            if (this.h == null) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("convertUnitIds failed");
                if (this.a != null) {
                    com.corrodinggames.rts.gameFramework.GameEngine.b("convertUnitIds: type:" + this.a.toString());
                }
                if (this.b != null) {
                    com.corrodinggames.rts.gameFramework.GameEngine.b("convertUnitIds: build:" + this.b.toString());
                }
                com.corrodinggames.rts.gameFramework.GameEngine.b("convertUnitIds: x:" + this.e + ", y:" + this.f);
            }
            this.g = -1L;
        }
    }

    public UnitCommandType d() {
        return this.a;
    }

    public void e() {
        this.a = UnitCommandType.move;
        this.b = null;
        this.d = 1;
        this.e = 2.0f;
        this.f = 2.0f;
        this.g = -1L;
        this.h = null;
        this.i = null;
        this.k = -1.0f;
        this.l = -1.0f;
        this.m = false;
        this.j = false;
        this.n = false;
        this.c = null;
    }

    public boolean f() {
        return this.a == UnitCommandType.attack || this.a == UnitCommandType.repair || this.a == UnitCommandType.reclaim || this.a == UnitCommandType.loadInto
                || this.a == UnitCommandType.loadUp || this.a == UnitCommandType.guard || this.a == UnitCommandType.touchTarget || this.a == UnitCommandType.follow;
    }

    public float g() {
        if (this.f() && this.h != null) {
            return this.h.posX;
        }
        return this.e;
    }

    public float h() {
        if (this.f() && this.h != null) {
            return this.h.posY;
        }
        return this.f;
    }

    public BaseUnit i() {
        return this.h;
    }

    public void a(float f2, float f3) {
        this.e();
        this.a = UnitCommandType.move;
        this.e = f2;
        this.f = f3;
    }

    public void b(float f2, float f3) {
        this.e();
        this.a = UnitCommandType.attackMove;
        this.e = f2;
        this.f = f3;
    }

    public void a(BaseUnit am2) {
        this.e();
        this.a = UnitCommandType.attack;
        this.h = am2;
    }

    public void a(float f2, float f3, UnitType as2, int n2) {
        this.e();
        this.a = UnitCommandType.build;
        this.e = f2;
        this.f = f3;
        this.b = as2;
        this.d = n2 = (int) ((byte) n2);
    }

    public void b(BaseUnit am2) {
        this.e();
        this.a = UnitCommandType.repair;
        this.h = am2;
    }

    public void c(BaseUnit am2) {
        this.e();
        this.a = UnitCommandType.guard;
        this.h = am2;
    }

    public void d(BaseUnit am2) {
        this.e();
        this.a = UnitCommandType.touchTarget;
        this.h = am2;
    }

    public void e(BaseUnit am2) {
        this.e();
        this.a = UnitCommandType.follow;
        this.h = am2;
    }

    public void c(float f2, float f3) {
        this.e();
        this.a = UnitCommandType.patrol;
        this.e = f2;
        this.f = f3;
    }

    public void f(BaseUnit am2) {
        this.e();
        this.a = UnitCommandType.reclaim;
        this.h = am2;
    }

    public void g(BaseUnit am2) {
        this.e();
        this.a = UnitCommandType.loadInto;
        this.h = am2;
    }

    public void h(BaseUnit am2) {
        this.e();
        this.a = UnitCommandType.loadUp;
        this.h = am2;
    }

    public void c(UnitCommand au2) {
        this.e();
        this.a = au2.a;
        this.b = au2.b;
        this.e = au2.e;
        this.f = au2.f;
        this.h = au2.h;
        this.i = au2.i;
        this.d = au2.d;
        this.j = au2.j;
        this.c = au2.c;
    }

    public long j() {
        long l2 = 0L;
        if (this.a != null) {
            l2 += (long) this.a.ordinal();
        }
        return l2;
    }

    public void k() {
        if (this.h != null) {
            this.g = this.h.objectId;
            this.h = null;
        }
        this.i = null;
    }

    public BaseUnit l() {
        if (this.f()) {
            BaseUnit am2 = this.i();
            return am2;
        }
        y y2 = com.corrodinggames.rts.game.PlayerTeam.i.t;
        y2.cg = 0.0f;
        y2.posX = this.e;
        y2.posY = this.f;
        y2.posZ = 0.0f;
        return y2;
    }
}
