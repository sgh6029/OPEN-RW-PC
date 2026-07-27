/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.f;

import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.f.a;
import com.corrodinggames.rts.game.units.custom.f.b$1;
import com.corrodinggames.rts.game.units.custom.f.d;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import java.util.regex.Matcher;

public class b {
    public d a;
    public d b;

    public b() {
        this.a = new d();
        this.b = new d();
    }

    public b(d d2, d d3) {
        this.a = d2;
        this.b = d3;
    }

    public void a() {
        this.a.a();
        this.b.a();
    }

    public b b() {
        b b2 = new b(this.a, new d());
        return b2;
    }

    public static double a(String string2) {
        return new b$1(string2).b();
    }

    public boolean b(String string2) {
        if (string2.contains("*")) {
            return true;
        }
        if (string2.contains("/")) {
            return true;
        }
        if (string2.contains("+")) {
            return true;
        }
        if (string2.contains("-")) {
            return true;
        }
        if (string2.contains("(")) {
            return true;
        }
        if (string2.contains(")")) {
            return true;
        }
        if (string2.contains("^")) {
            return true;
        }
        return string2.contains("%");
    }

    public String a(l l2, IniFile ab2, String string2, String string3) throws bo {
        string3 = string3.trim();
        boolean bl2 = this.b(string3);
        int n2 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = com.corrodinggames.rts.game.units.custom.f.a.b.matcher(string3);
        while (matcher.find()) {
            if (++n2 > 100) {
                throw new bo("Too many loops while parsing");
            }
            String string4 = matcher.group(0);
            if (GameUtils.r(string4) || string4.equals("int") || string4.equals("cos") || string4.equals("sin") || string4.equals("sqrt")) continue;
            String string5 = this.b(l2, ab2, string2, string4);
            if (bl2 && !GameUtils.r(string5)) {
                throw new bo("Cannot do maths on '" + string5 + "' from " + string4 + " (not a number)");
            }
            matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(string5));
        }
        matcher.appendTail(stringBuffer);
        string3 = stringBuffer.toString();
        if (bl2) {
            string3 = GameUtils.b(com.corrodinggames.rts.game.units.custom.f.b.a(string3));
        }
        return string3;
    }

    public String b(l l2, IniFile ab2, String string2, String string3) throws bo {
        if (string3.contains(".")) {
            String string4;
            String[] stringArray = GameUtils.c(string3, '.');
            if (stringArray.length != 2) {
                throw new bo("Unexpected key format: " + string3);
            }
            String string5 = stringArray[0];
            String string6 = stringArray[1];
            if (string5.equals("section")) {
                string5 = string2;
            }
            if ((string4 = ab2.b(string5, string6, (String)null)) == null) {
                if (string5.equalsIgnoreCase("self")) {
                    throw new bo("Static $ block: Could not find: [" + string5 + "]" + string6 + " in this conf file. Hint: You might have wanted % instead of $ for a dynamic string");
                }
                throw new bo("Static $ block: Could not find: [" + string5 + "]" + string6 + " in this conf file");
            }
            if (string4.contains("${")) {
                throw new bo("Reference [" + string5 + "]" + string6 + " is dynamic, chaining is not yet supported");
            }
            return string4;
        }
        String string7 = this.b.a(string3);
        if (string7 != null) {
            return string7;
        }
        string7 = this.a.a(string3);
        if (string7 != null) {
            return string7;
        }
        throw new bo("Could not find variable with name: " + string3);
    }
}

