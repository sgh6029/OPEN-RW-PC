/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.b;

import com.corrodinggames.rts.gameFramework.m.Texture_M;

class TilesetImageDescriptor {
    static int nextEmbedId = 1;
    public boolean inUse;
    public String pathPrefix;
    public String imageKey;
    public Texture_M texture;
    public String embeddedBase64;
    public String originalImageName;

    TilesetImageDescriptor() {
    }
}

