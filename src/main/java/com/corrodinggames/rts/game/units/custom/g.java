/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public final class g {
    final String a;
    public static ArrayList b = new ArrayList();
    public static final g[] c = new g[0];
    public static final h d = new h(c);

    private g(String string2) {
        this.a = string2;
    }

    public String toString() {
        return this.a;
    }

    public static h a(String string2) {
        return g.a(string2, null);
    }

    public static h a(String string2, h h2) {
        if (string2 == null) {
            return h2;
        }
        if (string2.trim().equals("")) {
            return h2;
        }
        ArrayList<g> arrayList = new ArrayList<g>();
        for (String string3 : string2.split(",")) {
            g g2;
            if ((string3 = string3.trim()).equals("") || arrayList.contains(g2 = g.c(string3))) continue;
            arrayList.add(g2);
        }
        if (arrayList.size() == 0) {
            return h2;
        }
        h h3 = new h(arrayList.toArray(new g[0]));
        return h3;
    }

    public static g b(String string2) throws bo {
        if ((string2 = string2.trim()).contains(",")) {
            throw new bo("Expected single tag, got:" + string2);
        }
        return g.c(string2);
    }

    public static g c(String string2) {
        string2 = string2.trim();
        string2 = string2.toLowerCase(Locale.ROOT);
        for (g g2 : ((ArrayList<g>)b)) {
            if (!g2.a.equals(string2)) continue;
            return g2;
        }
        g g3 = new g(string2);
        b.add(g3);
        return g3;
    }

    public static void a(h h2, GameOutputStream as2) throws IOException {
        if (h2 == null) {
            as2.b((String)null);
        } else if (h2.a.length == 0) {
            as2.b("");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl2 = true;
            for (g g2 : h2.a) {
                if (!bl2) {
                    stringBuilder.append(",");
                }
                bl2 = false;
                stringBuilder.append(g2.a);
            }
            as2.b(stringBuilder.toString());
        }
    }

    public static h a(GameInputStream k2) throws IOException {
        String string2 = k2.j();
        if (string2 == null) {
            return null;
        }
        h h2 = g.a(string2, d);
        return h2;
    }

    public static boolean a(h h2, h h3) {
        if (h3 == null) {
            return false;
        }
        g[] gArray = h2.a;
        int n2 = gArray.length;
        g[] gArray2 = h3.a;
        int n3 = gArray2.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                if (gArray[i2] != gArray2[i3]) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean a(g g2, h h2) {
        if (h2 == null) {
            return false;
        }
        g[] gArray = h2.a;
        int n2 = gArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (gArray[i2] != g2) continue;
            return true;
        }
        return false;
    }

    public static boolean b(h h2, h h3) {
        if (h3 == null) {
            return h2 == null || h2.b() == 0;
        }
        g[] gArray = h2.a;
        int n2 = gArray.length;
        g[] gArray2 = h3.a;
        int n3 = gArray2.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            boolean bl2 = false;
            for (int i3 = 0; i3 < n3; ++i3) {
                if (gArray[i2] != gArray2[i3]) continue;
                bl2 = true;
                break;
            }
            if (bl2) continue;
            return false;
        }
        return true;
    }
}

