/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.b.a.a;

import com.corrodinggames.rts.gameFramework.b.a.ShaderAttributeType;
import com.corrodinggames.rts.gameFramework.b.a.ShaderUtils;

public abstract class ShaderProgramBase {
    private int a;
    private int b;
    private int c;
    private boolean d = false;

    public void a() {
        this.a(null, null, null);
    }

    public void a(String string2, String string3, ShaderAttributeType[] aArray) {
        this.b = ShaderUtils.a(35633, string2);
        this.c = ShaderUtils.a(35632, string3);
        this.a = ShaderUtils.a(this.b, this.c, aArray);
        this.d = true;
    }

    public int b() {
        return this.a;
    }
}

