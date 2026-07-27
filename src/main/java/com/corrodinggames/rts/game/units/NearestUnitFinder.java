/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;

public class NearestUnitFinder
extends i {
    public float searchPosX;
    public float searchPosY;
    public h animationSetFilter;
    public float closestDistanceSq;
    public BaseUnit nearestUnit;
    public boolean checkLineOfSight;
    public boolean includeNonGroundUnits = false;

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
        if (this.checkLineOfSight && am2.g() <= 0.0f) {
            return;
        }
        float f3 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.searchPosX, this.searchPosY, am2.posX, am2.posY);
        if (f3 < this.closestDistanceSq) {
            if (am2.cm < 1.0f && !this.includeNonGroundUnits) {
                return;
            }
            if (this.animationSetFilter != null && !com.corrodinggames.rts.game.units.custom.g.a(this.animationSetFilter, am2.de())) {
                return;
            }
            if (this.checkLineOfSight && !y2.g(am2, true)) {
                return;
            }
            if (am2.cN != null) {
                return;
            }
            this.nearestUnit = am2;
            this.closestDistanceSq = f3;
        }
    }
}

