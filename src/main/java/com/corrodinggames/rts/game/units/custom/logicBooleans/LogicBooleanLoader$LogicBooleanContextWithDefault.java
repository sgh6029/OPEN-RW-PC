/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

public abstract class LogicBooleanLoader$LogicBooleanContextWithDefault
implements LogicBooleanLoader$LogicBooleanContext {
    @Override
    public LogicBoolean parseNextElementInChain(String string2, l l2, String string3, boolean bl2, String string4, String string5, LogicBoolean logicBoolean) {
        return LogicBooleanLoader$LogicBooleanContextWithDefault.defaultParseNextElementInChain(this, string2, l2, string3, bl2, string4, string5, logicBoolean, LogicBoolean.booleans);
    }

    public static LogicBoolean defaultParseNextElementInChain(LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, String string2, l l2, String string3, boolean bl2, String string4, String string5, LogicBoolean logicBoolean, HashMap hashMap) {
        LogicBoolean logicBoolean2;
        String string6;
        String string7;
        UnitReference unitReference = UnitReference.parseSingleUnitReferenceElement(l2, string3);
        if (unitReference != null) {
            return unitReference;
        }
        int n2 = string3.indexOf("(");
        if (n2 == -1) {
            string7 = string3.toLowerCase(Locale.ROOT);
            string6 = "";
        } else {
            string7 = string3.substring(0, n2).trim().toLowerCase(Locale.ROOT);
            string6 = string3.substring(n2);
        }
        if (string2 != null) {
            string7 = string2 + string7;
        }
        if ((logicBoolean2 = (LogicBoolean)hashMap.get(string7)) != null) {
            String string8 = LogicBooleanLoader.fixArguments(string6);
            LogicBoolean logicBoolean3 = logicBoolean2.with(l2, string8, string7);
            logicBoolean3 = logicBoolean3.validateAndOptimize(string7, string8, string4, logicBooleanLoader$LogicBooleanContext, bl2);
            return logicBoolean3;
        }
        String string9 = "";
        if (hashMap != null && hashMap.size() < 8 && hashMap.size() > 0) {
            string9 = " (Allowed functions: ";
            boolean bl3 = true;
            for (String string10 : ((Set<String>)hashMap.keySet())) {
                if (!bl3) {
                    string9 = string9 + ", ";
                }
                bl3 = false;
                string9 = string9 + string10;
            }
            string9 = string9 + ")";
        }
        if (string5 != null) {
            throw new RuntimeException("Unknown function or field:'" + string3 + "' in '" + string5 + "'" + string9);
        }
        throw new RuntimeException("Unknown function or field:'" + string3 + "'" + string9);
    }
}

