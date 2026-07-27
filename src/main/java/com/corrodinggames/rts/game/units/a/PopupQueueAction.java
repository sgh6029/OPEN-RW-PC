/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionType;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.d.j;
import com.corrodinggames.rts.game.units.d.l;

public abstract class PopupQueueAction
extends AbstractUnitAction {
    public PopupQueueAction(int n2) {
        super(n2);
    }

    public PopupQueueAction(String string2) {
        super(string2);
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        if (!(am2 instanceof l)) {
            return 99;
        }
        return ((l)((Object)am2)).a(this.N(), bl2);
    }

    @Override
    public float p(BaseUnit am2) {
        if (!(am2 instanceof l)) {
            return -1.0f;
        }
        l l2 = (l)((Object)am2);
        j j2 = l2.dw();
        if (j2 == null) {
            return -1.0f;
        }
        if (!this.d(j2.j)) {
            return -1.0f;
        }
        float f2 = j2.m;
        if (f2 < 0.0f) {
            return 0.0f;
        }
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    public float K() {
        return 0.01f;
    }

    @Override
    public boolean u() {
        return true;
    }

    @Override
    public ActionType e() {
        return ActionType.popupQueue;
    }
}

