/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.q;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference$NearestUnitReference$HandleCallbackNearest;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.IniFile;

public class UnitReference$NearestUnitReference
extends UnitReference {
    public float withinRange = 500.0f;
    public float withinRangeSq = this.withinRange * this.withinRange;
    public g _withTag;
    public g _withoutTag;
    public q relation = q.any;
    @LogicBoolean$Parameter
    public boolean incompleteBuildings;
    public static final UnitReference$NearestUnitReference$HandleCallbackNearest handleCallbackNearest = new UnitReference$NearestUnitReference$HandleCallbackNearest();

    @Override
    public String getClassDebugName() {
        return "NearestUnit";
    }

    @LogicBoolean$Parameter
    public void withinRange(float f2) {
        if (f2 > 1500.0f) {
            throw new com.corrodinggames.rts.gameFramework.utility.am("NearestUnit distance cannot be over 1500 is: " + f2);
        }
        this.withinRange = f2;
        this.withinRangeSq = f2 * f2;
    }

    @LogicBoolean$Parameter
    public void withTag(String string2) {
        this._withTag = g.c(string2);
    }

    @LogicBoolean$Parameter
    public void withoutTag(String string2) {
        this._withoutTag = g.c(string2);
    }

    @LogicBoolean$Parameter
    public void relation(String string2) {
        try {
            this.relation = (q)IniFile.a(string2, q.any, q.class);
        }
        catch (bo bo2) {
            throw new com.corrodinggames.rts.gameFramework.utility.am(bo2.getMessage(), bo2);
        }
    }

    @Override
    public BaseUnit getSingleRaw(y y2) {
        UnitReference$NearestUnitReference.handleCallbackNearest.nearest = null;
        UnitReference$NearestUnitReference.handleCallbackNearest.withinRangeSq = this.withinRangeSq;
        UnitReference$NearestUnitReference.handleCallbackNearest.tag = this._withTag;
        UnitReference$NearestUnitReference.handleCallbackNearest.withoutTag = this._withoutTag;
        UnitReference$NearestUnitReference.handleCallbackNearest.incompleteBuildings = this.incompleteBuildings;
        UnitReference$NearestUnitReference.handleCallbackNearest.relation = this.relation;
        GameEngine l2 = GameEngine.getInstance();
        l2.cc.a(y2.posX, y2.posY, this.withinRange, y2, 0.0f, handleCallbackNearest);
        return UnitReference$NearestUnitReference.handleCallbackNearest.nearest;
    }
}

