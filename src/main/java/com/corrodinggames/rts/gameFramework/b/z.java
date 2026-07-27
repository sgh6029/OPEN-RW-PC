/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.b;

import com.corrodinggames.rts.gameFramework.b.ShaderAttribute;
import com.corrodinggames.rts.gameFramework.b.ShaderVariable;
import com.corrodinggames.rts.gameFramework.b.ShaderUniform;

public class z {
    ShaderAttribute a = new ShaderAttribute("aPosition");
    ShaderAttribute b = new ShaderAttribute("aTextureCoordinate");
    ShaderAttribute c = new ShaderAttribute("aColor");
    ShaderUniform d = new ShaderUniform("uProjection");
    ShaderUniform e = new ShaderUniform("u_texture");
    ShaderVariable[] f = new ShaderVariable[]{this.a, this.b, this.c, this.d, this.e};
}

