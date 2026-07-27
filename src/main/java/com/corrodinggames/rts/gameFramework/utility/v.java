/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.utility.UnitList;
import com.corrodinggames.rts.gameFramework.utility.UnitList$1;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class v
implements Iterator {
    private int b;
    private int c;
    private int d;
    final /* synthetic */ UnitList a;

    private v(UnitList u2) {
        this.a = u2;
        this.b = this.a.b;
        this.c = -1;
        this.d = UnitList.a(this.a);
    }

    @Override
    public boolean hasNext() {
        return this.b != 0;
    }

    public BaseUnit a() {
        UnitList u2 = this.a;
        int n2 = this.b;
        if (UnitList.b(u2) != this.d) {
            throw new ConcurrentModificationException();
        }
        if (n2 == 0) {
            throw new NoSuchElementException();
        }
        this.b = n2 - 1;
        this.c = u2.b - n2;
        return u2.c[this.c];
    }

    @Override
    public void remove() {
        BaseUnit[] amArray = this.a.c;
        int n2 = this.c;
        if (UnitList.c(this.a) != this.d) {
            throw new ConcurrentModificationException();
        }
        if (n2 < 0) {
            throw new IllegalStateException();
        }
        System.arraycopy(amArray, n2 + 1, amArray, n2, this.b);
        amArray[--this.a.b] = null;
        this.c = -1;
        this.d = UnitList.d(this.a);
    }

    public /* synthetic */ Object next() {
        return this.a();
    }

    /* synthetic */ v(UnitList u2, UnitList$1 u$1) {
        this(u2);
    }
}

