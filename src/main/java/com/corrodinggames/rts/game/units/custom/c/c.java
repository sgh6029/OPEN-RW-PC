/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.c;

import java.io.IOException;
import java.util.List;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.c.a;
import com.corrodinggames.rts.game.units.custom.c.d;
import com.corrodinggames.rts.game.units.custom.c.e;
import com.corrodinggames.rts.game.units.custom.c.f;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.j.m;
import com.corrodinggames.rts.gameFramework.m.ag;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class c {
    static final Rect a = new Rect();
    static final RectF b = new RectF();
    static final Paint c = new Paint();
    com.corrodinggames.rts.gameFramework.utility.m d = new com.corrodinggames.rts.gameFramework.utility.m();
    static Paint e = new Paint();
    public static f f;

    public void a(l l2) {
        Object[] objectArray = this.d.a();
        for (int i2 = this.d.a - 1; i2 >= 0; --i2) {
            e e2 = (e)objectArray[i2];
            a a2 = l2.a(e2.a.g);
            if (a2 != null) {
                e2.a = a2;
                while (e2.b.size() > e2.a.d) {
                    e2.b.remove(e2.b.size() - 1);
                }
                continue;
            }
            this.d.remove(i2);
        }
    }

    public e a(a a2, boolean bl2) {
        int n2 = this.d.a;
        Object[] objectArray = this.d.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            if (e2.a != a2) continue;
            return e2;
        }
        if (bl2) {
            e e3 = new e(a2);
            this.d.add(e3);
            return e3;
        }
        return null;
    }

    public int a(a a2) {
        e e2 = this.a(a2, false);
        if (e2 == null) {
            return 0;
        }
        return e2.b.a;
    }

    public void a(float f2, BaseUnit am2) throws IOException {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        int n2 = this.d.a;
        if (n2 == 0) {
            return;
        }
        Object[] objectArray = this.d.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            a a2 = e2.a;
            int n3 = e2.b.a;
            Object[] objectArray2 = e2.b.a();
            for (int i3 = n3 - 1; i3 >= 0; --i3) {
                d d2 = (d)objectArray2[i3];
                if (!d2.c) continue;
                BaseUnit am3 = d2.a;
                if (a2.e != null) {
                    com.corrodinggames.rts.gameFramework.m.Texture_M e3 = a2.e;
                    float f3 = am2.posX - com.corrodinggames.rts.gameFramework.GameEngine.getInstance().cw;
                    float f4 = am2.posY - com.corrodinggames.rts.gameFramework.GameEngine.getInstance().cx - am2.posZ - 10.0f;
                    float f5 = e3.u;
                    float f6 = com.corrodinggames.rts.gameFramework.GameUtils.d(am2.posX, am2.posY - am2.posZ, am3.posX, am3.posY - am3.posZ);
                    float f7 = com.corrodinggames.rts.gameFramework.GameUtils.a(am2.posX, am2.posY - am2.posZ, am3.posX, am3.posY - am3.posZ);
                    if (f7 < (float)((e3.q - 2) * (e3.q - 2))) {
                        f5 = com.corrodinggames.rts.gameFramework.GameUtils.a((int)f7);
                    }
                    l2.bO.k();
                    l2.bO.a(f6 + 90.0f, f3, f4);
                    a.a(0, (int)((float)e3.q - f5), e3.p, e3.q);
                    b.a(f3 - (float)e3.r, f4 - f5, f3 + (float)e3.r, f4);
                    Paint paint = ag.r;
                    if (d2.d != 0.0f) {
                        paint = c;
                        int n4 = (int)Math.abs(d2.d * 5.0f);
                        if (n4 > 250) {
                            n4 = 250;
                        }
                        paint.a(255, 255, 255 - n4, 255 - n4);
                    }
                    l2.bO.a(e3, a, b, paint);
                    l2.bO.l();
                }
                if (a2.f == null) continue;
                l2.bO.a(am2.posX - l2.cw, am2.posY - l2.cx - am2.posZ, am3.posX - l2.cw, am3.posY - l2.cx - am3.posZ, a2.f);
            }
        }
    }

    public void a(GameOutputStream as2) throws IOException {
        if (this.d.a == 0) {
            as2.c(-1);
            return;
        }
        as2.c(0);
        int n2 = this.d.size();
        as2.a((short)n2);
        Object[] objectArray = this.d.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            as2.a(e2.a.g);
            as2.a((short)e2.b.size());
            for (d d2 : ((List<d>)e2.b)) {
                as2.a(d2.a);
                as2.a(d2.b);
                as2.a(d2.c);
            }
        }
    }

    public void a(BaseUnit am2, GameInputStream k2) throws IOException {
        byte by = k2.d();
        if (by == -1) {
            return;
        }
        int n2 = k2.v();
        this.d.clear();
        for (int i2 = 0; i2 < n2; ++i2) {
            g g2 = k2.m();
            a a2 = null;
            if (am2 instanceof j) {
                a2 = ((j)am2).x.a(g2);
            }
            e e2 = null;
            if (a2 != null) {
                e2 = new e(a2);
                this.d.add(e2);
            }
            int n3 = k2.v();
            for (int i3 = 0; i3 < n3; ++i3) {
                d d2 = new d();
                d2.a = k2.a(m.a);
                d2.b = k2.e();
                d2.c = k2.e();
                if (d2.a == null || e2 == null) continue;
                e2.b.add(d2);
            }
        }
    }

    static {
        e.a(255, 0, 0, 200);
        f = new f();
    }
}

