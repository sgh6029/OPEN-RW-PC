/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.c;

import com.codedisaster.steamworks.SteamID;
import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.java.c.a$1;
import com.corrodinggames.librocket.e;

public class SteamGameInviteHandler
implements Runnable {
    JavaSteamEngine a;
    String b;
    SteamID c;
    SteamID d;
    long e;
    Thread f;

    public SteamGameInviteHandler(JavaSteamEngine b2, SteamID steamID, SteamID steamID2, long l2) {
        this.a = b2;
        this.c = steamID;
        this.d = steamID2;
        this.e = l2;
        this.b = b2.c.getFriendPersonaName(steamID);
    }

    public void a() {
        if (this.f != null) {
            throw new RuntimeException("already started");
        }
        a$1 a$1 = new a$1(this);
        ScriptEngine.getInstance().addRunnableToQueue(a$1);
    }

    @Override
    public void run() {
        GameEngine.log("Join clicked");
        Root root = ScriptEngine.getInstance().getRoot();
        root.closePopup();
        this.a.d.joinLobby(this.d);
    }
}

class a$1
implements Runnable {
    final /* synthetic */ SteamGameInviteHandler a;

    a$1(SteamGameInviteHandler a2) {
        this.a = a2;
    }

    @Override
    public void run() {
        Root root = ScriptEngine.getInstance().getRoot();
        e e2 = new e("Join", this.a);
        root.showPopupWithButtons("Invite", "'" + this.a.b + "' has invited you to join a game", true, e2, null);
    }
}