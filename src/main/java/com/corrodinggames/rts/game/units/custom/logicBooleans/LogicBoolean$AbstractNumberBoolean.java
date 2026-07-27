/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;

public abstract class LogicBoolean$AbstractNumberBoolean
extends LogicBoolean {
    @LogicBoolean$Parameter
    public boolean full;
    @LogicBoolean$Parameter
    public boolean empty;
    @LogicBoolean$Parameter
    public float greaterThan = -1.0f;
    @LogicBoolean$Parameter
    public float lessThan = -1.0f;

    @LogicBoolean$Parameter
    public void equalTo(float f2) {
        this.greaterThan = f2 - 1.0E-4f;
        this.lessThan = f2 + 1.0E-4f;
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        if (this.greaterThan == -1.0f && this.lessThan == -1.0f && !this.full && !this.empty) {
            return LogicBoolean$ReturnType.number;
        }
        return LogicBoolean$ReturnType.bool;
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (bl2 && this.greaterThan == -1.0f && this.lessThan == -1.0f && !this.full && !this.empty) {
            throw new BooleanParseException("Expected greaterThan, lessThan, full, and/or empty to be set for function:" + string2 + " to return a boolean");
        }
    }

    public abstract String getName();

    public abstract float getValue(y var1);

    public abstract float getMaxValue(y var1);

    @Override
    public float readNumber(y y2) {
        return this.getValue(y2);
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        String string2 = this.getName() + "=" + GameUtils.a(this.getValue(y2), 3) + "";
        if (this.full) {
            string2 = string2 + "(full)";
        }
        if (this.empty) {
            string2 = string2 + "(empty)";
        }
        if (this.greaterThan != -1.0f) {
            string2 = string2 + ">" + GameUtils.a(this.greaterThan, 3);
        }
        if (this.lessThan != -1.0f) {
            string2 = string2 + "<" + GameUtils.a(this.lessThan, 3);
        }
        return string2;
    }

    @Override
    public boolean read(y y2) {
        float f2 = this.getValue(y2);
        boolean bl2 = true;
        if (this.full && !(f2 >= this.getMaxValue(y2))) {
            bl2 = false;
        }
        if (this.empty && !(f2 <= 0.0f)) {
            bl2 = false;
        }
        if (this.greaterThan != -1.0f && !(f2 > this.greaterThan)) {
            bl2 = false;
        }
        if (this.lessThan != -1.0f && !(f2 < this.lessThan)) {
            bl2 = false;
        }
        return bl2;
    }
}

