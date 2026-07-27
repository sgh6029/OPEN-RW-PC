/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.y;

public class LogicBooleanGameFunctions$InMapBoolean
extends LogicBoolean {
    @Override
    public boolean read(y y2) {
        boolean bl2 = false;
        if (com.corrodinggames.rts.gameFramework.utility.y.a(y2.posX, y2.posY)) {
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return "InMap";
    }
}

