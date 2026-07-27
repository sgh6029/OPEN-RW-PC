/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import java.util.ArrayList;

import test.rudp.b;
import test.rudp.b$1;
import test.rudp.e;
import test.rudp.ReliableSocket;
import test.rudp.s;

class f
implements s {
    final /* synthetic */ b a;

    private f(b b2) {
        this.a = b2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(ReliableSocket h2) {
        if (h2 instanceof e) {
            ArrayList arrayList = b.e(this.a);
            synchronized (arrayList) {
                while (b.e(this.a).size() > 50) {
                    try {
                        b.e(this.a).wait();
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                b.e(this.a).add((e)h2);
                b.e(this.a).notify();
            }
        }
    }

    @Override
    public void b(ReliableSocket h2) {
    }

    @Override
    public void c(ReliableSocket h2) {
        if (h2 instanceof e) {
            b.a(this.a, ((e)h2).c());
        }
    }

    @Override
    public void d(ReliableSocket h2) {
        if (h2 instanceof e) {
            b.a(this.a, ((e)h2).c());
        }
    }

    @Override
    public void e(ReliableSocket h2) {
    }

    /* synthetic */ f(b b2, b$1 b$1) {
        this(b2);
    }
}

