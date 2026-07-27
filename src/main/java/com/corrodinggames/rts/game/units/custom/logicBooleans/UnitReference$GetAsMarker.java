/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference$PlaceholderUnitReference;
import com.corrodinggames.rts.game.units.y;

public class UnitReference$GetAsMarker
extends UnitReference$PlaceholderUnitReference {
    @Override
    public String getClassDebugName() {
        return "getAsMarker";
    }

    @Override
    public BaseUnit getSingleRaw(y y2) {
        y y3 = y2.bX.t;
        y3.cg = y2.cg;
        y3.posX = y2.posX;
        y3.posY = y2.posY;
        y3.posZ = y2.posZ;
        return y3;
    }
}

