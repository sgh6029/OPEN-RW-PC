/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ag;

import android.graphics.Paint;

class m_f {
    float a;
    Paint b;
    final /* synthetic */ GameEngine c;

    m_f(GameEngine l2) {
        this.c = l2;
    }

    void a() {
        float f2 = this.c.e(this.a);
        if (this.b.k() != f2) {
            if (this.b instanceof ag) {
                ((ag)this.b).c(f2);
            } else {
                this.b.b(f2);
            }
        }
    }
}

