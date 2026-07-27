/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import java.io.IOException;
import java.util.List;

import com.corrodinggames.rts.gameFramework.effect.e;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.PointF;

import com.corrodinggames.rts.gameFramework.GameEngine;

//与文件夹重名了
public class f_f
        extends x {
    public float a = 2000.0f;
    public float b = 0.0f;
    public float c = 0.0f;
    public float d = 2000.0f;
    public float e;
    public float f;
    public boolean g = true;
    public float h = 1.0f;
    public boolean i;
    public float j;
    static Paint k = new Paint();
    static Paint l;
    static Paint m;
    static Paint n;
    static Paint o;
    static Paint p;
    boolean q;
    static final PointF r;

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.c(0);
        as2.a(this.a);
        as2.a(this.b);
        as2.a(this.c);
        as2.a(this.d);
        as2.a(this.e);
        as2.a(this.f);
        as2.a(this.g);
        as2.a(this.h);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        k2.d();
        this.a = k2.g();
        this.b = k2.g();
        this.c = k2.g();
        this.d = k2.g();
        this.e = k2.g();
        this.f = k2.g();
        this.g = k2.e();
        this.h = k2.g();
        super.a(k2);
        if (!this.bV) {
            com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bW.a(this);
        }
    }

    public UnitTypeEnum b() {
        if (this.q) {
            return com.corrodinggames.rts.game.units.UnitTypeEnum.zoneMarker;
        }
        return com.corrodinggames.rts.game.units.UnitTypeEnum.damagingBorder;
    }

    public static void d_() {
        GameEngine l2 = GameEngine.getInstance();
    }

    public f_f(boolean bl2) {
        super(bl2);
    }

    public f_f f() {
        List<BaseUnit> aaa = com.corrodinggames.rts.game.units.BaseUnit.bF();
        for (BaseUnit am2 : aaa) {
            if (!(am2 instanceof f_f) || am2.bV || am2 == this)
                continue;
            f_f f2 = (f_f) am2;
            if (f2.q != this.q)
                continue;
            return f2;
        }
        return null;
    }

    @Override
    public void a(float f2) {
        float f3;
        float f4;
        float f5;
        Object object;
        super.a(f2);
        if (this.bV) {
            return;
        }
        if (this.g) {
            this.g = false;
            object = this.f();
            if (object != null) {
                ((f_f) object).e = this.posX;
                ((f_f) object).f = this.posY;
                ((f_f) object).d = this.d;
                this.ci();
            } else {
                this.e = this.posX;
                this.f = this.posY;
                if (!this.q) {
                    com.corrodinggames.rts.gameFramework.GameEngine
                            .log("DamagingBorder created " + this.e + "," + this.f + " size:" + this.d);
                }
                com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bW.a(this);
            }
        }
        if (this.q) {
            this.a = this.d;
            this.posX = this.e;
            this.posY = this.f;
        } else if (this.a > this.d) {
            this.b += 2.5E-4f * f2;
            this.a -= this.b;
            this.i = true;
            float f6 = com.corrodinggames.rts.gameFramework.GameUtils.b(this.posX, this.posY, this.e, this.f);
            f5 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, this.e, this.f);
            if (f6 > 1.0f) {
                f4 = this.b;
                if (f4 > f6 * f2) {
                    f4 = f6 * f2;
                }
                this.posX += f4 * com.corrodinggames.rts.gameFramework.GameUtils.k(f5) * f2;
                this.posY += f4 * com.corrodinggames.rts.gameFramework.GameUtils.j(f5) * f2;
            }
        } else {
            this.i = false;
            this.posX = (float) ((double) this.posX + (double) (this.e - this.posX) * 0.003 * (double) f2);
            this.posY = (float) ((double) this.posY + (double) (this.f - this.posY) * 0.003 * (double) f2);
        }
        if (this.a < this.d) {
            this.a = this.d;
            this.b = 0.0f;
        }
        if (this.d < 0.0f) {
            this.ci();
            return;
        }
        this.c -= f2;
        if (!this.bV && this.c <= 0.0f && !this.q) {
            this.c = 2.0f;
            float f7 = this.a * com.corrodinggames.rts.gameFramework.GameUtils.k(45.0f);
            f5 = this.posX - f7;
            f4 = this.posX + f7;
            f3 = this.posY - f7;
            float f8 = this.posY + f7;
            float f9 = this.a * this.a;
            List<BaseUnit> aaa= com.corrodinggames.rts.game.units.BaseUnit.bF();
            for (BaseUnit am2 : aaa) {
                float f10;
                if (am2.posX > f5 && am2.posX < f4 && am2.posY > f3 && am2.posY < f8
                        || (f10 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, am2.posX, am2.posY)) < f9
                        || am2.bV || am2 instanceof Tree || am2.u() || am2.cN != null)
                    continue;
                float f11 = 0.5f + am2.cu * 0.002f + am2.cv * 0.001f;
                am2.a(this, f11 *= this.h, null);
            }
        }
        if (!this.q) {
            object = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
            this.j += f2;
            if (this.j > 3.0f) {
                int n2;
                this.j = 0.0f;
                int n3 = ((GameEngine) object).cu + com.corrodinggames.rts.gameFramework.GameUtils.a(0, (int) ((GameEngine) object).screenHeight);
                f3 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.posX, this.posY, (float) n3,
                        (float) (n2 = ((GameEngine) object).cv
                                + com.corrodinggames.rts.gameFramework.GameUtils.a(0, (int) ((GameEngine) object).uiScale)));
                if (f3 > (this.a + 30.0f) * (this.a + 30.0f)) {
                    ((GameEngine) object).bL.a((float) n3, (float) n2);
                    int n4 = ((GameEngine) object).bL.T;
                    int n5 = ((GameEngine) object).bL.U;
                    ((GameEngine) object).bL.a(n4, n5);
                    e e2 = ((GameEngine) object).bR.b(((GameEngine) object).bL.T + 10, ((GameEngine) object).bL.U - 10 + 10, 0.0f,
                            com.corrodinggames.rts.gameFramework.effect.d.custom, true,
                            com.corrodinggames.rts.gameFramework.effect.h.verylow);
                    if (e2 != null) {
                        e2.aq = 19;
                        e2.Y = com.corrodinggames.rts.gameFramework.GameUtils.c(-180.0f, 180.0f);
                        e2.r = true;
                        e2.ar = 1;
                        e2.E = 0.7f;
                        e2.W = e2.V = 30.0f;
                        e2.G = 0.2f;
                        e2.F = 1.2f;
                        e2.x = Color.a(255, 173, 12, 12);
                    }
                }
            }
        }
    }

    @Override
    public int s() {
        return 0;
    }

    @Override
    public boolean t() {
        return true;
    }

    @Override
    public boolean u() {
        return true;
    }

    @Override
    public boolean a(GameEngine l2) {
        return true;
    }

    @Override
    public void a(float f2, boolean bl2) {
        f_f f3;
        Paint paint;
        GameEngine l2 = GameEngine.getInstance();
        float f4 = this.posX - l2.cw;
        float f5 = this.posY - l2.cx;
        Paint paint2 = paint = this.i ? m : k;
        if (this.q) {
            paint = o;
        }
        float f6 = this.a;
        if (this.g && (f3 = this.f()) != null) {
            f6 = f3.d - 300.0f;
        }
        try {
            l2.bO.a(f4, f5, f6, paint);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean a(int n2, int n3) {
        Paint paint;
        GameEngine l2 = GameEngine.getInstance();
        l2.bO.i();
        l2.bO.a(l2.bW.w);
        float f2 = l2.bW.b(this.a);
        Paint paint2 = paint = this.i ? n : l;
        if (this.q) {
            paint = p;
        }
        com.corrodinggames.rts.gameFramework.m.aa.a(l2.bO, n2, n3, f2, paint);
        l2.bO.j();
        return true;
    }

    @Override
    public void a(int n2) {
        this.a = n2 * 100;
        this.d = n2 * 100;
    }

    public boolean a(float f2, float f3) {
        float f4 = this.d * this.d;
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.e, this.f, f2, f3);
        return f5 >= f4;
    }

    public PointF a(float f2, float f3, float f4) {
        if (f4 > this.d) {
            f4 = this.d;
        }
        float f5 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.posX, this.posY, f2, f3);
        float f6 = this.d - f4;
        float f7 = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(f5) * f6;
        float f8 = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(f5) * f6;
        com.corrodinggames.rts.game.units.f_f.r.x = f7;
        com.corrodinggames.rts.game.units.f_f.r.b = f8;
        return r;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }

    static {
        k.a(10.0f);
        k.b(Color.a(100, 160, 0, 0));
        k.a(Paint$Style.b);
        m = new Paint();
        m.a(k);
        m.b(Color.a(180, 160, 0, 0));
        l = new Paint();
        l.a(2.0f);
        l.b(Color.a(100, 160, 0, 0));
        l.a(Paint$Style.b);
        n = new Paint();
        n.a(l);
        n.b(Color.a(180, 160, 0, 0));
        o = new Paint();
        o.a(2.0f);
        o.b(Color.a(50, 255, 255, 255));
        o.a(Paint$Style.b);
        p = new Paint(o);
        r = new PointF();
    }
}
