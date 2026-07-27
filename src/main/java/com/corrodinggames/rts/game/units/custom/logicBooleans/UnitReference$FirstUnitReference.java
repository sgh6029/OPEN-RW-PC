/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.q;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.utility.IniFile;

public class UnitReference$FirstUnitReference
extends UnitReference {
    public g _withTag;
    public q relation = q.any;
    @LogicBoolean$Parameter
    public boolean incompleteBuildings;

    @Override
    public String getClassDebugName() {
        return "globalSearchForFirstUnit";
    }

    @LogicBoolean$Parameter
    public void withTag(String string2) {
        this._withTag = g.c(string2);
    }

    @LogicBoolean$Parameter
    public void relation(String string2) {
        try {
            this.relation = (q)IniFile.a(string2, null, q.class);
        } catch (bo e) {
            e.printStackTrace();
        }
    }

    @Override
    public BaseUnit getSingleRaw(y y2) {
        BaseUnit[] amArray = BaseUnit.bE.a();
        int n2 = BaseUnit.bE.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            BaseUnit am2 = amArray[i2];
            if (this.relation != q.any && !y2.bX.a(this.relation, am2.bX) || y2 == am2) continue;
            h h2 = am2.de();
            if (this._withTag != null && (h2 == null || !g.a(this._withTag, h2)) || am2.cm < 1.0f && !this.incompleteBuildings) continue;
            return am2;
        }
        return null;
    }
}

