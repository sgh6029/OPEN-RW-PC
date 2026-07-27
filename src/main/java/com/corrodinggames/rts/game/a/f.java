/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.UnitCommand;
import com.corrodinggames.rts.game.units.UnitCommandType;
import com.corrodinggames.rts.game.units.custom.a.e;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.y;
import java.util.AbstractList;
import java.util.ArrayList;

public class f {
    static boolean a(y y2) {
        UnitCommand au2;
        boolean bl2 = false;
        if (y2.aq()) {
            bl2 = true;
        }
        if (!bl2 && (au2 = y2.ar()) != null && au2.d() == UnitCommandType.reclaim) {
            bl2 = true;
        }
        return bl2;
    }

    static boolean b(y y2) {
        boolean bl2 = false;
        if (y2.aq()) {
            bl2 = true;
        }
        return bl2;
    }

    public static Object a(AbstractList abstractList) {
        int n2 = abstractList.size();
        if (n2 == 0) {
            return null;
        }
        return abstractList.get(com.corrodinggames.rts.gameFramework.GameUtils.a(0, n2 - 1));
    }

    public static boolean a(y y2, g g2) {
        h h2;
        UnitType as2 = y2.r();
        return as2 instanceof l && g.a(g2, h2 = ((l)as2).fv);
    }

    public static AbstractUnitAction a(AIController a2, y y2, e e2) {
        ArrayList<AbstractUnitAction> arrayList = y2.N();
        ArrayList arrayList2 = a2.ap();
        for (AbstractUnitAction s2 : arrayList) {
            if (s2.v(y2) != e2) continue;
            arrayList2.add(s2);
        }
        if (arrayList2.size() > 0) {
            return (AbstractUnitAction)f.a(arrayList2);
        }
        return null;
    }
}

