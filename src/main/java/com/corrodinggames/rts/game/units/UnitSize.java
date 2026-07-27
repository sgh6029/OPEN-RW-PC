package com.corrodinggames.rts.game.units;

public enum UnitSize
{
    verysmall("verysmall", 0), //a
    small("small", 1), //b
    normal("normal", 2), //c
    large("large", 3), //d
    largeUnit("largeUnit", 4), //e
    building("building", 5), //f
    buildingNoShockwaveOrSmoke("buildingNoShockwaveOrSmoke", 6), //g
    verylargeBuilding("verylargeBuilding", 7);//h
    
    private static final /* synthetic */ UnitSize[] i;
    
    
    private UnitSize(final String name, final int ordinal) {
    }
    
    static {
        i = new UnitSize[] { UnitSize.verysmall, UnitSize.small, UnitSize.normal, UnitSize.largeUnit, UnitSize.largeUnit, UnitSize.building, UnitSize.buildingNoShockwaveOrSmoke, UnitSize.verylargeBuilding };
    }
}
