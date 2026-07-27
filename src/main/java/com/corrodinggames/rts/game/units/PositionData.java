/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import java.io.IOException;

import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

public class PositionData {
    public float posX;
    public float posY;

    public void a(GameOutputStream as2) throws IOException {
        as2.a(this.posX);
        as2.a(this.posY);
    }

    public void a(GameInputStream k2)  throws IOException {
        this.posX = k2.g();
        this.posY = k2.g();
    }
}

