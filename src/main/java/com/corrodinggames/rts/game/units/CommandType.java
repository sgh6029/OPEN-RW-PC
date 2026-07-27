package com.corrodinggames.rts.game.units;

public enum CommandType
{
    attack("attack", 0), 
    move("move", 1), 
    newSelection("newSelection", 2);
    
    private static final /* synthetic */ CommandType[] d;
    
    private CommandType(final String name, final int ordinal) {
    }
    
    static {
        d = new CommandType[] { CommandType.attack, CommandType.move, CommandType.newSelection };
    }
}
