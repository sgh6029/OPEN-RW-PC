/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticValueBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.utility.al;
import java.util.ArrayList;

abstract class LogicNumberFunction$LogicNumberFunctionRawArgs
extends LogicNumberFunction {
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number)
    public LogicBoolean value;

    LogicNumberFunction$LogicNumberFunctionRawArgs() {
    }

    @Override
    public void setArgumentsRaw(String string2, l l2, String string3) {
        if (string2 == null || "".equals(string2)) {
            this.validateNumberOfArguments(0);
            return;
        }
        ArrayList arrayList = al.a(string2, ",", false);
        this.validateNumberOfArguments(arrayList.size());
        this.value = LogicBooleanLoader.parseNumberBlock(l2, (String)arrayList.get(0));
        if (this.value == null) {
            throw new BooleanParseException("Expected non-null argument");
        }
    }

    public void validateNumberOfArguments(int n2) {
        if (n2 != 1) {
            throw new BooleanParseException("Expected 1 argument");
        }
    }

    @Override
    public LogicBoolean validateAndOptimize(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        this.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (this.value instanceof LogicBoolean$StaticValueBoolean) {
            float f2 = ((LogicBoolean$StaticValueBoolean)this.value).getStaticValue();
            return new LogicBoolean$StaticValueBoolean(this.doFunction(f2));
        }
        return this;
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (this.value == null) {
            throw new BooleanParseException("Expected parameters missing");
        }
        if (bl2) {
            throw new BooleanParseException("Expected function:" + string2 + " to return a boolean, but it returns a number");
        }
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return this.getName() + "(" + this.value.getMatchFailReasonForPlayer(y2) + ")";
    }

    public abstract float doFunction(float var1);
}

