/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ArrayContextReader$ArrayFunction;
import com.corrodinggames.rts.game.units.y;

public class LogicBooleanLoader$ArrayContextReader$ArraySize
extends LogicBooleanLoader$ArrayContextReader$ArrayFunction {
    LogicBoolean targetArray;

    @Override
    public void setArrayTarget(LogicBoolean logicBoolean) {
        this.targetArray = logicBoolean;
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.number;
    }

    @Override
    public boolean read(y y2) {
        return false;
    }

    @Override
    public float readNumber(y y2) {
        int n2 = this.targetArray.getArraySize(y2);
        return n2;
    }

    public String getName() {
        return "size";
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        String string2 = "";
        if (this.targetArray != null) {
            string2 = string2 + this.targetArray.getMatchFailReasonForPlayer(y2);
        }
        string2 = string2 + this.getName() + "(=" + this.readNumber(y2) + ")";
        return string2;
    }
}

