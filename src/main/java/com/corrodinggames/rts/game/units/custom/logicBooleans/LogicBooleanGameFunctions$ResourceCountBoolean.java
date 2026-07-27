/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.e.a_f3;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$AbstractNumberBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanGameFunctions$ResourceScope;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.y;

public final class LogicBooleanGameFunctions$ResourceCountBoolean
extends LogicBoolean$AbstractNumberBoolean {
    l meta;
    a_f3 type;

    @Override
    public void forMeta(l l2) {
        if (l2 == null) {
            throw new BooleanParseException("ResourceCountBoolean requires metadata");
        }
        this.meta = l2;
    }

    @LogicBoolean$Parameter(positional=0)
    public void type(String string2) {
        this.type = this.meta.j(string2);
        if (this.type == null) {
            throw new BooleanParseException("Could not find resource type: '" + string2 + "'");
        }
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (this.type == null) {
            // empty if block
        }
    }

    @Override
    public String getName() {
        return this.type + "";
    }

    @Override
    public float getValue(y y2) {
        if (this.type == null) {
            return 0.0f;
        }
        return (float)this.type.a(y2);
    }

    @Override
    public float getMaxValue(y y2) {
        return 2.1474836E9f;
    }

    @Override
    public LogicBooleanLoader$LogicBooleanContext createContext() {
        return new LogicBooleanGameFunctions$ResourceScope();
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        if (this.type == null) {
            return LogicBoolean$ReturnType.voidReturn;
        }
        if (this.greaterThan == -1.0f && this.lessThan == -1.0f && !this.full && !this.empty) {
            return LogicBoolean$ReturnType.number;
        }
        return LogicBoolean$ReturnType.bool;
    }

    @Override
    public void throwVoidReturnError(String string2) {
        throw new RuntimeException("'" + string2 + "' requires type");
    }

    @Override
    public LogicBoolean setChild(LogicBoolean logicBoolean) {
        return logicBoolean;
    }
}

