/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 */
package com.corrodinggames.rts.gameFramework;

import android.media.MediaPlayer;
import com.corrodinggames.rts.gameFramework.MusicManager;
import com.corrodinggames.rts.gameFramework.AndroidMusic;
import com.corrodinggames.rts.gameFramework.AndroidMusicTrack;
import com.corrodinggames.rts.gameFramework.MusicFactory;
import com.corrodinggames.rts.gameFramework.GameMusic;
import com.corrodinggames.rts.gameFramework.MusicTrack;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;

public class AndroidMusicFactory
extends MusicFactory {
    ArrayList a = new ArrayList();
    ArrayList b = new ArrayList();
    ArrayList c = new ArrayList();
    boolean d = false;

    @Override
    public GameMusic a(String string2) {
        return new AndroidMusic(string2, this);
    }

    @Override
    public MusicTrack a() {
        AndroidMusicTrack ap2 = new AndroidMusicTrack(this);
        return ap2;
    }

    @Override
    public void a(MusicManager am2) {
        this.e = am2;
        if (this.d) {
            GameEngine.log("AndroidMusicFactory already loaded");
        }
        GameEngine.log("AndroidMusicFactory - load");
        this.d = true;
        this.a.add(new MediaPlayer());
        this.a.add(new MediaPlayer());
        this.b.addAll(this.a);
    }

    @Override
    public void b() {
    }
}

