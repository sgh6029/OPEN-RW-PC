/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.gameFramework.GameCommand;
import com.corrodinggames.rts.gameFramework.GameEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// CommandQueue

public class CommandQueue {
    static final boolean a = false;
    public ArrayList<GameCommand> b = new ArrayList<GameCommand>();
    public ArrayList c = new ArrayList();
    public ArrayList d = new ArrayList();
    static int e;

    public static void a(String string2) {
        if (++e == 5) {
            GameEngine.log("(Rate Limiting...)");
        }
        if (e >= 5) {
            return;
        }
        GameEngine.log(string2);
    }

    public void a() {
        this.b.clear();
        this.c.clear();
        this.d.clear();
    }

    public GameCommand b() {
        GameCommand e2 = new GameCommand(this);
        if (a) {
            GameEngine.log("Tracing source");
            e2.b = GameEngine.a(new Exception("Test"));
        }
        return e2;
    }

    public GameCommand a(PlayerTeam n2) {
        return this.b(n2);
    }

    public GameCommand b(PlayerTeam n2) {
        if (n2 == null) {
            throw new RuntimeException("team==null");
        }
        GameEngine l2 = GameEngine.getInstance();
        GameCommand e2 = new GameCommand(this);
        e2.i = n2;
        e2.d = l2.by;
        if (a) {
            GameEngine.log("Tracing source");
            e2.b = GameEngine.a(new Exception("Test"));
        }
        if (!l2.networkEngine.B) {
            if (!e2.l()) {
                GameEngine.b("Command failed prepareAndCheckOnServer()");
            }
            this.b.add(e2);
        } else {
            this.d.add(e2);
        }
        return e2;
    }

    public void c() throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        e = 0;
        if (!l2.networkEngine.B) {
            this.d();
        } else {
            this.e();
        }
    }

    public void d() throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        int n2 = l2.bx;
        int n3 = 0;
        for (GameCommand e2 : this.b) {
            l2.cb.a(e2, n2);
            e2.k();
            ++n3;
        }
        this.b.clear();
        if (n3 > 0) {
            l2.cb.c();
        }
    }

    public void e() throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        int n2 = l2.bx;
        int n3 = 0;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            GameCommand e2 = (GameCommand)iterator.next();
            if (e2.c != n2) continue;
            l2.cb.a(e2, n2);
            e2.k();
            iterator.remove();
            ++n3;
        }
        if (n3 > 0) {
            l2.cb.c();
        }
    }
}

