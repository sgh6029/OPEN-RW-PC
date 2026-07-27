/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import java.io.IOException;

import com.corrodinggames.rts.gameFramework.TeamHistory;
import com.corrodinggames.rts.gameFramework.SaveGameVersion;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

public class StatisticsData {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public TeamHistory l = new TeamHistory();
    private static final byte m = (byte)SaveGameVersion.b.ordinal();

    public void a(GameOutputStream as2) throws IOException {
        as2.c(m);
        as2.e();
        as2.a(this.a);
        as2.a(this.b);
        as2.a(this.c);
        as2.a(this.d);
        as2.a(this.e);
        as2.a(this.f);
        as2.a(this.g);
        as2.a(this.h);
        as2.a(this.i);
        as2.a(this.j);
        as2.a(this.k);
        this.l.a(as2);
    }

    public void a(GameInputStream k2) throws IOException {
        byte by = k2.d();
        k2.a("stats start");
        this.a = k2.readInt();
        this.b = k2.readInt();
        this.c = k2.readInt();
        this.d = k2.readInt();
        this.e = k2.readInt();
        this.f = k2.readInt();
        this.g = k2.readInt();
        this.h = k2.readInt();
        this.i = k2.readInt();
        this.j = k2.readInt();
        this.k = k2.i();
        if (by >= SaveGameVersion.b.ordinal()) {
            this.l.a(k2);
        }
    }
}

