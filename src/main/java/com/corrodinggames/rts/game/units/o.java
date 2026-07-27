package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.gameFramework.GameEngine;

public enum o {
    // 枚举常量定义
    land("land") {
        @Override
        public boolean a(UnitType as2) {
            if (as2 == null) {
                return false;
            }
            BaseUnit am2 = BaseUnit.c(as2);
            if (am2.bO() || as2.j()) {
                return false;
            }
            return am2.h() != UnitMovementType.AIR && am2.h() != UnitMovementType.WATER;
        }
    },
    air("air") {
        @Override
        public boolean a(UnitType as2) {
            if (as2 == null) {
                return false;
            }
            BaseUnit am2 = BaseUnit.c(as2);
            if (am2.bO() || as2.j()) {
                return false;
            }
            return am2.h() == UnitMovementType.AIR;
        }
    },
    sea("sea") {
        @Override
        public boolean a(UnitType as2) {
            if (as2 == null) {
                return false;
            }
            BaseUnit am2 = BaseUnit.c(as2);
            if (am2.bO() || as2.j()) {
                return false;
            }
            return am2.h() == UnitMovementType.WATER;
        }
    },
    buildings("buildings") {
        @Override
        public boolean a(UnitType as2) {
            if (as2 == null) {
                return false;
            }
            BaseUnit am2 = BaseUnit.c(as2);
            return !am2.bO() && as2.j();
        }
    },
    bio("bio") {
        @Override
        public boolean a(UnitType as2) {
            if (as2 == null) {
                return false;
            }
            BaseUnit am2 = BaseUnit.c(as2);
            return am2.bO();
        }
    };

    private final String name;

    private o(String name) {
        this.name = name;
    }

    public abstract boolean a(UnitType as2);

    public String a() {
        return this.name;
    }

    public boolean b() {
        return true;
    }

    public o a(boolean arg0) {
        if (!arg0) {
            return this.a(1, 0);
        } else {
            return this.a(-1, 0);
        }
    }

    public o a(int arg0, int arg1) {
        int ordinal = this.ordinal() + arg0;
        ordinal %= values().length;
        
        if (ordinal < 0) {
            ordinal += values().length;
        }
        
        o result = values()[ordinal];
        
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