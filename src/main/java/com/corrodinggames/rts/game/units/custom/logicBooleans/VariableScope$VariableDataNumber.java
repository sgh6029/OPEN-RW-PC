/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableData;
import com.corrodinggames.rts.game.units.y;

public class VariableScope$VariableDataNumber
extends VariableScope$VariableData {
    double number;

    public VariableScope$VariableDataNumber(double d2) {
        this.number = d2;
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.number;
    }

    @Override
    public float readNumber(y y2) {
        return (float)this.number;
    }
}

