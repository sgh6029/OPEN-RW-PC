/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.f;

import com.corrodinggames.rts.game.units.custom.bo;

public class e {
    public static void a(String string2) throws bo {
        String string3 = string2;
        if (string3.length() == 0) {
            throw new bo("name cannot be empty");
        }
        if (string3.contains(" ") || string3.contains("}") || string3.contains("$") || string3.contains(".") || string3.contains("{") || string3.contains("-") || string3.contains("+") || string3.contains(":") || string3.contains("(")) {
            throw new bo("invalid character in name");
        }
        if (Character.isDigit(string3.charAt(0))) {
            throw new bo("name cannot start with a digit");
        }
    }
}

