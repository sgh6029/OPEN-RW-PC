/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.e.a_f3;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanGameFunctions$ResourceCountBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanScopeOnly;

public class LogicBooleanGameFunctions$ResourceScope
extends LogicBooleanLoader$LogicBooleanScopeOnly {
    @Override
    public LogicBoolean parseNextElementInChain(String string2, l l2, String string3, boolean bl2, String string4, String string5, LogicBoolean logicBoolean) {
        String string6 = string3;
        a_f3 a2 = l2.j(string6);
        if (a2 == null) {
            throw new BooleanParseException("'" + string4 + "': Could not find resource: '" + string6 + "'");
        }
        LogicBooleanGameFunctions$ResourceCountBoolean logicBooleanGameFunctions$ResourceCountBoolean = new LogicBooleanGameFunctions$ResourceCountBoolean();
        logicBooleanGameFunctions$ResourceCountBoolean.meta = l2;
        logicBooleanGameFunctions$ResourceCountBoolean.type = a2;
        return logicBooleanGameFunctions$ResourceCountBoolean;
    }
}

