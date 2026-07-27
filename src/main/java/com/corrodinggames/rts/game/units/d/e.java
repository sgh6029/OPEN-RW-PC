/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import java.io.IOException;
import java.util.ArrayList;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.a.SetRallyAction;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;

public class e
extends i {
    static com.corrodinggames.rts.gameFramework.m.Texture_M a = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M[] b = new com.corrodinggames.rts.gameFramework.m.Texture_M[10];
    static com.corrodinggames.rts.gameFramework.m.Texture_M c = null;
    static com.corrodinggames.rts.gameFramework.m.Texture_M d = null;
    float e;
    public float f;
    public float g;
    public int h;
    public float i;
    public float j;
    float k = 20.0f;
    int l = 0;

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.e);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.e = k2.g();
        super.a(k2);
    }

    public static void b() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.base);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.base_dead);
        d = l2.bO.a(com.corrodinggames.rts.R.drawable.base_back);
        b = com.corrodinggames.rts.game.PlayerTeam.a(a);
    }

    public UnitTypeEnum K() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.commandCenter;
    }

    @Override
    public boolean L() {
        GameEngine l2 = GameEngine.getInstance();
        this.M = c;
        this.m = null;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.large);
        float f2 = this.posX;
        float f3 = this.posY;
        float f4 = 0.0f;
        l2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
        com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.a(f2, f3, this.posZ, Color.a(255, 255, 255, 255));
        if (e2 != null) {
            e2.G = 8.0f;
            e2.F = 5.0f;
            e2.E = 0.9f;
            e2.W = e2.V = 20.0f;
            e2.r = true;
        }
        l2.bR.b(com.corrodinggames.rts.gameFramework.effect.h.critical);
        e2 = l2.bR.c(f2, f3, f4, -1127220);
        if (e2 != null) {
            e2.G = 0.2f;
            e2.F = 2.0f;
            e2.ar = (short)2;
            e2.W = e2.V = 45.0f;
            e2.U = 0.0f;
        }
        float f5 = 40.0f;
        float f6 = 70.0f;
        l2.bR.a(this.posX, this.posY, this.posZ, f5, f6);
        com.corrodinggames.rts.gameFramework.effect.f.a(this.posX, this.posY);
        com.corrodinggames.rts.gameFramework.effect.f.b((float)this.posX, (float)this.posY).a = 800.0f;
        return true;
    }

    @Override
    public void a(int n2) {
    }

    @Override
    public void S() {
        super.S();
        this.m = this.bV ? null : d;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d() {
        if (this.bV) {
            return c;
        }
        return b[this.bX.R()];
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M k() {
        return null;
    }

    public e(boolean bl2) {
        super(bl2);
        this.M = a;
        this.m = d;
        this.T(53);
        this.U(68);
        this.ck = this.cj = 30.0f;
        this.cu = this.cv = 4000.0f;
        this.S(3);
        this.n.a(-1, -1, 1, 1);
        this.o.a(-1, -1, 1, 2);
    }

    @Override
    public RectF cF() {
        RectF rectF = super.cF();
        rectF.a(6.0f, 0.0f);
        return rectF;
    }

    @Override
    public void a(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        super.a(f2);
        if (!this.bT() || this.bV) {
            return;
        }
        this.k = com.corrodinggames.rts.gameFramework.GameUtils.a(this.k, f2);
        if (this.k == 0.0f) {
            this.k = 5.0f;
            ++this.l;
            if (this.l > 6) {
                this.l = 0;
                this.k = 70.0f;
            }
            this.s = this.l <= 3 ? this.l : 6 - this.l;
        }
        this.f += f2;
        ++this.h;
        this.i += 10.0f;
        if (this.j > f2) {
            this.j = f2;
        }
        this.g += f2;
        this.e += f2;
        if (this.e > com.corrodinggames.rts.game.PlayerTeam.ap - 0.1f) {
            this.e -= com.corrodinggames.rts.game.PlayerTeam.ap;
            this.bX.b(this.cy() * (com.corrodinggames.rts.game.PlayerTeam.ap / com.corrodinggames.rts.game.PlayerTeam.ao));
        }
    }

    @Override
    public float cy() {
        return 18.0f;
    }

    @Override
    public float q(int n2) {
        return 70.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        f f2 = com.corrodinggames.rts.game.f.a(this, this.posX, this.posY);
        PointF pointF = this.K(n2);
        f2.K = pointF.x;
        f2.L = pointF.b;
        f2.ar = Color.a(255, 230, 230, 50);
        f2.U = this.q(n2);
        f2.l = am2;
        f2.h = 180.0f;
        f2.t = 2.0f;
        f2.r = 5.0f;
        f2.aH = true;
        f2.aM = true;
        f2.aQ = true;
        f2.aG = true;
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(f2, -1118720);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.m, 0.8f, this.posX, this.posY);
    }

    @Override
    public float m() {
        return 280.0f;
    }

    @Override
    public float b(int n2) {
        return 70.0f;
    }

    @Override
    public float c(int n2) {
        return 999.0f;
    }

    @Override
    public boolean b(int n2, float f2) {
        return false;
    }

    @Override
    public boolean l() {
        return true;
    }

    public static void a(ArrayList arrayList, int n2) {
        arrayList.add(new SetRallyAction());
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.builder, 1.0f));
    }

    @Override
    public ArrayList N() {
        return this.K().a(this.V());
    }

    @Override
    public float a(BaseUnit am2, float f2, f f3) {
        if (f2 > 2500.0f) {
            f2 = 2500.0f;
        }
        return super.a(am2, f2, f3);
    }

    @Override
    public boolean bJ() {
        return true;
    }

    @Override
    public void e(float f2) {
        try {
            super.e(f2);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        float f3 = this.m();
        com.corrodinggames.rts.gameFramework.utility.y.a((BaseUnit)this, f3);
    }

    @Override
    public int s() {
        return 20;
    }

    @Override
    public int bp() {
        return 35;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.K();
    }
}

