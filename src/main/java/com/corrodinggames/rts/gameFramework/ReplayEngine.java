/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.h_f;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.ReplayWriter;
import com.corrodinggames.rts.gameFramework.ChatMessage;
import com.corrodinggames.rts.gameFramework.ReplayCommand;
import com.corrodinggames.rts.gameFramework.GameCommand;
import com.corrodinggames.rts.gameFramework.storage.a;

import android.content.Context;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.GameStateChecksum;
import com.corrodinggames.rts.gameFramework.j.ChecksumField;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GGameObject;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class ReplayEngine {
    String a = "replays/";
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = false;
    public static boolean e = true;
    public static boolean f = false;
    public GameStateChecksum g = new GameStateChecksum();
    public boolean h;
    int i;
    int j;
    boolean k;
    int l;
    boolean m;
    public boolean n = false;
    public int o;
    public int p;
    public int q;
    public String r;
    boolean s;
    private volatile boolean P;
    String t;
    boolean u;
    public int v = 1;
    ReplayCommand w;
    ReplayCommand x;
    int y;
    int z;
    int A;
    int B;
    InputStream C;
    BufferedInputStream D;
    DataInputStream E;
    GameInputStream F;
    OutputStream G;
    BufferedOutputStream H;
    DataOutputStream I;
    GameOutputStream J;
    ReplayWriter K;
    Thread L;
    Object M = new Object();
    public boolean N = false;
    public boolean O;

    public static void a(String string2) {
        com.corrodinggames.rts.gameFramework.GameEngine.log("Replay: " + string2);
    }

    public static void b(String string2) {
        com.corrodinggames.rts.gameFramework.GameEngine.b("Replay: " + string2);
    }

    public static void a(String string2, Exception exception) {
        com.corrodinggames.rts.gameFramework.GameEngine.a("Replay: " + string2, (Throwable)exception);
    }

    public File a(String string2, boolean bl2) {
        File file = com.corrodinggames.rts.gameFramework.storage.a.a(string2, this.a, bl2);
        return file;
    }

    public void a(Context context) {
    }

    public void a() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bt = l2.bt != 0.0f ? 0.0f : 1.0f;
    }

    public void b() {
        GameEngine l2 = GameEngine.getInstance();
        l2.bt = l2.bt == 1.0f ? 2.0f : (l2.bt == 2.0f ? 4.0f : (l2.bt == 4.0f ? 8.0f : (l2.bt == 8.0f ? 16.0f : (l2.bt == 16.0f ? 32.0f : (l2.bt == 32.0f ? 64.0f : (l2.bt == 64.0f ? 1.0f : 1.0f))))));
    }

    public void a(int n2, String string2, String string3, int n3) {
        ReplayWriter bb2 = this.K;
        if (this.P && !this.u) {
            if (string3.startsWith("-t ")) {
                // empty if block
            }
            ReplayCommand bd2 = new ReplayCommand();
            bd2.a = n3;
            bd2.g = new ChatMessage();
            bd2.g.a = n2;
            bd2.g.b = string2;
            bd2.g.c = string3;
            if (bb2 == null) {
                com.corrodinggames.rts.gameFramework.GameEngine.g("Failed to record chat message, replay might have already stopped");
                return;
            }
            bb2.a(bd2);
        }
    }

    public void a(byte[] byArray, int n2, int n3, int n4, float f2, float f3) {
        ReplayWriter bb2 = this.K;
        if (this.P && !this.u) {
            ReplayCommand bd2 = new ReplayCommand();
            bd2.a = n2;
            bd2.f = byArray;
            bd2.h = n3;
            bd2.i = n4;
            bd2.j = f2;
            bd2.k = f3;
            if (bb2 == null) {
                com.corrodinggames.rts.gameFramework.GameEngine.g("Failed to save resync, replay might have already stopped");
                return;
            }
            bb2.a(bd2);
        }
    }

    public void c() {
        if (f) {
            this.d();
        }
    }

    public void a(GameCommand e2, int n2) {
        ReplayWriter bb2 = this.K;
        if (this.P && !this.u) {
            if (bb2 == null) {
                com.corrodinggames.rts.gameFramework.GameEngine.g("Failed to record command, replay might have already stopped");
                return;
            }
            Object object = new ReplayCommand();
            ((ReplayCommand)object).e = e2.f();
            ((ReplayCommand)object).a = n2;
            bb2.a((ReplayCommand)object);
            ++this.j;
            if (this.j > 5) {
                this.j = 0;
                object = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
                ReplayCommand bd2 = new ReplayCommand();
                bd2.c = this.f();
                bd2.a = ((GameEngine)object).bx;
                bb2.a(bd2);
            }
        }
    }

    public void d() {
        if (this.P && !this.u) {
            this.g.b();
            this.a(this.g, true);
        }
    }

    public void a(GameStateChecksum ak2) {
        this.a(ak2, false);
    }

    public void a(GameStateChecksum ak2, boolean bl2) {
        if (this.P && !this.u) {
            GameEngine l2 = GameEngine.getInstance();
            ReplayCommand bd2 = new ReplayCommand();
            GameOutputStream as2 = new GameOutputStream();
            try {
                int n2 = 0;
                if (bl2) {
                    ++n2;
                }
                as2.c(n2);
                as2.a(ak2.b.size());
                for (ChecksumField al2 : ak2.b) {
                    as2.a(al2.b);
                }
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
            bd2.d = as2.d();
            bd2.a = l2.bx;
            this.K.a(bd2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void e() {
        Object object = this.M;
        synchronized (object) {
            try {
                if (this.K != null) {
                    this.K.a();
                    try {
                        this.L.join();
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    this.P = false;
                    this.K = null;
                    this.L = null;
                }
                if (this.G != null) {
                    this.I.flush();
                    this.I.close();
                    this.H.flush();
                    this.H.close();
                    this.G.flush();
                    this.G.close();
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            finally {
                this.G = null;
                this.H = null;
                this.I = null;
                this.J = null;
            }
            this.s = false;
            this.P = false;
            this.u = false;
            this.t = null;
            this.i = 0;
            this.j = 0;
            this.k = false;
            this.l = 0;
            this.m = false;
            this.y = 0;
            this.v = 1;
            this.z = 0;
            this.A = 0;
            this.B = 0;
            this.o = -1;
            this.p = 0;
            this.q = -1;
            this.r = null;
            try {
                if (this.C != null) {
                    this.E.close();
                    this.D.close();
                    this.C.close();
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            finally {
                this.C = null;
                this.D = null;
                this.E = null;
                this.F = null;
            }
        }
    }

    public long f() {
        long l2 = 0L;
        for (GGameObject w2 : ((List<GGameObject>)com.corrodinggames.rts.gameFramework.GGameObject.fastGameObjectList) ){
            if (!(w2 instanceof y)) continue;
            y y2 = (y)w2;
            l2 = (long)((float)l2 + y2.posX * 1000.0f);
            l2 = (long)((float)l2 + y2.posY * 1000.0f);
            l2 = (long)((float)l2 + y2.cu * 1.0f);
            l2 += y2.objectId;
        }
        return l2;
    }

    public void g() {
        if (!this.N) {
            this.e();
        }
    }

    public boolean c(String string2) {
        File file = this.a(string2, false);
        return this.a(string2, file);
    }

    private void l() {
        for (int i2 = 0; i2 < com.corrodinggames.rts.game.PlayerTeam.c; ++i2) {
            PlayerTeam n2 = com.corrodinggames.rts.game.PlayerTeam.k(i2);
            if (n2 == null || !(n2 instanceof com.corrodinggames.rts.game.a.AIController)) continue;
            ((com.corrodinggames.rts.game.a.AIController)n2).aX = true;
        }
    }

    public boolean a(String string2, File file) {
        if (this.P) {
            if (this.u) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("startReplayingFile: A replay is already playing");
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.b("startReplayingFile: A replay is already saving");
            }
        }
        this.e();
        GameEngine l2 = GameEngine.getInstance();
        l2.e();
        l2.networkEngine.q();
        this.w = null;
        this.s = false;
        this.P = true;
        this.u = true;
        this.t = string2;
        try {
            if (file.isDirectory()) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("File is a directory: " + file.getAbsolutePath());
                String string3 = "Cannot load replay: Target is a folder, instead of a file";
                com.corrodinggames.rts.gameFramework.GameEngine.log(string3);
                l2.a(string3, 1);
                return false;
            }
            this.C = com.corrodinggames.rts.gameFramework.storage.a.a(file);
            if (this.C == null) {
                String string4 = "Cannot load replay: Failed to read replay file";
                com.corrodinggames.rts.gameFramework.GameEngine.log(string4);
                l2.a(string4, 1);
                return false;
            }
            this.D = new BufferedInputStream(this.C);
            this.E = new DataInputStream(this.D);
            this.F = new GameInputStream(this.E);
            String string5 = this.F.l();
            if (!string5.equals("rustedWarfareReplay")) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Header is not correct:" + string5);
                String string6 = "Cannot load replay: File is missing header (check if this file is a replay)";
                com.corrodinggames.rts.gameFramework.GameEngine.log(string6);
                l2.a(string6, 1);
                return false;
            }
            int n2 = this.F.readInt();
            int n3 = this.F.readInt();
            ReplayEngine.a("Loading save from version: " + n3);
            this.F.a(n3);
            String string7 = this.F.l();
            if (!(n3 == 96 && n2 == l2.getVersionCode(true) || this.n)) {
                String string8 = "Cannot load replay: This replay was recording with a different version: " + string7;
                if (com.corrodinggames.rts.gameFramework.GameEngine.av()) {
                    string8 = string8 + " (You can use the beta tab in steam to switch to old versions)";
                }
                l2.a(string8, 1);
                ReplayEngine.a("Replay version: " + n3 + " (" + n2 + ")");
                ReplayEngine.a("GameSaver.thisSaveVersion: 96 (" + l2.getVersionCode(true) + ")");
                if (!com.corrodinggames.rts.gameFramework.GameEngine.isGamePausedOrMinimizedStatic) {
                    this.P = false;
                    return false;
                }
            }
            this.q = n3;
            this.r = string7;
            this.F.e();
            this.F.b("gamesave");
            this.O = false;
            this.N = true;
            ReplayEngine.a("Loading replay initial save");
            l2.ca.a(this.F, false, false, false);
            this.N = false;
            this.F.d("gamesave");
            if (!this.O) {
                ReplayEngine.a("ReplayEngine: --- No game setup read ----");
                l2.networkEngine.ay.i = true;
                l2.bB = l2.bC = l2.bQ.teamUnitCapHostedGame;
            }
            if (!this.h) {
                this.l();
            }
            ReplayEngine.a("--- Reply settings ---");
            ReplayEngine.a("Unit cap: " + l2.bC);
            ReplayEngine.a(l2.networkEngine.ay.b());
            ReplayEngine.a("Starting frame:" + l2.bx);
            if (!this.h) {
                for (int i2 = 0; i2 < com.corrodinggames.rts.game.PlayerTeam.c; ++i2) {
                    PlayerTeam n4 = com.corrodinggames.rts.game.PlayerTeam.k(i2);
                    if (n4 == null || n4.v == null) continue;
                    String string9 = "Player '" + n4.v + "' playing as " + n4.N().toLowerCase() + " (team:" + n4.h() + ")";
                    l2.bS.h.a("", string9);
                }
            }
            if (com.corrodinggames.rts.gameFramework.GameEngine.aw) {
                NetworkEngine.g("Warning: editor will desync checksums.");
                l2.bv = true;
                l2.bl = true;
                l2.bn = true;
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return true;
    }

    public void a(boolean bl2) {
        if (com.corrodinggames.rts.gameFramework.GameEngine.isAndroidVersionStatic2 ? !com.corrodinggames.rts.gameFramework.GameEngine.bd : !com.corrodinggames.rts.gameFramework.GameEngine.bc) {
            return;
        }
        GameEngine l2 = GameEngine.getInstance();
        if (l2.networkEngine.B && !bl2 && !this.N && l2.bQ.saveMultiplayerReplays) {
            String string2 = l2.al() + " [v" + l2.getVersionNumber() + "] (" + com.corrodinggames.rts.gameFramework.GameUtils.a("d MMM yyyy HH.mm.ss") + ").replay";
            this.d(string2);
        }
    }

    public void d(String string2) {
        ReplayEngine.a("Recording replay to: " + string2);
        if (this.P) {
            if (this.u) {
                ReplayEngine.b("startSaving: A replay is already playing");
            } else {
                ReplayEngine.b("startSaving: A replay is already saving");
            }
        }
        this.e();
        GameEngine l2 = GameEngine.getInstance();
        f = l2.bQ.replayTracing;
        if (f) {
            l2.networkEngine.j("Warning traceChecksumsWriting is on. Large replay file size will be created.");
        }
        this.s = false;
        this.P = true;
        this.u = false;
        this.t = string2;
        try {
            File file = this.a(string2, true);
            this.G = com.corrodinggames.rts.gameFramework.storage.a.a(file, false);
            if (this.G == null) {
                ReplayEngine.b("Failed to create replay file at:" + file.getAbsolutePath());
                com.corrodinggames.rts.gameFramework.GameEngine.getInstance().i("Failed to create replay file (Replay recording will be disabled)");
                this.e();
                return;
            }
            this.H = new BufferedOutputStream(this.G);
            this.I = new DataOutputStream(this.H);
            this.J = new GameOutputStream(this.I);
            this.J.writeUTF("rustedWarfareReplay");
            int n2 = l2.getVersionCode(true);
            this.J.a(n2);
            this.J.a(96);
            this.J.writeUTF(l2.getVersionNumber());
            this.J.a(l2.isGamePaused);
            this.J.e("gamesave");
            l2.ca.a(this.J);
            this.J.a("gamesave");
            this.I.flush();
            this.K = new ReplayWriter(this);
            this.L = new Thread(this.K);
            this.L.start();
        }
        catch (IOException iOException) {
            ReplayEngine.a("Failed to start recording replay", iOException);
            com.corrodinggames.rts.gameFramework.GameEngine.getInstance().i("Failed to start recording replay: " + iOException.getMessage());
            this.e();
        }
        catch (Exception exception) {
            ReplayEngine.a("Failed to start recording replay (Non IOException)", exception);
            com.corrodinggames.rts.gameFramework.GameEngine.getInstance().i("Failed to start recording replay (Non IOException): " + exception.getMessage());
            this.e();
        }
    }

    public boolean h() throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        String string2 = this.F.x();
        if ("rc".equals(string2)) {
            ++this.y;
            ReplayCommand bd2 = new ReplayCommand();
            bd2.a = this.F.readInt();
            GameCommand e2 = l2.cf.b();
            e2.a(this.F);
            e2.a = true;
            bd2.e = e2;
            this.F.d("rc");
            this.w = bd2;
            ++this.p;
            this.o = bd2.a;
            if (c) {
                ReplayEngine.a("updateGameFrame: Command: " + e2.i.v + " (" + e2.i.k + ") count:" + e2.d() + " id:" + this.y);
                if (e2.j != null) {
                    ReplayEngine.a("updateGameFrame: Waypoint: " + e2.j.d().name());
                    if (e2.j.a() != null) {
                        ReplayEngine.a("updateGameFrame: Build Type: " + e2.j.a().i());
                    }
                }
                if (com.corrodinggames.rts.game.units.a.AbstractUnitAction.c(e2.k)) {
                    ReplayEngine.a("updateGameFrame: SpecialAction: " + e2.k.getId());
                }
                if (e2.n != null) {
                    ReplayEngine.a("updateGameFrame: SetAttackMode: " + (Object)((Object)e2.n));
                }
                if (e2.g) {
                    ReplayEngine.a("updateGameFrame: stopOrUndo is set");
                }
                if (e2.r) {
                    if (e2.s != 0.0f) {
                        ReplayEngine.a("updateGameFrame: changeStepRate:" + e2.s);
                    }
                    if (e2.u != 0) {
                        ReplayEngine.a("updateGameFrame: systemAction_action:" + e2.u);
                    }
                }
                ReplayEngine.a("updateGameFrame: ------");
            }
        } else if ("wait".equals(string2)) {
            ReplayCommand bd3 = new ReplayCommand();
            bd3.a = this.F.readInt();
            bd3.b = true;
            this.w = bd3;
            this.F.d("wait");
        } else if ("cs".equals(string2)) {
            int n2 = this.F.readInt();
            long l3 = this.F.i();
            if (!this.n) {
                if (l2.bx != n2) {
                    com.corrodinggames.rts.gameFramework.GameEngine.b("replay:updateGameFrame", "expected:" + n2 + " got:" + l2.bx);
                }
                if (this.f() != l3) {
                    ReplayEngine.b("checksum: checksums don't match!!");
                    ReplayEngine.b("checksum: game frameNumber:" + l2.bx);
                    ReplayEngine.b("checksum: Replay checksum:" + l3);
                    ReplayEngine.b("checksum: Game checksum  :" + this.f());
                    ++this.l;
                    if (!this.k) {
                        this.k = true;
                        l2.bS.h.a("", "Error: This replay might be out of sync");
                    }
                } else {
                    ReplayEngine.a("checksum: checksums are matching frameNumber:" + l2.bx);
                }
            }
            this.F.d("cs");
        } else if ("es".equals(string2)) {
            int n3 = this.F.readInt();
            if (!this.n) {
                if (l2.bx != n3) {
                    com.corrodinggames.rts.gameFramework.GameEngine.b("replay.updateGameFrame: expected:" + n3 + " got:" + l2.bx);
                }
                GameInputStream k2 = new GameInputStream(this.F.t());
                byte by = k2.d();
                boolean bl2 = false;
                if (com.corrodinggames.rts.game.units.custom.d.b.a((int)by, 1)) {
                    bl2 = true;
                }
                if (bl2) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("replay: -trace checksum-");
                } else {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("replay: -long checksum-");
                }
                l2.networkEngine.d();
                int n4 = k2.readInt();
                for (ChecksumField al2 : l2.networkEngine.am.b) {
                    long l4 = k2.i();
                    if (!this.m && l4 == al2.b) {
                        ReplayEngine.a("extraChecksum: " + al2.a + " Checksum [" + n3 + "]. " + l4 + " == " + al2.b + " (ok)");
                    }
                    if (l4 == al2.b) continue;
                    if (this.l < 150) {
                        ReplayEngine.b("extraChecksum: " + al2.a + " Checksum [" + n3 + "]. " + l4 + " != " + al2.b + " (failed)");
                    }
                    ++this.l;
                }
            }
            this.m = true;
            this.F.d("es");
        } else if ("resync".equals(string2)) {
            int n5 = this.F.readInt();
            com.corrodinggames.rts.gameFramework.GameEngine.log("Loading resync from replay");
            if (l2.bx != n5) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("replay:resync", "expected:" + n5 + " got:" + l2.bx);
            }
            int n6 = this.F.readInt();
            int n7 = this.F.readInt();
            float f2 = this.F.g();
            float f3 = this.F.g();
            GameInputStream k3 = new GameInputStream(this.F.t());
            l2.ca.a(k3, true, true, true);
            this.l();
            l2.bx = n6;
            l2.by = n7;
            l2.networkEngine.am.a = 0L;
            if ((double)f2 < 0.1) {
                NetworkEngine.a("replay setCurrentStepRate:" + f2 + " is too small", true);
            }
            l2.networkEngine.a(f2, "replay");
            l2.networkEngine.J = f3;
            this.F.d("resync");
        } else if ("chat".equals(string2)) {
            ReplayCommand bd4 = new ReplayCommand();
            bd4.a = this.F.readInt();
            bd4.g = new ChatMessage();
            bd4.g.a = this.F.readInt();
            bd4.g.b = this.F.j();
            bd4.g.c = this.F.j();
            this.w = bd4;
            this.F.d("chat");
        } else {
            if ("end".equals(string2)) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("replay:updateGameFrame", "end of replay block found");
                l2.bS.h.a("", "Replay has ended");
                if (!l2.bv) {
                    this.s = true;
                    l2.bt = 0.25f;
                    com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bS.G();
                } else {
                    this.s = false;
                    this.P = false;
                    this.u = false;
                    h_f h2 = l2.bS.i();
                    if (h2 != null) {
                        l2.bs = h2.bX;
                    }
                }
                this.F.d("end");
                com.corrodinggames.rts.gameFramework.GameEngine.log("number of replay commands issued:" + this.z);
                return false;
            }
            if ("endReplayMetaData".equals(string2)) {
                this.F.d("endReplayMetaData");
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.b("updateGameFrame", "Unknown command block:" + string2);
                this.F.d(string2);
            }
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(float f2) throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        if (this.s) {
            return;
        }
        if (!this.P || !this.u) return;
        while (true) {
            if (this.w == null) {
                try {
                    boolean bl2 = this.h();
                    if (!bl2) {
                        return;
                    }
                }
                catch (IOException iOException) {
                    com.corrodinggames.rts.gameFramework.GameEngine.b("updateGameFrame", "IOException, read of replay?");
                    iOException.printStackTrace();
                    l2.bt = 0.25f;
                    if (!this.s && this.P) {
                        l2.bS.h.a("", "Replay ended (unexpected)");
                    }
                    this.s = true;
                    return;
                }
            }
            if (this.w != null) {
                if (this.n) {
                    this.w = null;
                    continue;
                }
                if (b && this.w != null && this.x != this.w) {
                    this.x = this.w;
                    com.corrodinggames.rts.gameFramework.GameEngine.log("replay: upcoming in " + (this.w.a - l2.bx) + " command:" + (this.w.e != null));
                }
                if (this.w.b && this.z == 0) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("updateGameFrame: replay: Skipping wait on first resync without commands to avoid delay");
                    this.w = null;
                    continue;
                }
                if (l2.bx >= this.w.a) {
                    if (this.w.e != null) {
                        if (l2.bx > this.w.a) {
                            com.corrodinggames.rts.gameFramework.GameEngine.b("updateGameFrame: replay incorrect frameNumber, skipping command:" + l2.bx + " vs " + this.w.a);
                        } else {
                            if (d) {
                                PlayerTeam n2 = this.w.e.p;
                                if (n2 == null) {
                                    com.corrodinggames.rts.gameFramework.GameEngine.log("Precommand Team: commandingPlayer==null");
                                    if (this.w.e.i != null) {
                                        com.corrodinggames.rts.gameFramework.GameEngine.log("Precommand Team id:" + this.w.e.i.k + " credits:" + this.w.e.i.o);
                                    }
                                } else {
                                    com.corrodinggames.rts.gameFramework.GameEngine.log("Precommand Team id:" + this.w.e.p.k + " credits:" + this.w.e.p.o + " count:" + this.w.e.p.w() + " max:" + this.w.e.p.x());
                                }
                            }
                            if (this.w.e.r && this.w.e.u != 0) {
                                com.corrodinggames.rts.gameFramework.GameEngine.b("replay:issueCommand", "systemAction_action:" + this.w.e.u);
                            }
                            this.w.e.k();
                            if (d) {
                                PlayerTeam n3 = this.w.e.p;
                                if (n3 != null) {
                                    com.corrodinggames.rts.gameFramework.GameEngine.log("Postcommand credits:" + this.w.e.p.o + " count:" + this.w.e.p.w() + " max:" + this.w.e.p.x());
                                } else if (this.w.e.i != null) {
                                    com.corrodinggames.rts.gameFramework.GameEngine.log("Postcommand Team id:" + this.w.e.i.k + " credits:" + this.w.e.i.o);
                                }
                            }
                            ++this.z;
                        }
                    } else if (this.w.g != null) {
                        ChatMessage bc2 = this.w.g;
                        boolean bl3 = false;
                        if (bc2.c == null) {
                            bl3 = true;
                        } else {
                            if (bc2.c.startsWith("-i ")) {
                                bl3 = true;
                            }
                            if (bc2.c.equals("<All players ready>")) {
                                bl3 = true;
                            }
                            if (bc2.c.equals("--too many desync errors, suppressing output--")) {
                                bl3 = true;
                            }
                            if (bc2.c.startsWith("desync:")) {
                                bl3 = true;
                            }
                        }
                        if (!l2.bQ.replaysShowRecordedChat) {
                            bl3 = true;
                        }
                        if (bl3) {
                            com.corrodinggames.rts.gameFramework.GameEngine.b("replay:updateGameFrame", "Skipping message: " + bc2.b + ":" + bc2.c);
                        } else {
                            com.corrodinggames.rts.gameFramework.GameEngine.b("replay:updateGameFrame", "message: " + bc2.b + ":" + bc2.c);
                            l2.bS.h.a(bc2.b, bc2.c);
                        }
                    } else if (this.w.b) {
                        if (c) {
                            // empty if block
                        }
                    } else {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("updateGameFrame", "error: lastReadCommand null action");
                    }
                    this.w = null;
                    continue;
                }
            }
            if (this.w != null) return;
        }
    }

    public void e(String string2) {
        File file;
        boolean bl2;
        com.corrodinggames.rts.gameFramework.GameEngine.log("ReplayEngine deleteGame: " + string2);
        String string3 = com.corrodinggames.rts.gameFramework.storage.a.o(string2);
        if (string3.contains("\\") || string3.contains("/")) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Cannot get replay with path: " + string2);
            return;
        }
        File file2 = this.a(string2, true);
        com.corrodinggames.rts.gameFramework.GameEngine.log("ReplayEngine path: " + file2.getAbsolutePath());
        if (!file2.exists()) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("ReplayEngine deleteGame: file doesn't exist");
        }
        if (!(bl2 = com.corrodinggames.rts.gameFramework.storage.a.b(file2))) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("ReplayEngine deleteGame: failed to delete: " + file2.getAbsolutePath());
        }
        if ((file = this.a(string2 + ".map", true)).exists()) {
            com.corrodinggames.rts.gameFramework.storage.a.b(file);
        }
    }

    public boolean i() {
        return this.P;
    }

    public boolean j() {
        return this.P && this.u;
    }

    public boolean k() {
        return this.P && !this.u;
    }

    static /* synthetic */ boolean a(ReplayEngine ba2) {
        return ba2.P;
    }

    static /* synthetic */ boolean a(ReplayEngine ba2, boolean bl2) {
        ba2.P = bl2;
        return ba2.P;
    }
}
