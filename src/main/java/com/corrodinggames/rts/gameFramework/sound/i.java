/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.sound;

import com.corrodinggames.rts.gameFramework.sound.h;

public abstract class i {
    public float d = 1.0f;
    public String e;
    public boolean f = false;
    public boolean g;

    public i(String string2, h h2) {
        this.e = com.corrodinggames.rts.gameFramework.GameUtils.g(string2);
        if (h2 != null) {
            h2.h.put(this.e, this);
        }
    }

    public abstract void a(float var1, float var2, int var3, int var4, float var5);

    public abstract int a();
}

