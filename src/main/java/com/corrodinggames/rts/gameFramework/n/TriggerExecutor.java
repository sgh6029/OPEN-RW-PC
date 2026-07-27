package com.corrodinggames.rts.gameFramework.n;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.n;
import com.corrodinggames.rts.gameFramework.f.r;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.PointF;

import java.util.Iterator;

public class TriggerExecutor {
   public static void a(MissionEngine var0, MapTrigger var1) throws com.corrodinggames.rts.game.b.MapLoadException {
      GameEngine var2 = GameEngine.getInstance();
      boolean var3 = false;
      if (!var1.j) {
         var3 = true;
      }

      var0.a(var1);
      var1.i = true;
      var1.j = true;
      var1.k = var2.by;
      boolean var4 = false;
      String var5;
      String var7;
      String var8;
      if (var1.A != null) {
         var5 = var1.A.b();
         n var6 = var2.bS.h.a((String) null, var5);
         if (var6 != null) {
            var7 = "globalMessage_delayPerChar";
            var8 = var1.b(var7);
            int var9;
            if (var8 != null) {
               if (var8.equals("slow")) {
                  var6.e = 18;
               } else {
                  var9 = var1.b(var7, -1);
                  if (var9 != -1) {
                     var6.e = var9;
                  }
               }
            }

            var9 = var1.c("globalMessage_textColor", -1);
            if (var9 != -1) {
               var6.f = var9;
            }
         }

         var4 = true;
      }

      var5 = var1.b("debugMessage");
      if (var5 != null) {
         var1.h("Debug: " + var5);
         if (var2.bv && var2.bl) {
            String var16 = "Debug: " + var5;
            NetworkEngine.a((String) null, var16);
         }

         var4 = true;
      }

      boolean var17 = var1.a("showOnMap", false);
      if (var17) {
         var2.bW.a(var1.b(), var1.c(), r.message);
         var4 = true;
      }

      if (var1.f.a > 0) {
         Iterator var18 = var1.f.iterator();

         while (var18.hasNext()) {
            com.corrodinggames.rts.gameFramework.n.a.TriggerCondition var20 = (com.corrodinggames.rts.gameFramework.n.a.TriggerCondition) var18
                  .next();
            if (var20.c(var1)) {
               var4 = true;
            }
         }
      }

      if (var1.g == TriggerType.objective) {
         if (var3) {
            var1.h("objective met");
         }

         var4 = true;
      }

      if (var1.g == TriggerType.trigger_basic) {
         var4 = true;
      }

      if (var1.g == TriggerType.trigger_unitDetect) {
         var4 = true;
      }

      if (var1.g == TriggerType.trigger_teamTagDetect) {
         var4 = true;
      }

      if (var1.g == TriggerType.mapText) {
         var4 = true;
      }

      float var19;
      float var22;
      if (var1.g == TriggerType.moveCamera) {
         var4 = true;
         var19 = (float) var1.b();
         var22 = (float) var1.c();
         var2.b(var19, var22);
      }

      Iterator var12;
      y var14;
      if (var1.g == TriggerType.event_unitAdd) {
         var19 = (float) var1.b();
         var22 = (float) var1.c();
         float var25 = 0.0F;
         float var10 = 0.0F;
         com.corrodinggames.rts.game.PlayerTeam var11 = var1.a();
         var12 = null;
         boolean var13 = false;
         var14 = null;
         boolean var15 = false;
         if (var11 == null) {
            var1.g("No team set, cannot spawn");
         } else if (var1.v != null) {
            var1.v.a(var19, var22, var25, var10, var11, var13, null, null, var15);
         } else {
            var1.g("No valid unit list to spawn");
         }

         var4 = true;
      }

      com.corrodinggames.rts.game.PlayerTeam var23;
      if (var1.g == TriggerType.event_changeCredits) {
         var23 = var1.a();
         if (var23 == null) {
            var1.g("Team not set for changeCredits");
         } else {
            Integer var29 = var1.d("set");
            if (var29 != null) {
               var23.o = (double) var29;
            }

            Integer var36 = var1.d("add");
            if (var36 != null) {
               var23.d((float) var36);
            }

            var4 = true;
         }
      } else if (var1.g == TriggerType.event_teamTags) {
         var23 = var1.a();
         if (var23 == null) {
            var1.g("Team not set for event_teamTags");
         } else {
            var8 = var1.a("addTeamTags", (String) null);
            if (var8 != null) {
               h var31 = g.a(var8);
               var23.b(var31);
            }

            String var33 = var1.a("removeTeamTags", (String) null);
            if (var33 != null) {
               h var34 = g.a(var33);
               var23.c(var34);
            }

            var4 = true;
         }
      } else if (var1.g == TriggerType.event_move) {
         var7 = var1.b("target");
         if (var7 == null) {
            MissionEngine.i("Move trigger has no target id:" + var1.a);
         } else {
            PointF var26 = var0.f(var7);
            if (var26 == null) {
               MissionEngine.i("Move trigger: Cannot find target for:" + var1.a + " target:" + var7);
            } else {
               com.corrodinggames.rts.game.PlayerTeam var30 = var1.a();
               if (var30 == null) {
                  MissionEngine.i("Team not set map trigger:" + var1.a);
               } else {
                  int var28 = 0;
                  com.corrodinggames.rts.gameFramework.GameCommand var35 = var2.cf.b(var30);
                  var12 = BaseUnit.bE.iterator();

                  while (var12.hasNext()) {
                     BaseUnit var39 = (BaseUnit) var12.next();
                     if (var39.bX == var30 && var39 instanceof y && var1.a(var39) && var1.b(var39)) {
                        var14 = (y) var39;
                        var35.a(var14);
                        ++var28;
                     }
                  }

                  var35.a(var26.x, var26.b);
                  if (var3) {
                     var0.b("firstActivation: move at:" + var2.by + " for teamId:" + var30.k + " to targetId:" + var7
                           + " (#units:" + var28 + ")");
                  }

                  if (var1.b("unload") != null) {
                     Iterator var32 = BaseUnit.bE.iterator();

                     while (var32.hasNext()) {
                        BaseUnit var37 = (BaseUnit) var32.next();
                        if (var37.bX == var30 && var37 instanceof y && var1.a(var37) && var1.b(var37) && var37.cr()) {
                           y var38 = (y) var37;
                           com.corrodinggames.rts.gameFramework.GameCommand var40 = var2.cf.b(var30);
                           var40.e = true;
                           var40.a(var38);
                           ActionId var41 = var38.cp();
                           var40.a(var41);
                        }
                     }
                  }

                  var4 = true;
               }
            }
         }
      } else {
         if (var1.g == TriggerType.event_unitRemove) {
            m var21 = new m();
            Iterator var24 = BaseUnit.bE.iterator();

            BaseUnit var27;
            while (var24.hasNext()) {
               var27 = (BaseUnit) var24.next();
               if (var27 instanceof y && var1.a(var27) && var1.b(var27)) {
                  var21.add(var27);
               }
            }

            if (var21.size() > 0) {
               var24 = var21.iterator();

               while (var24.hasNext()) {
                  var27 = (BaseUnit) var24.next();
                  var27.ci();
                  if (var27 instanceof y && var27.bI()) {
                     var2.bU.a((y) var27);
                  }
               }
            }

            var4 = true;
         }

         if (!var4) {
            var1.h("Trigger activated with no effect");
         }

      }
   }
}
