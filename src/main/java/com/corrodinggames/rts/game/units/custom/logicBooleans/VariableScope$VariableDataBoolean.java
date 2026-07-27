/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableData;
import com.corrodinggames.rts.game.units.y;

public class VariableScope$VariableDataBoolean
extends VariableScope$VariableData {
    boolean bool;

    public VariableScope$VariableDataBoolean(boolean bl2) {
        this.bool = bl2;
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.bool;
    }

    @Override
    public boolean read(y y2) {
        return this.bool;
    }
}

