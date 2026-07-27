/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class LogicBooleanGameFunctions$IsGameFrameBoolean
extends LogicBoolean {
    @LogicBoolean$Parameter
    public int mod;
    @LogicBoolean$Parameter
    public int equalTo;
    @LogicBoolean$Parameter
    public boolean offset;

    @LogicBoolean$Parameter
    public void mod(int n2) {
        this.mod = n2;
    }

    @Override
    public boolean read(y y2) {
        GameEngine l2 = GameEngine.getInstance();
        boolean bl2 = this.mod >= 0 ? (this.offset ? ((long)l2.bx + y2.objectId) % (long)this.mod == (long)this.equalTo : l2.bx % this.mod == this.equalTo) : (this.offset ? (long)l2.bx + y2.objectId == (long)this.equalTo : l2.bx == this.equalTo);
        return bl2;
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return "IsGameFrame(mod=" + this.mod + ")";
    }
}

