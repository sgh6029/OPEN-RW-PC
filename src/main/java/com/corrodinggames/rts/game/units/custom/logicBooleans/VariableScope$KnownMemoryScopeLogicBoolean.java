/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanScopeOnly;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$KnownMemoryReadLogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableDefinition;
import java.util.Locale;

public class VariableScope$KnownMemoryScopeLogicBoolean
extends LogicBooleanLoader$LogicBooleanScopeOnly {
    @Override
    public LogicBoolean parseNextElementInChain(String string2, l l2, String string3, boolean bl2, String string4, String string5, LogicBoolean logicBoolean) {
        String string6 = string3.toLowerCase(Locale.ROOT);
        VariableScope$VariableDefinition variableScope$VariableDefinition = l2.r.get(string6);
        if (variableScope$VariableDefinition == null) {
            throw new RuntimeException("Unknown variable:'" + string3 + "' in '" + string5 + "'");
        }
        VariableScope$KnownMemoryReadLogicBoolean variableScope$KnownMemoryReadLogicBoolean = new VariableScope$KnownMemoryReadLogicBoolean(variableScope$VariableDefinition);
        return variableScope$KnownMemoryReadLogicBoolean;
    }
}

