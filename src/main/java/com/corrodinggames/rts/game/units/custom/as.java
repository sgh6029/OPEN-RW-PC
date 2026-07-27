/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$CachedWriter;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class as
        implements Cloneable {
    public boolean a;
    public float b;
    public int c;
    public float d;
    public float e = 1.0f;
    public float f = 1.0f;
    public int g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public boolean m;
    public int n;
    public int o;
    public float p;
    public float q;
    public float r;
    static LinkedHashMap s = new LinkedHashMap();
    static LinkedHashMap t;

    public as(boolean bl2) {
        this.a = bl2;
    }

    public static VariableScope$CachedWriter a(String string2, l l2, String string3, String string4) {
        try {
            return VariableScope$CachedWriter.create(string2, new au(l2));
        } catch (bo bo2) {
            throw new RuntimeException("[" + string3 + "]" + string4 + ": " + bo2.getMessage(), bo2);
        }
    }

    public as a() {
        try {
            as as2 = (as) super.clone();
            as2.a = false;
            return as2;
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    static void a(LinkedHashMap linkedHashMap, at at2) {
        linkedHashMap.put(at2.b, at2);
    }

    public as b() {
        as as2 = this.a();
        as2.a = false;
        return as2;
    }

    public static at a(int n2) {
        for (at at2 : ((List<at>) s.values())) {
            if (n2 != at2.a)
                continue;
            return at2;
        }
        return null;
    }

    public static void a(j j2, as as2, at[] atArray) {
        for (at at2 : atArray) {
            double d2;
            double d3 = at2.a(j2, j2.y);
            if (d3 == (d2 = at2.a(j2, as2)))
                continue;
            j2.dJ();
            at2.a(j2, d2);
        }
    }

    public static void a(j j2, as as2, l l2) {
        boolean bl2;
        boolean bl3 = true;
        boolean bl4 = bl2 = as2 != l2.cL;
        if (!bl2) {
            return;
        }
        for (String string2 : ((Set<String>) t.keySet())) {
            double d2;
            at at2 = (at) t.get(string2);
            double d3 = at2.a(j2, l2.cL);
            if (d3 == (d2 = at2.a(j2, as2)))
                continue;
            j2.dJ();
            at2.a(j2, d2);
        }
    }

    public static void a(as as2, j j2, com.corrodinggames.rts.gameFramework.j.GameOutputStream as3) throws IOException {
        boolean bl2;
        l l2 = j2.x;
        boolean bl3 = bl2 = as2 != l2.cL;
        if (!bl2) {
            as3.a(true);
        } else {
            as3.a(false);
            short s2 = 0;
            for (Object object : t.keySet()) {
                double d2;
                Object object2 = (at) t.get(object);
                double d3 = ((at) object2).a(j2, l2.cL);
                if (d3 == (d2 = ((at) object2).a(j2, as2)))
                    continue;
                s2 = (short) (s2 + 1);
            }
            as3.a(s2);
            int n2 = 0;
            for (Object object2 : t.keySet()) {
                double d4;
                at at2 = (at) t.get(object2);
                double d5 = at2.a(j2, l2.cL);
                if (d5 == (d4 = at2.a(j2, as2)))
                    continue;
                if (s2 < ++n2) {
                    throw new IOException("numberOfChangedFields>fieldsWritten: " + s2 + ">" + n2);
                }
                as3.a((short) at2.a);
                as3.a(d4);
                as3.a(d5);
            }
        }
    }

    public static void a(j j2, GameInputStream k2, int n2) throws IOException {
        l l2 = j2.x;
        boolean bl2 = k2.e();
        if (bl2) {
            return;
        }
        int n3 = k2.v();
        for (int i2 = 0; i2 < n3; ++i2) {
            short s2 = k2.v();
            double d2 = k2.h();
            double d3 = k2.h();
            at at2 = as.a(s2);
            if (at2 == null) {
                throw new IOException("Field " + s2 + " doesn't exist");
            }
            j2.dJ();
            at2.a(j2, d2);
        }
    }

    public static at[] a(IniFile ab2, String string2, String string3, at[] atArray) {
        String string4 = ab2.b(string2, string3, (String) null);
        try {
            return as.a(string4, atArray);
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException("[" + string2 + "]" + string3 + ": " + runtimeException.getMessage(),
                    runtimeException);
        }
    }

    public static at[] a(String string2, at[] atArray) {
        if (string2 == null) {
            return atArray;
        }
        ArrayList<at> arrayList = new ArrayList<at>();
        for (String string3 : com.corrodinggames.rts.gameFramework.GameUtils.c(string2, ',')) {
            string3 = string3.trim();
            at at2 = (at) t.get(string3 = string3.toLowerCase(Locale.ROOT));
            if (arrayList.contains(at2)) {
                throw new RuntimeException("Value: " + string3 + " is repeated");
            }
            if (at2 == null) {
                String string4 = "";
                for (String string5 : ((Set<String>) t.keySet())) {
                    if (!string4.equals("")) {
                        string4 = string4 + ", ";
                    }
                    string4 = string4 + string5;
                }
                throw new RuntimeException("Unknown value: " + string3 + " (Expected: "
                        + com.corrodinggames.rts.gameFramework.GameUtils.b(string4, 100) + ")");
            }
            arrayList.add(at2);
        }
        return arrayList.toArray(new at[0]);
    }

    public /* synthetic */ Object clone() {
        return this.a();
    }

    static {
        as.a(s, new as$1(s.size(), "mass"));
        as.a(s, new as$12(s.size(), "maxenergy"));
        as.a(s, new as$13(s.size(), "energy"));
        as.a(s, new as$14(s.size(), "maxhp"));
        as.a(s, new as$15(s.size(), "hp"));
        as.a(s, new as$16(s.size(), "maxshield"));
        as.a(s, new as$17(s.size(), "shield"));
        as.a(s, new as$18(s.size(), "shieldregen"));
        as.a(s, new as$19(s.size(), "armour"));
        as.a(s, new as$2(s.size(), "maxattackrange"));
        as.a(s, new as$3(s.size(), "shootdelaymultiplier"));
        as.a(s, new as$4(s.size(), "shootdamagemultiplier"));
        as.a(s, new as$5(s.size(), "movespeed"));
        as.a(s, new as$6(s.size(), "maxturnspeed"));
        as.a(s, new as$7(s.size(), "fogofwarsightrange"));
        as.a(s, new as$8(s.size(), "nanorange"));
        as.a(s, new as$9(s.size(), "selfregenrate"));
        as.a(s, new as$10(s.size(), "targetHeight"));
        as.a(s, new as$11(s.size(), "nanoFactorySpeed"));
        t = new LinkedHashMap();
        for (String string2 : ((Set<String>) s.keySet())) {
            if (!string2.equals(string2.toLowerCase(Locale.ROOT))) {
                throw new RuntimeException(string2);
            }
            at at2 = (at) s.get(string2);
            if (at2.b())
                continue;
            t.put(string2, at2);
        }
    }
}
