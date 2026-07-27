/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.f.b;
import com.corrodinggames.rts.gameFramework.f.f;
import com.corrodinggames.rts.gameFramework.GameEngine;

class f$1
extends b {
    final /* synthetic */ f b;

    f$1(f f2, String string2) {
        super(string2);
        this.b = f2;
    }

    @Override
    void b() {
        GameEngine l2 = GameEngine.getInstance();
        l2.du = true;
    }
}

