package com.codedisaster.steamworks;

public enum SteamMatchmaking$ChatMemberStateChange {
   Entered(1),
   Left(2),
   Disconnected(4),
   Kicked(8),
   Banned(16);

   private final int bits;

   private SteamMatchmaking$ChatMemberStateChange(int var3) {
      this.bits = var3;
   }

   static boolean isSet(SteamMatchmaking$ChatMemberStateChange var0, int var1) {
      return (var0.bits & var1) == var0.bits;
   }
}
