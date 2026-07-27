/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.y;

public class UnitReference$LockedUnitReference
extends UnitReference {
    BaseUnit target;

    public UnitReference$LockedUnitReference(BaseUnit am2) {
        this.target = am2;
    }

    @Override
    public BaseUnit getSingleRaw(y y2) {
        return this.target;
    }

    @Override
    public String getClassDebugName() {
        return "unit";
    }
}

