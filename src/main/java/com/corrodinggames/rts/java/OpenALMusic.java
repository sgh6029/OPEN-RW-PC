/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameMusic;
import com.corrodinggames.rts.java.audio.Music;
import com.corrodinggames.rts.java.audio.a.AudioFile;
import com.corrodinggames.rts.java.OpenALMusicFactory;

public class OpenALMusic
extends GameMusic {
    OpenALMusicFactory a;
    Music c;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public OpenALMusic(String string2, OpenALMusicFactory l2) {
        super(string2, l2);
        this.a = l2;
        Object object = l2.f();
        synchronized (object) {
            this.a = l2;
            String string3 = com.corrodinggames.rts.gameFramework.storage.a.e(string2);
            this.c = string3.contains(".rwmod") ? l2.b.newMusic(new AudioFile(com.corrodinggames.rts.gameFramework.storage.a.k(string2), string3)) : l2.b.newMusic(new AudioFile(string3));
        }
    }
}

