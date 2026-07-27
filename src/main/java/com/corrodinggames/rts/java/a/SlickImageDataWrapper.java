/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.a;

import java.nio.ByteBuffer;
import org.newdawn.slick.opengl.ImageData;

//SlickImageDataWrapper
public class SlickImageDataWrapper
implements ImageData {
    ImageData a;
    ByteBuffer b;

    public SlickImageDataWrapper(ImageData imageData, ByteBuffer byteBuffer) {
        this.a = imageData;
        this.b = byteBuffer;
    }

    @Override
    public int getDepth() {
        return this.a.getDepth();
    }

    @Override
    public int getHeight() {
        return this.a.getHeight();
    }

    @Override
    public ByteBuffer getImageBufferData() {
        return this.b;
    }

    @Override
    public int getTexHeight() {
        return this.a.getTexHeight();
    }

    @Override
    public int getTexWidth() {
        return this.a.getTexWidth();
    }

    @Override
    public int getWidth() {
        return this.a.getWidth();
    }
}

