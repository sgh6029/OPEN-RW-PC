/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;

import android.graphics.PointF;

import com.corrodinggames.rts.game.units.y;

public class UnitReference$ThisActionTargetReference
extends UnitReference {
    @Override
    public BaseUnit getSingleRaw(y y2) {
        BaseUnit am2 = j.dN;
        if (am2 != null) {
            return am2;
        }
        PointF pointF = j.dM;
        if (pointF != null) {
            y y3 = PlayerTeam.i.t;
            y3.cg = 0.0f;
            y3.posX = pointF.x;
            y3.posY = pointF.b;
            y3.posZ = 0.0f;
            return y3;
        }
        return null;
    }

    @Override
    public String getClassDebugName() {
        return "ThisActionTarget";
    }
}

