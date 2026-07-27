/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bg;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;

public class bf
extends i {
    public float a;
    public float b;
    public bg c;
    public int d;

    @Override
    public void setup(y y2, float f2) {
    }

    @Override
    public int excludeTeam(y y2) {
        return -2;
    }

    @Override
    public PlayerTeam onlyEnemiesOfTeam(y y2) {
        return null;
    }

    @Override
    public PlayerTeam onlyTeam(y y2) {
        return null;
    }

    @Override
    public void callback(y y2, float f2, BaseUnit am2) {
        float f3;
        if (y2 == am2) {
            return;
        }
        h h2 = am2.de();
        h h3 = this.c.c;
        if ((h3 == null || h2 != null && g.a(h3, h2)) && (f3 = GameUtils.a(this.a, this.b, am2.posX, am2.posY)) < this.c.f) {
            if (am2.cm < 1.0f && this.c.i) {
                return;
            }
            if (this.c.j && !am2.bI()) {
                return;
            }
            if (this.c.d != null && !y2.bX.a(this.c.d, am2.bX)) {
                return;
            }
            ++this.d;
        }
    }
}

