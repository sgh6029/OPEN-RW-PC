/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.storage;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.storage.c;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.File;

public class e
extends c {
    c g;
    c h;
    String i;
    String j;

    public e(c c2, String string2, c c3, String string3) {
        this.g = c2;
        this.i = string2;
        this.h = c3;
        this.j = string3;
    }

    @Override
    public String a() {
        String string2 = this.g.a();
        String string3 = this.h.a();
        if (string2 != null) {
            return string2;
        }
        return string3;
    }

    @Override
    public void a(String string2) {
        this.g.a(string2);
        this.h.a(string2);
    }

    @Override
    public String a(String string2, String string3) {
        return this.s(string2).a(string2, string3);
    }

    @Override
    public boolean b(String string2) {
        return this.s(string2).b(this.q(string2));
    }

    @Override
    public boolean c(String string2) {
        return this.s(string2).c(this.q(string2));
    }

    @Override
    public String d(String string2) {
        return this.s(string2).d(this.q(string2));
    }

    @Override
    public String f(String string2) {
        return this.s(string2).f(this.q(string2));
    }

    @Override
    public String e(String string2) {
        return this.s(string2).e(this.q(string2));
    }

    @Override
    public boolean a(String string2, boolean bl2) {
        c c2 = this.r(string2);
        string2 = this.q(string2);
        if (c2 != null) {
            return c2.a(this.q(string2), bl2);
        }
        boolean bl3 = this.g.a(this.q(string2), bl2);
        if (this.h.a(this.q(string2), bl2)) {
            bl3 = true;
        }
        return bl3;
    }

    @Override
    public boolean g(String string2) {
        return this.s(string2).g(this.q(string2));
    }

    private String q(String string2) {
        if (string2 == null) {
            return null;
        }
        int n2 = string2.indexOf(this.i);
        if (n2 != -1) {
            String string3 = string2.substring(0, n2) + string2.substring(n2 + this.i.length());
            if (string3.contains(this.i) || string3.contains(this.j)) {
                GameEngine.log("fixPath: double tag for: " + string2);
            }
            return string3;
        }
        int n3 = string2.indexOf(this.j);
        if (n3 != -1) {
            String string4 = string2.substring(0, n3) + string2.substring(n3 + this.j.length());
            if (string4.contains(this.i) || string4.contains(this.j)) {
                GameEngine.log("fixPath: double tag for: " + string2);
            }
            return string4;
        }
        return string2;
    }

    private c r(String string2) {
        if (string2 == null) {
            return null;
        }
        if (string2.contains(this.i)) {
            return this.g;
        }
        if (string2.contains(this.j)) {
            return this.h;
        }
        return null;
    }

    private c s(String string2) {
        c c2 = this.r(string2);
        if (c2 != null) {
            return c2;
        }
        return this.g;
    }

    @Override
    public String[] b(String string2, boolean bl2) {
        int n2;
        c c2 = this.r(string2);
        string2 = this.q(string2);
        if (c2 != null) {
            return c2.b(string2, bl2);
        }
        String[] stringArray = this.g.b(string2, bl2);
        String[] stringArray2 = this.h.b(string2, bl2);
        if (stringArray == null && stringArray2 == null) {
            return null;
        }
        if (stringArray == null) {
            stringArray = new String[]{};
        }
        if (stringArray2 == null) {
            stringArray2 = new String[]{};
        }
        String[] stringArray3 = new String[stringArray.length + stringArray2.length];
        for (n2 = 0; n2 < stringArray.length; ++n2) {
            stringArray3[n2] = this.i + stringArray[n2];
        }
        for (n2 = 0; n2 < stringArray2.length; ++n2) {
            stringArray3[n2 + stringArray.length] = this.j + stringArray2[n2];
        }
        return stringArray3;
    }

    @Override
    public AssetInputStream i(String string2) {
        return this.g.i(string2);
    }

    @Override
    public AssetInputStream j(String string2) {
        return this.s(string2).j(this.q(string2));
    }

    @Override
    public String b() {
        return this.g.b();
    }

    @Override
    public File a(String string2, String string3, boolean bl2) {
        return this.s(string2).a(this.q(string2), string3, bl2);
    }

    @Override
    public String m(String string2) {
        return this.s(string2).m(string2);
    }

    @Override
    public String d() {
        String string2 = this.g.d();
        if (this.h.d() != null) {
            string2 = string2 + " and " + this.h.d();
        }
        return string2;
    }

    @Override
    public boolean e() {
        return this.g.e() || this.h.e();
    }

    @Override
    public String o(String string2) {
        if (string2.startsWith("/") && this.i.endsWith("/")) {
            string2 = string2.substring(1);
            return "/" + this.i + string2;
        }
        return this.i + string2;
    }
}

