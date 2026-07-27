/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.h_f;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GGameObject;

public abstract class CustomUnitToolAction
extends AbstractUnitAction {
    public CustomUnitToolAction(String string2) {
        super("c__cut_" + string2);
        this.sortOrder = 0.0f;
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return -1;
    }

    @Override
    public int c() {
        return 0;
    }

    @Override
    public UnitType i() {
        return null;
    }

    @Override
    public ActionType e() {
        return ActionType.infoOnly;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.infoOnly;
    }

    @Override
    public boolean g() {
        return false;
    }

    public y K() {
        y y2 = null;
        for (GGameObject w2 : ((Iterable<GGameObject>)GGameObject.fastGameObjectList)) {
            if (!(w2 instanceof y)) continue;
            y y3 = (y)w2;
            if (!y3.cG) continue;
            y2 = y3;
        }
        return y2;
    }

    public boolean L() {
        GameEngine l2 = GameEngine.getInstance();
        y y2 = this.K();
        if (y2 != null) {
            if (y2 instanceof h_f) {
                return true;
            }
            return l2.bs == y2.bX;
        }
        return false;
    }

    @Override
    public String d() {
        return this.b();
    }

    @Override
    public boolean h_() {
        return false;
    }

    @Override
    public boolean s() {
        return !this.L();
    }

    @Override
    public boolean G() {
        return false;
    }

    @Override
    public float l() {
        if (!com.corrodinggames.rts.gameFramework.f.g.bP) {
            return 1.0f;
        }
        return 1.0f;
    }
}

