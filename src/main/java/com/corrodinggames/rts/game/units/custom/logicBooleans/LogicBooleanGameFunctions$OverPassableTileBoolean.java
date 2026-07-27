/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$LogicBooleanCommonLocking;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class LogicBooleanGameFunctions$OverPassableTileBoolean
extends LogicBoolean$LogicBooleanCommonLocking {
    UnitMovementType movementType = UnitMovementType.LAND;

    @LogicBoolean$Parameter
    public void type(String string2) {
        this.movementType = UnitMovementType.a(string2, "isOverPassableTile()");
    }

    @Override
    public boolean read(y y2) {
        boolean bl2 = false;
        GameEngine l2 = GameEngine.getInstance();
        if (!com.corrodinggames.rts.gameFramework.utility.y.a(y2.posX, y2.posY, this.movementType)) {
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return "OverLand";
    }
}

