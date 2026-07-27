/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.ArrayList;

import test.rudp.b;
import test.rudp.ReliableSocket;
import test.rudp.r;

class e
extends ReliableSocket {
    boolean a;
    private ArrayList i;
    final /* synthetic */ b b;

    public e(b b2, DatagramSocket c, SocketAddress socketAddress) {
        super(c);
        this.b = b2;
        this.d = socketAddress;
    }

    @Override
    protected void a(DatagramSocket c, r r2) {
        this.i = new ArrayList();
        this.c = c;
        this.g = r2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected test.rudp.packet.RUDPPacket a() {
        ArrayList arrayList = this.i;
        synchronized (arrayList) {
            while (this.i.isEmpty()) {
                try {
                    this.i.wait();
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            return (test.rudp.packet.RUDPPacket)this.i.remove(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void a(test.rudp.packet.RUDPPacket h2) {
        ArrayList arrayList = this.i;
        synchronized (arrayList) {
            if (!this.a) {
                this.a = true;
                super.a(this.c, this.g);
            }
            this.i.add(h2);
            this.i.notify();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void b() {
        ArrayList arrayList = this.i;
        synchronized (arrayList) {
            this.i.clear();
            this.i.add(null);
            this.i.notify();
        }
    }

    @Override
    protected void a(String string2) {
        System.out.println(this.getPort() + ": " + string2);
    }
}

