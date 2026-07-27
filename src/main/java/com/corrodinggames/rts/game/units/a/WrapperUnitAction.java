/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.f.ae;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Paint;
import android.graphics.Rect;

import java.io.IOException;
import java.util.ArrayList;

public class WrapperUnitAction
extends AbstractUnitAction {
    public AbstractUnitAction a;
    public y b;
    public ActionFilter c = com.corrodinggames.rts.game.units.a.ActionFilter.emptyActionFilter;
    static com.corrodinggames.rts.gameFramework.utility.UnitList d;
    static final com.corrodinggames.rts.gameFramework.utility.UnitList e;

    private void K() {
        GameEngine l2 = GameEngine.getInstance();
        if (d != null) {
            throw new RuntimeException("savedSelectedUnitsCache!=null");
        }
        d = l2.bS.bZ;
        e.clear();
        e.a(this.b);
        l2.bS.bZ = e;
    }

    private void L() {
        GameEngine l2 = GameEngine.getInstance();
        if (d == null) {
            throw new RuntimeException("savedSelectedUnitsCache==null");
        }
        l2.bS.bZ = d;
        d = null;
        e.clear();
    }

    @Override
    public float m_() {
        return super.m_();
    }

    @Override
    public int a(AbstractUnitAction s2) {
        return super.a(s2);
    }

    @Override
    public String b() {
        return this.a.b();
    }

    @Override
    public String d(BaseUnit am2) {
        return this.a.d(this.b);
    }

    @Override
    public String a() throws IOException {
        String string2 = this.a.a();
        return string2;
    }

    @Override
    public String e(BaseUnit am2)  throws IOException {
        return this.a.e(this.b);
    }

    @Override
    public int c() {
        return this.a.c();
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return this.a.b(this.b, bl2);
    }

    @Override
    public boolean n_() {
        return this.a.n_();
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        return this.a.a((BaseUnit)this.b, bl2);
    }

    @Override
    public int t() {
        return this.a.t();
    }

    @Override
    public void f(BaseUnit am2) {
        this.a.f(this.b);
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public boolean g(BaseUnit am2) {
        return this.a.g(this.b);
    }

    @Override
    public boolean u() {
        return this.a.u();
    }

    @Override
    public boolean h() {
        return this.a.h();
    }

    @Override
    public UnitType i() {
        return this.a.i();
    }

    @Override
    public boolean g() {
        return this.a.g();
    }

    @Override
    public ActionType e() {
        return this.a.e();
    }

    @Override
    public ActionDisplayType f() {
        return this.a.f();
    }

    @Override
    public String d() {
        this.K();
        String string2 = this.a.d();
        this.L();
        return string2;
    }

    @Override
    public boolean h_() {
        return this.a.h_();
    }

    @Override
    public void a(BaseUnit am2, ae ae2, Paint paint, Paint paint2) {
        this.K();
        this.a.a(this.b, ae2, paint, paint2);
        this.L();
    }

    @Override
    public void a(BaseUnit am2, ae ae2) throws IOException {
        this.K();
        this.a.a((BaseUnit)this.b, ae2);
        this.L();
    }

    @Override
    public Texture_M j() {
        return this.a.j();
    }

    @Override
    public Texture_M h(BaseUnit am2) {
        return this.a.h(am2);
    }

    @Override
    public Rect v() {
        return this.a.v();
    }

    @Override
    public BaseUnit i(BaseUnit am2) {
        return this.a.i(this.b);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }

    public WrapperUnitAction(AbstractUnitAction s2, y y2, ActionId c2) {
        super(c2);
        this.a = s2;
        this.b = y2;
        this.sortOrder = this.a.sortOrder;
    }

    public AbstractUnitAction p_() {
        return this.a;
    }

    @Override
    public boolean x() {
        return this.a.x();
    }

    @Override
    public boolean s() {
        return this.a.s();
    }

    @Override
    public UnitType y() {
        return this.a.y();
    }

    @Override
    public ActionId z() {
        return this.a.N();
    }

    @Override
    public void a(BaseUnit am2, BaseUnit am3) {
        super.a(am2, am3);
    }

    @Override
    public boolean a(BaseUnit am2, PlayerTeam n2) {
        return this.a.a((BaseUnit)this.b, n2);
    }

    @Override
    public boolean A() {
        return this.a.A();
    }

    @Override
    public boolean a(BaseUnit am2) {
        return this.a.a((BaseUnit)this.b);
    }

    @Override
    public com.corrodinggames.rts.game.units.custom.d.b B() {
        return this.a.B();
    }

    @Override
    public String j(BaseUnit am2) {
        return this.a.j(this.b);
    }

    @Override
    public boolean d(BaseUnit am2, boolean bl2) {
        return this.a.d(this.b, bl2);
    }

    @Override
    public boolean k(BaseUnit am2) {
        return this.a.k(this.b);
    }

    @Override
    public boolean l(BaseUnit am2) {
        return this.a.l(this.b);
    }

    @Override
    public boolean C() {
        return this.a.C();
    }

    @Override
    public boolean D() {
        return this.a.D();
    }

    @Override
    public UnitType E() {
        return this.a.E();
    }

    @Override
    public boolean F() {
        return this.a.F();
    }

    @Override
    public boolean m(BaseUnit am2) {
        return this.a.m(this.b);
    }

    @Override
    public boolean n(BaseUnit am2) {
        return this.a.n(this.b);
    }

    @Override
    public boolean c(BaseUnit am2, boolean bl2) {
        return this.a.c(this.b, bl2);
    }

    @Override
    public boolean o(BaseUnit am2) {
        return this.a.o(this.b);
    }

    @Override
    public boolean G() {
        return this.a.G();
    }

    @Override
    public void c(BaseUnit am2) {
        this.a.c(this.b);
    }

    @Override
    public float l() {
        return this.a.l();
    }

    @Override
    public int m() {
        return this.a.m();
    }

    @Override
    public boolean H() {
        return this.a.H();
    }

    @Override
    public boolean I() {
        return this.a.I();
    }

    @Override
    public float p(BaseUnit am2) {
        return this.a.p(this.b);
    }

    @Override
    public ArrayList q(BaseUnit am2) {
        return this.a.q(this.b);
    }

    @Override
    public boolean r(BaseUnit am2) {
        if (!this.c.isAvailable(this, am2)) {
            return false;
        }
        return this.a.r(this.b);
    }

    @Override
    public boolean b(BaseUnit am2) {
        if (!this.c.isAvailable(this, am2)) {
            return false;
        }
        return this.a.b(this.b);
    }

    @Override
    public int J() {
        return this.a.J();
    }

    @Override
    public boolean s(BaseUnit am2) {
        return this.a.s(this.b);
    }

    @Override
    public boolean t(BaseUnit am2) {
        return this.a.t(this.b);
    }

    public boolean a(WrapperUnitAction g2) {
        return this.a == g2.a && this.b == g2.b && this.N() == g2.N() && this.c == g2.c;
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.a((AbstractUnitAction)object);
    }

    static {
        e = new com.corrodinggames.rts.gameFramework.utility.UnitList();
    }
}

