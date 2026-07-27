/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.y;

public final class CompareJoinerBoolean$CompareEqualUnits
extends CompareJoinerBoolean {
    @Override
    public String type() {
        return "==";
    }

    @Override
    public boolean read(y y2) {
        LogicBoolean[] logicBooleanArray = this.children;
        BaseUnit am2 = logicBooleanArray[0].readUnit(y2);
        for (int i2 = 1; i2 < logicBooleanArray.length; ++i2) {
            BaseUnit am3 = logicBooleanArray[i2].readUnit(y2);
            if (am2 != am3) {
                return false;
            }
            am2 = am3;
        }
        return true;
    }
}

