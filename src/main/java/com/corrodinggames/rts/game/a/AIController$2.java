/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.l;

class AIController$2
extends UnitBuildStrategy {
    final /* synthetic */ AIController a;

    AIController$2(AIController a2, String string2) {
        super(a2, string2);
        this.a = a2;
    }

    @Override
    public boolean a(UnitType as2) {
        BaseUnit am2 = BaseUnit.b(as2);
        if (as2.n()) {
            if (as2 instanceof l) {
                l l2 = (l)as2;
                if (l2.fw) {
                    return false;
                }
            }
            if (as2.o() != UnitMovementType.WATER) {
                return true;
            }
        }
        return false;
    }
}

