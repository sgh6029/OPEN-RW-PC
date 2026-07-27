package com.codedisaster.steamworks;

public enum SteamMatchmaking$ChatRoomEnterResponse {
   Success(1),
   DoesntExist(2),
   NotAllowed(3),
   Full(4),
   Error(5),
   Banned(6),
   Limited(7),
   ClanDisabled(8),
   CommunityBan(9),
   MemberBlockedYou(10),
   YouBlockedMember(11);

   private final int code;
   private static final SteamMatchmaking$ChatRoomEnterResponse[] values = values();

   private SteamMatchmaking$ChatRoomEnterResponse(int var3) {
      this.code = var3;
   }

   static SteamMatchmaking$ChatRoomEnterResponse byCode(int var0) {
      SteamMatchmaking$ChatRoomEnterResponse[] var1 = values;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         SteamMatchmaking$ChatRoomEnterResponse var4 = var1[var3];
         if (var4.code == var0) {
            return var4;
         }
      }

      return Error;
   }
}
