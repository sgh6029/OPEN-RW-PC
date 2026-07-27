package com.corrodinggames.rts.gameFramework.n;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.b.MapObjectLayer;
import com.corrodinggames.rts.game.units.Tree;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.game.units.custom.bb;
import com.corrodinggames.rts.game.units.d.a.b;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.Serializable;
import com.corrodinggames.rts.gameFramework.effect.g;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.PointF;
import android.graphics.Typeface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MissionEngine extends Serializable {
   public static boolean a = false;
   int b;
   int c;
   PlayerTeam d;
   l e;
   l f;
   public ArrayList g;
   public bb h;
   boolean i;
   boolean j;
   public boolean k;
   public boolean l;
   boolean m;
   boolean n;
   boolean o;
   boolean p;
   public boolean q;
   public int r;
   String s;
   String t;
   int u;
   int v;
   int w;
   int x;
   public int y;
   float z;
   float A;
   float B;
   h C;
   ArrayList D;
   public Paint E;
   public Paint F;
   public Paint G;
   public Paint H;
   final boolean I;
   public ArrayList<MapTrigger> J;
   PointF K;
   int L;
   float M;
   public boolean N;
   public ArrayList O;
   PointF P;
   boolean Q;
   boolean R;
   ArrayList S;
   ArrayList T;

   public MissionEngine() {
      this.f = com.corrodinggames.rts.gameFramework.n.l.b;
      this.g = new ArrayList();
      this.r = 0;
      this.s = null;
      this.t = null;
      this.u = 0;
      this.v = 2;
      this.w = 1;
      this.x = 0;
      this.y = 0;
      this.z = 3000.0F;
      this.A = 0.0F;
      this.B = 0.0F;
      this.C = com.corrodinggames.rts.gameFramework.n.h.a;
      this.D = new ArrayList();
      this.I = true;
      this.J = new ArrayList();
      this.K = new PointF();
      this.L = 0;
      this.M = 0.0F;
      this.O = new ArrayList();
      this.P = new PointF();
      this.Q = false;
      this.R = false;
      this.S = new ArrayList();
      this.T = new ArrayList();
   }

   public void a(String var1) {
      com.corrodinggames.rts.gameFramework.GameEngine.b("MissionEngine", "Map warning: " + var1);
      NetworkEngine.a((String) null, "Map error: " + var1);
   }

   public void a(GameOutputStream var1) throws IOException {
      var1.a(this.j);
      var1.a(this.r);
      var1.a(this.u);
      var1.a(this.v);
      var1.a(this.w);
      var1.a(this.x);
      var1.a(this.z);
      var1.a(this.A);
      var1.a(this.B);
      var1.a(this.m);
      var1.a(6);
      var1.a(this.J.size());
      Iterator var2 = this.J.iterator();

      while (var2.hasNext()) {
         MapTrigger var3 = (MapTrigger) var2.next();
         var1.writeUTF(var3.c);
         var1.a(var3.j);
         var1.a(var3.k);
         var1.a(var3.l);
         var1.a(var3.m);
         var1.a(var3.n);
      }

      var1.a(this.y);
      var1.a(this.l);
   }

   public void a(GameInputStream var1) throws IOException {
      this.j = var1.e();
      this.r = var1.readInt();
      this.u = var1.readInt();
      this.v = var1.readInt();
      this.w = var1.readInt();
      this.x = var1.readInt();
      this.z = var1.g();
      this.A = var1.g();
      this.B = var1.g();
      this.m = var1.e();
      int var2 = var1.readInt();
      if (var2 >= 1) {
         int var3 = var1.readInt();

         for (int var4 = 0; var4 < var3; ++var4) {
            String var5 = var1.l();
            boolean var6 = var1.e();
            int var7 = 0;
            int var8 = 0;
            boolean var9 = false;
            int var10 = 0;
            if (var2 >= 2) {
               var7 = var1.readInt();
               var8 = var1.readInt();
            }

            if (var2 >= 3) {
               var9 = var1.e();
            }

            if (var2 >= 4) {
               var10 = var1.readInt();
            }

            MapTrigger var11 = this.e(var5);
            if (var11 == null) {
               com.corrodinggames.rts.gameFramework.GameEngine
                     .b("MissionEngine:readIn: Could not find saved trigger:" + var5 + " for de/activation");
            } else {
               var11.j = var6;
               var11.k = var7;
               var11.l = var8;
               var11.m = var9;
               var11.n = var10;
            }
         }
      }

      if (var2 >= 5) {
         this.y = var1.readInt();
      }

      if (var2 >= 6) {
         this.l = var1.e();
      } else {
         this.l = true;
      }

   }

   public void b(String var1) {
      com.corrodinggames.rts.gameFramework.GameEngine.b("MissionEngine:triggerLog", var1);
   }

   public boolean a() {
      return this.n;
   }

   public boolean b() {
      return this.o;
   }

   public void a(boolean var1) throws com.corrodinggames.rts.game.b.MapLoadException {
      com.corrodinggames.rts.gameFramework.GameEngine var2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
      this.q = false;
      this.b = var2.by - 1000;
      this.c = var2.by - 1000;
      this.E = new Paint();
      this.E.a(255, 255, 255, 255);
      this.E.a(true);
      this.E.a(Paint$Align.b);
      this.E.a(Typeface.a(Typeface.c, 1));
      var2.a(this.E, 24.0F);
      this.G = new Paint();
      this.G.a(255, 255, 255, 255);
      this.G.a(true);
      this.G.a(Paint$Align.b);
      var2.a(this.G, 18.0F);
      this.H = new Paint();
      this.H.a(255, 255, 255, 255);
      this.H.a(true);
      this.H.a(Paint$Align.b);
      var2.a(this.H, 14.0F);
      this.F = new Paint();
      this.F.a(this.H);
      var2.a(this.F, 18.0F);
      this.j = true;
      boolean var3 = false;
      com.corrodinggames.rts.game.b.MapObject var4 = null;
      if (var2.bL.Q == null) {
         com.corrodinggames.rts.gameFramework.GameEngine.b("MissionEngine",
               "Error: 'triggers' object layer is missing from this map");
         var3 = true;
      } else {
         var4 = var2.bL.Q.a("map_info");
      }

      if (var4 == null) {
         com.corrodinggames.rts.gameFramework.GameEngine.b("MissionEngine", "Error: map_info is missing from this map");
         var3 = true;
      }

      if (var4 != null && var4.b("type") == null) {
         this.a("type is missing from map_info");
         var3 = true;
      }

      if (var3) {
         com.corrodinggames.rts.gameFramework.GameEngine.b("MissionEngine", "Defaulting to skirmish");
         this.n = true;
         this.e = com.corrodinggames.rts.gameFramework.n.l.f;
      } else {
         this.k = "survival".equalsIgnoreCase(var4.b("type"));
         if (this.k) {
            this.l = "true".equalsIgnoreCase(var4.b("survivalWavesClassic"));
            if (this.l) {
               com.corrodinggames.rts.gameFramework.GameEngine.log("Classic survial waves selected");
            }

            this.f();
            this.p = false;
            this.y = var2.bQ.aiDifficulty;
            if (!this.l) {
               this.z = 1200.0F;
               if (this.y < 0) {
                  this.z = 3000.0F;
               }
            } else {
               this.z = 3000.0F;
            }
         }

         String var5 = var4.b("survivalWaves");
         if (var5 != null) {
            this.g(var5);
         }

         String var6 = var4.b("startWithMusic");
         if (var6 != null) {
            var2.bN.a(var6);
         }

         this.n = "skirmish".equalsIgnoreCase(var4.b("type"));
         if (this.n) {
            this.e = com.corrodinggames.rts.gameFramework.n.l.f;
         }

         this.o = "true".equalsIgnoreCase(var4.b("shareFogWithAllies"));
         String var7 = var4.b("winCondition");
         if (var7 == null && !this.n) {
            throw new com.corrodinggames.rts.game.b.MapLoadException("win condition not set");
         } else {
            if (var7 != null) {
               if (var7.equalsIgnoreCase("none")) {
                  this.e = com.corrodinggames.rts.gameFramework.n.l.a;
               } else if (var7.equalsIgnoreCase("allUnitsAndBuildings")) {
                  this.e = com.corrodinggames.rts.gameFramework.n.l.b;
               } else if (var7.equalsIgnoreCase("allBuildings")) {
                  this.e = com.corrodinggames.rts.gameFramework.n.l.c;
               } else if (var7.equalsIgnoreCase("mainBuilings")) {
                  this.e = com.corrodinggames.rts.gameFramework.n.l.d;
               } else if (var7.equalsIgnoreCase("mainBuildings")) {
                  this.e = com.corrodinggames.rts.gameFramework.n.l.d;
               } else if (var7.equalsIgnoreCase("commandCenter")) {
                  this.e = com.corrodinggames.rts.gameFramework.n.l.e;
               } else {
                  if (!var7.equalsIgnoreCase("requiredObjectives")) {
                     throw new com.corrodinggames.rts.game.b.MapLoadException("unknown win condition:" + var7);
                  }

                  this.e = com.corrodinggames.rts.gameFramework.n.l.g;
               }
            }

            if (this.n) {
               this.f = this.e;
            }

            this.h = var4.a("introText", (bb) null);
            if (this.h != null) {
               this.h.a("\\\\n", "\n");
               if (this.h.a()) {
                  this.h = null;
               }
            }

            if (!var2.ay() && !this.n) {
               this.d = com.corrodinggames.rts.game.PlayerTeam.k(3);
               if (this.d != null) {
                  this.d.r = 0;
               }
            }

            if (var2.ay()) {
            }

            Iterator var14 = var2.bL.Q.c.iterator();

            while (true) {
               String var8;
               float var21;
               int var24;
               Iterator var25;
               BaseUnit var28;
               String var38;
               String var41;
               while (var14.hasNext()) {
                  var4 = (com.corrodinggames.rts.game.b.MapObject) var14.next();
                  if ("team_info".equalsIgnoreCase(var4.d)) {
                     int var15 = Integer.parseInt(var4.a("team", "-2"));
                     if (var15 == -2) {
                        throw new RuntimeException("cannot find team for:" + var4.b);
                     }

                     PlayerTeam var19 = com.corrodinggames.rts.game.PlayerTeam.k(var15);
                     if (var19 == null) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("No team loaded for:" + var15 + " skipping");
                        continue;
                     }

                     Integer var23 = var4.c("credits");
                     if (var23 != null) {
                        var19.o = (double) var23;
                     }

                     var8 = var4.b("basicAI");
                     if (var8 != null && var2.P() && var19 instanceof com.corrodinggames.rts.game.a.AIController) {
                        com.corrodinggames.rts.gameFramework.GameEngine
                              .b("Using basic AI:" + var15 + " by map request");
                        com.corrodinggames.rts.game.a.AIController var9 = (com.corrodinggames.rts.game.a.AIController) var19;
                        var9.aY = true;
                     }

                     String var31 = var4.b("lockAiDifficulty");
                     if (var31 != null && var19 instanceof com.corrodinggames.rts.game.a.AIController) {
                        com.corrodinggames.rts.gameFramework.GameEngine
                              .b("Locking lockAiDifficulty:" + var15 + " by map request to: " + var31);
                        com.corrodinggames.rts.game.a.AIController var10 = (com.corrodinggames.rts.game.a.AIController) var19;
                        int var11 = Integer.parseInt(var31);
                        var10.x = var11;
                        var10.y = true;
                        var2.networkEngine.aq();
                     }

                     var38 = var4.b("disabledAI");
                     if (var38 != null && var2.P() && var19 instanceof com.corrodinggames.rts.game.a.AIController) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("Disabling AI:" + var15 + " by map request");
                        com.corrodinggames.rts.game.a.AIController var40 = (com.corrodinggames.rts.game.a.AIController) var19;
                        var40.aX = true;
                     }

                     var41 = var4.b("allyGroup");
                     if (var41 != null && var2.P()) {
                        int var12 = Integer.parseInt(var41);
                        var19.r = var12;
                     }

                     String var43 = var4.b("ai");
                     if (var43 != null) {
                        var19.U = var43.equalsIgnoreCase("survival");
                     }
                  }

                  if ("camera_start".equalsIgnoreCase(var4.b) && !var1) {
                     var2.b(var4.e, var4.f);
                     this.q = true;
                     Integer var17 = var4.c("zoomTo");
                     if (var17 != null) {
                        var2.cV = (float) var17;
                     }
                  }

                  if ("attack_point".equalsIgnoreCase(var4.b)) {
                     this.D.add(new PointF(var4.e, var4.f));
                  }

                  if ("rotate".equalsIgnoreCase(var4.d)) {
                     var5 = var4.b("dir");
                     var21 = Float.parseFloat(var5);
                     var25 = BaseUnit.bE.iterator();

                     while (var25.hasNext()) {
                        var28 = (BaseUnit) var25.next();
                        if (var28 instanceof y && !var28.bI() && var4.a(var28)) {
                           var28.cg = var21;
                        }
                     }
                  }

                  Iterator var20;
                  BaseUnit var22;
                  if ("fall".equalsIgnoreCase(var4.d)) {
                     var20 = BaseUnit.bE.iterator();

                     while (var20.hasNext()) {
                        var22 = (BaseUnit) var20.next();
                        if (var22 instanceof y && !var22.bI() && var4.a(var22)) {
                           var22.dc();
                        }
                     }
                  }

                  if ("set_team".equalsIgnoreCase(var4.d)) {
                     var5 = var4.b("team");
                     var24 = Integer.parseInt(var5);
                     var25 = BaseUnit.bE.iterator();

                     while (var25.hasNext()) {
                        var28 = (BaseUnit) var25.next();
                        if (var28 instanceof y && var4.a(var28)) {
                           var28.P(var24);
                        }
                     }
                  }

                  if ("ai_allow_full_use".equalsIgnoreCase(var4.d)) {
                     var20 = BaseUnit.bE.iterator();

                     while (var20.hasNext()) {
                        var22 = (BaseUnit) var20.next();
                        if (var22 instanceof y && var4.a(var22)) {
                           ((y) var22).bM = false;
                        }
                     }
                  }

                  if ("disable_unit_ai".equalsIgnoreCase(var4.d)) {
                     var20 = BaseUnit.bE.iterator();

                     while (var20.hasNext()) {
                        var22 = (BaseUnit) var20.next();
                        if (var22 instanceof y && var4.a(var22)) {
                           var22.bN = true;
                        }
                     }
                  }
               }

               var14 = BaseUnit.bE.iterator();

               label402: while (true) {
                  BaseUnit var16;
                  do {
                     do {
                        do {
                           do {
                              do {
                                 if (!var14.hasNext()) {
                                    this.J.clear();
                                    var14 = var2.bL.Q.c.iterator();

                                    while (var14.hasNext()) {
                                       var4 = (com.corrodinggames.rts.game.b.MapObject) var14.next();
                                       if (!"team_info".equalsIgnoreCase(var4.d) && !"point".equalsIgnoreCase(var4.d)
                                             && !"camera_pan".equalsIgnoreCase(var4.d)
                                             && !"camera_start".equalsIgnoreCase(var4.b)
                                             && !"map_info".equalsIgnoreCase(var4.b)
                                             && !"attack_point".equalsIgnoreCase(var4.b)
                                             && !"rotate".equalsIgnoreCase(var4.d) && !"fall".equalsIgnoreCase(var4.d)
                                             && !"set_team".equalsIgnoreCase(var4.d)
                                             && !"ai_allow_full_use".equalsIgnoreCase(var4.d)
                                             && !"disable_unit_ai".equalsIgnoreCase(var4.d)
                                             && !"info".equalsIgnoreCase(var4.d)) {
                                          if (var4.n == null) {
                                             c("Error: Skipping trigger:" + var4.b + " - no properties found");
                                          } else {
                                             MapTrigger var27 = com.corrodinggames.rts.gameFramework.n.TriggerFactory.a(this, var4);
                                             if (var27 != null) {
                                                this.J.add(var27);
                                             }
                                          }
                                       }
                                    }

                                    var14 = this.J.iterator();

                                    MapTrigger var18;
                                    while (var14.hasNext()) {
                                       var18 = (MapTrigger) var14.next();
                                       var5 = var18.b("activateIds");
                                       if (var5 == null) {
                                          var5 = var18.b("alsoActivate");
                                       }

                                       String[] var29;
                                       int var37;
                                       if (var5 != null) {
                                          String[] var30 = var5.split(",");
                                          var29 = var30;
                                          int var32 = var30.length;

                                          for (var37 = 0; var37 < var32; ++var37) {
                                             var38 = var29[var37];
                                             MapTrigger var42 = this.d(var38);
                                             if (var42 != null) {
                                                var42.d.a(var18);
                                             } else {
                                                var18.g("linkedTo target not found: " + var5);
                                                com.corrodinggames.rts.gameFramework.GameEngine.log("Possible IDs:");
                                                Iterator var44 = this.J.iterator();

                                                while (var44.hasNext()) {
                                                   MapTrigger var13 = (MapTrigger) var44.next();
                                                   if (var13.b != null) {
                                                      com.corrodinggames.rts.gameFramework.GameEngine.log(var13.b);
                                                   }
                                                }

                                                com.corrodinggames.rts.gameFramework.GameEngine.log("--------");
                                             }
                                          }
                                       }

                                       var6 = var18.b("whenActivatedIds");
                                       if (var6 == null) {
                                          var6 = var18.b("activatedBy");
                                       }

                                       String[] var35;
                                       int var39;
                                       MapTrigger var45;
                                       if (var6 != null) {
                                          var29 = var6.split(",");
                                          var35 = var29;
                                          var37 = var29.length;

                                          for (var39 = 0; var39 < var37; ++var39) {
                                             var41 = var35[var39];
                                             var45 = this.d(var41);
                                             if (var45 == null) {
                                                var18.g("linkedFrom target not found: " + var41);
                                             } else {
                                                var18.d.a(var45);
                                             }
                                          }
                                       }

                                       var6 = var18.b("deactivatedBy");
                                       if (var6 != null) {
                                          var29 = var6.split(",");
                                          var35 = var29;
                                          var37 = var29.length;

                                          for (var39 = 0; var39 < var37; ++var39) {
                                             var41 = var35[var39];
                                             var45 = this.d(var41);
                                             if (var45 == null) {
                                                var18.g("deactivatedBy: target not found: " + var41);
                                             } else {
                                                var18.e.a(var45);
                                             }
                                          }
                                       }
                                    }

                                    com.corrodinggames.rts.gameFramework.GameEngine
                                          .log("Found " + this.J.size() + " map triggers");
                                    var14 = this.J.iterator();

                                    while (var14.hasNext()) {
                                       var18 = (MapTrigger) var14.next();
                                       String[] var33 = var18.t.a();
                                       var24 = var33.length;

                                       for (int var34 = 0; var34 < var24; ++var34) {
                                          var8 = var33[var34];
                                          var18.g("Key was not used: " + var8);
                                       }
                                    }

                                    this.c();
                                    return;
                                 }

                                 var16 = (BaseUnit) var14.next();
                              } while (var16.u());
                           } while (var16 instanceof Tree);
                        } while (var16.bI());
                     } while (var16.cN != null);
                  } while (var16.cO != null);

                  BaseUnit var26 = null;
                  var21 = 4900.0F;
                  var25 = BaseUnit.bE.iterator();

                  while (true) {
                     do {
                        do {
                           do {
                              if (!var25.hasNext()) {
                                 if (var26 != null) {
                                    var26.e(var16, true);
                                 }
                                 continue label402;
                              }

                              var28 = (BaseUnit) var25.next();
                           } while (!var28.cr());
                        } while (var16 == var28);
                     } while (var16.bX != com.corrodinggames.rts.game.PlayerTeam.i && !var28.bX.d(var16.bX));

                     float var36 = com.corrodinggames.rts.gameFramework.GameUtils.a(var28.posX, var28.posY, var16.posX,
                           var16.posY);
                     if (var36 < var21 && var28.d(var16, true)) {
                        var26 = var28;
                        var21 = var36;
                     }
                  }
               }
            }
         }
      }
   }

   public void c() {
      Iterator var1 = this.J.iterator();

      while (true) {
         MapTrigger var2;
         do {
            if (!var1.hasNext()) {
               return;
            }

            var2 = (MapTrigger) var1.next();
         } while (var2.g != com.corrodinggames.rts.gameFramework.n.TriggerType.objective);

         boolean var3 = false;
         Iterator var4 = this.g.iterator();

         while (var4.hasNext()) {
            m var5 = (m) var4.next();
            if (var5.a == var2) {
               var3 = true;
            }
         }

         if (!var3) {
            m var6 = new m();
            var6.a = var2;
            this.g.add(var6);
            com.corrodinggames.rts.gameFramework.GameEngine.log("Found objective: " + var6.a());
         }
      }
   }

   public static void c(String var0) {
      com.corrodinggames.rts.gameFramework.GameEngine var1 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
      com.corrodinggames.rts.gameFramework.GameEngine.b("MissionEngine", var0);
      NetworkEngine.g(var0);
   }

   public MapTrigger d(String var1) {
      var1 = var1.trim();
      Iterator var2 = this.J.iterator();

      MapTrigger var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (MapTrigger) var2.next();
      } while (var3.b == null || !var3.b.equalsIgnoreCase(var1));

      return var3;
   }

   public MapTrigger e(String var1) {
      var1 = var1.trim();
      Iterator var2 = this.J.iterator();

      MapTrigger var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (MapTrigger) var2.next();
      } while (!var3.c.equalsIgnoreCase(var1));

      return var3;
   }

   public PointF f(String var1) {
      com.corrodinggames.rts.gameFramework.GameEngine var2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
      MapObjectLayer var3 = var2.bL.Q;
      if (var3 != null) {
         Iterator var4 = var3.c.iterator();

         while (var4.hasNext()) {
            com.corrodinggames.rts.game.b.MapObject var5 = (com.corrodinggames.rts.game.b.MapObject) var4.next();
            if ("point".equalsIgnoreCase(var5.d) && var5.c != null && var5.c.equalsIgnoreCase(var1)) {
               this.K.a(var5.e, var5.f);
               return this.K;
            }
         }
      }

      return null;
   }

   public void a(float var1) {
      com.corrodinggames.rts.gameFramework.GameEngine var2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
   }

   public void b(float var1) {
      try {
         com.corrodinggames.rts.gameFramework.GameEngine var2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
         String var13;
         if (this.i) {
            Iterator var3 = this.J.iterator();

            while (var3.hasNext()) {
               MapTrigger var4 = (MapTrigger) var3.next();
               if (var4.g == com.corrodinggames.rts.gameFramework.n.TriggerType.mapText && var4.j) {
                  float var5 = (float) var4.b() - var2.cw;
                  float var6 = (float) var4.c() - var2.cx;
                  var5 *= var2.cX;
                  var6 *= var2.cX;
                  var5 += var4.w;
                  var6 += var4.x;
                  if (var4.C) {
                     g var7 = com.corrodinggames.rts.gameFramework.effect.c.s[9];
                     var7.a(2, var5, var6, var4.B);
                     var6 -= (float) (var7.c - 2);
                  }

                  if (var4.z != null) {
                     var13 = var4.z.b();
                     if (var13 != null && !var13.equals("")) {
                        var2.bO.a(var13, var5, var6, var4.B);
                     }
                  }
               }
            }
         }

         int var12;
         String var14;
         if (this.k && !this.N) {
            boolean var8 = true;
            boolean var10 = false;
            this.B = com.corrodinggames.rts.gameFramework.GameUtils.a(this.B, var1);
            if (this.B == 0.0F && this.A != 0.0F) {
               this.A = com.corrodinggames.rts.gameFramework.GameUtils.a(this.A, var1);
               var10 = true;
            }

            if (var8) {
               if (var10) {
                  var12 = (int) (23.0F + this.E.k() / 2.0F);
                  var2.bO.a("- Wave " + this.r + " -", var2.cameraShakeX / 2.0F, (float) var12, this.E);
                  if (this.s != null) {
                     var2.bO.a(this.s, var2.cameraShakeX / 2.0F, (float) var12 + this.E.k() + 2.0F, this.F);
                  }
               } else {
                  var12 = (int) (23.0F + this.G.k() / 2.0F);
                  var14 = "Wave " + (this.r + 1) + " in " + com.corrodinggames.rts.gameFramework.GameUtils
                        .f(String.valueOf((int) ((double) this.z / 60.0)), 3);
                  if (this.m) {
                     var14 = "Defeat - Wave " + this.r;
                  }

                  var2.bO.a(var14, var2.cameraShakeX / 2.0F, (float) var12, this.G);
                  if (this.t == null) {
                     com.corrodinggames.rts.gameFramework.n.i var15;
                     if (!this.l) {
                        var15 = this.b(false);
                     } else {
                        var15 = this.c(false);
                     }

                     this.t = var15.toString();
                  }

                  var13 = this.t;
                  var2.bO.a(var13, var2.cameraShakeX / 2.0F, (float) var12 + this.G.k() + 2.0F, this.H);
               }
            }
         }

         if (this.k && this.N) {
            com.corrodinggames.rts.gameFramework.n.g var9 = this.d();
            if (var9 != null) {
               int var11 = var9.e - var2.by / 1000;
               var12 = (int) (23.0F + this.G.k() / 2.0F);
               var14 = "Wave " + (this.r + 1) + " in "
                     + com.corrodinggames.rts.gameFramework.GameUtils.f(String.valueOf(var11), 3);
               if (this.m) {
                  var14 = "Defeat - Wave " + this.r;
               }

               var2.bO.a(var14, var2.cameraShakeX / 2.0F, (float) var12, this.G);
               var13 = var9.f;
               if (var13 != null) {
                  var2.bO.a(var13, var2.cameraShakeX / 2.0F, (float) var12 + this.G.k() + 2.0F, this.H);
               }
            }
         }
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

   public void g(String var1) throws com.corrodinggames.rts.game.b.MapLoadException {
      com.corrodinggames.rts.gameFramework.GameEngine.log("Loading survival waves");
      this.N = true;
      String[] var2 = var1.split("\n");
      int var3 = 0;
      int var4 = 0;
      boolean var5 = false;
      String[] var6 = var2;
      int var7 = var2.length;

      for (int var8 = 0; var8 < var7; ++var8) {
         String var9 = var6[var8];
         ++var4;
         com.corrodinggames.rts.gameFramework.n.g var10 = new com.corrodinggames.rts.gameFramework.n.g(this);
         if (var10.a(var9)) {
            var10.e = var3 + (int) var10.d;
            var3 = var10.e;
            com.corrodinggames.rts.gameFramework.GameEngine.log("Adding wave " + var4 + " at " + var10.e);
            this.O.add(var10);
         }
      }

   }

   public com.corrodinggames.rts.gameFramework.n.g d() {
      return this.r < this.O.size() ? (com.corrodinggames.rts.gameFramework.n.g) this.O.get(this.r) : null;
   }

   public void e() {
      this.R = true;
      int var1 = com.corrodinggames.rts.gameFramework.GameUtils.a(0, this.D.size() - 1, this.r);
      PointF var2 = (PointF) this.D.get(var1);
      this.P.a(var2);
   }

   public void f() {
      this.S.clear();
      this.a(this.S, "scout", 0.7F);
      this.a(this.S, (com.corrodinggames.rts.game.units.UnitType) UnitTypeEnum.tank, 2.1F);
      this.a(this.S, "mechGun", 1.0F);
      this.a(this.S, "lightGunship", 2.8F);
      this.a(this.S, (com.corrodinggames.rts.game.units.UnitType) UnitTypeEnum.hoverTank, 1.9F);
      this.a(this.S, (com.corrodinggames.rts.game.units.UnitType) UnitTypeEnum.helicopter, 0.8F);
      this.a(this.S, (com.corrodinggames.rts.game.units.UnitType) UnitTypeEnum.heavyTank, 1.0F);
      this.a(this.S, (com.corrodinggames.rts.game.units.UnitType) UnitTypeEnum.heavyHoverTank, 0.8F);
      this.a(this.S, (com.corrodinggames.rts.game.units.UnitType) UnitTypeEnum.gunShip, 0.7F);
      this.a(this.S, "plasmaTank", 0.6F);
      this.a(this.S, "missileAirship", 0.4F);
      this.T.clear();
      this.a(this.T, (com.corrodinggames.rts.game.units.UnitType) UnitTypeEnum.experimentalTank, 1.0F);
      this.a(this.T, (com.corrodinggames.rts.game.units.UnitType) UnitTypeEnum.turret_flamethrower, 0.5F);
   }

   public void a(ArrayList var1, String var2, float var3) {
      this.a(var1, com.corrodinggames.rts.game.units.custom.l.s(var2), var3);
   }

   public void a(ArrayList var1, com.corrodinggames.rts.game.units.UnitType var2, float var3) {
      if (var2 == null) {
         var2 = UnitTypeEnum.tank;
      }

      com.corrodinggames.rts.game.units.UnitType var4 = com.corrodinggames.rts.game.units.custom.l
            .c((com.corrodinggames.rts.game.units.UnitType) var2);
      if (var4 != null) {
         var2 = var4;
      }

      com.corrodinggames.rts.gameFramework.n.k var5 = new com.corrodinggames.rts.gameFramework.n.k(this);
      var5.a = (com.corrodinggames.rts.game.units.UnitType) var2;
      var5.b = var3;
      var1.add(var5);
   }

   public void a(com.corrodinggames.rts.gameFramework.n.i var1, int var2, float var3) {
      if (var2 < 0) {
         var2 = 0;
      }

      int var4 = this.S.size();
      if (var4 == 0) {
         com.corrodinggames.rts.gameFramework.GameEngine.b("error maxTypeNum: " + var4);
      } else {
         int var5 = var2 % var4;
         com.corrodinggames.rts.gameFramework.n.k var6 = (com.corrodinggames.rts.gameFramework.n.k) this.S.get(var5);
         int var7 = (int) ((double) (var2 + 3) * 0.5 * (double) var6.b * (double) var3);
         var7 = (int) com.corrodinggames.rts.gameFramework.GameUtils.e((float) var7, 0.8F);
         if (var7 < 1) {
            var7 = 1;
         }

         var1.b(var6.a, var7);
      }
   }

   public com.corrodinggames.rts.gameFramework.n.i b(boolean var1) {
      com.corrodinggames.rts.gameFramework.n.i var2 = new com.corrodinggames.rts.gameFramework.n.i(this);
      boolean var3 = false;
      int var4;
      if (this.u > 50 && (this.u + 1) % 100 == 0) {
         var4 = this.T.size();
         int var5 = this.u / 100;
         if (var4 == 0) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("error maxTypeNum: " + var4);
         } else {
            int var6 = var5 % var4;
            com.corrodinggames.rts.gameFramework.n.k var7 = (com.corrodinggames.rts.gameFramework.n.k) this.T.get(var6);
            int var8 = (int) ((float) var5 * var7.b);
            if (var8 < 1) {
               var8 = 1;
            }

            var2.b(var7.a, var8);
         }

         var3 = true;
      }

      var4 = 0;
      if (this.y > 0) {
         var4 = this.y;
      }

      this.a(var2, this.u + var4, 1.0F);
      if (this.u > 15 && !var3) {
         this.a(var2, (int) ((float) (this.u + var4) * 1.1F) - 11, 0.5F);
      }

      if (var1) {
         ++this.u;
         ++this.v;
      }

      return var2;
   }

   public com.corrodinggames.rts.gameFramework.n.i c(boolean var1) {
      com.corrodinggames.rts.gameFramework.n.i var2 = new com.corrodinggames.rts.gameFramework.n.i(this);
      var2.a = false;
      int var3 = this.v;
      UnitTypeEnum var4 = null;
      if (this.p) {
         var4 = UnitTypeEnum.ladybug;
      } else {
         if (this.u == 0) {
            ++var3;
            var4 = UnitTypeEnum.tank;
         }

         if (this.u == 1) {
            var4 = UnitTypeEnum.hoverTank;
         }

         if (this.u == 2) {
            var4 = UnitTypeEnum.helicopter;
         }

         if (this.u == 3) {
            var3 = this.w;
            var4 = UnitTypeEnum.heavyTank;
         }

         if (this.u == 4) {
            var3 = this.w;
            var4 = UnitTypeEnum.heavyHoverTank;
            if (this.w % 2 == 0) {
               var4 = UnitTypeEnum.gunShip;
            }
         }

         if (this.u == 5) {
            var2.a = true;
            var3 = 1;
            var4 = UnitTypeEnum.experimentalTank;
         }

         if (var1) {
            ++this.u;
            boolean var5 = false;
            if (this.w == 1) {
               if (this.u > 2) {
                  var5 = true;
               }
            } else if (this.w < 5) {
               if (this.u > 4) {
                  var5 = true;
               }
            } else {
               if (this.u > 5) {
                  var5 = true;
               }

               if (this.u > 4 && this.w % 2 == 0) {
                  var5 = true;
               }
            }

            if (var5) {
               this.u = 0;
               this.v += 2;
               ++this.w;
            }
         }
      }

      var2.a(var4, var3);
      return var2;
   }

   public void c(float var1) {
      com.corrodinggames.rts.gameFramework.GameEngine var2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
      int var3 = var2.by;
      this.M = com.corrodinggames.rts.gameFramework.GameUtils.a(this.M, var1);
      if (var2.gameStarted && var2.bH) {
         com.corrodinggames.rts.game.b.MapObject var4 = null;
         if (var2.bL.Q != null) {
            Iterator var5 = var2.bL.Q.c.iterator();

            while (var5.hasNext()) {
               com.corrodinggames.rts.game.b.MapObject var6 = (com.corrodinggames.rts.game.b.MapObject) var5.next();
               if ("camera_pan".equalsIgnoreCase(var6.d) && this.L == Integer.parseInt(var6.a("index", "-1"))) {
                  var4 = var6;
               }
            }
         }

         if (var4 == null) {
            this.L = 0;
         } else {
            float var12 = var4.e;
            float var14 = var4.f;
            if (var12 < var2.cameraShakeDecay + 2.0F) {
               var12 = var2.cameraShakeDecay + 2.0F;
            }

            if (var14 < var2.cameraShakeTime + 2.0F) {
               var14 = var2.cameraShakeTime + 2.0F;
            }

            if (var12 > var2.bL.i() - var2.cameraShakeDecay - 2.0F) {
               var12 = var2.bL.i() - var2.cameraShakeDecay - 2.0F;
            }

            if (var14 > var2.bL.j() - var2.cameraShakeTime - 2.0F) {
               var14 = var2.bL.j() - var2.cameraShakeTime - 2.0F;
            }

            float var7 = com.corrodinggames.rts.gameFramework.GameUtils.d(var2.cy + var2.cameraShakeDecay, var2.cz + var2.cameraShakeTime, var12,
                  var14);
            float var8 = com.corrodinggames.rts.gameFramework.GameUtils.a(var2.cy + var2.cameraShakeDecay, var2.cz + var2.cameraShakeTime, var12,
                  var14);
            if (this.M == 0.0F && (var8 < 225.0F || var2.ct)) {
               ++this.L;
               this.M = 50.0F;
            }

            float var9 = 0.45F * var1;
            var2.cy += com.corrodinggames.rts.gameFramework.GameUtils.k(var7) * var9;
            var2.cz += com.corrodinggames.rts.gameFramework.GameUtils.j(var7) * var9;
            var2.a(var2.cy, var2.cz);
            var2.Q();
         }
      }

      if (this.k) {
         if (!this.N) {
            if (!this.m) {
               this.z = com.corrodinggames.rts.gameFramework.GameUtils.a(this.z, var1);
            }

            if (this.z == 0.0F && !this.m) {
               ++this.r;
               this.A = 180.0F;
               int var10 = com.corrodinggames.rts.gameFramework.GameUtils.a(0, this.D.size() - 1, this.r);
               PointF var15 = (PointF) this.D.get(var10);
               com.corrodinggames.rts.gameFramework.n.i var18;
               if (!this.l) {
                  this.s = this.b(false).toString();
                  var18 = this.b(true);
               } else {
                  this.s = this.c(false).toString();
                  var18 = this.c(true);
               }

               this.z = 1800.0F;
               if (!this.l) {
                  if (this.y > 0) {
                     this.z -= (float) (this.y * 3 * 60);
                  } else {
                     this.z -= (float) (this.y * 9 * 60);
                  }
               }

               var18.a(var15.x, var15.b);
               this.t = null;
            }
         } else if (!this.m) {
            com.corrodinggames.rts.gameFramework.n.g var11 = this.d();
            if (var11 != null) {
               if (var11.e * 1000 < var2.by) {
                  var11.a();
                  ++this.r;
               }
            } else if (!var2.dq && !var2.cb.j()) {
               var2.bS.G();
            }
         }
      }

      if (this.j) {
         this.j = false;
         if (this.h != null) {
            var2.a("Briefing", this.h);
         }
      }

      if (var3 > this.b + 250) {
         this.b = var3;
         this.a(var3);
      }

      if (var3 > this.c + 1000) {
         this.c = var3;
         if (this.h()) {
            this.h();
            this.h();
         }

         boolean var13 = false;
         boolean var16 = false;
         if (var2.bs != null) {
            if (var2.bs.j()) {
               var13 = true;
            }

            if (var2.bs.b()) {
               var16 = true;
            }
         }

         boolean var20;
         if (!var2.dq && !var2.dt && !var2.cb.j() && !var16) {
            var20 = true;
            boolean var17 = true;
            Iterator var19;
            BaseUnit var24;
            if (this.e == com.corrodinggames.rts.gameFramework.n.l.a) {
               var20 = false;
            } else if (this.e == com.corrodinggames.rts.gameFramework.n.l.g) {
               var19 = this.g.iterator();

               while (var19.hasNext()) {
                  m var23 = (m) var19.next();
                  if (!var23.b()) {
                     var20 = false;
                  }
               }
            } else if (var2.bs != null) {
               var19 = BaseUnit.bE.iterator();

               while (var19.hasNext()) {
                  var24 = (BaseUnit) var19.next();
                  if (var2.bs.c(var24.bX) && this.a(this.e, var24)) {
                     var20 = false;
                     break;
                  }
               }
            }

            if (this.f == com.corrodinggames.rts.gameFramework.n.l.a) {
               var17 = false;
            } else if (this.f == com.corrodinggames.rts.gameFramework.n.l.g) {
               var17 = false;
            } else if (var2.bs != null) {
               var19 = BaseUnit.bE.iterator();

               while (var19.hasNext()) {
                  var24 = (BaseUnit) var19.next();
                  if (var2.bs.d(var24.bX) && this.a(this.f, var24)) {
                     var17 = false;
                     break;
                  }
               }
            }

            if (var17 && !var20) {
               var2.bS.H();
            }

            if (var20) {
               var2.bS.G();
               if (var2.by > 1500) {
                  ++var2.bQ.numberOfWins;
                  var2.bQ.save();
               }
            }
         }

         if (this.k && !this.m) {
            var20 = true;
            Iterator var21 = BaseUnit.bE.iterator();

            while (true) {
               BaseUnit var22;
               do {
                  if (!var21.hasNext()) {
                     if (var20) {
                        this.m = true;
                        var2.bS.H();
                     }

                     return;
                  }

                  var22 = (BaseUnit) var21.next();
               } while (!(var22 instanceof com.corrodinggames.rts.game.units.d.e) && !var22.bP);

               if (!var22.bV && !var22.u() && var22.bX == var2.bs) {
                  var20 = false;
               }
            }
         }
      }

   }

   public boolean a(l var1, BaseUnit var2) {
      if (!(var2 instanceof y)) {
         return false;
      } else if (!var2.bV && !var2.cT()) {
         if (var1 == com.corrodinggames.rts.gameFramework.n.l.a) {
            return false;
         } else if (var1 == com.corrodinggames.rts.gameFramework.n.l.b) {
            return true;
         } else if (var1 == com.corrodinggames.rts.gameFramework.n.l.c) {
            return var2.bI();
         } else if (var1 == com.corrodinggames.rts.gameFramework.n.l.e) {
            return var2 instanceof com.corrodinggames.rts.game.units.d.e || var2.bP;
         } else if (var1 != com.corrodinggames.rts.gameFramework.n.l.d) {
            if (var1 == com.corrodinggames.rts.gameFramework.n.l.f) {
               if (var2.bJ()) {
                  return true;
               } else {
                  return var2.ak();
               }
            } else {
               return var1 == com.corrodinggames.rts.gameFramework.n.l.g ? false : false;
            }
         } else {
            return var2.bI() && var2.bJ() && !(var2 instanceof b)
                  && !(var2 instanceof com.corrodinggames.rts.game.units.d.g);
         }
      } else {
         return false;
      }
   }

   public void h(String var1) {
      com.corrodinggames.rts.gameFramework.GameEngine.log("Map Script: " + var1);
   }

   public void a(MapTrigger var1) {
      if (this.g()) {
         this.h("Activiated trigger:" + var1.a + " (id:" + var1.b + ")");
      }
   }

   public boolean g() {
      return a && com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bl;
   }

   public static void i(String var0) {
      NetworkEngine.g("Map ScriptError: " + var0);
   }

   public void a(int var1) {
      Iterator var2 = this.J.iterator();

      while (var2.hasNext()) {
         MapTrigger var3 = (MapTrigger) var2.next();
         if (var3.j && var3.q != -1 && var1 >= var3.k + var3.q) {
            var3.j = false;
            var3.u = false;
         }

         if (!var3.j && !var3.u && var3.d()) {
            var3.u = true;
         }

         if ((var3.j || var3.u) && var3.e.b()) {
            var3.j = false;
            var3.u = false;
            var3.m = true;
         }

         if (var3.j && var3.p > 0 && var1 >= var3.k + var3.p) {
            var3.u = true;
         }

         if (var3.u) {
            var3.u = false;

            try {
               com.corrodinggames.rts.gameFramework.n.TriggerExecutor.a(this, var3);
            } catch (com.corrodinggames.rts.game.b.MapLoadException var5) {
               var5.printStackTrace();
               var3.g("Error activating trigger: " + var5.getMessage());
            }
         }
      }

   }

   public boolean h() {
      boolean var1 = false;
      com.corrodinggames.rts.gameFramework.GameEngine var2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
      BaseUnit[] var3 = BaseUnit.bE.a();
      int var4 = 0;

      for (int var5 = BaseUnit.bE.size(); var4 < var5; ++var4) {
         BaseUnit var6 = var3[var4];
         if (var6.bX == com.corrodinggames.rts.game.PlayerTeam.i && var6 instanceof y && var6.bT() && !var6.o()) {
            int var7 = 0;

            for (int var8 = BaseUnit.bE.size(); var7 < var8; ++var7) {
               BaseUnit var9 = var3[var7];
               boolean var10;
               if (!var2.ay()) {
                  var10 = var9.bX == var2.bs;
               } else {
                  var10 = !var9.bX.w;
                  if (var6.cO()) {
                     var10 = true;
                  }
               }

               if (var9.bX != null && var9.bX.k < 0) {
                  var10 = false;
               }

               if (var10 && var9.bX != var6.bX && var9 instanceof y && !var9.i() && var9.bT()
                     && com.corrodinggames.rts.gameFramework.GameUtils.a(var9.posX, var9.posY, var6.posX,
                           var6.posY) < 28900.0F) {
                  var6.e(var9.bX);
                  var6.cJ = 60.0F;
                  var1 = true;
                  break;
               }
            }
         }
      }

      return var1;
   }
}
