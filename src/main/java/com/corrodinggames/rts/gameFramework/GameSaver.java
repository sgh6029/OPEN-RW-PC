/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.AIPlayer;
import com.corrodinggames.rts.game.e;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.custom.ag;
import com.corrodinggames.rts.game.units.custom.bd;
import com.corrodinggames.rts.game.units.h_f;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.aw;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.utility.o;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class GameSaver{ 
   public static boolean a = false;
   final boolean b;
   int c;
   int d;

   public GameSaver() {
      if (!GameEngine.as) {
         // empty if block
      }
      this.b = false;
      this.c = -9999;
      this.d = -9999;
   }

   public File a(String string2, boolean bl2) {
      return GameSaver.a(string2, "saves/", bl2);
   }

   public static File a(String string2, String string3, boolean bl2) {
      return com.corrodinggames.rts.gameFramework.storage.a.a(string2, string3, bl2);
   }

   /*
    * WARNING - Removed try catching itself - possible behaviour change.
    */
   public void b(String var1, boolean var2) {
      GameEngine var3 = GameEngine.getInstance();
      String var4 = var1;
      if (var1 != null && !var1.endsWith(".rwsave")) {
         var4 = var1 + ".rwsave";
      }

      String var5 = "SD card";
      File var6 = null;
      boolean var7 = false;

      String var9;
      try {
         var6 = this.a(var4 + ".tmp", true);
         if (var6.exists()) {
            var6 = this.a(var4 + ".tmp2", true);
         }

         File var8 = this.a(var4, true);
         var5 = var8.getAbsolutePath();
         GameEngine.log("Saving game to: " + var5);
         OutputStream var27 = com.corrodinggames.rts.gameFramework.storage.a.a(var6, false);
         BufferedOutputStream var28 = new BufferedOutputStream(var27);
         if (!a) {
            DataOutputStream var11 = new DataOutputStream(var28);
            GameOutputStream var12 = new GameOutputStream(var11);

            try {
               this.a(var12);
            } finally {
               var11.close();
               var28.close();
               var27.close();
            }
         } else {
            PrintStream var29 = new PrintStream(var28);
            aw var31 = new aw(var29);

            try {
               this.a((GameOutputStream) var31);
            } finally {
               var29.close();
               var28.close();
               var27.close();
            }

            GameEngine.n("DEBUG plain text save created");
         }

         boolean var30;
         if (var2 && GameEngine.at() && com.corrodinggames.rts.gameFramework.storage.a.i(var8.getAbsolutePath())) {
            GameEngine.log("Autosave file already exists: " + var8.getAbsolutePath());
            var30 = com.corrodinggames.rts.gameFramework.storage.a.b(var8);
            if (!var30) {
               GameEngine.log("Old autosave failed to delete");
            }
         }

         GameEngine.log("Finished writing save, renaming to final filename");
         var30 = com.corrodinggames.rts.gameFramework.storage.a.b(var6, var8);
         if (!var30) {
            GameEngine.log("Failed to rename to final file");
            throw new IOException("Failed to rename to final file. Check file permissions of storage.");
         }

         com.corrodinggames.rts.gameFramework.storage.a.c(var8);
         var7 = true;
      } catch (Exception var25) {
         if (var2) {
            GameEngine.log("Auto save failed: " + var25.getMessage());
            return;
         }

         var25.printStackTrace();
         var9 = GameUtils.b(var25);
         String var10 = "Error saving game, please check permissions, disk space, etc. (" + var9 + ")";
         var3.a(var10, 1);
         if (var6 != null && com.corrodinggames.rts.gameFramework.storage.a.i(var6.getAbsolutePath())) {
            GameEngine.log("saveGame: Removing temp save file after crash");
            com.corrodinggames.rts.gameFramework.storage.a.b(var6);
         }
      } catch (OutOfMemoryError var26) {
         var26.printStackTrace();
         var9 = "Error. Run out of memory error while saving game to " + var5 + ".";
         var3.a(var9, 1);
         if (var6 != null && com.corrodinggames.rts.gameFramework.storage.a.i(var6.getAbsolutePath())) {
            GameEngine.log("saveGame: Removing temp save file after crash");
            com.corrodinggames.rts.gameFramework.storage.a.b(var6);
         }
      }

      if (var7) {
         if (var2) {
            var3.bS.i.a("Auto Saved", 1000);
         } else {
            var3.bS.h.a((String) null, "Game saved");
         }
      }

   }

   /*
    * Enabled force condition propagation
    * Lifted jumps to return sites
    */

   public void a(GameOutputStream var1) throws IOException {
      GameEngine var2 = GameEngine.getInstance();
      long var3 = System.currentTimeMillis();
      GameEngine.b("GameSaver", "saveCurrentMap took:" + (System.currentTimeMillis() - var3));
      long var5 = System.currentTimeMillis();

      try {
         var1.writeUTF("rustedWarfareSave");
         int var7 = var2.getVersionCode(true);
         var1.a(var7);
         var1.a(96);
         var1.a(var2.isGamePaused);
         var1.a("saveCompression", true);
         var1.e("customUnitsBlock");
         com.corrodinggames.rts.game.units.custom.l.a(var1);
         var1.a("customUnitsBlock");
         var1.e("gameSetup");
         boolean var8 = var2.networkEngine.B || var2.networkEngine.F;
         var1.a(var2.networkEngine.B);
         var1.a(var2.networkEngine.F);
         var1.a(var8);
         if (var8) {
            var2.networkEngine.a(var1);
         }

         var1.a("gameSetup");
         var1.writeUTF(var2.menuBackgroundMapFile);
         boolean var9 = var2.dm != null;
         var1.a(var9);
         if (var9) {
            GameEngine.log("Writing remote map steam into save");
            var1.a(var2.dm);
         }

         var1.a(var2.by);
         var1.a(var2.cy + var2.cameraShakeDecay);
         var1.a(var2.cz + var2.cameraShakeTime);
         var1.a(var2.cV);
         var1.a(var2.bV.a);
         var1.a(0);
         var1.e();
         var2.bL.a(var1);
         var1.a(var2.bv);
         var1.a(var2.bL.E);
         var1.a(var2.bL.F);
         var1.a(var2.bL.G);
         var1.a(var2.ce != null);
         if (var2.ce != null) {
            var2.ce.a(var1);
         }

         var1.e();
         int var10 = -1;
         if (var2.bs != null) {
            var10 = var2.bs.k;
         }

         var1.a(var10);
         var1.a(PlayerTeam.c);

         int var11;
         PlayerTeam var12;
         for (var11 = 0; var11 < PlayerTeam.c; ++var11) {
            var12 = PlayerTeam.k(var11);
            var1.a(var12 instanceof com.corrodinggames.rts.game.a.AIController);
            var1.a(var12 instanceof AIPlayer);
            var1.a(var12 != null);
            if (var12 != null) {
               var12.b(var1);
            }
         }

         if (!var2.bS.e) {
         }

         var1.d("Section: unit shells");
         var1.a(GGameObject.fastGameObjectList.size());

         Iterator var16;
         GGameObject var17;
         String var18;
         for (var16 = GGameObject.fastGameObjectList.iterator(); var16.hasNext(); var1.a(var17.objectId)) {
            var17 = (GGameObject) var16.next();
            if (var17 == null) {
               throw new RuntimeException("Found null in fastGameObjectList");
            }

            if (var17 instanceof BaseUnit) {
               BaseUnit var13 = (BaseUnit) var17;
               if (var13.r() instanceof UnitTypeEnum) {
                  var1.c(1);
                  var1.a((Enum) var13.r());
               } else {
                  if (!(var13.r() instanceof com.corrodinggames.rts.game.units.custom.l)) {
                     throw new IOException("Unhandled getUnitType on save:" + var13.r().getClass().toString());
                  }

                  var1.c(3);
                  String var14 = ((com.corrodinggames.rts.game.units.custom.l) var13.r()).M;
                  var1.writeUTF(var14);
               }
            } else {
               var1.c(2);
               if (var17 instanceof com.corrodinggames.rts.game.l) {
                  var1.c(1);
               } else if (var17 instanceof com.corrodinggames.rts.game.f) {
                  var1.c(2);
               } else {
                  if (!(var17 instanceof com.corrodinggames.rts.gameFramework.effect.f)) {
                     var18 = null;
                     if (var17.getClass() != null) {
                        var18 = var17.getClass().toString();
                     }

                     throw new IOException("Unhandled class on save: " + var18);
                  }

                  var1.c(3);
               }
            }
         }

         var1.d("Section: CurrentUnitId");
         var1.a(var2.networkEngine.z());
         var2.bV.a(var1);
         var2.bS.a(var1);
         var2.bY.a(var1);

         for (var11 = 0; var11 < PlayerTeam.c; ++var11) {
            var12 = PlayerTeam.k(var11);
            if (var12 != null) {
               var12.a(var1);
            }
         }

         var1.e();
         var16 = GGameObject.fastGameObjectList.iterator();

         while (true) {
            if (!var16.hasNext()) {
               var1.a("saveCompression");
               var1.e();
               var1.writeUTF("<SAVE END>");
               break;
            }

            var17 = (GGameObject) var16.next();
            if (var1.f()) {
               var18 = var17.getClass().getSimpleName();
               if (var17 instanceof BaseUnit) {
                  var18 = ((BaseUnit) var17).r().i();
               }

               var1.d("Saving unit:" + var18 + " (id" + var17.objectId + ")");
            }

            var17.a(var1);
            var1.e();
         }
      } catch (IOException var15) {
         var15.printStackTrace();
         throw var15;
      }

      GameEngine.b("GameSaver", "saveGame took:" + (System.currentTimeMillis() - var5));
   }

   public String a(String string2) {
      if (string2 == null) {
         return null;
      }
      if (string2.equals("maps/normal/l010;mission_1__-__Dividing_River.tmx")) {
         return "maps/normal/l010;[demo]mission_1__-__Dividing_River.tmx";
      }
      if (string2.equals("maps/normal/l030;mission_3__-__Crossfire.tmx")) {
         return "maps/normal/l030;[demo]mission_3__-__Crossfire.tmx";
      }
      return string2;
   }

   /*
    * WARNING - Removed try catching itself - possible behaviour change.
    */
   public boolean c(String string2, boolean bl2) throws IOException {
      boolean bl3;
      GameEngine l2 = GameEngine.getInstance();
      File file = this.a(string2, false);
      if (file.isDirectory()) {
         l2.a("Could not load, is a directory", 1);
         return false;
      }
      AssetInputStream j2 = com.corrodinggames.rts.gameFramework.storage.a.k(file.getAbsolutePath());
      if (j2 == null) {
         l2.a("Could not load, failed to open: "
               + com.corrodinggames.rts.gameFramework.storage.a.d(file.getAbsolutePath()), 1);
         return false;
      }
      BufferedInputStream bufferedInputStream = new BufferedInputStream(j2);
      DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
      GameInputStream k2 = new GameInputStream(dataInputStream);
      try {
         bl3 = this.a(k2, bl2, false, false);
      } catch (Throwable throwable) {
         try {
            dataInputStream.close();
            bufferedInputStream.close();
            ((InputStream) j2).close();
            throw throwable;
         } catch (Exception exception) {
            throw new RuntimeException(exception);
         }
      }
      dataInputStream.close();
      bufferedInputStream.close();
      ((InputStream) j2).close();
      return bl3;
   }

   public void a(String string2, GameOutputStream as2) throws IOException {
      File file = this.a(string2, false);
      if (file == null) {
         throw new IOException("Failed to get game save: " + string2);
      }
      as2.a(file);
   }

   /*
    * WARNING - Removed try catching itself - possible behaviour change.
    * Enabled force condition propagation
    * Lifted jumps to return sites
    */

   public synchronized boolean a(GameInputStream var1, boolean var2, boolean var3, boolean var4) {
      GameEngine var5 = GameEngine.getInstance();

      Iterator var8;
      try {
         PerformanceProfiler var6 = var5.cd;
         if (this.b) {
            var6.a(ProfilerSection.y);
         }

         ArrayList var41 = null;
         if (var4) {
            var41 = new ArrayList();
            var8 = var5.bS.bZ.iterator();

            while (var8.hasNext()) {
               BaseUnit var43 = (BaseUnit) var8.next();
               var41.add(var43.objectId);
            }
         }

         String var10;
         String var42;
         try {
            var42 = var1.l();
         } catch (EOFException var37) {
            var37.printStackTrace();
            var10 = "Failed to load save. (End of file trying to read header)";
            GameEngine.b(var10);
            var5.a(var10, 1);
            return false;
         } catch (IOException var38) {
            var38.printStackTrace();
            var10 = "Failed to load save. (Failed to read header: " + var38.getMessage() + ")";
            GameEngine.b(var10);
            var5.a(var10, 1);
            return false;
         }

         if (!var42.equals("rustedWarfareSave")) {
            GameEngine.b("Map Load: Header is not correct:" + var42.substring(0, Math.min(var42.length(), 50)));
            String var45 = "Failed to load save. (Could not find correct header)";
            if (var42.equals("rustedWarfareReplay")) {
               var45 = "Failed to load save. (This file appears to be a replay file, not a save file)";
            }

            GameEngine.b(var45);
            var5.a(var45, 1);
            return false;
         } else {
            var1.readInt();
            int var44 = var1.readInt();
            GameEngine.b("gameSaver", "Loading save from version: " + var44);
            var1.a(var44);
            if (var44 > 96) {
               var5.a("Cannot load: This save was made with a newer game", 1);
               return false;
            } else {
               if (var44 >= 5) {
                  var1.e();
               }

               if (var44 >= 23) {
                  var6.a(ProfilerSection.B);
                  var1.a("saveCompression", true);
                  var6.b(ProfilerSection.B);
               }

               if (var44 >= 54) {
                  var1.b("customUnitsBlock");
                  if (var5.cb.j() && !var4) {
                     GameEngine.log("Loading mods from replay");

                     try {
                        com.corrodinggames.rts.game.units.custom.l.a(var1);
                        ag.d();
                     } catch (bd var36) {
                        GameEngine.log("Replay load: Missing unit:" + var36.getMessage() + " d:" + var36.b);
                        var5.i(var36.getMessage()
                              + ", this is likely to cause the replay to desync (reverting to default units & mods)");
                        ag.b(true);
                     }
                  }

                  var1.d("customUnitsBlock");
               }

               Integer var46 = null;
               Integer var11 = null;
               if (var5.cb.j() && var4) {
                  var46 = var5.bB;
                  var11 = var5.bC;
               }

               boolean var13;
               if (var44 >= 56) {
                  var1.b("gameSetup");
                  boolean var12 = var1.e();
                  var13 = var12;
                  boolean var14 = false;
                  if (var44 >= 94) {
                     var14 = var1.e();
                     var13 = var1.e();
                  }

                  boolean var15 = var5.cb.j() || !var5.networkEngine.B;
                  if (var15 && !var4 && var13) {
                     GameEngine.log("Using game rules from save");
                     var5.cb.O = true;
                     var5.networkEngine.a(var1);
                     var46 = var5.bB;
                     var11 = var5.bC;
                     if ((var12 || var14) && !var5.networkEngine.F && !var5.networkEngine.B && !var5.cb.j()) {
                        GameEngine.log("Enabling use of singlePlayer rules from saved game.");
                        var5.networkEngine.F = true;
                     }
                  }

                  var1.d("gameSetup");
               }

               var5.dm = null;
               String var47 = var1.l();
               var47 = com.corrodinggames.rts.gameFramework.storage.a.o(var47);
               var5.menuBackgroundMapFile = this.a(var47);
               var13 = false;
               if (var44 >= 72) {
                  var13 = var1.e();
                  if (var13) {
                     GameEngine.log("Reading remote map stream");
                     var5.dm = var1.u();
                  }
               }

               if (var5.networkEngine.B && !var5.networkEngine.C && var4 && var5.networkEngine.aB != null && !var13) {
                  var5.menuBackgroundMapFile = "";
                  var5.dm = var5.networkEngine.aB;
               }

               var6.a(ProfilerSection.z);
               if (var4) {
                  var5.initializeAndStartGame(true, true, GameMode.normalSave);
                  if (GameEngine.at()) {
                     var5.dv = true;
                  }
               } else {
                  var5.startGame(true, GameMode.normalSave);
               }

               if (!var5.bL.W) {
                  GameEngine.log("Not loading save because map failed to load");
                  return false;
               } else {
                  if (var46 != null) {
                     var5.bB = var46;
                  }

                  if (var11 != null) {
                     var11 = var5.bC;
                  }

                  synchronized (var5) {
                     var6.b(ProfilerSection.z);
                     var5.by = var1.readInt();
                     float var48 = var1.g();
                     float var16 = var1.g();
                     float var17 = var1.g();
                     if (!var4) {
                        var5.b(var48, var16);
                        var5.cV = var17;
                     }

                     if (var44 >= 18) {
                        var5.bV.a = var1.readInt();
                     }

                     var1.readInt();
                     if (var44 >= 19) {
                        var1.a("end of setup");
                     }

                     var5.bL.a(var1);
                     boolean var18;
                     if (var44 >= 86) {
                        var18 = var1.e();
                        boolean var19 = var1.e();
                        boolean var20 = var1.e();
                        boolean var21 = var1.e();
                        if (!var2 && !var18) {
                           var5.bL.E = var19;
                           var5.bL.F = var20;
                           var5.bL.G = var21;
                        }
                     }

                     var18 = var1.e();
                     if (var18) {
                        if (var5.ce == null) {
                           GameEngine.b("gameSaver", "making new mission engine on load, this shouldn't happen");
                           var5.ce = new com.corrodinggames.rts.gameFramework.n.MissionEngine();
                           var5.ce.a(false);
                        }

                        var5.ce.a(var1);
                     }

                     if (var44 >= 19) {
                        var1.a("start of teams");
                     }

                     GameEngine.b("gameSaver", "loading teams");
                     PlayerTeam[] var49 = new PlayerTeam[PlayerTeam.e];
                     int var50 = -1;
                     if (var44 >= 36) {
                        var50 = var1.readInt();
                     }

                     int var51 = 8;
                     int var22;
                     if (var44 >= 49) {
                        var51 = var1.readInt();
                        PlayerTeam.b(var51, false);

                        for (var22 = 0; var22 < PlayerTeam.c; ++var22) {
                           if (var22 >= var51 && !var2) {
                              PlayerTeam var23 = PlayerTeam.k(var22);
                              if (var23 != null) {
                                 var23.I();
                              }
                           }
                        }
                     }

                     Integer var28;
                     for (var22 = 0; var22 < var51; ++var22) {
                        Object var53 = PlayerTeam.k(var22);
                        Object var24 = var53;
                        boolean var25 = var1.e();
                        boolean var26 = false;
                        if (var44 >= 7) {
                           var26 = var1.e();
                        }

                        boolean var27 = var1.e();
                        if (var27) {
                           if (var25) {
                              if (var53 == null || !(var53 instanceof com.corrodinggames.rts.game.a.AIController)) {
                                 if (var2 && !var4 && var53 != null) {
                                    GameEngine.b("Would replace team:" + var22 + " with AI, writing to dummy AI");
                                    var53 = new com.corrodinggames.rts.game.a.AIController(var22, false);
                                    var49[var22] = (PlayerTeam) var53;
                                 } else {
                                    if (var4) {
                                       GameEngine.b("Adding new AI " + var22 + " on resync");
                                    }

                                    var53 = new com.corrodinggames.rts.game.a.AIController(var22);
                                 }
                              }
                           } else if (var26) {
                              if (var53 == null || !(var53 instanceof AIPlayer)) {
                                 if (var2) {
                                    GameEngine.b("Replacing team:" + var22 + " with NetworkedPlayer");
                                 }

                                 var53 = new AIPlayer(var22);
                              }
                           } else if (var53 == null || !(var53 instanceof e)) {
                              if (var2) {
                                 GameEngine.b("Replacing team:" + var22 + " with Player");
                                 if (var53 != null) {
                                    ((PlayerTeam) var53).c("Existing");
                                 }
                              }

                              var53 = new e(var22);
                           }

                           var28 = ((PlayerTeam) var53).z;
                           if (var44 >= 2) {
                              ((PlayerTeam) var53).b(var1);
                           } else {
                              ((PlayerTeam) var53).c(var1);
                           }

                           if (!var4) {
                              ((PlayerTeam) var53).i();
                              if (var2) {
                                 ((PlayerTeam) var53).z = var28;
                                 ((PlayerTeam) var53).c("networkLoad aiDifficultyOverride=" + var28);
                                 var5.networkEngine.a((PlayerTeam) var53);
                                 var5.networkEngine.b((PlayerTeam) var53);
                              }

                              if (var24 != null && var53 != var24) {
                                 ((PlayerTeam) var24).c("Transfering team stats");
                                 ((PlayerTeam) var24).o = ((PlayerTeam) var53).o;
                                 ((PlayerTeam) var24).V().a(((PlayerTeam) var53).V());
                              }
                           }
                        } else if (var2 && !var5.cb.j()) {
                           GameEngine.b("GameSaver: Would normally remove team:" + var22 + "");
                           var49[var22] = PlayerTeam.g;
                        } else {
                           PlayerTeam var64 = PlayerTeam.k(var22);
                           if (var64 != null) {
                              var64.I();
                           }
                        }
                     }

                     boolean var52 = false;
                     boolean var55 = false;
                     var5.networkEngine.aq();
                     if (var5.cb.j()) {
                        var5.bs = PlayerTeam.i;
                     } else {
                        int var54;
                        if (var5.networkEngine.B) {
                           if (var5.networkEngine.z != null) {
                              var54 = var5.networkEngine.z.k;
                              if (var54 != -3) {
                                 PlayerTeam var57 = PlayerTeam.k(var54);
                                 if (var57 == null) {
                                    throw new RuntimeException("GameSaver: Cannot relink player team: " + var54);
                                 }

                                 var5.bs = var57;
                              }
                           }
                        } else if (var50 != -1 && var50 != -3) {
                           var5.bs = PlayerTeam.k(var50);
                        } else {
                           for (var54 = 0; var54 < PlayerTeam.c; ++var54) {
                              if (PlayerTeam.k(var54) instanceof e) {
                                 var5.bs = PlayerTeam.k(var54);
                              }
                           }
                        }
                     }

                     o var56 = GGameObject.dK();
                     Iterator var58 = var56.iterator();

                     GGameObject var61;
                     while (var58.hasNext()) {
                        var61 = (GGameObject) var58.next();
                        var61.a();
                     }

                     if (var5.aa()) {
                        var56 = GGameObject.dK();
                        var58 = var56.iterator();

                        while (var58.hasNext()) {
                           var61 = (GGameObject) var58.next();
                           if (var61.objectId == 0L) {
                              if (var61 instanceof BaseUnit) {
                                 GameEngine.log("object: " + ((BaseUnit) var61).c());
                              }

                              throw new RuntimeException("GameLoad preload: Found object in list with id:0");
                           }
                        }
                     }

                     boolean var59 = false;
                     int var60 = var1.readInt();

                     int var63;
                     int var67;
                     for (var63 = 0; var63 < var60; ++var63) {
                        Object var62 = null;
                        byte var66 = var1.d();
                        if (var66 == 1) {
                           UnitTypeEnum var69 = (UnitTypeEnum) var1.b(UnitTypeEnum.class);
                           if (var69 == UnitTypeEnum.editorOrBuilder) {
                              if (!var5.cb.j() && !var5.bv) {
                                 GameEngine.log("Creating DebugEditorBuilder for load");
                                 var62 = new h_f(false);
                                 var52 = true;
                              } else {
                                 GameEngine.log("Creating DebugEditorBuilder for replay");
                                 var62 = new h_f(false);
                                 h_f var78 = var5.bS.i();
                                 if (var78 == null || var78.ej) {
                                    GameEngine.log("Relinking editor");
                                    var5.bS.a((h_f) var62);
                                 }
                              }
                           } else {
                              var62 = var69.createUnitInstance();
                           }
                        } else if (var66 == 3) {
                           String var29 = var1.l();
                           com.corrodinggames.rts.game.units.custom.l var30 = com.corrodinggames.rts.game.units.custom.l
                                 .n(var29);
                           if (var30 == null) {
                              String var31 = "Could not find custom unit:" + var29;
                              GameEngine.log(var31);
                              if (!var59) {
                                 var59 = true;
                                 NetworkEngine.g(var31);
                              }

                              var30 = com.corrodinggames.rts.game.units.custom.l.b;
                              if (var30 == null) {
                                 throw new RuntimeException(
                                       "Could not find custom unit:" + var29 + " and missingPlaceHolder is null");
                              }
                           }

                           com.corrodinggames.rts.game.units.UnitType var77 = com.corrodinggames.rts.game.units.custom.l
                                 .c(var30);
                           if (var77 != null) {
                              if (var77 instanceof com.corrodinggames.rts.game.units.custom.l) {
                                 var30 = (com.corrodinggames.rts.game.units.custom.l) var77;
                              } else {
                                 GameEngine.b("replacement not a custom unit:" + var77.i());
                              }
                           }

                           var62 = var30.createUnitInstance();
                        } else {
                           if (var66 != 2) {
                              throw new IOException("Unhandled basic type on load:" + var66);
                           }

                           var67 = var1.d();
                           if (var67 == 1) {
                              var62 = new com.corrodinggames.rts.game.l();
                           } else if (var67 == 2) {
                              var62 = new com.corrodinggames.rts.game.f(false);
                           } else {
                              if (var67 != 3) {
                                 throw new IOException("Unhandled gameType on load:" + var67);
                              }

                              var62 = new com.corrodinggames.rts.gameFramework.effect.f(var5.bR);
                           }
                        }

                        ((GGameObject) var62).objectId = var1.i();
                        if (((GGameObject) var62).objectId == 0L) {
                           GameEngine.b("GameSaver: Adding object with id==0");
                           if (var62 instanceof BaseUnit) {
                              GameEngine.b(((BaseUnit) var62).cC());
                           }

                           var55 = true;
                        }

                        GGameObject.dL();
                     }

                     if (var44 >= 3) {
                        long var65 = var1.i();
                        if (var65 <= 0L) {
                           GameEngine.a("GameLoad: Trying to set next unit id <= 0: " + var65);
                           var65 = 100000L;
                        }

                        var5.networkEngine.a(var65);
                     } else {
                        var5.networkEngine.a(100000L);
                     }

                     if (var44 >= 24) {
                        var5.bV.a(var1);
                     }

                     if (var44 >= 4) {
                        var5.bS.a(var1, var4);
                     }

                     if (var44 >= 57) {
                        var5.bY.a(var1, var4);
                     }

                     if (var44 >= 7) {
                        for (var63 = 0; var63 < var51; ++var63) {
                           PlayerTeam var74 = PlayerTeam.k(var63);
                           if (var49[var63] != null) {
                              var74 = var49[var63];
                              if (var74 == PlayerTeam.g) {
                                 var74 = null;
                              }
                           }

                           if (var74 != null) {
                              var28 = var74.z;
                              var74.c(var1);
                              if (!var4) {
                                 if (var2) {
                                    var74.z = var28;
                                    var74.c("networkLoad2 aiDifficultyOverride=" + var28);
                                 }

                                 var5.networkEngine.a(var74);
                                 var5.networkEngine.b(var74);
                              }
                           }
                        }
                     } else if (var44 >= 2) {
                     }

                     if (var44 >= 10) {
                        var1.a("Pre-unit data");
                     }

                     var6.a(ProfilerSection.A);
                     o var71 = GGameObject.dK();
                     GameEngine.b("gameSaver", "Loading unit data for " + var71.size() + " objects.");
                     Iterator var79 = var71.iterator();

                     while (var79.hasNext()) {
                        GGameObject var68 = (GGameObject) var79.next();
                        var68.a(var1);
                        if (var44 >= 10) {
                           var1.a("post unit: " + var68.getClass().toString() + " with id:" + var68.objectId);
                        }
                     }

                     GameEngine.b("gameSaver", "Loading unit data done.");
                     var6.b(ProfilerSection.A);
                     BaseUnit var82;
                     if (var52) {
                        o var81 = GGameObject.dK();
                        Iterator var70 = var81.iterator();

                        while (var70.hasNext()) {
                           GGameObject var72 = (GGameObject) var70.next();
                           if (var72 instanceof BaseUnit) {
                              var82 = (BaseUnit) var72;
                              if (!var5.cb.j() && !var5.bv && var82.r() == UnitTypeEnum.editorOrBuilder) {
                                 var82.ci();
                              }
                           }
                        }
                     }

                     if (var44 >= 23) {
                        var1.d("saveCompression");
                     }

                     if (var44 >= 19) {
                        var1.a("End of Save");
                        var1.l();
                     }

                     GameEngine.b("gameSaver", "Checking for ID overlaps");
                     int var83 = 0;
                     boolean var73 = true;
                     if (var73) {
                        GGameObject[] var75 = GGameObject.fastGameObjectList.a();
                        int var84 = GGameObject.fastGameObjectList.size();

                        for (int var80 = 0; var80 < var84; ++var80) {
                           GGameObject var32 = var75[var80];
                           if (var32.objectId == 0L) {
                              GameEngine.b("GameSaver: Fixing object with zero id.");
                              var32.objectId = var5.networkEngine.y();
                           }

                           for (int var33 = var80 + 1; var33 < var84; ++var33) {
                              GGameObject var34 = var75[var33];
                              if (var32 != var34 && var32.objectId == var34.objectId) {
                                 ++var83;
                                 var34.objectId = var5.networkEngine.y();
                              }
                           }
                        }
                     }

                     GameEngine.b("gameSaver", "clearing out dead units.");
                     GameEngine.log("Unit.fastLiveUnitList before:" + BaseUnit.bE.size());
                     Iterator var76 = BaseUnit.bE.iterator();

                     while (var76.hasNext()) {
                        var82 = (BaseUnit) var76.next();
                        if (var82.bV) {
                           var76.remove();
                        }
                     }

                     GameEngine.log("Unit.fastLiveUnitList after:" + BaseUnit.bE.size());
                     if (var83 > 0) {
                        if (var44 <= 2) {
                           var5.a("Warning: " + var83
                                 + " errors were found in this save, this is due to a bug in the old version", 1);
                        } else {
                           var5.a("Warning: " + var83 + " errors were found in this save", 1);
                        }
                     }

                     GameEngine.b("gameSaver", "Fixing map cost.");
                     var5.bU.a((com.corrodinggames.rts.game.units.y) null);
                     var5.bU.b();
                     GameEngine.b("gameSaver", "Fixing map cost done.");
                     PlayerTeam.O();

                     PlayerTeam var89;
                     for (var67 = 0; var67 < PlayerTeam.c; ++var67) {
                        var89 = PlayerTeam.k(var67);
                        if (var89 != null) {
                           var89.d(false);
                        }
                     }

                     PlayerTeam.e();
                     GameEngine.b("gameSaver", "Rebuilt unit caches");
                     PlayerTeam.O();
                     PlayerTeam.Y();
                     PlayerTeam.i.d(false);
                     PlayerTeam.h.d(false);

                     for (var67 = 0; var67 < PlayerTeam.c; ++var67) {
                        var89 = PlayerTeam.k(var67);
                        if (var89 != null && var89 instanceof com.corrodinggames.rts.game.a.AIController) {
                           com.corrodinggames.rts.game.a.AIController var85 = (com.corrodinggames.rts.game.a.AIController) var89;
                           var85.aq();
                        }
                     }

                     if (var41 != null) {
                        var5.bS.y();
                        var76 = var41.iterator();

                        while (var76.hasNext()) {
                           long var90 = (Long) var76.next();
                           BaseUnit var86 = GGameObject.a(var90, true);
                           if (var86 != null) {
                              var5.bS.k(var86);
                           }
                        }
                     }

                     if (var5.aa()) {
                        o var87 = GGameObject.dK();
                        Iterator var91 = var87.iterator();

                        while (var91.hasNext()) {
                           GGameObject var88 = (GGameObject) var91.next();
                           if (var88.objectId == 0L) {
                              if (var88 instanceof BaseUnit) {
                                 GameEngine.log("object: " + ((BaseUnit) var88).c());
                              }

                              throw new RuntimeException("GameLoad postload: Found object in list with id:0");
                           }
                        }
                     }

                     GameEngine.log("--- Save file load complete ---");
                     GameEngine.log("GGameObject.fastGameObjectList:" + GGameObject.fastGameObjectList.size());
                     GameEngine.log("Unit.fastLiveUnitList:" + BaseUnit.bE.size());
                     if (!var4) {
                        var5.cb.a(var4);
                     }

                     if (this.b) {
                        var6.b(ProfilerSection.y);
                        var6.a(true, true);
                     }

                     return true;
                  }
               }
            }
         }
      } catch (Exception var40) {
         var40.printStackTrace();
         GameEngine.log("Save load error, clearing all units");
         o var7 = GGameObject.dK();

         GGameObject var9;
         for (var8 = var7.iterator(); var8.hasNext(); var9.a()) {
            var9 = (GGameObject) var8.next();
            if (var9.objectId == 0L) {
               var9.objectId = var5.networkEngine.y();
            }
         }

         throw new RuntimeException(var40);
      }
   }

   public boolean b(String string2) {
      GameEngine.log("Deleting: " + string2);
      String string3 = com.corrodinggames.rts.gameFramework.storage.a.o(string2);
      if (string3.contains("\\") || string3.contains("/")) {
         GameEngine.log("Cannot get save with path: " + string2);
         return false;
      }
      File file = this.a(string2, true);
      boolean bl2 = com.corrodinggames.rts.gameFramework.storage.a.b(file);
      File file2 = this.a(string2 + ".map", true);
      com.corrodinggames.rts.gameFramework.storage.a.b(file2);
      if (!bl2) {
         GameEngine.log("Failed to delete: " + file.getAbsolutePath());
         GameEngine.getInstance().i("Failed to delete: " + file.getAbsolutePath());
      }
      return true;
   }

   public void a(boolean bl2) {
      GameEngine l2 = GameEngine.getInstance();
      if (!bl2) {
         this.c = -9999;
         this.d = -9999;
      }
   }

   public boolean a() {
      GameEngine l2 = GameEngine.getInstance();
      if (!l2.bQ.autosaving) {
         return false;
      }
      if (GameEngine.ax()) {
         return false;
      }
      if (!l2.loadNewGame || l2.bH || l2.cb.j()) {
         return false;
      }
      return !l2.M();
   }

   public void b() {
      int n2 = 300000;
      GameEngine l2 = GameEngine.getInstance();
      if (!this.a()) {
         return;
      }
      if (this.d == -9999) {
         this.c = l2.by;
         this.d = l2.by;
      }
      if (this.d + n2 < l2.by) {
         this.d = l2.by;
         long l3 = PerformanceProfiler.a();
         this.c();
         double d2 = PerformanceProfiler.a(l3);
         GameEngine.log("Autosaved (" + PerformanceProfiler.a(d2) + ")");
      }
   }

   public void c() {
      this.b("autosave", true);
   }
}
