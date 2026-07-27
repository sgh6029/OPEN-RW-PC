/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import java.io.IOException;
import java.util.ArrayList;


import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.SetRallyAction;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

public class a_f
extends i {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M[] c = new Texture_M[10];
    static Texture_M[] d = new Texture_M[10];
    static Texture_M e = null;
    int f = 1;
    float g = 0.0f;
    static final ActionId h = com.corrodinggames.rts.game.units.a.ActionId.isSameInstance(String.valueOf(110));

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.f);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        if (k2.b() >= 17) {
            int n2 = k2.readInt();
            this.a(n2);
        }
        super.a(k2);
    }

    public static void b() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.air_factory);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.air_factory_t2);
        e = l2.bO.a(com.corrodinggames.rts.R.drawable.air_factory_dead);
        c = com.corrodinggames.rts.game.PlayerTeam.a(a);
        d = com.corrodinggames.rts.game.PlayerTeam.a(b);
    }

    public UnitTypeEnum K() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.airFactory;
    }

    @Override
    public boolean L() {
        this.M = e;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.large);
        return true;
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

    public a_f(boolean bl2) {
        super(bl2);
        this.M = a;
        this.T(40);
        this.U(61);
        this.ck = this.cj = 30.0f;
        this.cu = this.cv = 1000.0f;
        this.n.a(-1, -1, 1, 1);
        this.o.a(-1, -1, 1, 2);
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (!this.bT() || this.bV) {
            return;
        }
        this.g = com.corrodinggames.rts.gameFramework.GameUtils.a(this.g, f2);
        if (this.g == 0.0f) {
            this.g = 27.0f;
            ++this.s;
            if (this.s > 4) {
                this.s = 0;
            }
        }
    }

    @Override
    public void a(j j2) {
        if (j2.j.equals(h)) {
            com.corrodinggames.rts.game.PlayerTeam.b((BaseUnit)this);
            this.a(2);
            com.corrodinggames.rts.game.PlayerTeam.c(this);
            this.W();
        } else {
            super.a(j2);
        }
    }

    @Override
    public int V() {
        return this.f;
    }

    @Override
    public void a(int n2) {
        if (n2 == 1) {
            this.f = 1;
        } else if (n2 == 2 && this.f == 1) {
            this.f = 2;
        }
        this.S();
    }

    @Override
    public ActionId cm() {
        if (this.f == 1) {
            return h;
        }
        return com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID;
    }

    public static void a(ArrayList arrayList, int n2) {
        arrayList.add(new SetRallyAction());
        if (n2 == 1) {
            arrayList.add(new b());
        }
        if (n2 > 1) {
            arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.dropship, 3.2f));
            arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.gunShip, 4.0f));
            arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.amphibiousJet, 5.0f));
        }
    }

    @Override
    public ArrayList N() {
        return this.K().a(this.V());
    }

    @Override
    public boolean bJ() {
        return true;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.K();
    }
}

