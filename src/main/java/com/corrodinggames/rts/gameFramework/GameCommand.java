/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a_f;
import com.corrodinggames.rts.game.units.a.PingMapAction;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitCommand;
import com.corrodinggames.rts.game.units.UnitCommandType;
import com.corrodinggames.rts.game.units.g_f;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.ab;
import com.corrodinggames.rts.gameFramework.CommandQueue;
import com.corrodinggames.rts.gameFramework.MoveOrder;
import com.corrodinggames.rts.gameFramework.f.an;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.PointF;

import com.corrodinggames.rts.gameFramework.GGameObject;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameCommand {
    public boolean a;
    public String b;
    public int c;
    public int d;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public PlayerTeam i;
    public UnitCommand j;
    public com.corrodinggames.rts.game.units.a.ActionId k = com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID;
    public PointF l;
    public BaseUnit m;
    public a_f n;
    private PointF z;
    public boolean o = false;
    public PlayerTeam p;
    public short q;
    public boolean r;
    public float s;
    public float t;
    public int u;
    private m A = new m();
    m v = new m();
    m w = new m();
    public boolean x = false;
    final /* synthetic */ CommandQueue y;

    public GameCommand(CommandQueue c2) {
        this.y = c2;
    }

    public boolean a() {
        for (Object d2 : this.w) {
            MoveOrder order = (MoveOrder) d2;
            if (order.a.a() != null)
                continue;
            return false;
        }
        return true;
    }

    public void b() {
        GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        this.x = true;
        ab ab2 = l2.bV.c();
        for (y y2 : ((List<y>) this.v)) {
            ab2.a.add(y2);
        }
        if (this.j != null) {
            float f2 = this.j.g();
            float f3 = this.j.h();
            if (this.j.d() != UnitCommandType.move && this.j.d() != UnitCommandType.attackMove && this.j.d() != UnitCommandType.attack) {
                return;
            }
            m m2 = ab2.a(f2, f3, this.j.j);
            for (y y3 : ((List<y>) m2)) {
                if (y3.aK() || !y3.I() || this.e && y3.ar() != null)
                    continue;
                float f4 = f2;
                float f5 = f3;
                int n2 = 0;
                if (this.j.d() == UnitCommandType.attack) {
                    n2 = y3.q(this.j.i());
                }
                boolean bl2 = true;
                MoveOrder d2 = new MoveOrder();
                d2.b = y3.objectId;
                d2.c = y3.posX;
                d2.d = y3.posY;
                d2.e = f4;
                d2.f = f5;
                d2.g = l2.bx;
                d2.h = y3.h();
                boolean bl3 = false;
                boolean bl4 = false;
                d2.a = y3.a(f4, f5, n2, bl2, bl3, bl4);
                d2.a.s = d2.a.t = 120.0f;
                d2.a.u = true;
                this.w.add(d2);
            }
        }
    }

    public PlayerTeam c() {
        return this.i;
    }

    public int d() {
        return this.A.size() + this.v.size();
    }

    public boolean e() {
        if (com.corrodinggames.rts.game.units.a.AbstractUnitAction.c(this.k)) {
            return false;
        }
        return this.d() == 0;
    }

    public synchronized GameCommand f() {
        try {
            GameOutputStream as2 = new GameOutputStream();
            this.a(as2);
            GameInputStream k2 = new GameInputStream(as2.d());
            GameCommand e2 = new GameCommand(this.y);
            e2.c = this.c;
            e2.a(k2);
            return e2;
        } catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public void g() {
        if (this.j != null) {
            for (y y2 : ((List<y>) this.v)) {
                this.A.add((Object) y2.objectId);
            }
            this.v.clear();
            this.j.k();
        }
    }

    public synchronized void a(GameOutputStream as2) throws IOException {
        as2.e("c");
        as2.c(this.i.k);
        as2.a(this.j != null);
        if (this.j != null) {
            this.j.a(as2);
        }
        as2.a(this.e);
        as2.a(this.g);
        as2.a(-1);
        as2.a(this.n);
        as2.a(this.z != null);
        if (this.z != null) {
            as2.a(this.z.x);
            as2.a(this.z.b);
        }
        as2.a(this.o);
        as2.a(this.v.size() + this.A.size());
        for (y y2 : ((List<y>) this.v)) {
            as2.a(y2.objectId);
        }
        Iterator iterator = this.A.iterator();
        while (iterator.hasNext()) {
            long l2 = (Long) iterator.next();
            as2.a(l2);
        }
        as2.a(this.p != null);
        if (this.p != null) {
            as2.a(this.p);
        }
        as2.a(this.l != null);
        if (this.l != null) {
            as2.a(this.l.x);
            as2.a(this.l.b);
        }
        as2.a(this.m);
        as2.writeUTF(this.k.getId());
        as2.a(this.f);
        as2.a(this.q);
        as2.a(this.r);
        if (this.r) {
            as2.c(0);
            as2.a(this.s);
            as2.a(this.t);
            as2.a(this.u);
        }
        as2.a(this.w.size());
        for (int i2 = 0; i2 < this.w.size(); ++i2) {
            MoveOrder d2 = (MoveOrder) this.w.get(i2);
            d2.a(as2);
        }
        as2.a(this.h);
        as2.a("c");
    }

    public void a(GameInputStream k2) throws IOException {
        int n2;
        k2.b("c");
        this.i = com.corrodinggames.rts.game.PlayerTeam.k(k2.d());
        if (this.i == null) {
            throw new IOException("team==null");
        }
        boolean bl2 = k2.e();
        if (bl2) {
            this.j = new UnitCommand();
            this.j.a(k2);
        }
        this.e = k2.e();
        this.g = k2.e();
        this.k = com.corrodinggames.rts.game.units.a.ActionId.isSameInstance(String.valueOf(k2.readInt()));
        this.n = (a_f) k2.b(a_f.class);
        boolean bl3 = k2.e();
        if (bl3) {
            this.z = new PointF();
            this.z.x = k2.g();
            this.z.b = k2.g();
        }
        this.o = k2.e();
        int n3 = k2.readInt();
        for (n2 = 0; n2 < n3; ++n2) {
            this.A.add((Object) k2.n());
        }
        if (k2.b() >= 16) {
            this.p = null;
            if (k2.e()) {
                this.p = k2.s();
            }
        }
        if (k2.b() >= 29) {
            n2 = k2.e() ? 1 : 0;
            if (n2 != 0) {
                this.l = new PointF();
                this.l.x = k2.g();
                this.l.b = k2.g();
            }
            this.m = k2.o();
        }
        if (k2.b() >= 33) {
            this.k = com.corrodinggames.rts.game.units.a.ActionId.isSameInstance(k2.l());
        }
        if (k2.b() >= 37) {
            this.f = k2.e();
        }
        if (k2.b() >= 52) {
            this.q = k2.v();
        }
        if (k2.b() >= 53) {
            this.r = k2.e();
            if (this.r) {
                k2.d();
                this.s = k2.g();
                this.t = k2.g();
                this.u = k2.readInt();
            }
            n2 = k2.readInt();
            this.w.clear();
            for (int i2 = 0; i2 < n2; ++i2) {
                MoveOrder d2 = new MoveOrder();
                d2.a(k2);
                this.w.add(d2);
            }
        }
        if (k2.b() >= 80) {
            this.h = k2.e();
        }
        k2.d("c");
    }

    public void a(AbstractList<y> abstractList) {
        for (y y2 : abstractList) {
            this.a(y2);
        }
    }

    public void a(y y2) {
        if (y2 == null) {
            throw new RuntimeException("unit cannot be null");
        }
        if (y2.bX != this.i) {
            // empty if block
        }
        if (this.i.w) {
            if (y2.bX != this.i && com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bs != this.i) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("CommandController", "Warning AI: " + this.i.k
                        + " gave an order to unit with team:" + y2.bX.k + " type:" + y2.r().i());
                com.corrodinggames.rts.gameFramework.GameEngine.g("");
            }
            if (y2.cW()) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("CommandController", "Warning AI: " + this.i.k
                        + " gave an order to unit with canNotBeGivenOrdersByPlayer: " + y2.r().i());
            }
        }
        this.v.add(y2);
    }

    public void h() {
        this.o = true;
    }

    public void a(float f2, float f3) {
        this.j = new UnitCommand();
        this.j.a(f2, f3);
    }

    public void b(float f2, float f3) {
        this.j = new UnitCommand();
        this.j.b(f2, f3);
    }

    public void a(BaseUnit am2) {
        this.j = new UnitCommand();
        this.j.a(am2);
    }

    public void a(float f2, float f3, boolean bl2) {
        this.j = new UnitCommand();
        this.j.b(f2, f3);
        this.j.j = bl2;
    }

    public void a(BaseUnit am2, boolean bl2) {
        this.j = new UnitCommand();
        this.j.a(am2);
        this.j.j = bl2;
    }

    public void a(float f2, float f3, com.corrodinggames.rts.game.units.UnitType as2, int n2) {
        this.j = new UnitCommand();
        this.j.a(f2, f3, as2, n2);
    }

    public void b(BaseUnit am2) {
        this.j = new UnitCommand();
        this.j.b(am2);
    }

    public void c(BaseUnit am2) {
        this.j = new UnitCommand();
        this.j.c(am2);
    }

    public void c(float f2, float f3) {
        this.j = new UnitCommand();
        this.j.c(f2, f3);
    }

    public void d(BaseUnit am2) {
        this.j = new UnitCommand();
        this.j.f(am2);
    }

    public void e(BaseUnit am2) {
        this.j = new UnitCommand();
        this.j.g(am2);
    }

    public void f(BaseUnit am2) {
        this.j = new UnitCommand();
        this.j.h(am2);
    }

    public void a(com.corrodinggames.rts.game.units.a.ActionId c2) {
        this.k = c2;
    }

    public void a(com.corrodinggames.rts.game.units.a.ActionId c2, PointF pointF, BaseUnit am2) {
        this.k = c2;
        this.l = pointF;
        this.m = am2;
    }

    public void a(a_f a2) {
        this.n = a2;
    }

    public void a(PointF pointF) {
        this.z = pointF;
    }

    public synchronized void i() {
        for (Object object : this.A) {
            y y2 = com.corrodinggames.rts.gameFramework.GGameObject.b((Long) object, true);
            if (y2 == null)
                continue;
            this.v.add(y2);
        }
        this.A.clear();
        Iterator iterator = this.v.iterator();
        while (iterator.hasNext()) {
            Object object;
            object = (y) iterator.next();
            if (!((y) object).bV)
                continue;
            iterator.remove();
        }
    }

    public void j() {
        if (com.corrodinggames.rts.game.units.a.AbstractUnitAction.c(this.k)) {
            for (y y2 : ((List<y>) this.v)) {
                y2.b(y2.a(this.k), this.g);
            }
        }
    }

    public void k() throws IOException {
        Object object;
        Object object2;
        Object object3;
        GameEngine l2 = GameEngine.getInstance();
        if (l2.cb.j() && !this.a) {
            return;
        }
        this.i();
        if (this.r) {
            if (this.s != 0.0f) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("issueCommand: changeStepRate:" + this.s);
                l2.networkEngine.a(this.s, "command");
                return;
            }
            if (this.u != 0) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("system action:" + this.u);
                if (this.u == 1) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("new DebugDesyncDetector");
                    g_f g2 = new g_f(false);
                    ((BaseUnit) g2).b(com.corrodinggames.rts.game.PlayerTeam.i);
                    return;
                }
                if (this.u == 2) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("new DebugDesyncDetector (stress test)");
                    g_f g3 = new g_f(false);
                    g3.b(com.corrodinggames.rts.game.PlayerTeam.i);
                    g3.a = true;
                    return;
                }
                if (this.u == 100) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("team surrender");
                    if (this.i == null) {
                        com.corrodinggames.rts.gameFramework.GameEngine.log("team not found");
                        return;
                    }
                    if (l2.networkEngine.C) {
                        l2.networkEngine.j("'" + this.i.v + "' has surrendered");
                    }
                    this.i.E = true;
                    for (BaseUnit am2 : ((List<BaseUnit>) BaseUnit.bE)) {
                        if (am2.bX != this.i || !(am2 instanceof y))
                            continue;
                        y y2 = (y) am2;
                        y2.c(false);
                    }
                    return;
                }
                if (this.u == 200) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("queue quick resync");
                    l2.networkEngine.N = true;
                    return;
                }
                if (this.u == 5) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("system command spawn");
                    if (this.j == null || this.j.d() != UnitCommandType.build || this.j.a() == null) {
                        com.corrodinggames.rts.gameFramework.GameEngine.log("system command spawn - failed");
                        return;
                    }
                    int n2 = this.j.b();
                    com.corrodinggames.rts.game.units.UnitType as2 = this.j.a();
                    boolean bl2 = false;
                    if (this.i != null && this.i == l2.bs && l2.bs.a(false, false) == 0) {
                        bl2 = true;
                    }
                    BaseUnit am3 = as2.createUnitInstance();
                    am3.posX = this.j.g();
                    am3.posY = this.j.h();
                    if (this.i != null) {
                        am3.f(this.i);
                    } else {
                        am3.f(com.corrodinggames.rts.game.PlayerTeam.i);
                    }
                    am3.B(null);
                    if (n2 != 1 && am3 instanceof y) {
                        ((y) am3).a(n2);
                    }
                    am3.cP();
                    if (am3 instanceof y) {
                        y y3 = (y) am3;
                        y3.br();
                        if (am3.bI()) {
                            l2.bU.a(y3);
                        }
                    }
                    com.corrodinggames.rts.game.PlayerTeam.c(am3);
                    if (l2.bs == am3.bX && am3.bX != com.corrodinggames.rts.game.PlayerTeam.i && !am3.u() && bl2) {
                        l2.b(am3.posX, am3.posY);
                        l2.bS.j(am3);
                    }
                    return;
                }
                com.corrodinggames.rts.gameFramework.GameEngine.log("issueCommand: unknown system action:" + this.u);
                return;
            }
            com.corrodinggames.rts.gameFramework.GameEngine.log("issueCommand: Null System action");
            return;
        }
        if (this.p != null) {
            this.p.Y = System.currentTimeMillis();
            this.p.Z = l2.by;
        }
        if (this.p != null) {
            object3 = null;
            Object object4 = null;
            object2 = this.v.iterator();
            while (((Iterator) object2).hasNext()) {
                object = (y) ((Iterator) object2).next();
                if (((y) object).bX != this.p && !this.a(this.p, ((y) object).bX)) {
                    object3 = object3 == null ? "" : (String) object3 + ", ";
                    if (object4 == null) {
                        object4 = object;
                    }
                    object3 = (String) object3 + ((y) object).objectId;
                    ((Iterator) object2).remove();
                    continue;
                }
                if (!((BaseUnit) object).cW())
                    continue;
                com.corrodinggames.rts.gameFramework.CommandQueue
                        .a("Warning unit: " + ((y) object).objectId + " has canNotBeGivenOrdersByPlayer set");
                ((Iterator) object2).remove();
            }
            if (object3 != null) {
                NetworkEngine.a("Player(" + this.p.k + ") " + this.p.v + " cannot control units: " + (String) object3, true);
                if (object4 != null) {
                    object = "";
                    if (((BaseUnit) object4).bX != null) {
                        object = (String) object + " targetUnitTeamId: " + ((BaseUnit) object4).bX.k + " targetUnitTeamName: "
                                + ((BaseUnit) object4).bX.v;
                    }
                    com.corrodinggames.rts.gameFramework.CommandQueue.a((String) object);
                }
            }
        }
        if (this.o) {
            for (Object object4 : ((List<y>) this.v)) {
                ((y) object4).az();
                ((y) object4).R = null;
            }
        }
        if (this.j != null) {
            this.j.c();
            object3 = l2.bV.b();
            ((ab) object3).g = this.w;
            for (int i2 = 0; i2 <= 1; ++i2) {
                boolean bl3 = i2 == 1;
                for (y y4 : ((List<y>) this.v)) {
                    UnitCommand au2;
                    if (y4.ae != bl3)
                        continue;
                    if (this.f) {
                        y4.aA();
                        continue;
                    }
                    if (!this.e) {
                        y4.az();
                        continue;
                    }
                    if (!this.h || this.j == null || (au2 = y4.at()) == null || !this.j.a(au2)
                            || au2.d() != UnitCommandType.attackMove && au2.d() != UnitCommandType.move || this.j.d() != UnitCommandType.attackMove && this.j.d() != UnitCommandType.move)
                        continue;
                    y4.au();
                }
            }
            for (y y5 : ((List<y>) this.v)) {
                if (!y5.a(this.j, com.corrodinggames.rts.gameFramework.CommandQueue.e < 5)) {
                    object = "";
                    if (this.p != null) {
                        object = "Player(" + this.p.k + ") " + this.p.v + ": ";
                    }
                    com.corrodinggames.rts.gameFramework.CommandQueue
                            .a((String) object + "isValidNewWaypoint==false on: " + y5.c());
                    continue;
                }
                object = y5.d(this.j);
                ((ab) object3).a(y5, (UnitCommand) object);
                y5.a((UnitCommand) object);
            }
            ((ab) object3).b();
            return;
        }
        if (com.corrodinggames.rts.game.units.a.AbstractUnitAction.c(this.k)) {
            for (Object object4 : ((List<y>) this.v)) {
                object2 = ((BaseUnit) object4).a(this.k);
                if (object2 == null) {
                    com.corrodinggames.rts.gameFramework.CommandQueue
                            .a("Could not find specialAction:" + this.k.getId() + " on " + ((BaseUnit) object4).r().i());
                    continue;
                }
                if (!((AbstractUnitAction) object2).b((BaseUnit) object4)) {
                    com.corrodinggames.rts.gameFramework.CommandQueue.a("!isAvailable specialAction:" + this.k.getId()
                            + " on " + ((BaseUnit) object4).r().i() + " (action being skipped)");
                    if (!com.corrodinggames.rts.gameFramework.CommandQueue.a)
                        continue;
                    com.corrodinggames.rts.gameFramework.CommandQueue.a("Command source:" + this.b);
                    continue;
                }
                ((BaseUnit) object4).a((AbstractUnitAction) object2);
                an.a((y) object4, (AbstractUnitAction) object2);
                ((BaseUnit) object4).a((AbstractUnitAction) object2, this.g, this.l, this.m);
            }
            object3 = com.corrodinggames.rts.game.units.a.PingMapAction.a(this.k);
            if (object3 != null) {
                if (l2.bs != null && this.i != null) {
                    if (this.i.d(l2.bs)) {
                        l2.bS.a(this.l.x, this.l.b, this.i, (PingMapAction) object3);
                    }
                } else {
                    com.corrodinggames.rts.gameFramework.CommandQueue
                            .a("PingMapAction failed: game.playerTeam==null or this.team==null");
                }
            }
        }
        if (this.n != null) {
            for (Object object4 : ((List<y>) this.v)) {
                ((y) object4).P = this.n;
            }
        }
        if (this.z != null) {
            for (Object object4 : ((List<y>) this.v)) {
                if (!(object4 instanceof com.corrodinggames.rts.game.units.d.l))
                    continue;
                object2 = (com.corrodinggames.rts.game.units.d.l) object4;
                ((com.corrodinggames.rts.game.units.d.l) object2).a(this.z);
            }
        }
    }

    public boolean a(PlayerTeam n2, PlayerTeam n3) {
        if (n2 == null || n3 == null) {
            return false;
        }
        if (!n3.d(n2)) {
            return false;
        }
        return (this.q & 1 << n3.k) != 0;
    }

    public boolean l() {
        this.q = 0;

        for (int var1 = 0; var1 < com.corrodinggames.rts.game.PlayerTeam.c; ++var1) {
            PlayerTeam var2 = com.corrodinggames.rts.game.PlayerTeam.k(var1);
            if (var2 != null && var2.p()) {
                this.q = (short) (this.q | 1 << var1);
            }
        }

        GameEngine var4 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (var4.getVersionCode(true) < 127 && this.j != null && this.j.d() == UnitCommandType.build) {
            com.corrodinggames.rts.game.units.UnitType var5 = this.j.a();
            if (var5 != null) {
                BaseUnit var3 = BaseUnit.a(var5);
                if (var3 != null && !(var3 instanceof y)) {
                    com.corrodinggames.rts.gameFramework.GameEngine
                            .log("Rejecting non OrderableUnit build order: " + var5.i());
                    return false;
                }
            }
        }

        if (this.j != null && this.j.n) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Rejecting waypoint with addedByAction true");
            return false;
        } else {
            return true;
        }
    }
}
