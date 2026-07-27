/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$CompareEqualBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$CompareGreaterThanNumbers;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$CompareGreaterThanOrEqualNumbers;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$CompareLessThanNumbers;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$CompareLessThanOrEqualNumbers;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$CompareNotEqualBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$MathAddJoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$MathDivideJoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$MathModulusJoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$MathMultiplyJoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$MathSubtractJoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$AndBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$OrBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.y;

public abstract class LogicBoolean$JoinerBoolean
extends LogicBoolean {
    LogicBoolean[] children;

    public abstract String type();

    public static LogicBoolean$JoinerBoolean getNewJoiner(String string2) {
        LogicBoolean$JoinerBoolean logicBoolean$JoinerBoolean;
        if (string2.equals("or")) {
            logicBoolean$JoinerBoolean = new LogicBoolean$OrBoolean();
        } else if (string2.equals("and")) {
            logicBoolean$JoinerBoolean = new LogicBoolean$AndBoolean();
        } else if (string2.equals("==")) {
            logicBoolean$JoinerBoolean = new CompareJoinerBoolean$CompareEqualBoolean();
        } else if (string2.equals("!=")) {
            logicBoolean$JoinerBoolean = new CompareJoinerBoolean$CompareNotEqualBoolean();
        } else if (string2.equals(">")) {
            logicBoolean$JoinerBoolean = new CompareJoinerBoolean$CompareGreaterThanNumbers();
        } else if (string2.equals(">=")) {
            logicBoolean$JoinerBoolean = new CompareJoinerBoolean$CompareGreaterThanOrEqualNumbers();
        } else if (string2.equals("<")) {
            logicBoolean$JoinerBoolean = new CompareJoinerBoolean$CompareLessThanNumbers();
        } else if (string2.equals("<=")) {
            logicBoolean$JoinerBoolean = new CompareJoinerBoolean$CompareLessThanOrEqualNumbers();
        } else if (string2.equals("%")) {
            logicBoolean$JoinerBoolean = new CompareJoinerBoolean$MathModulusJoinerBoolean();
        } else if (string2.equals("+")) {
            logicBoolean$JoinerBoolean = new CompareJoinerBoolean$MathAddJoinerBoolean();
        } else if (string2.equals("-")) {
            logicBoolean$JoinerBoolean = new CompareJoinerBoolean$MathSubtractJoinerBoolean();
        } else if (string2.equals("*")) {
            logicBoolean$JoinerBoolean = new CompareJoinerBoolean$MathMultiplyJoinerBoolean();
        } else if (string2.equals("/")) {
            logicBoolean$JoinerBoolean = new CompareJoinerBoolean$MathDivideJoinerBoolean();
        } else {
            throw new BooleanParseException("Unknown joiner:'" + string2 + "'");
        }
        return logicBoolean$JoinerBoolean;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        String string2 = "(";
        boolean bl2 = true;
        for (LogicBoolean logicBoolean : this.children) {
            if (bl2) {
                bl2 = false;
            } else {
                string2 = string2 + " " + this.type() + " ";
            }
            string2 = string2 + logicBoolean.getMatchFailReasonForPlayer(y2);
        }
        string2 = string2 + ")";
        return string2;
    }

    @Override
    public String getDebugDetails(j j2) {
        String string2 = "(";
        boolean bl2 = true;
        for (LogicBoolean logicBoolean : this.children) {
            if (bl2) {
                bl2 = false;
            } else {
                string2 = string2 + " " + this.type() + " ";
            }
            string2 = string2 + logicBoolean.getDebugDetails(j2);
        }
        string2 = string2 + ")";
        return string2;
    }

    @Override
    public final void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
    }

    @Override
    public LogicBoolean validateAndOptimize(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        return this;
    }

    public boolean requireBooleanChildren() {
        return true;
    }
}

