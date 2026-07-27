/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.custom.a.d;
import com.corrodinggames.rts.game.units.custom.a.a.m;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference$UnitReferenceOrUnitType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.ac;
import com.corrodinggames.rts.gameFramework.utility.al;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

public class ag {
    static boolean a = false;
    static int b;
    static int c;
    public static int d;
    static com.corrodinggames.rts.gameFramework.i.b e;
    static boolean f;
    public static HashMap g;
    public static HashMap h;
    static int i;
    static int j;
    static boolean k;
    static int l;
    public static com.corrodinggames.rts.gameFramework.utility.m m;
    static HashMap n;
    static final Object o;
    public static float p;
    public static float q;
    static com.corrodinggames.rts.gameFramework.i.b r;
    static String s;

    public static void a(int n2) {
        if (e != null) {
            ag.e.G += (long) n2;
        }
    }

    public static void a() {
        ag.i();
        ag.j();
    }

    public static void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2) {
        if (e2 != null && !e2.v) {
            if (com.corrodinggames.rts.gameFramework.GameEngine.az()
                    && e2 instanceof com.corrodinggames.rts.gameFramework.m.TeamColorTexture) {
                return;
            }
            e2.v = true;
            ag.a(e2.u());
        }
    }

    public static void a(com.corrodinggames.rts.gameFramework.m.Texture_M[] eArray) {
        if (eArray != null) {
            com.corrodinggames.rts.gameFramework.m.Texture_M e2 = null;
            for (com.corrodinggames.rts.gameFramework.m.Texture_M e3 : eArray) {
                if (e3 != e2) {
                    ag.a(e3);
                }
                if (e2 != null)
                    continue;
                e2 = e3;
            }
        }
    }

    public static void a(com.corrodinggames.rts.gameFramework.sound.i i2) {
        if (!i2.g) {
            i2.g = true;
            if (e != null) {
                ag.e.H += (long) i2.a();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean a(com.corrodinggames.rts.gameFramework.utility.m m2) throws IOException {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        ArrayList arrayList = new ArrayList(com.corrodinggames.rts.game.units.custom.l.c);
        ArrayList arrayList2 = new ArrayList(com.corrodinggames.rts.game.units.custom.l.d);
        com.corrodinggames.rts.gameFramework.utility.m m3 = new com.corrodinggames.rts.gameFramework.utility.m();
        String string2 = null;
        for (com.corrodinggames.rts.game.units.custom.l l3 : ((List<com.corrodinggames.rts.game.units.custom.l>) m2)) {
            com.corrodinggames.rts.game.units.custom.l l4 = ag.a(l3);
            if (l4 == null) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Failed to apply changes to unit type: " + l3.M);
                bl2 = true;
                if (string2 != null || s == null)
                    continue;
                string2 = s;
                continue;
            }
            com.corrodinggames.rts.gameFramework.GameEngine.log("Changes applied to unit type: " + l3.M);
            bl3 = true;
            m3.add(l4);
        }
        if (string2 != null && com.corrodinggames.rts.gameFramework.GameEngine.at()) {
            l2.c("Unit errors", string2);
        }
        if (bl3 && !ag.c(false)) {
            bl2 = true;
        }
        if (bl3 && !bl2) {
            com.corrodinggames.rts.game.units.custom.l.e = null;
            ag.e();
            s = null;
            com.corrodinggames.rts.game.PlayerTeam.P();
            com.corrodinggames.rts.gameFramework.f.g.K();
            bl4 = true;
            if (!bl2) {
                for (com.corrodinggames.rts.game.units.custom.l l3 : ((List<com.corrodinggames.rts.game.units.custom.l>) m3)) {
                    if (l3.gt.size() <= 0)
                        continue;
                    l2.a(l3.gt.size() + " Warning(s) loading: " + l3.b() + " \n" + (String) l3.gt.get(0), 1);
                    l3.gt.clear();
                    bl4 = false;
                    break;
                }
            }
        }
        if (bl2) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Failed to load some units, keeping old config");
            ArrayList arrayList3 = com.corrodinggames.rts.game.units.custom.l.c;
            synchronized (arrayList3) {
                com.corrodinggames.rts.game.units.custom.l.c.clear();
                com.corrodinggames.rts.game.units.custom.l.c.addAll(arrayList);
            }
            com.corrodinggames.rts.game.units.custom.l.d = arrayList2;
        }
        return bl4;
    }

    public static void b() throws IOException {
        com.corrodinggames.rts.gameFramework.utility.m m2 = new com.corrodinggames.rts.gameFramework.utility.m();
        b = 0;
        c = 0;
        d = 0;
        for (BaseUnit am2 : ((List<BaseUnit>) BaseUnit.bF())) {
            com.corrodinggames.rts.game.units.UnitType as2 = am2.r();
            if (!(as2 instanceof com.corrodinggames.rts.game.units.custom.l) || m2.contains(as2))
                continue;
            m2.add((com.corrodinggames.rts.game.units.custom.l) as2);
        }
        if (m2.size() > 0) {
            boolean bl2 = ag.a(m2);
        }
    }

    public static void c() throws IOException {
        boolean bl2 = false;
        com.corrodinggames.rts.gameFramework.utility.m m2 = new com.corrodinggames.rts.gameFramework.utility.m();
        for (com.corrodinggames.rts.game.units.custom.l l2 : ((List<com.corrodinggames.rts.game.units.custom.l>) com.corrodinggames.rts.game.units.custom.l.c)) {
            boolean bl3 = false;
            for (aa aa2 : ((List<aa>) l2.k)) {
                long l3 = aa2.a(false);
                if (l3 == aa2.a)
                    continue;
                bl3 = true;
                aa2.a = l3;
            }
            if (!bl3)
                continue;
            if (!bl2) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Detected unit changes");
                bl2 = true;
            }
            m2.add(l2);
        }
        if (m2.size() > 0) {
            ag.a(m2);
        }
    }

    public static void d() {
        if (com.corrodinggames.rts.game.units.custom.l.e != null) {
            com.corrodinggames.rts.gameFramework.GameEngine
                    .log("applyPendingNetworkUnits: Applying new network units from server ("
                            + com.corrodinggames.rts.game.units.custom.l.e.size() + " units)");
            com.corrodinggames.rts.game.units.custom.l.d = com.corrodinggames.rts.game.units.custom.l.e;
            com.corrodinggames.rts.game.units.custom.l.e = null;
            ag.e();
        } else {
            com.corrodinggames.rts.gameFramework.GameEngine.log("applyPendingNetworkUnits: no server units list found");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ArrayList a(boolean bl2) {
        ArrayList<com.corrodinggames.rts.game.units.custom.l> arrayList = new ArrayList<com.corrodinggames.rts.game.units.custom.l>();
        ArrayList arrayList2 = com.corrodinggames.rts.game.units.custom.l.c;
        synchronized (arrayList2) {
            for (com.corrodinggames.rts.game.units.custom.l l2 : ((List<com.corrodinggames.rts.game.units.custom.l>) com.corrodinggames.rts.game.units.custom.l.c)) {
                if (l2.J != null && (!l2.J.m() || !bl2))
                    continue;
                arrayList.add(l2);
            }
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static com.corrodinggames.rts.gameFramework.utility.IniFile a(String string2)
            throws IOException {
        HashMap hashMap = n;
        synchronized (hashMap) {
            com.corrodinggames.rts.gameFramework.utility.IniFile ab2;
            com.corrodinggames.rts.gameFramework.utility.IniFile ab3 = (com.corrodinggames.rts.gameFramework.utility.IniFile) n
                    .get(string2);
            if (ab3 != null) {
                return ab3;
            }
            com.corrodinggames.rts.gameFramework.utility.AssetInputStream j2 = ag.b(string2);
            if (j2 == null) {
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(j2);
            ab2 = new com.corrodinggames.rts.gameFramework.utility.IniFile(bufferedInputStream, string2);
            ab2.a();
            ab2.f = j2.d();
            n.put(string2, ab2);
            return ab2;
        }
    }

    public static void a(com.corrodinggames.rts.game.units.custom.l l2,
            com.corrodinggames.rts.gameFramework.utility.IniFile ab2, String string2, String string3, boolean bl2)
            throws bo, IOException {
        com.corrodinggames.rts.gameFramework.utility.IniFile ab3 = ag.a(string2);
        if (ab3 == null) {
            if (bl2) {
                return;
            }
            throw new bo("[" + string3 + "] Could not find conf target:" + string2);
        }
        l2.o(ab3.f);
        ab2.a(ab3);
        ag.a(l2, ab2, ab3, string2, 1);
    }

    public static void a(com.corrodinggames.rts.game.units.custom.l l2,
            com.corrodinggames.rts.gameFramework.utility.IniFile ab2, com.corrodinggames.rts.gameFramework.utility.IniFile ab3,
            String string2, int n2) throws bo, IOException {
        if (n2 > 10) {
            throw new bo("copyFrom can only be 10 levels deep, maybe you have a loop?");
        }
        String string3 = ab3.b("core", "copyFrom", (String) null);
        if (string3 != null) {
            String[] stringArray = string3.split(",");
            Collections.reverse(Arrays.asList(stringArray));
            for (String string4 : stringArray) {
                String string5;
                Object object;
                if ((string4 = string4.trim()).equals(""))
                    continue;
                if (string4.contains("..")) {
                    throw new bo("'..' not supported in copyFrom");
                }
                if (string4.startsWith("ROOT:")) {
                    string4 = string4.substring("ROOT:".length());
                    object = l2.J == null ? "units/common.ini" : l2.J.q + "/common.ini";
                    string5 = ag.a(com.corrodinggames.rts.gameFramework.GameUtils.h((String) object), string4);
                } else if (string4.startsWith("CORE:")) {
                    string4 = string4.substring("CORE:".length());
                    object = "units/common.ini";
                    string5 = ag.a(com.corrodinggames.rts.gameFramework.GameUtils.h((String) object), string4);
                } else {
                    string5 = ag.a(com.corrodinggames.rts.gameFramework.GameUtils.h(string2), string4);
                }
                object = ag.a(string5);
                if (object == null) {
                    String string6 = "Could not find copyFrom target:" + string5;
                    if (n2 != 0) {
                        string6 = string6 + " (while loading: " + string2 + ")";
                    }
                    throw new bo(string6);
                }
                l2.o(((com.corrodinggames.rts.gameFramework.utility.IniFile) object).f);
                ab2.a((com.corrodinggames.rts.gameFramework.utility.IniFile) object);
                ag.a(l2, ab2, (com.corrodinggames.rts.gameFramework.utility.IniFile) object, string5, n2 + 1);
            }
        }
    }

    public static void a(com.corrodinggames.rts.game.units.custom.l l2,
            com.corrodinggames.rts.gameFramework.utility.IniFile ab2, String string2, String string3, int n2) throws bo {
        if (n2 > 10) {
            throw new bo("@copyFromSection can only be 10 levels deep, maybe you have a loop?");
        }
        String string4 = ab2.b(string3, "@copyFromSection", (String) null);
        if (string4 == null || string4.equals("")) {
            return;
        }
        String[] stringArray = string4.split(",");
        Collections.reverse(Arrays.asList(stringArray));
        for (String string5 : stringArray) {
            if ((string5 = string5.trim()).equals(""))
                continue;
            com.corrodinggames.rts.gameFramework.utility.m m2 = ab2.k(string5, "");
            if (m2.size() == 0) {
                throw new bo("[" + string3 + "]@copyFromSection: Could not find keys in target section: " + string5);
            }
            for (String string6 : ((List<String>) m2)) {
                String string7 = ab2.b(string5, string6);
                if (string7 == null)
                    continue;
                ab2.d(string2, string6, string7);
            }
            ag.a(l2, ab2, string2, string5, n2 + 1);
        }
    }

    public static bb a(com.corrodinggames.rts.gameFramework.utility.IniFile ab2, String string2, String string3,
            String string4) {
        return ab2.a(string2, string3, string4, false);
    }

    public static aj a(com.corrodinggames.rts.game.units.custom.l l2,
            com.corrodinggames.rts.gameFramework.utility.IniFile ab2, String string2, String string3, String string4)
            throws bo {
        return ab2.a(l2, string2, string3, string4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */ 
    public static com.corrodinggames.rts.game.units.custom.l a(final com.corrodinggames.rts.game.units.custom.l l) throws IOException {
        final String d = l.D;
        final GameEngine b = GameEngine.getInstance();
        com.corrodinggames.rts.game.units.custom.l a = null;
        String r = null;
        if (l.J != null) {
            r = l.J.R;
        }
        synchronized (ag.n) {
            ag.n.clear();
        }
        ag.s = null;
        try {
            a = a(d, l.J, l.K, l.L);
        }
        catch (final RuntimeException ex) {
            ex.printStackTrace();
            if (ag.s == null) {
                b.a("Error loading unit:" + a(l.J, d, true) + "\n" + ex.getMessage(), 1);
            }
        }
        if (a == null && l.J != null) {
            l.J.R = r;
        }
        if (a != null) {
            synchronized (l.c) {
                l.c.remove(l);
            }
            a((com.corrodinggames.rts.game.units.UnitType)l, a, true);
            if (l.d.remove(l)) {
                l.d.add(a);
                if (l.H != a.H) {
                    ++ag.d;
                }
            }
            else {
                l.e("Changed unit was not enabled (original not found in customUnitTypes)");
            }
            com.corrodinggames.rts.game.PlayerTeam.P();
            com.corrodinggames.rts.gameFramework.f.g.K();
        }
        return a;
    }
  
    public static void a(com.corrodinggames.rts.game.units.UnitType as2, com.corrodinggames.rts.game.units.custom.l l2,
            boolean bl2) {
        for (BaseUnit am2 : ((List<BaseUnit>) BaseUnit.bF())) {
            if (!(am2 instanceof com.corrodinggames.rts.game.units.custom.j))
                continue;
            com.corrodinggames.rts.game.units.custom.j j2 = (com.corrodinggames.rts.game.units.custom.j) am2;
            if (j2.x == as2) {
                com.corrodinggames.rts.game.PlayerTeam.b((BaseUnit) j2);
                j2.a(l2, false, bl2);
                j2.S();
                if (j2.dg() != null) {
                    j2.dg().a(l2);
                }
                com.corrodinggames.rts.game.PlayerTeam.c(j2);
            }
            if (j2.z != as2)
                continue;
            j2.z = l2;
        }
    }

    public static String a(ArrayList arrayList) {
        Integer n2;
        HashMap<com.corrodinggames.rts.gameFramework.i.b, Integer> hashMap = new HashMap<com.corrodinggames.rts.gameFramework.i.b, Integer>();
        for (Object object : arrayList) {
            com.corrodinggames.rts.gameFramework.i.b b2 = ((com.corrodinggames.rts.game.units.custom.l) object).J;
            if (b2 == null)
                continue;
            n2 = (Integer) hashMap.get(b2);
            n2 = n2 == null ? Integer.valueOf(1) : Integer.valueOf(n2 + 1);
            hashMap.put(b2, n2);
        }
        String object = "";
        for (com.corrodinggames.rts.gameFramework.i.b b2 : hashMap.keySet()) {
            n2 = (Integer) hashMap.get(b2);
            object = (String) object + b2.a() + "(unitCount: " + n2 + (b2.m() ? "" : "[disabled]") + "), ";
        }
        return object;
    }

    public static String b(boolean bl2) {
        ArrayList arrayList = ag.a(bl2);
        com.corrodinggames.rts.game.units.custom.l.e = null;
        com.corrodinggames.rts.game.units.custom.l.d = arrayList;
        s = null;
        com.corrodinggames.rts.gameFramework.GameEngine
                .log("enableAll: " + ag.a(com.corrodinggames.rts.game.units.custom.l.d));
        ag.e();
        return s;
    }

    public static boolean c(boolean bl2) {
        ArrayList arrayList = com.corrodinggames.rts.game.units.custom.l.d;
        ArrayList arrayList2 = bl2 ? ag.a(true) : com.corrodinggames.rts.game.units.custom.l.d;
        boolean bl3 = true;
        s = null;
        com.corrodinggames.rts.game.units.custom.l.d = arrayList2;
        ag.g();
        if (s != null) {
            bl3 = false;
        }
        com.corrodinggames.rts.game.units.custom.l.d = arrayList;
        ag.g();
        return bl3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void e() {
        Object object = o;
        synchronized (object) {
            ag.n();
        }
    }

    private static void n() {
        com.corrodinggames.rts.game.units.custom.l l2 = null;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        com.corrodinggames.rts.gameFramework.GameEngine l3 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (l3.as()) {
            for (UnitTypeEnum ar2 : UnitTypeEnum.values()) {
                arrayList.add(ar2);
            }
        }
        for (com.corrodinggames.rts.game.units.custom.l l4 : com.corrodinggames.rts.game.units.custom.l.d) {
            arrayList.add(l4);
            if (!l4.M.equals("missing") || l4.J != null)
                continue;
            l2 = l4;
        }
        UnitTypeEnum.ae = arrayList;
        BaseUnit.bL();
        ag.g();
        ag.f();
        com.corrodinggames.rts.game.units.custom.e.a_f3.e();
        if (l2 == null) {
            com.corrodinggames.rts.gameFramework.GameEngine
                    .log("missingPlaceHolder is not an active unit, searching for new target");
            for (com.corrodinggames.rts.game.units.custom.l l5 : com.corrodinggames.rts.game.units.custom.l.d) {
                if (!l5.M.equals("missing"))
                    continue;
                com.corrodinggames.rts.gameFramework.GameEngine.log("Found a missing placeholder");
                l2 = l5;
            }
        }
        com.corrodinggames.rts.game.units.custom.l.b = l2;
    }

    public static void f() {
        float f2 = 50.0f;
        float f3 = 50.0f;
        for (com.corrodinggames.rts.game.units.custom.l l2 : com.corrodinggames.rts.game.units.custom.l.d) {
            float f4 = l2.cW;
            if (f4 > 250.0f) {
                f4 = 250.0f;
            }
            if (f2 < f4) {
                f2 = f4;
            }
            if (!l2.aH || !(f3 < f4))
                continue;
            f3 = f4;
        }
        p = f2;
        q = f3;
    }

    public static com.corrodinggames.rts.gameFramework.utility.AssetInputStream b(String string2) {
        String string3 = "" + string2;
        return com.corrodinggames.rts.gameFramework.storage.a.k(string3);
    }

    public static void b(ArrayList arrayList) {
        Collections.sort(arrayList);
    }

    public static void a(com.corrodinggames.rts.game.units.UnitType unit) {
        try {
            com.corrodinggames.rts.gameFramework.GameEngine framework = com.corrodinggames.rts.gameFramework.GameEngine
                    .getInstance();

            // 初始化单位
            unit.h();

            // 如果是自定义单位
            if (unit instanceof com.corrodinggames.rts.game.units.custom.l) {
                com.corrodinggames.rts.game.units.custom.l customUnit = (com.corrodinggames.rts.game.units.custom.l) unit;

                // 处理升级关系
                if (customUnit.fI != null) {
                    com.corrodinggames.rts.game.units.UnitType upgradedFrom = com.corrodinggames.rts.game.units.custom.l
                            .s(customUnit.fI);
                    if (upgradedFrom == null) {
                        throw new com.corrodinggames.rts.game.units.custom.bo(
                                "Could not find [ai]upgradedFrom target:" + customUnit.fI);
                    }
                    customUnit.b(upgradedFrom);
                }

                // 初始化所有武器
                for (com.corrodinggames.rts.game.units.custom.v weapon : ((List<com.corrodinggames.rts.game.units.custom.v>) customUnit.p)) {
                    weapon.a();
                }

                // 如果是AI单位，添加到全局列表
                if (customUnit.eH) {
                    com.corrodinggames.rts.game.units.custom.l.g.add(customUnit);
                }
            }

            // 处理所有自定义单位的建造关系
            for (com.corrodinggames.rts.game.units.custom.l otherUnit : com.corrodinggames.rts.game.units.custom.l.d) {
                // 检查升级关系
                if (unit instanceof com.corrodinggames.rts.game.units.custom.l) {
                    com.corrodinggames.rts.game.units.custom.l customUnit = (com.corrodinggames.rts.game.units.custom.l) unit;
                    if (otherUnit.fI != null && otherUnit.fI.equalsIgnoreCase(customUnit.i())) {
                        customUnit.b(otherUnit);
                    }
                }

                // 处理建造关系
                for (com.corrodinggames.rts.game.units.custom.p buildRelation : ((ArrayList<com.corrodinggames.rts.game.units.custom.p>) otherUnit.gg)) {
                    if (buildRelation.a.equalsIgnoreCase(unit.i())) {
                        buildRelation.e = true; // 标记为已激活

                        // 为每个命令队列添加建造动作
                        int maxQueue = otherUnit.cl;
                        boolean hasWarning = false;

                        for (int queue = 1; queue <= 3; queue++) {
                            java.util.ArrayList<com.corrodinggames.rts.game.units.a.AbstractUnitAction> actions = unit.a(queue);

                            // 创建建造动作
                            com.corrodinggames.rts.game.units.a.AbstractUnitAction buildAction;
                            if (otherUnit.aH || buildRelation.c) {
                                // 使用高级建造动作
                                buildAction = new com.corrodinggames.rts.game.units.a.PlaceBuildingAction(otherUnit);
                            } else {
                                // 使用基础建造动作
                                buildAction = new com.corrodinggames.rts.game.units.a.QueueUnitAction(otherUnit);
                            }

                            // 设置优先级
                            if (buildRelation.b != -998653952f) {
                                buildAction.sortOrder = buildRelation.b;
                            }

                            // 处理锁定条件
                            if (buildRelation.f != null) {
                                boolean skipLockCheck = false;

                                // 检查是否需要跳过锁定检查
                                if (!(unit instanceof com.corrodinggames.rts.game.units.custom.l)) {
                                    com.corrodinggames.rts.game.units.BaseUnit unitController = com.corrodinggames.rts.game.units.BaseUnit
                                            .a(unit);
                                    if (!(unitController instanceof com.corrodinggames.rts.game.units.y)) {
                                        skipLockCheck = true;
                                    }
                                }

                                if (!skipLockCheck) {
                                    // 设置动作配置
                                    buildAction.unitAction = com.corrodinggames.rts.game.units.custom.a.c.a(buildRelation);
                                } else {
                                    if (!hasWarning) {
                                        hasWarning = true;
                                        otherUnit.r(
                                                "builtFrom isLocked currently cannot be used when targeting old-style unit:"
                                                        + unit.i());
                                    }
                                }
                            }

                            // 检查是否已存在相同动作
                            boolean actionExists = false;
                            for (com.corrodinggames.rts.game.units.a.AbstractUnitAction existingAction : actions) {
                                if (buildAction.equals(existingAction)) {
                                    actionExists = true;
                                    break;
                                }
                            }

                            // 添加动作并排序
                            if (!actionExists) {
                                actions.add(buildAction);
                            }
                            com.corrodinggames.rts.game.units.custom.ag.b(actions);
                        }
                    }
                }
            }

            // 处理自定义动作
            if (unit instanceof com.corrodinggames.rts.game.units.custom.l) {
                com.corrodinggames.rts.game.units.custom.l customUnit = (com.corrodinggames.rts.game.units.custom.l) unit;

                for (com.corrodinggames.rts.game.units.custom.a.d actionDef : ((ArrayList<com.corrodinggames.rts.game.units.custom.a.d>) customUnit.gh)) {
                    // 处理集结点设置
                    if ("setRally".equalsIgnoreCase(actionDef.k)) {
                        for (int queue = 1; queue <= 3; queue++) {
                            java.util.ArrayList<com.corrodinggames.rts.game.units.a.AbstractUnitAction> actions = unit.a(queue);
                            com.corrodinggames.rts.game.units.a.SetRallyAction rallyAction = new com.corrodinggames.rts.game.units.a.SetRallyAction();

                            if (actionDef.p != -998653952f) {
                                rallyAction.sortOrder = actionDef.p;
                            }

                            actions.add(rallyAction);
                            customUnit.dc = true; // 标记有集结点
                            com.corrodinggames.rts.game.units.custom.ag.b(actions);
                        }
                    }
                    // 处理回收动作
                    else if ("reclaim".equalsIgnoreCase(actionDef.k)) {
                        for (int queue = 1; queue <= 3; queue++) {
                            java.util.ArrayList<com.corrodinggames.rts.game.units.a.AbstractUnitAction> actions = unit.a(queue);
                            com.corrodinggames.rts.game.units.a.ReclaimTargetAction reclaimAction = new com.corrodinggames.rts.game.units.a.ReclaimTargetAction(
                                    true);

                            if (actionDef.p != -998653952f) {
                                reclaimAction.sortOrder = actionDef.p;
                            }

                            actions.add(reclaimAction);
                            com.corrodinggames.rts.game.units.custom.ag.b(actions);
                        }
                    }
                    // 处理修理动作
                    else if ("repair".equalsIgnoreCase(actionDef.k)) {
                        for (int queue = 1; queue <= 3; queue++) {
                            java.util.ArrayList<com.corrodinggames.rts.game.units.a.AbstractUnitAction> actions = unit.a(queue);
                            com.corrodinggames.rts.game.units.a.RepairTargetAction repairAction = new com.corrodinggames.rts.game.units.a.RepairTargetAction();

                            if (actionDef.p != -998653952f) {
                                repairAction.sortOrder = actionDef.p;
                            }

                            actions.add(repairAction);
                            com.corrodinggames.rts.game.units.custom.ag.b(actions);
                        }
                    }
                    // 处理通用建造动作
                    else {
                        com.corrodinggames.rts.game.units.UnitType targetUnit = null;

                        if (actionDef.k != null) {
                            targetUnit = com.corrodinggames.rts.game.units.UnitTypeEnum.a(actionDef.k);
                            if (targetUnit == null) {
                                throw new com.corrodinggames.rts.game.units.custom.bo(
                                        "Could not find canBuild target:" + actionDef.k);
                            }
                        }

                        // 下面AI写的
                        // 验证目标类型 - 只有当actionDef.k为null且不是convert类型时才需要目标
                        // 原先没有actionDef.k == null TODO: 注意
                        if (actionDef.k == null && actionDef.aM != com.corrodinggames.rts.game.units.custom.a.f.convert) {
                            throw new com.corrodinggames.rts.game.units.custom.bo(
                                    "'Target' required for action:" + actionDef.a());
                        }

                        // 为每个命令队列添加动作
                        for (int queue = 1; queue <= 3; queue++) {
                            java.util.ArrayList<com.corrodinggames.rts.game.units.a.AbstractUnitAction> actions = unit.a(queue);
                            com.corrodinggames.rts.game.units.a.AbstractUnitAction newAction = null;

                            // 根据动作类型创建相应动作
                            if (actionDef.aM == com.corrodinggames.rts.game.units.custom.a.f.build) {
                                if (targetUnit.j() || actionDef.aK) {
                                    newAction = new com.corrodinggames.rts.game.units.a.PlaceBuildingAction(targetUnit, actionDef.aJ,
                                            null);
                                } else {
                                    newAction = new com.corrodinggames.rts.game.units.a.QueueUnitAction(targetUnit);
                                }
                                newAction.unitAction = com.corrodinggames.rts.game.units.custom.a.c.a(actionDef);
                            } else if (actionDef.aM == com.corrodinggames.rts.game.units.custom.a.f.convert) {
                                com.corrodinggames.rts.game.units.custom.v weapon = com.corrodinggames.rts.game.units.custom.l
                                        .a(targetUnit);
                                newAction = new com.corrodinggames.rts.game.units.custom.a.g(actionDef, weapon);
                            } else {
                                throw new com.corrodinggames.rts.game.units.custom.bo(
                                        "Could not find actionType:" + actionDef.aM);
                            }

                            // 设置优先级
                            if (actionDef.p != -998653952f) {
                                newAction.sortOrder = actionDef.p;
                            }

                            // 检查是否已存在相同动作
                            boolean actionExists = false;
                            for (com.corrodinggames.rts.game.units.a.AbstractUnitAction existingAction : actions) {
                                if (newAction.equals(existingAction)) {
                                    actionExists = true;
                                    break;
                                }
                            }

                            // 添加动作并排序
                            if (!actionExists) {
                                actions.add(newAction);
                            }
                            com.corrodinggames.rts.game.units.custom.ag.b(actions);
                        }
                    }
                }
            }

            // 检查单位是否有建造能力
            if (unit instanceof com.corrodinggames.rts.game.units.custom.l) {
                com.corrodinggames.rts.game.units.custom.l customUnit = (com.corrodinggames.rts.game.units.custom.l) unit;
                customUnit.fu = false; // 重置建造标志

                // 检查所有命令队列中的动作
                for (int queue = 1; queue <= 3; queue++) {
                    java.util.ArrayList<com.corrodinggames.rts.game.units.a.AbstractUnitAction> actions = unit.a(queue);
                    for (com.corrodinggames.rts.game.units.a.AbstractUnitAction action : actions) {
                        // 跳过自定义动作
                        if (action instanceof com.corrodinggames.rts.game.units.custom.a.g) {
                            continue;
                        }

                        // 如果有有效的建造目标，标记为有建造能力
                        if (action.i() != null) {
                            customUnit.fu = true;
                            break;
                        }
                    }
                    if (customUnit.fu)
                        break;
                }

                // 初始化所有武器
                for (com.corrodinggames.rts.game.units.custom.v weapon : ((List<com.corrodinggames.rts.game.units.custom.v>) customUnit.p)) {
                    weapon.b();
                }
            }

            // 处理动作链配置（开发调试功能）
            boolean isDevMode = framework.O() &&
                    framework.networkEngine.ay != null &&
                    framework.networkEngine.ay.k;

            for (int queue = 1; queue <= 3; queue++) {
                java.util.ArrayList<com.corrodinggames.rts.game.units.a.AbstractUnitAction> actions = unit.a(queue);
                for (com.corrodinggames.rts.game.units.a.AbstractUnitAction action : actions) {
                    // 处理已存在的动作链配置
                    if (action.unitAction instanceof com.corrodinggames.rts.game.units.custom.a.b) {
                        com.corrodinggames.rts.gameFramework.GameEngine
                                .log("=== ChainedActionConfig already on: " + unit.i() + " action:" + action.b());
                        action.unitAction = ((com.corrodinggames.rts.game.units.custom.a.b) action.unitAction).b;
                    }

                    // 在开发模式下添加动作链配置
                    if (isDevMode) {
                        com.corrodinggames.rts.game.units.custom.d.b startConfig = action.B();
                        com.corrodinggames.rts.game.units.custom.d.b endConfig = action.r_();

                        if (!startConfig.c() && endConfig == null) {
                            com.corrodinggames.rts.game.units.custom.a.b chainConfig = new com.corrodinggames.rts.game.units.custom.a.b(
                                    action.unitAction);
                            action.unitAction = chainConfig;
                            chainConfig.c = com.corrodinggames.rts.game.units.custom.d.b.a;
                            chainConfig.d = startConfig;
                        }
                    }
                }
            }

        } catch (com.corrodinggames.rts.game.units.custom.bo | java.lang.RuntimeException e) {
            // 错误处理：记录错误信息
            com.corrodinggames.rts.game.units.custom.ag.a(unit.i(), e, unit);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void g() {
        Object object = o;
        synchronized (object) {
            ag.o();
        }
    }

    
    private static void o_unused() {
        try {
            // 清空AI单位列表和替换映射
            com.corrodinggames.rts.game.units.custom.l.g.clear();
            com.corrodinggames.rts.game.units.custom.l.f.clear();

            // 第一阶段：重置所有单位状态
            for (com.corrodinggames.rts.game.units.custom.l unit : com.corrodinggames.rts.game.units.custom.l.d) {
                // 检查模组错误
                if (unit.J != null && unit.J.R != null) {
                    String errorMessage = unit.J.R;
                    String logMessage = unit.i() + "(mod:" + unit.t() + "): Getting setup while mod has error: "
                            + errorMessage;
                    com.corrodinggames.rts.gameFramework.GameEngine.b(logMessage);
                }

                // 重置建造关系状态
                for (com.corrodinggames.rts.game.units.custom.p buildRelation : ((List<com.corrodinggames.rts.game.units.custom.p>) unit.gg)) {
                    buildRelation.e = false; // 重置激活状态
                }

                // 清空单位列表
                unit.fL.clear();
            }

            // 第二阶段：处理单位替换配置
            for (com.corrodinggames.rts.game.units.custom.l unit : com.corrodinggames.rts.game.units.custom.l.d) {
                try {
                    // 处理overrideAndReplace配置
                    if (unit.Q != null) {
                        String[] replaceTargets = unit.Q.split(",");

                        for (String targetName : replaceTargets) {
                            String trimmedName = targetName.trim();

                            // 查找要替换的目标单位
                            com.corrodinggames.rts.game.units.UnitType targetUnit = com.corrodinggames.rts.game.units.custom.l
                                    .a(trimmedName, false);

                            if (targetUnit == null) {
                                throw new com.corrodinggames.rts.game.units.custom.bo(
                                        "Could not find overrideAndReplace target:" + trimmedName);
                            }

                            // 如果是自定义单位，记录替换信息
                            if (targetUnit instanceof com.corrodinggames.rts.game.units.custom.l) {
                                String logMessage = "Replacing:" + targetUnit.i() + " with " + unit.i();
                                com.corrodinggames.rts.gameFramework.GameEngine.log(logMessage);
                            }

                            // 添加到替换映射
                            com.corrodinggames.rts.game.units.custom.l.f.put(targetUnit, unit);
                        }
                    }
                } catch (com.corrodinggames.rts.game.units.custom.bo e) {
                    // 错误处理：记录替换配置错误
                    com.corrodinggames.rts.game.units.custom.ag.a(unit.i(), e, unit);
                }
            }

            // 第三阶段：初始化所有单位动作
            // 初始化基础单位类型
            for (com.corrodinggames.rts.game.units.UnitTypeEnum baseUnitType : com.corrodinggames.rts.game.units.UnitTypeEnum.values()) {
                com.corrodinggames.rts.game.units.custom.ag.a(baseUnitType);
            }

            // 初始化自定义单位
            for (com.corrodinggames.rts.game.units.custom.l unit : com.corrodinggames.rts.game.units.custom.l.d) {
                com.corrodinggames.rts.game.units.custom.ag.a(unit);
            }

            // 第四阶段：验证建造关系
            for (com.corrodinggames.rts.game.units.custom.l unit : com.corrodinggames.rts.game.units.custom.l.d) {
                // 检查未激活的建造关系
                for (com.corrodinggames.rts.game.units.custom.p buildRelation : ((List<com.corrodinggames.rts.game.units.custom.p>) unit.gg)) {
                    if (!buildRelation.e) {
                        // 构建错误消息
                        String errorMessage = buildRelation.d + " failed to find target:" + buildRelation.a;

                        // 记录警告
                        unit.q(errorMessage);

                        // 根据严格级别决定是否转换为错误
                        if (unit.R >= 1) {
                            String strictMessage = "Converting warning to error (meta.strictLevel=" + unit.R + ")";
                            com.corrodinggames.rts.gameFramework.GameEngine.log(strictMessage);
                            unit.p(errorMessage); // 转换为错误
                        }
                    }
                }

                // 处理单位的特殊配置
                if (unit.gp != null && unit.gp.size() > 0) {
                    for (com.corrodinggames.rts.game.units.custom.u specialConfig : ((List<com.corrodinggames.rts.game.units.custom.u>) unit.gp)) {
                        try {
                            specialConfig.b(unit);
                        } catch (com.corrodinggames.rts.game.units.custom.bo e) {
                            // 错误处理：记录特殊配置错误
                            com.corrodinggames.rts.game.units.custom.ag.a(unit.i(), e, unit);
                        }
                    }
                }
            }

            // 第五阶段：最终初始化
            for (com.corrodinggames.rts.game.units.custom.l unit : com.corrodinggames.rts.game.units.custom.l.d) {
                unit.r(); // 调用单位的最终初始化方法
            }

            // 对AI单位列表进行排序
            java.util.Collections.sort(com.corrodinggames.rts.game.units.custom.l.g,
                    new com.corrodinggames.rts.game.units.custom.q());

        } catch (Exception e) {
            // 全局错误处理
            e.printStackTrace();
        }
    }


   private static void o() {
      com.corrodinggames.rts.game.units.custom.l.g.clear();
      com.corrodinggames.rts.game.units.custom.l.f.clear();
      Iterator var0 = com.corrodinggames.rts.game.units.custom.l.d.iterator();

      com.corrodinggames.rts.game.units.custom.l var1;
      p var3;
      Iterator var13;
      while(var0.hasNext()) {
         var1 = (com.corrodinggames.rts.game.units.custom.l)var0.next();
         if (var1.J != null) {
            String var2 = var1.J.R;
            if (var2 != null) {
               com.corrodinggames.rts.gameFramework.GameEngine.b(var1.i() + "(mod:" + var1.t() + "): Getting setup while mod has error: " + var2);
            }
         }

         for(var13 = var1.gg.iterator(); var13.hasNext(); var3.e = false) {
            var3 = (p)var13.next();
         }

         var1.fL.clear();
      }

      var0 = com.corrodinggames.rts.game.units.custom.l.d.iterator();

      while(var0.hasNext()) {
         var1 = (com.corrodinggames.rts.game.units.custom.l)var0.next();

         try {
            if (var1.Q != null) {
               String[] var14 = var1.Q.split(",");
               String[] var16 = var14;
               int var4 = var14.length;

               for(int var5 = 0; var5 < var4; ++var5) {
                  String var6 = var16[var5];
                  var6 = var6.trim();
                  boolean var7 = false;
                  com.corrodinggames.rts.game.units.UnitType var8 = com.corrodinggames.rts.game.units.custom.l.a(var6, var7);
                  if (var8 == null) {
                     throw new bo("Could not find overrideAndReplace target:" + var6);
                  }

                  if (var8 instanceof com.corrodinggames.rts.game.units.custom.l) {
                     com.corrodinggames.rts.gameFramework.GameEngine.log("Replacing:" + var8.i() + " with " + var1.i());
                  }

                  com.corrodinggames.rts.game.units.custom.l.f.put(var8, var1);
               }
            }
         } catch (bo var10) {
            a((String)var1.i(), (Exception)var10, (com.corrodinggames.rts.game.units.UnitType)var1);
         }
      }

      UnitTypeEnum[] var11 = UnitTypeEnum.values();
      int var12 = var11.length;

      for(int var15 = 0; var15 < var12; ++var15) {
         UnitTypeEnum var17 = var11[var15];
         a((com.corrodinggames.rts.game.units.UnitType)var17);
      }

      var0 = com.corrodinggames.rts.game.units.custom.l.d.iterator();

      while(var0.hasNext()) {
         var1 = (com.corrodinggames.rts.game.units.custom.l)var0.next();
         a((com.corrodinggames.rts.game.units.UnitType)var1);
      }

      var0 = com.corrodinggames.rts.game.units.custom.l.d.iterator();

      while(true) {
         do {
            do {
               if (!var0.hasNext()) {
                  var0 = com.corrodinggames.rts.game.units.custom.l.d.iterator();

                  while(var0.hasNext()) {
                     var1 = (com.corrodinggames.rts.game.units.custom.l)var0.next();
                     var1.r();
                  }

                  Collections.sort(com.corrodinggames.rts.game.units.custom.l.g, new q());
                  return;
               }

               var1 = (com.corrodinggames.rts.game.units.custom.l)var0.next();
               var13 = var1.gg.iterator();

               while(var13.hasNext()) {
                  var3 = (p)var13.next();
                  if (!var3.e) {
                     String var18 = var3.d + " failed to find target:" + var3.a;
                     var1.q(var18);
                     if (var1.R >= 1) {
                        com.corrodinggames.rts.gameFramework.GameEngine.log("Converting warning to error (meta.strictLevel=" + var1.R + ")");
                        var1.p(var18);
                     }
                  }
               }
            } while(var1.gp == null);
         } while(var1.gp.size() <= 0);

         var13 = var1.gp.iterator();

         while(var13.hasNext()) {
            u var19 = (u)var13.next();

            try {
               var19.b(var1);
            } catch (bo var9) {
               a((String)var1.i(), (Exception)var9, (com.corrodinggames.rts.game.units.UnitType)var1);
            }
         }
      }
   }

    public static com.corrodinggames.rts.game.units.custom.l a(String string2,
            com.corrodinggames.rts.gameFramework.i.b b2, String string3, String string4)
            throws IOException {
        try {
            long l2 = PerformanceProfiler.a();
            com.corrodinggames.rts.gameFramework.utility.AssetInputStream j2 = ag.b(string2);
            if (j2 == null) {
                throw new RuntimeException("Failed to open unit config file:" + string2);
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(j2);
            ag.a(l2, ah.iniOpen);
            ++b;
            if (b2 != null) {
                ++c;
            }
            com.corrodinggames.rts.gameFramework.GameEngine l3 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
            String string5 = "core units";
            if (b2 != null) {
                string5 = b2.a();
            }
            l3.h("Loading units - " + b + " (" + string5 + ")");
            com.corrodinggames.rts.game.units.custom.l l4 = ag.a(string2, bufferedInputStream, j2.c(), b2, j2, string3,
                    string4);
            long l5 = PerformanceProfiler.a();
            try {
                bufferedInputStream.close();
                j2.close();
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
            ag.a(l5, ah.iniClose);
            return l4;
        } catch (RuntimeException runtimeException) {
            ag.a(string2, (Exception) runtimeException, b2);
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void h() throws IOException {
        com.corrodinggames.rts.gameFramework.GameEngine framework = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();

        // 获取所有模组列表
        java.util.ArrayList<com.corrodinggames.rts.gameFramework.i.b> mods = framework.bZ.k();

        // 重置统计计数器
        com.corrodinggames.rts.game.units.custom.ag.j = 0; // 图片缓存命中数
        com.corrodinggames.rts.game.units.custom.ag.i = 0; // 图片缓存未命中数
        com.corrodinggames.rts.game.units.custom.ag.l = 0; // 其他计数器
        com.corrodinggames.rts.game.units.custom.ag.k = false; // 标志位

        // 记录开始时间
        long startTime = com.corrodinggames.rts.gameFramework.PerformanceProfiler.a();

        // 重置资源缓存标志
        java.util.HashMap<String, com.corrodinggames.rts.gameFramework.m.Texture_M> imageCache = com.corrodinggames.rts.game.units.custom.ag.g;
        for (com.corrodinggames.rts.gameFramework.m.Texture_M image : imageCache.values()) {
            image.v = false; // 重置使用标志
            // 递归重置所有子图片
            if (image.a != null) {
                for (com.corrodinggames.rts.gameFramework.m.Texture_M subImage : image.a) {
                    subImage.v = false;
                }
            }
            if (image.b != null) {
                for (com.corrodinggames.rts.gameFramework.m.Texture_M subImage : image.b) {
                    subImage.v = false;
                }
            }
            if (image.c != null) {
                for (com.corrodinggames.rts.gameFramework.m.Texture_M subImage : image.c) {
                    subImage.v = false;
                }
            }
        }

        // 重置音频缓存标志
        java.util.HashMap<String, com.corrodinggames.rts.gameFramework.sound.i> audioCache = com.corrodinggames.rts.game.units.custom.ag.h;
        for (com.corrodinggames.rts.gameFramework.sound.i audio : audioCache.values()) {
            audio.g = false; // 重置使用标志
        }

        // 预分配内存以防止加载模组时内存不足
        byte[] largeMemoryBlock = null;
        byte[][] mediumMemoryBlocks = null;
        java.nio.ByteBuffer[] directBuffers = null;

        try {
            // 分配大内存块 (8MB)
            largeMemoryBlock = new byte[8000000];
            // 测试内存访问
            largeMemoryBlock[0] = framework.dZ;
            framework.ea = largeMemoryBlock[1];

            // 分配中等内存块 (2x3MB)
            mediumMemoryBlocks = new byte[2][];
            mediumMemoryBlocks[0] = new byte[3000000];
            mediumMemoryBlocks[1] = new byte[3000000];
            // 测试内存访问
            mediumMemoryBlocks[0][0] = framework.dZ;
            mediumMemoryBlocks[1][0] = framework.dZ;

            // 分配直接内存缓冲区 (4x5MB)
            if (!com.corrodinggames.rts.gameFramework.GameEngine.at()) {
                directBuffers = new java.nio.ByteBuffer[4];
                directBuffers[0] = java.nio.ByteBuffer.allocateDirect(5000000);
                directBuffers[1] = java.nio.ByteBuffer.allocateDirect(5000000);
                directBuffers[2] = java.nio.ByteBuffer.allocateDirect(5000000);
                directBuffers[3] = java.nio.ByteBuffer.allocateDirect(5000000);
            }
        } catch (java.lang.OutOfMemoryError e) {
            // 内存不足时进行垃圾回收
            System.gc();
            com.corrodinggames.rts.gameFramework.GameEngine.log("Failed to reserve memory pre-mod load");
        }

        // 清理单位数据
        synchronized (com.corrodinggames.rts.game.units.custom.l.c) {
            com.corrodinggames.rts.game.units.custom.l.c.clear();
        }
        com.corrodinggames.rts.game.units.custom.l.d.clear();
        com.corrodinggames.rts.game.units.custom.l.e = null;
        com.corrodinggames.rts.game.units.custom.l.f.clear();

        // 清理模组管理器
        framework.bZ.n();

        // 重置计数器
        com.corrodinggames.rts.game.units.custom.ag.b = 0;
        com.corrodinggames.rts.game.units.custom.ag.c = 0;

        // 清理其他缓存
        synchronized (com.corrodinggames.rts.game.units.custom.ag.n) {
            com.corrodinggames.rts.game.units.custom.ag.n.clear();
        }

        // 加载基础单位定义
        String baseUnitsPath = com.corrodinggames.rts.gameFramework.storage.a.p("units");
        com.corrodinggames.rts.game.units.custom.ag.a(
                baseUnitsPath, 1, false, null, "units", null);

        // 加载模组（如果不是服务器模式且不是无模组模式）
        if (!com.corrodinggames.rts.gameFramework.GameEngine.isInGameOrLobbyStatic && !framework.isGamePaused) {
            // 检查自定义模组目录
            String customModPath = com.corrodinggames.rts.game.units.custom.ag.m();
            if (!com.corrodinggames.rts.gameFramework.storage.a.f(customModPath)) {
                com.corrodinggames.rts.gameFramework.GameEngine
                        .log("Modded Custom '" + customModPath + "' directory not found");
            }

            // 加载本地模组
            for (com.corrodinggames.rts.gameFramework.i.b mod : mods) {
                if (!mod.y && mod.q != null) { // 不是工作坊模组且有路径
                    String modPath = mod.j();

                    // 处理移动设备路径
                    if (mod.m) {
                        modPath = com.corrodinggames.rts.gameFramework.storage.a.p(modPath);
                    }

                    if (mod.f) {
                        // 禁用模组
                        com.corrodinggames.rts.gameFramework.GameEngine
                                .log("Disabled mod at:" + modPath + " (name:" + mod.a() + ")");
                    } else {
                        // 启用模组
                        com.corrodinggames.rts.gameFramework.GameEngine
                                .log("Loading mod at:" + modPath + " (name:" + mod.a() + ")");
                    }

                    // 加载模组单位
                    com.corrodinggames.rts.game.units.custom.ag.a(
                            modPath, 2, true, mod, modPath, null);
                }
            }

            // 加载工作坊模组
            for (com.corrodinggames.rts.gameFramework.i.b mod : mods) {
                if (mod.y && mod.q != null) { // 是工作坊模组且有路径
                    String workshopPath = mod.i();

                    if (mod.f) {
                        // 禁用工作坊模组
                        com.corrodinggames.rts.gameFramework.GameEngine
                                .log("Disabled workshop mod at:" + workshopPath + " (name:" + mod.a() + ")");
                    } else {
                        // 启用工作坊模组
                        com.corrodinggames.rts.gameFramework.GameEngine
                                .log("Loading workshop mod at:" + workshopPath + " (name:" + mod.a() + ")");
                    }

                    // 加载工作坊模组单位
                    com.corrodinggames.rts.game.units.custom.ag.a(
                            workshopPath, 2, true, mod, workshopPath, null);
                }
            }
        }

        // 处理加载的单位数据
        com.corrodinggames.rts.game.units.custom.ag.a();

        // 验证加载结果
        com.corrodinggames.rts.game.units.custom.ag.b(true);

        // 输出加载统计信息
        float loadTime = com.corrodinggames.rts.gameFramework.PerformanceProfiler.a(startTime);
        com.corrodinggames.rts.gameFramework.GameEngine.log("Done loading custom units. image cacheHits:" +
                com.corrodinggames.rts.game.units.custom.ag.j +
                " image cacheMisses:" +
                com.corrodinggames.rts.game.units.custom.ag.i +
                " (in: " + loadTime + "ms)");

        // 输出模组信息摘要
        com.corrodinggames.rts.gameFramework.GameEngine.log("========= Mods data loaded ===========");
        com.corrodinggames.rts.gameFramework.GameEngine.log("Number of mods:" + mods.size());
        for (com.corrodinggames.rts.gameFramework.i.b mod : mods) {
            mod.t(); // 输出模组详细信息
        }
        com.corrodinggames.rts.gameFramework.GameEngine.log("================================");

        // 清理预分配的内存
        if (directBuffers != null) {
            directBuffers[0] = null;
            directBuffers[1] = null;
            directBuffers[2] = null;
            directBuffers[3] = null;
        }

        if (mediumMemoryBlocks != null) {
            mediumMemoryBlocks[0] = null;
            mediumMemoryBlocks[1] = null;
        }

        if (largeMemoryBlock != null) {
            // 测试内存访问
            largeMemoryBlock[1] = framework.dZ;
            framework.ea = largeMemoryBlock[1];

            // 强制垃圾回收
            System.gc();
            System.gc();
        }
    }

    public static void a(String string2, int n2, boolean bl2, com.corrodinggames.rts.gameFramework.i.b b2,
            String string3, String string4) throws IOException {
        boolean bl3 = bl2 && n2 == 1;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (b2 != null) {
            if (b2.f && !l2.bQ.loadDisabledModData) {
                b2.C = true;
                return;
            }
            b2.C = false;
        }
        if (b2 != null && b2.f) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Note: Loading disabled mod: " + string2);
        }
        com.corrodinggames.rts.gameFramework.storage.a.c();
        String[] stringArray = com.corrodinggames.rts.gameFramework.storage.a.h(string2);
        if (stringArray == null) {
            String string5 = com.corrodinggames.rts.gameFramework.storage.a.c();
            com.corrodinggames.rts.gameFramework.GameEngine.b("readAllCustomUnitConfigs: ERROR");
            com.corrodinggames.rts.gameFramework.GameEngine.b("readAllCustomUnitConfigs: Failed to load:" + string2);
            if (b2 != null) {
                if (!b2.D) {
                    b2.R = string5 == null ? "Failed to list directory, check file permissions"
                            : "Failed to list directory: " + string5;
                } else {
                    b2.S = "Failed to list subdirectory: '" + string2 + "' check file permissions";
                    if (string5 != null) {
                        b2.S = b2.S + ": " + string5;
                    }
                }
            }
            return;
        }
        if (b2 != null) {
            b2.D = true;
        }
        if (!bl3) {
            for (String string6 : stringArray) {
                if (!string6.equalsIgnoreCase("all-units.template"))
                    continue;
                string4 = string2;
            }
        }
        for (String string6 : stringArray) {
            String string7;
            if (string6.equals("custom_units_here.txt") || string6.equals("mods_here_will_be_enabled_by_default.txt")
                    || string6.equals("__MACOSX"))
                continue;
            boolean bl4 = false;
            com.corrodinggames.rts.gameFramework.i.b b3 = b2;
            if (bl2 && n2 == 1 && b3 == null) {
                b3 = l2.bZ.e(string6);
                if (b3 == null) {
                    com.corrodinggames.rts.gameFramework.GameEngine
                            .b("readAllCustomUnitConfigs: Could not find linked mod:" + string6);
                    b3 = l2.bZ.c;
                }
                bl4 = true;
            }
            if (string6.toLowerCase(Locale.ENGLISH).endsWith(".ini") && !bl3) {
                string7 = string2 + "/" + string6;
                if (r != b3 && b3 != null) {
                    r = b3;
                    ag.a();
                    com.corrodinggames.rts.gameFramework.GameEngine.log("Loading units from mod: " + b3.c);
                }
                if (string6.equalsIgnoreCase("desktop.ini")) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("Skipping possible system file: " + string7);
                    continue;
                }
                long l3 = PerformanceProfiler.a();
                ag.a(string7, b3, string3, string4);
                ag.a(l3, ah.unitParse);
                continue;
            }
            if (string6.toLowerCase(Locale.ENGLISH).endsWith(".tmx")) {
                string7 = string2 + "/" + string6;
                com.corrodinggames.rts.gameFramework.GameEngine.log("Found map: " + string7);
                if (b3 != null && b3.B) {
                    l2.bZ.a(string7, b3);
                    continue;
                }
                com.corrodinggames.rts.gameFramework.GameEngine.log("Skipping map due to mod settings");
                continue;
            }
            string7 = string2 + "/" + string6;
            if (n2 < 10) {
                if (!com.corrodinggames.rts.gameFramework.storage.a.f(string7))
                    continue;
                String string8 = string3;
                if (string8 == null) {
                    string8 = string7;
                }
                long l4 = -1L;
                if (bl4) {
                    l4 = PerformanceProfiler.a();
                    com.corrodinggames.rts.gameFramework.GameEngine.log("============");
                    com.corrodinggames.rts.gameFramework.GameEngine
                            .log(">>> Mod '" + b3.c() + "'" + (b3.m() ? "" : " (disabled)"));
                }
                ag.a(string7, n2 + 1, bl2, b3, string8, string4);
                if (!bl4 || b3 == null || !b3.m())
                    continue;
                double d2 = PerformanceProfiler.a(l4);
                com.corrodinggames.rts.gameFramework.GameEngine.log("Mod '" + b3.c() + "' load took:" + PerformanceProfiler.a(d2));
                continue;
            }
            com.corrodinggames.rts.gameFramework.GameEngine.log("Too many levels:" + string7);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static com.corrodinggames.rts.game.units.custom.l a(String var0, InputStream var1, long var2,
            com.corrodinggames.rts.gameFramework.i.b var4, AssetInputStream var5, String var6, String var7)
            throws IOException {
        GameEngine var8 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();

        try {
            if (a) {
                String var9 = "CORE";
                if (var4 != null) {
                    var9 = var4.j();
                }

                com.corrodinggames.rts.gameFramework.GameEngine.log("Loading unit config: " + var0 + " [" + var9 + "]");
            }

            var8.bO.e();
            long var94 = PerformanceProfiler.a();

            IniFile var11;
            try {
                var11 = new IniFile(var1, var0);
            } catch (IOException var90) {
                throw new RuntimeException(var90);
            }

            a(var94, ah.iniParse);
            String var12 = "core";
            String var13 = "graphics";
            String var14 = "attack";
            String var15 = "movement";
            String var16 = "ai";
            com.corrodinggames.rts.game.units.custom.l var17 = new com.corrodinggames.rts.game.units.custom.l();
            if (var11.a(var12, "dont_load", false)) {
                return null;
            } else {
                var17.D = var0;
                var17.E = var5.d();
                var17.F = var17.D;
                var17.J = var4;
                var17.K = var6;
                var17.L = var7;
                e = var4;
                f = false;
                if (var17.J != null) {
                }

                long var18 = PerformanceProfiler.a();
                a(var17, var11, (IniFile) var11, var0, 0);
                if (var17.L != null) {
                    a(var17, var11, var17.L + "/" + "all-units.template", "AUTO units.template", true);
                }

                var11.a("core", "copyFrom");
                var17.R = var11.b(var12, "strictLevel", 0);
                if (var17.R < 0) {
                    throw new bo("[core]strictLevel cannot be < 0");
                } else if (var17.R > 1) {
                    throw new bo("[core]strictLevel cannot yet be > 1");
                } else {
                    var17.gs = var11.a(var12, "logIfCreditResourceUsed", false);
                    var11.a(var12, "dont_load");
                    var11.b(var12, "class", "CustomUnitMetadata");
                    com.corrodinggames.rts.gameFramework.utility.m var21 = var11.c("@copyFrom_skipThisSection");
                    Iterator var22 = var21.iterator();

                    String var23;
                    while (var22.hasNext()) {
                        var23 = (String) var22.next();
                        var11.a(var23, "@copyFrom_skipThisSection");
                    }

                    com.corrodinggames.rts.gameFramework.utility.m var95 = var11.c("@copyFromSection");
                    Iterator var96 = var95.iterator();

                    String var24;
                    while (var96.hasNext()) {
                        var24 = (String) var96.next();
                        a(var17, var11, (String) var24, var24, 0);
                    }

                    com.corrodinggames.rts.game.units.custom.f.a.a(var17, var11);
                    var23 = var11.b(var12, "overrideResourceLoadPath", (String) null);
                    if (var23 != null) {
                        var17.F = a(var17, var0, var23);
                    }

                    a(var18, ah.iniSetup);
                    var17.M = var11.e(var12, "name");
                    var17.H = var11.c();
                    if (var17.M.equals("self")) {
                        throw new bo("Unit name: " + var17.M + " is reserved");
                    } else if (var17.M.startsWith("self.")) {
                        throw new bo("Unit name cannot start with self.");
                    } else {
                        var24 = var11.b(var12, "altNames", (String) null);
                        int var26;
                        int var27;
                        String var28;
                        if (var24 != null && !var24.equalsIgnoreCase("NONE")) {
                            String[] var25 = var24.split(",");
                            var26 = var25.length;

                            for (var27 = 0; var27 < var26; ++var27) {
                                var28 = var25[var27];
                                var28 = var28.trim();
                                var17.N.add(var28);
                            }
                        }

                        var17.O = com.corrodinggames.rts.game.units.custom.g.a(var11.b(var12, "tags", (String) null));
                        if (var17.R >= 1 && var17.O != null) {
                            com.corrodinggames.rts.game.units.custom.g[] var97 = var17.O.a;
                            var26 = var97.length;

                            for (var27 = 0; var27 < var26; ++var27) {
                                com.corrodinggames.rts.game.units.custom.g var102 = var97[var27];
                                if (var102.a.contains(" ")) {
                                    throw new bo("(strictLevel 1) [core]tags: space in tag: '" + var102.a + "'");
                                }
                            }
                        }

                        var17.Q = var11.b(var12, "overrideAndReplace", (String) null);
                        if (var17.Q != null && var17.Q.equalsIgnoreCase("NONE")) {
                            var17.Q = null;
                        }

                        String var98 = var11.b(var12, "defineUnitMemory", (String) null);
                        if (var98 != null) {
                            var17.r.addDefineValue(var17, var12, "defineUnitMemory", var98);
                            if (var17.r.hasArrays()) {
                                var17.a("1.15p11", 115011, var12, "Memory arrays (in defineUnitMemory)");
                            }
                        }

                        Iterator var99 = var11.k(var12, "@memory ").iterator();

                        String var29;
                        String var101;
                        while (var99.hasNext()) {
                            var101 = (String) var99.next();
                            var28 = var101.substring("@memory ".length()).trim();
                            var29 = var11.b(var12, var101, (String) null);
                            if (var29 != null) {
                                if (var29.contains(",")) {
                                    throw new bo("[" + var12 + "]" + var101
                                            + ": Only a single variable can be defined per @memory");
                                }

                                var17.r.addSingleDefine(var17, var28, var29, var12, var101);
                                if (var17.r.hasArrays()) {
                                    var17.a("1.15p11", 115011, var12, "Memory arrays (in " + var101 + ")");
                                }
                            }
                        }

                        var17.T = (ad) var11.a(var12, "onNewMapSpawn", (Enum) null, ad.class);
                        var17.aG = (float) var11.a(var12, "globalScale", 1.0F);
                        var17.o(var17.E);
                        if (var17.M.equals("missing")) {
                            if (var4 == null) {
                                com.corrodinggames.rts.gameFramework.GameEngine.log("Setting missingPlaceHolder");
                                com.corrodinggames.rts.game.units.custom.l.b = var17;
                            } else {
                                com.corrodinggames.rts.gameFramework.GameEngine
                                        .log("Not setting missingPlaceHolder, as we are in a mod");
                            }
                        }

                        var17.aE = var11.b(var12, "displayLocaleKey", (String) null);
                        var17.aC = a((IniFile) var11, (String) var12, "displayText", (String) null);
                        var17.aD = a((IniFile) var11, (String) var12, "displayDescription", (String) null);
                        var17.eD = var11.a(var12, "isBio", false);
                        var17.eE = var11.a(var12, "isBug", false);
                        var17.eH = var11.a(var12, "isPickableStartingUnit", false);
                        var17.eI = var11.a(var12, "startFallingWhenStartingUnit", false);
                        var17.cy = var11.a(var12, "stayNeutral", false);
                        var17.cz = var11.a(var12, "createNeutral", false);
                        var17.cA = var11.a(var12, "allowCaptureWhenNeutralByAI", false);
                        if (var11.a(var12, "createOnNeutralTeam", false)) {
                            var17.cz = true;
                        }

                        var17.cB = var11.a(var12, "whileNeutralTransportAnyTeam", false);
                        var17.cC = var11.a(var12, "whileNeutralConvertToTransportedTeam", false);
                        var17.cD = var11.a(var12, "convertToNeutralIfNotTransporting", false);
                        if (var17.cD) {
                            var17.cy = true;
                        }

                        var17.cE = var11.a(var12, "createOnAggressiveTeam", false);
                        var17.aF = var11.a(var12, "showInEditor", true);
                        var17.U = var11.b(var13, "total_frames", 1);
                        if (var17.U < 1) {
                            throw new bo("TOTAL_FRAMES cannot be: " + var17.U + " (must be 1 or more)");
                        } else {
                            var17.W = var11.b(var13, "frame_width", -1);
                            var17.X = var11.b(var13, "frame_height", -1);
                            var17.Y = var11.b(var13, "default_frame", 0);
                            var17.ah = var11.b(var13, "image_offsetX", 0);
                            var17.ai = var11.b(var13, "image_offsetY", 0);
                            var17.aj = (float) var11.a(var13, "image_offsetH", 0.0F);
                            if (var17.ah != 0 || var17.ai != 0 || var17.aj != 0.0F) {
                                var17.ak = true;
                            }

                            var17.ac = com.corrodinggames.rts.game.o.pureGreen;
                            if (var11.a(var13, "teamColorsUseHue", false)) {
                                var17.ac = com.corrodinggames.rts.game.o.hueAdd;
                            }

                            String var100 = var11.b(var13, "teamColoringMode", (String) null);
                            if (var100 != null) {
                                if (var11.a(var13, "teamColorsUseHue", (Boolean) null) != null) {
                                    throw new bo("Cannot use teamColoringMode and teamColorsUseHue at the same time");
                                }

                                if (var100.equalsIgnoreCase("pureGreen")) {
                                    var17.ac = com.corrodinggames.rts.game.o.pureGreen;
                                } else if (var100.equalsIgnoreCase("hueAdd")) {
                                    var17.ac = com.corrodinggames.rts.game.o.hueAdd;
                                } else if (var100.equalsIgnoreCase("hueShift")) {
                                    var17.ac = com.corrodinggames.rts.game.o.hueShift;
                                } else {
                                    if (!var100.equalsIgnoreCase("disabled")) {
                                        throw new bo("Unknown teamColoringMode:" + var100);
                                    }

                                    var17.ac = com.corrodinggames.rts.game.o.disabled;
                                }
                            }

                            var17.ab = var11.a(var13, "imageSmoothing", false);
                            var17.aa = var11.a(var13, "imageSmoothingWhenZoomedIn", false);
                            var17.Z = var11.a(var17, var13, "isVisible", (LogicBoolean) null);
                            if (var17.Z == LogicBoolean.trueBoolean) {
                                var17.Z = null;
                            }

                            var17.cL.m = var11.a(var13, "isVisibleToEnemies", true);
                            var101 = var11.e(var13, "image");
                            var17.ad = var17.a(var17.F, var101, var17.ab, var13, "image");
                            if (var17.ad == null) {
                                throw new bo("Main unit image must be set on custom unit");
                            } else {
                                var17.ae = var11.a(var13, "image_floatingPointSize", false);
                                var17.af = var17.ad.m() / var17.U;
                                var17.ag = var17.ad.l();
                                if (var17.af < 1) {
                                    var17.af = 1;
                                }

                                if (var17.W > 0) {
                                    var17.af = var17.W;
                                }

                                if (var17.X > 0) {
                                    var17.ag = var17.X;
                                    if (var17.ag < var17.ad.l()) {
                                        var17.V = var17.ad.m() / var17.af;
                                        if (var17.V < 1) {
                                            var17.V = 1;
                                        }
                                    }
                                }

                                var17.al = var17.a(var11, var13, "image_back");
                                var17.am = var11.a(var13, "image_back_always_use_full_image", false);
                                var17.an = var17.a(var11, var13, "image_wreak");
                                var17.ao = var17.a(var11, var13, "image_turret");
                                var17.as = com.corrodinggames.rts.game.units.e.j.dN;
                                var28 = var11.b(var13, "image_shadow", "NONE");
                                com.corrodinggames.rts.gameFramework.m.Texture_M var30;
                                if (var28.equalsIgnoreCase("AUTO")) {
                                    var29 = "[autoShadow:" + var17.af + "," + var17.ag + "]" + var17.ad.d + "-"
                                            + var17.ad.e;
                                    var30 = c(var29);
                                    if (var30 != null) {
                                        var17.ap = var30;
                                    } else {
                                        var17.ap = BaseUnit.a(var17.ad, var17.af, var17.ag);
                                        a(var17.ap);
                                        if (var17.ap != null) {
                                            a(var29, var17.ap);
                                        }
                                    }
                                } else if (var28.equalsIgnoreCase("AUTO_ANIMATED")) {
                                    var29 = "[autoShadowAnimated:" + var17.af + "," + var17.ag + "]" + var17.ad.d + "-"
                                            + var17.ad.e;
                                    var30 = c(var29);
                                    if (var30 != null) {
                                        var17.ap = var30;
                                    } else {
                                        var17.ap = BaseUnit.a(var17.ad, var17.ad.m(), var17.ad.l());
                                        a(var17.ap);
                                        if (var17.ap != null) {
                                            a(var29, var17.ap);
                                        }
                                    }

                                    var17.aq = true;
                                } else {
                                    var17.ap = var17.a(var17.F, var28, var17.ab, var13, "image_shadow");
                                }

                                if (var11.a(var13, "image_shadow_frames", false)) {
                                    var17.aq = true;
                                }

                                var17.ar = var17.a(var17.ad, var17.ac);
                                var17.s = var11.a(var13, "teamColorsOnTurret", false);
                                if (var17.s && var17.ao != null) {
                                    var17.at = var17.a(var17.ao, var17.ac);
                                }

                                float var103 = (float) var11.a(var13, "scaleImagesTo", -1.0F);
                                if (var103 > 0.0F) {
                                    var103 *= var17.aG;
                                    var17.bH = var103 / (float) var17.af;
                                }

                                float var104 = (float) var11.a(var13, "imageScale", 1.0F);
                                if (var104 != 1.0F) {
                                    var17.bH *= var104;
                                }

                                float var31 = (float) var11.a(var13, "scaleTurretImagesTo", -1.0F);
                                if (var31 > 0.0F) {
                                    var31 *= var17.aG;
                                    if (var17.ao == null) {
                                        throw new RuntimeException("scaleTurretImagesTo needs image_turret set");
                                    }

                                    var17.bI = var31 / (float) var17.ao.p;
                                }

                                float var32 = (float) var11.a(var13, "turretImageScale", 1.0F);
                                if (var32 != 1.0F) {
                                    var17.bI *= var32;
                                }

                                var17.au = com.corrodinggames.rts.game.units.e.c.e;
                                com.corrodinggames.rts.gameFramework.m.Texture_M var33 = var17.a(var11, var13, "image_shield");
                                if (var33 != null) {
                                    var17.au = var33;
                                    var17.av = true;
                                }

                                var17.aw = var17.a(var11, var13, "icon_build", false);
                                float var34 = (float) var17.ad.m() * var17.bH;
                                float var35 = (float) var17.ad.l() * var17.bH;
                                if (var34 / 2.0F > 90.0F || var35 / 2.0F > 90.0F) {
                                    var17.C = new Rect();
                                    var17.C.left = (int) (-var34 / 2.0F);
                                    var17.C.c = (int) (var34 / 2.0F);
                                    var17.C.top = (int) (-var35 / 2.0F);
                                    var17.C.d = (int) (var35 / 2.0F);
                                    var17.B = true;
                                }

                                Iterator var36 = var11.m("resource_", "global_resource_").iterator();

                                while (true) {
                                    String var108;
                                    if (var36.hasNext()) {
                                        String var107 = (String) var36.next();
                                        boolean var110;
                                        if (var107.startsWith("resource_")) {
                                            var108 = var107.substring("resource_".length());
                                            var110 = false;
                                        } else {
                                            var108 = var107.substring("global_resource_".length());
                                            var110 = true;
                                        }

                                        var108 = var108.trim();
                                        if (var108.contains(" ")) {
                                            throw new RuntimeException(
                                                    "[" + var107 + "] resource codename cannot contain a space");
                                        }

                                        if (!var108.contains("=") && !var108.contains("|") && !var108.contains(":")
                                                && !var108.contains(",") && !var108.contains("(")
                                                && !var108.contains(")") && !var108.contains("<")
                                                && !var108.contains(">") && !var108.contains("$")) {
                                            com.corrodinggames.rts.game.units.custom.e.d var112 = new com.corrodinggames.rts.game.units.custom.e.d(
                                                    var110);
                                            var112.a(var17, var11, var107, var108);
                                            if (var17.k(var112.a) != null) {
                                                throw new RuntimeException("[" + var107 + "] resource with name:"
                                                        + var112.a + " already exists in this file");
                                            }

                                            var17.j.add(var112);
                                            continue;
                                        }

                                        throw new RuntimeException("[" + var107
                                                + "] resource codename cannot contain the symbols: =|:,()<>$");
                                    }

                                    var36 = var17.j.iterator();

                                    while (var36.hasNext()) {
                                        com.corrodinggames.rts.game.units.custom.e.d var37 = (com.corrodinggames.rts.game.units.custom.e.d) var36
                                                .next();
                                        var37.a(var17);
                                    }

                                    if (var8.isDeveloperMode()) {
                                        com.corrodinggames.rts.game.units.custom.b.l.a(var17, var11);
                                        com.corrodinggames.rts.game.units.custom.b.j.a(var17, var11);
                                    }

                                    com.corrodinggames.rts.game.units.custom.b.m.a(var17, var11);
                                    var17.ca = var11.b(var12, "autoTriggerCooldownTime", 60.0F);
                                    if (var17.ca < 0.0F) {
                                        throw new RuntimeException("autoTriggerCooldownTime cannot be < 0");
                                    }

                                    if (var17.ca > 120.0F) {
                                        throw new RuntimeException(
                                                "autoTriggerCooldownTime cannot be more than 2 seconds");
                                    }

                                    if (!var11.a(var12, "autoTriggerCooldownTime_allowDangerousHighCPU", false)
                                            && var17.ca < 5.0F) {
                                        throw new RuntimeException(
                                                "autoTriggerCooldownTime cannot be this low (without override). Note this cooldown is only applied after triggering an action not for the detection.");
                                    }

                                    var17.cb = (com.corrodinggames.rts.game.units.custom.s) var11.a(var12,
                                            "autoTriggerCheckRate",
                                            com.corrodinggames.rts.game.units.custom.s.everyFramea,
                                            com.corrodinggames.rts.game.units.custom.s.class);
                                    var17.cd = var11.a(var12, "autoTriggerCheckWhileNotBuilt", false);
                                    var17.cL.b = (float) var11.g(var12, "mass");
                                    var17.ce = var11.a(var12, "availableInDemo", true);
                                    var17.cf = var11.a(var12, "isLocked", false);
                                    var17.cg = var11.a(var12, "isLockedIfGameModeNoNuke", false);
                                    var17.ch = com.corrodinggames.rts.game.units.custom.d.b.a(var17, var11, var12,
                                            "price", false);
                                    var17.ci = com.corrodinggames.rts.game.units.custom.d.b.a(var17, var11, var12,
                                            "reclaimPrice", (com.corrodinggames.rts.game.units.custom.d.b) null);
                                    var17.cj = com.corrodinggames.rts.game.units.custom.d.b.b(var17, var11, var12,
                                            "streamingCost", (com.corrodinggames.rts.game.units.custom.d.b) null);
                                    boolean var105 = var11.a(var12, "switchPriceWithStreamingCost", false);
                                    if (var105) {
                                        if (var17.cj != null) {
                                            throw new RuntimeException("[" + var12
                                                    + "]streamingCost and switchPriceWithStreamingCost=true cannot be used at the same time");
                                        }

                                        var17.cj = com.corrodinggames.rts.game.units.custom.d.b.b(var17, var11, var12,
                                                "price", (com.corrodinggames.rts.game.units.custom.d.b) null);
                                        var17.ch = com.corrodinggames.rts.game.units.custom.d.b.a;
                                    }

                                    var17.ck = var11.d(var12, "buildSpeed", 1.0F);
                                    var17.cl = var11.b(var12, "techLevel", 1);
                                    if (var17.cl > 3) {
                                        throw new RuntimeException(
                                                "techLevel cannot be greater than max tech level of:3");
                                    }

                                    if (var17.cl < 1) {
                                        throw new RuntimeException(
                                                "techLevel cannot be less than 1, it is:" + var17.cl);
                                    }

                                    var17.cm = var11.a(var12, "experimental", false);
                                    var17.cv = com.corrodinggames.rts.game.units.custom.d.b.a(var17, var11, var12,
                                            "borrowResourcesWhileAlive", true);
                                    var17.cw = com.corrodinggames.rts.game.units.custom.d.b.a(var17, var11, var12,
                                            "borrowResourcesWhileBuilt", true);
                                    var17.co = com.corrodinggames.rts.game.units.custom.d.b.a(var17, var11, var12,
                                            "generation_resources", true);
                                    int var106 = var11.b(var12, "generation_credits", 0);
                                    if (var106 != 0) {
                                        var17.co = com.corrodinggames.rts.game.units.custom.d.b.a(var17.co,
                                                com.corrodinggames.rts.game.units.custom.d.b.a(var106));
                                    }

                                    var17.cr = var11.b(var12, "generation_delay", 40);
                                    if (var17.cr == 0) {
                                        var17.cr = 1;
                                    }

                                    if (var17.cr < 0) {
                                        throw new RuntimeException("[" + var12 + "]generation_delay cannot be < 0");
                                    }

                                    var17.cs = 40.0F / (float) var17.cr;
                                    if (!var17.co.c()) {
                                        var17.cp = new com.corrodinggames.rts.game.units.custom.e.f();
                                        var17.cp.a(var17.co);
                                        var17.cp.a((double) var17.cs);
                                        var17.cn = true;
                                    }

                                    if (!var17.cp.c()) {
                                        Iterator var38 = var17.cp.b.iterator();

                                        while (var38.hasNext()) {
                                            com.corrodinggames.rts.game.units.custom.e.e var39 = (com.corrodinggames.rts.game.units.custom.e.e) var38
                                                    .next();
                                            if (!var39.a.c() && var39.a.d()) {
                                                if (var17.cq == com.corrodinggames.rts.game.units.custom.e.f.a) {
                                                    var17.cq = new com.corrodinggames.rts.game.units.custom.e.f();
                                                }

                                                var17.cq.b(var39.a, var39.b);
                                            }
                                        }
                                    }

                                    var17.cx = var11.a(var17, var12, "generation_active", LogicBoolean.trueBoolean);
                                    var17.a(var17.co);
                                    var17.cF = (float) var11.a(var12, "resourceRate", 0.0F);
                                    if (var105 && var17.cF != 0.0F) {
                                        throw new RuntimeException("To avoid mistakes [" + var12
                                                + "]resourceRate cannot be used with switchPriceWithStreamingCost=true");
                                    }

                                    var108 = var11.b(var12, "updateUnitMemory", (String) null);
                                    if (var108 != null) {
                                        var17.ct = VariableScope.createMemoryWriter(var108, var17, var12,
                                                "updateUnitMemory");
                                    }

                                    var17.cu = var11.b(var12, "updateUnitMemoryRate", 60.0F);
                                    var17.cG = var11.b(var12, "resourceMaxConcurrentReclaimingThis", Integer.MAX_VALUE);
                                    var17.cH = var11.a(var17, var12, "similarResourcesHaveTag",
                                            (com.corrodinggames.rts.game.units.custom.h) null);
                                    var17.do_bl = bl.a(var17, var11.b(var12, "soundOnAttackOrder", (String) null));
                                    var17.dp = bl.a(var17, var11.b(var12, "soundOnMoveOrder", (String) null));
                                    var17.dq = bl.a(var17, var11.b(var12, "soundOnNewSelection", (String) null));
                                    String var109 = var11.b(var13, "drawLayer", (String) null);
                                    if (var109 != null) {
                                        if (var109.equals("experimentals")) {
                                            var17.cI = 4;
                                        } else if (var109.equals("underwater")) {
                                            var17.cI = 1;
                                        } else if (var109.equals("bottom")) {
                                            var17.cI = 1;
                                        } else if (var109.equals("ground")) {
                                            var17.cI = 2;
                                        } else if (var109.equals("ground2")) {
                                            var17.cI = 3;
                                        } else if (var109.equals("air")) {
                                            var17.cI = 5;
                                        } else if (var109.equals("top")) {
                                            var17.cI = 10;
                                        } else {
                                            if (!var109.equals("wreaks")) {
                                                throw new RuntimeException("unknown drawLayer:" + var109);
                                            }

                                            var17.cI = 0;
                                        }
                                    }

                                    var17.cJ = (float) var11.a(var13, "shadowOffsetX", 0.0F);
                                    var17.cK = (float) var11.a(var13, "shadowOffsetY", 0.0F);
                                    var17.dB = var11.a(var13, "rotate_with_direction", true);
                                    var17.dC = var11.a(var13, "lock_body_rotation_with_main_turret", false);
                                    var17.dD = var11.a(var13, "lock_shadow_rotation_with_main_turret", var17.dC);
                                    var17.dE = var11.a(var13, "lock_leg_rotation_with_main_turret", false);
                                    var17.dH = (float) var11.a(var13, "whenBeingBuiltMakeTransparentTill", 1.0F);
                                    var17.dI = com.corrodinggames.rts.game.units.custom.m.a(var17, var11, var13,
                                            "animation_", false);
                                    Iterator var40 = var11.e("effect_").iterator();

                                    String var41;
                                    String var42;
                                    while (var40.hasNext()) {
                                        var41 = (String) var40.next();
                                        var42 = var41.substring("effect_".length());
                                        ay var43 = new ay(var42);
                                        var43.a(var17, var11, var41);
                                        var17.gd.add(var43);
                                    }

                                    var40 = var17.gd.iterator();

                                    while (var40.hasNext()) {
                                        ay var113 = (ay) var40.next();
                                        if (var113.alsoEmitEffects != null) {
                                            var113.alsoEmitEffects.c();
                                        }

                                        if (var113.alsoEmitEffectsOnDeath != null) {
                                            var113.alsoEmitEffectsOnDeath.c();
                                        }

                                        if (var113.ifSpawnFailsEmitEffects != null) {
                                            var113.ifSpawnFailsEmitEffects.c();
                                        }

                                        if (var113.trailEffect != null) {
                                            var113.trailEffect.c();
                                        }
                                    }

                                    var17.bJ = var11.a(var13, "splastEffect", false);
                                    var17.bM = var11.a(var13, "dustEffect", false);
                                    var17.bK = var11.a(var13, "splastEffectReverse", true);
                                    var17.bN = var11.a(var13, "dustEffectReverse", true);
                                    var17.bL = var17.bM || var17.bJ;
                                    String var111 = var11.b(var13, "movementEffect", (String) null);
                                    if (var111 != null) {
                                        var17.bO = var17.a(var111, (z) null);
                                        if (var17.bO != null && var17.bO.a()) {
                                            var17.bL = true;
                                        }
                                    }

                                    var41 = var11.b(var13, "movementEffectReverse", (String) null);
                                    if (var41 != null) {
                                        var17.bP = var17.a(var41, (z) null);
                                        if (var17.bP != null && var17.bP.a()) {
                                            var17.bL = true;
                                        }
                                    }

                                    var17.bR = (float) var11.a(var13, "movementEffectRate", 11.0F);
                                    var17.bQ = var11.a(var13, "movementEffectReverseFlipEffects", false);
                                    var17.bT = (float) var11.a(var13, "repairEffectRate", 5.0F);
                                    var42 = var11.b(var13, "repairEffect", (String) null);
                                    if (var42 != null) {
                                        var17.bU = var17.a(var42, (z) null);
                                        if (var17.bU != null && var17.bU.b()) {
                                            var17.bS = true;
                                        }
                                    }

                                    String var114 = var11.b(var13, "repairEffectAtTarget", (String) null);
                                    if (var114 != null) {
                                        var17.bV = var17.a(var114, (z) null);
                                        if (var17.bV != null && var17.bV.b()) {
                                            var17.bS = true;
                                        }
                                    }

                                    var17.bX = (float) var11.a(var13, "reclaimEffectRate", 5.0F);
                                    String var44 = var11.b(var13, "reclaimEffect", (String) null);
                                    if (var44 != null) {
                                        var17.bY = var17.a(var44, (z) null);
                                        if (var17.bY != null && var17.bY.b()) {
                                            var17.bW = true;
                                        }
                                    }

                                    String var45 = var11.b(var13, "reclaimEffectAtTarget", (String) null);
                                    if (var45 != null) {
                                        var17.bZ = var17.a(var45, (z) null);
                                        if (var17.bZ != null && var17.bZ.b()) {
                                            var17.bW = true;
                                        }
                                    }

                                    var17.ds.a(var17, var11, var13, "animation_" + var17.ds.a + "_");
                                    var17.dt.a(var17, var11, var13, "animation_" + var17.dt.a + "_");
                                    var17.du.a(var17, var11, var13, "animation_" + var17.du.a + "_");
                                    Iterator var46 = var11.e("animation_").iterator();

                                    boolean tmp_use = false;//TODO: 我不知道他马的这泌阳是怎么跑起来的
                                    for (String iterable_element : ((List<String>)var11.e("animation_"))) {
                                        // var11.e("animation_").iterator()
                                    }
                                    while (var46.hasNext()) {
                                        String var47 = (String) var46.next();
                                        String var48 = var47.substring("animation_".length());
                                        com.corrodinggames.rts.game.units.custom.f_f6 var49 = new com.corrodinggames.rts.game.units.custom.f_f6(
                                                var48);
                                        var49.a(var17, var11, var47, "");
                                        var17.dr.add(var49);
                                        tmp_use=true;
                                    }

                                    var17.ds = var17.a(com.corrodinggames.rts.game.units.custom.n.move, var17.ds, true);
                                    var17.dt = var17.a(com.corrodinggames.rts.game.units.custom.n.idle, var17.dt, true);
                                    var17.du = var17.a(com.corrodinggames.rts.game.units.custom.n.attack, var17.du,
                                            true);
                                    var17.dw = var17.a(com.corrodinggames.rts.game.units.custom.n.underConstruction);
                                    var17.dx = var17.a(
                                            com.corrodinggames.rts.game.units.custom.n.underConstructionWithLinkedBuiltTime);
                                    if (var17.dw != null && var17.dx != null) {
                                        throw new RuntimeException(
                                                "Cannot use underConstruction and underConstructionWithLinkedBuiltTime animations at the same time");
                                    }

                                    var17.dv = var17.a(com.corrodinggames.rts.game.units.custom.n.created);
                                    var17.dy = var17.a(com.corrodinggames.rts.game.units.custom.n.queuedUnits);
                                    if (var17.dy != null) {
                                        var17.bg = true;
                                    }

                                    var17.dz = var17.a(com.corrodinggames.rts.game.units.custom.n.repair);
                                    var17.dA = var17.a(com.corrodinggames.rts.game.units.custom.n.reclaim);
                                    var17.cL.c = var11.g(var12, "maxHp");
                                    var17.cL.g = var11.b(var12, "maxShield", 0);
                                    var17.cM = var11.a(var12, "startShieldAtZero", false);
                                    var17.cL.h = (float) var11.a(var12, "shieldRegen", 0.25F);
                                    var17.cU = var11.a(var12, "shieldDisplayOnlyDeflection", false);
                                    var17.cV = (float) var11.a(var12, "shieldDeflectionDisplayRate", 4.0F);
                                    var17.cL.l = (float) var11.a(var12, "armour", 0.0F);
                                    var17.cN = (float) var11.a(var12, "armourMinDamageToKeep", 1.0F);
                                    var17.cL.d = (float) var11.a(var12, "energyMax", 0.0F);
                                    var17.cO = var11.a(var12, "startEnergyAtZero", false);
                                    var17.cP = (float) var11.a(var12, "energyRegen", 0.0F);
                                    var17.cS = (float) var11.a(var12, "energyStartingPercentage", 1.0F);
                                    var17.cR = var11.a(var12, "energyNeedsToRechargeToFull", false);
                                    var17.cQ = (float) var11.a(var12, "energyRegenWhenRecharging", var17.cP);
                                    var17.cT = a((IniFile) var11, (String) var12, "energyDisplayName", (String) null);
                                    var17.cW = var11.g(var12, "radius");
                                    var17.dd = var11.b(var12, "displayRadius", var17.cW);
                                    float var115 = (float) var17.cW;
                                    if (var115 < 6.0F) {
                                        var115 = 6.0F;
                                    }

                                    var17.de = (float) var11.a(var12, "uiTargetRadius", var115);
                                    var17.df = var11.b(var12, "shieldRenderRadius", var17.cW);
                                    var17.dg = var11.b(var12, "buildingSelectionOffset", 0);
                                    var17.cX = var11.a(var12, "footprint", var17.cX);
                                    var17.cY = var11.a(var12, "constructionFootprint", var17.cY);
                                    var17.cZ.a(var17.cX);
                                    var17.cZ = var11.a(var12, "displayFootprint", var17.cZ);
                                    var17.da = (float) var11.a(var12, "buildingToFootprintOffsetX", 10.0F);
                                    var17.db = (float) var11.a(var12, "buildingToFootprintOffsetY", 10.0F);
                                    var17.cW = (int) ((float) var17.cW * var17.aG);
                                    var17.dd = (int) ((float) var17.dd * var17.aG);
                                    var17.cL.n = var11.b(var12, "fogOfWarSightRange", 15);
                                    var17.dh = var11.b(var12, "fogOfWarSightRangeWhileNotBuilt", -1);
                                    var17.di = (float) var11.a(var12, "exit_x", 0.0F);
                                    var17.dj = (float) var11.a(var12, "exit_y", 9.0F);
                                    var17.dk = var11.a(var12, "exit_dirOffset", (Float) null);
                                    var17.dl = (float) var11.a(var12, "exit_heightOffset", 0.0F);
                                    var17.dm = var11.a(var12, "exitHeightIgnoreParent", false);
                                    var17.dn = (float) var11.a(var12, "exit_moveAwayAmount", 70.0F);
                                    var17.eB = var11.b(var12, "softCollisionOnAll", 0);
                                    var17.eC = var11.a(var12, "disableAllUnitCollisions", false);
                                    if (var17.eC) {
                                        var17.cX.a(0, 0, -1, -1);
                                    }

                                    var17.eJ = var11.a(var12, "hideScorchMark", false);
                                    var17.eK = var11.a(var13, "disableLowHpFire", var17.eD);
                                    var17.eL = var11.a(var13, "disableLowHpSmoke", var17.eD);
                                    var17.aH = var11.a(var12, "isBuilding", false);
                                    var17.aI = var11.a(var12, "ignoreInUnitCapCalculation", var17.aH);
                                    var17.aJ = var11.a(var12, "placeOnlyOnResPool", false);
                                    var17.aK = var11.a(var12, "isUnrepairableUnit", false);
                                    var17.aL = (float) var11.a(var12, "extraBuildRangeWhenBuildingThis", 0.0F);
                                    var17.aM = var11.a(var12, "isUnselectable", false);
                                    var17.aN = var11.a(var12, "isUnselectableAsTarget", var17.aM);
                                    var17.fO = var11.a(var17, var12, "showActionsWithMixedSelectionIfOtherUnitsHaveTag",
                                            (com.corrodinggames.rts.game.units.custom.h) null);
                                    var17.aO = var11.a(var12, "canNotBeDirectlyAttacked", false);
                                    var17.aP = var11.a(var12, "canNotBeDamaged", var17.aO);
                                    var17.aQ = var11.a(var12, "showOnMinimap", true);
                                    var17.aR = var11.a(var12, "showOnMinimapToEnemies", var17.cL.m);
                                    var17.aS = var11.a(var17, var12, "canOnlyBeAttackedByUnitsWithTags",
                                            (com.corrodinggames.rts.game.units.custom.h) null);
                                    if (var17.aO && var17.aS != null) {
                                        throw new RuntimeException(
                                                "canNotBeDirectlyAttacked and canOnlyBeAttackedByUnitsWithTags cannot be used at the same time");
                                    }

                                    var17.aT = var11.a(var12, "canNotBeGivenOrdersByPlayer", false);
                                    var17.aU = var11.a(var12, "canRepairBuildings", false);
                                    var17.aV = var11.a(var12, "canRepairUnits", false);
                                    var17.aW = var11.a(var12, "autoRepair", false);
                                    if (var17.aW) {
                                        var17.a(com.corrodinggames.rts.game.units.custom.b.b.a);
                                    }

                                    var17.cL.o = var11.b(var12, "nanoRange", -1);
                                    if (var17.cL.o != -1) {
                                        com.corrodinggames.rts.game.units.custom.as var10000 = var17.cL;
                                        var10000.o = (int) ((float) var10000.o * var17.aG);
                                    }

                                    var17.aY = var11.a(var12, "nanoRangeForRepairIsMelee", false);
                                    if (var17.aY) {
                                        var17.aX = 5;
                                    }

                                    int var116 = var11.b(var12, "nanoRangeForRepair", -1);
                                    if (var116 != -1) {
                                        var17.aX = var116;
                                        var17.aX = (int) ((float) var17.aX * var17.aG);
                                    }

                                    var17.ba = var11.a(var12, "nanoRangeForReclaimIsMelee", false);
                                    if (var17.ba) {
                                        var17.aZ = 5;
                                    }

                                    int var117 = var11.b(var12, "nanoRangeForReclaim", -1);
                                    if (var117 != -1) {
                                        var17.aZ = var117;
                                        var17.aZ = (int) ((float) var17.aZ * var17.aG);
                                    }

                                    var17.bb = (float) var11.a(var12, "nanoRepairSpeed", 0.2F);
                                    float var118 = 5.1F;
                                    var17.bc = (float) var11.a(var12, "nanoReclaimSpeed", var17.bb * 5.1F);
                                    var17.bd = (float) var11.a(var12, "resourceReclaimMultiplier", 1.0F);
                                    var17.be = (float) var11.a(var12, "nanoUnbuildSpeed", 1.0F) * 0.001F * 5.1F;
                                    var17.bf = (float) var11.a(var12, "nanoBuildSpeed", 1.0F);
                                    var17.cL.r = (float) var11.a(var12, "nanoFactorySpeed", 1.0F);
                                    var17.cL.p = (float) var11.a(var12, "selfRegenRate", 0.0F);
                                    var17.bh = var11.d(var12, "selfBuildRate", 0.0F);
                                    var17.bi = var11.a(var12, "dieOnConstruct", false);
                                    var17.bk = var11.a(var12, "dieOnZeroEnergy", false);
                                    byte var50 = 4;
                                    if (var17.cL.b > 30000.0F) {
                                        var50 = 8;
                                    }

                                    if (var17.aH) {
                                        var50 = 7;
                                    }

                                    var17.bq = var11.b(var12, "numBitsOnDeath", Integer.valueOf(var50));
                                    var17.bn = var11.a(var12, "nukeOnDeath", false);
                                    var17.bo = (float) var11.a(var12, "nukeOnDeathRange", 250.0F);
                                    var17.bp = (float) var11.a(var12, "nukeOnDeathDamage", 5400.0F);
                                    var17.br = var11.a(var12, "nukeOnDeathDisableWhenNoNuke", false);
                                    var17.bm = var11.b(var12, "fireOnDeath", 0);
                                    var17.bt = (com.corrodinggames.rts.game.units.UnitSize) var11.a(var12,
                                            "explodeTypeOnDeath", (Enum) null,
                                            com.corrodinggames.rts.game.units.UnitSize.class);
                                    var17.bu = var11.a(var12, "explodeOnDeath", true);
                                    var17.bs = var11.a(var12, "disableDeathOnZeroHp", false);
                                    boolean var51 = var11.a(var12, "explodeOnDeathGroundCollosion", true);
                                    var51 = var11.a(var12, "explodeOnDeathGroundCollision", var51);
                                    var17.bv = var51;
                                    var17.by = var17.a(var11.b(var12, "effectOnDeath", (String) null), (z) null);
                                    var17.bx = var17.a(var11.b(var12, "effectOnDeathIfUnbuilt", (String) null),
                                            (z) null);
                                    var17.bz = bl.a(var17, var11.b(var12, "soundOnDeath", (String) null));
                                    String var52 = var11.b(var12, "effectOnDeathGroundCollosion", (String) null);
                                    var52 = var11.b(var12, "effectOnDeathGroundCollision", var52);
                                    var17.bw = var17.a(var52, (z) null);
                                    var17.bC = bp.a(var17, var11, var12, "unitsSpawnedOnDeath");
                                    var17.bD = var11.a(var12, "unitsSpawnedOnDeath_setToTeamOfLastAttacker", false);
                                    var17.fk = var11.a(var12, "canReclaimResources", false);
                                    var17.fl = var11.a(var17, var12, "canReclaimResourcesOnlyWithTags",
                                            (com.corrodinggames.rts.game.units.custom.h) null);
                                    var17.fm = var11.b(var12, "canReclaimResourcesNextSearchRange", 500);
                                    var17.fn = var11.a(var17, var12, "canReclaimUnitsOnlyWithTags",
                                            (com.corrodinggames.rts.game.units.custom.h) null);
                                    var17.fo = var11.a(var17, var12, "canRepairUnitsOnlyWithTags",
                                            (com.corrodinggames.rts.game.units.custom.h) null);
                                    if (var17.fn != null && !var17.aV && !var17.aU) {
                                        throw new RuntimeException(
                                                "canReclaimUnitsOnlyWithTags requires canRepairUnits:true or canRepairBuildings:true");
                                    }

                                    if (var17.fo != null && !var17.aV && !var17.aU) {
                                        throw new RuntimeException(
                                                "canRepairUnitsOnlyWithTags requires canRepairUnits:true or canRepairBuildings:true");
                                    }

                                    var17.eM = var11.b(var12, "maxTransportingUnits", 0);
                                    if (var17.eM < 0) {
                                        throw new RuntimeException("maxTransportingUnits cannot be < 0");
                                    }

                                    var17.eN = var11.b(var12, "transportUnitsUnloadDelayBetweenEachUnit", 30.0F);
                                    var17.eP = com.corrodinggames.rts.game.units.custom.g
                                            .a(var11.b(var12, "transportUnitsRequireTag", (String) null));
                                    String var53 = var11.b(var12, "transportUnitsRequireMovementType", (String) null);
                                    String var57;
                                    if (var53 != null) {
                                        String[] var54 = var53.split(",");
                                        int var55 = var54.length;

                                        for (int var56 = 0; var56 < var55; ++var56) {
                                            var57 = var54[var56];
                                            var57 = var57.trim();
                                            var17.eQ.add(UnitMovementType.a(var57, "transportUnitsRequireMovementType"));
                                        }
                                    }

                                    var17.eO = var11.a(var12, "transportUnitsEachUnitAlwaysUsesSingleSlot", false);
                                    var17.eR = var11.a(var12, "transportUnitsBlockAirAndWaterUnits",
                                            var17.eQ.size() == 0);
                                    var17.eS = var11.a(var12, "transportUnitsBlockOtherTransports", true);
                                    var17.eU = var11.a(var17, var12, "transportUnitsKeepBuiltUnits",
                                            LogicBoolean.falseBoolean);
                                    var17.eV = var11.a(var17, var12, "transportUnitsKillOnDeath",
                                            LogicBoolean.trueBoolean);
                                    var17.eW = var11.a(var17, var12, "transportUnitsKeepWaypoints",
                                            LogicBoolean.falseBoolean);
                                    var17.eY = (float) var11.a(var12, "transportUnitsHealBy", 0.0F);
                                    var17.fc = var11.a(var17, var12, "transportUnitsCanUnloadUnits",
                                            (LogicBoolean) null);
                                    if (var17.fc != null) {
                                        var17.fd = var17.fc;
                                    } else {
                                        var17.fc = com.corrodinggames.rts.game.units.custom.l.fa;
                                        var17.fd = com.corrodinggames.rts.game.units.custom.l.fb;
                                    }

                                    var17.eT = var11.a(var12, "transportUnitsAddUnloadOption",
                                            var17.fc != LogicBoolean.falseBoolean);
                                    var17.eX = var11.a(var12, "transportUnitsOnTeamChangeKeepCurrentTeam", var17.eX);
                                    var17.eZ = var11.b(var12, "transportSlotsNeeded", 1);

                                    int var119;
                                    String var120;
                                    String var123;
                                    for (var119 = -1; var119 <= 29; ++var119) {
                                        var120 = "builtFrom_" + var119 + "_";
                                        if (var119 == -1) {
                                            var120 = "builtFrom_";
                                        }

                                        var123 = var120 + "name";
                                        var57 = var11.b(var12, var123, (String) null);
                                        if (var57 != null) {
                                            String[] var58 = var57.split(",");
                                            String[] var59 = var58;
                                            int var60 = var58.length;

                                            for (int var61 = 0; var61 < var60; ++var61) {
                                                String var62 = var59[var61];
                                                var62 = var62.trim();
                                                if (!var62.equals("")) {
                                                    p var63 = new p();
                                                    var63.a = var62;
                                                    var63.b = (float) var11.a(var12, var120 + "pos", 999.0F);
                                                    var63.c = var11.a(var12, var120 + "forceNano", false);
                                                    var63.d = "[" + var12 + "]" + var123;
                                                    var63.f = var11.a(var17, var12, var120 + "isLocked",
                                                            (LogicBoolean) null);
                                                    var63.g = a((IniFile) var11, (String) var12, var120 + "isLockedMessage",
                                                            (String) null);
                                                    if (var63.f == LogicBoolean.falseBoolean) {
                                                        var63.f = null;
                                                    }

                                                    if (!"NONE".equalsIgnoreCase(var62)) {
                                                        var17.gg.add(var63);
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    for (var119 = 0; var119 <= 50; ++var119) {
                                        var120 = var11.b(var12, "canBuild_" + var119 + "_name", (String) null);
                                        if (var120 != null) {
                                            var123 = "canBuild_" + var119 + "_";
                                            b(var17, var11, var12, var123, false);
                                        }
                                    }

                                    Iterator var121 = var11.e("canBuild_").iterator();

                                    while (var121.hasNext()) {
                                        var120 = (String) var121.next();
                                        b(var17, var11, var120, "", true);
                                    }

                                    var17.ff = be.a(var17, var11);
                                    String var122 = var11.e(var15, "movementType");
                                    var17.fg = UnitMovementType.a(var122, "movementType");
                                    if (!var17.aH) {
                                        var17.fh = var17.fg;
                                    } else {
                                        var17.fh = UnitMovementType.NONE;
                                    }

                                    Boolean var124 = var11.a(var16, "useAsBuilder", (Boolean) null);
                                    var17.fs = var11.a(var16, "useAsAttacker", true);
                                    Boolean var125 = var11.a(var12, "isBuilder", (Boolean) null);
                                    if (var125 == null) {
                                        if (var124 == null) {
                                            var125 = false;
                                        } else {
                                            var125 = var124;
                                        }
                                    } else if (var124 == null) {
                                        var124 = var125;
                                    }

                                    if (var124 == null) {
                                        var124 = false;
                                    }

                                    var17.fp = var125;
                                    var17.fq = var124;
                                    if (!var17.fp && var17.fq) {
                                        throw new RuntimeException(
                                                "Cannot tell AI to use a non-builder as builder [ai]useAsBuilder:"
                                                        + var17.fq + " [core]isBuilder:" + var17.fp);
                                    }

                                    if (var17.fk) {
                                        var17.fr = true;
                                    }

                                    Boolean var126 = var11.a(var16, "useAsHarvester", (Boolean) null);
                                    if (var126 != null) {
                                        var17.fr = var126;
                                    }

                                    Boolean var127 = var11.a(var16, "useAsTransport", (Boolean) null);
                                    if (var127 == null) {
                                        var127 = var17.eM > 0 && !var17.fq && !var17.aH;
                                        if (!var17.eT) {
                                            var127 = false;
                                        }
                                    }

                                    var17.ft = var127;
                                    if (var17.aH) {
                                        var17.as = com.corrodinggames.rts.game.units.d.d.q;
                                    } else if (var17.fg == UnitMovementType.AIR) {
                                        var17.as = com.corrodinggames.rts.game.units.b.AirUnit.n;
                                    } else if (var17.fg == UnitMovementType.WATER) {
                                        var17.as = com.corrodinggames.rts.game.units.h.f.q;
                                    } else if (var17.fg == UnitMovementType.HOVER) {
                                        if (var17.cm) {
                                            var17.as = com.corrodinggames.rts.game.units.e.j.dO;
                                        } else if (var17.l()) {
                                            var17.as = com.corrodinggames.rts.game.units.e.b.h;
                                        } else {
                                            var17.as = com.corrodinggames.rts.game.units.e.h.n;
                                        }
                                    } else if (var17.cm) {
                                        var17.as = com.corrodinggames.rts.game.units.e.j.dO;
                                    } else if (var17.l()) {
                                        var17.as = com.corrodinggames.rts.game.units.e.b.h;
                                    } else {
                                        var17.as = com.corrodinggames.rts.game.units.e.j.dN;
                                    }

                                    com.corrodinggames.rts.gameFramework.m.Texture_M var128 = var17.a(var11, var13,
                                            "icon_zoomed_out", false);
                                    if (var128 != null) {
                                        var17.as = var17.a(var128, var17.ac);
                                    }

                                    if (var11.a(var13, "icon_zoomed_out_neverShow", false)) {
                                        var17.as = null;
                                    }

                                    var17.t = var11.a(var13, "showHealthBar", true);
                                    var17.u = var11.a(var13, "showHealthBarChanges", true);
                                    var17.v = var11.a(var13, "showEnergyBar", true);
                                    var17.w = var11.a(var13, "showShotDelayBar", true);
                                    var17.x = var11.a(var13, "showTransportBar", true);
                                    var17.y = var11.a(var13, "showShieldBar", true);
                                    var17.z = var11.a(var13, "showQueueBar", true);
                                    var17.A = var11.a(var13, "showSelectionIndicator", true);
                                    var17.fi = var11.a(var15, "slowDeathFall", false);
                                    var17.fj = var11.a(var15, "slowDeathFallSmoke", true);
                                    var17.cL.j = (float) var11.a(var15, "moveSpeed", 1.0F) * var17.aG;
                                    var17.dN = (float) var11.a(var15, "moveAccelerationSpeed", 1.0F) * var17.aG;
                                    var17.dO = (float) var11.a(var15, "moveDecelerationSpeed", 1.0F) * var17.aG;
                                    Boolean var129 = var11.a(var15, "ignoreMoveOrders", (Boolean) null);
                                    if (var17.aH) {
                                        var17.dP = true;
                                    }

                                    if (var129 != null) {
                                        if (var129) {
                                            var17.dP = true;
                                            if (var17.cL.j > 0.0F) {
                                                throw new RuntimeException(
                                                        "[movement]ignoreMoveOrders expects moveSpeed=0");
                                            }
                                        } else if (var17.aH) {
                                            throw new RuntimeException(
                                                    "[movement]ignoreMoveOrders=false not yet supported on buildings");
                                        }
                                    }

                                    var17.ej = (float) var11.a(var15, "moveYAxisScaling", 1.0F);
                                    if (var17.ej <= 0.0F) {
                                        throw new RuntimeException("[movement]moveYAxisScaling must be > 0");
                                    }

                                    var17.ek = 1.0F / var17.ej;
                                    var17.el = (float) var11.a(var15, "reverseSpeedPercentage", 0.6F);
                                    String var130 = var11.b(var15, "landOnGround", "false");
                                    if (var130.equalsIgnoreCase("false")) {
                                        var17.dQ = false;
                                    } else if (var130.equalsIgnoreCase("onlyIdle")) {
                                        var17.dQ = true;
                                        var17.dR = true;
                                    } else {
                                        if (!var130.equalsIgnoreCase("true")) {
                                            throw new RuntimeException(
                                                    "landOnGround expected:true, false, onlyIdle, not:" + var130);
                                        }

                                        var17.dQ = true;
                                    }

                                    float var131 = 0.0F;
                                    float var132 = 0.0F;
                                    if (var17.fg == UnitMovementType.AIR) {
                                        var131 = 35.0F;
                                        var132 = 1.5F;
                                    }

                                    var17.dS = (float) var11.a(var15, "startingHeightOffset", 0.0F);
                                    var17.cL.q = (float) var11.a(var15, "targetHeight", var131);
                                    var17.dT = (float) var11.a(var15, "targetHeightDrift", var132);
                                    if (var17.cL.q > 80.0F) {
                                        var17.B = true;
                                    }

                                    var17.dU = (float) var11.a(var15, "heightChangeRate", var17.dU);
                                    var17.dV = (float) var11.a(var15, "fallingAcceleration", var17.dV);
                                    var17.dW = (float) var11.a(var15, "fallingAccelerationDead", var17.dW);
                                    var17.cL.k = (float) var11.a(var15, "maxTurnSpeed", 1.0F);
                                    var17.eo = (float) var11.a(var15, "turnAcceleration", 1.0F);
                                    var17.dX = var11.a(var15, "moveSlidingMode", false);
                                    var17.dY = var11.a(var15, "moveIgnoringBody", false);
                                    var17.dZ = var11.b(var15, "moveSlidingDir", -1);
                                    var17.ei = var11.a(var15, "joinsGroupFormations", true);
                                    var17.ea = (float) var11.a(var14, "turretSize", 1.0F) * var17.aG;
                                    var17.eb = (float) var11.a(var14, "turretTurnSpeed", 8.0F);
                                    var17.dL = var11.a(var14, "turretRotateWithBody", true);
                                    String var64 = var11.b(var14, "attackMovement", "normal");
                                    var17.ec = com.corrodinggames.rts.game.units.UnitBehaviorType.normal;
                                    if (var64.equalsIgnoreCase("normal")) {
                                        var17.ec = com.corrodinggames.rts.game.units.UnitBehaviorType.normal;
                                    }

                                    if (var64.equalsIgnoreCase("strafing")) {
                                        var17.ec = com.corrodinggames.rts.game.units.UnitBehaviorType.strafing;
                                    }

                                    if (var64.equalsIgnoreCase("bomber")) {
                                        var17.ec = com.corrodinggames.rts.game.units.UnitBehaviorType.bomber;
                                    }

                                    var17.ef = var11.a(var14, "disablePassiveTargeting", false);
                                    var17.eg = var11.a(var14, "stopTargetingAfterFiring", false);
                                    var17.eh = var11.a(var14, "turretMultiTargeting", false);
                                    var17.ed = (float) var11.a(var14, "attackMovementSpeed", 1.0F);
                                    var17.ee = (float) var11.a(var14, "attackMovementSpread", 1.0F);
                                    Float var65 = var11.a(var14, "maxAttackRange", (Float) null);
                                    boolean var66;
                                    if (var65 != null) {
                                        var66 = true;
                                        var17.cL.i = var65 * var17.aG;
                                    } else {
                                        var66 = false;
                                        var17.cL.i = 100.0F * var17.aG;
                                    }

                                    var17.ez = (float) var11.a(var14, "aimOffsetSpread", 0.6F);
                                    var17.dM = var11.b(var14, "shootDelay", 50.0F);
                                    var17.cL.e = (float) var11.a(var14, "shootDelayMultiplier", 1.0F);
                                    var17.cL.f = (float) var11.a(var14, "shootDamageMultiplier", 1.0F);
                                    var17.dK = var11.a(var14, "showRangeUIGuide", (Boolean) null);
                                    var17.eF = var11.a(var14, "isMelee", false);
                                    var17.eG = 0.0F;
                                    Float var67 = var11.a(var14, "meleeEngangementDistance", (Float) null);
                                    if (var17.eF) {
                                        var17.eG = 250.0F;
                                        if (var67 != null) {
                                            var17.eG = var67;
                                        }
                                    } else if (var67 != null) {
                                        throw new RuntimeException(
                                                "[attack]meleeEngangementDistance can only be used with isMelee:true");
                                    }

                                    a(var94, ah.unitParsePartA);
                                    Iterator var68 = var11.e("projectile_").iterator();

                                    while (var68.hasNext()) {
                                        String var69 = (String) var68.next();
                                        String var70 = var69.substring("projectile_".length());
                                        if (var17.f(var70) != null) {
                                            throw new RuntimeException(
                                                    "Two projectiles found with the same name:" + var70);
                                        }

                                        bh var71 = new bh();
                                        var71.bh = var70;
                                        var71.bj = var17;
                                        bh.a(var71, var17, var11, var69);
                                    }

                                    int var133 = var17.fT.size();
                                    if (var133 < 1) {
                                        var133 = 1;
                                    }

                                    var17.fR = new bh[var133];

                                    int var134;
                                    bh var135;
                                    for (var134 = 0; var134 < var17.fT.size(); ++var134) {
                                        var135 = (bh) var17.fT.get(var134);
                                        var135.bi = var134;
                                        var17.fR[var134] = var135;
                                    }

                                    for (var134 = 0; var134 < var17.fR.length; ++var134) {
                                        var135 = var17.fR[var134];
                                        if (var135 != null) {
                                            var135.w *= var17.aG;
                                            var135.au *= var17.aG;
                                            var135.aF *= var17.aG;
                                        }
                                    }

                                    if (var17.fR[0] == null) {
                                        bh var136 = new bh();
                                        var136.bi = 0;
                                        var136.bh = "1";
                                        var136.b = 10;
                                        var17.fT.add(var136);
                                        var17.fR[0] = var136;
                                    }

                                    ArrayList var137 = var17.fS;
                                    Iterator var138 = var11.e("turret_").iterator();

                                    while (var138.hasNext()) {
                                        String var139 = (String) var138.next();
                                        String var72 = var139.substring("turret_".length());
                                        if (var17.e(var72) != null) {
                                            throw new RuntimeException("Two turrets found with the same name:" + var72);
                                        }

                                        bn var73 = new bn();
                                        var73.a = var72;
                                        var73.b = var139;
                                        var137.add(var73);
                                    }

                                    var138 = var137.iterator();

                                    bn var140;
                                    while (var138.hasNext()) {
                                        var140 = (bn) var138.next();
                                        bn.a(var140, var17, var11, var140.b);
                                    }

                                    if (var137.size() == 0) {
                                        bn var141 = new bn();
                                        var141.f = 0.0F;
                                        var141.g = 0.0F;
                                        var141.a = "1";
                                        var141.m = var17.dM;
                                        var137.add(var141);
                                    }

                                    int var142;
                                    for (var142 = var137.size() - 1; var142 >= 0; --var142) {
                                        if (var137.get(var142) != null) {
                                            ((bn) var137.get(var142)).e = var142;
                                        }
                                    }

                                    for (var142 = var137.size() - 1; var142 >= 0; --var142) {
                                        if (var137.get(var142) != null) {
                                            var140 = (bn) var137.get(var142);
                                            if (var140.y != null) {
                                                var140.w = var140.y.e;
                                                if (var140.y.y != null) {
                                                    throw new RuntimeException(var140.a
                                                            + ": Turret can not be attached to turret that is also attached to a turret");
                                                }
                                            }

                                            if (var140.z != null) {
                                                var140.x = var140.z.e;
                                            }

                                            if (var140.W < 0.0F) {
                                                var140.W = var140.V;
                                            }
                                        }
                                    }

                                    if (var137.size() > 31) {
                                        throw new RuntimeException("Turret max count per unit is: 31");
                                    }

                                    var17.fQ = (bn[]) var137.toArray(new bn[0]);
                                    var17.dJ = var17.cL.i;
                                    float var145 = -1.0F;
                                    boolean var143 = true;
                                    boolean var144 = false;
                                    Iterator var146 = var137.iterator();

                                    while (var146.hasNext()) {
                                        bn var74 = (bn) var146.next();
                                        var74.X *= var17.aG;
                                        var74.f *= var17.aG;
                                        var74.g *= var17.aG;
                                        var74.Y *= var17.aG;
                                        var74.Z *= var17.aG;
                                        boolean var75 = false;
                                        if (var74.B) {
                                            if (var74.ab >= 99999.0F) {
                                                var143 = false;
                                            } else {
                                                var144 = true;
                                                if (var17.dJ > var74.ab) {
                                                    var17.dJ = var74.ab;
                                                }

                                                if (var145 < var74.ab) {
                                                    var145 = var74.ab;
                                                }

                                                if (com.corrodinggames.rts.gameFramework.GameUtils
                                                        .c(var74.ab - var17.cL.i) > 5.0F) {
                                                    boolean var76 = false;
                                                    Iterator var77 = var17.o.iterator();

                                                    while (var77.hasNext()) {
                                                        com.corrodinggames.rts.game.units.custom.y var78 = (com.corrodinggames.rts.game.units.custom.y) var77
                                                                .next();
                                                        if (com.corrodinggames.rts.gameFramework.GameUtils
                                                                .c(var74.ab - var78.a) < 5.0F) {
                                                            var76 = true;
                                                        }
                                                    }

                                                    if (!var76) {
                                                        var75 = true;
                                                    }
                                                }
                                            }
                                        }

                                        if (var74.ac != null) {
                                            var75 = var74.ac;
                                        }

                                        if (var75) {
                                            com.corrodinggames.rts.game.units.custom.y var149 = new com.corrodinggames.rts.game.units.custom.y();
                                            var149.a = var74.ab;
                                            var17.o.add(var149);
                                        }
                                    }

                                    if (var144 && var143) {
                                        if (!var66) {
                                            var17.cL.i = var145;
                                        } else if (var145 < var17.cL.i) {
                                            throw new RuntimeException(
                                                    "limitingRange as been applied to all turrets but is less than maxAttackRange (hint: unset maxAttackRange or a limitingRange, or make values match)");
                                        }
                                    }

                                    String var147 = var11.b(var14, "setMainTurretAs", (String) null);
                                    if (var147 != null) {
                                        var17.dF = var17.e(var147);
                                        if (var17.dF == null) {
                                            throw new RuntimeException(
                                                    "[attack] Could not find setMainTurretAs with name: " + var147);
                                        }
                                    } else {
                                        var17.dF = var17.e("1");
                                        if (var17.dF == null) {
                                            var17.dF = var17.fQ[0];
                                        }
                                    }

                                    var17.dG = var17.dF.e;
                                    a(var94, ah.unitParsePartB);
                                    long var148 = PerformanceProfiler.a();
                                    if (var11.l(var12, "action_")) {
                                        for (int var150 = 0; var150 <= 50; ++var150) {
                                            a(var17, var11, var12, "action_" + var150 + "_", "" + var150, false, false);
                                        }
                                    }

                                    Iterator var152 = var11.e("action_").iterator();

                                    String var151;
                                    String var154;
                                    while (var152.hasNext()) {
                                        var151 = (String) var152.next();
                                        var154 = var151.substring("action_".length());
                                        if (var17.g(var154) != null) {
                                            throw new RuntimeException(
                                                    "Two actions found with the same name:" + var154);
                                        }

                                        a(var17, var11, var151, "", var154, true, false);
                                    }

                                    var152 = var11.e("hiddenAction_").iterator();

                                    while (var152.hasNext()) {
                                        var151 = (String) var152.next();
                                        var154 = var151.substring("hiddenAction_".length());
                                        if (var17.g(var154) != null) {
                                            throw new RuntimeException(
                                                    "Two actions found with the same name:" + var154);
                                        }

                                        a(var17, var11, var151, "", var154, true, true);
                                    }

                                    a(var148, ah.actionParse);
                                    ArrayList var155 = new ArrayList();
                                    ArrayList var153 = new ArrayList();

                                    for (int var156 = 0; var156 <= 1; ++var156) {
                                        boolean var79 = var156 == 0;
                                        ArrayList var80 = var79 ? var155 : var153;

                                        for (int var81 = 1; var81 < 21; ++var81) {
                                            String var82 = var79 ? "leg_" + var81 : "arm_" + var81;
                                            if (var11.g(var82)) {
                                                ba var83 = new ba();
                                                ba.a(var83, var17, var11, var82, var79, var80);
                                                var80.add(var83);
                                            } else {
                                                var80.add((Object) null);
                                            }
                                        }
                                    }

                                    ArrayList<ba> var158 = new ArrayList<ba>();
                                    Iterator var157 = var155.iterator();

                                    ba var160;
                                    while (var157.hasNext()) {
                                        var160 = (ba) var157.next();
                                        if (var160 != null) {
                                            var158.add(var160);
                                        }
                                    }

                                    var157 = var153.iterator();

                                    while (var157.hasNext()) {
                                        var160 = (ba) var157.next();
                                        if (var160 != null) {
                                            var158.add(var160);
                                        }
                                    }

                                    for (int var159 = var158.size() - 1; var159 >= 0; var160.a = var159--) {
                                        var160 = (ba) var158.get(var159);
                                    }

                                    var17.ax = (ba[]) var158.toArray(new ba[0]);
                                    if (var17.ax.length > 0) {
                                        var17.a(com.corrodinggames.rts.game.units.custom.b.h.a);
                                    }

                                    var157 = var17.dr.iterator();
                                    while (var157.hasNext()&&!tmp_use) {//TODO: 原先没有tmp_use  这个逼代码真是脑脑瘫
                                        com.corrodinggames.rts.game.units.custom.f_f6 var162 = (com.corrodinggames.rts.game.units.custom.f_f6) var157
                                                .next();
                                        var162.a(var17);
                                    }

                                    b(var17);
                                    String var161 = var11.b(var12, "fireTurretXAtSelfOnDeath", (String) null);
                                    if (var161 != null && !"NONE".equalsIgnoreCase(var161)) {
                                        bn var163 = var17.e(var161);
                                        if (var163 == null) {
                                            throw new RuntimeException("Cannot find turret:" + var161 + " for [" + var12
                                                    + "]fireTurretXAtSelfOnDeath");
                                        }

                                        var17.bB = var163.e;
                                    }

                                    com.corrodinggames.rts.game.units.custom.b.c.a(var17, var11);
                                    var17.bj = var11.a(var14, "dieOnAttack", false);
                                    var17.bl = var11.a(var14, "removeOnAttack", false);
                                    var17.ep = var11.d(var14, "canAttack");
                                    if (var17.ep) {
                                        var17.eq = var11.a(var17, var14, "canAttackFlyingUnits");
                                        var17.er = var11.a(var17, var14, "canAttackLandUnits");
                                        var17.es = var11.a(var17, var14, "canAttackUnderwaterUnits");
                                    } else {
                                        var17.eq = var11.a(var17, var14, "canAttackFlyingUnits",
                                                LogicBoolean.falseBoolean);
                                        var17.er = var11.a(var17, var14, "canAttackLandUnits",
                                                LogicBoolean.falseBoolean);
                                        var17.es = var11.a(var17, var14, "canAttackUnderwaterUnits",
                                                LogicBoolean.falseBoolean);
                                    }

                                    var17.et = var11.a(var17, var14, "canAttackNotTouchingWaterUnits",
                                            (LogicBoolean) null);
                                    if (LogicBoolean.isStaticTrue(var17.et)) {
                                        var17.et = null;
                                    }

                                    var17.ev = var11.a(var17, var14, "canOnlyAttackUnitsWithTags",
                                            (com.corrodinggames.rts.game.units.custom.h) null);
                                    var17.ew = var11.a(var17, var14, "canOnlyAttackUnitsWithoutTags",
                                            (com.corrodinggames.rts.game.units.custom.h) null);
                                    if (var17.ev != null || var17.ew != null) {
                                        var17.eu = true;
                                    }

                                    boolean var165 = false;
                                    boolean var164 = false;
                                    Iterator var166 = var137.iterator();

                                    while (true) {
                                        while (true) {
                                            bn var168;
                                            do {
                                                if (!var166.hasNext()) {
                                                    if (var165 && !var164) {
                                                        var17.ex = true;
                                                        var17.eu = true;
                                                    }

                                                    var17.ey = var11.a(var14, "isFixedFiring", false);
                                                    var17.fM = var11.a(var16, "lowPriorityTargetForOtherUnits", false);
                                                    var17.fN = var11.a(var16, "notPassivelyTargetedByOtherUnits",
                                                            false);
                                                    if (var17.ep && var17.fN) {
                                                        throw new RuntimeException(
                                                                "[ai]notPassivelyTargetedByOtherUnits is cannot currently supported on units that can attack");
                                                    }

                                                    var17.fv = var11.a(var17, var16, "aiTags",
                                                            (com.corrodinggames.rts.game.units.custom.h) null);
                                                    var17.fw = var11.a(var16, "disableUse", false);
                                                    var17.fz = (float) var11.a(var16, "buildPriority", 0.05F);
                                                    var17.fA = var11.b(var16, "recommendedInEachBaseNum", 0);
                                                    var17.fB = (float) var11.a(var16,
                                                            "recommendedInEachBasePriorityIfUnmet", 0.5F);
                                                    var17.fy = var11.b(var16, "maxEachBase",
                                                            com.corrodinggames.rts.gameFramework.GameUtils.b(2,
                                                                    var17.fA));
                                                    var17.fx = var11.b(var16, "maxGlobal", -1);
                                                    if (var17.fy < var17.fA) {
                                                        throw new RuntimeException(
                                                                "[ai]recommendedInEachBaseNum is smaller than maxEachBase");
                                                    }

                                                    if (!var17.aH) {
                                                        if (var11.n(var16, "recommendedInEachBaseNum")) {
                                                            throw new RuntimeException(
                                                                    "[ai]recommendedInEachBaseNum currently only applies to buildings");
                                                        }

                                                        if (var11.n(var16, "recommendedInEachBasePriorityIfUnmet")) {
                                                            throw new RuntimeException(
                                                                    "[ai]recommendedInEachBasePriorityIfUnmet currently only applies to buildings");
                                                        }
                                                    }

                                                    var17.fE = var11.b(var16,
                                                            "whenUsingAsHarvester_recommendedInEachBase", -1);
                                                    var17.fF = var11.b(var16, "whenUsingAsHarvester_recommendedGlobal",
                                                            -1);
                                                    var17.fG = var11.a(var16,
                                                            "whenUsingAsHarvester_includeOtherHarvesterCounts", false);
                                                    var17.fH = var11.a(var17, var16,
                                                            "onlyUseAsHarvester_ifBaseHasUnitTagged",
                                                            (com.corrodinggames.rts.game.units.custom.h) null);
                                                    var17.fC = (float) var11.a(var16, "nonInBaseExtraPriority", 0.04F);
                                                    var17.fC = (float) var11.a(var16, "noneInBaseExtraPriority",
                                                            var17.fC);
                                                    var17.fD = (float) var11.a(var16, "nonGlobalExtraPriority", 0.0F);
                                                    var17.fD = (float) var11.a(var16, "noneGlobalExtraPriority",
                                                            var17.fD);
                                                    var17.fI = var11.b(var16, "upgradedFrom", (String) null);
                                                    Float var167 = var11.a(var16, "ai_upgradePriority", (Float) null);
                                                    if (var167 != null && var167 != -1.0F) {
                                                        if (!(var167 >= 0.0F) || !(var167 <= 1.0F)) {
                                                            throw new RuntimeException(
                                                                    "[ai]ai_upgradePriority: " + var17.fK
                                                                            + " must be between 0-1 or -1 for default");
                                                        }

                                                        var17.fK = var167 * 100.0F;
                                                    }

                                                    if (var17.ep) {
                                                        for (int var169 = 0; var169 < var17.fQ.length; ++var169) {
                                                            bn var84 = var17.fQ[var169];
                                                            if (var84.B && var84.ao == null && var17.w) {
                                                                if (var84.m > 140.0F && (var17.em == -1
                                                                        || var17.fQ[var17.em].m < var84.m)) {
                                                                    var17.em = var169;
                                                                }

                                                                if (var84.n > 80.0F) {
                                                                    var17.en = var169;
                                                                }
                                                            }
                                                        }
                                                    }

                                                    if (var17.cI == -2) {
                                                        if (var17.fg == UnitMovementType.AIR) {
                                                            var17.cI = 5;
                                                        } else if (var17.j()) {
                                                            if (var17.al != null) {
                                                                var17.cI = 3;
                                                            } else {
                                                                var17.cI = 2;
                                                            }
                                                        } else if (var17.cL.q < -2.0F) {
                                                            var17.cI = 1;
                                                        } else if (var17.eM > 0) {
                                                            var17.cI = 3;
                                                        } else {
                                                            var17.cI = 2;
                                                        }
                                                    }

                                                    if (var17.fW.size() > 0) {
                                                        var17.fX = true;
                                                        com.corrodinggames.rts.gameFramework.utility.m var170 = new com.corrodinggames.rts.gameFramework.utility.m();
                                                        com.corrodinggames.rts.gameFramework.utility.m var171 = new com.corrodinggames.rts.gameFramework.utility.m();
                                                        com.corrodinggames.rts.gameFramework.utility.m var85 = new com.corrodinggames.rts.gameFramework.utility.m();
                                                        Iterator var86 = var17.fW.iterator();

                                                        while (var86.hasNext()) {
                                                            r var87 = (r) var86.next();
                                                            if (var87.c == com.corrodinggames.rts.game.units.custom.s.everyFramea) {
                                                                var170.add(var87);
                                                            } else if (var87.c == com.corrodinggames.rts.game.units.custom.s.every4Frames) {
                                                                var171.add(var87);
                                                            } else {
                                                                if (var87.c != com.corrodinggames.rts.game.units.custom.s.every8Frames) {
                                                                    throw new RuntimeException(
                                                                            "Unknown check rate:" + var87.c);
                                                                }

                                                                var85.add(var87);
                                                            }
                                                        }

                                                        var17.fY = (r[]) var170.toArray(new r[0]);
                                                        var17.fZ = (r[]) var171.toArray(new r[0]);
                                                        var17.ga = (r[]) var85.toArray(new r[0]);
                                                    }

                                                    Iterator var172;
                                                    if (var17.gp != null && var17.gp.size() > 0) {
                                                        var172 = var17.gp.iterator();

                                                        while (var172.hasNext()) {
                                                            u var173 = (u) var172.next();
                                                            var173.a(var17);
                                                        }
                                                    }

                                                    if (var17.gb.a > 0) {
                                                        var172 = var17.gb.iterator();

                                                        while (var172.hasNext()) {
                                                            t var174 = (t) var172.next();
                                                            var174.a(var17);
                                                        }

                                                        var17.gb.clear();
                                                    }

                                                    a(var94, ah.unitParsePartC);
                                                    var11.b();
                                                    var172 = var11.d.iterator();

                                                    String var176;
                                                    do {
                                                        if (!var172.hasNext()) {
                                                            var172 = var11.e.iterator();

                                                            do {
                                                                if (!var172.hasNext()) {
                                                                    if (var4 != null) {
                                                                        ++var4.E;
                                                                    }

                                                                    synchronized (com.corrodinggames.rts.game.units.custom.l.c) {
                                                                        com.corrodinggames.rts.game.units.custom.l.c
                                                                                .add(var17);
                                                                    }

                                                                    a(var94, ah.unitParsePartD);
                                                                    return var17;
                                                                }

                                                                String var177 = (String) var172.next();
                                                                var176 = "Skipping line, unexpected format: '" + var177
                                                                        + "'";
                                                                var17.r(var176);
                                                            } while (var17.R < 1);

                                                            com.corrodinggames.rts.gameFramework.GameEngine
                                                                    .log("Converting warning to error (meta.strictLevel="
                                                                            + var17.R + ")");
                                                            throw new bo(var176);
                                                        }

                                                        ac var175 = (ac) var172.next();
                                                        if (var175.a() != null
                                                                && (var175.a().startsWith("hiddenAction_")
                                                                        || var175.a().startsWith("canBuild_"))) {
                                                            throw new RuntimeException("Error [" + var175.a() + "]"
                                                                    + var175.b() + " has been repeated");
                                                        }

                                                        var176 = "Repeated key " + var175;
                                                        var17.r(var176);
                                                    } while (var17.R < 1);

                                                    com.corrodinggames.rts.gameFramework.GameEngine
                                                            .log("Converting warning to error (meta.strictLevel="
                                                                    + var17.R + ")");
                                                    throw new bo(var176);
                                                }

                                                var168 = (bn) var166.next();
                                                if (var168.O != null && var168.O.a(var17.ev)) {
                                                    var168.O = null;
                                                }

                                                if (var168.P != null && var168.P.a(var17.ew)) {
                                                    var168.P = null;
                                                }
                                            } while (!var168.B);

                                            if (var168.O == null && var168.P == null) {
                                                var164 = true;
                                            } else {
                                                var165 = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (RuntimeException var91) {
            a((String) var0, (Exception) var91, (com.corrodinggames.rts.gameFramework.i.b) var4);
            return null;
        } catch (OutOfMemoryError var92) {
            ++l;
            a((String) var0, (Exception) (new RuntimeException(var92)),
                    (com.corrodinggames.rts.gameFramework.i.b) var4);
            return null;
        } catch (bo var93) {
            a((String) var0, (Exception) var93, (com.corrodinggames.rts.gameFramework.i.b) var4);
            return null;
        }
    }

    public static void a(String string2, Exception exception, com.corrodinggames.rts.game.units.UnitType as2) {
        com.corrodinggames.rts.gameFramework.i.b b2 = null;
        if (as2 instanceof com.corrodinggames.rts.game.units.custom.l) {
            com.corrodinggames.rts.game.units.custom.l l2 = (com.corrodinggames.rts.game.units.custom.l) as2;
            b2 = l2.J;
        }
        ag.a(string2, exception, b2);
    }

    public static String a(com.corrodinggames.rts.gameFramework.i.b b2, String string2, boolean bl2) {
        if (b2 != null) {
            String string3 = b2.q;
            string3 = com.corrodinggames.rts.gameFramework.storage.a.o(string3);
            if ((string2 = com.corrodinggames.rts.gameFramework.storage.a.o(string2)).startsWith(string3)) {
                if ((string2 = string2.substring(string3.length())).startsWith("/")) {
                    string2 = string2.substring(1);
                }
                if (string2.startsWith("\\")) {
                    string2 = string2.substring(1);
                }
            }
            if (bl2) {
                string2 = string2 + " (in mod " + b2.a() + ")";
            }
        }
        return string2;
    }

    public static void a(String string2, Exception exception, com.corrodinggames.rts.gameFramework.i.b b2) {
        String string3;
        com.corrodinggames.rts.gameFramework.GameEngine.b("Error while loading unit:" + string2);
        com.corrodinggames.rts.gameFramework.GameEngine.c(exception);
        if (string2 == null) {
            string2 = "<null>";
        }
        if ((string3 = exception instanceof bo ? exception.getMessage()
                : com.corrodinggames.rts.gameFramework.GameUtils.b(exception)) == null) {
            string3 = "<No error cause>";
        }
        if (!string3.contains("unit config file")) {
            string3 = string3.replace(string2 + ": ", "");
            string3 = string3.replace(string2, "");
        }
        string2 = ag.a(b2, string2, true);
        String string4 = b2 != null ? "Error loading unit: " + string2 + ": \n" + string3
                : (string3.contains("Error loading core unit") ? string3
                        : "Error loading core unit: " + string2 + ": \n" + string3
                                + " (This might be from placing a mod in 'assets/', they should go under 'mods/')");
        if (exception instanceof bo) {
            bo bo2 = (bo) exception;
            if (bo2.c != null || bo2.d != null) {
                string4 = string4 + " (section:" + bo2.c + ", key:" + bo2.d + ")";
            }
        }
        boolean bl2 = false;
        if (b2 != null) {
            bl2 = b2.f;
        }
        if (!bl2) {
            // empty if block
        }
        if (s != null) {
            s = string4;
        }
        if (b2 == null) {
            try {
                Thread.sleep(2L);
            } catch (InterruptedException interruptedException) {
                // empty catch block
            }
            throw new RuntimeException(string4, exception);
        }
        b2.a(string4);
    }

    public static void b(com.corrodinggames.rts.game.units.custom.l l2,
            com.corrodinggames.rts.gameFramework.utility.IniFile ab2, String string2, String string3, boolean bl2)
            throws bo {
        String[] stringArray;
        String string4 = ab2.b(string2, string3 + "name", (String) null);
        if (string4 == null) {
            return;
        }
        for (String string5 : stringArray = string4.split(",")) {
            com.corrodinggames.rts.game.units.custom.d.b b2;
            string5 = string5.trim();
            com.corrodinggames.rts.game.units.custom.a.d d2 = new com.corrodinggames.rts.game.units.custom.a.d();
            d2.k = string5;
            d2.o = ab2.a(string2, string3 + "extraLagHidingInUI", (Boolean) false);
            d2.p = ab2.a(string2, string3 + "pos", Float.valueOf(999.0f)).floatValue();
            d2.aJ = ab2.b(string2, string3 + "tech", 1);
            d2.aK = ab2.a(string2, string3 + "forceNano", (Boolean) false);
            d2.aL = ab2.b(string2, string3 + "type", (String) null);
            d2.q = com.corrodinggames.rts.game.units.custom.d.b.a(l2, ab2, string2, string3 + "price", null);
            d2.aF = ab2.a(l2, string2, string3 + "isGuiBlinking", (LogicBoolean) null);
            d2.v = ab2.a(l2, string2, string3 + "isVisible", (LogicBoolean) null);
            d2.z = ab2.a(l2, string2, string3 + "isLocked", (LogicBoolean) null);
            d2.A = ag.a(l2, ab2, string2, string3 + "isLockedMessage", null);
            if (d2.z != null) {
                d2.y = true;
            }
            if (d2.z == LogicBoolean.falseBoolean) {
                d2.z = null;
            }
            d2.B = ab2.a(l2, string2, string3 + "isLockedAlt", (LogicBoolean) null);
            d2.C = ag.a(l2, ab2, string2, string3 + "isLockedAltMessage", null);
            if (d2.B != null) {
                d2.y = true;
            }
            if (d2.B == LogicBoolean.falseBoolean) {
                d2.B = null;
            }
            d2.D = ab2.a(l2, string2, string3 + "isLockedAlt2", (LogicBoolean) null);
            d2.E = ag.a(l2, ab2, string2, string3 + "isLockedAlt2Message", null);
            if (d2.D != null) {
                d2.y = true;
            }
            if (d2.D == LogicBoolean.falseBoolean) {
                d2.D = null;
            }
            if ((b2 = com.corrodinggames.rts.game.units.custom.d.b.a(l2, ab2, string2, string3 + "addResources",
                    true)) != null && b2.d()) {
                d2.ae = b2;
            }
            d2.aM = com.corrodinggames.rts.game.units.custom.a.f.build;
            if ("NONE".equalsIgnoreCase(string5))
                continue;
            l2.gh.add(d2);
        }
    }

    public static void a(com.corrodinggames.rts.game.units.custom.l var0, IniFile var1, String var2, String var3,
            String var4, boolean var5, boolean var6) throws bo {
        com.corrodinggames.rts.game.units.custom.a.d var7 = new com.corrodinggames.rts.game.units.custom.a.d();
        String var8 = var1.b(var2, var3 + "convertTo", (String) null);
        String var9 = var1.b(var2, var3 + "whenBuilding_temporarilyConvertTo", (String) null);
        at[] var10 = com.corrodinggames.rts.game.units.custom.as.a(var1, var2,
                var3 + "whenBuilding_temporarilyConvertTo_keepFields", (at[]) null);
        Float var11 = var1.a(var2, var3 + "addEnergy", (Float) null);
        com.corrodinggames.rts.game.units.custom.d.b var12 = com.corrodinggames.rts.game.units.custom.d.b.a(var0, var1,
                var2, var3 + "addResources", true);
        var0.a(var12);
        com.corrodinggames.rts.game.units.custom.d.b var13 = com.corrodinggames.rts.game.units.custom.d.b.a(var0, var1,
                var2, var3 + "addResourcesScaledByAIHandicaps", true);
        var0.a(var13);
        String var14 = var1.b(var2, var3 + "fireTurretXAtGround", (String) null);
        LogicBoolean var15 = var1.b(var0, var2, var3 + "alsoTriggerOrQueueActionWithTarget", (LogicBoolean) null);
        LogicBoolean var16 = var1.a(var0, var2, var3 + "alsoTriggerOrQueueActionConditional", (LogicBoolean) null);
        String var17 = var1.b(var2, var3 + "alsoTriggerAction", (String) null);
        LogicBoolean var18 = var1.c(var0, var2, var3 + "alsoTriggerActionRepeat", (LogicBoolean) null);
        Object var19 = null;
        String var20 = var1.b(var2, var3 + "alsoQueueAction", (String) null);
        String var21 = var1.b(var2, var3 + "spawnEffects", (String) null);
        String var22 = var1.b(var2, var3 + "spawnEffectsOnQueue", (String) null);
        String var23 = var1.b(var2, var3 + "playSoundAtUnit", (String) null);
        String var24 = var1.b(var2, var3 + "playSoundGlobally", (String) null);
        String var25 = var1.b(var2, var3 + "playSoundToPlayer", (String) null);
        String var26 = var1.b(var2, var3 + "playSoundToPlayerOnQueue", (String) null);
        com.corrodinggames.rts.game.units.custom.a.a.o.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.e.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.h.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.a.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.k.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.b.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.d.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.l.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.g.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.m.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.f.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.j.a(var0, var1, var2, var3, var7, var4, var5);
        com.corrodinggames.rts.game.units.custom.a.a.i.a(var0, var1, var2, var3, var7, var4, var5);
        LogicBoolean var27 = var1.a(var0, var2, var3 + "resetCustomTimer", (LogicBoolean) null);
        boolean var28 = false;
        if (var5) {
            var28 = true;
        } else {
            if (var8 != null || var9 != null || var11 != null || var14 != null) {
                var28 = true;
            }

            if (var12.d() || var13.d()) {
                var28 = true;
            }

            if (var17 != null || var20 != null || var21 != null || var19 != null) {
                var28 = true;
            }

            if (var23 != null || var24 != null || var25 != null || var26 != null) {
                var28 = true;
            }

            if (var7.ac.size() > 0) {
                var28 = true;
            }
        }

        if (var28) {
            if ("NONE".equalsIgnoreCase(var8)) {
                var8 = null;
            }

            if ("NONE".equalsIgnoreCase(var9)) {
                var9 = null;
            }

            if (var14 != null && var14.equalsIgnoreCase("NONE")) {
                var14 = null;
            }

            var7.a = var0.gh.size();
            String var29 = var1.b(var2, var3 + "id", (String) null);
            if (var29 != null) {
                var7.b = "c" + var29;
                if (var7.b.contains(" ")) {
                    throw new RuntimeException("[" + var2 + "]id cannot contain space");
                }

                if (var7.b.contains(",")) {
                    throw new RuntimeException("[" + var2 + "]id cannot contain ,");
                }

                if (var7.b.contains(":")) {
                    throw new RuntimeException("[" + var2 + "]id cannot contain :");
                }

                if (var7.b.contains("(")) {
                    throw new RuntimeException("[" + var2 + "]id cannot contain (");
                }

                if (var7.b.contains("\u0000")) {
                    throw new RuntimeException("[" + var2 + "]id cannot contain null");
                }

                if (var7.b.length() > 15) {
                    throw new RuntimeException("[" + var2 + "]id cannot be longer than 15 characters");
                }

                Iterator var30 = var0.gh.iterator();

                while (var30.hasNext()) {
                    com.corrodinggames.rts.game.units.custom.a.d var31 = (com.corrodinggames.rts.game.units.custom.a.d) var30
                            .next();
                    if (var7.b.equalsIgnoreCase(var31.b)) {
                        throw new RuntimeException("[" + var2 + "]id more than one action exists with id: " + var29);
                    }
                }
            }

            var7.c = var4;
            var7.o = var1.a(var2, var3 + "extraLagHidingInUI", false);
            var7.s = com.corrodinggames.rts.game.units.custom.g.a(var1.b(var2, var3 + "tags", (String) null));
            var7.p = (float) var1.a(var2, var3 + "pos", 999.0F);
            var7.q = com.corrodinggames.rts.game.units.custom.d.b.a(var0, var1, var2, var3 + "price", true);
            var7.r = com.corrodinggames.rts.game.units.custom.d.b.b(var0, var1, var2, var3 + "streamingCost",
                    (com.corrodinggames.rts.game.units.custom.d.b) null);
            boolean var49 = var1.a(var2, var3 + "switchPriceWithStreamingCost", false);
            if (var49) {
                if (var7.r != null) {
                    throw new RuntimeException("[" + var2
                            + "]streamingCost and switchPriceWithStreamingCost=true cannot be used at the same time");
                }

                var7.r = com.corrodinggames.rts.game.units.custom.d.b.b(var0, var1, var2, var3 + "price",
                        (com.corrodinggames.rts.game.units.custom.d.b) null);
                var7.q = com.corrodinggames.rts.game.units.custom.d.b.a;
            }

            var0.a(var7.q);
            if (var7.r != null) {
                var0.a(var7.r);
            }

            var7.K = var1.a(var2, var3 + "highPriorityQueue", false);
            var7.L = var1.a(var2, var3 + "onlyOneUnitAtATime", false);
            var7.M = var1.a(var2, var3 + "canPlayerCancel", true);
            var7.O = var1.a(var2, var3 + "alwaysSinglePress", false);
            var7.N = var1.a(var2, var3 + "allowMultipleInQueue", true);
            if (!var7.M && !var7.N && var7.O) {
                var7.P = true;
            }

            if (!var7.M) {
                var7.j = com.corrodinggames.rts.game.units.a.ActionType.none;
            } else {
                var7.j = com.corrodinggames.rts.game.units.a.ActionType.popupQueue;
            }

            var7.t = var1.a(var0, var2, var3 + "requireConditional", (LogicBoolean) null);
            var7.u = var1.a(var0, var2, var3 + "isActive", (LogicBoolean) null);
            var7.v = var1.a(var0, var2, var3 + "isVisible", (LogicBoolean) null);
            var7.x = var1.a(var2, var3 + "isAlsoViewableByEnemies", false);
            var7.w = var1.a(var2, var3 + "isAlsoViewableByAllies", var7.x);
            if (var6) {
                if (var7.v != null && !LogicBoolean.isStaticFalse(var7.v)) {
                    throw new RuntimeException("[" + var2 + "]isVisible doesn't make sense to use in hidden actions");
                }

                var7.v = LogicBoolean.falseBoolean;
            }

            var7.z = var1.a(var0, var2, var3 + "isLocked", (LogicBoolean) null);
            var7.A = a(var0, var1, var2, var3 + "isLockedMessage", (String) null);
            if (var7.z != null) {
                var7.y = true;
            }

            if (var7.z == LogicBoolean.falseBoolean) {
                var7.z = null;
            }

            var7.B = var1.a(var0, var2, var3 + "isLockedAlt", (LogicBoolean) null);
            var7.C = a(var0, var1, var2, var3 + "isLockedAltMessage", (String) null);
            if (var7.B != null) {
                var7.y = true;
            }

            if (var7.B == LogicBoolean.falseBoolean) {
                var7.B = null;
            }

            var7.D = var1.a(var0, var2, var3 + "isLockedAlt2", (LogicBoolean) null);
            var7.E = a(var0, var1, var2, var3 + "isLockedAlt2Message", (String) null);
            if (var7.D != null) {
                var7.y = true;
            }

            if (var7.D == LogicBoolean.falseBoolean) {
                var7.D = null;
            }

            var7.F = LogicBoolean.create(var0, var1.b(var2, var3 + "ai_isHighPriority", (String) null),
                    (LogicBoolean) null);
            if (var7.F == LogicBoolean.falseBoolean) {
                var7.F = null;
            }

            if (var7.F != null) {
                var0.fJ = true;
            }

            var7.G = var1.a(var0, var2, var3 + "ai_isDisabled", LogicBoolean.falseBoolean);
            var7.aN = (com.corrodinggames.rts.game.units.custom.a.e) var1.a(var2, var3 + "aiUse", var7.aN,
                    com.corrodinggames.rts.game.units.custom.a.e.class);
            var7.J = var0.a(var1.b(var2, var3 + "guiBuildUnit", (String) null), var3 + "guiBuildUnit", var2);
            if (var7.J != null) {
                var7.j = com.corrodinggames.rts.game.units.a.ActionType.placeBuilding;
                if (var8 != null) {
                    throw new RuntimeException(
                            "[" + var2 + "]guiBuildUnit and convertTo cannot currently be used the same action");
                }
            }

            var7.I = var0.a(var1.b(var2, var3 + "ai_considerSameAsBuilding", (String) null),
                    var3 + "ai_considerSameAsBuilding", var2);
            var7.aF = var1.a(var0, var2, var3 + "isGuiBlinking", (LogicBoolean) null);
            var7.ay = a(var0.F, var1.b(var2, var3 + "iconImage", "NONE"), var0.ab, var0, var2, var3 + "iconImage");
            var7.aB = var1.a(var0, var2, var3 + "iconExtraIsVisible", (LogicBoolean) null);
            if (var7.aB == LogicBoolean.trueBoolean) {
                var7.aB = null;
            }

            var7.az = var0.a(var1, var2, var3 + "iconExtraImage");
            var7.aA = (int) var1.a(var2, var3 + "iconExtraColor",(Integer) Color.a(100, 255, 255, 255));
            var7.aC = UnitReference.parseUnitTypeOrReferenceFromConf(var0, var1, var2, var3 + "unitShownInUI",
                    (UnitReference$UnitReferenceOrUnitType) null);
            if (var7.aC != null && var7.ay != null) {
                throw new RuntimeException(
                        "[" + var2 + "]unitShownInUI and iconImage: doesn't make sense to use both at the same time");
            }

            var7.aD = var1.a(var2, var3 + "unitShownInUIWithHpBar", true);
            var7.aE = var1.a(var2, var3 + "unitShownInUIWithProgressBar", true);
            var7.aG = (com.corrodinggames.rts.game.units.a.ActionDisplayType) var1.a(var2, var3 + "displayType", var7.aG,
                    com.corrodinggames.rts.game.units.a.ActionDisplayType.class);
            var7.aI = var1.a(var2, var3 + "displayRemainingStockpile", false);
            var7.d = a(var0, var1, var2, var3 + "text", "");
            var7.e = UnitReference.parseUnitTypeOrReferenceFromConf(var0, var1, var2, var3 + "textAddUnitName",
                    (UnitReference$UnitReferenceOrUnitType) null);
            var7.h = a((IniFile) var1, (String) var2, var3 + "textPostFix", (String) null);
            var7.f = UnitReference.parseUnitTypeOrReferenceFromConf(var0, var1, var2, var3 + "descriptionAddFromUnit",
                    (UnitReference$UnitReferenceOrUnitType) null);
            var7.g = UnitReference.parseUnitTypeOrReferenceFromConf(var0, var1, var2, var3 + "descriptionAddUnitStats",
                    (UnitReference$UnitReferenceOrUnitType) null);
            var7.i = a(var0, var1, var2, var3 + "description", "");
            var7.S = var1.d(var2, var3 + "buildSpeed", var7.S);
            if (var7.S == 0.0F) {
                var7.S = 50.0F;
            }

            var7.T = var1.a(var2, var3 + "buildSpeed_ignoreFactorySpeedModifiers", var7.T);
            boolean var50 = false;
            var7.U = var1.a(var2, var3 + "whenBuilding_cannotMove", var7.U);
            var7.V = var0.a(var1.b(var2, var3 + "whenBuilding_playAnimation", (String) null), var7.V);
            var7.W = var1.a(var2, var3 + "whenBuilding_rotateTo", var7.W);
            var7.X = var1.a(var2, var3 + "whenBuilding_rotateTo_orBackwards", var7.X);
            var7.Y = var1.a(var2, var3 + "whenBuilding_rotateTo_waitTillRotated", var7.Y);
            var7.Z = var1.a(var2, var3 + "whenBuilding_rotateTo_aimAtActionTarget", var7.Z);
            String var32 = var1.b(var2, var3 + "whenBuilding_rotateTo_rotateTurretX", (String) null);
            if (var32 != null) {
                var7.aa = var0.e(var32);
                if (var7.aa == null) {
                    throw new RuntimeException("Cannot find turret:" + var32 + " for [" + var2 + "]" + var3
                            + "whenBuilding_rotateTo_rotateTurretX");
                }

                if (var7.X) {
                    throw new RuntimeException("whenBuilding_rotateTo_orBackwards:true not supported with [" + var2
                            + "]" + var3 + "whenBuilding_rotateTo_rotateTurretX");
                }
            }

            if (var7.Z && var7.W == null) {
                var7.W = 0.0F;
            }

            var7.ab = var1.a(var0, var2, var3 + "whenBuilding_triggerAction", (u) null);
            var7.Q = var1.a(var2, var3 + "convertTo_keepCurrentTags", var7.Q);
            var7.R = com.corrodinggames.rts.game.units.custom.as.a(var1, var2, var3 + "convertTo_keepCurrentFields",
                    (at[]) null);
            if (var9 != null && !"NONE".equalsIgnoreCase(var9)) {
                var7.l = var0.a(var9, var3 + "whenBuilding_temporarilyConvertTo", var2);
                var7.m = var10;
                var50 = true;
            }

            if (var7.U || var7.V != null || var7.W != null || var7.l != null || var7.ab != null) {
                var0.bg = true;
            }

            var7.aM = com.corrodinggames.rts.game.units.custom.a.f.convert;
            if (var8 != null && !"NONE".equalsIgnoreCase(var8)) {
                var7.H = var0.a(var8, var3 + "convertTo", var2);
                var7.k = var8;
                var7.N = false;
                var50 = true;
            }

            if (var11 != null) {
                var7.ad = var11;
                var50 = true;
            }

            if (var12 != null && var12.d()) {
                var7.ae = var12;
                var50 = true;
            }

            if (var13 != null && var13.d()) {
                var7.af = var13;
                var50 = true;
            }

            var7.ah = var1.a(var2, var3 + "fireTurretXAtGround_withOffset", (PointF) null);
            var7.ai = var1.b(var0, var2, var3 + "fireTurretXAtGround_withTarget", (LogicBoolean) null);
            var7.ak = var1.b(var2, var3 + "fireTurretXAtGround_count", 1);
            var7.am = com.corrodinggames.rts.game.units.custom.b.c.a(var0,
                    var1.b(var2, "fireTurretXAtGround_showGuideDecals", (String) null));
            if (var7.ai != null && var7.ah == null) {
                var7.ah = new PointF(0.0F, 0.0F);
            }

            String var33 = var1.b(var2, var3 + "fireTurretXAtGround_withProjectile", (String) null);
            if (var33 != null) {
                var7.aj = var0.f(var33);
                if (var7.aj == null) {
                    throw new RuntimeException("Cannot find projectile:" + var33 + " for [" + var2 + "]" + var3
                            + "fireTurretXAtGround_withProjectile");
                }
            }

            String var34 = var1.b(var2, var3 + "fireTurretXAtGround_onlyOverPassableTileOf", (String) null);
            if (var34 != null) {
                var7.al = UnitMovementType.a(var34, var3 + "fireTurretXAtGround_overPassableTileOf");
            }

            if (var14 != null) {
                bn var35 = var0.e(var14);
                if (var35 == null) {
                    throw new RuntimeException(
                            "Cannot find turret:" + var14 + " for [" + var2 + "]" + var3 + "fireTurretXAtGround");
                }

                var7.ag = var35.e;
                if (var7.ah == null) {
                    var7.j = com.corrodinggames.rts.game.units.a.ActionType.targetGround;
                    if (var7.J != null) {
                        throw new RuntimeException("[" + var2
                                + "]guiBuildUnit and fireTurretXAtGround (without withOffset) cannot be used in the same action");
                    }
                }

                var50 = true;
            }

            var7.an = var15;
            var7.ao = var16;
            if (var17 != null && !"NONE".equalsIgnoreCase(var17)) {
                var7.ap = var0.c(var17, "alsoTriggerAction", var2);
                if (var18 != null) {
                    if (LogicBoolean.isStaticNumber(var18)) {
                        float var51 = LogicBoolean.getKnownStaticNumber(var18);
                        if (var51 == 0.0F) {
                            var7.ap = null;
                        } else if (var51 != 1.0F) {
                            var7.ar = var18;
                        }
                    } else {
                        var7.ar = var18;
                    }
                }

                var50 = true;
            }

            if (var20 != null && !"NONE".equalsIgnoreCase(var20)) {
                var7.aq = var0.c(var20, "alsoQueueAction", var2);
                var50 = true;
            }

            if (var21 != null) {
                var7.as = var0.a(var21, (z) null);
                var50 = true;
            }

            if (var22 != null) {
                var7.at = var0.a(var22, (z) null);
                var50 = true;
            }

            if (var23 != null) {
                var7.au = bl.a(var0, var23);
                var50 = true;
            }

            if (var24 != null) {
                var7.av = bl.a(var0, var24);
                var50 = true;
            }

            if (var25 != null) {
                var7.aw = bl.a(var0, var25);
                var50 = true;
            }

            if (var26 != null) {
                var7.ax = bl.a(var0, var26);
                var50 = true;
            }

            if (var27 != null) {
                var7.aH = var27;
                var50 = true;
            }

            if (var7.ac.size() > 0) {
                var50 = true;
            }

            ArrayList var52 = null;
            String var36 = var1.b(var2, var3 + "autoTriggerOnEvent", (String) null);
            Integer var37 = var1.b(var2, var3 + "autoTriggerOnEventRecursionLimit", (Integer) null);
            if (var37 != null) {
                if (var37 < 0) {
                    throw new bo("[" + var2 + "]" + var3 + "autoTriggerOnEventRecursionLimit: Cannot be < 0");
                }

                if (var37 > 50) {
                    throw new bo("[" + var2 + "]" + var3 + "autoTriggerOnEventRecursionLimit: Cannot be > 100");
                }
            }

            Iterator var43;
            if (var36 != null) {
                ArrayList var38 = a(var2, var3 + "autoTriggerOnEvent", var36);
                if (var38 != null) {
                    if (var38.size() < 1) {
                        throw new bo("[" + var2 + "]" + var3 + "autoTriggerOnEvent: Expected 1 or more options, got:"
                                + var38.size());
                    }

                    ae var42;
                    for (Iterator var39 = var38.iterator(); var39.hasNext(); var52.add(var42)) {
                        ai var40 = (ai) var39.next();

                        af var41;
                        try {
                            var41 = (af) IniFile.a(var40.a, (Enum) null, af.class);
                        } catch (bo var48) {
                            throw new bo("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var48.getMessage(), var48);
                        }

                        if (var52 == null) {
                            var52 = new ArrayList();
                        }

                        var42 = new ae();
                        var42.a = var41;
                        if (var37 != null) {
                            var42.e = var37;
                        } else if (var42.a == af.newMessage) {
                            var42.e = 4;
                        }

                        String var47;
                        if (var40.b != null) {
                            for (var43 = var40.b.keySet().iterator(); var43
                                    .hasNext(); var42.d = IniFile.j(var2, var3 + "autoTriggerOnEvent", var47)) {
                                String var44 = (String) var43.next();
                                String var45 = (String) var40.b.get(var44);
                                boolean var46 = false;
                                if (var44.equalsIgnoreCase("withtag")) {
                                    if (var42.a != af.tookDamage && var42.a != af.newMessage) {
                                        throw new bo("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var42.a.name()
                                                + " doesn't support parameter: " + var44);
                                    }

                                    var46 = true;
                                }

                                if (var44.equalsIgnoreCase("withprojectiletag")) {
                                    if (var42.a != af.tookDamage) {
                                        throw new bo("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var42.a.name()
                                                + " doesn't support parameter: " + var44);
                                    }

                                    var46 = true;
                                }

                                if (var44.equalsIgnoreCase("withactiontag")) {
                                    if (var42.a != af.queueItemAdded && var42.a != af.queueItemCancelled) {
                                        throw new bo("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var42.a.name()
                                                + " doesn't support parameter: " + var44);
                                    }

                                    var46 = true;
                                }

                                if (!var46) {
                                    throw new bo("[" + var2 + "]" + var3 + "autoTriggerOnEvent: Unknown parameter: "
                                            + var44);
                                }

                                var47 = com.corrodinggames.rts.gameFramework.GameUtils.p(var45);
                                if (var47 == null) {
                                    throw new bo("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var42.a.name()
                                            + " expected quoted string, got: " + var45);
                                }

                                if (var42.d != null) {
                                    throw new bo("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var42.a.name()
                                            + " tag was set twice");
                                }
                            }
                        }
                    }
                }
            }

            LogicBoolean var53 = var1.a(var0, var2, var3 + "autoTrigger", (LogicBoolean) null);
            String var54 = var1.b(var2, var3 + "autoTrigger", (String) null);
            com.corrodinggames.rts.game.units.custom.s var55 = (com.corrodinggames.rts.game.units.custom.s) var1.a(var2,
                    var3 + "autoTriggerCheckRate", var0.cb, com.corrodinggames.rts.game.units.custom.s.class);
            var7.n = var50;
            if (var50 || var7.v != null) {
                if (var53 != null && var50) {
                    r var56 = new r();
                    var56.a = var53;
                    var56.b = var54;
                    var56.c = var55;
                    var56.d = new com.corrodinggames.rts.game.units.custom.a.g(var7,
                            var0.a(var7.k, "[" + var2 + "]" + var3, var2));
                    var0.fW.add(var56);
                }

                if (var52 != null && var50) {
                    com.corrodinggames.rts.game.units.custom.a.g var57 = new com.corrodinggames.rts.game.units.custom.a.g(
                            var7, var0.a(var7.k, "[" + var2 + "]" + var3, var2));
                    com.corrodinggames.rts.game.units.custom.l var58 = var0;
                    var43 = var52.iterator();

                    while (var43.hasNext()) {
                        ae var59 = (ae) var43.next();
                        var59.b = var57;
                        var59.c = var58;
                        var0.gq.add(var59);
                    }
                }

                if (var7.k != null && var7.q != null && var7.q.b > 0) {
                    var0.gi = true;
                }

                var0.gh.add(var7);
            }
        }

    }

    public static String a(com.corrodinggames.rts.game.units.custom.l l2, String string2, String string3) {
        if (string3.startsWith("SHARED:")) {
            string3 = string3.substring("SHARED:".length());
            string2 = "units/shared/common.ini";
        }
        if (string3.startsWith("CORE:")) {
            string3 = string3.substring("CORE:".length());
            string2 = "units/common.ini";
        }
        if (string3.startsWith("ROOT:")) {
            string3 = string3.substring("ROOT:".length());
            string2 = l2.J == null ? "units/common.ini" : l2.J.q + "/common.ini";
        }
        String string4 = com.corrodinggames.rts.gameFramework.GameUtils.h(string2) + "/";
        while (string3.startsWith("/") || string3.startsWith("\\")) {
            string3 = string3.substring(1);
        }
        String string5 = string4 + string3;
        return string5;
    }

    public static void a(long l2, ah ah2) {
        double d2 = PerformanceProfiler.a(l2);
        ah2.o += d2;
    }

    public static void i() {
        com.corrodinggames.rts.gameFramework.GameEngine.log("==Timing==");
        for (ah ah2 : ah.values()) {
            com.corrodinggames.rts.gameFramework.GameEngine.log(ah2.name() + ": " + PerformanceProfiler.a(ah2.o));
        }
    }

    public static void j() {
        for (ah ah2 : ah.values()) {
            ah2.o = 0.0;
        }
    }

    public static com.corrodinggames.rts.gameFramework.m.Texture_M a(String string2, String string3, boolean bl2,
            com.corrodinggames.rts.game.units.custom.l l2, String string4, String string5) {
        try {
            return ag.a(string2, string3, bl2, l2);
        } catch (RuntimeException runtimeException) {
            runtimeException.printStackTrace();
            throw new RuntimeException("[" + string4 + "]" + string5 + ": " + runtimeException.getMessage(),
                    runtimeException);
        }
    }

    public static com.corrodinggames.rts.gameFramework.m.Texture_M a(String string2, String string3, boolean bl2,
            com.corrodinggames.rts.game.units.custom.l l2) {
        long l3 = PerformanceProfiler.a();
        com.corrodinggames.rts.gameFramework.m.Texture_M e2 = ag.b(string2, string3, bl2, l2);
        ag.a(l3, ah.imageLoadOrGet);
        return e2;
    }

    public static com.corrodinggames.rts.gameFramework.m.Texture_M b(String string2, String string3, boolean bl2,
            com.corrodinggames.rts.game.units.custom.l l2) {
        com.corrodinggames.rts.gameFramework.m.Texture_M e2;
        if (string3 == null) {
            return null;
        }
        if (string3.equalsIgnoreCase("NONE")) {
            return null;
        }
        if (string3.equals("")) {
            return null;
        }
        boolean bl3 = false;
        if (string3.startsWith("SHADOW:")) {
            string3 = string3.substring("SHADOW:".length());
            bl3 = true;
        }
        if (string3.startsWith("SHARED:")) {
            string3 = string3.substring("SHARED:".length());
            string2 = "units/shared/common.ini";
        }
        if (string3.startsWith("CORE:")) {
            string3 = string3.substring("CORE:".length());
            string2 = "units/common.ini";
        }
        if (string3.startsWith("ROOT:")) {
            string3 = string3.substring("ROOT:".length());
            string2 = l2.J == null ? "units/common.ini" : l2.J.q + "/common.ini";
        }
        if (string3.startsWith("SHADOW:")) {
            string3 = string3.substring("SHADOW:".length());
            bl3 = true;
        }
        com.corrodinggames.rts.gameFramework.GameEngine l3 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        String string4 = com.corrodinggames.rts.gameFramework.GameUtils.h(string2) + "/";
        String string5 = "[" + bl2 + "," + bl3 + "]" + string4 + string3;
        com.corrodinggames.rts.gameFramework.m.Texture_M e3 = ag.c(string5);
        if (e3 != null) {
            return e3;
        }
        com.corrodinggames.rts.gameFramework.utility.AssetInputStream j2 = ag.c(string4, string3, l2);
        int n2 = 0;
        if (e != null) {
            n2 = ag.e.I;
        }
        if (n2 > 5) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Fast failing to oom image for this mod");
            e2 = l3.bO.r();
        } else {
            long l4 = PerformanceProfiler.a();
            try {
                e2 = l3.bO.a(j2, true);
            } catch (RuntimeException runtimeException) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("imageStream:" + j2);
                throw new RuntimeException(
                        "Error decode image from: "
                                + com.corrodinggames.rts.gameFramework.storage.a.d(string4 + string3),
                        runtimeException);
            }
            ag.a(l4, ah.imageLoad);
            if (e2.A()) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("oomErrors:" + l);
                ++l;
                if (e != null) {
                    ++ag.e.I;
                    ++ag.e.J;
                }
            } else if (e != null && !ag.e.z && com.corrodinggames.rts.gameFramework.GameEngine.isDebugVersionStatic2) {
                e2.z();
            }
        }
        try {
            ((InputStream) j2).close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (e2 == null) {
            throw new RuntimeException(
                    "Failed to decode image: " + com.corrodinggames.rts.gameFramework.storage.a.e(string4 + string3));
        }
        e2.a(bl2);
        if (bl3) {
            com.corrodinggames.rts.gameFramework.m.Texture_M e4 = e2;
            e2 = BaseUnit.a(e4, e2.p, e2.q);
        }
        ag.a(e2);
        ag.a(string5, e2);
        return e2;
    }

    public static void a(String string2, com.corrodinggames.rts.gameFramework.m.Texture_M e2) {
        g.put(string2, e2);
    }

    public static com.corrodinggames.rts.gameFramework.m.Texture_M c(String string2) {
        com.corrodinggames.rts.gameFramework.m.Texture_M e2 = (com.corrodinggames.rts.gameFramework.m.Texture_M) g.get(string2);
        if (e2 != null) {
            ++j;
            ag.a(e2);
            e2.t();
            return e2;
        }
        if (k) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("loadImageInConf: cache miss: " + string2);
        }
        ++i;
        return null;
    }

    public static com.corrodinggames.rts.gameFramework.sound.i a(String string2, String string3,
            com.corrodinggames.rts.game.units.custom.l l2) {
        long l3 = PerformanceProfiler.a();
        com.corrodinggames.rts.gameFramework.sound.i i2 = ag.b(string2, string3, l2);
        ag.a(l3, ah.soundLoadOrGet);
        return i2;
    }

    public static com.corrodinggames.rts.gameFramework.sound.i b(String string2, String string3,
            com.corrodinggames.rts.game.units.custom.l l2) {
        if (string3 == null) {
            return null;
        }
        if (string3.equalsIgnoreCase("NONE")) {
            return null;
        }
        com.corrodinggames.rts.gameFramework.GameEngine l3 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (!string3.contains(".")) {
            com.corrodinggames.rts.gameFramework.sound.i i2 = l3.bM.a(string3);
            return i2;
        }
        if (string3.startsWith("ROOT:")) {
            string3 = string3.substring("ROOT:".length());
            string2 = l2.J == null ? "units/common.ini" : l2.J.q + "/common.ini";
        }
        if (string3.startsWith("CORE:")) {
            string3 = string3.substring("CORE:".length());
            string2 = "units/common.ini";
        }
        if (string3.startsWith("SHARED:")) {
            string3 = string3.substring("SHARED:".length());
            string2 = "units/shared/common.ini";
        }
        boolean bl2 = false;
        String string4 = com.corrodinggames.rts.gameFramework.GameUtils.h(string2) + "/";
        String string5 = string4 + string3;
        com.corrodinggames.rts.gameFramework.sound.i i3 = (com.corrodinggames.rts.gameFramework.sound.i) h.get(string5);
        if (i3 != null) {
            ag.a(i3);
            return i3;
        }
        if (!string3.toLowerCase(Locale.ROOT).endsWith(".ogg") && !string3.toLowerCase(Locale.ROOT).endsWith(".wav")) {
            throw new RuntimeException("Failed to open sound: " + string4 + "" + string3
                    + " only the ogg & wav sound formats are supported.");
        }
        com.corrodinggames.rts.gameFramework.utility.AssetInputStream j2 = ag.c(string4, string3, l2);
        long l4 = PerformanceProfiler.a();
        com.corrodinggames.rts.gameFramework.sound.i i4 = l3.bM.a(string3, j2, bl2);
        try {
            j2.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        ag.a(l4, ah.soundLoad);
        if (i4 == null) {
            boolean bl3 = string3.toLowerCase(Locale.ROOT).endsWith(".ogg");
            String string6 = "Sound file found but failed to load: " + string5;
            if (bl3) {
                string6 = string6 + " - Check if this file is truly a ogg";
            }
            l2.r(string6);
            return l3.bM.b("Failed to load");
        }
        ag.a(i4);
        h.put(string5, i4);
        return i4;
    }

    public static boolean a(String string2, String string3, String string4, com.corrodinggames.rts.gameFramework.i.b b2)
            throws IOException {
        String string5;
        if (string3 == null) {
            return true;
        }
        if (!string3.contains("..")) {
            return true;
        }
        if (com.corrodinggames.rts.gameFramework.GameEngine.at()) {
            return true;
        }
        File file = new File(com.corrodinggames.rts.gameFramework.storage.a.e(string4));
        String string6 = file.getCanonicalPath();
        if (string6.startsWith(
                string5 = new File(com.corrodinggames.rts.gameFramework.storage.a.e("units")).getCanonicalPath())) {
            return true;
        }
        String string7 = b2.k();
        boolean bl2 = string6.startsWith(string7);
        if (!bl2) {
            com.corrodinggames.rts.gameFramework.GameEngine
                    .b("File: '" + string6 + "' is not within mod: '" + string7 + "'");
        }
        return bl2;
    }

    public static String a(String string2, String string3) {
        if (!string2.endsWith("/")) {
            string2 = string2 + "/";
        }
        while (string3.startsWith("/") || string3.startsWith("\\")) {
            string3 = string3.substring(1);
        }
        return string2 + string3;
    }

    public static com.corrodinggames.rts.gameFramework.utility.AssetInputStream c(String string2, String string3,
            com.corrodinggames.rts.game.units.custom.l l2) {
        String string4 = ag.a(string2, string3);
        com.corrodinggames.rts.gameFramework.i.b b2 = null;
        if (l2 != null) {
            b2 = l2.J;
        } else {
            com.corrodinggames.rts.gameFramework.GameEngine.g("findAssetSteam meta==null");
        }
        try {
            if (b2 != null && !ag.a(string2, string3, string4, b2)) {
                throw new RuntimeException("File is outside mod: " + string4);
            }
        } catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        com.corrodinggames.rts.gameFramework.utility.AssetInputStream j2 = com.corrodinggames.rts.gameFramework.storage.a.k(string4);
        if (j2 == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Orginal path: " + string4);
            throw new RuntimeException("IO Error: Failed to open: " + ag.a(b2, string4, true));
        }
        return j2;
    }

    public static void b(com.corrodinggames.rts.game.units.custom.l l2) {
        ba[] baArray = l2.ax;
        for (int i2 = 0; i2 < baArray.length; ++i2) {
            int n2;
            ba ba2 = baArray[i2];
            float f2 = -1.0f;
            ba ba3 = null;
            float f3 = 1.0f;
            if (ba2.o) {
                f3 = 0.1f;
            }
            for (int i3 = 0; i3 < baArray.length; ++i3) {
                ba ba4 = baArray[i3];
                if (ba2 == ba4 || ba4.l)
                    continue;
                float f4 = com.corrodinggames.rts.gameFramework.GameUtils.a(ba2.d * f3, ba2.e, ba4.d * f3, ba4.e);
                if (ba3 != null && !(f4 < f2))
                    continue;
                f2 = f4;
                ba3 = ba4;
            }
            f2 = com.corrodinggames.rts.gameFramework.GameUtils.a(f2) + 2.0f;
            f2 *= f2;
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (n2 = 0; n2 < baArray.length; ++n2) {
                float f5;
                ba ba5 = baArray[n2];
                if (ba2 == ba5 || ba5.l || !((f5 = com.corrodinggames.rts.gameFramework.GameUtils.a(ba2.d * f3, ba2.e,
                        ba5.d * f3, ba5.e)) <= f2))
                    continue;
                arrayList.add(ba5.a);
            }
            ba2.S = new int[arrayList.size()];
            for (n2 = 0; n2 < arrayList.size(); ++n2) {
                ba2.S[n2] = (Integer) arrayList.get(n2);
            }
        }
    }

    public static String k() {
        return "builtin_mods";
    }

    public static String l() {
        return "builtin_mods_enabled";
    }

    public static String m() {
        String string2 = com.corrodinggames.rts.gameFramework.GameEngine.isPausedStatic2 ? "/SD/mods/units"
                : "/SD/rustedWarfare/units";
        return string2;
    }

    public static ArrayList a(String paramString1, String paramString2, String paramString3) throws bo {
        // 检查paramString3是否为空或"NONE"
        if (paramString3 != null && !"".equals(paramString3) && !"NONE".equalsIgnoreCase(paramString3)) {
            ArrayList localArrayList = new ArrayList();

            // 按逗号分割字符串
            ArrayList localArrayList1 = com.corrodinggames.rts.gameFramework.utility.al.a(paramString3, ",", false);
            Iterator localIterator = localArrayList1.iterator();

            while (localIterator.hasNext()) {
                String str1 = (String) localIterator.next();
                String str2 = str1.trim();

                if (!"".equals(str2)) {
                    // 检查是否包含括号
                    if (str2.contains("(") && str2.contains(")")) {
                        // 按"("分割字符串
                        String[] arrayOfString1 = com.corrodinggames.rts.gameFramework.utility.al.b(str2, "(");

                        if (arrayOfString1 == null) {
                            // 格式错误抛出异常
                            throw new com.corrodinggames.rts.game.units.custom.bo(
                                    "[" + paramString1 + "]" + paramString2 +
                                            ": Unexpected format for '" + str2 + "' of " + paramString3);
                        }

                        String str3 = arrayOfString1[0];
                        String str4 = arrayOfString1[1].trim();

                        // 创建ai对象
                        com.corrodinggames.rts.game.units.custom.ai localAi = new com.corrodinggames.rts.game.units.custom.ai();
                        localAi.a = str3;

                        if (str4 != null) {
                            // 检查是否以")"结尾
                            if (str4.endsWith(")")) {
                                // 去掉末尾的")"
                                str4 = str4.substring(0, str4.length() - 1);

                                // 按逗号分割参数
                                ArrayList localArrayList2 = com.corrodinggames.rts.gameFramework.utility.al.a(str4, ",",
                                        false, false);
                                Iterator localIterator2 = localArrayList2.iterator();

                                while (localIterator2.hasNext()) {
                                    String str5 = (String) localIterator2.next();
                                    String str6 = str5.trim();

                                    if (!"".equals(str6)) {
                                        // 按"="分割键值对
                                        String[] arrayOfString2 = com.corrodinggames.rts.gameFramework.utility.al
                                                .b(str6, "=");

                                        if (arrayOfString2 == null) {
                                            throw new RuntimeException(
                                                    "[" + paramString1 + "]" + paramString2 +
                                                            ": Unexpected key format for '" + str2 + "' of "
                                                            + paramString3);
                                        }

                                        String str7 = arrayOfString2[0].trim();
                                        String str8 = arrayOfString2[1].trim();

                                        // 初始化HashMap
                                        if (localAi.b == null) {
                                            localAi.b = new HashMap();
                                        }

                                        // 将键值对放入HashMap
                                        localAi.b.put(str7, str8);
                                    }
                                }
                            } else {
                                // 缺少")"抛出异常
                                throw new com.corrodinggames.rts.game.units.custom.bo(
                                        "[" + paramString1 + "]" + paramString2 +
                                                ": Expected ')' in '" + str2 + "' of " + paramString3);
                            }
                        }

                        // 将ai对象添加到结果列表
                        localArrayList.add(localAi);
                    } else {
                        // 没有括号的情况
                        com.corrodinggames.rts.game.units.custom.ai localAi = new com.corrodinggames.rts.game.units.custom.ai();
                        localAi.a = str2;
                        localArrayList.add(localAi);
                    }
                }
            }

            return localArrayList;
        }

        return null;
    }

    static {
        g = new HashMap();
        h = new HashMap();
        m = new com.corrodinggames.rts.gameFramework.utility.m();
        n = new HashMap();
        o = new Object();
        p = 50.0f;
        q = 50.0f;
        r = null;
        s = null;
    }
}
