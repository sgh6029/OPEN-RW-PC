/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.java.SlickTexture;

import android.graphics.Bitmap;

import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.ImageData;

public class SlickTextureWrapper
extends SlickTexture {
    SlickTexture x;

    public SlickTextureWrapper(SlickTexture s2) {
        this.x = s2;
    }

    @Override
    public Image C() {
        return this.x.C();
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
    public String a() {
        return this.x.a();
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
    public int u() {
        return this.x.u();
    }

    @Override
    public void w() {
    }

    @Override
    public Texture_M a(int n2, int n3, boolean bl2) {
        return this;
    }

    @Override
    public int a(int n2, int n3) {
        return this.x.a(n2, n3);
    }

    @Override
    public void p() {
    }

    @Override
    public void r() {
    }

    @Override
    public void n() {
    }

    @Override
    public Texture_M h() {
        return this;
    }

    @Override
    public void t() {
    }

    @Override
    public long c(boolean bl2) {
        return this.x.c(bl2);
    }

    @Override
    public void a(boolean bl2) {
    }

    @Override
    public void a(Bitmap bitmap) {
    }

    @Override
    public void g() {
    }

    @Override
    public void a(Texture_M e2) {
        this.x.a(e2);
    }

    @Override
    public void D() {
    }

    @Override
    public void a(Image image, String string2) {
    }

    @Override
    public void a(ImageData imageData, String string2, boolean bl2) {
    }

    @Override
    public void v() {
    }

    @Override
    public void i() {
    }

    @Override
    public void j() {
    }

    @Override
    public void a(int n2, int n3, int n4) {
    }

    @Override
    public void o() {
    }

    @Override
    public void E() {
    }

    @Override
    public void F() {
    }

    @Override
    public void G() {
        this.x.G();
    }

    public String toString() {
        return this.x.toString();
    }

    @Override
    public boolean A() {
        return true;
    }

    @Override
    public /* synthetic */ Object clone() {
        return this.h();
    }
}

