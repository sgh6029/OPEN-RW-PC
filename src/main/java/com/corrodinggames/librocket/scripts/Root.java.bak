/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import com.Element;
import com.ElementDocument;
import com.LibRocket;
import com.corrodinggames.librocket.a;
import com.corrodinggames.librocket.b;
import com.corrodinggames.librocket.e;
import com.corrodinggames.rts.appFramework.i;
import com.corrodinggames.rts.appFramework.p;
import com.corrodinggames.rts.appFramework.q;
import com.corrodinggames.rts.gameFramework.KeyBinding;
import com.corrodinggames.rts.gameFramework.ProfilerTimer;
import com.corrodinggames.rts.gameFramework.h_f9;
import com.corrodinggames.rts.gameFramework.g.c;
import com.corrodinggames.rts.gameFramework.g.f;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.GameRoomSettings;
import com.corrodinggames.rts.gameFramework.j.GameModeType;
import com.corrodinggames.rts.gameFramework.j.SocketConnector;
import com.corrodinggames.rts.gameFramework.j.g;
import com.corrodinggames.rts.gameFramework.j.n;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.SlickToAndroidKeycodes;

import android.graphics.Color;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Root
        extends ScriptContext {
    public static final boolean DEBUG_TIMING = true;
    public Multiplayer multiplayer;
    public Mods mods;
    ProfilerTimer openDocumentTimer = new ProfilerTimer("openDocument", true);
    SocketConnector threadedGameConnector;
    ElementDocument lastConnectingPopup;
    static ProfilerTimer convertTextStopwatch = new ProfilerTimer("ConvertText", true);
    static ProfilerTimer loadSettingsStopwatch = new ProfilerTimer("LoadSettings", true);
    ArrayList lastSortedDiscoveredServers;

    //原无 后添加
    public LibRocket getLibRocket(){
        return libRocket;
    }

    public void logDebug(String string2) {
        GameEngine.log("ui[debug]: " + string2);
    }

    public void logWarn(String string2) {
        GameEngine.log("ui[warn]: " + string2);
    }

    public void back() {
        this.libRocket.backToLastDocument();
        if (this.libRocket.getActiveDocument() == null) {
            GameEngine.b("back: libRocket.getActiveDocument()==null");
            GameEngine l2 = GameEngine.getInstance();
            if (l2 == null || !l2.bq) {
                GameEngine.b("back: showing main menu!");
                this.showMainMenu();
            } else {
                GameEngine.b("back: resuming game");
                this.guiEngine.a(false);
            }
        }
    }

    public void backOrClose() {
        if (this.closePopup()) {
            return;
        }
        this.libRocket.backToLastDocument();
    }

    public String fullVersionOnlyStyle() {
        if (GameEngine.getInstance().isGamePaused) {
            return "notInDemo";
        }
        return "";
    }

    public void openIfNotDemo(String string2, Object object, String string3) {
        if (GameEngine.getInstance().isGamePaused) {
            this.alert(string3);
            return;
        }
        this.open(string2, object);
    }

    public String getVersionName() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.getVersionDisplayString();
    }

    public void delayedOpenNoHistory(String string2, Object object) {
        ScriptEngine$Action scriptEngine$Action = this.scriptEngine.addRunnableToQueue(new Root$1(this, string2));
        scriptEngine$Action.framesDelay = 1;
    }

    public void openAfterHelpPopup(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        if (GameEngine.au() && !l2.bQ.hasPlayedGameOrSeenHelp) {
            l2.bQ.hasPlayedGameOrSeenHelp = true;
            l2.bQ.save();
            String string3 = "";
            String string4 = "First time playing? Would you like to view the quick help slides?";
            String string5 = "[onenter]View Help:";
            string5 = string5 + "closePopup(); open('help_quick_mobile.rml');";
            String string6 = "Skip:";
            string6 = string6 + "closePopup(); open(" + this.restrictedString(string2) + ");";
            boolean bl2 = false;
            this.showPopup(string3, string4, bl2, string5, string6);
            return;
        }
        this.open(string2, null);
    }

    public void open(String string2, Object object) {
        this.openDocumentTimer.a();
        b.a.f();
        HashMap<String, Object> hashMap = null;
        if (object != null) {
            hashMap = new HashMap<String, Object>();
            hashMap.put("mode", object);
        }
        this.libRocket.setDocument(string2, hashMap);
        this.onShowNewScreen();
        this.openDocumentTimer.d();
        b.a.e();
    }

    public void onShowNewScreen() {
        this.guiEngine.a(true);
    }

    public void resume() {
        this.libRocket.closeActiveDocument();
        this.libRocket.clearHistory();
        this.guiEngine.f();
    }

    public void resumeNonMenu() {
        this.libRocket.closeActiveDocument();
        this.libRocket.clearHistory();
        this.guiEngine.a(false);
    }

    public void startNew(String string2) {
        this.guiEngine.a(string2);
        this.libRocket.closeActiveDocument();
        this.libRocket.clearHistory();
    }

    public void showRangeValue(String string2, String string3, boolean bl2) {
        Element element = this.libRocket.getActiveElementById(string2);
        if (element == null) {
            this.logWarn("Could not find:" + string2);
            return;
        }
        String string4 = element.getAttribute("value");
        string4 = bl2 ? new Float(string4).toString() : Integer.toString((int) Float.parseFloat(string4));
        Element element2 = this.libRocket.getActiveElementById(string3);
        if (element2 == null) {
            this.logWarn("Could not find:" + string3);
            return;
        }
        element2.setText(string4);
    }

    public String getValueById(String string2) {
        Element element = this.libRocket.getActiveElementById(string2);
        if (element == null) {
            this.logWarn("Could not find:" + string2);
            return null;
        }
        String string3 = element.getAttribute("value");
        return string3;
    }

    public void setValueById(String string2, String string3) {
        Element element = this.libRocket.getActiveElementById(string2);
        if (element == null) {
            this.logWarn("Could not find:" + string2);
            return;
        }
        element.setAttribute("value", string3);
    }

    public Element getElementById(String string2) {
        Element element = this.libRocket.getActiveElementById(string2);
        if (element == null) {
            this.logWarn("Could not find:" + string2);
            return null;
        }
        return element;
    }

    public boolean clickElement(Element element) {
        if (element == null) {
            this.logWarn("element is null");
            return false;
        }
        element.click();
        return true;
    }

    public void directJoinPopup() {
        GameEngine l2 = GameEngine.getInstance();
        String string2 = "Direct Join";
        String string3 = "Enter IP address or host name";
        String string4 = "";
        if (l2.bQ.lastNetworkIP != null) {
            string4 = l2.bQ.lastNetworkIP;
        }
        this.showInputPopup(string2, string3, string4, "[onenter]Join:joinServerFromPopup(getPopupText())", null);
    }

    public void joinServerFromPopup(String string2) {
        this.closePopup();
        this.hideKeyboard();
        if (string2 == null) {
            this.logDebug("joinAddress==null");
            return;
        }
        string2 = string2.trim();
        GameEngine l2 = GameEngine.getInstance();
        l2.bQ.lastNetworkIP = string2;
        l2.bQ.save();
        this.joinServerWithId(string2, null);
    }

    public void joinServerWithId(String string2, String string3) {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.bw = string3;
        try {
            this.joinServer(string2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinServer(String string2) throws IOException {
        if (ScriptEngine.inDebugScript && !com.corrodinggames.rts.a.DebugSocketServer.field_d) {
            return;
        }
        this.logDebug("joinAddress=" + string2);
        Root$2 root$2 = new Root$2(this);
        GameEngine l2 = GameEngine.getInstance();
        this.threadedGameConnector = l2.networkEngine.a(string2, false, root$2);
        this.lastConnectingPopup = this.createAndShowPopup("multiplayerLobby_connecting.rml", null, "Please wait");
    }

    public void joinServerCallback() {
        this.logDebug("joinServerCallback");
        final GameEngine b = GameEngine.getInstance();
        if (this.threadedGameConnector == null) {
            this.logDebug("threadedGameConnector==null");
            return;
        }
        this.closePopupOnly();
        if (this.threadedGameConnector.errorMessage != null) {
            if (this.threadedGameConnector.errorMessage.equals("CANCELLED")) {
                this.logDebug("Server join cancelled");
                return;
            }
            this.logWarn("Server join failed");
            this.showPopup("Connection failed", this.threadedGameConnector.errorMessage, true, null, null);
        }
        else {
            try {
                b.networkEngine.b("starting new");
                b.networkEngine.a(this.threadedGameConnector.connectedSocket);
                this.logDebug("connected");
                this.showBattleroom();
            }
            catch (final IOException ex) {
                b.c(ex.getMessage(), "Connection failed");
                ex.printStackTrace();
            }
        }
        this.threadedGameConnector = null;
    }

    public void cancelJoinServer() {
        if (this.threadedGameConnector != null) {
            if (this.threadedGameConnector.a()) {
                this.closePopup();
            }
        } else {
            this.closePopup();
        }
    }

    public void alert(String string2) {
        this.showAlert(string2);
    }

    public void showAlert(String string2) {
        this.logDebug("alert:" + string2);
        if (string2 == null) {
            string2 = "null";
        }
        this.libRocket.c(string2);
    }

    public void showPopupWithButtons(String string2, String string3, boolean bl2, e e2, e e3) {
        this.logDebug("showPopup:" + string3);
        if (string3 == null) {
            string3 = "null";
        }
        String string4 = null;
        this.libRocket.a(string2, string3, string4, e2, e3, bl2);
    }

    public void showPopupWithButtonsAndInput(String string2, String string3, boolean bl2, String string4, e e2, e e3) {
        this.logDebug("showPopup:" + string3);
        if (string3 == null) {
            string3 = "null";
        }
        if (string4 == null) {
            string4 = "";
        }
        if ("".equals(string4)) {
            this.guiEngine.l();
        }
        this.libRocket.a(string2, string3, string4, e2, e3, true, bl2);
    }

    public void showPopup(String string2, String string3, boolean bl2, String string4, String string5) {
        this.logDebug("showPopup:" + string3);
        if (string3 == null) {
            string3 = "null";
        }
        String string6 = null;
        this.libRocket.a(string2, string3, string6, string4, string5, bl2);
    }

    public void showInputPopup(String string2, String string3, String string4, String string5, String string6) {
        String string7;
        this.logDebug("showInputPopup:" + string3);
        if (string3 == null) {
            string3 = "null";
        }
        if ((string7 = string4) == null) {
            string7 = "";
        }
        if ("".equals(string7)) {
            this.guiEngine.l();
        }
        this.libRocket.a(string2, string3, string7, string5, string6, true);
    }

    public void showInputPopupNonClose(String string2, String string3, String string4, String string5, String string6) {
        String string7;
        this.logDebug("showInputPopup:" + string3);
        if (string3 == null) {
            string3 = "null";
        }
        if ((string7 = string4) == null) {
            string7 = "";
        }
        if ("".equals(string7)) {
            this.guiEngine.l();
        }
        this.libRocket.a(string2, string3, string7, string5, string6, true, false);
    }

    public ElementDocument getPopup() {
        return this.libRocket.c();
    }

    public ElementDocument getAlertOrPopup() {
        return this.libRocket.e();
    }

    public boolean closePopup() {
        return this.libRocket.h();
    }

    public boolean closePopupOnly() {
        return this.libRocket.j();
    }

    public boolean closeAlertOnly() {
        return this.libRocket.i();
    }

    public String getPopupText() {
        return this.libRocket.k();
    }

    public void showHostOptions() {
        this.libRocket.a("Host game", this.i("menus.hostgame.info_pc"), null,
                "Host Private:closePopup();hostStart(false);", "Host Public:closePopup();hostStart(true);", true);
    }

    public void hostStartFromPopup(boolean bl2) {
        Object object;
        ElementDocument elementDocument = this.libRocket.g();
        Element element = elementDocument.getElementById("password");
        Object object2 = null;
        if (element == null) {
            this.logWarn("hostStartFromPopup: password==null");
        } else {
            object = element.getValue();
            if (object != null && !((String) object).trim().equals("")) {
                object2 = object;
            }
        }
        object = elementDocument.getElementById("useMods");
        boolean bl3 = ((Element) object).getCheckbox();
        this.closePopup();
        this.hostStartWithPasswordAndMods(bl2, (String) object2, bl3);
    }

    public void hostStart(boolean bl2) {
        GameEngine.b("old version of hostStart");
        this.hostStartWithPassword(bl2, null);
    }

    public void hostStartWithPassword(boolean bl2, String string2) {
        GameEngine.b("old version of hostStartWithPassword");
        this.hostStartWithPasswordAndMods(bl2, string2, true);
    }

    public void hostStartWithPasswordAndMods(boolean bl2, String string2, boolean bl3) {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.b("starting new");
        l2.networkEngine.n = string2;
        l2.networkEngine.o = bl3;
        l2.networkEngine.q = bl2;
        if (l2.networkEngine.b(false)) {
            this.logDebug("-Hosting-");
            this.logDebug("using password: " + (l2.networkEngine.n != null));
            this.logDebug("using mods: " + l2.networkEngine.o);
            this.logDebug("public: " + l2.networkEngine.q);
            String string3 = l2.networkEngine.av();
            if (string3 != null && !com.corrodinggames.rts.gameFramework.storage.a.i(string3)) {
                GameEngine.b("hostStart: map does not exist: " + string3 + " reseting");
                string3 = null;
            }
            if (string3 == null) {
                int n2 = 0;
                l2.networkEngine.ay.a = GameModeType.values()[n2];
                l2.networkEngine.az = "maps/skirmish/[p8]Many Islands (8p).tmx";
                l2.networkEngine.ay.b = "[p8]Many Islands (8p).tmx";
            }
            this.libRocket.setDocument("battleroom.rml", null);
        } else {
            this.logWarn("hosting failed");
        }
    }

    public void exit() {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.bQ.numLoadsSinceRunningGameOrNormalExit != 0) {
            l2.bQ.numLoadsSinceRunningGameOrNormalExit = 0;
            l2.bQ.save();
        }
        this.scriptEngine.addRunnableToQueue(new Root$3(this));
    }

    public String getMapDetails(String string2) {
        return "hello 123";
    }

    public String getHTMLMapNameFromPath(String string2) {
        return this.htmlString(this.getMapNameFromPath(string2));
    }

    public String getMapNameFromPath(String string2) {
        File file = new File(string2);
        return this.convertMapName(file.getName());
    }

    public String convertMapName(String string2) {
        String string3 = this.convertMapNameWithoutTranslation(string2);
        string3 = com.corrodinggames.rts.gameFramework.h.a.b(string3);
        return string3;
    }

    public String convertMapNameWithoutTranslation(String string2) {
        String string3 = i.e(string2);
        return string3;
    }

    public String getHTMLMapThumbnail(String string2) {
        return this.escapedString(this.getMapThumbnail(string2));
    }

    public String getMapThumbnail(String string2) {
        String string3 = null;
        if (string2.startsWith("saves/")) {
            string3 = "drawable:icon_save.png";
        }
        String string4 = com.corrodinggames.rts.appFramework.c.c(string2);
        string3 = "thumbnail:assets:" + string4;
        if (!com.corrodinggames.rts.gameFramework.storage.a.i(string4)) {
            if (GameEngine.isDebugVersionStatic2) {
                GameEngine.a("getMapThumbnail: Failed to find: " + string4);
            }
            return "drawable:error_missingmap.png";
        }
        return string3;
    }

    public boolean isMapSkirmish(String string2) {
        return i.f(string2);
    }

    public void showLevelOptions() {
        GameEngine var1 = GameEngine.getInstance();
        String var2 = (String) this.libRocket.b("mode");
        if (var2 == null) {
            GameEngine.g("levelPath==null");
        } else {
            boolean var3 = true;
            if (!this.isMapSkirmish(var2)) {
                var3 = false;
            }

            ElementDocument var4 = this.libRocket.getActiveDocument();
            Iterator var5 = var4.findElementsByClassName("skirmishOnly").iterator();

            Element var6;
            while (var5.hasNext()) {
                var6 = (Element) var5.next();
                var6.show(var3);
            }

            Element var7 = var4.getElementById("advancedButton");
            if (var7 != null) {
                var7.show(var3 || i.g(var2));
            }

            var6 = var4.getElementById("aiDifficulty");
            var6.setValue("" + var1.bQ.aiDifficulty);
        }
    }

    public void loadConfigAndStartSwitchToAdvanced(String string2) {
        boolean bl2 = true;
        GameEngine l2 = GameEngine.getInstance();
        l2.bv = false;
        this.loadConfigCommon(string2, bl2);
        this._startAdvancedMode(false);
    }

    private void _startAdvancedMode(boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.b("starting singleplayer");
        l2.networkEngine.y = "You";
        l2.networkEngine.o = true;
        boolean bl3 = bl2 ? l2.networkEngine.R() : l2.networkEngine.S();
        if (bl3) {
            this.logDebug("started startSinglePlayerServer");
            GameRoomSettings ah2 = l2.networkEngine.e();
            if (ah2 != null) {
                ah2.f = l2.bQ.aiDifficulty;
                l2.networkEngine.a(ah2);
            }
            this.libRocket.setDocument("battleroom.rml", null);
        } else {
            this.logWarn("failed startSinglePlayerServer");
        }
    }

    public void loadConfigAndStartNewSandbox(String string2) throws IOException {
        this._loadConfigAndStartNewSandboxCommon(string2, true);
    }

    public void loadConfigAndStartNewSandboxInAdvanced(String string2) throws IOException {
        GameEngine.log("loadConfigAndStartNewSandboxInAdvanced");
        this._loadConfigAndStartNewSandboxCommon(string2, false);
        this._startAdvancedMode(true);
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.log("editorMode:" + l2.bv);
    }

    private void _loadConfigAndStartNewSandboxCommon(String string2, boolean bl2) throws IOException {
        boolean bl3 = false;
        if (string2.startsWith("saves/")) {
            GameEngine.log("Starting sandbox from save: " + string2);
            this.loadGame(string2.substring("saves/".length()));
        } else {
            GameEngine.log("Starting sandbox from map: " + string2);
            this.loadConfigCommon(string2, bl3);
        }
        GameEngine l2 = GameEngine.getInstance();
        l2.bL.E = false;
        l2.bS.y();
        l2.bv = true;
        if (bl2) {
            this.guiEngine.f();
        }
        this.libRocket.closeActiveDocument();
        this.libRocket.clearHistory();
    }

    public void loadConfigAndStartNew(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.bv = false;
        l2.networkEngine.b("starting singleplayer");
        boolean bl2 = false;
        this.loadConfigCommon(string2, bl2);
        this.guiEngine.f();
        this.libRocket.closeActiveDocument();
        this.libRocket.clearHistory();
    }

    public void loadConfigCommon(String string2, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        Element element = elementDocument.getElementById("aiDifficulty");
        l2.bQ.aiDifficulty = element.getValueAsInt(0);
        l2.bQ.save();
        this.guiEngine.b(true);
        this.guiEngine.c(false);
        String string3 = string2;
        boolean bl3 = this.isMapSkirmish(string3);
        int n2 = elementDocument.getElementById("numberOfAIs").getValueAsInt(4);
        boolean bl4 = true;
        int n3 = elementDocument.getElementById("aiTeams").getValueAsInt(1);
        int n4 = n3 - 1;
        if (n3 == 5) {
            n4 = 0;
            bl4 = false;
        }
        i.a(string3, bl3, n2, n4, bl4, bl2);
    }

    public void showMapPopup(String string2, String string3) throws IOException {
        boolean bl2 = false;
        ElementDocument elementDocument = this.libRocket.a("levelSelect.rml", (Object) string2, "Map Select", bl2);
        if (elementDocument != null) {
            elementDocument.setMetadata("mapClickFunction", string3);
            List<Element> aaa = elementDocument.findElementsByClassName("noStyleInPopup");
            for (Element element : aaa) {
                element.setAttribute("class", "");
            }
            if (this.showMapsWithDoc(elementDocument)) {
                GameEngine.log("showMapsWithDoc passed");
                this.libRocket.h();
                this.libRocket.a(elementDocument);
            }
        }
    }

    public void refreshAfterFileImport() {
        GameEngine.log("refreshAfterFileImport");
        GameEngine l2 = GameEngine.getInstance();
        ArrayList arrayList = l2.bZ.k();
        this.libRocket.reloadDocument();
    }

    public boolean showMaps() {
        ElementDocument elementDocument = this.libRocket.f();
        return this.showMapsWithDoc(elementDocument);
    }

    public boolean showMapsWithDoc(ElementDocument elementDocument) {
        String[] stringArray;
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.log("showMaps");
        if (elementDocument == null) {
            GameEngine.log("showMaps: elementDocument==null");
            return false;
        }
        Element element = elementDocument.getElementById("mapTemplateHolder");
        Element element2 = elementDocument.getElementById("mapHolder");
        String string2 = element.getInnerRML();
        String string3 = "";
        String string4 = (String) elementDocument.getMetadata("mode");
        String string5 = (String) elementDocument.getMetadata("mapClickFunction");
        boolean bl2 = string4.equals("saves");
        boolean bl3 = string4.equals("replays");
        boolean bl4 = string4.startsWith("/SD/");
        if (bl2) {
            stringArray = com.corrodinggames.rts.appFramework.j.l();
            if (stringArray == null) {
                l2.a("No saves", 1);
                return false;
            }
        } else if (bl3) {
            stringArray = q.l();
            if (!l2.bQ.saveMultiplayerReplays) {
                this.alert(
                        "Note: Multiplayer replay recordings are not turned on. You can enable them in the settings.");
            }
            if (stringArray == null) {
                if (l2.bQ.saveMultiplayerReplays) {
                    l2.a("No replays yet", 1);
                }
                return false;
            }
        } else {
            stringArray = com.corrodinggames.rts.gameFramework.storage.a.a(string4, true);
            if ((stringArray = l2.bZ.a(stringArray, string4)) == null) {
                l2.a("Could not find folder: " + com.corrodinggames.rts.gameFramework.storage.a.e(string4), 1);
                return false;
            }
        }
        String string6 = string4 + "/";
        int n2 = 0;
        for (String string7 : stringArray) {
            String string8;
            String string9;
            String string10;
            String string11 = string2;
            String string12 = this.convertMapName(string7);
            boolean bl5 = i.a(string7, string6 + string7);
            String string13 = string12 + "";
            if (l2.isGamePaused && !bl5) {
                string13 = "[LOCKED] " + string13;
            }
            string11 = string11.replace("_NAME_", this.htmlString(string13));
            if (bl2) {
                string10 = "loadGame(" + this.escapedString(string7) + ")";
                string9 = "loadGameEdit(" + this.escapedString(string7) + ")";
            } else if (bl3) {
                string10 = "loadReplay(" + this.escapedString(string7) + ")";
                string9 = "loadReplayEdit(" + this.escapedString(string7) + ")";
            } else {
                string10 = "open('levelOptions.rml', " + this.escapedString(string6 + string7) + ")";
                string9 = "";
            }
            if (string5 != null) {
                string10 = string5 + "(" + this.escapedString(string6 + string7) + ")";
                string9 = "";
            }
            string11 = string11.replace("_ONCLICK_", string10);
            string11 = string11.replace("_ONCLICKEDIT_", string9);
            String string14 = "thumbnail:assets:";
            int n3 = 18;
            if (bl4) {
                n3 = 2;
            }
            if (n2 > n3) {
                string14 = "lazy:" + string14;
            }
            String string15 = string8 = com.corrodinggames.rts.appFramework.c.c(string6 + string7);
            if (GameEngine.isDebugVersionStatic2) {
                // empty if block
            }
            String string16 = string14 + string8;
            if (!com.corrodinggames.rts.gameFramework.storage.a.i(string15)) {
                if (GameEngine.isDebugVersionStatic2) {
                    GameEngine.a("List: Failed to find: " + string15 + " after converting:" + string8 + " ( " + string16
                            + " )");
                }
                string16 = "drawable:error_missingmap.png";
            }
            if (bl2 || bl3) {
                string16 = "";
            }
            string11 = string11.replace("_IMG_", this.htmlString(string16));
            ++n2;
            string3 = string3 + string11;
        }
        element2.setInnerRML(string3);
        element2.loadCharsetIfNeeded(string3);
        if (bl2 || bl3) {
            element2.addClass("savesOnly");
        } else {
            element2.addClass("notSavesOnly");
        }
        if (bl4 && string5 == null && GameEngine.au()) {
            elementDocument.addClass("showImportButton");
        }
        return true;
    }

    public void convertTextOnPage() {
        GameEngine l2 = GameEngine.getInstance();
        this.logDebug("convertTextOnPage");
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        if (this.isMobile()) {
            elementDocument.addClass("mobile");
        }
        if (this.libRocket.getHeight() < 800) {
            elementDocument.addClass("smallScreen");
        }
        convertTextStopwatch.a();
        ArrayList<Element> arrayList = elementDocument.getAllNestedChildren();
        for (Element element : arrayList) {
            String string2;
            int n2 = element.getNumAttributes();
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object;
                String string3 = element.getAttributeKey(i2);
                String string4 = element.getAttributeValue(i2);
                if (string3 == null)
                    continue;
                if (string3.equals("nestedclone") && !string4.equalsIgnoreCase("false")) {
                    GameEngine.log("nested clone:" + element.getId());
                    element.setAttribute(string3, "false");
                    object = element.clone();
                    element.prependChild((Element) object);
                    ((Element) object).removeReference();
                    continue;
                }
                if (string3.equals("childclone") && !string4.equalsIgnoreCase("false")) {
                    element.setAttribute(string3, "false");
                    if (element.getNumChildren() < 1) {
                        GameEngine.log("child clone failed no children:" + element.getId());
                    }
                    object = element.getChild(0).clone();
                    ((Element) object).addClass("clone");
                    element.prependChild((Element) object);
                    ((Element) object).removeReference();
                    continue;
                }
                object = this.libRocket.d(string4);
                if (object == null)
                    continue;
                GameEngine.log("convertTextOnPage:" + string3 + ": '" + string4 + "' to '" + (String) object + "'");
                if (string3.equals("_html")) {
                    GameEngine.log("setting html:" + string3);
                    element.setInnerRML((String) object);
                    continue;
                }
                if (string3.startsWith("_")) {
                    string3 = string3.substring("_".length());
                    GameEngine.log("converted key to:" + string3);
                }
                element.setAttribute(string3, (String) object);
            }
            if (!elementDocument.translatedToUnicode || !(string2 = element.getTagName()).equals("p")
                    && !string2.startsWith("h") && !string2.startsWith("label") && !string2.startsWith("button")
                    && !string2.startsWith("select"))
                continue;
            boolean bl2 = element.loadCharsetIfNeededWithCurrentText();
        }
        convertTextStopwatch.d();
    }

    public void keyBindingPopup_apply(boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        ElementDocument elementDocument = this.libRocket.c();
        if (elementDocument == null) {
            this.logWarn("showKeyBindingActionPopup: popup==null");
            return;
        }
        String string2 = (String) elementDocument.getMetadata("mode");
        String[] stringArray = string2.split(":");
        int n2 = Integer.parseInt(stringArray[0]);
        int n3 = Integer.parseInt(stringArray[1]);
        ArrayList arrayList = l2.bT.al;
        KeyBinding ad2 = (KeyBinding) arrayList.get(n2);
        if (!bl2) {
            Object object = elementDocument.getMetadata("lastKeyPressed");
            if (object == null) {
                this.logWarn("keyBindingPopup_apply: no last key entered");
                return;
            }
            int n4 = (Integer) object;
            int n5 = 0;
            Object object2 = elementDocument.getMetadata("lastKeyModifiersPressed");
            if (object2 != null) {
                n5 = (Integer) object2;
            }
            ad2.a(n4, n3, n5, true);
        } else {
            int n6 = 0;
            ad2.a(0, n3, n6, true);
        }
        this.showKeyBinding();
        this.closePopup();
    }

    public void keyBindingPopup_onKeydown(int n2) {
        GameEngine l2 = GameEngine.getInstance();
        ElementDocument elementDocument = this.libRocket.c();
        if (elementDocument == null) {
            this.logWarn("showKeyBindingActionPopup: popup==null");
            return;
        }
        Element element = elementDocument.getElementById("keyBindMessage");
        if (element == null) {
            this.logWarn("showKeyBindingActionPopup: keyBindMessage==null");
            return;
        }
        String string2 = "";
        int n3 = this.guiEngine.i();
        string2 = string2 + GameEngine.j(n3);
        if (n2 == 111) {
            // empty if block
        }
        if (n2 == 0) {
            this.logWarn("keyBindingPopup_onKeydown: skipping keycode 0");
            return;
        }
        if (!l2.i(n2)) {
            elementDocument.setMetadata("lastKeyPressed", n2);
            elementDocument.setMetadata("lastKeyModifiersPressed", n3);
            string2 = string2 + SlickToAndroidKeycodes.a(n2);
            this.keyBindingPopup_apply(false);
            return;
        }
        String string3 = "Key: " + string2;
        element.setText(string3);
    }

    public void showKeyBindingPopup() {
        GameEngine l2 = GameEngine.getInstance();
        ElementDocument elementDocument = this.libRocket.c();
        if (elementDocument == null) {
            this.logWarn("showKeyBindingActionPopup: popup==null");
            return;
        }
        Element element = elementDocument.getElementById("keyBindMessage");
        if (element == null) {
            this.logWarn("showKeyBindingActionPopup: keyBindMessage==null");
            return;
        }
        String string2 = (String) elementDocument.getMetadata("mode");
        String[] stringArray = string2.split(":");
        int n2 = Integer.parseInt(stringArray[0]);
        int n3 = Integer.parseInt(stringArray[1]);
        ArrayList arrayList = l2.bT.al;
        KeyBinding ad2 = (KeyBinding) arrayList.get(n2);
        String string3 = "Press a key..";
        element.setText(string3);
    }

    public String getKeyBindingAction(int n2, KeyBinding ad2, int n3) {
        String string2 = n2 + ":" + n3;
        return "createAndShowPopup('settingsKeyBindingSet.rml', " + this.escapedString(string2) + ", "
                + this.escapedString(ad2.a) + "); showKeyBindingPopup();";
    }

    public void backWarnIfOverlappingKeyBinding() {
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        boolean bl2 = (Boolean) elementDocument.getMetadata("hasOverlappingKeys", false);
        if (bl2) {
            String string2 = "One or more keys are overlapping and have been highlighted in red. These can cause problems.";
            e e2 = new e("Ignore", new Root$4(this));
            e e3 = new e("Fix", new Root$5(this));
            boolean bl3 = false;
            this.showPopupWithButtons(null, string2, bl3, e2, e3);
            return;
        }
        this.back();
    }

    public void showKeyBinding() {
        GameEngine l2 = GameEngine.getInstance();
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        elementDocument.setMetadata("event_onkeydown", "keyBindingPopup_onKeydown");
        Root$TableData root$TableData = new Root$TableData();
        ArrayList arrayList = root$TableData.rows;
        ArrayList arrayList2 = l2.bT.al;
        boolean bl2 = false;
        for (int i2 = 0; i2 < arrayList2.size(); ++i2) {
            KeyBinding ad2 = (KeyBinding) arrayList2.get(i2);
            if (!ad2.b)
                continue;
            Root$TableRow root$TableRow = new Root$TableRow();
            root$TableRow.addCell(ad2.a);
            if (ad2.d()) {
                root$TableRow.addClass("rowHeader");
            } else {
                for (int i3 = 0; i3 <= 1; ++i3) {
                    boolean bl3 = l2.bT.a(ad2, i3);
                    Root$TableCell root$TableCell = root$TableRow.addCell(ad2.b(i3));
                    root$TableCell.setLibrocketOnClick(this.getKeyBindingAction(i2, ad2, i3));
                    if (!bl3)
                        continue;
                    root$TableCell.color = -65536;
                    bl2 = true;
                }
            }
            arrayList.add(root$TableRow);
        }
        elementDocument.setMetadata("hasOverlappingKeys", bl2);
        this.refreshTable("keysDiv", root$TableData);
    }

    public void loadSettings() {
        GameEngine l2 = GameEngine.getInstance();
        loadSettingsStopwatch.a();
        this.logDebug("loadSettings");
        Element element = this.libRocket.getActiveElementById("body");
        ArrayList<Element> arrayList = element.getAllNestedChildren();
        for (Element element2 : arrayList) {
            String string2 = element2.getAttribute("data-settings");
            if (string2 == null)
                continue;
            String string3 = element2.getId();
            String string4 = element2.getAttribute("type", "unknown");
            String string5 = l2.bQ.getValueDynamic(string3);
            if (string4.equals("checkbox")) {
                if (Boolean.parseBoolean(string5)) {
                    element2.setAttribute("checked", "");
                    continue;
                }
                element2.setAttribute("checked", null);
                continue;
            }
            element2.setAttribute("value", string5);
        }
        loadSettingsStopwatch.d();
    }

    public void loadLeaderboard() {
        GameEngine l2 = GameEngine.getInstance();
        this.logDebug("loadLeaderboard");
        Element element = this.libRocket.getActiveElementById("leaderboardType");
        Element element2 = this.libRocket.getActiveElementById("leaderboardGrouping");
        if (element == null || element2 == null) {
            GameEngine.a("loadLeaderboard: Failed to find elements. (For page: "
                    + this.libRocket.getActiveDocumentPath() + ")");
            return;
        }
        element.setAttribute("value", l2.cg.e().name());
        element2.setAttribute("value", l2.cg.f().name());
    }

    public void saveLeaderboard() {
        GameEngine l2 = GameEngine.getInstance();
        f f2 = f.none;
        c c2 = c.player;
        this.logDebug("saveLeaderboard");
        Element element = this.libRocket.getActiveElementById("leaderboardType");
        Element element2 = this.libRocket.getActiveElementById("leaderboardGrouping");
        if (element == null || element2 == null) {
            GameEngine.a("saveLeaderboard: Failed to find elements. (For page: "
                    + this.libRocket.getActiveDocumentPath() + ")");
            return;
        }
        f2 = f.valueOf(element.getAttribute("value"));
        c2 = c.valueOf(element2.getAttribute("value"));
        l2.a(f2, c2);
    }

    public void applyResolution() {
        this.guiEngine.g();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRenderScaleInSettings(boolean bl2) {
        Element element;
        GameEngine l2 = GameEngine.getInstance();
        Element element2 = this.libRocket.getActiveElementById("uiRenderScale");
        Element element3 = this.libRocket.getActiveElementById("renderDensity");
        Float f2 = null;
        Float f3 = null;
        if (element2 == null) {
            this.logDebug("updateRenderScaleInSettings: uiRenderScale==null");
        } else {
            f2 = element2.getValueAsFloat(Float.valueOf(1.0f));
            element = this.libRocket.getActiveElementById("uiRenderScaleDisplay");
            element.compareAndSetText(
                    "x" + com.corrodinggames.rts.gameFramework.GameUtils.b((double) (f2.floatValue() + 0.01f), 1));
        }
        if (element3 == null) {
            this.logDebug("updateRenderScaleInSettings: renderDensity==null");
        } else {
            f3 = element3.getValueAsFloat(Float.valueOf(1.0f));
            element = this.libRocket.getActiveElementById("renderDensityDisplay");
            element.compareAndSetText(
                    "x" + com.corrodinggames.rts.gameFramework.GameUtils.b((double) (f3.floatValue() + 0.01f), 1));
        }
        if (bl2) {
            float f4 = l2.bQ.uiRenderScale;
            if (f2 != null) {
                l2.bQ.uiRenderScale = f2.floatValue();
            }
            float f5 = l2.bQ.renderDensity;
            if (f3 != null) {
                l2.bQ.renderDensity = f3.floatValue();
            }
            try {
                this.applyResolution();
            } finally {
                l2.bQ.uiRenderScale = f4;
                l2.bQ.renderDensity = f5;
            }
        }
    }

    public void closeSettings() {
        this.applyResolution();
    }

    public void saveSettings() {
        GameEngine l2 = GameEngine.getInstance();
        this.logDebug((String) "saveSettings");
        Element element = this.libRocket.getActiveElementById((String) "body");
        ArrayList arrayList = element.getAllNestedChildren();
        Iterator iterator = arrayList.iterator();
        while (true) {
            String string;
            if (!iterator.hasNext()) {
                this.guiEngine.g();
                com.corrodinggames.rts.gameFramework.FileChangeEngine.a();
                com.corrodinggames.rts.gameFramework.h.a.e();
                this.guiEngine.h();
                return;
            }
            Element element2 = (Element) iterator.next();
            String string2 = element2.getAttribute((String) "data-settings");
            if (string2 == null)
                continue;
            String string3 = element2.getId();
            String string4 = element2.getAttribute((String) "type", (String) "unknown");
            String string5 = null;
            string5 = string4.equals((Object) "checkbox")
                    ? ((string = element2.getAttribute((String) "checked")) == null || "false".equals((Object) string)
                            ? "false"
                            : "true")
                    : element2.getAttribute((String) "value");
            try {
                l2.bQ.setValueDynamic((String) string3, (String) string5);
            } catch (NumberFormatException numberFormatException) {
                this.alert((String) ("Error:" + numberFormatException.getMessage()));
                continue;
            }
            break;
        }
    }

    public String hideStyle(boolean bl2) {
        if (bl2) {
            return "";
        }
        return "display:none;";
    }

    public String hideIf(boolean bl2) {
        return this.hideClass(!bl2);
    }

    public String hideUnless(boolean bl2) {
        return this.hideClass(bl2);
    }

    public String hideClass(boolean bl2) {
        if (bl2) {
            return "";
        }
        return "hide";
    }

    public String hideIfMobile() {
        if (GameEngine.au()) {
            return "hide";
        }
        return "";
    }

    public boolean canResume() {
        GameEngine l2 = GameEngine.getInstance();
        return l2 != null && l2.loadNewGame && !l2.bH;
    }

    public boolean isMobile() {
        return GameEngine.au();
    }

    public boolean isIOS() {
        return GameEngine.isDebugVersionStatic2;
    }

    public boolean isDesktop() {
        return GameEngine.av();
    }

    public boolean isMac() {
        return com.corrodinggames.rts.game.GameLogic.isSandboxEnabled;
    }

    public boolean hasModSupport() {
        return !GameEngine.isDebugVersionStatic2;
    }

    public boolean usingMods() {
        if (GameEngine.isDebugVersionStatic2) {
            GameEngine l2 = GameEngine.getInstance();
            return l2.bZ.c() > 0;
        }
        return true;
    }

    public boolean hasWorkshopSupport() {
        return GameEngine.av();
    }

    public boolean hasReloadSupport() {
        return !GameEngine.isDebugVersionStatic2;
    }

    String restrictedString(String string2) {
        if (string2 == null) {
            return null;
        }
        string2 = string2.replace("'", ".");
        string2 = string2.replace("\"", ".");
        string2 = string2.replace("(", ".");
        string2 = string2.replace(")", ".");
        string2 = string2.replace(",", ".");
        string2 = string2.replace("<", ".");
        string2 = string2.replace(">", ".");
        return "'" + string2 + "'";
    }

    String escapedString(String string2) {
        string2 = string2.replace("&", "&amp;");
        string2 = string2.replace("<", "&lt;");
        string2 = string2.replace(">", "&gt;");
        string2 = string2.replace("'", "&apos;");
        string2 = string2.replace("\"", "&quot;");
        string2 = string2.replace("${", "$ {");
        return "'" + string2 + "'";
    }

    String htmlString(String string2) {
        string2 = string2.replace("&", "&amp;");
        string2 = string2.replace("<", "&lt;");
        string2 = string2.replace(">", "&gt;");
        string2 = string2.replace("\"", "&quot;");
        string2 = string2.replace("${", "$ {");
        return "" + string2 + "";
    }

    String htmlStringWithNewlines(String string2) {
        string2 = this.htmlString(string2);
        string2 = string2.replace("\n", "<br/>");
        return "" + string2 + "";
    }

    public void checkServerListScroll() {
        Element element = this.libRocket.getActiveElementById("serverScrollDiv");
        if (element == null) {
            this.logWarn("serverScrollDiv==null");
            return;
        }
        Boolean bl2 = (Boolean) this.libRocket.b("showFullServerList");
        if (bl2 == null) {
            bl2 = false;
        }
        if (!bl2.booleanValue() && element.getScrollTop() > 200.0f) {
            this.libRocket.getActiveDocument().setMetadata("showFullServerList", true);
            this.scriptEngine.addScriptToQueue("displayServerList()");
        }
    }

    public void refreshServerList() {
        this.refreshServerListRaw("serverListData", "serverRowTemplateHolder", "refreshButton");
    }

    public void displayServerList() {
        this.displayServerListRaw("serverListData", "serverRowTemplateHolder", "refreshButton");
    }

    public void refreshServerListRaw(String string2, String string3, String string4) {
        Object object;
        GameEngine l2 = GameEngine.getInstance();
        if (string4 != null) {
            object = this.libRocket.getActiveElementById(string4);
            ((Element) object).setText("Refreshing");
        }
        object = new Root$6(this, string2, string3, string4);
        l2.networkEngine.bh = null;
        n.a((Runnable) object);
    }

    public void displayServerListRaw(String string2, String string3, String string4) {
        Boolean bl2;
        GameEngine l2 = GameEngine.getInstance();
        Element element = this.libRocket.getActiveElementById(string2);
        Element element2 = this.libRocket.getActiveElementById(string3);
        if (element == null) {
            GameEngine.b("serverListData is null, we may have changed page");
            return;
        }
        Element element3 = element;
        ArrayList<g> arrayList = p.m();
        this.lastSortedDiscoveredServers = arrayList;
        String string5 = com.corrodinggames.rts.gameFramework.h.a.a("menus.lobby.gameState.battleroom", new Object[0]);
        String string6 = com.corrodinggames.rts.gameFramework.h.a.a("menus.lobby.gameState.ingame", new Object[0]);
        String string7 = com.corrodinggames.rts.gameFramework.h.a.a("menus.lobby.gameState.chat", new Object[0]);
        if (element3.getNumChildren() > arrayList.size()) {
            for (int i2 = element3.getNumChildren() - 1; i2 >= arrayList.size(); --i2) {
                GameEngine.log("removing rowIndex:" + i2);
                element3.removeChild(element3.getChild(i2));
            }
            if (element3.getNumChildren() != arrayList.size()) {
                GameEngine.b(
                        "-- Non matching size after clean up:" + element3.getNumChildren() + " vs " + arrayList.size());
            }
        }
        if ((bl2 = (Boolean) this.libRocket.b("showFullServerList")) == null) {
            bl2 = false;
        }
        int n2 = 0;
        int n3 = 50;
        if (!bl2.booleanValue() && arrayList.size() > n3) {
            ArrayList<g> arrayList2 = new ArrayList<g>();
            for (g object2 : arrayList) {
                arrayList2.add(object2);
                if (arrayList2.size() <= n3)
                    continue;
                break;
            }
            n2 = arrayList.size() - arrayList2.size();
            arrayList = arrayList2;
        }
        int n4 = 0;
        Iterator<g> object3 = arrayList.iterator();
        while (object3.hasNext()) {
            String string8;
            g element7 = object3.next();
            Element element4 = null;
            if (n4 < element3.getNumChildren()) {
                element4 = element3.getChild(n4);
            }
            if (element4 != null && element4.hasClassName("serverRowMessage")) {
                GameUtils.e("removing non rowIndex:" + n4);
                element3.removeChild(element4);
                element4 = null;
            }
            if (element4 != null && element4.findByClassName("rState") == null) {
                GameUtils.e("removing non rowIndex with no rState:" + n4);
                element3.removeChild(element4);
                element4 = null;
            }
            if (element4 == null) {
                element4 = element2.clone();
                element3.appendChild(element4);
                element4.removeReference();
                element4.setAttribute("onclick", "clickedServerRow(" + n4 + ")");
            }
            if ((string8 = element7.s) != null) {
                string8 = string8.replace("battleroom", string5);
                string8 = string8.replace("ingame", string6);
                string8 = string8.replace("chat", string7);
            }
            boolean bl3 = false;
            boolean bl4 = false;
            boolean bl5 = false;
            boolean bl6 = false;
            if (element7 != null && element7.x) {
                bl3 = true;
                if ("chat".equalsIgnoreCase(element7.s)) {
                    bl4 = true;
                }
                if (element7.d()) {
                    bl6 = true;
                }
            }
            int n5 = Color.a(255, 255, 255, 255);
            String string9 = "serverRow serverRowData realServerRow ";
            boolean bl7 = false;
            if (element7 != null) {
                if (bl3) {
                    string9 = string9 + "dedicatedServerRow ";
                    if (bl4 || bl6) {
                        n5 = Color.a(255, 152, 236, 249);
                        string9 = string9 + "chatRow ";
                    }
                } else {
                    if (element7.h) {
                        n5 = Color.a(255, 240, 240, 240);
                        string9 = string9 + "openRow ";
                    }
                    if (element7.a) {
                        n5 = Color.a(255, 229, 149, 35);
                        string9 = string9 + "lanRow ";
                    }
                }
                if (element7.a()) {
                    string9 = string9 + "lastConnectedRow ";
                }
                if (!(bl4 || bl6 || ("" + l2.getVersionCode(true)).equals(element7.j))) {
                    bl5 = true;
                }
            }
            String string10 = "";
            string10 = string10 + "color:" + com.corrodinggames.rts.gameFramework.GameUtils.h(n5) + ";";
            if (bl7) {
                string10 = string10 + "font-weight: bold;";
                string9 = string9 + "boldRow ";
            }
            element4.compareAndSetClassNames(string9);
            element4.findByClassName("rState").compareAndSetText(string8);
            String string11 = com.corrodinggames.rts.gameFramework.GameUtils.a(element7.n, 15);
            element4.findByClassName("rHost").compareAndSetText(string11);
            String string12 = element7.t == "?" ? "?" : element7.t + "\\" + element7.u;
            element4.findByClassName("rPlayers")
                    .compareAndSetText(com.corrodinggames.rts.gameFramework.GameUtils.a(string12, 15));
            String string13 = com.corrodinggames.rts.gameFramework.GameUtils.a(i.e(element7.q), 40);
            if (string13 == null) {
                string13 = "";
            }
            element4.findByClassName("rMap").compareAndSetText(string13);
            String string14 = "ANY".equalsIgnoreCase(element7.k) ? element7.k
                    : "v" + com.corrodinggames.rts.gameFramework.GameUtils.a(element7.k, 8);
            Element element5 = element4.findByClassName("rVersion");
            element5.compareAndSetText(string14);
            String string15 = "";
            String string16 = "cell rVersion ";
            if (bl5) {
                string15 = "color:" + com.corrodinggames.rts.gameFramework.GameUtils.h(Color.a(255, 155, 147, 147))
                        + ";";
                string16 = string16 + "nonMatchingRow ";
            } else {
                string15 = "color:" + com.corrodinggames.rts.gameFramework.GameUtils.h(n5) + ";";
            }
            element5.compareAndSetClassNames(string16);
            String string17 = "";
            string17 = element7.h ? (element7.m ? "P" : "Y") : "N";
            if (element7.a) {
                string17 = "L";
            }
            Element element6 = element4.findByClassName("rOpen");
            element6.compareAndSetText(string17);
            String string18 = "";
            String string19 = "cell rOpen ";
            if (!element7.h && !element7.a) {
                string18 = "color:" + com.corrodinggames.rts.gameFramework.GameUtils.h(Color.a(255, 155, 147, 147))
                        + ";";
                string19 = string19 + "notOpenRow ";
            } else {
                string18 = "color:" + com.corrodinggames.rts.gameFramework.GameUtils.h(n5) + ";";
            }
            element6.compareAndSetClassNames(string19);
            ++n4;
        }
        if (arrayList.size() == 0 && l2.networkEngine.bh != null) {
            String errorMessage = "ERROR: " + l2.networkEngine.bh;
            Element element7 = element2.clone();
            element3.appendChild(element7);
            element7.removeReference();
            element7.setText(errorMessage);
        }
        Element paddingElement = this.libRocket.getActiveElementById("padding");
        if (paddingElement == null && n2 > 0) {
            paddingElement = element2.clone();
            element3.appendChild(paddingElement);
            paddingElement.removeReference();
            paddingElement.setAttribute("id", "padding");
            paddingElement.addClass("serverRowMessage");
        }
        if (paddingElement != null && n2 > 0) {
            int n6 = 18;
            paddingElement.setStyle("height:" + n6 * n2 + "px;");
        }
        if (string4 != null) {
            Element element8 = this.libRocket.getActiveElementById(string4);
            element8.setText("Refresh");
        }
        GameEngine.b("DONE");
    }

    public void clickedServerRow(int n2) throws IOException {
        g g2 = (g) this.lastSortedDiscoveredServers.get(n2);
        this.clickedServer(g2.b);
    }

    public void clickedServer(String string2) throws IOException {
        String string3;
        g g2;
        if (this.getAlertOrPopup() != null) {
            this.logWarn("clickedServer: getAlertOrPopup!=null");
            return;
        }
        g2 = n.b(string2);
        if (g2 == null) {
            this.logWarn("clickedServer: server==null");
            this.alert("That server no longer exists");
            return;
        }
        String string4 = g2.b();
        String string5 = "Join Server?";
        if (g2.d()) {
            string3 = "[onenter]Open Link:";
            string3 = string3 + "closePopup(); openWhitelistedLink(" + this.restrictedString(g2.c()) + ");";
        } else if (!g2.a) {
            string3 = "[onenter]Join:";
            string3 = string3 + "closePopup(); joinServerWithId(" + this.restrictedString(g2.e()) + ","
                    + this.restrictedString(g2.b) + ");";
        } else {
            string3 = "[onenter]Join over LAN:";
            string3 = string3 + "closePopup(); joinServerWithId(" + this.restrictedString(g2.f()) + ","
                    + this.restrictedString(g2.b) + ");";
        }
        boolean bl2 = true;
        this.showPopup(null, string4, bl2, string3, null);
    }

    public void hideKeyboard() {
        this.guiEngine.m();
    }

    public void saveGame(String string2) {
        this.closePopup();
        this.hideKeyboard();
        string2 = string2.replace(".", "_");
        string2 = string2.replace("/", "_");
        string2 = string2.replace("\\", "_");
        GameEngine l2 = GameEngine.getInstance();
        l2.ca.b(string2, false);
    }

    public void exportMap(String string2) throws com.corrodinggames.rts.game.b.MapLoadException {
        this.closePopup();
        GameEngine l2 = GameEngine.getInstance();
        string2 = string2.replace(".", "_");
        string2 = string2.replace("/", "_");
        string2 = string2.replace("\\", "_");
        string2 = string2.replace("|", "_");
        string2 = string2.replace("?", "_");
        try {
            l2.bL.b(l2.menuBackgroundMapFile, "/SD/rusted_warfare_maps/" + string2 + ".tmx");
        } catch (IOException iOException) {
            this.showAlert("Failed to export map. IO error: " + iOException.getMessage());
            return;
        }
        this.showAlert("Map exported");
    }

    public void loadGame(String string2) throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.b("loading new save");
        l2.bv = false;
        if (l2.ca.c(string2, false)) {
            this.resumeNonMenu();
        }
    }

    public void loadGameEdit(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        String string3 = string2;
        e e2 = null;
        if (com.corrodinggames.rts.gameFramework.l.a.b()) {
            e2 = new e("Share", new Root$7(this, l2, string2));
        }
        e e3 = new e("Delete", new Root$8(this, l2, string2));
        boolean bl2 = true;
        this.showPopupWithButtons(null, string3, bl2, e2, e3);
    }

    public void loadReplay(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.bv = false;
        if (l2.cb.c(string2)) {
            this.resumeNonMenu();
        }
    }

    public void loadReplayEdit(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        String string3 = string2;
        e e2 = null;
        if (com.corrodinggames.rts.gameFramework.l.a.b()) {
            e2 = new e("Share", new Root$9(this, l2, string2));
        }
        e e3 = new e("Delete", new Root$10(this, l2, string2));
        boolean bl2 = true;
        this.showPopupWithButtons(null, string3, bl2, e2, e3);
    }

    public void makeSaveGamePopup(String string2) {
        String string3;
        GameEngine l2 = GameEngine.getInstance();
        String string4 = "Save Game";
        String string5 = "Enter a name to save the game under";
        if (string2 == null) {
            string3 = l2.al() + " (" + com.corrodinggames.rts.gameFramework.GameUtils.a("d MMM yyyy HH-mm-ss") + ")";
            string3 = string3.replace("  ", " ");
        } else {
            string3 = string2;
        }
        this.showInputPopup(string4, string5, string3, "[onenter]Save:saveGame(getPopupText())", null);
    }

    public void makeExportMapGamePopup(String string2) {
        String string3;
        GameEngine l2 = GameEngine.getInstance();
        String string4 = "Export Map";
        String string5 = "Enter a name to export the map as";
        if (string2 == null) {
            string3 = "New " + l2.al() + " - " + com.corrodinggames.rts.gameFramework.GameUtils.a("d MMM yyyy");
            string3 = string3.replace("  ", " ");
        } else {
            string3 = string2;
        }
        this.showInputPopup(string4, string5, string3, "[onenter]Export:exportMap(getPopupText())", null);
    }

    public void makeSendMessagePopup() {
        GameEngine l2 = GameEngine.getInstance();
        String string2 = "Send Message";
        String string3 = "[onenter]Send: sendChatMessage(getPopupText()); closePopup();";
        String string4 = "Switch - Team only: makeSendTeamMessagePopupWithDefaultText(getPopupText()); ";
        String string5 = "";
        this.showInputPopup(string2, string5, "", string3, string4);
    }

    public void makeSendTeamMessagePopup() {
        this.makeSendTeamMessagePopupWithDefaultText("");
    }

    public void makeSendTeamMessagePopupWithDefaultText(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        String string3 = "Send Team Message";
        String string4 = "+ Ping Map:sendTeamChatMessageAndPing(getPopupText()); closePopup();";
        String string5 = "";
        this.showInputPopup(string3, string5, string2,
                "[onenter]Send Team:sendTeamChatMessage(getPopupText()); closePopup();", string4);
    }

    public void sendChatMessage(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        this.guiEngine.m();
        if (string2 == null || string2.trim().equals("")) {
            return;
        }
        l2.networkEngine.m(string2);
        l2.bS.u = false;
    }

    public void sendTeamChatMessageAndPing(String string2) {
        this.sendTeamChatMessage(string2);
        GameEngine l2 = GameEngine.getInstance();
        l2.bS.I();
    }

    public void sendTeamChatMessage(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        this.guiEngine.m();
        if (string2 == null || string2.trim().equals("")) {
            return;
        }
        l2.networkEngine.l(string2);
    }

    public void receiveChatMessage(int n2, String string2, String string3,
            com.corrodinggames.rts.gameFramework.j.NetworkConnection c2) {
        this.refreshChat();
    }

    public void refreshChat() {
        GameEngine var1 = GameEngine.getInstance();
        if (this.libRocket.getActiveDocument() != null) {
            Element var2 = this.libRocket.getActiveElementById("chatLogHistory");
            if (var2 != null) {
                boolean var3 = var2.getAttributeBoolean("reversed", false);
                if (var1.networkEngine.F) {
                    Element var4 = this.libRocket.getActiveElementById("chatBox");
                    if (var4 != null) {
                        var4.hide();
                    }
                }

                var2.setInnerRML("");
                ConcurrentLinkedQueue var8 = var1.networkEngine.aC.b();
                StringBuffer var5 = new StringBuffer();
                Iterator var6 = var8.iterator();

                while (var6.hasNext()) {
                    com.corrodinggames.rts.gameFramework.j.b var7 = (com.corrodinggames.rts.gameFramework.j.b) var6
                            .next();
                    if (var3) {
                        var5.insert(0, "<div>" + var7.b() + "</div>");
                    } else {
                        var5.append("<div>" + var7.b() + "</div>");
                    }
                }

                var5.append("<div id='chatLastRowSpacer'></div>");
                var2.setInnerRML(var5.toString());
                var2.loadCharsetIfNeededWithCurrentText();
                Element var9 = this.libRocket.getActiveElementById("chatLastRowSpacer");
                if (var9 != null) {
                    var9.scrollIntoView(false);
                }

            }
        }
    }

    public void trace(String string2) {
        GameEngine.log("Trace:" + string2);
    }

    public void updateTableTextOnly(String string2, Root$TableData root$TableData, Root$TableData root$TableData2) {
        ArrayList arrayList = root$TableData.rows;
        Element element = this.libRocket.getActiveElementById(string2);
        if (element == null) {
            GameEngine.b("updateTableText: tableElement:" + string2 + " is null, we may have changed page");
            return;
        }
        Element element2 = element.getElementById("tableListData");
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            Root$TableRow root$TableRow = (Root$TableRow) arrayList.get(i2);
            for (int i3 = 0; i3 < root$TableRow.tableCells.size(); ++i3) {
                Root$TableCell root$TableCell = (Root$TableCell) root$TableRow.tableCells.get(i3);
                Element element3 = element2.getChild(i2);
                if (element3 == null) {
                    GameEngine.b("updateTableText failed to get row " + i2);
                    return;
                }
                Element element4 = element3.getChild(i3);
                if (element4 == null) {
                    GameEngine.b("updateTableText failed to get cell " + i3);
                    return;
                }
                element4.compareAndSetText(root$TableCell.text);
            }
        }
    }

    public void refreshTable(String string2, Root$TableData root$TableData) {
        ArrayList<Root$TableRow> arrayList = root$TableData.rows;
        Element element = this.libRocket.getActiveElementById(string2);
        if (element == null) {
            GameEngine.b("refreshTable: tableElement:" + string2 + " is null, we may have changed page");
            return;
        }
        Element element2 = element.getElementById("tableRowTemplateHolder");
        Element element3 = element.getElementById("tableListData");
        Element element4 = element2.findByClassName("rowTemplate").getChild(0);
        Element element5 = element2.findByClassName("cellTemplate").getChild(0);
        element3.setInnerRML("");
        for (Root$TableRow root$TableRow : arrayList) {
            Element element6 = element4.cloneAndFix();
            if (root$TableRow.librocketOnClick != null) {
                element6.setAttribute("onclick", root$TableRow.librocketOnClick);
            }
            if (root$TableRow.extraClasses != null) {
                element6.addClass(root$TableRow.extraClasses);
            }
            for (Root$TableCell root$TableCell : root$TableRow.tableCells) {
                Element element7 = element5.cloneAndFix();
                element7.compareAndSetText(root$TableCell.text);
                if (root$TableCell.librocketOnClick != null) {
                    element7.setAttribute("onclick", root$TableCell.librocketOnClick);
                    element7.addClass("clickablecell");
                }
                if (root$TableCell.classes != null) {
                    element7.addClass(root$TableCell.classes);
                }
                if (root$TableCell.color != null) {
                    element7.setAttribute("style",
                            "color:" + com.corrodinggames.rts.gameFramework.GameUtils.h(root$TableCell.color) + ";");
                }
                element6.appendChild(element7);
                element7.removeReference();
            }
            element3.appendChild(element6);
            element6.removeReference();
        }
    }

    public ElementDocument createAndShowPopup(String string2, Object object, String string3) throws IOException {
        return this.libRocket.a(string2, object, string3, true);
    }

    public ElementDocument createPopupHidden(String string2, Object object, String string3) throws IOException {
        return this.libRocket.a(string2, object, string3, false);
    }

    public boolean tryToShowPopupDocument(ElementDocument elementDocument) {
        return this.libRocket.b(elementDocument);
    }

    public void showMainMenu() {
        GameEngine.getInstance().bS.u = false;
        a.a().b();
    }

    public void onEnter() {
        ElementDocument elementDocument = this.libRocket.g();
        if (elementDocument == null) {
            GameEngine.log("onEnter: elementDocument==null");
            return;
        }
        ArrayList<Element> arrayList = elementDocument.getAllNestedChildren();
        for (Element element : arrayList) {
            String string2 = element.getAttribute("onenter");
            if (string2 == null || !element.isFocused())
                continue;
            this.scriptEngine.processScript(string2);
        }
    }

    public void scrollFromFocusedElement(float f2) {
        ElementDocument elementDocument = this.libRocket.g();
        if (elementDocument == null) {
            GameEngine.log("onEnter: elementDocument==null");
            return;
        }
        Element element = elementDocument.getTopLevelFocusedElement();
        if (element == null) {
            GameEngine.log("focusedElement: Not found");
            return;
        }
        ArrayList<Element> arrayList = elementDocument.getChainFromChildElement(element);
        if (arrayList == null) {
            GameEngine.log("scrollFromFocusedElement: Failed to find chain");
            return;
        }
        for (Element element2 : arrayList) {
            boolean bl2 = false;
            if ("scrollDiv".equals(element2.getId())) {
                bl2 = true;
            }
            if (element2.hasClassName("slider")) {
                bl2 = true;
            }
            if (!bl2)
                continue;
            float f3 = element2.getScrollTop();
            element2.setScrollTop(f3 += f2);
            return;
        }
        GameEngine.log("Found no slider element to offset");
    }

    public boolean isSliderOrUIElementSelected() {
        ElementDocument elementDocument = this.libRocket.g();
        if (elementDocument == null) {
            GameEngine.log("onEnter: elementDocument==null");
            return false;
        }
        Element element = elementDocument.getTopLevelFocusedElement();
        if (element != null) {
            Element element2 = element;
            String string2 = element2.getTagName();
            boolean bl2 = false;
            if ("scrollDiv".equals(element2.getId())) {
                bl2 = true;
            }
            if (element2.hasClassName("slider")) {
                bl2 = true;
            }
            if ("input".equals(string2) && "range".equals(element2.getAttribute("type", "text"))) {
                bl2 = true;
            }
            if (bl2) {
                GameEngine.log("Slider element: true");
                return true;
            }
            GameEngine.log("Slider element: false");
        }
        GameEngine.log("Slider element: no element focused");
        return false;
    }

    public void onTouch() {
        ElementDocument elementDocument = this.libRocket.g();
        if (elementDocument == null) {
            GameEngine.log("onEnter: elementDocument==null");
            return;
        }
        ArrayList<Element> arrayList = elementDocument.getAllNestedChildren();
        for (Element element : arrayList) {
            String string2 = element.getAttribute("type");
            if (!"text".equals(string2) || !element.isFocused())
                continue;
            this.guiEngine.l();
        }
    }

    public void onEscape() {
        ElementDocument elementDocument = this.libRocket.g();
        if (elementDocument == null) {
            GameEngine.log("onEscape: elementDocument==null");
            return;
        }
        boolean bl2 = false;
        ArrayList<Element> arrayList = elementDocument.getAllNestedChildren();
        for (Element element : arrayList) {
            String string2 = element.getAttribute("click_on_escape");
            if (string2 == null)
                continue;
            element.click();
            bl2 = true;
            break;
        }
        if (bl2) {
            return;
        }
        if (this.closePopup()) {
            return;
        }
    }

    public void askQuitGame() {
        this.closePopup();
        String string2 = "Are you sure you want to quit?";
        String string3 = "";
        String string4 = "[onenter]Quit:";
        string4 = string4 + "closePopup(); exit();";
        boolean bl2 = true;
        this.showPopup(string2, string3, bl2, string4, null);
    }

    public String getCurrentDocumentPath() {
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        if (elementDocument == null) {
            return null;
        }
        return elementDocument.documentPath;
    }

    public String getCurrentPopupPath() {
        ElementDocument elementDocument = this.libRocket.c();
        if (elementDocument == null) {
            return null;
        }
        return elementDocument.documentPath;
    }

    public String getCreditsText() {
        return "Credits goes here";
    }

    public void runRunnable(Runnable runnable) {
        this.logDebug("runRunnable");
        if (runnable == null) {
            this.logDebug("runnable==null");
        }
        runnable.run();
    }

    public boolean isLinux() {
        return com.corrodinggames.rts.gameFramework.OSUtils.a() == h_f9.c;
    }

    public boolean not(boolean bl2) {
        return !bl2;
    }

    public boolean and(boolean bl2, boolean bl3) {
        return bl2 && bl3;
    }

    public boolean or(boolean bl2, boolean bl3) {
        return bl2 || bl3;
    }

    public void showBattleroom() {
        String string2 = "battleroom.rml";
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        boolean bl2 = true;
        if (elementDocument != null && string2.equals(elementDocument.documentPath)) {
            GameEngine.log("Already on battleroom page");
            bl2 = false;
        }
        this.libRocket.setDocument(string2, null, bl2);
    }

    public void setDocument(String string2) {
        this.libRocket.setDocument(string2);
    }

    public void playNextMusicTrack() {
        GameEngine.getInstance().bN.e();
    }

    public void toggleMusic() {
        GameEngine.getInstance().bN.u = !GameEngine.getInstance().bN.u;
    }

    public void updateMusicButton(String string2) {
        Element element = this.libRocket.getActiveElementById(string2);
        if (element != null) {
            if (GameEngine.getInstance().bN.u) {
                element.setText(">");
            } else {
                element.setText("||");
            }
        }
    }

    public void setSandboxMapFromPopup(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        this.closePopup();
        String string3 = string2;
        this.libRocket.getActiveDocument().setMetadata("mode", string2);
        this.showLevelOptions();
        this.libRocket.getActiveDocument().findByClassName("mapImage").setAttribute("src",
                this.getMapThumbnail(string3));
        this.libRocket.getActiveDocument().findByClassName("mapText").setText(this.getMapNameFromPath(string3));
    }

    public void showSandboxMapSelectOnChange() throws IOException {
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        Element element = elementDocument.getElementById("typeSelector");
        int n2 = Integer.parseInt(element.getValue());
        int n3 = (Integer) elementDocument.getMetadata("lastTypeSelector", 0);
        this.libRocket.getActiveDocument().setMetadata("lastTypeSelector", n2);
        if (n2 != n3) {
            this.showSandboxMapSelect();
        }
    }

    public void showSandboxMapSelect() throws IOException {
        String string2 = this.getModeMapPath(this.libRocket.getActiveDocument(), "typeSelector");
        this.showMapPopup(string2, "setSandboxMapFromPopup");
    }

    public String getModeMapPath(Element element, String string2) {
        int n2;
        GameEngine l2 = GameEngine.getInstance();
        if (string2 == null) {
            if (l2.networkEngine.ay.a == null) {
                GameEngine.b("getModeMapPath: currentType==0");
                n2 = 0;
            } else {
                n2 = l2.networkEngine.ay.a.ordinal();
            }
        } else {
            Element element2 = element.getElementById(string2);
            if (element2 == null) {
                GameEngine.g("getModeMapPath: typeSelector==null");
                n2 = 0;
            } else {
                n2 = element2.getValueAsInt(0);
            }
        }
        if (n2 == 0) {
            return "maps/skirmish";
        }
        if (n2 == 1) {
            return "/SD/rusted_warfare_maps";
        }
        if (n2 == 2) {
            return "saves";
        }
        throw new RuntimeException("Unknown typeIndex:" + n2);
    }

    public void event_unicodeEntered() {
        ElementDocument elementDocument = this.libRocket.g();
        if (elementDocument != null) {
            Element element = elementDocument.findByClassName("textinputUnicodeWrap");
            if (element != null) {
                element.compareAndAddClass("unicodeWasTyped");
            } else {
                GameEngine.log("event_unicodeEntered: missing textinput");
            }
        } else {
            GameEngine.log("event_unicodeEntered: missing document");
        }
    }

    public boolean isVersionBeta() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.isBetaVersion();
    }

    public Object ifCondition(boolean bl2, Object object, Object object2) {
        return bl2 ? object : object2;
    }

    public String i(String string2) {
        return com.corrodinggames.rts.gameFramework.h.a.a(string2, new Object[0]);
    }

    public void openLinkToCG(String string2) {
        String string3 = "http://corrodinggames.com/" + string2;
        this.openWhitelistedLink(string3);
    }

    public void openWhitelistedLink(String string2) {
        GameEngine.log("Opening link:" + string2);
        if (!(string2.startsWith("http://corrodinggames.com/") || string2.startsWith("https://corrodinggames.com/")
                || string2.startsWith("http://corrodinggames.net/")
                || string2.startsWith("https://corrodinggames.net/"))) {
            GameEngine.log("Not in whitelist");
            return;
        }
        if (this.guiEngine.b(string2)) {
            this.alert("Opened link: " + string2);
            return;
        }
        this.alert("Sorry couldn't load browser to: " + string2 + " please navigate manually");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeGameLog(String var1) {
        StringBuffer var2 = new StringBuffer();
        boolean var3 = false;
        LinkedList var4 = com.corrodinggames.librocket.a.a().k();
        if (var4 == null) {
            var3 = true;
        } else {
            synchronized (var4) {
                int var6 = com.corrodinggames.rts.gameFramework.GameUtils.b(0, var4.size() - 3000);
                ListIterator var7 = var4.listIterator(var6);

                while (var7.hasNext()) {
                    var2.append(Element.excapeHTML((String) var7.next()));
                    var2.append("<br/>");
                }
            }
        }

        if (var3) {
            this.alert("Internal game logging not active");
        } else {
            GameEngine.log("writeGameLog ready");
            Element var10 = this.libRocket.getActiveElementById(var1);
            if (var10 == null) {
                GameEngine.log("Failed to find: " + var1);
            } else {
                var10.setInnerRML(var2.toString());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void exportGameLog() {
        ListIterator object;
        Object object2;
        StringBuffer stringBuffer = new StringBuffer();
        boolean bl2 = false;
        Object object3 = a.a().k();
        if (object3 == null) {
            bl2 = true;
        } else {
            object2 = object3;
            synchronized (object2) {
                int n2 = com.corrodinggames.rts.gameFramework.GameUtils.b(0, ((LinkedList) object3).size() - 3000);
                object = ((LinkedList) object3).listIterator(n2);
                while (object.hasNext()) {
                    stringBuffer.append(Element.excapeHTML((String) object.next()));
                    stringBuffer.append("\n");
                }
            }
        }
        if (bl2) {
            this.alert("Internal game logging not active");
            return;
        }
        try {
            object3 = "/SD/rustedWarfare/RustedWarfareLog-"
                    + com.corrodinggames.rts.gameFramework.GameUtils.a("d_MMM_yyyy_HH.mm.ss") + ".txt";
            object2 = com.corrodinggames.rts.gameFramework.storage.a.e((String) object3);
            File file = new File((String) object2);
            object = (ListIterator) new FileWriter(file);
            ((OutputStreamWriter) object).append(stringBuffer.toString());
            ((OutputStreamWriter) object).flush();
            ((OutputStreamWriter) object).close();
            com.corrodinggames.rts.gameFramework.l.a.a(file);
            file.deleteOnExit();
        } catch (Exception exception) {
            exception.printStackTrace();
            this.alert("Failed to export logs: " + exception.getMessage());
            return;
        }
    }

    public void setPageMinWidthAndHeight(float f2, float f3) {
        GameEngine.log("setPageMinWidthAndHeight(" + f2 + ", " + f3 + ")");
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        if (elementDocument == null) {
            GameEngine.log("setPageMinWidthAndHeight - no page");
            return;
        }
        elementDocument.setMetadataFloat("minWidth", Float.valueOf(f2));
        elementDocument.setMetadataFloat("minHeight", Float.valueOf(f3));
        this.guiEngine.n();
    }

    public void importFilePopup() {
        Root$11 root$11 = new Root$11(this);
        com.corrodinggames.rts.gameFramework.l.a.a(root$11);
    }

    protected void setDocumentUpdate(ElementDocument elementDocument, Runnable runnable) {
        elementDocument.setMetadata("onUpdateFunction", runnable);
    }

    public void onFrameUpdate(float f2) {
        Object object;
        ElementDocument elementDocument = this.libRocket.getActiveDocument();
        if (elementDocument != null && (object = elementDocument.getMetadata("onUpdateFunction")) != null) {
            Runnable runnable = (Runnable) object;
            runnable.run();
        }
    }
}
