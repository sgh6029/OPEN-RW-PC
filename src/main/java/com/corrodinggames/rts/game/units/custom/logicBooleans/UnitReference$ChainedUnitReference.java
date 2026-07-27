/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.y;

public class UnitReference$ChainedUnitReference
extends UnitReference {
    UnitReference[] chain;

    UnitReference$ChainedUnitReference(UnitReference[] unitReferenceArray) {
        this.chain = unitReferenceArray;
    }

    @Override
    public BaseUnit getSingleRaw(y y2) {
        UnitReference[] unitReferenceArray = this.chain;
        BaseUnit am2 = y2;
        LogicBoolean.outerUnitParameterContext = y2;
        for (int i2 = 0; i2 < unitReferenceArray.length; ++i2) {
            if ((am2 = unitReferenceArray[i2].get(am2)) != null) continue;
            return null;
        }
        LogicBoolean.outerUnitParameterContext = null;
        return am2;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        UnitReference[] unitReferenceArray = this.chain;
        BaseUnit am2 = y2;
        String string2 = "";
        if (am2 instanceof y) {
            LogicBoolean.outerUnitParameterContext = (y) am2;
        }
        string2 = string2 + "[";
        for (int i2 = 0; i2 < unitReferenceArray.length; ++i2) {
            string2 = string2 + unitReferenceArray[i2].getMatchFailReasonForPlayer(y2);
            if (i2 != unitReferenceArray.length - 1) {
                string2 = string2 + ",";
            }
            if ((am2 = unitReferenceArray[i2].get(am2)) != null) continue;
            string2 = string2 + "<null>";
            break;
        }
        LogicBoolean.outerUnitParameterContext = null;
        string2 = string2 + "]";
        return string2;
    }
}

