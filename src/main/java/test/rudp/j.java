/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import test.rudp.ReliableSocket;
import test.rudp.h$1;

class j
implements Runnable {
    final /* synthetic */ ReliableSocket a;

    private j(ReliableSocket h2) {
        this.a = h2;
    }

    @Override
    public void run() {
        ReliableSocket.i(this.a);
    }

    /* synthetic */ j(ReliableSocket h2, h$1 h$1) {
        this(h2);
    }
}

