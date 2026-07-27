/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.UnitCommand;
import com.corrodinggames.rts.game.units.UnitCommandType;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.am;

public class LogicBooleanGameFunctions$HasActiveWaypoint
extends LogicBoolean {
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
    public boolean read(y y2) {
        boolean bl2 = false;
        UnitCommand au2 = y2.ar();
        if (au2 != null) {
            bl2 = this.type == null ? true : au2.d() == this.type;
        }
        return bl2;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return "HasActiveWaypoint(type=" + (Object)((Object)this.type) + ")";
    }
}

