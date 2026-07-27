/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import java.io.IOException;

import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.x;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class u
extends x {
    public int a = 14;
    public float b = 60.0f;

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.c(0);
        as2.a(this.a);
        as2.a(this.b);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        k2.d();
        this.a = k2.readInt();
        this.b = k2.g();
        super.a(k2);
    }

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.fogRevealer;
    }

    public static void f() {
        GameEngine l2 = GameEngine.getInstance();
    }

    public u(boolean bl2) {
        super(bl2);
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        this.b -= f2;
        if (this.b < 0.0f) {
            this.ci();
        }
    }

    @Override
    public int s() {
        return this.a;
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
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

