/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.g;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.gameFramework.g.d;
import com.corrodinggames.rts.gameFramework.g.f;
import java.util.ArrayList;

public class b
extends d {
    private final String a;
    private final int b;
    private final ArrayList<PlayerTeam> c;

    public b(int n2, ArrayList arrayList) {
        this.b = n2;
        this.c = (ArrayList<PlayerTeam>)arrayList;
        this.a = "Team " + PlayerTeam.a(n2);
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public String b() {
        return this.a;
    }

    @Override
    public int c() {
        return PlayerTeam.i(this.b);
    }

    @Override
    public int d() {
        return PlayerTeam.i(this.b);
    }

    @Override
    public int a(f f2) {
        int n2 = 0;
        for (PlayerTeam n3 : this.c) {
            n2 += f2.a(n3);
        }
        return n2;
    }
}

