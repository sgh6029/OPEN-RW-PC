/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticValueBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$StaticString;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.utility.al;
import java.util.ArrayList;

class LogicString$StringCast
extends LogicString {
    LogicBoolean child;
    LogicBoolean$ReturnType sourceType;

    @Override
    public void setArgumentsRaw(String string2, l l2, String string3) {
        if (string2 == null || "".equals(string2)) {
            this.validateNumberOfArguments(0);
            return;
        }
        ArrayList arrayList = al.a(string2, ",", false);
        this.validateNumberOfArguments(arrayList.size());
        this.child = LogicBooleanLoader.parseBooleanBlock(l2, (String)arrayList.get(0), false);
        if (this.child == null) {
            throw new BooleanParseException("Expected non-null argument");
        }
    }

    public void validateNumberOfArguments(int n2) {
        if (n2 != 1) {
            throw new BooleanParseException("Expected 1 argument");
        }
    }

    public static LogicBoolean createStringCast(LogicBoolean logicBoolean) {
        LogicString$StringCast logicString$StringCast = new LogicString$StringCast();
        logicString$StringCast.child = logicBoolean;
        return logicString$StringCast.validateAndOptimize("cast", "", "", null, false);
    }

    @Override
    public LogicBoolean validateAndOptimize(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        this.sourceType = this.child.getReturnType();
        if (this.child instanceof LogicString$StaticString) {
            return this.child;
        }
        if (this.child instanceof LogicBoolean$StaticBoolean) {
            return new LogicString$StaticString(this.readString(null));
        }
        if (this.child instanceof LogicBoolean$StaticValueBoolean) {
            return new LogicString$StaticString(this.readString(null));
        }
        return super.validateAndOptimize(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
    }

    @Override
    public String readString(y y2) {
        return LogicString$StringCast.castToString(this.sourceType, this.child, y2);
    }

    public static String castToString(LogicBoolean$ReturnType logicBoolean$ReturnType, LogicBoolean logicBoolean, y y2) {
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.number) {
            float f2 = logicBoolean.readNumber(y2);
            return GameUtils.a(f2, 2);
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.unit) {
            return BaseUnit.A(logicBoolean.readUnit(y2));
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.string) {
            String string2 = logicBoolean.readString(y2);
            return string2;
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.numberArray) {
            String string3 = LogicString$StringCast.arrayToString(y2, logicBoolean);
            return string3;
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.boolArray) {
            String string4 = LogicString$StringCast.arrayToString(y2, logicBoolean);
            return string4;
        }
        boolean bl2 = logicBoolean.read(y2);
        return bl2 ? "true" : "false";
    }
}

