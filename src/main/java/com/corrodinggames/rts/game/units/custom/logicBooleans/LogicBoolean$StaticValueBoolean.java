/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$LogicNumberOnly;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;

public final class LogicBoolean$StaticValueBoolean
extends LogicBoolean$LogicNumberOnly {
    public static final LogicBoolean$StaticValueBoolean static_0 = new LogicBoolean$StaticValueBoolean(0.0f);
    public static final LogicBoolean$StaticValueBoolean static_neg1 = new LogicBoolean$StaticValueBoolean(-1.0f);
    public static final LogicBoolean$StaticValueBoolean static_1 = new LogicBoolean$StaticValueBoolean(1.0f);
    float staticNumber;

    public static LogicBoolean$StaticValueBoolean getStaticNumber(String string2) {
        try {
            float f2 = Float.parseFloat(string2);
            return LogicBoolean$StaticValueBoolean.getStaticNumber(f2);
        }
        catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("Error reading number: " + string2, numberFormatException);
        }
    }

    public static LogicBoolean$StaticValueBoolean getStaticNumber(float f2) {
        if (f2 == 0.0f) {
            return static_0;
        }
        if (f2 == 1.0f) {
            return static_1;
        }
        if (f2 == -1.0f) {
            return static_neg1;
        }
        return new LogicBoolean$StaticValueBoolean(f2);
    }

    LogicBoolean$StaticValueBoolean(float f2) {
        this.staticNumber = f2;
    }

    @Override
    public String getName() {
        return "" + this.staticNumber;
    }

    @Override
    public final float readNumber(y y2) {
        return this.staticNumber;
    }

    public float getStaticValue() {
        return this.staticNumber;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return GameUtils.a(this.staticNumber, 3);
    }
}

