/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.e.a_f3;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.y;

public final class LogicBooleanGameFunctions$IsResourceLargerThan
extends LogicBoolean {
    l meta;
    a_f3 source;
    a_f3 compareTarget;
    @LogicBoolean$Parameter
    public float byMoreThan = 0.0f;
    @LogicBoolean$Parameter
    public float multiplyTargetBy = 1.0f;

    @Override
    public void forMeta(l l2) {
        if (l2 == null) {
            throw new BooleanParseException("IsResourceLargerThan requires metadata");
        }
        this.meta = l2;
    }

    @LogicBoolean$Parameter
    public void source(String string2) {
        this.source = this.meta.j(string2);
        if (this.source == null) {
            throw new BooleanParseException("Could not find custom resource type of:" + this.source);
        }
    }

    @LogicBoolean$Parameter
    public void compareTarget(String string2) {
        this.compareTarget = this.meta.j(string2);
        if (this.compareTarget == null) {
            throw new BooleanParseException("Could not find custom resource type of:" + this.compareTarget);
        }
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (this.source == null) {
            throw new BooleanParseException("Requires 'source'");
        }
        if (this.compareTarget == null) {
            throw new BooleanParseException("Requires 'compareTarget'");
        }
    }

    @Override
    public boolean read(y y2) {
        double d2 = this.source.a(y2);
        double d3 = this.compareTarget.a(y2);
        d3 += (double)this.byMoreThan;
        d3 *= (double)this.multiplyTargetBy;
        boolean bl2 = false;
        if (d2 > d3) {
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return "IsResourceLargerThan(" + this.source.j() + " vs " + this.compareTarget.j() + ")";
    }
}

