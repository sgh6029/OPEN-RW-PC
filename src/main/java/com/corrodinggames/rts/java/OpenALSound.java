/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.sound.h;
import com.corrodinggames.rts.gameFramework.sound.i;
import com.corrodinggames.rts.java.audio.Sound;
import com.corrodinggames.rts.java.OpenALSoundFactory;
import com.corrodinggames.rts.java.SoundPlayRequest;

public class OpenALSound
extends i {
    Sound a;
    final /* synthetic */ OpenALSoundFactory b;

    public OpenALSound(OpenALSoundFactory o2, String string2, h h2) {
        super(string2, h2);
        this.b = o2;
    }

    @Override
    public void a(float f2, float f3, int n2, int n3, float f4) {
        SoundPlayRequest p2 = (SoundPlayRequest)this.b.c.a();
        if (p2 == null) {
            return;
        }
        p2.b = f2;
        p2.c = f3;
        p2.d = n2;
        p2.e = n3;
        p2.f = f4;
        p2.a = this;
        this.b.b.offer(p2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void b(float f2, float f3, int n2, int n3, float f4) {
        if (this.a == null) {
            GameEngine.log("Sound not loaded");
            return;
        }
        Object object = this.b.b();
        synchronized (object) {
            float f5 = 0.0f;
            float f6 = com.corrodinggames.rts.gameFramework.GameUtils.f(f2, f3);
            this.a.play(f6, f4, f5);
        }
    }

    @Override
    public int a() {
        return this.a.getBytesUsed();
    }
}

