/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.q;
import com.corrodinggames.rts.game.units.custom.ag;
import com.corrodinggames.rts.game.units.custom.bb;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.utility.IniFile;

public final class bg {
    String a;
    g b;
    h c;
    q d;
    float e;
    float f;
    float g;
    float h;
    boolean i;
    boolean j;
    int k;
    int l;
    boolean m;
    boolean n;
    bb o;
    boolean p;

    public boolean a() {
        return this.n || this.m;
    }

    public void a(l l2, IniFile ab2, String string2) throws bo {
        this.b = ab2.a(string2, "anyRuleInGroup", (g)null);
        this.c = ab2.a(l2, string2, "searchTags", (h)null);
        this.d = (q)ab2.a(string2, "searchTeam", q.own, q.class);
        this.e = ab2.i(string2, "searchDistance");
        this.f = this.e * this.e;
        this.g = ab2.a(string2, "searchOffsetX", Float.valueOf(0.0f)).floatValue();
        this.h = ab2.a(string2, "searchOffsetY", Float.valueOf(0.0f)).floatValue();
        this.i = ab2.a(string2, "excludeIncompleteBuildings", (Boolean)false);
        this.j = ab2.a(string2, "excludeNonBuildings", (Boolean)false);
        this.k = ab2.b(string2, "minCount", Integer.MIN_VALUE);
        this.l = ab2.b(string2, "maxCount", Integer.MAX_VALUE);
        this.p = ab2.a(string2, "checkEachTile", (Boolean)true);
        this.m = ab2.a(string2, "aiSuggestionOnly", (Boolean)false);
        this.n = ab2.a(string2, "blocksPlacement", (Boolean)(!this.m ? true : false));
        if (this.m && this.n) {
            throw new bo("[" + string2 + "]: Cannot use aiSuggestionOnly and blocksPlacement at the same time");
        }
        this.o = ag.a(ab2, string2, "cannotPlaceMessage", null);
    }
}

