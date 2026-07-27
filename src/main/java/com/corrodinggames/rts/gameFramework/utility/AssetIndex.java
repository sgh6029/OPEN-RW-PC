/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.i$1;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class AssetIndex {
    private ArrayList c;
    public Context a;
    boolean b = true;

    public AssetIndex(Context context) {
        this.a = context;
        this.a();
    }

    public void a() {
        i$1 i$1 = new i$1(this);
        i$1.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void b() {
        AssetIndex i2 = this;
        synchronized (i2) {
            if (this.c != null) {
                return;
            }
            AssetManager assetManager = this.a.d();
            ArrayList arrayList = new ArrayList();
            try {
                GameEngine.log("------- createIndex -------");
                arrayList.addAll(this.a(assetManager, "", 1));
            } catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
            this.c = arrayList;
        }
    }

    public ArrayList a(AssetManager assetManager, String string2, int n2) throws IOException{
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = assetManager.c(string2);
        if (string2.length() > 0) {
            string2 = string2 + "/";
        }
        if (n2 > 140) {
            throw new RuntimeException("dirLevel>140 for: " + string2);
        }
        GameEngine.log("c:" + string2);
        for (String string3 : stringArray) {
            String string4 = string2 + string3;
            boolean bl2 = false;
            if (!string3.contains(".")) {
                bl2 = true;
            }
            if (string3.equals(".") || string3.equals("..") || string3.equals(""))
                continue;
            arrayList.add(string4);
            if (!bl2)
                continue;
            arrayList.addAll(this.a(assetManager, string4, n2 + 1));
        }
        return arrayList;
    }

    public ArrayList c() {
        if (this.c != null) {
            if (this.b) {
                GameEngine.log("assetIndex: getFile was not blocked on load");
                this.b = false;
            }
            return this.c;
        }
        long l2 = GameEngine.V();
        this.b();
        if (this.b) {
            GameEngine.log("assetIndex: getFile is BLOCKED on load");
            this.b = false;
        }
        return this.c;
    }

    public boolean a(String string2) {
        if (string2.endsWith(File.separator)) {
            string2 = string2.substring(0, string2.length() - 1);
        }
        string2 = string2.replace("//", "/");
        for (String string3 : ((ArrayList<String>) this.c())) {
            if (!string3.equals(string2))
                continue;
            return true;
        }
        return false;
    }

    public String[] b(String string2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String string3 = string2;
        if (string3.endsWith(File.separator)) {
            string3 = string3.substring(0, string3.length() - 1);
        }
        int n2 = 0;
        for (String string4 : ((ArrayList<String>) this.c())) {
            String string5;
            if (!string4.startsWith(string3) || (string5 = string4.substring(string3.length())).length() == 0
                    || string5.charAt(0) != File.separatorChar || string5.indexOf(File.separator, 1) != -1)
                continue;
            ++n2;
            String string6 = string4.substring((string3 + "/").length());
            arrayList.add(string6);
        }
        return arrayList.toArray(new String[0]);
    }
}
