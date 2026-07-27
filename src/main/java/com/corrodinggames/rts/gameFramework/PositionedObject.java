/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

import java.io.IOException;

import com.corrodinggames.rts.gameFramework.GGameObject;

public abstract class PositionedObject
extends GGameObject {
    public int ex = 0;

    protected PositionedObject(boolean bl2) {
        super(bl2);
    }

    @Override
    public void a(GameOutputStream as2) throws IOException {
        as2.d("xy is:");
        as2.a(this.posX);
        as2.a(this.posY);
        as2.a(this.posZ);
        as2.a(this.ex);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.posX = k2.g();
        this.posY = k2.g();
        this.posZ = k2.g();
        this.ex = k2.readInt();
        super.a(k2);
    }
}

