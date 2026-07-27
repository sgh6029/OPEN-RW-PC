/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.NetworkConnection;
import com.corrodinggames.rts.gameFramework.j.n;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.List;

public class MasterServerAuth {
    public static MasterServerAuth instance = new MasterServerAuth();
    public static int saltA = 2;
    static int saltB = 3;
    static int saltC = 2;
    static int saltD = 3;
    public static int authTokenLength = 4;
    static String g = "tx";
    static String h = "_";
    public static int minClientVersion = 55;
    public static int minServerVersion = 66;
    public static int k = 100;
    public static boolean l = true;

    public static float lerp(float f2, float f3, float f4) {
        return f2 + (f3 - f2) * f4;
    }

    public void addAuthParams(String string2, List list) {
        long l2 = com.corrodinggames.rts.gameFramework.GameEngine.V();
        n.a(list, h + "1", "" + l2);
        n.a(list, g + "2", com.corrodinggames.rts.gameFramework.GameUtils.d("_" + string2 + (saltA + saltB)));
        n.a(list, g + "3", com.corrodinggames.rts.gameFramework.GameUtils.d("_" + string2 + ((long)(saltA + saltB) + l2)));
    }

    public void addTokenHashParam(String string2, List list) {
        n.a(list, g + "3", com.corrodinggames.rts.gameFramework.GameUtils.d("-" + string2 + (saltC + saltD) + authTokenLength));
    }

    public void addOptionalTokenHashParam(String string2, List list) {
        if (authTokenLength > 1000) {
            n.a(list, g + "4", com.corrodinggames.rts.gameFramework.GameUtils.d("+" + string2 + (saltC + saltD) + authTokenLength));
        }
    }

    public static void applyHandshakeTimeoutFlag(NetworkConnection c2) {
        if (c2.N) {
            long l2 = com.corrodinggames.rts.gameFramework.GameEngine.V();
            if (com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bx > -5) {
                c2.O = com.corrodinggames.rts.gameFramework.GameUtils.a(0.0f, 0.0f, (float)k, 0.0f) > 10.0f;
            }
        }
    }
}

