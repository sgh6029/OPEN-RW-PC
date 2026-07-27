/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.storage;

import com.corrodinggames.rts.gameFramework.storage.c;

public class d
extends c {
    String g;
    String h;
    String i;

    public d(String string2, String string3) {
        this.g = string2;
        this.h = string3;
        if (!this.g.endsWith("/") && !this.g.endsWith("\\")) {
            this.g = this.g + "/";
        }
    }

    @Override
    public String b() {
        return this.g;
    }

    @Override
    public String d() {
        return this.h;
    }

    @Override
    public boolean e() {
        return false;
    }

    @Override
    public String e(String string2) {
        String string3 = super.e(string2);
        if (this.i != null && string3 != null && string3.startsWith(this.g)) {
            if ((string3 = string3.substring(this.g.length())).startsWith("/") || string3.startsWith("\\")) {
                string3 = string3.substring(1);
            }
            string3 = this.i + string3;
        }
        return string3;
    }
}

