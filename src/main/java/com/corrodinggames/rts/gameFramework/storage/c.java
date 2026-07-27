/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 */
package com.corrodinggames.rts.gameFramework.storage;

import android.os.Environment;
import android.content.Context;
import android.content.res.AssetManager;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.i.b;
import com.corrodinggames.rts.gameFramework.storage.a;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.FileLoaderFactory;
import com.corrodinggames.rts.gameFramework.utility.IFileLoader;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class c {
    public String a = "FileLoader: ";
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    String e;
    String f;

    public String a() {
        String string2 = this.e;
        this.e = null;
        return string2;
    }

    public void a(String string2) {
        this.e = string2;
    }

    public String a(String string2, String string3) {
        File file = new File(string2);
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            GameEngine.log(this.a + "findFileExtension('" + string2 + "','" + string3 + "'): path is not a folder");
            return null;
        }
        for (File file2 : fileArray) {
            String string4 = file2.getName();
            if (string4.contains(".")) {
                string4 = string4.substring(0, string4.lastIndexOf(46));
            }
            if (!string4.equals(string3)) continue;
            return string2 + "/" + file2.getName();
        }
        GameEngine.log(this.a + "Could not find file with path: " + string2 + " file:" + string3);
        return null;
    }

    public boolean b(String string2) {
        if (GameEngine.isPausedStatic2) {
            return false;
        }
        if (string2.startsWith("/")) {
            return false;
        }
        return !string2.startsWith("/SD/");
    }

    public boolean c(String string2) {
        if (string2.startsWith("/") || string2.startsWith("\\")) {
            return true;
        }
        if (GameEngine.isPausedStatic2) {
            if (string2.startsWith("mods")) {
                return true;
            }
            if (GameEngine.isDebugVersionStatic2 && string2.startsWith("converted-sounds")) {
                return true;
            }
        }
        return (string2 = string2.split("\\\\")[0]).endsWith(":");
    }

    public String d(String string2) {
        String string3;
        String string4;
        int n2;
        boolean bl2;
        String string5;
        String[] stringArray;
        GameEngine l2 = GameEngine.getInstance();
        if (string2.contains("MOD|")) {
            stringArray = string2.split("/");
            if (stringArray.length >= 2) {
                string5 = stringArray[stringArray.length - 1];
                bl2 = false;
                for (n2 = stringArray.length - 2; n2 >= 0; --n2) {
                    string4 = stringArray[n2];
                    if (string4.startsWith("MOD|")) {
                        string3 = string4.substring("MOD|".length());
                        b b2 = l2.bZ.c(string3);
                        if (b2 == null) {
                            GameEngine.log(this.a + "Failed to find mod with hash:" + string3);
                        } else {
                            string5 = com.corrodinggames.rts.gameFramework.GameUtils.b(b2.g(), string5);
                            GameEngine.log(this.a + "Path changed to mod path:" + string5);
                            bl2 = true;
                            break;
                        }
                    }
                    string5 = string4 + File.separator + string5;
                }
                if (bl2) {
                    string2 = string5;
                }
            }
            if (string2.contains("MOD|")) {
                GameEngine.log(this.a + "Path still contains prefix: " + string2);
            }
        }
        if (string2.contains("NEW_PATH|") && (stringArray = string2.split("/")).length >= 2) {
            string5 = stringArray[stringArray.length - 1];
            bl2 = false;
            for (n2 = stringArray.length - 2; n2 >= 0; --n2) {
                string4 = stringArray[n2];
                if (string4.startsWith("NEW_PATH|") && (string3 = string4.substring("NEW_PATH|".length())).equals("maps2")) {
                    string5 = "/SD/rustedWarfare/maps" + File.separator + string5;
                    GameEngine.log(this.a + "Path changed to maps2 path:" + string5);
                    bl2 = true;
                    break;
                }
                string5 = string4 + File.separator + string5;
            }
            if (bl2) {
                string2 = string5;
            }
        }
        return string2;
    }

    public String e(String string2) {
        boolean bl2 = false;
        if (string2 == null) {
            return "<null>";
        }
        IFileLoader af2 = FileLoaderFactory.b(string2 = this.f(string2));
        if (af2 != null) {
            String string3 = af2.f(string2);
            return string3;
        }
        return string2;
    }

    public String f(String string2) {
        string2 = this.d(string2);
        if (GameEngine.isPausedStatic2) {
            if (string2.startsWith("/SD/rusted_warfare_maps")) {
                string2 = "/SD/mods/maps" + string2.substring("/SD/rusted_warfare_maps".length());
            }
            if (string2.startsWith("/SD/rustedWarfare/maps")) {
                string2 = "/SD/mods/maps" + string2.substring("/SD/rustedWarfare/maps".length());
            }
            if (string2.startsWith("/SD/") || string2.startsWith("\\SD\\")) {
                String string3;
                String string4 = string2.substring("/SD/".length());
                if (string4.startsWith(string3 = "rustedWarfare/")) {
                    string4 = string4.substring(string3.length());
                }
                string4 = this.b() + string4;
                return string4;
            }
            if (this.c(string2)) {
                return string2;
            }
            return "assets/" + string2;
        }
        if (string2.startsWith("/SD/")) {
            String string5;
            String string6 = string2.substring("/SD/".length());
            if (string6.startsWith(string5 = "rustedWarfare/")) {
                string6 = string6.substring(string5.length());
            }
            return this.b() + string6;
        }
        return string2;
    }

    private String f() {
        if (this.f == null) {
            this.f = Environment.getExternalStorageDirectory() + "";
        }
        return this.f;
    }

    public boolean a(String string2, boolean bl2) {
        String string3 = this.f(string2);
        IFileLoader af2 = bl2 ? FileLoaderFactory.b(string3) : FileLoaderFactory.a(string3);
        if (af2 != null) {
            return af2.d(string3);
        }
        if (this.b(string2)) {
            if (this.d) {
                return false;
            }
            if (!GameEngine.getInstance().bK.a(string3)) {
                GameEngine.log(this.a + "isDirectory: asset file doesn't exist:" + string3);
                return false;
            }
            String string4 = com.corrodinggames.rts.gameFramework.GameUtils.k(string2);
            return !string4.contains(".");
        }
        File file = new File(string3);
        if (!file.exists()) {
            GameEngine.log(this.a + "isDirectory: file doesn't exist:" + string3);
            return false;
        }
        return file.isDirectory();
    }

    public boolean g(String string2) {
        String string3 = this.f(string2);
        IFileLoader af2 = FileLoaderFactory.a(string3);
        if (af2 != null) {
            boolean bl2 = af2.a(string3);
            if (this.c) {
                GameEngine.log("fileExists: " + bl2 + " with reader: " + af2 + " convertedDir:" + string3);
            }
            return bl2;
        }
        if (this.b(string2)) {
            if (this.d) {
                if (this.c) {
                    GameEngine.log("fileExists: false with disableAssets");
                }
                return false;
            }
            boolean bl3 = GameEngine.getInstance().bK.a(string3);
            if (this.c) {
                GameEngine.log("fileExists: " + bl3 + " with abstractPathAsset convertedDir:" + string3);
            }
            return bl3;
        }
        File file = new File(string3);
        if (file == null || !file.exists()) {
            if (this.c) {
                GameEngine.log("fileExists: false with normal file convertedDir:" + string3);
            }
            return false;
        }
        return true;
    }

    public String[] b(String string2, boolean bl2) {
        try {
            Serializable serializable;
            String[] stringArray;
            String string3 = this.f(string2);
            IFileLoader af2 = FileLoaderFactory.a(string3);
            if (af2 != null) {
                stringArray = af2.b(string3);
            } else if (this.b(string2)) {
                if (this.d) {
                    return null;
                }
                stringArray = GameEngine.getInstance().bK.b(string3);
            } else {
                serializable = new File(string3);
                if (serializable == null || !((File)serializable).exists()) {
                    String string4 = "listDir: path doesn't exist:" + string3;
                    GameEngine.b(string4);
                    com.corrodinggames.rts.gameFramework.storage.a.b(string4);
                    return null;
                }
                stringArray = ((File)serializable).list();
                if (stringArray == null) {
                    if (serializable != null && !((File)serializable).isDirectory()) {
                        com.corrodinggames.rts.gameFramework.storage.a.b("path is not a directory, .rwmod or .zip");
                    }
                    return null;
                }
            }
            if (stringArray == null) {
                GameEngine.log(this.a + "listDir baseList==null:" + string2 + " (non folder?)");
                return null;
            }
            serializable = new ArrayList();
            if (bl2) {
                for (String string5 : stringArray) {
                    if (!string5.toLowerCase(Locale.ENGLISH).endsWith(".tmx")) continue;
                    ((ArrayList)serializable).add(string5);
                }
            } else {
                for (String string6 : stringArray) {
                    ((ArrayList)serializable).add(string6);
                }
            }
            Collections.sort((List) serializable);
            return (String[]) ((ArrayList)serializable).toArray(new String[0]);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            com.corrodinggames.rts.gameFramework.storage.a.b(outOfMemoryError.getMessage());
            return null;
        }
    }

    public File h(String string2) {
        File file;
        if (string2.contains("\\")) {
            string2 = string2.replace('\\', '/');
        }
        if ((file = new File(string2)).exists()) {
            return file;
        }
        File file2 = file.getParentFile();
        if (!(file2 != null && file2.isDirectory() || (file2 = this.h(file2.getAbsolutePath())) != null && file2.isDirectory())) {
            GameEngine.log(this.a + "createFileCaseInsensitive: did not find parent for: " + string2);
            return null;
        }
        File[] fileArray = file2.listFiles();
        if (fileArray == null) {
            GameEngine.log(this.a + "createFileCaseInsensitive: Failed to list files for: " + string2 + " in " + file2);
            return null;
        }
        for (File file3 : fileArray) {
            if (!file3.getName().equalsIgnoreCase(file.getName())) continue;
            return file3;
        }
        return null;
    }

    public AssetInputStream i(String string2) {
        InputStream inputStream;
        if (string2.startsWith("assets/") || string2.startsWith("assets\\")) {
            string2 = string2.substring("assets/".length());
        }
        String string3 = string2;
        String string4 = "assets/" + string2;
        Context context = com.corrodinggames.rts.appFramework.c.a();
        AssetManager assetManager = context.d();
        if (GameEngine.isPCVersionStatic2) {
            // empty if block
        }
        try {
            inputStream = assetManager.a(string3);
        }
        catch (IOException iOException) {
            GameEngine.log(this.a + "Could not find asset:" + string4);
            return null;
        }
        try {
            return new AssetInputStream(inputStream, string4, string3);
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
    }

    public AssetInputStream j(String string2) {
        AssetInputStream j2;
        String string3 = this.f(string2);
        IFileLoader af2 = FileLoaderFactory.a(string3);
        if (af2 != null && !string3.endsWith(".rwmod")) {
            return af2.b(string3, true);
        }
        if (string2.startsWith("/SD/") || string2.startsWith("\\SD\\")) {
            String string4;
            String string5 = string2 = string2.substring("/SD/".length());
            if (string5.startsWith(string4 = "rustedWarfare/")) {
                string5 = string5.substring(string4.length());
            }
            string5 = this.b() + string5;
            if (this.b) {
                GameEngine.log(this.a + "openAssetSteam converted:" + string2 + " to: " + string5);
            }
            try {
                File file = this.h(string5);
                if (file == null) {
                    return null;
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                j2 = new AssetInputStream(fileInputStream, file.getAbsolutePath());
            }
            catch (FileNotFoundException fileNotFoundException) {
                return null;
            }
        } else if (this.c(string2)) {
            try {
                File file = this.h(string2);
                if (file == null) {
                    return null;
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                j2 = new AssetInputStream(fileInputStream, file.getAbsolutePath());
            }
            catch (FileNotFoundException fileNotFoundException) {
                return null;
            }
        } else {
            j2 = this.i(string2);
        }
        return j2;
    }

    public OutputStream c(String string2, boolean bl2) throws FileNotFoundException {
        IFileLoader af2 = FileLoaderFactory.a(string2 = this.f(string2));
        if (af2 != null && !string2.endsWith(".rwmod")) {
            return af2.c(string2, bl2);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(string2, bl2);
        return fileOutputStream;
    }

    public boolean k(String string2) {
        String string3 = this.f(string2);
        IFileLoader af2 = FileLoaderFactory.a(string3);
        if (af2 != null && !string3.endsWith(".rwmod")) {
            boolean bl2 = af2.e(string3);
            if (!bl2) {
                GameEngine.log("Failed to create directory: " + string3 + " using reader:" + af2);
            }
            return bl2;
        }
        boolean bl3 = new File(string3).mkdirs();
        if (!bl3) {
            GameEngine.log("Failed to create directory: " + string3);
        }
        return bl3;
    }

    public String b() {
        if (GameEngine.isPausedStatic2) {
            return "";
        }
        return this.f() + "/rustedWarfare/";
    }

    public String c() {
        if (GameEngine.at()) {
            String string2 = com.corrodinggames.rts.appFramework.c.a().i().getAbsolutePath();
            if (!string2.endsWith("/")) {
                string2 = string2 + "/";
            }
            return string2;
        }
        String string3 = this.b();
        if (string3.equals("")) {
            return "cache/";
        }
        return string3 + "/cache/";
    }

    public long l(String string2) {
        IFileLoader af2 = FileLoaderFactory.a(string2 = this.f(string2));
        if (af2 != null) {
            return af2.g(string2);
        }
        File file = new File(string2);
        if (!file.exists()) {
            // empty if block
        }
        return file.lastModified();
    }

    public void a(File file) {
        if (GameEngine.at()) {
            // empty if block
        }
    }

    public File a(String string2, String string3, boolean bl2) {
        String string4 = this.b();
        String string5 = string4 + string3 + string2;
        File file = new File(string5);
        if (bl2) {
            File file2 = file.getParentFile();
            if (!com.corrodinggames.rts.gameFramework.storage.a.i(file2.getAbsolutePath())) {
                GameEngine.log("Making missing parent dir: " + file2.getAbsolutePath());
                if (!com.corrodinggames.rts.gameFramework.storage.a.l(file2.getAbsolutePath())) {
                    GameEngine.b("getRWFile: Could not create parent directory");
                }
            }
            if (GameEngine.at()) {
                // empty if block
            }
        }
        return file;
    }

    public String d() {
        return "external";
    }

    public String m(String string2) {
        return this.d();
    }

    public boolean e() {
        return true;
    }

    public String n(String string2) {
        if (string2 == null) {
            return null;
        }
        String string3 = "[INTERNAL-PATH]/";
        String string4 = "[EXTERNAL-PATH]/";
        int n2 = string2.indexOf("[INTERNAL-PATH]/");
        if (n2 != -1) {
            String string5 = string2.substring(0, n2) + string2.substring(n2 + "[INTERNAL-PATH]/".length());
            if (string5.contains("[INTERNAL-PATH]/") || string5.contains("[EXTERNAL-PATH]/")) {
                GameEngine.log("fixPath: double tag for: " + string2);
            }
            return string5;
        }
        int n3 = string2.indexOf("[EXTERNAL-PATH]/");
        if (n3 != -1) {
            String string6 = string2.substring(0, n3) + string2.substring(n3 + "[EXTERNAL-PATH]/".length());
            if (string6.contains("[INTERNAL-PATH]/") || string6.contains("[EXTERNAL-PATH]/")) {
                GameEngine.log("fixPath: double tag for: " + string2);
            }
            return string6;
        }
        return string2;
    }

    public String o(String string2) {
        return string2;
    }

    public boolean b(File file) {
        GameEngine.log("deleteFile: " + file.getAbsolutePath());
        IFileLoader af2 = FileLoaderFactory.b(file.getAbsolutePath());
        if (af2 != null) {
            GameEngine.log("Mapped delete");
            return af2.c(file.getAbsolutePath());
        }
        GameEngine.log("Native delete");
        return file.delete();
    }

    public boolean a(File file, File file2) {
        GameEngine.log("renameFile: " + file.getAbsolutePath() + " to:" + file2.getAbsolutePath());
        IFileLoader af2 = FileLoaderFactory.b(file.getAbsolutePath());
        if (af2 != null) {
            boolean bl2;
            try {
                bl2 = af2.a(file.getAbsolutePath(), file2.getAbsolutePath());
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
            FileLoaderFactory.c(file2.getAbsolutePath());
            return bl2;
        }
        boolean bl3 = file.renameTo(file2);
        FileLoaderFactory.c(file2.getAbsolutePath());
        return bl3;
    }

    public boolean p(String string2) {
        IFileLoader af2 = FileLoaderFactory.b(string2 = this.f(string2));
        return af2 != null && af2 instanceof com.corrodinggames.rts.gameFramework.utility.a.a;
    }
}
