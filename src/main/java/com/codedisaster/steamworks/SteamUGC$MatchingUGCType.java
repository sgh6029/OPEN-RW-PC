package com.codedisaster.steamworks;

public enum SteamUGC$MatchingUGCType {
   Items(0),
   ItemsMtx(1),
   ItemsReadyToUse(2),
   Collections(3),
   Artwork(4),
   Videos(5),
   Screenshots(6),
   AllGuides(7),
   WebGuides(8),
   IntegratedGuides(9),
   UsableInGame(10),
   ControllerBindings(11),
   GameManagedItems(12),
   All(-1);

   private final int value;

   private SteamUGC$MatchingUGCType(int var3) {
      this.value = var3;
   }

   // $FF: synthetic method
   static int access$000(SteamUGC$MatchingUGCType var0) {
      return var0.value;
   }
}
