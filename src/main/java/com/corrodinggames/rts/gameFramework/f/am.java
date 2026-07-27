/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.Serializable;
import com.corrodinggames.rts.gameFramework.f.GameUIController;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GGameObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class am
        extends Serializable {
    private final GameUIController i;
    public ArrayList<com.corrodinggames.rts.game.units.BaseUnit> a = new ArrayList<com.corrodinggames.rts.game.units.BaseUnit>();
    public float b;
    public long c;
    public float d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;

    public am(GameUIController a2, boolean bl2) {
        this.i = a2;
        this.g = bl2;
    }

    public void a() {
        com.corrodinggames.rts.game.units.BaseUnit am2 = null;
        for (com.corrodinggames.rts.game.units.BaseUnit am3 : this.a) {
            boolean bl2;
            if (am3.bV || am3.cN != null || !(bl2 = this.i.a.j(am3)) || !am3.cf())
                continue;
            am2 = am3;
        }
        if (this.c > GameEngine.V() - 700L && am2 != null) {
            this.i.b.b(am2.posX, am2.posY);
        }
        this.c = GameEngine.V();
    }

    public void b() {
        this.a.clear();
    }

    public void c() {
        for (GGameObject w2 : ((List<GGameObject>) GGameObject.fastGameObjectList)) {
            if (!(w2 instanceof y))
                continue;
            y y2 = (y) w2;
            if (!y2.cG || this.a.contains(y2))
                continue;
            this.a.add(y2);
        }
    }

    @Override
    public void a(GameOutputStream as2) throws IOException {
        this.d();
        as2.a(this.b);
        as2.a(this.c);
        int n2 = this.a.size();
        as2.a(n2);
        for (com.corrodinggames.rts.game.units.BaseUnit am2 : this.a) {
            as2.a(am2);
        }
        as2.c(0);
    }

    public void a(GameInputStream k2) throws IOException {
        this.b = k2.g();
        this.c = k2.i();
        this.a.clear();
        int n2 = k2.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            com.corrodinggames.rts.game.units.BaseUnit am2 = k2.o();
            if (am2 == null)
                continue;
            this.a.add(am2);
        }
        k2.d();
    }

    public void d() {
        if (this.a.size() == 0) {
            return;
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            com.corrodinggames.rts.game.units.BaseUnit am2 = (com.corrodinggames.rts.game.units.BaseUnit) iterator.next();
            if (!am2.bV)
                continue;
            iterator.remove();
        }
    }

    public void e() {
        if (this.a.size() == 0) {
            return;
        }
        ArrayList<com.corrodinggames.rts.game.units.BaseUnit> arrayList = new ArrayList<com.corrodinggames.rts.game.units.BaseUnit>();
        for (com.corrodinggames.rts.game.units.BaseUnit am2 : this.a) {
            com.corrodinggames.rts.game.units.BaseUnit am3 = GGameObject.a(am2.objectId, true);
            if (am3 == null || am3.bV)
                continue;
            arrayList.add(am3);
        }
        this.a = arrayList;
    }
}
