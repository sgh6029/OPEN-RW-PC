package com.corrodinggames.rts.gameFramework.n;

public enum TriggerType {
    // 枚举常量
    objective("objective") {
        @Override
        public String a() {
            return "objective";
        }
    },
    event_move("event_move") {
        @Override
        public String a() {
            return "move";
        }
    },
    event_changeCredits("event_changeCredits") {
        @Override
        public String a() {
            return "changeCredits";
        }
    },
    event_teamTags("event_teamTags") {
        @Override
        public String a() {
            return "teamTags";
        }
    },
    event_unitAdd("event_unitAdd") {
        @Override
        public String a() {
            return "unitAdd";
        }
    },
    event_unitRemove("event_unitRemove") {
        @Override
        public String a() {
            return "unitRemove";
        }
    },
    mapText("mapText") {
        @Override
        public String a() {
            return "mapText";
        }
    },
    moveCamera("moveCamera") {
        @Override
        public String a() {
            return "moveCamera";
        }
    },
    trigger_unitDetect("trigger_unitDetect") {
        @Override
        public String a() {
            return "unitDetect";
        }
    },
    trigger_teamTagDetect("trigger_teamTagDetect") {
        @Override
        public String a() {
            return "teamTagDetect";
        }
    },
    trigger_basic("trigger_basic") {
        @Override
        public String a() {
            return "basic";
        }
    };

    // 枚举值数组
    private static final TriggerType[] l;

    static {
        // 静态初始化块
        l = new TriggerType[] {
                objective, event_move, event_changeCredits, event_teamTags, event_unitAdd, event_unitRemove, mapText, moveCamera, trigger_unitDetect, trigger_teamTagDetect, trigger_basic
        };
    }

    // 私有构造函数
    private TriggerType(String name) {
        // 枚举构造函数会自动处理name和ordinal
    }

    // 包级访问的合成构造函数（用于匿名子类）
    TriggerType(String name, int ordinal, Object synthetic) {
        this(name);
    }

    // 抽象方法 - 每个枚举常量需要实现
    public abstract String a();

    // 根据字符串值查找枚举（不区分大小写）
    public static TriggerType a(String value) {
        for (TriggerType enumValue : values()) {
            if (enumValue.a().equalsIgnoreCase(value)) {
                return enumValue;
            }
        }
        return null;
    }
}