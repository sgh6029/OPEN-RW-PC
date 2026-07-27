/*
 * Decompiled with CFR 0.152.
 */
package android.graphics;

public final class Rect {
    public int left;
    public int top;
    public int c;
    public int d;

    public Rect() {
    }

    public Rect(int n2, int n3, int n4, int n5) {
        this.left = n2;
        this.top = n3;
        this.c = n4;
        this.d = n5;
    }

    public Rect(Rect rect) {
        this.left = rect.left;
        this.top = rect.top;
        this.c = rect.c;
        this.d = rect.d;
    }

    public boolean equals(Object object) {
        Rect rect = (Rect)object;
        if (rect != null) {
            return this.left == rect.left && this.top == rect.top && this.c == rect.c && this.d == rect.d;
        }
        return false;
    }

    public String toString() {
        return "Rect(" + this.left + ", " + this.top + ", " + this.c + ", " + this.d + ")";
    }

    public final boolean a() {
        return this.left >= this.c || this.top >= this.d;
    }

    public final int b() {
        return this.c - this.left;
    }

    public final int c() {
        return this.d - this.top;
    }

    public final int d() {
        return this.left + this.c >> 1;
    }

    public final int e() {
        return this.top + this.d >> 1;
    }

    public final float f() {
        return (float)(this.left + this.c) * 0.5f;
    }

    public final float g() {
        return (float)(this.top + this.d) * 0.5f;
    }

    public void h() {
        this.d = 0;
        this.top = 0;
        this.c = 0;
        this.left = 0;
    }

    public void a(int n2, int n3, int n4, int n5) {
        this.left = n2;
        this.top = n3;
        this.c = n4;
        this.d = n5;
    }

    public void a(Rect rect) {
        this.left = rect.left;
        this.top = rect.top;
        this.c = rect.c;
        this.d = rect.d;
    }

    public void a(int n2, int n3) {
        this.left += n2;
        this.top += n3;
        this.c += n2;
        this.d += n3;
    }

    public boolean b(int n2, int n3) {
        return this.left < this.c && this.top < this.d && n2 >= this.left && n2 < this.c && n3 >= this.top && n3 < this.d;
    }

    public boolean b(Rect rect) {
        return this.left < this.c && this.top < this.d && this.left <= rect.left && this.top <= rect.top && this.c >= rect.c && this.d >= rect.d;
    }

    public boolean b(int n2, int n3, int n4, int n5) {
        return this.left < n4 && n2 < this.c && this.top < n5 && n3 < this.d;
    }
}

