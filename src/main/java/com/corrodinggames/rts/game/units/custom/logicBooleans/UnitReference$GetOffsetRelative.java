/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticValueBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference$PlaceholderUnitReference;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;

public class UnitReference$GetOffsetRelative
extends UnitReference$PlaceholderUnitReference {
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number, positional=0)
    public LogicBoolean x = LogicBoolean$StaticValueBoolean.static_0;
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number, positional=1)
    public LogicBoolean y = LogicBoolean$StaticValueBoolean.static_0;
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number)
    public LogicBoolean height = LogicBoolean$StaticValueBoolean.static_0;
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number)
    public LogicBoolean dirOffset = LogicBoolean$StaticValueBoolean.static_0;

    @Override
    public String getClassDebugName() {
        return "getOffsetRelative";
    }

    @Override
    public LogicBoolean validateAndOptimize(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        return super.validateAndOptimize(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
    }

    @Override
    public BaseUnit getSingleRaw(y y2) {
        y y3 = y2.bX.t;
        y y4 = UnitReference$GetOffsetRelative.getParameterContext(y2);
        float f2 = y2.cg + this.dirOffset.readNumber(y4);
        float f3 = GameUtils.k(f2);
        float f4 = GameUtils.j(f2);
        float f5 = this.x.readNumber(y4);
        float f6 = this.y.readNumber(y4);
        float f7 = f3 * f6 - f4 * f5;
        float f8 = f4 * f6 + f3 * f5;
        y3.cg = f2;
        y3.posX = y2.posX + f7;
        y3.posY = y2.posY + f8;
        y3.posZ = y2.posZ + this.height.readNumber(y4);
        return y3;
    }
}

