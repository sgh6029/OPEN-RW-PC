/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 */
package com.corrodinggames.rts.game.units;

import android.graphics.PorterDuff;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;


import com.corrodinggames.rts.game.units.d.d;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class e_f
extends d {
    static com.corrodinggames.rts.gameFramework.m.Texture_M a = null;
    float b;
    static PorterDuffColorFilter c = new PorterDuffColorFilter(Color.a(200, 200, 200), PorterDuff.Mode.MULTIPLY);

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.crystalResource;
    }

    public static void a_() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.crystal);
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M d() {
        return a;
    }

    @Override
    public boolean e() {
        return true;
    }

    @Override
    public void a(int n2) {
    }

    public e_f(boolean bl2) {
        super(bl2);
        this.M = a;
        this.b(a);
        this.cj = 11.0f;
        this.ck = this.cj + 1.0f;
        this.cu = this.cv = 600.0f;
        this.S(1);
        this.n.a(0, -1, 0, 0);
        this.o.a(this.n);
    }

    @Override
    public Paint f() {
        Paint paint = super.f();
        return paint;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        this.b += 0.01f * f2;
        if (this.b > 1.0f) {
            this.b -= 1.0f;
            if (this.b > 1.0f) {
                this.b = 0.0f;
            }
        }
    }

    @Override
    public float g() {
        return 0.02f;
    }

    @Override
    public UnitMovementType h() {
        return com.corrodinggames.rts.game.units.UnitMovementType.NONE;
    }

    @Override
    public boolean i() {
        return false;
    }

    @Override
    public boolean s_() {
        GameEngine l2 = GameEngine.getInstance();
        du.a(this.cE());
        return RectF.a(l2.cM, du);
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M k() {
        return null;
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public float m() {
        return 0.0f;
    }

    @Override
    public float b(int n2) {
        return 0.0f;
    }

    @Override
    public float c(int n2) {
        return 0.0f;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
    }

    @Override
    public void n() {
        super.n();
        this.b = (this.posY * 5.0f + this.posX * 3.0f) % 1.0f;
    }

    @Override
    public boolean o() {
        return true;
    }

    @Override
    public boolean p() {
        return true;
    }

    @Override
    public boolean q() {
        return true;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

