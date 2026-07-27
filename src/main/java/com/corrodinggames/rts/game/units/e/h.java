/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.e;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.e.j;
import com.corrodinggames.rts.gameFramework.effect.d;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

public abstract class h
extends j {
    float l;
    public static Texture_M m = null;
    public static Texture_M[] n = new Texture_M[10];

    public h(boolean bl2) {
        super(bl2);
    }

    @Override
    public Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        if (this.dd()) {
            return j.dO[this.bX.R()];
        }
        return n[this.bX.R()];
    }

    public static void K() {
        GameEngine l2 = GameEngine.getInstance();
        m = l2.bO.a(com.corrodinggames.rts.R.drawable.unit_icon_hover);
        n = com.corrodinggames.rts.game.PlayerTeam.a(m);
    }

    @Override
    public UnitMovementType h() {
        return com.corrodinggames.rts.game.units.UnitMovementType.OVER_CLIFF_WATER;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bT() || this.bV) {
            return;
        }
        if (this.cK()) {
            if (this.cf > 0.0f) {
                this.l += f2;
            }
            if (this.l > 10.0f) {
                this.l = 0.0f;
                if (this.s_()) {
                    float f3;
                    GameEngine l2 = GameEngine.getInstance();
                    float f4 = this.posX + GameUtils.k(this.cg) * 4.0f;
                    com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.b(f4, f3 = this.posY + GameUtils.j(this.cg) * 4.0f, 0.0f, d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.low);
                    if (e2 != null) {
                        e2.aq = 0;
                        e2.ap = 13;
                        e2.ar = 1;
                        e2.r = true;
                        e2.E = 0.8f;
                        e2.W = 80.0f;
                        e2.V = 80.0f;
                        e2.P = -GameUtils.k(this.cg) * 0.1f;
                        e2.Q = -GameUtils.j(this.cg) * 0.1f;
                        e2.Y = GameUtils.c(-180.0f, 180.0f);
                    }
                }
            }
        }
    }
}

