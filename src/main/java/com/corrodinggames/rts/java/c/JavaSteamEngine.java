/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.c;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamFriends;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamMatchmaking;
import com.codedisaster.steamworks.SteamMatchmaking$LobbyType;
import com.codedisaster.steamworks.SteamNetworking;
import com.codedisaster.steamworks.SteamNetworking$API;
import com.codedisaster.steamworks.SteamUGC;
import com.codedisaster.steamworks.SteamUtils;
import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine;
import com.corrodinggames.rts.java.c.b$1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;


import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.java.c.JavaSteamEngine;


public class JavaSteamEngine
        extends DisabledSteamEngine {
    SteamFriendsCallbackHandler b;
    SteamFriends c;
    SteamMatchmaking d;
    SteamMatchmakingCallbackHandler e;
    SteamNetworkingCallbackHandler f;
    SteamWorkshopManager g;
    SteamNetworking h;
    SteamUtilsCallbackHandler i;
    SteamUtils j;
    boolean k = false;
    HashMap l = new HashMap();
    ByteBuffer m;
    SteamID n;
    boolean o;
    SteamID p;

    public SteamWorkshopManager n() {
        return this.g;
    }

    @Override
    public void b() {
        if (this.k) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("SteamEngine - init already called");
            return;
        }
        this.k = true;
        com.corrodinggames.rts.gameFramework.GameEngine.log("SteamEngine - java steamEngine init()");
        try {
            SteamUGC steamUGC;
            if (!SteamAPI.init()) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("steamAPI init failed");
                this.d();
                return;
            }
            this.m = ByteBuffer.allocateDirect(100000);
            this.b = new SteamFriendsCallbackHandler(this);
            this.c = new SteamFriends(this.b);
            this.e = new SteamMatchmakingCallbackHandler(this);
            this.d = new SteamMatchmaking(this.e);
            this.f = new SteamNetworkingCallbackHandler(this);
            this.h = new SteamNetworking(this.f, SteamNetworking$API.Client);
            this.g = new SteamWorkshopManager(this);
            try {
                steamUGC = new SteamUGC(this.g.a());
            } catch (RuntimeException runtimeException) {
                runtimeException.printStackTrace();
                throw new SteamException("Failed to create workshop");
            }
            this.g.a(steamUGC);
            this.i = new SteamUtilsCallbackHandler(this);
            this.j = new SteamUtils(this.i);
        } catch (SteamException steamException) {
            steamException.printStackTrace();
            this.d();
        }
    }

    @Override
    public void a(float f2) {
        SteamAPI.runCallbacks();
        if (this.h != null) {
            int n2;
            if (com.corrodinggames.rts.gameFramework.GameEngine.buildVersion != null) {
                com.corrodinggames.rts.gameFramework.GameEngine.log(
                        "Joining game from commandline invite:" + com.corrodinggames.rts.gameFramework.GameEngine.buildVersion);
                long l2 = Long.parseLong(com.corrodinggames.rts.gameFramework.GameEngine.buildVersion);
                com.corrodinggames.rts.gameFramework.GameEngine.buildVersion = null;
                SteamID steamID = SteamID.createFromNativeHandle(l2);
                this.d.joinLobby(steamID);
            }
            while ((n2 = this.h.isP2PPacketAvailable(0)) != 0) {
                if (n2 > this.m.capacity()) {
                    com.corrodinggames.rts.gameFramework.GameEngine
                            .b("nextPacketSize:" + n2 + " larger then byteBuffer:" + this.m.capacity() + " resizing");
                    this.m = ByteBuffer.allocateDirect(n2);
                }
                SteamID steamID = new SteamID();
                try {
                    SteamSocket k2;
                    this.m.clear();
                    int n3 = this.h.readP2PPacket(steamID, this.m, 0);
                    if (n3 == 0) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("readP2PPacket with rtn==" + n3);
                    }
                    if ((k2 = (SteamSocket) this.l.get(steamID)) != null && k2.isClosed()) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("Removing stale steam socket");
                        this.l.remove(steamID);
                        k2 = null;
                    }
                    if (k2 == null) {
                        this.b(steamID);
                        k2 = (SteamSocket) this.l.get(steamID);
                    }
                    if (k2 == null) {
                        com.corrodinggames.rts.gameFramework.GameEngine
                                .log("Could not find remote ID steamSocket: " + steamID);
                        continue;
                    }
                    int n4 = this.m.limit();
                    byte[] byArray = new byte[n4];
                    this.m.get(byArray);
                    k2.c.a(byArray);
                } catch (SteamException steamException) {
                    steamException.printStackTrace();
                }
            }
        }
    }

    @Override
    public void d() {
        com.corrodinggames.rts.gameFramework.GameEngine.b("JavaSteamEngine: disableSteam");
        GameEngine l2 = GameEngine.getInstance();
        if (l2 != null) {
            l2.i("Steam connection failed.");
        } else {
            com.corrodinggames.rts.gameFramework.GameEngine.log("cannot show alert game has not been created");
        }
        com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine.a = new DisabledSteamEngine();
    }

    @Override
    public String c() {
        return this.c.getPersonaName();
    }

    @Override
    public boolean f() {
        return false;
    }

    public void a(String string2) {
        com.corrodinggames.rts.gameFramework.GameEngine.log("Steam: " + string2);
    }

    public void b(String string2) {
        com.corrodinggames.rts.gameFramework.GameEngine.b("Steam: " + string2);
    }

    @Override
    public void i() {
        this.a("createLobby");
        if (this.n != null) {
            this.b("createLobby: activeLobby!=null");
        }
        this.d.createLobby(SteamMatchmaking$LobbyType.FriendsOnly, 10);
    }

    public synchronized void a(SteamID steamID) {
        GameEngine l2 = GameEngine.getInstance();
        this.n = steamID;
    }

    public com.corrodinggames.rts.gameFramework.j.NetworkConnection b(SteamID steamID) {
        com.corrodinggames.rts.gameFramework.GameEngine.log("addPeer: " + steamID);
        GameEngine l2 = GameEngine.getInstance();
        SteamSocket k2 = (SteamSocket) this.l.get(steamID);
        if (k2 != null) {
            if (k2.isClosed()) {
                this.l.remove(steamID);
            } else {
                this.b("addPeer, user already exists");
                // try {
                k2.close();
                // }
                // catch (IOException iOException) {
                // iOException.printStackTrace();
                // }
            }
        }
        SteamSocket k3 = new SteamSocket(this, steamID);
        com.corrodinggames.rts.gameFramework.j.NetworkConnection c2 = new com.corrodinggames.rts.gameFramework.j.NetworkConnection(l2.networkEngine, k3);
        try {
            c2.i = true;
            c2.d();
            l2.networkEngine.aM.add(c2);
            this.l.put(steamID, k3);
            l2.networkEngine.Q();
            return c2;
        } catch (IOException iOException) {
            iOException.printStackTrace();
            c2.a("crash");
            return null;
        }
    }

    public void c(SteamID steamID) {
        com.corrodinggames.rts.gameFramework.GameEngine.log("connectTo: " + steamID);
        SteamSocket k2 = (SteamSocket) this.l.get(steamID);
        if (k2 != null) {
            if (k2.isClosed()) {
                this.l.remove(steamID);
            } else {
                this.b("connectTo, user already exists");
                // try {
                    k2.close();
                // } catch (IOException iOException) {
                //     iOException.printStackTrace();
                // }
            }
        }
        GameEngine l2 = GameEngine.getInstance();
        if (!this.o) {
            SteamID steamID2 = steamID;
            b$1 b$1 = new b$1(this, steamID2);
            ScriptEngine.getInstance().addRunnableToQueue(b$1);
        } else {
            this.a("connectTo as server?");
            this.b(steamID);
        }
    }

    @Override
    public void j() {
        this.a("stopLobby");
        if (this.n == null) {
            this.b("stopLobby: activeLobby==null");
        } else {
            this.d.leaveLobby(this.n);
        }
        this.a("stopLobby: activeSteamSockets:" + this.l.size());
        for (SteamSocket k2 : ((Collection<SteamSocket>) this.l.values())) {
            // try {
                k2.close();
            // } catch (IOException iOException) {
            //     iOException.printStackTrace();
            // }
        }
        this.l.clear();
        this.n = null;
        this.p = null;
    }

    @Override
    public void g() {
        if (this.n == null) {
            // empty if block
        }
        if (this.n == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.getInstance().i("Error: No steam lobby has been started");
            return;
        }
        this.c.activateGameOverlayInviteDialog(this.n);
    }

    @Override
    public void k() {
        this.g.c();
    }

    @Override
    public void l() {
        this.g.d();
    }

    @Override
    public void m() {
        this.n().b();
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.i.b b2) {
        this.n().c(b2);
    }

    @Override
    public void b(com.corrodinggames.rts.gameFramework.i.b b2) {
        this.n().b(b2);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.i.b b2, boolean bl2, String string2) {
        this.n().a(b2, bl2, string2);
    }
}
class b$1
implements Runnable {
    final /* synthetic */ SteamID a;
    final /* synthetic */ JavaSteamEngine b;

    b$1(JavaSteamEngine b2, SteamID steamID) {
        this.b = b2;
        this.a = steamID;
    }

    @Override
    public void run() {
        GameEngine l2 = GameEngine.getInstance();
        try {
            this.b.a("connectTo runnable start");
            Root root = ScriptEngine.getInstance().getRoot();
            l2.networkEngine.b("starting new");
            this.b.n = this.a;
            this.b.p = this.b.d.getLobbyOwner(this.b.n);
            String string2 = l2.bQ.lastNetworkPlayerName;
            String string3 = com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine.a().c();
            if (string3 != null && string2 == null) {
                string2 = string3;
                string2 = string2.replace(" ", "_");
                string2 = GameUtils.a(string2, 20);
            }
            l2.networkEngine.y = string2;
            SteamSocket k2 = new SteamSocket(this.b, this.b.p);
            this.b.l.put(this.b.p, k2);
            l2.networkEngine.a(k2);
            for (com.corrodinggames.rts.gameFramework.j.NetworkConnection c2 : l2.networkEngine.aM) {
                c2.i = true;
            }
            this.b.a("connected");
            root.showBattleroom();
            this.b.a("connectTo runnable end");
        }
        catch (IOException iOException) {
            String string4 = iOException.getMessage();
            l2.c(string4, "Connection failed");
            iOException.printStackTrace();
        }
    }
}

