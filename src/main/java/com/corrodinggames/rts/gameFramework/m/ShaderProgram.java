/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.m;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.FileChangeEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ShaderUniform;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.storage.a;

import android.graphics.Paint;

import java.io.IOException;
import java.util.Arrays;

public class ShaderProgram {
    public String c;
    public String d = "";
    public String e;
    public String f;
    public int g;
    public int h;
    String i;
    String j;
    long k;
    long l;
    public boolean m;
    public int n;
    public int o;
    public ShaderUniform[] p = new ShaderUniform[0];
    public Object q;
    public int r;
    int s;

    public void a(String string2, float f2) {
        this.a(string2).a(f2);
    }

    public void a(String string2, float f2, float f3) {
        this.a(string2).a(f2, f3);
    }

    public void a(String string2, int n2) {
        float f2 = (float)(n2 >> 16 & 0xFF) * 0.003921569f;
        float f3 = (float)(n2 >> 8 & 0xFF) * 0.003921569f;
        float f4 = (float)(n2 & 0xFF) * 0.003921569f;
        float f5 = (float)(n2 >>> 24) * 0.003921569f;
        this.a(string2).a(f2, f3, f4, f5);
    }

    public void a(String string2, Texture_M e2) {
        ShaderUniform af2 = this.a(string2);
        af2.a(e2);
    }

    public void b(String string2, Texture_M e2) {
        ShaderUniform af2 = this.a(string2);
        af2.b(e2);
    }

    public ShaderUniform a(String string2) {
        for (ShaderUniform af2 : this.p) {
            if (!af2.a.equals(string2)) continue;
            return af2;
        }
        ShaderUniform af3 = new ShaderUniform();
        af3.a = string2;
        ShaderUniform[] afArray = Arrays.copyOf(this.p, this.p.length + 1);
        afArray[afArray.length - 1] = af3;
        this.p = afArray;
        return af3;
    }

    public ShaderProgram(String string2) throws IOException {
        String string3 = "assets/shaders/plain.vert";
        if (com.corrodinggames.rts.gameFramework.GameEngine.isPCVersionStatic2) {
            string3 = "assets/shaders/plainGDX.vert";
        }
        this.a(string3, string2);
    }

    public void a(String string2, String string3) throws IOException {
        this.c = com.corrodinggames.rts.gameFramework.GameUtils.g(string3);
        this.i = string2;
        this.j = string3;
        this.d();
        this.e();
    }

    public ShaderProgram() {
        this.c = "Invalid";
        this.o = 1;
    }

    public void d() throws IOException {
        com.corrodinggames.rts.gameFramework.utility.AssetInputStream j2 = a.k(this.i);
        if (j2 == null) {
            throw new IOException("Cannot find: " + this.i);
        }
        this.e = com.corrodinggames.rts.gameFramework.GameUtils.a(j2);
        com.corrodinggames.rts.gameFramework.utility.AssetInputStream j3 = a.k(this.j);
        if (j3 == null) {
            throw new IOException("Cannot find: " + this.j);
        }
        this.f = com.corrodinggames.rts.gameFramework.GameUtils.a(j3);
    }

    public void b(String string2) {
        com.corrodinggames.rts.gameFramework.GameEngine.log("shader(" + this.c + "): " + string2);
    }

    public void c(String string2) {
        if (this.r < 3) {
            ++this.r;
            com.corrodinggames.rts.gameFramework.GameEngine.p("shader(" + this.c + "): " + string2);
        }
        com.corrodinggames.rts.gameFramework.GameEngine.a("shader(" + this.c + "): " + string2);
        this.o = 1;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean a(Paint paint, Texture_M e2) {
        return false;
    }

    public boolean e() {
        long l2 = com.corrodinggames.rts.gameFramework.FileChangeEngine.a(this.i, false);
        long l3 = com.corrodinggames.rts.gameFramework.FileChangeEngine.a(this.j, false);
        boolean bl2 = l2 != this.k || l3 != this.l;
        this.k = l2;
        this.l = l3;
        return bl2;
    }

    public void f() throws IOException {
        ++this.s;
        if (this.s < 100) {
            return;
        }
        this.s = 0;
        if (this.e()) {
            this.b("Reloading shader");
            this.d();
            this.m = true;
            this.o = 0;
            for (ShaderUniform af2 : this.p) {
                af2.c = true;
                af2.b = -1;
            }
        }
    }

    public void c() {
        GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        l2.bO.a(this);
    }
}

