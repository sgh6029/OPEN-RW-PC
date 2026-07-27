/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.game.GameLogic;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class PlatformHelper {
    public static int a(int n2) {
        return n2 + 5;
    }

    public static String a() {
        if (!GameEngine.at()) {
            return null;
        }
        GameLogic i2 = (GameLogic)GameEngine.getInstance();
        String string2 = i2.getSignatureHash();
        return string2;
    }
}

