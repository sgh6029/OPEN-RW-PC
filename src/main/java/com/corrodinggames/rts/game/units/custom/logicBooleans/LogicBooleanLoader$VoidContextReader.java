/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContextWithDefault;

public final class LogicBooleanLoader$VoidContextReader
extends LogicBooleanLoader$LogicBooleanContextWithDefault {
    String debugType;

    LogicBooleanLoader$VoidContextReader(String string2) {
        this.debugType = string2;
    }

    @Override
    public LogicBoolean parseNextElementInChain(String string2, l l2, String string3, boolean bl2, String string4, String string5, LogicBoolean logicBoolean) {
        if (string5 != null) {
            if (this.debugType != null) {
                throw new RuntimeException("No field:'" + string3 + "' in '" + string5 + "' (" + this.debugType + ")");
            }
            throw new RuntimeException("No field:'" + string3 + "' in '" + string5 + "'");
        }
        throw new RuntimeException("No field:'" + string3 + "'");
    }
}

