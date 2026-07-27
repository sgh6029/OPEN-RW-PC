package com.codedisaster.steamworks;

public enum SteamUGC$ItemPreviewType {
   Image(0),
   YouTubeVideo(1),
   Sketchfab(2),
   EnvironmentMap_HorizontalCross(3),
   EnvironmentMap_LatLong(4),
   ReservedMax(255),
   UnknownPreviewType_NotImplementedByAPI(-1);

   private final int value;
   private static final SteamUGC$ItemPreviewType[] values = values();

   private SteamUGC$ItemPreviewType(int var3) {
      this.value = var3;
   }

   static SteamUGC$ItemPreviewType byValue(int var0) {
      SteamUGC$ItemPreviewType[] var1 = values;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         SteamUGC$ItemPreviewType var4 = var1[var3];
         if (var4.value == var0) {
            return var4;
         }
      }

      return UnknownPreviewType_NotImplementedByAPI;
   }
}
