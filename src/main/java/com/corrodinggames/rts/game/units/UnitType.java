/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.SelectUnitTypeAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.custom.be;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import java.util.ArrayList;

public interface UnitType {
    public boolean C();

    public boolean w();

    public BaseUnit createUnitInstance();

    public SelectUnitTypeAction d();

    public int c();

    public int b(int var1);

    public b u();

    public b d(int var1);

    public b B();

    public Texture_M z();

    public boolean y();

    public float D();

    public int g();

    public boolean j();

    public boolean l();

    public boolean k();

    public boolean m();

    public boolean n();

    public UnitMovementType o();

    public boolean p();

    public be q();

    public String e();

    public String f();

    public String i();

    public void h();

    public ArrayList a(int var1);

    public String v();

    public h x();

    public int a(BaseUnit var1);
}

