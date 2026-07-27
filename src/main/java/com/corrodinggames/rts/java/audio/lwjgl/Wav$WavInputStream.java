/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.a.AudioFile;
import com.corrodinggames.rts.java.audio.a.AudioException;
import com.corrodinggames.rts.java.audio.a.s;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;

public class Wav$WavInputStream
extends FilterInputStream {
    public int channels;
    public int sampleRate;
    public int dataRemaining;

    public Wav$WavInputStream(AudioFile a2) {
        super(a2.a());
        try {
            if (this.read() != 82 || this.read() != 73 || this.read() != 70 || this.read() != 70) {
                throw new AudioException("RIFF header not found: " + a2);
            }
            this.skipFully(4);
            if (this.read() != 87 || this.read() != 65 || this.read() != 86 || this.read() != 69) {
                throw new AudioException("Invalid wave file header: " + a2);
            }
            int n2 = this.seekToChunk('f', 'm', 't', ' ');
            int n3 = this.read() & 0xFF | (this.read() & 0xFF) << 8;
            if (n3 != 1) {
                String string2;
                switch (n3) {
                    case 2: {
                        string2 = "ADPCM";
                        break;
                    }
                    case 3: {
                        string2 = "IEEE float";
                        break;
                    }
                    case 6: {
                        string2 = "8-bit ITU-T G.711 A-law";
                        break;
                    }
                    case 7: {
                        string2 = "8-bit ITU-T G.711 u-law";
                        break;
                    }
                    case 65534: {
                        string2 = "Extensible";
                        break;
                    }
                    default: {
                        string2 = "Unknown";
                    }
                }
                throw new AudioException("WAV files must be PCM, unsupported format: " + string2 + " (" + n3 + ")");
            }
            this.channels = this.read() & 0xFF | (this.read() & 0xFF) << 8;
            if (this.channels != 1 && this.channels != 2) {
                throw new AudioException("WAV files must have 1 or 2 channels: " + this.channels);
            }
            this.sampleRate = this.read() & 0xFF | (this.read() & 0xFF) << 8 | (this.read() & 0xFF) << 16 | (this.read() & 0xFF) << 24;
            this.skipFully(6);
            int n4 = this.read() & 0xFF | (this.read() & 0xFF) << 8;
            if (n4 != 16) {
                throw new AudioException("WAV files must have 16 bits per sample: " + n4);
            }
            this.skipFully(n2 - 16);
            this.dataRemaining = this.seekToChunk('d', 'a', 't', 'a');
        }
        catch (Throwable throwable) {
            s.a(this);
            throw new AudioException("Error reading WAV file: " + a2, throwable);
        }
    }

    private int seekToChunk(char c2, char c3, char c4, char c5) throws IOException {
        while (true) {
            boolean bl2 = this.read() == c2;
            bl2 &= this.read() == c3;
            bl2 &= this.read() == c4;
            bl2 &= this.read() == c5;
            int n2 = this.read() & 0xFF | (this.read() & 0xFF) << 8 | (this.read() & 0xFF) << 16 | (this.read() & 0xFF) << 24;
            if (n2 == -1) {
                throw new IOException("Chunk not found: " + c2 + c3 + c4 + c5);
            }
            if (bl2) {
                return n2;
            }
            this.skipFully(n2);
        }
    }

    private void skipFully(int n2) throws IOException {
        while (n2 > 0) {
            long l2 = this.in.skip(n2);
            if (l2 <= 0L) {
                throw new EOFException("Unable to skip.");
            }
            n2 = (int)((long)n2 - l2);
        }
    }

    @Override
    public int read(byte[] byArray) throws IOException {
        if (this.dataRemaining == 0) {
            return -1;
        }
        int n2 = Math.min(super.read(byArray), this.dataRemaining);
        if (n2 == -1) {
            return -1;
        }
        this.dataRemaining -= n2;
        return n2;
    }
}

