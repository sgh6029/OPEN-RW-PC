/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.UnitCommand;
import com.corrodinggames.rts.game.units.UnitCommandType;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$AbstractNumberBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.am;

public class LogicBooleanGameFunctions$NumberOfQueuedWaypoints
extends LogicBoolean$AbstractNumberBoolean {
    UnitCommandType type;

    @LogicBoolean$Parameter
    public void type(String string2) {
        try {
            this.type = (UnitCommandType)IniFile.a(string2, null, UnitCommandType.class);
        } catch (bo e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "NumberOfQueuedWaypoints";
    }

    @Override
    public float getValue(y y2) {
        if (this.type == null) {
            return y2.av();
        }
        int n2 = 0;
        int n3 = y2.av();
        for (int i2 = 0; i2 < n3; ++i2) {
            boolean bl2;
            UnitCommand au2 = y2.k(i2);
            if (au2 == null) continue;
            boolean bl3 = bl2 = au2.d() == this.type;
            if (!bl2) continue;
            ++n2;
        }
        return n2;
    }

    @Override
    public float getMaxValue(y y2) {
        return 2.1474836E9f;
    }
}

