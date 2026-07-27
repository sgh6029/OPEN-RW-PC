/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import java.io.IOException;
import java.util.ArrayList;

import test.rudp.ReliableSocket;
import test.rudp.h$1;
import test.rudp.packet.NullPacket;

class l
implements Runnable {
    final /* synthetic */ ReliableSocket a;

    private l(ReliableSocket h2) {
        this.a = h2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run(){
        ArrayList arrayList = ReliableSocket.g(this.a);
        synchronized (arrayList) {
            block6: {
                if (ReliableSocket.g(this.a).isEmpty()) {
                    ReliableSocket.b(this.a, new NullPacket(ReliableSocket.h(this.a).a()));
                }
            }
        }
    }

    /* synthetic */ l(ReliableSocket h2, h$1 h$1) {
        this(h2);
    }
}

