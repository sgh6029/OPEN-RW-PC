/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.corrodinggames.rts.appFramework.common.SAFInterface$FileRow
 */
package com.corrodinggames.rts.gameFramework.utility.a;

import android.net.Uri;
import android.content.Context;

import com.corrodinggames.rts.appFramework.common.SAFInterface;
import com.corrodinggames.rts.gameFramework.utility.a.a;
import com.corrodinggames.rts.gameFramework.utility.a.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

class c {
    String a;
    Uri b;
    boolean c;
    HashMap d;
    HashMap e;
    boolean f;
    int g;
    final /* synthetic */ b h;

    public c(b b2, String string2, Uri uri, boolean bl2) {
        this.h = b2;
        this.a = string2;
        this.b = uri;
        this.c = bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public HashMap a() throws IOException {
        if (this.d == null || this.f || this.g != this.h.g) {
            c c2 = this;
            synchronized (c2) {
                if (this.d == null || this.f || this.g != this.h.g) {
                    this.a(com.corrodinggames.rts.appFramework.c.a());
                }
            }
        }
        return this.d;
    }

    public void a(Context context) throws IOException {
        HashMap<String, c> hashMap = new HashMap<String, c>();
        HashMap<String, c> hashMap2 = new HashMap<String, c>();
        if (this.c) {
            ArrayList<SAFInterface.FileRow> arrayList = com.corrodinggames.rts.gameFramework.utility.a.a.a.listWithDetails(context, this.b);
            for (SAFInterface.FileRow fileRow : arrayList) {
                String string2 = fileRow.id;
                Uri uri = com.corrodinggames.rts.gameFramework.utility.a.a.a.getChildUri(this.b, string2);
                String string3 = fileRow.name;
                boolean bl2 = fileRow.isDirectory;
                if (string3.contains("/")) {
                    com.corrodinggames.rts.gameFramework.utility.a.a.h("Name contains symbols: " + string3);
                    string3 = string3.replace("/", "_");
                }
                String string4 = this.a + "/" + string3;
                c c2 = new c(this.h, string4, uri, bl2);
                hashMap.put(string3, c2);
                String string5 = string3.toLowerCase(Locale.ROOT);
                if (hashMap2.get(string5) != null) continue;
                hashMap2.put(string5, c2);
            }
        }
        this.d = hashMap;
        this.e = hashMap2;
        this.f = false;
        this.g = this.h.g;
    }
}

