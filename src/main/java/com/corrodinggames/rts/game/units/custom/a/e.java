package com.corrodinggames.rts.game.units.custom.a;

public enum e
{
    auto("auto", 0), 
    disabled("disabled", 1), 
    upgrade("upgrade", 2), 
    movementChange("movementChange", 3), 
    sameAsBuilding("sameAsBuilding", 4), 
    launch("launch", 5), 
    launchAmmo("launchAmmo", 6);
    
    private static final /* synthetic */ e[] h;

    
    private e(final String name, final int ordinal) {
    }
    
    static {
        h = new e[] { e.auto, e.disabled, e.upgrade, e.movementChange, e.sameAsBuilding, e.launch, e.launchAmmo };
    }
}
