/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.f.GameUIController;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class PlaceBuildingAction
extends AbstractUnitAction {
    UnitType a;
    int b = 1;

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        PlaceBuildingAction v2 = (PlaceBuildingAction)object;
        if (this.b != v2.b) {
            return false;
        }
        if (this.a != v2.a) {
            return false;
        }
        return super.equals(object);
    }

    public PlaceBuildingAction(UnitType as2) {
        this(as2, 1, null);
    }

    public PlaceBuildingAction(UnitType as2, int n2, Integer n3) {
        super("b_" + as2.v());
        UnitType as3 = com.corrodinggames.rts.game.units.custom.l.c(as2);
        if (as3 != null) {
            as2 = as3;
            this.a("b_" + as2.v());
        }
        if (n2 != 1) {
            this.a(this.N() + "_" + n2);
        }
        this.a = as2;
        this.b = n2;
        if (n3 != null) {
            this.sortOrder = n3.intValue();
        }
    }

    @Override
    public UnitType i() {
        return this.a;
    }

    @Override
    public UnitType y() {
        return this.a;
    }

    @Override
    public int t() {
        return this.b;
    }

    @Override
    public String a() {
        String string2 = this.i().f();
        boolean bl2 = false;
        boolean bl3 = true;
        BaseUnit am2 = BaseUnit.c(this.i());
        if (this.b != 1 && am2 instanceof y) {
            ((y)am2).a(this.b);
        }
        string2 = string2 + "\n\n" + com.corrodinggames.rts.gameFramework.f.GameUIController.a(am2, false, bl2, bl3);
        if (this.b != 1 && am2 instanceof y) {
            ((y)am2).a(1);
        }
        return string2;
    }

    @Override
    public String b() {
        UnitType as2 = this.i();
        String string2 = this.i().e();
        if (!(as2 instanceof com.corrodinggames.rts.game.units.custom.l)) {
            if (this.t() == 2) {
                string2 = string2 + " T-2";
            }
            if (this.t() == 3) {
                string2 = string2 + " T-3";
            }
        }
        return string2;
    }

    @Override
    public int c() {
        return this.B().a();
    }

    @Override
    public b B() {
        b b2 = this.unitAction.a();
        if (b2 != null) {
            return b2;
        }
        return this.i().d(this.t());
    }

    @Override
    public b r_() {
        b b2 = this.unitAction.b();
        if (b2 != null) {
            return b2;
        }
        return this.i().B();
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return -1;
    }

    @Override
    public ActionType e() {
        return ActionType.placeBuilding;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.building;
    }

    @Override
    public boolean n_() {
        return !this.i().C();
    }

    @Override
    public boolean g(BaseUnit am2) {
        GameEngine l2 = GameEngine.getInstance();
        if ((this.i() == UnitTypeEnum.AntiNukeLaucher || this.i() == UnitTypeEnum.NukeLaucher) && l2.O() && l2.networkEngine.ay.i) {
            return true;
        }
        if (this.i().w()) {
            return true;
        }
        return super.g(am2);
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public boolean u() {
        return true;
    }

    @Override
    public boolean D() {
        return false;
    }

    @Override
    public float p(BaseUnit am2) {
        if (!(am2 instanceof y)) {
            return -1.0f;
        }
        y y2 = (y)am2;
        BaseUnit am3 = y2.X();
        if (am3 != null && am3.cm < 1.0f && am3.r() == this.i()) {
            return am3.cm;
        }
        return -1.0f;
    }

    @Override
    public boolean r(BaseUnit am2) {
        return this.unitAction.a(am2, true);
    }

    @Override
    public boolean b(BaseUnit am2) {
        return this.unitAction.a(am2, false);
    }
}

