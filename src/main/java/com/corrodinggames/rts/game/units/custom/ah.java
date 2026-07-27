package com.corrodinggames.rts.game.units.custom;

enum ah
{
    imageLoad("imageLoad", 0), 
    imageLoadOrGet("imageLoadOrGet", 1), 
    soundLoad("soundLoad", 2), 
    soundLoadOrGet("soundLoadOrGet", 3), 
    iniParse("iniParse", 4), 
    unitParse("unitParse", 5), 
    iniOpen("iniOpen", 6), 
    iniClose("iniClose", 7), 
    iniSetup("iniSetup", 8), 
    actionParse("actionParse", 9), 
    unitParsePartA("unitParsePartA", 10), 
    unitParsePartB("unitParsePartB", 11), 
    unitParsePartC("unitParsePartC", 12), 
    unitParsePartD("unitParsePartD", 13); 
    
    double o; 
    private static final /* synthetic */ ah[] p;            
    
    private ah(final String name, final int ordinal) {
    }
    
    static {
        p = new ah[] { ah.imageLoad, ah.imageLoadOrGet, ah.soundLoad, ah.soundLoadOrGet, ah.iniParse, ah.unitParse, ah.iniOpen, ah.iniClose, ah.iniSetup, ah.actionParse, ah.unitParsePartA, ah.unitParsePartB, ah.unitParsePartC, ah.unitParsePartD };
    }
} 
