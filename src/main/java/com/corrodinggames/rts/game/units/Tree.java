/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

import java.io.IOException;


import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.m.y;

import android.graphics.Rect;

public class Tree
extends v {
    static Texture_M[] a = new Texture_M[3];
    static Texture_M b = null;
    Texture_M c;
    int d;
    int e;
    int f = 0;
    float g;
    boolean h;
    float i;
    int j = 0;
    int k = 0;
    float l = 1.0f;
    boolean m = false;

    public static void b() {
        GameEngine l2 = GameEngine.getInstance();
        Tree.a[0] = l2.bO.a(com.corrodinggames.rts.R.drawable.palm_tree);
        Tree.a[1] = l2.bO.a(com.corrodinggames.rts.R.drawable.trees);
        Tree.a[2] = l2.bO.a(com.corrodinggames.rts.R.drawable.trees_snow);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.palm_leaves);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.d);
        as2.a(this.f);
        as2.a(this.g);
        as2.a(this.h);
        as2.a(this.i);
        as2.c(2);
        as2.a(this.l);
        as2.a(this.e);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.d = k2.readInt();
        this.f = k2.readInt();
        this.g = k2.g();
        this.h = k2.e();
        this.i = k2.g();
        byte by = k2.d();
        this.l = by >= 1 ? k2.g() : 1.0f;
        this.e = by >= 2 ? k2.readInt() : 0;
        this.b(this.d, this.e);
        try {
            super.a(k2);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        if (this.bV) {
            this.m = false;
        }
    }

    public Texture_M d() {
        return this.c;
    }

    @Override
    public boolean e() {
        this.k();
        return true;
    }

    public Tree(boolean bl2) {
        super(bl2);
        this.b(1, -1);
        this.cj = 3.0f;
        this.ck = this.cj + 1.0f;
        this.cu = this.cv = 100.0f;
        this.cg = -90.0f;
        this.S(3);
    }

    @Override
    public void a_(String string2) {
        int n2;
        int n3 = -1;
        String[] stringArray = string2.split("\\.");
        if (stringArray.length != 0 && stringArray.length != 1) {
            if (stringArray.length == 2) {
                string2 = stringArray[0];
                try {
                    n3 = Integer.parseInt(stringArray[1]);
                }
                catch (NumberFormatException numberFormatException) {
                    throw new RuntimeException("Tree sub type format error:" + stringArray[1]);
                }
            } else {
                throw new RuntimeException("Tree sub unknown format with parts:" + stringArray.length);
            }
        }
        try {
            n2 = Integer.parseInt(string2);
        }
        catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("Tree type format error:" + string2);
        }
        this.b(n2, n3);
    }

    public void b(int n2, int n3) {
        this.d = n2;
        this.e = n3;
        if (this.d == 0) {
            this.T(27);
            this.U(41);
            this.j = 1;
            this.k = 1;
            this.c = a[0];
        } else if (this.d == 1 || this.d == 2) {
            if (n3 == -1) {
                n3 = GameUtils.a(0, 4, (int)this.objectId);
            }
            if (n3 < 0 || n3 > 4) {
                throw new RuntimeException("Tree subType out of range:" + n3);
            }
            this.T(25);
            this.U(30);
            this.c = this.d == 1 ? a[1] : a[2];
            this.j = 0;
            this.k = 30 * n3;
            this.l = n3 == 0 ? GameUtils.a(1.0f, 1.2f, (int)this.objectId + 1) : GameUtils.a(1.0f, 2.0f, (int)this.objectId + 1);
            this.m = true;
        } else {
            throw new RuntimeException("Tree type:" + this.d + " is not supported");
        }
    }

    @Override
    public void a(float f2) {
        if (this.d == 0) {
            if (this.h) {
                if (this.f < 4) {
                    this.g += f2;
                    if (this.g > 5.0f) {
                        this.g = 0.0f;
                        ++this.f;
                    }
                }
            } else if (this.i != 0.0f) {
                this.i = GameUtils.a(this.i, 0.1f * f2);
                this.f = 2;
            } else if (this.f > 1) {
                this.f = 1;
            }
        }
    }

    @Override
    public Rect a_(boolean bl2) {
        int n2 = this.j;
        int n3 = this.k;
        dC.a(n2 += this.f * (this.es + 1), n3, n2 + this.es, n3 + this.et);
        return dC;
    }

    @Override
    public boolean c(float f2) throws IOException {
        Texture_M e2 = this.d();
        GameEngine l2 = GameEngine.getInstance();
        if ((double)l2.cX < 0.15) {
            return false;
        }
        du.a(this.cF());
        du.a(0.0f, (int)(-this.posZ));
        float f3 = du.d();
        float f4 = du.e();
        dv.a(this.a_(false));
        y y2 = l2.bO;
        y2.k();
        if (this.l != 1.0f) {
            y2.a(this.l, this.l, f3, f4);
        }
        if (this.m) {
            dv.a(this.es, 0);
            l2.bO.a(e2, dv, du, null);
            dv.a(-this.es, 0);
        }
        y2.a(this.d(false), f3, f4);
        y2.a(e2, dv, du, null);
        y2.l();
        return true;
    }

    @Override
    public UnitMovementType h() {
        return UnitMovementType.NONE;
    }

    @Override
    public boolean i() {
        return false;
    }

    @Override
    public boolean Q() {
        return false;
    }

    @Override
    public boolean aj() {
        return false;
    }

    @Override
    public boolean ak() {
        return false;
    }

    @Override
    public boolean s_() {
        return true;
    }

    @Override
    public boolean c_() {
        return false;
    }

    public UnitTypeEnum f() {
        return UnitTypeEnum.tree;
    }

    @Override
    public boolean a(BaseUnit am2, float f2) {
        if (!this.h) {
            if (this.i == 0.0f) {
                // empty if block
            }
            this.cu -= am2.bN() / 3000.0f * this.cv * 0.06f * f2;
            this.i = 1.0f;
            this.dp = 1000.0f;
            if (this.cu <= 0.0f) {
                float f3;
                this.cg = f3 = GameUtils.d(this.posX, this.posY, am2.posX, am2.posY) + 180.0f;
                this.k();
            }
            if (!this.h) {
                return false;
            }
        }
        return true;
    }

    public void k() {
        if (!this.h) {
            GameEngine l2 = GameEngine.getInstance();
            this.f = 2;
            this.g = 0.0f;
            this.S(0);
            this.bT = false;
            this.bV = true;
            this.bW = l2.by;
            this.h = true;
            this.m = false;
            for (int i2 = 0; i2 < 1; ++i2) {
                l2.bR.a();
                com.corrodinggames.rts.gameFramework.effect.e e2 = l2.bR.b(this.posX + GameUtils.c(-12.0f, 12.0f), this.posY + GameUtils.c(-12.0f, 12.0f), this.posZ, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.high);
                if (e2 == null) continue;
                e2.aq = 9;
                e2.ap = GameUtils.a(4, 5);
                e2.Y = GameUtils.c(-180.0f, 180.0f);
                e2.an = true;
                e2.K = 5.0f + GameUtils.c(0.0f, 3.0f);
                e2.P = GameUtils.c(-0.05f, 0.05f) + GameUtils.k(this.cg) * 0.4f;
                e2.Q = GameUtils.c(-0.05f, 0.05f) + GameUtils.j(this.cg) * 0.4f;
                e2.v = true;
                e2.w = 0.2f;
                e2.G = 0.4f * this.l;
                e2.F = 0.4f * this.l;
                e2.W = e2.V = (float)(90 + GameUtils.a(0, 40));
                e2.r = true;
                e2.ar = (short)2;
            }
            float f2 = this.posX + GameUtils.k(this.cg) * (float)(this.et - 5);
            float f3 = this.posY + GameUtils.j(this.cg) * (float)(this.et - 5);
            boolean bl2 = true;
            for (int i3 = 0; i3 < 1; ++i3) {
                int n2 = 17;
                l2.bR.a();
                com.corrodinggames.rts.gameFramework.effect.e e3 = l2.bR.b(f2 + GameUtils.c((float)(-n2), (float)n2), f3 + com.corrodinggames.rts.gameFramework.GameUtils.c((float)(-n2), (float)n2), this.posZ, com.corrodinggames.rts.gameFramework.effect.d.custom, false, com.corrodinggames.rts.gameFramework.effect.h.high);
                if (e3 == null) continue;
                e3.aq = 9;
                e3.ap = GameUtils.a(4, 5);
                if (bl2) {
                    bl2 = false;
                    e3.ap = 3;
                }
                e3.Y = GameUtils.c(-180.0f, 180.0f);
                e3.an = true;
                if (e3.ap == 3) {
                    e3.P = GameUtils.c(-0.05f, 0.05f);
                    e3.Q = GameUtils.c(-0.05f, 0.05f);
                    e3.G = 1.5f * this.l;
                    e3.F = 2.2f * this.l;
                    e3.V = 90 + GameUtils.a(0, 40);
                    e3.ar = (short)2;
                } else {
                    e3.P = GameUtils.c(-0.05f, 0.05f);
                    e3.Q = GameUtils.c(-0.05f, 0.0f);
                    e3.G = 1.3f;
                    e3.F = 1.3f;
                    e3.V = 60 + GameUtils.a(0, 40);
                    e3.ar = 1;
                }
                e3.W = e3.V;
                e3.r = true;
            }
            if (this.d == 1 || this.d == 2) {
                this.posX += GameUtils.k(this.cg) * (float)(this.et / 2 - 3);
                this.posY += GameUtils.j(this.cg) * (float)(this.et / 2 - 3);
            }
        }
    }

    @Override
    public void n() {
        super.n();
        this.cg = GameUtils.a(this.posY * 5.0f + this.posX * 3.0f, false);
        if (this.d == 0) {
            this.f = (int)(this.posY * 5.0f + this.posX * 3.0f) % 1;
        }
        if (this.d == 1) {
            // empty if block
        }
    }

    @Override
    public float x() {
        return -1.0f;
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public float a(BaseUnit am2, float f2, f f3) {
        boolean bl2 = this.bV;
        float f4 = super.a(am2, f2, f3);
        if (!bl2 && this.bV && f3 != null) {
            float f5;
            this.cg = f5 = GameUtils.d(this.posX, this.posY, f3.posX, f3.posY) + 180.0f;
        }
        return f4;
    }

    @Override
    public boolean q() {
        return true;
    }

    @Override
    public boolean t() {
        return true;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.f();
    }
}

