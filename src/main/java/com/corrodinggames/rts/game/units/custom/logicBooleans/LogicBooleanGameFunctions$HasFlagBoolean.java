/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.y;

public class LogicBooleanGameFunctions$HasFlagBoolean
extends LogicBoolean {
    public int flagMask = 0;
    public int flagId = -1;

    @LogicBoolean$Parameter(positional=0)
    public void id(int n2) {
        if (n2 < 0 || n2 > 31) {
            throw new BooleanParseException("Flag id must be between 0-31");
        }
        this.flagId = n2;
        this.flagMask = 1 << n2;
    }

    public static boolean isFlagSet(int n2, int n3) {
        return (n3 & n2) == n3;
    }

    public static byte setFlag(int n2, int n3) {
        return (byte)(n3 | n2);
    }

    public static byte unsetFlag(int n2, int n3) {
        return (byte)(n3 & ~n2);
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        String string2 = "HasFlag";
        string2 = string2 + "(id:" + this.flagId + ")";
        return string2;
    }

    @Override
    public boolean read(y y2) {
        boolean bl2 = true;
        if (this.flagMask != 0 && !LogicBooleanGameFunctions$HasFlagBoolean.isFlagSet(y2.cF, this.flagMask)) {
            bl2 = false;
        }
        return bl2;
    }
}

