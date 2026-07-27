/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.openal.AL
 *  org.lwjgl.openal.AL10
 *  org.lwjgl.openal.OpenALException
 */
package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.Audio;
import com.corrodinggames.rts.java.audio.AudioDevice;
import com.corrodinggames.rts.java.audio.AudioRecorder;
import com.corrodinggames.rts.java.audio.a.AudioFile;
import com.corrodinggames.rts.java.audio.a.AudioException;
import com.corrodinggames.rts.java.audio.a.IntArray;
import com.corrodinggames.rts.java.audio.a.IntObjectMap;
import com.corrodinggames.rts.java.audio.a.LongObjectMap;
import com.corrodinggames.rts.java.audio.a.MathUtils;
import com.corrodinggames.rts.java.audio.a.ObjectMap;
import com.corrodinggames.rts.java.audio.lwjgl.JavaSoundAudioRecorder;
import com.corrodinggames.rts.java.audio.lwjgl.Ogg$Music;
import com.corrodinggames.rts.java.audio.lwjgl.Ogg$Sound;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio$1;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio$2;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudioDevice;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALMusic;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALSound;
import com.corrodinggames.rts.java.audio.lwjgl.Wav$Music;
import com.corrodinggames.rts.java.audio.lwjgl.Wav$Sound;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Locale;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.OpenALException;

public class OpenALAudio
implements Audio {
    private final int deviceBufferSize;
    private final int deviceBufferCount;
    private IntArray idleSources;
    private IntArray allSources;
    private LongObjectMap soundIdToSource;
    private IntObjectMap sourceToSoundId;
    private long nextSoundId = 0L;
    private ObjectMap extensionToSoundClass = new ObjectMap();
    private ObjectMap extensionToMusicClass = new ObjectMap();
    private OpenALSound[] recentSounds;
    private int mostRecetSound = -1;
    ArrayList music = new ArrayList();
    boolean noDevice = false;

    public OpenALAudio() {
        this(16, 9, 512);
    }

    public OpenALAudio(int n2, int n3, int n4) {
        this.deviceBufferSize = n4;
        this.deviceBufferCount = n3;
        this.registerSound("ogg", Ogg$Sound.class);
        this.registerMusic("ogg", Ogg$Music.class);
        this.registerSound("wav", Wav$Sound.class);
        this.registerMusic("wav", Wav$Music.class);
        try {
            AL.create();
        }
        catch (LWJGLException lWJGLException) {
            this.noDevice = true;
            lWJGLException.printStackTrace();
            return;
        }
        catch (OpenALException openALException) {
            this.noDevice = true;
            openALException.printStackTrace();
            return;
        }
        catch (NullPointerException nullPointerException) {
            this.noDevice = true;
            nullPointerException.printStackTrace();
            return;
        }
        this.allSources = new IntArray(false, n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5 = AL10.alGenSources();
            if (AL10.alGetError() != 0) break;
            this.allSources.a(n5);
        }
        this.idleSources = new IntArray(this.allSources);
        this.soundIdToSource = new LongObjectMap();
        this.sourceToSoundId = new IntObjectMap();
        FloatBuffer floatBuffer = (FloatBuffer)BufferUtils.createFloatBuffer((int)6).put(new float[]{0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f}).flip();
        AL10.alListener((int)4111, (FloatBuffer)floatBuffer);
        FloatBuffer floatBuffer2 = (FloatBuffer)BufferUtils.createFloatBuffer((int)3).put(new float[]{0.0f, 0.0f, 0.0f}).flip();
        AL10.alListener((int)4102, (FloatBuffer)floatBuffer2);
        FloatBuffer floatBuffer3 = (FloatBuffer)BufferUtils.createFloatBuffer((int)3).put(new float[]{0.0f, 0.0f, 0.0f}).flip();
        AL10.alListener((int)4100, (FloatBuffer)floatBuffer3);
        this.recentSounds = new OpenALSound[n2];
    }

    public void registerSound(String string2, Class clazz) {
        if (string2 == null) {
            throw new IllegalArgumentException("extension cannot be null.");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("soundClass cannot be null.");
        }
        this.extensionToSoundClass.a((Object)string2, clazz);
    }

    public void registerMusic(String string2, Class clazz) {
        if (string2 == null) {
            throw new IllegalArgumentException("extension cannot be null.");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("musicClass cannot be null.");
        }
        this.extensionToMusicClass.a((Object)string2, clazz);
    }

    @Override
    public OpenALSound newSound(AudioFile a2) {
        if (a2 == null) {
            throw new IllegalArgumentException("file cannot be null.");
        }
        Class clazz = (Class)this.extensionToSoundClass.a(a2.b().toLowerCase(Locale.ROOT));
        if (clazz == null) {
            throw new AudioException("Unknown file extension for sound: " + a2);
        }
        try {
            return (OpenALSound)clazz.getConstructor(OpenALAudio.class, AudioFile.class).newInstance(this, a2);
        }
        catch (Exception exception) {
            throw new AudioException("Error creating sound " + clazz.getName() + " for file: " + a2, exception);
        }
    }

    @Override
    public OpenALMusic newMusic(AudioFile a2) {
        if (a2 == null) {
            throw new IllegalArgumentException("file cannot be null.");
        }
        Class clazz = (Class)this.extensionToMusicClass.a(a2.b().toLowerCase(Locale.ROOT));
        if (clazz == null) {
            throw new AudioException("Unknown file extension for music: " + a2);
        }
        try {
            return (OpenALMusic)clazz.getConstructor(OpenALAudio.class, AudioFile.class).newInstance(this, a2);
        }
        catch (Exception exception) {
            throw new AudioException("Error creating music " + clazz.getName() + " for file: " + a2, exception);
        }
    }

    int obtainSource(boolean bl2) {
        if (this.noDevice) {
            return 0;
        }
        int n2 = this.idleSources.b;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.idleSources.b(i2);
            int n4 = AL10.alGetSourcei((int)n3, (int)4112);
            if (n4 == 4114 || n4 == 4115) continue;
            if (bl2) {
                this.idleSources.c(i2);
            } else {
                long l2;
                if (this.sourceToSoundId.e(n3)) {
                    l2 = (Long)this.sourceToSoundId.a(n3);
                    this.sourceToSoundId.b(n3);
                    this.soundIdToSource.b(l2);
                }
                l2 = this.nextSoundId++;
                this.sourceToSoundId.a(n3, l2);
                this.soundIdToSource.a(l2, n3);
            }
            AL10.alSourceStop((int)n3);
            AL10.alSourcei((int)n3, (int)4105, (int)0);
            AL10.alSourcef((int)n3, (int)4106, (float)1.0f);
            AL10.alSourcef((int)n3, (int)4099, (float)1.0f);
            AL10.alSource3f((int)n3, (int)4100, (float)0.0f, (float)0.0f, (float)1.0f);
            return n3;
        }
        return -1;
    }

    void freeSource(int n2) {
        if (this.noDevice) {
            return;
        }
        AL10.alSourceStop((int)n2);
        AL10.alSourcei((int)n2, (int)4105, (int)0);
        if (this.sourceToSoundId.e(n2)) {
            long l2 = (Long)this.sourceToSoundId.b(n2);
            this.soundIdToSource.b(l2);
        }
        this.idleSources.a(n2);
    }

    void freeBuffer(int n2) {
        if (this.noDevice) {
            return;
        }
        int n3 = this.idleSources.b;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.idleSources.b(i2);
            if (AL10.alGetSourcei((int)n4, (int)4105) != n2) continue;
            if (this.sourceToSoundId.e(n4)) {
                long l2 = (Long)this.sourceToSoundId.b(n4);
                this.soundIdToSource.b(l2);
            }
            AL10.alSourceStop((int)n4);
            AL10.alSourcei((int)n4, (int)4105, (int)0);
        }
    }

    void stopSourcesWithBuffer(int n2) {
        if (this.noDevice) {
            return;
        }
        int n3 = this.idleSources.b;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.idleSources.b(i2);
            if (AL10.alGetSourcei((int)n4, (int)4105) != n2) continue;
            if (this.sourceToSoundId.e(n4)) {
                long l2 = (Long)this.sourceToSoundId.b(n4);
                this.soundIdToSource.b(l2);
            }
            AL10.alSourceStop((int)n4);
        }
    }

    void pauseSourcesWithBuffer(int n2) {
        if (this.noDevice) {
            return;
        }
        int n3 = this.idleSources.b;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.idleSources.b(i2);
            if (AL10.alGetSourcei((int)n4, (int)4105) != n2) continue;
            AL10.alSourcePause((int)n4);
        }
    }

    void resumeSourcesWithBuffer(int n2) {
        if (this.noDevice) {
            return;
        }
        int n3 = this.idleSources.b;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.idleSources.b(i2);
            if (AL10.alGetSourcei((int)n4, (int)4105) != n2 || AL10.alGetSourcei((int)n4, (int)4112) != 4115) continue;
            AL10.alSourcePlay((int)n4);
        }
    }

    public void backgroundUpdate() {
        if (this.noDevice) {
            return;
        }
        for (int i2 = 0; i2 < this.music.size(); ++i2) {
            ((OpenALMusic)this.music.get(i2)).backgroundUpdate();
        }
    }

    public boolean hasDevice() {
        return this.noDevice;
    }

    public void update() {
        if (this.noDevice) {
            return;
        }
        for (int i2 = 0; i2 < this.music.size(); ++i2) {
            ((OpenALMusic)this.music.get(i2)).update();
        }
    }

    public long getSoundId(int n2) {
        if (!this.sourceToSoundId.e(n2)) {
            return -1L;
        }
        return (Long)this.sourceToSoundId.a(n2);
    }

    public void stopSound(long l2) {
        if (!this.soundIdToSource.d(l2)) {
            return;
        }
        int n2 = (Integer)this.soundIdToSource.a(l2);
        AL10.alSourceStop((int)n2);
    }

    public void pauseSound(long l2) {
        if (!this.soundIdToSource.d(l2)) {
            return;
        }
        int n2 = (Integer)this.soundIdToSource.a(l2);
        AL10.alSourcePause((int)n2);
    }

    public void resumeSound(long l2) {
        if (!this.soundIdToSource.d(l2)) {
            return;
        }
        int n2 = (Integer)this.soundIdToSource.a(l2);
        if (AL10.alGetSourcei((int)n2, (int)4112) == 4115) {
            AL10.alSourcePlay((int)n2);
        }
    }

    public void setSoundGain(long l2, float f2) {
        if (!this.soundIdToSource.d(l2)) {
            return;
        }
        int n2 = (Integer)this.soundIdToSource.a(l2);
        AL10.alSourcef((int)n2, (int)4106, (float)f2);
    }

    public void setSoundLooping(long l2, boolean bl2) {
        if (!this.soundIdToSource.d(l2)) {
            return;
        }
        int n2 = (Integer)this.soundIdToSource.a(l2);
        AL10.alSourcei((int)n2, (int)4103, (int)(bl2 ? 1 : 0));
    }

    public void setSoundPitch(long l2, float f2) {
        if (!this.soundIdToSource.d(l2)) {
            return;
        }
        int n2 = (Integer)this.soundIdToSource.a(l2);
        AL10.alSourcef((int)n2, (int)4099, (float)f2);
    }

    public void setSoundPan(long l2, float f2, float f3) {
        if (!this.soundIdToSource.d(l2)) {
            return;
        }
        int n2 = (Integer)this.soundIdToSource.a(l2);
        AL10.alSource3f((int)n2, (int)4100, (float)MathUtils.b((f2 - 1.0f) * (float)Math.PI / 2.0f), (float)0.0f, (float)MathUtils.a((f2 + 1.0f) * (float)Math.PI / 2.0f));
        AL10.alSourcef((int)n2, (int)4106, (float)f3);
    }

    public void dispose() {
        if (this.noDevice) {
            return;
        }
        int n2 = this.allSources.b;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.allSources.b(i2);
            int n4 = AL10.alGetSourcei((int)n3, (int)4112);
            if (n4 != 4116) {
                AL10.alSourceStop((int)n3);
            }
            AL10.alDeleteSources((int)n3);
        }
        this.sourceToSoundId.a();
        this.soundIdToSource.a();
        AL.destroy();
        while (AL.isCreated()) {
            try {
                Thread.sleep(10L);
            }
            catch (InterruptedException interruptedException) {}
        }
    }

    @Override
    public AudioDevice newAudioDevice(int n2, boolean bl2) {
        if (this.noDevice) {
            return new OpenALAudio$1(this, bl2);
        }
        return new OpenALAudioDevice(this, n2, bl2, this.deviceBufferSize, this.deviceBufferCount);
    }

    @Override
    public AudioRecorder newAudioRecorder(int n2, boolean bl2) {
        if (this.noDevice) {
            return new OpenALAudio$2(this);
        }
        return new JavaSoundAudioRecorder(n2, bl2);
    }

    protected void retain(OpenALSound openALSound, boolean bl2) {
        ++this.mostRecetSound;
        this.mostRecetSound %= this.recentSounds.length;
        if (bl2 && this.recentSounds[this.mostRecetSound] != null) {
            this.recentSounds[this.mostRecetSound].stop();
        }
        this.recentSounds[this.mostRecetSound] = openALSound;
    }

    public void forget(OpenALSound openALSound) {
        for (int i2 = 0; i2 < this.recentSounds.length; ++i2) {
            if (this.recentSounds[i2] != openALSound) continue;
            this.recentSounds[i2] = null;
        }
    }
}

