/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$WrappingLogicString;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class LogicString$DebugPassthrough
extends LogicString$WrappingLogicString {
    public void addMessage(y y2) {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.bv && l2.bl) {
            String string2 = "";
            if (y2 != null) {
                string2 = y2.r().i() + "(" + y2.objectId + ") ";
            }
            String string3 = string2 + "DebugPassthrough: " + this.children[0].getMatchFailReasonForPlayer(y2);
            NetworkEngine.a((String)null, string3);
        }
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return this.children[0].getReturnType();
    }

    @Override
    public boolean read(y y2) {
        this.addMessage(y2);
        return this.children[0].read(y2);
    }

    @Override
    public float readNumber(y y2) {
        this.addMessage(y2);
        return this.children[0].readNumber(y2);
    }

    @Override
    public String readString(y y2) {
        this.addMessage(y2);
        return this.children[0].readString(y2);
    }

    @Override
    public BaseUnit readUnit(y y2) {
        this.addMessage(y2);
        return this.children[0].readUnit(y2);
    }
}

