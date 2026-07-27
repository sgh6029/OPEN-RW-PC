/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.a.AIUnitGroupBase;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class RallyGroup
extends AIUnitGroupBase {
    float a = 0.0f;

    @Override
    public void a(GameOutputStream as2) throws IOException {
        int n2 = this.F.size();
        as2.a(n2);
        ArrayList<y> tmp = this.F;
        for (y y2 : tmp) {
            as2.a(y2);
        }
        as2.c(1);
        as2.a(this.G.size());
        ArrayList<y> tmp2 = this.G;
        for (y y2 : tmp2) {
            as2.a(y2);
        }
        as2.a(this.a);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        int n2;
        this.q();
        int n3 = k2.readInt();
        for (n2 = 0; n2 < n3; ++n2) {
            y y2 = k2.p();
            if (y2 == null) continue;
            this.a(y2);
        }
        n2 = k2.d();
        if (n2 >= 1) {
            this.G.clear();
            int n4 = k2.readInt();
            for (int i2 = 0; i2 < n4; ++i2) {
                y y3 = k2.p();
                if (y3 == null) continue;
                this.G.add(y3);
            }
            this.a = k2.g();
        }
        super.a(k2);
    }

    public RallyGroup(AIController a2) {
        super(a2);
    }

    @Override
    public void c(float f2) {
        this.n();
        if (!this.m()) {
            this.a += f2;
        }
        Iterator iterator = this.F.iterator();
        while (iterator.hasNext()) {
            y y2 = (y)iterator.next();
            if (!(this.c((BaseUnit)y2) < 3600.0f) || y2.cN != null) continue;
            if (y2.aB == this) {
                y2.aB = null;
            }
            iterator.remove();
        }
        if (this.F.size() == 0 || this.a > 5000.0f) {
            this.p();
        }
    }

    public void c(y y2) {
        this.a(y2);
        this.G.add(y2);
    }
}

