/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import com.Element;
import com.ElementDocument;
import com.corrodinggames.librocket.scripts.Mods$1;
import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.librocket.scripts.ScriptContext;
import com.corrodinggames.rts.game.units.custom.ag;
import com.corrodinggames.rts.gameFramework.GameUtils;//f
import com.corrodinggames.rts.gameFramework.i.b;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class Mods
extends ScriptContext {
    Root root;
    Runnable updateModsRunnable = new Mods$1(this);
    int checkWorkshopSkip = 0;

    Mods(Root root) {
        this.root = root;
    }

    public DisabledSteamEngine getSteam() {
        DisabledSteamEngine a2 = DisabledSteamEngine.a();
        if (!a2.e()) {
            a2.h();
            return null;
        }
        return a2;
    }

    public void openWorkshop() {
        GameEngine l2 = GameEngine.getInstance();
        DisabledSteamEngine a2 = this.getSteam();
        if (a2 == null) {
            return;
        }
        a2.m();
    }

    public void uploadModAsk(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.isBetaVersion()) {
            this.root.showAlert("Workshop uploading is disabled in BETA versions to ensure compatibility for others. Please test and upload this mod with a released version or wait till beta finishes.");
            return;
        }
        b b2 = l2.bZ.c(string2);
        if (b2 == null) {
            this.root.showAlert("Could not find mod:" + string2);
            return;
        }
        DisabledSteamEngine a2 = this.getSteam();
        if (a2 == null) {
            return;
        }
        String string3 = "Are you sure you want to upload to the workshop?";
        String string4 = "";
        String string5 = "[onenter]Upload:";
        string5 = string5 + "closePopup(); mods.uploadMod('" + string2 + "');";
        boolean bl2 = true;
        this.root.showPopup(string3, string4, bl2, string5, null);
    }

    public void uploadMod(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        b b2 = l2.bZ.c(string2);
        if (b2 == null) {
            this.root.showAlert("Could not find mod:" + string2);
            return;
        }
        DisabledSteamEngine a2 = this.getSteam();
        if (a2 == null) {
            return;
        }
        if (b2.k == 0L) {
            a2.b(b2);
            return;
        }
        String string3 = "Changes.";
        a2.a(b2, false, string3);
    }

    public void viewMod(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        b b2 = l2.bZ.c(string2);
        if (b2 == null) {
            this.root.showAlert("Could not find mod:" + string2);
            return;
        }
        DisabledSteamEngine a2 = this.getSteam();
        if (a2 == null) {
            return;
        }
        a2.a(b2);
    }

    public void deleteModPopup(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        b b2 = l2.bZ.c(string2);
        if (b2 == null) {
            this.root.showAlert("Could not find mod:" + string2);
            return;
        }
        String string3 = "";
        String string4 = "Are you sure you want to permanently delete '" + b2.b() + "'? (Note: You can instead disable the mod by unticking it)";
        String string5 = "[onenter]Delete:";
        string5 = string5 + "closePopup(); mods.deleteMod('" + string2 + "');";
        boolean bl2 = true;
        this.root.showPopup(string3, string4, bl2, string5, null);
    }

    public void deleteMod(String string2) throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        b b2 = l2.bZ.c(string2);
        if (b2 == null) {
            this.root.showAlert("Could not find mod:" + string2);
            return;
        }
        boolean bl2 = b2.u();
        if (bl2) {
            this.reloadModData();
        } else {
            this.root.showAlert("Error failed to delete mod");
        }
    }

    public void setModFilter(String string2) {
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        if (elementDocument == null) {
            GameEngine.log("loadMods: No Active Document");
            return;
        }
        elementDocument.setMetadata("modFilter", string2);
        this.applyModFilter();
    }

   public void applyModFilter() {
      GameEngine var1 = GameEngine.getInstance();
      ElementDocument var2 = this.libRocket.getActiveDocument();
      if (var2 == null) {
         GameEngine.log("loadMods: No Active Document");
      } else {
         String var3 = (String)var2.getMetadata("modFilter");
         Element var4 = var2.getElementById("modList");
         if (var4 == null) {
            GameEngine.log("loadMods: Failed to find modList, wrong page?");
         } else {
            Element var5 = var2.getElementById("onlyEnabledMods");
            boolean var6 = var5.getCheckbox();
            ArrayList var7 = var4.findElementsByClassName("modItem");
            if (var3 == null || var3.trim().equals("")) {
               var3 = null;
            }

            if (var3 != null) {
               var3 = var3.toLowerCase(Locale.ROOT).trim();
            }

            int var8 = 0;
            int var9 = 0;
            Iterator var10 = var7.iterator();

            Element var11;
            while(var10.hasNext()) {
               var11 = (Element)var10.next();
               boolean var12 = false;
               String var13 = var11.getAttribute("data_sessionid");
               int var14 = GameUtils.l(var13);
               b var15 = var1.bZ.a(var14);
               if (var15 == null) {
                  GameEngine.log("Could not find mod with mod session id: " + var14);
               } else {
                  if (var3 != null) {
                     boolean var16 = false;
                     if (var15.a() != null && var15.a().toLowerCase(Locale.ROOT).contains(var3)) {
                        var16 = true;
                     }

                     if (var15.e() != null && var15.e().toLowerCase(Locale.ROOT).contains(var3)) {
                        var16 = true;
                     }

                     if (!var16) {
                        var12 = true;
                     }
                  }

                  if (var6 && var15.f) {
                     var12 = true;
                  }
               }

               if (var12) {
                  ++var8;
                  var11.compareAndAddClass("modItemFilteredOut");
               } else {
                  ++var9;
                  var11.removeClass("modItemFilteredOut");
               }
            }

            String var17 = "";
            if (var8 > 0 && var9 == 0) {
               var17 = "< No mods found with active filter (" + var8 + " hidden) >";
            } else if (var8 > 0) {
               var17 = "< " + var8 + " mods hidden with active filter >";
            }

            var11 = var2.getElementById("filterStatus");
            var11.setText(var17);
         }
      }
   }

    public void updateMods() {
        ++this.checkWorkshopSkip;
        if (this.checkWorkshopSkip > 100) {
            this.checkWorkshopSkip = 0;
            DisabledSteamEngine a2 = DisabledSteamEngine.a();
            if (a2 != null) {
                a2.k();
            }
        }
    }

    public void refreshModList() {
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        if (elementDocument == null) {
            GameEngine.log("refreshModList: No Active Document");
            return;
        }
        GameEngine.log("refreshModList");
        Element element = elementDocument.getElementById("modTemplate");
        if (element == null) {
            GameEngine.log("refreshModList: Failed to find modTemplate, wrong page?");
            return;
        }
        GameEngine l2 = GameEngine.getInstance();
        l2.bZ.d();
        this._rememberTempModSelection();
        this.loadMods();
        this._restoreTempModSelection();
    }

    public void loadMods() {
        Object object;
        GameEngine l2 = GameEngine.getInstance();
        ArrayList<b> arrayList = l2.bZ.k();
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        if (elementDocument == null) {
            GameEngine.log("loadMods: No Active Document");
            return;
        }
        GameEngine.log("loadMods");
        Element element = elementDocument.getElementById("modTemplate");
        Element element2 = elementDocument.getElementById("modList");
        if (element == null) {
            GameEngine.log("loadMods: Failed to find modTemplate, wrong page?");
            return;
        }
        if (element2 == null) {
            GameEngine.log("loadMods: Failed to find modList, wrong page?");
            return;
        }
        this.root.setDocumentUpdate(elementDocument, this.updateModsRunnable);
        String string2 = element.getInnerRML();
        String string3 = "";
        int n2 = 0;
        for (b b2 : arrayList) {
            String string4;
            object = string2;
            String string5 = b2.a();
            String string6 = "";
            object = ((String)object).replace("_NAME_", this.root.htmlString(string5));
            object = ((String)object).replace("_ID_", b2.e);
            String string7 = b2.R;
            if (string7 == null) {
                string7 = "";
            } else {
                string6 = string6 + " modItemError";
            }
            if (b2.v()) {
                string6 = string6 + " modItemCanBeDeleted";
            }
            if (b2.k == 0L) {
                if (!b2.y && !b2.z) {
                    string6 = string6 + " modItemCanBePublished";
                }
            } else {
                if (!b2.y) {
                    string6 = string6 + " modItemIsOwner";
                }
                string6 = string6 + " modItemIsPublished";
            }
            if (b2.A) {
                string6 = string6 + " modItemHasMaps";
            }
            if ((string4 = b2.l()) == null) {
                string4 = "";
            }
            String string8 = b2.e();
            object = ((String)object).replace("_ERROR_", this.root.htmlString(string7));
            object = ((String)object).replace("_MESSAGE_", this.root.htmlStringWithNewlines(string4));
            object = ((String)object).replace("_DESCRIPTION_", this.root.htmlString(string8));
            object = ((String)object).replace("_CLASS_", string6);
            object = ((String)object).replace("_SESSIONID_", "" + b2.d());
            ++n2;
            string3 = string3 + (String)object;
        }
        element2.setInnerRML(string3);
        element2.loadCharsetIfNeeded(string3);
        for (b b2 : arrayList) {
            object = elementDocument.getElementById(b2.e);
            if (object == null) {
                GameEngine.b("Could not find:" + b2.c);
                continue;
            }
            ((Element)object).setCheckbox(!b2.f);
        }
        this.applyModFilter();
    }

    public void saveMods() {
        this._saveModsCommon(true);
    }

    private void _rememberTempModSelection() {
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.log("temp save");
        ArrayList<Element> arrayList = elementDocument.findElementsByClassName("modSelection");
        boolean bl2 = false;
        for (Element element : arrayList) {
            boolean bl3;
            String string2 = element.getId();
            if (string2.equals("_ID_")) continue;
            b b2 = l2.bZ.c(string2);
            if (b2 == null) {
            GameEngine.a("Could not find mod:" + element.getInnerRML());
                continue;
            }
            boolean bl4 = bl3 = !element.getCheckbox();
            if (b2.g != bl3) {
                bl2 = true;
            }
            b2.g = bl3;
            b2.h = true;
        }
    }

    private void _restoreTempModSelection() {
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.log("temp restore");
        ArrayList<Element> arrayList = elementDocument.findElementsByClassName("modSelection");
        boolean bl2 = false;
        for (Element element : arrayList) {
            boolean bl3;
            String string2 = element.getId();
            if (string2 == null || string2.equals("") || string2.equals("_ID_")) continue;
            b b2 = l2.bZ.c(string2);
            if (b2 == null) {
                GameEngine.a("Could not find mod:" + element.getInnerRML() + " id:" + string2);
                continue;
            }
            if (!b2.h || b2.g == (bl3 = !element.getCheckbox())) continue;
            bl2 = true;
            element.setCheckbox(!b2.g);
        }
    }

    private void _saveModsCommon(boolean bl2) {
        boolean bl3 = false;
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.log("savesMods");
        ArrayList<Element> arrayList = elementDocument.findElementsByClassName("modSelection");
        for (Element element : arrayList) {
            boolean bl4;
            String string2 = element.getId();
            if (string2.equals("_ID_")) continue;
            b b2 = l2.bZ.c(string2);
            if (b2 == null) {
                this.root.showAlert("Could not find mod:" + element.getInnerRML());
                continue;
            }
            boolean bl5 = bl4 = !element.getCheckbox();
            if (b2.f != bl4) {
                bl3 = true;
            }
            b2.f = bl4;
            b2.g = bl4;
        }
        if (bl3) {
            GameEngine.log("mod changes made");
        } else {
            GameEngine.log("no mod changes made");
        }
        l2.bZ.e();
        l2.bQ.save();
        if (bl2) {
            this._saveModsMessages(false);
        }
    }

    private void _saveModsMessages(boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        int n2 = l2.bZ.a(false);
        int n3 = l2.bZ.b();
        if (l2.networkEngine.B) {
        GameEngine.log("savesMods: in network game");
            this.root.showAlert("You are currently in a network game, changes will be checked and applied on next game");
        } else if (ag.c(true)) {
            if (n2 == 0) {
                this.root.showAlert("Mod changes saved. Will be used in the next game.");
            } else if (bl2) {
                String string2 = "Note: " + n2 + " selected mods are still not loaded after reload";
                if (n3 > 0) {
                    string2 = "Warning: " + n3 + " selected mods had errors after reload";
                }
                this.root.showAlert(string2);
            } else {
                String string3 = "Reload needed";
                String string4 = "Mod selection saved. But " + n2 + " mod(s) aren't loaded. Load them now?";
                if (!l2.I()) {
                    string4 = string4 + " (This will end your current game).";
                }
                String string5 = "[onenter]Reload:";
                string5 = string5 + "closePopup(); mods.reloadModData();";
                boolean bl3 = true;
                this.root.showPopup(string3, string4, bl3, string5, null);
            }
        } else {
            GameEngine.log("Errors found");
        }
    }

    public void disableAllAsk() {
        String string2 = "Disable all mods?";
        String string3 = "";
        String string4 = "[onenter]Disable All:";
        string4 = string4 + "closePopup(); mods.disableAll();";
        boolean bl2 = true;
        this.root.showPopup(string2, string3, bl2, string4, null);
    }

    public void disableAll()throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        l2.bZ.g();
        l2.bZ.e();
        l2.bQ.save();
        l2.bZ.l();
        this.loadMods();
    }

    public void reloadModDataAsk() throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.I()) {
            GameEngine.log("Menu active, reloading without asking");
            this.reloadModData();
            return;
        }
        String string2 = "Reload all mod data?";
        String string3 = "";
        string3 = string3 + "Warning! this will end your current game.";
        String string4 = "[onenter]Reload:";
        string4 = string4 + "closePopup(); mods.reloadModData();";
        boolean bl2 = true;
        this.root.showPopup(string2, string3, bl2, string4, null);
    }

    public void reloadModData() throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        this._saveModsCommon(false);
        l2.bZ.l();
        this._saveModsMessages(true);
        this.loadMods();
    }
}

