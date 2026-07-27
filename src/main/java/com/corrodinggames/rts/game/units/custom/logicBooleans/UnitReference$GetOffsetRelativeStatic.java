/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference$PlaceholderUnitReference;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;

public class UnitReference$GetOffsetRelativeStatic
extends UnitReference$PlaceholderUnitReference {
    @LogicBoolean$Parameter(positional=0)
    public float x;
    @LogicBoolean$Parameter(positional=1)
    public float y;
    @LogicBoolean$Parameter
    public float height;
    @LogicBoolean$Parameter
    public float dirOffset;

    @Override
    public String getClassDebugName() {
        return "getOffsetRelativeStatic";
    }

    @Override
    public BaseUnit getSingleRaw(y y2) {
        y y3 = y2.bX.t;
        float f2 = y2.cg + this.dirOffset;
        float f3 = GameUtils.k(f2);
        float f4 = GameUtils.j(f2);
        float f5 = this.x;
        float f6 = this.y;
        float f7 = f3 * f6 - f4 * f5;
        float f8 = f4 * f6 + f3 * f5;
        y3.cg = f2;
        y3.posX = y2.posX + f7;
        y3.posY = y2.posY + f8;
        y3.posZ = y2.posZ + this.height;
        return y3;
    }
}

