/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.bq;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.v;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.al;
import com.corrodinggames.rts.gameFramework.utility.m;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class bp {
    m a;

    public static bp a(String string2, String string3, String string4) throws bo {
        return bp.b(null, string2, string3, string4, false);
    }

    public static bp a(l l2, IniFile ab2, String string2, String string3) throws bo {
        String string4 = ab2.b(string2, string3, (String)null);
        return bp.a(l2, string4, string2, string3, false);
    }

    public static bp b(l l2, IniFile ab2, String string2, String string3) throws bo {
        String string4 = ab2.b(string2, string3, (String)null);
        return bp.a(l2, string4, string2, string3, true);
    }

    public static bp a(l l2, String string2, String string3, String string4, boolean bl2) throws bo {
        if (l2 == null) {
            throw new RuntimeException("meta==null");
        }
        return bp.b(l2, string2, string3, string4, bl2);
    }

    public static bp b(l l2, String string2, String string3, String string4, boolean bl2) throws bo {
        int n2;
        bp bp2 = new bp();
        if (string2 == null || "".equals(string2) || "NONE".equalsIgnoreCase(string2)) {
            return bp2;
        }
        ArrayList<String> arrayList = al.a(string2, ",", false);
        for (String string5 : arrayList) {
            String[] stringArray;
            if ("".equals(string5 = string5.trim())) continue;
            String string6 = string5;
            String string7 = null;
            if (string5.contains("(") && string5.contains(")")) {
                stringArray = al.b(string5, "(");
                if (stringArray == null) {
                    throw new bo("[" + string3 + "]" + string4 + " UnitList: Unexpected format for '" + string6 + "' of " + string2);
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
            v v2 = new v();
            v2.a = string4;
            v2.b = string3;
            v2.c = string5;
            if (l2 != null) {
                l2.p.add(v2);
            } else {
                v2.a();
            }
            bq bq2 = new bq(v2);
            if (bp2.a == null) {
                bp2.a = new m();
            }
            bq2.d = n3;
            if (string7 != null) {
                if (!string7.endsWith(")")) {
                    throw new bo("[" + string3 + "]" + string4 + " UnitList: Expected ')' in '" + string6 + "' of " + string2);
                }
                string7 = string7.substring(0, string7.length() - 1);
                ArrayList<String> arrayList2 = al.a(string7, ",", false, false);
                for (String string8 : arrayList2) {
                    if (string8.trim().equals("")) continue;
                    String[] stringArray2 = al.b(string8, "=");
                    if (stringArray2 == null) {
                        throw new RuntimeException("[" + string3 + "]" + string4 + " UnitList: Unexpected key format for '" + string6 + "' of " + string2);
                    }
                    String string9 = stringArray2[0].trim();
                    String string10 = stringArray2[1].trim();
                    if (string9.equalsIgnoreCase("neutralTeam")) {
                        bq2.e = IniFile.g(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("setToTeamOfLastAttacker")) {
                        bq2.g = IniFile.g(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("aggressiveTeam")) {
                        bq2.f = IniFile.g(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("spawnChance")) {
                        bq2.h = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("maxSpawnLimit")) {
                        bq2.i = IniFile.i(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("techLevel")) {
                        bq2.m = IniFile.i(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("gridAlign")) {
                        bq2.j = IniFile.g(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("skipIfOverlapping")) {
                        bq2.k = IniFile.g(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("falling")) {
                        bq2.l = IniFile.g(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("transportedUnitsToTransfer")) {
                        bq2.w = (short)IniFile.i(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("alwaysStartDirAtZero")) {
                        bq2.n = IniFile.g(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("alwayStartDirAtZero")) {
                        bq2.n = IniFile.g(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetX")) {
                        bq2.o = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetY")) {
                        bq2.p = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetRandomXY")) {
                        float f2;
                        bq2.s = f2 = IniFile.h(string3, string4, string10);
                        bq2.t = f2;
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetRandomX")) {
                        bq2.s = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetRandomY")) {
                        bq2.t = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetHeight")) {
                        bq2.q = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetRandomDir")) {
                        bq2.u = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("offsetDir")) {
                        bq2.r = IniFile.h(string3, string4, string10);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("addResources")) {
                        if (l2 == null) {
                            throw new bo("[" + string3 + "]" + string4 + " addResources not supported from here");
                        }
                        try {
                            bq2.v = b.b(l2, string10);
                            continue;
                        }
                        catch (bo bo2) {
                            bo2.printStackTrace();
                            throw new bo("[" + string3 + "]" + string4 + " addResources:" + bo2.getMessage());
                        }
                    }
                    if (string9.equalsIgnoreCase("spawnSource")) {
                        bq2.b = IniFile.a(string10, l2, string3, string4, null);
                        continue;
                    }
                    if (string9.equalsIgnoreCase("copyWaypointsFrom")) {
                        bq2.c = IniFile.a(string10, l2, string3, string4, null);
                        continue;
                    }
                    throw new bo("[" + string3 + "]" + string4 + " UnitList: Unknown parameter '" + string9 + "' for '" + string6 + "' of " + string2);
                }
                if (bq2.g && bq2.e) {
                    throw new bo("[" + string3 + "]" + string4 + " Cannot set setToTeamOfLastAttacker and neutralTeam at same time in " + string2);
                }
                if (bq2.f && bq2.e) {
                    throw new bo("[" + string3 + "]" + string4 + " Cannot set aggressiveTeam and neutralTeam at same time in " + string2);
                }
                if (bq2.f && bq2.g) {
                    throw new bo("[" + string3 + "]" + string4 + " Cannot set aggressiveTeam and setToTeamOfLastAttacker at same time in " + string2);
                }
            }
            bp2.a.add(bq2);
        }
        if (bl2 && (n2 = bp2.a()) > 1) {
            throw new bo("[" + string3 + "]" + string4 + " Too many units: " + n2 + ", only single unit is allowed here");
        }
        return bp2;
    }

    public int a() {
        if (this.a == null || this.a.size() == 0) {
            return 0;
        }
        int n2 = 0;
        for (bq bq2 : ((List<bq>)this.a) ){
            n2 += bq2.d;
        }
        return n2;
    }

    public boolean b() {
        return this.a == null || this.a.size() == 0;
    }

    public void a(m m2, PlayerTeam n2, BaseUnit am2, boolean bl2) {
        this.a(0.0f, 0.0f, 0.0f, 0.0f, n2, false, am2, m2, bl2);
    }

    public void a(float f2, float f3, float f4, float f5, PlayerTeam n2, boolean bl2, BaseUnit am2) {
        this.a(f2, f3, f4, f5, n2, bl2, am2, null, false);
    }

    public void a(float f2, float f3, float f4, float f5, PlayerTeam n2, boolean bl2, BaseUnit am2, m m2, boolean bl3) {
        if (this.a == null || this.a.size() == 0) {
            return;
        }
        boolean bl4 = false;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        int n3 = 0;
        int n4 = 0;
        for (bq bq2 :((List<bq>) this.a) ){
            Object object;
            PlayerTeam n5 = n2;
            Object object2 = am2;
            float f6 = f2;
            float f7 = f3;
            float f8 = f4;
            float f9 = f5;
            if (bq2.b != null) {
                if (!(object2 instanceof y)) {
                    com.corrodinggames.rts.gameFramework.GameEngine.b("spawnUnitsAt: sourceUnit!=OrderableUnit is:" + BaseUnit.A((BaseUnit)object2));
                    continue;
                }
                object = bq2.b.readUnit((y)am2);
                if (object == null) {
                    com.corrodinggames.rts.gameFramework.GameEngine.b("spawnUnitsAt: spawnSource==null");
                    continue;
                }
                n5 = ((BaseUnit)object).bX;
                object2 = object;
                f6 = ((BaseUnit)object).posX;
                f7 = ((BaseUnit)object).posY;
                f8 = ((BaseUnit)object).posZ;
                f9 = ((BaseUnit)object).cg;
                if (n5 == null) {
                    com.corrodinggames.rts.gameFramework.GameEngine.b("spawnUnitsAt: newSpawnSource.team==null");
                    continue;
                }
            }
            if (!bl3) {
                if (n5.w() > n5.x() + 300) {
                    bl4 = true;
                }
            } else if (n5.a(true, false) > n5.x() + 20000) {
                bl4 = true;
            }
            if (bl4) {
                object = "";
                if (object2 != null) {
                    object = (String)object + "source:" + ((BaseUnit)object2).cB();
                }
                com.corrodinggames.rts.gameFramework.GameEngine.b("spawnUnitsAt: Skipping, too many units already on team:" + n5.k + " count:" + n5.w() + " " + (String)object);
                if (!com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bl) continue;
                n5.W();
                continue;
            }
            if (n5.s() > n5.x() + 25000) {
                object = "";
                if (object2 != null) {
                    object = (String)object + "source:" + ((BaseUnit)object2).cB();
                }
                com.corrodinggames.rts.gameFramework.GameEngine.b("spawnUnitsAt: Failsafe, too many units already on team (including ignored):" + n5.k + " total count:" + n5.s() + " " + (String)object);
                if (!com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bl) continue;
                n5.W();
                continue;
            }
            object = bq2.a.c();
            if (object == null) continue;
            for (int i2 = 0; i2 < bq2.d; ++i2) {
                BaseUnit am3;
                float f10;
                PlayerTeam n6 = n5;
                if (bq2.h < 1.0f && (f10 = GameUtils.a((BaseUnit)object2, 0.0f, 1.0f, ++n4)) > bq2.h) continue;
                if (bq2.g) {
                    if (object2 == null || ((BaseUnit)object2).bt == null) continue;
                    n6 = ((BaseUnit)object2).bt.bX;
                    if (n6 == null) {
                        throw new RuntimeException("setToTeamOfLastAttacker targetTeam==null");
                    }
                }
                if (n3 >= bq2.i) continue;
                BaseUnit am4 = ((UnitType) object).createUnitInstance();
                if (bq2.e) {
                    n6 = PlayerTeam.i;
                }
                if (bq2.f) {
                    n6 = PlayerTeam.h;
                }
                if (n6 == null) {
                    throw new RuntimeException("Team==null");
                }
                am4.f(n6);
                am4.B((BaseUnit)object2);
                am4.posX = f6;
                am4.posY = f7;
                am4.posZ = f8;
                if (!am4.bI() && !bq2.n) {
                    am4.cg = f9;
                }
                am4.posZ += bq2.q;
                if (bq2.m != -1 && am4 instanceof y) {
                    ((y)am4).a(bq2.m);
                }
                float f11 = bq2.r;
                if (bq2.u != 0.0f) {
                    f11 += GameUtils.a((BaseUnit)object2, -bq2.u, bq2.u, n4 * 4 + 3);
                }
                if (f11 != 0.0f) {
                    if (am4 instanceof y) {
                        ((y)am4).i(f11);
                    } else {
                        am4.cg += f11;
                    }
                }
                am4.posX += (float)i2;
                if (bq2.s != 0.0f) {
                    am4.posX += GameUtils.a((BaseUnit)object2, -bq2.s, bq2.s, n4 * 2 + 1);
                }
                if (bq2.t != 0.0f) {
                    am4.posY += GameUtils.a((BaseUnit)object2, -bq2.t, bq2.t, n4 * 3 + 2);
                }
                if (bq2.j) {
                    l2.bL.b(am4.posX, am4.posY);
                    am4.posX = l2.bL.T;
                    am4.posY = l2.bL.U;
                    am4.posX += am4.cZ();
                    am4.posY += am4.da();
                }
                am4.posX += bq2.o;
                am4.posY += bq2.p;
                ++n3;
                if (bq2.k && am4 instanceof y && !((y)am4).c((PlayerTeam)null)) {
                    am4.ci();
                    continue;
                }
                if (bq2.l && am4 instanceof y) {
                    am4.dc();
                }
                if (bq2.v != null) {
                    bq2.v.h(am4);
                }
                if (bq2.w > 0 && object2 != null && object2 instanceof j) {
                    am3 = (j)object2;
                    if (((j)am3).B != null) {
                        for (int i3 = bq2.w; i3 > 0; --i3) {
                            BaseUnit am5;
                            int n7 = -1;
                            for (int i4 = ((j)am3).B.size() - 1; i4 >= 0; --i4) {
                                am5 = (BaseUnit)((j)am3).B.get(i4);
                                if (!am4.c(am5, true)) continue;
                                n7 = i4;
                                break;
                            }
                            if (n7 == -1) break;
                            BaseUnit am6 = (BaseUnit)((j)am3).B.remove(n7);
                            com.corrodinggames.rts.gameFramework.utility.y.a(am6, (y)am3);
                            ((j)am3).D(am6);
                            am6.posX = am4.posX;
                            am6.posY = am4.posY;
                            am6.cg = am4.cg;
                            if (am6 instanceof y) {
                                am5 = (y)am6;
                                ((y)am5).az();
                            }
                            if (am4.e(am6, true)) continue;
                            com.corrodinggames.rts.gameFramework.GameEngine.b("transportedUnitsToTransfer failed for: " + am6.cB() + " to: " + am4.cB());
                            am6.ci();
                        }
                    }
                }
                PlayerTeam.c(am4);
                if (am4.bI() && am4 instanceof y) {
                    l2.bU.a((y)am4);
                }
                if (bl2 && !am4.u()) {
                    com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bS.k(am4);
                }
                if (bq2.c != null) {
                    if (!(am4 instanceof y)) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("copyWaypointsFrom: spawnedUnit!=OrderableUnit is:" + BaseUnit.A((BaseUnit)object2));
                    } else {
                        am3 = bq2.c.readUnit((y)am2);
                        if (am3 != null) {
                            if (!(am3 instanceof y)) {
                                com.corrodinggames.rts.gameFramework.GameEngine.b("copyWaypointsFrom: copyWaypointsFrom!=OrderableUnit is:" + BaseUnit.A((BaseUnit)object2));
                            } else {
                                y.a((y)am3, (y)am4);
                            }
                        }
                    }
                }
                if (m2 == null) continue;
                m2.add(am4);
            }
        }
    }

    @Deprecated
    public static bp a(GameInputStream k2, boolean bl2)  throws IOException {
        int n2 = k2.readInt();
        if (bl2 && n2 == 0) {
            return null;
        }
        bp bp2 = new bp();
        for (int i2 = 0; i2 < n2; ++i2) {
            boolean bl3;
            bq bq2 = new bq(null);
            UnitType as2 = k2.q();
            if (as2 != null) {
                if (bp2.a == null) {
                    bp2.a = new m();
                }
                bq2.a = l.a(as2);
            }
            if (k2.b() >= 75 && (bl3 = k2.e())) {
                bq2.d = k2.readInt();
                bq2.e = k2.e();
                bq2.g = k2.e();
                if (k2.b() >= 76) {
                    bq2.h = k2.g();
                }
            }
            if (as2 == null) continue;
            bp2.a.add(bq2);
        }
        return bp2;
    }
}

