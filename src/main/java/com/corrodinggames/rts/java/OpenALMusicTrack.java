/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;


import com.corrodinggames.rts.gameFramework.GameMusic;
import com.corrodinggames.rts.gameFramework.MusicTrack;
import com.corrodinggames.rts.java.audio.Music;
import com.corrodinggames.rts.java.OpenALMusicFactory;
import com.corrodinggames.rts.java.OpenALMusic;

public class OpenALMusicTrack
extends MusicTrack {
    OpenALMusic a;
    OpenALMusicFactory b;
    Music c;
    boolean d = false;
    boolean e = false;
    boolean f = false;

    public OpenALMusicTrack(OpenALMusicFactory l2) {
        this.b = l2;
    }

    @Override
    public void a(GameMusic ar2) {
        this.a = (OpenALMusic)ar2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(boolean bl2) {
        Object object = this.b.f();
        synchronized (object) {
            this.d = true;
            this.e = bl2;
            this.f = false;
            com.corrodinggames.rts.gameFramework.GameEngine.log("Queued:" + this.a.b);
            if (this.c != null) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("startPlaying: Stopping old music");
                this.c.stop();
            }
            this.c = this.a.c;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void f() {
        if (this.f) {
            return;
        }
        Object object = this.b.f();
        synchronized (object) {
            if (this.c != null) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Now playing:" + this.a.b);
                if (this.e) {
                    this.c.setVolume(this.c.getVolume());
                    this.c.setLooping(true);
                    this.c.play();
                } else {
                    this.c.setVolume(this.c.getVolume());
                    this.c.play();
                }
                this.f = true;
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.log("realPlay: playingMusic==null");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a() {
        Object object = this.b.f();
        synchronized (object) {
            if (this.c != null) {
                this.c.pause();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void b() {
        Object object = this.b.f();
        synchronized (object) {
            if (this.c != null && !this.c.isPlaying()) {
                this.c.play();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void d() {
        Object object = this.b.f();
        synchronized (object) {
            if (this.c != null) {
                this.c.stop();
                this.f = false;
                this.d = false;
                this.c = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void e() {
        Object object = this.b.f();
        synchronized (object) {
            if (this.c != null) {
                this.c.stop();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean c() {
        Object object = this.b.f();
        synchronized (object) {
            if (this.f && this.c != null) {
                return this.c.isPlaying();
            }
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(float f2) {
        Object object = this.b.f();
        synchronized (object) {
            if (this.c != null) {
                if (f2 > 0.05f && !this.f && this.d) {
                    this.f();
                }
                this.c.setVolume(f2);
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.log("setVolume: playingMusic==null");
            }
        }
    }
}

