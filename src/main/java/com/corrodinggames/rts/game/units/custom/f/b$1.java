/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.f;

final class b$1 {
    int a = -1;
    int b;
    final /* synthetic */ String c;

    b$1(String string2) {
        this.c = string2;
    }

    void a() {
        this.b = ++this.a < this.c.length() ? (int)this.c.charAt(this.a) : -1;
    }

    boolean a(int n2) {
        while (this.b == 32) {
            this.a();
        }
        if (this.b == n2) {
            this.a();
            return true;
        }
        return false;
    }

    double b() {
        this.a();
        double d2 = this.c();
        if (this.a < this.c.length()) {
            throw new RuntimeException("Unexpected: " + (char)this.b);
        }
        return d2;
    }

    double c() {
        double d2 = this.d();
        while (true) {
            if (this.a(43)) {
                d2 += this.d();
                continue;
            }
            if (!this.a(45)) break;
            d2 -= this.d();
        }
        return d2;
    }

    double d() {
        double d2 = this.e();
        while (true) {
            if (this.a(42)) {
                d2 *= this.e();
                continue;
            }
            if (this.a(47)) {
                d2 /= this.e();
                continue;
            }
            if (!this.a(37)) break;
            d2 %= this.e();
        }
        return d2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    double e() {
        double d2;
        if (this.a(43)) {
            return this.e();
        }
        if (this.a(45)) {
            return -this.e();
        }
        int n2 = this.a;
        if (this.a(40)) {
            d2 = this.c();
            this.a(41);
        } else if (this.b >= 48 && this.b <= 57 || this.b == 46) {
            while (this.b >= 48 && this.b <= 57 || this.b == 46) {
                this.a();
            }
            d2 = Double.parseDouble(this.c.substring(n2, this.a));
        } else {
            if (this.b < 97) throw new RuntimeException("Unexpected: " + (char)this.b);
            if (this.b > 122) throw new RuntimeException("Unexpected: " + (char)this.b);
            while (this.b >= 97 && this.b <= 122) {
                this.a();
            }
            String string2 = this.c.substring(n2, this.a);
            d2 = this.e();
            if (string2.equals("sqrt")) {
                d2 = Math.sqrt(d2);
            } else if (string2.equals("sin")) {
                d2 = Math.sin(Math.toRadians(d2));
            } else if (string2.equals("cos")) {
                d2 = Math.cos(Math.toRadians(d2));
            } else if (string2.equals("tan")) {
                d2 = Math.tan(Math.toRadians(d2));
            } else {
                if (!string2.equals("int")) throw new RuntimeException("Unknown function: " + string2);
                d2 = (int)d2;
            }
        }
        if (!this.a(94)) return d2;
        return Math.pow(d2, this.e());
    }
}

