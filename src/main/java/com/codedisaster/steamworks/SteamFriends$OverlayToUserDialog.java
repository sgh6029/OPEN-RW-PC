package com.codedisaster.steamworks;

public enum SteamFriends$OverlayToUserDialog {
   SteamID("steamid"),
   Chat("chat"),
   JoinTrade("jointrade"),
   Stats("stats"),
   Achievements("achievements"),
   FriendAdd("friendadd"),
   FriendRemove("friendremove"),
   FriendRequestAccept("friendrequestaccept"),
   FriendRequestIgnore("friendrequestignore");

   private final String id;

   private SteamFriends$OverlayToUserDialog(String var3) {
      this.id = var3;
   }

   // $FF: synthetic method
   static String access$200(SteamFriends$OverlayToUserDialog var0) {
      return var0.id;
   }
}
