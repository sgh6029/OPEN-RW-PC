/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.gameFramework.FileChangeEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;

class aa {
    public long a;
    public String b;

    public aa(String string2) {
        this.b = string2;
        this.a = this.a(true);
    }

    public long a(boolean bl2) {
        if (GameEngine.au()) {
            return 0L;
        }
        long l2 = FileChangeEngine.a(this.b, bl2);
        if (bl2 && l2 == 0L) {
            GameEngine.log("Failed to watch: " + this.b);
        }
        return l2;
    }
}

