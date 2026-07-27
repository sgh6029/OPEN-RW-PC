/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.corrodinggames.rts.gameFramework.b;

import android.opengl.GLES20;
import android.util.Log;

import com.corrodinggames.rts.gameFramework.b.OpenGLRenderer;
import com.corrodinggames.rts.gameFramework.b.ShaderVariable;

class ShaderUniform
extends ShaderVariable {
    public ShaderUniform(String string2) {
        super(string2);
    }

    @Override
    public void a(int n2) {
        if (this.c != n2) {
            this.a = GLES20.glGetUniformLocation((int)n2, (String)this.b);
            this.c = n2;
            OpenGLRenderer.r();
            if (this.a == -1) {
                Log.d(OpenGLRenderer.s(), "loadHandle: Failed to find: " + this.b);
            }
        }
    }
}

