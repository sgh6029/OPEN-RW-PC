/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnInfoListener
 *  android.media.MediaPlayer$OnPreparedListener
 */
package com.corrodinggames.rts.gameFramework;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.corrodinggames.rts.gameFramework.AndroidMusicFactory;
import com.corrodinggames.rts.gameFramework.AndroidMusic;
import com.corrodinggames.rts.gameFramework.AndroidMusicTrack$1;
import com.corrodinggames.rts.gameFramework.AndroidMusicTrack$2;
import com.corrodinggames.rts.gameFramework.GameMusic;
import com.corrodinggames.rts.gameFramework.MusicTrack;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.storage.a;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.FileLoaderFactory;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AndroidMusicTrack
extends MusicTrack {
    MediaPlayer a;
    AndroidMusic b;
    AndroidMusicFactory c;

    public AndroidMusicTrack(AndroidMusicFactory an2) {
        this.c = an2;
        MediaPlayer mediaPlayer = null;
        if (an2.b.size() == 0) {
            throw new RuntimeException("Music player pool empty");
        }
        mediaPlayer = (MediaPlayer)an2.b.remove(0);
        an2.c.add(this);
        this.a = mediaPlayer;
    }

    @Override
    public void a(GameMusic ar2) {
        this.b = (AndroidMusic)ar2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(boolean bl2) {
        try {
            MediaPlayer mediaPlayer = this.a;
            mediaPlayer.reset();
            AssetFileDescriptor assetFileDescriptor = null;
            if (this.b.b.startsWith("music")) {
                String string2 = com.corrodinggames.rts.gameFramework.storage.a.e(this.b.b);
                try {
                    assetFileDescriptor = this.c.e.w.d().b(string2);
                }
                catch (IOException iOException) {
                    throw new RuntimeException(iOException);
                }
                mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            } else {
                String string3 = com.corrodinggames.rts.gameFramework.storage.a.e(this.b.b);
                if (FileLoaderFactory.a(string3) == null) {
                    mediaPlayer.setDataSource(string3);
                } else {
                    AssetInputStream j2 = com.corrodinggames.rts.gameFramework.storage.a.k(string3);
                    if (j2 == null) {
                        throw new RuntimeException("openAssetSteam() null for '" + string3 + "'");
                    }
                    File file = com.corrodinggames.rts.gameFramework.storage.a.a(this.c.e.w, "music", "ogg");
                    GameEngine.log("Temp file needed for this music from zipped/abstract mod file");
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        GameUtils.a(j2, fileOutputStream);
                        fileOutputStream.close();
                        j2.close();
                        try (FileInputStream fileInputStream = new FileInputStream(file);){
                            mediaPlayer.setDataSource(fileInputStream.getFD(), 0L, (long)fileInputStream.available());
                        }
                    }
                    finally {
                        file.delete();
                    }
                }
            }
            if (bl2) {
                mediaPlayer.setLooping(true);
            }
            mediaPlayer.setVolume(0.0f, 0.0f);
            mediaPlayer.setOnInfoListener((MediaPlayer.OnInfoListener)new AndroidMusicTrack$1(this));
            mediaPlayer.setOnPreparedListener((MediaPlayer.OnPreparedListener)new AndroidMusicTrack$2(this));
            mediaPlayer.prepareAsync();
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void a() {
        this.a.pause();
    }

    @Override
    public void b() {
        this.a.start();
    }

    @Override
    public boolean c() {
        return this.a.isPlaying();
    }

    @Override
    public void d() {
        if (this.a != null) {
            this.a.stop();
        }
    }

    @Override
    public void e() {
        if (this.a != null) {
            this.a.stop();
        }
        this.a = null;
        this.c.c.remove(this);
        this.c.b.add(this.a);
    }

    @Override
    public void a(float f2) {
        this.a.setVolume(f2, f2);
    }
}

