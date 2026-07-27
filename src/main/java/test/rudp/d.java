/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import test.rudp.b;
import test.rudp.c;
import test.rudp.e;
import test.rudp.g;
import test.rudp.packet.RUDPPacket;

class d
extends Thread {
    final /* synthetic */ b a;

    public d(b b2) {
        super("ReliableServerSocket");
        this.a = b2;
        this.setDaemon(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        byte[] byArray = new byte[65535];
        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length);
            e e2 = null;
            SocketAddress socketAddress = null;
            try {
                try {
                    b.a(this.a).receive(datagramPacket);
                }
                catch (IOException iOException) {
                    b.a(this.a, "IOException receiving packet:" + iOException.getMessage() + " isConnected:" + b.a(this.a).isConnected());
                    if (!b.a(this.a).isConnected()) {
                        this.a.close();
                    }
                    throw new IOException(iOException);
                }
                socketAddress = datagramPacket.getSocketAddress();
                Object object = b.b(this.a);
                synchronized (object) {
                    a_f a2 = (a_f)b.c(this.a).get(socketAddress);
                    if (a2 != null) {
                        a2.a(datagramPacket.getData(), datagramPacket.getLength());
                        continue;
                    }
                }
                object = b.b(this.a);
                synchronized (object) {
                    e2 = (e)b.b(this.a).get(socketAddress);
                }
                if (e2 == null && (object = this.a.a) != null && !((c)object).a(socketAddress)) continue;
                object = RUDPPacket.parse(datagramPacket.getData(), 0, datagramPacket.getLength());
                if (!this.a.isClosed() && e2 == null) {
                    g g2;
                    if (object instanceof test.rudp.packet.SYNPacket) {
                        g g3;
                        long l2 = System.currentTimeMillis();
                        if (b.d(this.a).size() > 0) {
                            int n2 = 10000;
                            if (b.d(this.a).size() > 20) {
                                n2 = 5000;
                            }
                            if (b.d(this.a).size() > 200) {
                                n2 = 3000;
                            }
                            Iterator iterator = b.d(this.a).entrySet().iterator();
                            while (iterator.hasNext()) {
                                Map.Entry entry = (Map.Entry) iterator.next();
                                if (((g)entry.getValue()).a + (long)n2 >= l2) continue;
                                iterator.remove();
                            }
                        }
                        if ((g3 = (g)b.d(this.a).get(socketAddress)) != null) {
                            g3.b.a((test.rudp.packet.SYNPacket)object);
                        } else {
                            g3 = new g();
                            g3.a = l2;
                            g3.b = new e(this.a, b.a(this.a), socketAddress);
                            g3.b.a((test.rudp.packet.SYNPacket)object);
                            b.d(this.a).put(socketAddress, g3);
                        }
                    }
                    if (object instanceof test.rudp.packet.ACKPacket && (g2 = (g)b.d(this.a).get(socketAddress)) != null) {
                        e e3 = g2.b;
                        if (!e3.b((RUDPPacket)object)) {
                            b.a(this.a, "lightweight ack failed ack:" + ((RUDPPacket)object));
                            continue;
                        }
                        b.a(this.a, socketAddress, e3);
                        e2 = e3;
                        b.d(this.a).remove(socketAddress);
                    }
                }
                if (e2 == null) continue;
                e2.a((ReliableSocket)object);
            }
            catch (IOException iOException) {
                if (this.a.isClosed()) break;
                b.a(this.a, "IOException client " + socketAddress + " - " + iOException.getMessage());
            }
            catch (IllegalArgumentException illegalArgumentException) {
                if (this.a.isClosed()) break;
                b.a(this.a, "IllegalArgumentException " + socketAddress + " - " + illegalArgumentException.getMessage());
            }
        }
    }
}

