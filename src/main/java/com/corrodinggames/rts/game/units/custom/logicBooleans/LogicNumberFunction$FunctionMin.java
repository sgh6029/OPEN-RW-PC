/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction;
import com.corrodinggames.rts.game.units.y;

public class LogicNumberFunction$FunctionMin
extends LogicNumberFunction {
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number, positional=0, required=true)
    public LogicBoolean a;
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number, positional=1, required=true)
    public LogicBoolean b;

    @Override
    public String getName() {
        return "Min";
    }

    @Override
    public float readNumber(y y2) {
        float f2;
        float f3 = this.a.readNumber(y2);
        if (f3 < (f2 = this.b.readNumber(y2))) {
            return f3;
        }
        return f2;
    }
}

