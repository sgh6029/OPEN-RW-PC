/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bh;
import com.corrodinggames.rts.game.units.custom.bj;
import com.corrodinggames.rts.game.units.custom.bk;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.x;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.al;
import com.corrodinggames.rts.gameFramework.utility.m;
import java.util.ArrayList;
import java.util.List;

public class bi {
    m a;
    public static final bj b = new bj();

    public static bi a(l l2, IniFile ab2, String string2, String string3, bi bi2) throws bo {
        String string4 = ab2.b(string2, string3, (String) null);
        if (string4 == null) {
            return bi2;
        }
        return bi.a(l2, string4, string2, string3, false);
    }

    public static bi a(l l2, String string2, String string3, String string4, boolean bl2) throws bo {
        if (l2 == null) {
            throw new RuntimeException("meta==null");
        }
        return bi.b(l2, string2, string3, string4, bl2);
    }

    public static bi b(l l2, String string2, String string3, String string4, boolean bl2) throws bo {
        int n2;
        bi bi2 = new bi();
        if (string2 == null || "".equals(string2) || "NONE".equalsIgnoreCase(string2)) {
            return bi2;
        }
        if (l2 == null) {
            throw new bo("meta required");
        }
        ArrayList<String> arrayList = al.a(string2, ",", false);
        for (String string5 : arrayList) {
            String[] stringArray;
            if ("".equals(string5 = string5.trim()))
                continue;
            String string6 = string5;
            String string7 = null;
            if (string5.contains("(") && string5.contains(")")) {
                stringArray = string5.split("\\(");
                if (stringArray.length != 2) {
                    throw new bo("[" + string3 + "]" + string4 + " UnitList: Unexpected format for '" + string6
                            + "' of " + string2);
                }
                string5 = stringArray[0];
                string7 = stringArray[1].trim();
            }
            stringArray = string5.split("\\*");
            string5 = stringArray[0];
            int n3 = 1;
            if (stringArray.length >= 2) {
                n3 = Integer.parseInt(stringArray[1]);
            }
            x x2 = l2.b(string5, string4, string3);
            bk bk2 = new bk(x2);
            if (bi2.a == null) {
                bi2.a = new m();
            }
            bk2.b = n3;
            if (string7 != null) {
                String[] stringArray2;
                if (!string7.endsWith(")")) {
                    throw new bo("[" + string3 + "]" + string4 + " UnitList: Expected ')' in '" + string6 + "' of "
                            + string2);
                }
                string7 = string7.substring(0, string7.length() - 1);
                for (String string8 : stringArray2 = string7.split("\\,")) {
                    if (string8.trim().equals(""))
                        continue;
                    String[] stringArray3 = string8.split("\\=");
                    if (stringArray3.length != 2) {
                        throw new RuntimeException("[" + string3 + "]" + string4
                                + " UnitList: Unexpected key format for '" + string6 + "' of " + string2);
                    }
                    String string9 = stringArray3[0].trim();
                    String string10 = stringArray3[1].trim();
                    if (string9.equalsIgnoreCase("spawnChance")) {
                        bk2.c = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("maxSpawnLimit")) {
                        bk2.d = IniFile.i(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("recursionLimit")) {
                        bk2.n = IniFile.i(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetX") || string9.equalsIgnoreCase("xOffsetAbsolute")) {
                        bk2.e = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetY") || string9.equalsIgnoreCase("yOffsetAbsolute")) {
                        bk2.f = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("xOffsetRelative")) {
                        bk2.i = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("yOffsetRelative")) {
                        bk2.j = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetRandomXY")) {
                        float f2;
                        bk2.k = f2 = IniFile.h(string3, string4, string10);
                        bk2.l = f2;
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetRandomX")) {
                        bk2.k = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetRandomY")) {
                        bk2.l = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetHeight")) {
                        bk2.g = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetRandomDir")) {
                        bk2.m = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetDir")) {
                        bk2.h = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    throw new bo("[" + string3 + "]" + string4 + " ProjectileList: Unknown parameter '" + string9
                            + "' for '" + string6 + "' of " + string2);
                }
            }
            bi2.a.add(bk2);
        }
        if (bl2 && (n2 = bi2.a()) > 1) {
            throw new bo(
                    "[" + string3 + "]" + string4 + " Too many units: " + n2 + ", only single unit is allowed here");
        }
        return bi2;
    }

    public int a() {
        if (this.a == null || this.a.size() == 0) {
            return 0;
        }
        int n2 = 0;
        for (bk bk2 : ((List<bk>) this.a)) {
            n2 += bk2.b;
        }
        return n2;
    }

    public void a(float f2, float f3, float f4, float f5, BaseUnit am2, m m2, boolean bl2, int n2, f f6, BaseUnit am3) {
        if (this.a == null || this.a.size() == 0) {
            return;
        }
        int n3 = 0;
        int n4 = 0;
        if (am2 == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("projectile spawn At: Skipping, source unit required");
            return;
        }
        for (bk bk2 : ((List<bk>) this.a)) {
            bh bh2 = bk2.a.f();
            if (bh2 == null) {
                com.corrodinggames.rts.gameFramework.GameEngine
                        .log("projectile spawn At: Skipping, projectileType==null");
                continue;
            }
            for (int i2 = 0; i2 < bk2.b; ++i2) {
                float f7;
                if (bk2.c < 1.0f
                        && (f7 = com.corrodinggames.rts.gameFramework.GameUtils.a(am2, 0.0f, 1.0f, ++n4)) > bk2.c
                        || n3 >= bk2.d || n2 > bk2.n)
                    continue;
                f7 = f2 + bk2.e;
                float f8 = f3 + bk2.f;
                float f9 = f4 + bk2.g;
                float f10 = f5 + bk2.h;
                if (bk2.m != 0.0f) {
                    f10 += com.corrodinggames.rts.gameFramework.GameUtils.a(am2, -bk2.m, bk2.m, n4 * 4 + 3);
                }
                if (bk2.k != 0.0f) {
                    f7 += com.corrodinggames.rts.gameFramework.GameUtils.a(am2, -bk2.k, bk2.k, n4 * 2 + 1);
                }
                if (bk2.l != 0.0f) {
                    f8 += com.corrodinggames.rts.gameFramework.GameUtils.a(am2, -bk2.l, bk2.l, n4 * 3 + 2);
                }
                if (bk2.i != 0.0f || bk2.j != 0.0f) {
                    float f11 = com.corrodinggames.rts.gameFramework.GameUtils.k(f5);
                    float f12 = com.corrodinggames.rts.gameFramework.GameUtils.j(f5);
                    float f13 = bk2.i;
                    float f14 = bk2.j;
                    f7 += f11 * f14 - f12 * f13;
                    f8 += f12 * f14 + f11 * f13;
                }
                int n5 = -1;
                f f15 = j.a(am2, n5, bh2, f7, f8, f9, f10);
                f15.aD = n2;
                if (f6 != null && am2 != null) {
                    bh2.a(am2, f15, f6.l, f6.n, f6.o, -1.0f);
                }
                this.a(f15, bk2, am2, f6, am3);
                ++n3;
                if (m2 == null)
                    continue;
                m2.add(f15);
            }
        }
    }

    public void a(f f2, bk bk2, BaseUnit am2, f f3, BaseUnit am3) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        bi.b.a = f2;
        bi.b.b = bk2;
        bi.b.c = am2;
        bi.b.d = f3;
        bi.b.e = am3;
        float f4 = f2.posX;
        float f5 = f2.posY;
        float f6 = 100.0f;
        l2.cc.a(f4, f5, f6, null, 0.0f, b);
    }
}
