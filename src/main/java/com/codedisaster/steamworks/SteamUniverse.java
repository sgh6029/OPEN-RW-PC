package com.codedisaster.steamworks;

public enum SteamUniverse {
   Invalid(0),
   Public(1),
   Beta(2),
   Internal(3),
   Dev(4);

   private final int value;
   private static final SteamUniverse[] values = values();

   private SteamUniverse(int var3) {
      this.value = var3;
   }

   static SteamUniverse byValue(int var0) {
      SteamUniverse[] var1 = values;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         SteamUniverse var4 = var1[var3];
         if (var4.value == var0) {
            return var4;
         }
      }

      return Invalid;
   }
}
