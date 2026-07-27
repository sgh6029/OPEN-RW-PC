/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.h_f9;
import java.util.Locale;

public final class OSUtils {
    protected static h_f9 a;

    public static h_f9 a() {
        if (a == null) {
            String string2 = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
            a = string2.indexOf("mac") >= 0 || string2.indexOf("darwin") >= 0 ? h_f9.b : (string2.indexOf("win") >= 0 ? h_f9.a : (string2.indexOf("nux") >= 0 ? h_f9.c : h_f9.d));
        }
        return a;
    }
}

