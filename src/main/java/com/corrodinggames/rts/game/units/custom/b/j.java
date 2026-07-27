/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.b;

import com.corrodinggames.rts.game.units.custom.b.a;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.utility.IniFile;

public class j
extends a {
    LogicBoolean a;
    float b;
    float c;
    h d;
    boolean e;

    public static void a(l l2, IniFile ab2) {
        String string2 = "movement_repelFromUnits";
        if (ab2.g(string2)) {
            j j2 = new j();
            j2.a(l2, ab2, string2, string2);
            if (!LogicBoolean.isStaticFalse(j2.a)) {
                l2.a(j2);
            }
        }
    }

    public void a(l l2, IniFile ab2, String string2, String string3) {
        this.a = ab2.a(l2, string2, "enabled");
        this.b = ab2.i(string2, "speed");
        this.c = ab2.a(string2, "maxSpeed", Float.valueOf(5.0f)).floatValue();
        this.d = g.a(ab2.b(string2, "otherUnitHasTag", (String)null), null);
        this.e = ab2.a(string2, "onlySameTeam", (Boolean)false);
    }

    @Override
    public void b(com.corrodinggames.rts.game.units.custom.j j2, float f2) {
        if (!this.a.read(j2)) {
            return;
        }
    }
}

