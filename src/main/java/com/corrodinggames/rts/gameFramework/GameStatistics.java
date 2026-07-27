/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.UnitEventManager;
import com.corrodinggames.rts.gameFramework.TeamHistory;
import com.corrodinggames.rts.gameFramework.StatisticsData;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;

import java.io.IOException;
import java.util.ArrayList;

public class GameStatistics {
    public static boolean a = true;
    StatisticsData b = new StatisticsData();
    StatisticsData[] c = new StatisticsData[PlayerTeam.e];
    int d;
    boolean e;
    public static UnitEventManager f = new UnitEventManager();

    public void a(GameOutputStream as2) throws IOException {
        as2.e("stats");
        as2.c(0);
        int n2 = PlayerTeam.c;
        as2.a(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.c[i2].a(as2);
        }
        as2.a("stats");
    }

    public void a(GameInputStream k2, boolean bl2) throws IOException {
        k2.b("stats");
        byte by = k2.d();
        int n2 = k2.readInt();
        this.c = new StatisticsData[PlayerTeam.e];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.c[i2] = new StatisticsData();
            this.c[i2].a(k2);
        }
        k2.d("stats");
    }

    public void a() {
        this.b = new StatisticsData();
        this.c = new StatisticsData[PlayerTeam.e];
        for (int i2 = 0; i2 < this.c.length; ++i2) {
            this.c[i2] = new StatisticsData();
        }
        this.d = 0;
        this.e = a;
    }

    public void b() {
        int n2 = GameEngine.getInstance().by;
        if (this.e && this.d <= n2) {
            int n3 = 5000;
            if (n2 < 60000) {
                n3 = 1000;
            }
            if (n2 > 1800000) {
                n3 = 15000;
            }
            if (n2 > 3600000) {
                n3 = 30000;
            }
            n3 += n3;
            this.a(n2, false, false);
        }
    }

    private void a(int n2, boolean bl2, boolean bl3) {
        for (int i2 = 0; i2 < PlayerTeam.c; ++i2) {
            PlayerTeam n3 = PlayerTeam.k(i2);
            if (n3 == null) continue;
            TeamHistory bn2 = this.c[i2].l;
            if (bl2 && !bn2.c()) continue;
            bn2.a(n3, n2, bl3);
            bn2.a(i2);
        }
    }

    public void c() {
        this.e = false;
        this.a(GameEngine.getInstance().by, true, true);
    }

    public ArrayList d() {
        ArrayList<StatisticsData> arrayList = new ArrayList<StatisticsData>();
        for (int i2 = 0; i2 < PlayerTeam.c; ++i2) {
            if (!this.c[i2].l.c()) continue;
            arrayList.add(this.c[i2]);
        }
        return arrayList;
    }

    public StatisticsData a(BaseUnit am2) {
        return this.a(am2.bX);
    }

    public StatisticsData a(PlayerTeam n2) {
        int n3 = n2.k;
        if (n3 < 0 || n3 >= this.c.length) {
            return this.b;
        }
        StatisticsData bo2 = this.c[n3];
        if (bo2 == null) {
            return this.b;
        }
        return bo2;
    }

    public void a(BaseUnit am2, BaseUnit am3, float f2) {
        if (am2 != null) {
            boolean bl2 = am3.bV;
            StatisticsData bo2 = this.a(am2);
            StatisticsData bo3 = this.a(am3);
            if (bl2) {
                f.a(am2, am3);
                if (am3.bI()) {
                    ++bo2.d;
                    ++bo3.g;
                } else if (am3.dd()) {
                    ++bo2.e;
                    ++bo3.h;
                } else {
                    ++bo2.c;
                    ++bo3.f;
                }
            }
        }
        GameEngine l2 = GameEngine.getInstance();
        if (am3.bX == l2.bs) {
            l2.a(am3, f2);
        }
    }
}

