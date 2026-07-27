/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$MathAddJoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$StringJoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticValueBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.y;

public abstract class CompareJoinerBoolean$MathJoinerBoolean
extends CompareJoinerBoolean {
    @Override
    public boolean read(y y2) {
        return false;
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.number;
    }

    @Override
    public LogicBoolean validateAndOptimize(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        boolean bl3;
        if (this instanceof CompareJoinerBoolean$MathAddJoinerBoolean) {
            bl3 = false;
            for (LogicBoolean logicBoolean : this.children) {
                if (logicBoolean.getReturnType() != LogicBoolean$ReturnType.string) continue;
                bl3 = true;
            }
            if (bl3) {
                CompareJoinerBoolean$StringJoinerBoolean compareJoinerBoolean$StringJoinerBoolean = new CompareJoinerBoolean$StringJoinerBoolean();
                compareJoinerBoolean$StringJoinerBoolean.children = this.children;
                return compareJoinerBoolean$StringJoinerBoolean.validateAndOptimize(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
            }
        }
        bl3 = true;
        for (LogicBoolean logicBoolean : this.children) {
            if (!(logicBoolean instanceof LogicBoolean$StaticValueBoolean)) {
                bl3 = false;
            }
            if (logicBoolean.getReturnType() == LogicBoolean$ReturnType.number) continue;
            throw new BooleanParseException("Unexpected type while using " + this.type() + " got: " + logicBoolean.getReturnType().name());
        }
        if (bl3) {
            float f2 = this.readNumber(null);
            return new LogicBoolean$StaticValueBoolean(f2);
        }
        if (bl2) {
            throw new BooleanParseException("Cannot return number here, expected boolean");
        }
        return super.validateAndOptimize(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
    }
}

