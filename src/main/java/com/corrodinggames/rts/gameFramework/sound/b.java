/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.sound;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.sound.a;
import com.corrodinggames.rts.gameFramework.sound.c;
import com.corrodinggames.rts.gameFramework.sound.h;
import com.corrodinggames.rts.gameFramework.sound.i;

import android.util.Log;

public class b
extends i {
    a a;
    int b;
    final /* synthetic */ a c;

    public b(a a2, String string2, h h2) {
        super(string2, h2);
        this.c = a2;
        this.b = -1;
    }

    @Override
    public void a(float f2, float f3, int n2, int n3, float f4) {
        c c2 = (c)this.c.c.a();
        if (c2 == null) {
            return;
        }
        c2.b = f2;
        c2.c = f3;
        c2.e = n3;
        c2.f = f4;
        c2.a = this;
        boolean bl2 = false;
        GameEngine l2 = GameEngine.getInstance();
        if (l2 != null && l2.bQ != null && l2.bQ.androidNoSoundPrioritiesDebug) {
            bl2 = true;
        }
        if (bl2) {
            c2.d = 0;
        } else {
            --this.c.e;
            if (this.c.e <= 1) {
                this.c.e = 1000;
            }
            c2.d = this.c.e;
        }
        this.c.a.offer(c2);
    }

    public void b(float f2, float f3, int n2, int n3, float f4) {
        if (this.b == 0) {
            Log.d("RustedWarfare", "Sound not loaded");
            return;
        }
        int n4 = this.a.g.play(this.b, f2, f3, n2, n3, f4);
        if (n4 == 0) {
            // empty if block
        }
    }

    @Override
    public int a() {
        return 0;
    }
}

