/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import com.Element;
import com.ElementDocument;
import com.corrodinggames.librocket.scripts.Multiplayer$1;
import com.corrodinggames.librocket.scripts.Multiplayer$DropdownOption;
import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.librocket.scripts.Root$TableCell;
import com.corrodinggames.librocket.scripts.Root$TableData;
import com.corrodinggames.librocket.scripts.Root$TableRow;
import com.corrodinggames.librocket.scripts.ScriptContext;
import com.corrodinggames.librocket.scripts.ScriptEngine$Action;
import com.corrodinggames.rts.appFramework.i;
import com.corrodinggames.rts.appFramework.j;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.GameRoomSettings;
import com.corrodinggames.rts.gameFramework.j.GameModeType;
import com.corrodinggames.rts.gameFramework.j.TeamLayoutType;
import com.corrodinggames.rts.gameFramework.storage.a;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.al;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.Game;

public class Multiplayer
extends ScriptContext {
    Root root;
    String[] currentDropdownRawArray;
    Root$TableData lastPlayerTable;
    boolean useMapDropdown = false;

    Multiplayer(Root root) {
        this.root = root;
    }

   void updateMapDropdown(Element var1, String var2, String var3) {
      GameEngine var4 = GameEngine.getInstance();
      Element var5 = var1.getElementById(var3);
      int var6 = var5.getValueAsInt(0);
      this.currentDropdownRawArray = null;
      ArrayList var7 = new ArrayList();
      String[] var8;
      int var9;
      int var10;
      String var11;
      String var12;
      if (var6 == 0) {
         this.currentDropdownRawArray = a.a("maps/skirmish", true);
         Arrays.sort(this.currentDropdownRawArray);
         var8 = this.currentDropdownRawArray;
         var9 = var8.length;

         for(var10 = 0; var10 < var9; ++var10) {
            var11 = var8[var10];
            var12 = i.e(var11);
            var7.add(var12);
         }
      } else if (var6 == 1) {
         this.currentDropdownRawArray = a.a("/SD/rusted_warfare_maps", true);
         if (this.currentDropdownRawArray == null) {
            var4.a("Could not find folder: /SD/rusted_warfare_maps", 1);
            this.currentDropdownRawArray = new String[0];
         }

         Arrays.sort(this.currentDropdownRawArray);
         var8 = this.currentDropdownRawArray;
         var9 = var8.length;

         for(var10 = 0; var10 < var9; ++var10) {
            var11 = var8[var10];
            var12 = i.e(var11);
            var7.add(var12);
         }
      } else {
         if (var6 != 2) {
            throw new RuntimeException("Unknown typeIndex:" + var6);
         }

         this.currentDropdownRawArray = j.l();
         if (this.currentDropdownRawArray == null) {
            var4.a("Could not find a save folder on SD card", 1);
            this.currentDropdownRawArray = new String[0];
         }

         var8 = this.currentDropdownRawArray;
         var9 = var8.length;

         for(var10 = 0; var10 < var9; ++var10) {
            var11 = var8[var10];
            var12 = i.e(var11);
            var7.add(var12);
         }
      }

      String var18 = "";
      String var19 = "maps/skirmish";
      var10 = 0;
      int var20 = 1;
      String[] var21 = this.currentDropdownRawArray;
      int var13 = var21.length;

      int var14;
      String var15;
      for(var14 = 0; var14 < var13; ++var14) {
         var15 = var21[var14];
         ++var10;
         if (var6 == 0 && var15.equalsIgnoreCase("[p8]Many Islands (8p).tmx")) {
            var20 = var10;
         }
      }

      var10 = 0;
      var21 = this.currentDropdownRawArray;
      var13 = var21.length;

      for(var14 = 0; var14 < var13; ++var14) {
         var15 = var21[var14];
         ++var10;
         String var16 = this.root.convertMapName(var15);
         boolean var17 = var10 == var20;
         var18 = var18 + this.generateOption(var15, var16, var17) + "\n";
      }

      GameEngine.log("mapList:" + var18);
      if (var6 != 2) {
      }

      Element var22 = var1.getElementById("mapsSelectorParent");
      String var23 = "<p data-workaround='this stops disappearing select'></p><select id='mapsSelector' class='mapsSelector'><option value='0'>...</option></select>";
      var22.setInnerRML(var23);
      Element var24 = this.getMapDropdown();
      var24.setInnerRML(var18);
   }

    String generateOption(String string2, String string3, boolean bl2) {
        return this.generateOption(string2, string3, bl2, null, false);
    }

    String generateOption(String string2, String string3, boolean bl2, Integer n2, boolean bl3) {
        String string4 = "";
        if (bl2) {
            string4 = string4 + " selected='selected'";
        }
        String string5 = this.root.htmlString(string3);
        String string6 = "";
        if (n2 != null) {
            string6 = string6 + " style='color:" + GameUtils.h(n2) + ";'";
        }
        if (bl3) {
            string6 = string6 + " class='disabled-option'";
        }
        if (string6 != null && !"".equals(string6)) {
            string5 = "<span " + string6 + ">" + string5 + "</span>";
        }
        return "<option value=" + this.root.escapedString(string2) + " " + string4 + ">" + string5 + "</option>";
    }

    Element getMapDropdown() {
        ElementDocument elementDocument = this.libRocket.c();
        Element element = elementDocument.findByClassName("mapsSelector");
        return element;
    }

    String getMapDropdownSelected() {
        return this.getMapDropdown().getAttribute("value");
    }

    void readInterfaceIntoNetworkSettings() {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.networkEngine.C) {
            String string2 = this.getMapDropdownSelected();
            if (string2 == null) {
                string2 = "<No Map>";
            }
            l2.networkEngine.ay.b = string2;
            int n2 = 0;
            l2.networkEngine.ay.a = GameModeType.values()[n2];
        }
    }

    public void multiplayerStart() {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.networkEngine.C) {
            if (l2.networkEngine.ay.a == GameModeType.skirmishMap) {
                String string2;
                l2.networkEngine.az = string2 = "maps/skirmish/" + l2.networkEngine.ay.b;
            } else if (l2.networkEngine.ay.a == GameModeType.customMap) {
                l2.networkEngine.az = "/SD/rusted_warfare_maps/" + l2.networkEngine.ay.b;
            } else if (l2.networkEngine.ay.a == GameModeType.savedGame) {
                l2.networkEngine.az = null;
            } else {
                this.libRocket.c("Error: No map type selected");
                return;
            }
            if (l2.networkEngine.ay.b == null || "".equals(l2.networkEngine.ay.b) || l2.networkEngine.ay.b.equals("<No Map>")) {
                this.libRocket.c("Error: No map selected");
                return;
            }
            l2.networkEngine.ae();
        } else if (l2.networkEngine.H) {
            l2.networkEngine.k("-start");
        } else {
            GameEngine.b("startNetButton.setOnClickListener", "Clicked but not server or proxy controller");
        }
    }

    public void battleroomSetup() {
        GameEngine l2 = GameEngine.getInstance();
        this.lastPlayerTable = null;
        this.refreshUI();
        this.root.refreshChat();
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        if (elementDocument != null && l2.networkEngine.F) {
            elementDocument.addClass("singlePlayer");
        }
        l2.networkEngine.as();
    }

   public void refreshUI() {
      GameEngine var1 = GameEngine.getInstance();
      Element var2 = this.libRocket.getActiveElementById("infoDiv");
      if (var2 == null) {
         GameEngine.log("refreshUI: infoTextElement==null");
      } else {
         ElementDocument var3 = this.libRocket.getActiveDocument();
         boolean var4 = var1.networkEngine.C || var1.networkEngine.H;
         boolean var5 = var1.networkEngine.C;
         boolean var6 = !var4 && !var1.networkEngine.ay.m;
         Iterator var7 = var3.findElementsByClassName("forHostOnly").iterator();

         Element var8;
         while(var7.hasNext()) {
            var8 = (Element)var7.next();
            var8.show(var4);
         }

         var7 = var3.findElementsByClassName("forLocalHostOnly").iterator();

         while(var7.hasNext()) {
            var8 = (Element)var7.next();
            var8.show(var5);
         }

         var7 = var3.findElementsByClassName("forUnlockedTeamsNonHost").iterator();

         while(var7.hasNext()) {
            var8 = (Element)var7.next();
            var8.show(var6);
         }

         if (var1.P()) {
            var7 = var3.findElementsByClassName("forRealNetworkOnly").iterator();

            while(var7.hasNext()) {
               var8 = (Element)var7.next();
               var8.show(false);
            }
         }

         String var12 = var1.networkEngine.at();
         var2.compareAndSetText(var12);
         String var13 = var1.networkEngine.av();
         if (var1.networkEngine.ay.a == GameModeType.savedGame) {
            var13 = "saves/" + var1.networkEngine.ay.b;
         }

         Element var9 = this.libRocket.getActiveElementById("mapImage");
         if (var1.networkEngine.v) {
            var9.hide();
         }

         String var10 = var9.getAttribute("src");
         if (var13 == null) {
            if (!"".equals(var10)) {
               var9.setAttribute("src", "");
            }
         } else {
            String var11 = this.root.getMapThumbnail(var13);
            if (var11 == null) {
               var11 = "";
            }

            if (!var11.equals(var10)) {
               var9.setAttribute("src", var11);
            }
         }

         this.refreshPlayerTable();
      }
   }

    public void refreshPlayerTable() {
        Root$TableData root$TableData = this.getPlayerTable();
        String string2 = "playersDiv";
        if (this.lastPlayerTable != null) {
            if (this.lastPlayerTable.same(root$TableData, false)) {
                return;
            }
            if (this.lastPlayerTable.same(root$TableData, true)) {
                this.root.updateTableTextOnly(string2, root$TableData, this.lastPlayerTable);
                return;
            }
        }
        this.root.refreshTable(string2, root$TableData);
        this.lastPlayerTable = root$TableData;
    }

    public Root$TableData getPlayerTable() {
        Root$TableRow root$TableRow;
        Object object;
        GameEngine l2 = GameEngine.getInstance();
        Root$TableData root$TableData = new Root$TableData();
        ArrayList arrayList = root$TableData.rows;
        int n2 = -1;
        int n3 = 0;
        ArrayList arrayList2 = PlayerTeam.a(true);
        for (Object object2 : arrayList2) {
            if (object2 == null) continue;
            if (n2 != -1 && n2 != ((PlayerTeam)object2).r) {
                ++n3;
            }
            n2 = ((PlayerTeam)object2).r;
        }
        n2 = -1;
        for (Object object2 : arrayList2) {
            Object object3;
            if (object2 == null) continue;
            if (n2 != -1 && n2 != ((PlayerTeam)object2).r && n3 <= 3) {
                object = new Root$TableRow();
                for (int i2 = 0; i2 < 4; ++i2) {
                    object3 = ((Root$TableRow)object).addCell("");
                    ((Root$TableCell)object3).addClass("spacer");
                }
                arrayList.add(object);
            }
            n2 = ((PlayerTeam)object2).r;
            object = "unnamed";
            if (((PlayerTeam)object2).v != null) {
                object = ((PlayerTeam)object2).v;
            }
            String string2 = ((PlayerTeam)object2).z();
            object3 = Integer.toString(((PlayerTeam)object2).k + 1);
            boolean bl2 = ((PlayerTeam)object2).b();
            if (bl2) {
                object3 = "S";
            }
            if (!bl2 && ((PlayerTeam)object2).teamAIBehaviourOverride != null && ((PlayerTeam)object2).teamAIBehaviourOverride != l2.networkEngine.ay.g) {
                object3 = (String)object3 + " - " + l2.networkEngine.d(((PlayerTeam)object2).teamAIBehaviourOverride);
            }
            String string3 = ((PlayerTeam)object2).h();
            root$TableRow = new Root$TableRow();
            Root$TableCell root$TableCell = root$TableRow.addCell((String)object);
            if (((PlayerTeam)object2).C != null) {
                root$TableCell.color = PlayerTeam.i(((PlayerTeam)object2).C);
            }
            if (object2 == l2.networkEngine.z) {
                root$TableCell.addClass("boldText");
            }
            Root$TableCell root$TableCell2 = root$TableRow.addCell((String)object3);
            root$TableCell2.color = ((PlayerTeam)object2).M();
            Root$TableCell root$TableCell3 = root$TableRow.addCell(string3);
            root$TableCell3.color = PlayerTeam.i(((PlayerTeam)object2).r);
            root$TableRow.addCell(string2);
            root$TableRow.setLibrocketOnClick("mp.showPlayerConfig('" + ((PlayerTeam)object2).k + "')");
            arrayList.add(root$TableRow);
        }
        if (!l2.networkEngine.C && l2.networkEngine.S == null) {
            Object object2;
            arrayList.clear();
            Object object4 = "Connecting...";
            if (l2.networkEngine.aM.size() == 0) {
                object4 = "Disconnected";
            }
            root$TableRow = new Root$TableRow();
            root$TableRow.addCell((String)object4);
            object2 = root$TableRow.addCell("");
            object = root$TableRow.addCell("");
            root$TableRow.addCell("");
            arrayList.add(root$TableRow);
        }
        return root$TableData;
    }

    public void showSetTeamsDialog() {
        GameEngine l2 = GameEngine.getInstance();
        ElementDocument elementDocument=null;
        try {
            elementDocument = this.root.createAndShowPopup("battleroom_setTeams.rml", null, "Set Teams");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (elementDocument != null) {
            // empty if block
        }
    }

    public void showPlayerConfigForSelf() {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.networkEngine.z != null) {
            this.showPlayerConfig("" + l2.networkEngine.z.k);
        }
    }

    public void showPlayerConfig(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        ScriptEngine$Action action = this.scriptEngine.addRunnableToQueue(new Multiplayer$1(this, string2));
    }

    public void showPlayerConfigNow(String string2) throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        int n2 = Integer.parseInt(string2);
        PlayerTeam n3 = PlayerTeam.k(n2);
        if (n3 == null) {
            this.root.logWarn("showPlayerConfig: " + string2 + "==null");
            return;
        }
        if (!l2.networkEngine.aw() && (l2.networkEngine.z != n3 || l2.networkEngine.ay.m)) {
            return;
        }
        ElementDocument elementDocument = this.root.createAndShowPopup("battleroom_player.rml", n3, n3.v);
        if (elementDocument != null) {
            Element element = elementDocument.getElementById("team_id");
            Element element2 = elementDocument.getElementById("spawnPoint");
            Element element3 = elementDocument.getElementById("allyTeam");
            Element element4 = elementDocument.getElementById("aiDifficulty");
            Element element5 = elementDocument.getElementById("startingUnits");
            Element element6 = elementDocument.getElementById("playerColor");
            Element element7 = elementDocument.getElementById("playerOverridesSection");
            Element element8 = elementDocument.getElementById("aiDifficultySelection");
            if (!GameEngine.o("sd")) {
                this.setupStartingUnitDropDown(element5, true);
                this.setupPlayerColorDropDown(element6, true, true, n3);
            } else {
                GameEngine.log("sd");
            }
            element.setValue("" + n3.k);
            String string3 = "" + (n3.k + 1);
            if (n3.b()) {
                string3 = "-2";
            }
            element2.setValue(string3);
            if (n3.u) {
                element3.setValue("" + (n3.r + 1));
            } else {
                element3.setValue("fromSpawn2");
            }
            if (element7 == null) {
                throw new RuntimeException("playerOverridesSection==null");
            }
            if (!l2.networkEngine.C) {
                element7.hide();
            }
            if (element8 == null) {
                throw new RuntimeException("aiDifficultySelection==null");
            }
            if (!GameEngine.o("s1")) {
                if (n3.w) {
                    if (n3.z == null) {
                        element4.setValue("-99");
                    } else {
                        element4.setValue("" + n3.z);
                    }
                } else {
                    element8.hide();
                }
            } else {
                GameEngine.log("s1");
            }
            if (!GameEngine.o("s2")) {
                if (n3.teamAIBehaviourOverride == null) {
                    element5.setValue("-99");
                } else {
                    GameEngine.log("startingUnitOverride: " + n3.teamAIBehaviourOverride);
                    element5.setValue("" + n3.teamAIBehaviourOverride);
                }
            } else {
                GameEngine.log("s2");
            }
            if (!GameEngine.o("s3")) {
                if (n3.C == null) {
                    element6.setValue("-99");
                } else {
                    GameEngine.log("playerColor: " + n3.C);
                    element6.setValue("" + n3.C);
                }
            } else {
                GameEngine.log("s3");
            }
        }
    }

    public void teamsSet_apply() {
        GameEngine l2 = GameEngine.getInstance();
        if (!l2.networkEngine.C) {
            GameEngine.log("Not server");
            return;
        }
        GameEngine.log("playerConfig_kick");
        String string2 = this.libRocket.c().getElementById("teamLayout").getValue();
        if ("2t".equalsIgnoreCase(string2)) {
            l2.networkEngine.a(TeamLayoutType.layout_2sides);
        } else if ("3t".equalsIgnoreCase(string2)) {
            l2.networkEngine.a(TeamLayoutType.layout_3sides);
        } else if ("FFA".equalsIgnoreCase(string2)) {
            l2.networkEngine.a(TeamLayoutType.layout_ffa);
        } else if ("spectators".equalsIgnoreCase(string2)) {
            l2.networkEngine.a(TeamLayoutType.layout_spectators);
        } else {
            GameEngine.b("teamsSet_apply: unknown layout: " + string2);
        }
        this.refreshUI();
    }

    public void playerConfig_kick() {
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.log("playerConfig_kick");
        String string2 = this.libRocket.c().getElementById("team_id").getValue();
        int n2 = Integer.parseInt(string2);
        PlayerTeam n3 = PlayerTeam.k(n2);
        if (n3 == null) {
            this.root.logWarn("playerConfig_kick: " + string2 + "==null");
            return;
        }
        l2.networkEngine.e(n3);
    }

    public void playerConfig_apply() {
        int n2;
        Integer n3;
        boolean bl2;
        int n4;
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.log("playerConfig_kick");
        String string2 = this.libRocket.c().getElementById("team_id").getValue();
        int n5 = Integer.parseInt(string2);
        PlayerTeam n6 = PlayerTeam.k(n5);
        if (n6 == null) {
            this.root.logWarn("playerConfig_apply: " + string2 + "==null");
            return;
        }
        ElementDocument elementDocument = this.libRocket.c();
        Element element = elementDocument.getElementById("spawnPoint");
        Element element2 = elementDocument.getElementById("allyTeam");
        Element element3 = elementDocument.getElementById("aiDifficulty");
        Element element4 = elementDocument.getElementById("startingUnits");
        Element element5 = elementDocument.getElementById("playerColor");
        String string3 = element.getValue();
        String string4 = element2.getValue();
        int n7 = Integer.valueOf(string3) - 1;
        boolean bl3 = false;
        if (n7 == -3) {
            bl3 = true;
        } else {
            if (n7 < 0) {
                n7 = 1;
            }
            if (n7 > PlayerTeam.c - 1) {
                n7 = PlayerTeam.c - 1;
            }
        }
        boolean bl4 = false;
        if (bl3) {
            n4 = -3;
            bl2 = true;
        } else if (string4.equals("fromSpawn2")) {
            n4 = n7 % 2;
            n6.u = false;
            bl2 = true;
        } else {
            bl2 = false;
            n4 = n6.r;
            try {
                n4 = Integer.valueOf(string4) - 1;
            }
            catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
            n6.u = true;
        }
        if (n6.r != n4) {
            if (l2.networkEngine.C) {
                bl4 = true;
            } else if (l2.networkEngine.H || l2.networkEngine.z == n6) {
                bl4 = true;
            } else {
                GameEngine.b("row.setOnClickListener", "Clicked but not server or proxy controller");
            }
        }
        try {
            if (n6.k != n7) {
                if (l2.networkEngine.C) {
                    bl4 = false;
                    l2.networkEngine.a(n6, n7);
                    n6.r = n4;
                } else if (l2.networkEngine.H || l2.networkEngine.z == n6) {
                    bl4 = false;
                    int n8 = n4;
                    if (bl2) {
                        n8 = -1;
                    }
                    l2.networkEngine.a(n6, n7, (Integer)n8);
                } else {
                    GameEngine.b("row.setOnClickListener", "Clicked but not server or proxy controller");
                }
            }
        }
        catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
        }
        if (n6.w && n6.z != (n3 = (n2 = element3.getValueAsInt(-99).intValue()) == -99 ? null : Integer.valueOf(n2))) {
            if (l2.networkEngine.C) {
                n6.z = n3;
            } else {
                GameEngine.log("aiDifficultyOverride: not server or proxy controller");
            }
        }
        int n9 = element4.getValueAsInt(-99);
        GameEngine.log("startingUnits now: " + n9);
        n3 = n9 == -99 ? null : Integer.valueOf(n9);
        if (n6.teamAIBehaviourOverride != n3) {
            if (l2.networkEngine.C) {
                n6.teamAIBehaviourOverride = n3;
            } else {
                GameEngine.log("startingUnitOverride: not server or proxy controller");
            }
        }
        int n10 = element5.getValueAsInt(-99);
        GameEngine.log("playerColor now: " + n10);
        Integer n11 = n10 == -99 ? null : Integer.valueOf(n10);
        if (n6.C != n11) {
            if (l2.networkEngine.C) {
                n6.C = n11;
            } else {
                GameEngine.log("colorOverride: not server or proxy controller");
            }
        }
        if (bl4) {
            if (l2.networkEngine.C) {
                n6.r = n4;
            } else if (bl2) {
                l2.networkEngine.b(n6, -1);
            } else {
                l2.networkEngine.b(n6, n4);
            }
        }
        l2.networkEngine.f();
        l2.networkEngine.M();
        this.refreshUI();
    }

    public void disconnect(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.b(string2);
    }

    public void multiplayerBackPrompt() {
        String string2 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.multiplayerClose.title", new Object[0]);
        String string3 = "What would you like to do?";
        String string4 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.multiplayerClose.disconnectButton", new Object[0]) + ":";
        string4 = string4 + "closePopup(); mp.disconnect('exited'); back();";
        boolean bl2 = true;
        this.root.showPopup(string2, string3, bl2, string4, null);
    }

    public void surrenderPrompt() {
        String string2 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.surrender.title", new Object[0]);
        String string3 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.surrender.message", new Object[0]);
        String string4 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.surrender.surrenderButton", new Object[0]) + ":";
        string4 = string4 + "closePopup(); mp.surrender();";
        boolean bl2 = true;
        this.root.showPopup(string2, string3, bl2, string4, null);
    }

    public void surrender() {
        GameEngine.log("Surrender requested");
        this.root.sendChatMessage("-surrender");
    }

    public void multiplayerExitPrompt() {
        String string2 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.multiplayerClose.titleDisconnect", new Object[0]);
        String string3 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.multiplayerClose.messageDisconnect", new Object[0]);
        GameEngine l2 = GameEngine.getInstance();
        String string4 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.multiplayerClose.disconnectButton", new Object[0]) + ":";
        string4 = string4 + "closePopup(); mp.disconnect('exited'); showMainMenu();";
        String string5 = null;
        if (l2.networkEngine.C) {
            string2 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.multiplayerClose.title", new Object[0]);
            string3 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.multiplayerClose.messageEndGame", new Object[0]);
            string4 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.exitGame", new Object[0]) + ":";
            string4 = string4 + "closePopup(); mp.disconnect('exited'); showMainMenu();";
            string5 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.multiplayerClose.returnToBattleroom", new Object[0]) + ":";
            string5 = string5 + "closePopup(); mp.sendReturnToBattleroomEvent();";
        }
        boolean bl2 = true;
        this.root.showPopup(string2, string3, bl2, string4, string5);
    }

    public void sendReturnToBattleroomEvent() {
        GameEngine.log("mp.sendReturnToBattleroomEvent()");
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.ag();
        l2.bS.u = false;
    }

    public void addAI() {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.networkEngine.C) {
            l2.networkEngine.ap();
        } else if (l2.networkEngine.H) {
            l2.networkEngine.k("-addai");
        } else {
            this.root.logWarn("addAI(): Clicked but not server or proxy controller");
        }
    }

    public String _getRandomDefaultPlayerName() {
        return "Unnamed" + GameUtils.a(0, 999);
    }

    public void loadUsername() {
        GameEngine.log("mp.loadUsername()");
        GameEngine l2 = GameEngine.getInstance();
        String string2 = l2.bQ.lastNetworkPlayerName;
        Element element = this.libRocket.getActiveElementById("username");
        String string3 = com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine.a().c();
        GameEngine.log("steamName:" + string3);
        if (string3 != null && string2 == null) {
            string2 = string3;
        }
        if (string2 == null || "".equals(string2)) {
            string2 = this._getRandomDefaultPlayerName();
        }
        element.loadCharsetIfNeeded(string2);
        element.setAttribute("value", string2);
    }

    public void getUsernameFromInterface() {
        GameEngine l2 = GameEngine.getInstance();
        String string2 = this.root.getValueById("username");
        if (string2 == null) {
            GameEngine.b("getUsernameFromInterface: Cannot find username");
            return;
        }
        string2 = string2.trim();
        GameEngine.log("set username:" + string2);
        if (string2.equals("")) {
            string2 = this._getRandomDefaultPlayerName();
        }
        l2.networkEngine.a(string2);
    }

    public void gameOptionsGet() {
        this.gameOptionsGetOrPush(false);
    }

    public void gameOptionsPush() {
        this.gameOptionsGetOrPush(true);
    }

    public void gameOptionsRefreshTypes() {
        GameEngine l2 = GameEngine.getInstance();
        ElementDocument elementDocument = this.libRocket.c();
        if (this.useMapDropdown) {
            this.updateMapDropdown(elementDocument, "mapsSelector", "typeSelector");
        }
    }

    public void gameOptionsGetOrPush(boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        ElementDocument elementDocument = this.libRocket.c();
        Element element = elementDocument.getElementById("fogMode");
        Element element2 = elementDocument.getElementById("startingCredits");
        Element element3 = elementDocument.getElementById("incomeMultiplier");
        Element element4 = elementDocument.getElementById("noNukes");
        Element element5 = elementDocument.getElementById("sharedControl");
        Element element6 = elementDocument.getElementById("aiDifficulty");
        Element element7 = elementDocument.getElementById("startingUnits");
        if (!bl2) {
            this.setupStartingUnitDropDown(element7, false);
        }
        Element element8 = elementDocument.getElementById("typeSelector");
        Element element9 = this.getMapDropdown();
        if (!bl2) {
            if (l2.networkEngine.ay.a == null) {
                GameEngine.log("gameOptionsGetOrPush: game.network.setup.currentType==null");
            } else {
                element8.setValue("" + l2.networkEngine.ay.a.ordinal());
            }
            if (this.useMapDropdown) {
                this.updateMapDropdown(elementDocument, "mapsSelector", "typeSelector");
                element9 = this.getMapDropdown();
                GameEngine.log("new currentMapSelection=" + l2.networkEngine.ay.b);
                element9.setValue("" + l2.networkEngine.ay.b);
            }
            element8 = elementDocument.getElementById("typeSelector");
            element.setValue("" + l2.networkEngine.ay.d);
            element2.setValue("" + l2.networkEngine.ay.c);
            element7.setValue("" + l2.networkEngine.ay.g);
            l2.networkEngine.ay.e = true;
            element4.setCheckbox(l2.networkEngine.ay.i);
            element5.setCheckbox(l2.networkEngine.ay.l);
            element3.setValue("" + GameUtils.a(l2.networkEngine.ay.h, 1) + "x");
            element6.setValue("" + l2.networkEngine.ay.f);
            return;
        }
        GameRoomSettings ah2 = l2.networkEngine.e();
        if (ah2 != null) {
            String string2 = null;
            if (this.useMapDropdown && (string2 = element9.getValue()) == null) {
                GameEngine.log("gameOptionsGetOrPush: mapDropdownSelected==null");
                string2 = "<No Map>";
            }
            int n2 = element8.getValueAsInt(0);
            GameModeType ai2 = ah2.a;
            ah2.a = GameModeType.values()[n2];
            if (this.useMapDropdown) {
                ah2.b = string2;
            } else if (ai2 != ah2.a) {
                ah2.b = null;
            }
            ah2.d = element.getValueAsInt(null);
            ah2.c = element2.getValueAsInt(null);
            String string3 = element3.getValue();
            string3 = string3.replace("x", "");
            float f2 = 1.0f;
            try {
                f2 = Float.parseFloat(string3);
            }
            catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
            ah2.h = f2;
            ah2.i = element4.getCheckbox();
            ah2.l = element5.getCheckbox();
            ah2.f = element6.getValueAsInt(null);
            ah2.g = element7.getValueAsInt(1);
            l2.networkEngine.a(ah2);
        }
    }

    public void closeBattleroomIfOpen() {
        GameEngine l2 = GameEngine.getInstance();
        Element element = this.libRocket.getActiveElementById("battleroomPage");
        if (element == null) {
            GameEngine.log("closeBattleroomIfOpen: battleroomPage==null");
            return;
        }
        this.libRocket.backToLastDocument();
    }

    public void reinviteAsk() {
        String string2 = com.corrodinggames.rts.gameFramework.h.a.a("menus.ingame.multiplayerReinvite.title", new Object[0]);
        String string3 = "While in-game you can only reinvite players who were in-game before but dropped out";
        String string4 = "reInvite:";
        string4 = string4 + "closePopup(); mp.showSteamInviteDialog();";
        boolean bl2 = true;
        this.root.showPopup(string2, string3, bl2, string4, null);
    }

    public void showSteamInviteDialog() {
        com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine a2 = com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine.a();
        a2.g();
    }

    public void setMapFromPopup(String string2) {
        if (!this.isInControlOfServer()) {
            String string3 = this.root.getMapNameFromPath(string2);
            String string4 = "clicked on '" + string3 + "'";
            this.root.sendChatMessage(string4);
            this.root.closePopup();
            return;
        }
        GameEngine l2 = GameEngine.getInstance();
        GameRoomSettings ah2 = l2.networkEngine.e();
        if (ah2 != null) {
            String string5 = string2;
            if (!string5.contains("MOD|")) {
                string5 = GameUtils.k(string5);
            }
            ah2.b = string5;
            l2.networkEngine.a(ah2);
        }
        this.root.closePopup();
    }

    public void showMapSelect() {
        String string2 = this.root.getModeMapPath(null, null);
        try {
            this.root.showMapPopup(string2, "mp.setMapFromPopup");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isInControlOfServer() {
        GameEngine l2 = GameEngine.getInstance();
        boolean bl2 = l2.networkEngine.C || l2.networkEngine.H;
        return bl2;
    }

    public void askPassword() {
        GameEngine.log("mp.askPassword()");
        GameEngine l2 = GameEngine.getInstance();
        String string2 = "Password Required";
        String string3 = "This server requires a password to join";
        String string4 = "";
        this.root.showInputPopupNonClose(string2, string3, string4, "Close:mp.cancelPaswordAsk()", "[onenter]Join:mp.askPasswordEntered(getPopupText())");
    }

    public void askPasswordEntered(String string2) {
        GameEngine.log("mp.askPasswordEntered()");
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.n = string2;
        l2.networkEngine.X();
        this.root.closePopup();
    }

    public void cancelPaswordAsk() {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.networkEngine.C) {
            this.root.logWarn("cancelPaswordAsk: we are the server");
        } else {
            l2.networkEngine.b("Cancel password");
            this.closeBattleroomIfOpen();
        }
        this.root.closePopup();
    }

    public void setupStartingUnitDropDown(Element element, boolean bl2) {
        String string2 = "";
        if (bl2) {
            string2 = string2 + this.generateOption("-99", com.corrodinggames.rts.gameFramework.h.a.a("menus.settings.option.default", new Object[0]), false);
        }
        ArrayList<Multiplayer$DropdownOption> aaa = this.getStartingUnitOptions();
        for (Multiplayer$DropdownOption multiplayer$DropdownOption : aaa) {
            string2 = string2 + this.generateOption(multiplayer$DropdownOption.key, multiplayer$DropdownOption.value, false);
        }
        element.setInnerRML(string2);
    }

    public void setupPlayerColorDropDown(Element element, boolean bl2, boolean bl3, PlayerTeam n2) {
        GameEngine l2 = GameEngine.getInstance();
        String string2 = "";
        if (bl2) {
            string2 = string2 + this.generateOption("-99", com.corrodinggames.rts.gameFramework.h.a.a("menus.settings.option.default", new Object[0]), false);
        }
        for (int i2 = 0; i2 < 10; ++i2) {
            boolean bl4 = false;
            if (bl3 && l2.networkEngine.a(i2, n2)) {
                bl4 = true;
            }
            String string3 = PlayerTeam.j(i2);
            string3 = al.d(string3);
            int n3 = i2;
            int n4 = i2;
            if (bl4) {
                string3 = string3 + " (used)";
                n3 = -7829368;
                n4 = -99;
            }
            string2 = string2 + this.generateOption("" + n4, string3, false, PlayerTeam.i(n3), bl4);
        }
        element.setInnerRML(string2);
    }

    public ArrayList getStartingUnitOptions() {
        GameEngine l2 = GameEngine.getInstance();
        ArrayList<Multiplayer$DropdownOption> arrayList = new ArrayList<Multiplayer$DropdownOption>();
        List<Integer> aaa = l2.networkEngine.i();
        for (Integer n2 : aaa) {
            String string2 = l2.networkEngine.d(n2);
            arrayList.add(new Multiplayer$DropdownOption(n2.toString(), string2));
        }
        return arrayList;
    }
}

