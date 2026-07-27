/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

public class av
extends MusicFactory {
    boolean a = false;

    @Override
    public GameMusic a(String string2) {
        return new aw(string2, this);
    }

    @Override
    public MusicTrack a() {
        ax ax2 = new ax(this);
        return ax2;
    }

    @Override
    public void a(MusicManager am2) {
        GameEngine.log("Null musicFactory - load");
        this.e = am2;
    }

    @Override
    public void b() {
    }
}

