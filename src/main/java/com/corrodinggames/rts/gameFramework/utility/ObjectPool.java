/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

public class ObjectPool {
    private final Object[] a;
    private int b;
    private final boolean c = false;

    public ObjectPool(int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[n2];
    }

    public Object a() {
        if (this.b > 0) {
            int n2 = this.b - 1;
            Object object = this.a[n2];
            this.a[n2] = null;
            --this.b;
            return object;
        }
        return null;
    }

    public boolean a(Object object) {
        if (this.b < this.a.length) {
            this.a[this.b] = object;
            ++this.b;
            return true;
        }
        return false;
    }
}

