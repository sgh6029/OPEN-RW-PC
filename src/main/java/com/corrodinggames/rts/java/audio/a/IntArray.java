/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.audio.a;

public class IntArray {
    public int[] a;
    public int b;
    public boolean c;

    public IntArray() {
        this(true, 16);
    }

    public IntArray(boolean bl2, int n2) {
        this.c = bl2;
        this.a = new int[n2];
    }

    public IntArray(IntArray d2) {
        this.c = d2.c;
        this.b = d2.b;
        this.a = new int[this.b];
        System.arraycopy(d2.a, 0, this.a, 0, this.b);
    }

    public void a(int n2) {
        int[] nArray = this.a;
        if (this.b == nArray.length) {
            nArray = this.d(Math.max(8, (int)((float)this.b * 1.75f)));
        }
        nArray[this.b++] = n2;
    }

    public int b(int n2) {
        if (n2 >= this.b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.b);
        }
        return this.a[n2];
    }

    public int c(int n2) {
        if (n2 >= this.b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.b);
        }
        int[] nArray = this.a;
        int n3 = nArray[n2];
        --this.b;
        if (this.c) {
            System.arraycopy(nArray, n2 + 1, nArray, n2, this.b - n2);
        } else {
            nArray[n2] = nArray[this.b];
        }
        return n3;
    }

    protected int[] d(int n2) {
        int[] nArray = new int[n2];
        int[] nArray2 = this.a;
        System.arraycopy(nArray2, 0, nArray, 0, Math.min(this.b, nArray.length));
        this.a = nArray;
        return nArray;
    }

    public int hashCode() {
        if (!this.c) {
            return super.hashCode();
        }
        int[] nArray = this.a;
        int n2 = 1;
        int n3 = this.b;
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = n2 * 31 + nArray[i2];
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!this.c) {
            return false;
        }
        if (!(object instanceof IntArray)) {
            return false;
        }
        IntArray d2 = (IntArray)object;
        if (!d2.c) {
            return false;
        }
        int n2 = this.b;
        if (n2 != d2.b) {
            return false;
        }
        int[] nArray = this.a;
        int[] nArray2 = d2.a;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.a[i2] == d2.a[i2]) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        if (this.b == 0) {
            return "[]";
        }
        int[] nArray = this.a;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(nArray[0]);
        for (int i2 = 1; i2 < this.b; ++i2) {
            stringBuilder.append(", ");
            stringBuilder.append(nArray[i2]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

