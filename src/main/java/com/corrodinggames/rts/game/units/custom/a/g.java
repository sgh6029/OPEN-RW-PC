/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.a;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.a.d;
import com.corrodinggames.rts.game.units.custom.a.e;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.v;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.f.GameUIController;
import com.corrodinggames.rts.gameFramework.f.an;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class g
        extends PopupQueueAction {
    public d a;
    public v b;
    public e c = e.disabled;

    public g(d d2, v v2) {
        super((String) null);
        String string2 = "";
        if (d2.k != null) {
            string2 = string2 + d2.k;
        }
        string2 = string2 + "_" + d2.a;
        if (d2.b != null) {
            string2 = d2.b;
        }
        this.a(string2);
        this.a = d2;
        this.b = v2;
        if (d2.J != null) {
            this.b = d2.J;
        }
        this.c = d2.aN;
        if (this.c == e.auto) {
            boolean bl2 = false;
            boolean bl3 = false;
            if (d2.ag != null && d2.ah == null) {
                bl3 = true;
            }
            if (d2.q.d()) {
                bl2 = true;
                this.c = e.upgrade;
            }
            this.c = bl2 && !bl3 ? e.upgrade : e.movementChange;
            if (d2.I != null) {
                this.c = e.sameAsBuilding;
            }
        }
    }

    @Override
    public h P() {
        return this.a.s;
    }

    @Override
    public boolean F() {
        return true;
    }

    @Override
    public boolean d(BaseUnit am2, boolean bl2) {
        return this.a.M;
    }

    @Override
    public boolean k(BaseUnit am2) {
        return this.a.O;
    }

    @Override
    public boolean l(BaseUnit am2) {
        return this.a.P;
    }

    @Override
    public boolean u() {
        return super.u();
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        j j2 = (j) am2;
        if (!this.a.N && j2.a(this.N(), bl2) > 0) {
            return false;
        }
        if (this.a.u != null && (bl2 && this.Q() ? !an.a(this.a.u, j2) : !this.a.u.read(j2))) {
            return false;
        }
        return super.a(am2, bl2);
    }

    @Override
    public boolean g(BaseUnit am2) {
        if (this.a(am2, -1)) {
            return true;
        }
        return super.g(am2);
    }

    public boolean a(BaseUnit am2, int n2) {
        if (this.a.z != null && (n2 == -1 || n2 == 1)) {
            if (!(am2 instanceof j)) {
                GameEngine.n("CustomActionConfig lockedInGame:" + am2.r().i() + " is not a custom unit");
                return false;
            }
            if (this.a.z.read((j) am2)) {
                return true;
            }
        }
        if (this.a.B != null && (n2 == -1 || n2 == 2)) {
            if (!(am2 instanceof j)) {
                GameEngine.n("CustomActionConfig lockedInGame:" + am2.r().i() + " is not a custom unit");
                return false;
            }
            if (this.a.B.read((j) am2)) {
                return true;
            }
        }
        if (this.a.D != null && (n2 == -1 || n2 == 3)) {
            if (!(am2 instanceof j)) {
                GameEngine.n("CustomActionConfig lockedInGame:" + am2.r().i() + " is not a custom unit");
                return false;
            }
            if (this.a.D.read((j) am2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String j(BaseUnit am2) {
        if (this.a(am2, 1) && this.a.A != null) {
            return this.a.A.b(am2);
        }
        if (this.a(am2, 2) && this.a.C != null) {
            return this.a.C.b(am2);
        }
        if (this.a(am2, 3) && this.a.E != null) {
            return this.a.E.b(am2);
        }
        return super.j(am2);
    }

    @Override
    public boolean r(BaseUnit am2) {
        j j2 = (j) am2;
        if (this.a.v != null) {
            if (this.Q()) {
                return an.a(this.a.v, j2);
            }
            return this.a.v.read(j2);
        }
        return super.b(am2);
    }

    @Override
    public boolean b(BaseUnit am2) {
        j j2 = (j) am2;
        if (this.a.v != null) {
            return this.a.v.read(j2);
        }
        return super.b(am2);
    }

    @Override
    public boolean a(BaseUnit am2, PlayerTeam n2) {
        if (!this.a.w && !this.a.x) {
            return false;
        }
        if (am2.bX.d(n2)) {
            return this.a.w;
        }
        return this.a.x;
    }

    @Override
    public b r_() {
        b b2 = this.unitAction.b();
        if (b2 != null) {
            return b2;
        }
        return this.a.r;
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        if (this.a.aI) {
            return this.a.q.a(am2, true);
        }
        return super.b(am2, bl2);
    }

    @Override
    public String d() {
        return super.d();
    }

    @Override
    public String b() {
        String string2 = null;
        if (this.a.d != null) {
            string2 = this.a.d.b();
        }
        return string2;
    }

    @Override
    public String d(BaseUnit am2) {
        UnitType as2;
        String string2 = null;
        if (this.a.d != null) {
            string2 = this.a.d.b(am2);
        }
        if (this.a.e != null && (as2 = this.a.e.getTypeOrNull(am2)) != null) {
            if (string2 == null) {
                string2 = "";
            } else if (!string2.equals("")) {
                string2 = string2 + " ";
            }
            string2 = string2 + as2.e();
        }
        if (this.a.h != null) {
            if (string2 == null) {
                string2 = "";
            } else if (!string2.equals("")) {
                string2 = string2 + " ";
            }
            string2 = string2 + this.a.h.b();
        }
        return string2;
    }

    @Override
    public String a() {
        String string2 = null;
        if (this.a.i != null) {
            string2 = this.a.i.b();
        }
        return string2;
    }

    @Override
    public String e(BaseUnit var1) {
        String var2 = null;
        if (this.a.i != null) {
            var2 = this.a.i.b(var1);
        }

        if (this.a.f != null) {
            UnitType var3 = this.a.f.getTypeOrNull(var1);
            if (var3 != null) {
                if (var2 == null) {
                    var2 = "";
                } else if (!var2.equals("")) {
                    var2 = var2 + " ";
                }

                var2 = var2 + var3.f();
            }
        }

        if (this.a.g != null) {
            BaseUnit var7 = this.a.g.getUnitReferenceOrNull(var1);
            if (var7 != null) {
                if (var2 == null) {
                    var2 = "";
                } else if (!var2.equals("")) {
                    var2 = var2 + "\n\n";
                }

                boolean var4 = false;
                String var5 = com.corrodinggames.rts.gameFramework.f.GameUIController.a(var7, false, false, var4);
                var2 = var2 + var5;
            } else {
                BaseUnit var8 = this.a.g.getUnitOrSharedUnit(var1);
                if (var8 != null) {
                    if (var2 == null) {
                        var2 = "";
                    } else if (!var2.equals("")) {
                        var2 = var2 + "\n\n";
                    }

                    boolean var9 = true;
                    String var6 = com.corrodinggames.rts.gameFramework.f.GameUIController.a(var8, false, false, var9);
                    var2 = var2 + var6;
                }
            }
        }

        return var2;
    }

    public boolean L() {
        return this.a.U;
    }

    @Override
    public float K() {
        if (this.a.S >= 1.0f) {
            return 1000.0f;
        }
        return this.a.S;
    }

    @Override
    public ActionType e() {
        return this.a.j;
    }

    @Override
    public b B() {
        b b2 = this.unitAction.a();
        if (b2 != null) {
            return b2;
        }
        return this.a.q;
    }

    @Override
    public int c() {
        return this.B().a();
    }

    @Override
    public UnitType i() {
        if (this.b == null) {
            return null;
        }
        return this.b.c();
    }

    @Override
    public UnitType y() {
        if (this.a.J != null) {
            return this.a.J.c();
        }
        return null;
    }

    @Override
    public UnitType E() {
        if (this.a.I != null) {
            return this.a.I.c();
        }
        return null;
    }

    @Override
    public boolean A() {
        return true;
    }

    @Override
    public boolean g() {
        return this.a.J != null;
    }

    @Override
    public ActionDisplayType f() {
        return this.a.aG;
    }

    @Override
    public boolean m(BaseUnit am2) {
        return this.a.G.read((j) am2);
    }

    @Override
    public boolean n(BaseUnit am2) {
        if (this.a.F == null) {
            return false;
        }
        if (!(am2 instanceof j)) {
            GameEngine.b("ai_isHighPriority non customUnit:" + am2.r().i());
            return false;
        }
        return this.a.F.read((j) am2);
    }

    @Override
    public e v(BaseUnit am2) {
        return this.c;
    }

    @Override
    public boolean H() {
        return this.a.K;
    }

    @Override
    public boolean I() {
        return this.a.L;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M j() {
        return this.a.ay;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M h(BaseUnit am2) {
        if (this.a.aB != null && am2 instanceof j && !an.a(this.a.aB, (j) am2)) {
            return null;
        }
        return this.a.az;
    }

    @Override
    public int J() {
        return this.a.aA;
    }

    @Override
    public BaseUnit i(BaseUnit am2) {
        if (this.a.aC != null) {
            BaseUnit am3 = this.a.aC.getUnitOrSharedUnit(am2);
            return am3;
        }
        return null;
    }

    @Override
    public boolean s(BaseUnit am2) {
        return this.a.aD;
    }

    @Override
    public boolean t(BaseUnit am2) {
        return this.a.aE;
    }

    @Override
    public boolean a(BaseUnit am2) {
        if (this.a.aF != null) {
            return an.a(this.a.aF, (j) am2);
        }
        return false;
    }

    @Override
    public boolean Q() {
        return this.a.o;
    }

    @Override
    public void a(y y2) {
        if (this.a.ae != null) {
            an.b(y2, this.a.ae);
        }
    }
}
