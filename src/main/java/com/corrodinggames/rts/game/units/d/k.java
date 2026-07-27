/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.d.f;
import com.corrodinggames.rts.game.units.d.j;
import com.corrodinggames.rts.game.units.d.l;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.Serializable;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.PointF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class k {
    y a;
    public PointF b = null;
    public final m c = new m();
    final m d = new m();
    public float e;
    j f;

    public k(y y2) {
        this.a = y2;
    }

    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.e);
        as2.a(this.c.size());
        for (Serializable bq2 : ((List<Serializable>) this.c)) {
            bq2.a(as2);
        }
        as2.a(this.b != null);
        if (this.b != null) {
            as2.a(this.b.x);
            as2.a(this.b.b);
        }
    }

    public void a(com.corrodinggames.rts.gameFramework.j.GameInputStream k2) throws IOException {
        int n2;
        this.e = k2.g();
        int n3 = k2.readInt();
        this.c.clear();
        for (n2 = 0; n2 < n3; ++n2) {
            j j2 = new j();
            j2.a(k2);
            if (AbstractUnitAction.c(j2.j)) {
                AbstractUnitAction s2 = this.a.a(j2.j);
                if (s2 == null) {
                    com.corrodinggames.rts.gameFramework.GameEngine.b("Factory",
                            this.a.r() + " no longer has the action:" + j2.j);
                    continue;
                }
                this.c.add(j2);
                continue;
            }
            com.corrodinggames.rts.gameFramework.GameEngine.b("Factory", "buildQueue has uIndex of -1, skipping");
        }
        if (k2.b() >= 5) {
            n2 = k2.e() ? 1 : 0;
            if (n2 != 0) {
                if (this.b == null) {
                    this.b = new PointF();
                }
                this.b.x = k2.g();
                this.b.b = k2.g();
            } else {
                this.b = null;
            }
        }
    }

    public BaseUnit a(j j2, float f2, boolean bl2, float f3) {
        AbstractUnitAction s2 = this.a.a(j2.j);
        if (s2 == null) {
            NetworkEngine.a("specialAction=null on completeQueueItem for item.uIndex:" + j2.j + " id:" + this.a.objectId, true);
            return null;
        }
        UnitType as2 = s2.i();
        if (as2 == null) {
            NetworkEngine.a("unitType=null on completeQueueItem for item.uIndex:" + j2.j + " id:" + this.a.objectId, false);
            return null;
        }
        return this.a(as2, f2, bl2, f3);
    }

    public void a(BaseUnit am2, float f2, boolean bl2) {
        am2.cl = 30.0f;
        if (this.a instanceof f) {
            am2.cl += 40.0f;
        }
        if (am2 instanceof y) {
            y y2 = (y) am2;
            y2.j(90.0f);
            if ((double) y2.z() < 0.75) {
                am2.cl += 30.0f;
            }
            if ((double) y2.z() < 0.55) {
                am2.cl += 20.0f;
            }
            float f3 = bl2 ? 0.0f : 1.0f;
            float f4 = f2;
            float f5 = this.a.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(am2.cg) * f4;
            float f6 = this.a.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(am2.cg) * f4;
            if (this.b != null) {
                if (f4 != 0.0f) {
                    y2.d(f5, f6);
                }
                y2.d(this.b.x + f3, this.b.b);
            } else {
                f5 -= com.corrodinggames.rts.gameFramework.GameUtils.j(am2.cg) * f3;
                f6 += com.corrodinggames.rts.gameFramework.GameUtils.k(am2.cg) * f3;
                if (f4 != 0.0f) {
                    y2.d(f5, f6);
                }
            }
        }
    }

    public BaseUnit a(UnitType as2, float f2, boolean bl2, float f3) {
        BaseUnit am2 = null;
        am2 = as2.createUnitInstance();
        am2.posX = this.a.posX;
        am2.posY = this.a.posY + 5.0f;
        am2.cg = 90.0f + f3;
        am2.f(this.a.bX);
        am2.B(this.a);
        this.a(am2, f2, bl2);
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (am2.bX == l2.bs) {
            l2.bS.i.a(am2);
        }
        return am2;
    }

    public final boolean a() {
        return this.c.a == 0;
    }

    public j a(PopupQueueAction w2, boolean bl2) {
        return this.a(w2, bl2, null, null);
    }

    public j a(PopupQueueAction w2, boolean bl2, PointF pointF, BaseUnit am2) {
        j j2 = new j();
        j2.j = w2.N();
        j2.h = pointF;
        j2.i = am2;
        if (j2.j == null) {
            throw new RuntimeException("item.uIndex==null??");
        }
        j2.a = 1;
        j2.b = w2.K();
        j2.c = w2.B();
        j2.d = w2.r_();
        j2.e = w2.P();
        j2.f = w2.g();
        j2.g = w2.i();
        j2.l = w2.H();
        if (!bl2) {
            PlayerTeam.b((BaseUnit) this.a);
            if (j2.l) {
                int n2 = 0;
                for (int i2 = 0; i2 < this.c.size() && ((j) this.c.get((int) i2)).l; ++i2) {
                    n2 = i2 + 1;
                }
                if (n2 != 0 || this.c.size() != 0) {
                    // empty if block
                }
                this.c.add(n2, j2);
            } else {
                this.c.add(j2);
            }
            PlayerTeam.c(this.a);
        } else {
            this.d.add(j2);
        }
        return j2;
    }

    public j b(PopupQueueAction w2, boolean bl2) {
        if (bl2) {
            if (this.a(w2.N(), true) > 0) {
                j j2 = this.a(w2, true);
                j2.k = true;
                return j2;
            }
            return null;
        }
        m m2 = this.c;
        ListIterator listIterator = m2.listIterator(m2.size());
        while (listIterator.hasPrevious()) {
            j j3 = (j) listIterator.previous();
            if (!j3.j.equals(w2.N()))
                continue;
            PlayerTeam.b((BaseUnit) this.a);
            listIterator.remove();
            PlayerTeam.c(this.a);
            return j3;
        }
        return null;
    }

    public void a(j j2) {
        this.f = j2;
        this.a.bC();
    }

    public j b() {
        return this.f;
    }

    public b c() {
        if (this.f == null) {
            return null;
        }
        if (this.f.d == null) {
            return null;
        }
        float f2 = this.f.b * this.a.cx() * 60.0f;
        return com.corrodinggames.rts.game.units.custom.d.b.a(this.f.d, -f2);
    }

    public AbstractUnitAction d() {
        if (this.f != null) {
            AbstractUnitAction s2 = this.a.a(this.f.j);
            return s2;
        }
        return null;
    }

    public void a(float f2) {
        if (!this.a()) {
            j j2 = (j) this.f().get(0);
            if (this.f != j2) {
                if (j2.m < 0.0f) {
                    j2.m = 0.0f;
                    ((l) ((Object) this.a)).b(j2);
                }
                if (this.f != null) {
                    this.e = j2.m;
                }
                this.a(j2);
            }
            float f3 = j2.b * this.a.cx() * f2;
            boolean bl2 = false;
            if (j2.d != null) {
                if (this.e + f3 > 1.0f) {
                    f3 = 1.0f - this.e;
                    bl2 = true;
                }
                double d2 = (double) (this.e + f3) - j2.n;
                double d3 = 0.0;
                if (bl2) {
                    d3 = 1.0 - j2.n;
                } else {
                    double d4 = 0.01f;
                    if (d2 >= d4) {
                        int n2 = (int) (d2 / d4);
                        d3 = (double) n2 * d4;
                    }
                }
                boolean bl3 = false;
                if (d3 > 0.0 && this.a.bX.am.a(j2.d)) {
                    bl3 = true;
                }
                if (!bl3 && (d3 <= 0.0 || j2.d.c((BaseUnit) this.a, d3))) {
                    j2.n += d3;
                } else {
                    if (!bl3) {
                        this.a.bX.am.a(j2.d, (BaseUnit) this.a, d3);
                    }
                    f3 = 0.0f;
                    bl2 = false;
                }
            }
            this.e += f3;
            if (bl2) {
                this.e = 1.0f;
            }
            j2.m = this.e;
            if (this.e >= 1.0f) {
                if (j2.f && ((l) ((Object) this.a)).dA()) {
                    this.e = 1.0f;
                } else {
                    PlayerTeam.b((BaseUnit) this.a);
                    this.e = 0.0f;
                    --j2.a;
                    if (j2.a <= 0) {
                        List list = this.f();
                        if (list.size() == 0) {
                            com.corrodinggames.rts.gameFramework.GameEngine
                                    .b("-------------buildQueue empty for:" + j2.j);
                            com.corrodinggames.rts.gameFramework.GameEngine.b("-------------");
                        } else {
                            list.remove(0);
                        }
                    }
                    PlayerTeam.c(this.a);
                    ((l) ((Object) this.a)).a(j2);
                }
            }
        } else {
            this.a((j) null);
            this.e = 0.0f;
            if (this.d.a > 0) {
                j j3 = (j) this.d.get(0);
                if (j3.b > 10.0f && j3.m <= 0.0f) {
                    j3.m = 1.0f;
                    AbstractUnitAction s2 = this.a.a(j3.j);
                    if (s2 != null && s2.Q()) {
                        s2.a(this.a);
                    }
                }
            }
        }
    }

    public void e() {
        Iterator iterator = this.c.iterator();
        while (iterator.hasNext()) {
            j j2 = (j) iterator.next();
            AbstractUnitAction s2 = this.a.a(j2.j);
            if (s2 != null)
                continue;
            this.b(j2);
            this.c(j2);
            iterator.remove();
        }
    }

    public void a(boolean bl2) {
        Iterator iterator = this.c.iterator();
        while (iterator.hasNext()) {
            j j2 = (j) iterator.next();
            if (bl2) {
                this.b(j2);
            }
            this.c(j2);
            iterator.remove();
        }
    }

    private void b(j j2) {
        if (((l) ((Object) this.a)).c(j2)) {
            if (j2.d != null && j2.n > 0.0) {
                j2.d.a((BaseUnit) this.a, j2.n, true);
            }
            j2.c.h(this.a);
        }
    }

    private void c(j j2) {
    }

    public int a(UnitType as2) {
        int n2 = 0;
        int n3 = this.c.a;
        if (n3 != 0) {
            Object[] objectArray = this.c.a();
            for (int i2 = 0; i2 < n3; ++i2) {
                UnitType as3;
                j j2 = (j) objectArray[i2];
                if (!j2.f || (as3 = j2.g) != as2)
                    continue;
                n2 += j2.a;
            }
        }
        return n2;
    }

    public int a(ActionId c2, boolean bl2) {
        return this.a(c2, bl2, false);
    }

    public int a(g g2) {
        if (g2 == null) {
            return this.c.a;
        }
        int n2 = 0;
        for (j j2 : ((List<j>) this.c)) {
            if (!g.a(g2, j2.e))
                continue;
            ++n2;
        }
        return n2;
    }

    public int a(ActionId c2, boolean bl2, boolean bl3) {
        int n2 = 0;
        if (this.c.a != 0) {
            for (j j2 : ((List<j>) this.c)) {
                if (AbstractUnitAction.NONE_ACTION_ID != c2 && !j2.j.equals(c2) || bl3 && !j2.f)
                    continue;
                n2 += j2.a;
            }
        }
        if (bl2 && this.d.a != 0) {
            for (j j2 : ((List<j>) this.d)) {
                if (AbstractUnitAction.NONE_ACTION_ID != c2 && !j2.j.equals(c2) || bl3 && !j2.f)
                    continue;
                if (!j2.k) {
                    n2 += j2.a;
                    continue;
                }
                n2 -= j2.a;
            }
        }
        return n2;
    }

    public AbstractUnitAction b(UnitType as2) {
        ArrayList arrayList = this.a.N();
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            PopupQueueAction w2;
            AbstractUnitAction s2 = (AbstractUnitAction) arrayList.get(i2);
            if (s2 == null || !(s2 instanceof PopupQueueAction) || (w2 = (PopupQueueAction) s2).i() != as2)
                continue;
            return w2;
        }
        return null;
    }

    public j a(AbstractUnitAction s2, boolean bl2, PointF pointF, BaseUnit am2) {
        if (s2 instanceof PopupQueueAction) {
            PopupQueueAction w2 = (PopupQueueAction) s2;
            if (!bl2) {
                if (s2.a((BaseUnit) this.a, false) && s2.b(this.a) && (!w2.g() || this.a.bX.w() < this.a.bX.x())
                        && w2.B().c(this.a)) {
                    return this.a(w2, false, pointF, am2);
                }
            } else {
                j j2 = this.b(w2, false);
                if (j2 != null) {
                    this.b(j2);
                    this.c(j2);
                    return j2;
                }
            }
        }
        return null;
    }

    public void a(AbstractUnitAction s2, boolean bl2) {
        if (s2 instanceof PopupQueueAction) {
            PopupQueueAction w2 = (PopupQueueAction) s2;
            if (!bl2) {
                if (s2.a((BaseUnit) this.a, true) && (!w2.g() || this.a.bX.w() < this.a.bX.x())
                        && w2.B().b((BaseUnit) this.a, s2.Q())) {
                    this.a(w2, true);
                }
            } else if (this.b(w2, true) != null) {
                w2.B().e(this.a, s2.Q());
            }
        }
    }

    public void a(AbstractUnitAction s2) {
        if (this.d.size() != 0) {
            j j2 = null;
            for (j j3 : ((List<j>) this.d)) {
                if (!j3.j.equals(s2.N()))
                    continue;
                j2 = j3;
            }
            if (j2 != null) {
                if (!j2.k) {
                    j2.c.e(this.a, s2.Q());
                } else {
                    j2.c.d(this.a, s2.Q());
                }
                this.d.remove(j2);
            }
        }
    }

    public List f() {
        return this.c;
    }

    public m g() {
        return this.c;
    }
}
