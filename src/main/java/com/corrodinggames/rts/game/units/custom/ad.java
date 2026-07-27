package com.corrodinggames.rts.game.units.custom;

public enum ad
{
    emptyResourcePools_asNeutral("emptyResourcePools_asNeutral", 0), 
    emptyOrOccupiedResourcePools_asNeutral("emptyOrOccupiedResourcePools_asNeutral", 1), 
    mapCenter_asNeutral("mapCenter_asNeutral", 2), 
    mapCenter_eachActiveTeam("mapCenter_eachActiveTeam", 3), 
    spawnPoint_eachActiveTeam("spawnPoint_eachActiveTeam", 4);
    
    private static final /* synthetic */ ad[] f;
    
    
    private ad(final String name, final int ordinal) {
    }
    
    static {
        f = new ad[] { ad.emptyResourcePools_asNeutral, ad.emptyOrOccupiedResourcePools_asNeutral, ad.mapCenter_asNeutral, ad.mapCenter_eachActiveTeam, ad.spawnPoint_eachActiveTeam };
    }
}
