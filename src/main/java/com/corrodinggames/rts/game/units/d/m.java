/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.i;
import com.corrodinggames.rts.game.units.d.j;
import com.corrodinggames.rts.game.units.d.k;
import com.corrodinggames.rts.game.units.d.o;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import java.io.IOException;
import java.util.ArrayList;

public class m
extends i {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M[] d = new Texture_M[10];
    static Texture_M[] e = new Texture_M[10];
    static Texture_M f = null;
    boolean g;
    static final ActionId h = com.corrodinggames.rts.game.units.a.ActionId.isSameInstance(String.valueOf(110));

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.g);
        as2.c(0);
        super.a(as2);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameInputStream k2)  throws IOException {
        boolean bl2 = k2.e();
        if (bl2) {
            this.a(2);
        }
        k2.d();
        super.a(k2);
    }

    public static void b() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.land_factory_front);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.land_factory_front_t2);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.land_factory_back);
        f = l2.bO.a(com.corrodinggames.rts.R.drawable.land_factory_dead);
        d = com.corrodinggames.rts.game.PlayerTeam.a(a);
        e = com.corrodinggames.rts.game.PlayerTeam.a(b);
    }

    public UnitTypeEnum K() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.landFactory;
    }

    @Override
    public boolean L() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bR.a(this.posX, this.posY, this.posZ);
        this.m = null;
        this.M = f;
        this.S(0);
        this.bT = false;
        l2.bM.a(com.corrodinggames.rts.gameFramework.sound.e.p, 0.8f, this.posX, this.posY);
        return true;
    }

    @Override
    public void S() {
        super.S();
        this.m = this.bV ? null : c;
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return f;
        }
        if (this.bX == null) {
            return d[d.length - 1];
        }
        if (!this.g) {
            return d[this.bX.R()];
        }
        return e[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return null;
    }

    public m(boolean bl2) {
        super(bl2);
        this.M = a;
        this.m = c;
        this.b(this.M);
        this.ck = this.cj = 30.0f;
        this.cu = this.cv = 1200.0f;
        this.S(3);
        this.n.a(-1, -1, 1, 1);
        this.o.a(-1, -1, 1, 3);
    }

    @Override
    public void a(j j2) {
        if (h.fromString(j2.j)) {
            com.corrodinggames.rts.game.PlayerTeam.b((BaseUnit)this);
            this.a(2);
            com.corrodinggames.rts.game.PlayerTeam.c(this);
            this.W();
        } else {
            super.a(j2);
        }
    }

    @Override
    public void a(int n2) {
        if (n2 == 1) {
            this.g = false;
        } else if (n2 == 2 && !this.g) {
            this.g = true;
        }
        this.S();
    }

    @Override
    public ActionId cm() {
        if (!this.g) {
            return h;
        }
        return com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID;
    }

    public static void a(ArrayList arrayList, int n2) {
        arrayList.add(new com.corrodinggames.rts.game.units.a.SetRallyAction());
        if (n2 == 1) {
            arrayList.add(new com.corrodinggames.rts.game.units.d.n());
        }
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.builder, 1.0f));
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.tank, 2.0f));
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.hoverTank, 3.0f));
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.artillery, 4.0f));
        if (n2 >= 2) {
            arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.hovercraft, 5.0f));
            arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.heavyTank, 6.0f));
            arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.heavyHoverTank, 7.0f));
            arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.laserTank, 8.0f));
        }
    }

    @Override
    public ArrayList N() {
        return this.K().a(this.V());
    }

    @Override
    public int V() {
        if (this.g) {
            return 2;
        }
        return 1;
    }

    @Override
    public k du() {
        return new o(this);
    }

    @Override
    public boolean bJ() {
        return true;
    }

    @Override
    public float db() {
        return super.db() - 8.0f;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.K();
    }
}

