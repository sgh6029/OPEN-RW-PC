/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.java.OpenALSoundFactory;
import com.corrodinggames.rts.java.SoundPlayRequest;

public class SoundPlayThread
extends Thread {
    final /* synthetic */ OpenALSoundFactory a;

    public SoundPlayThread(OpenALSoundFactory o2) {
        this.a = o2;
    }

    @Override
    public void run() {
        GameEngine.aq();
        try {
            while (true) {
                SoundPlayRequest p2 = (SoundPlayRequest)this.a.b.take();
                p2.a();
                this.a.c.a(p2);
            }
        }
        catch (InterruptedException interruptedException) {
            return;
        }
    }
}

