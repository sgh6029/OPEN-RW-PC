package com.corrodinggames.rts.game.a;

public enum BaseZoneType
{
    Main("Main", 0), 
    ResourceOutpost("ResourceOutpost", 1), 
    ForwardOutpost("ForwardOutpost", 2);
    
    private static final /* synthetic */ BaseZoneType[] d;
    
    
    private BaseZoneType(final String name, final int ordinal) {
    }
    
    static {
        d = new BaseZoneType[] { BaseZoneType.Main, BaseZoneType.ResourceOutpost, BaseZoneType.ForwardOutpost };
    }
}
