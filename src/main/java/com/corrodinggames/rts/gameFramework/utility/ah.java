/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.appFramework.c;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.storage.a;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.FileLoaderFactory;
import com.corrodinggames.rts.gameFramework.utility.IFileLoader;
import com.corrodinggames.rts.gameFramework.utility.ag;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ah {
    String a = "";
    String b;
    ZipFile c;
    String[] d;
    boolean e;

    public ah(String string2, String string3) throws IOException {
        this.b = string2;
        GameEngine.g("Opening new zip at: " + string3);
        IFileLoader af2 = FileLoaderFactory.b(string3);
        if (af2 != null) {
            GameEngine.log("Temp file needed for zip with SAF interface");
            if (!GameEngine.at()) {
                throw new IOException("Failed to open source zip with mapper: " + string3);
            }
            long l2 = PerformanceProfiler.a();
            AssetInputStream j2 = af2.b(string3, true);
            if (j2 == null) {
                throw new IOException("Failed to open file of zip: " + string3);
            }
            this.c = ah.a(j2, null);
            double d2 = PerformanceProfiler.a(l2);
            GameEngine.log("Streamed zip open took:" + PerformanceProfiler.a(d2));
        } else {
            this.c = new ZipFile(string3);
        }
        try {
            this.b();
        } catch (IllegalArgumentException illegalArgumentException) {
            ag.h("Failed to open source zip with unicode encoding, attempting with ISO-8859-1");
            Charset charset = Charset.forName("ISO-8859-1");
            try {
                if (af2 != null) {
                    GameEngine.log("Temp file needed for zip with SAF interface");
                    if (!GameEngine.at()) {
                        throw new IOException("Failed to open source zip with mapper: " + string3);
                    }
                    long l3 = PerformanceProfiler.a();
                    AssetInputStream j3 = af2.b(string3, true);
                    this.c = ah.a(j3, charset);
                    double d3 = PerformanceProfiler.a(l3);
                    GameEngine.log("Streamed zip open took:" + PerformanceProfiler.a(d3));
                } else {
                    this.c = ah.a(string3, charset);
                }
            } catch (RuntimeException runtimeException) {
                illegalArgumentException.printStackTrace();
                throw new IOException("Failed to open source zip with unicode and ISO-8859-1 encoding",
                        runtimeException);
            }
            this.b();
        }
    }

    public void a() {
        if (!this.e) {
            this.e = true;
            if (this.c != null) {
                try {
                    this.c.close();
                } catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ZipFile a(InputStream inputStream, Charset charset) throws IOException {
        File file = com.corrodinggames.rts.gameFramework.storage.a.a(com.corrodinggames.rts.appFramework.c.a(),
                "safMod", "zip");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            GameUtils.a(inputStream, fileOutputStream);
            fileOutputStream.close();
            inputStream.close();
            if (charset == null) {
                ZipFile zipFile = new ZipFile(file);
                return zipFile;
            }
            ZipFile zipFile = ah.a(file.getAbsolutePath(), charset);
            return zipFile;
        } finally {
            file.delete();
        }
    }

    public static ZipFile a(String string2, Charset charset) throws IOException {
        Class[] classArray = new Class[] { String.class, Charset.class };
        Constructor constructor = null;
        try {
            constructor = ZipFile.class.getDeclaredConstructor(classArray);
        } catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        } catch (SecurityException securityException) {
            securityException.printStackTrace();
        }
        if (constructor == null) {
            throw new IOException("Failed to open source zip with unicode encoding, and no method for ISO-8859-1");
        }
        Object[] objectArray = new Object[] { string2, charset };
        try {
            return (ZipFile) constructor.newInstance(objectArray);
        } catch (InstantiationException instantiationException) {
            throw new IOException(instantiationException);
        } catch (IllegalAccessException illegalAccessException) {
            throw new IOException(illegalAccessException);
        } catch (InvocationTargetException invocationTargetException) {
            throw new IOException(invocationTargetException);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IOException(illegalArgumentException);
        }
    }

    public void b() {
        long var1 = PerformanceProfiler.a();
        ArrayList var3 = new ArrayList();
        Enumeration var4 = this.c.entries();

        while (var4.hasMoreElements()) {
            ZipEntry var5 = (ZipEntry) var4.nextElement();
            String var6 = var5.getName();
            if (var6 == null) {
                throw new RuntimeException("filePath==null");
            }

            var3.add(var6);
        }

        this.d = (String[]) var3.toArray(new String[0]);
        this.a = "";
        String[] var8 = this.e("");
        if (var8.length == 1 && this.d(var8[0])) {
            this.a = var8[0] + "/";

            for (int var9 = 0; var9 < this.d.length; ++var9) {
                if (this.d[var9].startsWith(this.a)) {
                    this.d[var9] = this.d[var9].substring(this.a.length());
                }
            }
        }

        double var10 = (double) PerformanceProfiler.a(var1);
        if (var10 > 3.0) {
            GameEngine.log("zip: buildCache for: " + this.b + ", took:" + PerformanceProfiler.a(var10));
        }

    }

    public void a(String string2) {
        GameEngine.log("Zip: " + string2);
    }

    public boolean b(String string2) {
        for (String string3 : this.d) {
            if (!string3.equals(string2))
                continue;
            return true;
        }
        return false;
    }

    public boolean c(String string2) {
        for (String string3 : this.d) {
            if (!string3.equals(string2))
                continue;
            return true;
        }
        for (String string3 : this.d) {
            if (!string3.equalsIgnoreCase(string2))
                continue;
            return true;
        }
        return false;
    }

    public boolean d(String string2) {
        if (!string2.endsWith("/")) {
            string2 = string2 + "/";
        }
        if (string2.equals("/")) {
            return true;
        }
        for (String string3 : this.d) {
            if (!string3.contains(string2))
                continue;
            return true;
        }
        return false;
    }

    public String[] e(String string2) {
        if (string2.equals("") || string2.equals("/") || string2.equals("\\")) {
            string2 = "";
        } else if (!string2.endsWith("/")) {
            string2 = string2 + "/";
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string3 : this.d) {
            String string4;
            if (!string2.equals("") && !string3.startsWith(string2)
                    || (string4 = string3.substring(string2.length())).length() == 0 || string4.equals(".."))
                continue;
            if (string4.contains("/")) {
                if (arrayList.contains(string4 = string4.substring(0, string4.indexOf("/"))))
                    continue;
                arrayList.add(string4);
                continue;
            }
            arrayList.add(string4);
        }
        return arrayList.toArray(new String[0]);
    }

    public ZipEntry f(String string2) {
        String string3 = this.a + string2;
        ZipEntry zipEntry = null;
        IllegalArgumentException illegalArgumentException = null;
        try {
            zipEntry = this.c.getEntry(string3);
        } catch (IllegalArgumentException illegalArgumentException2) {
            illegalArgumentException = illegalArgumentException2;
        }
        if (zipEntry == null && this.b(string2) && !this.d(string2)) {
            Enumeration<? extends ZipEntry> enumeration = this.c.entries();
            while (enumeration.hasMoreElements()) {
                ZipEntry zipEntry2;
                try {
                    zipEntry2 = enumeration.nextElement();
                } catch (IllegalArgumentException illegalArgumentException3) {
                    illegalArgumentException3.printStackTrace();
                    continue;
                }
                String string4 = zipEntry2.getName();
                if (!string4.equals(string3))
                    continue;
                return zipEntry2;
            }
            this.a("getEntry: Still did not find file after workaround");
        }
        if (illegalArgumentException != null) {
            throw new RuntimeException(
                    "Failed to decode data in zip: " + string2 + " (Check zip encoding, utf-8 is recommended)",
                    illegalArgumentException);
        }
        return zipEntry;
    }

    public String g(String string2) {
        String string3 = string2;
        if (!string3.endsWith("/")) {
            string3 = string3 + "/";
        }
        for (String string4 : this.d) {
            if (!string4.equals(string2))
                continue;
            return string4;
        }
        for (String string4 : this.d) {
            if (!string4.equals(string3))
                continue;
            return string4;
        }
        for (String string4 : this.d) {
            if (!string4.equalsIgnoreCase(string2))
                continue;
            return string4;
        }
        for (String string4 : this.d) {
            if (!string4.equalsIgnoreCase(string3))
                continue;
            return string4;
        }
        return string2;
    }

    public long h(String string2) {
        ZipEntry zipEntry = this.f(string2);
        if (zipEntry == null) {
            this.a("getEntrySize: File not found: " + string2);
            return -1L;
        }
        return zipEntry.getSize();
    }

    public AssetInputStream i(String string2) {
        AssetInputStream j2;
        InputStream inputStream;
        ZipEntry zipEntry = this.f(string2);
        if (zipEntry == null) {
            zipEntry = this.f(this.g(string2));
        }
        if (zipEntry == null) {
            return null;
        }
        try {
            inputStream = this.c.getInputStream(zipEntry);
        } catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
        try {
            j2 = new AssetInputStream(inputStream, this.b + "/" + string2);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            return null;
        }
        return j2;
    }
}
