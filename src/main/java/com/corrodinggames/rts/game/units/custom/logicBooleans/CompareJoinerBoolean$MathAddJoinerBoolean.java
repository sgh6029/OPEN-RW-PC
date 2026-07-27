/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$MathJoinerBoolean;
import com.corrodinggames.rts.game.units.y;

public final class CompareJoinerBoolean$MathAddJoinerBoolean
extends CompareJoinerBoolean$MathJoinerBoolean {
    @Override
    public String type() {
        return "+";
    }

    @Override
    public float readNumber(y y2) {
        float f2 = this.children[0].readNumber(y2);
        for (int i2 = 1; i2 < this.children.length; ++i2) {
            f2 += this.children[i2].readNumber(y2);
        }
        return f2;
    }
}

