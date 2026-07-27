package com.corrodinggames.rts.game;

public enum q
{
    own("own", 0), //a
    ally("ally", 1), //b
    allyNotOwn("allyNotOwn", 2), //c
    enemy("enemy", 3), //d
    neutral("neutral", 4),//e 
    any("any", 5), //f
    notOwn("notOwn", 6);//g
    
    private static final /* synthetic */ q[] h;

    private q(final String name, final int ordinal) {
    }
    
    static {
        h = new q[] { q.own, q.ally, q.allyNotOwn, q.enemy, q.neutral, q.any, q.notOwn };
    }
}
