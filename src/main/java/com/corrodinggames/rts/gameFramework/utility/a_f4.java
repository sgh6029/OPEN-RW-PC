/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.utility.a$1;
import com.corrodinggames.rts.gameFramework.utility.b;
import com.corrodinggames.rts.gameFramework.utility.c;

import android.os.Looper;

import java.util.Map;
import java.util.TreeMap;

public class a_f4
extends Error {
    private a_f4(c c2) {
        super("Application Not Responding", c2);
    }

    @Override
    public Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    static a_f4 a(String string2, boolean bl2) {
        Thread thread = Looper.b().e();
        TreeMap<Thread, Object> treeMap = new TreeMap<Thread, Object>(new a$1(thread));
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            if (entry.getKey() != thread && (!entry.getKey().getName().startsWith(string2) || !bl2 && ((StackTraceElement[])entry.getValue()).length <= 0)) continue;
            treeMap.put(entry.getKey(), entry.getValue());
        }
        if (!treeMap.containsKey(thread)) {
            treeMap.put(thread, thread.getStackTrace());
        }
        Object object = null;
        for (Map.Entry entry : treeMap.entrySet()) {
            b b2 = new b(a_f4.a((Thread)entry.getKey()), (StackTraceElement[])entry.getValue());
            b2.getClass();
            object = new c(b2, (c)object);
        }
        return new a_f4((c)object);
    }

    static a_f4 a() {
        Thread thread = Looper.b().e();
        StackTraceElement[] stackTraceElementArray = thread.getStackTrace();
        b b2 = new b(a_f4.a(thread), stackTraceElementArray);
        b2.getClass();
        return new a_f4(new c(b2, null));
    }

    private static String a(Thread thread) {
        return thread.getName() + " (state = " + (Object)((Object)thread.getState()) + ")";
    }
}

