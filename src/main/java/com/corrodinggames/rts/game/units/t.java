/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.x;

public class t
extends x {
    public static t a(PlayerTeam n2) {
        t t2 = new t(true);
        t2.b(n2);
        t2.bV = true;
        return t2;
    }

    t(boolean bl2) {
        super(bl2);
    }

    @Override
    public UnitType r() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.dummyNonUnitWithTeam;
    }

    public static void b() {
    }

    @Override
    public String c() {
        String string2 = this.r().i() + "(pos:" + (int)this.posX + "," + (int)this.posY;
        if (this.bX != null) {
            string2 = string2 + " t:" + this.bX.k;
        }
        string2 = string2 + ")";
        return string2;
    }
}

