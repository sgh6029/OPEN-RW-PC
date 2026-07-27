/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.d;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.SetRallyAction;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.UnitSize;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.f$1;
import com.corrodinggames.rts.game.units.d.i;
import com.corrodinggames.rts.game.units.d.j;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import java.io.IOException;
import java.util.ArrayList;

public class f
extends i {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M[] c = new Texture_M[10];
    static Texture_M[] d = new Texture_M[10];
    static Texture_M e = null;
    boolean f;
    static AbstractUnitAction g = new f$1(110);

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2)  throws IOException {
        as2.a(this.f);
        as2.c(0);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        boolean bl2 = k2.e();
        if (bl2) {
            this.M();
        }
        k2.d();
        super.a(k2);
    }

    public static void b() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.experimental_unit_factory_front);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.experimental_unit_factory_base);
        e = l2.bO.a(com.corrodinggames.rts.R.drawable.experimental_unit_factory_dead);
        c = com.corrodinggames.rts.game.PlayerTeam.a(a);
    }

    public UnitTypeEnum K() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.experimentalLandFactory;
    }

    @Override
    public boolean L() {
        GameEngine l2 = GameEngine.getInstance();
        this.m = null;
        this.M = e;
        this.S(0);
        this.bT = false;
        this.a(com.corrodinggames.rts.game.units.UnitSize.verylargeBuilding);
        return true;
    }

    @Override
    public void a(int n2) {
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return e;
        }
        if (this.bX == null) {
            return c[c.length - 1];
        }
        if (!this.f) {
            return c[this.bX.R()];
        }
        return d[this.bX.R()];
    }

    @Override
    public void S() {
        super.S();
        this.m = this.bV ? null : b;
    }

    @Override
    public Texture_M k() {
        return null;
    }

    public f(boolean bl2) {
        super(bl2);
        this.M = a;
        this.m = b;
        this.b(this.M);
        this.ck = this.cj = 55.0f;
        this.cu = this.cv = 3200.0f;
        this.S(4);
        this.n.a(-2, -2, 2, 2);
        this.o.a(-2, -2, 2, 4);
    }

    @Override
    public void a(j j2) {
        if (j2.j.equals(g.N())) {
            this.M();
        } else {
            super.a(j2);
        }
    }

    public void M() {
        if (!this.f) {
            this.f = true;
            this.S();
        }
    }

    @Override
    public ActionId cm() {
        return com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID;
    }

    public static void a(ArrayList arrayList, int n2) {
        arrayList.add(new SetRallyAction());
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.experimentalTank, 2.0f));
        arrayList.add(new com.corrodinggames.rts.game.units.a.QueueUnitAction(com.corrodinggames.rts.game.units.UnitTypeEnum.experimentalHoverTank, 3.0f));
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
    public int V() {
        return 2;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.K();
    }
}

