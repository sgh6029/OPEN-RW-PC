/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.java.SlickTexture;
import java.nio.ByteBuffer;
import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.MiscUtils;

public class SlickImageData
implements ImageData {
    int a;
    private int c;
    private int d;
    private int e;
    private int f;
    private byte[] g;
    final /* synthetic */ SlickTexture b;

    public SlickImageData(SlickTexture s2, Image image) {
        this.b = s2;
        Texture texture = image.getTexture();
        this.g = texture.getTextureData();
        this.a = texture.hasAlpha() ? 32 : 24;
        this.c = texture.getImageWidth();
        this.d = texture.getImageHeight();
        this.e = texture.getTextureWidth();
        this.f = texture.getTextureHeight();
    }

    @Override
    public int getDepth() {
        return this.a;
    }

    @Override
    public int getWidth() {
        return this.c;
    }

    @Override
    public int getHeight() {
        return this.d;
    }

    @Override
    public int getTexWidth() {
        return this.e;
    }

    @Override
    public int getTexHeight() {
        return this.f;
    }

    @Override
    public ByteBuffer getImageBufferData() {
        ByteBuffer byteBuffer = MiscUtils.createByteBuffer(this.g.length);
        byteBuffer.put(this.g);
        byteBuffer.flip();
        return byteBuffer;
    }

    public byte[] a() {
        return this.g;
    }
}

