package com.codedisaster.steamworks;

import java.util.Collection;
import java.util.Iterator;

public enum SteamFriends$FriendFlags {
   None(0),
   Blocked(1),
   FriendshipRequested(2),
   Immediate(4),
   ClanMember(8),
   OnGameServer(16),
   RequestingFriendship(128),
   RequestingInfo(256),
   Ignored(512),
   IgnoredFriend(1024),
   ChatMember(4096),
   All(65535);

   private final int bits;

   private SteamFriends$FriendFlags(int var3) {
      this.bits = var3;
   }

   static int asBits(Collection var0) {
      int var1 = 0;

      SteamFriends$FriendFlags var3;
      for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 |= var3.bits) {
         var3 = (SteamFriends$FriendFlags)var2.next();
      }

      return var1;
   }

   // $FF: synthetic method
   static int access$000(SteamFriends$FriendFlags var0) {
      return var0.bits;
   }
}