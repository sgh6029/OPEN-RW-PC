/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.audio.a;

import com.corrodinggames.rts.java.audio.a.AudioException;
import com.corrodinggames.rts.java.audio.a.IntObjectMap;
import com.corrodinggames.rts.java.audio.a.IntObjectMapEntry;
import com.corrodinggames.rts.java.audio.a.IntObjectMapIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntObjectMapEntries
extends IntObjectMapIterator
implements Iterable,
Iterator {
    private IntObjectMapEntry f = new IntObjectMapEntry();

    public IntObjectMapEntries(IntObjectMap e2) {
        super(e2);
    }

    public IntObjectMapEntry a() {
        if (!this.a) {
            throw new NoSuchElementException();
        }
        if (!this.e) {
            throw new AudioException("#iterator() cannot be used nested.");
        }
        int[] nArray = this.b.b;
        if (this.c == -1) {
            this.f.a = 0;
            this.f.b = this.b.f;
        } else {
            this.f.a = nArray[this.c];
            this.f.b = this.b.c[this.c];
        }
        this.d = this.c;
        this.c();
        return this.f;
    }

    @Override
    public boolean hasNext() {
        if (!this.e) {
            throw new AudioException("#iterator() cannot be used nested.");
        }
        return this.a;
    }

    public Iterator iterator() {
        return this;
    }

    @Override
    public void remove() {
        super.remove();
    }

    public /* synthetic */ Object next() {
        return this.a();
    }
}

