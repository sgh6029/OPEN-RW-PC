/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.a.UnitBuildStrategy;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitType;

class AIController$12
extends UnitBuildStrategy {
    final /* synthetic */ AIController a;

    AIController$12(AIController a2, String string2) {
        super(a2, string2);
        this.a = a2;
    }

    @Override
    public boolean a(UnitType as2) {
        return this.a.bw.a(as2) && as2.o() != UnitMovementType.AIR;
    }
}

