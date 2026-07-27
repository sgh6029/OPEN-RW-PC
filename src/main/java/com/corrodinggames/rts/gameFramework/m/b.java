/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.khronos.opengles.GL10
 */
package com.corrodinggames.rts.gameFramework.m;

import com.corrodinggames.rts.gameFramework.m.AndroidGLRenderer;
import com.corrodinggames.rts.gameFramework.m.ac;
import com.corrodinggames.rts.gameFramework.m.d;

import android.graphics.Rect;
import android.graphics.RectF;

import com.corrodinggames.rts.gameFramework.m.Texture_M;
import javax.microedition.khronos.opengles.GL10;

public class b {
    d a;
    Texture_M b;
    float c;
    float d;
    Rect e;
    RectF f;
    final /* synthetic */ AndroidGLRenderer g = new AndroidGLRenderer();//TODO: 原先未初始化

    void a(GL10 gL10) {
        ac ac2;
        if (this.g.i != this.b.h) {
            gL10.glBindTexture(3553, this.b.h.intValue());
            this.g.i = this.b.h;
        }
        gL10.glPushMatrix();
        gL10.glLoadIdentity();
        if (this.a == com.corrodinggames.rts.gameFramework.m.d.b) {
            gL10.glTranslatef(this.f.left, this.g.c - this.f.b - (float)this.e.c(), 0.0f);
            ac2 = this.g.h;
            float f2 = (float)this.e.left / (float)this.b.m();
            float f3 = (float)this.e.c / (float)this.b.m();
            float f4 = (float)this.e.top / (float)this.b.l();
            float f5 = (float)this.e.d / (float)this.b.l();
            if (this.g.j == this.e.c() && this.g.k == this.e.b()) {
                ac2.a(0, 0, f2, f5);
                ac2.a(1, 0, f3, f5);
                ac2.a(0, 1, f2, f4);
                ac2.a(1, 1, f3, f4);
            } else {
                this.g.j = this.e.c();
                this.g.k = this.e.b();
                ac2.a(0, 0, 0.0f, 0.0f, 0.0f, f2, f5, null);
                ac2.a(1, 0, this.e.b(), 0.0f, 0.0f, f3, f5, null);
                ac2.a(0, 1, 0.0f, this.e.c(), 0.0f, f2, f4, null);
                ac2.a(1, 1, this.e.b(), this.e.c(), 0.0f, f3, f4, null);
            }
        } else {
            gL10.glTranslatef(this.c, this.g.c - this.d - (float)this.b.l(), 0.0f);
            throw new RuntimeException("Not supported");
        }
        ac2.b(gL10, true, false);
        gL10.glPopMatrix();
    }
}

