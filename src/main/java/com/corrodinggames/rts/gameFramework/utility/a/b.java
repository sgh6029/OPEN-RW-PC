/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.corrodinggames.rts.gameFramework.utility.a;

import android.net.Uri;
import android.content.Context;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.utility.a.a;
import com.corrodinggames.rts.gameFramework.utility.a.c;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

class b {
    Uri a;
    Uri b;
    String c;
    boolean d;
    c e;
    boolean f = false;
    int g = 1;

    public b(Uri uri, boolean bl2) {
        this.a = uri;
        this.b = com.corrodinggames.rts.gameFramework.utility.a.a.a.buildDocumentUriUsingTree(uri);
        this.c = com.corrodinggames.rts.gameFramework.utility.a.a.a.getReadablePath(this.c(), uri);
        this.d = bl2;
        com.corrodinggames.rts.gameFramework.utility.a.a.h("== new SafLink write:" + bl2 + " ==");
        com.corrodinggames.rts.gameFramework.utility.a.a.h("root:" + this.a);
        com.corrodinggames.rts.gameFramework.utility.a.a.h("rootDocument:" + this.b);
        com.corrodinggames.rts.gameFramework.utility.a.a.h("shownUrl:" + this.c);
        this.e = new c(this, "", this.b, true);
    }

    public void a() {
        this.f = true;
        ++this.g;
    }

    public void b()  throws IOException {
        com.corrodinggames.rts.gameFramework.utility.a.a.h("== testRoot ==");
        com.corrodinggames.rts.gameFramework.utility.a.a.a.listWithDetails(this.c(), this.b);
    }

    public Context c() {
        return com.corrodinggames.rts.appFramework.c.a();
    }

    public boolean a(String string2) {
        boolean bl2 = false;
        if ("mod-info.txt".equals(string2)) {
            bl2 = true;
        }
        if (bl2) {
            return com.corrodinggames.rts.gameFramework.utility.a.a.a.exists(this.c(), this.f(string2));
        }
        c c2 = this.k(string2);
        return c2 != null;
    }

    public AssetInputStream b(String string2) throws FileNotFoundException {
        Uri uri;
        Object object;
        boolean bl2 = false;
        if ("mod-info.txt".equals(string2)) {
            bl2 = true;
        }
        if (!bl2) {
            object = this.k(string2);
            if (object == null) {
                return null;
            }
            uri = ((c)object).b;
        } else {
            uri = this.f(string2);
        }
        if (uri == null) {
            return null;
        }
        try {
            object = com.corrodinggames.rts.gameFramework.utility.a.a.a.read(this.c(), uri);
        }
        catch (FileNotFoundException fileNotFoundException) {
            com.corrodinggames.rts.gameFramework.utility.a.a.j("openAssetSteam: " + fileNotFoundException.getMessage() + " (file: " + string2 + ")");
            return null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            com.corrodinggames.rts.gameFramework.utility.a.a.j("openAssetSteam: " + illegalArgumentException.getMessage() + " (file: " + string2 + ")");
            return null;
        }
        if (object == null) {
            return null;
        }
        AssetInputStream j2 = new AssetInputStream((InputStream)object, this.a + "/" + string2);
        return j2;
    }

    public long c(String string2) throws IOException {
        Uri uri = this.f(string2);
        if (uri == null) {
            com.corrodinggames.rts.gameFramework.utility.a.a.h("getLastModified file missing: " + string2);
            return 0L;
        }
        long l2 = com.corrodinggames.rts.gameFramework.utility.a.a.a.getLastModified(this.c(), uri);
        return l2;
    }

    public long d(String string2) {
        Uri uri = this.f(string2);
        if (uri == null) {
            com.corrodinggames.rts.gameFramework.utility.a.a.h("getEntrySize file missing: " + string2);
            return -1L;
        }
        long l2 = com.corrodinggames.rts.gameFramework.utility.a.a.a.getFileSize(this.c(), uri);
        return l2;
    }

    public OutputStream a(String string2, boolean bl2) {
        String string3;
        Object object;
        com.corrodinggames.rts.gameFramework.utility.a.a.i("writableOutputSteam:" + string2);
        Uri uri = this.f(string2);
        if (uri == null) {
            object = new File(string2);
            string3 = ((File)object).getName();
            Uri uri2 = this.i(string2);
            com.corrodinggames.rts.gameFramework.utility.a.a.i("writableOutputSteam creating: " + string3 + " in " + uri2);
            if (uri2 == null) {
                com.corrodinggames.rts.gameFramework.utility.a.a.j("writableOutputSteam: Parent folder not found for: " + string2);
                return null;
            }
            try {
                uri = com.corrodinggames.rts.gameFramework.utility.a.a.a.createFile(this.c(), uri2, "", string3);
                com.corrodinggames.rts.gameFramework.utility.a.a.i("newFileUri: " + uri);
            }
            catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
                return null;
            }
        }
        try {
            string3 = "w";
            if (bl2) {
                string3 = "wa";
            }
            object = com.corrodinggames.rts.gameFramework.utility.a.a.a.write(this.c(), uri, string3);
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            return null;
        }
        this.a();
        return (OutputStream) object;
    }

    public boolean e(String string2) {
        boolean bl2;
        if (!this.d) {
            com.corrodinggames.rts.gameFramework.utility.a.a.j("deleteFile: Not open as writable");
            return false;
        }
        Uri uri = this.f(string2);
        if (uri == null) {
            com.corrodinggames.rts.gameFramework.utility.a.a.j("deleteFile: fileUri==null for:" + string2);
            return false;
        }
        if (com.corrodinggames.rts.gameFramework.utility.a.a.a.isDirectory(this.c(), uri)) {
            throw new RuntimeException("Attempted to delete folder at: " + string2 + " url:" + uri);
        }
        try {
            bl2 = com.corrodinggames.rts.gameFramework.utility.a.a.a.deleteFile(this.c(), uri);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return false;
        }
        this.a();
        return bl2;
    }

    public boolean a(String string2, String string3) {
        Uri uri;
        if (!this.d) {
            com.corrodinggames.rts.gameFramework.utility.a.a.j("renameFile: Not open as writable");
            return false;
        }
        Uri uri2 = this.f(string2);
        if (uri2 == null) {
            com.corrodinggames.rts.gameFramework.utility.a.a.j("renameFile: fileUri==null for:" + string2);
            return false;
        }
        String string4 = com.corrodinggames.rts.gameFramework.GameUtils.k(string3);
        com.corrodinggames.rts.gameFramework.utility.a.a.i("Rename: " + uri2 + " to " + string4);
        try {
            uri = com.corrodinggames.rts.gameFramework.utility.a.a.a.renameFile(this.c(), uri2, string4);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
        this.a();
        return uri != null;
    }

    public Uri f(String string2) {
        c c2 = this.k(string2);
        if (c2 == null) {
            return null;
        }
        return c2.b;
    }

    public String[] g(String string2) throws IOException {
        c c2 = this.k(string2);
        if (c2 == null) {
            return null;
        }
        if (!c2.c) {
            return null;
        }
        HashMap hashMap = c2.a();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string3 : ((Set<String>)hashMap.keySet()) ){
            arrayList.add(string3);
        }
        return arrayList.toArray(new String[0]);
    }

    public boolean h(String string2) {
        if (string2.equals("/") || string2.equals("")) {
            return true;
        }
        c c2 = this.k(string2);
        if (c2 == null) {
            return false;
        }
        return c2.c;
    }

    public Uri i(String string2) {
        Uri uri;
        File file = new File(string2);
        String string3 = file.getParent();
        if (string3 == null) {
            string3 = "";
        }
        if ((uri = this.f(string3)) == null) {
            com.corrodinggames.rts.gameFramework.utility.a.a.j("createDirectory: Parent folder: " + string3 + " not found");
        }
        return uri;
    }

    public boolean j(String string2) throws FileNotFoundException {
        File file = new File(string2);
        String string3 = file.getName();
        Uri uri = this.i(string2);
        if (uri == null) {
            return false;
        }
        Uri uri2 = com.corrodinggames.rts.gameFramework.utility.a.a.a.createDirectory(this.c(), uri, string3);
        this.a();
        return uri2 != null;
    }

    private c k(String string2) {
        return this.l(string2);
    }

    private c l(String string2) {
        String[] stringArray = string2.split("\\\\|\\/");
        c c2 = this.e;
        for (String string3 : stringArray) {
            HashMap hashMap;
            if (string3.trim().equals("")) continue;
            try {
                hashMap = c2.a();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return null;
            }
            c c3 = (c)hashMap.get(string3);
            if (c3 != null) {
                c2 = c3;
                continue;
            }
            String string4 = string3.toLowerCase(Locale.ROOT);
            c3 = (c)c2.e.get(string4);
            if (c3 != null) {
                c2 = c3;
                continue;
            }
            com.corrodinggames.rts.gameFramework.utility.a.a.i("child null for: " + string2);
            com.corrodinggames.rts.gameFramework.utility.a.a.i("element: " + string3);
            return null;
        }
        return c2;
    }
}

