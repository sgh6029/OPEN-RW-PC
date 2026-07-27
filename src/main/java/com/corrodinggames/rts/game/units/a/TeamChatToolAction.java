/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.a.CustomUnitToolAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.KeyBinding;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class TeamChatToolAction
extends CustomUnitToolAction {
    public TeamChatToolAction() {
        super("c__cut_chat");
    }

    @Override
    public String b() {
        return "Team Chat";
    }

    @Override
    public String a() {
        return "Send a team chat message to your allies";
    }

    @Override
    public boolean c(BaseUnit am2, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.bS.g.n();
        return true;
    }

    @Override
    public KeyBinding M() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.bT.u;
    }
}

