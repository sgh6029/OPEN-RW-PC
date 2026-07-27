/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.a.ActionFilter;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;

public class LogicBooleanActionFilter
extends ActionFilter {
    LogicBoolean logicBoolean;
    j target;

    public LogicBooleanActionFilter(LogicBoolean logicBoolean, j j2) {
        this.logicBoolean = logicBoolean;
    }

    @Override
    public boolean isAvailable(AbstractUnitAction s2, BaseUnit am2) {
        return this.logicBoolean.read(this.target);
    }
}

