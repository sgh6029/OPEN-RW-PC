/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bk;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.y;

public class bj
extends i {
    f a;
    bk b;
    BaseUnit c;
    f d;
    BaseUnit e;

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
    }
}

