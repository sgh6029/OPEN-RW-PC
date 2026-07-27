/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import com.corrodinggames.librocket.scripts.Debug$1;
import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.librocket.scripts.ScriptContext;
import com.corrodinggames.rts.a.DebugSocketServer;
import com.corrodinggames.rts.a.a.n;
import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.Tree;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.d.l;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.GameCommand;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.GameRoomSettings;
import com.corrodinggames.rts.gameFramework.j.GameModeType;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.k.d;
import com.corrodinggames.rts.gameFramework.k.m;
import com.corrodinggames.rts.gameFramework.k.p;
import com.corrodinggames.rts.gameFramework.utility.r;

import test.rudp.ReliableSocket;

import com.corrodinggames.rts.gameFramework.GGameObject;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Debug
        extends ScriptContext {
    Root root;
    boolean allFeatures;
    ConcurrentLinkedQueue backgroundClientConnections;
    Thread backgroundConnectionThread;
    Runnable backgroundConnectionRunnable = new Debug$1(this);
    boolean forceNonThreaded = true;

    Debug(Root root) {
        this.root = root;
    }

    public int currentPid() {
        try {
            // Try Java 9+ approach first
            try {
                Class<?> processHandleClass = Class.forName("java.lang.ProcessHandle");
                Method currentMethod = processHandleClass.getMethod("current");
                Method pidMethod = processHandleClass.getMethod("pid");
                Object currentHandle = currentMethod.invoke(null);
                long pid = (Long) pidMethod.invoke(currentHandle);
                return (int) pid;
            } catch (Exception e) {
                // Fallback for older Java versions
                String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
                if (processName.contains("@")) {
                    String pidStr = processName.split("@")[0];
                    return Integer.parseInt(pidStr);
                }
                return -1;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return -1;
        }
    }

    public void setLocalPlayerName(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.a(string2);
    }

    public void setDdosProtection(boolean bl2) {
        com.corrodinggames.rts.gameFramework.j.ConnectionAcceptor.b = bl2;
    }

    public void lookAt(float f2, float f3) {
        GameEngine l2 = GameEngine.getInstance();
        l2.b(f2, f3);
    }

    public void createManyUnits(String string2, float f2, float f3, int n2, boolean bl2, int n3) {
        int n4 = 0;
        int n5 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            if ((n4 += 9) > 400) {
                n4 = 0;
                n5 += 9;
            }
            this.createUnit(string2, f2 + (float) n4, f3 + (float) n5, n2, i2 == 0 ? bl2 : false);
        }
    }

    public Long createUnit(String string2, float f2, float f3, int n2, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        UnitType as2 = UnitTypeEnum.a(string2);
        if (as2 == null) {
            this.root.logWarn("Could not find type:" + string2);
            return null;
        }
        BaseUnit am2 = as2.createUnitInstance();
        am2.posX = f2;
        am2.posY = f3;
        try {
            am2.Q(n2);
        } catch (com.corrodinggames.rts.game.b.MapLoadException f4) {
            throw new RuntimeException(f4);
        }
        com.corrodinggames.rts.game.PlayerTeam.c(am2);
        am2.cK = true;
        if (bl2) {
            l2.b(f2, f3);
        }
        return am2.objectId;
    }

    public int getMaxCustomUnitTypeId() {
        return com.corrodinggames.rts.game.units.custom.l.d.size();
    }

    public Long createCustomUnitFromTypeId(int n2, float f2, float f3, int n3, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.game.units.custom.l l3 = (com.corrodinggames.rts.game.units.custom.l) com.corrodinggames.rts.game.units.custom.l.d
                .get(n2);
        BaseUnit am2 = l3.createUnitInstance();
        am2.posX = f2;
        am2.posY = f3;
        try {
            am2.Q(n3);
        } catch (com.corrodinggames.rts.game.b.MapLoadException f4) {
            throw new RuntimeException(f4);
        }
        com.corrodinggames.rts.game.PlayerTeam.c(am2);
        am2.cK = true;
        if (bl2) {
            l2.b(f2, f3);
        }
        return am2.objectId;
    }

    public void enableFeatures(String string2) {
        String string3 = GameUtils.e(string2);
        if (string3.startsWith("221FC410BD29D786")) {
            this.allFeatures = true;
            DebugSocketServer.field_d = true;
            return;
        }
        throw new RuntimeException("unknown");
    }

    public void selectNextUnit() {
        GameEngine l2 = GameEngine.getInstance();
        BaseUnit am2 = null;
        boolean bl2 = false;
        List<BaseUnit> aaa = BaseUnit.bF();
        for (BaseUnit am3 : aaa) {
            BaseUnit am4;
            if (!(am3 instanceof BaseUnit) || (am4 = am3) instanceof Tree || am4.t())
                continue;
            if (am2 == null) {
                am2 = am4;
            }
            if (bl2) {
                am2 = am4;
                break;
            }
            bl2 = am4.cG;
        }
        l2.bS.y();
        if (am2 != null) {
            l2.bS.j(am2);
        }
    }

    public void removeAllUnits() {
        List<GGameObject> tmp = GGameObject.dK();
        for (GGameObject w2 : tmp) {
            w2.a();
        }
    }

    public void killAllUnits() {
        List<BaseUnit> tmp = BaseUnit.bF();
        for (BaseUnit am2 : tmp) {
            if (!(am2 instanceof BaseUnit))
                continue;
            BaseUnit am3 = am2;
            am3.cu = -1.0f;
        }
    }

    public boolean backgroundCurrentClientConnection() {
        if (!this.allFeatures) {
            return false;
        }
        GameEngine l2 = GameEngine.getInstance();
        if (!l2.networkEngine.B) {
            GameEngine.log("Not networked");
            return false;
        }
        if (l2.networkEngine.C) {
            throw new RuntimeException("server=true");
        }
        if (this.backgroundConnectionThread == null) {
            this.backgroundConnectionThread = new Thread(this.backgroundConnectionRunnable);
            this.backgroundConnectionThread.start();
        }
        if (this.backgroundClientConnections == null) {
            this.backgroundClientConnections = new ConcurrentLinkedQueue();
        }

        ConcurrentLinkedQueue<com.corrodinggames.rts.gameFramework.j.NetworkConnection> tmp = l2.networkEngine.aM;
        for (com.corrodinggames.rts.gameFramework.j.NetworkConnection c2 : tmp) {
            c2.t = true;
            this.backgroundClientConnections.add(c2);
            l2.networkEngine.aM.remove(c2);
        }
        l2.networkEngine.b("backgrounded");
        l2.networkEngine.B = true;
        return true;
    }

    public boolean isTeamWipedOut(int n2) {
        com.corrodinggames.rts.game.PlayerTeam n3 = com.corrodinggames.rts.game.PlayerTeam.k(n2);
        if (n3 == null) {
            this.root.logWarn("Could not find team:" + n2);
            return true;
        }
        return n3.G;
    }

    public boolean isTeamDefeated(int n2) {
        com.corrodinggames.rts.game.PlayerTeam n3 = com.corrodinggames.rts.game.PlayerTeam.k(n2);
        if (n3 == null) {
            this.root.logWarn("Could not find team:" + n2);
            return true;
        }
        return n3.G;
    }

    public boolean isTeamInVictory(int n2) {
        com.corrodinggames.rts.game.PlayerTeam n3 = com.corrodinggames.rts.game.PlayerTeam.k(n2);
        if (n3 == null) {
            this.root.logWarn("Could not find team:" + n2);
            return false;
        }
        return n3.H;
    }

    public String getPlayerName(int n2) {
        com.corrodinggames.rts.game.PlayerTeam n3 = com.corrodinggames.rts.game.PlayerTeam.k(n2);
        if (n3 == null) {
            this.root.logWarn("Could not find team:" + n2);
            return null;
        }
        return n3.v;
    }

    public String getQueryStringOfPlayer(int n2) {
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.game.PlayerTeam n3 = com.corrodinggames.rts.game.PlayerTeam.k(n2);
        if (n3 == null) {
            this.root.logWarn("Could not find team:" + n2);
            return null;
        }
        com.corrodinggames.rts.gameFramework.j.NetworkConnection c2 = l2.networkEngine.c(n3);
        if (c2 == null) {
            this.root.logWarn("Found team but could not find connection for team:" + n2);
            return null;
        }
        return c2.o;
    }

    public boolean setTeamCredits(int n2, int n3) {
        com.corrodinggames.rts.game.PlayerTeam n4 = com.corrodinggames.rts.game.PlayerTeam.k(n2);
        if (n4 == null) {
            this.root.logWarn("Could not find team:" + n2);
            return false;
        }
        n4.o = n3;
        return true;
    }

    public boolean setTeamAllyGroup(int n2, int n3) {
        com.corrodinggames.rts.game.PlayerTeam n4 = com.corrodinggames.rts.game.PlayerTeam.k(n2);
        if (n4 == null) {
            this.root.logWarn("Could not find team:" + n2);
            return false;
        }
        n4.r = n3;
        return true;
    }

    public void giveUpgradeToAllUnits() {
        List<BaseUnit> tmp = BaseUnit.bF();
        for (BaseUnit am2 : tmp) {
            ActionId c2;
            y y2;
            AbstractUnitAction s2;
            if (!(am2 instanceof y) || (s2 = (y2 = (y) am2).a(c2 = y2.cm())) == null)
                continue;
            y2.a(s2, false);
        }
    }

    public void giveAllActionsToAllUnits() {
        List<BaseUnit> tmp = BaseUnit.bF();
        for (BaseUnit am2 : tmp) {
            if (!(am2 instanceof y))
                continue;
            y y2 = (y) am2;
            List<AbstractUnitAction> tmp2 = y2.N();
            for (AbstractUnitAction s2 : tmp2) {
                y2.a(s2, false);
            }
        }
    }

    public void completeAllUnitsQueues() {
        List<BaseUnit> tmp = BaseUnit.bF();
        for (BaseUnit am2 : tmp) {
            if (!(am2 instanceof l))
                continue;
            l l2 = (l) ((Object) am2);
            l2.dz();
        }
    }

    public boolean moveAllUnitsOnTeam(int n2, float f2, float f3) {
        com.corrodinggames.rts.game.PlayerTeam n3 = com.corrodinggames.rts.game.PlayerTeam.k(n2);
        if (n3 == null) {
            this.root.logWarn("Could not find team:" + n2);
            return false;
        }
        GameEngine l2 = GameEngine.getInstance();
        GameCommand e2 = l2.cf.b(n3);
        List<BaseUnit> tmp = BaseUnit.bF();
        for (BaseUnit am2 : tmp) {
            if (!(am2 instanceof y))
                continue;
            y y2 = (y) am2;
            if (y2.bX != n3)
                continue;
            e2.a(y2);
        }
        e2.a(f2, f3);
        return true;
    }

    public void showMessage(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        if (string2 == null || string2.trim().equals("")) {
            return;
        }
        string2 = string2.replace("\\n", "\n");
        l2.networkEngine.m(string2);
    }

    public String unicodeTest1() {
        return "start \u00a5123 \u061c end";
    }

    public void setZoom(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.cV = f2;
    }

    public boolean isNetworkGameActive() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.N();
    }

    public int getLocalPlayerId() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.networkEngine.z.k;
    }

    public int numberOfHumanPlayers() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.networkEngine.an();
    }

    public int numberOfPlayersPlusAI() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.networkEngine.ao();
    }

    public int numberOfPlayerConnections() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.networkEngine.B();
    }

    public boolean enableFastSync() {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.ai = 30;
        return true;
    }

    public boolean enableExtraNetworkDebug() {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.g = true;
        return true;
    }

    public boolean throwIfAnyPlayerNotInSync() {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.x();
        return true;
    }

    public boolean enableFastResyncTimer() {
        NetworkEngine.c = true;
        return true;
    }

    public boolean enablePauseOnDesync() {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.aj = true;
        return true;
    }

    public boolean networkSetIncomeMultiplier(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        GameRoomSettings ah2 = l2.networkEngine.e();
        ah2.h = f2;
        l2.networkEngine.a(ah2);
        return true;
    }

    public boolean networkSetPortNumber(int n2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.bQ.networkPort = n2;
        return true;
    }

    public boolean networkSetUdp(boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.bQ.udpInMultiplayer = bl2;
        return true;
    }

    public boolean networkDisconnect() {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.b("debug");
        return true;
    }

    public boolean networkAbort() {
        GameEngine l2 = GameEngine.getInstance();
            ConcurrentLinkedQueue<com.corrodinggames.rts.gameFramework.j.NetworkConnection > tmp =l2.networkEngine.aM;
        for (com.corrodinggames.rts.gameFramework.j.NetworkConnection c2 : tmp) {
            if (!(c2.d instanceof ReliableSocket))
                continue;
            GameEngine.log("Closing: " + c2.g());
            ((ReliableSocket) c2.d).d();
        }
        l2.networkEngine.b("debug");
        return true;
    }

    public boolean disableNetworkOwnInfo() {
        NetworkEngine.r = false;
        return true;
    }

    public boolean networkPause() {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.aj = true;
        l2.networkEngine.ak = true;
        return true;
    }

    public boolean plainTextDebugSave(boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        com.corrodinggames.rts.gameFramework.GameSaver.a = bl2;
        return true;
    }

    public boolean checkDesync(int n2) {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.networkEngine.ap != 0) {
            throw new RuntimeException("numberOfDesyncErrors==" + l2.networkEngine.ap);
        }
        if (l2.networkEngine.aq < n2) {
            throw new RuntimeException("game.network.numberOfDesyncPasses:" + l2.networkEngine.aq + "<" + n2);
        }
        this.root.logDebug("numberOfDesyncPasses:" + l2.networkEngine.aq);
        return true;
    }

    public int getNumberOfDesyncErrors() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.networkEngine.ap;
    }

    public int getNumberOfDesyncPasses() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.networkEngine.aq;
    }

    public int getNumberOfResyncSendsOrRecv() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.networkEngine.ar;
    }

    public boolean setMultiplayerMap(int n2, String string2) {
        GameEngine l2 = GameEngine.getInstance();
        GameRoomSettings ah2 = l2.networkEngine.ay;
        ah2.a = GameModeType.values()[n2];
        ah2.b = string2;
        return true;
    }

    public boolean setMultiplayerSave(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        GameRoomSettings ah2 = l2.networkEngine.ay;
        ah2.a = GameModeType.savedGame;
        ah2.b = string2;
        return true;
    }

    public void generateNewClientId() {
        GameEngine l2 = GameEngine.getInstance();
        l2.networkEngine.Y();
    }

    public void disableFog() {
        GameEngine l2 = GameEngine.getInstance();
    }

    public void overrideDeltaSpeed(float f2) {
        GameEngine l2 = GameEngine.getInstance();
        l2.bu = f2;
    }

    public void setGameSetting(String string2, String string3) {
        GameEngine l2 = GameEngine.getInstance();
        l2.bQ.setValueDynamic(string2, string3);
    }

    public void setNetworkaiDifficulty(int n2) {
        GameEngine l2 = GameEngine.getInstance();
        GameRoomSettings ah2 = l2.networkEngine.e();
        ah2.f = n2;
        l2.networkEngine.a(ah2);
    }

    public void setNetworkStartingUnits(int n2) {
        GameEngine l2 = GameEngine.getInstance();
        GameRoomSettings ah2 = l2.networkEngine.e();
        ah2.g = n2;
        l2.networkEngine.a(ah2);
    }

    public void startRandomUnitDesyncTest() {
        GameEngine l2 = GameEngine.getInstance();
        GameCommand e2 = l2.cf.b();
        e2.i = com.corrodinggames.rts.game.PlayerTeam.i;
        e2.r = true;
        e2.u = 1;
        l2.networkEngine.a(e2);
    }

    public void startRandomUnitStressTest() {
        GameEngine l2 = GameEngine.getInstance();
        GameCommand e2 = l2.cf.b();
        e2.i = com.corrodinggames.rts.game.PlayerTeam.i;
        e2.r = true;
        e2.u = 2;
        l2.networkEngine.a(e2);
    }

    public void runAllUnitTests() {
        this.root.logWarn("Running unit tests..");
        n n2 = new n();
        n2.a();
    }

    public void runAllLeakTests() {
        this.root.logWarn("Running leak tests..");
        com.corrodinggames.rts.a.a.b b2 = new com.corrodinggames.rts.a.a.b();
        b2.a();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean loadSaveFromSystemPath(String string2) throws FileNotFoundException {
        boolean bl2;
        GameEngine l2 = GameEngine.getInstance();
        File file = new File(string2);
        FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        GameInputStream k2 = new GameInputStream(dataInputStream);
        try {
            bl2 = l2.ca.a(k2, false, false, false);
        } catch (Throwable throwable) {
            try {
                dataInputStream.close();
                bufferedInputStream.close();
                fileInputStream.close();
                throw throwable;
            } catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
        try {
            dataInputStream.close();
        bufferedInputStream.close();
        fileInputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bl2;
    }

    public void checkTeamCaches() {
            List<com.corrodinggames.rts.game.PlayerTeam> tmp =com.corrodinggames.rts.game.PlayerTeam.c();
        for (com.corrodinggames.rts.game.PlayerTeam n2 : tmp) {
            if (!n2.t())
                continue;
            throw new RuntimeException("Team cache difference on team:" + n2.k);
        }
    }

    public void setPathSpeedConf(boolean bl2) {
        this.forceNonThreaded = bl2;
    }

    public float getPathSpeed(int n2, float f2, float f3, float f4, float f5) {
        GameEngine l2 = GameEngine.getInstance();
        TileMap b2 = l2.bL;
        ArrayList<com.corrodinggames.rts.gameFramework.k.k> arrayList = new ArrayList<com.corrodinggames.rts.gameFramework.k.k>();
        b2.a(f4, f5);
        int n3 = b2.T;
        int n4 = b2.U;
        long l3 = PerformanceProfiler.a();
        d.a = 0;
        d.b = 0;
        d.c = 0;
        d.d = 0;
        d.e = 0;
        d.f = 0;
        d.g = 0;
        d.h = 0.0;
        d.i = 0.0;
        m.c = 0;
        d.u = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            com.corrodinggames.rts.gameFramework.k.k k2 = l2.bU.a(false);
            b2.a(f2, f3);
            k2.a(UnitMovementType.LAND, (short) b2.T, (short) b2.U, null, false);
            b2.a(f4, f5);
            k2.a((short) b2.T, (short) b2.U, (short) 0);
            k2.p = true;
            k2.q = 0;
            k2.r = false;
            l2.bU.a(k2, false, this.forceNonThreaded);
            arrayList.add(k2);
        }
        if (!this.forceNonThreaded) {
            return -1.0f;
        }
        float f6 = PerformanceProfiler.a(l3);
        int n5 = -1;
        for (com.corrodinggames.rts.gameFramework.k.k k3 : arrayList) {
            Object object;
            LinkedList linkedList = k3.a();
            int n6 = 0;
            for (Object object2 : linkedList) {
                ++n6;
            }
            if (n5 != -1 && n5 != n6) {
                object = "pathDistance inconsistency detected:" + n5 + "!=" + n6;
                com.corrodinggames.rts.gameFramework.GameEngine.b((String) object);
            }
            object = (p) linkedList.getLast();
            if (((p) object).a != n3 || ((p) object).b != n4) {
                Object object2;
                object2 = "path did not react goal, got to:" + ((p) object).a + "," + ((p) object).b + " (vs " + n3
                        + ", " + n4 + ")";
                com.corrodinggames.rts.gameFramework.GameEngine.b((String) object2);
            }
            n5 = n6;
        }
        com.corrodinggames.rts.gameFramework.GameEngine
                .b("hotBufferWatermark:" + d.a + ", nodesAdded:" + d.d + ", mainQueueWatermark:" + d.b
                        + ", backlogWatermark:" + d.c + ", scannedA:" + d.e + ", scannedB:" + d.f + ", scannedC:" + d.g
                        + ", time:" + PerformanceProfiler.a(d.i) + "/" + PerformanceProfiler.a(d.h) + ", dirtyPeak:" + d.u + ", dis:" + n5);
        if (m.c != 0) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("newNodesCreated:" + m.c);
        }
        return f6;
    }

    public void muteSounds() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bM.b = true;
        l2.bN.f();
    }

    public void pong() {
    }
}
