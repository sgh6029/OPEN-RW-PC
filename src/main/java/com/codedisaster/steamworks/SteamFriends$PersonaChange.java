package com.codedisaster.steamworks;

public enum SteamFriends$PersonaChange {
   Name(1),
   Status(2),
   ComeOnline(4),
   GoneOffline(8),
   GamePlayed(16),
   GameServer(32),
   Avatar(64),
   JoinedSource(128),
   LeftSource(256),
   RelationshipChanged(512),
   NameFirstSet(1024),
   FacebookInfo(2048),
   Nickname(4096),
   SteamLevel(8192);

   private final int bits;

   private SteamFriends$PersonaChange(int var3) {
      this.bits = var3;
   }

   static boolean isSet(SteamFriends$PersonaChange var0, int var1) {
      return (var0.bits & var1) == var0.bits;
   }
}
