/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.c;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.l;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.e.j;
import com.corrodinggames.rts.gameFramework.effect.d;
import com.corrodinggames.rts.gameFramework.effect.h;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.PointF;
import android.graphics.Rect;

import java.io.IOException;

public class a
extends j {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M[] d = new Texture_M[10];
    int e = 0;
    float f = 0.0f;
    Rect g = new Rect();
    Rect h = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.ladybug;
    }

    public static void f() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.ladybug);
        d = PlayerTeam.a(b);
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return a;
        }
        return d[this.bX.R()];
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
        com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.b(this.posX, this.posY, this.posZ, com.corrodinggames.rts.gameFramework.effect.d.blood, false, com.corrodinggames.rts.gameFramework.effect.h.high);
        if (e2 != null) {
            // empty if block
        }
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.A, 0.8f, this.posX, this.posY);
        l.a(this, 1);
        return false;
    }

    public a(boolean bl2) {
        super(bl2);
        this.T(17);
        this.U(26);
        this.cj = 5.0f;
        this.ck = this.cj + 3.0f;
        this.cu = this.cv = 130.0f;
        this.M = b;
        this.P = com.corrodinggames.rts.game.units.a_f.outOfRange;
    }

    @Override
    public Rect a_(boolean bl2) {
        int n2 = this.e * this.es;
        int n3 = 0;
        this.g.a(n2, n3, n2 + this.es, n3 + this.et);
        return this.g;
    }

    @Override
    public boolean bP() {
        return true;
    }

    @Override
    public boolean bO() {
        return true;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.cK) {
            this.e = this.e == 0 ? 1 : 0;
        }
        if (this.f != 0.0f) {
            this.f = com.corrodinggames.rts.gameFramework.GameUtils.a(this.f, f2);
            this.e = 2;
        }
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        com.corrodinggames.rts.game.f.a((BaseUnit)this, am2, 14.0f, null, false);
        this.f = 4.0f;
        PointF pointF = this.E(n2);
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.B, 0.3f, pointF.x, pointF.b);
    }

    @Override
    public float m() {
        return 43.0f;
    }

    @Override
    public float b(int n2) {
        return 17.0f;
    }

    @Override
    public float z() {
        return 1.7f;
    }

    @Override
    public float A() {
        return 5.5f;
    }

    @Override
    public float c(int n2) {
        return 99.0f;
    }

    @Override
    public boolean c(float f2) throws IOException {
        return super.c(f2);
    }

    @Override
    public float C() {
        return 0.07f;
    }

    @Override
    public float D() {
        return 0.12f;
    }

    @Override
    public boolean l() {
        return true;
    }

    @Override
    public boolean af() {
        return false;
    }

    @Override
    public float g(int n2) {
        return 7.0f;
    }

    @Override
    public boolean E() {
        return true;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

