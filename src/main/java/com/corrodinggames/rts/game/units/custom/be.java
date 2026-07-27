package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.m;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.game.units.f.c;
import com.corrodinggames.rts.game.b.TileMap;
import java.util.Iterator;

public final class be {
    public static final bf e = new bf();
    private m a = new m();
    private m b = new m();
    private boolean c;
    private boolean d;

    public be() {
        this.a = new m();
        this.b = new m();
    }

    public static be a(l lVar, IniFile abVar) throws bo {
        be beVar = new be();
        beVar.b(lVar, abVar);
        
        if (beVar.b.size() == 0) {
            return null;
        }
        
        Iterator<g> iterator = beVar.a.iterator();
        while (iterator.hasNext()) {
            g next = iterator.next();
            if (next != null) {
                int i = 0;
                bg bgVar = null;
                Iterator<bg> iterator2 = beVar.b.iterator();
                while (iterator2.hasNext()) {
                    bg next2 = iterator2.next();
                    if (next2.b == next) {
                        i++;
                        bgVar = next2;
                    }
                }
                if (i == 1) {
                    lVar.r("[placementRule_" + bgVar.a + "]anyRuleInGroup: No other rule with this same group name found");
                }
            }
        }
        return beVar;
    }

    private static boolean a(y yVar, bg bgVar, float f, float f2) {
        bf bfVar = e;
        bfVar.a = bgVar.g + f;
        bfVar.b = bgVar.h + f2;
        bfVar.c = bgVar;
        bfVar.d = 0;
        
        GameEngine B = GameEngine.getInstance();
        c cVar = B.cc;
        float f3 = bfVar.a;
        float f4 = bfVar.b;
        float f5 = bgVar.e;
        float f6 = 0.0f;
        cVar.a(f3, f4, f5, yVar, 0.0f, bfVar);
        
        return bfVar.d >= bgVar.k && bfVar.d <= bgVar.l;
    }

    public String a(y yVar, float f, float f2) {
        if (!this.c) {
            return null;
        }
        return b(yVar, f, f2);
    }

    public String a(y yVar, int i, int i2) {
        if (!this.d) {
            return null;
        }
        GameEngine B = GameEngine.getInstance();
        TileMap bVar = B.bL;
        bVar.b(i, i2);
        return b(yVar, bVar.T, bVar.U);
    }

    public String b(y yVar, float f, float f2) {
        Iterator<g> iterator = this.a.iterator();
        String str = null;
        while (iterator.hasNext()) {
            g next = iterator.next();
            Iterator<bg> iterator2 = this.b.iterator();
            bg bgVar = null;
            boolean z = false;
            boolean z2 = false;
            while (iterator2.hasNext()) {
                bg next2 = iterator2.next();
                if (next2.b == next && next2.n) {
                    boolean a = a(yVar, next2, f, f2);
                    if (!a) {
                        if (bgVar == null) {
                            bgVar = next2;
                        }
                        z = true;
                    } else {
                        z2 = true;
                    }
                }
            }
            boolean z3 = next == null ? !z : z2;
            if (!z3 && bgVar != null) {
                if (bgVar.o != null) {
                    return bgVar.o.b();
                }
                return "{0}";
            }
        }
        return null;
    }

    public void b(l lVar, IniFile abVar) throws bo {
        m e = abVar.e("placementRule_");
        Iterator<String> iterator = e.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            String substring = next.substring("placementRule_".length());
            bg bgVar = new bg();
            bgVar.a = substring;
            bgVar.a(lVar, abVar, next);
            if (bgVar.a()) {
                if (!this.a.contains(bgVar.b)) {
                    this.a.add(bgVar.b);
                }
                if (bgVar.n) {
                    if (!bgVar.p) {
                        this.c = true;
                    } else {
                        this.d = true;
                    }
                }
                this.b.add(bgVar);
            }
        }
    }
}