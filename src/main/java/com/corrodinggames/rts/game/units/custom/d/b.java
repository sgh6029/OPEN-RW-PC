/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.d;

import java.io.IOException;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.d.a;
import com.corrodinggames.rts.game.units.custom.e.e;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.f.ae;
import com.corrodinggames.rts.gameFramework.f.an;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.utility.IniFile;

import android.graphics.Color;

public class b
extends a
implements Comparable {
    private static final com.corrodinggames.rts.game.units.custom.e.f m = new com.corrodinggames.rts.game.units.custom.e.f().a();
    public static final b a = com.corrodinggames.rts.game.units.custom.d.b.a(0);
    public int b;
    public float c;
    public float d;
    public float e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public com.corrodinggames.rts.game.units.custom.e.f k = m;
    static final int l = Color.a(255, 0, 100, 0);

    public int a() {
        return this.b;
    }

    public int b() {
        if (this.k == m) {
            return this.b;
        }
        int n2 = this.b;
        int n3 = this.k.b.a;
        Object[] objectArray = this.k.b.a();
        for (int i2 = 0; i2 < n3; ++i2) {
            float f2;
            e e2 = (e)objectArray[i2];
            if (!(e2.b > 0.0) || (f2 = e2.a.b()) == 0.0f) continue;
            n2 += (int)((double)f2 * e2.b);
        }
        return n2;
    }

    public static b a(b b2, b b3) {
        b b4 = new b();
        b4.b = b2.b + b3.b;
        b4.c = b2.c + b3.c;
        b4.d = b2.d + b3.d;
        b4.e = b2.e + b3.e;
        b4.f = b2.f + b3.f;
        if (!b2.k.c() || !b3.k.c()) {
            b4.k = com.corrodinggames.rts.game.units.custom.e.f.a(b2.k, b3.k);
        }
        return b4;
    }

    public static b a(b b2, float f2) {
        b b3 = new b();
        b3.b = (int)((float)b2.b * f2);
        b3.c = b2.c * f2;
        b3.d = b2.d * f2;
        b3.e = b2.e * f2;
        b3.f = (int)((float)b2.f * f2);
        if (!b2.k.c()) {
            b3.k = com.corrodinggames.rts.game.units.custom.e.f.b(b2.k, f2);
        }
        return b3;
    }

    public static b a(int n2) {
        b b2 = new b();
        b2.b = n2;
        return b2;
    }

    public static b a(l l2, IniFile ab2, String string2, String string3, boolean bl2) throws bo {
        String string4 = ab2.b(string2, string3, (String)null);
        if (string4 == null && !bl2) {
            throw new RuntimeException("Could not find " + string3 + " in configuration file under:" + string2);
        }
        try {
            b b2 = com.corrodinggames.rts.game.units.custom.d.b.b(l2, string4);
            return b2;
        }
        catch (bo bo2) {
            throw new bo("[" + string2 + "]" + string3 + ": " + bo2.getMessage());
        }
    }

    public static b a(l l2, IniFile ab2, String string2, String string3, b b2) throws bo {
        String string4 = ab2.b(string2, string3, (String)null);
        if (string4 == null) {
            return b2;
        }
        try {
            b b3 = com.corrodinggames.rts.game.units.custom.d.b.b(l2, string4);
            return b3;
        }
        catch (bo bo2) {
            throw new bo("[" + string2 + "]" + string3 + ": " + bo2.getMessage());
        }
    }

    public static b b(l l2, IniFile ab2, String string2, String string3, b b2) throws bo {
        String string4 = ab2.b(string2, string3, (String)null);
        if (string4 == null) {
            return b2;
        }
        try {
            b b3 = com.corrodinggames.rts.game.units.custom.d.b.a(l2, string4);
            return b3;
        }
        catch (bo bo2) {
            throw new bo("[" + string2 + "]" + string3 + ": " + bo2.getMessage());
        }
    }

    public static void b(int n2) throws bo {
        if (n2 < 0 || n2 > 31) {
            throw new bo("Flag id must be between 0-31 (is:" + n2 + ")");
        }
    }

    public static int a(int n2, String string2) throws bo {
        if (string2.contains("-")) {
            String[] stringArray = com.corrodinggames.rts.gameFramework.GameUtils.c(string2, '-');
            if (stringArray.length != 2) {
                throw new bo("Unexpected flag id: " + string2);
            }
            int n3 = Integer.parseInt(stringArray[0]);
            int n4 = Integer.parseInt(stringArray[1]);
            com.corrodinggames.rts.game.units.custom.d.b.b(n3);
            com.corrodinggames.rts.game.units.custom.d.b.b(n4);
            if (n4 < n3) {
                throw new bo("end<start in flag id: " + string2);
            }
            for (int i2 = n3; i2 <= n4; ++i2) {
                n2 |= 1 << i2;
            }
            return n2;
        }
        int n5 = Integer.parseInt(string2);
        com.corrodinggames.rts.game.units.custom.d.b.b(n5);
        return n2 |= 1 << n5;
    }

    public static b a(l l2, String string2) throws bo {
        b b2 = com.corrodinggames.rts.game.units.custom.d.b.b(l2, string2);
        if (b2 != null && b2.f != 0) {
            throw new bo("Ammo not supported on streaming price:" + string2);
        }
        return b2;
    }

    public static b b(l l2, String string2) throws bo {
        if (string2 == null) {
            return a;
        }
        b b2 = new b();
        for (String string3 : string2.split(",|\\|")) {
            String string4;
            String string5;
            if ((string3 = string3.trim()).equals("")) continue;
            String[] stringArray = string3.split("=|:");
            if (stringArray.length == 1) {
                string5 = "credits";
                string4 = stringArray[0];
            } else if (stringArray.length == 2) {
                string5 = stringArray[0].trim();
                string4 = stringArray[1].trim();
            } else {
                throw new bo("Unknown price format:" + string2);
            }
            boolean bl2 = false;
            try {
                if (string5.equals("credits")) {
                    int n2;
                    bl2 = true;
                    b2.b = n2 = Integer.parseInt(string4);
                    continue;
                }
                if (string5.equals("energy")) {
                    float f2;
                    b2.c = f2 = Float.parseFloat(string4);
                    continue;
                }
                if (string5.equals("hp")) {
                    float f3;
                    b2.d = f3 = Float.parseFloat(string4);
                    continue;
                }
                if (string5.equals("shield")) {
                    float f4;
                    b2.e = f4 = Float.parseFloat(string4);
                    continue;
                }
                if (string5.equals("ammo")) {
                    int n3;
                    bl2 = true;
                    b2.f = n3 = Integer.parseInt(string4);
                    continue;
                }
                if (string5.equals("hasFlag")) {
                    bl2 = true;
                    b2.i = com.corrodinggames.rts.game.units.custom.d.b.a(b2.i, string4);
                    continue;
                }
                if (string5.equals("hasMissingFlag")) {
                    bl2 = true;
                    b2.j = com.corrodinggames.rts.game.units.custom.d.b.a(b2.j, string4);
                    continue;
                }
                if (string5.equals("setFlag")) {
                    bl2 = true;
                    b2.g = com.corrodinggames.rts.game.units.custom.d.b.a(b2.g, string4);
                    continue;
                }
                if (string5.equals("unsetFlag")) {
                    bl2 = true;
                    b2.h = com.corrodinggames.rts.game.units.custom.d.b.a(b2.h, string4);
                    continue;
                }
                com.corrodinggames.rts.game.units.custom.e.a_f3 a2 = l2.k(string5);
                if (a2 != null) {
                    float f5 = Float.parseFloat(string4);
                    if (b2.k == m) {
                        b2.k = new com.corrodinggames.rts.game.units.custom.e.f();
                    }
                    b2.k.a(a2, (double)f5);
                    continue;
                }
                throw new bo("Unknown price type:" + string5);
            }
            catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
                String string6 = "Bad price number:" + string4 + " in " + string2;
                if (bl2) {
                    string6 = string6 + " (Hint: A whole number was expected)";
                }
                throw new bo(string6);
            }
        }
        if (b2.k != m) {
            b2.k.a();
        }
        if (!b2.d()) {
            return a;
        }
        return b2;
    }

    public int a(BaseUnit am2, boolean bl2) {
        int n2;
        int n3 = 9999;
        if (!bl2 && this.b > 0) {
            n2 = (int)(am2.bX.o / (double)this.b);
            n3 = com.corrodinggames.rts.gameFramework.GameUtils.c(n3, n2);
        }
        if (this.c > 0.0f) {
            n2 = (int)(am2.cB / this.c);
            n3 = com.corrodinggames.rts.gameFramework.GameUtils.c(n3, n2);
        }
        if (this.d > 0.0f) {
            n2 = (int)(am2.cu / this.d);
            n3 = com.corrodinggames.rts.gameFramework.GameUtils.c(n3, n2);
        }
        if (this.e > 0.0f) {
            n2 = (int)(am2.cx / this.e);
            n3 = com.corrodinggames.rts.gameFramework.GameUtils.c(n3, n2);
        }
        if (this.f > 0) {
            n2 = am2.cE / this.f;
            n3 = com.corrodinggames.rts.gameFramework.GameUtils.c(n3, n2);
        }
        if (!this.k.c()) {
            n2 = com.corrodinggames.rts.game.units.custom.e.f.a(this.k, am2);
            n3 = com.corrodinggames.rts.gameFramework.GameUtils.c(n3, n2);
        }
        if (!this.f(am2)) {
            n3 = 0;
        }
        return n3;
    }

    @Override
    public boolean b(BaseUnit am2, double d2) {
        if (this.b > 0 && !am2.bX.a((double)this.b * d2)) {
            return false;
        }
        if (this.c > 0.0f && (double)am2.cB < (double)this.c * d2) {
            return false;
        }
        if (this.d > 0.0f && (double)am2.cu < (double)this.d * d2) {
            return false;
        }
        if (this.e > 0.0f && (double)am2.cx < (double)this.e * d2) {
            return false;
        }
        if (this.f > 0 && (double)am2.cE < (double)this.f * d2) {
            return false;
        }
        if (!this.f(am2)) {
            return false;
        }
        return this.k.c() || com.corrodinggames.rts.game.units.custom.e.f.a(this.k, am2, d2);
    }

    @Override
    public boolean b(BaseUnit am2) {
        if (this.b > 0 && !am2.bX.a((double)this.b)) {
            return false;
        }
        if (this.c > 0.0f && am2.cB < this.c) {
            return false;
        }
        if (this.d > 0.0f && am2.cu < this.d) {
            return false;
        }
        if (this.e > 0.0f && am2.cx < this.e) {
            return false;
        }
        if (this.f > 0 && am2.cE < this.f) {
            return false;
        }
        if (!this.f(am2)) {
            return false;
        }
        return this.k.c() || com.corrodinggames.rts.game.units.custom.e.f.b(this.k, am2);
    }

    public boolean a(BaseUnit am2, BaseUnit am3) {
        boolean bl2 = false;
        if (!this.k.c() && com.corrodinggames.rts.game.units.custom.e.f.a(this.k, am2, am3)) {
            bl2 = true;
        }
        return bl2;
    }

    public static void d(BaseUnit am2) {
        if (am2.cB < 0.0f) {
            am2.cB = 0.0f;
        }
        if (am2.cB > am2.bd()) {
            am2.cB = am2.bd();
        }
        if (am2.cx < 0.0f) {
            am2.cx = 0.0f;
        }
        if (am2.cx > am2.cA) {
            am2.cx = am2.cA;
        }
        if (am2.cu > am2.cv) {
            am2.cu = am2.cv;
        }
        if (am2.cE < 0) {
            am2.cE = 0;
        }
    }

    public void e(BaseUnit am2) {
        if (this.h != 0) {
            am2.cF &= ~this.h;
        }
        if (this.g != 0) {
            am2.cF |= this.g;
        }
    }

    public int c(int n2) {
        if (this.h != 0) {
            n2 &= ~this.h;
        }
        if (this.g != 0) {
            n2 |= this.g;
        }
        return n2;
    }

    public static boolean a(int n2, int n3) {
        int n4 = 1 << n3;
        return (n2 & n4) != 0;
    }

    public boolean f(BaseUnit am2) {
        if (this.i != 0 && !com.corrodinggames.rts.game.units.custom.d.b.b(am2.cF, this.i)) {
            return false;
        }
        return this.j == 0 || !com.corrodinggames.rts.game.units.custom.d.b.c(am2.cF, this.j);
    }

    public static boolean b(int n2, int n3) {
        return (n3 & n2) == n3;
    }

    public static boolean c(int n2, int n3) {
        return (n3 & n2) != 0;
    }

    @Override
    public void a(BaseUnit am2) {
        am2.bX.o -= (double)this.b;
        am2.cB -= this.c;
        am2.cu -= this.d;
        am2.cx -= this.e;
        am2.cE -= this.f;
        this.e(am2);
        if (!this.k.c()) {
            com.corrodinggames.rts.game.units.custom.e.f.c(this.k, am2);
        }
        com.corrodinggames.rts.game.units.custom.d.b.d(am2);
    }

    @Override
    public void a(BaseUnit am2, double d2) {
        am2.bX.o -= (double)this.b * d2;
        am2.cB = (float)((double)am2.cB - (double)this.c * d2);
        am2.cu = (float)((double)am2.cu - (double)this.d * d2);
        am2.cx = (float)((double)am2.cx - (double)this.e * d2);
        am2.cE = (int)((double)am2.cE - (double)this.f * d2);
        this.e(am2);
        if (!this.k.c()) {
            com.corrodinggames.rts.game.units.custom.e.f.b(this.k, am2, d2);
        }
        com.corrodinggames.rts.game.units.custom.d.b.d(am2);
    }

    public void g(BaseUnit am2) {
        if (this.b > 0) {
            am2.bX.b(this.b);
        } else {
            am2.bX.o += (double)this.b;
        }
        am2.cB += this.c;
        am2.cu += this.d;
        am2.cx += this.e;
        am2.cE += this.f;
        this.e(am2);
        if (!this.k.c()) {
            com.corrodinggames.rts.game.units.custom.e.f.d(this.k, am2);
        }
        com.corrodinggames.rts.game.units.custom.d.b.d(am2);
    }

    public void h(BaseUnit am2) {
        am2.bX.o += (double)this.b;
        am2.cB += this.c;
        am2.cu += this.d;
        am2.cx += this.e;
        am2.cE += this.f;
        this.e(am2);
        if (!this.k.c()) {
            com.corrodinggames.rts.game.units.custom.e.f.d(this.k, am2);
        }
        com.corrodinggames.rts.game.units.custom.d.b.d(am2);
    }

    public void a(BaseUnit am2, double d2, boolean bl2) {
        if (bl2) {
            am2.bX.o += (double)this.b * d2;
        }
        am2.cB = (float)((double)am2.cB + (double)this.c * d2);
        am2.cu = (float)((double)am2.cu + (double)this.d * d2);
        am2.cx = (float)((double)am2.cx + (double)this.e * d2);
        am2.cE = (int)((double)am2.cE + (double)this.f * d2);
        this.e(am2);
        if (!this.k.c()) {
            com.corrodinggames.rts.game.units.custom.e.f.c(this.k, am2, d2);
        }
        com.corrodinggames.rts.game.units.custom.d.b.d(am2);
    }

    public boolean c() {
        if (this == a) {
            return true;
        }
        if (this.b != 0 || this.c != 0.0f || this.d != 0.0f || this.e != 0.0f || this.f != 0) {
            return false;
        }
        return this.k.c();
    }

    public boolean d() {
        if (this == a) {
            return false;
        }
        if (this.b != 0 || this.c != 0.0f || this.d != 0.0f || this.e != 0.0f || this.f != 0) {
            return true;
        }
        if (this.g != 0 || this.h != 0 || this.i != 0 || this.j != 0) {
            return true;
        }
        return !this.k.c();
    }

    public boolean e() {
        if (this == a) {
            return false;
        }
        if (this.b != 0 || this.c != 0.0f || this.d != 0.0f || this.e != 0.0f || this.f != 0) {
            return true;
        }
        return this.g != 0 || this.h != 0;
    }

    public String a(boolean bl2, boolean bl3, int n2, boolean bl4) {
        ae ae2 = new ae();
        this.a(ae2, bl2, bl3, n2, bl4);
        return ae2.a();
    }

    public void a(ae ae2, boolean bl2, boolean bl3, int n2, boolean bl4, BaseUnit am2, int n3) {
        this.b(ae2, bl2, bl3, n2, bl4, am2, n3);
    }

    private void a(ae ae2, boolean bl2, boolean bl3, int n2, boolean bl4) {
        this.b(ae2, bl2, bl3, n2, bl4, null, 0);
    }

    private void b(ae ae2, boolean bl2, boolean bl3, int n2, boolean bl4, BaseUnit am2, int n3) {
        String string2 = bl2 ? "\n" : " | ";
        int n4 = 0;
        if (this.b > 0 && n4 < n2) {
            double d2;
            int n5 = l;
            if (am2 != null && (d2 = am2.bX.o) < (double)this.b) {
                n5 = n3;
            }
            ae2.a("$" + this.b + string2, n5);
            ++n4;
        }
        if (bl3) {
            if (this.c > 0.0f && n4 < n2) {
                ae2.b(com.corrodinggames.rts.gameFramework.GameUtils.g(this.c) + " energy" + string2);
                ++n4;
            }
            if (this.d > 0.0f && n4 < n2) {
                ae2.b(com.corrodinggames.rts.gameFramework.GameUtils.g(this.d) + " hp" + string2);
                ++n4;
            }
            if (this.e > 0.0f && n4 < n2) {
                ae2.b(com.corrodinggames.rts.gameFramework.GameUtils.g(this.e) + " shield" + string2);
                ++n4;
            }
            if (this.f > 0 && n4 < n2) {
                ae2.b(com.corrodinggames.rts.gameFramework.GameUtils.g((float)this.f) + " ammo" + string2);
                ++n4;
            }
        }
        if (!this.k.c()) {
            this.k.a(ae2, bl2, bl3, n2 - n4, bl4, false, am2, n3);
        }
        ae2.a(string2);
    }

    public b i(BaseUnit am2) {
        b b2 = new b();
        if (this.b > 0 && am2.bX.o < (double)this.b) {
            b2.b = this.b - (int)am2.bX.o;
        }
        if (!this.k.c()) {
            b2.k = this.k.a(am2);
        }
        return b2;
    }

    public String a(BaseUnit am2, int n2, boolean bl2) {
        String string2;
        String string3 = null;
        String string4 = ", ";
        int n3 = 0;
        if (this.b > 0 && n3 < n2 && am2.bX.o < (double)this.b) {
            if (string3 == null) {
                string3 = "";
            }
            string3 = string3 + "credits" + string4;
            ++n3;
        }
        if (!this.k.c() && (string2 = this.k.a(am2, string4, n2, bl2)) != null) {
            if (string3 == null) {
                string3 = "";
            }
            string3 = string3 + string2;
        }
        if (string3 == null) {
            return null;
        }
        string3 = com.corrodinggames.rts.gameFramework.GameUtils.a(string3, string4);
        return string3;
    }

    public int a(b b2) {
        return this.b - b2.b;
    }

    public static void a(GameOutputStream as2, b b2) throws IOException {
        as2.a(b2 != null);
        if (b2 != null) {
            b2.a(as2);
        }
    }

    public void a(GameOutputStream as2) throws IOException {
        boolean bl2 = false;
        boolean bl3 = false;
        if (this.c != 0.0f || this.d != 0.0f || this.e != 0.0f || this.f != 0) {
            bl2 = true;
        }
        if (this.g != 0 || this.h != 0 || this.i != 0 || this.j != 0) {
            bl2 = true;
        }
        if (!this.k.c()) {
            bl3 = true;
        }
        byte by = 0;
        if (bl2) {
            by = (byte)(by | 1);
        }
        if (bl3) {
            by = (byte)(by | 2);
        }
        as2.c(by);
        as2.a(this.b);
        if (bl2) {
            as2.a(this.c);
            as2.a(this.d);
            as2.a(this.e);
            as2.a(this.f);
            as2.a(this.g);
            as2.a(this.h);
            as2.a(this.i);
            as2.a(this.j);
        }
        if (bl3) {
            this.k.a(as2);
        }
    }

    public static b a(GameInputStream k2) throws IOException {
        boolean bl2 = k2.e();
        if (bl2) {
            return com.corrodinggames.rts.game.units.custom.d.b.b(k2);
        }
        return null;
    }

    public static b b(GameInputStream k2) throws IOException {
        b b2 = new b();
        byte by = k2.d();
        boolean bl2 = com.corrodinggames.rts.game.units.custom.d.b.b(by, 1);
        boolean bl3 = com.corrodinggames.rts.game.units.custom.d.b.b(by, 2);
        b2.b = k2.readInt();
        if (bl2) {
            b2.c = k2.g();
            b2.d = k2.g();
            b2.e = k2.g();
            b2.f = k2.readInt();
            b2.g = k2.readInt();
            b2.h = k2.readInt();
            b2.i = k2.readInt();
            b2.j = k2.readInt();
        }
        if (bl3) {
            b2.k = new com.corrodinggames.rts.game.units.custom.e.f();
            b2.k.a(k2);
        }
        return b2;
    }

    public boolean b(BaseUnit am2, boolean bl2) {
        if (this.c(am2, bl2)) {
            this.d(am2, bl2);
            return true;
        }
        return false;
    }

    public boolean c(BaseUnit am2, boolean bl2) {
        if (this.b > 0 && !am2.bX.g(this.b)) {
            return false;
        }
        if (bl2) {
            return an.c(am2, this);
        }
        return this.b(am2);
    }

    public void d(BaseUnit am2, boolean bl2) {
        am2.bX.p -= (double)this.b;
        am2.bX.q = 0;
        if (bl2) {
            an.a(am2, this);
        }
    }

    public void e(BaseUnit am2, boolean bl2) {
        am2.bX.p += (double)this.b;
        am2.bX.q = 0;
        if (bl2) {
            an.b(am2, this);
        }
    }

    public static boolean b(b b2, b b3) {
        if (b3 == b2) {
            return true;
        }
        if (b3 == null || b2 == null) {
            return false;
        }
        return b3.b(b2);
    }

    public boolean b(b b2) {
        if (this.b != b2.b) {
            return false;
        }
        if (this.d != b2.d) {
            return false;
        }
        if (this.e != b2.e) {
            return false;
        }
        if (this.f != b2.f) {
            return false;
        }
        if (this.k.c() != b2.k.c()) {
            return false;
        }
        return this.k.c() || b2.k.c() || this.k.e(b2.k);
    }

    public boolean c(b b2) {
        if (this.b > 0 && b2.b > 0) {
            return true;
        }
        if (this.d > 0.0f && b2.d > 0.0f) {
            return true;
        }
        if (this.e > 0.0f && b2.e > 0.0f) {
            return true;
        }
        if (this.f > 0 && b2.f > 0) {
            return true;
        }
        return !this.k.c() && !b2.k.c() && this.k.f(b2.k);
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((b)object);
    }
}

