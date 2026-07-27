/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import java.io.IOException;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.d.d;
import com.corrodinggames.rts.game.units.d.j;
import com.corrodinggames.rts.game.units.d.k;
import com.corrodinggames.rts.game.units.d.l;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

public abstract class i
extends d
implements l {
    public static final Paint y = new Paint();
    k z = this.du();
    Rect A = new Rect();
    Rect B = new Rect();

    public i(boolean bl2) {
        super(bl2);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.r);
        this.z.a(as2);
        super.a(as2);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameInputStream k2) throws IOException {
        if (k2.b() >= 69) {
            int n2 = k2.readInt();
            this.R(n2);
        }
        this.z.a(k2);
        super.a(k2);
    }

    public k du() {
        return new k(this);
    }

    @Override
    public void b(j j2) {
    }

    @Override
    public boolean c(j j2) {
        return true;
    }

    @Override
    public void a(j j2) {
        float f2 = this.z.b != null ? this.cj * 2.0f : this.cj * 3.0f;
        BaseUnit am2 = this.z.a(j2, f2, false, 0.0f);
        if (am2 != null) {
            if (am2.posY - am2.cj < this.posY + (float)this.dv()) {
                am2.posY = this.posY + (float)this.dv() + am2.cj;
            }
            com.corrodinggames.rts.game.PlayerTeam.c(am2);
        }
    }

    public int dv() {
        return -100;
    }

    @Override
    public int f(boolean bl2) {
        return this.z.a(com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID, bl2, true);
    }

    @Override
    public final int a(ActionId c2, boolean bl2) {
        return this.z.a(c2, bl2);
    }

    @Override
    public j dw() {
        return this.z.b();
    }

    @Override
    public b bD() {
        return this.z.c();
    }

    @Override
    public m dx() {
        return this.z.c;
    }

    @Override
    public int h(UnitType as2) {
        return this.z.a(as2);
    }

    @Override
    public boolean dy() {
        return this.z.a();
    }

    @Override
    public void dz() {
        this.z.e = 1.0f;
    }

    @Override
    public void a(PointF pointF) {
        this.z.b = pointF;
    }

    @Override
    public boolean dA() {
        return false;
    }

    @Override
    public float bV() {
        if (this.bT() && !this.z.a()) {
            return this.z.e;
        }
        return super.bV();
    }

    @Override
    public AbstractUnitAction e(UnitType as2) {
        return this.z.b(as2);
    }

    @Override
    public void a(AbstractUnitAction s2, boolean bl2) {
        this.z.a(s2, bl2, null, null);
    }

    @Override
    public void b(AbstractUnitAction s2, boolean bl2) {
        this.z.a(s2, bl2);
    }

    @Override
    public void a(AbstractUnitAction s2) {
        this.z.a(s2);
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bT() || this.bV) {
            return;
        }
        this.z.a(f2);
    }

    @Override
    public boolean c(float f2) {
        return super.c(f2);
    }

    @Override
    public void bv() {
        com.corrodinggames.rts.game.PlayerTeam.a((BaseUnit)this);
        this.z.a(true);
        super.bv();
    }

    @Override
    public void a() {
        com.corrodinggames.rts.game.PlayerTeam.a((BaseUnit)this);
        this.z.a(true);
        super.a();
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public void a(BaseUnit am2, int n2) {
        throw new RuntimeException("Unit cannot shoot");
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
    public void ca() {
        if (this.z.b != null) {
            com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
            float f2 = (int)(this.posX - l2.cw);
            float f3 = (int)(this.posY - l2.cx);
            float f4 = (int)(this.z.b.x - l2.cw);
            float f5 = (int)(this.z.b.b - l2.cx);
            try {
                l2.bO.a(f2, f3, f4, f5, y);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public int a(g g2) {
        return this.z.a(g2);
    }

    static {
        y.a(255, 0, 255, 0);
        y.a(1.5f);
        y.a(true);
    }
}

