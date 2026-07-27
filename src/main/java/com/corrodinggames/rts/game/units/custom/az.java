package com.corrodinggames.rts.game.units.custom;

enum az
{
    small("small", 0), 
    medium("medium", 1), 
    large("large", 2), 
    smoke("smoke", 3), 
    shockwave("shockwave", 4), 
    largeExplosion("largeExplosion", 5), 
    smallExplosion("smallExplosion", 6), 
    resourcePoolSmoke("resourcePoolSmoke", 7), 
    noneExplosion("noneExplosion", 8);
    
    private static final /* synthetic */ az[] j;
    
    
    private az(final String name, final int ordinal) {  
    }  
    
    static {
        j = new az[] { az.small, az.medium, az.large, az.smoke, az.shockwave, az.largeExplosion, az.smallExplosion, az.resourcePoolSmoke, az.noneExplosion };
    }
} 
  