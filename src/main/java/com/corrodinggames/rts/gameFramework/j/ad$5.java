/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.f.a.c;
import com.corrodinggames.rts.gameFramework.f.a.f;
import com.corrodinggames.rts.gameFramework.f.a.k;
import com.corrodinggames.rts.gameFramework.GameEngine;

class ad$5
extends k {
    final /* synthetic */ f a;
    final /* synthetic */ GameEngine b;
    final /* synthetic */ NetworkEngine c;

    ad$5(NetworkEngine ad2, f f2, GameEngine l2) {
        this.c = ad2;
        this.a = f2;
        this.b = l2;
    }

    @Override
    public boolean a(c c2) {
        this.a.i();
        this.b.a(new ad$5$1(this));
        return true;
    }
}

