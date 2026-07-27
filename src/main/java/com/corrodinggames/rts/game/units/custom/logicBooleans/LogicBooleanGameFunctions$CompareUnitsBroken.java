/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ParameterMapping;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.y;

public class LogicBooleanGameFunctions$CompareUnitsBroken
extends LogicBoolean {
    l meta;
    UnitReference sameUnitAs;

    @Override
    public void forMeta(l l2) {
        if (l2 == null) {
            throw new BooleanParseException("SameUnitAs requires metadata");
        }
        this.meta = l2;
    }

    @LogicBoolean$Parameter
    public void sameUnitAs(String string2) {
        try {
            this.sameUnitAs = UnitReference.parseUnitReference(this.meta, string2, "", "", null, false);
        }
        catch (bo bo2) {
            throw new BooleanParseException(bo2.getMessage(), bo2);
        }
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (this.sameUnitAs == null) {
            LogicBooleanLoader$ParameterMapping logicBooleanLoader$ParameterMapping = this.getParameters();
            throw new BooleanParseException("Missing required parameters (Possible parameters:" + logicBooleanLoader$ParameterMapping.allParametersString + ")");
        }
    }

    @Override
    public boolean read(y y2) {
        boolean bl2 = true;
        return bl2;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return "SameUnitAs";
    }
}

