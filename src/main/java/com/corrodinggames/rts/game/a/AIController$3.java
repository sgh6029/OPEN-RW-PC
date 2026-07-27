/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.a.UnitBuildStrategy;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.l;

class AIController$3
extends UnitBuildStrategy {
    final /* synthetic */ AIController a;

    AIController$3(AIController a2, String string2) {
        super(a2, string2);
        this.a = a2;
    }

    @Override
    public boolean a(UnitType as2) {
        BaseUnit am2 = BaseUnit.b(as2);
        if (am2.bI() && as2.p()) {
            if (as2 instanceof l) {
                l l2 = (l)as2;
                if (l2.fw) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

