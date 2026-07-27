/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.MenuItem
 *  android.view.View
 *  android.widget.AdapterView$AdapterContextMenuInfo
 */
package com.corrodinggames.rts.appFramework;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.app.Activity;

import com.corrodinggames.rts.appFramework.b;
import com.corrodinggames.rts.appFramework.c;
import com.corrodinggames.rts.game.a.AIController;
import com.corrodinggames.rts.game.e;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameMode;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class i
extends b {
    boolean c;
    String d;

    @Override
    public void b() {
        super.b();
        com.corrodinggames.rts.appFramework.c.a((Activity)this, true);
    }

    public static String d(String string2) {
        if (string2 == null) {
            return null;
        }
        if (string2.contains("/MOD|")) {
            int n2 = string2.indexOf("/MOD|");
            return string2.substring(n2);
        }
        if (string2.contains("/NEW_PATH|")) {
            int n3 = string2.indexOf("/NEW_PATH|");
            return string2.substring(n3);
        }
        String[] stringArray = string2.split("/");
        return stringArray[stringArray.length - 1];
    }

    public static boolean a(String string2, String string3) {
        String string4;
        Pattern pattern = Pattern.compile(".*\\[(.*)\\].*");
        Matcher matcher = pattern.matcher(string2);
        if (matcher.matches() && ((string4 = matcher.group(1)).toLowerCase(Locale.ENGLISH) + "|").contains("demo|")) {
            return true;
        }
        string4 = string3.replace(".tmx", "");
        return com.corrodinggames.rts.gameFramework.storage.a.i(string4 = string4 + "_demo");
    }

    public static String e(String string2) {
        return com.corrodinggames.rts.appFramework.c.b(string2);
    }

    public static boolean f(String string2) {
        return string2.contains("skirmish/");
    }

    public static boolean g(String string2) {
        return string2.contains("SD/");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
   public static void a(String var0, boolean var1, int var2, int var3, boolean var4, boolean var5) {
      GameEngine var6 = GameEngine.getInstance();
      var6.bS.g();
      if (!var1 && !var5) {
         var6.L();
         synchronized(var6) {
            var6.dm = null;
            var6.menuBackgroundMapFile = var0;
         }

         if (!var5) {
            var6.startGame(true, GameMode.normal);
         }
      } else {
         int var7 = 0;
         var6.L();
         synchronized(var6) {
            var6.dm = null;
            var6.menuBackgroundMapFile = var0;
            int var9 = PlayerTeam.c - 1;
            int var10 = com.corrodinggames.rts.appFramework.c.a(var0);
            GameEngine.log("Max teams on map: " + var0 + " = " + var10);
            if (var10 > 0 && var10 - 1 < var9) {
               var9 = var10 - 1;
            }

            PlayerTeam.F();
            var6.bs = new e(0);
            var6.bs.v = "Player";

            int var11;
            int var12;
            for(var11 = 0; var11 <= 1; ++var11) {
               for(var12 = 1; var12 <= var9; ++var12) {
                  boolean var13 = var12 % 2 == 0 || var11 == 1;
                  if (var7 < var3 && var13) {
                     PlayerTeam var14 = PlayerTeam.k(var12);
                     if (var14 == null) {
                        com.corrodinggames.rts.game.a.AIController var22 = new com.corrodinggames.rts.game.a.AIController(var12);
                        var22.v = "AI";
                        var22.r = 0;
                        ++var7;
                     }
                  }
               }
            }

            GameEngine.log("Allies: " + var7 + "/" + var3);
            var11 = 0;
            var12 = var2 - var3;

            for(int var21 = 0; var21 <= 1; ++var21) {
               for(int var23 = 1; var23 <= var9; ++var23) {
                  boolean var15 = var23 % 2 == 1 || var21 == 1;
                  if (!var4) {
                     var15 = true;
                  }

                  if (var11 < var12 && var15) {
                     PlayerTeam var16 = PlayerTeam.k(var23);
                     if (var16 == null) {
                        com.corrodinggames.rts.game.a.AIController var24 = new com.corrodinggames.rts.game.a.AIController(var23);
                        var24.v = "AI";
                        ++var11;
                        if (var4) {
                           var24.r = 1;
                        }
                     }
                  }
               }
            }

            var6.networkEngine.aq();
            if (!var5) {
               var6.startGame(false, GameMode.normal);
            }
         }
      }

   }

    @Override

   public void onCreateContextMenu(ContextMenu var1, View var2, ContextMenu.ContextMenuInfo var3) {
      super.onCreateContextMenu(var1, var2, var3);
      AdapterView.AdapterContextMenuInfo var4 = (AdapterView.AdapterContextMenuInfo)var3;
      View var5 = var4.targetView;
      String var6 = (String)var5.getTag();
      GameEngine var7 = GameEngine.getInstance();
      String var8 = e(var6);
      com.corrodinggames.rts.gameFramework.i.b var9;
      if (var6 != null) {
         var9 = var7.bZ.h(var6);
      } else {
         var9 = null;
      }

      this.d = var6;
      var1.setHeaderTitle(var8);
      MenuItem var10 = var1.add(0, var5.getId(), 0, "Export");
      if (var9 != null) {
         var10.setTitle("Export (Standalone maps only)");
         var10.setEnabled(false);
      }

      MenuItem var11 = var1.add(2, var5.getId(), 0, "Delete");
      if (var9 != null) {
         var11.setTitle("Delete (Standalone maps only)");
         var11.setEnabled(false);
      }

      if (var9 != null) {
         MenuItem var12 = var1.add(4, var5.getId(), 0, "From Mod: " + var9.b());
         var12.setEnabled(false);
      }

      if (var9 == null && this.c) {
         String var14 = com.corrodinggames.rts.gameFramework.storage.a.n(var6);
         MenuItem var13 = var1.add(3, var2.getId(), 0, "Storage: " + var14);
         if (var13 != null) {
            var13.setEnabled(false);
         }
      }

   }
}

