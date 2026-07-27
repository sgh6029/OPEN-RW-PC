package com.corrodinggames.rts.game.units.a;

// import com.corrodinggames.rts.gameFramework.h.*;

public enum PingType
{
    normal("normal", 0), 
    attack("attack", 1), 
    defend("defend", 2), 
    nuke("nuke", 3), 
    build("build", 4), 
    upgrade("upgrade", 5), 
    ok("ok", 6), 
    no("no", 7), 
    happy("happy", 8), 
    sad("sad", 9), 
    retreat("retreat", 10);
    
    private static final /* synthetic */ PingType[] l;
    
    
    private PingType(final String name, final int ordinal) {
    }
    
    public String a() {
        return " - " + this.b();
    }
    
    public String b() {
        return com.corrodinggames.rts.gameFramework.h.a.a(this.c(), new Object[0]);
    }
    
    public String c() {
        return "menus.ingame.ping.type." + this.name();
    }
    
    static {
        l = new PingType[] { PingType.normal, PingType.attack, PingType.defend, PingType.nuke, PingType.build, PingType.upgrade, PingType.ok, PingType.no, PingType.happy, PingType.sad, PingType.retreat };
    }
}
