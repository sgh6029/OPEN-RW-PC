/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.f;

import com.corrodinggames.rts.game.units.BaseUnit;

public final class b {
    public static final BaseUnit[] a = new BaseUnit[0];
    public int b;
    transient BaseUnit[] c = a;

    public boolean a(BaseUnit am2) {
        int n2 = this.b;
        BaseUnit[] amArray = this.c;
        if (n2 == amArray.length) {
            BaseUnit[] amArray2 = new BaseUnit[n2 + (n2 < 6 ? 12 : n2 >> 1)];
            System.arraycopy(amArray, 0, amArray2, 0, n2);
            amArray = amArray2;
            this.c = amArray2;
        }
        amArray[n2] = am2;
        this.b = n2 + 1;
        return true;
    }

    public boolean b(BaseUnit am2) {
        BaseUnit[] amArray = this.c;
        int n2 = this.b;
        if (am2 != null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!am2.equals(amArray[i2])) continue;
                System.arraycopy(amArray, i2 + 1, amArray, i2, --n2 - i2);
                amArray[n2] = null;
                this.b = n2;
                return true;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                if (amArray[i3] != null) continue;
                System.arraycopy(amArray, i3 + 1, amArray, i3, --n2 - i3);
                amArray[n2] = null;
                this.b = n2;
                return true;
            }
        }
        return false;
    }

    public final BaseUnit[] a() {
        return this.c;
    }
}

