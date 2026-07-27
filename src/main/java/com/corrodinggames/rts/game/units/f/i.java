/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.f;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.f.j;
import com.corrodinggames.rts.game.units.y;

public abstract class i
extends j {
    public abstract int excludeTeam(y var1);

    public abstract PlayerTeam onlyEnemiesOfTeam(y var1);

    public PlayerTeam onlyTeam(y y2) {
        return null;
    }

    public void setup(y y2, float f2) {
    }

    public BaseUnit getResult() {
        return null;
    }
}

