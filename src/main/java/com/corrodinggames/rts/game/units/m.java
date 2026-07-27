/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.ActionDisplayType;
import com.corrodinggames.rts.game.units.a.ActionType;
import com.corrodinggames.rts.game.units.a.NoneAction;
import com.corrodinggames.rts.gameFramework.GameEngine;

class m
extends NoneAction {
    boolean a;
    boolean b;

    public m(boolean bl2, boolean bl3) {
        super("changeUnitTab" + bl2 + "d:" + bl3);
        this.a = bl2;
        this.b = bl3;
    }

    @Override
    public String b() {
        return this.d();
    }

    @Override
    public String d() {
        h_f h2 = com.corrodinggames.rts.game.units.h_f.L();
        if (h2 == null) {
            return "<NULL>";
        }
        if (this.b) {
            return h2.G.a();
        }
        String string2 = "";
        if (this.a) {
            string2 = string2 + "<- ";
        }
        if (!this.a) {
            string2 = string2 + " ->";
        }
        return string2;
    }

    public void n() {
        h_f h2 = com.corrodinggames.rts.game.units.h_f.L();
        if (h2 == null) {
            GameEngine.b("Editor not active");
            return;
        }
        if (this.b) {
            return;
        }
        h2.G = h2.G.a(this.a);
    }

    @Override
    public String a() {
        return "Change unit tab in editor";
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

