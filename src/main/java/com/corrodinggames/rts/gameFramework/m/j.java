/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 */
package com.corrodinggames.rts.gameFramework.m;

import android.graphics.PorterDuff;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.corrodinggames.rts.gameFramework.m.aa;
import com.corrodinggames.rts.gameFramework.m.ShaderProgram;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.m.l;
import com.corrodinggames.rts.gameFramework.m.m;
import java.util.concurrent.locks.Lock;

public class j
implements l {
    public Canvas a;
    boolean b = false;

    public j(Canvas canvas) {
        this.a = canvas;
    }

    @Override
    public void a(Rect rect) {
        this.a.a(rect);
    }

    @Override
    public void a(RectF rectF) {
        this.a.a(rectF);
    }

    @Override
    public void a(Texture_M e2, float f2, float f3, Paint paint) {
        this.a.a(aa.a(e2), f2, f3, paint);
    }

    @Override
    public void a(Texture_M e2, Rect rect, Rect rect2, Paint paint) {
        this.a.a(aa.a(e2), rect, rect2, paint);
    }

    @Override
    public void a(Texture_M e2, Rect rect, RectF rectF, Paint paint) {
        this.a.a(aa.a(e2), rect, rectF, paint);
    }

    @Override
    public void a(float f2, float f3, float f4, Paint paint) {
        this.a.a(f2, f3, f4, paint);
    }

    @Override
    public void a(int n2, PorterDuff.Mode mode) {
        this.a.a(n2, mode);
    }

    @Override
    public void a(int n2) {
        this.a.a(n2);
    }

    @Override
    public void a(float f2, float f3, float f4, float f5, Paint paint) {
        this.a.a(f2, f3, f4, f5, paint);
    }

    @Override
    public void a(float[] fArray, int n2, int n3, Paint paint) {
        this.a.a(fArray, n2, n3, paint);
    }

    @Override
    public void a(Rect rect, Paint paint) {
        this.a.a(rect, paint);
    }

    @Override
    public void a(RectF rectF, Paint paint) {
        this.a.a(rectF, paint);
    }

    @Override
    public void a(String string2, float f2, float f3, Paint paint) {
        this.a.a(string2, f2, f3, paint);
    }

    public boolean equals(Object object) {
        return this.a.equals(object);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public void a() {
        this.a.b();
    }

    @Override
    public void a(float f2, float f3, float f4) {
        this.a.a(f2, f3, f4);
    }

    @Override
    public void b() {
        this.a.a();
    }

    @Override
    public void a(float f2, float f3, float f4, float f5) {
        this.a.a(f2, f3, f4, f5);
    }

    @Override
    public void a(float f2, float f3) {
        this.a.b(f2, f3);
    }

    @Override
    public void a(Texture_M e2) {
        this.a.a(e2.b());
    }

    public String toString() {
        return this.a.toString();
    }

    @Override
    public void b(float f2, float f3) {
        this.a.a(f2, f3);
    }

    @Override
    public void a(boolean bl2) {
        this.b = bl2;
    }

    @Override
    public boolean c() {
        return this.b;
    }

    @Override
    public void a(m m2) {
        m2.a(com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bO);
    }

    @Override
    public void a(Bitmap bitmap) {
    }

    @Override
    public void a(Lock lock) {
    }

    @Override
    public void b(Lock lock) {
    }

    @Override
    public boolean a(ShaderProgram ae2) {
        return false;
    }
}

