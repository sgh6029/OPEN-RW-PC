package com.codedisaster.steamworks;

public enum SteamUtils$SteamAPICallFailure {
   None(-1),
   SteamGone(0),
   NetworkFailure(1),
   InvalidHandle(2),
   MismatchedCallback(3);

   private final int code;
   private static final SteamUtils$SteamAPICallFailure[] values = values();

   private SteamUtils$SteamAPICallFailure(int var3) {
      this.code = var3;
   }

   static SteamUtils$SteamAPICallFailure byValue(int var0) {
      SteamUtils$SteamAPICallFailure[] var1 = values;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         SteamUtils$SteamAPICallFailure var4 = var1[var3];
         if (var4.code == var0) {
            return var4;
         }
      }

      return None;
   }
}
