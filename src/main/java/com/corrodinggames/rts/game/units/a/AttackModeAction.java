/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a_f;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameCommand;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class AttackModeAction
extends AbstractUnitAction {
    int a;
    a_f b;

    public AttackModeAction() {
        super("c_7");
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return -1;
    }

    @Override
    public int c() {
        return 0;
    }

    public UnitTypeEnum n() {
        return null;
    }

    @Override
    public ActionType e() {
        return ActionType.directToAction;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.none;
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return "Attack Mode";
    }

    @Override
    public String b() {
        a_f a2 = this.q();
        if (a2 != null) {
            return a2.name();
        }
        return "NA";
    }

    @Override
    public boolean h_() {
        return false;
    }

    @Override
    public void c(BaseUnit am2) {
        GameEngine l2 = GameEngine.getInstance();
        a_f a2 = this.r();
        a_f a3 = this.a(a2);
        PlayerTeam n2 = null;
        n2 = am2.bX;
        GameCommand e2 = l2.cf.b(n2);
        for (BaseUnit am3 : ((Iterable<BaseUnit>)BaseUnit.bE)) {
            if (!(am3 instanceof y)) continue;
            y y2 = (y)am3;
            if (!y2.cG) continue;
            e2.a(y2);
        }
        e2.a(a3);
        this.a = l2.bS.Y;
        this.b = a3;
    }

    public a_f a(a_f a2) {
        if (a2 == com.corrodinggames.rts.game.units.a_f.onlyInRange) {
            return com.corrodinggames.rts.game.units.a_f.guardArea;
        }
        if (a2 == com.corrodinggames.rts.game.units.a_f.onlyInRange) {
            return com.corrodinggames.rts.game.units.a_f.aggressive;
        }
        return com.corrodinggames.rts.game.units.a_f.onlyInRange;
    }

    public a_f q() {
        GameEngine l2 = GameEngine.getInstance();
        a_f a2 = this.r();
        this.a = l2.bS.Y;
        this.b = a2;
        return a2;
    }

    public a_f r() {
        GameEngine l2 = GameEngine.getInstance();
        if (this.a == l2.bS.Y && this.b != null) {
            return this.b;
        }
        a_f a2 = null;
        boolean bl2 = false;
        boolean bl3 = false;
        for (BaseUnit am2 : ((Iterable<BaseUnit>)BaseUnit.bE)) {
            if (!(am2 instanceof y)) continue;
            y y2 = (y)am2;
            if (!y2.cG) continue;
            if (a2 == null || a2 == y2.P) {
                a2 = y2.P;
                continue;
            }
            a2 = com.corrodinggames.rts.game.units.a_f.mixed;
        }
        return a2;
    }

    @Override
    public boolean b(BaseUnit am2) {
        return true;
    }

    @Override
    public String d() {
        return this.b();
    }

    @Override
    public boolean s() {
        return true;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.n();
    }
}

