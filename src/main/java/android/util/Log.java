/*
 * Decompiled with CFR 0.152.
 */
package android.util;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Log {
    @SuppressWarnings("rawtypes")
    private static final ThreadLocal a = new ThreadLocal() {
        protected SimpleDateFormat a() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }

        protected /* synthetic */ Object initialValue() {
            return this.a();
        }
    };

    public static boolean disableLog = false;

    private Log() {
    }

    // 下方6个最终汇聚到一个方法
    public static int a(String string2, String string3) {
        return Log.a(0, 2, string2, string3);
    }

    public static int b(String string2, String string3) {
        return Log.a(0, 3, string2, string3);
    }

    public static int c(String string2, String string3) {
        return Log.a(0, 5, string2, string3);
    }

    public static int a(String string2, String string3, Throwable throwable) {
        return Log.a(0, 5, string2, string3 + '\n' + Log.a(throwable));
    }

    public static int d(String string2, String string3) {
        return Log.a(0, 6, string2, string3);
    }

    public static int b(String string2, String string3, Throwable throwable) {
        return Log.a(0, 6, string2, string3 + '\n' + Log.a(throwable));
    }

    public static native boolean isLoggable(String var0, int var1);

    // remove
    public static int c(String string2, String string3, Throwable throwable) {
        return Log.a(0, string2, string3, throwable, false);
    }

    // remove
    static int a(int n2, String string2, String string3, Throwable throwable, boolean bl2) {
        throw new RuntimeException("removed");
    }

    @SuppressWarnings("unused")
    public static String a(Throwable throwable) {
        StackTraceElement[] stackTraceElementArray;
        StringWriter stringWriter = new StringWriter();
        for (StackTraceElement stackTraceElement : stackTraceElementArray = new Throwable().getStackTrace()) {
            stringWriter.write(stackTraceElement.toString() + "\n");
        }
        return stringWriter.toString();
    }

    // private
    public static int a(int n2, int n3, String string2, String string3) {
        Log.a(n2, string2, string3);
        return 0;
    }

    // private
    public static int a(int n2, String string2, String string3) {
        if (disableLog) {
            return 0;
        }
        String string4 = ((SimpleDateFormat) a.get()).format(new Date());// 获取时间
        System.out.println(string4 + ": " + string3);
        return 0;
    }
}
