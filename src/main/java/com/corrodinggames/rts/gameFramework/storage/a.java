/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.corrodinggames.rts.gameFramework.storage;

import android.os.Build;
import android.content.Context;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class a {
    public static final c a;
    public static c b;
    public static Boolean c;
    public static String d;
    public static String e;

    protected static String a() {
        Context context = com.corrodinggames.rts.appFramework.c.a();
        File file = context.b(null);
        if (file != null) {
            return file.getAbsolutePath();
        }
        GameEngine.b("Failed to get an internal path.");
        return null;
    }

    public static void b() {
        e = null;
        if (GameEngine.at()) {
            if (Build.VERSION.SDK_INT < 19) {
                e = "Android version too old for new file system support";
                GameEngine.log("FileLoader: SDK too old, not changing FileLoader");
                return;
            }
            int n2 = GameEngine.getInstance().bQ.storageType;
            GameEngine.log("FileLoader: storageBehaviour:" + n2);
            c c2 = com.corrodinggames.rts.gameFramework.storage.a.a(n2);
            GameEngine.log("Using file loader: " + c2.d());
            b = c2;
        }
    }

    public static boolean a(String string2) {
        return b.p(string2);
    }

    public static b a(boolean bl2) {
        b b2 = new b();
        if (!GameEngine.at()) {
            b2.b = false;
            b2.c = true;
            return b2;
        }
        if (Build.VERSION.SDK_INT < 19) {
            b2.b = false;
            b2.c = true;
            return b2;
        }
        b2.b = true;
        b2.a = false;
        if (d != null) {
            b2.a = true;
        }
        if (c != null && !c.booleanValue()) {
            b2.c = true;
            b2.b = false;
            b2.a = false;
        }
        if (Build.VERSION.SDK_INT <= 28 && c == null) {
            GameEngine.b("FileLoader using direct external access due to sdk: " + Build.VERSION.SDK_INT);
            b2.c = true;
            b2.b = false;
            b2.a = false;
        }
        return b2;
    }

    public static c a(int n2) {
        c c2;
        if (!GameEngine.at()) {
            return new c();
        }
        if (Build.VERSION.SDK_INT < 19) {
            GameEngine.log("FileLoader: SDK too old, not changing FileLoader");
            return new c();
        }
        String string2 = com.corrodinggames.rts.gameFramework.storage.a.a();
        d d2 = null;
        if (string2 == null) {
            e = "Failed to get internal app path (is it unmounted?).";
            n2 = 3;
        } else {
            d2 = new d(string2, "internal");
            d2.i = "Internal: ";
        }
        b b2 = com.corrodinggames.rts.gameFramework.storage.a.a(false);
        if (!b2.a) {
            if (!b2.c) {
                GameEngine.b("Not using direct external backend: As direct reads will cause problems");
                c2 = null;
                n2 = 0;
            } else {
                GameEngine.b("FileLoader using direct external file access! SDK:" + Build.VERSION.SDK_INT);
                c2 = new c();
            }
        } else {
            GameEngine.log("FileLoader using overriddenExternalPath:" + d);
            c2 = new d(d, "external");
        }
        f f2 = new f();
        if (n2 != 3 && d2 == null) {
            GameEngine.b("No available file backends!!");
            return f2;
        }
        e e2 = n2 == 1 ? new e(d2, "[INTERNAL-PATH]/", c2, "[EXTERNAL-PATH]/") : (n2 == 2 ? new e(c2, "[EXTERNAL-PATH]/", d2, "[INTERNAL-PATH]/") : (n2 == 3 ? new e(c2, "[EXTERNAL-PATH]/", f2, "[NULL-PATH]/") : new e(d2, "[INTERNAL-PATH]/", f2, "[NULL-PATH]/")));
        e2.h.d = true;
        return e2;
    }

    public static String c() {
        return b.a();
    }

    public static void b(String string2) {
        b.a(string2);
    }

    public static String a(String string2, String string3) {
        return b.a(string2, string3);
    }

    public static boolean c(String string2) {
        return b.b(string2);
    }

    public static String d(String string2) {
        return b.e(string2);
    }

    public static String e(String string2) {
        return b.f(string2);
    }

    public static boolean f(String string2) {
        return b.a(string2, false);
    }

    public static boolean g(String string2) {
        return b.a(string2, true);
    }

    public static String[] h(String string2) {
        return b.b(string2, false);
    }

    public static String[] a(String string2, boolean bl2) {
        return b.b(string2, bl2);
    }

    public static boolean i(String string2) {
        return b.g(string2);
    }

    public static AssetInputStream j(String string2) {
        return b.i(string2);
    }

    public static AssetInputStream a(File file) {
        return b.j(file.getAbsolutePath());
    }

    public static AssetInputStream k(String string2) {
        return b.j(string2);
    }

    public static OutputStream a(File file, boolean bl2) throws FileNotFoundException {
        return b.c(file.getAbsolutePath(), bl2);
    }

    public static OutputStream b(String string2, boolean bl2) throws FileNotFoundException {
        return b.c(string2, bl2);
    }

    public static boolean l(String string2) {
        return b.k(string2);
    }

    public static String d() {
        return b.b();
    }

    public static String e() {
        return b.c();
    }

    public static long m(String string2) {
        return b.l(string2);
    }

    public static File a(String string2, String string3, boolean bl2) {
        return b.a(string2, string3, bl2);
    }

    public static boolean a(File file, File file2) {
        if (GameEngine.av() && file2.exists()) {
            file2.delete();
        }
        return file.renameTo(file2);
    }

    public static boolean b(File file, File file2) {
        return b.a(file, file2);
    }

    public static boolean b(File file) {
        return b.b(file);
    }

    public static String n(String string2) {
        return b.m(string2);
    }

    public static boolean f() {
        return b.e();
    }

    public static String o(String string2) {
        return b.n(string2);
    }

    public static String p(String string2) {
        return b.o(string2);
    }

    public static File a(Context context, String string2, String string3) throws IOException {
        try {
            File file = context.i();
            File file2 = File.createTempFile(string2, string3, file);
            return file2;
        }
        catch (IOException iOException) {
            try {
                File file = context.j();
                File file3 = File.createTempFile(string2, string3, file);
                return file3;
            }
            catch (IOException iOException2) {
                iOException.printStackTrace();
                throw iOException2;
            }
        }
    }

    public static void c(File file) {
        b.a(file);
    }

    static {
        b = a = new c();
    }
}

