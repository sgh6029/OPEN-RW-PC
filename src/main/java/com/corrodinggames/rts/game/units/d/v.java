/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.i;
import com.corrodinggames.rts.game.units.d.j;
import com.corrodinggames.rts.game.units.d.v$1;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import java.io.IOException;
import java.util.ArrayList;

public class v
extends i {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M[] c = new Texture_M[10];
    static Texture_M[] d = new Texture_M[10];
    static Texture_M e = null;
    int f = 1;
    float g = 0.0f;
    int h = 0;
    public static int i = 0;
    static AbstractUnitAction j = new v$1(102);
    static ArrayList k = new ArrayList();

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.f);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2)  throws IOException {
        int n2 = k2.readInt();
        this.a(n2);
        super.a(k2);
    }

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.supplyDepot;
    }

    public static void K() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.supply_depot);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.supply_depot_t2);
        c = com.corrodinggames.rts.game.PlayerTeam.a(a);
        d = com.corrodinggames.rts.game.PlayerTeam.a(b);
        e = l2.bO.a(com.corrodinggames.rts.R.drawable.supply_depot_dead);
    }

    @Override
    public boolean L() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(this.posX, this.posY, this.posZ);
        this.M = e;
        this.S(0);
        this.bT = false;
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.p, 0.8f, this.posX, this.posY);
        return false;
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return e;
        }
        if (this.bX == null) {
            return c[c.length - 1];
        }
        if (this.f == 1) {
            return c[this.bX.R()];
        }
        return d[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return null;
    }

    public v(boolean bl2) {
        super(bl2);
        this.M = a;
        this.a(this.M, 1);
        this.ck = this.cj = 20.0f;
        this.cu = this.cv = 800.0f;
        this.n.a(-1, -1, 0, 0);
        this.o.a(this.n);
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bT() || this.bV) {
            return;
        }
    }

    @Override
    public void a(j j2) {
        if (j2.j.equals(j.N())) {
            this.M();
            this.W();
        }
    }

    @Override
    public void a(int n2) {
        this.f = n2;
    }

    public void M() {
        if (this.f == 1) {
            this.f = 2;
            this.S();
        }
    }

    @Override
    public ActionId cm() {
        if (this.f == 1) {
            return j.N();
        }
        return com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID;
    }

    @Override
    public ArrayList N() {
        return k;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }

    static {
        k.add(j);
    }
}

