/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.y;

public final class LogicBooleanGameFunctions$HasResourcesBoolean
extends LogicBoolean {
    b requiredResources;
    l meta;

    @Override
    public void forMeta(l l2) {
        if (l2 == null) {
            throw new BooleanParseException("HasResourcesBoolean requires metadata");
        }
        this.meta = l2;
    }

    @Override
    public void setArgumentsRaw(String string2, l l2, String string3) {
        try {
            this.requiredResources = b.b(this.meta, string2);
        }
        catch (bo bo2) {
            throw new BooleanParseException(bo2.getMessage(), bo2);
        }
    }

    @Override
    public boolean read(y y2) {
        boolean bl2 = false;
        if (this.requiredResources.b(y2)) {
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return "HasResources(" + this.requiredResources.a(false, true, 8, true) + ")";
    }
}

