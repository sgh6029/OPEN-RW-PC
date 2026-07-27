/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.utility.n;
import com.corrodinggames.rts.gameFramework.utility.x;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class m
extends AbstractList
implements Serializable,
Cloneable,
RandomAccess {
    public int a;
    transient Object[] b;

    public m(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("capacity < 0: " + n2);
        }
        this.b = n2 == 0 ? x.g : new Object[n2];
    }

    public m() {
        this.b = x.g;
    }

    public Object[] a() {
        return this.b;
    }

    public m(Collection collection) {
        Object[] objectArray = collection.toArray();
        if (objectArray.getClass() != Object[].class) {
            Object[] objectArray2 = new Object[objectArray.length];
            System.arraycopy(objectArray, 0, objectArray2, 0, objectArray.length);
            objectArray = objectArray2;
        }
        this.b = objectArray;
        this.a = objectArray.length;
    }

    @Override
    public boolean add(Object object) {
        int n2 = this.a;
        Object[] objectArray = this.b;
        if (n2 == objectArray.length) {
            Object[] objectArray2 = new Object[n2 + (n2 < 6 ? 12 : n2 >> 1)];
            System.arraycopy(objectArray, 0, objectArray2, 0, n2);
            objectArray = objectArray2;
            this.b = objectArray2;
        }
        objectArray[n2] = object;
        this.a = n2 + 1;
        ++this.modCount;
        return true;
    }

    @Override
    public void add(int n2, Object object) {
        Object[] objectArray = this.b;
        int n3 = this.a;
        if (n2 > n3 || n2 < 0) {
            m.a(n2, n3);
        }
        if (n3 < objectArray.length) {
            System.arraycopy(objectArray, n2, objectArray, n2 + 1, n3 - n2);
        } else {
            Object[] objectArray2 = new Object[m.b(n3)];
            System.arraycopy(objectArray, 0, objectArray2, 0, n2);
            System.arraycopy(objectArray, n2, objectArray2, n2 + 1, n3 - n2);
            objectArray = objectArray2;
            this.b = objectArray2;
        }
        objectArray[n2] = object;
        this.a = n3 + 1;
        ++this.modCount;
    }

    private static int b(int n2) {
        int n3 = n2 < 6 ? 12 : n2 >> 1;
        return n2 + n3;
    }

    @Override
    public boolean addAll(Collection collection) {
        Object[] objectArray = collection.toArray();
        int n2 = objectArray.length;
        if (n2 == 0) {
            return false;
        }
        int n3 = this.a;
        int n4 = n3 + n2;
        Object[] objectArray2 = this.b;
        if (n4 > objectArray2.length) {
            int n5 = m.b(n4 - 1);
            Object[] objectArray3 = new Object[n5];
            System.arraycopy(objectArray2, 0, objectArray3, 0, n3);
            objectArray2 = objectArray3;
            this.b = objectArray3;
        }
        System.arraycopy(objectArray, 0, objectArray2, n3, n2);
        this.a = n4;
        ++this.modCount;
        return true;
    }

    @Override
    public boolean addAll(int n2, Collection collection) {
        Object[] objectArray;
        int n3;
        int n4 = this.a;
        if (n2 > n4 || n2 < 0) {
            m.a(n2, n4);
        }
        if ((n3 = (objectArray = collection.toArray()).length) == 0) {
            return false;
        }
        int n5 = n4 + n3;
        Object[] objectArray2 = this.b;
        if (n5 <= objectArray2.length) {
            System.arraycopy(objectArray2, n2, objectArray2, n2 + n3, n4 - n2);
        } else {
            int n6 = m.b(n5 - 1);
            Object[] objectArray3 = new Object[n6];
            System.arraycopy(objectArray2, 0, objectArray3, 0, n2);
            System.arraycopy(objectArray2, n2, objectArray3, n2 + n3, n4 - n2);
            objectArray2 = objectArray3;
            this.b = objectArray3;
        }
        System.arraycopy(objectArray, 0, objectArray2, n2, n3);
        this.a = n5;
        ++this.modCount;
        return true;
    }

    static IndexOutOfBoundsException a(int n2, int n3) {
        throw new IndexOutOfBoundsException("Invalid index " + n2 + ", size is " + n3);
    }

    @Override
    public void clear() {
        if (this.a != 0) {
            Arrays.fill(this.b, 0, this.a, null);
            this.a = 0;
            ++this.modCount;
        }
    }

    public Object clone() {
        try {
            m m2 = (m)super.clone();
            m2.b = (Object[])this.b.clone();
            return m2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError();
        }
    }

    @Override
    public Object get(int n2) {
        if (n2 >= this.a) {
            m.a(n2, this.a);
        }
        return this.b[n2];
    }

    public final Object a(int n2) {
        return this.b[n2];
    }

    @Override
    public int size() {
        return this.a;
    }

    @Override
    public boolean isEmpty() {
        return this.a == 0;
    }

    @Override
    public boolean contains(Object object) {
        Object[] objectArray = this.b;
        int n2 = this.a;
        if (object != null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!object.equals(objectArray[i2])) continue;
                return true;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                if (objectArray[i3] != null) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object object) {
        Object[] objectArray = this.b;
        int n2 = this.a;
        if (object != null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!object.equals(objectArray[i2])) continue;
                return i2;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                if (objectArray[i3] != null) continue;
                return i3;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        Object[] objectArray = this.b;
        if (object != null) {
            for (int i2 = this.a - 1; i2 >= 0; --i2) {
                if (!object.equals(objectArray[i2])) continue;
                return i2;
            }
        } else {
            for (int i3 = this.a - 1; i3 >= 0; --i3) {
                if (objectArray[i3] != null) continue;
                return i3;
            }
        }
        return -1;
    }

    @Override
    public Object remove(int n2) {
        Object[] objectArray = this.b;
        int n3 = this.a;
        if (n2 >= n3) {
            m.a(n2, n3);
        }
        Object object = objectArray[n2];
        System.arraycopy(objectArray, n2 + 1, objectArray, n2, --n3 - n2);
        objectArray[n3] = null;
        this.a = n3;
        ++this.modCount;
        return object;
    }

    public Object b() {
        Object[] objectArray = this.b;
        int n2 = this.a;
        int n3 = n2 - 1;
        if (n2 == 0) {
            m.a(n3, n2);
        }
        Object object = objectArray[n3];
        objectArray[--n2] = null;
        this.a = n2;
        ++this.modCount;
        return object;
    }

    public Object c() {
        Object[] objectArray = this.b;
        int n2 = this.a;
        int n3 = n2 - 1;
        Object object = objectArray[n3];
        objectArray[--n2] = null;
        this.a = n2;
        return object;
    }

    @Override
    public boolean remove(Object object) {
        Object[] objectArray = this.b;
        int n2 = this.a;
        if (object != null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!object.equals(objectArray[i2])) continue;
                System.arraycopy(objectArray, i2 + 1, objectArray, i2, --n2 - i2);
                objectArray[n2] = null;
                this.a = n2;
                ++this.modCount;
                return true;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                if (objectArray[i3] != null) continue;
                System.arraycopy(objectArray, i3 + 1, objectArray, i3, --n2 - i3);
                objectArray[n2] = null;
                this.a = n2;
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
        Object[] objectArray = this.b;
        int n4 = this.a;
        if (n2 >= n4) {
            throw new IndexOutOfBoundsException("fromIndex " + n2 + " >= size " + this.a);
        }
        if (n3 > n4) {
            throw new IndexOutOfBoundsException("toIndex " + n3 + " > size " + this.a);
        }
        if (n2 > n3) {
            throw new IndexOutOfBoundsException("fromIndex " + n2 + " > toIndex " + n3);
        }
        System.arraycopy(objectArray, n3, objectArray, n2, n4 - n3);
        int n5 = n3 - n2;
        Arrays.fill(objectArray, n4 - n5, n4, null);
        this.a = n4 - n5;
        ++this.modCount;
    }

    @Override
    public Object set(int n2, Object object) {
        Object[] objectArray = this.b;
        if (n2 >= this.a) {
            m.a(n2, this.a);
        }
        Object object2 = objectArray[n2];
        objectArray[n2] = object;
        return object2;
    }

    @Override
    public Object[] toArray() {
        int n2 = this.a;
        Object[] objectArray = new Object[n2];
        System.arraycopy(this.b, 0, objectArray, 0, n2);
        return objectArray;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        int n2 = this.a;
        if (objectArray.length < n2) {
            Object[] objectArray2 = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n2);
            objectArray = objectArray2;
        }
        System.arraycopy(this.b, 0, objectArray, 0, n2);
        if (objectArray.length > n2) {
            objectArray[n2] = null;
        }
        return objectArray;
    }

    @Override
    public Iterator iterator() {
        return new n(this, null);
    }

    @Override
    public int hashCode() {
        Object[] objectArray = this.b;
        int n2 = 1;
        int n3 = this.a;
        for (int i2 = 0; i2 < n3; ++i2) {
            Object object = objectArray[i2];
            n2 = 31 * n2 + (object == null ? 0 : object.hashCode());
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
        int n2 = this.a;
        if (list.size() != n2) {
            return false;
        }
        Object[] objectArray = this.b;
        if (list instanceof RandomAccess) {
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object2 = objectArray[i2];
                Object e2 = list.get(i2);
                if (!(object2 == null ? e2 != null : !object2.equals(e2))) continue;
                return false;
            }
        } else {
            Iterator iterator = list.iterator();
            for (int i3 = 0; i3 < n2; ++i3) {
                Object object3 = objectArray[i3];
                Object e3 = iterator.next();
                if (!(object3 == null ? e3 != null : !object3.equals(e3))) continue;
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ int a(m m2) {
        return m2.modCount;
    }

    static /* synthetic */ int b(m m2) {
        return m2.modCount;
    }

    static /* synthetic */ int c(m m2) {
        return m2.modCount;
    }

    static /* synthetic */ int d(m m2) {
        return ++m2.modCount;
    }
}

