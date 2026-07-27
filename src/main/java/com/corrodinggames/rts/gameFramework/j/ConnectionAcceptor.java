/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import test.rudp.b;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

//ao.java
public class ConnectionAcceptor
implements Runnable {
    public final boolean a = false;
    public static boolean b = true;
    public final NetworkEngine r;
    protected volatile boolean c = true;
    protected ServerSocket d;
    public int e;
    public boolean f;
    protected long g = -1L;
    protected final boolean h = false;
    protected final boolean i = true;
    protected final Object j = new Object();
    protected ArrayList<ConnectionAttemptTracker> k = new ArrayList<ConnectionAttemptTracker>();
    protected final Object l = new Object();
    protected int m = 0;
    protected int n = 0;
    protected boolean o;
    protected boolean p;
    protected boolean q;

    public ConnectionAcceptor(NetworkEngine ad2) {
        this.r = ad2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean a(InetAddress inetAddress, boolean bl2) {
        int n2;
        Object object;
        if (inetAddress == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("isIpAllowed: inetAddress==null");
            return true;
        }
        if (!b) {
            return true;
        }
        long l2 = System.currentTimeMillis();
        if (l2 > this.g + 60000L) {
            this.g = l2;
            object = this.l;
            synchronized (object) {
                this.k.clear();
            }
            this.m = 0;
            this.n = 0;
            this.o = false;
            this.p = false;
            this.q = false;
        }
        object = this.l;
        synchronized (object) {
            n2 = 0;
            for (Object object2 : this.k) {
                if (!inetAddress.equals(((ConnectionAttemptTracker)object2).a)) continue;
                ++((ConnectionAttemptTracker)object2).b;
                int n3 = 30;
                if (this.n > 100) {
                    n3 = 10;
                }
                if (this.n > 250) {
                    n3 = 5;
                }
                if (((ConnectionAttemptTracker)object2).b > n3) {
                    if (!((ConnectionAttemptTracker)object2).c) {
                        ((ConnectionAttemptTracker)object2).c = true;
                        com.corrodinggames.rts.gameFramework.GameEngine.log("DOS: Too many attempts:" + ((ConnectionAttemptTracker)object2).b + " ip:" + inetAddress.toString());
                    }
                    if (((ConnectionAttemptTracker)object2).b > 300 && !((ConnectionAttemptTracker)object2).d) {
                        ((ConnectionAttemptTracker)object2).d = true;
                        com.corrodinggames.rts.gameFramework.GameEngine.log("DOS: Excessive attempts:" + ((ConnectionAttemptTracker)object2).b + " ip:" + inetAddress.toString());
                    }
                    return false;
                }
                n2 = 1;
                break;
            }
            if (n2 == 0) {
                Object object3;
                if (bl2) {
                    ++this.m;
                }
                if (this.k.size() > 200) {
                    object3 = null;
                    for (ConnectionAttemptTracker ap2 : this.k) {
                        if (object3 != null && ((ConnectionAttemptTracker)object3).b <= ap2.b) continue;
                        object3 = ap2;
                    }
                    if (object3 != null) {
                        this.k.remove(object3);
                    }
                }
                object3 = new ConnectionAttemptTracker(this);
                ((ConnectionAttemptTracker)object3).a = inetAddress;
                this.k.add((ConnectionAttemptTracker) object3);
            }
        }
        if (this.m > 500) {
            if (!this.p) {
                this.p = true;
                com.corrodinggames.rts.gameFramework.GameEngine.log("DOS: Too many unique attempts: " + this.m + ". udp:" + this.f);
            }
            return false;
        }
        int n4 = 0;
        n2 = 0;
        for (Object object2 : this.r.aM) {
            ++n2;
            if (((NetworkConnection)object2).e == null || !inetAddress.equals(((NetworkConnection)object2).e)) continue;
            ++n4;
        }
        int n5 = 20;
        if (n2 > 150) {
            n5 = 10;
        }
        if (n2 > 200) {
            n5 = 5;
        }
        if (n4 > n5) {
            if (!this.q) {
                this.q = true;
                com.corrodinggames.rts.gameFramework.GameEngine.log("DOS: Too open connections from same ip:" + inetAddress.toString() + " (count:" + n4 + ") max:" + n5);
            }
            return false;
        }
        if (n2 > 300) {
            if (!this.o) {
                this.o = true;
                com.corrodinggames.rts.gameFramework.GameEngine.log("DOS: Too open connections locking down:" + inetAddress.toString() + " (count:" + n2 + ")");
            }
            return false;
        }
        ++this.n;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a() throws IOException {
        this.r.d("Recreating server socket " + (this.f ? "udp" : "tcp"));
        Object object = this.j;
        synchronized (object) {
            if (this.d != null) {
                try {
                    this.d.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                this.d = null;
            }
            if (!this.c) {
                throw new IOException("recreate on non-active socket");
            }
            this.a(this.f);
        }
    }

    public void a(boolean bl2) throws IOException{
        this.e = this.r.m;
        this.r.d("starting socket.. " + (bl2 ? "udp" : "tcp") + " port: " + this.e);
        this.f = bl2;
        if (!bl2) {
            this.d = new ServerSocket(this.e);
        } else {
            b b2 = new b(this.r.m, 0, null, true);
            b2.a(new ao$1(this));
            this.d = b2;
        }
    }

    @Override
    public void run() {
        com.corrodinggames.rts.gameFramework.GameEngine.aq();
        Thread.currentThread().setName("NewConnectionWorker-" + (this.f ? "udp" : "tcp") + " - " + this.e);
        int n2 = 0;
        int n3 = 0;
        this.r.d("reading..");
        while (this.c) {
            String string2;
            Object object;
            Socket socket;
            try {
                socket = this.d.accept();
            }
            catch (IOException iOException) {
                if (!this.c) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("ServerSocket-accept(" + (this.f ? "udp" : "tcp") + "): Got expected IOException after closed socket");
                    break;
                }
                object = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
                com.corrodinggames.rts.gameFramework.GameEngine.log("ServerSocket-accept(" + (this.f ? "udp" : "tcp") + ") failed: " + iOException.getMessage() + " (closed:" + this.d.isClosed() + ")");
                if (++n2 > 100) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("Too many server socket fails");
                    this.b();
                    return;
                }
                try {
                    this.a();
                }
                catch (IOException iOException2) {
                    iOException2.printStackTrace();
                    com.corrodinggames.rts.gameFramework.GameEngine.getInstance().i("Warning server socket got closed and could not be recreated");
                    this.b();
                    return;
                }
                int n4;
                if (n3 >= 3 || (n4 = ((GameEngine)object).networkEngine.D()) <= 0) continue;
                string2 = "Warning: server socket got closed and needed to be recreated, players were likely disconnected (but can rejoin).";
                if (com.corrodinggames.rts.gameFramework.GameEngine.isDebugVersionStatic2) {
                    string2 = string2 + "\n This likely due to iOS removing sockets of background apps. Avoid minimising the game when hosting.";
                }
                com.corrodinggames.rts.gameFramework.GameEngine.getInstance().i(string2);
                ++n3;
                continue;
            }
            try {
                socket.setTcpNoDelay(true);
                socket.setSoTimeout(15000);
                String string3 = "<unknown>";
                object = socket.getInetAddress();
                if (object != null) {
                    string3 = ((InetAddress)object).getHostAddress();
                }
                if (!this.a((InetAddress)object, true)) {
                    socket.close();
                    continue;
                }
                NetworkConnection c2 = new NetworkConnection(this.r, socket);
                string2 = "Accepted new connection id:" + c2.c + ".. (ip:" + string3 + ")";
                if (this.f) {
                    string2 = string2 + " (udp)";
                }
                this.r.d(string2);
                c2.h = this.f;
                c2.e = (InetAddress) object;
                c2.d();
                this.r.aM.add(c2);//Connections ?
            }
            catch (IOException iOException) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Got IOException on new player connection");
                iOException.printStackTrace();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void b() {
        Object object = this.j;
        synchronized (object) {
            this.c = false;
            if (this.d != null) {
                try {
                    this.d.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                this.d = null;
            }
        }
    }
}

