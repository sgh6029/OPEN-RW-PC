/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.e;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.e.h;
import com.corrodinggames.rts.game.units.w;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

public abstract class j
extends w {
    float dK;
    public static Texture_M dL = null;
    public static Texture_M dM = null;
    public static Texture_M[] dN = new Texture_M[10];
    public static Texture_M[] dO = new Texture_M[10];

    public j(boolean bl2) {
        super(bl2);
    }

    @Override
    public Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        if (this.dd()) {
            return dO[this.bX.R()];
        }
        return dN[this.bX.R()];
    }

    public static void dt() {
        GameEngine l2 = GameEngine.getInstance();
        dL = l2.bO.a(com.corrodinggames.rts.R.drawable.unit_icon_land);
        if (dL == null) {
            throw new RuntimeException("IMAGE_ICON is null");
        }
        dN = PlayerTeam.a(dL);
        dM = l2.bO.a(com.corrodinggames.rts.R.drawable.unit_icon_land_exp);
        if (dM == null) {
            throw new RuntimeException("IMAGE_ICON_EXP is null");
        }
        dO = PlayerTeam.a(dM);
    }

    @Override
    public void a(float f2) {
        float f3;
        super.a(f2);
        if (this.bV) {
            f3 = 0.0f;
            if (this.cK()) {
                f3 = -10.0f;
            }
            if (this.posZ > f3) {
                if (this.posZ > 0.0f && this.dK < 0.4f) {
                    this.dK = 0.4f;
                }
                this.dK += 0.002f * f2;
                this.posZ -= this.dK * f2;
                if (this.posZ <= f3) {
                    this.posZ = f3;
                }
            }
        }
        if (!this.bT() || this.bV) {
            return;
        }
        if (!(this instanceof h)) {
            f3 = 0.0f;
            if (this.posZ < f3) {
                this.posZ += 0.2f * f2;
                if (this.posZ >= f3) {
                    this.posZ = f3;
                }
            }
            if (this.posZ > 0.0f) {
                this.dK += 0.03f * f2;
                if (this.posZ < 0.0f) {
                    this.dK = GameUtils.b(this.dK, 0.2f);
                }
                this.posZ -= this.dK * f2;
                if (this.posZ <= 0.0f) {
                    if (this.posZ < 0.0f) {
                        this.posZ = 0.0f;
                    }
                    this.dK = 0.0f;
                }
            }
        }
    }

    @Override
    public UnitMovementType h() {
        return com.corrodinggames.rts.game.units.UnitMovementType.LAND;
    }
}

