/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.Point2i;
import java.util.ArrayList;

public class IntLookupTable
        extends ArrayList {
    public int a(int n2) {
        if (this.isEmpty()) {
            return 0;
        }
        int n3 = ((Point2i) this.get((int) 0)).b;
        for (Point2i bh2 : ((ArrayList<Point2i>) this)) {
            if (bh2.a > n2) {
                return n3;
            }
            n3 = bh2.b;
        }
        return n3;
    }
}
