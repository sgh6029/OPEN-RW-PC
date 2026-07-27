/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.y;
import java.util.HashMap;

public class BuildPreferenceCache {
    HashMap a = new HashMap();
    HashMap b = new HashMap();
    HashMap c = new HashMap();

    public Integer a(boolean bl2, UnitType as2, boolean bl3) {
        if (bl2) {
            return (Integer)this.c.get(as2);
        }
        if (!bl3) {
            return (Integer)this.b.get(as2);
        }
        return (Integer)this.a.get(as2);
    }

    public void a(boolean bl2, UnitType as2, boolean bl3, Integer n2) {
        if (bl2) {
            this.c.put(as2, n2);
        } else if (!bl3) {
            this.b.put(as2, n2);
        } else {
            this.a.put(as2, n2);
        }
    }

    public void a() {
        this.a.clear();
        this.b.clear();
    }

    public void a(UnitType as2) {
        this.a.put(as2, null);
        this.b.put(as2, null);
    }

    public void a(y y2) {
        this.c.put(y2.dz, null);
    }

    public void b() {
        this.c.clear();
    }
}

