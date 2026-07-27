/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.effect;


import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ShaderProgram;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.Rect;
import android.graphics.RectF;

import com.corrodinggames.rts.gameFramework.GGameObject;
import com.corrodinggames.rts.gameFramework.effect.d;
import com.corrodinggames.rts.gameFramework.effect.e;
import com.corrodinggames.rts.gameFramework.effect.g;
import com.corrodinggames.rts.gameFramework.effect.h;

public final class c {
    public int a = 0;
    public int b = 80;
    public int c = 100;
    public int d = 110;
    public int e = 120;
    public static e[] f = new e[0];
    public static int g = 0;
    public static boolean h;
    public int i;
    public int j;
    private boolean[] y = new boolean[5];
    public static ShaderProgram k;
    public com.corrodinggames.rts.gameFramework.m.Texture_M l;
    public com.corrodinggames.rts.gameFramework.m.Texture_M m;
    public static final RectF n;
    public static final Rect o;
    public static final Rect p;
    public static final Paint q;
    public static final Paint r;
    public static g[] s;
    h t = null;
    boolean u = false;
    boolean v = false;
    public final Paint w = new Paint();
    float x = 0.0f;

    public e a(h h2) {
        GameEngine l2 = GameEngine.getInstance();
        int n2 = 0;
        int n3 = l2.getScreenHeight();
        if (n3 < 13) {
            n2 = -this.j;
        } else if (n3 < 28) {
            n2 = -this.i;
        }
        int n4 = this.a;
        if (h2 == com.corrodinggames.rts.gameFramework.effect.h.verylow && n4 > this.b + n2) {
            return null;
        }
        if (h2 == com.corrodinggames.rts.gameFramework.effect.h.low && n4 > this.c + n2) {
            return null;
        }
        if (h2 == com.corrodinggames.rts.gameFramework.effect.h.high && n4 > this.d + n2) {
            return null;
        }
        if (h2 == com.corrodinggames.rts.gameFramework.effect.h.veryhigh && n4 > this.e + n2) {
            return null;
        }
        e e2 = null;
        e2 = this.a(true, null);
        if (e2 == null && (h2 == com.corrodinggames.rts.gameFramework.effect.h.critical || h2 == com.corrodinggames.rts.gameFramework.effect.h.veryhigh)) {
            e2 = this.a(false, com.corrodinggames.rts.gameFramework.effect.h.high);
        }
        if (e2 != null) {
            if (!e2.o) {
                e2.o = true;
                ++this.a;
            }
            return e2;
        }
        return null;
    }

    private e a(boolean bl2, h h2) {
        e[] eArray = f;
        int n2 = eArray.length;
        if (bl2 && h2 == null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                e e2 = eArray[i2];
                if (e2.o) continue;
                if (g == i2) {
                    ++g;
                }
                return e2;
            }
            return null;
        }
        for (int i3 = 0; i3 < n2; ++i3) {
            e e3 = eArray[i3];
            if (bl2 && e3.o || h2 != null && !e3.q.a(h2)) continue;
            return e3;
        }
        return null;
    }

    public void a(float f2, float f3, float f4) {
        this.a(f2, f3, f4, 0.0f, 20.0f);
    }

    public void a(float f2, float f3, float f4, float f5, float f6) {
        for (int i2 = 0; i2 < 7; ++i2) {
            e e2 = this.b(f2 + com.corrodinggames.rts.gameFramework.GameUtils.c(-20.0f, 20.0f), f3 + com.corrodinggames.rts.gameFramework.GameUtils.c(-20.0f, 20.0f), f4);
            if (e2 == null) continue;
            e2.U = f5 + com.corrodinggames.rts.gameFramework.GameUtils.c(0.0f, f6);
            e2.aj = com.corrodinggames.rts.gameFramework.GameUtils.c(0.3f, 0.6f);
        }
    }

    public float a(float f2, float f3) {
        return com.corrodinggames.rts.gameFramework.GameUtils.c(f2, f3);
    }

    public e b(float f2, float f3, float f4) {
        this.a();
        e e2 = this.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.high);
        if (e2 != null) {
            float f5;
            e2.aq = 1;
            e2.ae = true;
            e2.ak = 0.0f;
            e2.aj = 0.5f;
            e2.ag = 12;
            e2.ap = 0;
            e2.V = 35.0f;
            e2.W = e2.V - 10.0f;
            e2.r = true;
            e2.E = 0.7f;
            e2.Y = this.a(-180.0f, 180.0f);
            e2.G = f5 = this.a(0.8f, 1.0f);
            e2.F = f5;
        }
        return e2;
    }

    public e c(float f2, float f3, float f4) {
        this.a();
        e e2 = this.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.high);
        if (e2 != null) {
            e2.aq = 13;
            e2.ae = true;
            e2.ak = 3.0f;
            e2.aj = 0.5f;
            e2.ag = 7;
            e2.ap = 0;
            e2.V = 35.0f;
            e2.W = e2.V - 10.0f;
            e2.r = true;
            e2.E = 1.0f;
            e2.G = 0.5f;
            e2.F = 0.5f;
        }
        return e2;
    }

    public e a(float f2, float f3, float f4, float f5, float f6, float f7) {
        GameEngine l2 = GameEngine.getInstance();
        if (!l2.bL.a(f2, f3, l2.bs) && !l2.bL.a(f5, f6, l2.bs)) {
            return null;
        }
        e e2 = this.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, true, com.corrodinggames.rts.gameFramework.effect.h.high);
        if (e2 != null) {
            e2.an = false;
            e2.W = e2.V = 5.0f;
            e2.r = true;
            e2.E = 1.0f;
            e2.L = true;
            e2.M = f5;
            e2.N = f6;
            e2.O = f7;
        }
        return e2;
    }

    public e a(float f2, float f3, float f4, float f5) {
        return this.a(f2, f3, f4, f5, 0);
    }

    public e a(float f2, float f3, float f4, float f5, int n2) {
        return this.a(f2, f3, f4, f5, n2, 0);
    }

    public e b(float f2, float f3, float f4, float f5, int n2) {
        return this.a(f2, f3, f4, f5, n2, 1);
    }

    public e a(float f2, float f3, float f4, float f5, int n2, int n3) {
        this.a();
        e e2 = this.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.high);
        if (e2 != null) {
            e2.g = com.corrodinggames.rts.gameFramework.effect.e.j;
            e2.ae = true;
            if (n3 == 1) {
                e2.aq = 3;
                e2.ak = 1.0f;
                e2.aj = 0.4f;
                e2.ag = 4;
            } else {
                e2.aq = 3;
                e2.ak = 0.0f;
                e2.aj = 0.5f;
                e2.ag = 3;
            }
            e2.Y = f5;
            e2.ap = 0;
            e2.W = e2.V = 20.0f;
            e2.r = false;
            if (n2 != 0) {
                e2.B = new LightingColorFilter(n2, 0);
            }
        }
        return e2;
    }

    public e c(float f2, float f3, float f4, float f5, int n2) {
        e e2 = this.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.verylow);
        if (e2 != null) {
            e2.aq = 4;
            e2.g = com.corrodinggames.rts.gameFramework.effect.e.i;
            e2.ap = com.corrodinggames.rts.gameFramework.GameUtils.a(0, 2);
            e2.Y = f5;
            e2.an = true;
            e2.P = com.corrodinggames.rts.gameFramework.GameUtils.k(f5) * 0.15f;
            e2.Q = com.corrodinggames.rts.gameFramework.GameUtils.j(f5) * 0.15f;
            e2.W = e2.V = 30.0f;
            e2.r = true;
            e2.ar = 1;
            e2.G = 0.8f;
            e2.F = 2.3f;
            if (n2 != 0) {
                e2.B = new LightingColorFilter(n2, 0);
            }
        }
        return e2;
    }

    public static void a(e e2, GGameObject w2) {
        if (e2 == null) {
            return;
        }
        e2.b = w2;
        e2.I -= w2.posX;
        e2.J -= w2.posY;
        e2.K -= w2.posZ;
    }

    public e a(GGameObject w2, int n2) {
        return this.a(w2, n2, 0.5f);
    }

    public e a(GGameObject w2, int n2, float f2) {
        this.b();
        e e2 = this.b(w2.posX, w2.posY, w2.posZ, n2);
        if (e2 != null) {
            e2.I = 0.0f;
            e2.J = 0.0f;
            e2.K = 0.0f;
            e2.W = e2.V = 400.0f;
            e2.E = 0.3f;
            e2.G = f2;
            e2.b = w2;
        }
        return e2;
    }

    public e a(float f2, float f3, float f4, int n2) {
        if (this.t == null && !this.v) {
            this.a();
        }
        return this.b(f2, f3, f4, n2);
    }

    public e b(float f2, float f3, float f4, int n2) {
        e e2 = this.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, true, com.corrodinggames.rts.gameFramework.effect.h.low);
        if (e2 != null) {
            e2.e = false;
            e2.g = com.corrodinggames.rts.gameFramework.effect.e.h;
            e2.aq = 2;
            e2.W = e2.V = 10.0f;
            e2.r = true;
            e2.E = 0.5f;
            e2.ar = (short)2;
            e2.d = true;
            if (n2 != 0) {
                e2.x = n2;
                e2.B = new LightingColorFilter(n2, 0);
            }
        }
        return e2;
    }

    public e b(float f2, float f3, float f4, float f5) {
        this.a();
        e e2 = this.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.low);
        if (e2 != null) {
            e2.g = com.corrodinggames.rts.gameFramework.effect.e.l;
            e2.aq = 0;
            e2.ap = 13;
            e2.ar = 1;
            e2.r = true;
            e2.E = 0.8f;
            e2.V = e2.W = 80.0f;
            e2.Y = com.corrodinggames.rts.gameFramework.GameUtils.c(-180.0f, 180.0f);
            e2.G = com.corrodinggames.rts.gameFramework.GameUtils.c(0.6f, 0.8f);
            e2.F = 1.5f;
            e2.P = com.corrodinggames.rts.gameFramework.GameUtils.k(f5) * 0.13f * com.corrodinggames.rts.gameFramework.GameUtils.c(1.0f, 1.5f) + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.01f, 0.01f);
            e2.Q = com.corrodinggames.rts.gameFramework.GameUtils.j(f5) * 0.13f * com.corrodinggames.rts.gameFramework.GameUtils.c(1.0f, 1.5f) + com.corrodinggames.rts.gameFramework.GameUtils.c(-0.01f, 0.01f);
        }
        return e2;
    }

    public e a(float f2, float f3, float f4, int n2, float f5, float f6) {
        e e2 = this.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.high);
        if (e2 != null) {
            e2.g = com.corrodinggames.rts.gameFramework.effect.e.l;
            e2.aq = 6;
            e2.W = e2.V = 120.0f;
            e2.r = true;
            e2.G = 0.2f;
            e2.F = 0.9f;
            e2.ar = 1;
            e2.E = 0.5f;
            e2.P = f5;
            e2.Q = f6;
            if (n2 != 0) {
                n2 = Color.a(255, 0, 0, 200);
            }
            if (n2 != 0) {
                e2.B = new LightingColorFilter(n2, 0);
            }
        }
        return e2;
    }

    public void a(float f2, float f3, float f4, int n2, float f5, float f6, float f7) {
        this.a(f2, f3, 0.0f, 0, 0.0f, 0.0f);
        for (int i2 = -180; i2 < 180; i2 += 45) {
            float f8;
            float f9 = f7 + (float)i2;
            float f10 = f2 + com.corrodinggames.rts.gameFramework.GameUtils.k(f9) * -5.0f;
            e e2 = this.b(f10, f8 = f3 + com.corrodinggames.rts.gameFramework.GameUtils.j(f9) * -5.0f, 0.0f, f9);
            if (e2 == null) continue;
            e2.ar = (short)2;
            e2.s = true;
            e2.t = 7.0f;
        }
    }

    public e c(float f2, float f3, float f4, int n2) {
        e e2 = this.d(f2, f3, f4, n2);
        if (e2 != null) {
            e2.aq = 11;
        }
        return e2;
    }

    public e d(float f2, float f3, float f4, int n2) {
        this.a();
        e e2 = this.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.high);
        if (e2 != null) {
            e2.aq = 6;
            e2.W = e2.V = 30.0f;
            e2.r = true;
            e2.G = 0.2f;
            e2.F = 1.3f;
            e2.ar = 1;
            if (n2 != 0) {
                e2.B = new LightingColorFilter(n2, 0);
            }
        }
        return e2;
    }

    public e d(float f2, float f3, float f4) {
        e e2 = this.b(f2, f3, f4, 0.3f, 0.7f);
        if (e2 != null) {
            e2.aq = 14;
            e2.ap = com.corrodinggames.rts.gameFramework.GameUtils.a(0, 5);
            e2.w = 0.5f;
        }
        return e2;
    }

    public e e(float f2, float f3, float f4) {
        e e2 = this.b(f2, f3, f4, 1.0f, 1.0f);
        if (e2 != null) {
            // empty if block
        }
        return e2;
    }

    public e b(float f2, float f3, float f4, float f5, float f6) {
        this.b();
        e e2 = this.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.high);
        if (e2 != null) {
            float f7;
            e2.g = com.corrodinggames.rts.gameFramework.effect.e.m;
            e2.aq = 12;
            e2.ap = com.corrodinggames.rts.gameFramework.GameUtils.a(0, 7);
            e2.V = com.corrodinggames.rts.gameFramework.GameUtils.c(400.0f, 800.0f);
            e2.W = e2.V - 150.0f;
            e2.r = true;
            e2.G = f7 = com.corrodinggames.rts.gameFramework.GameUtils.c(0.6f, 1.0f);
            e2.F = f7;
            e2.ar = (short)2;
            e2.v = true;
            e2.as = true;
            float f8 = com.corrodinggames.rts.gameFramework.GameUtils.c(-180.0f, 180.0f);
            float f9 = com.corrodinggames.rts.gameFramework.GameUtils.c(0.4f, 1.2f) * f5;
            e2.P = com.corrodinggames.rts.gameFramework.GameUtils.k(f8) * f9;
            e2.Q = com.corrodinggames.rts.gameFramework.GameUtils.j(f8) * f9;
            e2.R = com.corrodinggames.rts.gameFramework.GameUtils.c(0.6f, 2.7f) * f6;
            e2.Y = com.corrodinggames.rts.gameFramework.GameUtils.c(-180.0f, 180.0f);
            e2.K += 1.0f;
        }
        return e2;
    }

    public e f(float f2, float f3, float f4) {
        e e2 = this.b(f2, f3, f4, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.low);
        if (e2 != null) {
            e2.aq = 8;
            e2.W = e2.V = 480.0f;
            e2.r = false;
            e2.ar = 1;
            e2.ae = true;
            e2.ak = 0.0f;
            e2.G = 0.5f;
            e2.G = 1.0f;
            int n2 = com.corrodinggames.rts.gameFramework.GameUtils.a(0, 100);
            if (n2 > 80) {
                e2.aj = com.corrodinggames.rts.gameFramework.GameUtils.c(0.1f, 0.15f);
                e2.ag = 15;
            } else if (n2 > 60) {
                e2.aj = com.corrodinggames.rts.gameFramework.GameUtils.c(0.06f, 0.16f);
                e2.ah = true;
                e2.ag = 6;
                e2.r = true;
            } else {
                e2.aj = com.corrodinggames.rts.gameFramework.GameUtils.c(0.06f, 0.16f);
                e2.ah = true;
                e2.ag = 3;
                e2.r = true;
            }
        }
        return e2;
    }

    public void b(h h2) {
        this.t = h2;
    }

    public void a() {
        this.u = true;
    }

    public void b() {
        this.v = true;
    }

    public e a(float f2, float f3, float f4, d d2, boolean bl2, h h2) {
        e e2 = this.b(f2, f3, f4, d2, bl2, h2);
        if (e2 != null) {
            e2.p = true;
        }
        return e2;
    }

    public e b(float f2, float f3, float f4, d d2, boolean bl2, h h2) {
        GameEngine l2 = GameEngine.getInstance();
        if (this.t != null) {
            h2 = this.t;
            this.t = null;
        }
        boolean bl3 = this.v;
        this.v = false;
        if (this.u) {
            this.u = false;
            if (!l2.cP.b(f2, f3)) {
                return null;
            }
        }
        if (!bl2 && l2.bL != null && !l2.bL.a(f2, f3, l2.bs)) {
            return null;
        }
        if (l2.cO.b(f2, f3)) {
            if (h2 == com.corrodinggames.rts.gameFramework.effect.h.verylow) {
                h2 = com.corrodinggames.rts.gameFramework.effect.h.low;
            } else if (h2 == com.corrodinggames.rts.gameFramework.effect.h.low) {
                h2 = com.corrodinggames.rts.gameFramework.effect.h.high;
            } else if (h2 == com.corrodinggames.rts.gameFramework.effect.h.high) {
                h2 = com.corrodinggames.rts.gameFramework.effect.h.veryhigh;
            }
        } else if (bl3 || !l2.cP.b(f2, f3)) {
            // empty if block
        }
        e e2 = this.a(h2);
        if (e2 == null) {
            return null;
        }
        e2.c();
        e2.q = h2;
        e2.aq = 0;
        e2.an = true;
        e2.I = f2;
        e2.J = f3;
        e2.K = f4;
        e2.E = 1.0f;
        if (d2 == com.corrodinggames.rts.gameFramework.effect.d.hitGround || d2 == com.corrodinggames.rts.gameFramework.effect.d.playerLand || d2 == com.corrodinggames.rts.gameFramework.effect.d.playerJump) {
            e2.ap = 7;
            e2.V = 12.0f;
            e2.r = true;
            e2.Q = -0.3f;
            e2.E = 0.7f;
            if (d2 == com.corrodinggames.rts.gameFramework.effect.d.playerJump) {
                e2.ap = 3;
                e2.Q = -0.7f;
                e2.V = 24.0f;
                e2.E = 0.7f;
            }
            if (d2 == com.corrodinggames.rts.gameFramework.effect.d.playerLand) {
                e2.ap = 4;
                e2.V = 15.0f;
                e2.E = 0.4f;
            }
        }
        if (d2 == com.corrodinggames.rts.gameFramework.effect.d.teleport) {
            e2.ap = 1;
            e2.V = 25.0f;
            e2.r = true;
        }
        if (d2 == com.corrodinggames.rts.gameFramework.effect.d.gemCollect) {
            e2.ap = 5;
            e2.V = 42.0f;
            e2.r = true;
            e2.Q = 0.1f;
            e2.E = 2.0f;
        }
        if (d2 == com.corrodinggames.rts.gameFramework.effect.d.keyDoorOpen) {
            e2.ap = 6;
            e2.V = 39.0f;
            e2.r = true;
            e2.Q = 0.1f;
            e2.E = 2.0f;
        }
        if (d2 == com.corrodinggames.rts.gameFramework.effect.d.blood) {
            e2.ap = 14;
            e2.V = 39.0f;
            e2.r = true;
            e2.Q = 0.1f;
            e2.E = 0.7f;
        }
        e2.W = e2.V;
        return e2;
    }

    public void a(Context context) {
        int n2;
        GameEngine l2 = GameEngine.getInstance();
        this.w.a(130, 200, 0, 0);
        this.w.a(true);
        this.w.a(2.0f);
        this.w.a(Paint$Cap.b);
        if (com.corrodinggames.rts.gameFramework.GameEngine.isAndroidVersionStatic2) {
            this.w.a(3.0f);
        }
        s = new g[20];
        g g2 = new g();
        g2.b = 25;
        g2.c = 25;
        g2.d = 1;
        g2.e = 1;
        g2.f = 26;
        g2.g = 26;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.effects, true);
        g2.a = "effects";
        g2.a();
        com.corrodinggames.rts.gameFramework.effect.c.s[0] = g2;
        g2 = new g();
        g2.b = 39;
        g2.c = 40;
        g2.d = 1;
        g2.e = 1;
        g2.f = 40;
        g2.g = 41;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.explode_big, true);
        g2.a = "explode_big";
        com.corrodinggames.rts.gameFramework.effect.c.s[1] = g2;
        g2 = new g();
        g2.k = true;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.light_50, true);
        g2.a = "light_50";
        com.corrodinggames.rts.gameFramework.effect.c.s[2] = g2;
        g2 = new g();
        g2.b = 20;
        g2.c = 25;
        g2.d = 0;
        g2.e = 0;
        g2.f = 20;
        g2.g = 25;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.flame, true);
        g2.a = "flame";
        com.corrodinggames.rts.gameFramework.effect.c.s[3] = g2;
        g2 = new g();
        g2.b = 20;
        g2.c = 25;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.dust, true);
        g2.a = "dust";
        com.corrodinggames.rts.gameFramework.effect.c.s[4] = g2;
        g2 = new g();
        g2.b = 50;
        g2.c = 40;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.smoke_black, true);
        g2.a = "smoke_black";
        g2.a();
        com.corrodinggames.rts.gameFramework.effect.c.s[5] = g2;
        g2 = new g();
        g2.b = 50;
        g2.c = 50;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.shockwave, true);
        g2.a = "shockwave";
        com.corrodinggames.rts.gameFramework.effect.c.s[6] = g2;
        g2 = new g();
        g2.b = 20;
        g2.c = 20;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.fire, true);
        g2.a = "fire";
        com.corrodinggames.rts.gameFramework.effect.c.s[7] = g2;
        g2 = new g();
        g2.b = 20;
        g2.c = 30;
        g2.f = g2.b + 2;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.lava_bubble, true);
        g2.a = "lava_bubble";
        com.corrodinggames.rts.gameFramework.effect.c.s[8] = g2;
        g2 = new g();
        g2.b = 28;
        g2.c = 28;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b + 1;
        g2.g = g2.c + 1;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.effects2, true);
        g2.a = "effects2";
        com.corrodinggames.rts.gameFramework.effect.c.s[9] = g2;
        g2 = new g();
        g2.b = 20;
        g2.c = 25;
        g2.d = 0;
        g2.e = 0;
        g2.f = 20;
        g2.g = 25;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.plasma_shot, true);
        g2.a = "plasma_shot";
        com.corrodinggames.rts.gameFramework.effect.c.s[10] = g2;
        g2 = new g();
        g2.b = 104;
        g2.c = 104;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.shockwave_large, true);
        g2.a = "shockwave_large";
        com.corrodinggames.rts.gameFramework.effect.c.s[11] = g2;
        g2 = new g();
        g2.b = 20;
        g2.c = 20;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.explode_bits, true);
        g2.a = "explode_bits";
        g2.a();
        com.corrodinggames.rts.gameFramework.effect.c.s[12] = g2;
        g2 = new g();
        g2.b = 39;
        g2.c = 40;
        g2.d = 1;
        g2.e = 1;
        g2.f = 40;
        g2.g = 41;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.explode_big2, true);
        g2.a = "explode_big2";
        com.corrodinggames.rts.gameFramework.effect.c.s[13] = g2;
        g2 = new g();
        g2.b = 20;
        g2.c = 20;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.explode_bits_bug, true);
        g2.a = "explode_bits_bug";
        g2.a();
        com.corrodinggames.rts.gameFramework.effect.c.s[14] = g2;
        g2 = new g();
        g2.b = 20;
        g2.c = 20;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.projectiles, true);
        g2.a = "projectiles";
        g2.a();
        com.corrodinggames.rts.gameFramework.effect.c.s[15] = g2;
        g2 = new g();
        g2.b = 20;
        g2.c = 20;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.projectiles2, true);
        g2.a = "projectiles2";
        g2.a();
        com.corrodinggames.rts.gameFramework.effect.c.s[16] = g2;
        g2 = new g();
        g2.b = 30;
        g2.c = 30;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b + 1;
        g2.g = g2.c + 1;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.effects3, true);
        g2.a = "effects3";
        com.corrodinggames.rts.gameFramework.effect.c.s[17] = g2;
        g2 = new g();
        g2.b = 50;
        g2.c = 40;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.smoke_white, true);
        g2.a = "smoke_white";
        g2.a();
        com.corrodinggames.rts.gameFramework.effect.c.s[18] = g2;
        g2 = new g();
        g2.b = 56;
        g2.c = 56;
        g2.d = 0;
        g2.e = 0;
        g2.f = g2.b;
        g2.g = g2.c;
        g2.i = l2.bO.a(com.corrodinggames.rts.R.drawable.shockwave2, true);
        g2.a = "shockwave2";
        g2.a();
        com.corrodinggames.rts.gameFramework.effect.c.s[19] = g2;
        if (com.corrodinggames.rts.gameFramework.GameEngine.av()) {
            n2 = 500;
            this.i = 90;
            this.j = 210;
        } else {
            n2 = 350;
            this.i = 90;
            this.j = 170;
        }
        f = new e[n2];
        this.b = n2 - 60;
        this.c = n2 - 30;
        this.d = n2 - 20;
        this.e = n2 - 10;
        for (int i2 = 0; i2 < f.length; ++i2) {
            com.corrodinggames.rts.gameFramework.effect.c.f[i2] = new e(this);
        }
    }

    public int a(String string2) {
        for (int i2 = 0; i2 < s.length; ++i2) {
            if (s[i2] == null) continue;
            if (com.corrodinggames.rts.gameFramework.effect.c.s[i2].a != null && com.corrodinggames.rts.gameFramework.effect.c.s[i2].a.equalsIgnoreCase(string2)) {
                return i2;
            }
            if (!("" + i2).equals(string2)) continue;
            return i2;
        }
        return -1;
    }

    public void a(float f2) {
        int n2;
        GameEngine l2 = GameEngine.getInstance();
        e[] eArray = f;
        for (n2 = 0; n2 < g; ++n2) {
            e e2 = eArray[n2];
            if (!e2.o || e2.p) continue;
            e2.b(f2);
        }
        if (h) {
            while (g > 0) {
                e e3 = eArray[g - 1];
                if (e3.o) break;
                --g;
            }
        }
        this.x += f2;
        if (this.x > 10.0f) {
            this.x = 0.0f;
            n2 = l2.cu + com.corrodinggames.rts.gameFramework.GameUtils.a(0, (int)l2.screenHeight);
            int n3 = l2.cv + com.corrodinggames.rts.gameFramework.GameUtils.a(0, (int)l2.uiScale);
            l2.bL.a((float)n2, (float)n3);
            int n4 = l2.bL.T;
            int n5 = l2.bL.U;
            com.corrodinggames.rts.game.b.MapTile g2 = l2.bL.d(n4, n5);
            if (g2 != null && g2.g && !g2.h) {
                l2.bL.a(n4, n5);
                this.f(l2.bL.T + 10, l2.bL.U - 10 + 10, 0.0f);
            }
        }
    }

    public int b(float f2) {
        int n2;
        GameEngine l2 = GameEngine.getInstance();
        int n3 = 0;
        for (n2 = 0; n2 < this.y.length; ++n2) {
            this.y[n2] = false;
        }
        for (n2 = 0; n2 < g; ++n2) {
            boolean bl2;
            e e2 = f[n2];
            if (!e2.o) continue;
            if (!this.y[e2.ar]) {
                this.y[e2.ar] = true;
            }
            if (e2.p) {
                e2.b(f2);
            }
            if (!e2.as || !(bl2 = e2.a(l2, true))) continue;
            ++n3;
        }
        return n3;
    }

    public int a(float f2, int n2) {
        if (!this.y[n2]) {
            return 0;
        }
        GameEngine l2 = GameEngine.getInstance();
        int n3 = 0;
        e[] eArray = f;
        for (int i2 = 0; i2 < g; ++i2) {
            boolean bl2;
            e e2 = eArray[i2];
            if (!e2.o || e2.ar != n2 || !(bl2 = e2.a(l2, false))) continue;
            ++n3;
        }
        return n3;
    }

    public void a(boolean bl2) {
        if (bl2) {
            return;
        }
        for (int i2 = 0; i2 < f.length; ++i2) {
            e e2 = f[i2];
            if (!e2.o) continue;
            e2.o = false;
            --this.a;
        }
        if (this.a != 0) {
            com.corrodinggames.rts.gameFramework.GameEngine.a("EffectEngine::removeAll: effectListActiveSize == " + this.a);
        }
        g = 0;
    }

    static {
        n = new RectF();
        o = new Rect();
        p = new Rect();
        q = new Paint();
        r = new Paint();
    }
}
