/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a.a;

import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.a.a.AIBehaviorType;
import com.corrodinggames.rts.game.a.a.UnitAIBehavior;
import com.corrodinggames.rts.game.a.f;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.a.e;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.d.l;

import android.graphics.PointF;

import com.corrodinggames.rts.game.units.y;

public class NukeBehavior
extends UnitAIBehavior {
    public final boolean b = true;
    static final g c = g.c("nukeLauncher");

    @Override
    public AIBehaviorType a() {
        return com.corrodinggames.rts.game.a.a.AIBehaviorType.nuking;
    }

    @Override
    public boolean c(AIController a2, y y2) {
        return this.a(y2);
    }

    public PointF d(AIController a2, y y2) {
        return a2.at();
    }

    public void e(AIController a2, y y2) {
        AbstractUnitAction s2 = f.a(a2, y2, e.launch);
        if (s2 != null) {
            if (s2.b(y2) && s2.a((BaseUnit)y2, false)) {
                PointF pointF = this.d(a2, y2);
                if (pointF != null) {
                    a2.c("nuke: launching at:" + pointF.x + ", " + pointF.b);
                    a2.a(y2, s2, pointF, null);
                } else {
                    a2.c("nuke: no target");
                }
            } else {
                a2.c("nuke: not ready");
            }
        }
    }

    public void f(AIController a2, y y2) {
        AbstractUnitAction s2;
        if (y2 instanceof l && ((l)((Object)y2)).dy() && (s2 = f.a(a2, y2, e.launchAmmo)) != null && a2.a(s2.B(), (BaseUnit)y2)) {
            a2.c("ai nuke building");
            a2.a(y2, s2);
        }
    }

    public boolean a(y y2) {
        return f.a(y2, c);
    }

    @Override
    public void b(float f2, AIController a2) {
        BaseUnit[] amArray = this.a.a();
        int n2 = this.a.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            y y2 = (y)amArray[i2];
            this.f(a2, y2);
            this.e(a2, y2);
        }
    }
}

