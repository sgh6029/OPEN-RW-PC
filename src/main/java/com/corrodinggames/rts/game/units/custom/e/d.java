/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.e;

import com.corrodinggames.rts.game.units.custom.ag;
import com.corrodinggames.rts.game.units.custom.bb;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.e.a_f3;
import com.corrodinggames.rts.game.units.custom.e.b;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.IniFile;

public class d {
    public String a;
    public a_f3 b;
    public float c;
    public Integer d;
    public boolean e;
    public boolean f;
    bb g;
    bb h;
    boolean i;
    boolean j;
    public boolean k;
    public boolean l;
    public float m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public b r = com.corrodinggames.rts.game.units.custom.e.b.none;
    public int s;
    public bb t;
    public bb u;
    public String v;
    public a_f3 w;
    public boolean x;
    public boolean y;
    public String z;
    public a_f3 A;
    public Texture_M B;
    public boolean C;

    public d(boolean bl2) {
        this.f = bl2;
    }

    public void a(l l2, IniFile ab2, String string2, String string3) throws bo {
        bb bb2;
        this.a = string3;
        this.g = ag.a(ab2, string2, "displayName", null);
        this.h = ag.a(ab2, string2, "displayNameShort", null);
        if (this.h == null) {
            this.h = this.g;
        }
        this.i = ab2.a(string2, "displayNameHideWhenIconShownInHUD", (Boolean)false);
        this.j = ab2.a(string2, "displayNameHideWhenIconShownInText", (Boolean)false);
        this.l = ab2.a(string2, "hidden", (Boolean)false);
        float f2 = 1.0f;
        boolean bl2 = ab2.a(string2, "includeInStats", (Boolean)true);
        if (!bl2) {
            f2 = 0.0f;
        }
        if (this.l || !this.f) {
            f2 = 0.0f;
        }
        this.m = ab2.a(string2, "valueInStats", Float.valueOf(f2)).floatValue();
        if (!bl2 && this.m != 0.0f) {
            throw new bo("[" + string2 + "]includeInStats==false expects valueInStats==0");
        }
        if (this.m < 0.0f) {
            throw new bo("[" + string2 + "]valueInStats cannot be < 0 (is:" + this.m + ")");
        }
        this.k = ab2.a(string2, "stackHorizontal", (Boolean)false);
        this.c = ab2.a(string2, "priority", Float.valueOf(0.0f)).floatValue();
        this.d = ab2.a(string2, "displayColor", (Integer)null);
        this.e = ab2.a(string2, "displayColorUseInText", (Boolean)true);
        this.n = ab2.a(string2, "displayWithRounding", (Boolean)true);
        this.o = ab2.a(string2, "displayRoundedDown", (Boolean)false);
        this.p = ab2.a(string2, "displayWhenZero", (Boolean)false);
        boolean bl3 = !this.l && this.f;
        this.q = ab2.a(string2, "displayInHud", (Boolean)bl3);
        if (this.q && !this.f) {
            throw new bo("[" + string2 + "]displayInHud:true currently only supported on global resources");
        }
        if (this.q && this.l) {
            throw new bo("[" + string2 + "]displayInHud:true only supported non-hidden resources");
        }
        this.s = ab2.b(string2, "displayPos", 0);
        this.r = (b)ab2.a(string2, "displayDigitGrouping", com.corrodinggames.rts.game.units.custom.e.b.none, b.class);
        this.t = ag.a(ab2, string2, "displayTextPrefix", null);
        this.u = ag.a(ab2, string2, "displayTextPostfix", null);
        bb bb3 = ag.a(ab2, string2, "displayPrefixInHUD", null);
        if (bb3 != null) {
            if (this.t != null) {
                throw new bo("[" + string2 + "]displayPrefixInHUD and displayTextPrefix are aliases, don't use both");
            }
            this.t = bb3;
        }
        if ((bb2 = ag.a(ab2, string2, "displayPostfixInHUD", null)) != null) {
            if (this.u != null) {
                throw new bo("[" + string2 + "]displayPostfixInHUD and displayTextPostfix are aliases, don't use both");
            }
            this.u = bb2;
        }
        this.v = ab2.b(string2, "displayTextAppendResource", (String)null);
        String string4 = ab2.b(string2, "appendResourceInHUD", (String)null);
        if (string4 != null) {
            if (this.v != null) {
                throw new bo("[" + string2 + "]displayTextAppendResource and appendResourceInHUD are aliases, don't use both");
            }
            this.v = string4;
        }
        this.x = ab2.a(string2, "displayTextAppendResourceWithGap", (Boolean)false);
        this.y = ab2.a(string2, "appendResourceInHUD_whenThisZero", (Boolean)true);
        this.B = l2.a(ab2, string2, "iconImage", true);
        if (this.B != null && (this.B.m() > 100 || this.B.l() > 100)) {
            throw new bo("[" + string2 + "]iconImage: Image is too big, keep under 100x100");
        }
        this.C = ab2.a(string2, "iconImageUseInText", (Boolean)true);
        if (this.i && this.B == null) {
            throw new bo("[" + string2 + "]displayNameHideWhenIconShownInHUD: Cannot use without iconImage");
        }
        if (this.j && this.B == null) {
            throw new bo("[" + string2 + "]displayNameHideWhenIconShownInText: Cannot use without iconImage");
        }
        String string5 = this.f ? "g_" : "l_";
        string5 = string5 + this.a;
        this.b = com.corrodinggames.rts.game.units.custom.e.a_f3.a(string5, false, this.f);
        if (this.b.u) {
            throw new RuntimeException("Cannot define resource with a built-in name: " + string5);
        }
        if (!this.f) {
            String string6;
            this.z = string6 = ab2.b(string2, "equivalentGlobalResourceForAI", (String)null);
        }
    }

    public void a(l l2) throws bo {
        if (this.z != null) {
            this.A = l2.k(this.z);
            if (this.A == null) {
                throw new bo("[resource]equivalentGlobalResourceForAI: Failed to find resource: " + this.z);
            }
            if (!this.A.t) {
                throw new bo("[resource]equivalentGlobalResourceForAI: Expected global resource for: " + this.z);
            }
        }
        if (this.v != null) {
            this.w = l2.k(this.v);
            if (this.w == null) {
                throw new bo("[resource]displayTextAppendResource: Failed to find resource: " + this.v);
            }
        }
    }
}

