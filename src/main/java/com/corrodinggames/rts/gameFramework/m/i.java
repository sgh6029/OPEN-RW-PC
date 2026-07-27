/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.m;

import java.io.IOException;

import com.corrodinggames.rts.gameFramework.m.ShaderProgram;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import android.graphics.Paint;

import com.corrodinggames.rts.gameFramework.m.TeamColorTexture;

public class i
extends ShaderProgram {
    int a = -99;
    boolean b;

    public i(String string2, boolean bl2) throws IOException {
        super(string2);
    }

    @Override
    public boolean a() {
        return this.b;
    }

    @Override
    public boolean b() {
        boolean bl2 = false;
        int n2 = -16711936;
        if (n2 != this.a) {
            this.a("teamColor", n2);
            bl2 = true;
            this.a = n2;
        }
        return bl2;
    }

    @Override
    public boolean a(Paint paint, Texture_M e2) {
        boolean bl2 = false;
        if (e2 instanceof TeamColorTexture) {
            TeamColorTexture h2 = (TeamColorTexture)e2;
            if (h2.D != this.a) {
                this.a("teamColor", h2.D);
                bl2 = true;
                this.a = h2.D;
            }
        }
        super.a(paint, e2);
        return bl2;
    }

    @Override
    public void c() {
        super.c();
    }
}

