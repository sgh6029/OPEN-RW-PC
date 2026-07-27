/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.b;

import com.corrodinggames.rts.game.units.custom.b.a;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.utility.IniFile;

public class l
extends a {
    LogicBoolean a;
    float b;
    float c;
    int d;

    public static void a(com.corrodinggames.rts.game.units.custom.l l2, IniFile ab2) {
        String string2 = "movement_random";
        if (ab2.g(string2)) {
            l l3 = new l();
            l3.a(l2, ab2, string2, string2);
            if (!LogicBoolean.isStaticFalse(l3.a)) {
                l2.a(l3);
            }
        }
    }

    public void a(com.corrodinggames.rts.game.units.custom.l l2, IniFile ab2, String string2, String string3) {
        this.a = ab2.a(l2, string2, "enabled");
        this.b = ab2.i(string2, "speed");
        this.c = ab2.a(string2, "maxSpeed", Float.valueOf(5.0f)).floatValue();
        this.d = ab2.b(string2, "awayFromEdge", 75);
    }

    @Override
    public void b(j j2, float f2) {
        if (!this.a.read(j2)) {
            return;
        }
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (j2.bi()) {
            if (GameUtils.c(j2.cc) < this.c) {
                j2.cc += GameUtils.b(j2, -this.b, this.b, 1);
            }
            if (GameUtils.c(j2.cd) < this.c) {
                j2.cd += GameUtils.b(j2, -this.b, this.b, 2);
            }
        } else {
            if (GameUtils.c(j2.cf) < this.c) {
                j2.cf += GameUtils.b(j2, -this.b, this.b, 1);
            }
            j2.cg += GameUtils.b(j2, -1.0f, 1.0f, 2);
        }
        if (this.d > 0) {
            if (j2.posY > l2.bL.j() - (float)this.d) {
                j2.cd -= GameUtils.b(j2, 0.0f, this.b * 0.25f, 10);
            }
            if (j2.posY < (float)this.d) {
                j2.cd += GameUtils.b(j2, 0.0f, this.b * 0.25f, 11);
            }
            if (j2.posX > l2.bL.i() - (float)this.d) {
                j2.cc -= GameUtils.b(j2, 0.0f, this.b * 0.25f, 12);
            }
            if (j2.posX < (float)this.d) {
                j2.cc += GameUtils.b(j2, 0.0f, this.b * 0.25f, 13);
            }
        }
        j2.ay = true;
    }
}

