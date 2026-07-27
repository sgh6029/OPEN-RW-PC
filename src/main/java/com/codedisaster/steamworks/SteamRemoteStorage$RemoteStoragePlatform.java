package com.codedisaster.steamworks;

public enum SteamRemoteStorage$RemoteStoragePlatform {
   None(0),
   Windows(1),
   OSX(2),
   PS3(4),
   Linux(8),
   Reserved2(16),
   All(-1);

   private final int mask;
   private static final SteamRemoteStorage$RemoteStoragePlatform[] values = values();

   private SteamRemoteStorage$RemoteStoragePlatform(int var3) {
      this.mask = var3;
   }

   static SteamRemoteStorage$RemoteStoragePlatform[] byMask(int var0) {
      int var1 = Integer.bitCount(var0);
      SteamRemoteStorage$RemoteStoragePlatform[] var2 = new SteamRemoteStorage$RemoteStoragePlatform[var1];
      int var3 = 0;
      SteamRemoteStorage$RemoteStoragePlatform[] var4 = values;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         SteamRemoteStorage$RemoteStoragePlatform var7 = var4[var6];
         if ((var7.mask & var0) != 0) {
            var2[var3++] = var7;
         }
      }

      return var2;
   }

   // $FF: synthetic method
   static int access$000(SteamRemoteStorage$RemoteStoragePlatform var0) {
      return var0.mask;
   }
}
