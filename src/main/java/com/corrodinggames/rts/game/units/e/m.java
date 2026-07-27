/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.e;

import java.io.IOException;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.e.j;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

public class m
extends j {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M[] d = new Texture_M[10];
    Rect e = new Rect();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.megaTank;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.mega_tank);
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.mega_tank_dead);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.mega_tank_turret);
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

    public m(boolean bl2) {
        super(bl2);
        this.T(20);
        this.U(25);
        this.cj = 12.0f;
        this.ck = this.cj + 1.0f;
        this.cu = this.cv = 550.0f;
        this.M = b;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
    }

    @Override
    public float bN() {
        return 7000.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        if (!am2.i()) {
            PointF pointF = this.E(n2);
            f f2 = f.a(this, pointF.x, pointF.b);
            f2.ar = Color.a(255, 150, 230, 40);
            f2.U = 50.0f;
            f2.l = am2;
            f2.h = 60.0f;
            f2.t = 3.0f;
            f2.x = 2.0f;
            f2.aQ = true;
            GameEngine l2 = GameEngine.getInstance();
            l2.bR.a(pointF.x, pointF.b, this.posZ, -1127220);
            l2.bR.a(pointF.x, pointF.b, this.posZ, this.cL[n2].targetX);
            l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.u, 0.3f, this.posX, this.posY);
        } else {
            f f3 = f.a(this, this.posX, this.posY);
            f3.ar = Color.a(255, 230, 230, 50);
            f3.U = 40.0f;
            f3.l = am2;
            f3.h = 190.0f;
            f3.t = 4.0f;
            f3.aH = true;
            f3.aI = 10.0f;
            f3.aJ = 15.0f;
            f3.aM = true;
            f3.aQ = true;
            GameEngine l3 = GameEngine.getInstance();
            l3.bM.a(com.corrodinggames.rts.gameFramework.sound.e.m, 0.2f, this.posX, this.posY);
        }
    }

    @Override
    public float m() {
        return 140.0f;
    }

    @Override
    public float b(int n2) {
        return 70.0f;
    }

    @Override
    public float z() {
        return 0.8f;
    }

    @Override
    public float A() {
        return 1.2f;
    }

    @Override
    public float c(int n2) {
        return 2.0f;
    }

    @Override
    public float C() {
        return 0.05f;
    }

    @Override
    public float D() {
        return 0.1f;
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
        y.a(this);
        return true;
    }

    @Override
    public boolean l() {
        return true;
    }

    @Override
    public boolean af() {
        return true;
    }

    @Override
    public float g(int n2) {
        return 12.0f;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

