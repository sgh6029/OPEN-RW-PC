/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import test.rudp.ReliableSocket;

class h$1
extends Thread {
    final /* synthetic */ ReliableSocket a;

    h$1(ReliableSocket h2) {
        this.a = h2;
    }

    @Override
    public void run() {
        ReliableSocket.a(this.a).stop();
        ReliableSocket.b(this.a).stop();
        try {
            Thread.sleep(this.a.g.g() * 2);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        ReliableSocket.c(this.a).stop();
        ReliableSocket.d(this.a).stop();
        this.a.b();
        ReliableSocket.e(this.a);
    }
}

