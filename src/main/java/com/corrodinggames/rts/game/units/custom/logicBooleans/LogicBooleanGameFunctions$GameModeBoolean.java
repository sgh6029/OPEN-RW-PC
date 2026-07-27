/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$LogicBooleanCommonLocking;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class LogicBooleanGameFunctions$GameModeBoolean
extends LogicBoolean$LogicBooleanCommonLocking {
    @LogicBoolean$Parameter
    public boolean nukesEnabled;

    @Override
    public boolean read(y y2) {
        boolean bl2 = true;
        GameEngine l2 = GameEngine.getInstance();
        if (this.nukesEnabled && l2.O() && l2.networkEngine.ay.i) {
            bl2 = false;
        }
        return bl2;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return "GameMode(" + (this.nukesEnabled ? "Nukes enabled" : "Nukes disabled") + ")";
    }
}

