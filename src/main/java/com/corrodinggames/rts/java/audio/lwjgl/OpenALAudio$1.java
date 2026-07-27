/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.AudioDevice;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio;

class OpenALAudio$1
implements AudioDevice {
    final /* synthetic */ boolean val$isMono;
    final /* synthetic */ OpenALAudio this$0;

    OpenALAudio$1(OpenALAudio openALAudio, boolean bl2) {
        this.this$0 = openALAudio;
        this.val$isMono = bl2;
    }

    @Override
    public void writeSamples(float[] fArray, int n2, int n3) {
    }

    @Override
    public void writeSamples(short[] sArray, int n2, int n3) {
    }

    @Override
    public void setVolume(float f2) {
    }

    @Override
    public boolean isMono() {
        return this.val$isMono;
    }

    @Override
    public int getLatency() {
        return 0;
    }

    @Override
    public void dispose() {
    }
}

