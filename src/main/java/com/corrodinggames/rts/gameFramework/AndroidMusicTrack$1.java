/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnInfoListener
 */
package com.corrodinggames.rts.gameFramework;

import android.media.MediaPlayer;
import com.corrodinggames.rts.gameFramework.AndroidMusicTrack;

class AndroidMusicTrack$1
implements MediaPlayer.OnInfoListener {
    final /* synthetic */ AndroidMusicTrack a;

    AndroidMusicTrack$1(AndroidMusicTrack ap2) {
        this.a = ap2;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int n2, int n3) {
        return true;
    }
}

