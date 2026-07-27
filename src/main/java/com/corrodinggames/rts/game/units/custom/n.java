package com.corrodinggames.rts.game.units.custom;

enum n
{
    move("move", 0), //a
    attack("attack", 1),//b 
    idle("idle", 2), //c
    created("created", 3),//d 
    underConstruction("underConstruction", 4), //e
    underConstructionWithLinkedBuiltTime("underConstructionWithLinkedBuiltTime", 5), //f
    queuedUnits("queuedUnits", 6),// g
    repair("repair", 7), //h
    reclaim("reclaim", 8);//i
    
    private static final /* synthetic */ n[] j;
    
    // public static strictfp n[] values() {
    //     return n.j.clone();
    // }
    
    // public static strictfp n valueOf(final String name) {
    //     return Enum.valueOf(n.class, name);
    // }
    
    private n(final String name, final int ordinal) {
    }
    
    public static strictfp n a(final String s) {
        try {
            return valueOf(s);
        }
        catch (final IllegalArgumentException ex) {
            return null;
        }
    }
    
    static {
        j = new n[] { n.move, n.attack, n.idle, n.created, n.underConstruction, n.underConstructionWithLinkedBuiltTime, n.queuedUnits, n.repair, n.reclaim };
    }
}
