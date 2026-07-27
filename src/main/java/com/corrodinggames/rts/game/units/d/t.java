/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;

import java.util.ArrayList;


import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.SetRallyAction;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

public class t
extends i {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M[] d = new Texture_M[10];
    static Texture_M[] e = new Texture_M[10];
    static Texture_M f = null;
    static final ActionId g = com.corrodinggames.rts.game.units.a.ActionId.isSameInstance(String.valueOf(110));

    public static void b() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.sea_factory);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.sea_factory_t2);
        f = l2.bO.a(com.corrodinggames.rts.R.drawable.sea_factory_dead);
        d = com.corrodinggames.rts.game.PlayerTeam.a(a);
        e = com.corrodinggames.rts.game.PlayerTeam.a(b);
    }

    public UnitTypeEnum K() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.seaFactory;
    }

    @Override
    public boolean L() {
        this.m = null;
        this.M = f;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.large);
        return true;
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return f;
        }
        if (this.bX == null) {
            return d[d.length - 1];
        }
        if (this.r == 1) {
            return d[this.bX.R()];
        }
        return e[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return null;
    }

    public t(boolean bl2) {
        super(bl2);
        this.M = a;
        this.b(a);
        this.ck = this.cj = 45.0f;
        this.cu = this.cv = 1000.0f;
        this.S(2);
        this.n.a(-1, -1, 1, 2);
        this.o.a(-2, -1, 2, 4);
    }

    @Override
    public void a(j j2) {
        if (j2.j.equals(g)) {
            com.corrodinggames.rts.game.PlayerTeam.b((BaseUnit)this);
            this.a(2);
            com.corrodinggames.rts.game.PlayerTeam.c(this);
            this.W();
        } else {
            super.a(j2);
        }
    }

    @Override
    public int dv() {
        return -20;
    }

    @Override
    public int V() {
        return this.r;
    }

    @Override
    public void a(int n2) {
        if (n2 == 1) {
            this.r = 1;
        } else if (n2 == 2 && this.r == 1) {
            this.r = 2;
        }
        this.S();
    }

    @Override
    public ActionId cm() {
        if (this.r == 1) {
            return g;
        }
        return com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID;
    }

    public static void a(ArrayList arrayList, int n2) {
        arrayList.add(new SetRallyAction());
        arrayList.add(new u());
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.builderShip, 1.0f));
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.gunBoat, 2.0f));
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.missileShip, 3.0f));
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.hovercraft, 4.0f));
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.battleShip, 5.0f));
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.attackSubmarine, 6.0f));
        if (n2 > 1) {
            // empty if block
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

