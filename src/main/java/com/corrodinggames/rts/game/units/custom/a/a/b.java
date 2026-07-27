/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.a.a;

import com.corrodinggames.rts.game.q;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitCommand;
import com.corrodinggames.rts.game.units.UnitCommandType;
import com.corrodinggames.rts.game.units.custom.a.a_f2;
import com.corrodinggames.rts.game.units.custom.a.d;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.u;
import com.corrodinggames.rts.game.units.custom.v;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.PointF;

import com.corrodinggames.rts.gameFramework.GGameObject;

public class b
extends a_f2 {
    public boolean a;
    public boolean b;
    public UnitCommandType c;
    public v d;
    public boolean e;
    public h f;
    public q g;
    public float h;
    public boolean i;
    public h j;
    public q k;
    public float l;
    public boolean m;
    public boolean n;
    public PointF o;
    public PointF p;
    public PointF q;
    public LogicBoolean r;
    public float s = -1.0f;
    public u t;
    public u u;
    public static UnitCommand v = new UnitCommand();
    public static final c w = new c();

    public static void a(l l2, IniFile ab2, String string2, String string3, d d2, String string4, boolean bl2) {
        boolean bl3;
        boolean bl4 = false;
        boolean bl5 = ab2.a(string2, string3 + "clearAllWaypoints", (Boolean)false);
        if (bl5) {
            bl4 = true;
        }
        if (bl3 = ab2.a(string2, string3 + "clearActiveWaypoint", (Boolean)false).booleanValue()) {
            bl4 = true;
        }
        UnitCommandType av2 = (UnitCommandType)ab2.a(string2, "addWaypoint_type", null, UnitCommandType.class);
        boolean bl6 = ab2.a(string2, string3 + "addWaypoint_prepend", (Boolean)false);
        h h2 = ab2.a(l2, string2, string3 + "addWaypoint_target_nearestUnit_tagged", (h)null);
        q q2 = (q)ab2.a(string2, "addWaypoint_target_nearestUnit_team", com.corrodinggames.rts.game.q.own, q.class);
        float f2 = ab2.a(string2, string3 + "addWaypoint_target_nearestUnit_maxRange", Float.valueOf(10000.0f)).floatValue();
        h h3 = ab2.a(l2, string2, string3 + "addWaypoint_target_randomUnit_tagged", (h)null);
        q q3 = (q)ab2.a(string2, "addWaypoint_target_randomUnit_team", com.corrodinggames.rts.game.q.own, q.class);
        float f3 = ab2.a(string2, string3 + "addWaypoint_target_randomUnit_maxRange", Float.valueOf(10000.0f)).floatValue();
        float f4 = ab2.b(string2, string3 + "addWaypoint_maxTime", Float.valueOf(-1.0f)).floatValue();
        u u2 = ab2.a(l2, string2, string3 + "addWaypoint_triggerActionIfFailed", (u)null);
        u u3 = ab2.a(l2, string2, string3 + "addWaypoint_triggerActionIfMatched", (u)null);
        PointF pointF = ab2.a(string2, string3 + "addWaypoint_position_offsetFromSelf", (PointF)null);
        PointF pointF2 = ab2.a(string2, string3 + "addWaypoint_position_relativeOffsetFromSelf", (PointF)null);
        PointF pointF3 = ab2.a(string2, string3 + "addWaypoint_position_randomOffsetFromSelf", (PointF)null);
        boolean bl7 = pointF != null || pointF2 != null || pointF3 != null;
        boolean bl8 = h2 != null;
        boolean bl9 = h3 != null;
        boolean bl10 = ab2.a(string2, string3 + "addWaypoint_position_fromAction", (Boolean)false);
        LogicBoolean logicBoolean = ab2.b(l2, string2, string3 + "addWaypoint_target_fromReference", null);
        if (logicBoolean != null) {
            bl4 = true;
            if (bl8 || bl9) {
                throw new RuntimeException("[" + string2 + "] addWaypoint_target_nearestUnit/randomUnit and addWaypoint_target_fromReference cannot be used together");
            }
            if (bl7) {
                throw new RuntimeException("[" + string2 + "] addWaypoint_position_offset* and addWaypoint_target_fromReference cannot be used together");
            }
            if (bl10) {
                throw new RuntimeException("[" + string2 + "] addWaypoint_position_fromAction and addWaypoint_target_fromReference cannot be used together");
            }
        }
        if (bl10) {
            bl4 = true;
            if (bl8 || bl9) {
                throw new RuntimeException("[" + string2 + "] addWaypoint_target_* and addWaypoint_position_fromAction cannot be used together");
            }
            if (bl7) {
                throw new RuntimeException("[" + string2 + "] addWaypoint_position_offset* and addWaypoint_position_fromAction cannot be used together");
            }
        }
        if ((bl8 || bl9 || bl7 || logicBoolean != null) && av2 == null) {
            throw new RuntimeException("[" + string2 + "] addWaypoint_type is required when using addWaypoint_*");
        }
        if (av2 != null) {
            bl4 = true;
            if (!(bl8 || bl9 || bl7 || bl10 || logicBoolean != null)) {
                throw new RuntimeException("[" + string2 + "] addWaypoint_target_nearestUnit_tagged, addWaypoint_position_offsetFromSelf or addWaypoint_target_fromReference is required when using addWaypoint_*");
            }
        }
        if (bl7) {
            bl4 = true;
            if (bl8 || bl9) {
                throw new RuntimeException("[" + string2 + "] addWaypoint_target_* and addWaypoint_position_* cannot be used together");
            }
            if (av2 != UnitCommandType.move && av2 != UnitCommandType.attackMove) {
                throw new RuntimeException("[" + string2 + "] addWaypoint_position_* only supports position based waypoints (eg: move, attackMove)");
            }
        }
        if (bl8 && bl9) {
            throw new RuntimeException("[" + string2 + "] addWaypoint_target_nearestUnit_* and addWaypoint_target_randomUnit_* cannot be used together");
        }
        if (bl4) {
            b b2 = new b();
            b2.a = bl5;
            b2.b = bl3;
            if (av2 != null) {
                b2.c = av2;
                if (b2.c == UnitCommandType.build) {
                    b2.d = l2.a(ab2.b(string2, string3 + "addWaypoint_unitType", (String)null), string3 + "addWaypoint_unitType", string2);
                    if (b2.d == null) {
                        throw new RuntimeException("[" + string2 + "] addWaypoint_type: build requires addWaypoint_unitType");
                    }
                }
                b2.e = bl6;
                b2.f = h2;
                b2.g = q2;
                b2.h = f2;
                b2.j = h3;
                b2.k = q3;
                b2.l = f3;
                if (bl9) {
                    b2.i = true;
                }
                b2.m = ab2.a(string2, string3 + "addWaypoint_target_mapMustBeReachable", (Boolean)true);
                b2.o = pointF;
                b2.p = pointF2;
                b2.q = pointF3;
                b2.n = bl10;
                b2.r = logicBoolean;
                b2.s = f4;
                b2.t = u2;
                b2.u = u3;
            }
            d2.ac.add(b2);
        }
    }

    public UnitCommand a(j j2, float f2, float f3, BaseUnit am2, int n2) {
        UnitCommand au2;
        if (this.s == 0.0f) {
            au2 = v;
            au2.e();
        } else if (this.e) {
            au2 = j2.ao();
            j2.aD();
            j2.aB();
        } else {
            au2 = j2.ap();
        }
        if (this.c == UnitCommandType.move) {
            au2.a(f2, f3);
        } else if (this.c == UnitCommandType.attackMove) {
            au2.b(f2, f3);
        } else if (this.c == UnitCommandType.guard && am2 != null) {
            au2.c(am2);
        } else if (this.c == UnitCommandType.follow && am2 != null) {
            au2.e(am2);
        } else if (this.c == UnitCommandType.loadInto && am2 != null) {
            au2.g(am2);
        } else if (this.c == UnitCommandType.loadUp && am2 != null) {
            au2.h(am2);
        } else if (this.c == UnitCommandType.attack && am2 != null) {
            au2.a(am2);
        } else if (this.c == UnitCommandType.reclaim && am2 != null) {
            au2.f(am2);
        } else if (this.c == UnitCommandType.repair && am2 != null) {
            au2.b(am2);
        } else if (this.c == UnitCommandType.touchTarget && am2 != null) {
            au2.d(am2);
        } else if (this.c == UnitCommandType.build) {
            au2.a(f2, f3, this.d.c(), 1);
        } else {
            j2.ay();
        }
        au2.l = this.s;
        au2.n = true;
        if (this.u != null) {
            PointF pointF = new PointF(au2.g(), au2.h());
            this.u.a(j2, pointF, au2.i(), n2 + 1, 0);
        }
        return au2;
    }

    @Override
    public boolean a(j j2, AbstractUnitAction s2, PointF pointF, BaseUnit am2, int n2) {
        if (this.a) {
            j2.az();
        } else if (this.b) {
            j2.ay();
        }
        if (this.c != null) {
            if (this.r != null) {
                BaseUnit am3 = this.r.readUnit(j2);
                if (am3 != null) {
                    this.a(j2, am3.posX, am3.posY, am3, n2);
                } else if (this.t != null) {
                    this.t.a(j2, pointF, am2, n2 + 1, 0);
                }
            } else if (this.n) {
                if (pointF == null) {
                    if (this.t != null) {
                        this.t.a(j2, pointF, am2, n2 + 1, 0);
                    }
                } else {
                    this.a(j2, pointF.x, pointF.b, null, n2);
                }
            } else if (this.o != null || this.p != null || this.q != null) {
                float f2 = j2.posX;
                float f3 = j2.posY;
                if (this.o != null) {
                    f2 += this.o.x;
                    f3 += this.o.b;
                }
                if (this.p != null) {
                    float f4 = this.p.x;
                    float f5 = this.p.b;
                    float f6 = com.corrodinggames.rts.gameFramework.GameUtils.k(j2.cg);
                    float f7 = com.corrodinggames.rts.gameFramework.GameUtils.j(j2.cg);
                    float f8 = f6 * f5 - f7 * f4;
                    float f9 = f7 * f5 + f6 * f4;
                    f2 += f8;
                    f3 += f9;
                }
                if (this.q != null) {
                    int n3 = n2;
                    f2 += (float)com.corrodinggames.rts.gameFramework.GameUtils.a((GGameObject)j2, -((int)this.q.x), (int)this.q.x, n3 + 1);
                    f3 += (float)com.corrodinggames.rts.gameFramework.GameUtils.a((GGameObject)j2, -((int)this.q.b), (int)this.q.b, n3 + 2);
                }
                this.a(j2, f2, f3, null, n2);
            } else if (this.i) {
                com.corrodinggames.rts.game.units.custom.a.a.b.w.c = this.l * this.l;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.b = this.j;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.d = false;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.h = null;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.e = this.k;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.a = this.m;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.f = true;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.g.clear();
                com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
                l2.cc.a(j2.posX, j2.posY, this.l, j2, 0.0f, w);
                if (com.corrodinggames.rts.game.units.custom.a.a.b.w.g.size() == 0) {
                    if (this.t != null) {
                        this.t.a(j2, pointF, am2, n2 + 1, 0);
                    }
                } else {
                    m m2 = com.corrodinggames.rts.game.units.custom.a.a.b.w.g;
                    int n4 = com.corrodinggames.rts.gameFramework.GameUtils.a((GGameObject)j2, 0, m2.size(), 0);
                    ++j2.bC;
                    if (n4 > m2.size() - 1) {
                        n4 = m2.size() - 1;
                    }
                    BaseUnit am4 = (BaseUnit)m2.get(n4);
                    this.a(j2, am4.posX, am4.posY, am4, n2);
                }
            } else {
                com.corrodinggames.rts.game.units.custom.a.a.b.w.c = this.h * this.h;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.b = this.f;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.d = false;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.h = null;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.e = this.g;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.a = this.m;
                com.corrodinggames.rts.game.units.custom.a.a.b.w.f = false;
                com.corrodinggames.rts.gameFramework.GameEngine l3 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
                l3.cc.a(j2.posX, j2.posY, this.h, j2, 0.0f, w);
                if (com.corrodinggames.rts.game.units.custom.a.a.b.w.h == null) {
                    if (this.t != null) {
                        this.t.a(j2, pointF, am2, n2 + 1, 0);
                    }
                } else {
                    BaseUnit am5 = com.corrodinggames.rts.game.units.custom.a.a.b.w.h;
                    this.a(j2, am5.posX, am5.posY, am5, n2);
                }
            }
        }
        return true;
    }
}
