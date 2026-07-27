/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 */
package com.corrodinggames.rts.gameFramework.m;

import android.graphics.PorterDuff;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.corrodinggames.rts.gameFramework.m.AndroidGLRenderer;
import com.corrodinggames.rts.gameFramework.m.ShaderProgram;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.m.l;
import com.corrodinggames.rts.gameFramework.m.m;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.Lock;

public interface y {
    public y b(Texture_M var1);

    public y a(Texture_M var1);

    public boolean a();

    public void a(Context var1);

    public void b();

    public l d();

    public void a(l var1);

    public void a(AndroidGLRenderer var1);

    public Texture_M a(int var1);

    public Texture_M a(int var1, boolean var2);

    public Texture_M a(InputStream var1, boolean var2);

    public Texture_M a(int var1, int var2, boolean var3);

    public Texture_M b(int var1, int var2, boolean var3);

    public void e();

    public void a(Texture_M var1, float var2, float var3, float var4, Paint var5) throws IOException;

    public void a(Texture_M var1, Rect var2, float var3, float var4, float var5, Paint var6) throws IOException;

    public void a(Texture_M var1, Rect var2, Rect var3, Paint var4) throws IOException;

    public void a(Texture_M var1, Rect var2, RectF var3, Paint var4) throws IOException;

    public void a(Texture_M var1, float var2, float var3, Paint var4) throws IOException;

    public void a(Texture_M var1, float var2, float var3, Paint var4, float var5, float var6) throws IOException;

    public void b(Texture_M var1, float var2, float var3, Paint var4) throws IOException;

    public void b(Texture_M var1, Rect var2, Rect var3, Paint var4) throws IOException;

    public void a(Rect var1, Paint var2) throws IOException;

    public void a(boolean var1);

    public void f();

    public void a(Texture_M var1, Rect var2, Paint var3);

    public void a(Texture_M var1, Rect var2, Paint var3, int var4, int var5, int var6, int var7);

    public void a(Texture_M var1, RectF var2, Paint var3, float var4, float var5, int var6, int var7);

    public void b(int var1);

    public void a(int var1, PorterDuff.Mode var2);

    public void a(String var1, float var2, float var3, Paint var4, Paint var5, float var6) throws IOException;

    public void a(String var1, float var2, float var3, Paint var4) throws IOException;

    public void b(Rect var1, Paint var2) throws IOException;

    public void a(RectF var1, Paint var2) throws IOException;

    public void g();

    public void h();

    public void c(Rect var1, Paint var2) throws IOException;

    public void a(Rect var1);

    public void a(RectF var1);

    public void a(float var1, float var2, float var3, Paint var4) throws IOException;

    public void b(float var1, float var2, float var3, Paint var4) throws IOException;

    public void a(float[] var1, int var2, int var3, Paint var4) throws IOException;

    public void i();

    public void j();

    public void k();

    public void l();

    public void a(float var1, float var2, float var3);

    public void a(float var1, float var2);

    public void a(float var1, float var2, float var3, float var4);

    public void b(float var1, float var2);

    public void a(m var1);

    public void a(float var1, float var2, float var3, float var4, Paint var5) throws IOException;

    public int m();

    public int n();

    public void a(int var1, int var2);

    public void o();

    public void a(Paint var1);

    public void p();

    public void q();

    public int a(String var1, Paint var2) throws IOException;

    public int b(String var1, Paint var2) throws IOException;

    public Texture_M r();

    public void a(Texture_M var1, File var2);

    public void a(Lock var1);

    public void b(Lock var1);

    public void a(ShaderProgram var1);

    public float s();
}

