/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;


import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.File;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

public class FileChangeEngine {
    static ConcurrentHashMap<String,Long> a = new ConcurrentHashMap<String,Long>();
    static k_f b;

    public static long a(String string2, boolean bl2) {
        Long l2 = a.get(string2);
        if (l2 != null) {
            return l2;
        }
        l2 = FileChangeEngine.a(string2);
        if (!bl2) {
            a.put(string2, l2);
            if (b == null) {
                // empty if block
            }
        }
        return l2;
    }

    private static long a(String string2) {
        File file = new File(string2);
        return file.lastModified();
    }

    public static synchronized void a() {
        FileChangeEngine.a(GameEngine.getInstance().bQ.liveReloading);
    }

    public static synchronized void a(boolean bl2) {
        if (!GameEngine.av()) {
            return;
        }
        if (bl2) {
            if (b != null) {
                GameEngine.log("FileChangeEngine: Already running");
                return;
            }
            GameEngine.log("FileChangeEngine: Starting");
            b = new k_f();
            b.start();
        } else if (b != null) {
            FileChangeEngine.b.a = false;
            b = null;
        }
    }

    public static void b() {
        int n2 = 0;
        Enumeration enumeration = a.keys();
        while (enumeration.hasMoreElements()) {
            String string2 = (String)enumeration.nextElement();
            long l2 = FileChangeEngine.a(string2);
            Long l3 = (Long)a.get(string2);
            if (l3 == null) {
                GameEngine.log("FileChangeEngine: old lastModified null for " + string2);
            } else if (l3 != l2) {
                GameEngine.log("FileChangeEngine: Detected change to:" + string2 + " now " + l2);
            }
            a.put(string2, l2);
            if (++n2 <= 50) continue;
            n2 = 0;
            try {
                Thread.sleep(2L);
            }
            catch (InterruptedException interruptedException) {}
        }
    }
}

