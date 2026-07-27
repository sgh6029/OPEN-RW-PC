/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.y;

public abstract class LogicString
extends LogicBoolean {
    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.string;
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return "TEXT";
    }

    @Override
    public boolean read(y y2) {
        return false;
    }

    @Override
    public float readNumber(y y2) {
        return 0.0f;
    }

    public static String arrayToString(y y2, LogicBoolean logicBoolean) {
        int n2 = logicBoolean.getArraySize(y2);
        String string2 = "[";
        for (int i2 = 0; i2 < n2; ++i2) {
            LogicBoolean logicBoolean2;
            if (i2 > 12) {
                string2 = string2 + ",...";
                break;
            }
            if (i2 != 0) {
                string2 = string2 + ",";
            }
            if ((logicBoolean2 = logicBoolean.readArrayElement(y2, i2)) == null) continue;
            string2 = string2 + logicBoolean2.valueToStringDebug(y2);
        }
        string2 = string2 + "]";
        return string2;
    }

    public static String arraySummaryToString(y y2, LogicBoolean logicBoolean) {
        int n2 = logicBoolean.getArraySize(y2);
        LogicBoolean$ReturnType logicBoolean$ReturnType = logicBoolean.getReturnType();
        LogicBoolean$ReturnType logicBoolean$ReturnType2 = LogicBoolean$ReturnType.getArrayBaseType(logicBoolean$ReturnType);
        String string2 = LogicBoolean$ReturnType.toUserString(logicBoolean$ReturnType2);
        String string3 = string2 + "[" + n2 + "]";
        return string3;
    }
}

