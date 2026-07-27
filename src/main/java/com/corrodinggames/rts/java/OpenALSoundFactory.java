/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.sound.h;
import com.corrodinggames.rts.gameFramework.sound.i;
import com.corrodinggames.rts.gameFramework.utility.ObjectPool;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import com.corrodinggames.rts.java.audio.a.AudioFile;
import com.corrodinggames.rts.java.audio.a.AudioException;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio;

import android.content.Context;

import com.corrodinggames.rts.java.SoundPlayRequest;
import com.corrodinggames.rts.java.OpenALSound;
import com.corrodinggames.rts.java.SoundPlayThread;
import java.util.concurrent.LinkedBlockingQueue;

public class OpenALSoundFactory
extends h {
    final int a = 15;
    LinkedBlockingQueue b = new LinkedBlockingQueue();
    ObjectPool c = new ObjectPool(15);
    SoundPlayThread d;
    Context e;
    public OpenALAudio f;

    public Object b() {
        return this.f;
    }

    public OpenALSoundFactory(OpenALAudio openALAudio) {
        for (int i2 = 0; i2 < 15; ++i2) {
            this.c.a(new SoundPlayRequest());
        }
        this.f = openALAudio;
    }

    @Override
    public void a(Context context) {
        if (this.e != null) {
            GameEngine.log("SlickSoundFactory:setContext context already set");
            return;
        }
        this.e = context;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public i a(int n2) {
        String string2 = com.corrodinggames.rts.gameFramework.GameUtils.f(n2);
        OpenALSound q2 = new OpenALSound(this, string2, this);
        String string3 = com.corrodinggames.rts.gameFramework.GameUtils.f(n2);
        if (string3 == null) {
            throw new RuntimeException("Failed to find sound for res id:" + n2);
        }
        Object object = this.b();
        synchronized (object) {
            AudioFile a2 = new AudioFile(string3);
            q2.a = this.f.newSound(a2);
        }
        return q2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public i a(String string2, AssetInputStream j2, boolean bl2) {
        OpenALSoundFactory o2 = this;
        if (!bl2) {
            o2 = null;
        }
        OpenALSound q2 = new OpenALSound(this, string2, o2);
        try {
            Object object = this.b();
            synchronized (object) {
                q2.a = this.f.newSound(new AudioFile(j2, j2.d()));
            }
        }
        catch (AudioException c2) {
            c2.printStackTrace();
            return null;
        }
        return q2;
    }

    @Override
    public void a() {
        if (this.d != null) {
            throw new RuntimeException("startThreads: soundThread!=null");
        }
        this.d = new SoundPlayThread(this);
        this.d.start();
    }
}

