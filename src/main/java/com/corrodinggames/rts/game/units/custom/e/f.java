/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.e;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.e.a_f3;
import com.corrodinggames.rts.game.units.custom.e.e;
import com.corrodinggames.rts.game.units.custom.e.f$1;
import com.corrodinggames.rts.gameFramework.f.ae;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.utility.m;

import java.io.IOException;
import java.util.Collections;

public final class f {
    public static final f a = new f().a();
    public final m b = new m();
    boolean c;

    public f a() {
        this.c = true;
        return this;
    }

    public void b() {
        this.b.clear();
    }

    public boolean c() {
        if (this.b.a == 0) {
            return true;
        }
        int n2 = this.b.a;
        Object[] objectArray = this.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            if (e2.b == 0.0) continue;
            return false;
        }
        return true;
    }

    public double a(a_f3 a2) {
        int n2 = this.b.a;
        Object[] objectArray = this.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            if (e2.a != a2) continue;
            return e2.b;
        }
        return 0.0;
    }

    public double b(a_f3 a2) {
        int n2 = this.b.a;
        Object[] objectArray = this.b.a();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            if (e2.a == a2) {
                n3 = (int)((double)n3 + e2.b);
            }
            if (e2.a.v != a2) continue;
            n3 = (int)((double)n3 + e2.b);
        }
        return n3;
    }

    public void a(com.corrodinggames.rts.game.units.custom.e.f f2) {
        this.b();
        this.b(f2);
    }

    public void a(a_f3 a2, double d2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        }
        int n2 = this.b.a;
        Object[] objectArray = this.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            if (e2.a != a2) continue;
            e2.b = d2;
            return;
        }
        e e3 = new e(a2);
        e3.b = d2;
        this.b.add(e3);
    }

    public void a(double d2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        }
        int n2 = this.b.a;
        Object[] objectArray = this.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            e2.b *= d2;
        }
    }

    public void b(a_f3 a2, double d2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        }
        if (d2 == 0.0) {
            return;
        }
        m m2 = this.b;
        int n2 = m2.a;
        Object[] objectArray = m2.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            if (e2.a != a2) continue;
            e2.b += d2;
            return;
        }
        e e3 = new e(a2);
        e3.b = d2;
        m2.add(e3);
    }

    public void c(a_f3 a2, double d2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        }
        if (d2 == 0.0) {
            return;
        }
        m m2 = this.b;
        int n2 = m2.a;
        Object[] objectArray = m2.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            if (e2.a != a2) continue;
            e2.b += d2;
            return;
        }
        e e3 = new e(a2);
        e3.b = d2;
        m2.add(e3);
    }

    public void d(a_f3 a2, double d2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        }
        this.b(a2, -d2);
    }

    public void a(b b2, double d2, double d3) {
        if ((double)b2.b >= d2 && (double)b2.b <= d3) {
            this.c(com.corrodinggames.rts.game.units.custom.e.a_f3.D, b2.b);
        }
        this.a(b2.k, d2, d3);
    }

    public void b(b b2, double d2, double d3) {
        if ((double)b2.b >= d2 && (double)b2.b <= d3) {
            this.c(com.corrodinggames.rts.game.units.custom.e.a_f3.D, -b2.b);
        }
        this.b(b2.k, d2, d3);
    }

    public void a(b b2) {
        this.c(com.corrodinggames.rts.game.units.custom.e.a_f3.D, b2.b);
        this.b(b2.k);
    }

    public void b(f f2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        }
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            this.b(e2.a, e2.b);
        }
    }

    public void a(f f2, double d2, double d3) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        }
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            if (!(e2.b >= d2) || !(e2.b <= d3)) continue;
            this.b(e2.a, e2.b);
        }
    }

    public void a(f f2, double d2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        }
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            this.b(e2.a, e2.b * d2);
        }
    }

    public void c(f f2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        }
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            this.d(e2.a, e2.b);
        }
    }

    public void b(f f2, double d2, double d3) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        }
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            if (!(e2.b >= d2) || !(e2.b <= d3)) continue;
            this.d(e2.a, e2.b);
        }
    }

    public static f a(f f2, f f3) {
        f f4 = new f();
        f4.b(f2);
        f4.b(f3);
        return f4;
    }

    public static f b(f f2, f f3) {
        f f4 = new f();
        f4.b(f2);
        f4.c(f3);
        return f4;
    }

    public static f b(f f2, double d2) {
        f f3 = new f();
        f3.a(f2, d2);
        return f3;
    }

    public static f d(f f2) {
        f f3 = new f();
        f3.b(f2);
        return f3;
    }

    public static int a(f f2, BaseUnit am2) {
        int n2 = 9999;
        int n3 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n3; ++i2) {
            e e2 = (e)objectArray[i2];
            if (!(e2.b > 0.0)) continue;
            double d2 = e2.a.t ? am2.bX.c(e2.a) : am2.a(e2.a);
            int n4 = (int)(d2 / e2.b);
            n2 = com.corrodinggames.rts.gameFramework.GameUtils.c(n2, n4);
        }
        return n2;
    }

    public static boolean b(f f2, BaseUnit am2) {
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            double d2 = e2.a.t ? am2.bX.c(e2.a) : am2.a(e2.a);
            if (!(e2.b > d2)) continue;
            return false;
        }
        return true;
    }

    public static boolean a(f f2, BaseUnit am2, double d2) {
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            double d3 = e2.a.t ? am2.bX.c(e2.a) : am2.a(e2.a);
            if (!(e2.b * d2 > d3)) continue;
            return false;
        }
        return true;
    }

    public static void c(f f2, BaseUnit am2) {
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f3;
            e e2 = (e)objectArray[i2];
            if (e2.a.t) {
                f3 = am2.bX.V();
                f3.d(e2.a, e2.b);
                continue;
            }
            f3 = am2.df();
            f3.d(e2.a, e2.b);
        }
    }

    public static void b(f f2, BaseUnit am2, double d2) {
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f3;
            e e2 = (e)objectArray[i2];
            if (e2.a.t) {
                f3 = am2.bX.V();
                f3.d(e2.a, e2.b * d2);
                continue;
            }
            f3 = am2.df();
            f3.d(e2.a, e2.b * d2);
        }
    }

    public static void d(f f2, BaseUnit am2) {
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f3;
            e e2 = (e)objectArray[i2];
            if (e2.a.t) {
                f3 = am2.bX.V();
                f3.b(e2.a, e2.b);
                continue;
            }
            f3 = am2.df();
            f3.b(e2.a, e2.b);
        }
    }

    public static void c(f f2, BaseUnit am2, double d2) {
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f3;
            e e2 = (e)objectArray[i2];
            if (e2.a.t) {
                f3 = am2.bX.V();
                f3.b(e2.a, e2.b * d2);
                continue;
            }
            f3 = am2.df();
            f3.b(e2.a, e2.b * d2);
        }
    }

    public static boolean a(f f2, BaseUnit am2, BaseUnit am3) {
        boolean bl2 = false;
        int n2 = f2.b.a;
        Object[] objectArray = f2.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2;
            e e2 = (e)objectArray[i2];
            a_f3 a2 = e2.a;
            double d3 = e2.b;
            if (d3 == 0.0) continue;
            double d4 = a2.a(am2);
            double d5 = a2.a(am3);
            if (d3 >= 0.0) {
                if (d4 <= 0.0) continue;
                d2 = com.corrodinggames.rts.gameFramework.GameUtils.a(d4, d3);
                a2.b(am2, -d2);
                a2.b(am3, d2);
                bl2 = true;
                continue;
            }
            if (d5 <= 0.0) continue;
            d3 = -d3;
            d2 = com.corrodinggames.rts.gameFramework.GameUtils.a(d5, d3);
            a2.b(am3, -d2);
            a2.b(am2, d2);
            bl2 = true;
        }
        return bl2;
    }

    public String a(boolean bl2, boolean bl3, int n2, boolean bl4, boolean bl5) {
        ae ae2 = new ae();
        this.a(ae2, bl2, bl3, n2, bl4, bl5, null, 0);
        return ae2.a();
    }

    public void a(ae ae2, boolean bl2, boolean bl3, int n2, boolean bl4, boolean bl5, BaseUnit am2, int n3) {
        int n4 = this.b.a;
        if (n4 == 0) {
            return;
        }
        String string2 = bl2 ? "\n" : " | ";
        int n5 = 0;
        Object[] objectArray = this.b.a();
        for (int i2 = 0; i2 < n4; ++i2) {
            double d2;
            e e2 = (e)objectArray[i2];
            if (!(e2.b > 0.0) && !bl5 || n5 >= n2) continue;
            a_f3 a2 = e2.a;
            if (!bl4 && a2.a()) continue;
            boolean bl6 = false;
            if (a2.y != null && a2.z) {
                bl6 = true;
                int n6 = 0;
                try {
                    n6 = ae2.c() - 2;
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                if (n6 < 2) {
                    n6 = 2;
                }
                ae2.a(a2.y, n6 * 3, n6);
            }
            String string3 = a2.a(e2.b, false, bl6) + string2;
            boolean bl7 = false;
            int n7 = 0;
            if (a2.m != null && a2.n) {
                bl7 = true;
                n7 = a2.m;
            }
            if (am2 != null && (d2 = a2.a(am2)) < e2.b) {
                bl7 = true;
                n7 = n3;
            }
            if (bl7) {
                ae2.a(string3, n7);
            } else {
                ae2.b(string3);
            }
            ++n5;
        }
    }

    public void a(GameOutputStream as2) throws IOException {
        if (this.b.a == 0) {
            as2.c(-1);
            return;
        }
        as2.c(0);
        as2.a((short)this.b.a);
        int n2 = this.b.a;
        Object[] objectArray = this.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            as2.writeUTF(e2.a.b);
            as2.a(e2.b);
        }
    }

    public void a(GameInputStream k2) throws IOException {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        }
        byte by = k2.d();
        if (by == -1) {
            return;
        }
        int n2 = k2.v();
        this.b.clear();
        for (int i2 = 0; i2 < n2; ++i2) {
            a_f3 a2 = com.corrodinggames.rts.game.units.custom.e.a_f3.b(k2.l());
            double d2 = k2.h();
            if (a2 == null || d2 == 0.0) continue;
            e e2 = new e(a2, d2);
            this.b.add(e2);
        }
    }

    public int d() {
        int n2 = 0;
        int n3 = this.b.a;
        Object[] objectArray = this.b.a();
        for (int i2 = 0; i2 < n3; ++i2) {
            e e2 = (e)objectArray[i2];
            if (e2.b == 0.0) continue;
            ++n2;
        }
        return n2;
    }

    public boolean e(f f2) {
        if (this.d() != f2.d()) {
            return false;
        }
        int n2 = this.b.a;
        Object[] objectArray = this.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            double d2 = f2.a(e2.a);
            if (com.corrodinggames.rts.gameFramework.GameUtils.b(e2.b, d2)) continue;
            return false;
        }
        return true;
    }

    public boolean f(f f2) {
        int n2 = this.b.a;
        Object[] objectArray = this.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2;
            e e2 = (e)objectArray[i2];
            if (!(e2.b > 0.0) || !((d2 = f2.b(e2.a)) > 0.0)) continue;
            return true;
        }
        return false;
    }

    public f a(BaseUnit am2) {
        f f2 = new f();
        int n2 = this.b.a;
        Object[] objectArray = this.b.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            double d2 = e2.a.t ? am2.bX.c(e2.a) : am2.a(e2.a);
            if (!(d2 < e2.b)) continue;
            double d3 = e2.b - d2;
            f2.b(e2.a, d3);
        }
        if (f2.c()) {
            return a;
        }
        return f2;
    }

    public String a(BaseUnit am2, String string2, int n2, boolean bl2) {
        String string3 = null;
        int n3 = 0;
        int n4 = this.b.a;
        Object[] objectArray = this.b.a();
        for (int i2 = 0; i2 < n4; ++i2) {
            double d2;
            e e2 = (e)objectArray[i2];
            if (!bl2 && e2.a.a() || !((d2 = e2.a.t ? am2.bX.c(e2.a) : am2.a(e2.a)) < e2.b)) continue;
            double d3 = e2.b - d2;
            String string4 = e2.a.i();
            string3 = string3 == null ? string4 : string3 + string2 + string4;
            if (++n3 > n2) break;
        }
        return string3;
    }

    public void g(f f2) {
        this.b();
        this.b(f2);
    }

    public void c(a_f3 a2) {
        m m2 = this.b;
        int n2 = m2.a;
        Object[] objectArray = m2.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)objectArray[i2];
            if (e2.a != a2) continue;
            return;
        }
        e e3 = new e(a2);
        e3.b = 0.0;
        m2.add(e3);
    }

    public void e() {
        Collections.sort(this.b, new f$1(this));
    }
}

