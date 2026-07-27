/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ArrayContextReader$ArrayFunction;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.utility.al;
import java.util.ArrayList;

public class LogicBooleanLoader$ArrayContextReader$ArrayGet
extends LogicBooleanLoader$ArrayContextReader$ArrayFunction {
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number)
    public LogicBoolean index;
    LogicBoolean targetArray;
    public LogicBoolean$ReturnType elementType;

    @Override
    public LogicBooleanLoader$LogicBooleanContext createContext() {
        return LogicBooleanLoader.voidArrayContextReader;
    }

    @Override
    public void setArrayTarget(LogicBoolean logicBoolean) {
        this.targetArray = logicBoolean;
        LogicBoolean$ReturnType logicBoolean$ReturnType = logicBoolean.getReturnType();
        this.elementType = LogicBoolean$ReturnType.getArrayBaseType(logicBoolean$ReturnType);
    }

    @Override
    public void setArgumentsRaw(String string2, l l2, String string3) {
        if (string2 == null || "".equals(string2)) {
            this.validateNumberOfArguments(0);
            return;
        }
        ArrayList arrayList = al.a(string2, ",", false);
        this.validateNumberOfArguments(arrayList.size());
        this.index = LogicBooleanLoader.parseNumberBlock(l2, (String)arrayList.get(0));
        if (this.index == null) {
            throw new BooleanParseException("Expected non-null argument");
        }
    }

    public void validateNumberOfArguments(int n2) {
        if (n2 != 1) {
            throw new BooleanParseException("Expected 1 argument");
        }
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (this.index == null) {
            throw new BooleanParseException("No array index");
        }
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return this.elementType;
    }

    LogicBoolean readElement(y y2) {
        int n2 = (int)this.index.readNumber(y2);
        if (this.targetArray == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("ArrayGet readElement targetArray==null");
            return null;
        }
        LogicBoolean logicBoolean = this.targetArray.readArrayElement(y2, n2);
        return logicBoolean;
    }

    @Override
    public boolean read(y y2) {
        LogicBoolean logicBoolean = this.readElement(y2);
        if (logicBoolean == null) {
            return false;
        }
        return logicBoolean.read(y2);
    }

    @Override
    public float readNumber(y y2) {
        LogicBoolean logicBoolean = this.readElement(y2);
        if (logicBoolean == null) {
            return 0.0f;
        }
        return logicBoolean.readNumber(y2);
    }

    @Override
    public BaseUnit readUnit(y y2) {
        LogicBoolean logicBoolean = this.readElement(y2);
        if (logicBoolean == null) {
            return null;
        }
        return logicBoolean.readUnit(y2);
    }

    public String getName() {
        return "get";
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        LogicBoolean logicBoolean = this.readElement(y2);
        int n2 = (int)this.index.readNumber(y2);
        String string2 = "";
        if (this.targetArray != null) {
            string2 = string2 + this.targetArray.getMatchFailReasonForPlayer(y2);
        }
        string2 = string2 + "." + this.getName() + "(" + n2 + ")";
        string2 = logicBoolean == null ? string2 + "=null" : string2 + "=" + logicBoolean.getMatchFailReasonForPlayer(y2);
        return string2;
    }
}

