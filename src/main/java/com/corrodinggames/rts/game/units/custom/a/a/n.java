/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.a.a;

import com.corrodinggames.rts.game.q;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.utility.m;

public class n
extends i {
    public h a;
    public float b;
    public boolean c;
    public q d;
    public m e;

    @Override
    public void setup(y y2, float f2) {
    }

    @Override
    public int excludeTeam(y y2) {
        return -2;
    }

    @Override
    public com.corrodinggames.rts.game.PlayerTeam onlyEnemiesOfTeam(y y2) {
        return null;
    }

    @Override
    public com.corrodinggames.rts.game.PlayerTeam onlyTeam(y y2) {
        return null;
    }

    @Override
    public void callback(y y2, float f2, BaseUnit am2) {
        float f3;
        h h2 = am2.de();
        if ((this.a == null || h2 != null && g.a(this.a, h2)) && (f3 = GameUtils.a(y2.posX, y2.posY, am2.posX, am2.posY)) < this.b) {
            if (am2.cm < 1.0f && !this.c) {
                return;
            }
            if (this.d != null && !y2.bX.a(this.d, am2.bX)) {
                return;
            }
            this.e.add(am2);
        }
    }
}

