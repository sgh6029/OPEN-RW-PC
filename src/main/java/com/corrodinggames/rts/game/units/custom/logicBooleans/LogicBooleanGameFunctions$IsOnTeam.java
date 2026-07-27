/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$LogicBooleanCommonLocking;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.y;

public class LogicBooleanGameFunctions$IsOnTeam
extends LogicBoolean$LogicBooleanCommonLocking {
    int teamId = -99;

    @LogicBoolean$Parameter
    public void team(int n2) {
        if (n2 < -1 || n2 > PlayerTeam.c) {
            throw new BooleanParseException("Flag id must be between 0-" + PlayerTeam.c);
        }
        this.teamId = n2;
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (this.teamId == -99) {
            throw new BooleanParseException("Expended teamId argument for function:" + string2);
        }
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        String string2 = "Team";
        string2 = string2 + "(id:" + this.teamId + ")";
        return string2;
    }

    @Override
    public boolean read(y y2) {
        boolean bl2 = true;
        if (y2.bX.k != this.teamId) {
            bl2 = false;
        }
        return bl2;
    }
}

