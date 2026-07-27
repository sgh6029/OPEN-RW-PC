package com.corrodinggames.rts.gameFramework;

public enum GameMode
{
    menu("menu", 0), 
    normal("normal", 1), 
    normalSave("normalSave", 2);
    
    private static final /* synthetic */ GameMode[] d;
    
    
    private GameMode(final String name, final int ordinal) {
    }
    
    static {
        d = new GameMode[] { GameMode.menu, GameMode.normal, GameMode.normalSave };
    }
}
