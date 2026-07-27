/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.h;

import java.io.IOException;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.w;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

public abstract class f
extends w {
    float m;
    float n;
    boolean o = false;
    public static Texture_M p = null;
    public static Texture_M[] q = new Texture_M[10];

    public f(boolean bl2) {
        super(bl2);
    }

    @Override
    public void a(GameOutputStream as2) throws IOException {
        as2.a(this.n);
        as2.a(this.o);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.n = k2.g();
        this.o = k2.e();
        super.a(k2);
    }

    @Override
    public Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        return q[this.bX.R()];
    }

    public static void M() {
        GameEngine l2 = GameEngine.getInstance();
        p = l2.bO.a(com.corrodinggames.rts.R.drawable.unit_icon_water);
        q = com.corrodinggames.rts.game.PlayerTeam.a(p);
    }

    @Override
    public UnitMovementType h() {
        return com.corrodinggames.rts.game.units.UnitMovementType.WATER;
    }

    @Override
    public boolean cv() {
        return true;
    }

    public boolean K() {
        return true;
    }

    public void s(float f2) {
        float f3 = 0.0f;
        if (this.posZ != f3) {
            this.posZ = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, f3, 0.2f * f2);
        }
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.bV) {
            if (this.posZ > -10.0f) {
                this.n += 0.002f * f2;
                this.posZ -= this.n * f2;
            } else {
                this.posZ = -10.0f;
                if (!this.o) {
                    this.o = true;
                }
            }
            return;
        }
        if (!this.bT() || this.bV) {
            return;
        }
        this.s(f2);
        if (this.K()) {
            if (this.cf != 0.0f) {
                this.m += f2;
            }
            if (this.m > 10.0f) {
                this.m = 0.0f;
                if (this.s_()) {
                    float f3;
                    GameEngine l2 = GameEngine.getInstance();
                    float f4 = this.cg + 180.0f;
                    if (this.cf < 0.0f) {
                        f4 += 180.0f;
                    }
                    if ((f3 = this.cj - 6.0f) < 4.0f) {
                        f3 = 4.0f;
                    }
                    float f5 = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(f4) * f3;
                    float f6 = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(f4) * f3;
                    l2.bR.b(f5, f6, 0.0f, f4);
                }
            }
        }
    }
}

