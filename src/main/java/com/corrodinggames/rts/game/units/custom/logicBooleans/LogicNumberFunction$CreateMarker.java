/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticValueBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.y;

public class LogicNumberFunction$CreateMarker
extends UnitReference {
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number, positional=0, required=true)
    public LogicBoolean x;
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number, positional=1, required=true)
    public LogicBoolean y;
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number, positional=2, required=false)
    public LogicBoolean height;
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number)
    public LogicBoolean teamId;
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number)
    public LogicBoolean dir;

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (this.height == null) {
            this.height = LogicBoolean$StaticValueBoolean.static_0;
        }
        if (this.dir == null) {
            this.dir = LogicBoolean$StaticValueBoolean.static_0;
        }
        if (this.teamId == null) {
            this.teamId = LogicBoolean$StaticValueBoolean.static_neg1;
        }
    }

    @Override
    public BaseUnit getSingleRaw(y y2) {
        float f2 = this.x.readNumber(y2);
        float f3 = this.y.readNumber(y2);
        float f4 = this.height.readNumber(y2);
        float f5 = this.dir.readNumber(y2);
        PlayerTeam n2 = PlayerTeam.k((int)this.teamId.readNumber(y2));
        if (n2 == null) {
            n2 = PlayerTeam.i;
        }
        y y3 = n2.t;
        y3.cg = f5;
        y3.posX = f2;
        y3.posY = f3;
        y3.posZ = f4;
        return y3;
    }

    @Override
    public String getClassDebugName() {
        return "createMarker";
    }
}

