/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import java.util.List;

import java.util.List;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.UnitEventListener;
import com.corrodinggames.rts.gameFramework.utility.m;

public class UnitEventManager {
    m a = new m();

    public void a(BaseUnit am2, BaseUnit am3) {
        if (this.a.a > 0) {
            for (UnitEventListener bk2 : ((List<UnitEventListener>)this.a) ){
                bk2.a(am2, am3, null);
            }
        }
    }
}

