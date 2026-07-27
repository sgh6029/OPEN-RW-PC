/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.utility.o;
import com.corrodinggames.rts.gameFramework.utility.o$1;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class p
implements Iterator {
    private int b;
    private int c;
    private int d;
    final /* synthetic */ o a;

    private p(o o2) {
        this.a = o2;
        this.b = this.a.c;
        this.c = -1;
        this.d = o.a(this.a);
    }

    @Override
    public boolean hasNext() {
        return this.b != 0;
    }

    public Object next() {
        o o2 = this.a;
        int n2 = this.b;
        if (o.b(o2) != this.d) {
            throw new ConcurrentModificationException();
        }
        if (n2 == 0) {
            throw new NoSuchElementException();
        }
        this.b = n2 - 1;
        this.c = o2.c - n2;
        return o2.d[this.c];
    }

    @Override
    public void remove() {
        Object[] objectArray = this.a.d;
        int n2 = this.c;
        if (o.c(this.a) != this.d) {
            throw new ConcurrentModificationException();
        }
        if (n2 < 0) {
            throw new IllegalStateException();
        }
        System.arraycopy(objectArray, n2 + 1, objectArray, n2, this.b);
        objectArray[--this.a.c] = null;
        this.c = -1;
        this.d = o.d(this.a);
    }

    /* synthetic */ p(o o2, o$1 o$1) {
        this(o2);
    }
}

