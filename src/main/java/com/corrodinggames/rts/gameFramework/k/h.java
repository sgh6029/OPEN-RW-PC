/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.k;

import java.io.IOException;

import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.units.PositionData;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.k.c;
import com.corrodinggames.rts.gameFramework.k.f;

import android.graphics.Point;

import com.corrodinggames.rts.gameFramework.GameEngine;

public class h
extends c {
    f a;
    PositionData b = new PositionData();
    static Point c = new Point();

    public h(f f2) {
        this.a = f2;
    }

    @Override
    public PositionData a(BaseUnit am2) {
        PositionData af2 = this.a(am2.posX, am2.posY);
        if (af2 == null) {
            return null;
        }
        PositionData af3 = this.a(af2.posX, af2.posY);
        if (af3 == null) {
            return af2;
        }
        PositionData af4 = this.a(af3.posX, af3.posY);
        if (af4 == null) {
            return af3;
        }
        return af4;
    }

    @Override
    public void d(BaseUnit am2) {
            try {
        PositionData af2;
        float f2;
        if (this.a != null) {
            this.a.d();
        }
        GameEngine l2 = GameEngine.getInstance();
        float f3 = l2.cw;
        float f4 = l2.cx;
        PositionData af3 = this.e(am2);
        if (af3 != null) {
            float f5 = af3.posX;
            f2 = af3.posY;
            f.c.b(-16776961);
            l2.bO.a(am2.posX - f3, am2.posY - f4, f5 - f3, f2 - f4, f.c);
            PositionData af4 = this.b(am2);
            if (af4 != null) {
                f.c.b(-7829368);
                l2.bO.a(f5 - f3, f2 - f4, af4.posX - f3, af4.posY - f4, f.c);
            }
        }
        if ((af2 = this.a(am2)) != null) {
            f2 = af2.posX;
            float f6 = af2.posY;
            f.c.b(-256);
                l2.bO.a(am2.posX - f3, am2.posY - f4, f2 - f3, f6 - f4, f.c);
        }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    public PositionData e(BaseUnit am2) {
        return this.a(am2.posX, am2.posY);
    }

    @Override
    public PositionData b(BaseUnit am2) {
        PositionData af2 = this.a(am2.posX, am2.posY);
        if (af2 == null) {
            return null;
        }
        return this.a(af2.posX, af2.posY);
    }

    @Override
    public void c(BaseUnit am2) {
    }

    public PositionData a(float f2, float f3) {
        if (this.a.b == null) {
            return null;
        }
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        int n2 = (int)(f2 * b2.r);
        int n3 = (int)(f3 * b2.s);
        if (!b2.c(n2, n3)) {
            return null;
        }
        byte by = this.a.a(n2, n3);
        if (by == 0) {
            return null;
        }
        f.a(by, c);
        int n4 = n2 - h.c.x;
        int n5 = n3 - h.c.b;
        this.b.posX = n4 * b2.n + b2.p;
        this.b.posY = n5 * b2.o + b2.q;
        return this.b;
    }
}

