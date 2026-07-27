/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import test.rudp.ReliableSocket;
import test.rudp.h$1;

class k
implements Runnable {
    final /* synthetic */ ReliableSocket a;

    private k(ReliableSocket h2) {
        this.a = h2;
    }

    @Override
    public void run() {
        ReliableSocket.j(this.a);
    }

    /* synthetic */ k(ReliableSocket h2, h$1 h$1) {
        this(h2);
    }
}

