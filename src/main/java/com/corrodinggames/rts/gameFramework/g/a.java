package com.corrodinggames.rts.gameFramework.g;

import com.corrodinggames.rts.gameFramework.g.f;
import com.corrodinggames.rts.gameFramework.g.c;
import com.corrodinggames.rts.gameFramework.g.d;
import com.corrodinggames.rts.gameFramework.g.e;
import com.corrodinggames.rts.gameFramework.g.b;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;
import java.util.Iterator;

public class a {
    private final f a;
    private final c b;
    private final ArrayList<d> c_List = new ArrayList<>();

    public a() {
        this(f.none, c.player);
    }

    public a(f fVar, c cVar) {
        this.a = fVar;
        this.b = cVar;
    }

    public static String a(f fVar, int i) {
        switch (fVar.ordinal()) {
            case 1:
                return "" + i;
            case 2:
                return "+" + com.corrodinggames.rts.game.units.custom.e.a.c.D.a((double) i, true);
            default:
                return com.corrodinggames.rts.game.units.custom.e.a.c.D.a((double) i, true);
        }
    }

    public String a(d dVar) {
        if (this.b == c.combinedPlayerAndGroup && (dVar instanceof e)) {
            return "   " + a(this.a, d.b(dVar));
        }
        return a(this.a, d.b(dVar));
    }

    public void a() {
        if (this.a == f.none) {
            return;
        }
        
        ArrayList<PlayerTeam> b = PlayerTeam.b(false);
        
        if (this.b == c.player) {
            Iterator<PlayerTeam> it = b.iterator();
            while (it.hasNext()) {
                this.c_List.add(new e(it.next()));
            }
        } else if (this.b == c.allyGroup) {
            ArrayList<Integer> f = PlayerTeam.f();
            Iterator<Integer> it2 = f.iterator();
            while (it2.hasNext()) {
                Integer next = it2.next();
                ArrayList<PlayerTeam> arrayList = new ArrayList<>();
                Iterator<PlayerTeam> it3 = b.iterator();
                while (it3.hasNext()) {
                    PlayerTeam next2 = it3.next();
                    if (next2.r == next.intValue()) {
                        arrayList.add(next2);
                    }
                }
                this.c_List.add(new b(next.intValue(), arrayList));
            }
        } else if (this.b == c.combinedPlayerAndGroup) {
            ArrayList<Integer> f2 = PlayerTeam.f();
            int i = 0;
            Iterator<Integer> it4 = f2.iterator();
            while (it4.hasNext()) {
                Integer next3 = it4.next();
                ArrayList<PlayerTeam> arrayList2 = new ArrayList<>();
                Iterator<PlayerTeam> it5 = b.iterator();
                while (it5.hasNext()) {
                    PlayerTeam next4 = it5.next();
                    if (next4.r == next3.intValue()) {
                        arrayList2.add(next4);
                    }
                }
                if (i < arrayList2.size()) {
                    i = arrayList2.size();
                }
            }
            if (i <= 1) {
                Iterator<PlayerTeam> it6 = b.iterator();
                while (it6.hasNext()) {
                    this.c_List.add(new e(it6.next()));
                }
            } else {
                Iterator<Integer> it7 = f2.iterator();
                while (it7.hasNext()) {
                    Integer next5 = it7.next();
                    ArrayList<PlayerTeam> arrayList3 = new ArrayList<>();
                    Iterator<PlayerTeam> it8 = b.iterator();
                    while (it8.hasNext()) {
                        PlayerTeam next6 = it8.next();
                        if (next6.r == next5.intValue()) {
                            arrayList3.add(next6);
                        }
                    }
                    this.c_List.add(new b(next5.intValue(), arrayList3));
                    Iterator<PlayerTeam> it9 = arrayList3.iterator();
                    while (it9.hasNext()) {
                        this.c_List.add(new e(it9.next()));
                    }
                }
            }
        }
        
        b();
    }

    public void b() {
        Iterator<d> it = this.c_List.iterator();
        while (it.hasNext()) {
            it.next().b(this.a);
        }
    }

    public void c() {
        int ordinal = this.a.ordinal() + 1;
        if (ordinal >= f.values().length) {
            ordinal = 0;
        }
        f fVar = f.values()[ordinal];
        c cVar = c.combinedPlayerAndGroup;
        GameEngine B = GameEngine.getInstance();
        B.a(fVar, cVar);
    }

    public ArrayList<d> d() {
        return this.c_List;
    }

    public f e() {
        return this.a;
    }

    public c f() {
        return this.b;
    }
}