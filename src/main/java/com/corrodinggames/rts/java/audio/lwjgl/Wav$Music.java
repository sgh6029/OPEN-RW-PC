/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.a.AudioFile;
import com.corrodinggames.rts.java.audio.a.AudioException;
import com.corrodinggames.rts.java.audio.a.s;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALMusic;
import com.corrodinggames.rts.java.audio.lwjgl.Wav$WavInputStream;
import java.io.IOException;

public class Wav$Music
extends OpenALMusic {
    private Wav$WavInputStream input;

    public Wav$Music(OpenALAudio openALAudio, AudioFile a2) {
        super(openALAudio, a2);
        this.input = new Wav$WavInputStream(a2);
        if (openALAudio.noDevice) {
            return;
        }
        this.setup(this.input.channels, this.input.sampleRate);
    }

    @Override
    public int read(byte[] byArray) {
        if (this.input == null) {
            this.input = new Wav$WavInputStream(this.file);
            this.setup(this.input.channels, this.input.sampleRate);
        }
        try {
            return this.input.read(byArray);
        }
        catch (IOException iOException) {
            throw new AudioException("Error reading WAV file: " + this.file, iOException);
        }
    }

    @Override
    public void reset() {
        s.a(this.input);
        this.input = null;
    }
}

