/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ArrayContextReader$ArrayContains;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ArrayContextReader$ArrayFunction;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ArrayContextReader$ArrayGet;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ArrayContextReader$ArrayGetUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ArrayContextReader$ArraySize;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContextWithDefault;
import java.util.HashMap;
import java.util.Locale;

public final class LogicBooleanLoader$ArrayContextReader
extends LogicBooleanLoader$LogicBooleanContextWithDefault {
    LogicBoolean$ReturnType arrayType;
    static HashMap arrayFunctions = new HashMap();
    static HashMap arrayFunctionsUnit;

    public LogicBooleanLoader$ArrayContextReader(LogicBoolean$ReturnType logicBoolean$ReturnType) {
        this.arrayType = logicBoolean$ReturnType;
    }

    public static void addContextFunction(HashMap hashMap, LogicBoolean logicBoolean, String ... stringArray) {
        for (String string2 : stringArray) {
            if (hashMap.get(string2 = string2.toLowerCase(Locale.ROOT)) != null) {
                throw new RuntimeException("logicBoolean: " + string2 + " already exists");
            }
            hashMap.put(string2, logicBoolean);
        }
    }

    @Override
    public LogicBoolean parseNextElementInChain(String string2, l l2, String string3, boolean bl2, String string4, String string5, LogicBoolean logicBoolean) {
        LogicBoolean logicBoolean2 = this.arrayType == LogicBoolean$ReturnType.unitArray ? LogicBooleanLoader$ArrayContextReader.defaultParseNextElementInChain(this, null, l2, string3, bl2, string4, string5, logicBoolean, arrayFunctionsUnit) : LogicBooleanLoader$ArrayContextReader.defaultParseNextElementInChain(this, null, l2, string3, bl2, string4, string5, logicBoolean, arrayFunctions);
        if (logicBoolean2 == null) {
            return null;
        }
        if (!(logicBoolean2 instanceof LogicBooleanLoader$ArrayContextReader$ArrayFunction)) {
            throw new RuntimeException("Expected array function.");
        }
        LogicBooleanLoader$ArrayContextReader$ArrayFunction logicBooleanLoader$ArrayContextReader$ArrayFunction = (LogicBooleanLoader$ArrayContextReader$ArrayFunction)logicBoolean2;
        logicBooleanLoader$ArrayContextReader$ArrayFunction.setArrayTarget(logicBoolean);
        return logicBooleanLoader$ArrayContextReader$ArrayFunction;
    }

    static {
        LogicBooleanLoader$ArrayContextReader.addContextFunction(arrayFunctions, new LogicBooleanLoader$ArrayContextReader$ArrayGet(), "get");
        LogicBooleanLoader$ArrayContextReader.addContextFunction(arrayFunctions, new LogicBooleanLoader$ArrayContextReader$ArraySize(), "size");
        LogicBooleanLoader$ArrayContextReader.addContextFunction(arrayFunctions, new LogicBooleanLoader$ArrayContextReader$ArraySize(), "length");
        LogicBooleanLoader$ArrayContextReader.addContextFunction(arrayFunctions, new LogicBooleanLoader$ArrayContextReader$ArrayContains(), "contains");
        arrayFunctionsUnit = new HashMap();
        LogicBooleanLoader$ArrayContextReader.addContextFunction(arrayFunctionsUnit, new LogicBooleanLoader$ArrayContextReader$ArrayGetUnit(), "get");
        LogicBooleanLoader$ArrayContextReader.addContextFunction(arrayFunctionsUnit, new LogicBooleanLoader$ArrayContextReader$ArraySize(), "size");
        LogicBooleanLoader$ArrayContextReader.addContextFunction(arrayFunctionsUnit, new LogicBooleanLoader$ArrayContextReader$ArraySize(), "length");
        LogicBooleanLoader$ArrayContextReader.addContextFunction(arrayFunctionsUnit, new LogicBooleanLoader$ArrayContextReader$ArrayContains(), "contains");
    }
}

