/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.f.al;

final class al$6
extends al {
    al$6() {
    }

    @Override
    public boolean a(y y2) {
        return y2.r() == UnitTypeEnum.airFactory && y2.cN == null;
    }
}

