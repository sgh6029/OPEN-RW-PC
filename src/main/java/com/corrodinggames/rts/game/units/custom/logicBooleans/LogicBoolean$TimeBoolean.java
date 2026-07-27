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
import com.corrodinggames.rts.gameFramework.GameEngine;

public abstract class LogicBoolean$TimeBoolean
extends LogicBoolean {
    @LogicBoolean$Parameter
    public float laterThanSeconds = -1.0f;
    @LogicBoolean$Parameter
    public float withinSeconds = -1.0f;

    public abstract String getName();

    public abstract int getTime(y var1);

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        if (this.laterThanSeconds == -1.0f && this.withinSeconds == -1.0f) {
            return LogicBoolean$ReturnType.number;
        }
        return LogicBoolean$ReturnType.bool;
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (bl2 && this.laterThanSeconds == -1.0f && this.withinSeconds == -1.0f) {
            throw new BooleanParseException("Expended laterThanSeconds, or withinSeconds argument for function:" + string2 + " to return a boolean");
        }
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        GameEngine l2 = GameEngine.getInstance();
        String string2 = this.getName() + "=" + this.msToSecondsString(l2.by - this.getTime(y2));
        if (this.laterThanSeconds != -1.0f) {
            string2 = string2 + ">" + this.msToSecondsString(this.laterThanSeconds * 1000.0f);
        }
        if (this.withinSeconds != -1.0f) {
            string2 = string2 + "<" + this.msToSecondsString(this.withinSeconds * 1000.0f);
        }
        return string2;
    }

    private String msToSecondsString(float f2) {
        return GameUtils.g(f2 / 1000.0f) + "s";
    }

    @Override
    public float readNumber(y y2) {
        int n2 = this.getTime(y2);
        GameEngine l2 = GameEngine.getInstance();
        return (float)(l2.by - n2) * 0.001f;
    }

    @Override
    public boolean read(y y2) {
        int n2 = this.getTime(y2);
        boolean bl2 = true;
        GameEngine l2 = GameEngine.getInstance();
        if (this.withinSeconds > 0.0f && (float)l2.by - this.withinSeconds * 1000.0f > (float)n2) {
            bl2 = false;
        }
        if (this.laterThanSeconds > 0.0f && (float)l2.by - this.laterThanSeconds * 1000.0f < (float)n2) {
            bl2 = false;
        }
        return bl2;
    }
}

