/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.a.BaseZone;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.d;
import com.corrodinggames.rts.gameFramework.Serializable;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.PointF;

import java.io.IOException;
import java.util.ArrayList;

public abstract class o
extends Serializable {
    public int Q;
    protected final AIController R;
    public float S;
    public float T;
    public float U;
    public boolean V;
    static final ArrayList W = new ArrayList();

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.S);
        as2.a(this.T);
        as2.a(this.U);
    }

    public void a(GameInputStream k2) throws IOException {
        this.S = k2.g();
        this.T = k2.g();
        this.U = k2.g();
    }

    public o(AIController a2) {
        ++a2.aI;
        this.Q = a2.aI;
        this.R = a2;
        this.R.bm.add(this);
        this.R.bn.add(this);
    }

    public o(AIController a2, float f2, float f3) {
        this(a2);
        this.S = f2;
        this.T = f3;
    }

    public void p() {
        this.R.bm.remove(this);
        this.R.bn.remove(this);
        this.V = true;
    }

    public boolean c(float f2, float f3) {
        float f4;
        float f5 = GameUtils.a(this.S, this.T, f2, f3);
        return f5 < (f4 = this.U) * f4;
    }

    public boolean b(BaseUnit am2) {
        float f2;
        float f3 = GameUtils.a(this.S, this.T, am2.posX, am2.posY);
        return f3 < (f2 = this.U + am2.cj) * f2;
    }

    public boolean a(BaseUnit am2, float f2) {
        float f3;
        float f4 = GameUtils.a(this.S, this.T, am2.posX, am2.posY);
        return f4 < (f3 = this.U + am2.cj + f2) * f3;
    }

    public float c(BaseUnit am2) {
        return GameUtils.a(this.S, this.T, am2.posX, am2.posY);
    }

    public float a(BaseZone i2) {
        return GameUtils.a(this.S, this.T, i2.S, i2.T);
    }

    public float d(float f2, float f3) {
        return GameUtils.a(this.S, this.T, f2, f3);
    }

    public PointF w() {
        PointF pointF = new PointF();
        float f2 = (float)(Math.random() * 360.0);
        float f3 = (float)(Math.random() * (double)this.U);
        pointF.a(this.S + GameUtils.k(f2) * f3, this.T + GameUtils.j(f2) * f3);
        return pointF;
    }

    public PointF e(UnitType as2) {
        GameEngine l2 = GameEngine.getInstance();
        PointF pointF = new PointF();
        float f2 = this.U;
        UnitMovementType ao2 = UnitMovementType.LAND;
        BaseUnit am2 = null;
        if (as2 == UnitTypeEnum.seaFactory) {
            f2 = 600.0f;
            ao2 = UnitMovementType.WATER;
        }
        for (int i2 = 0; i2 < 15; ++i2) {
            int n2;
            UnitTypeEnum ar2 = null;
            boolean bl2 = false;
            boolean bl3 = false;
            if (this instanceof BaseZone) {
                BaseZone i3 = (BaseZone)this;
                if (i2 < 6 && as2 == UnitTypeEnum.fabricator) {
                    ar2 = UnitTypeEnum.fabricator;
                }
                if (ar2 != null) {
                    com.corrodinggames.rts.game.units.y y2 = null;
                    if (am2 == null) {
                        am2 = BaseUnit.c(as2);
                    }
                    if (am2 instanceof com.corrodinggames.rts.game.units.y) {
                        y2 = (com.corrodinggames.rts.game.units.y)am2;
                    }
                    n2 = i3.c(ar2);
                    if (y2 != null && n2 > 1) {
                        int n3 = -1;
                        int n4 = GameUtils.a(0, n2 - 1);
                        BaseUnit[] amArray = BaseUnit.bE.a();
                        int n5 = BaseUnit.bE.size();
                        for (int i4 = 0; i4 < n5; ++i4) {
                            BaseUnit am3 = amArray[i4];
                            if (am3.bX != this.R || !i3.a(am3) || !am3.bT() || !this.R.i(am3) || am3.r() != ar2 || ++n3 != n4) continue;
                            float f3 = am3.posX;
                            float f4 = am3.posY;
                            boolean bl4 = GameUtils.a(0, 1) == 0;
                            float f5 = f3;
                            float f6 = f4;
                            if (bl4) {
                                f6 += GameUtils.c(-150.0f, 150.0f);
                            } else {
                                f5 += GameUtils.c(-150.0f, 150.0f);
                            }
                            boolean bl5 = false;
                            W.clear();
                            BaseUnit am4 = null;
                            l2.bS.a(y2, f3, f4, f5, f6, bl5, W, am4);
                            if (W.size() > 0) {
                                PointF pointF2 = (PointF)W.get(0);
                                pointF.a(pointF2.x, pointF2.b);
                                bl2 = true;
                                continue;
                            }
                            bl3 = true;
                        }
                    }
                }
            }
            if (bl3) continue;
            if (!bl2) {
                float f7 = (float)(Math.random() * 360.0);
                float f8 = (float)(Math.random() * (double)f2);
                pointF.a(this.S + GameUtils.k(f7) * f8, this.T + GameUtils.j(f7) * f8);
            }
            l2.bL.a(pointF.x, pointF.b);
            int n6 = l2.bL.T;
            int n7 = l2.bL.U;
            if (l2.bL.c(n6, n7) && ((n2 = y.c(n6, n7, ao2)) > 5 || n2 == 0) && d.a(as2, pointF.x, pointF.b, this.R)) {
                return pointF;
            }
            if (as2 != UnitTypeEnum.seaFactory) continue;
            f2 += 100.0f;
        }
        return null;
    }
}

