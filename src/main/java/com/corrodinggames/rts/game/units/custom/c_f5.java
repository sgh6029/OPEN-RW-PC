/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.a_f5;
import com.corrodinggames.rts.game.units.custom.b_f;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.d_f;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.utility.m;

import test.rudp.a_f;

import java.util.Collections;
import java.util.List;

public final class c_f5 {
    d_f a;
    int b;
    String c;
    float d;
    public a_f5[] e;
    private m g = new m();
    public final boolean f = false;

    public b_f a() {
        b_f b2 = null;
        if (this.g.size() > 0) {
            b2 = (b_f)this.g.get(this.g.size() - 1);
            if (b2.h) {
                b2 = null;
            }
        }
        return b2;
    }

    public void a(j j2, float f2, float f3, boolean bl2) {
        if (bl2) {
            return;
        }
        if (f3 <= f2) {
            return;
        }
        a_f5[] aArray = this.e;
        int n2 = aArray.length;
        int n3 = -1;
        while (n3 + 1 < n2 && !(f2 <= aArray[n3 + 1].a)) {
            ++n3;
        }
        int n4 = n3;
        while (n4 + 1 < n2 && !(f3 <= aArray[n4 + 1].a)) {
            ++n4;
        }
        if (n4 <= n3) {
            return;
        }
        for (int i2 = n3 + 1; i2 <= n4; ++i2) {
            b_f b2 = (b_f)aArray[i2];
            b2.a(j2);
        }
    }

    public void b() throws bo {
        b_f b2;
        if (this.a == com.corrodinggames.rts.game.units.custom.d_f.event && (b2 = this.a()) != null) {
            b2.finalize();
        }
    }

    public void a(l l2, float f2, String string2, String string3) throws bo {
        float f3;
        if (this.a == com.corrodinggames.rts.game.units.custom.d_f.event) {
            b_f b2 = this.a();
            if (b2 == null) {
                b2 = new b_f(f2, 0.0f);
                this.g.add(b2);
            }
            b2.a(l2, string2, string3);
            return;
        }
        try {
            f3 = Float.parseFloat(string3);
        }
        catch (NumberFormatException numberFormatException) {
            throw new bo("Failed to parse float:" + string3);
        }
        this.a(f2, f3);
    }

    public void a(float f2, float f3) throws bo {
        a_f5 a2;
        if (this.a == com.corrodinggames.rts.game.units.custom.d_f.event) {
            throw new bo("Adding key frame value to event set");
        }
        if (this.g.size() == 0 && f2 > 0.0f && f3 != 0.0f) {
            a2 = new a_f5(0.0f, 0.0f);
            this.g.add(a2);
        }
        a2 = new a_f5(f2, f3);
        this.g.add(a2);
    }

    public void a(float f2) {
        for (a_f5 a2 : ((List<a_f5>)this.g) ){
            a2.a *= f2;
        }
    }

    public void c() {
        Collections.sort(this.g);
        a_f5 a2 = null;
        for (a_f5 a3 : ((List<a_f5>)this.g) ){
            if (a2 != null) {
                a3.c = 1.0f / (a3.a - a2.a);
                a3.d = a3.b - a2.b;
            }
            a2 = a3;
            this.d = a3.a;
        }
        this.e = (a_f5[])this.g.toArray(new a_f5[0]);
        this.g = null;
    }

    public float b(float f2) {
        a_f5[] aArray = this.e;
        int n2 = aArray.length;
        if (n2 == 1 || f2 <= aArray[0].a) {
            return aArray[0].b;
        }
        if (f2 >= this.d) {
            return aArray[n2 - 1].b;
        }
        int n3 = 1;
        while (f2 > aArray[n3].a) {
            if (++n3 < n2) continue;
            return aArray[n2 - 1].b;
        }
        a_f5 a2 = aArray[n3 - 1];
        a_f5 a3 = aArray[n3];
        float f3 = (f2 - a2.a) * a3.c;
        float f4 = a2.b + a3.d * f3;
        return f4;
    }
}

