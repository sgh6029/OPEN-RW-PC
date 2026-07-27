/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.MusicManager;
import com.corrodinggames.rts.gameFramework.GameMusic;
import com.corrodinggames.rts.gameFramework.MusicTrack;

public abstract class MusicFactory {
    protected MusicManager e;

    public void a(int n2) {
    }

    public void a(float f2) {
    }

    public abstract GameMusic a(String var1);

    public abstract MusicTrack a();

    public abstract void a(MusicManager var1);

    public abstract void b();

    public boolean c() {
        return false;
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return 0;
    }
}

