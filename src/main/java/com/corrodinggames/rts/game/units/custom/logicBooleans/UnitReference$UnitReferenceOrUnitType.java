/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.custom.v;

public class UnitReference$UnitReferenceOrUnitType {
    v unitType;
    UnitReference unitReference;

    UnitReference$UnitReferenceOrUnitType(v v2) {
        this.unitType = v2;
    }

    UnitReference$UnitReferenceOrUnitType(UnitReference unitReference) {
        this.unitReference = unitReference;
    }

    public BaseUnit getUnitOrSharedUnit(BaseUnit am2) {
        BaseUnit am3;
        if (this.unitType != null) {
            return BaseUnit.c(this.unitType.c());
        }
        if (this.unitReference != null && (am3 = this.unitReference.get(am2)) != null) {
            return am3;
        }
        return null;
    }

    public BaseUnit getUnitReferenceOrNull(BaseUnit am2) {
        BaseUnit am3;
        if (this.unitReference != null && (am3 = this.unitReference.get(am2)) != null) {
            return am3;
        }
        return null;
    }

    public UnitType getTypeOrNull(BaseUnit am2) {
        BaseUnit am3;
        if (this.unitType != null) {
            return this.unitType.c();
        }
        if (this.unitReference != null && (am3 = this.unitReference.get(am2)) != null) {
            return am3.r();
        }
        return null;
    }
}

