/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.storage;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.storage.a;
import com.corrodinggames.rts.gameFramework.storage.h;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.ag;
import com.corrodinggames.rts.gameFramework.utility.al;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class g {
    public static boolean a = true;

    public static final String a(char c2) {
        return String.valueOf((int)c2);
    }

    public static String a(String string2, char c2) {
        if (GameUtils.b(string2, c2)) {
            string2 = GameUtils.a(string2, String.valueOf(c2), "%" + g.a(c2));
        }
        return string2;
    }

    public static String a(String string2) {
        if (string2 == null) {
            return "null";
        }
        string2 = GameUtils.a(string2, "%", "%%");
        string2 = g.a(string2, '/');
        string2 = g.a(string2, '\\');
        string2 = g.a(string2, ':');
        string2 = g.a(string2, '\"');
        string2 = g.a(string2, '\'');
        string2 = g.a(string2, '|');
        string2 = g.a(string2, '?');
        string2 = g.a(string2, '*');
        string2 = g.a(string2, '<');
        string2 = g.a(string2, '>');
        if ((string2 = g.a(string2, '\u0000')).contains("/")) {
            throw new IllegalArgumentException();
        }
        if (string2.contains("\\")) {
            throw new IllegalArgumentException();
        }
        return string2;
    }

    public static String a(String string2, String string3, boolean bl2) {
        boolean bl3;
        Object object;
        String string4 = com.corrodinggames.rts.gameFramework.storage.a.e();
        String string5 = string4 + g.a(string2) + ".cachedata";
        if (bl2 && !((File)(object = new File(string5))).isDirectory() && !(bl3 = ((File)object).mkdirs())) {
            GameEngine.log("Failed to create folder for:" + ((File)object).getAbsolutePath());
        }
        object = string5 + "/" + g.a(string3);
        return (String) object;
    }

    public static boolean a(String string2, String string3, String string4) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(string4.getBytes("UTF-8"));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException);
        }
        return g.a(string2, string3, byteArrayInputStream);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean a(String string2, String string3, InputStream inputStream) {
        try {
            String string4 = g.a(string2, string3, true);
            File file = new File(string4);
            File file2 = new File(string4 + ".tmp");
            try (FileOutputStream fileOutputStream = new FileOutputStream(file2);){
                GameUtils.a(inputStream, fileOutputStream);
            }
            boolean bl2 = com.corrodinggames.rts.gameFramework.storage.a.a(file2, file);
            if (!bl2) {
                GameEngine.b("AddToCache: Failed to rename to final file: " + string4);
                return false;
            }
            if (a) {
                GameEngine.log("Wrote cache file at: " + file.getAbsolutePath());
            }
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    public static FileInputStream a(String string2, String string3) {
        String string4 = g.a(string2, string3, false);
        try {
            File file = new File(string4);
            if (!file.exists()) {
                return null;
            }
            long l2 = System.currentTimeMillis();
            file.setLastModified(l2);
            FileInputStream fileInputStream = new FileInputStream(file);
            return fileInputStream;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public static String b(String string2, String string3) {
        FileInputStream fileInputStream = g.a(string2, string3);
        if (fileInputStream == null) {
            return null;
        }
        return GameUtils.a(fileInputStream);
    }

    public static void c(String string2, String string3) {
        boolean bl2;
        String string4 = g.a(string2, string3, false);
        File file = new File(string4);
        if (file.exists() && !(bl2 = file.delete())) {
            GameEngine.g("Failed to delete: " + string4);
        }
    }

    private static h b(String string2, String string3, String string4) {
        String[] stringArray;
        String string5 = string3 + ".data";
        String string6 = string3 + ".meta";
        String string7 = g.b(string2, string6);
        if (string7 != null && (stringArray = al.b(string7, ":")) != null) {
            Long l2 = GameUtils.m(stringArray[0]);
            long l3 = com.corrodinggames.rts.gameFramework.storage.a.m(string3);
            String string8 = stringArray[1];
            if (l2 == null) {
                if (a) {
                    GameEngine.log("openAssetCached: Bad meta data for: " + string3);
                }
            } else if (l2 != l3) {
                if (a) {
                    GameEngine.log("openAssetCached: Stale timestamp for: " + string3 + " (" + l2 + "!=" + l3 + ")");
                }
            } else {
                if (string8.startsWith("null")) {
                    if (a) {
                        GameEngine.log("openAssetCached: Cache hit (null-type) for: " + string3 + " (" + l2 + "!=" + l3 + ")");
                    }
                    return new h(null);
                }
                if (!string8.startsWith(string4)) {
                    if (a) {
                        GameEngine.log("openAssetCached: Unsupported type " + string8 + " for: " + string3 + " expected: " + string4);
                    }
                    return new h(null);
                }
                FileInputStream fileInputStream = g.a(string2, string5);
                if (fileInputStream != null) {
                    if (a) {
                        GameEngine.log("openAssetCached: Cache hit for: " + string3);
                    }
                    return new h(fileInputStream);
                }
                if (a) {
                    GameEngine.log("openAssetCached: meta file but not data for: " + string3);
                }
            }
        }
        return null;
    }

    public static String[] d(String string2, String string3) {
        long l2;
        String string4;
        if (!ag.i(string3)) {
            return com.corrodinggames.rts.gameFramework.storage.a.h(string3);
        }
        String string5 = string3 + ".data";
        String string6 = string3 + ".meta";
        String string7 = "list";
        h h2 = g.b(string2, string3, "list");
        if (h2 != null) {
            if (h2.a == null) {
                return null;
            }
            String string8 = GameUtils.a(h2.a);
            h2.a();
            return al.e(string8);
        }
        String[] stringArray = com.corrodinggames.rts.gameFramework.storage.a.h(string3);
        if (stringArray != null) {
            if (a) {
                GameEngine.log("listDirCached: Listing count: " + stringArray.length);
            }
            string4 = "list";
            l2 = com.corrodinggames.rts.gameFramework.storage.a.m(string3);
            if (l2 == 0L) {
                if (a) {
                    GameEngine.log("openAssetCached: Got 0 timestamp for: " + string3 + " cannot cache");
                }
                return stringArray;
            }
            g.a(string2, string5, al.a(stringArray));
        } else {
            if (a) {
                GameEngine.log("listDirCached: Null");
            }
            string4 = "null";
            l2 = com.corrodinggames.rts.gameFramework.storage.a.m(string3);
        }
        String string9 = l2 + ":" + string4;
        g.a(string2, string6, string9);
        return stringArray;
    }

    public static InputStream e(String string2, String string3) {
        long l2;
        String string4;
        AssetInputStream j2;
        String string5 = string3 + ".data";
        String string6 = string3 + ".meta";
        String string7 = "data";
        h h2 = g.b(string2, string3, "data");
        if (h2 != null) {
            return h2.a;
        }
        if (a) {
            GameEngine.log("openAssetCached: Cache miss for: " + string3);
        }
        if ((j2 = com.corrodinggames.rts.gameFramework.storage.a.k(string3)) != null) {
            if (a) {
                GameEngine.log("openAssetCached: Reading: " + string3);
            }
            string4 = "data";
            l2 = com.corrodinggames.rts.gameFramework.storage.a.m(string3);
            if (l2 == 0L) {
                if (a) {
                    GameEngine.log("openAssetCached: Got 0 timestamp for: " + string3 + " cannot cache");
                }
                return j2;
            }
            if (!g.a(string2, string5, j2)) {
                // empty if block
            }
        } else {
            if (a) {
                GameEngine.log("openAssetCached: Got null for: " + string3);
            }
            string4 = "null";
            l2 = com.corrodinggames.rts.gameFramework.storage.a.m(string3);
        }
        String string8 = l2 + ":" + string4;
        g.a(string2, string6, string8);
        if (j2 == null) {
            return null;
        }
        try {
            ((InputStream)j2).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        FileInputStream fileInputStream = g.a(string2, string5);
        if (fileInputStream == null) {
            GameEngine.b("openAssetCached: Error. Failed to reopen cache: " + string3);
            return com.corrodinggames.rts.gameFramework.storage.a.k(string3);
        }
        return fileInputStream;
    }

    public static boolean f(String string2, String string3) {
        InputStream inputStream = g.e(string2, string3);
        if (inputStream == null) {
            return false;
        }
        try {
            inputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return true;
    }
}

