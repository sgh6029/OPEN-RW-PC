/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.CommandGroup;
import java.util.ArrayList;

public class a {
    public CommandGroup a;
    public CommandGroup b;
    public CommandGroup c;
    public CommandGroup d;
    public CommandGroup e;
    public CommandGroup f;
    public CommandGroup g;
    public CommandGroup h;
    public CommandGroup i;
    public CommandGroup j;
    public CommandGroup k;
    public CommandGroup l;
    public CommandGroup m;
    ArrayList<CommandGroup> n = new ArrayList<CommandGroup>();

    public a() {
        this.a = this.a((byte)1);
        this.b = this.a((byte)2);
        this.c = this.a((byte)3);
        this.d = this.a((byte)4);
        this.e = this.a((byte)10);
        this.f = this.a((byte)11);
        this.g = this.a((byte)13);
        this.h = this.a((byte)21);
        this.i = this.a((byte)35);
        this.j = this.a((byte)40);
        this.k = this.a((byte)45);
        this.l = this.a((byte)52);
        this.m = this.a((byte)60);
        CommandGroup b2 = null;
        b2 = this.a;
        b2.a(b2);
        b2.a(this.a((byte)3));
        b2.a(this.a((byte)4));
        b2.a(this.a((byte)10));
        b2.a(this.a((byte)11));
        b2.a(this.a((byte)13));
        b2.a(this.a((byte)21));
        b2 = this.k;
        b2.a(this.a((byte)52));
        b2 = this.m;
        b2.a(b2);
        b2.a(this.a((byte)3));
        b2.a(this.a((byte)4));
        b2.a(this.a((byte)10));
        b2.a(this.a((byte)11));
        b2.a(this.a((byte)13));
        b2.a(this.a((byte)21));
        b2 = this.a((byte)10);
        b2.a(this.a((byte)3));
        b2.a(this.a((byte)4));
        b2.a(this.a((byte)10));
        b2.a(this.a((byte)13));
        b2.a(this.a((byte)40));
        b2 = this.a((byte)11);
        b2.a(this.a((byte)3));
        b2.a(this.a((byte)10));
        b2.a(this.a((byte)13));
        b2.a(this.a((byte)40));
        b2 = this.a((byte)3);
        b2.a(this.a((byte)3));
        b2.a(this.a((byte)4));
        b2.a(this.a((byte)10));
        b2.a(this.a((byte)13));
        b2 = this.a((byte)4);
        b2.a(this.a((byte)3));
        b2.a(this.a((byte)4));
        b2.a(this.a((byte)10));
        b2.a(this.a((byte)13));
        b2 = this.a((byte)13);
        b2.a(this.a((byte)3));
        b2.a(this.a((byte)4));
        b2.a(this.a((byte)10));
        b2.a(this.a((byte)13));
        b2 = this.a((byte)21);
        b2.a(this.a((byte)3));
        b2.a(this.a((byte)4));
        b2.a(this.a((byte)10));
        b2.a(this.a((byte)13));
        b2 = this.i;
        b2.a(this.a((byte)10));
        b2.a(this.a((byte)13));
    }

    public CommandGroup a(byte by) {
        for (CommandGroup b2 : this.n) {
            if (b2.a != by) continue;
            return b2;
        }
        CommandGroup b3 = new CommandGroup();
        b3.a = by;
        this.n.add(b3);
        return b3;
    }
}

