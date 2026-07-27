/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.a.UnitBuildStrategy;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitType;

class AIController$6
extends UnitBuildStrategy {
    final /* synthetic */ AIController a;

    AIController$6(AIController a2, String string2) {
        super(a2, string2);
        this.a = a2;
    }

    @Override
    public boolean a(UnitType as2) {
        return com.corrodinggames.rts.game.a.AIController.a(this.a, as2) && this.a(as2, UnitMovementType.HOVER);
    }
}

