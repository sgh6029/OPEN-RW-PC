/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a.a;

import java.io.IOException;
import java.util.List;

import com.corrodinggames.rts.game.a.a.AIBehavior;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.utility.UnitList;

public abstract class UnitAIBehavior
extends AIBehavior {
    UnitList a = new UnitList();

    @Override
    public void a(GameInputStream k2) throws IOException {
        super.a(k2);
        int n2 = k2.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            y y2 = k2.p();
            if (y2 == null) continue;
            this.a.a(y2);
        }
    }

    @Override
    public void a(GameOutputStream as2) throws IOException {
        super.a(as2);
        int n2 = this.a.size();
        as2.a(n2);
        List<y> tmp = this.a;
        for (y y2 : tmp) {
            as2.a(y2);
        }
    }

    public abstract boolean c(com.corrodinggames.rts.game.a.AIController var1, y var2);

    @Override
    public void a(com.corrodinggames.rts.game.a.AIController a2, y y2) {
        if (this.c(a2, y2) && !this.a.contains(y2)) {
            this.a.a(y2);
        }
    }

    @Override
    public void b(com.corrodinggames.rts.game.a.AIController a2, y y2) {
    }
}

