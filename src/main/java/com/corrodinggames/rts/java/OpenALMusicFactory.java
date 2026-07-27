/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.MusicManager;
import com.corrodinggames.rts.gameFramework.MusicFactory;
import com.corrodinggames.rts.gameFramework.GameMusic;
import com.corrodinggames.rts.gameFramework.MusicTrack;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio;
import com.corrodinggames.rts.java.OpenALMusic;
import com.corrodinggames.rts.java.OpenALMusicTrack;

public class OpenALMusicFactory
extends MusicFactory {
    volatile boolean a;
    public OpenALAudio b;
    boolean c = false;

    public Object f() {
        return this.b;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(float f2) {
        Object object = this.f();
        synchronized (object) {
            if (this.a) {
                return;
            }
            long l2 = PerformanceProfiler.a();
            this.b.update();
            double d2 = PerformanceProfiler.a(l2);
            if (d2 > 16.0) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("music poll took:" + PerformanceProfiler.a(d2));
            }
        }
        super.a(f2);
    }

    @Override
    public void a(int n2) {
    }

    public OpenALMusicFactory(OpenALAudio openALAudio) {
        this.b = openALAudio;
    }

    @Override
    public GameMusic a(String string2) {
        return new OpenALMusic(string2, this);
    }

    @Override
    public MusicTrack a() {
        OpenALMusicTrack n2 = new OpenALMusicTrack(this);
        return n2;
    }

    @Override
    public void a(MusicManager am2) {
        this.e = am2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void b() {
        Object object = this.f();
        synchronized (object) {
            this.a = true;
        }
    }

    @Override
    public boolean c() {
        return true;
    }

    @Override
    public boolean d() {
        return true;
    }

    @Override
    public int e() {
        return 100;
    }
}

