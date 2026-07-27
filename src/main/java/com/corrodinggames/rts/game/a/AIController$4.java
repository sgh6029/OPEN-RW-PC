/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import java.util.List;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.PopupQueueAction;
import com.corrodinggames.rts.game.units.custom.l;

class AIController$4
extends UnitBuildStrategy {
    final /* synthetic */ AIController a;

    AIController$4(AIController a2, String string2) {
        super(a2, string2);
        this.a = a2;
    }

    @Override
    public boolean a(UnitType as2) {
        BaseUnit am2 = BaseUnit.b(as2);
        if (am2.bI()) {
            if (as2 instanceof l) {
                l l2 = (l)as2;
                if (l2.fw) {
                    return false;
                }
            }
            boolean bl2 = false;
            List<AbstractUnitAction> tmp = am2.N();
            for (AbstractUnitAction s2 : tmp) {
                UnitType as3;
                PopupQueueAction w2;
                if (s2 == null || !(s2 instanceof PopupQueueAction) || (w2 = (PopupQueueAction)s2).F() || (as3 = w2.i()) == null || as3.j()) continue;
                bl2 = true;
            }
            if (bl2) {
                return true;
            }
        }
        return false;
    }
}

