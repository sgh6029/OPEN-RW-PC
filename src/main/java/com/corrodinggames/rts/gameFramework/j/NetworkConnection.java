/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.lang.ref.Cleaner;

//c.java
public class NetworkConnection {
    private final NetworkEngine W;
    public volatile boolean a = false;
    volatile boolean b = false;
    public int c;
    public Socket d;
    public InetAddress e;
    ConcurrentLinkedQueue f = new ConcurrentLinkedQueue();
    public long g;
    public boolean h;
    public boolean i;
    public NetworkConnection j;
    public int k = -1;
    PacketData l;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public int y;
    public com.corrodinggames.rts.game.e z;
    int A = -1;
    long B = -1L;
    boolean C = false;
    boolean D = false;
    public int E = 999999;
    d receiveWorker;
    e sendWorker;
    Thread H;
    Thread I;
    boolean J = false;
    boolean K = false;
    public String L;
    public int M;
    public boolean N;
    public boolean O;
    public int P;
    public boolean Q;
    public int R;
    public long S;
    public boolean T;
    volatile int U;
    volatile int V;

    // 添加 Cleaner 实例
    private static final Cleaner CLEANER = Cleaner.create();
    private final Cleaner.Cleanable cleanable;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NetworkConnection(NetworkEngine ad2, Socket socket) {
        this.W = ad2;
        this.d = socket;
        Object object = this.W.aQ;
        synchronized (object) {
            this.c = this.W.aP++;
        }
        this.M = com.corrodinggames.rts.gameFramework.GameUtils.a(1, 1000000);
        this.cleanable = CLEANER.register(this, new SocketCleanup(this.d, this.c));
    }

    // 清理动作类
    private static class SocketCleanup implements Runnable {
        private final Socket socket;
        private final int connectionIndex;

        SocketCleanup(Socket socket, int connectionIndex) {
            this.socket = socket;
            this.connectionIndex = connectionIndex;
        }

        @Override
        public void run() {
            try {
                if (this.socket == null || this.socket.isClosed()) {
                    return;
                }
                com.corrodinggames.rts.gameFramework.GameEngine
                        .log("Connection::cleaner called on unclosed socket (index:" + this.connectionIndex + ")");
                if (this.socket.getInetAddress() == null) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("Skipping possible steam socket");
                }
                try {
                    this.socket.close();
                } catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            } catch (RuntimeException runtimeException) {
                runtimeException.printStackTrace();
            }
        }
    }

    public boolean a() {
        if (this.S < System.currentTimeMillis() - 10000L) {
            this.S = System.currentTimeMillis();
            this.R = 0;
        }
        if (this.R > 100) {
            if (!this.T) {
                this.T = true;
                this.c("Command limit was reached");
            }
            return true;
        }
        ++this.R;
        return false;
    }

    public int b() {
        if (this.B == -1L) {
            return -2;
        }
        if (this.B < System.currentTimeMillis() - 5000L) {
            return -1;
        }
        return this.A;
    }

    int c() {
        com.corrodinggames.rts.game.e e2 = this.z;
        if (e2 != null) {
            return e2.k;
        }
        return -1;
    }

    public synchronized void d() throws IOException {
        this.sendWorker = new e(this);//sender
        this.I = new Thread(this.sendWorker);
        this.I.setDaemon(true);
        this.I.start();//reader
        this.receiveWorker = new d(this, null);
        this.H = new Thread(this.receiveWorker);
        this.H.setDaemon(true);
        this.H.start();
    }

    public void i() {
        com.corrodinggames.rts.game.e e2;
        this.a = true;
        if (this.W.C && !this.W.n() && (e2 = this.z) != null) {
            this.z = null;
            NetworkConnection c2 = this.W.d(e2);
            if (c2 == null) {
                e2.I();
                this.W.P();
                com.corrodinggames.rts.appFramework.n.o();
            }
        }
        if (this.H != null) {
            this.H.interrupt();
        }
        this.W.b(this);
        this.p = false;
        if (this.q) {
            this.W.c(this, "Closing");
        }
    }

    private synchronized void j() {
        if (this.a) {
            return;
        }
        this.b = true;
        if (this.sendWorker != null) {
            this.sendWorker.a();
        }
        if (this.H != null) {
            this.H.interrupt();
        }
        this.W.b(this);
    }

    public void a(String string2) {
        GameOutputStream as2 = new GameOutputStream();
        try {
            if (string2 == null) {
                string2 = "NULL";
            }
            as2.writeUTF(string2);
        } catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        this.a(as2.b(111));
        this.j();
    }

    private synchronized void a(boolean bl2, boolean bl3) {
        this.a(bl2, bl3, "Time out");
    }

    public String e() {
        String string2 = "<null>";
        if (this.z != null) {
            string2 = this.z.v;
        }
        return string2;
    }

    public String f() {
        if (this.j != null) {
            return this.n;
        }
        try {
            InetAddress inetAddress;
            Socket socket = this.d;
            if (socket != null && (inetAddress = socket.getInetAddress()) != null) {
                return inetAddress.getHostAddress();
            }
            return null;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public String g() {
        if (this.j != null) {
            if (this.n == null) {
                return "<forwarded unknown>";
            }
            return this.n;
        }
        String string2 = "<no socket>";
        try {
            Socket socket = this.d;
            if (socket != null) {
                string2 = "<no bond socket>";
                InetAddress inetAddress = socket.getInetAddress();
                if (inetAddress != null) {
                    string2 = inetAddress.getHostAddress();
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return "<socket error>";
        }
        return string2;
    }

    public synchronized void a(boolean bl2, boolean bl3, String string2) {
        if (!this.a) {
            Object object;
            this.c("handleRemoteDisconnect");
            String string3 = null;
            if (this.z != null) {
                string3 = this.z.v;
            }
            String string4 = null;
            if (this.z != null) {
                String string5 = "player";
                object = "";
                if (this.z.b()) {
                    string5 = "spectator";
                } else if (this.W.aW) {
                    int n2 = this.z.a(false, false);
                    object = n2 == 0 ? " (Had no units)" : " (Team " + this.z.h() + ")";
                }
                string4 = string5 + " '" + this.z.v + "' disconnected" + (String) object;
            } else if (this.p) {
                string4 = this.s && this.q ? "relay server disconnected" : "a player disconnected";
            }
            if (!this.W.C) {
                string4 = "The server disconnected";
            }
            if (string4 != null && string2 != null) {
                string4 = string4 + "  (" + NetworkEngine.i(string2) + ")";
            }
            this.i();
            if (string4 != null) {
                boolean bl4 = false;
                if (this.z != null && this.W.C && (object = this.W.d(this.z)) != null) {
                    bl4 = true;
                }
                if (!bl4) {
                    if (!this.W.C) {
                        this.W.f(string4);
                    } else {
                        this.W.j(string4);
                    }
                } else {
                    this.c("Not sending: '" + string4 + "' still another active connection");
                }
            }
            this.W.d.b(this, string3);
        } else {
            this.c("handleRemoteDisconnect: connection is already disconnecting");
        }
        if (!bl3 && this.sendWorker != null) {
            this.sendWorker.a();
        }
        if (bl3) {
            this.J = true;
        }
        if (bl2) {
            this.K = true;
        }
        if (this.J && this.K) {
            try {
                this.d.close();
            } catch (IOException iOException) {
                com.corrodinggames.rts.gameFramework.GameEngine.a("Error while closing network socket",
                        (Throwable) iOException);
            }
            this.I = null;
            this.H = null;
            this.sendWorker = null;
            this.receiveWorker = null;
            if (this.f != null) {
                this.f.clear();
            }
        }
    }

    public void a(String string2, Throwable throwable) {
        com.corrodinggames.rts.gameFramework.GameEngine.a(this.d(string2), throwable);
    }

    public void b(String string2) {
        com.corrodinggames.rts.gameFramework.GameEngine.b(this.d(string2));
    }

    public void c(String string2) {
        com.corrodinggames.rts.gameFramework.GameEngine.log(this.d(string2));
    }

    public String d(String string2) {
        string2 = "id:" + this.c + ": " + string2;
        com.corrodinggames.rts.game.e e2 = this.z;
        if (e2 != null) {
            string2 = string2 + " (Player:" + e2.v + ")";
        }
        return string2;
    }

    public void a(PacketData au2) {
        if (this.sendWorker == null && this.a) {
            return;
        }
        this.sendWorker.a(au2);
    }

    public boolean h() {
        return !this.a;
    }

    // public void finalize() {
    //     try {
    //         if (this.d == null || this.d.isClosed()) {
    //             return;
    //         }
    //         com.corrodinggames.rts.gameFramework.GameEngine
    //                 .e("Connection::finalize called on unclosed socket (index:" + this.c + ")");
    //         if (this.d.getInetAddress() == null) {
    //             com.corrodinggames.rts.gameFramework.GameEngine.e("Skipping possible steam socket");
    //         }
    //         try {
    //             this.d.close();
    //         } catch (IOException iOException) {
    //             iOException.printStackTrace();
    //         }
    //     } catch (RuntimeException runtimeException) {
    //         runtimeException.printStackTrace();
    //     }
    // }

    static /* synthetic */ void a(NetworkConnection c2, boolean bl2, boolean bl3) {
        c2.a(bl2, bl3);
    }

    static /* synthetic */ NetworkEngine a(NetworkConnection c2) {
        return c2.W;
    }
}
