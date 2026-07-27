/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.ActionFilter;
import com.corrodinggames.rts.game.units.a.FilteredUnitAction;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.n;

final class h$16
extends ActionFilter {
    h$16() {
    }

    @Override
    public boolean isAvailable(AbstractUnitAction s2, BaseUnit am2) {
        com.corrodinggames.rts.game.units.h_f h2;
        if (s2 instanceof FilteredUnitAction) {
            s2 = ((FilteredUnitAction)s2).q_();
        }
        if ((h2 = com.corrodinggames.rts.game.units.h_f.L()) == null) {
            return true;
        }
        n n2 = h2.G;
        if (n2 == null) {
            n2 = n.all;
        }
        if (n2 == n.all && com.corrodinggames.rts.game.units.h_f.a(s2, am2)) {
            return false;
        }
        if (n2 == n.modded && s2 == com.corrodinggames.rts.game.units.h_f.h) {
            return true;
        }
        if (n2 == n.modded && s2 == com.corrodinggames.rts.game.units.h_f.i) {
            return true;
        }
        if (n2 == n.search && s2 == com.corrodinggames.rts.game.units.h_f.y) {
            return true;
        }
        if (s2 == com.corrodinggames.rts.game.units.h_f.B && !com.corrodinggames.rts.game.units.h_f.B.b(am2)) {
            return false;
        }
        if (s2 == com.corrodinggames.rts.game.units.h_f.C && !com.corrodinggames.rts.game.units.h_f.C.b(am2)) {
            return false;
        }
        UnitType as2 = s2.i();
        return n2.a(as2);
    }
}

