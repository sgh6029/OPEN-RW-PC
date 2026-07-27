package com.corrodinggames.rts.game.units.custom;

public enum s
{
    everyFramea("everyFrame", 0), 
    every4Frames("every4Frames", 1), 
    every8Frames("every8Frames", 2);
    
    private static final /* synthetic */ s[] d;
    
    
    private s(final String name, final int ordinal) {
    }
    
    static {
        d = new s[] { s.everyFramea, s.every4Frames, s.every8Frames };
    }
}
