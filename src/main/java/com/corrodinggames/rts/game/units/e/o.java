/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.e;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;

import java.io.IOException;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.e.j;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.PointF;
import android.graphics.Rect;

public class o
extends j {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M[] d = new Texture_M[10];
    Rect e = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.turret;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.tank2);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.tank2_dead);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.tank2_turret);
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
        return c;
    }

    @Override
    public boolean e() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.b(this.posX, this.posY, this.posZ);
        this.M = a;
        this.S(0);
        this.bT = false;
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.o, 0.8f, this.posX, this.posY);
        this.bq();
        return true;
    }

    public o(boolean bl2) {
        super(bl2);
        this.T(16);
        this.U(30);
        this.cj = 11.0f;
        this.ck = this.cj + 2.0f;
        this.cu = this.cv = 350.0f;
        this.M = b;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        PointF pointF = this.E(n2);
        f f2 = f.a(this, pointF.x, pointF.b);
        f2.U = 35.0f;
        f2.l = am2;
        f2.h = 60.0f;
        f2.t = 3.0f;
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(pointF.x, pointF.b, this.posZ, -1127220);
        l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.q, 0.3f, pointF.x, pointF.b);
    }

    @Override
    public float m() {
        return 150.0f;
    }

    @Override
    public float b(int n2) {
        return 70.0f;
    }

    @Override
    public float z() {
        return 1.0f;
    }

    @Override
    public float A() {
        return 1.9f;
    }

    @Override
    public float c(int n2) {
        return 3.0f;
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
        return 10.0f;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

