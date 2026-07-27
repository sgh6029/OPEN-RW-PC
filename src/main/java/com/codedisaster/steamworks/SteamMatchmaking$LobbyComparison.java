package com.codedisaster.steamworks;

public enum SteamMatchmaking$LobbyComparison {
   EqualToOrLessThan(-2),
   LessThan(-1),
   Equal(0),
   GreaterThan(1),
   EqualToOrGreaterThan(2),
   NotEqual(3);

   private final int value;

   private SteamMatchmaking$LobbyComparison(int var3) {
      this.value = var3;
   }

   // $FF: synthetic method
   static int access$000(SteamMatchmaking$LobbyComparison var0) {
      return var0.value;
   }
}
