/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.a.a;
import com.corrodinggames.rts.gameFramework.utility.IFileLoader;
import com.corrodinggames.rts.gameFramework.utility.ag;

public class FileLoaderFactory {
    static Object a = new Object();
    static ag b = new ag();
    static IFileLoader c;

    public static boolean a() {
        return GameEngine.at();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static IFileLoader a(String string2) {
        if (ag.i(string2)) {
            return b;
        }
        if (FileLoaderFactory.a() && com.corrodinggames.rts.gameFramework.utility.a.a.l(string2)) {
            if (c == null) {
                Object object = a;
                synchronized (object) {
                    if (c == null) {
                        c = new a();
                    }
                }
            }
            return c;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static IFileLoader b(String string2) {
        if (FileLoaderFactory.a() && com.corrodinggames.rts.gameFramework.utility.a.a.l(string2)) {
            if (c == null) {
                Object object = a;
                synchronized (object) {
                    if (c == null) {
                        c = new a();
                    }
                }
            }
            return c;
        }
        return null;
    }

    public static void c(String string2) {
        if (b != null && ag.i(string2)) {
            b.k(string2);
        }
    }

    public static void b() {
        if (b != null) {
            b.a();
        }
        if (c != null) {
            c.a();
        }
    }
}

