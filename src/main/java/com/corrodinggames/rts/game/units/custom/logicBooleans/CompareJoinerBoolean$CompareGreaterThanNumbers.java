/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.y;

public final class CompareJoinerBoolean$CompareGreaterThanNumbers
extends CompareJoinerBoolean$CompareNumbers {
    @Override
    public String type() {
        return ">";
    }

    @Override
    public boolean read(y y2) {
        LogicBoolean[] logicBooleanArray = this.children;
        float f2 = logicBooleanArray[0].readNumber(y2);
        for (int i2 = 1; i2 < logicBooleanArray.length; ++i2) {
            float f3 = logicBooleanArray[i2].readNumber(y2);
            if (!(f2 > f3)) {
                return false;
            }
            f2 = f3;
        }
        return true;
    }
}

