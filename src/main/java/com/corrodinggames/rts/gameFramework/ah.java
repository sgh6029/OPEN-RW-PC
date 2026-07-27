/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.ac;
import com.corrodinggames.rts.gameFramework.af;

public class ah
extends af {
    int e = -1;
    int f = -1;
    boolean g;
    int h = -1;
    float i;
    boolean j = false;

    @Override
    public boolean a() {
        if (this.b()) {
            if (!this.c) {
                this.c = true;
                return true;
            }
            return false;
        }
        if (this.c) {
            this.c = false;
        }
        return false;
    }

    @Override
    public boolean b() {
        return this.e() > 0.5f;
    }

    public float e() {
        return this.a(false);
    }

    public float a(boolean bl2) {
        float f2;
        if (this.h != -1) {
            f2 = ac.b.a(this.h, this.e) ? 0.0f : 1.0f;
        } else {
            f2 = ac.b.b(this.e, this.f);
            float f3 = f2 = this.g ? -f2 : f2;
        }
        if (bl2) {
            return f2;
        }
        if (!this.j && Math.abs(f2 - this.i) > 0.001f) {
            this.j = true;
        }
        if (!this.j) {
            return 0.0f;
        }
        return f2;
    }

    @Override
    public String c() {
        return "controller";
    }

    @Override
    public boolean d() {
        return false;
    }
}

