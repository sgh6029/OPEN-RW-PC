/*
 * Decompiled with CFR 0.152.
 */
package org.a.a.d;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.a.a.d.c;

public interface b
extends org.a.a.a.b,
c {
    @Override
    public org.a.a.c.b a();

    public org.a.a.e.b b();

    public org.a.a.e.b a(int var1);

    public b a(int var1, int var2);

    @Deprecated
    public Integer b(int var1);

    @Override
    default public /* synthetic */ Iterator iterator() {
        return this.a();
    }

    default public /* synthetic */ List subList(int n2, int n3) {
        return this.a(n2, n3);
    }

    default public /* synthetic */ ListIterator listIterator(int n2) {
        return this.a(n2);
    }

    default public /* synthetic */ ListIterator listIterator() {
        return this.b();
    }

    @Deprecated
    default public /* synthetic */ Object remove(int n2) {
        return this.b(n2);
    }
}

