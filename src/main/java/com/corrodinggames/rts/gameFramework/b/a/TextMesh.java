/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.corrodinggames.rts.gameFramework.b.a;

import android.opengl.GLES20;
import com.corrodinggames.rts.gameFramework.b.a.ShaderAttributeType;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class TextMesh {
    public final int a;
    public final int b;
    public final int c;
    public final IntBuffer d;
    public final ShortBuffer e;
    public int f;
    public int g;
    final int[] h;
    private int i;
    private int j;

    public TextMesh(int n2, int n3) {
        this.a = 2;
        this.b = this.a + 2;
        this.c = this.b * 4;
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n2 * this.c);
        byteBuffer.order(ByteOrder.nativeOrder());
        this.d = byteBuffer.asIntBuffer();
        if (n3 > 0) {
            byteBuffer = ByteBuffer.allocateDirect(n3 * 2);
            byteBuffer.order(ByteOrder.nativeOrder());
            this.e = byteBuffer.asShortBuffer();
        } else {
            this.e = null;
        }
        this.f = 0;
        this.g = 0;
        this.h = new int[n2 * this.c / 4];
        this.i = com.corrodinggames.rts.gameFramework.b.a.ShaderAttributeType.A_TexCoordinate.a();
        this.j = com.corrodinggames.rts.gameFramework.b.a.ShaderAttributeType.A_Position.a();
    }

    public void a(float[] fArray, int n2, int n3) {
        this.d.clear();
        int n4 = n2 + n3;
        int n5 = n2;
        int n6 = 0;
        while (n5 < n4) {
            this.h[n6] = Float.floatToRawIntBits(fArray[n5]);
            ++n5;
            ++n6;
        }
        this.d.put(this.h, 0, n3);
        this.d.flip();
        this.f = n3 / this.b;
    }

    public void a(short[] sArray, int n2, int n3) {
        this.e.clear();
        this.e.put(sArray, n2, n3);
        this.e.flip();
        this.g = n3;
    }

    public void a() {
        this.d.position(0);
        GLES20.glVertexAttribPointer((int)this.j, (int)this.a, (int)5126, (boolean)false, (int)this.c, (Buffer)this.d);
        GLES20.glEnableVertexAttribArray((int)this.j);
        this.d.position(this.a);
        GLES20.glVertexAttribPointer((int)this.i, (int)2, (int)5126, (boolean)false, (int)this.c, (Buffer)this.d);
        GLES20.glEnableVertexAttribArray((int)this.i);
    }

    public void a(int n2, int n3, int n4) {
        if (this.e != null) {
            this.e.position(n3);
            GLES20.glDrawElements((int)n2, (int)n4, (int)5123, (Buffer)this.e);
        } else {
            GLES20.glDrawArrays((int)n2, (int)n3, (int)n4);
        }
    }

    public void b() {
        GLES20.glDisableVertexAttribArray((int)this.i);
    }
}

