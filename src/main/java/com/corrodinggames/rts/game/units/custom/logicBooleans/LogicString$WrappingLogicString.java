/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString;
import com.corrodinggames.rts.gameFramework.utility.al;
import java.util.ArrayList;

public class LogicString$WrappingLogicString
extends LogicString {
    LogicBoolean[] children;

    @Override
    public void setArgumentsRaw(String string2, l l2, String string3) {
        if (string2 == null || "".equals(string2)) {
            this.validateNumberOfArguments(0);
            return;
        }
        ArrayList arrayList = al.a(string2, ",", false);
        this.validateNumberOfArguments(arrayList.size());
        this.children = new LogicBoolean[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            this.children[i2] = LogicBooleanLoader.parseBooleanBlock(l2, (String)arrayList.get(i2), false);
            if (this.children != null) continue;
            throw new BooleanParseException("Expected non-null argument");
        }
    }

    public void validateNumberOfArguments(int n2) {
        if (n2 != 1) {
            throw new BooleanParseException("Expected 1 argument");
        }
    }
}

