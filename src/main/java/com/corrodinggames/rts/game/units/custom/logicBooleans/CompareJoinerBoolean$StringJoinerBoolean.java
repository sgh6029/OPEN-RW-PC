/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$StaticString;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$StringCast;
import com.corrodinggames.rts.game.units.y;

public final class CompareJoinerBoolean$StringJoinerBoolean
extends CompareJoinerBoolean {
    @Override
    public String type() {
        return "+";
    }

    @Override
    public LogicBoolean validateAndOptimize(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        int n2;
        for (n2 = 0; n2 < this.children.length; ++n2) {
            if (this.children[n2].getReturnType() == LogicBoolean$ReturnType.string) continue;
            this.children[n2] = LogicString$StringCast.createStringCast(this.children[n2]);
        }
        n2 = 1;
        for (LogicBoolean logicBoolean : this.children) {
            if (logicBoolean instanceof LogicString$StaticString) continue;
            n2 = 0;
        }
        if (n2 != 0) {
            String string5 = this.readString(null);
            return new LogicString$StaticString(string5);
        }
        return super.validateAndOptimize(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
    }

    @Override
    public String readString(y y2) {
        String string2 = this.children[0].readString(y2);
        for (int i2 = 1; i2 < this.children.length; ++i2) {
            string2 = string2 + this.children[i2].readString(y2);
        }
        return string2;
    }

    @Override
    public boolean read(y y2) {
        return false;
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.string;
    }
}

