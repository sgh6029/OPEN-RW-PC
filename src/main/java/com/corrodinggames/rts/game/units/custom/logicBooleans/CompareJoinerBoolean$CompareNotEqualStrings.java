/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.y;

public final class CompareJoinerBoolean$CompareNotEqualStrings
extends CompareJoinerBoolean {
    @Override
    public String type() {
        return "!=";
    }

    @Override
    public boolean read(y y2) {
        LogicBoolean[] logicBooleanArray = this.children;
        String string2 = logicBooleanArray[0].readString(y2);
        if (string2 == null) {
            string2 = "";
        }
        for (int i2 = 1; i2 < logicBooleanArray.length; ++i2) {
            String string3 = logicBooleanArray[i2].readString(y2);
            if (string3 == null) {
                string3 = "";
            }
            if (string2.equals(string3)) {
                return false;
            }
            string2 = string3;
        }
        return true;
    }
}

