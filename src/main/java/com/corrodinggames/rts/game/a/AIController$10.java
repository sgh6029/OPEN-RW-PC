/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.l;

class AIController$10
extends UnitBuildStrategy {
    final /* synthetic */ AIController a;

    AIController$10(AIController a2, String string2) {
        super(a2, string2);
        this.a = a2;
    }

    @Override
    public boolean a(UnitType as2) {
        BaseUnit am2 = BaseUnit.b(as2);
        if (this.a.g(am2)) {
            if (as2 instanceof l) {
                l l2 = (l)as2;
                if (l2.fw) {
                    return false;
                }
            }
            if (as2.o() == UnitMovementType.AIR || as2.o() == UnitMovementType.HOVER || as2.o() == UnitMovementType.OVER_CLIFF_WATER) {
                return true;
            }
        }
        return false;
    }
}

