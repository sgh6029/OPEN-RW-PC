/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.a.ActionFilter;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;

import java.io.IOException;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.f.ae;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class FilteredUnitAction
extends AbstractUnitAction {
    AbstractUnitAction a;
    ActionFilter b = com.corrodinggames.rts.game.units.a.ActionFilter.emptyActionFilter;
    boolean c;
    public int d = 0;
    public boolean e;
    public final int f = Color.a(255, 50, 50, 50);

    @Override
    public float m_() {
        return this.a.m_();
    }

    @Override
    public int a(AbstractUnitAction s2) {
        return this.a.a(s2);
    }

    @Override
    public String b() {
        return this.a.b();
    }

    @Override
    public String d(BaseUnit am2) {
        return this.a.d(am2);
    }

    @Override
    public String a() throws IOException {
        String string2 = this.a.a();
        return string2;
    }

    @Override
    public String e(BaseUnit am2)  throws IOException {
        return this.a.e(am2);
    }

    @Override
    public int c() {
        return 0;
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return this.a.b(am2, bl2);
    }

    @Override
    public boolean n_() {
        return this.a.n_();
    }

    @Override
    public boolean a(BaseUnit am2, boolean bl2) {
        if (this.c) {
            return this.a.a(am2, bl2);
        }
        return true;
    }

    @Override
    public int t() {
        return this.a.t();
    }

    @Override
    public void f(BaseUnit am2) {
        this.a.f(am2);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof FilteredUnitAction) {
            return this.a.equals(((FilteredUnitAction)object).a);
        }
        return false;
    }

    @Override
    public boolean g(BaseUnit am2) {
        return this.a.g(am2);
    }

    @Override
    public boolean b(BaseUnit am2) {
        if (!this.b.isAvailable(this, am2)) {
            return false;
        }
        return this.a.b(am2);
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
        return this.a.d();
    }

    @Override
    public boolean h_() {
        return this.a.h_();
    }

    @Override
    public void a(BaseUnit am2, ae ae2, Paint paint, Paint paint2) {
        this.a.a(am2, ae2, paint, paint2);
    }

    @Override
    public void a(BaseUnit am2, ae ae2)  throws IOException {
        this.a.a(am2, ae2);
        UnitType as2 = this.a.i();
        if (as2 != null && as2 instanceof l) {
            l l2 = (l)as2;
            if (l2.J != null) {
                String string2 = l2.J.a();
                string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, 30);
                ae2.a("\n(mod: " + string2 + ")", this.f, true);
            }
        }
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
        return this.a.i(am2);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }

    public FilteredUnitAction(AbstractUnitAction s2, ActionFilter b2) {
        this(s2, b2, false);
    }

    public FilteredUnitAction(AbstractUnitAction s2, ActionFilter b2, boolean bl2) {
        super(s2.N());
        this.a = s2;
        this.b = b2;
        this.e(this.a.N());
        this.sortOrder = this.a.sortOrder;
        this.c = bl2;
    }

    public AbstractUnitAction q_() {
        return this.a;
    }

    @Override
    public boolean x() {
        return true;
    }

    @Override
    public boolean s() {
        if (!this.b.isAvailable(this, null)) {
            return false;
        }
        if (this.c) {
            return this.a.s();
        }
        return true;
    }

    @Override
    public UnitType y() {
        return this.a.y();
    }

    @Override
    public boolean c(BaseUnit am2, boolean bl2) {
        return this.a.c(am2, bl2);
    }

    @Override
    public boolean a(BaseUnit am2) {
        return this.a.a(am2);
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.a((AbstractUnitAction)object);
    }
}

