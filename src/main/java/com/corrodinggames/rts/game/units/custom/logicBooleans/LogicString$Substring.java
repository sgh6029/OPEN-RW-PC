/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$StringCast;
import com.corrodinggames.rts.game.units.y;

public class LogicString$Substring
extends LogicString {
    @LogicBoolean$Parameter(required=true, positional=0)
    public LogicBoolean text;
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number, required=true, positional=1)
    public LogicBoolean start;
    @LogicBoolean$Parameter(type=LogicBoolean$ReturnType.number, required=true, positional=2)
    public LogicBoolean end;

    @Override
    public LogicBoolean validateAndOptimize(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        if (this.text == null) {
            throw new BooleanParseException("Expected argument text");
        }
        if (this.text.getReturnType() != LogicBoolean$ReturnType.string) {
            this.text = LogicString$StringCast.createStringCast(this.text);
        }
        return super.validateAndOptimize(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
    }

    @Override
    public String readString(y y2) {
        String string2 = this.text.readString(y2);
        int n2 = (int)this.start.readNumber(y2);
        int n3 = (int)this.end.readNumber(y2);
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        if (n2 > string2.length()) {
            n2 = string2.length();
        }
        if (n3 > string2.length()) {
            n3 = string2.length();
        }
        if (n3 < n2) {
            n3 = n2;
        }
        string2 = string2.substring(n2, n3);
        return string2;
    }
}

