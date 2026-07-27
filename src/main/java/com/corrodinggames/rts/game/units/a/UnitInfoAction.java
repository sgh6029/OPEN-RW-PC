/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import java.io.IOException;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.h_f;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.j.C1326f;

public class UnitInfoAction
extends AbstractUnitAction {
    public boolean a;

    public UnitInfoAction(boolean bl2) {
        super("c_5");
        this.sortOrder = -9990.0f;
        this.a = bl2;
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
        return null;
    }

    @Override
    public ActionType e() {
        return ActionType.infoOnly;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.infoOnly;
    }

    @Override
    public boolean g() {
        return false;
    }

    public com.corrodinggames.rts.game.units.y K() {
        GameEngine l2 = GameEngine.getInstance();
        BaseUnit[] amArray = l2.bS.bZ.a();
        int n2 = l2.bS.bZ.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            BaseUnit am2 = amArray[i2];
            if (!(am2 instanceof com.corrodinggames.rts.game.units.y)) continue;
            com.corrodinggames.rts.game.units.y y2 = (com.corrodinggames.rts.game.units.y)am2;
            if (!y2.cG) continue;
            return y2;
        }
        return null;
    }

    public boolean L() {
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.game.units.y y2 = this.K();
        if (y2 != null) {
            if (y2 instanceof h_f) {
                return true;
            }
            return l2.bs == y2.bX;
        }
        return false;
    }

    @Override
    public String d() {
        String string2 = "UnitInfo";
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.game.units.y y2 = this.K();
        if (y2 != null) {
            if (y2 instanceof h_f) {
                return "Editor";
            }
            if (!this.a) {
                string2 = l2.bS.g.a((BaseUnit)y2, false);
            } else {
                PlayerTeam n2 = y2.bX;
                string2 = l2.bS.g.a(n2);
            }
        }
        return string2;
    }

    @Override
    public boolean h_() {
        return true;
    }

    @Override
    public String b() {
        return "UnitInfo";
    }

    @Override
    public String d(BaseUnit am2) {
        if (this.a) {
            return "";
        }
        if (am2 != null) {
            return am2.r().e();
        }
        return "UnitInfo";
    }

    @Override
    public boolean s() {
        if (this.a) {
            return !this.L();
        }
        return true;
    }

    @Override
    public boolean u() {
        return !this.a;
    }

    @Override
    public boolean C() {
        return true;
    }

    @Override
    public String a()  throws IOException {
        if (this.a) {
            return "";
        }
        com.corrodinggames.rts.game.units.y y2 = this.K();
        if (y2 != null) {
            boolean bl2 = false;
            String string2 = com.corrodinggames.rts.gameFramework.f.GameUIController.a(y2, false, true, bl2);
            boolean bl3 = false;
            if (bl3) {
                C1326f f2 = new C1326f();
                y2.a(f2);
                string2 = string2 + "\n" + f2.a;
            }
            return string2;
        }
        return "";
    }

    @Override
    public boolean G() {
        return true;
    }
}

