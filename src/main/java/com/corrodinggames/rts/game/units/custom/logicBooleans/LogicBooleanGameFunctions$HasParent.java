/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.y;

public final class LogicBooleanGameFunctions$HasParent
extends LogicBoolean {
    public g _withTag;

    @LogicBoolean$Parameter
    public void withTag(String string2) {
        this._withTag = g.c(string2);
    }

    @Override
    public boolean read(y y2) {
        boolean bl2 = false;
        BaseUnit am2 = y2.dr();
        if (am2 != null) {
            h h2;
            bl2 = true;
            if (this._withTag != null && !g.a(this._withTag, h2 = am2.de())) {
                bl2 = false;
            }
        }
        return bl2;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return "HasParent";
    }
}

