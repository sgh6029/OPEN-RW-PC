/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ArrayContextReader$ArrayFunction;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.utility.al;
import java.util.ArrayList;

public class LogicBooleanLoader$ArrayContextReader$ArrayContains
extends LogicBooleanLoader$ArrayContextReader$ArrayFunction {
    public LogicBoolean value;
    LogicBoolean targetArray;
    public LogicBoolean$ReturnType elementType;

    @Override
    public LogicBooleanLoader$LogicBooleanContext createContext() {
        return LogicBooleanLoader.voidNumberContextReader;
    }

    @Override
    public void setArrayTarget(LogicBoolean logicBoolean) {
        this.targetArray = logicBoolean;
        LogicBoolean$ReturnType logicBoolean$ReturnType = logicBoolean.getReturnType();
        this.elementType = LogicBoolean$ReturnType.getArrayBaseType(logicBoolean$ReturnType);
        if (this.value.getReturnType() != this.elementType) {
            throw new BooleanParseException("Expected value of type: " + (Object)((Object)this.elementType) + " (got:" + (Object)((Object)this.value.getReturnType()) + ")");
        }
    }

    @Override
    public void setArgumentsRaw(String string2, l l2, String string3) {
        if (string2 == null || "".equals(string2)) {
            this.validateNumberOfArguments(0);
            return;
        }
        ArrayList arrayList = al.a(string2, ",", false);
        this.validateNumberOfArguments(arrayList.size());
        this.value = LogicBooleanLoader.parseBooleanBlock(l2, (String)arrayList.get(0), false);
        if (this.value == null) {
            throw new BooleanParseException("Expected non-null argument");
        }
    }

    public void validateNumberOfArguments(int n2) {
        if (n2 != 1) {
            throw new BooleanParseException("Expected 1 argument");
        }
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (this.value == null) {
            throw new BooleanParseException("No value");
        }
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.bool;
    }

    @Override
    public boolean read(y y2) {
        int n2 = LogicBooleanLoader$ArrayContextReader$ArrayContains.indexOf(y2, this.targetArray, this.value);
        return n2 != -1;
    }

    public static final int indexOf(y y2, LogicBoolean logicBoolean, LogicBoolean logicBoolean2) {
        block8: {
            LogicBoolean$ReturnType logicBoolean$ReturnType;
            int n2;
            block9: {
                block7: {
                    n2 = logicBoolean.getArraySize(y2);
                    logicBoolean$ReturnType = logicBoolean2.getReturnType();
                    if (logicBoolean$ReturnType != LogicBoolean$ReturnType.bool) break block7;
                    boolean bl2 = logicBoolean2.read(y2);
                    for (int i2 = 0; i2 < n2; ++i2) {
                        LogicBoolean logicBoolean3 = logicBoolean.readArrayElement(y2, i2);
                        if (logicBoolean3.read(y2) != bl2) continue;
                        return i2;
                    }
                    break block8;
                }
                if (logicBoolean$ReturnType != LogicBoolean$ReturnType.number) break block9;
                float f2 = logicBoolean2.readNumber(y2);
                for (int i3 = 0; i3 < n2; ++i3) {
                    LogicBoolean logicBoolean4 = logicBoolean.readArrayElement(y2, i3);
                    float f3 = logicBoolean4.readNumber(y2);
                    if (!GameUtils.j(f2, f3)) continue;
                    return i3;
                }
                break block8;
            }
            if (logicBoolean$ReturnType != LogicBoolean$ReturnType.unit) break block8;
            BaseUnit am2 = logicBoolean2.readUnit(y2);
            if (VariableScope.isMarker(am2)) {
                if (am2 == null) {
                    return -1;
                }
                float f4 = am2.posX;
                float f5 = am2.posY;
                int n3 = am2.bX.k;
                am2 = null;
                for (int i4 = 0; i4 < n2; ++i4) {
                    LogicBoolean logicBoolean5 = logicBoolean.readArrayElement(y2, i4);
                    BaseUnit am3 = logicBoolean5.readUnit(y2);
                    if (am3 == null || !GameUtils.j(f4, am3.posX) || !GameUtils.j(f5, am3.posY) || n3 != am3.bX.k) continue;
                    return i4;
                }
            } else {
                for (int i5 = 0; i5 < n2; ++i5) {
                    LogicBoolean logicBoolean6 = logicBoolean.readArrayElement(y2, i5);
                    BaseUnit am4 = logicBoolean6.readUnit(y2);
                    if (am2 != am4) continue;
                    return i5;
                }
            }
        }
        return -1;
    }

    public String getName() {
        return "contains";
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        String string2;
        String string3 = "";
        if (this.targetArray != null) {
            string3 = string3 + this.targetArray.getMatchFailReasonForPlayer(y2);
        }
        if ((string2 = null) != null) {
            string2 = this.value.getMatchFailReasonForPlayer(y2);
        }
        string3 = string3 + "." + this.getName() + "(" + string2 + ")";
        string3 = string3 + "=" + this.valueToStringDebug(y2);
        return string3;
    }
}

