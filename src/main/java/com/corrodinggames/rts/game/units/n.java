package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.Locale;

public enum n {
    // 枚举常量定义
    //a
    all("all") {
        @Override
        public boolean a(UnitType as2) {
            return true;
        }
    },
    //b
    types("types") {
        @Override
        public boolean a(UnitType as2) {
            h_f h2 = h_f.L();
            if (h2 != null && h2.F != null) {
                return h2.F.a(as2);
            }
            return false;
        }
    },
    //c
    terrain("terrain") {
        @Override
        public boolean a(UnitType as2) {
            return false;
        }

        @Override
        public boolean b() {
            return false;
        }
    },
    //d
    modded("modded") {
        @Override
        public boolean a(UnitType as2) {
            if (as2 == null) {
                return false;
            }
            if (as2 instanceof l) {
                l l2 = (l)as2;
                if (l2.J == null) {
                    return false;
                }
                h_f h2 = h_f.L();
                return h2 == null || h2.E == null || l2.J == h2.E;
            }
            return false;
        }
    },
    //e
    search("search") {
        @Override
        public boolean a(UnitType as2) {
            h_f h2 = h_f.L();
            if (h2 == null) {
                return false;
            }
            if (h2.H == null) {
                return false;
            }
            if (h2.I) {
                h2.I = false;
                h2.J = h2.H.toLowerCase().trim();
            }
            if (as2 == null) {
                return false;
            }
            if (as2.i() != null && as2.i().toLowerCase(Locale.ROOT).contains(h2.J)) {
                return true;
            }
            return as2.i() != null && as2.e().toLowerCase(Locale.ROOT).contains(h2.J);
        }

        @Override
        public boolean b() {
            h_f h2 = h_f.L();
            if (h2 == null) {
                return false;
            }
            return h2.H != null;
        }
    },
    actions("actions") {
        @Override
        public boolean a(UnitType as2) {
            return as2 == null;
        }
    };

    private final String name;

    private n(String name) {
        this.name = name;
    }

    public abstract boolean a(UnitType as2);

    public String a() {
        return this.name;
    }

    public boolean b() {
        return true;
    }

    public n a(boolean arg0) {
        if (!arg0) {
            return this.a(1, 0);
        } else {
            return this.a(-1, 0);
        }
    }

    public n a(int arg0, int arg1) {
        int ordinal = this.ordinal() + arg0;
        ordinal %= values().length;
        
        if (ordinal < 0) {
            ordinal += values().length;
        }
        
        n result = values()[ordinal];
        
        if (!result.b()) {
            if (arg1 > 30) {
                GameEngine.log("jumpBy recursion limit hit");
                return result;
            }
            result = result.a(arg0, arg1 + 1);
        }
        
        return result;
    }
}