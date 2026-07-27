/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.utility.t;
import com.corrodinggames.rts.gameFramework.GGameObject;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class s
extends AbstractList
implements Serializable,
Cloneable,
RandomAccess {
    public static final GGameObject[] a = new GGameObject[0];
    int b;
    transient GGameObject[] c = a;
    String d;

    public s(String string2) {
        this.d = string2;
    }

    public GGameObject[] a() {
        return this.c;
    }

    public boolean a(GGameObject w2) {
        int n2 = this.b;
        GGameObject[] wArray = this.c;
        if (n2 == wArray.length) {
            GGameObject[] wArray2 = new GGameObject[n2 + (n2 < 6 ? 12 : n2 >> 1)];
            System.arraycopy(wArray, 0, wArray2, 0, n2);
            wArray = wArray2;
            this.c = wArray2;
        }
        wArray[n2] = w2;
        this.b = n2 + 1;
        ++this.modCount;
        return true;
    }

    public void a(int n2, GGameObject w2) {
        GGameObject[] wArray = this.c;
        int n3 = this.b;
        if (n2 > n3 || n2 < 0) {
            s.a(n2, n3);
        }
        if (n3 < wArray.length) {
            System.arraycopy(wArray, n2, wArray, n2 + 1, n3 - n2);
        } else {
            GGameObject[] wArray2 = new GGameObject[s.c(n3)];
            System.arraycopy(wArray, 0, wArray2, 0, n2);
            System.arraycopy(wArray, n2, wArray2, n2 + 1, n3 - n2);
            wArray = wArray2;
            this.c = wArray2;
        }
        wArray[n2] = w2;
        this.b = n3 + 1;
        ++this.modCount;
    }

    private static int c(int n2) {
        int n3 = n2 < 6 ? 12 : n2 >> 1;
        return n2 + n3;
    }

    @Override
    public boolean addAll(Collection collection) {
        GGameObject[] wArray = (GGameObject[])collection.toArray();
        int n2 = wArray.length;
        if (n2 == 0) {
            return false;
        }
        int n3 = this.b;
        int n4 = n3 + n2;
        GGameObject[] wArray2 = this.c;
        if (n4 > wArray2.length) {
            int n5 = s.c(n4 - 1);
            GGameObject[] wArray3 = new GGameObject[n5];
            System.arraycopy(wArray2, 0, wArray3, 0, n3);
            wArray2 = wArray3;
            this.c = wArray3;
        }
        System.arraycopy(wArray, 0, wArray2, n3, n2);
        this.b = n4;
        ++this.modCount;
        return true;
    }

    @Override
    public boolean addAll(int n2, Collection collection) {
        GGameObject[] wArray;
        int n3;
        int n4 = this.b;
        if (n2 > n4 || n2 < 0) {
            s.a(n2, n4);
        }
        if ((n3 = (wArray = (GGameObject[])collection.toArray()).length) == 0) {
            return false;
        }
        int n5 = n4 + n3;
        GGameObject[] wArray2 = this.c;
        if (n5 <= wArray2.length) {
            System.arraycopy(wArray2, n2, wArray2, n2 + n3, n4 - n2);
        } else {
            int n6 = s.c(n5 - 1);
            GGameObject[] wArray3 = new GGameObject[n6];
            System.arraycopy(wArray2, 0, wArray3, 0, n2);
            System.arraycopy(wArray2, n2, wArray3, n2 + n3, n4 - n2);
            wArray2 = wArray3;
            this.c = wArray3;
        }
        System.arraycopy(wArray, 0, wArray2, n2, n3);
        this.b = n5;
        ++this.modCount;
        return true;
    }

    static IndexOutOfBoundsException a(int n2, int n3) {
        throw new IndexOutOfBoundsException("Invalid index " + n2 + ", size is " + n3);
    }

    @Override
    public void clear() {
        if (this.b != 0) {
            Arrays.fill(this.c, 0, this.b, null);
            this.b = 0;
            ++this.modCount;
        }
    }

    public void b() {
        if (this.b != 0) {
            this.b = 0;
            ++this.modCount;
        }
    }

    public Object clone() {
        try {
            s s2 = (s)super.clone();
            s2.c = (GGameObject[])this.c.clone();
            return s2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError();
        }
    }

    public GGameObject a(int n2) {
        if (n2 >= this.b) {
            s.a(n2, this.b);
        }
        return this.c[n2];
    }

    @Override
    public int size() {
        return this.b;
    }

    @Override
    public boolean isEmpty() {
        return this.b == 0;
    }

    @Override
    public boolean contains(Object object) {
        GGameObject[] wArray = this.c;
        int n2 = this.b;
        if (object != null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!object.equals(wArray[i2])) continue;
                return true;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                if (wArray[i3] != null) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object object) {
        GGameObject[] wArray = this.c;
        int n2 = this.b;
        if (object != null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!object.equals(wArray[i2])) continue;
                return i2;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                if (wArray[i3] != null) continue;
                return i3;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        GGameObject[] wArray = this.c;
        if (object != null) {
            for (int i2 = this.b - 1; i2 >= 0; --i2) {
                if (!object.equals(wArray[i2])) continue;
                return i2;
            }
        } else {
            for (int i3 = this.b - 1; i3 >= 0; --i3) {
                if (wArray[i3] != null) continue;
                return i3;
            }
        }
        return -1;
    }

    public GGameObject b(int n2) {
        GGameObject[] wArray = this.c;
        int n3 = this.b;
        if (n2 >= n3) {
            s.a(n2, n3);
        }
        GGameObject w2 = wArray[n2];
        System.arraycopy(wArray, n2 + 1, wArray, n2, --n3 - n2);
        wArray[n3] = null;
        this.b = n3;
        ++this.modCount;
        return w2;
    }

    @Override
    public boolean remove(Object object) {
        GGameObject[] wArray = this.c;
        int n2 = this.b;
        if (object != null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!object.equals(wArray[i2])) continue;
                System.arraycopy(wArray, i2 + 1, wArray, i2, --n2 - i2);
                wArray[n2] = null;
                this.b = n2;
                ++this.modCount;
                return true;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                if (wArray[i3] != null) continue;
                System.arraycopy(wArray, i3 + 1, wArray, i3, --n2 - i3);
                wArray[n2] = null;
                this.b = n2;
                ++this.modCount;
                return true;
            }
        }
        return false;
    }

    @Override
    protected void removeRange(int n2, int n3) {
        if (n2 == n3) {
            return;
        }
        Object[] objectArray = this.c;
        int n4 = this.b;
        if (n2 >= n4) {
            throw new IndexOutOfBoundsException("fromIndex " + n2 + " >= size " + this.b);
        }
        if (n3 > n4) {
            throw new IndexOutOfBoundsException("toIndex " + n3 + " > size " + this.b);
        }
        if (n2 > n3) {
            throw new IndexOutOfBoundsException("fromIndex " + n2 + " > toIndex " + n3);
        }
        System.arraycopy(objectArray, n3, objectArray, n2, n4 - n3);
        int n5 = n3 - n2;
        Arrays.fill(objectArray, n4 - n5, n4, null);
        this.b = n4 - n5;
        ++this.modCount;
    }

    public GGameObject b(int n2, GGameObject w2) {
        GGameObject[] wArray = this.c;
        if (n2 >= this.b) {
            s.a(n2, this.b);
        }
        GGameObject w3 = wArray[n2];
        wArray[n2] = w2;
        return w3;
    }

    @Override
    public Object[] toArray() {
        int n2 = this.b;
        Object[] objectArray = new Object[n2];
        System.arraycopy(this.c, 0, objectArray, 0, n2);
        return objectArray;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        int n2 = this.b;
        if (objectArray.length < n2) {
            Object[] objectArray2 = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n2);
            objectArray = objectArray2;
        }
        System.arraycopy(this.c, 0, objectArray, 0, n2);
        if (objectArray.length > n2) {
            objectArray[n2] = null;
        }
        return objectArray;
    }

    @Override
    public Iterator iterator() {
        return new t(this, null);
    }

    @Override
    public int hashCode() {
        GGameObject[] wArray = this.c;
        int n2 = 1;
        int n3 = this.b;
        for (int i2 = 0; i2 < n3; ++i2) {
            GGameObject w2 = wArray[i2];
            n2 = 31 * n2 + (w2 == null ? 0 : w2.hashCode());
        }
        return n2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof List)) {
            return false;
        }
        List list = (List)object;
        int n2 = this.b;
        if (list.size() != n2) {
            return false;
        }
        GGameObject[] wArray = this.c;
        if (list instanceof RandomAccess) {
            for (int i2 = 0; i2 < n2; ++i2) {
                GGameObject w2 = wArray[i2];
                Object e2 = list.get(i2);
                if (!(w2 == null ? e2 != null : !w2.equals(e2))) continue;
                return false;
            }
        } else {
            Iterator iterator = list.iterator();
            for (int i3 = 0; i3 < n2; ++i3) {
                GGameObject w3 = wArray[i3];
                Object e3 = iterator.next();
                if (!(w3 == null ? e3 != null : !w3.equals(e3))) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public /* synthetic */ Object remove(int n2) {
        return this.b(n2);
    }

    @Override
    public /* synthetic */ void add(int n2, Object object) {
        this.a(n2, (GGameObject)object);
    }

    @Override
    public /* synthetic */ Object set(int n2, Object object) {
        return this.b(n2, (GGameObject)object);
    }

    @Override
    public /* synthetic */ Object get(int n2) {
        return this.a(n2);
    }

    @Override
    public /* synthetic */ boolean add(Object object) {
        return this.a((GGameObject)object);
    }

    static /* synthetic */ int a(s s2) {
        return s2.modCount;
    }

    static /* synthetic */ int b(s s2) {
        return s2.modCount;
    }

    static /* synthetic */ int c(s s2) {
        return s2.modCount;
    }

    static /* synthetic */ int d(s s2) {
        return s2.modCount;
    }

    static /* synthetic */ int e(s s2) {
        return s2.modCount;
    }

    static /* synthetic */ int f(s s2) {
        return ++s2.modCount;
    }
}

