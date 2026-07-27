/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.m;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.o;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.ShaderProgram;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.m.i;

import android.graphics.Bitmap;

import com.corrodinggames.rts.gameFramework.AssetType;
import java.io.IOException;

public class TeamColorTexture
extends Texture_M {
    public static ShaderProgram x;
    public static ShaderProgram y;
    public static ShaderProgram z;
    public static boolean A;
    boolean B = false;
    boolean C = false;
    private Texture_M H;
    private Texture_M I;
    int D;
    int E;
    o F;
    public static float G;

    public static synchronized void C() {
        if (A) {
            return;
        }
        try {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Loading team shaders...");
            x = new i("assets/shaders/pureGreenTeamColor.frag", true);
            x.a("teamColor", -1);
            x.c();
            y = new i("assets/shaders/hueAddTeamColor.frag", false);
            y.a("teamColorAmount", 0.15f);
            y.a("teamColor", -1);
            y.c();
            z = new i("assets/shaders/hueShiftTeamColor.frag", false);
            z.a("teamColor", -1);
            z.c();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        A = true;
    }

    public void D() {
        if (!A) {
            com.corrodinggames.rts.gameFramework.m.TeamColorTexture.C();
        }
    }

    @Override
    public String a() {
        if (this.H == null) {
            return "LazyColoring (error sourceBitmap==null)";
        }
        return "LazyColoring(" + this.E + "):" + this.H.a();
    }

    public TeamColorTexture(Texture_M e2, int n2, o o2, int n3) {
        if (e2 == null) {
            throw new RuntimeException("baseImage==null");
        }
        this.H = e2;
        this.D = n2;
        this.F = o2;
        this.E = n3;
        this.H.a(this);
        this.k = null;
    }

    public void c(boolean bl2) {
        if (com.corrodinggames.rts.gameFramework.GameEngine.az()) {
            if (bl2) {
                // empty if block
            }
            this.D();
            if (this.F == com.corrodinggames.rts.game.o.hueAdd) {
                this.a(y);
            } else if (this.F == com.corrodinggames.rts.game.o.hueShift) {
                this.a(z);
            } else {
                this.a(x);
            }
            this.I = this.H;
            this.C = true;
            return;
        }
        if (this.H.A()) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Lazy loaded bitmap using errored image: " + this.H.a());
            this.I = this.H;
            return;
        }
        try {
            if (bl2) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Loading in lazy loaded bitmap:" + this.H.a() + " team:" + this.E);
            }
            long l2 = PerformanceProfiler.a();
            this.H.i();
            this.I = this.H.h();
            this.I.j();
            Texture_M[] eArray = new Texture_M[]{this.I};
            int[] nArray = new int[]{this.D};
            int[] nArray2 = new int[]{this.E};
            long l3 = PerformanceProfiler.a();
            if (this.F == com.corrodinggames.rts.game.o.hueAdd) {
                com.corrodinggames.rts.game.PlayerTeam.b(this.H, eArray, nArray);
            } else if (this.F == com.corrodinggames.rts.game.o.hueShift) {
                com.corrodinggames.rts.game.PlayerTeam.a(this.H, eArray, nArray, nArray2);
            } else {
                com.corrodinggames.rts.game.PlayerTeam.a(this.H, eArray, nArray);
            }
            double d2 = PerformanceProfiler.a(l3);
            this.I.p();
            this.I.s();
            this.H.q();
            this.H = null;
            double d3 = PerformanceProfiler.a(l2);
            if (d3 > 1.0) {
                com.corrodinggames.rts.gameFramework.GameEngine.log((this.F == com.corrodinggames.rts.game.o.pureGreen ? "Standard " : "Hue ") + "Colouring took:" + PerformanceProfiler.a(d3) + " (" + PerformanceProfiler.a(d2) + ")");
            }
            G = (float)((double)G + d3);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Colouring failed with OOM");
            com.corrodinggames.rts.gameFramework.GameEngine.a(com.corrodinggames.rts.gameFramework.AssetType.gameImageColor, (Throwable)outOfMemoryError);
            this.I = com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bO.r();
        }
    }

    @Override
    public Bitmap b() {
        if (this.C && !com.corrodinggames.rts.gameFramework.GameEngine.az()) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Team shader coloring now disabled. Recoloring image: " + this.H.a());
            this.B = false;
            this.C = false;
            this.a((ShaderProgram)null);
        }
        if (!this.B) {
            this.c(true);
            this.B = true;
        }
        return this.I.k;
    }

    @Override
    public Texture_M c() {
        if (this.C && !com.corrodinggames.rts.gameFramework.GameEngine.az()) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Team shader coloring now disabled. Recoloring image: " + this.H.a());
            this.B = false;
            this.C = false;
            this.a((ShaderProgram)null);
        }
        if (!this.B) {
            if (G > 60.0f) {
                // empty if block
            }
            this.c(true);
            this.B = true;
        }
        if (this.I == null) {
            throw new RuntimeException("coloredBitmap==null");
        }
        return this.I;
    }

    @Override
    public void w() {
        if (!this.B) {
            this.c(false);
            this.B = true;
        }
    }

    @Override
    public int u() {
        if (!this.B & this.H != null) {
            return this.H.u();
        }
        return super.u();
    }
}
