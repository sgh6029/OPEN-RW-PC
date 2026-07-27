/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.audio.a;

import com.corrodinggames.rts.java.audio.a.n;
import java.util.Random;

public final class MathUtils {
    public static Random a = new Random();

    public static float a(float f2) {
        return n.a[(int)(f2 * 2607.5945f) & 0x3FFF];
    }

    public static float b(float f2) {
        return n.a[(int)((f2 + 1.5707964f) * 2607.5945f) & 0x3FFF];
    }

    public static int a(int n2) {
        return a.nextInt(n2 + 1);
    }

    public static int b(int n2) {
        if (n2 == 0) {
            return 1;
        }
        --n2;
        n2 |= n2 >> 1;
        n2 |= n2 >> 2;
        n2 |= n2 >> 4;
        n2 |= n2 >> 8;
        n2 |= n2 >> 16;
        return n2 + 1;
    }

    public static float a(float f2, float f3, float f4) {
        if (f2 < f3) {
            return f3;
        }
        if (f2 > f4) {
            return f4;
        }
        return f2;
    }
}

