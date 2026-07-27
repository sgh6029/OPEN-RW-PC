/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import test.rudp.packet.RUDPPacket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class n
implements Runnable {
    final /* synthetic */ ReliableSocket a;

    private n(ReliableSocket h2) {
        this.a = h2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        ArrayList arrayList = ReliableSocket.g((ReliableSocket)this.a);
        synchronized (arrayList) {
            Iterator iterator = ReliableSocket.g((ReliableSocket)this.a).iterator();
            while (iterator.hasNext()) {
                RUDPPacket h2 = (RUDPPacket)iterator.next();
                ReliableSocket.c((ReliableSocket)this.a, (RUDPPacket)h2);
            }
            return;
        }
    }
    
    /* synthetic */ n(ReliableSocket h2, h$1 h$1) {
        this(h2);
    }
}
