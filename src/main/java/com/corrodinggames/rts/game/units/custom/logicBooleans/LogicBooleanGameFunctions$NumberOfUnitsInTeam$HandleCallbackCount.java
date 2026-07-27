/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;

public class LogicBooleanGameFunctions$NumberOfUnitsInTeam$HandleCallbackCount
extends i {
    public g tag;
    public int count;
    public float withinRangeSq;
    public boolean incompleteBuildings;
    public PlayerTeam targetTeam;

    @Override
    public void setup(y y2, float f2) {
    }

    @Override
    public int excludeTeam(y y2) {
        return -1;
    }

    @Override
    public PlayerTeam onlyEnemiesOfTeam(y y2) {
        return null;
    }

    @Override
    public PlayerTeam onlyTeam(y y2) {
        return this.targetTeam;
    }

    @Override
    public void callback(y y2, float f2, BaseUnit am2) {
        float f3;
        h h2 = am2.de();
        if ((this.tag == null || h2 != null && g.a(this.tag, h2)) && (f3 = GameUtils.a(y2.posX, y2.posY, am2.posX, am2.posY)) < this.withinRangeSq) {
            if (am2.cm < 1.0f && !this.incompleteBuildings) {
                return;
            }
            ++this.count;
        }
    }
}

