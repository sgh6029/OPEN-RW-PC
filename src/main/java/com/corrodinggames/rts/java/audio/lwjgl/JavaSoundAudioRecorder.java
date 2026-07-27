/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.AudioRecorder;
import com.corrodinggames.rts.java.audio.a.AudioException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.TargetDataLine;

public class JavaSoundAudioRecorder
implements AudioRecorder {
    private TargetDataLine line;
    private byte[] buffer = new byte[4096];

    public JavaSoundAudioRecorder(int n2, boolean bl2) {
        try {
            AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, n2, 16, bl2 ? 1 : 2, bl2 ? 2 : 4, n2, false);
            this.line = AudioSystem.getTargetDataLine(audioFormat);
            this.line.open(audioFormat, this.buffer.length);
            this.line.start();
        }
        catch (Exception exception) {
            throw new AudioException("Error creating JavaSoundAudioRecorder.", exception);
        }
    }

    @Override
    public void read(short[] sArray, int n2, int n3) {
        if (this.buffer.length < n3 * 2) {
            this.buffer = new byte[n3 * 2];
        }
        int n4 = n3 * 2;
        for (int i2 = 0; i2 != n4; i2 += this.line.read(this.buffer, i2, n4 - i2)) {
        }
        int n5 = 0;
        int n6 = 0;
        while (n5 < n3 * 2) {
            sArray[n2 + n6] = (short)(this.buffer[n5 + 1] << 8 | this.buffer[n5] & 0xFF);
            n5 += 2;
            ++n6;
        }
    }

    @Override
    public void dispose() {
        this.line.close();
    }
}

