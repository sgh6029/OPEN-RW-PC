package com.corrodinggames.rts.game.a;

enum BaseZoneStage
{
    Pre("Pre", 0), 
    Prepare("Prepare", 1), 
    Active("Active", 2);
    
    private static final /* synthetic */ BaseZoneStage[] d;
    
    private BaseZoneStage(final String name, final int ordinal) {
    }
    
    int a() {
        return this.ordinal();
    }
    
    static {
        d = new BaseZoneStage[] { BaseZoneStage.Pre, BaseZoneStage.Prepare, BaseZoneStage.Active };
    }
}


