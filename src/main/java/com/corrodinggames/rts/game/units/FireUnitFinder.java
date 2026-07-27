/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.FireUnit;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.y;

public class FireUnitFinder
extends i {
    float a;
    float b;
    public FireUnit c;

    FireUnitFinder() {
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
    public void setup(y y2, float f2) {
        this.c = null;
    }

    public void a(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    @Override
    public void callback(y y2, float f2, BaseUnit am2) {
        if (am2 instanceof FireUnit && !am2.bV && am2.c(this.a, this.b, 0.0f)) {
            this.c = (FireUnit)am2;
        }
    }
}

