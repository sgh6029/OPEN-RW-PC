/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import java.util.List;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;
import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.gameFramework.GameEngine;

class k
        extends NoneAction {
    boolean a;
    boolean b;

    public k(boolean bl2, boolean bl3) {
        super("changeTeam" + bl2 + "d:" + bl3);
        this.a = bl2;
        this.b = bl3;
    }

    @Override
    public String b() {
        if (this.b) {
            return "Selected player";
        }
        if (this.a) {
            return "<- Set player";
        }
        return "Set player ->";
    }

    @Override
    public String d() {
        if (!this.b) {
            if (this.a) {
                return "<-";
            }
            return "->";
        }
        GameEngine l2 = GameEngine.getInstance();
        PlayerTeam n2 = null;
        for (BaseUnit am2 : ((List<BaseUnit>) l2.bS.bZ)) {
            if (!(am2 instanceof y))
                continue;
            y y2 = (y) am2;
            if (!y2.cG || !l2.bS.m(y2))
                continue;
            n2 = y2.bX;
        }
        String object = "";
        if (n2 != null) {
            object =  object + "Team - " + (n2.k + 1) + "";
        }
        return object;
    }

    @Override
    public String a() {
        return "Change targeted player for editor";
    }

    @Override
    public float l() {
        if (!com.corrodinggames.rts.gameFramework.f.g.bP) {
            return 0.8f;
        }
        return 0.5f;
    }

    @Override
    public int m() {
        if (this.b) {
            return 2;
        }
        return 4;
    }

    @Override
    public ActionDisplayType f() {
        if (this.b) {
            return ActionDisplayType.infoOnly;
        }
        return super.f();
    }

    @Override
    public ActionType e() {
        if (this.b) {
            return ActionType.infoOnly;
        }
        return super.e();
    }
}
