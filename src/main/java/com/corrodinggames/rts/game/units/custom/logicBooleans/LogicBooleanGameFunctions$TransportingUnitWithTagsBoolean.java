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
import com.corrodinggames.rts.gameFramework.utility.m;

public class LogicBooleanGameFunctions$TransportingUnitWithTagsBoolean
extends LogicBoolean {
    public g includesTag;

    @LogicBoolean$Parameter
    public void includes(String string2) {
        this.includesTag = g.c(string2);
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        String string2 = "TransportingUnitWithTags ";
        if (this.includesTag != null) {
            string2 = string2 + " includes " + this.includesTag;
        }
        return string2;
    }

    @Override
    public boolean read(y y2) {
        m m2;
        boolean bl2 = false;
        if (this.includesTag != null && (m2 = y2.bz()) != null) {
            Object[] objectArray = m2.a();
            for (int i2 = 0; i2 < m2.a; ++i2) {
                BaseUnit am2 = (BaseUnit)objectArray[i2];
                h h2 = am2.de();
                if (h2 == null || !g.a(this.includesTag, h2)) continue;
                bl2 = true;
            }
        }
        return bl2;
    }
}

