/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.y;

public class UnitReference$AttackingReference
extends UnitReference {
    @Override
    public BaseUnit getSingleRaw(y y2) {
        BaseUnit am2 = y2.R;
        return am2;
    }

    @Override
    public String getClassDebugName() {
        return "Attacking";
    }
}

