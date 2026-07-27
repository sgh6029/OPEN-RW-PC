/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.BaseUnit;

public class ActionFilter {
    public static final ActionFilter emptyActionFilter = new ActionFilter();

    public boolean isAvailable(AbstractUnitAction s2, BaseUnit am2) {
        return true;
    }
}

