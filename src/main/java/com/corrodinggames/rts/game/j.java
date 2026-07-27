/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ShaderProgram;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.m.y;

import android.graphics.Paint;
import android.graphics.Rect;

import com.corrodinggames.rts.gameFramework.AssetType;
import java.io.IOException;

public class j {
    public Texture_M a;
    y b;
    ag c;
    ShaderProgram d;
    Paint e = new Paint();
    Rect f = new Rect(-101, 0, -1, 100);
    boolean g;

    public j() {
        this.c = new ag();
    }

    public j(String string2) throws IOException {
        this();
        this.d = new ShaderProgram(string2);
        this.c.a(this.d);
        if (this.d.o != 0) {
            this.g = true;
        }
    }

    public boolean a() {
        if (this.d != null && this.d.o != 0) {
            return true;
        }
        return this.g;
    }

    public void a(y y2) {
        this.a(y2, y2.m(), y2.n(), 10);
    }

    public void a(y y2, int n2, int n3, int n4) {
        if (this.g) {
            return;
        }
        if (this.a != null && (n2 > this.a.m() || n3 > this.a.l())) {
            this.a.o();
            this.a = null;
            this.b = null;
        }
        if (this.a == null) {
            try {
                this.a = y2.a(n2 + n4, n3 + n4, true);
                this.b = y2.a(this.a);
            }
            catch (OutOfMemoryError outOfMemoryError) {
                this.g = true;
                GameEngine.a(AssetType.gameImageCreate, (Throwable)outOfMemoryError);
                return;
            }
        }
        this.b.a(n2, n3);
    }

    public void b() throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        l2.bO.b(this.f, this.e);
        l2.bO.b(this.a, 0.0f, 0.0f, (Paint)this.c);
    }
}

