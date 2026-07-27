/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.openal.AL10
 */
package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.Music;
import com.corrodinggames.rts.java.audio.Music$OnCompletionListener;
import com.corrodinggames.rts.java.audio.a.AudioFile;
import com.corrodinggames.rts.java.audio.a.FloatArray;
import com.corrodinggames.rts.java.audio.a.AudioException;
import com.corrodinggames.rts.java.audio.a.MathUtils;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;

public abstract class OpenALMusic
implements Music {
    private static final int bufferSize = 40960;
    private static final int bufferCount = 3;
    private static final int bytesPerSample = 2;
    private static final byte[] tempBytes = new byte[40960];
    private static final ByteBuffer tempBuffer = BufferUtils.createByteBuffer((int)40960);
    private FloatArray renderedSecondsQueue = new FloatArray(3);
    private final OpenALAudio audio;
    private IntBuffer buffers;
    private int sourceID = -1;
    private int format;
    private int sampleRate;
    private boolean isLooping;
    private boolean isPlaying;
    private float volume = 1.0f;
    private float pan = 0.0f;
    private float renderedSeconds;
    private float maxSecondsPerBuffer;
    protected final AudioFile file;
    protected int bufferOverhead = 0;
    private Music$OnCompletionListener onCompletionListener;

    public OpenALMusic(OpenALAudio openALAudio, AudioFile a2) {
        this.audio = openALAudio;
        this.file = a2;
        this.onCompletionListener = null;
    }

    protected void setup(int n2, int n3) {
        this.format = n2 > 1 ? 4355 : 4353;
        this.sampleRate = n3;
        this.maxSecondsPerBuffer = (float)(40960 - this.bufferOverhead) / (float)(2 * n2 * n3);
    }

    public void playWhenReady() {
        if (this.audio.noDevice) {
            return;
        }
    }

    @Override
    public void play() {
        if (this.audio.noDevice) {
            return;
        }
        if (this.sourceID == -1) {
            int n2;
            int n3;
            this.sourceID = this.audio.obtainSource(true);
            if (this.sourceID == -1) {
                return;
            }
            this.audio.music.add(this);
            if (this.buffers == null) {
                this.buffers = BufferUtils.createIntBuffer((int)3);
                AL10.alGenBuffers((IntBuffer)this.buffers);
                n3 = AL10.alGetError();
                if (n3 != 0) {
                    throw new AudioException("Unable to allocate audio buffers. AL Error: " + n3);
                }
            }
            AL10.alSourcei((int)this.sourceID, (int)4103, (int)0);
            this.setPan(this.pan, this.volume);
            n3 = 0;
            for (int i2 = 0; i2 < 3 && this.fill(n2 = this.buffers.get(i2)); ++i2) {
                n3 = 1;
                AL10.alSourceQueueBuffers((int)this.sourceID, (int)n2);
            }
            if (n3 == 0 && this.onCompletionListener != null) {
                this.onCompletionListener.onCompletion(this);
            }
            if (AL10.alGetError() != 0) {
                this.stop();
                return;
            }
        }
        if (!this.isPlaying) {
            AL10.alSourcePlay((int)this.sourceID);
            this.isPlaying = true;
        }
    }

    @Override
    public void stop() {
        if (this.audio.noDevice) {
            return;
        }
        if (this.sourceID == -1) {
            return;
        }
        this.audio.music.remove(this);
        this.reset();
        this.audio.freeSource(this.sourceID);
        this.sourceID = -1;
        this.renderedSeconds = 0.0f;
        this.renderedSecondsQueue.c();
        this.isPlaying = false;
    }

    @Override
    public void pause() {
        if (this.audio.noDevice) {
            return;
        }
        if (this.sourceID != -1) {
            AL10.alSourcePause((int)this.sourceID);
        }
        this.isPlaying = false;
    }

    @Override
    public boolean isPlaying() {
        if (this.audio.noDevice) {
            return false;
        }
        if (this.sourceID == -1) {
            return false;
        }
        return this.isPlaying;
    }

    @Override
    public void setLooping(boolean bl2) {
        this.isLooping = bl2;
    }

    @Override
    public boolean isLooping() {
        return this.isLooping;
    }

    @Override
    public void setVolume(float f2) {
        this.volume = f2;
        if (this.audio.noDevice) {
            return;
        }
        if (this.sourceID != -1) {
            AL10.alSourcef((int)this.sourceID, (int)4106, (float)f2);
        }
    }

    @Override
    public float getVolume() {
        return this.volume;
    }

    @Override
    public void setPan(float f2, float f3) {
        this.volume = f3;
        this.pan = f2;
        if (this.audio.noDevice) {
            return;
        }
        if (this.sourceID == -1) {
            return;
        }
        AL10.alSource3f((int)this.sourceID, (int)4100, (float)MathUtils.b((f2 - 1.0f) * (float)Math.PI / 2.0f), (float)0.0f, (float)MathUtils.a((f2 + 1.0f) * (float)Math.PI / 2.0f));
        AL10.alSourcef((int)this.sourceID, (int)4106, (float)f3);
    }

    @Override
    public void setPosition(float f2) {
        int n2;
        if (this.audio.noDevice) {
            return;
        }
        if (this.sourceID == -1) {
            return;
        }
        boolean bl2 = this.isPlaying;
        this.isPlaying = false;
        AL10.alSourceStop((int)this.sourceID);
        AL10.alSourceUnqueueBuffers((int)this.sourceID, (IntBuffer)this.buffers);
        while (this.renderedSecondsQueue.b > 0) {
            this.renderedSeconds = this.renderedSecondsQueue.a();
        }
        if (f2 <= this.renderedSeconds) {
            this.reset();
            this.renderedSeconds = 0.0f;
        }
        while (this.renderedSeconds < f2 - this.maxSecondsPerBuffer && this.read(tempBytes) > 0) {
            this.renderedSeconds += this.maxSecondsPerBuffer;
        }
        this.renderedSecondsQueue.a(this.renderedSeconds);
        boolean bl3 = false;
        for (int i2 = 0; i2 < 3 && this.fill(n2 = this.buffers.get(i2)); ++i2) {
            bl3 = true;
            AL10.alSourceQueueBuffers((int)this.sourceID, (int)n2);
        }
        this.renderedSecondsQueue.a();
        if (!bl3) {
            this.stop();
            if (this.onCompletionListener != null) {
                this.onCompletionListener.onCompletion(this);
            }
        }
        AL10.alSourcef((int)this.sourceID, (int)4132, (float)(f2 - this.renderedSeconds));
        if (bl2) {
            AL10.alSourcePlay((int)this.sourceID);
            this.isPlaying = true;
        }
    }

    @Override
    public float getPosition() {
        if (this.audio.noDevice) {
            return 0.0f;
        }
        if (this.sourceID == -1) {
            return 0.0f;
        }
        return this.renderedSeconds + AL10.alGetSourcef((int)this.sourceID, (int)4132);
    }

    public abstract int read(byte[] var1);

    public void reset() {
    }

    protected void loop() {
        this.reset();
    }

    public int getChannels() {
        return this.format == 4355 ? 2 : 1;
    }

    public int getRate() {
        return this.sampleRate;
    }

    public void backgroundUpdate() {
    }

    public void update() {
        int n2;
        if (this.audio.noDevice) {
            return;
        }
        if (this.sourceID == -1) {
            return;
        }
        boolean bl2 = false;
        int n3 = AL10.alGetSourcei((int)this.sourceID, (int)4118);
        while (n3-- > 0 && (n2 = AL10.alSourceUnqueueBuffers((int)this.sourceID)) != 40963) {
            this.renderedSeconds = this.renderedSecondsQueue.a();
            if (bl2) continue;
            if (this.fill(n2)) {
                AL10.alSourceQueueBuffers((int)this.sourceID, (int)n2);
                continue;
            }
            bl2 = true;
        }
        if (bl2 && AL10.alGetSourcei((int)this.sourceID, (int)4117) == 0) {
            this.stop();
            if (this.onCompletionListener != null) {
                this.onCompletionListener.onCompletion(this);
            }
        }
        if (this.isPlaying && AL10.alGetSourcei((int)this.sourceID, (int)4112) != 4114) {
            AL10.alSourcePlay((int)this.sourceID);
        }
    }

    private boolean fill(int n2) {
        tempBuffer.clear();
        int n3 = this.read(tempBytes);
        if (n3 <= 0) {
            if (this.isLooping) {
                this.loop();
                n3 = this.read(tempBytes);
                if (n3 <= 0) {
                    return false;
                }
                if (this.renderedSecondsQueue.b > 0) {
                    this.renderedSecondsQueue.a(0, 0.0f);
                }
            } else {
                return false;
            }
        }
        float f2 = this.renderedSecondsQueue.b > 0 ? this.renderedSecondsQueue.b() : 0.0f;
        float f3 = this.maxSecondsPerBuffer * (float)n3 / 40960.0f;
        this.renderedSecondsQueue.b(0, f2 + f3);
        tempBuffer.put(tempBytes, 0, n3).flip();
        AL10.alBufferData((int)n2, (int)this.format, (ByteBuffer)tempBuffer, (int)this.sampleRate);
        return true;
    }

    @Override
    public void dispose() {
        this.stop();
        if (this.audio.noDevice) {
            return;
        }
        if (this.buffers == null) {
            return;
        }
        AL10.alDeleteBuffers((IntBuffer)this.buffers);
        this.buffers = null;
        this.onCompletionListener = null;
    }

    @Override
    public void setOnCompletionListener(Music$OnCompletionListener music$OnCompletionListener) {
        this.onCompletionListener = music$OnCompletionListener;
    }

    public int getSourceId() {
        return this.sourceID;
    }
}

