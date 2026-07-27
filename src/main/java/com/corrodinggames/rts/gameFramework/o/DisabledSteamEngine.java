/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.o;

import com.corrodinggames.rts.gameFramework.i.b;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class DisabledSteamEngine {
    public static DisabledSteamEngine a = new DisabledSteamEngine();

    public static DisabledSteamEngine a() {
        return a;
    }

    public void b() {
        GameEngine.log("SteamEngine - blank init");
    }

    public void a(float f2) {
    }

    public String c() {
        return null;
    }

    public void d() {
        GameEngine.log("SteamEngine - disableSteam - already disabled");
    }

    public boolean e() {
        return !this.f();
    }

    public boolean f() {
        return true;
    }

    public void g() {
        GameEngine.log("disabledSteam - showInviteDialog");
        GameEngine.getInstance().i("steam API not connected");
    }

    public void h() {
        GameEngine.log("Steam: alertNotEnabled");
        GameEngine l2 = GameEngine.getInstance();
        if (l2 != null) {
            l2.i("steam API not connected");
        }
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
        GameEngine.log("disabledSteam - loadWorkshopMods");
    }

    public void m() {
        GameEngine.log("disabledSteam - showWorkshop");
    }

    public void a(b b2) {
        GameEngine.log("disabledSteam - showWorkshopMod");
    }

    public void b(b b2) {
        GameEngine.log("disabledSteam - publishWorkshopMod");
    }

    public void a(b b2, boolean bl2, String string2) {
        GameEngine.log("disabledSteam - uploadWorkshopMod");
    }
}

