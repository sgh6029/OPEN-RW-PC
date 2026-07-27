/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import java.util.ArrayList;
import java.util.List;

public class bl {
    ArrayList a = new ArrayList();
    int b;

    public void a(float f2) {
        for (bm bm2 : ((List<bm>)this.a)) {
            bm2.b = f2;
        }
    }

    public boolean a() {
        return this.a(0.0f, 0.0f, 1.0f, true);
    }

    public boolean a(float f2, float f3, float f4) {
        return this.a(f2, f3, f4, false);
    }

    public boolean a(float f2, float f3, float f4, boolean bl2) {
        if (this.a.size() == 0) {
            return false;
        }
        if (this.b >= this.a.size()) {
            this.b = 0;
        }
        bm bm2 = (bm)this.a.get(this.b);
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (bl2) {
            l2.bM.c(bm2.a, bm2.b);
        } else {
            l2.bM.a(bm2.a, bm2.b, f2, f3);
        }
        ++this.b;
        return true;
    }

    public static bl a(l l2, String string2) {
        return bl.a(l2, string2, null);
    }

    public static bl a(l l2, String string2, bl bl2) {
        if ((string2 == null || string2.equals("")) && bl2 != null) {
            return bl2;
        }
        bl bl3 = new bl(l2, string2);
        return bl3;
    }

    public bl() {
    }

    public bl(l l2, String string2) {
        String[] stringArray;
        if (string2 == null || string2.equals("") || string2.equalsIgnoreCase("NONE")) {
            return;
        }
        for (String string3 : stringArray = string2.split(",")) {
            bm bm2 = new bm(this);
            string3 = string3.trim();
            String string4 = "";
            if (string3.startsWith("ROOT:")) {
                string3 = string3.substring("ROOT:".length());
                string4 = string4 + "ROOT:";
            }
            if (string3.startsWith("SHARED:")) {
                string3 = string3.substring("SHARED:".length());
                string4 = string4 + "SHARED:";
            }
            String[] stringArray2 = string3.split(":");
            String string5 = null;
            String string6 = stringArray2[0].trim();
            if (stringArray2.length != 1) {
                if (stringArray2.length == 2) {
                    string5 = stringArray2[1].trim();
                } else {
                    throw new RuntimeException("Unknown sound format:" + string3);
                }
            }
            if (string5 != null) {
                try {
                    bm2.b = Float.parseFloat(string5);
                }
                catch (NumberFormatException numberFormatException) {
                    throw new RuntimeException("Failed to parse volume float: '" + string5 + "' of sound: '" + string3 + "'");
                }
            }
            string6 = string4 + string6;
            bm2.a = ag.a(l2.F, string6, l2);
            if (bm2.a == null) continue;
            this.a.add(bm2);
        }
    }
}

