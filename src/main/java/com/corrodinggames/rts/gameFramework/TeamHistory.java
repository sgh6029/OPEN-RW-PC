/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import java.io.IOException;
import java.util.List;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.gameFramework.Point2i;
import com.corrodinggames.rts.gameFramework.IntLookupTable;
import com.corrodinggames.rts.gameFramework.StatisticType;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class TeamHistory {
    private int a = -1;
    private IntLookupTable[] b = new IntLookupTable[StatisticType.values().length];

    public TeamHistory() {
        this.a();
    }

    public void a() {
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            this.b[i2] = new IntLookupTable();
        }
    }

    public void a(GameInputStream k2) throws IOException {
        boolean bl2 = k2.e();
        if (bl2) {
            k2.a("History");
            k2.d();
            this.a = k2.readInt();
            boolean bl3 = k2.e();
            int n2 = k2.d();
            this.a();
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = 0;
                int n4 = 0;
                int n5 = k2.v();
                for (int i3 = 0; i3 < n5; ++i3) {
                    int n6;
                    int n7;
                    if (bl3) {
                        n7 = k2.readInt() + n3;
                        n6 = k2.readInt() + n4;
                        n3 = n7;
                        n4 = n6;
                    } else {
                        n7 = k2.readInt();
                        n6 = k2.readInt();
                    }
                    if (i2 >= this.b.length)
                        continue;
                    this.b[i2].add(new Point2i(n7, n6));
                }
            }
        }
    }

    public void a(GameOutputStream as2) throws IOException {
        boolean bl2 = true;
        as2.a(bl2);
        if (bl2) {
            as2.e();
            as2.c(0);
            as2.a(this.a);
            boolean bl3 = true;
            as2.a(bl3);
            as2.c(this.b.length);
            int n2 = 0;
            for (IntLookupTable bi2 : this.b) {
                int n3 = bi2.size();
                as2.a((short) n3);
                int n4 = 0;
                int n5 = 0;
                for (int i2 = 0; i2 < n3; ++i2) {
                    ++n2;
                    Point2i bh2 = (Point2i) bi2.get(i2);
                    if (bl3) {
                        int n6 = bh2.a;
                        int n7 = bh2.b;
                        as2.a(n6 - n4);
                        as2.a(n7 - n5);
                        n4 = n6;
                        n5 = n7;
                        continue;
                    }
                    as2.a(bh2.a);
                    as2.a(bh2.b);
                }
            }
            GameEngine.log("TeamHistory(" + this.a + "): totalValues written:" + n2);
        }
    }

    public void a(PlayerTeam n2, int n3, boolean bl2) {
        for (StatisticType bj2 : StatisticType.values()) {
            int n4 = bj2.e.a(n2);
            IntLookupTable bi2 = this.b[bj2.ordinal()];
            if (!bi2.isEmpty() && !bl2 && ((Point2i) bi2.get((int) (bi2.size() - 1))).b == n4)
                continue;
            bi2.add(new Point2i(n3, n4));
        }
    }

    public void a(int n2) {
        this.a = n2;
    }

    public int b() {
        return this.a;
    }

    public IntLookupTable a(StatisticType bj2) {
        return this.b[bj2.ordinal()];
    }

    public boolean c() {
        if (this.a < 0) {
            return false;
        }
        for (IntLookupTable bi2 : this.b) {
            if (bi2.size() <= 1)
                continue;
            return true;
        }
        return false;
    }

    public int a(StatisticType bj2, int n2) {
        return this.b[bj2.ordinal()].a(n2);
    }

    public void a(TeamHistory bn2) {
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            this.b[i2] = this.a(this.b[i2], bn2.b[i2]);
        }
    }

    private IntLookupTable a(IntLookupTable bi2, IntLookupTable bi3) {
        if (bi2.isEmpty()) {
            bi2.addAll(bi3);
            return bi2;
        }
        IntLookupTable bi4 = new IntLookupTable();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (Point2i bh2 : ((List<Point2i>) bi2)) {
            int n5 = bh2.a;
            int n6 = bh2.b;
            if (n2 < bi3.size()) {
                Point2i bh3 = (Point2i) bi3.get(n2);
                while (bh3.a < n5) {
                    n4 = bh3.b;
                    bi4.add(new Point2i(bh3.a, n3 + n4));
                    if (++n2 >= bi3.size())
                        continue;
                    bh3 = (Point2i) bi3.get(n2);
                }
                if (bh3.a == n5) {
                    n4 = bh3.b;
                    n3 = n6;
                    bi4.add(new Point2i(n5, n3 + n4));
                    ++n2;
                    continue;
                }
                if (bh3.a <= n5)
                    continue;
                n3 = n6;
                bi4.add(new Point2i(n5, n3 + n4));
                continue;
            }
            n3 = n6;
            bi4.add(new Point2i(n5, n3 + n4));
        }
        while (n2 < bi3.size()) {
            Point2i bh4 = (Point2i) bi3.get(n2);
            n4 = bh4.b;
            bi4.add(new Point2i(bh4.a, n3 + n4));
            ++n2;
        }
        return bi4;
    }
}
