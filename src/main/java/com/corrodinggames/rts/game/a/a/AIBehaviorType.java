package com.corrodinggames.rts.game.a.a;

public enum AIBehaviorType {
    // 枚举常量定义
    //1
    unknown("unknown") {
        @Override
        public AIBehavior a() {
            return null;
        }
    },
    //2
    nuking("nuking") {
        @Override
        public AIBehavior a() {
            return new NukeBehavior();
        }
    };

    private final String name;

    private AIBehaviorType(String name) {
        this.name = name;
    }

    public abstract AIBehavior a();

    // 自动生成的 values() 和 valueOf() 方法不需要手动定义

    // 如果需要获取枚举名称
    public String getName() {
        return name;
    }
}