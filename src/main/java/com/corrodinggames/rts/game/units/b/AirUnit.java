/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.b;

import java.io.IOException;


import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.w;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

public abstract class AirUnit
extends w {
    float h;
    boolean i = false;
    float j;
    Boolean k;
    Boolean l;
    public static Texture_M m = null;
    public static Texture_M[] n = new Texture_M[10];

    public AirUnit(boolean bl2) {
        super(bl2);
    }

    @Override
    public void a(GameOutputStream as2) throws IOException {
        as2.a(this.h);
        as2.a(this.i);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.h = k2.g();
        this.i = k2.e();
        super.a(k2);
    }

    @Override
    public Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        return n[this.bX.R()];
    }

    public static void K() {
        GameEngine l2 = GameEngine.getInstance();
        m = l2.bO.a(com.corrodinggames.rts.R.drawable.unit_icon_air);
        n = com.corrodinggames.rts.game.PlayerTeam.a(m);
    }

    @Override
    public UnitMovementType h() {
        return com.corrodinggames.rts.game.units.UnitMovementType.AIR;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.bV) {
            if (this.posZ > 0.0f) {
                this.h += 0.06f * f2;
                this.posZ -= this.h * f2;
            } else {
                if (this.k == null) {
                    this.k = this.cK();
                }
                if (this.l == null) {
                    this.l = this.cJ();
                }
                if (!this.i) {
                    this.i = true;
                    if (this.k.booleanValue()) {
                        this.a(com.corrodinggames.rts.game.units.UnitSize.verysmall);
                        if (this.l.booleanValue()) {
                            com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bR.a(this.posX, this.posY, 0.0f, 0, 0.0f, 0.0f, this.cg);
                        }
                    } else {
                        this.a(com.corrodinggames.rts.game.units.UnitSize.small);
                    }
                    this.h = 0.0f;
                } else if (this.k.booleanValue()) {
                    if (this.posZ > -10.0f) {
                        this.h += 8.0E-4f * f2;
                        this.posZ -= this.h * f2;
                        if (this.l.booleanValue()) {
                            this.j += f2;
                            if (this.j > 30.0f) {
                                this.j = 0.0f;
                                if (this.s_()) {
                                    GameEngine l2 = GameEngine.getInstance();
                                    com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.b(this.posX, this.posY, this.posZ, this.cg);
                                    if (e2 != null) {
                                        e2.P = 0.0f;
                                        e2.Q = -0.1f;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.posZ = 0.0f;
                }
            }
            return;
        }
    }

    @Override
    public boolean e() {
        GameEngine l2 = GameEngine.getInstance();
        if (this.posZ > -1.0f) {
            for (int i2 = 0; i2 < 3; ++i2) {
                l2.bR.e(this.posX, this.posY, this.posZ);
            }
        }
        return super.e();
    }
}

