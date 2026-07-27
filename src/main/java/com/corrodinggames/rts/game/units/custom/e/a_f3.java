/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.e;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bb;
import com.corrodinggames.rts.game.units.custom.e.a.c;
import com.corrodinggames.rts.game.units.custom.e.a.e;
import com.corrodinggames.rts.game.units.custom.e.a.f;
import com.corrodinggames.rts.game.units.custom.e.b;
import com.corrodinggames.rts.game.units.custom.e.d;
import com.corrodinggames.rts.game.units.custom.l;
import java.util.ArrayList;
import java.util.Locale;

public class a_f3 {
    public boolean a;
    protected String b;
    protected bb c;
    protected bb d;
    protected boolean e;
    protected boolean f;
    protected bb g;
    protected bb h;
    public a_f3 i;
    public boolean j;
    public boolean k;
    public boolean l = true;
    Integer m;
    public boolean n;
    public boolean o;
    public boolean p;
    public b q = com.corrodinggames.rts.game.units.custom.e.b.none;
    boolean r;
    float s;
    protected boolean t;
    protected boolean u;
    a_f3 v;
    public boolean w;
    public float x;
    public com.corrodinggames.rts.gameFramework.m.Texture_M y;
    public boolean z;
    static ArrayList<a_f3> A = new ArrayList<a_f3>();
    static ArrayList B = new ArrayList();
    public static ArrayList<a_f3> C = new ArrayList<a_f3>();
    public static final a_f3 D = com.corrodinggames.rts.game.units.custom.e.a_f3.a(new c());
    public static final a_f3 E = com.corrodinggames.rts.game.units.custom.e.a_f3.a(new com.corrodinggames.rts.game.units.custom.e.a.d());
    public static final a_f3 F = com.corrodinggames.rts.game.units.custom.e.a_f3.a(new com.corrodinggames.rts.game.units.custom.e.a.b());
    public static final a_f3 G;
    public static final a_f3 H;

    public boolean a() {
        return this.r;
    }

    public float b() {
        return this.s;
    }

    public boolean c() {
        return this.u;
    }

    public boolean d() {
        return this.t;
    }

    public static void e() {
        for (Object object : A) {
            ((a_f3)object).g();
        }
        ArrayList arrayList = new ArrayList();
        for (a_f3 a2 : A) {
            if (!a2.a) continue;
            arrayList.add(a2);
        }
        B = arrayList;
    }

    public static ArrayList f() {
        return B;
    }

    public void g() {
        if (this.u) {
            this.a = true;
            return;
        }
        d d2 = null;
        for (l l2 : com.corrodinggames.rts.game.units.custom.l.d) {
            d d3 = l2.a(this);
            if (d3 == null || d2 != null && !(d2.c < d3.c)) continue;
            d2 = d3;
        }
        boolean bl2 = this.a = d2 != null;
        if (d2 != null) {
            this.c = d2.g;
            this.d = d2.h;
            this.e = d2.i;
            this.f = d2.j;
            this.m = d2.d;
            this.n = d2.e;
            this.o = d2.o;
            this.p = d2.p;
            this.q = d2.r;
            this.g = d2.t;
            this.h = d2.u;
            this.i = d2.w;
            this.j = d2.y;
            this.l = d2.q;
            this.k = d2.x;
            this.r = d2.l;
            this.s = d2.m;
            this.v = d2.A;
            this.w = d2.k;
            this.x = d2.s;
            this.y = d2.B;
            this.z = d2.C;
        }
    }

    public Integer h() {
        return this.m;
    }

    public String i() {
        if (this.c == null) {
            return this.b;
        }
        return this.c.b();
    }

    public String j() {
        if (this.d != null) {
            return this.d.b();
        }
        return this.i();
    }

    public String a(double d2, boolean bl2) {
        String string2 = this.o ? "" + (int)d2 : com.corrodinggames.rts.gameFramework.GameUtils.c(d2);
        string2 = com.corrodinggames.rts.game.units.custom.e.a_f3.a(string2, this.q);
        return this.a(bl2) + string2 + this.b(bl2);
    }

    public static String a(String string2, b b2) {
        String string3;
        if (b2 == com.corrodinggames.rts.game.units.custom.e.b.none) {
            return string2;
        }
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (l2.bQ.disableDigitGrouping) {
            return string2;
        }
        String string4 = string2;
        String string5 = "";
        String string6 = "";
        int n2 = string4.indexOf(".");
        if (n2 != -1) {
            string6 = string4.substring(n2);
            string4 = string4.substring(0, n2);
        }
        if (string4.length() <= 3) {
            return string2;
        }
        if (b2 == com.corrodinggames.rts.game.units.custom.e.b.space) {
            string3 = " ";
        } else if (b2 == com.corrodinggames.rts.game.units.custom.e.b.comma) {
            string3 = ",";
        } else {
            throw new RuntimeException("Unhandled grouping style: " + (Object)((Object)b2));
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = string4.length() % 3;
        if (n3 != 0) {
            stringBuilder.append(string4.substring(0, n3));
        }
        for (int i2 = n3; i2 < string4.length(); i2 += 3) {
            if (i2 != 0) {
                stringBuilder.append(string3);
            }
            stringBuilder.append(string4.substring(i2, i2 + 3));
        }
        if (string6 == "") {
            return stringBuilder.toString();
        }
        return stringBuilder.toString() + string6;
    }

    public static String a(long l2, b b2) {
        if (b2 == com.corrodinggames.rts.game.units.custom.e.b.none) {
            return "" + l2;
        }
        if (b2 == com.corrodinggames.rts.game.units.custom.e.b.space) {
            return String.format(Locale.US, "%,d", l2).replace(",", " ");
        }
        if (b2 == com.corrodinggames.rts.game.units.custom.e.b.comma) {
            return String.format(Locale.US, "%,d", l2);
        }
        throw new RuntimeException("Unhandled grouping style: " + (Object)((Object)b2));
    }

    public String a(boolean bl2) {
        if (this.g != null) {
            return this.g.b();
        }
        if (bl2 && this.e) {
            return "";
        }
        return this.i() + ": ";
    }

    public String b(boolean bl2) {
        if (this.h != null) {
            return this.h.b();
        }
        return "";
    }

    public com.corrodinggames.rts.gameFramework.m.Texture_M k() {
        return this.y;
    }

    protected a_f3() {
    }

    public static a_f3 a(String string2) {
        string2 = string2.toLowerCase(Locale.ENGLISH);
        for (a_f3 a2 : C) {
            if (!a2.b.equalsIgnoreCase(string2)) continue;
            return a2;
        }
        return null;
    }

    public static a_f3 a(a_f3 a2) {
        for (a_f3 a3 : A) {
            if (!a3.b.equals(a2.b)) continue;
            throw new RuntimeException("Built in resource already exists:" + a2.b);
        }
        a_f3 a4 = a2;
        A.add(a4);
        C.add(a4);
        return a4;
    }

    public static a_f3 a(String string2, boolean bl2, boolean bl3) {
        for (a_f3 a2 : A) {
            if (!a2.b.equals(string2)) continue;
            return a2;
        }
        a_f3 a3 = new a_f3();
        a3.b = string2;
        a3.u = bl2;
        a3.t = bl3;
        A.add(a3);
        return a3;
    }

    public static a_f3 b(String string2) {
        for (a_f3 a2 : A) {
            if (!a2.b.equals(string2)) continue;
            return a2;
        }
        return null;
    }

    private String a(double d2) {
        String string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(d2, 1);
        return com.corrodinggames.rts.game.units.custom.e.a_f3.a(string2, this.q);
    }

    public String a(double d2, boolean bl2, boolean bl3) {
        String string2 = bl3 && this.f ? "" : this.j() + ": ";
        if (this == D) {
            string2 = "$";
        }
        if (bl2) {
            if (d2 > 0.0) {
                return "+" + string2 + this.a(d2);
            }
            return "-" + string2 + this.a(-d2);
        }
        if (d2 > 0.0) {
            return string2 + this.a(d2);
        }
        return string2 + this.a(d2);
    }

    public String toString() {
        return "resource(" + this.b + ")";
    }

    public double a(BaseUnit am2) {
        if (this.t) {
            return am2.bX.c(this);
        }
        return am2.a(this);
    }

    public void a(BaseUnit am2, double d2) {
        if (this.t) {
            am2.bX.V().a(this, d2);
        } else {
            am2.df().a(this, d2);
        }
    }

    public void b(BaseUnit am2, double d2) {
        if (this.t) {
            am2.bX.V().b(this, d2);
        } else {
            am2.df().b(this, d2);
        }
    }

    static {
        H = com.corrodinggames.rts.game.units.custom.e.a_f3.a(new f());
        G = com.corrodinggames.rts.game.units.custom.e.a_f3.a(new e());
    }
}

