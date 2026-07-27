package com.corrodinggames.rts.gameFramework.g;

import com.corrodinggames.rts.game.*;
import com.corrodinggames.rts.game.units.custom.e.*;
import java.util.*;

public enum f
{
    none("none", 0), 
    income("income", 1), 
    armyValue("armyValue", 2), 
    buildingValue("buildingValue", 3), 
    totalValue("totalValue", 4), 
    credits("credits", 5);
    
    private static final /* synthetic */ f[] g;
    
    
    private f(final String name, final int ordinal) {
    }
    
    public int a(final PlayerTeam n) {
        switch (a$1.a[this.ordinal()]) {
            default: {
                return 0;
            }
            case 2: {
                int v = n.v();
                for (final a_f3 a : ((ArrayList<a_f3>)com.corrodinggames.rts.game.units.custom.e.a_f3.f()) ){
                    if (a.d()) {
                        final float b = a.b();
                        if (b == 0.0f) {
                            continue;
                        }
                        v += (int)(b * n.b(a));
                    }
                }
                return v;
            }
            case 3: {
                return n.T.n;
            }
            case 4: {
                return n.T.o;
            }
            case 5: {
                return n.T.n + n.T.o;
            }
            case 6: {
                return (int)n.o;
            }
        }
    }
    
    static {
        g = new f[] { f.none, f.income, f.armyValue, f.buildingValue, f.totalValue, f.credits };
    }
}
