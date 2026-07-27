/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.aq;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;

public class an
extends aq {
    an(LogicBoolean logicBoolean) {
        super(logicBoolean);
    }

    @Override
    String a(y y2) {
        return GameUtils.g(this.a.readNumber(y2));
    }
}

