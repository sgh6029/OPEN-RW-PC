/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.game.e;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.gameFramework.j.PasswordHandler;
import com.corrodinggames.rts.gameFramework.j.NetworkConnection;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class NetworkCallbacks {
    public boolean a(NetworkConnection c2, String string2, String string3) {
        return true;
    }

    public boolean a(NetworkConnection c2, PlayerTeam n2, String string2, boolean bl2) {
        return true;
    }

    public void b(NetworkConnection c2, String string2, String string3) {
    }

    public void a(int n2, String string2, String string3, NetworkConnection c2) {
    }

    public String a(NetworkConnection c2, String string2) {
        return null;
    }

    public void c(NetworkConnection c2, String string2, String string3) {
    }

    public void b(NetworkConnection c2, String string2) {
    }

    public void a(PlayerTeam n2) {
    }

    public String a(NetworkConnection c2, String string2, int n2, int n3, String string3, e e2) {
        GameEngine.log("new player Joining packageName:" + string3 + ", appVersion:" + n3 + ", playerName:" + string2 + " ip:" + c2.g() + " id:" + c2.c);
        return null;
    }

    public void a() {
    }

    public boolean a(NetworkConnection c2) {
        return false;
    }

    public boolean b(NetworkConnection c2) {
        return false;
    }

    public void b() {
        GameEngine.log("NetworkCallbacks:startGameEvent()");
    }

    public void c() {
    }

    public void a(PasswordHandler ae2) {
    }

    public void d() {
    }

    public boolean e() {
        return false;
    }
}

