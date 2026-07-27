package com.codedisaster.steamworks;

public enum SteamFriends$OverlayDialog {
   Friends("Friends"),
   Community("Community"),
   Players("Players"),
   Settings("Settings"),
   OfficialGameGroup("OfficialGameGroup"),
   Stats("Stats"),
   Achievements("Achievements");

   private final String id;

   private SteamFriends$OverlayDialog(String var3) {
      this.id = var3;
   }

   // $FF: synthetic method
   static String access$100(SteamFriends$OverlayDialog var0) {
      return var0.id;
   }
}
