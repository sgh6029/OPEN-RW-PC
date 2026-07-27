package com.codedisaster.steamworks;

public enum SteamMatchmaking$ChatEntryType {
   Invalid(0),
   ChatMsg(1),
   Typing(2),
   InviteGame(3),
   Emote(4),
   LeftConversation(6),
   Entered(7),
   WasKicked(8),
   WasBanned(9),
   Disconnected(10),
   HistoricalChat(11),
   Reserved1(12),
   Reserved2(13),
   LinkBlocked(14);

   private final int code;
   private static final SteamMatchmaking$ChatEntryType[] values = values();

   private SteamMatchmaking$ChatEntryType(int var3) {
      this.code = var3;
   }

   static SteamMatchmaking$ChatEntryType byCode(int var0) {
      SteamMatchmaking$ChatEntryType[] var1 = values;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         SteamMatchmaking$ChatEntryType var4 = var1[var3];
         if (var4.code == var0) {
            return var4;
         }
      }

      return Invalid;
   }
}
