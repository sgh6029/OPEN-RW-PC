/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.e.f;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class x
extends com.corrodinggames.rts.game.units.x {
    f a = new f();

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.fogRevealer;
    }

    public x() {
        super(true);
        this.bX = PlayerTeam.i;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        GameEngine.a("PlaceholderUnit was updated");
        this.ci();
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
    public f df() {
        return this.a;
    }

    public void a(f f2) {
        this.a = f2;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }
}

