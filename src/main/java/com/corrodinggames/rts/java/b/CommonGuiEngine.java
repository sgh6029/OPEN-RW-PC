/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.b;

import com.corrodinggames.rts.java.Main;

public class CommonGuiEngine
extends com.corrodinggames.librocket.a {
    public Main f;
    boolean g = false;

    public static synchronized CommonGuiEngine p() {
        if (a != null) {
            throw new RuntimeException("CommonGuiEngine already exists");
        }
        CommonGuiEngine a2 = new CommonGuiEngine();
        a = a2;
        return a2;
    }

    @Override
    public void g() {
        this.f.i();
    }

    @Override
    public void h() {
        this.f.u = true;
    }

    @Override
    public int i() {
        return this.f.gameHandler.e();
    }

    @Override
    public void d(boolean bl2) {
        this.f.a(bl2);
    }
}

