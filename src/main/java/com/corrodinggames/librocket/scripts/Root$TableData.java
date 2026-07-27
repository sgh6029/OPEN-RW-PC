/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import com.corrodinggames.librocket.scripts.Root$TableRow;
import java.util.ArrayList;

public class Root$TableData {
    public ArrayList rows = new ArrayList();

    public boolean same(Root$TableData root$TableData, boolean bl2) {
        if (this.rows.size() != root$TableData.rows.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.rows.size(); ++i2) {
            Root$TableRow root$TableRow;
            Root$TableRow root$TableRow2 = (Root$TableRow)this.rows.get(i2);
            if (root$TableRow2.same(root$TableRow = (Root$TableRow)root$TableData.rows.get(i2), bl2)) continue;
            return false;
        }
        return true;
    }
}

