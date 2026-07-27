package com.codedisaster.steamworks;

import java.util.Collection;
import java.util.EnumSet;

public enum SteamUGC$ItemState {
   None(0),
   Subscribed(1),
   LegacyItem(2),
   Installed(4),
   NeedsUpdate(8),
   Downloading(16),
   DownloadPending(32);

   private final int bits;
   private static final SteamUGC$ItemState[] values = values();

   private SteamUGC$ItemState(int var3) {
      this.bits = var3;
   }

   static Collection fromBits(int var0) {
      EnumSet var1 = EnumSet.noneOf(SteamUGC$ItemState.class);
      SteamUGC$ItemState[] var2 = values;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         SteamUGC$ItemState var5 = var2[var4];
         if ((var0 & var5.bits) == var5.bits) {
            var1.add(var5);
         }
      }

      return var1;
   }
}
