/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.c.a;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$AbstractNumberBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.y;

public final class LogicBooleanGameFunctions$NumberOfConnectionsBoolean
extends LogicBoolean$AbstractNumberBoolean {
    l meta;
    a connectionMetadata;

    @Override
    public void forMeta(l l2) {
        if (l2 == null) {
            throw new BooleanParseException("NumberOfConnectionsBoolean requires metadata");
        }
        this.meta = l2;
    }

    @LogicBoolean$Parameter
    public void name(String string2) {
        this.connectionMetadata = this.meta.l(string2);
        if (this.connectionMetadata == null) {
            throw new BooleanParseException("Could not find connection type with name: " + string2);
        }
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (logicBooleanLoader$LogicBooleanContext != null && logicBooleanLoader$LogicBooleanContext != LogicBooleanLoader.defaultContextReader) {
            throw new BooleanParseException("Function:" + string2 + " only supports use with 'self.'");
        }
        if (this.connectionMetadata == null) {
            throw new BooleanParseException("requires connection name");
        }
    }

    @Override
    public String getName() {
        return "NumberOfConnections";
    }

    @Override
    public float getValue(y y2) {
        return y2.dI.a(this.connectionMetadata);
    }

    @Override
    public float getMaxValue(y y2) {
        return 2.1474836E9f;
    }
}

