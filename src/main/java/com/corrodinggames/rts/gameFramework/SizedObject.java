/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.PositionedObject;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

public abstract class SizedObject
extends PositionedObject {
    public int es;
    public int et;
    public float eu;
    public float ev;
    public boolean ew;

    public void b(Texture_M e2) {
        this.T(e2.p);
        this.U(e2.q);
        this.ew = true;
    }

    public void a(Texture_M e2, int n2) {
        this.T(e2.p / n2);
        this.U(e2.q);
        this.ew = false;
    }

    public void T(int n2) {
        this.es = n2;
        this.eu = n2 / 2;
    }

    public void U(int n2) {
        this.et = n2;
        this.ev = n2 / 2;
    }

    public void V(int n2) {
        this.es = n2;
        this.eu = (float)n2 / 2.0f;
    }

    public void W(int n2) {
        this.et = n2;
        this.ev = (float)n2 / 2.0f;
    }

    protected SizedObject(boolean bl2) {
        super(bl2);
    }

    @Override
    public void a() {
        super.a();
    }
}

