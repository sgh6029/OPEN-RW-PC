/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.m;

import android.graphics.Bitmap;

public class ad
extends Texture_M {
    Texture_M x;

    public ad(Texture_M e2) {
        this.x = e2;
        this.k = e2.k;
    }

    @Override
    public String a() {
        return this.x.a();
    }

    @Override
    public Bitmap b() {
        return this.x.b();
    }

    @Override
    public Texture_M c() {
        return this.x.c();
    }

    @Override
    public void a(boolean bl2) {
    }

    @Override
    public void a(Bitmap bitmap) {
    }

    @Override
    public void g() {
        this.x.g();
    }

    @Override
    public void a(Texture_M e2) {
        this.x.a(e2);
    }

    @Override
    public Texture_M h() {
        return this;
    }

    @Override
    public Texture_M a(int n2, int n3, boolean bl2) {
        return this;
    }

    @Override
    public void i() {
    }

    @Override
    public void j() {
    }

    @Override
    public int a(int n2, int n3) {
        return this.x.a(n2, n3);
    }

    @Override
    public void a(int n2, int n3, int n4) {
    }

    @Override
    public int l() {
        return this.x.l();
    }

    @Override
    public int m() {
        return this.x.m();
    }

    @Override
    public void n() {
    }

    @Override
    public void o() {
    }

    @Override
    public void p() {
    }

    @Override
    public void r() {
    }

    @Override
    public void t() {
    }

    @Override
    public int u() {
        return this.x.u();
    }

    @Override
    public void v() {
    }

    @Override
    public void w() {
    }

    public String toString() {
        return "MutableBitmapOrTexture(" + this.x.toString() + ")";
    }

    @Override
    public ShaderProgram B() {
        return this.x.i;
    }

    @Override
    public void a(ShaderProgram ae2) {
    }

    @Override
    public /* synthetic */ Object clone() {
        return this.h();
    }
}

