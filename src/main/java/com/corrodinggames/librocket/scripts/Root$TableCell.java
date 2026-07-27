/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import com.corrodinggames.rts.gameFramework.GameUtils;

public class Root$TableCell {
    public String text;
    public String classes;
    public String librocketOnClick;
    public Integer color;

    public void setLibrocketOnClick(String string2) {
        this.librocketOnClick = string2;
    }

    public Root$TableCell(String string2) {
        this.text = string2;
    }

    public void addClass(String string2) {
        this.classes = this.classes != null ? this.classes + " " + string2 : string2;
    }

    public boolean same(Root$TableCell root$TableCell, boolean bl2) {
        if (!(GameUtils.d(this.classes, root$TableCell.classes) && GameUtils.d(this.librocketOnClick, root$TableCell.librocketOnClick) && GameUtils.a(this.color, root$TableCell.color))) {
            return false;
        }
        return bl2 || GameUtils.d(this.text, root$TableCell.text);
    }
}

