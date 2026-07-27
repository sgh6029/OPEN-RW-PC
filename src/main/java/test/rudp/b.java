/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;

import test.rudp.c;
import test.rudp.d;
import test.rudp.e;
import test.rudp.f;
import test.rudp.s;

public class b extends ServerSocket {
    c a;
    private DatagramSocket d;
    private int e;
    private int f;
    private boolean g;
    private ArrayList h;
    private HashMap i;
    private HashMap j;
    private HashMap k;
    long b;
    int c;
    private s l;

    public b() throws IOException {
        this(new DatagramSocket(null), 0);
    }

    public b(int n2, int n3, InetAddress inetAddress, boolean bl2) throws IOException {
        try {
            DatagramSocket DatagramSocket = new DatagramSocket(null);
            DatagramSocket.setReuseAddress(bl2);
            DatagramSocket.bind(new InetSocketAddress(inetAddress, n2));
            this.a(DatagramSocket, n3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public b(DatagramSocket c, int n2) throws IOException {
        this.a(c, n2);
    }

    public void a(DatagramSocket c, int n2) {
        if (c == null) {
            throw new NullPointerException("sock");
        }
        this.d = c;
        this.f = n2 <= 0 ? 50 : n2;
        this.h = new ArrayList(this.f);
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new f(this, null);
        this.e = 0;
        this.g = false;
        new d(this).start();
    }

    public void a(c c2) {
        this.a = c2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Socket accept() throws SocketException, SocketTimeoutException {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        }
        ArrayList arrayList = this.h;
        synchronized (arrayList) {
            while (this.h.isEmpty()) {
                try {
                    if (this.e == 0) {
                        this.h.wait();
                    } else {
                        long l2 = System.currentTimeMillis();
                        this.h.wait(this.e);
                        if (System.currentTimeMillis() - l2 >= (long) this.e) {
                            throw new SocketTimeoutException();
                        }
                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                if (!this.isClosed())
                    continue;
                throw new SocketException("Socket is closed");
            }
            return (Socket) this.h.remove(0);
        }
    }

    @Override
    public synchronized void bind(SocketAddress socketAddress) throws SocketException {
        this.bind(socketAddress, 0);
    }

    @Override
    public synchronized void bind(SocketAddress socketAddress, int n2) throws SocketException {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        }
        this.d.setReuseAddress(true);
        this.d.bind(socketAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void close() {
        if (this.isClosed()) {
            return;
        }
        this.g = true;
        Cloneable cloneable = this.h;
        synchronized (cloneable) {
            this.h.clear();
            this.h.notify();
        }
        cloneable = this.i;
        synchronized (cloneable) {
            if (this.i.isEmpty()) {
                this.d.close();
            }
        }
    }

    @Override
    public InetAddress getInetAddress() {
        return this.d.getInetAddress();
    }

    @Override
    public int getLocalPort() {
        return this.d.getLocalPort();
    }

    @Override
    public SocketAddress getLocalSocketAddress() {
        return this.d.getLocalSocketAddress();
    }

    @Override
    public boolean isBound() {
        return this.d.isBound();
    }

    @Override
    public boolean isClosed() {
        return this.g;
    }

    @Override
    public void setSoTimeout(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        this.e = n2;
    }

    @Override
    public int getSoTimeout() {
        return this.e;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(SocketAddress socketAddress, e e2) {
        HashMap hashMap = this.i;
        synchronized (hashMap) {
            e2.a(this.l);
            this.i.put(socketAddress, e2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private e a(SocketAddress socketAddress) {
        HashMap hashMap = this.i;
        synchronized (hashMap) {
            e e2 = (e) this.i.remove(socketAddress);
            if (this.i.isEmpty() && this.isClosed()) {
                this.d.close();
            }
            return e2;
        }
    }

    private void a(String string2) {
        if (this.b + 5000L < System.currentTimeMillis()) {
            this.b = System.currentTimeMillis();
            this.c = 0;
        }
        if (this.c > 20) {
            return;
        }
        ++this.c;
        System.out.println(string2);
    }

    static /* synthetic */ DatagramSocket a(b b2) {
        return b2.d;
    }

    static /* synthetic */ void a(b b2, String string2) {
        b2.a(string2);
    }

    static /* synthetic */ HashMap b(b b2) {
        return b2.i;
    }

    static /* synthetic */ HashMap c(b b2) {
        return b2.k;
    }

    static /* synthetic */ HashMap d(b b2) {
        return b2.j;
    }

    static /* synthetic */ void a(b b2, SocketAddress socketAddress, e e2) {
        b2.a(socketAddress, e2);
    }

    static /* synthetic */ ArrayList e(b b2) {
        return b2.h;
    }

    static /* synthetic */ e a(b b2, SocketAddress socketAddress) {
        return b2.a(socketAddress);
    }
}
