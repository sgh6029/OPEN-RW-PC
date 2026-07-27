/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;
import com.corrodinggames.rts.game.units.a.NoneAction;

class l
extends NoneAction {
    boolean a;
    boolean b;

    public l(boolean bl2, boolean bl3) {
        super("changeTypeFilter" + bl2 + "d:" + bl3);
        this.a = bl2;
        this.b = bl3;
    }

    @Override
    public boolean b(BaseUnit am2) {
        h_f h2 = com.corrodinggames.rts.game.units.h_f.L();
        if (h2 != null) {
            return h2.G == n.types;
        }
        return true;
    }

    @Override
    public String b() {
        if (this.b) {
            h_f h2 = com.corrodinggames.rts.game.units.h_f.L();
            if (h2 != null) {
                if (h2.F != null) {
                    return h2.F.a();
                }
                return "All types";
            }
            return "Type Filter";
        }
        if (this.a) {
            return "<- Set type";
        }
        return "Set type ->";
    }

    @Override
    public String d() {
        if (!this.b) {
            if (this.a) {
                return "<-";
            }
            return "->";
        }
        h_f h2 = com.corrodinggames.rts.game.units.h_f.L();
        if (h2 == null) {
            return "NA";
        }
        if (h2.F == null) {
            return "All mods";
        }
        return h2.F.a();
    }

    @Override
    public String a() {
        return "Change filtered type";
    }

    @Override
    public float l() {
        if (!com.corrodinggames.rts.gameFramework.f.g.bP) {
            return 0.8f;
        }
        return 0.5f;
    }

    @Override
    public int m() {
        if (this.b) {
            return 2;
        }
        return 4;
    }

    @Override
    public ActionDisplayType f() {
        if (this.b) {
            return ActionDisplayType.infoOnly;
        }
        return super.f();
    }

    @Override
    public ActionType e() {
        if (this.b) {
            return ActionType.infoOnly;
        }
        return super.e();
    }
}

