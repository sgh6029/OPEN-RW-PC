/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.n;

import java.util.List;

import com.corrodinggames.rts.gameFramework.n.MapTrigger;
import com.corrodinggames.rts.gameFramework.utility.m;

public class TriggerGroup {
    m a = new m();
    boolean b;

    public void a(MapTrigger a2) {
        this.a.add(a2);
    }

    public boolean a() {
        return this.a.a > 0;
    }

    public boolean b() {
        boolean bl2 = false;
        boolean bl3 = true;
        for (MapTrigger a2 : ((List<MapTrigger>) this.a)) {
            if (a2.j) {
                bl2 = true;
                continue;
            }
            bl3 = false;
        }
        if (this.b && !bl3) {
            bl2 = false;
        }
        return bl2;
    }
}
