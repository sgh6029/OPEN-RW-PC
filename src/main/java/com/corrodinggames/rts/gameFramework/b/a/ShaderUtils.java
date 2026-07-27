/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.corrodinggames.rts.gameFramework.b.a;

import android.opengl.GLES20;
import android.util.Log;

import com.corrodinggames.rts.gameFramework.b.a.ShaderAttributeType;

public class ShaderUtils {
    public static int a(int n2, int n3, ShaderAttributeType[] aArray) {
        int n4 = GLES20.glCreateProgram();
        if (n4 != 0) {
            GLES20.glAttachShader((int)n4, (int)n2);
            GLES20.glAttachShader((int)n4, (int)n3);
            for (ShaderAttributeType a2 : aArray) {
                GLES20.glBindAttribLocation((int)n4, (int)a2.a(), (String)a2.b());
            }
            GLES20.glLinkProgram((int)n4);
            int[] nArray = new int[1];
            GLES20.glGetProgramiv((int)n4, (int)35714, (int[])nArray, (int)0);
            if (nArray[0] == 0) {
                Log.a("Utilities", GLES20.glGetProgramInfoLog((int)n4));
                GLES20.glDeleteProgram((int)n4);
                n4 = 0;
            }
        }
        if (n4 == 0) {
            throw new RuntimeException("Error creating program.");
        }
        return n4;
    }

    public static int a(int n2, String string2) {
        int n3 = GLES20.glCreateShader((int)n2);
        if (n3 != 0) {
            GLES20.glShaderSource((int)n3, (String)string2);
            GLES20.glCompileShader((int)n3);
            int[] nArray = new int[1];
            GLES20.glGetShaderiv((int)n3, (int)35713, (int[])nArray, (int)0);
            if (nArray[0] == 0) {
                Log.a("Utilities", "Shader fail info: " + GLES20.glGetShaderInfoLog((int)n3));
                GLES20.glDeleteShader((int)n3);
                n3 = 0;
            }
        }
        if (n3 == 0) {
            throw new RuntimeException("Error creating shader " + n2);
        }
        return n3;
    }
}

