/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$StringCast;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$AbstractMemoryLogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableName;
import com.corrodinggames.rts.game.units.y;
import java.util.Locale;

public class VariableScope$ReadUnitMemoryLogicBoolean
extends VariableScope$AbstractMemoryLogicBoolean {
    VariableScope$VariableName _name;
    LogicBoolean$ReturnType _type;
    @LogicBoolean$Parameter(key="default")
    public LogicBoolean defaultValue;
    @LogicBoolean$Parameter(key="index")
    public LogicBoolean index;

    @LogicBoolean$Parameter(required=true, positional=0)
    public void name(String string2) {
        string2 = string2.toLowerCase(Locale.ROOT).trim();
        this._name = VariableScope$VariableName.get(string2);
    }

    @LogicBoolean$Parameter(required=true)
    public void type(String string2) {
        this._type = VariableScope.getUserType(string2);
        if (this._type == null) {
            throw new RuntimeException("Unknown type: " + string2);
        }
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (this.defaultValue != null && this.defaultValue.getReturnType() != this._type) {
            throw new BooleanParseException("defaultValue type:" + (Object)((Object)this.defaultValue.getReturnType()) + " does not match requested type: " + (Object)((Object)this._type));
        }
        if (this.defaultValue == null) {
            this.defaultValue = VariableScope.variableDataNull;
        }
    }

    public LogicBoolean getUnitMemory(y y2) {
        if (y2.bw == null) {
            return this.defaultValue;
        }
        LogicBoolean logicBoolean = y2.bw.getAsLogicBoolean(this._name);
        if (logicBoolean == null) {
            return this.defaultValue;
        }
        if (this.index != null) {
            int n2 = (int)this.index.readNumber(y2);
            LogicBoolean logicBoolean2 = logicBoolean.readArrayElement(y2, n2);
            if (logicBoolean2 == null) {
                return this.defaultValue;
            }
            logicBoolean = logicBoolean2;
        }
        return logicBoolean;
    }

    @Override
    public boolean read(y y2) {
        return this.getUnitMemory(y2).read(y2);
    }

    @Override
    public float readNumber(y y2) {
        return this.getUnitMemory(y2).readNumber(y2);
    }

    @Override
    public String readString(y y2) {
        LogicBoolean logicBoolean = this.getUnitMemory(y2);
        return LogicString$StringCast.castToString(logicBoolean.getReturnType(), logicBoolean, y2);
    }

    @Override
    public BaseUnit readUnit(y y2) {
        return this.getUnitMemory(y2).readUnit(y2);
    }

    @Override
    public int getArraySize(y y2) {
        return this.getUnitMemory(y2).getArraySize(y2);
    }

    @Override
    public LogicBoolean readArrayElement(y y2, int n2) {
        return this.getUnitMemory(y2).readArrayElement(y2, n2);
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return this._type;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        if (this._type == null || this._name == null) {
            return "<memory with type/name == null>";
        }
        LogicBoolean logicBoolean = this.getUnitMemory(y2);
        if (logicBoolean != null) {
            String string2 = "";
            if (this._type != logicBoolean.getReturnType() && logicBoolean.getReturnType() != LogicBoolean$ReturnType.voidReturn) {
                string2 = "(TYPE MISMATCH GOT: " + logicBoolean.getReturnType().name() + ")";
            }
            return "memory(" + VariableScope$VariableName.access$000(this._name) + " as " + this._type.name() + "=" + logicBoolean.getMatchFailReasonForPlayer(y2) + string2 + ")";
        }
        return "memory(" + VariableScope$VariableName.access$000(this._name) + " as " + this._type.name() + ")";
    }
}

