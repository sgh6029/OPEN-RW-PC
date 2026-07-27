/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import java.io.IOException;

import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.d_f2;
import com.corrodinggames.rts.game.units.e.b;
import com.corrodinggames.rts.game.units.e.j;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.PointF;

import com.corrodinggames.rts.gameFramework.GGameObject;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class g_f
extends j
implements d_f2 {
    public boolean a;
    PointF[] b = new PointF[6];
    PointF[] c = new PointF[this.b.length];
    static Paint d;
    static Paint e;
    static Paint f;
    int g;
    float h;
    float i;
    int j;

    public UnitTypeEnum f() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.builder;
    }

    @Override
    public PointF[] b() {
        return this.b;
    }

    @Override
    public PointF[] e_() {
        return this.c;
    }

    @Override
    public Texture_M v() {
        if (this.bX.k == -1) {
            return null;
        }
        return dN[this.bX.R()];
    }

    @Override
    public boolean a(BaseUnit am2) {
        return true;
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return com.corrodinggames.rts.game.units.e.b.b;
        }
        return com.corrodinggames.rts.game.units.e.b.d[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return null;
    }

    @Override
    public Texture_M d(int n2) {
        return null;
    }

    @Override
    public boolean e() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        l2.bR.b(this.posX, this.posY, this.posZ);
        this.M = com.corrodinggames.rts.game.units.e.b.b;
        this.S(0);
        this.bT = false;
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.o, 0.8f, this.posX, this.posY);
        this.bq();
        return true;
    }

    public g_f(boolean bl2) {
        super(bl2);
        d = new Paint();
        d.a(40, 0, 255, 0);
        d.a(true);
        d.a(2.0f);
        d.a(Paint$Cap.b);
        e = new Paint();
        e.a(d);
        e.a(55, 255, 60, 60);
        f = new Paint();
        f.a(60, 255, 255, 255);
        this.T(20);
        this.U(20);
        this.cj = 10.0f;
        this.posX = -1000.0f;
        this.posY = -1000.0f;
        this.ck = this.cj;
        this.cu = this.cv = 170000.0f;
        this.M = com.corrodinggames.rts.game.units.e.b.b;
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            this.b[i2] = new PointF();
            this.c[i2] = new PointF();
        }
    }

    public static void a(float f2, d_f2 d2) {
        block4: {
            PointF[] pointFArray;
            PointF[] pointFArray2;
            block3: {
                y y2 = (y)((Object)d2);
                pointFArray2 = d2.b();
                pointFArray = d2.e_();
                BaseUnit am2 = y2.X();
                boolean bl2 = y2.aN = am2 != null;
                if (am2 == null) break block3;
                for (int i2 = 0; i2 < pointFArray2.length; ++i2) {
                    PointF pointF = pointFArray2[i2];
                    PointF pointF2 = pointFArray[i2];
                    pointF.x = com.corrodinggames.rts.gameFramework.GameUtils.a(pointF.x, pointF2.x, 0.1f * f2);
                    pointF.b = com.corrodinggames.rts.gameFramework.GameUtils.a(pointF.b, pointF2.b, 0.1f * f2);
                    pointF.x += (pointF2.x - pointF.x) * 0.04f * f2;
                    pointF.b += (pointF2.b - pointF.b) * 0.04f * f2;
                    float f3 = am2.cj * 0.75f;
                    if (com.corrodinggames.rts.gameFramework.GameUtils.c(pointF.x - pointF2.x) < 1.0f) {
                        pointF2.x = com.corrodinggames.rts.gameFramework.GameUtils.d(-f3, f3);
                    }
                    if (!(com.corrodinggames.rts.gameFramework.GameUtils.c(pointF.b - pointF2.b) < 1.0f)) continue;
                    pointF2.b = com.corrodinggames.rts.gameFramework.GameUtils.d(-f3, f3);
                }
                break block4;
            }
            if (pointFArray2[0].x == 0.0f && pointFArray2[0].b == 0.0f) break block4;
            for (int i3 = 0; i3 < pointFArray2.length; ++i3) {
                PointF pointF = pointFArray2[i3];
                PointF pointF3 = pointFArray[i3];
                pointF.x = 0.0f;
                pointF.b = 0.0f;
                pointF3.x = 0.0f;
                pointF3.b = 0.0f;
            }
        }
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bV) {
            com.corrodinggames.rts.game.units.g_f.a(f2, this);
        }
        this.cu = this.cv;
        ++this.g;
        this.h += f2;
        this.i += f2;
        if (this.a) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Stress test active");
            for (int i2 = 0; i2 < 6000; ++i2) {
                this.w();
            }
            this.ci();
            return;
        }
        if (this.i > 3.0f) {
            this.i = 0.0f;
            this.w();
        }
    }

    public void w() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        ++this.j;
        int n2 = com.corrodinggames.rts.game.units.UnitTypeEnum.ae.size();
        int n3 = com.corrodinggames.rts.gameFramework.GameUtils.a((GGameObject)this, 0, n2 - 1, 1 + this.j);
        UnitType as2 = (UnitType)com.corrodinggames.rts.game.units.UnitTypeEnum.ae.get(n3);
        boolean bl2 = true;
        if (l.b == as2) {
            bl2 = false;
        }
        if (as2 == com.corrodinggames.rts.game.units.UnitTypeEnum.spreadingFire) {
            bl2 = false;
        }
        if (bl2) {
            BaseUnit am2 = as2.createUnitInstance();
            am2.posX = com.corrodinggames.rts.gameFramework.GameUtils.a((GGameObject)this, 200, (int)l2.bL.i() - 200, 2 + this.g + this.j);
            am2.posY = com.corrodinggames.rts.gameFramework.GameUtils.a((GGameObject)this, 200, (int)l2.bL.j() - 200, 3 + this.g + this.j + this.j * 9);
            try {
                am2.Q(com.corrodinggames.rts.gameFramework.GameUtils.a((GGameObject)this, 0, 3, 4 + this.g + this.j + this.j * 9));
            }
            catch (com.corrodinggames.rts.game.b.MapLoadException f2) {
                throw new RuntimeException(f2);
            }
            PlayerTeam.c(am2);
            if (am2.u()) {
                am2.a();
            }
            if (am2.bO()) {
                am2.a();
            }
        }
    }

    @Override
    public void a(float f2, boolean bl2) {
        if (!this.bV) {
            // empty if block
        }
    }

    @Override
    public float e(int n2) {
        return 0.0f;
    }

    @Override
    public float f(int n2) {
        return 0.0f;
    }

    @Override
    public boolean c(float f2) {
        try {
            if (!super.c(f2)) {
                return false;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
    }

    @Override
    public boolean b_() {
        return false;
    }

    @Override
    public int y() {
        return 850000;
    }

    @Override
    public float b(BaseUnit am2) {
        return 1.0E7f;
    }

    @Override
    public float c(BaseUnit am2) {
        return 1.0E7f;
    }

    @Override
    public float m() {
        return 30.0f;
    }

    @Override
    public float b(int n2) {
        return 100.0f;
    }

    @Override
    public float z() {
        return 0.0f;
    }

    @Override
    public float A() {
        if (this.cK()) {
            return 4.7f;
        }
        return 4.8f;
    }

    @Override
    public float B() {
        return 0.35f;
    }

    @Override
    public float c(int n2) {
        return 99.0f;
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public float C() {
        return 0.04f;
    }

    @Override
    public float D() {
        return 0.1f;
    }

    @Override
    public boolean E() {
        return true;
    }

    @Override
    public float g(int n2) {
        return 10.0f;
    }

    @Override
    public boolean F() {
        return com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bQ.renderExtraShadows && !this.bV;
    }

    @Override
    public float G() {
        return 1.0f;
    }

    @Override
    public float H() {
        return 1.0f;
    }

    @Override
    public boolean u() {
        return true;
    }

    @Override
    public boolean I() {
        return false;
    }

    @Override
    public boolean d(BaseUnit am2) {
        return false;
    }

    @Override
    public boolean J() {
        return true;
    }

    @Override
    public float a(BaseUnit am2, float f2, f f3) {
        f2 = 0.0f;
        return super.a(am2, f2, f3);
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.f();
    }
}

