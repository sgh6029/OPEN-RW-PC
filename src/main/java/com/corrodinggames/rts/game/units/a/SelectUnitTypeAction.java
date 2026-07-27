/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.h_f;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;
import java.util.List;

public class SelectUnitTypeAction
extends AbstractUnitAction {
    UnitType a;
    ArrayList b = new ArrayList();
    int c = 0;
    boolean d;
    y e = null;
    int f;

    public SelectUnitTypeAction(UnitType as2) {
        super("s_" + as2.v());
        this.sortOrder = -9999.0f;
        this.a = as2;
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return -1;
    }

    @Override
    public int c() {
        return 0;
    }

    @Override
    public UnitType i() {
        return this.a;
    }

    @Override
    public ActionType e() {
        return ActionType.infoOnly;
    }

    @Override
    public ActionDisplayType f() {
        if (GameEngine.at() && !com.corrodinggames.rts.gameFramework.f.g.bO) {
            return ActionDisplayType.infoOnlyNoBox;
        }
        return ActionDisplayType.infoOnly;
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public boolean c(BaseUnit am2, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        if (!bl2) {
            if (l2.bS.q() == 1) {
                return false;
            }
            boolean bl3 = false;
            for (BaseUnit am3 : ((List<BaseUnit>)BaseUnit.bE)) {
                if (!am3.cG || am3.r() == this.a) continue;
                l2.bS.l(am3);
                bl3 = true;
            }
            if (!bl3) {
                return false;
            }
        } else {
            for (BaseUnit am4 : ((List<BaseUnit>)BaseUnit.bE)) {
                if (!am4.cG || am4.r() != this.a) continue;
                l2.bS.l(am4);
            }
        }
        return true;
    }

    @Override
    public String d() {
        String string2 = "UnitInfo";
        GameEngine l2 = GameEngine.getInstance();
        if (this.e instanceof h_f) {
            return "Editor";
        }
        string2 = "" + this.a.e() + " x" + this.c;
        return string2;
    }

    @Override
    public String b() {
        return "UnitInfo";
    }

    @Override
    public String w(BaseUnit am2) {
        if (this.e instanceof h_f) {
            return "Editor";
        }
        return this.a.e();
    }

    @Override
    public boolean h_() {
        return true;
    }

    @Override
    public boolean s() {
        return true;
    }

    @Override
    public boolean u() {
        return true;
    }

    @Override
    public boolean C() {
        return true;
    }

    @Override
    public String a() {
        String string2 = "";
        if (this.e instanceof h_f) {
            return "";
        }
        if (this.d) {
            string2 = "(Left click to exclusively select / Right click to unselect)\n";
        }
        return string2 + this.a.f();
    }

    public void K() {
        GameEngine l2 = GameEngine.getInstance();
        if (this.f == l2.bS.Y) {
            return;
        }
        this.f = l2.bS.Y;
        this.c = 0;
        this.d = false;
        this.e = null;
        BaseUnit[] amArray = l2.bS.bZ.a();
        int n2 = l2.bS.bZ.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            BaseUnit am2 = amArray[i2];
            if (!(am2 instanceof y)) continue;
            y y2 = (y)am2;
            if (!y2.cG) continue;
            if (y2.r() == this.a) {
                ++this.c;
                if (this.e != null) continue;
                this.e = y2;
                continue;
            }
            this.d = true;
        }
    }

    @Override
    public float m_() {
        return this.sortOrder - (float)this.c;
    }

    @Override
    public boolean G() {
        return true;
    }

    @Override
    public boolean o_() {
        return true;
    }
}

