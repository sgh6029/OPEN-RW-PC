/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.b.n;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$AbstractNumberBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.utility.am;

public final class LogicBooleanGameFunctions$NumberOfAttachedUnitsBoolean
extends LogicBoolean$AbstractNumberBoolean {
    public g _withTag;
    short attachmentId = (short)-1;
    l meta;

    @Override
    public void forMeta(l l2) {
        if (l2 == null) {
            throw new am("NumberOfAttachedUnitsBoolean requires metadata");
        }
        this.meta = l2;
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (logicBooleanLoader$LogicBooleanContext != null && logicBooleanLoader$LogicBooleanContext != LogicBooleanLoader.defaultContextReader && this.attachmentId != -1) {
            throw new BooleanParseException("Function:" + string2 + " only supports use with 'self.' when using 'slot'");
        }
    }

    @LogicBoolean$Parameter
    public void withTag(String string2) {
        this._withTag = g.c(string2);
    }

    @LogicBoolean$Parameter
    public void slot(String string2) {
        n n2 = this.meta.i(string2);
        if (n2 == null) {
            throw new am("No attachment slot with name: " + string2 + " found");
        }
        this.attachmentId = n2.a();
    }

    @Override
    public String getName() {
        String string2 = "";
        if (this._withTag != null) {
            string2 = string2 + "tag=" + this._withTag;
        }
        if (this.attachmentId != -1) {
            string2 = string2 + " attachmentId=" + this.attachmentId;
        }
        return "NumberOfAttachedUnits(" + string2 + ")";
    }

    @Override
    public float getValue(y y2) {
        if (!(y2 instanceof j)) {
            return 0.0f;
        }
        j j2 = (j)y2;
        if (j2.C == null) {
            return 0.0f;
        }
        int n2 = 0;
        Object[] objectArray = j2.C.a();
        for (int i2 = j2.C.a - 1; i2 >= 0; --i2) {
            h h2;
            y y3 = (y)objectArray[i2];
            if (y3 == null || this.attachmentId != -1 && i2 != this.attachmentId || this._withTag != null && !g.a(this._withTag, h2 = y3.de())) continue;
            ++n2;
        }
        return n2;
    }

    @Override
    public float getMaxValue(y y2) {
        return 2.1474836E9f;
    }
}

