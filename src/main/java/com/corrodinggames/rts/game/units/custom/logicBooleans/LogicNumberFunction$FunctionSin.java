/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$LogicNumberFunctionRawArgs;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;

public class LogicNumberFunction$FunctionSin
extends LogicNumberFunction$LogicNumberFunctionRawArgs {
    @Override
    public String getName() {
        return "sin";
    }

    @Override
    public float readNumber(y y2) {
        float f2 = this.value.readNumber(y2);
        f2 = this.doFunction(f2);
        return f2;
    }

    @Override
    public float doFunction(float f2) {
        return GameUtils.j(f2);
    }
}

