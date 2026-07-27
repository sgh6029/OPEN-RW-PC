package com.corrodinggames.rts.gameFramework.j;

public enum GameModeType {
    // a
    skirmishMap {
        @Override
        public String a() {
            return "Skirmish Map";
        }
    },
    // b
    customMap {
        @Override
        public String a() {
            return "Custom Map";
        }
    },
    // c-
    savedGame {
        @Override
        public String a() {
            return "Saved Game";
        }
    };

    // 抽象方法
    public abstract String a();
}