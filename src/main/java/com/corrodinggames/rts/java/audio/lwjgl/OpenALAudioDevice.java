/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.openal.AL10
 */
package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.AudioDevice;
import com.corrodinggames.rts.java.audio.a.AudioException;
import com.corrodinggames.rts.java.audio.a.MathUtils;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;

public class OpenALAudioDevice
implements AudioDevice {
    private static final int bytesPerSample = 2;
    private final OpenALAudio audio;
    private final int channels;
    private IntBuffer buffers;
    private int sourceID = -1;
    private int format;
    private int sampleRate;
    private boolean isPlaying;
    private float volume = 1.0f;
    private float renderedSeconds;
    private float secondsPerBuffer;
    private byte[] bytes;
    private final int bufferSize;
    private final int bufferCount;
    private final ByteBuffer tempBuffer;

    public OpenALAudioDevice(OpenALAudio openALAudio, int n2, boolean bl2, int n3, int n4) {
        this.audio = openALAudio;
        this.channels = bl2 ? 1 : 2;
        this.bufferSize = n3;
        this.bufferCount = n4;
        this.format = this.channels > 1 ? 4355 : 4353;
        this.sampleRate = n2;
        this.secondsPerBuffer = (float)n3 / 2.0f / (float)this.channels / (float)n2;
        this.tempBuffer = BufferUtils.createByteBuffer((int)n3);
    }

    @Override
    public void writeSamples(short[] sArray, int n2, int n3) {
        if (this.bytes == null || this.bytes.length < n3 * 2) {
            this.bytes = new byte[n3 * 2];
        }
        int n4 = Math.min(n2 + n3, sArray.length);
        int n5 = 0;
        for (int i2 = n2; i2 < n4; ++i2) {
            short s2 = sArray[i2];
            this.bytes[n5++] = (byte)(s2 & 0xFF);
            this.bytes[n5++] = (byte)(s2 >> 8 & 0xFF);
        }
        this.writeSamples(this.bytes, 0, n3 * 2);
    }

    @Override
    public void writeSamples(float[] fArray, int n2, int n3) {
        if (this.bytes == null || this.bytes.length < n3 * 2) {
            this.bytes = new byte[n3 * 2];
        }
        int n4 = Math.min(n2 + n3, fArray.length);
        int n5 = 0;
        for (int i2 = n2; i2 < n4; ++i2) {
            float f2 = fArray[i2];
            f2 = MathUtils.a(f2, -1.0f, 1.0f);
            int n6 = (int)(f2 * 32767.0f);
            this.bytes[n5++] = (byte)(n6 & 0xFF);
            this.bytes[n5++] = (byte)(n6 >> 8 & 0xFF);
        }
        this.writeSamples(this.bytes, 0, n3 * 2);
    }

    public void writeSamples(byte[] byArray, int n2, int n3) {
        int n4;
        if (n3 < 0) {
            throw new IllegalArgumentException("length cannot be < 0.");
        }
        if (this.sourceID == -1) {
            int n5;
            int n6;
            this.sourceID = this.audio.obtainSource(true);
            if (this.sourceID == -1) {
                return;
            }
            if (this.buffers == null) {
                this.buffers = BufferUtils.createIntBuffer((int)this.bufferCount);
                AL10.alGenBuffers((IntBuffer)this.buffers);
                if (AL10.alGetError() != 0) {
                    throw new AudioException("Unabe to allocate audio buffers.");
                }
            }
            AL10.alSourcei((int)this.sourceID, (int)4103, (int)0);
            AL10.alSourcef((int)this.sourceID, (int)4106, (float)this.volume);
            n4 = 0;
            for (n6 = 0; n6 < this.bufferCount; ++n6) {
                n5 = this.buffers.get(n6);
                int n7 = Math.min(this.bufferSize, n3);
                this.tempBuffer.clear();
                this.tempBuffer.put(byArray, n2, n7).flip();
                AL10.alBufferData((int)n5, (int)this.format, (ByteBuffer)this.tempBuffer, (int)this.sampleRate);
                AL10.alSourceQueueBuffers((int)this.sourceID, (int)n5);
                n3 -= n7;
                n2 += n7;
                ++n4;
            }
            this.tempBuffer.clear().flip();
            for (n6 = n4; n6 < this.bufferCount; ++n6) {
                n5 = this.buffers.get(n6);
                AL10.alBufferData((int)n5, (int)this.format, (ByteBuffer)this.tempBuffer, (int)this.sampleRate);
                AL10.alSourceQueueBuffers((int)this.sourceID, (int)n5);
            }
            AL10.alSourcePlay((int)this.sourceID);
            this.isPlaying = true;
        }
        while (n3 > 0) {
            n4 = this.fillBuffer(byArray, n2, n3);
            n3 -= n4;
            n2 += n4;
        }
    }

    private int fillBuffer(byte[] byArray, int n2, int n3) {
        int n4;
        int n5 = Math.min(this.bufferSize, n3);
        while (true) {
            int n6 = AL10.alGetSourcei((int)this.sourceID, (int)4118);
            if (n6-- > 0 && (n4 = AL10.alSourceUnqueueBuffers((int)this.sourceID)) != 40963) {
                this.renderedSeconds += this.secondsPerBuffer;
                break;
            }
            try {
                Thread.sleep((long)(1000.0f * this.secondsPerBuffer));
            }
            catch (InterruptedException interruptedException) {}
        }
        this.tempBuffer.clear();
        this.tempBuffer.put(byArray, n2, n5).flip();
        AL10.alBufferData((int)n4, (int)this.format, (ByteBuffer)this.tempBuffer, (int)this.sampleRate);
        AL10.alSourceQueueBuffers((int)this.sourceID, (int)n4);
        if (!this.isPlaying || AL10.alGetSourcei((int)this.sourceID, (int)4112) != 4114) {
            AL10.alSourcePlay((int)this.sourceID);
            this.isPlaying = true;
        }
        return n5;
    }

    public void stop() {
        if (this.sourceID == -1) {
            return;
        }
        this.audio.freeSource(this.sourceID);
        this.sourceID = -1;
        this.renderedSeconds = 0.0f;
        this.isPlaying = false;
    }

    public boolean isPlaying() {
        if (this.sourceID == -1) {
            return false;
        }
        return this.isPlaying;
    }

    @Override
    public void setVolume(float f2) {
        this.volume = f2;
        if (this.sourceID != -1) {
            AL10.alSourcef((int)this.sourceID, (int)4106, (float)f2);
        }
    }

    public float getPosition() {
        if (this.sourceID == -1) {
            return 0.0f;
        }
        return this.renderedSeconds + AL10.alGetSourcef((int)this.sourceID, (int)4132);
    }

    public void setPosition(float f2) {
        this.renderedSeconds = f2;
    }

    public int getChannels() {
        return this.format == 4355 ? 2 : 1;
    }

    public int getRate() {
        return this.sampleRate;
    }

    @Override
    public void dispose() {
        if (this.buffers == null) {
            return;
        }
        if (this.sourceID != -1) {
            this.audio.freeSource(this.sourceID);
            this.sourceID = -1;
        }
        AL10.alDeleteBuffers((IntBuffer)this.buffers);
        this.buffers = null;
    }

    @Override
    public boolean isMono() {
        return this.channels == 1;
    }

    @Override
    public int getLatency() {
        return (int)(this.secondsPerBuffer * (float)this.bufferCount * 1000.0f);
    }
}

