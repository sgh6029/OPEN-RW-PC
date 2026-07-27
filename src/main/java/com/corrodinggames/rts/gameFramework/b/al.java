/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.corrodinggames.rts.gameFramework.b;

import android.opengl.GLES20;
import com.corrodinggames.rts.gameFramework.b.aj;
import com.corrodinggames.rts.gameFramework.b.OpenGLRenderer;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class al {
    public final FloatBuffer a;
    public final ShortBuffer b;
    public int c;
    int[] d;
    int e;
    final /* synthetic */ aj f = new aj();//TODO：原先没有

    public al() {
        // Initialize FloatBuffer with a reasonable capacity for vertex data
        // Using 1024 floats as initial capacity (enough for 256 vertices with 4 floats each)
        this.a = FloatBuffer.allocate(1024);
        // ShortBuffer can be null initially since it's optional for indexed rendering
        this.b = null;
    }

    public void a(float[] fArray, int n2, int n3) {
        this.a.clear();
        int n4 = n2 + n3;
        this.a.put(fArray, 0, n3);
        this.a.flip();
        this.c = n3;
    }

    public void a() {
        GLES20.glEnableVertexAttribArray((int)this.f.h.a.a);
        GLES20.glEnableVertexAttribArray((int)this.f.h.b.a);
    }

    public void b() {
        OpenGLRenderer.q();
        if (this.d == null) {
            this.d = new int[1];
            GLES20.glGenBuffers((int)1, (int[])this.d, (int)0);
            OpenGLRenderer.r();
        }
        ++this.e;
        if (this.e >= 1) {
            this.e = 0;
        }
        GLES20.glBindBuffer((int)34962, (int)this.d[this.e]);
        GLES20.glBufferData((int)34962, (int)(this.c * 4), (Buffer)this.a, (int)35040);
        GLES20.glVertexAttribPointer((int)this.f.h.a.a, (int)2, (int)5126, (boolean)false, (int)32, (int)0);
        OpenGLRenderer.q();
        OpenGLRenderer.q();
        GLES20.glVertexAttribPointer((int)this.f.h.b.a, (int)4, (int)5126, (boolean)false, (int)32, (int)16);
        OpenGLRenderer.q();
    }

    public void a(int n2, int n3, int n4) {
        if (this.b != null) {
            this.b.position(n3);
            GLES20.glDrawElements((int)n2, (int)n4, (int)5123, (Buffer)this.b);
        } else {
            GLES20.glDrawArrays((int)n2, (int)n3, (int)n4);
        }
    }

    public void c() {
        GLES20.glBindBuffer((int)34962, (int)0);
    }

    public void d() {
        this.a();
    }

    public void e() {
        GLES20.glDisableVertexAttribArray((int)this.f.h.b.a);
    }
}
