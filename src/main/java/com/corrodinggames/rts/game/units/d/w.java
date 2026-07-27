/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.i;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

public class w
extends i {
    static Texture_M a = null;
    static Texture_M[] b = new Texture_M[10];
    static Texture_M c = null;

    public static void b() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.wall_v);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.wall_v);
        b = com.corrodinggames.rts.game.PlayerTeam.a(a);
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return c;
        }
        if (this.bX == null) {
            return b[b.length - 1];
        }
        return b[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return null;
    }

    @Override
    public void a(int n2) {
    }

    public w(boolean bl2) {
        super(bl2);
        this.b(a);
        this.ck = this.cj = 15.0f;
        this.cu = this.cv = 700.0f;
        this.M = a;
        this.n.a(0, 0, 1, 0);
        this.o.a(0, 0, 1, 0);
    }

    public UnitTypeEnum K() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.wall_v;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.K();
    }
}

