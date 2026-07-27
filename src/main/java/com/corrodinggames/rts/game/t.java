/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game;

import com.corrodinggames.rts.game.p;

public class t {
    public static final p[] a = new p[0];
    p[] b = a;
    int c = 0;

    public boolean a(p p2) {
        int n2 = this.c;
        p[] pArray = this.b;
        if (n2 == pArray.length) {
            p[] pArray2 = new p[n2 + (n2 < 6 ? 12 : n2 >> 1)];
            System.arraycopy(pArray, 0, pArray2, 0, n2);
            pArray = pArray2;
            this.b = pArray2;
        }
        pArray[n2] = p2;
        this.c = n2 + 1;
        return true;
    }
}

