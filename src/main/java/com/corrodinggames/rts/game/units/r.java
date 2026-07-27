package com.corrodinggames.rts.game.units;

public enum r {
    // 枚举常量定义
    a("grass") {
        @Override
        public String b() {
            return "terrain/Long Grass.tsx";
        }

        @Override
        public String a() {
            return null;
        }
    },
    b("sea") {
        @Override
        public String b() {
            return "terrain/Water.tsx";
        }

        @Override
        public String a() {
            return null;
        }
    },
    c("sand") {
        @Override
        public String b() {
            return "terrain/Sand.tsx";
        }

        @Override
        public String a() {
            return "ridges/Sand Nothing - Flat.tsx";
        }
    },
    d("dust") {
        @Override
        public String b() {
            return "terrain/Dust.tsx";
        }

        @Override
        public String a() {
            return "ridges/Nothing Dust - Flat.tsx";
        }
    };

    private final String name;

    private r(String name) {
        this.name = name;
    }

    public abstract String a();
    public abstract String b();

    // 不需要手动定义 values() 和 valueOf() 方法，枚举会自动生成

    // 如果需要获取枚举名称
    public String getName() {
        return name;
    }
}