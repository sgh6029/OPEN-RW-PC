/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.PacketData;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;

public class PasswordHandler {
    public String b;
    public int c;
    public boolean d;
    public String e;
    public String f;
    public String g;

    public void a(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        if (this.d) {
            GameOutputStream as2;
            try {
                as2 = new GameOutputStream();
                as2.c(1);
                as2.a(this.c);
                as2.writeUTF(string2);
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
            PacketData au2 = as2.b(118);
            l2.networkEngine.d(au2);
            return;
        }
        if (l2.networkEngine.C) {
            GameEngine.a("Cannot enter a password when we are a server");
            return;
        }
        l2.networkEngine.n = string2;
        l2.networkEngine.X();
    }

    public void a() {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.b("exited password");
        l2.networkEngine.K();
    }
}

