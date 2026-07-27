/*
 * Decompiled with CFR 0.152.
 */
package com.a.a.a;

public class a {
    private static Object[] a = new Object[0];
    private static Object[] b = new Object[73];

    public static int a(int n2) {
        for (int i2 = 4; i2 < 32; ++i2) {
            if (n2 > (1 << i2) - 12) continue;
            return (1 << i2) - 12;
        }
        return n2;
    }

    public static int b(int n2) {
        return com.a.a.a.a.a(n2 * 2) / 2;
    }

    public static int c(int n2) {
        return com.a.a.a.a.a(n2 * 4) / 4;
    }
}

