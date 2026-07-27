/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$AbstractNumberBoolean;
import com.corrodinggames.rts.game.units.y;

public final class LogicBooleanGameFunctions$PositionXBoolean
extends LogicBoolean$AbstractNumberBoolean {
    @Override
    public String getName() {
        return "x";
    }

    @Override
    public float getValue(y y2) {
        return y2.posX;
    }

    @Override
    public float getMaxValue(y y2) {
        return 2.1474836E9f;
    }
}

