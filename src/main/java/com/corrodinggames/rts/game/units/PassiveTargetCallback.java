/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;

//ae.java
public class PassiveTargetCallback
extends i {
    public int callbackCount;
    public float closestDistanceSq;
    public boolean checkLineOfSight;
    public boolean isReady;

    PassiveTargetCallback(boolean bl2) {
        this.checkLineOfSight = bl2;
    }

    @Override
    public int excludeTeam(y y2) {
        return -2;
    }

    @Override
    public PlayerTeam onlyEnemiesOfTeam(y y2) {
        return y2.bX;
    }

    public void a(float f2) {
        this.closestDistanceSq = f2 * f2 + 1.0f;
        this.isReady = true;
    }

    @Override
    public void setup(y y2, float f2) {
        this.callbackCount = 0;
        if (!this.isReady) {
            throw new RuntimeException("PassiveTargetCallback not ready");
        }
        this.isReady = false;
    }

    @Override
    public void callback(y y2, float f2, BaseUnit am2) {
        if (y2.b(am2, true)) {
            float f3;
            ++this.callbackCount;
            if (this.checkLineOfSight) {
                if (!(am2 instanceof y)) {
                    return;
                }
                y y3 = (y)am2;
                if (!y3.l() || !y3.k(y2)) {
                    return;
                }
            }
            if ((f3 = GameUtils.a(y2.posX, y2.posY, am2.posX, am2.posY)) < this.closestDistanceSq) {
                this.closestDistanceSq = f3;
                y2.R = am2;
            }
        }
    }
}

