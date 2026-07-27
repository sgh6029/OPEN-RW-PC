/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitCommand;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.y;

public class UnitReference$ActiveWaypointTargetReference
extends UnitReference {
    @Override
    public BaseUnit getSingleRaw(y y2) {
        UnitCommand au2 = y2.ar();
        if (au2 == null) {
            return null;
        }
        BaseUnit am2 = au2.l();
        return am2;
    }

    @Override
    public String getClassDebugName() {
        return "ActiveWaypointTarget";
    }
}

