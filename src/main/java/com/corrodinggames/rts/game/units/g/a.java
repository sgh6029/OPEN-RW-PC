/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.g;

import com.corrodinggames.rts.game.units.g.b;

import java.io.IOException;

import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

public abstract class a {
    int a;

    public a() {
    }

    public a(int n2) {
        this.a = n2;
    }

    public int a() {
        return this.a;
    }

    public abstract b b();

    public void a(y y2, float f2) {
    }

    public void a(y y2, GameOutputStream as2)  throws IOException {
        as2.a(this.a);
    }

    public void a(y y2, GameInputStream k2) throws IOException {
        this.a = k2.readInt();
    }
}

