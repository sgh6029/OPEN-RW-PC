/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.y;

public class UnitReference$SelfUnitReference
extends UnitReference {
    @Override
    public BaseUnit getSingleRaw(y y2) {
        return y2;
    }

    @Override
    public String getClassDebugName() {
        return "self";
    }
}

