/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.e;


import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.UnitSize;
import com.corrodinggames.rts.game.units.TransportUnitInterface;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.e.h;
import com.corrodinggames.rts.game.units.e.i$1;
import com.corrodinggames.rts.game.units.e.i$2;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.m;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class i
        extends h
        implements TransportUnitInterface {
    static Texture_M a = null;
    static Texture_M b = null;
    static Texture_M c = null;
    static Texture_M[] d = new Texture_M[10];
    float e = 0.0f;
    float f;
    boolean g;
    m h = new m();
    public static final AbstractUnitAction i = new i$1(109);
    public static final AbstractUnitAction j = new i$2(110);
    static ArrayList k = new ArrayList();

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(this.e);
        as2.a(this.f);
        as2.a(this.g);
        as2.a(this.h.size());
        for (BaseUnit am2 : ((List<BaseUnit>) this.h)) {
            as2.a(am2);
        }
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.e = k2.g();
        this.f = k2.g();
        this.g = k2.e();
        this.h.clear();
        int n2 = k2.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            BaseUnit am2 = k2.o();
            if (am2 == null)
                continue;
            this.h.add(am2);
        }
        super.a(k2);
    }

    public UnitTypeEnum b() {
        return com.corrodinggames.rts.game.units.UnitTypeEnum.hovercraft;
    }

    public static void L() {
        GameEngine l2 = GameEngine.getInstance();
        a = l2.bO.a(com.corrodinggames.rts.R.drawable.hovercraft);
        c = l2.bO.a(com.corrodinggames.rts.R.drawable.hovercraft_shadow);
        b = l2.bO.a(com.corrodinggames.rts.R.drawable.hovercraft_dead);
        d = com.corrodinggames.rts.game.PlayerTeam.a(a);
    }

    @Override
    public Texture_M d() {
        if (this.bV) {
            return b;
        }
        return d[this.bX.R()];
    }

    @Override
    public Texture_M k() {
        return c;
    }

    @Override
    public Texture_M d(int n2) {
        return null;
    }

    @Override
    public boolean e() {
        this.M = b;
        this.S(0);
        this.bT = false;
        this.f(true);
        this.a(com.corrodinggames.rts.game.units.UnitSize.small);
        return true;
    }

    @Override
    public void a() {
        this.f(true);
        super.a();
    }

    public void f(boolean bl2) {
        for (BaseUnit am2 : ((List<BaseUnit>) this.h)) {
            am2.cN = null;
            am2.posX = this.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(this.cg) * -9.0f;
            am2.posY = this.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(this.cg) * -9.0f;
            if (!bl2)
                continue;
            am2.cj();
        }
        this.h.clear();
    }

    public i(boolean bl2) {
        super(bl2);
        this.T(20);
        this.U(32);
        this.ck = this.cj = 15.0f;
        this.cu = this.cv = 450.0f;
        this.M = a;
        this.N = c;
    }

    public static int a(m m2) {
        int n2 = 0;
        for (BaseUnit am2 : ((List<BaseUnit>) m2)) {
            n2 += am2.cw();
        }
        return n2;
    }

    public static boolean a(m m2, int n2, BaseUnit am2) {
        int n3 = com.corrodinggames.rts.game.units.e.i.a(m2);
        return n3 + am2.cw() <= n2;
    }

    @Override
    public int bY() {
        return com.corrodinggames.rts.game.units.e.i.a(this.h);
    }

    @Override
    public int bZ() {
        return 4;
    }

    public static boolean a(BaseUnit am2, BaseUnit am3, boolean bl2) {
        float f2 = 9.0f;
        float f3 = -180.0f;
        float f4 = 70.0f;
        float f5 = 0.0f;
        float f6 = 7.0f;
        return com.corrodinggames.rts.game.units.e.i.a(am2, am3, bl2, f2, f3, f4, f5, f6);
    }

    public static boolean a(BaseUnit am2, BaseUnit am3, boolean bl2, float f2, float f3, float f4, float f5, float f6) {
        float f7 = am2.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(am2.cg + f3) * f6
                - com.corrodinggames.rts.gameFramework.GameUtils.j(am2.cg + f3) * f5;
        float f8 = am2.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(am2.cg + f3) * f6
                + com.corrodinggames.rts.gameFramework.GameUtils.k(am2.cg + f3) * f5;
        if (!com.corrodinggames.rts.gameFramework.utility.y.a(am3,
                f7 += com.corrodinggames.rts.gameFramework.GameUtils.k(am2.cg + 90.0f) * (bl2 ? -f2 : f2),
                f8 += com.corrodinggames.rts.gameFramework.GameUtils.j(am2.cg + 90.0f) * (bl2 ? -f2 : f2))) {
            f7 += 10.0f;
        }
        if (!com.corrodinggames.rts.gameFramework.utility.y.a(am3, f7, f8)) {
            f7 -= 20.0f;
        }
        if (!com.corrodinggames.rts.gameFramework.utility.y.a(am3, f7, f8)) {
            f7 -= 10.0f;
            f8 += 10.0f;
        }
        if (!com.corrodinggames.rts.gameFramework.utility.y.a(am3, f7, f8)) {
            f8 -= 20.0f;
        }
        if (!com.corrodinggames.rts.gameFramework.utility.y.a(am3, f7, f8)) {
            return false;
        }
        am3.cN = null;
        am3.posX = f7;
        am3.posY = f8;
        am3.bZ += 0.1f;
        am3.cg = am2.cg + f3;
        am3.bR = am2;
        am3.bS = 45.0f;
        if (am3 instanceof y) {
            y y2 = (y) am3;
            y2.j(am3.cg);
            y2.az();
            y2.d(am3.posX + com.corrodinggames.rts.gameFramework.GameUtils.k(am3.cg + (bl2 ? -f2 : f2)) * f4,
                    am3.posY + com.corrodinggames.rts.gameFramework.GameUtils.j(am3.cg + (bl2 ? -f2 : f2)) * f4);
            y2.ac = 0;
        }
        return true;
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.bV || !this.bT()) {
            return;
        }
        if (this.cl == 0.0f && this.em != 3) {
            this.S(3);
        }
        if (this.g && !this.cK() && !this.cK) {
            this.f = com.corrodinggames.rts.gameFramework.GameUtils.a(this.f, f2);
            if (this.f == 0.0f) {
                this.f = 30.0f;
                if (this.h.size() == 0) {
                    this.g = false;
                } else {
                    boolean bl2 = this.h.size() % 2 == 0;
                    BaseUnit am2 = (BaseUnit) this.h.remove(this.h.size() - 1);
                    boolean bl3 = com.corrodinggames.rts.game.units.e.i.a(this, am2, bl2);
                    if (!bl3) {
                        this.h.add(am2);
                    }
                    if (this.h.size() == 0) {
                        this.g = false;
                    }
                }
            }
        }
        this.e += 4.0f * f2;
        if (this.e > 360.0f) {
            this.e -= 360.0f;
        }
        this.posZ = !this.g
                ? com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ,
                        3.0f + com.corrodinggames.rts.gameFramework.GameUtils.j(this.e) * 1.5f, 0.1f * f2)
                : com.corrodinggames.rts.gameFramework.GameUtils.a(this.posZ, 0.0f, 0.1f * f2);
    }

    @Override
    public void a(BaseUnit am2, int n2) {
    }

    @Override
    public float m() {
        return 30.0f;
    }

    @Override
    public float b(int n2) {
        return 100.0f;
    }

    @Override
    public float z() {
        if (this.cK()) {
            return 1.2f;
        }
        return 0.9f;
    }

    @Override
    public float A() {
        if (this.cK()) {
            return 1.8f;
        }
        return 1.4f;
    }

    @Override
    public float B() {
        return 0.1f;
    }

    @Override
    public float C() {
        return 0.03f;
    }

    @Override
    public float D() {
        return 0.05f;
    }

    @Override
    public float c(int n2) {
        return 99.0f;
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public boolean d(BaseUnit am2, boolean bl2) {
        if (this.g) {
            return false;
        }
        if (!com.corrodinggames.rts.game.units.e.i.a(this.h, 4, am2)) {
            return false;
        }
        if (am2 == this) {
            return false;
        }
        if (this.bX != am2.bX && !bl2) {
            return false;
        }
        return com.corrodinggames.rts.gameFramework.utility.y.a(am2, true, true);
    }

    @Override
    public boolean e(BaseUnit am2, boolean bl2) {
        if (!this.d(am2, bl2)) {
            return false;
        }
        this.C(am2);
        return true;
    }

    public void C(BaseUnit am2) {
        am2.cN = this;
        this.h.add(am2);
        GameEngine l2 = GameEngine.getInstance();
        l2.bS.l(am2);
    }

    @Override
    public void e(BaseUnit am2) {
        if (am2.cN == this) {
            this.h.remove(am2);
            am2.cN = null;
        } else {
            com.corrodinggames.rts.gameFramework.GameEngine.g("Unit is not being transported");
        }
    }

    @Override
    public float bN() {
        return 12000.0f;
    }

    @Override
    public boolean bA() {
        return this.g;
    }

    public void M() {
        this.g = true;
        this.f = 30.0f;
    }

    public void ds() {
        this.g = false;
    }

    @Override
    public void a(AbstractUnitAction s2, boolean bl2) {
        if (s2 == i) {
            this.M();
        }
        if (s2 == j) {
            this.ds();
        }
    }

    @Override
    public boolean cr() {
        return true;
    }

    @Override
    public int bB() {
        return this.h.size();
    }

    @Override
    public ActionId cp() {
        return i.N();
    }

    @Override
    public ArrayList N() {
        return k;
    }

    @Override
    public boolean f() {
        return !this.cK();
    }

    @Override
    public boolean j() {
        return true;
    }

    @Override
    public m bz() {
        return this.h;
    }

    @Override
    public /* synthetic */ UnitType r() {
        return this.b();
    }

    static {
        k.add(i);
        k.add(j);
    }
}
