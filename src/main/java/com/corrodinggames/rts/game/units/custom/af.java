package com.corrodinggames.rts.game.units.custom;

public enum af
{
    created("created", 0), 
    completeAndActive("completeAndActive", 1), 
    destroyed("destroyed", 2), 
    killedAnyUnit("killedAnyUnit", 3), 
    queuedUnitFinished("queuedUnitFinished", 4), 
    queueItemAdded("queueItemAdded", 5), 
    queueItemCancelled("queueItemCancelled", 6), 
    teleported("teleported", 7), 
    touchTargetSuccess("touchTargetSuccess", 8), 
    newWaypointGivenByPlayer("newWaypointGivenByPlayer", 9), 
    teamChanged("teamChanged", 10), 
    transportingNewUnit("transportingNewUnit", 11), 
    transportUnloadedOrRemovedUnit("transportUnloadedOrRemovedUnit", 12), 
    tookDamage("tookDamage", 13), 
    enteredTransport("enteredTransport", 14), 
    leftTransport("leftTransport", 15), 
    newMessage("newMessage", 16), 
    attachmentRemoved("attachmentRemoved", 17);//r
    
    private static final /* synthetic */ af[] s;
    
    
    private af(final String name, final int ordinal) {
    }
    
    static {
        s = new af[] { af.created, af.completeAndActive, af.destroyed, af.killedAnyUnit, af.queuedUnitFinished, af.queueItemAdded, af.queueItemCancelled, af.teleported, af.touchTargetSuccess, af.newWaypointGivenByPlayer, af.teamChanged, af.transportingNewUnit, af.transportUnloadedOrRemovedUnit, af.tookDamage, af.enteredTransport, af.leftTransport, af.newMessage, af.attachmentRemoved };
    }
}
