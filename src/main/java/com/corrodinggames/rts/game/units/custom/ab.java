/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.i.b;

public class ab {
    String a;
    String b;
    int c;
    int d;
    String e;
    l f;

    public String a() {
        b b2;
        String string2 = "from internal units";
        if (this.a != null) {
            string2 = "from mod:'" + this.a + "'";
        }
        if ((b2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bZ.f(this.a)) != null) {
            string2 = !b2.m() ? string2 + " (You seem to have this mod but it is not enabled)" : string2 + " (You seem to have this mod but it might be a different version)";
        }
        String string3 = "";
        if (this.f != null && this.e != null) {
            if (this.f.I == null) {
                string3 = " (Extra debug not enabled)";
            } else {
                String[] stringArray = this.e.split("\n");
                String[] stringArray2 = this.f.I.split("\n");
                int n2 = com.corrodinggames.rts.gameFramework.GameUtils.c(stringArray.length, stringArray2.length);
                if (stringArray.length != stringArray2.length) {
                    string3 = string3 + "Line length difference: " + stringArray.length + " vs " + stringArray2.length;
                }
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (stringArray[i2].equals(stringArray2[i2])) continue;
                    string3 = string3 + "Difference on line " + i2 + ": '" + stringArray[i2] + "' vs '" + stringArray2[i2] + "'";
                    break;
                }
            }
        }
        if (this.d == -1) {
            return "The server requires the unit:" + this.b + " that was not found " + string2 + string3;
        }
        return "Found unit:" + this.b + " but it does not match the server's copy " + string2 + string3 + " (checksum c:" + this.d + " s:" + this.c + ")";
    }
}

