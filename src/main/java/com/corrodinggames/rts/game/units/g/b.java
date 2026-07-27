package com.corrodinggames.rts.game.units.g;

public enum b {
    // 枚举常量定义
    //1
    movementSpeed("movementSpeed") {
        @Override
        a a() {
            return new d();
        }
    },
    //2
    specialActionBlock("specialActionBlock") {
        @Override
        a a() {
            return new e();
        }
    };

    private final String name;

    private b(String name) {
        this.name = name;
    }

    abstract a a();

    // 自动生成的 values() 和 valueOf() 方法不需要手动定义

    // 如果需要获取枚举名称
    public String getName() {
        return name;
    }
}