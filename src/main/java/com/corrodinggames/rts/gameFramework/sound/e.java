/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.sound;


import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.AssetType;
import com.corrodinggames.rts.gameFramework.sound.a;
import com.corrodinggames.rts.gameFramework.sound.h;
import com.corrodinggames.rts.gameFramework.sound.i;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;

import android.content.Context;

import java.util.ArrayList;

public class e {
    ArrayList a = new ArrayList();
    public boolean b;
    public static h c = new a();
    public static i d;
    public static i e;
    public static i f;
    public static i g;
    public static i h;
    public static i i;
    public static i j;
    public static i k;
    public static i l;
    public static i m;
    public static i n;
    public static i o;
    public static i p;
    public static i q;
    public static i r;
    public static i s;
    public static i t;
    public static i u;
    public static i v;
    public static i w;
    public static i x;
    public static i y;
    public static i z;
    public static i A;
    public static i B;
    public static i C;
    public static i D;
    public static i E;
    public static i F;

    public boolean a(i i2, float f2) {
        if (this.a.contains(i2)) {
            return false;
        }
        this.a.add(i2);
        return true;
    }

    public boolean a() {
        GameEngine l2 = GameEngine.getInstance();
        return this.a(l2.bQ.masterVolume * l2.bQ.gameVolume);
    }

    public boolean a(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        if (f2 < 0.01f) {
            return false;
        }
        if (this.b) {
            return false;
        }
        return l2.bQ.enableSounds;
    }

    public static void b() {
    }

    public void a(Context context) {
        c.a(context);
        e = c.a(com.corrodinggames.rts.R.raw.attack);
        com.corrodinggames.rts.gameFramework.sound.e.e.d = 0.2f;
        d = c.a(com.corrodinggames.rts.R.raw.attack2);
        f = c.a(com.corrodinggames.rts.R.raw.move);
        g = c.a(com.corrodinggames.rts.R.raw.click);
        h = c.a(com.corrodinggames.rts.R.raw.click_add);
        i = c.a(com.corrodinggames.rts.R.raw.click_remove);
        j = c.a(com.corrodinggames.rts.R.raw.warning);
        k = c.a(com.corrodinggames.rts.R.raw.message);
        m = c.a(com.corrodinggames.rts.R.raw.missile_fire);
        n = c.a(com.corrodinggames.rts.R.raw.missile_hit);
        o = c.a(com.corrodinggames.rts.R.raw.unit_explode);
        p = c.a(com.corrodinggames.rts.R.raw.buiding_explode);
        q = c.a(com.corrodinggames.rts.R.raw.tank_firing);
        r = c.a(com.corrodinggames.rts.R.raw.cannon_firing);
        s = c.a(com.corrodinggames.rts.R.raw.gun_fire);
        x = c.a(com.corrodinggames.rts.R.raw.lighting_burst);
        y = c.a(com.corrodinggames.rts.R.raw.plasma_fire);
        z = c.a(com.corrodinggames.rts.R.raw.plasma_fire2);
        t = c.a(com.corrodinggames.rts.R.raw.firing3);
        u = c.a(com.corrodinggames.rts.R.raw.firing4);
        v = c.a(com.corrodinggames.rts.R.raw.large_gun_fire1);
        w = c.a(com.corrodinggames.rts.R.raw.large_gun_fire2);
        A = c.a(com.corrodinggames.rts.R.raw.bug_die);
        B = c.a(com.corrodinggames.rts.R.raw.bug_attack);
        l = c.a(com.corrodinggames.rts.R.raw.interface_error);
        C = c.a(com.corrodinggames.rts.R.raw.nuke_explode);
        D = c.a(com.corrodinggames.rts.R.raw.nuke_launch);
        E = c.a(com.corrodinggames.rts.R.raw.laser_deflect);
        F = c.a(com.corrodinggames.rts.R.raw.laser_deflect2);
        c.a();
    }

    public i a(String string2) {
        i i2 = (i)com.corrodinggames.rts.gameFramework.sound.e.c.h.get(string2);
        if (i2 == null) {
            throw new RuntimeException("Could not find sound:" + string2);
        }
        return i2;
    }

    public void b(i i2, float f2) {
        GameEngine l2 = GameEngine.getInstance();
        f2 *= l2.bQ.masterVolume * l2.bQ.interfaceVolume;
        if (!this.a(f2 *= i2.d)) {
            return;
        }
        if ((double)f2 < 0.01) {
            return;
        }
        if (!this.a(i2, f2)) {
            return;
        }
        if (l2.gameStarted) {
            f2 /= 20.0f;
        }
        i2.a(f2, f2, 1, 0, 1.0f);
    }

    public void c(i i2, float f2) {
        GameEngine l2 = GameEngine.getInstance();
        f2 *= l2.bQ.masterVolume * l2.bQ.gameVolume;
        if (!this.a(f2 *= i2.d)) {
            return;
        }
        if (l2.gameStarted) {
            f2 /= 20.0f;
        }
        if (!this.a(i2, f2)) {
            return;
        }
        i2.a(f2, f2, 1, 0, 1.0f);
    }

    public void a(i i2, float f2, float f3, float f4) {
        this.a(i2, f2, 1.0f, f3, f4);
    }

    public void a(i i2, float f2, float f3, float f4, float f5) {
        float f6;
        if (!this.a()) {
            return;
        }
        GameEngine l2 = GameEngine.getInstance();
        if (l2.gameStarted) {
            f2 /= 20.0f;
        }
        if (l2.cb.j() && (double)l2.bt > 1.5) {
            f2 /= l2.bt;
        }
        int n2 = (int)(l2.cw + l2.cameraShakeDecay);
        int n3 = (int)(l2.cx + l2.cameraShakeTime);
        float f7 = com.corrodinggames.rts.gameFramework.GameUtils.a((float)n2, (float)n3, f4, f5);
        float f8 = l2.cameraShakeDecay * 1.72f;
        if ((double)l2.cX < 0.5) {
            f2 *= 4.0f;
            f2 *= l2.cX * l2.cX;
        }
        if (f2 <= 1.0f && !i2.f && f7 > f8 * f8) {
            return;
        }
        float f9 = (float)Math.sqrt(f7);
        float f10 = 1.0f;
        if (f9 > l2.cameraShakeDecay) {
            f10 = 1.0f - (f9 - l2.cameraShakeDecay) / l2.cameraShakeDecay;
        }
        if ((double)(f6 = f10 * f2) <= 0.05 && !i2.f) {
            return;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        f6 *= l2.bQ.masterVolume * l2.bQ.gameVolume;
        if (!this.a(i2, f6 *= i2.d)) {
            return;
        }
        i2.a(f6, f6, 1, 0, f3);
    }

    public i a(String string2, AssetInputStream j2, boolean bl2) {
        try {
            return c.a(string2, j2, bl2);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            com.corrodinggames.rts.gameFramework.GameEngine.a(com.corrodinggames.rts.gameFramework.AssetType.gameSound, (Throwable)outOfMemoryError);
            return com.corrodinggames.rts.gameFramework.sound.f.b();
        }
    }

    public i b(String string2) {
        return com.corrodinggames.rts.gameFramework.sound.f.a(string2);
    }

    public void b(float f2) {
        this.a.clear();
    }
}
