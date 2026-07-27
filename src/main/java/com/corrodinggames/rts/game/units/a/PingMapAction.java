/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Rect;

import java.util.ArrayList;

public class PingMapAction
extends AbstractUnitAction {
    public PingType a;
    static ArrayList b = new ArrayList();
    static Rect c;

    public PingMapAction() {
        this(PingType.normal);
    }

    public PingMapAction(PingType k2) {
        super("c_6_" + k2.name());
        this.a = k2;
    }

    @Override
    public int b(BaseUnit am2, boolean bl2) {
        return -1;
    }

    @Override
    public int c() {
        return 0;
    }

    public UnitTypeEnum w() {
        return null;
    }

    @Override
    public ActionType e() {
        return ActionType.pingMap;
    }

    @Override
    public ActionDisplayType f() {
        return ActionDisplayType.none;
    }

    @Override
    public boolean g() {
        return false;
    }

    @Override
    public String a() {
        return "Ping Map" + this.a.a();
    }

    @Override
    public String b() {
        return this.a.b();
    }

    public String K() {
        return this.a.c();
    }

    @Override
    public boolean h_() {
        return false;
    }

    @Override
    public boolean s() {
        return true;
    }

    public static PingMapAction a(ActionId c2) {
        for (AbstractUnitAction s2 : ((ArrayList<AbstractUnitAction>)b)) {
            if (!s2.d(c2)) continue;
            return (PingMapAction)s2;
        }
        return null;
    }

    @Override
    public ArrayList q(BaseUnit am2) {
        return b;
    }

    @Override
    public Texture_M j() {
        return com.corrodinggames.rts.gameFramework.effect.c.s[9].i;
    }

    @Override
    public Rect v() {
        int n2 = 7 + this.a.ordinal();
        c.a(29 * n2, 0, 29 * n2 + 28, 28);
        return c;
    }

    @Override
    public /* synthetic */ UnitType i() {
        return this.w();
    }

    static {
        for (PingType k2 : PingType.values()) {
            b.add(new PingMapAction(k2));
        }
        c = new Rect();
    }
}

