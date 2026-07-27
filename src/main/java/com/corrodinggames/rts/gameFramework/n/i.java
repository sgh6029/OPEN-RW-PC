/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.n;

import com.corrodinggames.rts.game.a.AIController;

import java.util.List;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.n.j;
import com.corrodinggames.rts.gameFramework.utility.m;

class i {
    boolean a;
    m b = new m();
    final /* synthetic */ com.corrodinggames.rts.gameFramework.n.MissionEngine c;

    i(com.corrodinggames.rts.gameFramework.n.MissionEngine f2) {
        this.c = f2;
    }

    public void a(UnitType as2, int n2) {
        UnitType as3 = com.corrodinggames.rts.game.units.custom.l.c(as2);
        if (as3 != null) {
            as2 = as3;
        }
        this.b(as2, n2);
    }

    public void b(UnitType as2, int n2) {
        for (j j2 : ((List<j>) this.b)) {
            if (j2.a != as2)
                continue;
            j2.b += n2;
            return;
        }
        j j3 = new j(this);
        j3.a = as2;
        j3.b = n2;
        this.b.add(j3);
    }

    public void a(float f2, float f3) {
        GameEngine l2 = GameEngine.getInstance();
        int n2 = 0;
        PlayerTeam n3 = PlayerTeam.k(1);
        if (n3 == null) {
            GameEngine.log("Warning: Creating missing wave team AI");
            n3 = new AIController(1);
            n3.r = 100;
            n3.U = true;
        }
        for (j j2 : ((List<j>) this.b)) {
            for (int i2 = 0; i2 < j2.b; ++i2) {
                BaseUnit am2 = j2.a.createUnitInstance();
                int n4 = 85;
                am2.posX = f2 + (float) GameUtils.a(-n4, n4, n2 + 0);
                am2.posY = f3 + (float) GameUtils.a(-n4, n4, n2 + 1);
                am2.cg = GameUtils.a(-180, 180, n2 + 2);
                n2 += 3;
                am2.b(n3);
                if (am2.posX < 0.0f) {
                    am2.posX = 0.0f;
                }
                if (am2.posY < 0.0f) {
                    am2.posY = 0.0f;
                }
                if (am2.posX > l2.bL.i()) {
                    am2.posX = l2.bL.i();
                }
                if (am2.posY > l2.bL.j()) {
                    am2.posY = l2.bL.j();
                }
                if (i2 != 0)
                    continue;
                l2.bW.a(am2);
            }
        }
    }

    public String toString() {
        if (this.b.size() == 0) {
            return "No units";
        }
        String string2 = "";
        boolean bl2 = true;
        for (j j2 : ((List<j>) this.b)) {
            if (!bl2) {
                string2 = string2 + ", ";
            }
            bl2 = false;
            string2 = string2 + j2.b + "x ";
            string2 = string2 + j2.a.e();
        }
        return string2;
    }
}
