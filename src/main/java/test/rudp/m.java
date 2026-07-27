/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import java.io.IOException;

import test.rudp.ReliableSocket;
import test.rudp.packet.ACKPacket;
import test.rudp.packet.EAKPacket;
import test.rudp.packet.SYNPacket;

class m
extends Thread {
    final /* synthetic */ ReliableSocket a;

    public m(ReliableSocket h2) {
        super("ReliableSocket");
        this.a = h2;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        try {
            test.rudp.packet.RUDPPacket h2;
            while ((h2 = ReliableSocket.f(this.a)) != null) {
                if (h2 instanceof SYNPacket) {
                    this.a.a((SYNPacket)h2);
                } else if (h2 instanceof EAKPacket) {
                    ReliableSocket.a(this.a, (EAKPacket)h2);
                } else if (!(h2 instanceof ACKPacket)) {
                    ReliableSocket.a(this.a, h2);
                }
                this.a.c(h2);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

